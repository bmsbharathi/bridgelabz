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
		} 
		
		
		finally {
			session.close();
		}
	}

	public Register getUser(Login user) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();

		try {
			UserMapper usermapper = session.getMapper(UserMapper.class);
			Register reg = usermapper.getUser(user);
			
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
		try {
			UserMapper usermapper = session.getMapper(UserMapper.class);
			usermapper.updatePass(email,pass);
			
			
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public String checkEmail(String email) {

		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		String email1="";
		
		try {
			UserMapper usermapper = session.getMapper(UserMapper.class);
			email1 = usermapper.checkEmail(email);
			
			session.commit();
			return email1;
		} finally {
			session.close();
			
		}
		
		
	}

}
