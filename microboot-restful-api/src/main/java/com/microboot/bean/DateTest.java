package com.microboot.bean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.rmi.CORBA.UtilDelegate;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年12月28日 下午2:53:39 
* 类说明 
*/
public class DateTest {

	public static void main(String[] args) {
		LocalDate after = LocalDate.of(2019, 2, 10);
		LocalDate befor = after.minusDays(29);
		System.out.println(befor);

	}

}
 