package pomplatform.invoiceexpresitssccmisiior.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMinvoiceexpresitssccmisiior extends GenericCondition{

	public ConditionMinvoiceexpresitssccmisiior(){
		setParameterCount(19);
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getClientName() {
		return this.__client_name == null ? null : (this.__client_name.indexOf("%") >= 0 ? this.__client_name : "%"+this.__client_name+"%");
	}

	public void setClientName( java.lang.String value ) {
		this.__client_name = value;
	}

	public java.lang.Integer getCourierType() {
		return this.__courier_type;
	}

	public void setCourierType( java.lang.Integer value ) {
		this.__courier_type = value;
	}

	public java.util.Date getMinCourierDate() {
		return this.__min_courier_date;
	}

	public void setMinCourierDate( java.util.Date value ) {
		this.__min_courier_date = value;
	}

	public java.util.Date getMaxCourierDate() {
		return this.__max_courier_date;
	}

	public void setMaxCourierDate( java.util.Date value ) {
		this.__max_courier_date = value;
	}

	public java.util.Date getMinSignDate() {
		return this.__min_sign_date;
	}

	public void setMinSignDate( java.util.Date value ) {
		this.__min_sign_date = value;
	}

	public java.util.Date getMaxSignDate() {
		return this.__max_sign_date;
	}

	public void setMaxSignDate( java.util.Date value ) {
		this.__max_sign_date = value;
	}

	public java.lang.String getTel() {
		return this.__tel == null ? null : (this.__tel.indexOf("%") >= 0 ? this.__tel : "%"+this.__tel+"%");
	}

	public void setTel( java.lang.String value ) {
		this.__tel = value;
	}

	public java.lang.Integer getSignStatus() {
		return this.__sign_status;
	}

	public void setSignStatus( java.lang.Integer value ) {
		this.__sign_status = value;
	}

	public java.lang.String getSignName() {
		return this.__sign_name == null ? null : (this.__sign_name.indexOf("%") >= 0 ? this.__sign_name : "%"+this.__sign_name+"%");
	}

	public void setSignName( java.lang.String value ) {
		this.__sign_name = value;
	}

	public java.lang.String getCourierNumber() {
		return this.__courier_number == null ? null : (this.__courier_number.indexOf("%") >= 0 ? this.__courier_number : "%"+this.__courier_number+"%");
	}

	public void setCourierNumber( java.lang.String value ) {
		this.__courier_number = value;
	}

	public java.lang.String getMailingAddress() {
		return this.__mailing_address == null ? null : (this.__mailing_address.indexOf("%") >= 0 ? this.__mailing_address : "%"+this.__mailing_address+"%");
	}

	public void setMailingAddress( java.lang.String value ) {
		this.__mailing_address = value;
	}

	public java.lang.Integer getInvoiceType() {
		return this.__invoice_type;
	}

	public void setInvoiceType( java.lang.Integer value ) {
		this.__invoice_type = value;
	}

	public java.lang.Integer getSign() {
		return this.__sign;
	}

	public void setSign( java.lang.Integer value ) {
		this.__sign = value;
	}

	public java.lang.String getInvoiceCode() {
		return this.__invoice_code == null ? null : (this.__invoice_code.indexOf("%") >= 0 ? this.__invoice_code : "%"+this.__invoice_code+"%");
	}

	public void setInvoiceCode( java.lang.String value ) {
		this.__invoice_code = value;
	}

	public java.lang.String getInvoiceNumber() {
		return this.__invoice_number == null ? null : (this.__invoice_number.indexOf("%") >= 0 ? this.__invoice_number : "%"+this.__invoice_number+"%");
	}

	public void setInvoiceNumber( java.lang.String value ) {
		this.__invoice_number = value;
	}

	public java.lang.Integer getContactId() {
		return this.__contact_id;
	}

	public void setContactId( java.lang.Integer value ) {
		this.__contact_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getClientName() != null) sb.append(__wrapString(1, "clientName", getClientName()));
		if(getCourierType() != null) sb.append(__wrapNumber(1, "courierType", getCourierType()));
		if(getMinCourierDate() != null) sb.append(__wrapDate(1, "minCourierDate", getMinCourierDate()));
		if(getMaxCourierDate() != null) sb.append(__wrapDate(1, "maxCourierDate", getMaxCourierDate()));
		if(getMinSignDate() != null) sb.append(__wrapDate(1, "minSignDate", getMinSignDate()));
		if(getMaxSignDate() != null) sb.append(__wrapDate(1, "maxSignDate", getMaxSignDate()));
		if(getTel() != null) sb.append(__wrapString(1, "tel", getTel()));
		if(getSignStatus() != null) sb.append(__wrapNumber(1, "signStatus", getSignStatus()));
		if(getSignName() != null) sb.append(__wrapString(1, "signName", getSignName()));
		if(getCourierNumber() != null) sb.append(__wrapString(1, "courierNumber", getCourierNumber()));
		if(getMailingAddress() != null) sb.append(__wrapString(1, "mailingAddress", getMailingAddress()));
		if(getInvoiceType() != null) sb.append(__wrapNumber(1, "invoiceType", getInvoiceType()));
		if(getSign() != null) sb.append(__wrapNumber(1, "sign", getSign()));
		if(getInvoiceCode() != null) sb.append(__wrapString(1, "invoiceCode", getInvoiceCode()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(1, "invoiceNumber", getInvoiceNumber()));
		if(getContactId() != null) sb.append(__wrapNumber(1, "contactId", getContactId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("clientName")) != null) setClientName(__getString(val));
		if((val = values.get("courierType")) != null) setCourierType(__getInt(val)); 
		if((val = values.get("minCourierDate")) != null) setMinCourierDate(__getDate(val)); 
		if((val = values.get("maxCourierDate")) != null) setMaxCourierDate(__getDate(val)); 
		if((val = values.get("minSignDate")) != null) setMinSignDate(__getDate(val)); 
		if((val = values.get("maxSignDate")) != null) setMaxSignDate(__getDate(val)); 
		if((val = values.get("tel")) != null) setTel(__getString(val));
		if((val = values.get("signStatus")) != null) setSignStatus(__getInt(val)); 
		if((val = values.get("signName")) != null) setSignName(__getString(val));
		if((val = values.get("courierNumber")) != null) setCourierNumber(__getString(val));
		if((val = values.get("mailingAddress")) != null) setMailingAddress(__getString(val));
		if((val = values.get("invoiceType")) != null) setInvoiceType(__getInt(val)); 
		if((val = values.get("sign")) != null) setSign(__getInt(val)); 
		if((val = values.get("invoiceCode")) != null) setInvoiceCode(__getString(val));
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
		if((val = values.get("contactId")) != null) setContactId(__getInt(val)); 
	}

	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.String __client_name = null;
	private java.lang.Integer __courier_type = null;
	private java.util.Date __min_courier_date = null;
	private java.util.Date __max_courier_date = null;
	private java.util.Date __min_sign_date = null;
	private java.util.Date __max_sign_date = null;
	private java.lang.String __tel = null;
	private java.lang.Integer __sign_status = null;
	private java.lang.String __sign_name = null;
	private java.lang.String __courier_number = null;
	private java.lang.String __mailing_address = null;
	private java.lang.Integer __invoice_type = null;
	private java.lang.Integer __sign = null;
	private java.lang.String __invoice_code = null;
	private java.lang.String __invoice_number = null;
	private java.lang.Integer __contact_id = null;
}

