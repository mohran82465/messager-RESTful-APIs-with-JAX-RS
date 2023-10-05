package com.mohran.brains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.mohran.brains.messenger.database.DatabaseClass;
import com.mohran.brains.messenger.exception.DataNotFoundException;
import com.mohran.brains.messenger.model.Message;
import com.mohran.brains.messenger.model.Profile;

public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	public MessageService()
	{
		messages.put(1L, new Message(1,"Hello world","mohran"));
		messages.put(2L, new Message(2,"Hello jersey","mohamed"));

	}
	public List<Message> getAllMessages()
	{
		return new ArrayList<Message>(messages.values());
	}
	
	
	public List<Message> getAllMessagesForYear(int year)
	{
		List<Message> messagesForYear = new  ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values())
		{
			 cal.setTime(message.getCreated());
			 if(cal.get(Calendar.YEAR)==year)
			 {
				 messagesForYear.add(message);
			 }
		}
		return messagesForYear;
	}
	public List<Message> getAllMessagesPanginated(int start, int size)
	{
		List<Message> list = new  ArrayList<Message>(messages.values());
		if(size+start>list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size);
	}

	
	public Message  getMessage(long id) 
	{
		Message message =  messages.get(id); 
		if(message == null )
		{
			throw new DataNotFoundException("Message with id "+ id + " not found") ;
		}
		
		
		return message;
	}
	
	public Message  addMessage(Message message) 
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public Message  updateMessage(Message message) 
	{
		if(message.getId()<=0) return null ;
		messages.put(message.getId(), message);
		return message;
	}
	public void  removeMessage(long id) 
	{
		 messages.remove(id); 
	}
	
}
