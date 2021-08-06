package com.sgi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sgi.entities.Incident;
import com.sgi.jdbc.DBManager;

public class IncidentDaoImpl implements IDao<Incident> {

	@Override
	public void create(Incident incident) throws Exception {
		Connection connection = DBManager.getConnection() ;

		String query = "Insert Into T_Incidents (description, application, gravite) values (?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setString(1, incident.getDescription());
		preparedStatement.setString(2, incident.getApplication());
		preparedStatement.setString(3, incident.getGravite());

		preparedStatement.execute();
		
		connection.close();

	}

	@Override
	public Incident read(int id) throws Exception {
		Incident incident = null;
		
		Connection connection = DBManager.getConnection() ;

	    String query = "Select * From T_Incidents Where id = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setInt(1, id);
	    
	    ResultSet resultSet = preparedStatement.executeQuery();
	    	    	    
	    if (resultSet.next()) {
	    	incident = new Incident (id, 
	        		resultSet.getString("description"),
	        		resultSet.getString("application"),
	        		resultSet.getString("gravite"));
	    }

	    connection.close();
	    
		return incident;
	}

	@Override
	public void update(Incident incident) throws Exception {
		Connection connection = DBManager.getConnection() ;

	    String query = "Update T_Incidents Set description=? Where id=?";

	    PreparedStatement prepareStatement = connection.prepareStatement(query);
	        
	    prepareStatement.setString(1, incident.getDescription());
	    prepareStatement.setInt(2, incident.getId());
	       
	    prepareStatement.execute();
	    
	    connection.close();
	}

	@Override
	public void delete(Integer id) throws Exception {
		Connection connection = DBManager.getConnection() ;

		String query = "Delete From T_Incidents Where id=?";
	       
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		
		connection.close();
	}

	@Override
	public List<Incident> list() throws Exception {
		Connection connection = DBManager.getConnection() ;

		List<Incident> incidents = new ArrayList<>();
		String query = "Select * From T_Incidents";

		PreparedStatement prepareStatement = connection.prepareStatement(query);
		ResultSet resultSet = prepareStatement.executeQuery();

		while (resultSet.next()) {
			
			int id = resultSet.getInt("id");
			String description = resultSet.getString("description");
			String application = resultSet.getString("application");
			String gravite = resultSet.getString("gravite");
			
			Incident incident = new Incident (id, description, application, gravite);
			
			incidents.add(incident);
		}
		
		connection.close();
		
		return incidents;
	}

}
