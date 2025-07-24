package pomplatform.attachment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnUpdateAttachmentLinkInvoiceApplys extends GenericCondition{

	public ConditionOnUpdateAttachmentLinkInvoiceApplys(){
		setParameterCount(2);
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAttachmentManageId() != null) sb.append(__wrapNumber(1, "attachmentManageId", getAttachmentManageId()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("attachmentManageId")) != null) setAttachmentManageId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
	}

	private java.lang.Integer __attachment_manage_id = null;
	private java.lang.Integer __contract_id = null;
}

