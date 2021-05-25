package com.controller.sys;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.sys.Course;
import com.model.user.User;
import com.service.sys.CourseService;
import com.service.user.UserService;

/**
 * @功能说明：课程信息表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseService courseService;

	/**
	 * 课程信息表列表跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, Model model) {
		//获取当前用户
		User user = (User) request.getSession().getAttribute("user");
		user = (User) userService.get(user);
		model.addAttribute("user", user);
		return "views/sys/courseList";
	}

	/**
	 * 分页获取课程信息表
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/courseList")
	public Map<String, Object> courseList(HttpServletRequest request, Model model, Course course) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Course> list = courseService.getAllList(course);
			map.put("code", 200);
			map.put("msg", "");
			map.put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}


	/**
	 * 分页获取课程信息表
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/courseData")
	public Map<String, Object> courseData(HttpServletRequest request, Model model, Course course) throws UnsupportedEncodingException {
		 Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Course> list = courseService.getListByPage(course);
	        Long count = courseService.getCount(course);
	        map.put("code", 0);
	        map.put("msg", "");
	        map.put("count", count);
	        map.put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

        return map;
		
	}
	
	/**
	 * 删除课程信息表
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model, Course course) {
		String result = "1";
		try {
			courseService.delete(course.getId());
			result = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 批量删除课程信息表
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteBatch")
	public String deleteBatch(HttpServletRequest request, Model model, String ids) {
		String result = "1";
		try {
			String[] idarr = ids.split(",");
			for(String id : idarr){
				courseService.delete(Integer.parseInt(id));
			}
			result = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 新增课程信息表跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form")
	public String form(Course course, HttpServletRequest request, Model model) {
		return "views/sys/courseForm";
	}
	
	/**
	 * 新增课程信息表跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String edit(Course course, HttpServletRequest request, Model model) {
		course = courseService.get(course);
		model.addAttribute("course", course);
		return "views/sys/courseForm";
	}
	
	/**
	 * 保存课程信息表
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, Model model, Course course) throws UnsupportedEncodingException {
		String result = "1";//结果标识 1：失败 0：成功
		try
		{
			//设置默认值
			courseService.save(course);
			result = "0";
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
}
