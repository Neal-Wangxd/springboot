package org.microboot.controller;

import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String upload(String name,MultipartFile multipartFile,Model model) throws IOException{
		if(null != multipartFile){
			
			FileCopyUtils.copy(multipartFile.getBytes(), 
					new File( "E:/mytemp/" + multipartFile.getOriginalFilename()));
			System.out.println("【***文件名称***】"+ name);
			System.out.println("【***文件名称***】"+ multipartFile.getOriginalFilename());
			System.out.println("【***文件类型***】"+ multipartFile.getContentType());
			System.out.println("【***文件大小***】"+ multipartFile.getSize());
			
			model.addAttribute("name", name);
			model.addAttribute("fileName", multipartFile.getOriginalFilename());
			model.addAttribute("fileType", multipartFile.getContentType());
			model.addAttribute("fileSize", multipartFile.getSize());
			model.addAttribute("filePath", "E:/mytemp/"+multipartFile.getOriginalFilename());
		}
		return "upload/upload_show";
	}
	
	@RequestMapping(value = "/upload/uploadMult",method = RequestMethod.POST)
	public String uploadMult(String name,HttpServletRequest request,Model model)throws IOException{
		if(request instanceof MultipartHttpServletRequest){
			MultipartHttpServletRequest msRequest = (MultipartHttpServletRequest) request;
			List<MultipartFile> files = msRequest.getFiles("multipartFile");
			Iterator<MultipartFile> iterator = files.iterator();
			while(iterator.hasNext()){
				MultipartFile file = iterator.next();
				if(null != file){
					System.out.println("【***文件名称***】"+ name);
					System.out.println("【***文件名称***】"+ file.getOriginalFilename());
					System.out.println("【***文件类型***】"+ file.getContentType());
					System.out.println("【***文件大小***】"+ file.getSize());
					FileCopyUtils.copy(file.getBytes(), 
							new File( "E:/mytemp/" + file.getOriginalFilename()));
					model.addAttribute("name", name);
					model.addAttribute("fileName", file.getOriginalFilename());
					model.addAttribute("fileType", file.getContentType());
					model.addAttribute("fileSize", file.getSize());
					model.addAttribute("filePath", "E:/mytemp/"+file.getOriginalFilename());
				}
			}
		}
		return "upload/upload_show";
	}
}
 