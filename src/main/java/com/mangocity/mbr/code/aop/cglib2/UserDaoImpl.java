package com.mangocity.mbr.code.aop.cglib2;

public class UserDaoImpl {
	public void addUser(User user) {
		System.out.println("addUser");
	}

	public void deleteUser(User user) {
		System.out.println("deleteUser");
	}

	public void findUser(User user) {
		System.out.println("findUser");
	}

	public void updateUser(User user) {
		System.out.println("updateUser");
	}
	
	public void execute(){
		addUser(null);
		deleteUser(null);
		updateUser(null);
		findUser(null);
		
		show();
	}
	
	public void show(){
		System.out.println("show");
	}
}
