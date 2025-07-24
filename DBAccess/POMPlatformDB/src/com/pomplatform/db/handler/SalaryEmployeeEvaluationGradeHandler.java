package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryEmployeeEvaluationGrade;
import com.pomplatform.db.dao.SalaryEmployeeEvaluationGrade;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryEmployeeEvaluationGradeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryEmployeeEvaluationGradeHandler.class);

	public static BaseSalaryEmployeeEvaluationGrade getSalaryEmployeeEvaluationGradeById( 
		java.lang.Integer salary_employee_evaluation_grade_id
	) throws Exception
	{
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		dao.setSalaryEmployeeEvaluationGradeId(salary_employee_evaluation_grade_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryEmployeeEvaluationGradeExists( com.pomplatform.db.bean.BaseSalaryEmployeeEvaluationGrade bean, String additional ) throws Exception {

		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryEmployeeEvaluationGrade( com.pomplatform.db.bean.BaseSalaryEmployeeEvaluationGrade bean, String additional ) throws Exception {

		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryEmployeeEvaluationGrade> querySalaryEmployeeEvaluationGrade( com.pomplatform.db.bean.BaseSalaryEmployeeEvaluationGrade bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryEmployeeEvaluationGrade> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryEmployeeEvaluationGrade> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryEmployeeEvaluationGrade addToSalaryEmployeeEvaluationGrade ( BaseSalaryEmployeeEvaluationGrade salaryemployeeevaluationgrade )  throws Exception {
		return addToSalaryEmployeeEvaluationGrade ( salaryemployeeevaluationgrade , false);
	}

	public static BaseSalaryEmployeeEvaluationGrade addToSalaryEmployeeEvaluationGrade ( BaseSalaryEmployeeEvaluationGrade salaryemployeeevaluationgrade, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		dao.setDataFromBase(salaryemployeeevaluationgrade);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryEmployeeEvaluationGrade addUpdateSalaryEmployeeEvaluationGrade ( BaseSalaryEmployeeEvaluationGrade salaryemployeeevaluationgrade ) throws Exception {
		return addUpdateSalaryEmployeeEvaluationGrade ( salaryemployeeevaluationgrade , false);
	}

	public static BaseSalaryEmployeeEvaluationGrade addUpdateSalaryEmployeeEvaluationGrade ( BaseSalaryEmployeeEvaluationGrade salaryemployeeevaluationgrade, boolean singleTransaction  ) throws Exception {
		if(salaryemployeeevaluationgrade.getSalaryEmployeeEvaluationGradeId() == null) return addToSalaryEmployeeEvaluationGrade(salaryemployeeevaluationgrade);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		dao.setDataFromBase(salaryemployeeevaluationgrade);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salaryemployeeevaluationgrade); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryEmployeeEvaluationGrade ( BaseSalaryEmployeeEvaluationGrade bean ) throws Exception {
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryEmployeeEvaluationGrade updateSalaryEmployeeEvaluationGrade ( BaseSalaryEmployeeEvaluationGrade salaryemployeeevaluationgrade ) throws Exception {
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		dao.setSalaryEmployeeEvaluationGradeId( salaryemployeeevaluationgrade.getSalaryEmployeeEvaluationGradeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salaryemployeeevaluationgrade);
			result = dao.update();
		}
		return result == 1 ? salaryemployeeevaluationgrade : null ;
	}

	public static BaseSalaryEmployeeEvaluationGrade updateSalaryEmployeeEvaluationGradeDirect( BaseSalaryEmployeeEvaluationGrade salaryemployeeevaluationgrade ) throws Exception {
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		int result = 0;
		dao.setDataFromBase(salaryemployeeevaluationgrade);
		result = dao.update();
		return result == 1 ? salaryemployeeevaluationgrade : null ;
	}

	public static int setDeleteConditions(BaseSalaryEmployeeEvaluationGrade bean, SalaryEmployeeEvaluationGrade dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryEmployeeEvaluationGradeId() != null) {
			dao.setConditionSalaryEmployeeEvaluationGradeId("=", bean.getSalaryEmployeeEvaluationGradeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getGrade() != null) {
				dao.setConditionGrade("=", bean.getGrade());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getFlag() != null) {
				dao.setConditionFlag("=", bean.getFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSalaryEmployeeEvaluationGrade bean, SalaryEmployeeEvaluationGrade dao){
		int count = 0;
		if(bean.getSalaryEmployeeEvaluationGradeId() != null) {
			dao.setConditionSalaryEmployeeEvaluationGradeId("=", bean.getSalaryEmployeeEvaluationGradeId());
			count++;
		}
		if(bean.getGrade() != null) {
			if(bean.getGrade().indexOf("%") >= 0)
				dao.setConditionGrade("like", bean.getGrade());
			else
				dao.setConditionGrade("=", bean.getGrade());
			count++;
		}
		if(bean.getProportion() != null) {
			dao.setConditionProportion("=", bean.getProportion());
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
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getFlag() != null) {
			dao.setConditionFlag("=", bean.getFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSalaryEmployeeEvaluationGrade bean = new BaseSalaryEmployeeEvaluationGrade();
		bean.setDataFromJSON(json);
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryEmployeeEvaluationGrade> rlist = new BaseCollection<>();
		BaseSalaryEmployeeEvaluationGrade bean = new BaseSalaryEmployeeEvaluationGrade();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryEmployeeEvaluationGrade> result = dao.conditionalLoad(addtion);
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
		BaseSalaryEmployeeEvaluationGrade bean = new BaseSalaryEmployeeEvaluationGrade();
		bean.setDataFromJSON(json);
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSalaryEmployeeEvaluationGrade bean = new BaseSalaryEmployeeEvaluationGrade();
		bean.setDataFromJSON(json);
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryEmployeeEvaluationGrade bean = new BaseSalaryEmployeeEvaluationGrade();
		bean.setDataFromJSON(json);
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryEmployeeEvaluationGrade bean = new BaseSalaryEmployeeEvaluationGrade();
		bean.setDataFromJSON(json);
		SalaryEmployeeEvaluationGrade dao = new SalaryEmployeeEvaluationGrade();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


