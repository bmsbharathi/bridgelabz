package com.bridgeit;

public class Person {

	private Person(){
		
	}
	
	private Person(String name,int age, String city){
		
		this.name = name;
		this.age = age;
		this.city = city;
	}
	
	
	private String name,city;
	private int age;
	
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public int getAge() {
		return age;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", city=" + city + ", age=" + age + "]";
	}
	
	
	
	
}
