package com.cg.librarymanagementhash.ui;

//------------------------    <NAme> Application --------------------------
	/*******************************************************************************************************
	 - Method Name	        :	<method_name>
	 - Input Parameters	:	<variable name(s)> <data type(s)>
	 - Return Type		:	<variable name> <data type>
	 - Throws		:  	<Application_name>Exception
	 - Author		:	<Your_name>
	 - Creation Date	:	dd/MM/yyyy
	 - Description		:	write description of the method in few lines
	 ********************************************************************************************************/

import java.util.Scanner;

import com.cg.librarymanagementhash.dto.PersonInfoDto;
import com.cg.librarymanagementhash.exception.MemberException;
import com.cg.librarymanagementhash.service.ILibraryService;
import com.cg.librarymanagementhash.service.LibraryService;

public class MainLibrary {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		ILibraryService service= new LibraryService();
		
		PersonInfoDto dto=new PersonInfoDto();
		
		int choice=0;
		do {
			printDetails();
			choice=scanner.nextInt();
			
			switch(choice) {
			case 1://add
				try {
				System.out.println("enter person id");
				String id=scanner.next();
				System.out.println("enter person name");
				String name=scanner.next();
				System.out.println("enter amount");
				double amount=scanner.nextDouble();
				System.out.println("enter fine amount");
				double fineAmt=scanner.nextDouble();
			
				if(service.validateMember(name, id)) {
					dto.setMemberID(id);
					dto.setMemberName(name);
					dto.setAmount(amount);
				   dto.setFineAmount(fineAmt);
				
				   service.addDetails(dto);
				
		}
				}catch(MemberException e) {
					System.out.println(e.getMessage());
				}
				
				break;
				case 2://view details
				
					System.out.println("enter member id");
				    String memId=scanner.next();
				
				PersonInfoDto per=service.viewMemberDetails(memId);
				
				System.out.println("Member Name: "+ dto.getMemberName());
				System.out.println("Member Account:" + dto.getAmount());
					
				break;
			
				case 3://updated balance
					
				System.out.println("enter member id");
				String id2=scanner.next();
				double finalamount1=service.payAmount(id2);
				System.out.println("Amount left after fine payment: "+ finalamount1);
				break;
			}	
			
			
		} while(choice!=3);
		scanner.close();
		
	}
	public static void printDetails() {
		
		System.out.println("*****Menu*****");
	
		System.out.println("1. To add member details");	
	System.out.println("2. To view member");
	System.out.println("3. To update  amount");
	}

}
