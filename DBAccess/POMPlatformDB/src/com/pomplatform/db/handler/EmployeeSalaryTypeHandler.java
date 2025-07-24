package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeSalaryType;
import com.pomplatform.db.dao.EmployeeSalaryType;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeSalaryTypeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeSalaryTypeHandler.class);

	public static BaseEmployeeSalaryType getEmployeeSalaryTypeById( 
		java.lang.Integer employee_salary_type_id
	) throws Exception
	{
		EmployeeSalaryType dao = new EmployeeSalaryType();
		dao.setEmployeeSalaryTypeId(employee_salary_type_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeSalaryTypeExists( com.pomplatform.db.bean.BaseEmployeeSalaryType bean, String additional ) throws Exception {

		EmployeeSalaryType dao = new EmployeeSalaryType();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeSalaryType( com.pomplatform.db.bean.BaseEmployeeSalaryType bean, String additional ) throws Exception {

		EmployeeSalaryType dao = new EmployeeSalaryType();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeSalaryType> queryEmployeeSalaryType( com.pomplatform.db.bean.BaseEmployeeSalaryType bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeSalaryType dao = new EmployeeSalaryType();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeSalaryType> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeSalaryType> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeSalaryType addToEmployeeSalaryType ( BaseEmployeeSalaryType employeesalarytype )  throws Exception {
		return addToEmployeeSalaryType ( employeesalarytype , false);
	}

	public static BaseEmployeeSalaryType addToEmployeeSalaryType ( BaseEmployeeSalaryType employeesalarytype, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeSalaryType dao = new EmployeeSalaryType();
		dao.setDataFromBase(employeesalarytype);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeSalaryType addUpdateEmployeeSalaryType ( BaseEmployeeSalaryType employeesalarytype ) throws Exception {
		return addUpdateEmployeeSalaryType ( employeesalarytype , false);
	}

	public static BaseEmployeeSalaryType addUpdateEmployeeSalaryType ( BaseEmployeeSalaryType employeesalarytype, boolean singleTransaction  ) throws Exception {
		if(employeesalarytype.getEmployeeSalaryTypeId() == null) return addToEmployeeSalaryType(employeesalarytype);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeSalaryType dao = new EmployeeSalaryType();
		dao.setDataFromBase(employeesalarytype);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeesalarytype); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeSalaryType ( BaseEmployeeSalaryType bean ) throws Exception {
		EmployeeSalaryType dao = new EmployeeSalaryType();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeSalaryType updateEmployeeSalaryType ( BaseEmployeeSalaryType employeesalarytype ) throws Exception {
		EmployeeSalaryType dao = new EmployeeSalaryType();
		dao.setEmployeeSalaryTypeId( employeesalarytype.getEmployeeSalaryTypeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeesalarytype);
			result = dao.update();
		}
		return result == 1 ? employeesalarytype : null ;
	}

	public static BaseEmployeeSalaryType updateEmployeeSalaryTypeDirect( BaseEmployeeSalaryType employeesalarytype ) throws Exception {
		EmployeeSalaryType dao = new EmployeeSalaryType();
		int result = 0;
		dao.setDataFromBase(employeesalarytype);
		result = dao.update();
		return result == 1 ? employeesalarytype : null ;
	}

	public static int setDeleteConditions(BaseEmployeeSalaryType bean, EmployeeSalaryType dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeSalaryTypeId() != null) {
			dao.setConditionEmployeeSalaryTypeId("=", bean.getEmployeeSalaryTypeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
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
			if(bean.getSalaryType() != null) {
				dao.setConditionSalaryType("=", bean.getSalaryType());
				count++;
			}
			if(bean.getFundraisingProjectType() != null) {
				dao.setConditionFundraisingProjectType("=", bean.getFundraisingProjectType());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeSalaryType bean, EmployeeSalaryType dao){
		int count = 0;
		if(bean.getEmployeeSalaryTypeId() != null) {
			dao.setConditionEmployeeSalaryTypeId("=", bean.getEmployeeSalaryTypeId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
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
		if(bean.getSalaryType() != null) {
			dao.setConditionSalaryType("=", bean.getSalaryType());
			count++;
		}
		if(bean.getFundraisingProjectType() != null) {
			dao.setConditionFundraisingProjectType("=", bean.getFundraisingProjectType());
			count++;
		}
		if(bean.getFundraisingProjectRate() != null) {
			dao.setConditionFundraisingProjectRate("=", bean.getFundraisingProjectRate());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeSalaryType bean = new BaseEmployeeSalaryType();
		bean.setDataFromJSON(json);
		EmployeeSalaryType dao = new EmployeeSalaryType();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeSalaryType> rlist = new BaseCollection<>();
		BaseEmployeeSalaryType bean = new BaseEmployeeSalaryType();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeSalaryType dao = new EmployeeSalaryType();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeSalaryType> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeSalaryType bean = new BaseEmployeeSalaryType();
		bean.setDataFromJSON(json);
		EmployeeSalaryType dao = new EmployeeSalaryType();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeSalaryType bean = new BaseEmployeeSalaryType();
		bean.setDataFromJSON(json);
		EmployeeSalaryType dao = new EmployeeSalaryType();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeSalaryType bean = new BaseEmployeeSalaryType();
		bean.setDataFromJSON(json);
		EmployeeSalaryType dao = new EmployeeSalaryType();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeSalaryType bean = new BaseEmployeeSalaryType();
		bean.setDataFromJSON(json);
		EmployeeSalaryType dao = new EmployeeSalaryType();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


