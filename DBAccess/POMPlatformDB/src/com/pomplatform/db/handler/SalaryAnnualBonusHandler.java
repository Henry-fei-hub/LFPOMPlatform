package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryAnnualBonus;
import com.pomplatform.db.dao.SalaryAnnualBonus;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryAnnualBonusHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryAnnualBonusHandler.class);

	public static BaseSalaryAnnualBonus getSalaryAnnualBonusById( 
		java.lang.Integer salary_annual_bonus_id
	) throws Exception
	{
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		dao.setSalaryAnnualBonusId(salary_annual_bonus_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryAnnualBonusExists( com.pomplatform.db.bean.BaseSalaryAnnualBonus bean, String additional ) throws Exception {

		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryAnnualBonus( com.pomplatform.db.bean.BaseSalaryAnnualBonus bean, String additional ) throws Exception {

		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryAnnualBonus> querySalaryAnnualBonus( com.pomplatform.db.bean.BaseSalaryAnnualBonus bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryAnnualBonus> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryAnnualBonus> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryAnnualBonus addToSalaryAnnualBonus ( BaseSalaryAnnualBonus salaryannualbonus )  throws Exception {
		return addToSalaryAnnualBonus ( salaryannualbonus , false);
	}

	public static BaseSalaryAnnualBonus addToSalaryAnnualBonus ( BaseSalaryAnnualBonus salaryannualbonus, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		dao.setDataFromBase(salaryannualbonus);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryAnnualBonus addUpdateSalaryAnnualBonus ( BaseSalaryAnnualBonus salaryannualbonus ) throws Exception {
		return addUpdateSalaryAnnualBonus ( salaryannualbonus , false);
	}

	public static BaseSalaryAnnualBonus addUpdateSalaryAnnualBonus ( BaseSalaryAnnualBonus salaryannualbonus, boolean singleTransaction  ) throws Exception {
		if(salaryannualbonus.getSalaryAnnualBonusId() == null) return addToSalaryAnnualBonus(salaryannualbonus);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		dao.setDataFromBase(salaryannualbonus);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salaryannualbonus); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryAnnualBonus ( BaseSalaryAnnualBonus bean ) throws Exception {
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryAnnualBonus updateSalaryAnnualBonus ( BaseSalaryAnnualBonus salaryannualbonus ) throws Exception {
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		dao.setSalaryAnnualBonusId( salaryannualbonus.getSalaryAnnualBonusId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salaryannualbonus);
			result = dao.update();
		}
		return result == 1 ? salaryannualbonus : null ;
	}

	public static BaseSalaryAnnualBonus updateSalaryAnnualBonusDirect( BaseSalaryAnnualBonus salaryannualbonus ) throws Exception {
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		int result = 0;
		dao.setDataFromBase(salaryannualbonus);
		result = dao.update();
		return result == 1 ? salaryannualbonus : null ;
	}

	public static int setDeleteConditions(BaseSalaryAnnualBonus bean, SalaryAnnualBonus dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryAnnualBonusId() != null) {
			dao.setConditionSalaryAnnualBonusId("=", bean.getSalaryAnnualBonusId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBankAccount() != null) {
				dao.setConditionBankAccount("=", bean.getBankAccount());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
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
			if(bean.getTotalPay() != null) {
				dao.setConditionTotalPay("=", bean.getTotalPay());
				count++;
			}
			if(bean.getYearTestLevel() != null) {
				dao.setConditionYearTestLevel("=", bean.getYearTestLevel());
				count++;
			}
			if(bean.getThirteenBonus() != null) {
				dao.setConditionThirteenBonus("=", bean.getThirteenBonus());
				count++;
			}
			if(bean.getYearPerformanceBonus() != null) {
				dao.setConditionYearPerformanceBonus("=", bean.getYearPerformanceBonus());
				count++;
			}
			if(bean.getProgramBonus() != null) {
				dao.setConditionProgramBonus("=", bean.getProgramBonus());
				count++;
			}
			if(bean.getTransferAccountMoney() != null) {
				dao.setConditionTransferAccountMoney("=", bean.getTransferAccountMoney());
				count++;
			}
			if(bean.getShouldTotal() != null) {
				dao.setConditionShouldTotal("=", bean.getShouldTotal());
				count++;
			}
			if(bean.getShouldTax() != null) {
				dao.setConditionShouldTax("=", bean.getShouldTax());
				count++;
			}
			if(bean.getFactBonus() != null) {
				dao.setConditionFactBonus("=", bean.getFactBonus());
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
			if(bean.getDepositDeduct() != null) {
				dao.setConditionDepositDeduct("=", bean.getDepositDeduct());
				count++;
			}
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getFlowStatus() != null) {
				dao.setConditionFlowStatus("=", bean.getFlowStatus());
				count++;
			}
			if(bean.getSalaryDiffDeduct() != null) {
				dao.setConditionSalaryDiffDeduct("=", bean.getSalaryDiffDeduct());
				count++;
			}
			if(bean.getReimbursementDeduct() != null) {
				dao.setConditionReimbursementDeduct("=", bean.getReimbursementDeduct());
				count++;
			}
			if(bean.getOtherDeduct() != null) {
				dao.setConditionOtherDeduct("=", bean.getOtherDeduct());
				count++;
			}
			if(bean.getAlreadyBonus() != null) {
				dao.setConditionAlreadyBonus("=", bean.getAlreadyBonus());
				count++;
			}
			if(bean.getShouldTaxAchieve() != null) {
				dao.setConditionShouldTaxAchieve("=", bean.getShouldTaxAchieve());
				count++;
			}
			if(bean.getOneToThreeRest() != null) {
				dao.setConditionOneToThreeRest("=", bean.getOneToThreeRest());
				count++;
			}
			if(bean.getHousingSubsidy() != null) {
				dao.setConditionHousingSubsidy("=", bean.getHousingSubsidy());
				count++;
			}
			if(bean.getDeductPerformanceBonus() != null) {
				dao.setConditionDeductPerformanceBonus("=", bean.getDeductPerformanceBonus());
				count++;
			}
			if(bean.getInsteadDeduct() != null) {
				dao.setConditionInsteadDeduct("=", bean.getInsteadDeduct());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSalaryAnnualBonus bean, SalaryAnnualBonus dao){
		int count = 0;
		if(bean.getSalaryAnnualBonusId() != null) {
			dao.setConditionSalaryAnnualBonusId("=", bean.getSalaryAnnualBonusId());
			count++;
		}
		if(bean.getBankAccount() != null) {
			if(bean.getBankAccount().indexOf("%") >= 0)
				dao.setConditionBankAccount("like", bean.getBankAccount());
			else
				dao.setConditionBankAccount("=", bean.getBankAccount());
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
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
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
		if(bean.getTotalPay() != null) {
			if(bean.getTotalPay().indexOf("%") >= 0)
				dao.setConditionTotalPay("like", bean.getTotalPay());
			else
				dao.setConditionTotalPay("=", bean.getTotalPay());
			count++;
		}
		if(bean.getYearShouldWorkDay() != null) {
			dao.setConditionYearShouldWorkDay("=", bean.getYearShouldWorkDay());
			count++;
		}
		if(bean.getYearFactWorkDay() != null) {
			dao.setConditionYearFactWorkDay("=", bean.getYearFactWorkDay());
			count++;
		}
		if(bean.getYearServiceNum() != null) {
			dao.setConditionYearServiceNum("=", bean.getYearServiceNum());
			count++;
		}
		if(bean.getYearTestLevel() != null) {
			if(bean.getYearTestLevel().indexOf("%") >= 0)
				dao.setConditionYearTestLevel("like", bean.getYearTestLevel());
			else
				dao.setConditionYearTestLevel("=", bean.getYearTestLevel());
			count++;
		}
		if(bean.getTestNum() != null) {
			dao.setConditionTestNum("=", bean.getTestNum());
			count++;
		}
		if(bean.getThirteenBonus() != null) {
			if(bean.getThirteenBonus().indexOf("%") >= 0)
				dao.setConditionThirteenBonus("like", bean.getThirteenBonus());
			else
				dao.setConditionThirteenBonus("=", bean.getThirteenBonus());
			count++;
		}
		if(bean.getYearPerformanceBonus() != null) {
			if(bean.getYearPerformanceBonus().indexOf("%") >= 0)
				dao.setConditionYearPerformanceBonus("like", bean.getYearPerformanceBonus());
			else
				dao.setConditionYearPerformanceBonus("=", bean.getYearPerformanceBonus());
			count++;
		}
		if(bean.getProgramBonus() != null) {
			if(bean.getProgramBonus().indexOf("%") >= 0)
				dao.setConditionProgramBonus("like", bean.getProgramBonus());
			else
				dao.setConditionProgramBonus("=", bean.getProgramBonus());
			count++;
		}
		if(bean.getTransferAccountMoney() != null) {
			if(bean.getTransferAccountMoney().indexOf("%") >= 0)
				dao.setConditionTransferAccountMoney("like", bean.getTransferAccountMoney());
			else
				dao.setConditionTransferAccountMoney("=", bean.getTransferAccountMoney());
			count++;
		}
		if(bean.getShouldTotal() != null) {
			if(bean.getShouldTotal().indexOf("%") >= 0)
				dao.setConditionShouldTotal("like", bean.getShouldTotal());
			else
				dao.setConditionShouldTotal("=", bean.getShouldTotal());
			count++;
		}
		if(bean.getShouldTax() != null) {
			if(bean.getShouldTax().indexOf("%") >= 0)
				dao.setConditionShouldTax("like", bean.getShouldTax());
			else
				dao.setConditionShouldTax("=", bean.getShouldTax());
			count++;
		}
		if(bean.getFactBonus() != null) {
			if(bean.getFactBonus().indexOf("%") >= 0)
				dao.setConditionFactBonus("like", bean.getFactBonus());
			else
				dao.setConditionFactBonus("=", bean.getFactBonus());
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
		if(bean.getDepositDeduct() != null) {
			if(bean.getDepositDeduct().indexOf("%") >= 0)
				dao.setConditionDepositDeduct("like", bean.getDepositDeduct());
			else
				dao.setConditionDepositDeduct("=", bean.getDepositDeduct());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getFlowStatus() != null) {
			dao.setConditionFlowStatus("=", bean.getFlowStatus());
			count++;
		}
		if(bean.getSalaryDiffDeduct() != null) {
			if(bean.getSalaryDiffDeduct().indexOf("%") >= 0)
				dao.setConditionSalaryDiffDeduct("like", bean.getSalaryDiffDeduct());
			else
				dao.setConditionSalaryDiffDeduct("=", bean.getSalaryDiffDeduct());
			count++;
		}
		if(bean.getReimbursementDeduct() != null) {
			if(bean.getReimbursementDeduct().indexOf("%") >= 0)
				dao.setConditionReimbursementDeduct("like", bean.getReimbursementDeduct());
			else
				dao.setConditionReimbursementDeduct("=", bean.getReimbursementDeduct());
			count++;
		}
		if(bean.getOtherDeduct() != null) {
			if(bean.getOtherDeduct().indexOf("%") >= 0)
				dao.setConditionOtherDeduct("like", bean.getOtherDeduct());
			else
				dao.setConditionOtherDeduct("=", bean.getOtherDeduct());
			count++;
		}
		if(bean.getAlreadyBonus() != null) {
			if(bean.getAlreadyBonus().indexOf("%") >= 0)
				dao.setConditionAlreadyBonus("like", bean.getAlreadyBonus());
			else
				dao.setConditionAlreadyBonus("=", bean.getAlreadyBonus());
			count++;
		}
		if(bean.getShouldTaxAchieve() != null) {
			if(bean.getShouldTaxAchieve().indexOf("%") >= 0)
				dao.setConditionShouldTaxAchieve("like", bean.getShouldTaxAchieve());
			else
				dao.setConditionShouldTaxAchieve("=", bean.getShouldTaxAchieve());
			count++;
		}
		if(bean.getSendTime() != null) {
			dao.setConditionSendTime(">=", bean.getSendTime());
			count++;
		}
		if(bean.getFinishTime() != null) {
			dao.setConditionFinishTime(">=", bean.getFinishTime());
			count++;
		}
		if(bean.getOneToThreeRest() != null) {
			if(bean.getOneToThreeRest().indexOf("%") >= 0)
				dao.setConditionOneToThreeRest("like", bean.getOneToThreeRest());
			else
				dao.setConditionOneToThreeRest("=", bean.getOneToThreeRest());
			count++;
		}
		if(bean.getHousingSubsidy() != null) {
			if(bean.getHousingSubsidy().indexOf("%") >= 0)
				dao.setConditionHousingSubsidy("like", bean.getHousingSubsidy());
			else
				dao.setConditionHousingSubsidy("=", bean.getHousingSubsidy());
			count++;
		}
		if(bean.getDeductPerformanceBonus() != null) {
			if(bean.getDeductPerformanceBonus().indexOf("%") >= 0)
				dao.setConditionDeductPerformanceBonus("like", bean.getDeductPerformanceBonus());
			else
				dao.setConditionDeductPerformanceBonus("=", bean.getDeductPerformanceBonus());
			count++;
		}
		if(bean.getInsteadDeduct() != null) {
			if(bean.getInsteadDeduct().indexOf("%") >= 0)
				dao.setConditionInsteadDeduct("like", bean.getInsteadDeduct());
			else
				dao.setConditionInsteadDeduct("=", bean.getInsteadDeduct());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSalaryAnnualBonus bean = new BaseSalaryAnnualBonus();
		bean.setDataFromJSON(json);
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryAnnualBonus> rlist = new BaseCollection<>();
		BaseSalaryAnnualBonus bean = new BaseSalaryAnnualBonus();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryAnnualBonus> result = dao.conditionalLoad(addtion);
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
		BaseSalaryAnnualBonus bean = new BaseSalaryAnnualBonus();
		bean.setDataFromJSON(json);
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSalaryAnnualBonus bean = new BaseSalaryAnnualBonus();
		bean.setDataFromJSON(json);
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryAnnualBonus bean = new BaseSalaryAnnualBonus();
		bean.setDataFromJSON(json);
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryAnnualBonus bean = new BaseSalaryAnnualBonus();
		bean.setDataFromJSON(json);
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


