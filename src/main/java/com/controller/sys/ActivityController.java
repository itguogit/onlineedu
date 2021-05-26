package com.controller.sys;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.util.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.sys.Activity;
import com.model.user.User;
import com.service.sys.ActivityService;
import com.service.user.UserService;

/**
 * @功能说明：活动表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ActivityService activityService;

	/**
	 * 活动表列表跳转页面
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
		return "views/sys/activityList";
	}
	
	
	/**
	 * 分页获取活动表
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/activityData")
	public Map<String, Object> activityData(HttpServletRequest request, Model model, Activity activity) throws UnsupportedEncodingException {
		 Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Activity> list = activityService.getListByPage(activity);
	        Long count = activityService.getCount(activity);
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
	 * 删除活动表
	 * @param request
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model, Activity activity) {
		String result = "1";
		try {
			activityService.delete(activity.getId());
			result = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 批量删除活动表
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
				activityService.delete(Integer.parseInt(id));
			}
			result = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 新增活动表跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form")
	public String form(Activity activity, HttpServletRequest request, Model model) {
		return "views/sys/activityForm";
	}
	
	/**
	 * 新增活动表跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String edit(Activity activity, HttpServletRequest request, Model model) {
		activity = activityService.get(activity);
		model.addAttribute("activity", activity);
		return "views/sys/activityForm";
	}
	
	/**
	 * 保存活动表
	 * @param request
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, Model model, Activity activity) throws UnsupportedEncodingException {
		String result = "1";//结果标识 1：失败 0：成功
		//获取当前用户
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		//设置默认值
		activity.setAddUser(user.getId());
		try
		{
			activity.setAddTime(new Date());
			if (activity.getStartDate() != null && activity.getStartDate() != ""){
				activity.setStartTime(DateUtil.toDate(activity.getStartDate()));
			}
			if (activity.getEndDate() != null || activity.getEndDate() != ""){
				activity.setEndTime(DateUtil.toDate(activity.getEndDate()));
			}
			//设置默认值
			activityService.save(activity);
			result = "0";

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
}
