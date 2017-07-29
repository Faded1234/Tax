package cn.gyw.nsfw.user.dao.impl;

import java.io.Serializable;
import java.util.List;


import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;

import cn.gyw.core.dao.impl.BaseDaoImpl;
import cn.gyw.nsfw.user.dao.UserDao;
import cn.gyw.nsfw.user.entity.User;
import cn.gyw.nsfw.user.entity.UserRole;
import freemarker.template.utility.StringUtil;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	//根据账号和Id查找
	public List<User> findUserByAccountAndId(String account, String id) {
		String hql="FROM User WHERE account = ? ";
		if(StringUtils.isNotBlank(id)){
			hql += " AND id !=?";
		}
		Query query= getSession().createQuery(hql);
		query.setParameter(0, account);
		if(StringUtils.isNotBlank(id)){
			query.setParameter(1, id);
		}
		return query.list();
	}

	public void deleteUserRoleByUserId(Serializable id) {
		Query query = getSession().createQuery("DELETE FROM UserRole WHERE id.userId=?");
		query.setParameter(0, id);
		query.executeUpdate();
	}

	public void saveUserRole(UserRole userRole) {
		getHibernateTemplate().save(userRole);
	}

	public List<UserRole> getUserRolesByUserId(String id) {
		Query query = getSession().createQuery("FROM UserRole WHERE id.userId=?");
		query.setParameter(0, id);
		return query.list();
	}

	public List<User> findUserByAccountAndPass(String account, String password) {
		Query query = getSession().createQuery("FROM User WHERE account=? AND password=?");
		query.setParameter(0, account);
		query.setParameter(1, password);
		return query.list();
	}

}
