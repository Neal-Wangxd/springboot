package org.microboot;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.microboot.StartSpringBootMain;
import com.microboot.controller.MessageController;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月6日 上午10:51:16 
* 类说明 
*/
@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestMessageController {
	
	@Resource
	private MessageController messageController;
	
	@Test
	public void testEcho(){
		//System.out.println(this.messageController.echo("testSpring"));
		
		System.out.println(this.messageController.info());
	}

}
 