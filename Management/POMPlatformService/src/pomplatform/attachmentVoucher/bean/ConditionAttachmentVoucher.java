package pomplatform.attachmentVoucher.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAttachmentVoucher extends GenericCondition{

	public ConditionAttachmentVoucher(){
		setParameterCount(23);
	}

	public java.util.Date getMinVestingDate() {
		return this.__min_vesting_date;
	}

	public void setMinVestingDate( java.util.Date value ) {
		this.__min_vesting_date = value;
	}

	public java.util.Date getMaxVestingDate() {
		return this.__max_vesting_date;
	}

	public void setMaxVestingDate( java.util.Date value ) {
		this.__max_vesting_date = value;
	}

	public java.util.Date getMinCreateTime() {
		return this.__min_create_time;
	}

	public void setMinCreateTime( java.util.Date value ) {
		this.__min_create_time = value;
	}

	public java.util.Date getMaxCreateTime() {
		return this.__max_create_time;
	}

	public void setMaxCreateTime( java.util.Date value ) {
		this.__max_create_time = value;
	}

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getName() {
		return this.__name == null ? null : (this.__name.indexOf("%") >= 0 ? this.__name : "%"+this.__name+"%");
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getSimplifyRemark() {
		return this.__simplify_remark == null ? null : (this.__simplify_remark.indexOf("%") >= 0 ? this.__simplify_remark : "%"+this.__simplify_remark+"%");
	}

	public void setSimplifyRemark( java.lang.String value ) {
		this.__simplify_remark = value;
	}

	public java.lang.Integer getK3VoucherId() {
		return this.__k3_voucher_id;
	}

	public void setK3VoucherId( java.lang.Integer value ) {
		this.__k3_voucher_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getSequenceNumber() {
		return this.__sequence_number;
	}

	public void setSequenceNumber( java.lang.Integer value ) {
		this.__sequence_number = value;
	}

	public java.lang.Integer getInternalSequenceNumber() {
		return this.__internal_sequence_number;
	}

	public void setInternalSequenceNumber( java.lang.Integer value ) {
		this.__internal_sequence_number = value;
	}

	public java.lang.Integer getCodeType() {
		return this.__code_type;
	}

	public void setCodeType( java.lang.Integer value ) {
		this.__code_type = value;
	}

	public java.lang.Integer getCodeId() {
		return this.__code_id;
	}

	public void setCodeId( java.lang.Integer value ) {
		this.__code_id = value;
	}

	public java.lang.Integer getLinkId() {
		return this.__link_id;
	}

	public void setLinkId( java.lang.Integer value ) {
		this.__link_id = value;
	}

	public java.lang.Integer getVoucherType() {
		return this.__voucher_type;
	}

	public void setVoucherType( java.lang.Integer value ) {
		this.__voucher_type = value;
	}

	public java.lang.Integer getAdditionalLinkId() {
		return this.__additional_link_id;
	}

	public void setAdditionalLinkId( java.lang.Integer value ) {
		this.__additional_link_id = value;
	}

	public java.lang.Boolean getLocked() {
		return this.__locked;
	}

	public void setLocked( java.lang.Boolean value ) {
		this.__locked = value;
	}

	public java.math.BigDecimal getDebitSide() {
		return this.__debit_side;
	}

	public void setDebitSide( java.math.BigDecimal value ) {
		this.__debit_side = value;
	}

	public java.math.BigDecimal getCreditSide() {
		return this.__credit_side;
	}

	public void setCreditSide( java.math.BigDecimal value ) {
		this.__credit_side = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name == null ? null : (this.__attachment_name.indexOf("%") >= 0 ? this.__attachment_name : "%"+this.__attachment_name+"%");
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinVestingDate() != null) sb.append(__wrapDate(1, "minVestingDate", getMinVestingDate()));
		if(getMaxVestingDate() != null) sb.append(__wrapDate(1, "maxVestingDate", getMaxVestingDate()));
		if(getMinCreateTime() != null) sb.append(__wrapDate(1, "minCreateTime", getMinCreateTime()));
		if(getMaxCreateTime() != null) sb.append(__wrapDate(1, "maxCreateTime", getMaxCreateTime()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getName() != null) sb.append(__wrapString(1, "name", getName()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getSimplifyRemark() != null) sb.append(__wrapString(1, "simplifyRemark", getSimplifyRemark()));
		if(getK3VoucherId() != null) sb.append(__wrapNumber(1, "k3VoucherId", getK3VoucherId()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getSequenceNumber() != null) sb.append(__wrapNumber(1, "sequenceNumber", getSequenceNumber()));
		if(getInternalSequenceNumber() != null) sb.append(__wrapNumber(1, "internalSequenceNumber", getInternalSequenceNumber()));
		if(getCodeType() != null) sb.append(__wrapNumber(1, "codeType", getCodeType()));
		if(getCodeId() != null) sb.append(__wrapNumber(1, "codeId", getCodeId()));
		if(getLinkId() != null) sb.append(__wrapNumber(1, "linkId", getLinkId()));
		if(getVoucherType() != null) sb.append(__wrapNumber(1, "voucherType", getVoucherType()));
		if(getAdditionalLinkId() != null) sb.append(__wrapNumber(1, "additionalLinkId", getAdditionalLinkId()));
		if(getLocked() != null) sb.append(__wrapBoolean(1, "locked", getLocked()));
		if(getDebitSide() != null) sb.append(__wrapNumber(1, "debitSide", getDebitSide()));
		if(getCreditSide() != null) sb.append(__wrapNumber(1, "creditSide", getCreditSide()));
		if(getAttachmentName() != null) sb.append(__wrapString(1, "attachmentName", getAttachmentName()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minVestingDate")) != null) setMinVestingDate(__getDate(val)); 
		if((val = values.get("maxVestingDate")) != null) setMaxVestingDate(__getDate(val)); 
		if((val = values.get("minCreateTime")) != null) setMinCreateTime(__getDate(val)); 
		if((val = values.get("maxCreateTime")) != null) setMaxCreateTime(__getDate(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("simplifyRemark")) != null) setSimplifyRemark(__getString(val));
		if((val = values.get("k3VoucherId")) != null) setK3VoucherId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("sequenceNumber")) != null) setSequenceNumber(__getInt(val)); 
		if((val = values.get("internalSequenceNumber")) != null) setInternalSequenceNumber(__getInt(val)); 
		if((val = values.get("codeType")) != null) setCodeType(__getInt(val)); 
		if((val = values.get("codeId")) != null) setCodeId(__getInt(val)); 
		if((val = values.get("linkId")) != null) setLinkId(__getInt(val)); 
		if((val = values.get("voucherType")) != null) setVoucherType(__getInt(val)); 
		if((val = values.get("additionalLinkId")) != null) setAdditionalLinkId(__getInt(val)); 
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
		if((val = values.get("debitSide")) != null) setDebitSide(__getDecimal(val));  
		if((val = values.get("creditSide")) != null) setCreditSide(__getDecimal(val));  
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
	}

	private java.util.Date __min_vesting_date = null;
	private java.util.Date __max_vesting_date = null;
	private java.util.Date __min_create_time = null;
	private java.util.Date __max_create_time = null;
	private java.lang.String __code = null;
	private java.lang.String __name = null;
	private java.lang.String __remark = null;
	private java.lang.String __simplify_remark = null;
	private java.lang.Integer __k3_voucher_id = null;
	private java.lang.Integer __project_id = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __sequence_number = null;
	private java.lang.Integer __internal_sequence_number = null;
	private java.lang.Integer __code_type = null;
	private java.lang.Integer __code_id = null;
	private java.lang.Integer __link_id = null;
	private java.lang.Integer __voucher_type = null;
	private java.lang.Integer __additional_link_id = null;
	private java.lang.Boolean __locked = null;
	private java.math.BigDecimal __debit_side = null;
	private java.math.BigDecimal __credit_side = null;
	private java.lang.String __attachment_name = null;
	private java.lang.Integer __contract_id = null;
}

