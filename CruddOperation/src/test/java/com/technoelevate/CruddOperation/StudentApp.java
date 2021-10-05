package com.technoelevate.CruddOperation;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		StudentManagementSystem managementsystem=new StudentManagementSystem(scanner);
		
		for(;;) {
			System.out.println("1.InsertionDetails\n2.AllDetails\n3.ForSpecificData\n4.Update\n5.Delete\n.exit");
			System.out.println("Enter the choice ");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:
				managementsystem.insert();
				System.out.println("To continue press y or discontinue n");
				String option1=scanner.next();
				if(option1.equalsIgnoreCase("y")) {
					break;
				}else {
					return;
				}
			case 2:
				managementsystem.selectAll();
				System.out.println("To continue press y or discontinue n");
				String option2=scanner.next();
				if(option2.equalsIgnoreCase("y")) {
					break;
				}else {
					return;
				}
			case 3:
				managementsystem.selectParticular();
				System.out.println("To continue press y or discontinue n");
				String option3=scanner.next();
				if(option3.equalsIgnoreCase("y")) {
					break;
				}else {
					return;
				}
			case 4:
				managementsystem.delete();
				System.out.println("To continue press y or discontinue n");
				String option4=scanner.next();
				if(option4.equalsIgnoreCase("y")) {
					break;
				}else {
					return;
				}
			case 5:
				managementsystem.update();
				System.out.println("To continue press y or discontinue n");
				String option5=scanner.next();
				if(option5.equalsIgnoreCase("y")) {
					break;
				}else {
					return;
				}
			case 6:
				System.exit(0);
				break;
			default:
					
				try {
					throw new CustomException("Invalid data");
				}catch(CustomException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}

	}

}
