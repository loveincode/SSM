package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author loveincode
* @data Sep 14, 2017 4:16:15 PM
*/
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 当前页数
     **/
    private int pageNo;
    /**
     * 每页显示的数量
     **/
    private int pageNum;
    
    private int offsets;
    /**
     * 总条数
     **/
    private int total;
    /**
     * 存放集合
     **/
    private List<T> rows = new ArrayList<T>();
    
    public Page(){
    	
    }
    
    public Page(int pageNo,int pageNum){
    	this.pageNo = pageNo;
    	this.pageNum = pageNum;
    	this.offsets = (pageNo - 1) * pageNum;
    }
    
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }


    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    
    // 计算开始位置
    public int getOffsets() {
        return (pageNo - 1) * pageNum;
    }
    
    public void setOffset(int offset) {
    }

    // 计算总页数
    public int getTotalPages() {
        int totalPages;
        if (total % pageNum == 0) {
            totalPages = total / pageNum;
        } else {
            totalPages = (total / pageNum) + 1;
        }
        return totalPages;
    }

    // 计算最后一页
    public int getEndIndex() {
        if (getOffsets() + pageNum > total) {
            return total;
        } else {
            return getOffsets() + pageNum;
        }
    }

}