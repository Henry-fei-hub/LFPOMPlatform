package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryException;
import com.pomplatform.db.dao.SalaryException;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryExceptionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryExceptionHandler.class);

	public static BaseSalaryException getSalaryExceptionById( 
		java.lang.Integer salary_exception_id
	) throws Exception
	{
		SalaryException dao = new SalaryException();
		dao.setSalaryExceptionId(salary_exception_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryExceptionExists( com.pomplatform.db.bean.BaseSalaryException bean, String additional ) throws Exception {

		SalaryException dao = new SalaryException();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryException( com.pomplatform.db.bean.BaseSalaryException bean, String additional ) throws Exception {

		SalaryException dao = new SalaryException();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryException> querySalaryException( com.pomplatform.db.bean.BaseSalaryException bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryException dao = new SalaryException();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryException> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryException> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryException addToSalaryException ( BaseSalaryException salaryexception )  throws Exception {
		return addToSalaryException ( salaryexception , false);
	}

	public static BaseSalaryException addToSalaryException ( BaseSalaryException salaryexception, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryException dao = new SalaryException();
		dao.setDataFromBase(salaryexception);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryException addUpdateSalaryException ( BaseSalaryException salaryexception ) throws Exception {
		return addUpdateSalaryException ( salaryexception , false);
	}

	public static BaseSalaryException addUpdateSalaryException ( BaseSalaryException salaryexception, boolean singleTransaction  ) throws Exception {
		if(salaryexception.getSalaryExceptionId() == null) return addToSalaryException(salaryexception);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryException dao = new SalaryException();
		dao.setDataFromBase(salaryexception);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salaryexception); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryException ( BaseSalaryException bean ) throws Exception {
		SalaryException dao = new SalaryException();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryException updateSalaryException ( BaseSalaryException salaryexception ) throws Exception {
		SalaryException dao = new SalaryException();
		dao.setSalaryExceptionId( salaryexception.getSalaryExceptionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salaryexception);
			result = dao.update();
		}
		return result == 1 ? salaryexception : null ;
	}

	public static BaseSalaryException updateSalaryExceptionDirect( BaseSalaryException salaryexception ) throws Exception {
		SalaryException dao = new SalaryException();
		int result = 0;
		dao.setDataFromBase(salaryexception);
		result = dao.update();
		return result == 1 ? salaryexception : null ;
	}

	public static int setDeleteConditions(BaseSalaryException bean, SalaryException dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryExceptionId() != null) {
			dao.setConditionSalaryExceptionId("=", bean.getSalaryExceptionId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getReason() != null) {
				dao.setConditionReason("=", bean.getReason());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getIsApply() != null) {
				dao.setConditionIsApply("=", bean.getIsApply());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSalaryException bean, SalaryException dao){
		int count = 0;
		if(bean.getSalaryExceptionId() != null) {
			dao.setConditionSalaryExceptionId("=", bean.getSalaryExceptionId());
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
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getReason() != null) {
			if(bean.getReason().indexOf("%") >= 0)
				dao.setConditionReason("like", bean.getReason());
			else
				dao.setConditionReason("=", bean.getReason());
			count++;
		}
		if(bean.getAttendanceDeduction() != null) {
			dao.setConditionAttendanceDeduction("=", bean.getAttendanceDeduction());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
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
		if(bean.getIsApply() != null) {
			dao.setConditionIsApply("=", bean.getIsApply());
			count++;
		}
		if(bean.getActuallyDeduction() != null) {
			dao.setConditionActuallyDeduction("=", bean.getActuallyDeduction());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSalaryException bean = new BaseSalaryException();
		bean.setDataFromJSON(json);
		SalaryException dao = new SalaryException();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryException> rlist = new BaseCollection<>();
		BaseSalaryException bean = new BaseSalaryException();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryException dao = new SalaryException();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryException> result = dao.conditionalLoad(addtion);
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
		BaseSalaryException bean = new BaseSalaryException();
		bean.setDataFromJSON(json);
		SalaryException dao = new SalaryException();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSalaryException bean = new BaseSalaryException();
		bean.setDataFromJSON(json);
		SalaryException dao = new SalaryException();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryException bean = new BaseSalaryException();
		bean.setDataFromJSON(json);
		SalaryException dao = new SalaryException();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryException bean = new BaseSalaryException();
		bean.setDataFromJSON(json);
		SalaryException dao = new SalaryException();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


