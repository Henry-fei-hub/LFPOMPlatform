package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeFundIssuance extends GenericBase implements BaseFactory<BaseEmployeeFundIssuance>, Comparable<BaseEmployeeFundIssuance> 
{


	public static BaseEmployeeFundIssuance newInstance(){
		return new BaseEmployeeFundIssuance();
	}

	@Override
	public BaseEmployeeFundIssuance make(){
		BaseEmployeeFundIssuance b = new BaseEmployeeFundIssuance();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_FUND_ISSUANCE_ID = "employee_fund_issuance_id" ;
	public final static java.lang.String CS_FUNDRASING_TYPE_ID = "fundrasing_type_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_PAY_NUMBER = "pay_number" ;
	public final static java.lang.String CS_PAY_MONEY = "pay_money" ;
	public final static java.lang.String CS_FUND_TYPE = "fund_type" ;
	public final static java.lang.String CS_RELEASE_TYPE = "release_type" ;
	public final static java.lang.String CS_AMOUNT_OF_CREDIT = "amount_of_credit" ;
	public final static java.lang.String CS_NUMBER_OF_CREDIT = "number_of_credit" ;
	public final static java.lang.String CS_TOTAL_SUM = "total_sum" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_ACCOUNTING_NUMBER = "accounting_number" ;
	public final static java.lang.String CS_PERSONEL_BUSINESS_ID = "personel_business_id" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;

	public final static java.lang.String ALL_CAPTIONS = "资金发放总表,募投项目类型,归属公司,年份,月份,发放人数,发放钱数,资金类型（1工资 2奖金 3年终奖）,发放类型（0募投项目，1非募投项目）,冲账金额,冲账数量,总计金额,创建时间,冲账数量,流程主表的主键,流程状态(0发放中 1驳回或删除)";

	public java.lang.Integer getEmployeeFundIssuanceId() {
		return this.__employee_fund_issuance_id;
	}

	public void setEmployeeFundIssuanceId( java.lang.Integer value ) {
		this.__employee_fund_issuance_id = value;
	}

	public java.lang.Integer getFundrasingTypeId() {
		return this.__fundrasing_type_id;
	}

	public void setFundrasingTypeId( java.lang.Integer value ) {
		this.__fundrasing_type_id = value;
	}

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

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getPayNumber() {
		return this.__pay_number;
	}

	public void setPayNumber( java.lang.Integer value ) {
		this.__pay_number = value;
	}

	public java.math.BigDecimal getPayMoney() {
		return this.__pay_money;
	}

	public void setPayMoney( java.math.BigDecimal value ) {
		this.__pay_money = value;
	}

	public java.lang.Integer getFundType() {
		return this.__fund_type;
	}

	public void setFundType( java.lang.Integer value ) {
		this.__fund_type = value;
	}

	public java.lang.Integer getReleaseType() {
		return this.__release_type;
	}

	public void setReleaseType( java.lang.Integer value ) {
		this.__release_type = value;
	}

	public java.math.BigDecimal getAmountOfCredit() {
		return this.__amount_of_credit;
	}

	public void setAmountOfCredit( java.math.BigDecimal value ) {
		this.__amount_of_credit = value;
	}

	public java.lang.Integer getNumberOfCredit() {
		return this.__number_of_credit;
	}

	public void setNumberOfCredit( java.lang.Integer value ) {
		this.__number_of_credit = value;
	}

	public java.math.BigDecimal getTotalSum() {
		return this.__total_sum;
	}

	public void setTotalSum( java.math.BigDecimal value ) {
		this.__total_sum = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getAccountingNumber() {
		return this.__accounting_number;
	}

	public void setAccountingNumber( java.lang.Integer value ) {
		this.__accounting_number = value;
	}

	public java.lang.Integer getPersonelBusinessId() {
		return this.__personel_business_id;
	}

	public void setPersonelBusinessId( java.lang.Integer value ) {
		this.__personel_business_id = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public void cloneCopy(BaseEmployeeFundIssuance __bean){
		__bean.setEmployeeFundIssuanceId(getEmployeeFundIssuanceId());
		__bean.setFundrasingTypeId(getFundrasingTypeId());
		__bean.setCompanyId(getCompanyId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setPayNumber(getPayNumber());
		__bean.setPayMoney(getPayMoney());
		__bean.setFundType(getFundType());
		__bean.setReleaseType(getReleaseType());
		__bean.setAmountOfCredit(getAmountOfCredit());
		__bean.setNumberOfCredit(getNumberOfCredit());
		__bean.setTotalSum(getTotalSum());
		__bean.setCreateTime(getCreateTime());
		__bean.setAccountingNumber(getAccountingNumber());
		__bean.setPersonelBusinessId(getPersonelBusinessId());
		__bean.setProcessStatus(getProcessStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeFundIssuanceId() == null ? "" : getEmployeeFundIssuanceId());
		sb.append(",");
		sb.append(getFundrasingTypeId() == null ? "" : getFundrasingTypeId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getPayNumber() == null ? "" : getPayNumber());
		sb.append(",");
		sb.append(getPayMoney() == null ? "" : getPayMoney());
		sb.append(",");
		sb.append(getFundType() == null ? "" : getFundType());
		sb.append(",");
		sb.append(getReleaseType() == null ? "" : getReleaseType());
		sb.append(",");
		sb.append(getAmountOfCredit() == null ? "" : getAmountOfCredit());
		sb.append(",");
		sb.append(getNumberOfCredit() == null ? "" : getNumberOfCredit());
		sb.append(",");
		sb.append(getTotalSum() == null ? "" : getTotalSum());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getAccountingNumber() == null ? "" : getAccountingNumber());
		sb.append(",");
		sb.append(getPersonelBusinessId() == null ? "" : getPersonelBusinessId());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeFundIssuance o) {
		return __employee_fund_issuance_id == null ? -1 : __employee_fund_issuance_id.compareTo(o.getEmployeeFundIssuanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_fund_issuance_id);
		hash = 97 * hash + Objects.hashCode(this.__fundrasing_type_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__pay_number);
		hash = 97 * hash + Objects.hashCode(this.__pay_money);
		hash = 97 * hash + Objects.hashCode(this.__fund_type);
		hash = 97 * hash + Objects.hashCode(this.__release_type);
		hash = 97 * hash + Objects.hashCode(this.__amount_of_credit);
		hash = 97 * hash + Objects.hashCode(this.__number_of_credit);
		hash = 97 * hash + Objects.hashCode(this.__total_sum);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__accounting_number);
		hash = 97 * hash + Objects.hashCode(this.__personel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeFundIssuance o = (BaseEmployeeFundIssuance)obj;
		if(!Objects.equals(this.__employee_fund_issuance_id, o.getEmployeeFundIssuanceId())) return false;
		if(!Objects.equals(this.__fundrasing_type_id, o.getFundrasingTypeId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__pay_number, o.getPayNumber())) return false;
		if(!Objects.equals(this.__pay_money, o.getPayMoney())) return false;
		if(!Objects.equals(this.__fund_type, o.getFundType())) return false;
		if(!Objects.equals(this.__release_type, o.getReleaseType())) return false;
		if(!Objects.equals(this.__amount_of_credit, o.getAmountOfCredit())) return false;
		if(!Objects.equals(this.__number_of_credit, o.getNumberOfCredit())) return false;
		if(!Objects.equals(this.__total_sum, o.getTotalSum())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__accounting_number, o.getAccountingNumber())) return false;
		if(!Objects.equals(this.__personel_business_id, o.getPersonelBusinessId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeFundIssuanceId() != null) sb.append(__wrapNumber(count++, "employeeFundIssuanceId", getEmployeeFundIssuanceId()));
		if(getFundrasingTypeId() != null) sb.append(__wrapNumber(count++, "fundrasingTypeId", getFundrasingTypeId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getPayNumber() != null) sb.append(__wrapNumber(count++, "payNumber", getPayNumber()));
		if(getPayMoney() != null) sb.append(__wrapDecimal(count++, "payMoney", getPayMoney()));
		if(getFundType() != null) sb.append(__wrapNumber(count++, "fundType", getFundType()));
		if(getReleaseType() != null) sb.append(__wrapNumber(count++, "releaseType", getReleaseType()));
		if(getAmountOfCredit() != null) sb.append(__wrapDecimal(count++, "amountOfCredit", getAmountOfCredit()));
		if(getNumberOfCredit() != null) sb.append(__wrapNumber(count++, "numberOfCredit", getNumberOfCredit()));
		if(getTotalSum() != null) sb.append(__wrapDecimal(count++, "totalSum", getTotalSum()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getAccountingNumber() != null) sb.append(__wrapNumber(count++, "accountingNumber", getAccountingNumber()));
		if(getPersonelBusinessId() != null) sb.append(__wrapNumber(count++, "personelBusinessId", getPersonelBusinessId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeFundIssuanceId() != null) res.put("employeeFundIssuanceId", getEmployeeFundIssuanceId());
		if(getFundrasingTypeId() != null) res.put("fundrasingTypeId", getFundrasingTypeId());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getPayNumber() != null) res.put("payNumber", getPayNumber());
		if(getPayMoney() != null) res.put("payMoney", getPayMoney());
		if(getFundType() != null) res.put("fundType", getFundType());
		if(getReleaseType() != null) res.put("releaseType", getReleaseType());
		if(getAmountOfCredit() != null) res.put("amountOfCredit", getAmountOfCredit());
		if(getNumberOfCredit() != null) res.put("numberOfCredit", getNumberOfCredit());
		if(getTotalSum() != null) res.put("totalSum", getTotalSum());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getAccountingNumber() != null) res.put("accountingNumber", getAccountingNumber());
		if(getPersonelBusinessId() != null) res.put("personelBusinessId", getPersonelBusinessId());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeFundIssuanceId")) != null) setEmployeeFundIssuanceId(__getInt(val)); 
		if((val = values.get("fundrasingTypeId")) != null) setFundrasingTypeId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("payNumber")) != null) setPayNumber(__getInt(val)); 
		if((val = values.get("payMoney")) != null) setPayMoney(__getDecimal(val));  
		if((val = values.get("fundType")) != null) setFundType(__getInt(val)); 
		if((val = values.get("releaseType")) != null) setReleaseType(__getInt(val)); 
		if((val = values.get("amountOfCredit")) != null) setAmountOfCredit(__getDecimal(val));  
		if((val = values.get("numberOfCredit")) != null) setNumberOfCredit(__getInt(val)); 
		if((val = values.get("totalSum")) != null) setTotalSum(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("accountingNumber")) != null) setAccountingNumber(__getInt(val)); 
		if((val = values.get("personelBusinessId")) != null) setPersonelBusinessId(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_fund_issuance_id ;
	protected java.lang.Integer  __fundrasing_type_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __pay_number ;
	protected java.math.BigDecimal  __pay_money ;
	protected java.lang.Integer  __fund_type ;
	protected java.lang.Integer  __release_type ;
	protected java.math.BigDecimal  __amount_of_credit ;
	protected java.lang.Integer  __number_of_credit ;
	protected java.math.BigDecimal  __total_sum ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __accounting_number ;
	protected java.lang.Integer  __personel_business_id ;
	protected java.lang.Integer  __process_status ;
}
