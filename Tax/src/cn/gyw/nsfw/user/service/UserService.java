package cn.gyw.nsfw.user.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.gyw.core.service.BaseService;
import cn.gyw.nsfw.user.entity.User;
import cn.gyw.nsfw.user.entity.UserRole;


public interface UserService extends BaseService<User>{
	//导出用户列表
	public void exportExcel(List<User> userList,ServletOutputStream outputStream);
	//导入用户列表
	public void importExecl(File userExcel, String userExcelFileName);
	//根据账号和用户Id查找
	public List<User> findUserByAccountAndId(String account, String id);
	//保存用户及其对应的角色
	public void saveUserAndRole(User user, String... roleIds);
	//更新用户及其对应的角色
	public void updateUserAndRole(User user, String... roleIds);
	//根据用户id查找用户角色
	public List<UserRole> getUserRolesByUserId(String id);
	//根据账号和密码查找用户
	public List<User> findUserByAccountAndPass(String account, String password);
}
