package com.bridgeit.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Demo {

	public static void main(String args[]) {
		
		Resource resourse = new ClassPathResource("config.xml");
		BeanFactory factory = new XmlBeanFactory(resourse);

		Student stud =  (Student)factory.getBean("studentBean");
		System.out.println(stud);
	}
}
