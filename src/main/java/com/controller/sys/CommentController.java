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

import com.model.sys.Comment;
import com.model.user.User;
import com.service.sys.CommentService;
import com.service.user.UserService;

/**
 * @功能说明：评论表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;

	/**
	 * 评论表列表跳转页面
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
		return "views/sys/commentList";
	}


	/**
	 * 评论表列表跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ourlist")
	public String ourlist(HttpServletRequest request, Model model) {
		//获取当前用户
		User user = (User) request.getSession().getAttribute("user");
		user = (User) userService.get(user);
		model.addAttribute("user", user);
		return "views/sys/ourCommentList";
	}
	
	
	/**
	 * 分页获取评论表
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/commentData")
	public Map<String, Object> commentData(HttpServletRequest request, Model model, Comment comment) throws UnsupportedEncodingException {
		 Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Comment> list = commentService.getListByPage(comment);
	        Long count = commentService.getCount(comment);
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
	 * 分页获取评论表
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/ourCommentData")
	public Map<String, Object> ourCommentData(HttpServletRequest request, Model model, Comment comment) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		//获取当前用户
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		comment.setAddUser(String.valueOf(user.getId()));
		try {
			List<Comment> list = commentService.getListByPage(comment);
			Long count = commentService.getCount(comment);
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
	 * 删除评论表
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model, Comment comment) {
		String result = "1";
		try {
			commentService.delete(comment.getId());
			result = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 批量删除评论表
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
				commentService.delete(Integer.parseInt(id));
			}
			result = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 新增评论表跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form")
	public String form(Comment comment, HttpServletRequest request, Model model) {
		return "views/sys/commentForm";
	}
	
	/**
	 * 新增评论表跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String edit(Comment comment, HttpServletRequest request, Model model) {
		comment = commentService.get(comment);
		model.addAttribute("comment", comment);
		return "views/sys/commentForm";
	}
	
	/**
	 * 保存评论表
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, Model model, Comment comment) throws UnsupportedEncodingException {
		String result = "1";//结果标识 1：失败 0：成功

		//获取当前用户
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		//设置默认值
		comment.setAddUser(String.valueOf(user.getId()));
		comment.setAddTime(new Date());
		try
		{
			//设置默认值
			commentService.save(comment);
			result = "0";
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
}
