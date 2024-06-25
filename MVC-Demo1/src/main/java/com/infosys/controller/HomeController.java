package com.infosys.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infosys.entity.Contact;
import com.infosys.entity.ContactDetails;

@Controller
public class HomeController {
	
	@RequestMapping("/abc")
	public String welcome() {
		return "index";
	}
	
	@RequestMapping("/list_contact")
	public String listContact(Model model) {
		ContactDetails details = new ContactDetails();
		List<Contact> contactlist = details.getContactList();
		model.addAttribute("contacts",contactlist); // inside the jsp page , model creates an attribute(model attribute)
		return "contact";
	}
}
