package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeShiftManage;
import com.pomplatform.db.dao.EmployeeShiftManage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeShiftManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeShiftManageHandler.class);

	public static BaseEmployeeShiftManage getEmployeeShiftManageById( 
		java.lang.Integer employee_shift_manage_id
	) throws Exception
	{
		EmployeeShiftManage dao = new EmployeeShiftManage();
		dao.setEmployeeShiftManageId(employee_shift_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeShiftManageExists( com.pomplatform.db.bean.BaseEmployeeShiftManage bean, String additional ) throws Exception {

		EmployeeShiftManage dao = new EmployeeShiftManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeShiftManage( com.pomplatform.db.bean.BaseEmployeeShiftManage bean, String additional ) throws Exception {

		EmployeeShiftManage dao = new EmployeeShiftManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeShiftManage> queryEmployeeShiftManage( com.pomplatform.db.bean.BaseEmployeeShiftManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeShiftManage dao = new EmployeeShiftManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeShiftManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeShiftManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeShiftManage addToEmployeeShiftManage ( BaseEmployeeShiftManage employeeshiftmanage )  throws Exception {
		return addToEmployeeShiftManage ( employeeshiftmanage , false);
	}

	public static BaseEmployeeShiftManage addToEmployeeShiftManage ( BaseEmployeeShiftManage employeeshiftmanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeShiftManage dao = new EmployeeShiftManage();
		dao.setDataFromBase(employeeshiftmanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeShiftManage addUpdateEmployeeShiftManage ( BaseEmployeeShiftManage employeeshiftmanage ) throws Exception {
		return addUpdateEmployeeShiftManage ( employeeshiftmanage , false);
	}

	public static BaseEmployeeShiftManage addUpdateEmployeeShiftManage ( BaseEmployeeShiftManage employeeshiftmanage, boolean singleTransaction  ) throws Exception {
		if(employeeshiftmanage.getEmployeeShiftManageId() == null) return addToEmployeeShiftManage(employeeshiftmanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeShiftManage dao = new EmployeeShiftManage();
		dao.setDataFromBase(employeeshiftmanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeeshiftmanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeShiftManage ( BaseEmployeeShiftManage bean ) throws Exception {
		EmployeeShiftManage dao = new EmployeeShiftManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeShiftManage updateEmployeeShiftManage ( BaseEmployeeShiftManage employeeshiftmanage ) throws Exception {
		EmployeeShiftManage dao = new EmployeeShiftManage();
		dao.setEmployeeShiftManageId( employeeshiftmanage.getEmployeeShiftManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeeshiftmanage);
			result = dao.update();
		}
		return result == 1 ? employeeshiftmanage : null ;
	}

	public static BaseEmployeeShiftManage updateEmployeeShiftManageDirect( BaseEmployeeShiftManage employeeshiftmanage ) throws Exception {
		EmployeeShiftManage dao = new EmployeeShiftManage();
		int result = 0;
		dao.setDataFromBase(employeeshiftmanage);
		result = dao.update();
		return result == 1 ? employeeshiftmanage : null ;
	}

	public static int setDeleteConditions(BaseEmployeeShiftManage bean, EmployeeShiftManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeShiftManageId() != null) {
			dao.setConditionEmployeeShiftManageId("=", bean.getEmployeeShiftManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getShiftManageId() != null) {
				dao.setConditionShiftManageId("=", bean.getShiftManageId());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
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

	public static int setConditions(BaseEmployeeShiftManage bean, EmployeeShiftManage dao){
		int count = 0;
		if(bean.getEmployeeShiftManageId() != null) {
			dao.setConditionEmployeeShiftManageId("=", bean.getEmployeeShiftManageId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getShiftManageId() != null) {
			dao.setConditionShiftManageId("=", bean.getShiftManageId());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
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
		BaseEmployeeShiftManage bean = new BaseEmployeeShiftManage();
		bean.setDataFromJSON(json);
		EmployeeShiftManage dao = new EmployeeShiftManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeShiftManage> rlist = new BaseCollection<>();
		BaseEmployeeShiftManage bean = new BaseEmployeeShiftManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeShiftManage dao = new EmployeeShiftManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeShiftManage> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeShiftManage bean = new BaseEmployeeShiftManage();
		bean.setDataFromJSON(json);
		EmployeeShiftManage dao = new EmployeeShiftManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeShiftManage bean = new BaseEmployeeShiftManage();
		bean.setDataFromJSON(json);
		EmployeeShiftManage dao = new EmployeeShiftManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeShiftManage bean = new BaseEmployeeShiftManage();
		bean.setDataFromJSON(json);
		EmployeeShiftManage dao = new EmployeeShiftManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeShiftManage bean = new BaseEmployeeShiftManage();
		bean.setDataFromJSON(json);
		EmployeeShiftManage dao = new EmployeeShiftManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


