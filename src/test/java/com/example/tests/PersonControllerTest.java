package com.example.tests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import com.example.controller.PersonController;
import com.example.model.Person;
import com.example.service.PersonService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })

public class PersonControllerTest extends TestCase {

	@Autowired
	PersonService personService;
	
 	@Test
    public void testListPersons() throws Exception {
 		Person p = new Person();
		p.setFirstName("Test");
		p.setLastName("Person");
		personService.addPerson(p);
		
		List<Person> persons = personService.listPeople();
		Assert.assertEquals(1, persons.size());
   }

}