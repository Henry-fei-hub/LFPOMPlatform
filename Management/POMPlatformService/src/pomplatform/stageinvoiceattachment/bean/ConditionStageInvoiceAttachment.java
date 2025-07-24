package pomplatform.stageinvoiceattachment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionStageInvoiceAttachment extends GenericCondition{

	public ConditionStageInvoiceAttachment(){
		setParameterCount(1);
	}

	public java.lang.Integer getAttachmentManageId() {
		return this.__attachment_manage_id;
	}

	public void setAttachmentManageId( java.lang.Integer value ) {
		this.__attachment_manage_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAttachmentManageId() != null) sb.append(__wrapNumber(1, "attachmentManageId", getAttachmentManageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("attachmentManageId")) != null) setAttachmentManageId(__getInt(val)); 
	}

	private java.lang.Integer __attachment_manage_id = null;
}

