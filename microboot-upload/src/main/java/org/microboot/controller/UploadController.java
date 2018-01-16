package org.microboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月16日 下午2:56:10 
* 类说明 :文件上传的控制类
*/

@Controller
public class UploadController extends AbstractBaseController{

	@RequestMapping(value = "/upload/uploadPre", method = RequestMethod.GET)
	public String uploadPre(){
		return "upload/upload_pre";
	}
	
	@RequestMapping(value = "/upload/upload",method = RequestMethod.POST)
	public String upload(String name,MultipartFile multipartFile,Model model){
		if(null != multipartFile){
			System.out.println("【***文件名称***】"+ name);
			System.out.println("【***文件名称***】"+ multipartFile.getName());
			System.out.println("【***文件类型***】"+ multipartFile.getContentType());
			System.out.println("【***文件大小***】"+ multipartFile.getSize());
			model.addAttribute("name", name);
			model.addAttribute("fileName", multipartFile.getName());
			model.addAttribute("fileType", multipartFile.getContentType());
			model.addAttribute("fileSize", multipartFile.getSize());
		}
		return "upload/upload_show";
	}
}
 