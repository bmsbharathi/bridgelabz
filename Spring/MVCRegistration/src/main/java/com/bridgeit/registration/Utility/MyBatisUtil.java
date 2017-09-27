package com.bridgeit.registration.Utility;

import java.io.IOException;
import java.io.Reader;

import javax.annotation.Resources;

import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisUtil {

	private static SqlSessionFactory factory;
	
	static {
		
		Reader reader = null;
		
		try {
			reader = Resources.getResourceAsReader("MyBatis-config.xml");
			
		}catch (IOException e) {
			
			System.out.println(e);
		}
		
	}
}
