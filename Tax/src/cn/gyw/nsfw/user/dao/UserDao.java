package cn.gyw.nsfw.user.dao;

import java.io.Serializable;
import java.util.List;

import sun.print.resources.serviceui;

import cn.gyw.core.dao.BaseDao;
import cn.gyw.nsfw.user.entity.User;
import cn.gyw.nsfw.user.entity.UserRole;

public interface UserDao extends BaseDao<User>{
	//根据账号和id查找
	public List<User> findUserByAccountAndId(String account, String id);
	//根据用户的id删除该用户的所有角色
	public void deleteUserRoleByUserId(Serializable id);
	//保存用户的角色
	public void saveUserRole(UserRole userRole);
	//通过用户的Id查找用户的角色
	public List<UserRole> getUserRolesByUserId(String id);
	//根据用户账号和密码查找用户
	public List<User> findUserByAccountAndPass(String account, String password);
	
}
