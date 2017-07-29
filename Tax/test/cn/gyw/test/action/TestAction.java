package cn.gyw.test.action;

import javax.annotation.Resource;

import cn.gyw.test.service.TestService;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	

	@Resource
	TestService testService;

	public String execute(){
		testService.say();
		return SUCCESS;
	}

	public String login(){
		testService.say();
		return SUCCESS;
	}
}
