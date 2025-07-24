package pomplatform.contract.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadAttachmentBindContract extends GenericCondition{

	public ConditionOnLoadAttachmentBindContract(){
		setParameterCount(2);
	}

	public java.lang.Integer getContractAttachmentId() {
		return this.__contract_attachment_id;
	}

	public void setContractAttachmentId( java.lang.Integer value ) {
		this.__contract_attachment_id = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractAttachmentId() != null) sb.append(__wrapNumber(1, "contractAttachmentId", getContractAttachmentId()));
		if(getFileId() != null) sb.append(__wrapNumber(1, "fileId", getFileId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractAttachmentId")) != null) setContractAttachmentId(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
	}

	private java.lang.Integer __contract_attachment_id = null;
	private java.lang.Integer __file_id = null;
}

