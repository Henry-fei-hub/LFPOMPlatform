package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeRewardExperience;
import com.pomplatform.db.dao.EmployeeRewardExperience;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeRewardExperienceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeRewardExperienceHandler.class);

	public static BaseEmployeeRewardExperience getEmployeeRewardExperienceById( 
		java.lang.Integer employee_reward_experience_id
	) throws Exception
	{
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		dao.setEmployeeRewardExperienceId(employee_reward_experience_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeRewardExperienceExists( com.pomplatform.db.bean.BaseEmployeeRewardExperience bean, String additional ) throws Exception {

		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeRewardExperience( com.pomplatform.db.bean.BaseEmployeeRewardExperience bean, String additional ) throws Exception {

		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeRewardExperience> queryEmployeeRewardExperience( com.pomplatform.db.bean.BaseEmployeeRewardExperience bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeRewardExperience> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeRewardExperience> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeRewardExperience addToEmployeeRewardExperience ( BaseEmployeeRewardExperience employeerewardexperience )  throws Exception {
		return addToEmployeeRewardExperience ( employeerewardexperience , false);
	}

	public static BaseEmployeeRewardExperience addToEmployeeRewardExperience ( BaseEmployeeRewardExperience employeerewardexperience, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		dao.setDataFromBase(employeerewardexperience);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeRewardExperience addUpdateEmployeeRewardExperience ( BaseEmployeeRewardExperience employeerewardexperience ) throws Exception {
		return addUpdateEmployeeRewardExperience ( employeerewardexperience , false);
	}

	public static BaseEmployeeRewardExperience addUpdateEmployeeRewardExperience ( BaseEmployeeRewardExperience employeerewardexperience, boolean singleTransaction  ) throws Exception {
		if(employeerewardexperience.getEmployeeRewardExperienceId() == null) return addToEmployeeRewardExperience(employeerewardexperience);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		dao.setDataFromBase(employeerewardexperience);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeerewardexperience); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeRewardExperience ( BaseEmployeeRewardExperience bean ) throws Exception {
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeRewardExperience updateEmployeeRewardExperience ( BaseEmployeeRewardExperience employeerewardexperience ) throws Exception {
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		dao.setEmployeeRewardExperienceId( employeerewardexperience.getEmployeeRewardExperienceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeerewardexperience);
			result = dao.update();
		}
		return result == 1 ? employeerewardexperience : null ;
	}

	public static BaseEmployeeRewardExperience updateEmployeeRewardExperienceDirect( BaseEmployeeRewardExperience employeerewardexperience ) throws Exception {
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		int result = 0;
		dao.setDataFromBase(employeerewardexperience);
		result = dao.update();
		return result == 1 ? employeerewardexperience : null ;
	}

	public static int setDeleteConditions(BaseEmployeeRewardExperience bean, EmployeeRewardExperience dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeRewardExperienceId() != null) {
			dao.setConditionEmployeeRewardExperienceId("=", bean.getEmployeeRewardExperienceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getRewardName() != null) {
				dao.setConditionRewardName("=", bean.getRewardName());
				count++;
			}
			if(bean.getRewardDescription() != null) {
				dao.setConditionRewardDescription("=", bean.getRewardDescription());
				count++;
			}
			if(bean.getRewardUnit() != null) {
				dao.setConditionRewardUnit("=", bean.getRewardUnit());
				count++;
			}
			if(bean.getAttachment() != null) {
				dao.setConditionAttachment("=", bean.getAttachment());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeRewardExperience bean, EmployeeRewardExperience dao){
		int count = 0;
		if(bean.getEmployeeRewardExperienceId() != null) {
			dao.setConditionEmployeeRewardExperienceId("=", bean.getEmployeeRewardExperienceId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getRewardName() != null) {
			if(bean.getRewardName().indexOf("%") >= 0)
				dao.setConditionRewardName("like", bean.getRewardName());
			else
				dao.setConditionRewardName("=", bean.getRewardName());
			count++;
		}
		if(bean.getRewardDescription() != null) {
			if(bean.getRewardDescription().indexOf("%") >= 0)
				dao.setConditionRewardDescription("like", bean.getRewardDescription());
			else
				dao.setConditionRewardDescription("=", bean.getRewardDescription());
			count++;
		}
		if(bean.getRewardDate() != null) {
			dao.setConditionRewardDate(">=", bean.getRewardDate());
			count++;
		}
		if(bean.getRewardUnit() != null) {
			if(bean.getRewardUnit().indexOf("%") >= 0)
				dao.setConditionRewardUnit("like", bean.getRewardUnit());
			else
				dao.setConditionRewardUnit("=", bean.getRewardUnit());
			count++;
		}
		if(bean.getAttachment() != null) {
			if(bean.getAttachment().indexOf("%") >= 0)
				dao.setConditionAttachment("like", bean.getAttachment());
			else
				dao.setConditionAttachment("=", bean.getAttachment());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeRewardExperience bean = new BaseEmployeeRewardExperience();
		bean.setDataFromJSON(json);
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeRewardExperience> rlist = new BaseCollection<>();
		BaseEmployeeRewardExperience bean = new BaseEmployeeRewardExperience();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeRewardExperience> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeRewardExperience bean = new BaseEmployeeRewardExperience();
		bean.setDataFromJSON(json);
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeRewardExperience bean = new BaseEmployeeRewardExperience();
		bean.setDataFromJSON(json);
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeRewardExperience bean = new BaseEmployeeRewardExperience();
		bean.setDataFromJSON(json);
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeRewardExperience bean = new BaseEmployeeRewardExperience();
		bean.setDataFromJSON(json);
		EmployeeRewardExperience dao = new EmployeeRewardExperience();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


