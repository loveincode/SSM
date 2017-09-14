package com.hyf.loveincode.bean;
/**
* person 实体
* @author loveincode
* @data Sep 12, 2017 12:14:24 PM
*/
public class Person {

    private int id;
    private String name;
    private int age;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
    
}