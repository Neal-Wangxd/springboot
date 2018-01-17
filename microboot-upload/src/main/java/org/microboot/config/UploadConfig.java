package org.microboot.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月16日 下午4:05:04 
* 类说明 : 上传文件控制类
*/
@Configuration
public class UploadConfig {
	@Bean
	public MultipartConfigElement getMultipartConfig(){
		MultipartConfigFactory config = new MultipartConfigFactory();
		config.setMaxFileSize("10MB");//单个文件的大小限制
		config.setMaxRequestSize("100MB");//总的上传限制
		config.setLocation("E:/mytemp/");//临时保存路径
		return config.createMultipartConfig();
	}

}
 