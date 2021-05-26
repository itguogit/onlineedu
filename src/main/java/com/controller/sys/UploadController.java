package com.controller.sys;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.service.user.UserService;
import com.util.Tool;
import com.util.UploadUtil;
/*
 * 登陆
 * 
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	UserService userService;
	
	private static Logger log = Logger.getLogger(UploadController.class);


	/**
	 * 新增接口 上传文档
	 *
	 * @author 郭晓东
	 * @Date 2021-01-01
	 */
	@RequestMapping("uploadvedio")
	@ResponseBody
	public Map<String, Object> addItem(MultipartFile file, HttpServletRequest request) {
		// 文件保存路径
		String dirname=Tool.getyyyyMMdd();
		String path = "D:/onlineedu/upload/vedio/";
		String filePath = path  + "/" + dirname + Tool.getRandom() +".mp4";
		// 保存文件
		File dest = new File(filePath);
		try {
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();
			}
			file.transferTo(dest);
		} catch (IOException e) {
			System.out.println(e);
		}
		// 保存信息
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", "0");
		map.put("msg", "上传成功！");
		map.put("data", "");
		return map;
	}



	
	@ResponseBody
	@RequestMapping("uploadimg")
	public Map<String, Object> uploadimg(HttpServletRequest request) throws IOException {
		//0代表失败，1代表成功，2格式错误
		Map<String, Object> map=new HashMap<String, Object>();
        // 转型为MultipartHttpRequest  
        try {  
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
            List<MultipartFile> fileList = multipartRequest.getFiles("file");  
            for (MultipartFile mf : fileList) { 
                if(!mf.isEmpty()){
                	try {
						String path = "D:/onlineedu/upload/vedio/";
                        String filenamelast=getfilenamelast(mf.getOriginalFilename()).toUpperCase();
                        if(!filenamelast.equals(".JPG")&&!filenamelast.equals(".GIF")&&!filenamelast.equals(".JPEG")&&!filenamelast.equals(".PNG")&&!filenamelast.equals(".SWF")){
                        	 map.put("code", "2");
                        	 map.put("msg", "不是图片！");
                        }else{
							File file = new File(path);
							if (!file.exists()) {
								file.mkdirs();
							}
                        	filenamelast=Tool.getyyyyMMddHHmmssSSS()+Tool.getRandom()+filenamelast;
                        	map.put("code", "1");
                        	map.put("msg", "上传成功！");
                        	// 转存文件  
                        	Map<String, String> m = new HashMap<String, String>();
                        	m.put("src", path+filenamelast);
                        	map.put("data", m);
                        	mf.transferTo(new File(path+filenamelast));
                        }
					} catch (Exception e) {
						map.put("code", "0");
						map.put("msg", "上传失败！");
						e.printStackTrace();
					}
                }  
            }  
        } catch (Exception e) {
            e.printStackTrace();  
        } 
        //JSONObject json = new JSONObject(map);
        System.out.println(map);
        return map;
		//return map;
	}
	
    //获取文件名
    private String getfilenamelast(String filename){
    	int start=filename.lastIndexOf(".");
    	if(start!=-1){
    		filename=filename.substring(start, filename.length());
    	}
    	return filename;
    }
	
	
}
