package cn.gyw.nsfw.home.action;

import cn.gyw.core.action.BaseAction;

public class HomeAction extends BaseAction {
	//跳转到纳税访问系统的首页
	public String frame() {
		return "frame";
	}
	//跳转到纳税访问系统的首页-顶部
	public String top() {
		return "top";
	}
	//跳转到纳税访问系统的首页-左边菜单
	public String left() {
		return "left";
	}
}
