package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryEmployeeEvaluation;
import com.pomplatform.db.dao.SalaryEmployeeEvaluation;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryEmployeeEvaluationHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryEmployeeEvaluationHandler.class);

	public static BaseSalaryEmployeeEvaluation getSalaryEmployeeEvaluationById( 
		java.lang.Integer salary_employee_evaluation_id
	) throws Exception
	{
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		dao.setSalaryEmployeeEvaluationId(salary_employee_evaluation_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryEmployeeEvaluationExists( com.pomplatform.db.bean.BaseSalaryEmployeeEvaluation bean, String additional ) throws Exception {

		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryEmployeeEvaluation( com.pomplatform.db.bean.BaseSalaryEmployeeEvaluation bean, String additional ) throws Exception {

		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryEmployeeEvaluation> querySalaryEmployeeEvaluation( com.pomplatform.db.bean.BaseSalaryEmployeeEvaluation bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryEmployeeEvaluation> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryEmployeeEvaluation> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryEmployeeEvaluation addToSalaryEmployeeEvaluation ( BaseSalaryEmployeeEvaluation salaryemployeeevaluation )  throws Exception {
		return addToSalaryEmployeeEvaluation ( salaryemployeeevaluation , false);
	}

	public static BaseSalaryEmployeeEvaluation addToSalaryEmployeeEvaluation ( BaseSalaryEmployeeEvaluation salaryemployeeevaluation, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		dao.setDataFromBase(salaryemployeeevaluation);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryEmployeeEvaluation addUpdateSalaryEmployeeEvaluation ( BaseSalaryEmployeeEvaluation salaryemployeeevaluation ) throws Exception {
		return addUpdateSalaryEmployeeEvaluation ( salaryemployeeevaluation , false);
	}

	public static BaseSalaryEmployeeEvaluation addUpdateSalaryEmployeeEvaluation ( BaseSalaryEmployeeEvaluation salaryemployeeevaluation, boolean singleTransaction  ) throws Exception {
		if(salaryemployeeevaluation.getSalaryEmployeeEvaluationId() == null) return addToSalaryEmployeeEvaluation(salaryemployeeevaluation);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		dao.setDataFromBase(salaryemployeeevaluation);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salaryemployeeevaluation); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryEmployeeEvaluation ( BaseSalaryEmployeeEvaluation bean ) throws Exception {
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryEmployeeEvaluation updateSalaryEmployeeEvaluation ( BaseSalaryEmployeeEvaluation salaryemployeeevaluation ) throws Exception {
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		dao.setSalaryEmployeeEvaluationId( salaryemployeeevaluation.getSalaryEmployeeEvaluationId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salaryemployeeevaluation);
			result = dao.update();
		}
		return result == 1 ? salaryemployeeevaluation : null ;
	}

	public static BaseSalaryEmployeeEvaluation updateSalaryEmployeeEvaluationDirect( BaseSalaryEmployeeEvaluation salaryemployeeevaluation ) throws Exception {
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		int result = 0;
		dao.setDataFromBase(salaryemployeeevaluation);
		result = dao.update();
		return result == 1 ? salaryemployeeevaluation : null ;
	}

	public static int setDeleteConditions(BaseSalaryEmployeeEvaluation bean, SalaryEmployeeEvaluation dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryEmployeeEvaluationId() != null) {
			dao.setConditionSalaryEmployeeEvaluationId("=", bean.getSalaryEmployeeEvaluationId());
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
			if(bean.getGrade() != null) {
				dao.setConditionGrade("=", bean.getGrade());
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

	public static int setConditions(BaseSalaryEmployeeEvaluation bean, SalaryEmployeeEvaluation dao){
		int count = 0;
		if(bean.getSalaryEmployeeEvaluationId() != null) {
			dao.setConditionSalaryEmployeeEvaluationId("=", bean.getSalaryEmployeeEvaluationId());
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
		if(bean.getGrade() != null) {
			if(bean.getGrade().indexOf("%") >= 0)
				dao.setConditionGrade("like", bean.getGrade());
			else
				dao.setConditionGrade("=", bean.getGrade());
			count++;
		}
		if(bean.getHappenDate() != null) {
			dao.setConditionHappenDate(">=", bean.getHappenDate());
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
		BaseSalaryEmployeeEvaluation bean = new BaseSalaryEmployeeEvaluation();
		bean.setDataFromJSON(json);
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryEmployeeEvaluation> rlist = new BaseCollection<>();
		BaseSalaryEmployeeEvaluation bean = new BaseSalaryEmployeeEvaluation();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryEmployeeEvaluation> result = dao.conditionalLoad(addtion);
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
		BaseSalaryEmployeeEvaluation bean = new BaseSalaryEmployeeEvaluation();
		bean.setDataFromJSON(json);
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSalaryEmployeeEvaluation bean = new BaseSalaryEmployeeEvaluation();
		bean.setDataFromJSON(json);
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryEmployeeEvaluation bean = new BaseSalaryEmployeeEvaluation();
		bean.setDataFromJSON(json);
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryEmployeeEvaluation bean = new BaseSalaryEmployeeEvaluation();
		bean.setDataFromJSON(json);
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


