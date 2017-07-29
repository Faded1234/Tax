package cn.gyw.test.service.impl;


import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.gyw.test.dao.TestDao;
import cn.gyw.test.entity.Person;
import cn.gyw.test.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {
	
	@Resource
	TestDao testDao;
	
	public void say() {
		System.out.println("service saying hi.");
	}

	public void save(Person person) {
		testDao.save(person);
	}

	public Person findPerson(Serializable id) {
		
		return testDao.findPerson(id);
	}

}
