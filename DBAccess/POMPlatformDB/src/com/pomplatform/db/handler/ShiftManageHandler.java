package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseShiftManage;
import com.pomplatform.db.dao.ShiftManage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ShiftManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ShiftManageHandler.class);

	public static BaseShiftManage getShiftManageById( 
		java.lang.Integer shift_manage_id
	) throws Exception
	{
		ShiftManage dao = new ShiftManage();
		dao.setShiftManageId(shift_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isShiftManageExists( com.pomplatform.db.bean.BaseShiftManage bean, String additional ) throws Exception {

		ShiftManage dao = new ShiftManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countShiftManage( com.pomplatform.db.bean.BaseShiftManage bean, String additional ) throws Exception {

		ShiftManage dao = new ShiftManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseShiftManage> queryShiftManage( com.pomplatform.db.bean.BaseShiftManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ShiftManage dao = new ShiftManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseShiftManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseShiftManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseShiftManage addToShiftManage ( BaseShiftManage shiftmanage )  throws Exception {
		return addToShiftManage ( shiftmanage , false);
	}

	public static BaseShiftManage addToShiftManage ( BaseShiftManage shiftmanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ShiftManage dao = new ShiftManage();
		dao.setDataFromBase(shiftmanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseShiftManage addUpdateShiftManage ( BaseShiftManage shiftmanage ) throws Exception {
		return addUpdateShiftManage ( shiftmanage , false);
	}

	public static BaseShiftManage addUpdateShiftManage ( BaseShiftManage shiftmanage, boolean singleTransaction  ) throws Exception {
		if(shiftmanage.getShiftManageId() == null) return addToShiftManage(shiftmanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ShiftManage dao = new ShiftManage();
		dao.setDataFromBase(shiftmanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(shiftmanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteShiftManage ( BaseShiftManage bean ) throws Exception {
		ShiftManage dao = new ShiftManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseShiftManage updateShiftManage ( BaseShiftManage shiftmanage ) throws Exception {
		ShiftManage dao = new ShiftManage();
		dao.setShiftManageId( shiftmanage.getShiftManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(shiftmanage);
			result = dao.update();
		}
		return result == 1 ? shiftmanage : null ;
	}

	public static BaseShiftManage updateShiftManageDirect( BaseShiftManage shiftmanage ) throws Exception {
		ShiftManage dao = new ShiftManage();
		int result = 0;
		dao.setDataFromBase(shiftmanage);
		result = dao.update();
		return result == 1 ? shiftmanage : null ;
	}

	public static int setDeleteConditions(BaseShiftManage bean, ShiftManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getShiftManageId() != null) {
			dao.setConditionShiftManageId("=", bean.getShiftManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getShiftName() != null) {
				dao.setConditionShiftName("=", bean.getShiftName());
				count++;
			}
			if(bean.getIsEnable() != null) {
				dao.setConditionIsEnable("=", bean.getIsEnable());
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

	public static int setConditions(BaseShiftManage bean, ShiftManage dao){
		int count = 0;
		if(bean.getShiftManageId() != null) {
			dao.setConditionShiftManageId("=", bean.getShiftManageId());
			count++;
		}
		if(bean.getShiftName() != null) {
			if(bean.getShiftName().indexOf("%") >= 0)
				dao.setConditionShiftName("like", bean.getShiftName());
			else
				dao.setConditionShiftName("=", bean.getShiftName());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getIsEnable() != null) {
			dao.setConditionIsEnable("=", bean.getIsEnable());
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
		BaseShiftManage bean = new BaseShiftManage();
		bean.setDataFromJSON(json);
		ShiftManage dao = new ShiftManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseShiftManage> rlist = new BaseCollection<>();
		BaseShiftManage bean = new BaseShiftManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ShiftManage dao = new ShiftManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseShiftManage> result = dao.conditionalLoad(addtion);
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
		BaseShiftManage bean = new BaseShiftManage();
		bean.setDataFromJSON(json);
		ShiftManage dao = new ShiftManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseShiftManage bean = new BaseShiftManage();
		bean.setDataFromJSON(json);
		ShiftManage dao = new ShiftManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseShiftManage bean = new BaseShiftManage();
		bean.setDataFromJSON(json);
		ShiftManage dao = new ShiftManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseShiftManage bean = new BaseShiftManage();
		bean.setDataFromJSON(json);
		ShiftManage dao = new ShiftManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


