package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		// 실행시 person.xml을 읽어 들여 빈을 생성
		
		PersonService person = (PersonService) factory.getBean("personService");
		// id가 personService인 빈을 가져온다.
		
		person.sayHello();
		// 생성된 빈을 이용해 name 값을 출력한다.
	}
}
