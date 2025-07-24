package pomplatform.attachment.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseOnAttachmentLinkInvoiceApplys extends GenericBase implements BaseFactory<BaseOnAttachmentLinkInvoiceApplys>, Comparable<BaseOnAttachmentLinkInvoiceApplys> 
{


	public static BaseOnAttachmentLinkInvoiceApplys newInstance(){
		return new BaseOnAttachmentLinkInvoiceApplys();
	}

	@Override
	public BaseOnAttachmentLinkInvoiceApplys make(){
		BaseOnAttachmentLinkInvoiceApplys b = new BaseOnAttachmentLinkInvoiceApplys();
		return b;
	}

	public final static java.lang.String CS_INVOICE_APPLY_ID = "invoice_apply_id" ;
	public final static java.lang.String CS_APPLICANT_ID = "applicant_id" ;
	public final static java.lang.String CS_INVOICE_TYPE = "invoice_type" ;
	public final static java.lang.String CS_COMPANY_NAME = "company_name" ;
	public final static java.lang.String CS_DUTY_PARAGRAPH = "duty_paragraph" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_CUSTOMER_PHONE = "customer_phone" ;
	public final static java.lang.String CS_APPLY_REMARK = "apply_remark" ;
	public final static java.lang.String CS_OPERATOR_REMARK = "operator_remark" ;
	public final static java.lang.String CS_FLAG_TYPE = "flag_type" ;
	public final static java.lang.String CS_BIND_AMOUNT = "bind_amount" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;

	public final static java.lang.String ALL_CAPTIONS = "发票联系人编码,申请人,发票类型,单位名称,税号,客户名称,联系电话,申请备注,operator_remark,绑定状态";

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

	public java.lang.String getApplyRemark() {
		return this.__apply_remark;
	}

	public void setApplyRemark( java.lang.String value ) {
		this.__apply_remark = value;
	}

	public java.lang.String getOperatorRemark() {
		return this.__operator_remark;
	}

	public void setOperatorRemark( java.lang.String value ) {
		this.__operator_remark = value;
	}

	public java.lang.Integer getFlagType() {
		return this.__flag_type;
	}

	public void setFlagType( java.lang.Integer value ) {
		this.__flag_type = value;
	}
	
	public java.lang.Integer getBindAmount() {
		return __bind_amount;
	}

	public void setBindAmount(java.lang.Integer value) {
		this.__bind_amount = value;
	}
	
	public java.lang.Integer getDeleteFlag() {
		return __delete_flag;
	}

	public void setDeleteFlag(java.lang.Integer value) {
		this.__delete_flag = value;
	}

	public java.lang.String getRegisteredAddress() {
		return __registered_address;
	}

	public void setRegisteredAddress(java.lang.String value) {
		this.__registered_address = value;
	}

	public java.lang.String getBankName() {
		return __bank_name;
	}

	public void setBankName(java.lang.String value) {
		this.__bank_name = value;
	}

	public java.lang.String getBankAccount() {
		return __bank_account;
	}

	public void setBankAccount(java.lang.String value) {
		this.__bank_account = value;
	}
	
	public java.lang.String getLandline() {
		return __landline;
	}

	public void setLandline(java.lang.String value) {
		this.__landline = value;
	}

	public void cloneCopy(BaseOnAttachmentLinkInvoiceApplys __bean){
		__bean.setInvoiceApplyId(getInvoiceApplyId());
		__bean.setApplicantId(getApplicantId());
		__bean.setInvoiceType(getInvoiceType());
		__bean.setCompanyName(getCompanyName());
		__bean.setDutyParagraph(getDutyParagraph());
		__bean.setCustomerName(getCustomerName());
		__bean.setCustomerPhone(getCustomerPhone());
		__bean.setApplyRemark(getApplyRemark());
		__bean.setOperatorRemark(getOperatorRemark());
		__bean.setFlagType(getFlagType());
		__bean.setBindAmount(getBindAmount());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setRegisteredAddress(getRegisteredAddress());
		__bean.setBankName(getBankName());
		__bean.setBankAccount(getBankAccount());
		__bean.setLandline(getLandline());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInvoiceApplyId() == null ? "" : getInvoiceApplyId());
		sb.append(",");
		sb.append(getApplicantId() == null ? "" : getApplicantId());
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
		sb.append(getApplyRemark() == null ? "" : getApplyRemark());
		sb.append(",");
		sb.append(getOperatorRemark() == null ? "" : getOperatorRemark());
		sb.append(",");
		String strFlagType = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getFlagType()));
		sb.append(strFlagType == null ? "" : strFlagType);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnAttachmentLinkInvoiceApplys o) {
		return __invoice_apply_id == null ? -1 : __invoice_apply_id.compareTo(o.getInvoiceApplyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__invoice_apply_id);
		hash = 97 * hash + Objects.hashCode(this.__applicant_id);
		hash = 97 * hash + Objects.hashCode(this.__invoice_type);
		hash = 97 * hash + Objects.hashCode(this.__company_name);
		hash = 97 * hash + Objects.hashCode(this.__duty_paragraph);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_phone);
		hash = 97 * hash + Objects.hashCode(this.__apply_remark);
		hash = 97 * hash + Objects.hashCode(this.__operator_remark);
		hash = 97 * hash + Objects.hashCode(this.__flag_type);
		hash = 97 * hash + Objects.hashCode(this.__bind_amount);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__registered_address);
		hash = 97 * hash + Objects.hashCode(this.__bank_name);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__landline);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnAttachmentLinkInvoiceApplys o = (BaseOnAttachmentLinkInvoiceApplys)obj;
		if(!Objects.equals(this.__invoice_apply_id, o.getInvoiceApplyId())) return false;
		if(!Objects.equals(this.__applicant_id, o.getApplicantId())) return false;
		if(!Objects.equals(this.__invoice_type, o.getInvoiceType())) return false;
		if(!Objects.equals(this.__company_name, o.getCompanyName())) return false;
		if(!Objects.equals(this.__duty_paragraph, o.getDutyParagraph())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__customer_phone, o.getCustomerPhone())) return false;
		if(!Objects.equals(this.__apply_remark, o.getApplyRemark())) return false;
		if(!Objects.equals(this.__operator_remark, o.getOperatorRemark())) return false;
		if(!Objects.equals(this.__flag_type, o.getFlagType())) return false;
		if(!Objects.equals(this.__bind_amount, o.getBindAmount())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__registered_address, o.getRegisteredAddress())) return false;
		if(!Objects.equals(this.__bank_name, o.getBankName())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__landline, o.getLandline())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInvoiceApplyId() != null) sb.append(__wrapNumber(count++, "invoiceApplyId", getInvoiceApplyId()));
		if(getApplicantId() != null) sb.append(__wrapNumber(count++, "applicantId", getApplicantId()));
		if(getInvoiceType() != null) sb.append(__wrapNumber(count++, "invoiceType", getInvoiceType()));
		if(getCompanyName() != null) sb.append(__wrapString(count++, "companyName", getCompanyName()));
		if(getDutyParagraph() != null) sb.append(__wrapString(count++, "dutyParagraph", getDutyParagraph()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getCustomerPhone() != null) sb.append(__wrapString(count++, "customerPhone", getCustomerPhone()));
		if(getApplyRemark() != null) sb.append(__wrapString(count++, "applyRemark", getApplyRemark()));
		if(getOperatorRemark() != null) sb.append(__wrapString(count++, "operatorRemark", getOperatorRemark()));
		if(getFlagType() != null) sb.append(__wrapNumber(count++, "flagType", getFlagType()));
		if(getBindAmount() != null) sb.append(__wrapNumber(count++, "bindAmount", getBindAmount()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getRegisteredAddress() != null) sb.append(__wrapString(count++, "registeredAddress", getRegisteredAddress()));
		if(getBankName() != null) sb.append(__wrapString(count++, "bankName", getBankName()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getLandline() != null) sb.append(__wrapString(count++, "landline", getLandline()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("invoiceApplyId")) != null) setInvoiceApplyId(__getInt(val)); 
		if((val = values.get("applicantId")) != null) setApplicantId(__getInt(val)); 
		if((val = values.get("invoiceType")) != null) setInvoiceType(__getInt(val)); 
		if((val = values.get("companyName")) != null) setCompanyName(__getString(val));
		if((val = values.get("dutyParagraph")) != null) setDutyParagraph(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("customerPhone")) != null) setCustomerPhone(__getString(val));
		if((val = values.get("applyRemark")) != null) setApplyRemark(__getString(val));
		if((val = values.get("operatorRemark")) != null) setOperatorRemark(__getString(val));
		if((val = values.get("flagType")) != null) setFlagType(__getInt(val)); 
		if((val = values.get("bindAmount")) != null) setBindAmount(__getInt(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("registeredAddress")) != null) setRegisteredAddress(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("landline")) != null) setLandline(__getString(val));
	}

	protected java.lang.Integer  __invoice_apply_id ;
	protected java.lang.Integer  __applicant_id ;
	protected java.lang.Integer  __invoice_type ;
	protected java.lang.String  __company_name ;
	protected java.lang.String  __duty_paragraph ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __customer_phone ;
	protected java.lang.String  __apply_remark ;
	protected java.lang.String  __operator_remark ;
	protected java.lang.Integer  __flag_type ;
	protected java.lang.Integer  __bind_amount ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.String  __registered_address ;
	protected java.lang.String  __bank_name ;
	protected java.lang.String  __bank_account ;
	protected java.lang.String  __landline;
}
