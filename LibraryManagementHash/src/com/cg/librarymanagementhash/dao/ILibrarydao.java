package com.cg.librarymanagementhash.dao;

import java.util.HashMap;

import com.cg.librarymanagementhash.dto.PersonInfoDto;

public interface ILibrarydao {

	public void addDetails(PersonInfoDto personInfoDto);
    public PersonInfoDto viewMemberDetails(String id);
    public double payAmount(String id);
}
