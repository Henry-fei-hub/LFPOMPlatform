package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeePayment;
import com.pomplatform.db.dao.EmployeePayment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeePaymentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeePaymentHandler.class);

	public static BaseEmployeePayment getEmployeePaymentById( 
		java.lang.Integer employee_payment_id
	) throws Exception
	{
		EmployeePayment dao = new EmployeePayment();
		dao.setEmployeePaymentId(employee_payment_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeePaymentExists( com.pomplatform.db.bean.BaseEmployeePayment bean, String additional ) throws Exception {

		EmployeePayment dao = new EmployeePayment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeePayment( com.pomplatform.db.bean.BaseEmployeePayment bean, String additional ) throws Exception {

		EmployeePayment dao = new EmployeePayment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeePayment> queryEmployeePayment( com.pomplatform.db.bean.BaseEmployeePayment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeePayment dao = new EmployeePayment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeePayment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeePayment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeePayment addToEmployeePayment ( BaseEmployeePayment employeepayment )  throws Exception {
		return addToEmployeePayment ( employeepayment , false);
	}

	public static BaseEmployeePayment addToEmployeePayment ( BaseEmployeePayment employeepayment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeePayment dao = new EmployeePayment();
		dao.setDataFromBase(employeepayment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeePayment addUpdateEmployeePayment ( BaseEmployeePayment employeepayment ) throws Exception {
		return addUpdateEmployeePayment ( employeepayment , false);
	}

	public static BaseEmployeePayment addUpdateEmployeePayment ( BaseEmployeePayment employeepayment, boolean singleTransaction  ) throws Exception {
		if(employeepayment.getEmployeePaymentId() == null) return addToEmployeePayment(employeepayment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeePayment dao = new EmployeePayment();
		dao.setDataFromBase(employeepayment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeepayment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeePayment ( BaseEmployeePayment bean ) throws Exception {
		EmployeePayment dao = new EmployeePayment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeePayment updateEmployeePayment ( BaseEmployeePayment employeepayment ) throws Exception {
		EmployeePayment dao = new EmployeePayment();
		dao.setEmployeePaymentId( employeepayment.getEmployeePaymentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeepayment);
			result = dao.update();
		}
		return result == 1 ? employeepayment : null ;
	}

	public static BaseEmployeePayment updateEmployeePaymentDirect( BaseEmployeePayment employeepayment ) throws Exception {
		EmployeePayment dao = new EmployeePayment();
		int result = 0;
		dao.setDataFromBase(employeepayment);
		result = dao.update();
		return result == 1 ? employeepayment : null ;
	}

	public static int setDeleteConditions(BaseEmployeePayment bean, EmployeePayment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeePaymentId() != null) {
			dao.setConditionEmployeePaymentId("=", bean.getEmployeePaymentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getPaymentChangeType() != null) {
				dao.setConditionPaymentChangeType("=", bean.getPaymentChangeType());
				count++;
			}
			if(bean.getMonthPay() != null) {
				dao.setConditionMonthPay("=", bean.getMonthPay());
				count++;
			}
			if(bean.getBasicProportionStr() != null) {
				dao.setConditionBasicProportionStr("=", bean.getBasicProportionStr());
				count++;
			}
			if(bean.getMonthBasicPay() != null) {
				dao.setConditionMonthBasicPay("=", bean.getMonthBasicPay());
				count++;
			}
			if(bean.getMonthPerformancePay() != null) {
				dao.setConditionMonthPerformancePay("=", bean.getMonthPerformancePay());
				count++;
			}
			if(bean.getForemanPay() != null) {
				dao.setConditionForemanPay("=", bean.getForemanPay());
				count++;
			}
			if(bean.getOtherSubsidy() != null) {
				dao.setConditionOtherSubsidy("=", bean.getOtherSubsidy());
				count++;
			}
			if(bean.getTotalPay() != null) {
				dao.setConditionTotalPay("=", bean.getTotalPay());
				count++;
			}
			if(bean.getAnnualPerformance() != null) {
				dao.setConditionAnnualPerformance("=", bean.getAnnualPerformance());
				count++;
			}
			if(bean.getCostAttribution() != null) {
				dao.setConditionCostAttribution("=", bean.getCostAttribution());
				count++;
			}
			if(bean.getEnabled() != null) {
				dao.setConditionEnabled("=", bean.getEnabled());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeePayment bean, EmployeePayment dao){
		int count = 0;
		if(bean.getEmployeePaymentId() != null) {
			dao.setConditionEmployeePaymentId("=", bean.getEmployeePaymentId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getPaymentChangeType() != null) {
			dao.setConditionPaymentChangeType("=", bean.getPaymentChangeType());
			count++;
		}
		if(bean.getChangeDate() != null) {
			dao.setConditionChangeDate(">=", bean.getChangeDate());
			count++;
		}
		if(bean.getMonthPay() != null) {
			if(bean.getMonthPay().indexOf("%") >= 0)
				dao.setConditionMonthPay("like", bean.getMonthPay());
			else
				dao.setConditionMonthPay("=", bean.getMonthPay());
			count++;
		}
		if(bean.getBasicProportionStr() != null) {
			if(bean.getBasicProportionStr().indexOf("%") >= 0)
				dao.setConditionBasicProportionStr("like", bean.getBasicProportionStr());
			else
				dao.setConditionBasicProportionStr("=", bean.getBasicProportionStr());
			count++;
		}
		if(bean.getBasicProportion() != null) {
			dao.setConditionBasicProportion("=", bean.getBasicProportion());
			count++;
		}
		if(bean.getMonthBasicPay() != null) {
			if(bean.getMonthBasicPay().indexOf("%") >= 0)
				dao.setConditionMonthBasicPay("like", bean.getMonthBasicPay());
			else
				dao.setConditionMonthBasicPay("=", bean.getMonthBasicPay());
			count++;
		}
		if(bean.getMonthPerformancePay() != null) {
			if(bean.getMonthPerformancePay().indexOf("%") >= 0)
				dao.setConditionMonthPerformancePay("like", bean.getMonthPerformancePay());
			else
				dao.setConditionMonthPerformancePay("=", bean.getMonthPerformancePay());
			count++;
		}
		if(bean.getForemanPay() != null) {
			if(bean.getForemanPay().indexOf("%") >= 0)
				dao.setConditionForemanPay("like", bean.getForemanPay());
			else
				dao.setConditionForemanPay("=", bean.getForemanPay());
			count++;
		}
		if(bean.getOtherSubsidy() != null) {
			if(bean.getOtherSubsidy().indexOf("%") >= 0)
				dao.setConditionOtherSubsidy("like", bean.getOtherSubsidy());
			else
				dao.setConditionOtherSubsidy("=", bean.getOtherSubsidy());
			count++;
		}
		if(bean.getTotalPay() != null) {
			if(bean.getTotalPay().indexOf("%") >= 0)
				dao.setConditionTotalPay("like", bean.getTotalPay());
			else
				dao.setConditionTotalPay("=", bean.getTotalPay());
			count++;
		}
		if(bean.getAnnualPerformance() != null) {
			if(bean.getAnnualPerformance().indexOf("%") >= 0)
				dao.setConditionAnnualPerformance("like", bean.getAnnualPerformance());
			else
				dao.setConditionAnnualPerformance("=", bean.getAnnualPerformance());
			count++;
		}
		if(bean.getCostAttribution() != null) {
			dao.setConditionCostAttribution("=", bean.getCostAttribution());
			count++;
		}
		if(bean.getEnabled() != null) {
			dao.setConditionEnabled("=", bean.getEnabled());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeePayment bean = new BaseEmployeePayment();
		bean.setDataFromJSON(json);
		EmployeePayment dao = new EmployeePayment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeePayment> rlist = new BaseCollection<>();
		BaseEmployeePayment bean = new BaseEmployeePayment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeePayment dao = new EmployeePayment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeePayment> result = dao.conditionalLoad(addtion);
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
		BaseEmployeePayment bean = new BaseEmployeePayment();
		bean.setDataFromJSON(json);
		EmployeePayment dao = new EmployeePayment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeePayment bean = new BaseEmployeePayment();
		bean.setDataFromJSON(json);
		EmployeePayment dao = new EmployeePayment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeePayment bean = new BaseEmployeePayment();
		bean.setDataFromJSON(json);
		EmployeePayment dao = new EmployeePayment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeePayment bean = new BaseEmployeePayment();
		bean.setDataFromJSON(json);
		EmployeePayment dao = new EmployeePayment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


