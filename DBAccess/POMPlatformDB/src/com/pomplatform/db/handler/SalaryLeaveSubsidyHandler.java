package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryLeaveSubsidy;
import com.pomplatform.db.dao.SalaryLeaveSubsidy;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryLeaveSubsidyHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryLeaveSubsidyHandler.class);

	public static BaseSalaryLeaveSubsidy getSalaryLeaveSubsidyById( 
		java.lang.Integer salary_leave_subsidy_id
	) throws Exception
	{
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		dao.setSalaryLeaveSubsidyId(salary_leave_subsidy_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryLeaveSubsidyExists( com.pomplatform.db.bean.BaseSalaryLeaveSubsidy bean, String additional ) throws Exception {

		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryLeaveSubsidy( com.pomplatform.db.bean.BaseSalaryLeaveSubsidy bean, String additional ) throws Exception {

		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryLeaveSubsidy> querySalaryLeaveSubsidy( com.pomplatform.db.bean.BaseSalaryLeaveSubsidy bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryLeaveSubsidy> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryLeaveSubsidy> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryLeaveSubsidy addToSalaryLeaveSubsidy ( BaseSalaryLeaveSubsidy salaryleavesubsidy )  throws Exception {
		return addToSalaryLeaveSubsidy ( salaryleavesubsidy , false);
	}

	public static BaseSalaryLeaveSubsidy addToSalaryLeaveSubsidy ( BaseSalaryLeaveSubsidy salaryleavesubsidy, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		dao.setDataFromBase(salaryleavesubsidy);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryLeaveSubsidy addUpdateSalaryLeaveSubsidy ( BaseSalaryLeaveSubsidy salaryleavesubsidy ) throws Exception {
		return addUpdateSalaryLeaveSubsidy ( salaryleavesubsidy , false);
	}

	public static BaseSalaryLeaveSubsidy addUpdateSalaryLeaveSubsidy ( BaseSalaryLeaveSubsidy salaryleavesubsidy, boolean singleTransaction  ) throws Exception {
		if(salaryleavesubsidy.getSalaryLeaveSubsidyId() == null) return addToSalaryLeaveSubsidy(salaryleavesubsidy);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		dao.setDataFromBase(salaryleavesubsidy);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salaryleavesubsidy); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryLeaveSubsidy ( BaseSalaryLeaveSubsidy bean ) throws Exception {
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryLeaveSubsidy updateSalaryLeaveSubsidy ( BaseSalaryLeaveSubsidy salaryleavesubsidy ) throws Exception {
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		dao.setSalaryLeaveSubsidyId( salaryleavesubsidy.getSalaryLeaveSubsidyId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salaryleavesubsidy);
			result = dao.update();
		}
		return result == 1 ? salaryleavesubsidy : null ;
	}

	public static BaseSalaryLeaveSubsidy updateSalaryLeaveSubsidyDirect( BaseSalaryLeaveSubsidy salaryleavesubsidy ) throws Exception {
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		int result = 0;
		dao.setDataFromBase(salaryleavesubsidy);
		result = dao.update();
		return result == 1 ? salaryleavesubsidy : null ;
	}

	public static int setDeleteConditions(BaseSalaryLeaveSubsidy bean, SalaryLeaveSubsidy dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryLeaveSubsidyId() != null) {
			dao.setConditionSalaryLeaveSubsidyId("=", bean.getSalaryLeaveSubsidyId());
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
			if(bean.getNoDeductTax() != null) {
				dao.setConditionNoDeductTax("=", bean.getNoDeductTax());
				count++;
			}
			if(bean.getDeductTax() != null) {
				dao.setConditionDeductTax("=", bean.getDeductTax());
				count++;
			}
			if(bean.getTotalAmount() != null) {
				dao.setConditionTotalAmount("=", bean.getTotalAmount());
				count++;
			}
			if(bean.getIsSended() != null) {
				dao.setConditionIsSended("=", bean.getIsSended());
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

	public static int setConditions(BaseSalaryLeaveSubsidy bean, SalaryLeaveSubsidy dao){
		int count = 0;
		if(bean.getSalaryLeaveSubsidyId() != null) {
			dao.setConditionSalaryLeaveSubsidyId("=", bean.getSalaryLeaveSubsidyId());
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
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getNoDeductTax() != null) {
			if(bean.getNoDeductTax().indexOf("%") >= 0)
				dao.setConditionNoDeductTax("like", bean.getNoDeductTax());
			else
				dao.setConditionNoDeductTax("=", bean.getNoDeductTax());
			count++;
		}
		if(bean.getDeductTax() != null) {
			if(bean.getDeductTax().indexOf("%") >= 0)
				dao.setConditionDeductTax("like", bean.getDeductTax());
			else
				dao.setConditionDeductTax("=", bean.getDeductTax());
			count++;
		}
		if(bean.getTotalAmount() != null) {
			if(bean.getTotalAmount().indexOf("%") >= 0)
				dao.setConditionTotalAmount("like", bean.getTotalAmount());
			else
				dao.setConditionTotalAmount("=", bean.getTotalAmount());
			count++;
		}
		if(bean.getIsSended() != null) {
			dao.setConditionIsSended("=", bean.getIsSended());
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
		BaseSalaryLeaveSubsidy bean = new BaseSalaryLeaveSubsidy();
		bean.setDataFromJSON(json);
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryLeaveSubsidy> rlist = new BaseCollection<>();
		BaseSalaryLeaveSubsidy bean = new BaseSalaryLeaveSubsidy();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryLeaveSubsidy> result = dao.conditionalLoad(addtion);
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
		BaseSalaryLeaveSubsidy bean = new BaseSalaryLeaveSubsidy();
		bean.setDataFromJSON(json);
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSalaryLeaveSubsidy bean = new BaseSalaryLeaveSubsidy();
		bean.setDataFromJSON(json);
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryLeaveSubsidy bean = new BaseSalaryLeaveSubsidy();
		bean.setDataFromJSON(json);
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryLeaveSubsidy bean = new BaseSalaryLeaveSubsidy();
		bean.setDataFromJSON(json);
		SalaryLeaveSubsidy dao = new SalaryLeaveSubsidy();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


