package com.praveen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.praveen.entity.Person;
import com.praveen.jdbc.PersonJDBCDao;

@SpringBootApplication
public class SpringbootJdbcJpaApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJDBCDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJdbcJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("All users => {}",dao.findAll());
		logger.info("User id 10001 => {}",dao.findById(10001));
		logger.info("User id 10001 delete => {}",dao.deleteById(10001));
		logger.info("All users => {}",dao.findAll());
		logger.info("Insert users => {}",dao.insert(new Person(10003, "john", "erode")));
		logger.info("Update user id=10003 => {}",dao.update(new Person(10003, "john", "coimbatore")));
		logger.info("All users => {}",dao.findAll());
		
	}

}
