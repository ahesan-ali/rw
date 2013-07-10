package org.rw.controller;

import org.rw.entity.User;
import org.rw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String showAddForm(Model model) {
		model.addAttribute("user", new User());
		return "UserAddEditForm";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Model model, User user) {
		Long userId = userService.save(user);
		return "redirect:view/" + userId;
	}
	
	
}
