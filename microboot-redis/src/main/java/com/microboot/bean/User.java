package com.microboot.bean;

import java.io.Serializable;
import java.util.Date;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月17日 下午5:55:31 
* 类说明 
*/
@SuppressWarnings("serial")
public class User implements Serializable{
	
	private Integer id;
	private String username;
	private double salary;
	private Integer age;
	private float hight;
	private Date birthday;
	
	public User() {
		super();
	}

	public User(Integer id, String username, double salary, Integer age, float hight, Date birthday) {
		super();
		this.id = id;
		this.username = username;
		this.salary = salary;
		this.age = age;
		this.hight = hight;
		this.birthday = birthday;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public float getHight() {
		return hight;
	}
	public void setHight(float hight) {
		this.hight = hight;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", salary=" + salary + ", age=" + age + ", hight=" + hight
				+ ", birthday=" + birthday + "]";
	}
	
}
 