package com.hyf.loveincode.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
*
* @author loveincode
* @data Sep 14, 2017 2:53:03 PM
*/
public class ToolsUtil {
	
	private static Logger log = Logger.getLogger(ToolsUtil.class);
	
	/**
	 * 压缩文件
	 * @param fileName 压缩文件名
	 * @return 压缩后的文件名 
	 * @throws IOException 文件IO异常
	 */
	public static String createTarFile(String fileName) throws IOException{

		String desFile =fileName + ".zip";
		File file = new File(fileName);
		if(!file.exists()){
			throw new IOException(fileName + " 文件不存在.");
		}
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream(desFile);
		GZIPOutputStream gos = new GZIPOutputStream(fos);
		BufferedOutputStream bos = new BufferedOutputStream(gos);
		try{
			byte[] buffer = new byte[1024];
			int  i = 0;
			while((i = bis.read(buffer))!= -1){
				bos.write(buffer,0,i);
			}
			bos.flush();
			
		}catch(IOException ioe){
			log.error("createTarFile IOException",ioe);
			throw ioe;
		}finally{
			if(bis!=null)
				bis.close();
			if(bos!=null)
				bos.close();
			
		}
		return desFile;
	}
	/**
	 * 解压文件
	 * @param fileName 文件名
	 * @return 解压后的文件名 
	 * @throws IOException 
	 */
	public static String getTarFile(String fileName) throws IOException{

		String desFile =fileName.substring(0, fileName.length() - 4);
		File file = new File(fileName);
		if(!file.exists()){
			throw new IOException(fileName + " 文件不存在.");
		}
		FileInputStream fis = new FileInputStream(fileName);
		GZIPInputStream gis = new GZIPInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(gis);
		FileOutputStream fos = new FileOutputStream(desFile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		try{
			byte[] buffer = new byte[1024];
			int  i = 0;
			while((i = bis.read(buffer))!= -1){
				bos.write(buffer,0,i);
			}
			bos.flush();
		}catch(IOException ioe){
			log.error("createTarFile getTarFile",ioe);
			throw ioe;
		}finally{
			if(bis!=null)
				bis.close();
			if(bos!=null)
				bos.close();
			
		}
		return desFile;
	}
	
	// 文件复制
	public static void FileCopy(File fin, File fout) throws Exception {
		FileInputStream in = new FileInputStream(fin);
		FileOutputStream out = new FileOutputStream(fout);
		byte[] buffer = new byte[1024];
		int length = -1;
		while ((length = in.read(buffer))!=-1) {
				out.write(buffer,0,length);
				out.flush();
		}
		out.flush();
		in.close();
		out.close();
		
	}
	
	public static String getMethodName() {
    	StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];
        String methodName = e.getMethodName();
        return methodName;
    }

	 public static String bean2Json(Object obj) {
		Gson gson = new GsonBuilder().setPrettyPrinting()
				.excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT)
				.excludeFieldsWithModifiers(java.lang.reflect.Modifier.FINAL,java.lang.reflect.Modifier.STATIC)
				.disableHtmlEscaping().create();
		return gson.toJson(obj);
	 }
	 
}
