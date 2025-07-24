package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseShiftTimeManage;
import com.pomplatform.db.dao.ShiftTimeManage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ShiftTimeManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ShiftTimeManageHandler.class);

	public static BaseShiftTimeManage getShiftTimeManageById( 
		java.lang.Integer shift_time_manage_id
	) throws Exception
	{
		ShiftTimeManage dao = new ShiftTimeManage();
		dao.setShiftTimeManageId(shift_time_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isShiftTimeManageExists( com.pomplatform.db.bean.BaseShiftTimeManage bean, String additional ) throws Exception {

		ShiftTimeManage dao = new ShiftTimeManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countShiftTimeManage( com.pomplatform.db.bean.BaseShiftTimeManage bean, String additional ) throws Exception {

		ShiftTimeManage dao = new ShiftTimeManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseShiftTimeManage> queryShiftTimeManage( com.pomplatform.db.bean.BaseShiftTimeManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ShiftTimeManage dao = new ShiftTimeManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseShiftTimeManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseShiftTimeManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseShiftTimeManage addToShiftTimeManage ( BaseShiftTimeManage shifttimemanage )  throws Exception {
		return addToShiftTimeManage ( shifttimemanage , false);
	}

	public static BaseShiftTimeManage addToShiftTimeManage ( BaseShiftTimeManage shifttimemanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ShiftTimeManage dao = new ShiftTimeManage();
		dao.setDataFromBase(shifttimemanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseShiftTimeManage addUpdateShiftTimeManage ( BaseShiftTimeManage shifttimemanage ) throws Exception {
		return addUpdateShiftTimeManage ( shifttimemanage , false);
	}

	public static BaseShiftTimeManage addUpdateShiftTimeManage ( BaseShiftTimeManage shifttimemanage, boolean singleTransaction  ) throws Exception {
		if(shifttimemanage.getShiftTimeManageId() == null) return addToShiftTimeManage(shifttimemanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ShiftTimeManage dao = new ShiftTimeManage();
		dao.setDataFromBase(shifttimemanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(shifttimemanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteShiftTimeManage ( BaseShiftTimeManage bean ) throws Exception {
		ShiftTimeManage dao = new ShiftTimeManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseShiftTimeManage updateShiftTimeManage ( BaseShiftTimeManage shifttimemanage ) throws Exception {
		ShiftTimeManage dao = new ShiftTimeManage();
		dao.setShiftTimeManageId( shifttimemanage.getShiftTimeManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(shifttimemanage);
			result = dao.update();
		}
		return result == 1 ? shifttimemanage : null ;
	}

	public static BaseShiftTimeManage updateShiftTimeManageDirect( BaseShiftTimeManage shifttimemanage ) throws Exception {
		ShiftTimeManage dao = new ShiftTimeManage();
		int result = 0;
		dao.setDataFromBase(shifttimemanage);
		result = dao.update();
		return result == 1 ? shifttimemanage : null ;
	}

	public static int setDeleteConditions(BaseShiftTimeManage bean, ShiftTimeManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getShiftTimeManageId() != null) {
			dao.setConditionShiftTimeManageId("=", bean.getShiftTimeManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getShiftTimeName() != null) {
				dao.setConditionShiftTimeName("=", bean.getShiftTimeName());
				count++;
			}
			if(bean.getCheckSignIn() != null) {
				dao.setConditionCheckSignIn("=", bean.getCheckSignIn());
				count++;
			}
			if(bean.getSignInTime() != null) {
				dao.setConditionSignInTime("=", bean.getSignInTime());
				count++;
			}
			if(bean.getCheckSignOff() != null) {
				dao.setConditionCheckSignOff("=", bean.getCheckSignOff());
				count++;
			}
			if(bean.getSignOffTime() != null) {
				dao.setConditionSignOffTime("=", bean.getSignOffTime());
				count++;
			}
			if(bean.getLateMinutes() != null) {
				dao.setConditionLateMinutes("=", bean.getLateMinutes());
				count++;
			}
			if(bean.getLeaveEarlyTime() != null) {
				dao.setConditionLeaveEarlyTime("=", bean.getLeaveEarlyTime());
				count++;
			}
			if(bean.getSignInStartTime() != null) {
				dao.setConditionSignInStartTime("=", bean.getSignInStartTime());
				count++;
			}
			if(bean.getSignInEndTime() != null) {
				dao.setConditionSignInEndTime("=", bean.getSignInEndTime());
				count++;
			}
			if(bean.getSignOffStartTime() != null) {
				dao.setConditionSignOffStartTime("=", bean.getSignOffStartTime());
				count++;
			}
			if(bean.getSignOffEndTime() != null) {
				dao.setConditionSignOffEndTime("=", bean.getSignOffEndTime());
				count++;
			}
			if(bean.getMinutes() != null) {
				dao.setConditionMinutes("=", bean.getMinutes());
				count++;
			}
			if(bean.getOvertimeStartTime() != null) {
				dao.setConditionOvertimeStartTime("=", bean.getOvertimeStartTime());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseShiftTimeManage bean, ShiftTimeManage dao){
		int count = 0;
		if(bean.getShiftTimeManageId() != null) {
			dao.setConditionShiftTimeManageId("=", bean.getShiftTimeManageId());
			count++;
		}
		if(bean.getShiftTimeName() != null) {
			if(bean.getShiftTimeName().indexOf("%") >= 0)
				dao.setConditionShiftTimeName("like", bean.getShiftTimeName());
			else
				dao.setConditionShiftTimeName("=", bean.getShiftTimeName());
			count++;
		}
		if(bean.getCheckSignIn() != null) {
			dao.setConditionCheckSignIn("=", bean.getCheckSignIn());
			count++;
		}
		if(bean.getSignInTime() != null) {
			if(bean.getSignInTime().indexOf("%") >= 0)
				dao.setConditionSignInTime("like", bean.getSignInTime());
			else
				dao.setConditionSignInTime("=", bean.getSignInTime());
			count++;
		}
		if(bean.getCheckSignOff() != null) {
			dao.setConditionCheckSignOff("=", bean.getCheckSignOff());
			count++;
		}
		if(bean.getSignOffTime() != null) {
			if(bean.getSignOffTime().indexOf("%") >= 0)
				dao.setConditionSignOffTime("like", bean.getSignOffTime());
			else
				dao.setConditionSignOffTime("=", bean.getSignOffTime());
			count++;
		}
		if(bean.getLateMinutes() != null) {
			dao.setConditionLateMinutes("=", bean.getLateMinutes());
			count++;
		}
		if(bean.getLeaveEarlyTime() != null) {
			dao.setConditionLeaveEarlyTime("=", bean.getLeaveEarlyTime());
			count++;
		}
		if(bean.getSignInStartTime() != null) {
			if(bean.getSignInStartTime().indexOf("%") >= 0)
				dao.setConditionSignInStartTime("like", bean.getSignInStartTime());
			else
				dao.setConditionSignInStartTime("=", bean.getSignInStartTime());
			count++;
		}
		if(bean.getSignInEndTime() != null) {
			if(bean.getSignInEndTime().indexOf("%") >= 0)
				dao.setConditionSignInEndTime("like", bean.getSignInEndTime());
			else
				dao.setConditionSignInEndTime("=", bean.getSignInEndTime());
			count++;
		}
		if(bean.getSignOffStartTime() != null) {
			if(bean.getSignOffStartTime().indexOf("%") >= 0)
				dao.setConditionSignOffStartTime("like", bean.getSignOffStartTime());
			else
				dao.setConditionSignOffStartTime("=", bean.getSignOffStartTime());
			count++;
		}
		if(bean.getSignOffEndTime() != null) {
			if(bean.getSignOffEndTime().indexOf("%") >= 0)
				dao.setConditionSignOffEndTime("like", bean.getSignOffEndTime());
			else
				dao.setConditionSignOffEndTime("=", bean.getSignOffEndTime());
			count++;
		}
		if(bean.getDays() != null) {
			dao.setConditionDays("=", bean.getDays());
			count++;
		}
		if(bean.getMinutes() != null) {
			dao.setConditionMinutes("=", bean.getMinutes());
			count++;
		}
		if(bean.getOvertimeStartTime() != null) {
			if(bean.getOvertimeStartTime().indexOf("%") >= 0)
				dao.setConditionOvertimeStartTime("like", bean.getOvertimeStartTime());
			else
				dao.setConditionOvertimeStartTime("=", bean.getOvertimeStartTime());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseShiftTimeManage bean = new BaseShiftTimeManage();
		bean.setDataFromJSON(json);
		ShiftTimeManage dao = new ShiftTimeManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseShiftTimeManage> rlist = new BaseCollection<>();
		BaseShiftTimeManage bean = new BaseShiftTimeManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ShiftTimeManage dao = new ShiftTimeManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseShiftTimeManage> result = dao.conditionalLoad(addtion);
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
		BaseShiftTimeManage bean = new BaseShiftTimeManage();
		bean.setDataFromJSON(json);
		ShiftTimeManage dao = new ShiftTimeManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseShiftTimeManage bean = new BaseShiftTimeManage();
		bean.setDataFromJSON(json);
		ShiftTimeManage dao = new ShiftTimeManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseShiftTimeManage bean = new BaseShiftTimeManage();
		bean.setDataFromJSON(json);
		ShiftTimeManage dao = new ShiftTimeManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseShiftTimeManage bean = new BaseShiftTimeManage();
		bean.setDataFromJSON(json);
		ShiftTimeManage dao = new ShiftTimeManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


