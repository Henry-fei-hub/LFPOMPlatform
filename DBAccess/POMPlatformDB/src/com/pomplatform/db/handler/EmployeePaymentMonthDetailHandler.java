package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeePaymentMonthDetail;
import com.pomplatform.db.dao.EmployeePaymentMonthDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeePaymentMonthDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeePaymentMonthDetailHandler.class);

	public static BaseEmployeePaymentMonthDetail getEmployeePaymentMonthDetailById( 
		java.lang.Integer employee_payment_month_detail_id
	) throws Exception
	{
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		dao.setEmployeePaymentMonthDetailId(employee_payment_month_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeePaymentMonthDetailExists( com.pomplatform.db.bean.BaseEmployeePaymentMonthDetail bean, String additional ) throws Exception {

		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeePaymentMonthDetail( com.pomplatform.db.bean.BaseEmployeePaymentMonthDetail bean, String additional ) throws Exception {

		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeePaymentMonthDetail> queryEmployeePaymentMonthDetail( com.pomplatform.db.bean.BaseEmployeePaymentMonthDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeePaymentMonthDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeePaymentMonthDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeePaymentMonthDetail addToEmployeePaymentMonthDetail ( BaseEmployeePaymentMonthDetail employeepaymentmonthdetail )  throws Exception {
		return addToEmployeePaymentMonthDetail ( employeepaymentmonthdetail , false);
	}

	public static BaseEmployeePaymentMonthDetail addToEmployeePaymentMonthDetail ( BaseEmployeePaymentMonthDetail employeepaymentmonthdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		dao.setDataFromBase(employeepaymentmonthdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeePaymentMonthDetail addUpdateEmployeePaymentMonthDetail ( BaseEmployeePaymentMonthDetail employeepaymentmonthdetail ) throws Exception {
		return addUpdateEmployeePaymentMonthDetail ( employeepaymentmonthdetail , false);
	}

	public static BaseEmployeePaymentMonthDetail addUpdateEmployeePaymentMonthDetail ( BaseEmployeePaymentMonthDetail employeepaymentmonthdetail, boolean singleTransaction  ) throws Exception {
		if(employeepaymentmonthdetail.getEmployeePaymentMonthDetailId() == null) return addToEmployeePaymentMonthDetail(employeepaymentmonthdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		dao.setDataFromBase(employeepaymentmonthdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeepaymentmonthdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeePaymentMonthDetail ( BaseEmployeePaymentMonthDetail bean ) throws Exception {
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeePaymentMonthDetail updateEmployeePaymentMonthDetail ( BaseEmployeePaymentMonthDetail employeepaymentmonthdetail ) throws Exception {
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		dao.setEmployeePaymentMonthDetailId( employeepaymentmonthdetail.getEmployeePaymentMonthDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeepaymentmonthdetail);
			result = dao.update();
		}
		return result == 1 ? employeepaymentmonthdetail : null ;
	}

	public static BaseEmployeePaymentMonthDetail updateEmployeePaymentMonthDetailDirect( BaseEmployeePaymentMonthDetail employeepaymentmonthdetail ) throws Exception {
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		int result = 0;
		dao.setDataFromBase(employeepaymentmonthdetail);
		result = dao.update();
		return result == 1 ? employeepaymentmonthdetail : null ;
	}

	public static int setDeleteConditions(BaseEmployeePaymentMonthDetail bean, EmployeePaymentMonthDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeePaymentMonthDetailId() != null) {
			dao.setConditionEmployeePaymentMonthDetailId("=", bean.getEmployeePaymentMonthDetailId());
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

	public static int setConditions(BaseEmployeePaymentMonthDetail bean, EmployeePaymentMonthDetail dao){
		int count = 0;
		if(bean.getEmployeePaymentMonthDetailId() != null) {
			dao.setConditionEmployeePaymentMonthDetailId("=", bean.getEmployeePaymentMonthDetailId());
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
		BaseEmployeePaymentMonthDetail bean = new BaseEmployeePaymentMonthDetail();
		bean.setDataFromJSON(json);
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeePaymentMonthDetail> rlist = new BaseCollection<>();
		BaseEmployeePaymentMonthDetail bean = new BaseEmployeePaymentMonthDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeePaymentMonthDetail> result = dao.conditionalLoad(addtion);
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
		BaseEmployeePaymentMonthDetail bean = new BaseEmployeePaymentMonthDetail();
		bean.setDataFromJSON(json);
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeePaymentMonthDetail bean = new BaseEmployeePaymentMonthDetail();
		bean.setDataFromJSON(json);
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeePaymentMonthDetail bean = new BaseEmployeePaymentMonthDetail();
		bean.setDataFromJSON(json);
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeePaymentMonthDetail bean = new BaseEmployeePaymentMonthDetail();
		bean.setDataFromJSON(json);
		EmployeePaymentMonthDetail dao = new EmployeePaymentMonthDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


