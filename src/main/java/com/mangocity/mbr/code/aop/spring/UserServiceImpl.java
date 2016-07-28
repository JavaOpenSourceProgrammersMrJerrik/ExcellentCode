package com.mangocity.mbr.code.aop.spring;

public class UserServiceImpl implements IUserService {

	@Override
	public int addUser() {
		System.out.println("addUser {}");
		return 0;
	}

	@Override
	public int deleteUser() {
		System.out.println("deleteUser {}");
		return 1;
	}

	@Override
	public int updateUser() {
		System.out.println("updateUser {}");
		return 2;
	}

	@Override
	public void findUser() {
		System.out.println("findUser {}");
	}

}
