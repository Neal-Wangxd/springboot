package com.microboot.config;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月18日 下午4:45:08 
* 类说明 
*/
@Configuration
public class DruidConfig {
	
	@Bean
	public ServletRegistrationBean druidServlet(){//主要实现web监控的配置处理
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
				new StatViewServlet(),"/druid/*");//进行druid监控配置处理操作
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1");//白名单
		servletRegistrationBean.addInitParameter("deny", "192.168.2.2");//黑名单
		servletRegistrationBean.addInitParameter("loginUsername","wxd");//用户名
		servletRegistrationBean.addInitParameter("loginPassword","123");//密码
		servletRegistrationBean.addInitParameter("resetEnable","false");//是否可以重置数据
		return servletRegistrationBean;
	}
	
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");//所有的请求都监控
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.git,*.jpg,*.css,/druid/*");
		return filterRegistrationBean;
	}
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource(){
		return new DruidDataSource();
	}

}
 