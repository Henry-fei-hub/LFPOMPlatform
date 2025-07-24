package pomplatform.attachment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSattachmentmanageaaaor extends GenericCondition{

	public ConditionSattachmentmanageaaaor(){
		setParameterCount(7);
	}

	public java.lang.String getAttachmentCode() {
		return this.__attachment_code == null ? null : (this.__attachment_code.indexOf("%") >= 0 ? this.__attachment_code : "%"+this.__attachment_code+"%");
	}

	public void setAttachmentCode( java.lang.String value ) {
		this.__attachment_code = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name == null ? null : (this.__attachment_name.indexOf("%") >= 0 ? this.__attachment_name : "%"+this.__attachment_name+"%");
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.String getAttachmentAddress() {
		return this.__attachment_address == null ? null : (this.__attachment_address.indexOf("%") >= 0 ? this.__attachment_address : "%"+this.__attachment_address+"%");
	}

	public void setAttachmentAddress( java.lang.String value ) {
		this.__attachment_address = value;
	}

	public java.lang.String getPerfessionRemark() {
		return this.__perfession_remark == null ? null : (this.__perfession_remark.indexOf("%") >= 0 ? this.__perfession_remark : "%"+this.__perfession_remark+"%");
	}

	public void setPerfessionRemark( java.lang.String value ) {
		this.__perfession_remark = value;
	}

	public java.lang.Integer getAttachmentManageId() {
		return this.__attachment_manage_id;
	}

	public void setAttachmentManageId( java.lang.Integer value ) {
		this.__attachment_manage_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getSerialNumber() {
		return this.__serial_number;
	}

	public void setSerialNumber( java.lang.Integer value ) {
		this.__serial_number = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAttachmentCode() != null) sb.append(__wrapString(1, "attachmentCode", getAttachmentCode()));
		if(getAttachmentName() != null) sb.append(__wrapString(1, "attachmentName", getAttachmentName()));
		if(getAttachmentAddress() != null) sb.append(__wrapString(1, "attachmentAddress", getAttachmentAddress()));
		if(getPerfessionRemark() != null) sb.append(__wrapString(1, "perfessionRemark", getPerfessionRemark()));
		if(getAttachmentManageId() != null) sb.append(__wrapNumber(1, "attachmentManageId", getAttachmentManageId()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getSerialNumber() != null) sb.append(__wrapNumber(1, "serialNumber", getSerialNumber()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("attachmentCode")) != null) setAttachmentCode(__getString(val));
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("attachmentAddress")) != null) setAttachmentAddress(__getString(val));
		if((val = values.get("perfessionRemark")) != null) setPerfessionRemark(__getString(val));
		if((val = values.get("attachmentManageId")) != null) setAttachmentManageId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("serialNumber")) != null) setSerialNumber(__getInt(val)); 
	}

	private java.lang.String __attachment_code = null;
	private java.lang.String __attachment_name = null;
	private java.lang.String __attachment_address = null;
	private java.lang.String __perfession_remark = null;
	private java.lang.Integer __attachment_manage_id = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __serial_number = null;
}

