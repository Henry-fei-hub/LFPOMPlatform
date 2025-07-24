package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeEducationInformation;
import com.pomplatform.db.dao.EmployeeEducationInformation;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeEducationInformationHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeEducationInformationHandler.class);

	public static BaseEmployeeEducationInformation getEmployeeEducationInformationById( 
		java.lang.Integer employee_education_information_id
	) throws Exception
	{
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		dao.setEmployeeEducationInformationId(employee_education_information_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeEducationInformationExists( com.pomplatform.db.bean.BaseEmployeeEducationInformation bean, String additional ) throws Exception {

		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeEducationInformation( com.pomplatform.db.bean.BaseEmployeeEducationInformation bean, String additional ) throws Exception {

		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeEducationInformation> queryEmployeeEducationInformation( com.pomplatform.db.bean.BaseEmployeeEducationInformation bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeEducationInformation> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeEducationInformation> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeEducationInformation addToEmployeeEducationInformation ( BaseEmployeeEducationInformation employeeeducationinformation )  throws Exception {
		return addToEmployeeEducationInformation ( employeeeducationinformation , false);
	}

	public static BaseEmployeeEducationInformation addToEmployeeEducationInformation ( BaseEmployeeEducationInformation employeeeducationinformation, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		dao.setDataFromBase(employeeeducationinformation);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeEducationInformation addUpdateEmployeeEducationInformation ( BaseEmployeeEducationInformation employeeeducationinformation ) throws Exception {
		return addUpdateEmployeeEducationInformation ( employeeeducationinformation , false);
	}

	public static BaseEmployeeEducationInformation addUpdateEmployeeEducationInformation ( BaseEmployeeEducationInformation employeeeducationinformation, boolean singleTransaction  ) throws Exception {
		if(employeeeducationinformation.getEmployeeEducationInformationId() == null) return addToEmployeeEducationInformation(employeeeducationinformation);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		dao.setDataFromBase(employeeeducationinformation);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeeeducationinformation); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeEducationInformation ( BaseEmployeeEducationInformation bean ) throws Exception {
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeEducationInformation updateEmployeeEducationInformation ( BaseEmployeeEducationInformation employeeeducationinformation ) throws Exception {
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		dao.setEmployeeEducationInformationId( employeeeducationinformation.getEmployeeEducationInformationId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeeeducationinformation);
			result = dao.update();
		}
		return result == 1 ? employeeeducationinformation : null ;
	}

	public static BaseEmployeeEducationInformation updateEmployeeEducationInformationDirect( BaseEmployeeEducationInformation employeeeducationinformation ) throws Exception {
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		int result = 0;
		dao.setDataFromBase(employeeeducationinformation);
		result = dao.update();
		return result == 1 ? employeeeducationinformation : null ;
	}

	public static int setDeleteConditions(BaseEmployeeEducationInformation bean, EmployeeEducationInformation dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeEducationInformationId() != null) {
			dao.setConditionEmployeeEducationInformationId("=", bean.getEmployeeEducationInformationId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getGraduatedSchool() != null) {
				dao.setConditionGraduatedSchool("=", bean.getGraduatedSchool());
				count++;
			}
			if(bean.getSpecialty() != null) {
				dao.setConditionSpecialty("=", bean.getSpecialty());
				count++;
			}
			if(bean.getEducation() != null) {
				dao.setConditionEducation("=", bean.getEducation());
				count++;
			}
			if(bean.getDegree() != null) {
				dao.setConditionDegree("=", bean.getDegree());
				count++;
			}
			if(bean.getLearningWay() != null) {
				dao.setConditionLearningWay("=", bean.getLearningWay());
				count++;
			}
			if(bean.getAttachment() != null) {
				dao.setConditionAttachment("=", bean.getAttachment());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeEducationInformation bean, EmployeeEducationInformation dao){
		int count = 0;
		if(bean.getEmployeeEducationInformationId() != null) {
			dao.setConditionEmployeeEducationInformationId("=", bean.getEmployeeEducationInformationId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getGraduatedSchool() != null) {
			if(bean.getGraduatedSchool().indexOf("%") >= 0)
				dao.setConditionGraduatedSchool("like", bean.getGraduatedSchool());
			else
				dao.setConditionGraduatedSchool("=", bean.getGraduatedSchool());
			count++;
		}
		if(bean.getSpecialty() != null) {
			if(bean.getSpecialty().indexOf("%") >= 0)
				dao.setConditionSpecialty("like", bean.getSpecialty());
			else
				dao.setConditionSpecialty("=", bean.getSpecialty());
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
		if(bean.getEducation() != null) {
			dao.setConditionEducation("=", bean.getEducation());
			count++;
		}
		if(bean.getDegree() != null) {
			dao.setConditionDegree("=", bean.getDegree());
			count++;
		}
		if(bean.getLearningWay() != null) {
			dao.setConditionLearningWay("=", bean.getLearningWay());
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
		BaseEmployeeEducationInformation bean = new BaseEmployeeEducationInformation();
		bean.setDataFromJSON(json);
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeEducationInformation> rlist = new BaseCollection<>();
		BaseEmployeeEducationInformation bean = new BaseEmployeeEducationInformation();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeEducationInformation> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeEducationInformation bean = new BaseEmployeeEducationInformation();
		bean.setDataFromJSON(json);
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeEducationInformation bean = new BaseEmployeeEducationInformation();
		bean.setDataFromJSON(json);
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeEducationInformation bean = new BaseEmployeeEducationInformation();
		bean.setDataFromJSON(json);
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeEducationInformation bean = new BaseEmployeeEducationInformation();
		bean.setDataFromJSON(json);
		EmployeeEducationInformation dao = new EmployeeEducationInformation();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


