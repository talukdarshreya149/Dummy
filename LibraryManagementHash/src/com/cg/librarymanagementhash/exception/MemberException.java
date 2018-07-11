package com.cg.librarymanagementhash.exception;

@SuppressWarnings("serial")
public class MemberException extends Exception{
public MemberException() {
	// TODO Auto-generated constructor stub
	super();
}
public MemberException(String messages) {
	System.out.println(messages);
}
}
