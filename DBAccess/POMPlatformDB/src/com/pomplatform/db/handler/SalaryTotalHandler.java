package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryTotal;
import com.pomplatform.db.dao.SalaryTotal;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryTotalHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryTotalHandler.class);

	public static BaseSalaryTotal getSalaryTotalById( 
		java.lang.Integer salary_total_id
	) throws Exception
	{
		SalaryTotal dao = new SalaryTotal();
		dao.setSalaryTotalId(salary_total_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryTotalExists( com.pomplatform.db.bean.BaseSalaryTotal bean, String additional ) throws Exception {

		SalaryTotal dao = new SalaryTotal();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryTotal( com.pomplatform.db.bean.BaseSalaryTotal bean, String additional ) throws Exception {

		SalaryTotal dao = new SalaryTotal();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryTotal> querySalaryTotal( com.pomplatform.db.bean.BaseSalaryTotal bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryTotal dao = new SalaryTotal();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryTotal> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryTotal> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryTotal addToSalaryTotal ( BaseSalaryTotal salarytotal )  throws Exception {
		return addToSalaryTotal ( salarytotal , false);
	}

	public static BaseSalaryTotal addToSalaryTotal ( BaseSalaryTotal salarytotal, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryTotal dao = new SalaryTotal();
		dao.setDataFromBase(salarytotal);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryTotal addUpdateSalaryTotal ( BaseSalaryTotal salarytotal ) throws Exception {
		return addUpdateSalaryTotal ( salarytotal , false);
	}

	public static BaseSalaryTotal addUpdateSalaryTotal ( BaseSalaryTotal salarytotal, boolean singleTransaction  ) throws Exception {
		if(salarytotal.getSalaryTotalId() == null) return addToSalaryTotal(salarytotal);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryTotal dao = new SalaryTotal();
		dao.setDataFromBase(salarytotal);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salarytotal); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryTotal ( BaseSalaryTotal bean ) throws Exception {
		SalaryTotal dao = new SalaryTotal();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryTotal updateSalaryTotal ( BaseSalaryTotal salarytotal ) throws Exception {
		SalaryTotal dao = new SalaryTotal();
		dao.setSalaryTotalId( salarytotal.getSalaryTotalId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salarytotal);
			result = dao.update();
		}
		return result == 1 ? salarytotal : null ;
	}

	public static BaseSalaryTotal updateSalaryTotalDirect( BaseSalaryTotal salarytotal ) throws Exception {
		SalaryTotal dao = new SalaryTotal();
		int result = 0;
		dao.setDataFromBase(salarytotal);
		result = dao.update();
		return result == 1 ? salarytotal : null ;
	}

	public static int setDeleteConditions(BaseSalaryTotal bean, SalaryTotal dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryTotalId() != null) {
			dao.setConditionSalaryTotalId("=", bean.getSalaryTotalId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
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
			if(bean.getBankAccount() != null) {
				dao.setConditionBankAccount("=", bean.getBankAccount());
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
			if(bean.getMonthBasicPay() != null) {
				dao.setConditionMonthBasicPay("=", bean.getMonthBasicPay());
				count++;
			}
			if(bean.getWorkMoney() != null) {
				dao.setConditionWorkMoney("=", bean.getWorkMoney());
				count++;
			}
			if(bean.getFillSendDeduct() != null) {
				dao.setConditionFillSendDeduct("=", bean.getFillSendDeduct());
				count++;
			}
			if(bean.getJobSubsidy() != null) {
				dao.setConditionJobSubsidy("=", bean.getJobSubsidy());
				count++;
			}
			if(bean.getAttendanceDeduct() != null) {
				dao.setConditionAttendanceDeduct("=", bean.getAttendanceDeduct());
				count++;
			}
			if(bean.getPerformancePay() != null) {
				dao.setConditionPerformancePay("=", bean.getPerformancePay());
				count++;
			}
			if(bean.getShouldSalary() != null) {
				dao.setConditionShouldSalary("=", bean.getShouldSalary());
				count++;
			}
			if(bean.getShouldBonus() != null) {
				dao.setConditionShouldBonus("=", bean.getShouldBonus());
				count++;
			}
			if(bean.getShouldTotal() != null) {
				dao.setConditionShouldTotal("=", bean.getShouldTotal());
				count++;
			}
			if(bean.getAlreadyBonus() != null) {
				dao.setConditionAlreadyBonus("=", bean.getAlreadyBonus());
				count++;
			}
			if(bean.getOtherBonus() != null) {
				dao.setConditionOtherBonus("=", bean.getOtherBonus());
				count++;
			}
			if(bean.getShouldTaxAchieve() != null) {
				dao.setConditionShouldTaxAchieve("=", bean.getShouldTaxAchieve());
				count++;
			}
			if(bean.getTaxTotal() != null) {
				dao.setConditionTaxTotal("=", bean.getTaxTotal());
				count++;
			}
			if(bean.getDeductTax() != null) {
				dao.setConditionDeductTax("=", bean.getDeductTax());
				count++;
			}
			if(bean.getShouldTax() != null) {
				dao.setConditionShouldTax("=", bean.getShouldTax());
				count++;
			}
			if(bean.getTotalInsurance() != null) {
				dao.setConditionTotalInsurance("=", bean.getTotalInsurance());
				count++;
			}
			if(bean.getTotalFund() != null) {
				dao.setConditionTotalFund("=", bean.getTotalFund());
				count++;
			}
			if(bean.getUnitTotalInsurance() != null) {
				dao.setConditionUnitTotalInsurance("=", bean.getUnitTotalInsurance());
				count++;
			}
			if(bean.getUnitTotalFund() != null) {
				dao.setConditionUnitTotalFund("=", bean.getUnitTotalFund());
				count++;
			}
			if(bean.getLeaveNoDeductTax() != null) {
				dao.setConditionLeaveNoDeductTax("=", bean.getLeaveNoDeductTax());
				count++;
			}
			if(bean.getLeaveDeductTax() != null) {
				dao.setConditionLeaveDeductTax("=", bean.getLeaveDeductTax());
				count++;
			}
			if(bean.getFactSalary() != null) {
				dao.setConditionFactSalary("=", bean.getFactSalary());
				count++;
			}
			if(bean.getAffiliated() != null) {
				dao.setConditionAffiliated("=", bean.getAffiliated());
				count++;
			}
			if(bean.getVoteProject() != null) {
				dao.setConditionVoteProject("=", bean.getVoteProject());
				count++;
			}
			if(bean.getVotePercent() != null) {
				dao.setConditionVotePercent("=", bean.getVotePercent());
				count++;
			}
			if(bean.getInsteadDeduct() != null) {
				dao.setConditionInsteadDeduct("=", bean.getInsteadDeduct());
				count++;
			}
			if(bean.getInsteadDeductIll() != null) {
				dao.setConditionInsteadDeductIll("=", bean.getInsteadDeductIll());
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
			if(bean.getCostAttribution() != null) {
				dao.setConditionCostAttribution("=", bean.getCostAttribution());
				count++;
			}
			if(bean.getDevelopmentProject() != null) {
				dao.setConditionDevelopmentProject("=", bean.getDevelopmentProject());
				count++;
			}
			if(bean.getSalaryTypeName() != null) {
				dao.setConditionSalaryTypeName("=", bean.getSalaryTypeName());
				count++;
			}
			if(bean.getShouldTaxAchieveSum() != null) {
				dao.setConditionShouldTaxAchieveSum("=", bean.getShouldTaxAchieveSum());
				count++;
			}
			if(bean.getIndividualIncomeTaxSum() != null) {
				dao.setConditionIndividualIncomeTaxSum("=", bean.getIndividualIncomeTaxSum());
				count++;
			}
			if(bean.getInsuranceFundSum() != null) {
				dao.setConditionInsuranceFundSum("=", bean.getInsuranceFundSum());
				count++;
			}
			if(bean.getWithholdingTax() != null) {
				dao.setConditionWithholdingTax("=", bean.getWithholdingTax());
				count++;
			}
			if(bean.getReplacementTax() != null) {
				dao.setConditionReplacementTax("=", bean.getReplacementTax());
				count++;
			}
			if(bean.getSuspendBonus() != null) {
				dao.setConditionSuspendBonus("=", bean.getSuspendBonus());
				count++;
			}
			if(bean.getOtherDeduction() != null) {
				dao.setConditionOtherDeduction("=", bean.getOtherDeduction());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSalaryTotal bean, SalaryTotal dao){
		int count = 0;
		if(bean.getSalaryTotalId() != null) {
			dao.setConditionSalaryTotalId("=", bean.getSalaryTotalId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
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
		if(bean.getBankAccount() != null) {
			if(bean.getBankAccount().indexOf("%") >= 0)
				dao.setConditionBankAccount("like", bean.getBankAccount());
			else
				dao.setConditionBankAccount("=", bean.getBankAccount());
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
		if(bean.getMonthBasicPay() != null) {
			if(bean.getMonthBasicPay().indexOf("%") >= 0)
				dao.setConditionMonthBasicPay("like", bean.getMonthBasicPay());
			else
				dao.setConditionMonthBasicPay("=", bean.getMonthBasicPay());
			count++;
		}
		if(bean.getWorkMoney() != null) {
			if(bean.getWorkMoney().indexOf("%") >= 0)
				dao.setConditionWorkMoney("like", bean.getWorkMoney());
			else
				dao.setConditionWorkMoney("=", bean.getWorkMoney());
			count++;
		}
		if(bean.getFillSendDeduct() != null) {
			if(bean.getFillSendDeduct().indexOf("%") >= 0)
				dao.setConditionFillSendDeduct("like", bean.getFillSendDeduct());
			else
				dao.setConditionFillSendDeduct("=", bean.getFillSendDeduct());
			count++;
		}
		if(bean.getJobSubsidy() != null) {
			if(bean.getJobSubsidy().indexOf("%") >= 0)
				dao.setConditionJobSubsidy("like", bean.getJobSubsidy());
			else
				dao.setConditionJobSubsidy("=", bean.getJobSubsidy());
			count++;
		}
		if(bean.getAttendanceDeduct() != null) {
			if(bean.getAttendanceDeduct().indexOf("%") >= 0)
				dao.setConditionAttendanceDeduct("like", bean.getAttendanceDeduct());
			else
				dao.setConditionAttendanceDeduct("=", bean.getAttendanceDeduct());
			count++;
		}
		if(bean.getPerformancePay() != null) {
			if(bean.getPerformancePay().indexOf("%") >= 0)
				dao.setConditionPerformancePay("like", bean.getPerformancePay());
			else
				dao.setConditionPerformancePay("=", bean.getPerformancePay());
			count++;
		}
		if(bean.getShouldSalary() != null) {
			if(bean.getShouldSalary().indexOf("%") >= 0)
				dao.setConditionShouldSalary("like", bean.getShouldSalary());
			else
				dao.setConditionShouldSalary("=", bean.getShouldSalary());
			count++;
		}
		if(bean.getShouldBonus() != null) {
			if(bean.getShouldBonus().indexOf("%") >= 0)
				dao.setConditionShouldBonus("like", bean.getShouldBonus());
			else
				dao.setConditionShouldBonus("=", bean.getShouldBonus());
			count++;
		}
		if(bean.getShouldTotal() != null) {
			if(bean.getShouldTotal().indexOf("%") >= 0)
				dao.setConditionShouldTotal("like", bean.getShouldTotal());
			else
				dao.setConditionShouldTotal("=", bean.getShouldTotal());
			count++;
		}
		if(bean.getAlreadyBonus() != null) {
			if(bean.getAlreadyBonus().indexOf("%") >= 0)
				dao.setConditionAlreadyBonus("like", bean.getAlreadyBonus());
			else
				dao.setConditionAlreadyBonus("=", bean.getAlreadyBonus());
			count++;
		}
		if(bean.getOtherBonus() != null) {
			if(bean.getOtherBonus().indexOf("%") >= 0)
				dao.setConditionOtherBonus("like", bean.getOtherBonus());
			else
				dao.setConditionOtherBonus("=", bean.getOtherBonus());
			count++;
		}
		if(bean.getTaxBegin() != null) {
			dao.setConditionTaxBegin("=", bean.getTaxBegin());
			count++;
		}
		if(bean.getShouldTaxAchieve() != null) {
			if(bean.getShouldTaxAchieve().indexOf("%") >= 0)
				dao.setConditionShouldTaxAchieve("like", bean.getShouldTaxAchieve());
			else
				dao.setConditionShouldTaxAchieve("=", bean.getShouldTaxAchieve());
			count++;
		}
		if(bean.getTaxTotal() != null) {
			if(bean.getTaxTotal().indexOf("%") >= 0)
				dao.setConditionTaxTotal("like", bean.getTaxTotal());
			else
				dao.setConditionTaxTotal("=", bean.getTaxTotal());
			count++;
		}
		if(bean.getDeductTax() != null) {
			if(bean.getDeductTax().indexOf("%") >= 0)
				dao.setConditionDeductTax("like", bean.getDeductTax());
			else
				dao.setConditionDeductTax("=", bean.getDeductTax());
			count++;
		}
		if(bean.getShouldTax() != null) {
			if(bean.getShouldTax().indexOf("%") >= 0)
				dao.setConditionShouldTax("like", bean.getShouldTax());
			else
				dao.setConditionShouldTax("=", bean.getShouldTax());
			count++;
		}
		if(bean.getTotalInsurance() != null) {
			if(bean.getTotalInsurance().indexOf("%") >= 0)
				dao.setConditionTotalInsurance("like", bean.getTotalInsurance());
			else
				dao.setConditionTotalInsurance("=", bean.getTotalInsurance());
			count++;
		}
		if(bean.getTotalFund() != null) {
			if(bean.getTotalFund().indexOf("%") >= 0)
				dao.setConditionTotalFund("like", bean.getTotalFund());
			else
				dao.setConditionTotalFund("=", bean.getTotalFund());
			count++;
		}
		if(bean.getUnitTotalInsurance() != null) {
			if(bean.getUnitTotalInsurance().indexOf("%") >= 0)
				dao.setConditionUnitTotalInsurance("like", bean.getUnitTotalInsurance());
			else
				dao.setConditionUnitTotalInsurance("=", bean.getUnitTotalInsurance());
			count++;
		}
		if(bean.getUnitTotalFund() != null) {
			if(bean.getUnitTotalFund().indexOf("%") >= 0)
				dao.setConditionUnitTotalFund("like", bean.getUnitTotalFund());
			else
				dao.setConditionUnitTotalFund("=", bean.getUnitTotalFund());
			count++;
		}
		if(bean.getLeaveNoDeductTax() != null) {
			if(bean.getLeaveNoDeductTax().indexOf("%") >= 0)
				dao.setConditionLeaveNoDeductTax("like", bean.getLeaveNoDeductTax());
			else
				dao.setConditionLeaveNoDeductTax("=", bean.getLeaveNoDeductTax());
			count++;
		}
		if(bean.getLeaveDeductTax() != null) {
			if(bean.getLeaveDeductTax().indexOf("%") >= 0)
				dao.setConditionLeaveDeductTax("like", bean.getLeaveDeductTax());
			else
				dao.setConditionLeaveDeductTax("=", bean.getLeaveDeductTax());
			count++;
		}
		if(bean.getFactSalary() != null) {
			if(bean.getFactSalary().indexOf("%") >= 0)
				dao.setConditionFactSalary("like", bean.getFactSalary());
			else
				dao.setConditionFactSalary("=", bean.getFactSalary());
			count++;
		}
		if(bean.getAffiliated() != null) {
			dao.setConditionAffiliated("=", bean.getAffiliated());
			count++;
		}
		if(bean.getVoteProject() != null) {
			if(bean.getVoteProject().indexOf("%") >= 0)
				dao.setConditionVoteProject("like", bean.getVoteProject());
			else
				dao.setConditionVoteProject("=", bean.getVoteProject());
			count++;
		}
		if(bean.getVotePercent() != null) {
			if(bean.getVotePercent().indexOf("%") >= 0)
				dao.setConditionVotePercent("like", bean.getVotePercent());
			else
				dao.setConditionVotePercent("=", bean.getVotePercent());
			count++;
		}
		if(bean.getInsteadDeduct() != null) {
			if(bean.getInsteadDeduct().indexOf("%") >= 0)
				dao.setConditionInsteadDeduct("like", bean.getInsteadDeduct());
			else
				dao.setConditionInsteadDeduct("=", bean.getInsteadDeduct());
			count++;
		}
		if(bean.getInsteadDeductIll() != null) {
			if(bean.getInsteadDeductIll().indexOf("%") >= 0)
				dao.setConditionInsteadDeductIll("like", bean.getInsteadDeductIll());
			else
				dao.setConditionInsteadDeductIll("=", bean.getInsteadDeductIll());
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
		if(bean.getCostAttribution() != null) {
			dao.setConditionCostAttribution("=", bean.getCostAttribution());
			count++;
		}
		if(bean.getDevelopmentProject() != null) {
			if(bean.getDevelopmentProject().indexOf("%") >= 0)
				dao.setConditionDevelopmentProject("like", bean.getDevelopmentProject());
			else
				dao.setConditionDevelopmentProject("=", bean.getDevelopmentProject());
			count++;
		}
		if(bean.getPersonalPension() != null) {
			dao.setConditionPersonalPension("=", bean.getPersonalPension());
			count++;
		}
		if(bean.getPersonalMedicalInsurance() != null) {
			dao.setConditionPersonalMedicalInsurance("=", bean.getPersonalMedicalInsurance());
			count++;
		}
		if(bean.getPersonalLargeMedicalInsurance() != null) {
			dao.setConditionPersonalLargeMedicalInsurance("=", bean.getPersonalLargeMedicalInsurance());
			count++;
		}
		if(bean.getPersonalUnemploymentInsurance() != null) {
			dao.setConditionPersonalUnemploymentInsurance("=", bean.getPersonalUnemploymentInsurance());
			count++;
		}
		if(bean.getPersonalHeating() != null) {
			dao.setConditionPersonalHeating("=", bean.getPersonalHeating());
			count++;
		}
		if(bean.getPersonalSeriousIllInsurance() != null) {
			dao.setConditionPersonalSeriousIllInsurance("=", bean.getPersonalSeriousIllInsurance());
			count++;
		}
		if(bean.getSalaryTypeName() != null) {
			if(bean.getSalaryTypeName().indexOf("%") >= 0)
				dao.setConditionSalaryTypeName("like", bean.getSalaryTypeName());
			else
				dao.setConditionSalaryTypeName("=", bean.getSalaryTypeName());
			count++;
		}
		if(bean.getSpecialAdditionalDuduct() != null) {
			dao.setConditionSpecialAdditionalDuduct("=", bean.getSpecialAdditionalDuduct());
			count++;
		}
		if(bean.getSpecialDuduct1() != null) {
			dao.setConditionSpecialDuduct1("=", bean.getSpecialDuduct1());
			count++;
		}
		if(bean.getSpecialDuduct2() != null) {
			dao.setConditionSpecialDuduct2("=", bean.getSpecialDuduct2());
			count++;
		}
		if(bean.getSpecialDuduct3() != null) {
			dao.setConditionSpecialDuduct3("=", bean.getSpecialDuduct3());
			count++;
		}
		if(bean.getSpecialDuduct4() != null) {
			dao.setConditionSpecialDuduct4("=", bean.getSpecialDuduct4());
			count++;
		}
		if(bean.getSpecialDuduct5() != null) {
			dao.setConditionSpecialDuduct5("=", bean.getSpecialDuduct5());
			count++;
		}
		if(bean.getSpecialDuduct6() != null) {
			dao.setConditionSpecialDuduct6("=", bean.getSpecialDuduct6());
			count++;
		}
		if(bean.getSpecialDuductSum() != null) {
			dao.setConditionSpecialDuductSum("=", bean.getSpecialDuductSum());
			count++;
		}
		if(bean.getShouldTaxAchieveSum() != null) {
			if(bean.getShouldTaxAchieveSum().indexOf("%") >= 0)
				dao.setConditionShouldTaxAchieveSum("like", bean.getShouldTaxAchieveSum());
			else
				dao.setConditionShouldTaxAchieveSum("=", bean.getShouldTaxAchieveSum());
			count++;
		}
		if(bean.getIndividualIncomeTaxSum() != null) {
			if(bean.getIndividualIncomeTaxSum().indexOf("%") >= 0)
				dao.setConditionIndividualIncomeTaxSum("like", bean.getIndividualIncomeTaxSum());
			else
				dao.setConditionIndividualIncomeTaxSum("=", bean.getIndividualIncomeTaxSum());
			count++;
		}
		if(bean.getInsuranceFundSum() != null) {
			if(bean.getInsuranceFundSum().indexOf("%") >= 0)
				dao.setConditionInsuranceFundSum("like", bean.getInsuranceFundSum());
			else
				dao.setConditionInsuranceFundSum("=", bean.getInsuranceFundSum());
			count++;
		}
		if(bean.getWithholdingTax() != null) {
			if(bean.getWithholdingTax().indexOf("%") >= 0)
				dao.setConditionWithholdingTax("like", bean.getWithholdingTax());
			else
				dao.setConditionWithholdingTax("=", bean.getWithholdingTax());
			count++;
		}
		if(bean.getReplacementTax() != null) {
			if(bean.getReplacementTax().indexOf("%") >= 0)
				dao.setConditionReplacementTax("like", bean.getReplacementTax());
			else
				dao.setConditionReplacementTax("=", bean.getReplacementTax());
			count++;
		}
		if(bean.getSuspendBonus() != null) {
			if(bean.getSuspendBonus().indexOf("%") >= 0)
				dao.setConditionSuspendBonus("like", bean.getSuspendBonus());
			else
				dao.setConditionSuspendBonus("=", bean.getSuspendBonus());
			count++;
		}
		if(bean.getOtherDeduction() != null) {
			if(bean.getOtherDeduction().indexOf("%") >= 0)
				dao.setConditionOtherDeduction("like", bean.getOtherDeduction());
			else
				dao.setConditionOtherDeduction("=", bean.getOtherDeduction());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSalaryTotal bean = new BaseSalaryTotal();
		bean.setDataFromJSON(json);
		SalaryTotal dao = new SalaryTotal();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryTotal> rlist = new BaseCollection<>();
		BaseSalaryTotal bean = new BaseSalaryTotal();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryTotal dao = new SalaryTotal();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryTotal> result = dao.conditionalLoad(addtion);
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
		BaseSalaryTotal bean = new BaseSalaryTotal();
		bean.setDataFromJSON(json);
		SalaryTotal dao = new SalaryTotal();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSalaryTotal bean = new BaseSalaryTotal();
		bean.setDataFromJSON(json);
		SalaryTotal dao = new SalaryTotal();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryTotal bean = new BaseSalaryTotal();
		bean.setDataFromJSON(json);
		SalaryTotal dao = new SalaryTotal();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryTotal bean = new BaseSalaryTotal();
		bean.setDataFromJSON(json);
		SalaryTotal dao = new SalaryTotal();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


