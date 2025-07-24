package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnSalaryAnnualBonusByCompany extends GenericBase implements BaseFactory<BaseOnSalaryAnnualBonusByCompany>, Comparable<BaseOnSalaryAnnualBonusByCompany> 
{


	public static BaseOnSalaryAnnualBonusByCompany newInstance(){
		return new BaseOnSalaryAnnualBonusByCompany();
	}

	@Override
	public BaseOnSalaryAnnualBonusByCompany make(){
		BaseOnSalaryAnnualBonusByCompany b = new BaseOnSalaryAnnualBonusByCompany();
		return b;
	}

	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_THIRTEEN_BONUS = "thirteen_bonus" ;
	public final static java.lang.String CS_YEAR_PERFORMANCE_BONUS = "year_performance_bonus" ;
	public final static java.lang.String CS_PROGRAM_BONUS = "program_bonus" ;
	public final static java.lang.String CS_TRANSFER_ACCOUNT_MONEY = "transfer_account_money" ;
	public final static java.lang.String CS_DEPOSIT_DEDUCT = "deposit_deduct" ;
	public final static java.lang.String CS_SHOULD_TOTAL = "should_total" ;
	public final static java.lang.String CS_SHOULD_TAX = "should_tax" ;
	public final static java.lang.String CS_FACT_BONUS = "fact_bonus" ;
	public final static java.lang.String CS_TOTAL_PAY = "total_pay" ;
	public final static java.lang.String CS_SALARY_DIFF_DEDUCT = "salary_diff_deduct" ;
	public final static java.lang.String CS_REIMBURSEMENT_DEDUCT = "reimbursement_deduct" ;
	public final static java.lang.String CS_OTHER_DEDUCT = "other_deduct" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_FLOW_STATUS = "flow_status" ;
	public final static java.lang.String CS_SEND_TIME = "send_time" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT = "instead_deduct" ;
	public final static java.lang.String CS_ONE_TO_THREE_REST = "one_to_three_rest" ;

	public final static java.lang.String ALL_CAPTIONS = "所属公司,年份,应发13薪奖金,应发年度绩效工资,应发项目奖金,调户押金返还,调户押金扣除,应发合计,应纳个税,实发奖金,全薪,补/扣工资差额,报销扣款,其他扣款,备注,流程业务表Id,流程状态,发放时间";

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.math.BigDecimal getThirteenBonus() {
		return this.__thirteen_bonus;
	}

	public void setThirteenBonus( java.math.BigDecimal value ) {
		this.__thirteen_bonus = value;
	}

	public java.math.BigDecimal getYearPerformanceBonus() {
		return this.__year_performance_bonus;
	}

	public void setYearPerformanceBonus( java.math.BigDecimal value ) {
		this.__year_performance_bonus = value;
	}

	public java.math.BigDecimal getProgramBonus() {
		return this.__program_bonus;
	}

	public void setProgramBonus( java.math.BigDecimal value ) {
		this.__program_bonus = value;
	}

	public java.math.BigDecimal getTransferAccountMoney() {
		return this.__transfer_account_money;
	}

	public void setTransferAccountMoney( java.math.BigDecimal value ) {
		this.__transfer_account_money = value;
	}

	public java.math.BigDecimal getDepositDeduct() {
		return this.__deposit_deduct;
	}

	public void setDepositDeduct( java.math.BigDecimal value ) {
		this.__deposit_deduct = value;
	}

	public java.math.BigDecimal getShouldTotal() {
		return this.__should_total;
	}

	public void setShouldTotal( java.math.BigDecimal value ) {
		this.__should_total = value;
	}

	public java.math.BigDecimal getShouldTax() {
		return this.__should_tax;
	}

	public void setShouldTax( java.math.BigDecimal value ) {
		this.__should_tax = value;
	}

	public java.math.BigDecimal getFactBonus() {
		return this.__fact_bonus;
	}

	public void setFactBonus( java.math.BigDecimal value ) {
		this.__fact_bonus = value;
	}

	public java.math.BigDecimal getTotalPay() {
		return this.__total_pay;
	}

	public void setTotalPay( java.math.BigDecimal value ) {
		this.__total_pay = value;
	}

	public java.math.BigDecimal getSalaryDiffDeduct() {
		return this.__salary_diff_deduct;
	}

	public void setSalaryDiffDeduct( java.math.BigDecimal value ) {
		this.__salary_diff_deduct = value;
	}

	public java.math.BigDecimal getReimbursementDeduct() {
		return this.__reimbursement_deduct;
	}

	public void setReimbursementDeduct( java.math.BigDecimal value ) {
		this.__reimbursement_deduct = value;
	}

	public java.math.BigDecimal getOtherDeduct() {
		return this.__other_deduct;
	}

	public void setOtherDeduct( java.math.BigDecimal value ) {
		this.__other_deduct = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getFlowStatus() {
		return this.__flow_status;
	}

	public void setFlowStatus( java.lang.Integer value ) {
		this.__flow_status = value;
	}

	public java.util.Date getSendTime() {
		return this.__send_time;
	}

	public void setSendTime( java.util.Date value ) {
		this.__send_time = value;
	}
	
	public java.lang.String getInsteadDeduct() {
		return this.__instead_deduct;
	}
	
	public void setInsteadDeduct( java.lang.String value ) {
		this.__instead_deduct = value;
	}
	
	
	public java.lang.String getOneToThreeRest() {
		return this.__one_to_three_rest;
	}
	
	public void setOneToThreeRest( java.lang.String value ) {
		this.__one_to_three_rest = value;
	}

	public void cloneCopy(BaseOnSalaryAnnualBonusByCompany __bean){
		__bean.setCompanyId(getCompanyId());
		__bean.setYear(getYear());
		__bean.setThirteenBonus(getThirteenBonus());
		__bean.setYearPerformanceBonus(getYearPerformanceBonus());
		__bean.setProgramBonus(getProgramBonus());
		__bean.setTransferAccountMoney(getTransferAccountMoney());
		__bean.setDepositDeduct(getDepositDeduct());
		__bean.setShouldTotal(getShouldTotal());
		__bean.setShouldTax(getShouldTax());
		__bean.setFactBonus(getFactBonus());
		__bean.setTotalPay(getTotalPay());
		__bean.setSalaryDiffDeduct(getSalaryDiffDeduct());
		__bean.setReimbursementDeduct(getReimbursementDeduct());
		__bean.setOtherDeduct(getOtherDeduct());
		__bean.setRemark(getRemark());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setFlowStatus(getFlowStatus());
		__bean.setSendTime(getSendTime());
		__bean.setInsteadDeduct(getInsteadDeduct());
		__bean.setOneToThreeRest(getOneToThreeRest());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getThirteenBonus() == null ? "" : getThirteenBonus());
		sb.append(",");
		sb.append(getYearPerformanceBonus() == null ? "" : getYearPerformanceBonus());
		sb.append(",");
		sb.append(getProgramBonus() == null ? "" : getProgramBonus());
		sb.append(",");
		sb.append(getTransferAccountMoney() == null ? "" : getTransferAccountMoney());
		sb.append(",");
		sb.append(getDepositDeduct() == null ? "" : getDepositDeduct());
		sb.append(",");
		sb.append(getShouldTotal() == null ? "" : getShouldTotal());
		sb.append(",");
		sb.append(getShouldTax() == null ? "" : getShouldTax());
		sb.append(",");
		sb.append(getFactBonus() == null ? "" : getFactBonus());
		sb.append(",");
		sb.append(getTotalPay() == null ? "" : getTotalPay());
		sb.append(",");
		sb.append(getSalaryDiffDeduct() == null ? "" : getSalaryDiffDeduct());
		sb.append(",");
		sb.append(getReimbursementDeduct() == null ? "" : getReimbursementDeduct());
		sb.append(",");
		sb.append(getOtherDeduct() == null ? "" : getOtherDeduct());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getFlowStatus() == null ? "" : getFlowStatus());
		sb.append(",");
		sb.append(getSendTime() == null ? "" : sdf.format(getSendTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnSalaryAnnualBonusByCompany o) {
		return __company_id == null ? -1 : __company_id.compareTo(o.getCompanyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__thirteen_bonus);
		hash = 97 * hash + Objects.hashCode(this.__year_performance_bonus);
		hash = 97 * hash + Objects.hashCode(this.__program_bonus);
		hash = 97 * hash + Objects.hashCode(this.__transfer_account_money);
		hash = 97 * hash + Objects.hashCode(this.__deposit_deduct);
		hash = 97 * hash + Objects.hashCode(this.__should_total);
		hash = 97 * hash + Objects.hashCode(this.__should_tax);
		hash = 97 * hash + Objects.hashCode(this.__fact_bonus);
		hash = 97 * hash + Objects.hashCode(this.__total_pay);
		hash = 97 * hash + Objects.hashCode(this.__salary_diff_deduct);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_deduct);
		hash = 97 * hash + Objects.hashCode(this.__other_deduct);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__flow_status);
		hash = 97 * hash + Objects.hashCode(this.__send_time);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct);
		hash = 97 * hash + Objects.hashCode(this.__one_to_three_rest);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnSalaryAnnualBonusByCompany o = (BaseOnSalaryAnnualBonusByCompany)obj;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__thirteen_bonus, o.getThirteenBonus())) return false;
		if(!Objects.equals(this.__year_performance_bonus, o.getYearPerformanceBonus())) return false;
		if(!Objects.equals(this.__program_bonus, o.getProgramBonus())) return false;
		if(!Objects.equals(this.__transfer_account_money, o.getTransferAccountMoney())) return false;
		if(!Objects.equals(this.__deposit_deduct, o.getDepositDeduct())) return false;
		if(!Objects.equals(this.__should_total, o.getShouldTotal())) return false;
		if(!Objects.equals(this.__should_tax, o.getShouldTax())) return false;
		if(!Objects.equals(this.__fact_bonus, o.getFactBonus())) return false;
		if(!Objects.equals(this.__total_pay, o.getTotalPay())) return false;
		if(!Objects.equals(this.__salary_diff_deduct, o.getSalaryDiffDeduct())) return false;
		if(!Objects.equals(this.__reimbursement_deduct, o.getReimbursementDeduct())) return false;
		if(!Objects.equals(this.__other_deduct, o.getOtherDeduct())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__flow_status, o.getFlowStatus())) return false;
		if(!Objects.equals(this.__send_time, o.getSendTime())) return false;
		if(!Objects.equals(this.__instead_deduct, o.getInsteadDeduct())) return false;
		if(!Objects.equals(this.__one_to_three_rest, o.getOneToThreeRest())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getThirteenBonus() != null) sb.append(__wrapDecimal(count++, "thirteenBonus", getThirteenBonus()));
		if(getYearPerformanceBonus() != null) sb.append(__wrapDecimal(count++, "yearPerformanceBonus", getYearPerformanceBonus()));
		if(getProgramBonus() != null) sb.append(__wrapDecimal(count++, "programBonus", getProgramBonus()));
		if(getTransferAccountMoney() != null) sb.append(__wrapDecimal(count++, "transferAccountMoney", getTransferAccountMoney()));
		if(getDepositDeduct() != null) sb.append(__wrapDecimal(count++, "depositDeduct", getDepositDeduct()));
		if(getShouldTotal() != null) sb.append(__wrapDecimal(count++, "shouldTotal", getShouldTotal()));
		if(getShouldTax() != null) sb.append(__wrapDecimal(count++, "shouldTax", getShouldTax()));
		if(getFactBonus() != null) sb.append(__wrapDecimal(count++, "factBonus", getFactBonus()));
		if(getTotalPay() != null) sb.append(__wrapDecimal(count++, "totalPay", getTotalPay()));
		if(getSalaryDiffDeduct() != null) sb.append(__wrapDecimal(count++, "salaryDiffDeduct", getSalaryDiffDeduct()));
		if(getReimbursementDeduct() != null) sb.append(__wrapDecimal(count++, "reimbursementDeduct", getReimbursementDeduct()));
		if(getOtherDeduct() != null) sb.append(__wrapDecimal(count++, "otherDeduct", getOtherDeduct()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getFlowStatus() != null) sb.append(__wrapNumber(count++, "flowStatus", getFlowStatus()));
		if(getSendTime() != null) sb.append(__wrapDate(count++, "sendTime", getSendTime()));
		if(getInsteadDeduct() != null) sb.append(__wrapString(count++, "insteadDeduct", getInsteadDeduct()));
		if(getOneToThreeRest() != null) sb.append(__wrapString(count++, "oneToThreeRest", getOneToThreeRest()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("thirteenBonus")) != null) setThirteenBonus(__getDecimal(val));  
		if((val = values.get("yearPerformanceBonus")) != null) setYearPerformanceBonus(__getDecimal(val));  
		if((val = values.get("programBonus")) != null) setProgramBonus(__getDecimal(val));  
		if((val = values.get("transferAccountMoney")) != null) setTransferAccountMoney(__getDecimal(val));  
		if((val = values.get("depositDeduct")) != null) setDepositDeduct(__getDecimal(val));  
		if((val = values.get("shouldTotal")) != null) setShouldTotal(__getDecimal(val));  
		if((val = values.get("shouldTax")) != null) setShouldTax(__getDecimal(val));  
		if((val = values.get("factBonus")) != null) setFactBonus(__getDecimal(val));  
		if((val = values.get("totalPay")) != null) setTotalPay(__getDecimal(val));  
		if((val = values.get("salaryDiffDeduct")) != null) setSalaryDiffDeduct(__getDecimal(val));  
		if((val = values.get("reimbursementDeduct")) != null) setReimbursementDeduct(__getDecimal(val));  
		if((val = values.get("otherDeduct")) != null) setOtherDeduct(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("flowStatus")) != null) setFlowStatus(__getInt(val)); 
		if((val = values.get("sendTime")) != null) setSendTime(__getDate(val)); 
		if((val = values.get("insteadDeduct")) != null) setInsteadDeduct(__getString(val));
		if((val = values.get("oneToThreeRest")) != null) setInsteadDeduct(__getString(val));
	}

	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __year ;
	protected java.math.BigDecimal  __thirteen_bonus ;
	protected java.math.BigDecimal  __year_performance_bonus ;
	protected java.math.BigDecimal  __program_bonus ;
	protected java.math.BigDecimal  __transfer_account_money ;
	protected java.math.BigDecimal  __deposit_deduct ;
	protected java.math.BigDecimal  __should_total ;
	protected java.math.BigDecimal  __should_tax ;
	protected java.math.BigDecimal  __fact_bonus ;
	protected java.math.BigDecimal  __total_pay ;
	protected java.math.BigDecimal  __salary_diff_deduct ;
	protected java.math.BigDecimal  __reimbursement_deduct ;
	protected java.math.BigDecimal  __other_deduct ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __flow_status ;
	protected java.util.Date  __send_time ;
	protected java.lang.String  __instead_deduct ;
	protected java.lang.String  __one_to_three_rest ;
}
