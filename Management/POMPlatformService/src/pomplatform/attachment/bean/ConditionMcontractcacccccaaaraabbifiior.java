package pomplatform.attachment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcontractcacccccaaaraabbifiior extends GenericCondition{

	public ConditionMcontractcacccccaaaraabbifiior(){
		setParameterCount(20);
	}

	public java.util.Date getMinHappenDate() {
		return this.__min_happen_date;
	}

	public void setMinHappenDate( java.util.Date value ) {
		this.__min_happen_date = value;
	}
	
	public java.util.Date getMaxHappenDate() {
		return this.__max_happen_date;
	}

	public void setMaxHappenDate( java.util.Date value ) {
		this.__max_happen_date = value;
	}
	
	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
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

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
	}

	public java.lang.Integer getContractType() {
		return this.__contract_type;
	}

	public void setContractType( java.lang.Integer value ) {
		this.__contract_type = value;
	}

	public java.lang.String getAttachmentAddress() {
		return this.__attachment_address == null ? null : (this.__attachment_address.indexOf("%") >= 0 ? this.__attachment_address : "%"+this.__attachment_address+"%");
	}

	public void setAttachmentAddress( java.lang.String value ) {
		this.__attachment_address = value;
	}

	public java.lang.String getAttachmentCode() {
		return this.__attachment_code == null ? null : (this.__attachment_code.indexOf("%") >= 0 ? this.__attachment_code : "%"+this.__attachment_code+"%");
	}

	public void setAttachmentCode( java.lang.String value ) {
		this.__attachment_code = value;
	}

	public java.lang.Integer getAttachmentManageId() {
		return this.__attachment_manage_id;
	}

	public void setAttachmentManageId( java.lang.Integer value ) {
		this.__attachment_manage_id = value;
	}

	public java.math.BigDecimal getReturnAmount() {
		return this.__return_amount;
	}

	public void setReturnAmount( java.math.BigDecimal value ) {
		this.__return_amount = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name == null ? null : (this.__attachment_name.indexOf("%") >= 0 ? this.__attachment_name : "%"+this.__attachment_name+"%");
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code == null ? null : (this.__info_code.indexOf("%") >= 0 ? this.__info_code : "%"+this.__info_code+"%");
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getFlowStatus() {
		return this.__flow_status;
	}

	public void setFlowStatus( java.lang.Integer value ) {
		this.__flow_status = value;
	}

	public java.lang.Boolean getIsFinish() {
		return this.__is_finish;
	}

	public void setIsFinish( java.lang.Boolean value ) {
		this.__is_finish = value;
	}

	public java.lang.Boolean getIsSystemAdd() {
		return this.__is_system_add;
	}

	public void setIsSystemAdd( java.lang.Boolean value ) {
		this.__is_system_add = value;
	}

	public java.lang.Boolean getContractInfoAudited() {
		return __contract_info_audited;
	}

	public void setContractInfoAudited(java.lang.Boolean value) {
		this.__contract_info_audited = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinHappenDate() != null) sb.append(__wrapDate(1, "minHappenDate", getMinHappenDate()));
		if(getMaxHappenDate() != null) sb.append(__wrapDate(1, "maxHappenDate", getMaxHappenDate()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getContractStatus() != null) sb.append(__wrapNumber(1, "contractStatus", getContractStatus()));
		if(getContractType() != null) sb.append(__wrapNumber(1, "contractType", getContractType()));
		if(getAttachmentAddress() != null) sb.append(__wrapString(1, "attachmentAddress", getAttachmentAddress()));
		if(getAttachmentCode() != null) sb.append(__wrapString(1, "attachmentCode", getAttachmentCode()));
		if(getAttachmentManageId() != null) sb.append(__wrapNumber(1, "attachmentManageId", getAttachmentManageId()));
		if(getReturnAmount() != null) sb.append(__wrapNumber(1, "returnAmount", getReturnAmount()));
		if(getAmount() != null) sb.append(__wrapNumber(1, "amount", getAmount()));
		if(getAttachmentName() != null) sb.append(__wrapString(1, "attachmentName", getAttachmentName()));
		if(getBorrowMoney() != null) sb.append(__wrapNumber(1, "borrowMoney", getBorrowMoney()));
		if(getBusinessType() != null) sb.append(__wrapString(1, "businessType", getBusinessType()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getFlowStatus() != null) sb.append(__wrapNumber(1, "flowStatus", getFlowStatus()));
		if(getIsFinish() != null) sb.append(__wrapBoolean(1, "isFinish", getIsFinish()));
		if(getIsSystemAdd() != null) sb.append(__wrapBoolean(1, "isSystemAdd", getIsSystemAdd()));
		if(getContractInfoAudited() != null) sb.append(__wrapBoolean(1, "contractInfoAudited", getContractInfoAudited()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minHappenDate")) != null) setMinHappenDate(__getDate(val)); 
		if((val = values.get("maxHappenDate")) != null) setMaxHappenDate(__getDate(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("contractType")) != null) setContractType(__getInt(val)); 
		if((val = values.get("attachmentAddress")) != null) setAttachmentAddress(__getString(val));
		if((val = values.get("attachmentCode")) != null) setAttachmentCode(__getString(val));
		if((val = values.get("attachmentManageId")) != null) setAttachmentManageId(__getInt(val)); 
		if((val = values.get("returnAmount")) != null) setReturnAmount(__getDecimal(val));  
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("flowStatus")) != null) setFlowStatus(__getInt(val)); 
		if((val = values.get("isFinish")) != null) setIsFinish(__getBoolean(val));
		if((val = values.get("isSystemAdd")) != null) setIsSystemAdd(__getBoolean(val));
		if((val = values.get("contractInfoAudited")) != null) setContractInfoAudited(__getBoolean(val));
	}

	private java.util.Date __min_happen_date = null;
	private java.util.Date __max_happen_date = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.Integer __contract_status = null;
	private java.lang.Integer __contract_type = null;
	private java.lang.String __attachment_address = null;
	private java.lang.String __attachment_code = null;
	private java.lang.Integer __attachment_manage_id = null;
	private java.math.BigDecimal __return_amount = null;
	private java.math.BigDecimal __amount = null;
	private java.lang.String __attachment_name = null;
	private java.math.BigDecimal __borrow_money = null;
	private java.lang.String __business_type = null;
	private java.lang.String __info_code = null;
	private java.lang.Integer __flow_status = null;
	private java.lang.Boolean __is_finish = null;
	private java.lang.Boolean __is_system_add = null;
	private java.lang.Boolean __contract_info_audited = null;
}

