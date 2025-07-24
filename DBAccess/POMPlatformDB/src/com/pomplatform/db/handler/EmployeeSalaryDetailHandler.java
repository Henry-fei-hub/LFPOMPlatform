package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.dao.EmployeeSalaryDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeSalaryDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeSalaryDetailHandler.class);

	public static BaseEmployeeSalaryDetail getEmployeeSalaryDetailById( 
		java.lang.Integer employee_salary_detail_id
	) throws Exception
	{
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		dao.setEmployeeSalaryDetailId(employee_salary_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeSalaryDetailExists( com.pomplatform.db.bean.BaseEmployeeSalaryDetail bean, String additional ) throws Exception {

		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeSalaryDetail( com.pomplatform.db.bean.BaseEmployeeSalaryDetail bean, String additional ) throws Exception {

		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeSalaryDetail> queryEmployeeSalaryDetail( com.pomplatform.db.bean.BaseEmployeeSalaryDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeSalaryDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeSalaryDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeSalaryDetail addToEmployeeSalaryDetail ( BaseEmployeeSalaryDetail employeesalarydetail )  throws Exception {
		return addToEmployeeSalaryDetail ( employeesalarydetail , false);
	}

	public static BaseEmployeeSalaryDetail addToEmployeeSalaryDetail ( BaseEmployeeSalaryDetail employeesalarydetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		dao.setDataFromBase(employeesalarydetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeSalaryDetail addUpdateEmployeeSalaryDetail ( BaseEmployeeSalaryDetail employeesalarydetail ) throws Exception {
		return addUpdateEmployeeSalaryDetail ( employeesalarydetail , false);
	}

	public static BaseEmployeeSalaryDetail addUpdateEmployeeSalaryDetail ( BaseEmployeeSalaryDetail employeesalarydetail, boolean singleTransaction  ) throws Exception {
		if(employeesalarydetail.getEmployeeSalaryDetailId() == null) return addToEmployeeSalaryDetail(employeesalarydetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		dao.setDataFromBase(employeesalarydetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeesalarydetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeSalaryDetail ( BaseEmployeeSalaryDetail bean ) throws Exception {
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeSalaryDetail updateEmployeeSalaryDetail ( BaseEmployeeSalaryDetail employeesalarydetail ) throws Exception {
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		dao.setEmployeeSalaryDetailId( employeesalarydetail.getEmployeeSalaryDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeesalarydetail);
			result = dao.update();
		}
		return result == 1 ? employeesalarydetail : null ;
	}

	public static BaseEmployeeSalaryDetail updateEmployeeSalaryDetailDirect( BaseEmployeeSalaryDetail employeesalarydetail ) throws Exception {
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		int result = 0;
		dao.setDataFromBase(employeesalarydetail);
		result = dao.update();
		return result == 1 ? employeesalarydetail : null ;
	}

	public static int setDeleteConditions(BaseEmployeeSalaryDetail bean, EmployeeSalaryDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeSalaryDetailId() != null) {
			dao.setConditionEmployeeSalaryDetailId("=", bean.getEmployeeSalaryDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getAllSalary() != null) {
				dao.setConditionAllSalary("=", bean.getAllSalary());
				count++;
			}
			if(bean.getBasicProportion() != null) {
				dao.setConditionBasicProportion("=", bean.getBasicProportion());
				count++;
			}
			if(bean.getPerformanceBonus() != null) {
				dao.setConditionPerformanceBonus("=", bean.getPerformanceBonus());
				count++;
			}
			if(bean.getBasicSalary() != null) {
				dao.setConditionBasicSalary("=", bean.getBasicSalary());
				count++;
			}
			if(bean.getWorkSubsidies() != null) {
				dao.setConditionWorkSubsidies("=", bean.getWorkSubsidies());
				count++;
			}
			if(bean.getWorkYearSalary() != null) {
				dao.setConditionWorkYearSalary("=", bean.getWorkYearSalary());
				count++;
			}
			if(bean.getAnotherPlaceSubsidies() != null) {
				dao.setConditionAnotherPlaceSubsidies("=", bean.getAnotherPlaceSubsidies());
				count++;
			}
			if(bean.getDeductSalary() != null) {
				dao.setConditionDeductSalary("=", bean.getDeductSalary());
				count++;
			}
			if(bean.getPositiveAccount() != null) {
				dao.setConditionPositiveAccount("=", bean.getPositiveAccount());
				count++;
			}
			if(bean.getShouldPaySalary() != null) {
				dao.setConditionShouldPaySalary("=", bean.getShouldPaySalary());
				count++;
			}
			if(bean.getLastMonthAchievementEffect() != null) {
				dao.setConditionLastMonthAchievementEffect("=", bean.getLastMonthAchievementEffect());
				count++;
			}
			if(bean.getProjectBonus() != null) {
				dao.setConditionProjectBonus("=", bean.getProjectBonus());
				count++;
			}
			if(bean.getTaxableIncome() != null) {
				dao.setConditionTaxableIncome("=", bean.getTaxableIncome());
				count++;
			}
			if(bean.getIncomeTotal() != null) {
				dao.setConditionIncomeTotal("=", bean.getIncomeTotal());
				count++;
			}
			if(bean.getDeductIncome() != null) {
				dao.setConditionDeductIncome("=", bean.getDeductIncome());
				count++;
			}
			if(bean.getShouldPayIncome() != null) {
				dao.setConditionShouldPayIncome("=", bean.getShouldPayIncome());
				count++;
			}
			if(bean.getSocialSecurity() != null) {
				dao.setConditionSocialSecurity("=", bean.getSocialSecurity());
				count++;
			}
			if(bean.getReservedFunds() != null) {
				dao.setConditionReservedFunds("=", bean.getReservedFunds());
				count++;
			}
			if(bean.getWithholdBorrow() != null) {
				dao.setConditionWithholdBorrow("=", bean.getWithholdBorrow());
				count++;
			}
			if(bean.getLeaveSubsidies() != null) {
				dao.setConditionLeaveSubsidies("=", bean.getLeaveSubsidies());
				count++;
			}
			if(bean.getFactPaySalary() != null) {
				dao.setConditionFactPaySalary("=", bean.getFactPaySalary());
				count++;
			}
			if(bean.getUnitSocialSecurity() != null) {
				dao.setConditionUnitSocialSecurity("=", bean.getUnitSocialSecurity());
				count++;
			}
			if(bean.getSecretKey() != null) {
				dao.setConditionSecretKey("=", bean.getSecretKey());
				count++;
			}
			if(bean.getBankAccount() != null) {
				dao.setConditionBankAccount("=", bean.getBankAccount());
				count++;
			}
			if(bean.getSalaryYear() != null) {
				dao.setConditionSalaryYear("=", bean.getSalaryYear());
				count++;
			}
			if(bean.getSalaryMonth() != null) {
				dao.setConditionSalaryMonth("=", bean.getSalaryMonth());
				count++;
			}
			if(bean.getIsReturn() != null) {
				dao.setConditionIsReturn("=", bean.getIsReturn());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeSalaryDetail bean, EmployeeSalaryDetail dao){
		int count = 0;
		if(bean.getEmployeeSalaryDetailId() != null) {
			dao.setConditionEmployeeSalaryDetailId("=", bean.getEmployeeSalaryDetailId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEntryDate() != null) {
			dao.setConditionEntryDate(">=", bean.getEntryDate());
			count++;
		}
		if(bean.getPositiveDate() != null) {
			dao.setConditionPositiveDate(">=", bean.getPositiveDate());
			count++;
		}
		if(bean.getAllSalary() != null) {
			if(bean.getAllSalary().indexOf("%") >= 0)
				dao.setConditionAllSalary("like", bean.getAllSalary());
			else
				dao.setConditionAllSalary("=", bean.getAllSalary());
			count++;
		}
		if(bean.getBasicProportion() != null) {
			if(bean.getBasicProportion().indexOf("%") >= 0)
				dao.setConditionBasicProportion("like", bean.getBasicProportion());
			else
				dao.setConditionBasicProportion("=", bean.getBasicProportion());
			count++;
		}
		if(bean.getPerformanceBonus() != null) {
			if(bean.getPerformanceBonus().indexOf("%") >= 0)
				dao.setConditionPerformanceBonus("like", bean.getPerformanceBonus());
			else
				dao.setConditionPerformanceBonus("=", bean.getPerformanceBonus());
			count++;
		}
		if(bean.getBasicSalary() != null) {
			if(bean.getBasicSalary().indexOf("%") >= 0)
				dao.setConditionBasicSalary("like", bean.getBasicSalary());
			else
				dao.setConditionBasicSalary("=", bean.getBasicSalary());
			count++;
		}
		if(bean.getWorkSubsidies() != null) {
			if(bean.getWorkSubsidies().indexOf("%") >= 0)
				dao.setConditionWorkSubsidies("like", bean.getWorkSubsidies());
			else
				dao.setConditionWorkSubsidies("=", bean.getWorkSubsidies());
			count++;
		}
		if(bean.getWorkYearSalary() != null) {
			if(bean.getWorkYearSalary().indexOf("%") >= 0)
				dao.setConditionWorkYearSalary("like", bean.getWorkYearSalary());
			else
				dao.setConditionWorkYearSalary("=", bean.getWorkYearSalary());
			count++;
		}
		if(bean.getAnotherPlaceSubsidies() != null) {
			if(bean.getAnotherPlaceSubsidies().indexOf("%") >= 0)
				dao.setConditionAnotherPlaceSubsidies("like", bean.getAnotherPlaceSubsidies());
			else
				dao.setConditionAnotherPlaceSubsidies("=", bean.getAnotherPlaceSubsidies());
			count++;
		}
		if(bean.getDeductSalary() != null) {
			if(bean.getDeductSalary().indexOf("%") >= 0)
				dao.setConditionDeductSalary("like", bean.getDeductSalary());
			else
				dao.setConditionDeductSalary("=", bean.getDeductSalary());
			count++;
		}
		if(bean.getPositiveAccount() != null) {
			if(bean.getPositiveAccount().indexOf("%") >= 0)
				dao.setConditionPositiveAccount("like", bean.getPositiveAccount());
			else
				dao.setConditionPositiveAccount("=", bean.getPositiveAccount());
			count++;
		}
		if(bean.getShouldPaySalary() != null) {
			if(bean.getShouldPaySalary().indexOf("%") >= 0)
				dao.setConditionShouldPaySalary("like", bean.getShouldPaySalary());
			else
				dao.setConditionShouldPaySalary("=", bean.getShouldPaySalary());
			count++;
		}
		if(bean.getLastMonthAchievementEffect() != null) {
			if(bean.getLastMonthAchievementEffect().indexOf("%") >= 0)
				dao.setConditionLastMonthAchievementEffect("like", bean.getLastMonthAchievementEffect());
			else
				dao.setConditionLastMonthAchievementEffect("=", bean.getLastMonthAchievementEffect());
			count++;
		}
		if(bean.getProjectBonus() != null) {
			if(bean.getProjectBonus().indexOf("%") >= 0)
				dao.setConditionProjectBonus("like", bean.getProjectBonus());
			else
				dao.setConditionProjectBonus("=", bean.getProjectBonus());
			count++;
		}
		if(bean.getTaxableIncome() != null) {
			if(bean.getTaxableIncome().indexOf("%") >= 0)
				dao.setConditionTaxableIncome("like", bean.getTaxableIncome());
			else
				dao.setConditionTaxableIncome("=", bean.getTaxableIncome());
			count++;
		}
		if(bean.getIncomeTotal() != null) {
			if(bean.getIncomeTotal().indexOf("%") >= 0)
				dao.setConditionIncomeTotal("like", bean.getIncomeTotal());
			else
				dao.setConditionIncomeTotal("=", bean.getIncomeTotal());
			count++;
		}
		if(bean.getDeductIncome() != null) {
			if(bean.getDeductIncome().indexOf("%") >= 0)
				dao.setConditionDeductIncome("like", bean.getDeductIncome());
			else
				dao.setConditionDeductIncome("=", bean.getDeductIncome());
			count++;
		}
		if(bean.getShouldPayIncome() != null) {
			if(bean.getShouldPayIncome().indexOf("%") >= 0)
				dao.setConditionShouldPayIncome("like", bean.getShouldPayIncome());
			else
				dao.setConditionShouldPayIncome("=", bean.getShouldPayIncome());
			count++;
		}
		if(bean.getSocialSecurity() != null) {
			if(bean.getSocialSecurity().indexOf("%") >= 0)
				dao.setConditionSocialSecurity("like", bean.getSocialSecurity());
			else
				dao.setConditionSocialSecurity("=", bean.getSocialSecurity());
			count++;
		}
		if(bean.getReservedFunds() != null) {
			if(bean.getReservedFunds().indexOf("%") >= 0)
				dao.setConditionReservedFunds("like", bean.getReservedFunds());
			else
				dao.setConditionReservedFunds("=", bean.getReservedFunds());
			count++;
		}
		if(bean.getWithholdBorrow() != null) {
			if(bean.getWithholdBorrow().indexOf("%") >= 0)
				dao.setConditionWithholdBorrow("like", bean.getWithholdBorrow());
			else
				dao.setConditionWithholdBorrow("=", bean.getWithholdBorrow());
			count++;
		}
		if(bean.getLeaveSubsidies() != null) {
			if(bean.getLeaveSubsidies().indexOf("%") >= 0)
				dao.setConditionLeaveSubsidies("like", bean.getLeaveSubsidies());
			else
				dao.setConditionLeaveSubsidies("=", bean.getLeaveSubsidies());
			count++;
		}
		if(bean.getFactPaySalary() != null) {
			if(bean.getFactPaySalary().indexOf("%") >= 0)
				dao.setConditionFactPaySalary("like", bean.getFactPaySalary());
			else
				dao.setConditionFactPaySalary("=", bean.getFactPaySalary());
			count++;
		}
		if(bean.getUnitSocialSecurity() != null) {
			if(bean.getUnitSocialSecurity().indexOf("%") >= 0)
				dao.setConditionUnitSocialSecurity("like", bean.getUnitSocialSecurity());
			else
				dao.setConditionUnitSocialSecurity("=", bean.getUnitSocialSecurity());
			count++;
		}
		if(bean.getSecretKey() != null) {
			if(bean.getSecretKey().indexOf("%") >= 0)
				dao.setConditionSecretKey("like", bean.getSecretKey());
			else
				dao.setConditionSecretKey("=", bean.getSecretKey());
			count++;
		}
		if(bean.getBankAccount() != null) {
			if(bean.getBankAccount().indexOf("%") >= 0)
				dao.setConditionBankAccount("like", bean.getBankAccount());
			else
				dao.setConditionBankAccount("=", bean.getBankAccount());
			count++;
		}
		if(bean.getSalaryYear() != null) {
			dao.setConditionSalaryYear("=", bean.getSalaryYear());
			count++;
		}
		if(bean.getSalaryMonth() != null) {
			dao.setConditionSalaryMonth("=", bean.getSalaryMonth());
			count++;
		}
		if(bean.getIsReturn() != null) {
			dao.setConditionIsReturn("=", bean.getIsReturn());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeSalaryDetail bean = new BaseEmployeeSalaryDetail();
		bean.setDataFromJSON(json);
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeSalaryDetail> rlist = new BaseCollection<>();
		BaseEmployeeSalaryDetail bean = new BaseEmployeeSalaryDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeSalaryDetail> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeSalaryDetail bean = new BaseEmployeeSalaryDetail();
		bean.setDataFromJSON(json);
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeSalaryDetail bean = new BaseEmployeeSalaryDetail();
		bean.setDataFromJSON(json);
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeSalaryDetail bean = new BaseEmployeeSalaryDetail();
		bean.setDataFromJSON(json);
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeSalaryDetail bean = new BaseEmployeeSalaryDetail();
		bean.setDataFromJSON(json);
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


