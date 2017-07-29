package cn.gyw.nsfw.role.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.gyw.core.service.impl.BaseServiceImpl;
import cn.gyw.nsfw.role.dao.RoleDao;
import cn.gyw.nsfw.role.entity.Role;
import cn.gyw.nsfw.role.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	
	private RoleDao roleDao;
	
	@Resource
	public void setRoleDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
		this.roleDao = roleDao;
	}


	public void update(Role role) {
		roleDao.deleteRolePrivilegeByRoleId(role.getRoleId());
		roleDao.update(role);
	}




}
