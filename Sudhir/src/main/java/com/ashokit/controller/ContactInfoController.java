package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.entity.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ContactInfoController{

	@Autowired
	private ContactService contactService;
	//@GetMapping(value="/")
	 @GetMapping("/")
     public String displayContactForm(Model model) { 
		
		Contact conObj=new Contact();
		
		model.addAttribute("contact", conObj);
    	 return "index";
     } // to display form
   
//	 @PostMapping("/saveContact")
//     public String handleSubmitBtn(@ModelAttribute("contact")Contact c, Model model) { 
//    	 boolean isSaved=contactService.saveContact(c);
//    	 if(isSaved) {
//    		 model.addAttribute("succMsg","contact saved");
//    	 }else {
//    		 model.addAttribute("errorMsg","failed to save");
//    	 }
//    	 return "redirect:/submitContact";
//     }// form submission
	 
	 @PostMapping("/saveContact")
     public String handleSubmitBtn(@ModelAttribute("contact")Contact c, RedirectAttributes attr) { 
    	 boolean isSaved=contactService.saveContact(c);
    	 if(isSaved) {
    		 if(c.getContactId() !=null) {
    			 attr.addFlashAttribute("succMsg","contact updated Successfully");
    		 }else {
    		 attr.addFlashAttribute("succMsg","contact saved Successfully");
    		 }
    	 }else {
    		 attr.addFlashAttribute("errorMsg","failed to save");
    	 }
    	 return "redirect:/submitContact";
     }// form submission
	 
	 @GetMapping("/submitContact")
     public String handleViewCtctsHyperlink(Model model) {
    	 model.addAttribute("contact", new Contact());
    	 return "index";
     } // hyperlink
	 
	 @GetMapping("/viewContacts")
     public String viewContacts(Model model) {
		 List<Contact> contactList=contactService.getAllContacts();
    	 model.addAttribute("contacts", contactList);
    	 return "ViewContact";
     } 
	 
}