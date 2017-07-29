package cn.gyw.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.gyw.core.Constant.Constant;
import cn.gyw.core.permission.PermissionCheck;
import cn.gyw.nsfw.user.entity.User;

public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		String uri=request.getRequestURI();
		//判断当前的请求是否是登录的请求
		if(!uri.contains("/sys/login_")){
			//非登录请求
			if(request.getSession().getAttribute(Constant.USER) != null){
				//说明已经登录，放行
				//判断是否访问纳税系统
				if(uri.contains("/nsfw/")){
					//访问纳税服务子系统
					User user=(User)request.getSession().getAttribute(Constant.USER);
					//获取spring容器
					WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
					//必须初始化，不然会报空指针异常
					PermissionCheck pc=(PermissionCheck)applicationContext.getBean("permissionCheck");
					if(pc.isAccessible(user,"nsfw")){
						//有权限，放行
						chain.doFilter(request,response);
					}else{
						//没有权限，跳转到没有权限提示页面
						response.sendRedirect(request.getContextPath() + "/sys/login_toNoPermissionUI.action");
						
					}
				}else{
					//非访问纳税服务子系统，直接放行
					chain.doFilter(request,response);
				}
			}else{
				//没有登录，跳转到登录页面
				response.sendRedirect(request.getContextPath() + "/sys/login_toLoginUI.action");
				
			}
		}else{
			//登录请求，放行
			chain.doFilter(request,response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
