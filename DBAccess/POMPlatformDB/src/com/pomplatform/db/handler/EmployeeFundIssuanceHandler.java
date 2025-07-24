package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeFundIssuance;
import com.pomplatform.db.dao.EmployeeFundIssuance;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeFundIssuanceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeFundIssuanceHandler.class);

	public static BaseEmployeeFundIssuance getEmployeeFundIssuanceById( 
		java.lang.Integer employee_fund_issuance_id
	) throws Exception
	{
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		dao.setEmployeeFundIssuanceId(employee_fund_issuance_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeFundIssuanceExists( com.pomplatform.db.bean.BaseEmployeeFundIssuance bean, String additional ) throws Exception {

		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeFundIssuance( com.pomplatform.db.bean.BaseEmployeeFundIssuance bean, String additional ) throws Exception {

		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeFundIssuance> queryEmployeeFundIssuance( com.pomplatform.db.bean.BaseEmployeeFundIssuance bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeFundIssuance> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeFundIssuance> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeFundIssuance addToEmployeeFundIssuance ( BaseEmployeeFundIssuance employeefundissuance )  throws Exception {
		return addToEmployeeFundIssuance ( employeefundissuance , false);
	}

	public static BaseEmployeeFundIssuance addToEmployeeFundIssuance ( BaseEmployeeFundIssuance employeefundissuance, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		dao.setDataFromBase(employeefundissuance);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeFundIssuance addUpdateEmployeeFundIssuance ( BaseEmployeeFundIssuance employeefundissuance ) throws Exception {
		return addUpdateEmployeeFundIssuance ( employeefundissuance , false);
	}

	public static BaseEmployeeFundIssuance addUpdateEmployeeFundIssuance ( BaseEmployeeFundIssuance employeefundissuance, boolean singleTransaction  ) throws Exception {
		if(employeefundissuance.getEmployeeFundIssuanceId() == null) return addToEmployeeFundIssuance(employeefundissuance);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		dao.setDataFromBase(employeefundissuance);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeefundissuance); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeFundIssuance ( BaseEmployeeFundIssuance bean ) throws Exception {
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeFundIssuance updateEmployeeFundIssuance ( BaseEmployeeFundIssuance employeefundissuance ) throws Exception {
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		dao.setEmployeeFundIssuanceId( employeefundissuance.getEmployeeFundIssuanceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeefundissuance);
			result = dao.update();
		}
		return result == 1 ? employeefundissuance : null ;
	}

	public static BaseEmployeeFundIssuance updateEmployeeFundIssuanceDirect( BaseEmployeeFundIssuance employeefundissuance ) throws Exception {
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		int result = 0;
		dao.setDataFromBase(employeefundissuance);
		result = dao.update();
		return result == 1 ? employeefundissuance : null ;
	}

	public static int setDeleteConditions(BaseEmployeeFundIssuance bean, EmployeeFundIssuance dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeFundIssuanceId() != null) {
			dao.setConditionEmployeeFundIssuanceId("=", bean.getEmployeeFundIssuanceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFundrasingTypeId() != null) {
				dao.setConditionFundrasingTypeId("=", bean.getFundrasingTypeId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
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
			if(bean.getPayNumber() != null) {
				dao.setConditionPayNumber("=", bean.getPayNumber());
				count++;
			}
			if(bean.getFundType() != null) {
				dao.setConditionFundType("=", bean.getFundType());
				count++;
			}
			if(bean.getReleaseType() != null) {
				dao.setConditionReleaseType("=", bean.getReleaseType());
				count++;
			}
			if(bean.getNumberOfCredit() != null) {
				dao.setConditionNumberOfCredit("=", bean.getNumberOfCredit());
				count++;
			}
			if(bean.getAccountingNumber() != null) {
				dao.setConditionAccountingNumber("=", bean.getAccountingNumber());
				count++;
			}
			if(bean.getPersonelBusinessId() != null) {
				dao.setConditionPersonelBusinessId("=", bean.getPersonelBusinessId());
				count++;
			}
			if(bean.getProcessStatus() != null) {
				dao.setConditionProcessStatus("=", bean.getProcessStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeFundIssuance bean, EmployeeFundIssuance dao){
		int count = 0;
		if(bean.getEmployeeFundIssuanceId() != null) {
			dao.setConditionEmployeeFundIssuanceId("=", bean.getEmployeeFundIssuanceId());
			count++;
		}
		if(bean.getFundrasingTypeId() != null) {
			dao.setConditionFundrasingTypeId("=", bean.getFundrasingTypeId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
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
		if(bean.getPayNumber() != null) {
			dao.setConditionPayNumber("=", bean.getPayNumber());
			count++;
		}
		if(bean.getPayMoney() != null) {
			dao.setConditionPayMoney("=", bean.getPayMoney());
			count++;
		}
		if(bean.getFundType() != null) {
			dao.setConditionFundType("=", bean.getFundType());
			count++;
		}
		if(bean.getReleaseType() != null) {
			dao.setConditionReleaseType("=", bean.getReleaseType());
			count++;
		}
		if(bean.getAmountOfCredit() != null) {
			dao.setConditionAmountOfCredit("=", bean.getAmountOfCredit());
			count++;
		}
		if(bean.getNumberOfCredit() != null) {
			dao.setConditionNumberOfCredit("=", bean.getNumberOfCredit());
			count++;
		}
		if(bean.getTotalSum() != null) {
			dao.setConditionTotalSum("=", bean.getTotalSum());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getAccountingNumber() != null) {
			dao.setConditionAccountingNumber("=", bean.getAccountingNumber());
			count++;
		}
		if(bean.getPersonelBusinessId() != null) {
			dao.setConditionPersonelBusinessId("=", bean.getPersonelBusinessId());
			count++;
		}
		if(bean.getProcessStatus() != null) {
			dao.setConditionProcessStatus("=", bean.getProcessStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeFundIssuance bean = new BaseEmployeeFundIssuance();
		bean.setDataFromJSON(json);
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeFundIssuance> rlist = new BaseCollection<>();
		BaseEmployeeFundIssuance bean = new BaseEmployeeFundIssuance();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeFundIssuance> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeFundIssuance bean = new BaseEmployeeFundIssuance();
		bean.setDataFromJSON(json);
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeFundIssuance bean = new BaseEmployeeFundIssuance();
		bean.setDataFromJSON(json);
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeFundIssuance bean = new BaseEmployeeFundIssuance();
		bean.setDataFromJSON(json);
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeFundIssuance bean = new BaseEmployeeFundIssuance();
		bean.setDataFromJSON(json);
		EmployeeFundIssuance dao = new EmployeeFundIssuance();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


