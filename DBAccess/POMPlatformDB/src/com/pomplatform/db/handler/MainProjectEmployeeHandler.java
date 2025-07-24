package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.dao.MainProjectEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class MainProjectEmployeeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MainProjectEmployeeHandler.class);

	public static BaseMainProjectEmployee getMainProjectEmployeeById( 
		java.lang.Integer main_project_employee_id
	) throws Exception
	{
		MainProjectEmployee dao = new MainProjectEmployee();
		dao.setMainProjectEmployeeId(main_project_employee_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMainProjectEmployeeExists( com.pomplatform.db.bean.BaseMainProjectEmployee bean, String additional ) throws Exception {

		MainProjectEmployee dao = new MainProjectEmployee();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMainProjectEmployee( com.pomplatform.db.bean.BaseMainProjectEmployee bean, String additional ) throws Exception {

		MainProjectEmployee dao = new MainProjectEmployee();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMainProjectEmployee> queryMainProjectEmployee( com.pomplatform.db.bean.BaseMainProjectEmployee bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MainProjectEmployee dao = new MainProjectEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMainProjectEmployee> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMainProjectEmployee> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMainProjectEmployee addToMainProjectEmployee ( BaseMainProjectEmployee mainprojectemployee )  throws Exception {
		return addToMainProjectEmployee ( mainprojectemployee , false);
	}

	public static BaseMainProjectEmployee addToMainProjectEmployee ( BaseMainProjectEmployee mainprojectemployee, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MainProjectEmployee dao = new MainProjectEmployee();
		dao.setDataFromBase(mainprojectemployee);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMainProjectEmployee addUpdateMainProjectEmployee ( BaseMainProjectEmployee mainprojectemployee ) throws Exception {
		return addUpdateMainProjectEmployee ( mainprojectemployee , false);
	}

	public static BaseMainProjectEmployee addUpdateMainProjectEmployee ( BaseMainProjectEmployee mainprojectemployee, boolean singleTransaction  ) throws Exception {
		if(mainprojectemployee.getMainProjectEmployeeId() == null) return addToMainProjectEmployee(mainprojectemployee);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MainProjectEmployee dao = new MainProjectEmployee();
		dao.setDataFromBase(mainprojectemployee);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(mainprojectemployee); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMainProjectEmployee ( BaseMainProjectEmployee bean ) throws Exception {
		MainProjectEmployee dao = new MainProjectEmployee();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMainProjectEmployee updateMainProjectEmployee ( BaseMainProjectEmployee mainprojectemployee ) throws Exception {
		MainProjectEmployee dao = new MainProjectEmployee();
		dao.setMainProjectEmployeeId( mainprojectemployee.getMainProjectEmployeeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(mainprojectemployee);
			result = dao.update();
		}
		return result == 1 ? mainprojectemployee : null ;
	}

	public static BaseMainProjectEmployee updateMainProjectEmployeeDirect( BaseMainProjectEmployee mainprojectemployee ) throws Exception {
		MainProjectEmployee dao = new MainProjectEmployee();
		int result = 0;
		dao.setDataFromBase(mainprojectemployee);
		result = dao.update();
		return result == 1 ? mainprojectemployee : null ;
	}

	public static int setDeleteConditions(BaseMainProjectEmployee bean, MainProjectEmployee dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMainProjectEmployeeId() != null) {
			dao.setConditionMainProjectEmployeeId("=", bean.getMainProjectEmployeeId());
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
			if(bean.getRelation() != null) {
				dao.setConditionRelation("=", bean.getRelation());
				count++;
			}
			if(bean.getPreProjectId() != null) {
				dao.setConditionPreProjectId("=", bean.getPreProjectId());
				count++;
			}
			if(bean.getMainAndAssistance() != null) {
				dao.setConditionMainAndAssistance("=", bean.getMainAndAssistance());
				count++;
			}
			if(bean.getIsPlateManager() != null) {
				dao.setConditionIsPlateManager("=", bean.getIsPlateManager());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMainProjectEmployee bean, MainProjectEmployee dao){
		int count = 0;
		if(bean.getMainProjectEmployeeId() != null) {
			dao.setConditionMainProjectEmployeeId("=", bean.getMainProjectEmployeeId());
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
		if(bean.getRelation() != null) {
			dao.setConditionRelation("=", bean.getRelation());
			count++;
		}
		if(bean.getPreProjectId() != null) {
			dao.setConditionPreProjectId("=", bean.getPreProjectId());
			count++;
		}
		if(bean.getMainAndAssistance() != null) {
			dao.setConditionMainAndAssistance("=", bean.getMainAndAssistance());
			count++;
		}
		if(bean.getIsPlateManager() != null) {
			dao.setConditionIsPlateManager("=", bean.getIsPlateManager());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMainProjectEmployee bean = new BaseMainProjectEmployee();
		bean.setDataFromJSON(json);
		MainProjectEmployee dao = new MainProjectEmployee();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMainProjectEmployee> rlist = new BaseCollection<>();
		BaseMainProjectEmployee bean = new BaseMainProjectEmployee();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MainProjectEmployee dao = new MainProjectEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMainProjectEmployee> result = dao.conditionalLoad(addtion);
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
		BaseMainProjectEmployee bean = new BaseMainProjectEmployee();
		bean.setDataFromJSON(json);
		MainProjectEmployee dao = new MainProjectEmployee();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMainProjectEmployee bean = new BaseMainProjectEmployee();
		bean.setDataFromJSON(json);
		MainProjectEmployee dao = new MainProjectEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMainProjectEmployee bean = new BaseMainProjectEmployee();
		bean.setDataFromJSON(json);
		MainProjectEmployee dao = new MainProjectEmployee();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMainProjectEmployee bean = new BaseMainProjectEmployee();
		bean.setDataFromJSON(json);
		MainProjectEmployee dao = new MainProjectEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


