package com.company.enroller.persistence;

import java.util.Collection;

import org.springframework.stereotype.Component;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import com.company.enroller.model.Participant;

@Component("participantService")
public class ParticipantService {

	DatabaseConnector connector;

	public ParticipantService() {
		connector = DatabaseConnector.getInstance();
	}

	public Collection<Participant> getAll() {
		return connector.getSession().createCriteria(Participant.class).list();
	}

public Participant findByLogin(String login) {
	return (Participant) connector.getSession().get(Participant.class, login);
}

	public void addParticipant(Participant participant) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().save(participant);
		transaction.commit();
	}


	public void deleteParticipant(Participant participant) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().delete(participant);
		transaction.commit();
	}

	public void updateParticipant(Participant participant) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().update(participant);
		transaction.commit();
	}

}
