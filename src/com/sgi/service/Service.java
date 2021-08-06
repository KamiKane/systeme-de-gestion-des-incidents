package com.sgi.service;

import java.util.ArrayList;
import java.util.List;

import com.sgi.dao.IDao;
import com.sgi.dao.IncidentDaoImpl;
import com.sgi.dao.NoteDaoImpl;
import com.sgi.dao.UserDaoImpl;
import com.sgi.entities.Incident;
import com.sgi.entities.Note;
import com.sgi.entities.User;

public class Service {

	public static User authentifier (String login, String password) throws Exception {
		
		IDao<User> dao = new UserDaoImpl();
		
		if (dao instanceof UserDaoImpl) {
			return ((UserDaoImpl) dao).readByLoginPassword(login, password);
		}
		
		return null;
	}

	public static void creerIncident(Incident incident) throws Exception {
		IDao<Incident> dao = new IncidentDaoImpl();
		
		dao.create(incident);
	}

	public static List<Incident> listerIncidents() throws Exception {
		IDao<Incident> dao = new IncidentDaoImpl();
		
		List<Incident> incidents = dao.list();
		
		return incidents;
	}

	public static List<Note> listerNotes(int idIncident) throws Exception {
		IDao<Note> dao = new NoteDaoImpl();
				
		if (dao instanceof NoteDaoImpl) {
			return ((NoteDaoImpl) dao).list(idIncident);
		}
		
		return new ArrayList<Note>(); 
	}

	public static void creerNote(Note note) throws Exception {
		IDao<Note> dao = new NoteDaoImpl();
		
		dao.create(note);
	}
}
