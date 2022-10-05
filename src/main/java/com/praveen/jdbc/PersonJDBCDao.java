package com.praveen.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.praveen.entity.Person;

@Repository
public class PersonJDBCDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
	    return jdbcTemplate;
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	// select * from person;
	public List<Person> findAll() {
		
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
		
		
	}
	
	// select * from person where id = ?;
	@SuppressWarnings("deprecation")
	public Person findById(int id) {
			
		return jdbcTemplate.queryForObject("select * from person where id=?",
											new Object[] {id}, 
											new BeanPropertyRowMapper<Person>(Person.class));
		
		
	}
	
	// delete from person where id=?
	public int deleteById(int id) {
			
		return jdbcTemplate.update("delete from person where id=?",	new Object[] {id});
						
	}
	
	// INSERT INTO person(id, name, location) VALUES(?, ?, ?);
	public int insert(Person person) {
				
		return jdbcTemplate.update("insert into person(id, name, location) "
								 + "values(?, ?, ?);",	
		new Object[] {person.getId(), person.getName(), person.getLocation()});
							
	}
	
	// INSERT INTO person(id, name, location) VALUES(?, ?, ?);
	public int update(Person person) {
					
		return jdbcTemplate.update("update person set name=?, location=? "
								 + "where id = ?",	
		new Object[] {person.getName(), person.getLocation(), person.getId(),});
								
	}

}
