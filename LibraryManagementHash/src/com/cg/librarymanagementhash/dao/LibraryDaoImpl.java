package com.cg.librarymanagementhash.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.cg.librarymanagementhash.dto.PersonInfoDto;

public  class LibraryDaoImpl implements ILibrarydao {
	
public	static HashMap<String,PersonInfoDto> person=null;
	
	static {		
		person=new HashMap<>();
	}

	@Override
	public void addDetails(PersonInfoDto personInfoDto) {
		String personId=personInfoDto.getMemberID();
		person.put(personId, personInfoDto);
		System.out.println("Details added");
	}

	@Override
	public PersonInfoDto viewMemberDetails(String id1) {
		// TODO Auto-generated method stub
		PersonInfoDto personinfo=new PersonInfoDto(); //object of dto class
		
		Set<Entry<String,PersonInfoDto>> set=person.entrySet();
		Iterator<Entry<String,PersonInfoDto>> it=set.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String,PersonInfoDto> entry=it.next();
			if(entry.getKey().equals(id1)) {
				personinfo=entry.getValue();
				break;
			}
		}
		return personinfo;
	}

	@Override
	public double payAmount(String id) {
		// TODO Auto-generated method stub
		Set<Entry<String,PersonInfoDto>> set=person.entrySet();
		Iterator<Entry<String,PersonInfoDto>> it=set.iterator();
		PersonInfoDto personinfo=new PersonInfoDto();
		
		while(it.hasNext()) {
			Map.Entry<String,PersonInfoDto> entry=it.next();

id=entry.getKey();
				personinfo=entry.getValue();
		}
double amount=personinfo.getAmount();
double fineamount=personinfo.getFineAmount();
double finalamount=amount-fineamount;
return finalamount;
	
	}
}
