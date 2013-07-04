package org.rw.controller;

import java.sql.Timestamp;

import org.rw.entity.Person;
import org.rw.service.PersonService;
import org.rw.spring.propertyeditor.TimestampPropertyEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/person")
public class PersonController {

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	TimestampPropertyEditor timestampPropertyEditor;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Timestamp.class, "dob", timestampPropertyEditor);
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String showAddForm(Model model) {
		model.addAttribute("person",new Person());
		return "PersonAddEditForm";
	}
	
	
	//@ExceptionHandler(Throwable.class)
	//@ResponseBody
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Model model, Person person) {
		logger.debug("in save");
		Long personId = personService.save(person);
		return "redirect:view/" + personId;
	}
	
	
	@RequestMapping(value="/view/{personId}")
	public String view(@PathVariable Long personId, ModelMap model) {
		Person person = personService.findById(personId);
		model.addAttribute("person", person);
		return "PersonView";
	}
	
	
	@RequestMapping(value="/edit/{personId}")
	public String showEditForm() {
		return "PersonAddEditForm";
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update() {
		return "redirect:";
	}
	
	
	@RequestMapping(value="/delete/{personId}")
	public String delete() {
		return "";
	}
	
	
}
