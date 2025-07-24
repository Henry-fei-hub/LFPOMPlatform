package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeCheckinoutDetail;
import com.pomplatform.db.dao.EmployeeCheckinoutDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeCheckinoutDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeCheckinoutDetailHandler.class);

	public static BaseEmployeeCheckinoutDetail getEmployeeCheckinoutDetailById( 
		java.lang.Integer employee_checkinout_detail_id
	) throws Exception
	{
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		dao.setEmployeeCheckinoutDetailId(employee_checkinout_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeCheckinoutDetailExists( com.pomplatform.db.bean.BaseEmployeeCheckinoutDetail bean, String additional ) throws Exception {

		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeCheckinoutDetail( com.pomplatform.db.bean.BaseEmployeeCheckinoutDetail bean, String additional ) throws Exception {

		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeCheckinoutDetail> queryEmployeeCheckinoutDetail( com.pomplatform.db.bean.BaseEmployeeCheckinoutDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeCheckinoutDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeCheckinoutDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeCheckinoutDetail addToEmployeeCheckinoutDetail ( BaseEmployeeCheckinoutDetail employeecheckinoutdetail )  throws Exception {
		return addToEmployeeCheckinoutDetail ( employeecheckinoutdetail , false);
	}

	public static BaseEmployeeCheckinoutDetail addToEmployeeCheckinoutDetail ( BaseEmployeeCheckinoutDetail employeecheckinoutdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		dao.setDataFromBase(employeecheckinoutdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeCheckinoutDetail addUpdateEmployeeCheckinoutDetail ( BaseEmployeeCheckinoutDetail employeecheckinoutdetail ) throws Exception {
		return addUpdateEmployeeCheckinoutDetail ( employeecheckinoutdetail , false);
	}

	public static BaseEmployeeCheckinoutDetail addUpdateEmployeeCheckinoutDetail ( BaseEmployeeCheckinoutDetail employeecheckinoutdetail, boolean singleTransaction  ) throws Exception {
		if(employeecheckinoutdetail.getEmployeeCheckinoutDetailId() == null) return addToEmployeeCheckinoutDetail(employeecheckinoutdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		dao.setDataFromBase(employeecheckinoutdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeecheckinoutdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeCheckinoutDetail ( BaseEmployeeCheckinoutDetail bean ) throws Exception {
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeCheckinoutDetail updateEmployeeCheckinoutDetail ( BaseEmployeeCheckinoutDetail employeecheckinoutdetail ) throws Exception {
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		dao.setEmployeeCheckinoutDetailId( employeecheckinoutdetail.getEmployeeCheckinoutDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeecheckinoutdetail);
			result = dao.update();
		}
		return result == 1 ? employeecheckinoutdetail : null ;
	}

	public static BaseEmployeeCheckinoutDetail updateEmployeeCheckinoutDetailDirect( BaseEmployeeCheckinoutDetail employeecheckinoutdetail ) throws Exception {
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		int result = 0;
		dao.setDataFromBase(employeecheckinoutdetail);
		result = dao.update();
		return result == 1 ? employeecheckinoutdetail : null ;
	}

	public static int setDeleteConditions(BaseEmployeeCheckinoutDetail bean, EmployeeCheckinoutDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeCheckinoutDetailId() != null) {
			dao.setConditionEmployeeCheckinoutDetailId("=", bean.getEmployeeCheckinoutDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getOaEmployeeId() != null) {
				dao.setConditionOaEmployeeId("=", bean.getOaEmployeeId());
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

	public static int setConditions(BaseEmployeeCheckinoutDetail bean, EmployeeCheckinoutDetail dao){
		int count = 0;
		if(bean.getEmployeeCheckinoutDetailId() != null) {
			dao.setConditionEmployeeCheckinoutDetailId("=", bean.getEmployeeCheckinoutDetailId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getCheckDate() != null) {
			dao.setConditionCheckDate(">=", bean.getCheckDate());
			count++;
		}
		if(bean.getCheckTime() != null) {
			dao.setConditionCheckTime(">=", bean.getCheckTime());
			count++;
		}
		if(bean.getOaEmployeeId() != null) {
			dao.setConditionOaEmployeeId("=", bean.getOaEmployeeId());
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
		BaseEmployeeCheckinoutDetail bean = new BaseEmployeeCheckinoutDetail();
		bean.setDataFromJSON(json);
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeCheckinoutDetail> rlist = new BaseCollection<>();
		BaseEmployeeCheckinoutDetail bean = new BaseEmployeeCheckinoutDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeCheckinoutDetail> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeCheckinoutDetail bean = new BaseEmployeeCheckinoutDetail();
		bean.setDataFromJSON(json);
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeCheckinoutDetail bean = new BaseEmployeeCheckinoutDetail();
		bean.setDataFromJSON(json);
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeCheckinoutDetail bean = new BaseEmployeeCheckinoutDetail();
		bean.setDataFromJSON(json);
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeCheckinoutDetail bean = new BaseEmployeeCheckinoutDetail();
		bean.setDataFromJSON(json);
		EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


