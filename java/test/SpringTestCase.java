package test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
*
* @author loveincode
* @data Sep 19, 2017 10:07:07 AM
*/
//指定bean注入的配置文件  
@ContextConfiguration(locations = { "classpath:applicationContext-cache.xml" })  
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner  
@RunWith(SpringJUnit4ClassRunner.class)  
public class SpringTestCase extends AbstractJUnit4SpringContextTests {

}
