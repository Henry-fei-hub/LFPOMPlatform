package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseLeaveTypeLinkProvince;
import com.pomplatform.db.dao.LeaveTypeLinkProvince;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class LeaveTypeLinkProvinceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(LeaveTypeLinkProvinceHandler.class);

	public static BaseLeaveTypeLinkProvince getLeaveTypeLinkProvinceById( 
		java.lang.Integer leave_type_link_province_id
	) throws Exception
	{
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		dao.setLeaveTypeLinkProvinceId(leave_type_link_province_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isLeaveTypeLinkProvinceExists( com.pomplatform.db.bean.BaseLeaveTypeLinkProvince bean, String additional ) throws Exception {

		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countLeaveTypeLinkProvince( com.pomplatform.db.bean.BaseLeaveTypeLinkProvince bean, String additional ) throws Exception {

		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseLeaveTypeLinkProvince> queryLeaveTypeLinkProvince( com.pomplatform.db.bean.BaseLeaveTypeLinkProvince bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseLeaveTypeLinkProvince> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseLeaveTypeLinkProvince> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseLeaveTypeLinkProvince addToLeaveTypeLinkProvince ( BaseLeaveTypeLinkProvince leavetypelinkprovince )  throws Exception {
		return addToLeaveTypeLinkProvince ( leavetypelinkprovince , false);
	}

	public static BaseLeaveTypeLinkProvince addToLeaveTypeLinkProvince ( BaseLeaveTypeLinkProvince leavetypelinkprovince, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		dao.setDataFromBase(leavetypelinkprovince);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseLeaveTypeLinkProvince addUpdateLeaveTypeLinkProvince ( BaseLeaveTypeLinkProvince leavetypelinkprovince ) throws Exception {
		return addUpdateLeaveTypeLinkProvince ( leavetypelinkprovince , false);
	}

	public static BaseLeaveTypeLinkProvince addUpdateLeaveTypeLinkProvince ( BaseLeaveTypeLinkProvince leavetypelinkprovince, boolean singleTransaction  ) throws Exception {
		if(leavetypelinkprovince.getLeaveTypeLinkProvinceId() == null) return addToLeaveTypeLinkProvince(leavetypelinkprovince);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		dao.setDataFromBase(leavetypelinkprovince);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(leavetypelinkprovince); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteLeaveTypeLinkProvince ( BaseLeaveTypeLinkProvince bean ) throws Exception {
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseLeaveTypeLinkProvince updateLeaveTypeLinkProvince ( BaseLeaveTypeLinkProvince leavetypelinkprovince ) throws Exception {
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		dao.setLeaveTypeLinkProvinceId( leavetypelinkprovince.getLeaveTypeLinkProvinceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(leavetypelinkprovince);
			result = dao.update();
		}
		return result == 1 ? leavetypelinkprovince : null ;
	}

	public static BaseLeaveTypeLinkProvince updateLeaveTypeLinkProvinceDirect( BaseLeaveTypeLinkProvince leavetypelinkprovince ) throws Exception {
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		int result = 0;
		dao.setDataFromBase(leavetypelinkprovince);
		result = dao.update();
		return result == 1 ? leavetypelinkprovince : null ;
	}

	public static int setDeleteConditions(BaseLeaveTypeLinkProvince bean, LeaveTypeLinkProvince dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getLeaveTypeLinkProvinceId() != null) {
			dao.setConditionLeaveTypeLinkProvinceId("=", bean.getLeaveTypeLinkProvinceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getLeaveTypeId() != null) {
				dao.setConditionLeaveTypeId("=", bean.getLeaveTypeId());
				count++;
			}
			if(bean.getProvinceId() != null) {
				dao.setConditionProvinceId("=", bean.getProvinceId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getIsEnable() != null) {
				dao.setConditionIsEnable("=", bean.getIsEnable());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseLeaveTypeLinkProvince bean, LeaveTypeLinkProvince dao){
		int count = 0;
		if(bean.getLeaveTypeLinkProvinceId() != null) {
			dao.setConditionLeaveTypeLinkProvinceId("=", bean.getLeaveTypeLinkProvinceId());
			count++;
		}
		if(bean.getLeaveTypeId() != null) {
			dao.setConditionLeaveTypeId("=", bean.getLeaveTypeId());
			count++;
		}
		if(bean.getProvinceId() != null) {
			dao.setConditionProvinceId("=", bean.getProvinceId());
			count++;
		}
		if(bean.getDays() != null) {
			dao.setConditionDays("=", bean.getDays());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
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
		BaseLeaveTypeLinkProvince bean = new BaseLeaveTypeLinkProvince();
		bean.setDataFromJSON(json);
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseLeaveTypeLinkProvince> rlist = new BaseCollection<>();
		BaseLeaveTypeLinkProvince bean = new BaseLeaveTypeLinkProvince();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseLeaveTypeLinkProvince> result = dao.conditionalLoad(addtion);
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
		BaseLeaveTypeLinkProvince bean = new BaseLeaveTypeLinkProvince();
		bean.setDataFromJSON(json);
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseLeaveTypeLinkProvince bean = new BaseLeaveTypeLinkProvince();
		bean.setDataFromJSON(json);
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseLeaveTypeLinkProvince bean = new BaseLeaveTypeLinkProvince();
		bean.setDataFromJSON(json);
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseLeaveTypeLinkProvince bean = new BaseLeaveTypeLinkProvince();
		bean.setDataFromJSON(json);
		LeaveTypeLinkProvince dao = new LeaveTypeLinkProvince();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


