package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeFundIssuanceDetail extends GenericBase implements BaseFactory<BaseEmployeeFundIssuanceDetail>, Comparable<BaseEmployeeFundIssuanceDetail> 
{


	public static BaseEmployeeFundIssuanceDetail newInstance(){
		return new BaseEmployeeFundIssuanceDetail();
	}

	@Override
	public BaseEmployeeFundIssuanceDetail make(){
		BaseEmployeeFundIssuanceDetail b = new BaseEmployeeFundIssuanceDetail();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_FUND_ISSUANCE_DETAIL_ID = "employee_fund_issuance_detail_id" ;
	public final static java.lang.String CS_FUNDRAISING_TYPE_ID = "fundraising_type_id" ;
	public final static java.lang.String CS_FUND_TYPE = "fund_type" ;
	public final static java.lang.String CS_EMPLOYEE_FUND_ISSUANCE_ID = "employee_fund_issuance_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_ISSUE_MONEY = "issue_money" ;
	public final static java.lang.String CS_RATIO = "ratio" ;
	public final static java.lang.String CS_AMOUNT_OF_CREDIT = "amount_of_credit" ;
	public final static java.lang.String CS_TOTAL_MONEY = "total_money" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_PERSONEL_BUSINESS_ID = "personel_business_id" ;

	public final static java.lang.String ALL_CAPTIONS = "募投工资的详情表,募投项目类型,发放类型（1工资 , 2奖金 ，3年终奖）,募投项目主表编码,员工编码,员工工号,业务部门编码,年份,月份,发放钱数,发放比例,冲账金额,总金额,创建时间,流程状态（1流程运行中 0删除或者驳回）,流程主表的主键";

	public java.lang.Integer getEmployeeFundIssuanceDetailId() {
		return this.__employee_fund_issuance_detail_id;
	}

	public void setEmployeeFundIssuanceDetailId( java.lang.Integer value ) {
		this.__employee_fund_issuance_detail_id = value;
	}

	public java.lang.Integer getFundraisingTypeId() {
		return this.__fundraising_type_id;
	}

	public void setFundraisingTypeId( java.lang.Integer value ) {
		this.__fundraising_type_id = value;
	}

	public java.lang.Integer getFundType() {
		return this.__fund_type;
	}

	public void setFundType( java.lang.Integer value ) {
		this.__fund_type = value;
	}

	public java.lang.Integer getEmployeeFundIssuanceId() {
		return this.__employee_fund_issuance_id;
	}

	public void setEmployeeFundIssuanceId( java.lang.Integer value ) {
		this.__employee_fund_issuance_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
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

	public java.math.BigDecimal getIssueMoney() {
		return this.__issue_money;
	}

	public void setIssueMoney( java.math.BigDecimal value ) {
		this.__issue_money = value;
	}

	public java.math.BigDecimal getRatio() {
		return this.__ratio;
	}

	public void setRatio( java.math.BigDecimal value ) {
		this.__ratio = value;
	}

	public java.math.BigDecimal getAmountOfCredit() {
		return this.__amount_of_credit;
	}

	public void setAmountOfCredit( java.math.BigDecimal value ) {
		this.__amount_of_credit = value;
	}

	public java.math.BigDecimal getTotalMoney() {
		return this.__total_money;
	}

	public void setTotalMoney( java.math.BigDecimal value ) {
		this.__total_money = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getPersonelBusinessId() {
		return this.__personel_business_id;
	}

	public void setPersonelBusinessId( java.lang.Integer value ) {
		this.__personel_business_id = value;
	}

	public void cloneCopy(BaseEmployeeFundIssuanceDetail __bean){
		__bean.setEmployeeFundIssuanceDetailId(getEmployeeFundIssuanceDetailId());
		__bean.setFundraisingTypeId(getFundraisingTypeId());
		__bean.setFundType(getFundType());
		__bean.setEmployeeFundIssuanceId(getEmployeeFundIssuanceId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setIssueMoney(getIssueMoney());
		__bean.setRatio(getRatio());
		__bean.setAmountOfCredit(getAmountOfCredit());
		__bean.setTotalMoney(getTotalMoney());
		__bean.setCreateTime(getCreateTime());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setPersonelBusinessId(getPersonelBusinessId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeFundIssuanceDetailId() == null ? "" : getEmployeeFundIssuanceDetailId());
		sb.append(",");
		sb.append(getFundraisingTypeId() == null ? "" : getFundraisingTypeId());
		sb.append(",");
		sb.append(getFundType() == null ? "" : getFundType());
		sb.append(",");
		sb.append(getEmployeeFundIssuanceId() == null ? "" : getEmployeeFundIssuanceId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getIssueMoney() == null ? "" : getIssueMoney());
		sb.append(",");
		sb.append(getRatio() == null ? "" : getRatio());
		sb.append(",");
		sb.append(getAmountOfCredit() == null ? "" : getAmountOfCredit());
		sb.append(",");
		sb.append(getTotalMoney() == null ? "" : getTotalMoney());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		sb.append(",");
		sb.append(getPersonelBusinessId() == null ? "" : getPersonelBusinessId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeFundIssuanceDetail o) {
		return __employee_fund_issuance_detail_id == null ? -1 : __employee_fund_issuance_detail_id.compareTo(o.getEmployeeFundIssuanceDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_fund_issuance_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__fundraising_type_id);
		hash = 97 * hash + Objects.hashCode(this.__fund_type);
		hash = 97 * hash + Objects.hashCode(this.__employee_fund_issuance_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__issue_money);
		hash = 97 * hash + Objects.hashCode(this.__ratio);
		hash = 97 * hash + Objects.hashCode(this.__amount_of_credit);
		hash = 97 * hash + Objects.hashCode(this.__total_money);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__personel_business_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeFundIssuanceDetail o = (BaseEmployeeFundIssuanceDetail)obj;
		if(!Objects.equals(this.__employee_fund_issuance_detail_id, o.getEmployeeFundIssuanceDetailId())) return false;
		if(!Objects.equals(this.__fundraising_type_id, o.getFundraisingTypeId())) return false;
		if(!Objects.equals(this.__fund_type, o.getFundType())) return false;
		if(!Objects.equals(this.__employee_fund_issuance_id, o.getEmployeeFundIssuanceId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__issue_money, o.getIssueMoney())) return false;
		if(!Objects.equals(this.__ratio, o.getRatio())) return false;
		if(!Objects.equals(this.__amount_of_credit, o.getAmountOfCredit())) return false;
		if(!Objects.equals(this.__total_money, o.getTotalMoney())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__personel_business_id, o.getPersonelBusinessId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeFundIssuanceDetailId() != null) sb.append(__wrapNumber(count++, "employeeFundIssuanceDetailId", getEmployeeFundIssuanceDetailId()));
		if(getFundraisingTypeId() != null) sb.append(__wrapNumber(count++, "fundraisingTypeId", getFundraisingTypeId()));
		if(getFundType() != null) sb.append(__wrapNumber(count++, "fundType", getFundType()));
		if(getEmployeeFundIssuanceId() != null) sb.append(__wrapNumber(count++, "employeeFundIssuanceId", getEmployeeFundIssuanceId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getIssueMoney() != null) sb.append(__wrapDecimal(count++, "issueMoney", getIssueMoney()));
		if(getRatio() != null) sb.append(__wrapDecimal(count++, "ratio", getRatio()));
		if(getAmountOfCredit() != null) sb.append(__wrapDecimal(count++, "amountOfCredit", getAmountOfCredit()));
		if(getTotalMoney() != null) sb.append(__wrapDecimal(count++, "totalMoney", getTotalMoney()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getPersonelBusinessId() != null) sb.append(__wrapNumber(count++, "personelBusinessId", getPersonelBusinessId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeFundIssuanceDetailId() != null) res.put("employeeFundIssuanceDetailId", getEmployeeFundIssuanceDetailId());
		if(getFundraisingTypeId() != null) res.put("fundraisingTypeId", getFundraisingTypeId());
		if(getFundType() != null) res.put("fundType", getFundType());
		if(getEmployeeFundIssuanceId() != null) res.put("employeeFundIssuanceId", getEmployeeFundIssuanceId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getIssueMoney() != null) res.put("issueMoney", getIssueMoney());
		if(getRatio() != null) res.put("ratio", getRatio());
		if(getAmountOfCredit() != null) res.put("amountOfCredit", getAmountOfCredit());
		if(getTotalMoney() != null) res.put("totalMoney", getTotalMoney());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		if(getPersonelBusinessId() != null) res.put("personelBusinessId", getPersonelBusinessId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeFundIssuanceDetailId")) != null) setEmployeeFundIssuanceDetailId(__getInt(val)); 
		if((val = values.get("fundraisingTypeId")) != null) setFundraisingTypeId(__getInt(val)); 
		if((val = values.get("fundType")) != null) setFundType(__getInt(val)); 
		if((val = values.get("employeeFundIssuanceId")) != null) setEmployeeFundIssuanceId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("issueMoney")) != null) setIssueMoney(__getDecimal(val));  
		if((val = values.get("ratio")) != null) setRatio(__getDecimal(val));  
		if((val = values.get("amountOfCredit")) != null) setAmountOfCredit(__getDecimal(val));  
		if((val = values.get("totalMoney")) != null) setTotalMoney(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("personelBusinessId")) != null) setPersonelBusinessId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_fund_issuance_detail_id ;
	protected java.lang.Integer  __fundraising_type_id ;
	protected java.lang.Integer  __fund_type ;
	protected java.lang.Integer  __employee_fund_issuance_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __issue_money ;
	protected java.math.BigDecimal  __ratio ;
	protected java.math.BigDecimal  __amount_of_credit ;
	protected java.math.BigDecimal  __total_money ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __process_status ;
	protected java.lang.Integer  __personel_business_id ;
}
