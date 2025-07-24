package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseMainProjectMajorEmployee;
import com.pomplatform.db.dao.MainProjectMajorEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class MainProjectMajorEmployeeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MainProjectMajorEmployeeHandler.class);

	public static BaseMainProjectMajorEmployee getMainProjectMajorEmployeeById( 
		java.lang.Integer main_project_major_employee_id
	) throws Exception
	{
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		dao.setMainProjectMajorEmployeeId(main_project_major_employee_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMainProjectMajorEmployeeExists( com.pomplatform.db.bean.BaseMainProjectMajorEmployee bean, String additional ) throws Exception {

		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMainProjectMajorEmployee( com.pomplatform.db.bean.BaseMainProjectMajorEmployee bean, String additional ) throws Exception {

		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMainProjectMajorEmployee> queryMainProjectMajorEmployee( com.pomplatform.db.bean.BaseMainProjectMajorEmployee bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMainProjectMajorEmployee> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMainProjectMajorEmployee> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMainProjectMajorEmployee addToMainProjectMajorEmployee ( BaseMainProjectMajorEmployee mainprojectmajoremployee )  throws Exception {
		return addToMainProjectMajorEmployee ( mainprojectmajoremployee , false);
	}

	public static BaseMainProjectMajorEmployee addToMainProjectMajorEmployee ( BaseMainProjectMajorEmployee mainprojectmajoremployee, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		dao.setDataFromBase(mainprojectmajoremployee);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMainProjectMajorEmployee addUpdateMainProjectMajorEmployee ( BaseMainProjectMajorEmployee mainprojectmajoremployee ) throws Exception {
		return addUpdateMainProjectMajorEmployee ( mainprojectmajoremployee , false);
	}

	public static BaseMainProjectMajorEmployee addUpdateMainProjectMajorEmployee ( BaseMainProjectMajorEmployee mainprojectmajoremployee, boolean singleTransaction  ) throws Exception {
		if(mainprojectmajoremployee.getMainProjectMajorEmployeeId() == null) return addToMainProjectMajorEmployee(mainprojectmajoremployee);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		dao.setDataFromBase(mainprojectmajoremployee);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(mainprojectmajoremployee); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMainProjectMajorEmployee ( BaseMainProjectMajorEmployee bean ) throws Exception {
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMainProjectMajorEmployee updateMainProjectMajorEmployee ( BaseMainProjectMajorEmployee mainprojectmajoremployee ) throws Exception {
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		dao.setMainProjectMajorEmployeeId( mainprojectmajoremployee.getMainProjectMajorEmployeeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(mainprojectmajoremployee);
			result = dao.update();
		}
		return result == 1 ? mainprojectmajoremployee : null ;
	}

	public static BaseMainProjectMajorEmployee updateMainProjectMajorEmployeeDirect( BaseMainProjectMajorEmployee mainprojectmajoremployee ) throws Exception {
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		int result = 0;
		dao.setDataFromBase(mainprojectmajoremployee);
		result = dao.update();
		return result == 1 ? mainprojectmajoremployee : null ;
	}

	public static int setDeleteConditions(BaseMainProjectMajorEmployee bean, MainProjectMajorEmployee dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMainProjectMajorEmployeeId() != null) {
			dao.setConditionMainProjectMajorEmployeeId("=", bean.getMainProjectMajorEmployeeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getSpecialtyId() != null) {
				dao.setConditionSpecialtyId("=", bean.getSpecialtyId());
				count++;
			}
			if(bean.getRelation() != null) {
				dao.setConditionRelation("=", bean.getRelation());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
			if(bean.getStampHolder() != null) {
				dao.setConditionStampHolder("=", bean.getStampHolder());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMainProjectMajorEmployee bean, MainProjectMajorEmployee dao){
		int count = 0;
		if(bean.getMainProjectMajorEmployeeId() != null) {
			dao.setConditionMainProjectMajorEmployeeId("=", bean.getMainProjectMajorEmployeeId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getSpecialtyId() != null) {
			dao.setConditionSpecialtyId("=", bean.getSpecialtyId());
			count++;
		}
		if(bean.getRelation() != null) {
			dao.setConditionRelation("=", bean.getRelation());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getStampHolder() != null) {
			dao.setConditionStampHolder("=", bean.getStampHolder());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMainProjectMajorEmployee bean = new BaseMainProjectMajorEmployee();
		bean.setDataFromJSON(json);
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMainProjectMajorEmployee> rlist = new BaseCollection<>();
		BaseMainProjectMajorEmployee bean = new BaseMainProjectMajorEmployee();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMainProjectMajorEmployee> result = dao.conditionalLoad(addtion);
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
		BaseMainProjectMajorEmployee bean = new BaseMainProjectMajorEmployee();
		bean.setDataFromJSON(json);
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMainProjectMajorEmployee bean = new BaseMainProjectMajorEmployee();
		bean.setDataFromJSON(json);
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMainProjectMajorEmployee bean = new BaseMainProjectMajorEmployee();
		bean.setDataFromJSON(json);
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMainProjectMajorEmployee bean = new BaseMainProjectMajorEmployee();
		bean.setDataFromJSON(json);
		MainProjectMajorEmployee dao = new MainProjectMajorEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


