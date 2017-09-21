package com.bridgeit.DAO;

import org.apache.ibatis.session.SqlSession;

import com.bridgeit.Model.Login;
import com.bridgeit.Model.Register;
import com.bridgeit.MyBatisUtility.MyBatisUtil;

public class UserMapperImpl implements UserMapper {

	public void insertUser(Register user) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();

		try {
			UserMapper usermapper = session.getMapper(UserMapper.class);
			usermapper.insertUser(user);
			session.commit();
		} finally {
			session.close();
		}
	}

	public Register getUser(Login user) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();

		try {
			UserMapper usermapper = session.getMapper(UserMapper.class);
			Register reg = usermapper.getUser(user);
			System.out.println(reg);
			session.commit();
			return reg;
		} finally {
			session.close();
		}

	}

	@Override
	public String checkUser(String uname) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper usermapper = session.getMapper(UserMapper.class);
			String name = usermapper.checkUser(uname);

			session.commit();
			return name;
		} finally {
			session.close();
		}

	}

	@Override
	public String getEmail(String uname) {

		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		
		try {
			UserMapper usermapper = session.getMapper(UserMapper.class);
			String email = usermapper.getEmail(uname);

			session.commit();
			return email;
		} finally {
			session.close();
		}
		
	}

	@Override
	public void updatePass(String email,String pass) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		int n;
		try {
			UserMapper usermapper = session.getMapper(UserMapper.class);
			usermapper.updatePass(email,pass);
			System.out.println("disturbed: ");
			System.out.println(email+"   "+pass);
			session.commit();
		} finally {
			session.close();
		}

	}

}
