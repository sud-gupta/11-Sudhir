package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.controller.ViewContactsController;
import com.ashokit.entity.Contact;
import com.ashokit.entity.ContactDtlsEntity;
import com.ashokit.repository.ContactDtlsRepository;


@Service
public class ContactServiceImpl implements ContactService {
	private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
	
	@Autowired
	private ContactDtlsRepository contactDtlsRepository;
	
	@Override
	public boolean saveContact(Contact contact) {
		logger.debug("saveContact() started");
		ContactDtlsEntity conEntity=new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, conEntity);
	    ContactDtlsEntity conDtl=contactDtlsRepository.save(conEntity);
	    logger.debug("saveContact() ended");
		return conDtl.getContactId() !=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		logger.debug("saveContact() started");
		List<Contact> cont=new ArrayList<Contact>();
		
		List<ContactDtlsEntity> contactDtlsEntity=contactDtlsRepository.findAll();
		contactDtlsEntity.forEach(entity ->{
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			cont.add(c);
		});
		logger.debug("saveContact() ended");
		return cont;
	}

	@Override
	public Contact getContactById(Integer cid) {
//		Optional<ContactDtlsEntity> optional= contactDtlsRepository.findById(cid);
//		if(optional.isPresent()) {
//			ContactDtlsEntity contactDtlsEntity=optional.get();
//			Contact contact=new Contact();
//			BeanUtils.copyProperties(contactDtlsEntity, contact);
//			return contact;
//		}
		logger.debug("getContactById() started");
		Optional<ContactDtlsEntity> optional= contactDtlsRepository.findById(cid);
		if(optional.isPresent()) {
			Contact contact=new Contact();
			BeanUtils.copyProperties(optional.get(), contact);
			return contact;
		}
		logger.debug("getContactById() ended");
		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		return false;
	}

	@Override
	public boolean deleteContactById(Integer cid) {
		logger.debug("deleteContactById() started");
		contactDtlsRepository.deleteById(cid);
		logger.debug("deleteContactById() ended");
		return true;
	}

}
