package pomplatform.reimbursementpackage.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMreimbursementpackagesummarycrtppor extends GenericBase implements BaseFactory<BaseMreimbursementpackagesummarycrtppor>, Comparable<BaseMreimbursementpackagesummarycrtppor> 
{


	public static BaseMreimbursementpackagesummarycrtppor newInstance(){
		return new BaseMreimbursementpackagesummarycrtppor();
	}

	@Override
	public BaseMreimbursementpackagesummarycrtppor make(){
		BaseMreimbursementpackagesummarycrtppor b = new BaseMreimbursementpackagesummarycrtppor();
		return b;
	}

	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_SUMMARY_ID = "reimbursement_package_summary_id" ;
	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_ID = "reimbursement_package_id" ;
	public final static java.lang.String CS_MONEY_ATTRIBUTE = "money_attribute" ;
	public final static java.lang.String CS_PAY_FOR = "pay_for" ;
	public final static java.lang.String CS_EMPLOYEE_OR_COMPANY_ID = "employee_or_company_id" ;
	public final static java.lang.String CS_PAYEE_NAME = "payee_name" ;
	public final static java.lang.String CS_SELF_BANK_NAME = "self_bank_name" ;
	public final static java.lang.String CS_SELF_BANK_ACCOUNT = "self_bank_account" ;
	public final static java.lang.String CS_OTHER_NAME = "other_name" ;
	public final static java.lang.String CS_OTHER_BANK_NAME = "other_bank_name" ;
	public final static java.lang.String CS_OTHER_BANK_ACCOUNT = "other_bank_account" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_PAYMENT_AMOUNT = "payment_amount" ;
	public final static java.lang.String CS_STRIKE_A_BALANCE_AMOUNT = "strike_a_balance_amount" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_PAY_TYPE = "pay_type" ;
	public final static java.lang.String CS_CMBC_PAYMENT_ID = "cmbc_payment_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_YURREF = "yurref" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_TOTAL_NUM = "total_num" ;
	public final static java.lang.String CS_PAY_STATUS = "pay_status" ;
	public final static java.lang.String CS_PAY_RESULT = "pay_result" ;
	public final static java.lang.String CS_ERROR_MSG = "error_msg" ;
	public final static java.lang.String CS_EPTTIM = "epttim" ;
	public final static java.lang.String CS_SUCCESS_TOTAL_AMOUNT = "success_total_amount" ;
	public final static java.lang.String CS_SUCCESS_TOTAL_NUM = "success_total_num" ;
	public final static java.lang.String CS_OPRDAT = "oprdat" ;

	public final static java.lang.String ALL_CAPTIONS = "报销打包汇总表编码,报销打包表编码,款项属性,1 员工  2收款单位,员工或者收款单位Id,收款方,银行名称(收款方),银行账号(收款方),付款方  system_dictionary_69,银行名称(付款方),银行账号(付款方),总金额,付款金额,冲账金额,开始时间,修改时间,是否完成,归属公司,年(用于记录薪资与奖金的发放年份),月(用于记录薪资与奖金的发放月份),付款类型 0普通付款 1薪资发放  2奖金发放,多对1(支付主表编码),类型 1支付 2代发工资 3代发奖金 4代发其他 5 内部转账,业务参考号,总金额(用户记录代发与代扣),总数量(用户记录代发与代扣),3支付完成(已返回处理结果),4失败,错误信息,期望时间,,成功总笔数,经办日期";

	public java.lang.Integer getReimbursementPackageSummaryId() {
		return this.__reimbursement_package_summary_id;
	}

	public void setReimbursementPackageSummaryId( java.lang.Integer value ) {
		this.__reimbursement_package_summary_id = value;
	}

	public java.lang.Integer getReimbursementPackageId() {
		return this.__reimbursement_package_id;
	}

	public void setReimbursementPackageId( java.lang.Integer value ) {
		this.__reimbursement_package_id = value;
	}

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
	}

	public java.lang.Integer getPayFor() {
		return this.__pay_for;
	}

	public void setPayFor( java.lang.Integer value ) {
		this.__pay_for = value;
	}

	public java.lang.Integer getEmployeeOrCompanyId() {
		return this.__employee_or_company_id;
	}

	public void setEmployeeOrCompanyId( java.lang.Integer value ) {
		this.__employee_or_company_id = value;
	}

	public java.lang.String getPayeeName() {
		return this.__payee_name;
	}

	public void setPayeeName( java.lang.String value ) {
		this.__payee_name = value;
	}

	public java.lang.String getSelfBankName() {
		return this.__self_bank_name;
	}

	public void setSelfBankName( java.lang.String value ) {
		this.__self_bank_name = value;
	}

	public java.lang.String getSelfBankAccount() {
		return this.__self_bank_account;
	}

	public void setSelfBankAccount( java.lang.String value ) {
		this.__self_bank_account = value;
	}

	public java.lang.Integer getOtherName() {
		return this.__other_name;
	}

	public void setOtherName( java.lang.Integer value ) {
		this.__other_name = value;
	}

	public java.lang.String getOtherBankName() {
		return this.__other_bank_name;
	}

	public void setOtherBankName( java.lang.String value ) {
		this.__other_bank_name = value;
	}

	public java.lang.String getOtherBankAccount() {
		return this.__other_bank_account;
	}

	public void setOtherBankAccount( java.lang.String value ) {
		this.__other_bank_account = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.math.BigDecimal getPaymentAmount() {
		return this.__payment_amount;
	}

	public void setPaymentAmount( java.math.BigDecimal value ) {
		this.__payment_amount = value;
	}

	public java.math.BigDecimal getStrikeABalanceAmount() {
		return this.__strike_a_balance_amount;
	}

	public void setStrikeABalanceAmount( java.math.BigDecimal value ) {
		this.__strike_a_balance_amount = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
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

	public java.lang.Integer getPayType() {
		return this.__pay_type;
	}

	public void setPayType( java.lang.Integer value ) {
		this.__pay_type = value;
	}

	public java.lang.Integer getCmbcPaymentId() {
		return this.__cmbc_payment_id;
	}

	public void setCmbcPaymentId( java.lang.Integer value ) {
		this.__cmbc_payment_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.String getYurref() {
		return this.__yurref;
	}

	public void setYurref( java.lang.String value ) {
		this.__yurref = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.lang.Integer getTotalNum() {
		return this.__total_num;
	}

	public void setTotalNum( java.lang.Integer value ) {
		this.__total_num = value;
	}

	public java.lang.Integer getPayStatus() {
		return this.__pay_status;
	}

	public void setPayStatus( java.lang.Integer value ) {
		this.__pay_status = value;
	}

	public java.lang.Integer getPayResult() {
		return this.__pay_result;
	}

	public void setPayResult( java.lang.Integer value ) {
		this.__pay_result = value;
	}

	public java.lang.String getErrorMsg() {
		return this.__error_msg;
	}

	public void setErrorMsg( java.lang.String value ) {
		this.__error_msg = value;
	}

	public java.util.Date getEpttim() {
		return this.__epttim;
	}

	public void setEpttim( java.util.Date value ) {
		this.__epttim = value;
	}

	public java.lang.Long getSuccessTotalAmount() {
		return this.__success_total_amount;
	}

	public void setSuccessTotalAmount( java.lang.Long value ) {
		this.__success_total_amount = value;
	}

	public java.lang.Integer getSuccessTotalNum() {
		return this.__success_total_num;
	}

	public void setSuccessTotalNum( java.lang.Integer value ) {
		this.__success_total_num = value;
	}

	public java.util.Date getOprdat() {
		return this.__oprdat;
	}

	public void setOprdat( java.util.Date value ) {
		this.__oprdat = value;
	}

	public void cloneCopy(BaseMreimbursementpackagesummarycrtppor __bean){
		__bean.setReimbursementPackageSummaryId(getReimbursementPackageSummaryId());
		__bean.setReimbursementPackageId(getReimbursementPackageId());
		__bean.setMoneyAttribute(getMoneyAttribute());
		__bean.setPayFor(getPayFor());
		__bean.setEmployeeOrCompanyId(getEmployeeOrCompanyId());
		__bean.setPayeeName(getPayeeName());
		__bean.setSelfBankName(getSelfBankName());
		__bean.setSelfBankAccount(getSelfBankAccount());
		__bean.setOtherName(getOtherName());
		__bean.setOtherBankName(getOtherBankName());
		__bean.setOtherBankAccount(getOtherBankAccount());
		__bean.setAmount(getAmount());
		__bean.setPaymentAmount(getPaymentAmount());
		__bean.setStrikeABalanceAmount(getStrikeABalanceAmount());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setIsCompleted(getIsCompleted());
		__bean.setCompanyId(getCompanyId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setPayType(getPayType());
		__bean.setCmbcPaymentId(getCmbcPaymentId());
		__bean.setType(getType());
		__bean.setYurref(getYurref());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setTotalNum(getTotalNum());
		__bean.setPayStatus(getPayStatus());
		__bean.setPayResult(getPayResult());
		__bean.setErrorMsg(getErrorMsg());
		__bean.setEpttim(getEpttim());
		__bean.setSuccessTotalAmount(getSuccessTotalAmount());
		__bean.setSuccessTotalNum(getSuccessTotalNum());
		__bean.setOprdat(getOprdat());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getReimbursementPackageSummaryId() == null ? "" : getReimbursementPackageSummaryId());
		sb.append(",");
		sb.append(getReimbursementPackageId() == null ? "" : getReimbursementPackageId());
		sb.append(",");
		sb.append(getMoneyAttribute() == null ? "" : getMoneyAttribute());
		sb.append(",");
		sb.append(getPayFor() == null ? "" : getPayFor());
		sb.append(",");
		sb.append(getEmployeeOrCompanyId() == null ? "" : getEmployeeOrCompanyId());
		sb.append(",");
		sb.append(getPayeeName() == null ? "" : getPayeeName());
		sb.append(",");
		sb.append(getSelfBankName() == null ? "" : getSelfBankName());
		sb.append(",");
		sb.append(getSelfBankAccount() == null ? "" : getSelfBankAccount());
		sb.append(",");
		sb.append(getOtherName() == null ? "" : getOtherName());
		sb.append(",");
		sb.append(getOtherBankName() == null ? "" : getOtherBankName());
		sb.append(",");
		sb.append(getOtherBankAccount() == null ? "" : getOtherBankAccount());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getPaymentAmount() == null ? "" : getPaymentAmount());
		sb.append(",");
		sb.append(getStrikeABalanceAmount() == null ? "" : getStrikeABalanceAmount());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		String strPayType = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getPayType()));
		sb.append(strPayType == null ? "" : strPayType);
		sb.append(",");
		sb.append(getCmbcPaymentId() == null ? "" : getCmbcPaymentId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getYurref() == null ? "" : getYurref());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getTotalNum() == null ? "" : getTotalNum());
		sb.append(",");
		sb.append(getPayStatus() == null ? "" : getPayStatus());
		sb.append(",");
		sb.append(getPayResult() == null ? "" : getPayResult());
		sb.append(",");
		sb.append(getErrorMsg() == null ? "" : getErrorMsg());
		sb.append(",");
		sb.append(getEpttim() == null ? "" : sdf.format(getEpttim()));
		sb.append(",");
		sb.append(getSuccessTotalAmount() == null ? "" : getSuccessTotalAmount());
		sb.append(",");
		sb.append(getSuccessTotalNum() == null ? "" : getSuccessTotalNum());
		sb.append(",");
		sb.append(getOprdat() == null ? "" : sdf.format(getOprdat()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMreimbursementpackagesummarycrtppor o) {
		return __reimbursement_package_summary_id == null ? -1 : __reimbursement_package_summary_id.compareTo(o.getReimbursementPackageSummaryId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_summary_id);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_id);
		hash = 97 * hash + Objects.hashCode(this.__money_attribute);
		hash = 97 * hash + Objects.hashCode(this.__pay_for);
		hash = 97 * hash + Objects.hashCode(this.__employee_or_company_id);
		hash = 97 * hash + Objects.hashCode(this.__payee_name);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_name);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__other_name);
		hash = 97 * hash + Objects.hashCode(this.__other_bank_name);
		hash = 97 * hash + Objects.hashCode(this.__other_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__payment_amount);
		hash = 97 * hash + Objects.hashCode(this.__strike_a_balance_amount);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__pay_type);
		hash = 97 * hash + Objects.hashCode(this.__cmbc_payment_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__yurref);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__total_num);
		hash = 97 * hash + Objects.hashCode(this.__pay_status);
		hash = 97 * hash + Objects.hashCode(this.__pay_result);
		hash = 97 * hash + Objects.hashCode(this.__error_msg);
		hash = 97 * hash + Objects.hashCode(this.__epttim);
		hash = 97 * hash + Objects.hashCode(this.__success_total_amount);
		hash = 97 * hash + Objects.hashCode(this.__success_total_num);
		hash = 97 * hash + Objects.hashCode(this.__oprdat);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMreimbursementpackagesummarycrtppor o = (BaseMreimbursementpackagesummarycrtppor)obj;
		if(!Objects.equals(this.__reimbursement_package_summary_id, o.getReimbursementPackageSummaryId())) return false;
		if(!Objects.equals(this.__reimbursement_package_id, o.getReimbursementPackageId())) return false;
		if(!Objects.equals(this.__money_attribute, o.getMoneyAttribute())) return false;
		if(!Objects.equals(this.__pay_for, o.getPayFor())) return false;
		if(!Objects.equals(this.__employee_or_company_id, o.getEmployeeOrCompanyId())) return false;
		if(!Objects.equals(this.__payee_name, o.getPayeeName())) return false;
		if(!Objects.equals(this.__self_bank_name, o.getSelfBankName())) return false;
		if(!Objects.equals(this.__self_bank_account, o.getSelfBankAccount())) return false;
		if(!Objects.equals(this.__other_name, o.getOtherName())) return false;
		if(!Objects.equals(this.__other_bank_name, o.getOtherBankName())) return false;
		if(!Objects.equals(this.__other_bank_account, o.getOtherBankAccount())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__payment_amount, o.getPaymentAmount())) return false;
		if(!Objects.equals(this.__strike_a_balance_amount, o.getStrikeABalanceAmount())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__pay_type, o.getPayType())) return false;
		if(!Objects.equals(this.__cmbc_payment_id, o.getCmbcPaymentId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__yurref, o.getYurref())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__total_num, o.getTotalNum())) return false;
		if(!Objects.equals(this.__pay_status, o.getPayStatus())) return false;
		if(!Objects.equals(this.__pay_result, o.getPayResult())) return false;
		if(!Objects.equals(this.__error_msg, o.getErrorMsg())) return false;
		if(!Objects.equals(this.__epttim, o.getEpttim())) return false;
		if(!Objects.equals(this.__success_total_amount, o.getSuccessTotalAmount())) return false;
		if(!Objects.equals(this.__success_total_num, o.getSuccessTotalNum())) return false;
		if(!Objects.equals(this.__oprdat, o.getOprdat())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getReimbursementPackageSummaryId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageSummaryId", getReimbursementPackageSummaryId()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageId", getReimbursementPackageId()));
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(count++, "moneyAttribute", getMoneyAttribute()));
		if(getPayFor() != null) sb.append(__wrapNumber(count++, "payFor", getPayFor()));
		if(getEmployeeOrCompanyId() != null) sb.append(__wrapNumber(count++, "employeeOrCompanyId", getEmployeeOrCompanyId()));
		if(getPayeeName() != null) sb.append(__wrapString(count++, "payeeName", getPayeeName()));
		if(getSelfBankName() != null) sb.append(__wrapString(count++, "selfBankName", getSelfBankName()));
		if(getSelfBankAccount() != null) sb.append(__wrapString(count++, "selfBankAccount", getSelfBankAccount()));
		if(getOtherName() != null) sb.append(__wrapNumber(count++, "otherName", getOtherName()));
		if(getOtherBankName() != null) sb.append(__wrapString(count++, "otherBankName", getOtherBankName()));
		if(getOtherBankAccount() != null) sb.append(__wrapString(count++, "otherBankAccount", getOtherBankAccount()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getPaymentAmount() != null) sb.append(__wrapDecimal(count++, "paymentAmount", getPaymentAmount()));
		if(getStrikeABalanceAmount() != null) sb.append(__wrapDecimal(count++, "strikeABalanceAmount", getStrikeABalanceAmount()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getPayType() != null) sb.append(__wrapNumber(count++, "payType", getPayType()));
		if(getCmbcPaymentId() != null) sb.append(__wrapNumber(count++, "cmbcPaymentId", getCmbcPaymentId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getYurref() != null) sb.append(__wrapString(count++, "yurref", getYurref()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getTotalNum() != null) sb.append(__wrapNumber(count++, "totalNum", getTotalNum()));
		if(getPayStatus() != null) sb.append(__wrapNumber(count++, "payStatus", getPayStatus()));
		if(getPayResult() != null) sb.append(__wrapNumber(count++, "payResult", getPayResult()));
		if(getErrorMsg() != null) sb.append(__wrapString(count++, "errorMsg", getErrorMsg()));
		if(getEpttim() != null) sb.append(__wrapDate(count++, "epttim", getEpttim()));
		if(getSuccessTotalAmount() != null) sb.append(__wrapNumber(count++, "successTotalAmount", getSuccessTotalAmount()));
		if(getSuccessTotalNum() != null) sb.append(__wrapNumber(count++, "successTotalNum", getSuccessTotalNum()));
		if(getOprdat() != null) sb.append(__wrapDate(count++, "oprdat", getOprdat()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("reimbursementPackageSummaryId")) != null) setReimbursementPackageSummaryId(__getInt(val)); 
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("payFor")) != null) setPayFor(__getInt(val)); 
		if((val = values.get("employeeOrCompanyId")) != null) setEmployeeOrCompanyId(__getInt(val)); 
		if((val = values.get("payeeName")) != null) setPayeeName(__getString(val));
		if((val = values.get("selfBankName")) != null) setSelfBankName(__getString(val));
		if((val = values.get("selfBankAccount")) != null) setSelfBankAccount(__getString(val));
		if((val = values.get("otherName")) != null) setOtherName(__getInt(val)); 
		if((val = values.get("otherBankName")) != null) setOtherBankName(__getString(val));
		if((val = values.get("otherBankAccount")) != null) setOtherBankAccount(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("paymentAmount")) != null) setPaymentAmount(__getDecimal(val));  
		if((val = values.get("strikeABalanceAmount")) != null) setStrikeABalanceAmount(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("payType")) != null) setPayType(__getInt(val)); 
		if((val = values.get("cmbcPaymentId")) != null) setCmbcPaymentId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("yurref")) != null) setYurref(__getString(val));
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("totalNum")) != null) setTotalNum(__getInt(val)); 
		if((val = values.get("payStatus")) != null) setPayStatus(__getInt(val)); 
		if((val = values.get("payResult")) != null) setPayResult(__getInt(val)); 
		if((val = values.get("errorMsg")) != null) setErrorMsg(__getString(val));
		if((val = values.get("epttim")) != null) setEpttim(__getDate(val)); 
		if((val = values.get("successTotalAmount")) != null) setSuccessTotalAmount(__getLong(val)); 
		if((val = values.get("successTotalNum")) != null) setSuccessTotalNum(__getInt(val)); 
		if((val = values.get("oprdat")) != null) setOprdat(__getDate(val)); 
	}

	protected java.lang.Integer  __reimbursement_package_summary_id ;
	protected java.lang.Integer  __reimbursement_package_id ;
	protected java.lang.Integer  __money_attribute ;
	protected java.lang.Integer  __pay_for ;
	protected java.lang.Integer  __employee_or_company_id ;
	protected java.lang.String  __payee_name ;
	protected java.lang.String  __self_bank_name ;
	protected java.lang.String  __self_bank_account ;
	protected java.lang.Integer  __other_name ;
	protected java.lang.String  __other_bank_name ;
	protected java.lang.String  __other_bank_account ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __payment_amount ;
	protected java.math.BigDecimal  __strike_a_balance_amount ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.lang.Boolean  __is_completed ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __pay_type ;
	protected java.lang.Integer  __cmbc_payment_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.String  __yurref ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.lang.Integer  __total_num ;
	protected java.lang.Integer  __pay_status ;
	protected java.lang.Integer  __pay_result ;
	protected java.lang.String  __error_msg ;
	protected java.util.Date  __epttim ;
	protected java.lang.Long  __success_total_amount ;
	protected java.lang.Integer  __success_total_num ;
	protected java.util.Date  __oprdat ;
}
