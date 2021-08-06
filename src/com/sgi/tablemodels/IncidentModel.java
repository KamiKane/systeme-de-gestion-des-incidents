package com.sgi.tablemodels;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.sgi.entities.Incident;

public class IncidentModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public static final int OBJECT_COL = -1;
	
	private Vector<Object[]> rows = new Vector<>();
	
	private List<Incident> incidents = new ArrayList<>();
	
	private String[] columns = {"Id", "Open date", "Application", "Gravité", "Statut", "Rapporteur", "Developpeur", "Close Date"};
	
	public IncidentModel() {}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {		
		return rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case OBJECT_COL : return incidents.get(rowIndex);
			default : return rows.get(rowIndex)[columnIndex];
		}
	}

	public List<Incident> getIncidents() {
		return incidents;
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}
	
	public void setIncidents (List<Incident> incidents) {		
		rows.clear();
		this.incidents.clear();
		this.incidents.addAll(0, incidents);
		
		for (Incident incident : incidents ){			
			rows.add( new Object [] {
					incident.getId(), "", 
					incident.getApplication(),
					incident.getGravite(), 
					incident.getStatut(), "", "", ""
				});
		}
		
		fireTableDataChanged();
	}
	
	public void clear() {
		rows.clear();
		this.incidents.clear();
		
		fireTableDataChanged();
	}

	/*
	public void add(int id, String login, String password) {
		User user = new User (id, login, password);
		users.add(user);
		rows.add( new Object [] {
				user.getIdentifiant(), "", 
				
				user.getLogin(),
				user.getPassword()
		});
		
		fireTableDataChanged();
	}

	public void delete(User user) {
		int indexOf = users.indexOf(user);
		users.remove(user);
		rows.remove(indexOf);
		
		fireTableDataChanged();
	}
	
	public void update (int id, String login, String password) {
		User user = new User(id, login, password);
		int indexOf = users.indexOf(user);
		users.get(indexOf).setLogin(login);
		users.get(indexOf).setPassword(password);
		
		Object [] obj = rows.get(indexOf);
		obj[1] = login;
		obj[2] = password;
		
		fireTableDataChanged();
	}
	*/
}