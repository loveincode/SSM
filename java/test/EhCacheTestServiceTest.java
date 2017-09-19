package test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyf.loveincode.encache.EhCacheTestService;

/**
*
* @author loveincode
* @data Sep 19, 2017 10:07:30 AM
*/
public class EhCacheTestServiceTest extends SpringTestCase {

    @Autowired  
    private EhCacheTestService ehCacheTestService;

    @Test  
    public void getTimestampTest() throws InterruptedException{  
        System.out.println("第一次调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(11000);
        System.out.println("再过11秒之后调用：" + ehCacheTestService.getTimestamp("param"));
    } 
}
