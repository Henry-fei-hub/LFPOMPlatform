package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseLeaveType;
import com.pomplatform.db.dao.LeaveType;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class LeaveTypeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(LeaveTypeHandler.class);

	public static BaseLeaveType getLeaveTypeById( 
		java.lang.Integer leave_type_id
	) throws Exception
	{
		LeaveType dao = new LeaveType();
		dao.setLeaveTypeId(leave_type_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isLeaveTypeExists( com.pomplatform.db.bean.BaseLeaveType bean, String additional ) throws Exception {

		LeaveType dao = new LeaveType();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countLeaveType( com.pomplatform.db.bean.BaseLeaveType bean, String additional ) throws Exception {

		LeaveType dao = new LeaveType();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseLeaveType> queryLeaveType( com.pomplatform.db.bean.BaseLeaveType bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		LeaveType dao = new LeaveType();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseLeaveType> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseLeaveType> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseLeaveType addToLeaveType ( BaseLeaveType leavetype )  throws Exception {
		return addToLeaveType ( leavetype , false);
	}

	public static BaseLeaveType addToLeaveType ( BaseLeaveType leavetype, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		LeaveType dao = new LeaveType();
		dao.setDataFromBase(leavetype);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseLeaveType addUpdateLeaveType ( BaseLeaveType leavetype ) throws Exception {
		return addUpdateLeaveType ( leavetype , false);
	}

	public static BaseLeaveType addUpdateLeaveType ( BaseLeaveType leavetype, boolean singleTransaction  ) throws Exception {
		if(leavetype.getLeaveTypeId() == null) return addToLeaveType(leavetype);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		LeaveType dao = new LeaveType();
		dao.setDataFromBase(leavetype);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(leavetype); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteLeaveType ( BaseLeaveType bean ) throws Exception {
		LeaveType dao = new LeaveType();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseLeaveType updateLeaveType ( BaseLeaveType leavetype ) throws Exception {
		LeaveType dao = new LeaveType();
		dao.setLeaveTypeId( leavetype.getLeaveTypeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(leavetype);
			result = dao.update();
		}
		return result == 1 ? leavetype : null ;
	}

	public static BaseLeaveType updateLeaveTypeDirect( BaseLeaveType leavetype ) throws Exception {
		LeaveType dao = new LeaveType();
		int result = 0;
		dao.setDataFromBase(leavetype);
		result = dao.update();
		return result == 1 ? leavetype : null ;
	}

	public static int setDeleteConditions(BaseLeaveType bean, LeaveType dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getLeaveTypeId() != null) {
			dao.setConditionLeaveTypeId("=", bean.getLeaveTypeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getLeaveTypeName() != null) {
				dao.setConditionLeaveTypeName("=", bean.getLeaveTypeName());
				count++;
			}
			if(bean.getGender() != null) {
				dao.setConditionGender("=", bean.getGender());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getIsEnable() != null) {
				dao.setConditionIsEnable("=", bean.getIsEnable());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseLeaveType bean, LeaveType dao){
		int count = 0;
		if(bean.getLeaveTypeId() != null) {
			dao.setConditionLeaveTypeId("=", bean.getLeaveTypeId());
			count++;
		}
		if(bean.getLeaveTypeName() != null) {
			if(bean.getLeaveTypeName().indexOf("%") >= 0)
				dao.setConditionLeaveTypeName("like", bean.getLeaveTypeName());
			else
				dao.setConditionLeaveTypeName("=", bean.getLeaveTypeName());
			count++;
		}
		if(bean.getGender() != null) {
			dao.setConditionGender("=", bean.getGender());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getIsEnable() != null) {
			dao.setConditionIsEnable("=", bean.getIsEnable());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseLeaveType bean = new BaseLeaveType();
		bean.setDataFromJSON(json);
		LeaveType dao = new LeaveType();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseLeaveType> rlist = new BaseCollection<>();
		BaseLeaveType bean = new BaseLeaveType();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		LeaveType dao = new LeaveType();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseLeaveType> result = dao.conditionalLoad(addtion);
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
		BaseLeaveType bean = new BaseLeaveType();
		bean.setDataFromJSON(json);
		LeaveType dao = new LeaveType();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseLeaveType bean = new BaseLeaveType();
		bean.setDataFromJSON(json);
		LeaveType dao = new LeaveType();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseLeaveType bean = new BaseLeaveType();
		bean.setDataFromJSON(json);
		LeaveType dao = new LeaveType();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseLeaveType bean = new BaseLeaveType();
		bean.setDataFromJSON(json);
		LeaveType dao = new LeaveType();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


