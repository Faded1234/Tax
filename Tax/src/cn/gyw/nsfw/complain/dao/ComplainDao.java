package cn.gyw.nsfw.complain.dao;

import java.util.List;

import cn.gyw.core.dao.BaseDao;
import cn.gyw.nsfw.complain.entity.Complain;

public interface ComplainDao extends BaseDao<Complain> {
	//根据年份获取统计年度的每个月的投诉数。
	public List<Object[]> getAnnualStatisticDataByYear(int year);

}
