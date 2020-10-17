package com.ashokit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.entity.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ViewContactsController {
	private static final Logger logger = LoggerFactory.getLogger(ViewContactsController.class);

	@Autowired
	private ContactService contactService;

	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		logger.debug("editContact() started");
		Contact contact = contactService.getContactById(contactId);
		model.addAttribute("contact", contact);
		logger.debug("editContact() ended");
		return "index";
	}

	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer contactId, RedirectAttributes attr) {
		logger.debug("deleteContact() started");
		contactService.deleteContactById(contactId);
		attr.addFlashAttribute("delMsg", "contact deleted Successfully");
		logger.debug("deleteContact() ended");
		return "redirect:viewContacts";
	}
}
