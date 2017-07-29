package cn.gyw.core.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.gyw.core.dao.BaseDao;
import cn.gyw.core.page.PageResult;
import cn.gyw.core.service.BaseService;
import cn.gyw.core.util.QueryHelper;
import cn.gyw.nsfw.info.entity.Info;

public class BaseServiceImpl<T> implements BaseService<T> {
	
	private BaseDao<T> baseDao;
	
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	public void save(T entity) {
		baseDao.save(entity);
	}

	public void update(T entity) {
		baseDao.update(entity);
	}

	public void delete(Serializable id) {
		baseDao.delete(id);
	}

	public T findObjectById(Serializable id) {
		return baseDao.findObjectById(id);
	}

	public List<T> findObjects() {
		return baseDao.findObjects();
	}

	public List<T> findObjects(String hql, List<Object> parameters) {
		return baseDao.findObjects(hql, parameters);
	}

	public List<T> findObjects(QueryHelper queryHelper) {
		return baseDao.findObjects(queryHelper);
	}

	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		return baseDao.getPageResult(queryHelper,pageNo,pageSize);
	}

}
