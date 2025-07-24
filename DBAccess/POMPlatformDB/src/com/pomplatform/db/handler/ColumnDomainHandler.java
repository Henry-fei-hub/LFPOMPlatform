package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseColumnDomain;
import com.pomplatform.db.dao.ColumnDomain;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class ColumnDomainHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ColumnDomainHandler.class);

	public static BaseColumnDomain getColumnDomainById( 
		java.lang.String select_id
	) throws Exception
	{
		ColumnDomain dao = new ColumnDomain();
		dao.setSelectId(select_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isColumnDomainExists( com.pomplatform.db.bean.BaseColumnDomain bean, String additional ) throws Exception {

		ColumnDomain dao = new ColumnDomain();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countColumnDomain( com.pomplatform.db.bean.BaseColumnDomain bean, String additional ) throws Exception {

		ColumnDomain dao = new ColumnDomain();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseColumnDomain> queryColumnDomain( com.pomplatform.db.bean.BaseColumnDomain bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ColumnDomain dao = new ColumnDomain();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseColumnDomain> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseColumnDomain> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseColumnDomain addToColumnDomain ( BaseColumnDomain columndomain )  throws Exception {
		return addToColumnDomain ( columndomain , false);
	}

	public static BaseColumnDomain addToColumnDomain ( BaseColumnDomain columndomain, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ColumnDomain dao = new ColumnDomain();
		dao.setDataFromBase(columndomain);
		int result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseColumnDomain addUpdateColumnDomain ( BaseColumnDomain columndomain ) throws Exception {
		return addUpdateColumnDomain ( columndomain , false);
	}

	public static BaseColumnDomain addUpdateColumnDomain ( BaseColumnDomain columndomain, boolean singleTransaction  ) throws Exception {
		if(columndomain.getSelectId() == null) return addToColumnDomain(columndomain);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ColumnDomain dao = new ColumnDomain();
		dao.setDataFromBase(columndomain);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(columndomain); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteColumnDomain ( BaseColumnDomain bean ) throws Exception {
		ColumnDomain dao = new ColumnDomain();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseColumnDomain updateColumnDomain ( BaseColumnDomain columndomain ) throws Exception {
		ColumnDomain dao = new ColumnDomain();
		dao.setSelectId( columndomain.getSelectId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(columndomain);
			result = dao.update();
		}
		return result == 1 ? columndomain : null ;
	}

	public static BaseColumnDomain updateColumnDomainDirect( BaseColumnDomain columndomain ) throws Exception {
		ColumnDomain dao = new ColumnDomain();
		int result = 0;
		dao.setDataFromBase(columndomain);
		result = dao.update();
		return result == 1 ? columndomain : null ;
	}

	public static int setDeleteConditions(BaseColumnDomain bean, ColumnDomain dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSelectId() != null) {
			dao.setConditionSelectId("=", bean.getSelectId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTableName() != null) {
				dao.setConditionTableName("=", bean.getTableName());
				count++;
			}
			if(bean.getKeyColumn() != null) {
				dao.setConditionKeyColumn("=", bean.getKeyColumn());
				count++;
			}
			if(bean.getValueColumn() != null) {
				dao.setConditionValueColumn("=", bean.getValueColumn());
				count++;
			}
			if(bean.getConditionColumn() != null) {
				dao.setConditionConditionColumn("=", bean.getConditionColumn());
				count++;
			}
			if(bean.getAdditionalCondition() != null) {
				dao.setConditionAdditionalCondition("=", bean.getAdditionalCondition());
				count++;
			}
			if(bean.getLoadOnStartup() != null) {
				dao.setConditionLoadOnStartup("=", bean.getLoadOnStartup());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseColumnDomain bean, ColumnDomain dao){
		int count = 0;
		if(bean.getSelectId() != null) {
			if(bean.getSelectId().indexOf("%") >= 0)
				dao.setConditionSelectId("like", bean.getSelectId());
			else
				dao.setConditionSelectId("=", bean.getSelectId());
			count++;
		}
		if(bean.getTableName() != null) {
			if(bean.getTableName().indexOf("%") >= 0)
				dao.setConditionTableName("like", bean.getTableName());
			else
				dao.setConditionTableName("=", bean.getTableName());
			count++;
		}
		if(bean.getKeyColumn() != null) {
			if(bean.getKeyColumn().indexOf("%") >= 0)
				dao.setConditionKeyColumn("like", bean.getKeyColumn());
			else
				dao.setConditionKeyColumn("=", bean.getKeyColumn());
			count++;
		}
		if(bean.getValueColumn() != null) {
			if(bean.getValueColumn().indexOf("%") >= 0)
				dao.setConditionValueColumn("like", bean.getValueColumn());
			else
				dao.setConditionValueColumn("=", bean.getValueColumn());
			count++;
		}
		if(bean.getConditionColumn() != null) {
			if(bean.getConditionColumn().indexOf("%") >= 0)
				dao.setConditionConditionColumn("like", bean.getConditionColumn());
			else
				dao.setConditionConditionColumn("=", bean.getConditionColumn());
			count++;
		}
		if(bean.getAdditionalCondition() != null) {
			if(bean.getAdditionalCondition().indexOf("%") >= 0)
				dao.setConditionAdditionalCondition("like", bean.getAdditionalCondition());
			else
				dao.setConditionAdditionalCondition("=", bean.getAdditionalCondition());
			count++;
		}
		if(bean.getLoadOnStartup() != null) {
			dao.setConditionLoadOnStartup("=", bean.getLoadOnStartup());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseColumnDomain bean = new BaseColumnDomain();
		bean.setDataFromJSON(json);
		ColumnDomain dao = new ColumnDomain();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseColumnDomain> rlist = new BaseCollection<>();
		BaseColumnDomain bean = new BaseColumnDomain();
		bean.setDataFromJSON(json);
		ColumnDomain dao = new ColumnDomain();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseColumnDomain> result = dao.conditionalLoad(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception{
		BaseColumnDomain bean = new BaseColumnDomain();
		bean.setDataFromJSON(json);
		ColumnDomain dao = new ColumnDomain();
		dao.setDataFromBase(bean);
		int num = dao.save(false);
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseColumnDomain bean = new BaseColumnDomain();
		bean.setDataFromJSON(json);
		ColumnDomain dao = new ColumnDomain();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseColumnDomain bean = new BaseColumnDomain();
		bean.setDataFromJSON(json);
		ColumnDomain dao = new ColumnDomain();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseColumnDomain bean = new BaseColumnDomain();
		bean.setDataFromJSON(json);
		ColumnDomain dao = new ColumnDomain();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(false); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


