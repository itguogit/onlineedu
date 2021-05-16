package com.controller.sys;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.sys.Category;
import com.model.user.User;
import com.service.sys.CategoryService;
import com.service.user.UserService;

/**
 * @功能说明：类别表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;

	/**
	 * 类别表列表跳转页面
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
		return "views/sys/categoryList";
	}
	
	
	/**
	 * 分页获取类别表
	 * @param request
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/categoryData")
	public Map<String, Object> categoryData(HttpServletRequest request, Model model, Category category) throws UnsupportedEncodingException {
		 Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Category> list = categoryService.getListByPage(category);
	        Long count = categoryService.getCount(category);
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
	 * 删除类别表
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model, Category category) {
		String result = "1";
		try {
			categoryService.delete(category.getId());
			result = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 批量删除类别表
	 * @param request
	 * @param model
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
				categoryService.delete(Integer.parseInt(id));
			}
			result = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 新增类别表跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form")
	public String form(Category category, HttpServletRequest request, Model model) {
		return "views/sys/categoryForm";
	}
	
	/**
	 * 新增类别表跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String edit(Category category, HttpServletRequest request, Model model) {
		category = categoryService.get(category);
		model.addAttribute("category", category);
		return "views/sys/categoryForm";
	}
	
	/**
	 * 保存类别表
	 * @param request
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, Model model, Category category) throws UnsupportedEncodingException {
		String result = "1";//结果标识 1：失败 0：成功
		try
		{
			User user = (User) SecurityUtils.getSubject().getPrincipal();
			//设置默认值
			category.setAddUser(user.getId());
			category.setAddTime(new Date());
			categoryService.save(category);
			result = "0";
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
}
