package com.controller.sys;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.model.sys.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.sys.UserJoin;
import com.model.user.User;
import com.service.sys.UserJoinService;
import com.service.user.UserService;

/**
 * @功能说明：课程的加入人
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
@Controller
@RequestMapping("/userJoin")
public class UserJoinController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserJoinService userJoinService;

	/**
	 * 课程的加入人列表跳转页面
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
		return "views/sys/userJoinList";
	}
	
	
	/**
	 * 分页获取课程的加入人
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/userJoinData")
	public Map<String, Object> userJoinData(HttpServletRequest request, Model model, UserJoin userJoin) throws UnsupportedEncodingException {
		 Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<UserJoin> list = userJoinService.getListByPage(userJoin);
	        Long count = userJoinService.getCount(userJoin);
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
	 * 删除课程的加入人
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model, UserJoin userJoin) {
		String result = "1";
		try {
			userJoinService.delete(userJoin.getId());
			result = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 批量删除课程的加入人
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
				userJoinService.delete(Integer.parseInt(id));
			}
			result = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 新增课程的加入人跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form")
	public String form(UserJoin userJoin, HttpServletRequest request, Model model) {
		return "views/sys/userJoinForm";
	}
	
	/**
	 * 新增课程的加入人跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String edit(UserJoin userJoin, HttpServletRequest request, Model model) {
		userJoin = userJoinService.get(userJoin);
		model.addAttribute("userJoin", userJoin);
		return "views/sys/userJoinForm";
	}
	
	/**
	 * 保存课程的加入人
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, Model model, UserJoin userJoin) throws UnsupportedEncodingException {
		String result = "1";//结果标识 1：失败 0：成功
		try
		{
			//设置默认值
			userJoinService.save(userJoin);
			result = "0";
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
}
