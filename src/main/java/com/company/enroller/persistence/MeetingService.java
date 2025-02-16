package com.company.enroller.persistence;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.company.enroller.model.Meeting;
import com.company.enroller.model.Participant;
@Component("meetingService")
public class MeetingService {

	DatabaseConnector connector;

	public MeetingService() {
		connector = DatabaseConnector.getInstance();
	}

	//public Collection<Meeting> getAll() {
		//String hql = "FROM Meeting";
		//return connector.getSession().createCriteria(Meeting.class).list();
	
	public Collection<Meeting> getAll() {
		return connector.getSession().createCriteria(Meeting.class).list();
	}

	public Meeting findByID(Long id) {	
		return (Meeting) connector.getSession().get(Meeting.class, id);
	}

	public void addMeeting(Meeting meeting) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().save(meeting);
		transaction.commit();	
	}


}
	

