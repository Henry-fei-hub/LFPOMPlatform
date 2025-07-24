package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeWorkExperience;
import com.pomplatform.db.dao.EmployeeWorkExperience;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeWorkExperienceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeWorkExperienceHandler.class);

	public static BaseEmployeeWorkExperience getEmployeeWorkExperienceById( 
		java.lang.Integer employee_work_experience_id
	) throws Exception
	{
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		dao.setEmployeeWorkExperienceId(employee_work_experience_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeWorkExperienceExists( com.pomplatform.db.bean.BaseEmployeeWorkExperience bean, String additional ) throws Exception {

		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeWorkExperience( com.pomplatform.db.bean.BaseEmployeeWorkExperience bean, String additional ) throws Exception {

		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeWorkExperience> queryEmployeeWorkExperience( com.pomplatform.db.bean.BaseEmployeeWorkExperience bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeWorkExperience> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeWorkExperience> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeWorkExperience addToEmployeeWorkExperience ( BaseEmployeeWorkExperience employeeworkexperience )  throws Exception {
		return addToEmployeeWorkExperience ( employeeworkexperience , false);
	}

	public static BaseEmployeeWorkExperience addToEmployeeWorkExperience ( BaseEmployeeWorkExperience employeeworkexperience, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		dao.setDataFromBase(employeeworkexperience);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeWorkExperience addUpdateEmployeeWorkExperience ( BaseEmployeeWorkExperience employeeworkexperience ) throws Exception {
		return addUpdateEmployeeWorkExperience ( employeeworkexperience , false);
	}

	public static BaseEmployeeWorkExperience addUpdateEmployeeWorkExperience ( BaseEmployeeWorkExperience employeeworkexperience, boolean singleTransaction  ) throws Exception {
		if(employeeworkexperience.getEmployeeWorkExperienceId() == null) return addToEmployeeWorkExperience(employeeworkexperience);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		dao.setDataFromBase(employeeworkexperience);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeeworkexperience); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeWorkExperience ( BaseEmployeeWorkExperience bean ) throws Exception {
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeWorkExperience updateEmployeeWorkExperience ( BaseEmployeeWorkExperience employeeworkexperience ) throws Exception {
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		dao.setEmployeeWorkExperienceId( employeeworkexperience.getEmployeeWorkExperienceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeeworkexperience);
			result = dao.update();
		}
		return result == 1 ? employeeworkexperience : null ;
	}

	public static BaseEmployeeWorkExperience updateEmployeeWorkExperienceDirect( BaseEmployeeWorkExperience employeeworkexperience ) throws Exception {
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		int result = 0;
		dao.setDataFromBase(employeeworkexperience);
		result = dao.update();
		return result == 1 ? employeeworkexperience : null ;
	}

	public static int setDeleteConditions(BaseEmployeeWorkExperience bean, EmployeeWorkExperience dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeWorkExperienceId() != null) {
			dao.setConditionEmployeeWorkExperienceId("=", bean.getEmployeeWorkExperienceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getWorkPlace() != null) {
				dao.setConditionWorkPlace("=", bean.getWorkPlace());
				count++;
			}
			if(bean.getPosition() != null) {
				dao.setConditionPosition("=", bean.getPosition());
				count++;
			}
			if(bean.getReasonOfLeaving() != null) {
				dao.setConditionReasonOfLeaving("=", bean.getReasonOfLeaving());
				count++;
			}
			if(bean.getIsForeignCompany() != null) {
				dao.setConditionIsForeignCompany("=", bean.getIsForeignCompany());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeWorkExperience bean, EmployeeWorkExperience dao){
		int count = 0;
		if(bean.getEmployeeWorkExperienceId() != null) {
			dao.setConditionEmployeeWorkExperienceId("=", bean.getEmployeeWorkExperienceId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getWorkPlace() != null) {
			if(bean.getWorkPlace().indexOf("%") >= 0)
				dao.setConditionWorkPlace("like", bean.getWorkPlace());
			else
				dao.setConditionWorkPlace("=", bean.getWorkPlace());
			count++;
		}
		if(bean.getWorkexStartDate() != null) {
			dao.setConditionWorkexStartDate(">=", bean.getWorkexStartDate());
			count++;
		}
		if(bean.getWorkexEndDate() != null) {
			dao.setConditionWorkexEndDate(">=", bean.getWorkexEndDate());
			count++;
		}
		if(bean.getPosition() != null) {
			if(bean.getPosition().indexOf("%") >= 0)
				dao.setConditionPosition("like", bean.getPosition());
			else
				dao.setConditionPosition("=", bean.getPosition());
			count++;
		}
		if(bean.getReasonOfLeaving() != null) {
			if(bean.getReasonOfLeaving().indexOf("%") >= 0)
				dao.setConditionReasonOfLeaving("like", bean.getReasonOfLeaving());
			else
				dao.setConditionReasonOfLeaving("=", bean.getReasonOfLeaving());
			count++;
		}
		if(bean.getIsForeignCompany() != null) {
			dao.setConditionIsForeignCompany("=", bean.getIsForeignCompany());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeWorkExperience bean = new BaseEmployeeWorkExperience();
		bean.setDataFromJSON(json);
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeWorkExperience> rlist = new BaseCollection<>();
		BaseEmployeeWorkExperience bean = new BaseEmployeeWorkExperience();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeWorkExperience> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeWorkExperience bean = new BaseEmployeeWorkExperience();
		bean.setDataFromJSON(json);
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeWorkExperience bean = new BaseEmployeeWorkExperience();
		bean.setDataFromJSON(json);
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeWorkExperience bean = new BaseEmployeeWorkExperience();
		bean.setDataFromJSON(json);
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeWorkExperience bean = new BaseEmployeeWorkExperience();
		bean.setDataFromJSON(json);
		EmployeeWorkExperience dao = new EmployeeWorkExperience();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


