package cn.gyw.nsfw.info.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.gyw.core.service.impl.BaseServiceImpl;
import cn.gyw.nsfw.info.dao.InfoDao;
import cn.gyw.nsfw.info.entity.Info;
import cn.gyw.nsfw.info.service.InfoService;

@Service("infoService")
public class InfoServiceImpl extends BaseServiceImpl<Info> implements InfoService{

	private InfoDao infoDao;

	@Resource
	public void setInfoDao(InfoDao infoDao) {
		super.setBaseDao(infoDao);
		this.infoDao = infoDao;
	}
	

}
