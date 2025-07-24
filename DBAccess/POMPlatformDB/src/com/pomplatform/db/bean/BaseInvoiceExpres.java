package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseInvoiceExpres extends GenericBase implements BaseFactory<BaseInvoiceExpres>, Comparable<BaseInvoiceExpres> 
{


	public static BaseInvoiceExpres newInstance(){
		return new BaseInvoiceExpres();
	}

	@Override
	public BaseInvoiceExpres make(){
		BaseInvoiceExpres b = new BaseInvoiceExpres();
		return b;
	}

	public final static java.lang.String CS_INVOICE_EXPRESS_ID = "invoice_express_id" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTACT_ID = "contact_id" ;
	public final static java.lang.String CS_TEL = "tel" ;
	public final static java.lang.String CS_MAILING_ADDRESS = "mailing_address" ;
	public final static java.lang.String CS_COURIER_TYPE = "courier_type" ;
	public final static java.lang.String CS_COURIER_NUMBER = "courier_number" ;
	public final static java.lang.String CS_COURIER_DATE = "courier_date" ;
	public final static java.lang.String CS_SIGN_STATUS = "sign_status" ;
	public final static java.lang.String CS_SIGN_NAME = "sign_name" ;
	public final static java.lang.String CS_SIGN_RECEIPT = "sign_receipt" ;
	public final static java.lang.String CS_SIGN_DATE = "sign_date" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_TYPE = "type" ;

	public final static java.lang.String ALL_CAPTIONS = "开发票 编码,信息编号,项目编号,合同id,合同主编号,联系人主键   对应  client 表 主键,电话,寄件地址,快递类型,快递单号,快递日期,签收状态,签收签名,签收回执文件路劲,签收日期,操作人id,快递单的登记日期,备注,寄送类型 1发票寄送  2其他资料寄送";

	public java.lang.Integer getInvoiceExpressId() {
		return this.__invoice_express_id;
	}

	public void setInvoiceExpressId( java.lang.Integer value ) {
		this.__invoice_express_id = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getContactId() {
		return this.__contact_id;
	}

	public void setContactId( java.lang.Integer value ) {
		this.__contact_id = value;
	}

	public java.lang.String getTel() {
		return this.__tel;
	}

	public void setTel( java.lang.String value ) {
		this.__tel = value;
	}

	public java.lang.String getMailingAddress() {
		return this.__mailing_address;
	}

	public void setMailingAddress( java.lang.String value ) {
		this.__mailing_address = value;
	}

	public java.lang.Integer getCourierType() {
		return this.__courier_type;
	}

	public void setCourierType( java.lang.Integer value ) {
		this.__courier_type = value;
	}

	public java.lang.String getCourierNumber() {
		return this.__courier_number;
	}

	public void setCourierNumber( java.lang.String value ) {
		this.__courier_number = value;
	}

	public java.util.Date getCourierDate() {
		return this.__courier_date;
	}

	public void setCourierDate( java.util.Date value ) {
		this.__courier_date = value;
	}

	public java.lang.Integer getSignStatus() {
		return this.__sign_status;
	}

	public void setSignStatus( java.lang.Integer value ) {
		this.__sign_status = value;
	}

	public java.lang.String getSignName() {
		return this.__sign_name;
	}

	public void setSignName( java.lang.String value ) {
		this.__sign_name = value;
	}

	public java.lang.String getSignReceipt() {
		return this.__sign_receipt;
	}

	public void setSignReceipt( java.lang.String value ) {
		this.__sign_receipt = value;
	}

	public java.util.Date getSignDate() {
		return this.__sign_date;
	}

	public void setSignDate( java.util.Date value ) {
		this.__sign_date = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public void cloneCopy(BaseInvoiceExpres __bean){
		__bean.setInvoiceExpressId(getInvoiceExpressId());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContactId(getContactId());
		__bean.setTel(getTel());
		__bean.setMailingAddress(getMailingAddress());
		__bean.setCourierType(getCourierType());
		__bean.setCourierNumber(getCourierNumber());
		__bean.setCourierDate(getCourierDate());
		__bean.setSignStatus(getSignStatus());
		__bean.setSignName(getSignName());
		__bean.setSignReceipt(getSignReceipt());
		__bean.setSignDate(getSignDate());
		__bean.setOperator(getOperator());
		__bean.setCreateDate(getCreateDate());
		__bean.setRemark(getRemark());
		__bean.setType(getType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInvoiceExpressId() == null ? "" : getInvoiceExpressId());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContactId() == null ? "" : getContactId());
		sb.append(",");
		sb.append(getTel() == null ? "" : getTel());
		sb.append(",");
		sb.append(getMailingAddress() == null ? "" : getMailingAddress());
		sb.append(",");
		sb.append(getCourierType() == null ? "" : getCourierType());
		sb.append(",");
		sb.append(getCourierNumber() == null ? "" : getCourierNumber());
		sb.append(",");
		sb.append(getCourierDate() == null ? "" : sdf.format(getCourierDate()));
		sb.append(",");
		sb.append(getSignStatus() == null ? "" : getSignStatus());
		sb.append(",");
		sb.append(getSignName() == null ? "" : getSignName());
		sb.append(",");
		sb.append(getSignReceipt() == null ? "" : getSignReceipt());
		sb.append(",");
		sb.append(getSignDate() == null ? "" : sdf.format(getSignDate()));
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseInvoiceExpres o) {
		return __invoice_express_id == null ? -1 : __invoice_express_id.compareTo(o.getInvoiceExpressId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__invoice_express_id);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contact_id);
		hash = 97 * hash + Objects.hashCode(this.__tel);
		hash = 97 * hash + Objects.hashCode(this.__mailing_address);
		hash = 97 * hash + Objects.hashCode(this.__courier_type);
		hash = 97 * hash + Objects.hashCode(this.__courier_number);
		hash = 97 * hash + Objects.hashCode(this.__courier_date);
		hash = 97 * hash + Objects.hashCode(this.__sign_status);
		hash = 97 * hash + Objects.hashCode(this.__sign_name);
		hash = 97 * hash + Objects.hashCode(this.__sign_receipt);
		hash = 97 * hash + Objects.hashCode(this.__sign_date);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseInvoiceExpres o = (BaseInvoiceExpres)obj;
		if(!Objects.equals(this.__invoice_express_id, o.getInvoiceExpressId())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contact_id, o.getContactId())) return false;
		if(!Objects.equals(this.__tel, o.getTel())) return false;
		if(!Objects.equals(this.__mailing_address, o.getMailingAddress())) return false;
		if(!Objects.equals(this.__courier_type, o.getCourierType())) return false;
		if(!Objects.equals(this.__courier_number, o.getCourierNumber())) return false;
		if(!Objects.equals(this.__courier_date, o.getCourierDate())) return false;
		if(!Objects.equals(this.__sign_status, o.getSignStatus())) return false;
		if(!Objects.equals(this.__sign_name, o.getSignName())) return false;
		if(!Objects.equals(this.__sign_receipt, o.getSignReceipt())) return false;
		if(!Objects.equals(this.__sign_date, o.getSignDate())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInvoiceExpressId() != null) sb.append(__wrapNumber(count++, "invoiceExpressId", getInvoiceExpressId()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContactId() != null) sb.append(__wrapNumber(count++, "contactId", getContactId()));
		if(getTel() != null) sb.append(__wrapString(count++, "tel", getTel()));
		if(getMailingAddress() != null) sb.append(__wrapString(count++, "mailingAddress", getMailingAddress()));
		if(getCourierType() != null) sb.append(__wrapNumber(count++, "courierType", getCourierType()));
		if(getCourierNumber() != null) sb.append(__wrapString(count++, "courierNumber", getCourierNumber()));
		if(getCourierDate() != null) sb.append(__wrapDate(count++, "courierDate", getCourierDate()));
		if(getSignStatus() != null) sb.append(__wrapNumber(count++, "signStatus", getSignStatus()));
		if(getSignName() != null) sb.append(__wrapString(count++, "signName", getSignName()));
		if(getSignReceipt() != null) sb.append(__wrapString(count++, "signReceipt", getSignReceipt()));
		if(getSignDate() != null) sb.append(__wrapDate(count++, "signDate", getSignDate()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("invoiceExpressId")) != null) setInvoiceExpressId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contactId")) != null) setContactId(__getInt(val)); 
		if((val = values.get("tel")) != null) setTel(__getString(val));
		if((val = values.get("mailingAddress")) != null) setMailingAddress(__getString(val));
		if((val = values.get("courierType")) != null) setCourierType(__getInt(val)); 
		if((val = values.get("courierNumber")) != null) setCourierNumber(__getString(val));
		if((val = values.get("courierDate")) != null) setCourierDate(__getDate(val)); 
		if((val = values.get("signStatus")) != null) setSignStatus(__getInt(val)); 
		if((val = values.get("signName")) != null) setSignName(__getString(val));
		if((val = values.get("signReceipt")) != null) setSignReceipt(__getString(val));
		if((val = values.get("signDate")) != null) setSignDate(__getDate(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("type")) != null) setType(__getInt(val)); 
	}

	protected java.lang.Integer  __invoice_express_id ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.Integer  __contact_id ;
	protected java.lang.String  __tel ;
	protected java.lang.String  __mailing_address ;
	protected java.lang.Integer  __courier_type ;
	protected java.lang.String  __courier_number ;
	protected java.util.Date  __courier_date ;
	protected java.lang.Integer  __sign_status ;
	protected java.lang.String  __sign_name ;
	protected java.lang.String  __sign_receipt ;
	protected java.util.Date  __sign_date ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_date ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __type ;
}
