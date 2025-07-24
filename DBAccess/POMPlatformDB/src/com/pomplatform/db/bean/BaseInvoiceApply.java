package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseInvoiceApply extends GenericBase implements BaseFactory<BaseInvoiceApply>, Comparable<BaseInvoiceApply> 
{


	public static BaseInvoiceApply newInstance(){
		return new BaseInvoiceApply();
	}

	@Override
	public BaseInvoiceApply make(){
		BaseInvoiceApply b = new BaseInvoiceApply();
		return b;
	}

	public final static java.lang.String CS_INVOICE_APPLY_ID = "invoice_apply_id" ;
	public final static java.lang.String CS_APPLICANT_ID = "applicant_id" ;
	public final static java.lang.String CS_APPLICANT_DEPARMENT_ID = "applicant_deparment_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_INVOICE_TYPE = "invoice_type" ;
	public final static java.lang.String CS_COMPANY_NAME = "company_name" ;
	public final static java.lang.String CS_DUTY_PARAGRAPH = "duty_paragraph" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_CUSTOMER_PHONE = "customer_phone" ;
	public final static java.lang.String CS_REGISTERED_ADDRESS = "registered_address" ;
	public final static java.lang.String CS_BANK_NAME = "bank_name" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_APPLY_TIME = "apply_time" ;
	public final static java.lang.String CS_APPLY_SUM_MONEY = "apply_sum_money" ;
	public final static java.lang.String CS_APPLY_REMARK = "apply_remark" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_OPERATOR_TIME = "operator_time" ;
	public final static java.lang.String CS_OPERATOR_REMARK = "operator_remark" ;
	public final static java.lang.String CS_INVOICE_APPLY_STATUS = "invoice_apply_status" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_QQ = "qq" ;
	public final static java.lang.String CS_EMAIL = "email" ;
	public final static java.lang.String CS_LANDLINE = "landline" ;
	public final static java.lang.String CS_FAX = "fax" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,申请人,申请人部门,合同主键,发票类型,单位名称,税号,联系人,联系电话,注册地址,,,,申请总金额,申请备注,,操作时间,,申请状态  1申请中 2已处理 3已驳回,创建时间,修改时间,qq号,邮箱,座机,传真,0/1 是/否删除";

	public java.lang.Integer getInvoiceApplyId() {
		return this.__invoice_apply_id;
	}

	public void setInvoiceApplyId( java.lang.Integer value ) {
		this.__invoice_apply_id = value;
	}

	public java.lang.Integer getApplicantId() {
		return this.__applicant_id;
	}

	public void setApplicantId( java.lang.Integer value ) {
		this.__applicant_id = value;
	}

	public java.lang.Integer getApplicantDeparmentId() {
		return this.__applicant_deparment_id;
	}

	public void setApplicantDeparmentId( java.lang.Integer value ) {
		this.__applicant_deparment_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getInvoiceType() {
		return this.__invoice_type;
	}

	public void setInvoiceType( java.lang.Integer value ) {
		this.__invoice_type = value;
	}

	public java.lang.String getCompanyName() {
		return this.__company_name;
	}

	public void setCompanyName( java.lang.String value ) {
		this.__company_name = value;
	}

	public java.lang.String getDutyParagraph() {
		return this.__duty_paragraph;
	}

	public void setDutyParagraph( java.lang.String value ) {
		this.__duty_paragraph = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getCustomerPhone() {
		return this.__customer_phone;
	}

	public void setCustomerPhone( java.lang.String value ) {
		this.__customer_phone = value;
	}

	public java.lang.String getRegisteredAddress() {
		return this.__registered_address;
	}

	public void setRegisteredAddress( java.lang.String value ) {
		this.__registered_address = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name;
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.util.Date getApplyTime() {
		return this.__apply_time;
	}

	public void setApplyTime( java.util.Date value ) {
		this.__apply_time = value;
	}

	public java.math.BigDecimal getApplySumMoney() {
		return this.__apply_sum_money;
	}

	public void setApplySumMoney( java.math.BigDecimal value ) {
		this.__apply_sum_money = value;
	}

	public java.lang.String getApplyRemark() {
		return this.__apply_remark;
	}

	public void setApplyRemark( java.lang.String value ) {
		this.__apply_remark = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getOperatorTime() {
		return this.__operator_time;
	}

	public void setOperatorTime( java.util.Date value ) {
		this.__operator_time = value;
	}

	public java.lang.String getOperatorRemark() {
		return this.__operator_remark;
	}

	public void setOperatorRemark( java.lang.String value ) {
		this.__operator_remark = value;
	}

	public java.lang.Integer getInvoiceApplyStatus() {
		return this.__invoice_apply_status;
	}

	public void setInvoiceApplyStatus( java.lang.Integer value ) {
		this.__invoice_apply_status = value;
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

	public java.lang.String getQq() {
		return this.__qq;
	}

	public void setQq( java.lang.String value ) {
		this.__qq = value;
	}

	public java.lang.String getEmail() {
		return this.__email;
	}

	public void setEmail( java.lang.String value ) {
		this.__email = value;
	}

	public java.lang.String getLandline() {
		return this.__landline;
	}

	public void setLandline( java.lang.String value ) {
		this.__landline = value;
	}

	public java.lang.String getFax() {
		return this.__fax;
	}

	public void setFax( java.lang.String value ) {
		this.__fax = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public void cloneCopy(BaseInvoiceApply __bean){
		__bean.setInvoiceApplyId(getInvoiceApplyId());
		__bean.setApplicantId(getApplicantId());
		__bean.setApplicantDeparmentId(getApplicantDeparmentId());
		__bean.setContractId(getContractId());
		__bean.setInvoiceType(getInvoiceType());
		__bean.setCompanyName(getCompanyName());
		__bean.setDutyParagraph(getDutyParagraph());
		__bean.setCustomerName(getCustomerName());
		__bean.setCustomerPhone(getCustomerPhone());
		__bean.setRegisteredAddress(getRegisteredAddress());
		__bean.setBankName(getBankName());
		__bean.setBankAccount(getBankAccount());
		__bean.setApplyTime(getApplyTime());
		__bean.setApplySumMoney(getApplySumMoney());
		__bean.setApplyRemark(getApplyRemark());
		__bean.setOperatorId(getOperatorId());
		__bean.setOperatorTime(getOperatorTime());
		__bean.setOperatorRemark(getOperatorRemark());
		__bean.setInvoiceApplyStatus(getInvoiceApplyStatus());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setQq(getQq());
		__bean.setEmail(getEmail());
		__bean.setLandline(getLandline());
		__bean.setFax(getFax());
		__bean.setDeleteFlag(getDeleteFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInvoiceApplyId() == null ? "" : getInvoiceApplyId());
		sb.append(",");
		sb.append(getApplicantId() == null ? "" : getApplicantId());
		sb.append(",");
		sb.append(getApplicantDeparmentId() == null ? "" : getApplicantDeparmentId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getInvoiceType() == null ? "" : getInvoiceType());
		sb.append(",");
		sb.append(getCompanyName() == null ? "" : getCompanyName());
		sb.append(",");
		sb.append(getDutyParagraph() == null ? "" : getDutyParagraph());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getCustomerPhone() == null ? "" : getCustomerPhone());
		sb.append(",");
		sb.append(getRegisteredAddress() == null ? "" : getRegisteredAddress());
		sb.append(",");
		sb.append(getBankName() == null ? "" : getBankName());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getApplyTime() == null ? "" : sdf.format(getApplyTime()));
		sb.append(",");
		sb.append(getApplySumMoney() == null ? "" : getApplySumMoney());
		sb.append(",");
		sb.append(getApplyRemark() == null ? "" : getApplyRemark());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getOperatorTime() == null ? "" : sdf.format(getOperatorTime()));
		sb.append(",");
		sb.append(getOperatorRemark() == null ? "" : getOperatorRemark());
		sb.append(",");
		sb.append(getInvoiceApplyStatus() == null ? "" : getInvoiceApplyStatus());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getQq() == null ? "" : getQq());
		sb.append(",");
		sb.append(getEmail() == null ? "" : getEmail());
		sb.append(",");
		sb.append(getLandline() == null ? "" : getLandline());
		sb.append(",");
		sb.append(getFax() == null ? "" : getFax());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseInvoiceApply o) {
		return __invoice_apply_id == null ? -1 : __invoice_apply_id.compareTo(o.getInvoiceApplyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__invoice_apply_id);
		hash = 97 * hash + Objects.hashCode(this.__applicant_id);
		hash = 97 * hash + Objects.hashCode(this.__applicant_deparment_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__invoice_type);
		hash = 97 * hash + Objects.hashCode(this.__company_name);
		hash = 97 * hash + Objects.hashCode(this.__duty_paragraph);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_phone);
		hash = 97 * hash + Objects.hashCode(this.__registered_address);
		hash = 97 * hash + Objects.hashCode(this.__bank_name);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__apply_time);
		hash = 97 * hash + Objects.hashCode(this.__apply_sum_money);
		hash = 97 * hash + Objects.hashCode(this.__apply_remark);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__operator_time);
		hash = 97 * hash + Objects.hashCode(this.__operator_remark);
		hash = 97 * hash + Objects.hashCode(this.__invoice_apply_status);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__qq);
		hash = 97 * hash + Objects.hashCode(this.__email);
		hash = 97 * hash + Objects.hashCode(this.__landline);
		hash = 97 * hash + Objects.hashCode(this.__fax);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseInvoiceApply o = (BaseInvoiceApply)obj;
		if(!Objects.equals(this.__invoice_apply_id, o.getInvoiceApplyId())) return false;
		if(!Objects.equals(this.__applicant_id, o.getApplicantId())) return false;
		if(!Objects.equals(this.__applicant_deparment_id, o.getApplicantDeparmentId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__invoice_type, o.getInvoiceType())) return false;
		if(!Objects.equals(this.__company_name, o.getCompanyName())) return false;
		if(!Objects.equals(this.__duty_paragraph, o.getDutyParagraph())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__customer_phone, o.getCustomerPhone())) return false;
		if(!Objects.equals(this.__registered_address, o.getRegisteredAddress())) return false;
		if(!Objects.equals(this.__bank_name, o.getBankName())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__apply_time, o.getApplyTime())) return false;
		if(!Objects.equals(this.__apply_sum_money, o.getApplySumMoney())) return false;
		if(!Objects.equals(this.__apply_remark, o.getApplyRemark())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__operator_time, o.getOperatorTime())) return false;
		if(!Objects.equals(this.__operator_remark, o.getOperatorRemark())) return false;
		if(!Objects.equals(this.__invoice_apply_status, o.getInvoiceApplyStatus())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__qq, o.getQq())) return false;
		if(!Objects.equals(this.__email, o.getEmail())) return false;
		if(!Objects.equals(this.__landline, o.getLandline())) return false;
		if(!Objects.equals(this.__fax, o.getFax())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInvoiceApplyId() != null) sb.append(__wrapNumber(count++, "invoiceApplyId", getInvoiceApplyId()));
		if(getApplicantId() != null) sb.append(__wrapNumber(count++, "applicantId", getApplicantId()));
		if(getApplicantDeparmentId() != null) sb.append(__wrapNumber(count++, "applicantDeparmentId", getApplicantDeparmentId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getInvoiceType() != null) sb.append(__wrapNumber(count++, "invoiceType", getInvoiceType()));
		if(getCompanyName() != null) sb.append(__wrapString(count++, "companyName", getCompanyName()));
		if(getDutyParagraph() != null) sb.append(__wrapString(count++, "dutyParagraph", getDutyParagraph()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getCustomerPhone() != null) sb.append(__wrapString(count++, "customerPhone", getCustomerPhone()));
		if(getRegisteredAddress() != null) sb.append(__wrapString(count++, "registeredAddress", getRegisteredAddress()));
		if(getBankName() != null) sb.append(__wrapString(count++, "bankName", getBankName()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getApplyTime() != null) sb.append(__wrapDate(count++, "applyTime", getApplyTime()));
		if(getApplySumMoney() != null) sb.append(__wrapDecimal(count++, "applySumMoney", getApplySumMoney()));
		if(getApplyRemark() != null) sb.append(__wrapString(count++, "applyRemark", getApplyRemark()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getOperatorTime() != null) sb.append(__wrapDate(count++, "operatorTime", getOperatorTime()));
		if(getOperatorRemark() != null) sb.append(__wrapString(count++, "operatorRemark", getOperatorRemark()));
		if(getInvoiceApplyStatus() != null) sb.append(__wrapNumber(count++, "invoiceApplyStatus", getInvoiceApplyStatus()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getQq() != null) sb.append(__wrapString(count++, "qq", getQq()));
		if(getEmail() != null) sb.append(__wrapString(count++, "email", getEmail()));
		if(getLandline() != null) sb.append(__wrapString(count++, "landline", getLandline()));
		if(getFax() != null) sb.append(__wrapString(count++, "fax", getFax()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("invoiceApplyId")) != null) setInvoiceApplyId(__getInt(val)); 
		if((val = values.get("applicantId")) != null) setApplicantId(__getInt(val)); 
		if((val = values.get("applicantDeparmentId")) != null) setApplicantDeparmentId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("invoiceType")) != null) setInvoiceType(__getInt(val)); 
		if((val = values.get("companyName")) != null) setCompanyName(__getString(val));
		if((val = values.get("dutyParagraph")) != null) setDutyParagraph(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("customerPhone")) != null) setCustomerPhone(__getString(val));
		if((val = values.get("registeredAddress")) != null) setRegisteredAddress(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("applyTime")) != null) setApplyTime(__getDate(val)); 
		if((val = values.get("applySumMoney")) != null) setApplySumMoney(__getDecimal(val));  
		if((val = values.get("applyRemark")) != null) setApplyRemark(__getString(val));
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("operatorTime")) != null) setOperatorTime(__getDate(val)); 
		if((val = values.get("operatorRemark")) != null) setOperatorRemark(__getString(val));
		if((val = values.get("invoiceApplyStatus")) != null) setInvoiceApplyStatus(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("qq")) != null) setQq(__getString(val));
		if((val = values.get("email")) != null) setEmail(__getString(val));
		if((val = values.get("landline")) != null) setLandline(__getString(val));
		if((val = values.get("fax")) != null) setFax(__getString(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __invoice_apply_id ;
	protected java.lang.Integer  __applicant_id ;
	protected java.lang.Integer  __applicant_deparment_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __invoice_type ;
	protected java.lang.String  __company_name ;
	protected java.lang.String  __duty_paragraph ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __customer_phone ;
	protected java.lang.String  __registered_address ;
	protected java.lang.String  __bank_name ;
	protected java.lang.String  __bank_account ;
	protected java.util.Date  __apply_time ;
	protected java.math.BigDecimal  __apply_sum_money ;
	protected java.lang.String  __apply_remark ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __operator_time ;
	protected java.lang.String  __operator_remark ;
	protected java.lang.Integer  __invoice_apply_status ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.lang.String  __qq ;
	protected java.lang.String  __email ;
	protected java.lang.String  __landline ;
	protected java.lang.String  __fax ;
	protected java.lang.Integer  __delete_flag ;
}
