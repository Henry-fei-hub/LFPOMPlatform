package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeePaymentDetail;
import com.pomplatform.db.dao.EmployeePaymentDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeePaymentDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeePaymentDetailHandler.class);

	public static BaseEmployeePaymentDetail getEmployeePaymentDetailById( 
		java.lang.Integer employee_payment_detail_id
	) throws Exception
	{
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		dao.setEmployeePaymentDetailId(employee_payment_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeePaymentDetailExists( com.pomplatform.db.bean.BaseEmployeePaymentDetail bean, String additional ) throws Exception {

		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeePaymentDetail( com.pomplatform.db.bean.BaseEmployeePaymentDetail bean, String additional ) throws Exception {

		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeePaymentDetail> queryEmployeePaymentDetail( com.pomplatform.db.bean.BaseEmployeePaymentDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeePaymentDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeePaymentDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeePaymentDetail addToEmployeePaymentDetail ( BaseEmployeePaymentDetail employeepaymentdetail )  throws Exception {
		return addToEmployeePaymentDetail ( employeepaymentdetail , false);
	}

	public static BaseEmployeePaymentDetail addToEmployeePaymentDetail ( BaseEmployeePaymentDetail employeepaymentdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		dao.setDataFromBase(employeepaymentdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeePaymentDetail addUpdateEmployeePaymentDetail ( BaseEmployeePaymentDetail employeepaymentdetail ) throws Exception {
		return addUpdateEmployeePaymentDetail ( employeepaymentdetail , false);
	}

	public static BaseEmployeePaymentDetail addUpdateEmployeePaymentDetail ( BaseEmployeePaymentDetail employeepaymentdetail, boolean singleTransaction  ) throws Exception {
		if(employeepaymentdetail.getEmployeePaymentDetailId() == null) return addToEmployeePaymentDetail(employeepaymentdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		dao.setDataFromBase(employeepaymentdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeepaymentdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeePaymentDetail ( BaseEmployeePaymentDetail bean ) throws Exception {
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeePaymentDetail updateEmployeePaymentDetail ( BaseEmployeePaymentDetail employeepaymentdetail ) throws Exception {
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		dao.setEmployeePaymentDetailId( employeepaymentdetail.getEmployeePaymentDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeepaymentdetail);
			result = dao.update();
		}
		return result == 1 ? employeepaymentdetail : null ;
	}

	public static BaseEmployeePaymentDetail updateEmployeePaymentDetailDirect( BaseEmployeePaymentDetail employeepaymentdetail ) throws Exception {
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		int result = 0;
		dao.setDataFromBase(employeepaymentdetail);
		result = dao.update();
		return result == 1 ? employeepaymentdetail : null ;
	}

	public static int setDeleteConditions(BaseEmployeePaymentDetail bean, EmployeePaymentDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeePaymentDetailId() != null) {
			dao.setConditionEmployeePaymentDetailId("=", bean.getEmployeePaymentDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getDetailWeek() != null) {
				dao.setConditionDetailWeek("=", bean.getDetailWeek());
				count++;
			}
			if(bean.getBasicProportionStr() != null) {
				dao.setConditionBasicProportionStr("=", bean.getBasicProportionStr());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getLateLeave10m() != null) {
				dao.setConditionLateLeave10m("=", bean.getLateLeave10m());
				count++;
			}
			if(bean.getLateLeave30m() != null) {
				dao.setConditionLateLeave30m("=", bean.getLateLeave30m());
				count++;
			}
			if(bean.getLateLeave() != null) {
				dao.setConditionLateLeave("=", bean.getLateLeave());
				count++;
			}
			if(bean.getIllPercentStr() != null) {
				dao.setConditionIllPercentStr("=", bean.getIllPercentStr());
				count++;
			}
			if(bean.getIsLocked() != null) {
				dao.setConditionIsLocked("=", bean.getIsLocked());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeePaymentDetail bean, EmployeePaymentDetail dao){
		int count = 0;
		if(bean.getEmployeePaymentDetailId() != null) {
			dao.setConditionEmployeePaymentDetailId("=", bean.getEmployeePaymentDetailId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getDetailDate() != null) {
			dao.setConditionDetailDate(">=", bean.getDetailDate());
			count++;
		}
		if(bean.getDetailWeek() != null) {
			dao.setConditionDetailWeek("=", bean.getDetailWeek());
			count++;
		}
		if(bean.getMonthPay() != null) {
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
		if(bean.getMonthWorkDay() != null) {
			dao.setConditionMonthWorkDay("=", bean.getMonthWorkDay());
			count++;
		}
		if(bean.getMonthTotalDay() != null) {
			dao.setConditionMonthTotalDay("=", bean.getMonthTotalDay());
			count++;
		}
		if(bean.getDayWorkTime() != null) {
			dao.setConditionDayWorkTime("=", bean.getDayWorkTime());
			count++;
		}
		if(bean.getDayPay() != null) {
			dao.setConditionDayPay("=", bean.getDayPay());
			count++;
		}
		if(bean.getDayForemanPay() != null) {
			dao.setConditionDayForemanPay("=", bean.getDayForemanPay());
			count++;
		}
		if(bean.getDayCost() != null) {
			dao.setConditionDayCost("=", bean.getDayCost());
			count++;
		}
		if(bean.getUnitTotalFund() != null) {
			dao.setConditionUnitTotalFund("=", bean.getUnitTotalFund());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getLateLeave10m() != null) {
			dao.setConditionLateLeave10m("=", bean.getLateLeave10m());
			count++;
		}
		if(bean.getLateLeave30m() != null) {
			dao.setConditionLateLeave30m("=", bean.getLateLeave30m());
			count++;
		}
		if(bean.getLateLeave() != null) {
			dao.setConditionLateLeave("=", bean.getLateLeave());
			count++;
		}
		if(bean.getThingLeaveDays() != null) {
			dao.setConditionThingLeaveDays("=", bean.getThingLeaveDays());
			count++;
		}
		if(bean.getThingLeaveHours() != null) {
			dao.setConditionThingLeaveHours("=", bean.getThingLeaveHours());
			count++;
		}
		if(bean.getIllLeaveDays() != null) {
			dao.setConditionIllLeaveDays("=", bean.getIllLeaveDays());
			count++;
		}
		if(bean.getIllPercentStr() != null) {
			if(bean.getIllPercentStr().indexOf("%") >= 0)
				dao.setConditionIllPercentStr("like", bean.getIllPercentStr());
			else
				dao.setConditionIllPercentStr("=", bean.getIllPercentStr());
			count++;
		}
		if(bean.getIllPercent() != null) {
			dao.setConditionIllPercent("=", bean.getIllPercent());
			count++;
		}
		if(bean.getLateLeaveTotal() != null) {
			dao.setConditionLateLeaveTotal("=", bean.getLateLeaveTotal());
			count++;
		}
		if(bean.getThingTotal() != null) {
			dao.setConditionThingTotal("=", bean.getThingTotal());
			count++;
		}
		if(bean.getIllTotal() != null) {
			dao.setConditionIllTotal("=", bean.getIllTotal());
			count++;
		}
		if(bean.getDeductTotal() != null) {
			dao.setConditionDeductTotal("=", bean.getDeductTotal());
			count++;
		}
		if(bean.getIllLeaveHours() != null) {
			dao.setConditionIllLeaveHours("=", bean.getIllLeaveHours());
			count++;
		}
		if(bean.getUnitTotalInsurance() != null) {
			dao.setConditionUnitTotalInsurance("=", bean.getUnitTotalInsurance());
			count++;
		}
		if(bean.getAllSalary() != null) {
			dao.setConditionAllSalary("=", bean.getAllSalary());
			count++;
		}
		if(bean.getDayAttendanceDeduction() != null) {
			dao.setConditionDayAttendanceDeduction("=", bean.getDayAttendanceDeduction());
			count++;
		}
		if(bean.getIsLocked() != null) {
			dao.setConditionIsLocked("=", bean.getIsLocked());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeePaymentDetail bean = new BaseEmployeePaymentDetail();
		bean.setDataFromJSON(json);
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeePaymentDetail> rlist = new BaseCollection<>();
		BaseEmployeePaymentDetail bean = new BaseEmployeePaymentDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeePaymentDetail> result = dao.conditionalLoad(addtion);
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
		BaseEmployeePaymentDetail bean = new BaseEmployeePaymentDetail();
		bean.setDataFromJSON(json);
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeePaymentDetail bean = new BaseEmployeePaymentDetail();
		bean.setDataFromJSON(json);
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeePaymentDetail bean = new BaseEmployeePaymentDetail();
		bean.setDataFromJSON(json);
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeePaymentDetail bean = new BaseEmployeePaymentDetail();
		bean.setDataFromJSON(json);
		EmployeePaymentDetail dao = new EmployeePaymentDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


