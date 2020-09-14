package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Contact;
import com.ashokit.entity.ContactDtlsEntity;
import com.ashokit.repository.ContactDtlsRepository;


@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDtlsRepository contactDtlsRepository;
	
	@Override
	public boolean saveContact(Contact contact) {
		// TODO Auto-generated method stub
		ContactDtlsEntity conEntity=new ContactDtlsEntity();
		
//		conEntity.setContactId(contact.getContactId());
//		conEntity.setContactName(contact.getContactName());
//		conEntity.setContactNum(contact.getContactNum());
//		conEntity.setContactEmail(contact.getContactEmail());
			
		BeanUtils.copyProperties(contact, conEntity);
	    ContactDtlsEntity conDtl=contactDtlsRepository.save(conEntity);
	    
		return conDtl.getContactId() !=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> cont=new ArrayList<Contact>();
		
		List<ContactDtlsEntity> contactDtlsEntity=contactDtlsRepository.findAll();
		contactDtlsEntity.forEach(entity ->{
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			cont.add(c);
		});
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
		Optional<ContactDtlsEntity> optional= contactDtlsRepository.findById(cid);
		if(optional.isPresent()) {
			Contact contact=new Contact();
			BeanUtils.copyProperties(optional.get(), contact);
			return contact;
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContactById(Integer cid) {
		// TODO Auto-generated method stub
		contactDtlsRepository.deleteById(cid);
		return true;
	}

}
