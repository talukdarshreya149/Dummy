package com.cg.librarymanagementhash.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.librarymanagementhash.dto.PersonInfoDto;

public class LibraryMemberTest {
	private static final double DELTA=1e-15;
	static ILibrarydao test=null;
	static PersonInfoDto persondto=null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test=new LibraryDaoImpl();
		persondto=new PersonInfoDto();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Test executed");
	}

	@Before
	public void addDetailsTest() {
		persondto.setMemberName("shreya");
		persondto.setMemberID("shreya1234");
		assertEquals("shreya",persondto.getMemberName());
	}

	@Test
	public void viewDetailsTest() {
		persondto.setMemberName("shreya");
		persondto.setMemberID("shreya123");
		
		LibraryDaoImpl.person.put(persondto.getMemberID(),persondto);
		assertEquals("shreya",LibraryDaoImpl.person.get("shreya123").getMemberName());
		
	}
	
	@Test
	public void paymentAmountTest() {
		persondto.setAmount(1000);
		persondto.setFineAmount(200);
		persondto.setMemberName("shreya");
		persondto.setMemberID("shreya1234");
		
		LibraryDaoImpl.person.put(persondto.getMemberID(),persondto);
		double finalamount=test.payAmount("shreya1234");
		assertEquals(800,finalamount,DELTA); //DEltA is used to compare two double values
	}

	@Test
	public void viewDetailsTest1() {
		persondto.setMemberName("shreya");
		persondto.setMemberName("shreya123");
		LibraryDaoImpl.person.put(persondto.getMemberID(),persondto);
		assertNotSame("shreya",LibraryDaoImpl.person.get("shreya1234").getMemberName());
		
	}
}
