package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeChangePlateDetail;
import com.pomplatform.db.dao.EmployeeChangePlateDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeChangePlateDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeChangePlateDetailHandler.class);

	public static BaseEmployeeChangePlateDetail getEmployeeChangePlateDetailById( 
		java.lang.Integer employee_change_plate_detail_id
	) throws Exception
	{
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		dao.setEmployeeChangePlateDetailId(employee_change_plate_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeChangePlateDetailExists( com.pomplatform.db.bean.BaseEmployeeChangePlateDetail bean, String additional ) throws Exception {

		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeChangePlateDetail( com.pomplatform.db.bean.BaseEmployeeChangePlateDetail bean, String additional ) throws Exception {

		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeChangePlateDetail> queryEmployeeChangePlateDetail( com.pomplatform.db.bean.BaseEmployeeChangePlateDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeChangePlateDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeChangePlateDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeChangePlateDetail addToEmployeeChangePlateDetail ( BaseEmployeeChangePlateDetail employeechangeplatedetail )  throws Exception {
		return addToEmployeeChangePlateDetail ( employeechangeplatedetail , false);
	}

	public static BaseEmployeeChangePlateDetail addToEmployeeChangePlateDetail ( BaseEmployeeChangePlateDetail employeechangeplatedetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		dao.setDataFromBase(employeechangeplatedetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeChangePlateDetail addUpdateEmployeeChangePlateDetail ( BaseEmployeeChangePlateDetail employeechangeplatedetail ) throws Exception {
		return addUpdateEmployeeChangePlateDetail ( employeechangeplatedetail , false);
	}

	public static BaseEmployeeChangePlateDetail addUpdateEmployeeChangePlateDetail ( BaseEmployeeChangePlateDetail employeechangeplatedetail, boolean singleTransaction  ) throws Exception {
		if(employeechangeplatedetail.getEmployeeChangePlateDetailId() == null) return addToEmployeeChangePlateDetail(employeechangeplatedetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		dao.setDataFromBase(employeechangeplatedetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeechangeplatedetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeChangePlateDetail ( BaseEmployeeChangePlateDetail bean ) throws Exception {
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeChangePlateDetail updateEmployeeChangePlateDetail ( BaseEmployeeChangePlateDetail employeechangeplatedetail ) throws Exception {
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		dao.setEmployeeChangePlateDetailId( employeechangeplatedetail.getEmployeeChangePlateDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeechangeplatedetail);
			result = dao.update();
		}
		return result == 1 ? employeechangeplatedetail : null ;
	}

	public static BaseEmployeeChangePlateDetail updateEmployeeChangePlateDetailDirect( BaseEmployeeChangePlateDetail employeechangeplatedetail ) throws Exception {
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		int result = 0;
		dao.setDataFromBase(employeechangeplatedetail);
		result = dao.update();
		return result == 1 ? employeechangeplatedetail : null ;
	}

	public static int setDeleteConditions(BaseEmployeeChangePlateDetail bean, EmployeeChangePlateDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeChangePlateDetailId() != null) {
			dao.setConditionEmployeeChangePlateDetailId("=", bean.getEmployeeChangePlateDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
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
			if(bean.getOutPlateId() != null) {
				dao.setConditionOutPlateId("=", bean.getOutPlateId());
				count++;
			}
			if(bean.getInPlateId() != null) {
				dao.setConditionInPlateId("=", bean.getInPlateId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeChangePlateDetail bean, EmployeeChangePlateDetail dao){
		int count = 0;
		if(bean.getEmployeeChangePlateDetailId() != null) {
			dao.setConditionEmployeeChangePlateDetailId("=", bean.getEmployeeChangePlateDetailId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
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
		if(bean.getOutPlateId() != null) {
			dao.setConditionOutPlateId("=", bean.getOutPlateId());
			count++;
		}
		if(bean.getInPlateId() != null) {
			dao.setConditionInPlateId("=", bean.getInPlateId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
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
		if(bean.getChangePlateDate() != null) {
			dao.setConditionChangePlateDate(">=", bean.getChangePlateDate());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeChangePlateDetail bean = new BaseEmployeeChangePlateDetail();
		bean.setDataFromJSON(json);
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeChangePlateDetail> rlist = new BaseCollection<>();
		BaseEmployeeChangePlateDetail bean = new BaseEmployeeChangePlateDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeChangePlateDetail> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeChangePlateDetail bean = new BaseEmployeeChangePlateDetail();
		bean.setDataFromJSON(json);
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeChangePlateDetail bean = new BaseEmployeeChangePlateDetail();
		bean.setDataFromJSON(json);
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeChangePlateDetail bean = new BaseEmployeeChangePlateDetail();
		bean.setDataFromJSON(json);
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeChangePlateDetail bean = new BaseEmployeeChangePlateDetail();
		bean.setDataFromJSON(json);
		EmployeeChangePlateDetail dao = new EmployeeChangePlateDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


