package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeCheckinoutUpdatetime;
import com.pomplatform.db.dao.EmployeeCheckinoutUpdatetime;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeCheckinoutUpdatetimeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeCheckinoutUpdatetimeHandler.class);

	public static BaseEmployeeCheckinoutUpdatetime getEmployeeCheckinoutUpdatetimeById( 
		java.lang.Integer employee_checkinout_updatetime_id
	) throws Exception
	{
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		dao.setEmployeeCheckinoutUpdatetimeId(employee_checkinout_updatetime_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeCheckinoutUpdatetimeExists( com.pomplatform.db.bean.BaseEmployeeCheckinoutUpdatetime bean, String additional ) throws Exception {

		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeCheckinoutUpdatetime( com.pomplatform.db.bean.BaseEmployeeCheckinoutUpdatetime bean, String additional ) throws Exception {

		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeCheckinoutUpdatetime> queryEmployeeCheckinoutUpdatetime( com.pomplatform.db.bean.BaseEmployeeCheckinoutUpdatetime bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeCheckinoutUpdatetime> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeCheckinoutUpdatetime> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeCheckinoutUpdatetime addToEmployeeCheckinoutUpdatetime ( BaseEmployeeCheckinoutUpdatetime employeecheckinoutupdatetime )  throws Exception {
		return addToEmployeeCheckinoutUpdatetime ( employeecheckinoutupdatetime , false);
	}

	public static BaseEmployeeCheckinoutUpdatetime addToEmployeeCheckinoutUpdatetime ( BaseEmployeeCheckinoutUpdatetime employeecheckinoutupdatetime, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		dao.setDataFromBase(employeecheckinoutupdatetime);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeCheckinoutUpdatetime addUpdateEmployeeCheckinoutUpdatetime ( BaseEmployeeCheckinoutUpdatetime employeecheckinoutupdatetime ) throws Exception {
		return addUpdateEmployeeCheckinoutUpdatetime ( employeecheckinoutupdatetime , false);
	}

	public static BaseEmployeeCheckinoutUpdatetime addUpdateEmployeeCheckinoutUpdatetime ( BaseEmployeeCheckinoutUpdatetime employeecheckinoutupdatetime, boolean singleTransaction  ) throws Exception {
		if(employeecheckinoutupdatetime.getEmployeeCheckinoutUpdatetimeId() == null) return addToEmployeeCheckinoutUpdatetime(employeecheckinoutupdatetime);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		dao.setDataFromBase(employeecheckinoutupdatetime);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeecheckinoutupdatetime); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeCheckinoutUpdatetime ( BaseEmployeeCheckinoutUpdatetime bean ) throws Exception {
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeCheckinoutUpdatetime updateEmployeeCheckinoutUpdatetime ( BaseEmployeeCheckinoutUpdatetime employeecheckinoutupdatetime ) throws Exception {
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		dao.setEmployeeCheckinoutUpdatetimeId( employeecheckinoutupdatetime.getEmployeeCheckinoutUpdatetimeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeecheckinoutupdatetime);
			result = dao.update();
		}
		return result == 1 ? employeecheckinoutupdatetime : null ;
	}

	public static BaseEmployeeCheckinoutUpdatetime updateEmployeeCheckinoutUpdatetimeDirect( BaseEmployeeCheckinoutUpdatetime employeecheckinoutupdatetime ) throws Exception {
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		int result = 0;
		dao.setDataFromBase(employeecheckinoutupdatetime);
		result = dao.update();
		return result == 1 ? employeecheckinoutupdatetime : null ;
	}

	public static int setDeleteConditions(BaseEmployeeCheckinoutUpdatetime bean, EmployeeCheckinoutUpdatetime dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeCheckinoutUpdatetimeId() != null) {
			dao.setConditionEmployeeCheckinoutUpdatetimeId("=", bean.getEmployeeCheckinoutUpdatetimeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeCheckinoutUpdatetime bean, EmployeeCheckinoutUpdatetime dao){
		int count = 0;
		if(bean.getEmployeeCheckinoutUpdatetimeId() != null) {
			dao.setConditionEmployeeCheckinoutUpdatetimeId("=", bean.getEmployeeCheckinoutUpdatetimeId());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
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
		BaseEmployeeCheckinoutUpdatetime bean = new BaseEmployeeCheckinoutUpdatetime();
		bean.setDataFromJSON(json);
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeCheckinoutUpdatetime> rlist = new BaseCollection<>();
		BaseEmployeeCheckinoutUpdatetime bean = new BaseEmployeeCheckinoutUpdatetime();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeCheckinoutUpdatetime> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeCheckinoutUpdatetime bean = new BaseEmployeeCheckinoutUpdatetime();
		bean.setDataFromJSON(json);
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeCheckinoutUpdatetime bean = new BaseEmployeeCheckinoutUpdatetime();
		bean.setDataFromJSON(json);
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeCheckinoutUpdatetime bean = new BaseEmployeeCheckinoutUpdatetime();
		bean.setDataFromJSON(json);
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeCheckinoutUpdatetime bean = new BaseEmployeeCheckinoutUpdatetime();
		bean.setDataFromJSON(json);
		EmployeeCheckinoutUpdatetime dao = new EmployeeCheckinoutUpdatetime();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


