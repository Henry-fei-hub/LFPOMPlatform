package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePoolManage;
import com.pomplatform.db.dao.PoolManage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PoolManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PoolManageHandler.class);

	public static BasePoolManage getPoolManageById( 
		java.lang.Integer pool_manage_id
	) throws Exception
	{
		PoolManage dao = new PoolManage();
		dao.setPoolManageId(pool_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPoolManageExists( com.pomplatform.db.bean.BasePoolManage bean, String additional ) throws Exception {

		PoolManage dao = new PoolManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPoolManage( com.pomplatform.db.bean.BasePoolManage bean, String additional ) throws Exception {

		PoolManage dao = new PoolManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePoolManage> queryPoolManage( com.pomplatform.db.bean.BasePoolManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PoolManage dao = new PoolManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePoolManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePoolManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePoolManage addToPoolManage ( BasePoolManage poolmanage )  throws Exception {
		return addToPoolManage ( poolmanage , false);
	}

	public static BasePoolManage addToPoolManage ( BasePoolManage poolmanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PoolManage dao = new PoolManage();
		dao.setDataFromBase(poolmanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePoolManage addUpdatePoolManage ( BasePoolManage poolmanage ) throws Exception {
		return addUpdatePoolManage ( poolmanage , false);
	}

	public static BasePoolManage addUpdatePoolManage ( BasePoolManage poolmanage, boolean singleTransaction  ) throws Exception {
		if(poolmanage.getPoolManageId() == null) return addToPoolManage(poolmanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PoolManage dao = new PoolManage();
		dao.setDataFromBase(poolmanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(poolmanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePoolManage ( BasePoolManage bean ) throws Exception {
		PoolManage dao = new PoolManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePoolManage updatePoolManage ( BasePoolManage poolmanage ) throws Exception {
		PoolManage dao = new PoolManage();
		dao.setPoolManageId( poolmanage.getPoolManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(poolmanage);
			result = dao.update();
		}
		return result == 1 ? poolmanage : null ;
	}

	public static BasePoolManage updatePoolManageDirect( BasePoolManage poolmanage ) throws Exception {
		PoolManage dao = new PoolManage();
		int result = 0;
		dao.setDataFromBase(poolmanage);
		result = dao.update();
		return result == 1 ? poolmanage : null ;
	}

	public static int setDeleteConditions(BasePoolManage bean, PoolManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPoolManageId() != null) {
			dao.setConditionPoolManageId("=", bean.getPoolManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPoolName() != null) {
				dao.setConditionPoolName("=", bean.getPoolName());
				count++;
			}
			if(bean.getRegion() != null) {
				dao.setConditionRegion("=", bean.getRegion());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getPoolType() != null) {
				dao.setConditionPoolType("=", bean.getPoolType());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePoolManage bean, PoolManage dao){
		int count = 0;
		if(bean.getPoolManageId() != null) {
			dao.setConditionPoolManageId("=", bean.getPoolManageId());
			count++;
		}
		if(bean.getPoolName() != null) {
			if(bean.getPoolName().indexOf("%") >= 0)
				dao.setConditionPoolName("like", bean.getPoolName());
			else
				dao.setConditionPoolName("=", bean.getPoolName());
			count++;
		}
		if(bean.getRegion() != null) {
			dao.setConditionRegion("=", bean.getRegion());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getPoolType() != null) {
			dao.setConditionPoolType("=", bean.getPoolType());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePoolManage bean = new BasePoolManage();
		bean.setDataFromJSON(json);
		PoolManage dao = new PoolManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePoolManage> rlist = new BaseCollection<>();
		BasePoolManage bean = new BasePoolManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PoolManage dao = new PoolManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePoolManage> result = dao.conditionalLoad(addtion);
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
		BasePoolManage bean = new BasePoolManage();
		bean.setDataFromJSON(json);
		PoolManage dao = new PoolManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePoolManage bean = new BasePoolManage();
		bean.setDataFromJSON(json);
		PoolManage dao = new PoolManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePoolManage bean = new BasePoolManage();
		bean.setDataFromJSON(json);
		PoolManage dao = new PoolManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePoolManage bean = new BasePoolManage();
		bean.setDataFromJSON(json);
		PoolManage dao = new PoolManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


