package org.rw.controller;

import java.sql.Timestamp;
import java.util.List;

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
		model.addAttribute("person", new Person());
		return "PersonAddEditForm";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Model model, Person person) {
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
		logger.debug("deleting person");
		return "";
	}
	
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String showSearchForm(Model model) {
		model.addAttribute("person", new Person());
		return "PersonSearchForm";
	}
	
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(Model model, Person person) {
		List<Person> persons = personService.findByLikeExample(person);
		model.addAttribute("persons", persons);
		return "PersonSearchResult";
	}
	
	/*//one method for all crud operation
	@RequestMapping(value="/person", method=RequestMethod.POST)
	public String doAction(@ModelAttribute Person person,@RequestParam String request)
	{
		Person resultPerson=new Person();
		switch (request.toLowerCase()) { // only for jdk1.7
		case "add":
			personService.save(person);
			resultPerson=person;
			break;
		case "update":
			resultPerson=person;
			break;
		case "delete":
			break;
		case "search":
		}
		return "personView";
	}*/
	
}
