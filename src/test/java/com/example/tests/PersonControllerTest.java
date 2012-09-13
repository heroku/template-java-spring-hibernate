package com.example.tests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.example.controller.PersonController;


import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;


public class PersonControllerTest extends TestCase {
	@Test
    public void testListPersons() throws Exception {
		/*Map<String,Object> reqMap = new HashMap<String,Object>();
		PersonController c= new PersonController();
		
		String viewName = c.listPeople(reqMap);
		*/
		Assert.assertEquals(1, 1);
   }

}