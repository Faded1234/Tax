package cn.gyw.test.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gyw.test.dao.TestDao;
import cn.gyw.test.entity.Person;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao{

	public void save(Person person) {
		getHibernateTemplate().save(person);
	}

	public Person findPerson(Serializable id) {
		return getHibernateTemplate().get(Person.class, id);
		
	}

}
