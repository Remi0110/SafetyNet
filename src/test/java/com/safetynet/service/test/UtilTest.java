package com.safetynet.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.safetynet.service.Util;

public class UtilTest {

	
	 @Test
		public void testCalculAge () {
		 String date = "01/10/1987";
		 Util util = new Util();
		 long age = util.calculAge(date);
		 assertEquals(33, age);
		}
	 
	 @Test
		public void testCalculAgeWithANullValue () {
	
		 Util util = new Util();
		 String date = null;
		  assertThrows(
				  NullPointerException.class,
		            ()->util.calculAge(date));	
		}
}
