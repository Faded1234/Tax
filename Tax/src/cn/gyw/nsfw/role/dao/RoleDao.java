package cn.gyw.nsfw.role.dao;

import cn.gyw.core.dao.BaseDao;
import cn.gyw.nsfw.role.entity.Role;

public interface RoleDao extends BaseDao<Role> {
	//删除角色的所有权限
	public void deleteRolePrivilegeByRoleId(String roleId);
	
}
