package cn.gyw.core.permission;

import cn.gyw.nsfw.user.entity.User;

public interface PermissionCheck {
	//判断用户是否有对应的权限
	public boolean isAccessible(User user, String string);
	
}
