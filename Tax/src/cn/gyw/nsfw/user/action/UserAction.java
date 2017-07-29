package cn.gyw.nsfw.user.action;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.gyw.core.action.BaseAction;
import cn.gyw.core.util.QueryHelper;
import cn.gyw.nsfw.info.entity.Info;
import cn.gyw.nsfw.role.entity.Role;
import cn.gyw.nsfw.role.service.RoleService;
import cn.gyw.nsfw.user.entity.User;
import cn.gyw.nsfw.user.entity.UserRole;
import cn.gyw.nsfw.user.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.StringUtil;

public class UserAction extends BaseAction{
	
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	private User user;
	private String[] userRoleIds;

	private File headImg;
	private String headImgContentType;
	private String headImgFileName;

	private File userExcel;
	private String userExcelContentType;
	private String userExcelFileName;
	private String strName;
	
	//列表页面
	public String listUI() throws Exception{
		QueryHelper queryHelper = new QueryHelper(User.class, "u");
		try {
			if(user != null){
				if(StringUtils.isNotBlank(user.getName())){
					user.setName(URLDecoder.decode(user.getName(), "utf-8"));
					queryHelper.addCondition("u.name like ? ", "%"+user.getName()+"%");
				}
			}
			pageResult = userService.getPageResult(queryHelper,getPageNo(),getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "listUI";
	}
	//跳转到新增页面
	public String addUI(){
		//添加角色列表
		ActionContext.getContext().getContextMap().put("roleList", roleService.findObjects());
		return "addUI";
	}
	//保存新增
	public String add(){
		if(user!=null){
			//处理头像
			try {
				if(headImg != null){
					//保存文件到指定文件夹
					String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
					String fileName = UUID.randomUUID().toString() + 
							headImgFileName.substring(headImgFileName.lastIndexOf("."));
					FileUtils.copyFile(headImg, new File(filePath,fileName));
					
					//设置用户头像路径
					user.setHeadImg("user/" + fileName);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			userService.saveUserAndRole(user,userRoleIds);
		}
		return "list";
	}
	//跳转到编辑页面
	public String editUI(){
		List<Role> findObjecs = roleService.findObjects();
		ActionContext.getContext().getContextMap().put("roleList", findObjecs);
		if(user!=null && user.getId()!=null){
			strName=user.getName();
			user=userService.findObjectById(user.getId());
			//处理角色回显
			List<UserRole> list = userService.getUserRolesByUserId(user.getId());
			if(list != null && list.size() > 0){
				userRoleIds = new String[list.size()];
				for(int i=0;i<list.size();i++){
					userRoleIds[i] = list.get(i).getId().getRole().getRoleId();
				}
			}
		}
		return "editUI";
	}
	//保存编辑
	public String edit(){
		if(user!=null){
			try {
				if(headImg != null){
					//保存文件到指定文件夹
					String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
					String fileName = UUID.randomUUID().toString() + 
							headImgFileName.substring(headImgFileName.lastIndexOf("."));
					FileUtils.copyFile(headImg, new File(filePath,fileName));
					
					//设置用户头像路径
					user.setHeadImg("user/" + fileName);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			userService.updateUserAndRole(user,userRoleIds);
		}		
		return "list";
	}
	//删除
	public String delete(){
		if(user!=null && user.getId()!=null){
			userService.delete(user.getId());
		}	
		return "list";
	}
	//批量删除
	public String deleteSelected(){
		if( selectedRow !=null){
			for (String id : selectedRow) {
				userService.delete(id);
			}
		}
		return "list";
	}
	//导出excel
	public void exportExcel(){
		try {
			//1，查找用户列表
			//2，导出
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/x-execl");
			response.setHeader("content-Disposition", "attachment;filename=" +new String("用户列表.xls".getBytes(),"ISO-8859-1"));
			ServletOutputStream outputStream = response.getOutputStream();
			userService.exportExcel(userService.findObjects(),outputStream);
			if(outputStream == null){
				outputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//导入用户列表
	public String importExcel(){
		//1，获取execl文件
		if(userExcel !=null){
			if(userExcelFileName.matches("^.+\\.(?i)((xls)|(xlsx))$")){
				//导入
				userService.importExecl(userExcel,userExcelFileName);
			}
		}
		return "list";
	}
	
	//效验用户唯一性
	public void verifyAccount(){
		try {
			//获取账号
			if(user != null && StringUtils.isNotBlank(user.getAccount())){
				List<User> list = userService.findUserByAccountAndId(user.getAccount(),user.getId());
				String strResult = "true";
				if(list !=null && list.size()>1){
					strResult = "false";
				}
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(strResult.getBytes());
				outputStream.close();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public File getHeadImg() {
		return headImg;
	}
	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}
	public String getHeadImgContentType() {
		return headImgContentType;
	}
	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}
	public String getHeadImgFileName() {
		return headImgFileName;
	}
	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}
	public File getUserExcel() {
		return userExcel;
	}
	public void setUserExcel(File userExcel) {
		this.userExcel = userExcel;
	}
	public String getUserExcelContentType() {
		return userExcelContentType;
	}
	public void setUserExcelContentType(String userExcelContentType) {
		this.userExcelContentType = userExcelContentType;
	}
	public String getUserExcelFileName() {
		return userExcelFileName;
	}
	public void setUserExcelFileName(String userExcelFileName) {
		this.userExcelFileName = userExcelFileName;
	}
	public String[] getUserRoleIds() {
		return userRoleIds;
	}
	public void setUserRoleIds(String[] userRoleIds) {
		this.userRoleIds = userRoleIds;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
}
