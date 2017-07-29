package cn.gyw.nsfw.info.action;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;

import cn.gyw.core.Constant.Constant;
import cn.gyw.core.action.BaseAction;
import cn.gyw.core.page.PageResult;
import cn.gyw.core.util.QueryHelper;
import cn.gyw.nsfw.info.entity.Info;
import cn.gyw.nsfw.info.service.InfoService;

public class InfoAction extends BaseAction{
	
	@Resource
	private InfoService infoService;
	private Info info;
	private String[] privilegeIds;
	private String strTitle;

	
	//列表页面
	public String listUI() throws Exception{
		//加载分类集合
		ActionContext.getContext().getContextMap().put("infoTypeMap",Info.INFO_TYPE_MAP );
		List<Object> parameters=new ArrayList<Object>(); 
		QueryHelper queryHelper = new QueryHelper(Info.class, "i");
		try {
			if(info != null){
				if(StringUtils.isNotBlank(info.getTitle())){
					info.setTitle(URLDecoder.decode(info.getTitle(), "utf-8"));
					queryHelper.addCondition("i.title like ? ", "%"+info.getTitle()+"%");
				}
				queryHelper.addCondition("i.state = ? ", "1");
			}
			//根据创建时间排序
			queryHelper.addOrderByProperty("i.createTime", queryHelper.ORDER_BY_DESC);
			pageResult = infoService.getPageResult(queryHelper,getPageNo(),getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "listUI";
	}
	//跳转到新增页面
	public String addUI(){
		//加载分类集合
		ActionContext.getContext().getContextMap().put("infoTypeMap",Info.INFO_TYPE_MAP );
		info = new Info();
		info.setCreateTime(new Timestamp(new Date().getTime()));
		return "addUI";
	}
	//保存新增
	public String add(){
		if(info!=null){
			infoService.save(info);
		}
		return "list";
	}
	//跳转到编辑页面
	public String editUI(){
		//加载分类集合
		ActionContext.getContext().getContextMap().put("infoTypeMap",Info.INFO_TYPE_MAP );
		if(info!=null && info.getInfoId()!=null){
			strTitle = info.getTitle();
			info=infoService.findObjectById(info.getInfoId());
		}
		return "editUI";
	}
	//保存编辑
	public String edit(){
		if(info!=null){
			infoService.update(info);
		}		
		return "list";
	}
	//删除
	public String delete(){
		if(info!=null && info.getInfoId()!=null){
			strTitle = info.getTitle();
			infoService.delete(info.getInfoId());
		}	
		return "list";
	}
	//批量删除
	public String deleteSelected(){
		if( selectedRow !=null){
			strTitle = info.getTitle();
			for (String id : selectedRow) {
				infoService.delete(id);
			}
		}
		return "list";
	}
	//异步刷新信息
	public void publicInfo(){
		if(info != null){
			//更新状态信息
			try {
				Info tem = infoService.findObjectById(info.getInfoId());
				tem.setState(info.getState());
				infoService.update(tem);
				//输出更新结果
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write("更新状态成功".getBytes("utf-8"));
				outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} 
	
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public String[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	public String getStrTitle() {
		return strTitle;
	}
	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}
}
