package org.rw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@RequestMapping(value="/add")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return "UserAdd";
	}
	
	@RequestMapping(value="/view/{userId}")
	public String view(@PathVariable String userId, ModelMap model) {
		model.addAttribute("userId", userId);
		return "UserView";
	}
	
}
