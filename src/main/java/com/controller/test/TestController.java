package com.controller.test;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;

import com.model.user.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.model.test.Test;
import com.service.test.TestService;
import com.service.user.UserService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TestService testService;
	
	/**
	 * 分页获取test
	 * @param request
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/testData")
	public void testData(HttpServletRequest request, Model model, Test test) throws UnsupportedEncodingException {
		User user = new User();
		userService.getAllList(user);
		System.out.println();
	}
}
