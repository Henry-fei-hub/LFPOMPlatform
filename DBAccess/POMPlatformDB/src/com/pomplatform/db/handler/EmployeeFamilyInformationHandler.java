package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeFamilyInformation;
import com.pomplatform.db.dao.EmployeeFamilyInformation;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeFamilyInformationHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeFamilyInformationHandler.class);

	public static BaseEmployeeFamilyInformation getEmployeeFamilyInformationById( 
		java.lang.Integer employee_family_information_id
	) throws Exception
	{
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		dao.setEmployeeFamilyInformationId(employee_family_information_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeFamilyInformationExists( com.pomplatform.db.bean.BaseEmployeeFamilyInformation bean, String additional ) throws Exception {

		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeFamilyInformation( com.pomplatform.db.bean.BaseEmployeeFamilyInformation bean, String additional ) throws Exception {

		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeFamilyInformation> queryEmployeeFamilyInformation( com.pomplatform.db.bean.BaseEmployeeFamilyInformation bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeFamilyInformation> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeFamilyInformation> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeFamilyInformation addToEmployeeFamilyInformation ( BaseEmployeeFamilyInformation employeefamilyinformation )  throws Exception {
		return addToEmployeeFamilyInformation ( employeefamilyinformation , false);
	}

	public static BaseEmployeeFamilyInformation addToEmployeeFamilyInformation ( BaseEmployeeFamilyInformation employeefamilyinformation, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		dao.setDataFromBase(employeefamilyinformation);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeFamilyInformation addUpdateEmployeeFamilyInformation ( BaseEmployeeFamilyInformation employeefamilyinformation ) throws Exception {
		return addUpdateEmployeeFamilyInformation ( employeefamilyinformation , false);
	}

	public static BaseEmployeeFamilyInformation addUpdateEmployeeFamilyInformation ( BaseEmployeeFamilyInformation employeefamilyinformation, boolean singleTransaction  ) throws Exception {
		if(employeefamilyinformation.getEmployeeFamilyInformationId() == null) return addToEmployeeFamilyInformation(employeefamilyinformation);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		dao.setDataFromBase(employeefamilyinformation);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeefamilyinformation); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeFamilyInformation ( BaseEmployeeFamilyInformation bean ) throws Exception {
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeFamilyInformation updateEmployeeFamilyInformation ( BaseEmployeeFamilyInformation employeefamilyinformation ) throws Exception {
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		dao.setEmployeeFamilyInformationId( employeefamilyinformation.getEmployeeFamilyInformationId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeefamilyinformation);
			result = dao.update();
		}
		return result == 1 ? employeefamilyinformation : null ;
	}

	public static BaseEmployeeFamilyInformation updateEmployeeFamilyInformationDirect( BaseEmployeeFamilyInformation employeefamilyinformation ) throws Exception {
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		int result = 0;
		dao.setDataFromBase(employeefamilyinformation);
		result = dao.update();
		return result == 1 ? employeefamilyinformation : null ;
	}

	public static int setDeleteConditions(BaseEmployeeFamilyInformation bean, EmployeeFamilyInformation dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeFamilyInformationId() != null) {
			dao.setConditionEmployeeFamilyInformationId("=", bean.getEmployeeFamilyInformationId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getFamilyMemberName() != null) {
				dao.setConditionFamilyMemberName("=", bean.getFamilyMemberName());
				count++;
			}
			if(bean.getRelation() != null) {
				dao.setConditionRelation("=", bean.getRelation());
				count++;
			}
			if(bean.getFamilyWorkPlace() != null) {
				dao.setConditionFamilyWorkPlace("=", bean.getFamilyWorkPlace());
				count++;
			}
			if(bean.getTelephone() != null) {
				dao.setConditionTelephone("=", bean.getTelephone());
				count++;
			}
			if(bean.getFamilyMemberCard() != null) {
				dao.setConditionFamilyMemberCard("=", bean.getFamilyMemberCard());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeFamilyInformation bean, EmployeeFamilyInformation dao){
		int count = 0;
		if(bean.getEmployeeFamilyInformationId() != null) {
			dao.setConditionEmployeeFamilyInformationId("=", bean.getEmployeeFamilyInformationId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getFamilyMemberName() != null) {
			if(bean.getFamilyMemberName().indexOf("%") >= 0)
				dao.setConditionFamilyMemberName("like", bean.getFamilyMemberName());
			else
				dao.setConditionFamilyMemberName("=", bean.getFamilyMemberName());
			count++;
		}
		if(bean.getRelation() != null) {
			if(bean.getRelation().indexOf("%") >= 0)
				dao.setConditionRelation("like", bean.getRelation());
			else
				dao.setConditionRelation("=", bean.getRelation());
			count++;
		}
		if(bean.getFamilyWorkPlace() != null) {
			if(bean.getFamilyWorkPlace().indexOf("%") >= 0)
				dao.setConditionFamilyWorkPlace("like", bean.getFamilyWorkPlace());
			else
				dao.setConditionFamilyWorkPlace("=", bean.getFamilyWorkPlace());
			count++;
		}
		if(bean.getTelephone() != null) {
			if(bean.getTelephone().indexOf("%") >= 0)
				dao.setConditionTelephone("like", bean.getTelephone());
			else
				dao.setConditionTelephone("=", bean.getTelephone());
			count++;
		}
		if(bean.getFamilyMemberCard() != null) {
			if(bean.getFamilyMemberCard().indexOf("%") >= 0)
				dao.setConditionFamilyMemberCard("like", bean.getFamilyMemberCard());
			else
				dao.setConditionFamilyMemberCard("=", bean.getFamilyMemberCard());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeFamilyInformation bean = new BaseEmployeeFamilyInformation();
		bean.setDataFromJSON(json);
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeFamilyInformation> rlist = new BaseCollection<>();
		BaseEmployeeFamilyInformation bean = new BaseEmployeeFamilyInformation();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeFamilyInformation> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeFamilyInformation bean = new BaseEmployeeFamilyInformation();
		bean.setDataFromJSON(json);
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeFamilyInformation bean = new BaseEmployeeFamilyInformation();
		bean.setDataFromJSON(json);
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeFamilyInformation bean = new BaseEmployeeFamilyInformation();
		bean.setDataFromJSON(json);
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeFamilyInformation bean = new BaseEmployeeFamilyInformation();
		bean.setDataFromJSON(json);
		EmployeeFamilyInformation dao = new EmployeeFamilyInformation();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


