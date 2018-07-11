package com.cg.librarymanagementhash.service;

import com.cg.librarymanagementhash.dao.ILibrarydao;
import com.cg.librarymanagementhash.dao.LibraryDaoImpl;
import com.cg.librarymanagementhash.dto.PersonInfoDto;
import com.cg.librarymanagementhash.exception.IMemberExceptionMessages;

import com.cg.librarymanagementhash.exception.MemberException;

public class LibraryService implements ILibraryService {
	
	ILibrarydao iLibrarydao=new LibraryDaoImpl();

	@Override
	public void addDetails(PersonInfoDto personDto) {
		// TODO Auto-generated method stub
		iLibrarydao.addDetails(personDto);
	}

	@Override
	public PersonInfoDto viewMemberDetails(String memberId) {
		// TODO Auto-generated method stub
		
		return iLibrarydao.viewMemberDetails(memberId);
	}

	@Override
	public double payAmount(String id) {
		// TODO Auto-generated method stub
		return iLibrarydao.payAmount(id);
	}

	@Override
	public boolean validateMember(String memberName, String memberId) throws MemberException{	// TODO Auto-generated method stub
		
	
		boolean result=false;
		if(memberId.trim().matches("{^[0-9a-zA-Z]+$}"))		{
		
			if(memberName.trim().matches("^[a-zA-Z]{1,15}$")) {		
			result=true;
		}
		else
			{
			throw new MemberException(IMemberExceptionMessages.ERROR2);
			}
		}
		else{
			throw new MemberException(IMemberExceptionMessages.ERROR1);
		}
		
		
		return result;
	}
 

}
