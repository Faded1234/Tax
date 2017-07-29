package cn.gyw.nsfw.role.entity;

import java.io.Serializable;

/**
 * @author 
 *角色权限表
 */
public class RolePrivilege implements Serializable{
	//联合主键
	private RolePrivilegeId id;
	public RolePrivilege() {
	}
	public RolePrivilege(RolePrivilegeId id) {
		this.id = id;
	}
	public RolePrivilegeId getId() {
		return id;
	}
	public void setId(RolePrivilegeId id) {
		this.id = id;
	}
	
	
}
