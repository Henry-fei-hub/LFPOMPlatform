package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseRevenueRecord extends GenericBase implements BaseFactory<BaseRevenueRecord>, Comparable<BaseRevenueRecord> 
{


	public static BaseRevenueRecord newInstance(){
		return new BaseRevenueRecord();
	}

	@Override
	public BaseRevenueRecord make(){
		BaseRevenueRecord b = new BaseRevenueRecord();
		return b;
	}

	public final static java.lang.String CS_REVENUE_RECORD_ID = "revenue_record_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_MONEY = "money" ;
	public final static java.lang.String CS_FINISH_PERCENT = "finish_percent" ;
	public final static java.lang.String CS_FINISH_PERCENT_VIEW = "finish_percent_view" ;
	public final static java.lang.String CS_REVENUE_MONEY = "revenue_money" ;
	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_SIGNING_COMPANY = "signing_company" ;
	public final static java.lang.String CS_IS_FINISH = "is_finish" ;
	public final static java.lang.String CS_ACCOUNT_DATE = "account_date" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_FINISH_PERCENT_DETAIL = "finish_percent_detail" ;
	public final static java.lang.String CS_FINISH_PERCENT_DETAIL_VIEW = "finish_percent_detail_view" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同编码,编号,名称,金额,完工比,完工比(显示),营收金额,发票金额,回款金额,父级编码,签约公司,合同是否完成,结算日期,记录月份,2月末计算,操作人,操作时间,完工比明细,完工比明细(显示)";

	public java.lang.Integer getRevenueRecordId() {
		return this.__revenue_record_id;
	}

	public void setRevenueRecordId( java.lang.Integer value ) {
		this.__revenue_record_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.math.BigDecimal getMoney() {
		return this.__money;
	}

	public void setMoney( java.math.BigDecimal value ) {
		this.__money = value;
	}

	public java.math.BigDecimal getFinishPercent() {
		return this.__finish_percent;
	}

	public void setFinishPercent( java.math.BigDecimal value ) {
		this.__finish_percent = value;
	}

	public java.lang.String getFinishPercentView() {
		return this.__finish_percent_view;
	}

	public void setFinishPercentView( java.lang.String value ) {
		this.__finish_percent_view = value;
	}

	public java.math.BigDecimal getRevenueMoney() {
		return this.__revenue_money;
	}

	public void setRevenueMoney( java.math.BigDecimal value ) {
		this.__revenue_money = value;
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return this.__invoice_amount;
	}

	public void setInvoiceAmount( java.math.BigDecimal value ) {
		this.__invoice_amount = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getSigningCompany() {
		return this.__signing_company;
	}

	public void setSigningCompany( java.lang.Integer value ) {
		this.__signing_company = value;
	}

	public java.lang.Boolean getIsFinish() {
		return this.__is_finish;
	}

	public void setIsFinish( java.lang.Boolean value ) {
		this.__is_finish = value;
	}

	public java.util.Date getAccountDate() {
		return this.__account_date;
	}

	public void setAccountDate( java.util.Date value ) {
		this.__account_date = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.math.BigDecimal getFinishPercentDetail() {
		return this.__finish_percent_detail;
	}

	public void setFinishPercentDetail( java.math.BigDecimal value ) {
		this.__finish_percent_detail = value;
	}

	public java.lang.String getFinishPercentDetailView() {
		return this.__finish_percent_detail_view;
	}

	public void setFinishPercentDetailView( java.lang.String value ) {
		this.__finish_percent_detail_view = value;
	}

	public void cloneCopy(BaseRevenueRecord __bean){
		__bean.setRevenueRecordId(getRevenueRecordId());
		__bean.setContractId(getContractId());
		__bean.setCode(getCode());
		__bean.setName(getName());
		__bean.setMoney(getMoney());
		__bean.setFinishPercent(getFinishPercent());
		__bean.setFinishPercentView(getFinishPercentView());
		__bean.setRevenueMoney(getRevenueMoney());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setParentId(getParentId());
		__bean.setSigningCompany(getSigningCompany());
		__bean.setIsFinish(getIsFinish());
		__bean.setAccountDate(getAccountDate());
		__bean.setMonth(getMonth());
		__bean.setFlag(getFlag());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setFinishPercentDetail(getFinishPercentDetail());
		__bean.setFinishPercentDetailView(getFinishPercentDetailView());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getRevenueRecordId() == null ? "" : getRevenueRecordId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getMoney() == null ? "" : getMoney());
		sb.append(",");
		sb.append(getFinishPercent() == null ? "" : getFinishPercent());
		sb.append(",");
		sb.append(getFinishPercentView() == null ? "" : getFinishPercentView());
		sb.append(",");
		sb.append(getRevenueMoney() == null ? "" : getRevenueMoney());
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		String strSigningCompany = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getSigningCompany()));
		sb.append(strSigningCompany == null ? "" : strSigningCompany);
		sb.append(",");
		sb.append(getIsFinish() == null ? "" : getIsFinish());
		sb.append(",");
		sb.append(getAccountDate() == null ? "" : sdf.format(getAccountDate()));
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		String strFlag = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_34", String.valueOf(getFlag()));
		sb.append(strFlag == null ? "" : strFlag);
		sb.append(",");
		String strOperateEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperateEmployeeId()));
		sb.append(strOperateEmployeeId == null ? "" : strOperateEmployeeId);
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getFinishPercentDetail() == null ? "" : getFinishPercentDetail());
		sb.append(",");
		sb.append(getFinishPercentDetailView() == null ? "" : getFinishPercentDetailView());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRevenueRecord o) {
		return __revenue_record_id == null ? -1 : __revenue_record_id.compareTo(o.getRevenueRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__revenue_record_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__money);
		hash = 97 * hash + Objects.hashCode(this.__finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__finish_percent_view);
		hash = 97 * hash + Objects.hashCode(this.__revenue_money);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__signing_company);
		hash = 97 * hash + Objects.hashCode(this.__is_finish);
		hash = 97 * hash + Objects.hashCode(this.__account_date);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__finish_percent_detail);
		hash = 97 * hash + Objects.hashCode(this.__finish_percent_detail_view);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRevenueRecord o = (BaseRevenueRecord)obj;
		if(!Objects.equals(this.__revenue_record_id, o.getRevenueRecordId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__money, o.getMoney())) return false;
		if(!Objects.equals(this.__finish_percent, o.getFinishPercent())) return false;
		if(!Objects.equals(this.__finish_percent_view, o.getFinishPercentView())) return false;
		if(!Objects.equals(this.__revenue_money, o.getRevenueMoney())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__signing_company, o.getSigningCompany())) return false;
		if(!Objects.equals(this.__is_finish, o.getIsFinish())) return false;
		if(!Objects.equals(this.__account_date, o.getAccountDate())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__finish_percent_detail, o.getFinishPercentDetail())) return false;
		if(!Objects.equals(this.__finish_percent_detail_view, o.getFinishPercentDetailView())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getRevenueRecordId() != null) sb.append(__wrapNumber(count++, "revenueRecordId", getRevenueRecordId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getMoney() != null) sb.append(__wrapDecimal(count++, "money", getMoney()));
		if(getFinishPercent() != null) sb.append(__wrapDecimal(count++, "finishPercent", getFinishPercent()));
		if(getFinishPercentView() != null) sb.append(__wrapString(count++, "finishPercentView", getFinishPercentView()));
		if(getRevenueMoney() != null) sb.append(__wrapDecimal(count++, "revenueMoney", getRevenueMoney()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getSigningCompany() != null) sb.append(__wrapNumber(count++, "signingCompany", getSigningCompany()));
		if(getIsFinish() != null) sb.append(__wrapBoolean(count++, "isFinish", getIsFinish()));
		if(getAccountDate() != null) sb.append(__wrapDate(count++, "accountDate", getAccountDate()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getFinishPercentDetail() != null) sb.append(__wrapDecimal(count++, "finishPercentDetail", getFinishPercentDetail()));
		if(getFinishPercentDetailView() != null) sb.append(__wrapString(count++, "finishPercentDetailView", getFinishPercentDetailView()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("revenueRecordId")) != null) setRevenueRecordId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("money")) != null) setMoney(__getDecimal(val));  
		if((val = values.get("finishPercent")) != null) setFinishPercent(__getDecimal(val));  
		if((val = values.get("finishPercentView")) != null) setFinishPercentView(__getString(val));
		if((val = values.get("revenueMoney")) != null) setRevenueMoney(__getDecimal(val));  
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("signingCompany")) != null) setSigningCompany(__getInt(val)); 
		if((val = values.get("isFinish")) != null) setIsFinish(__getBoolean(val));
		if((val = values.get("accountDate")) != null) setAccountDate(__getDate(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("finishPercentDetail")) != null) setFinishPercentDetail(__getDecimal(val));  
		if((val = values.get("finishPercentDetailView")) != null) setFinishPercentDetailView(__getString(val));
	}

	protected java.lang.Integer  __revenue_record_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __code ;
	protected java.lang.String  __name ;
	protected java.math.BigDecimal  __money ;
	protected java.math.BigDecimal  __finish_percent ;
	protected java.lang.String  __finish_percent_view ;
	protected java.math.BigDecimal  __revenue_money ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __signing_company ;
	protected java.lang.Boolean  __is_finish ;
	protected java.util.Date  __account_date ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __flag ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.math.BigDecimal  __finish_percent_detail ;
	protected java.lang.String  __finish_percent_detail_view ;
}
