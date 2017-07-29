package cn.gyw.core.permission.impl;

import java.util.List;

import javax.annotation.Resource;

import cn.gyw.core.permission.PermissionCheck;
import cn.gyw.nsfw.role.entity.Role;
import cn.gyw.nsfw.role.entity.RolePrivilege;
import cn.gyw.nsfw.user.entity.User;
import cn.gyw.nsfw.user.entity.UserRole;
import cn.gyw.nsfw.user.service.UserService;

public class PermissionCheckImpl implements PermissionCheck{
	
	@Resource
	private UserService userService;
	public boolean isAccessible(User user, String code) {
		//获取用户的所有角色
		List<UserRole> list = user.getUserRole();
		if(list == null){
			list = userService.getUserRolesByUserId(user.getId());
		}
		//根据每个角色对于所有的权限进行对比
		 if(list !=null && list.size()>0){
			 for (UserRole ur : list) {
				Role role = ur.getId().getRole();
				for(RolePrivilege rp:role.getRolePrivileges()){
					//是否含有code对应的角色
					if(code.equals(rp.getId().getCode())){
						return true;
					}
				}
			 }
		 }
		return false;
	}

}
