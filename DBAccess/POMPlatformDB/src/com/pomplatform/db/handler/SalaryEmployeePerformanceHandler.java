package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryEmployeePerformance;
import com.pomplatform.db.dao.SalaryEmployeePerformance;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryEmployeePerformanceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryEmployeePerformanceHandler.class);

	public static BaseSalaryEmployeePerformance getSalaryEmployeePerformanceById( 
		java.lang.Integer salary_employee_performance_id
	) throws Exception
	{
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		dao.setSalaryEmployeePerformanceId(salary_employee_performance_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryEmployeePerformanceExists( com.pomplatform.db.bean.BaseSalaryEmployeePerformance bean, String additional ) throws Exception {

		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryEmployeePerformance( com.pomplatform.db.bean.BaseSalaryEmployeePerformance bean, String additional ) throws Exception {

		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryEmployeePerformance> querySalaryEmployeePerformance( com.pomplatform.db.bean.BaseSalaryEmployeePerformance bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryEmployeePerformance> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryEmployeePerformance> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryEmployeePerformance addToSalaryEmployeePerformance ( BaseSalaryEmployeePerformance salaryemployeeperformance )  throws Exception {
		return addToSalaryEmployeePerformance ( salaryemployeeperformance , false);
	}

	public static BaseSalaryEmployeePerformance addToSalaryEmployeePerformance ( BaseSalaryEmployeePerformance salaryemployeeperformance, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		dao.setDataFromBase(salaryemployeeperformance);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryEmployeePerformance addUpdateSalaryEmployeePerformance ( BaseSalaryEmployeePerformance salaryemployeeperformance ) throws Exception {
		return addUpdateSalaryEmployeePerformance ( salaryemployeeperformance , false);
	}

	public static BaseSalaryEmployeePerformance addUpdateSalaryEmployeePerformance ( BaseSalaryEmployeePerformance salaryemployeeperformance, boolean singleTransaction  ) throws Exception {
		if(salaryemployeeperformance.getSalaryEmployeePerformanceId() == null) return addToSalaryEmployeePerformance(salaryemployeeperformance);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		dao.setDataFromBase(salaryemployeeperformance);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salaryemployeeperformance); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryEmployeePerformance ( BaseSalaryEmployeePerformance bean ) throws Exception {
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryEmployeePerformance updateSalaryEmployeePerformance ( BaseSalaryEmployeePerformance salaryemployeeperformance ) throws Exception {
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		dao.setSalaryEmployeePerformanceId( salaryemployeeperformance.getSalaryEmployeePerformanceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salaryemployeeperformance);
			result = dao.update();
		}
		return result == 1 ? salaryemployeeperformance : null ;
	}

	public static BaseSalaryEmployeePerformance updateSalaryEmployeePerformanceDirect( BaseSalaryEmployeePerformance salaryemployeeperformance ) throws Exception {
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		int result = 0;
		dao.setDataFromBase(salaryemployeeperformance);
		result = dao.update();
		return result == 1 ? salaryemployeeperformance : null ;
	}

	public static int setDeleteConditions(BaseSalaryEmployeePerformance bean, SalaryEmployeePerformance dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryEmployeePerformanceId() != null) {
			dao.setConditionSalaryEmployeePerformanceId("=", bean.getSalaryEmployeePerformanceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
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
			if(bean.getIsSended() != null) {
				dao.setConditionIsSended("=", bean.getIsSended());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSalaryEmployeePerformance bean, SalaryEmployeePerformance dao){
		int count = 0;
		if(bean.getSalaryEmployeePerformanceId() != null) {
			dao.setConditionSalaryEmployeePerformanceId("=", bean.getSalaryEmployeePerformanceId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
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
		if(bean.getShouldDays() != null) {
			dao.setConditionShouldDays("=", bean.getShouldDays());
			count++;
		}
		if(bean.getFactDays() != null) {
			dao.setConditionFactDays("=", bean.getFactDays());
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
		if(bean.getHappenDate() != null) {
			dao.setConditionHappenDate(">=", bean.getHappenDate());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
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
		if(bean.getWorkingCoefficient() != null) {
			dao.setConditionWorkingCoefficient("=", bean.getWorkingCoefficient());
			count++;
		}
		if(bean.getActualPerformancePay() != null) {
			dao.setConditionActualPerformancePay("=", bean.getActualPerformancePay());
			count++;
		}
		if(bean.getIsSended() != null) {
			dao.setConditionIsSended("=", bean.getIsSended());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSalaryEmployeePerformance bean = new BaseSalaryEmployeePerformance();
		bean.setDataFromJSON(json);
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryEmployeePerformance> rlist = new BaseCollection<>();
		BaseSalaryEmployeePerformance bean = new BaseSalaryEmployeePerformance();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryEmployeePerformance> result = dao.conditionalLoad(addtion);
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
		BaseSalaryEmployeePerformance bean = new BaseSalaryEmployeePerformance();
		bean.setDataFromJSON(json);
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSalaryEmployeePerformance bean = new BaseSalaryEmployeePerformance();
		bean.setDataFromJSON(json);
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryEmployeePerformance bean = new BaseSalaryEmployeePerformance();
		bean.setDataFromJSON(json);
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryEmployeePerformance bean = new BaseSalaryEmployeePerformance();
		bean.setDataFromJSON(json);
		SalaryEmployeePerformance dao = new SalaryEmployeePerformance();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


