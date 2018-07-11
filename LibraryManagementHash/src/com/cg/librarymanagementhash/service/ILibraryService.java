package com.cg.librarymanagementhash.service;

import com.cg.librarymanagementhash.dto.PersonInfoDto;
import com.cg.librarymanagementhash.exception.MemberException;

public interface ILibraryService {

	public void addDetails(PersonInfoDto personDto);
	public PersonInfoDto viewMemberDetails(String memberId);
public double payAmount(String id);
public boolean validateMember(String memberName,String memberId) throws MemberException;
	
}