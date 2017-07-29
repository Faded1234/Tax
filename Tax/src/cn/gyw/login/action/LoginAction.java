package cn.gyw.login.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.struts2.ServletActionContext;

import cn.gyw.core.Constant.Constant;
import cn.gyw.nsfw.user.entity.User;
import cn.gyw.nsfw.user.service.UserService;

import com.mysql.jdbc.log.LogFactory;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.StringUtil;

public class LoginAction extends ActionSupport {
	
	@Resource
	private UserService userService; 
	private User user;
	private String loginResult;
	// 跳转到登陆页面
	public String toLoginUI() {
		return "loginUI";
	}
	//登陆
	public String login(){
		if(user != null ){
			if(StringUtils.isNotBlank(user.getAccount() )|| StringUtils.isNotBlank(user.getPassword())){
				//根据用户账号和密码查找
				List<User> list = userService.findUserByAccountAndPass(user.getAccount(),user.getPassword());
				if(list != null && list.size() > 0){
					//登陆成功
				    //将用户信息保存到sesion中
					User user=list.get(0);
					//根据用户id查找该用户的所有角色
					user.setUserRole(userService.getUserRolesByUserId(user.getId()));
					ServletActionContext.getRequest().getSession().setAttribute(Constant.USER, user);
					//将用户登陆记录保存到日志中
					Log log = org.apache.commons.logging.LogFactory.getLog(getClass());
					log.info("用户名称为：" + user.getName() + "的用户登陆了系统");
					//重定向到首页
					return "home";
				}else{
					loginResult="账号密码不正确！";
				}
			}else{
				loginResult="账号或者密码不能为空！";
			}
		}else{
			loginResult = "请输入账号和密码！";
		}
		return toLoginUI();
	}
	//推出注销
	public String logout(){
		//清除session中保存的对象
		ServletActionContext.getRequest().getSession().removeAttribute(Constant.USER);
		return toLoginUI();
	}
	//跳转到没有权限提示页面
	public String toNoPermissionUI(){
		return "noPermissionUI";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getLoginResult() {
		return loginResult;
	}
	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}
	
}
