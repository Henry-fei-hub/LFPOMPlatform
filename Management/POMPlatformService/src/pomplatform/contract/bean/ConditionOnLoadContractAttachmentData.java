package pomplatform.contract.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadContractAttachmentData extends GenericCondition{

	public ConditionOnLoadContractAttachmentData(){
		setParameterCount(6);
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

	public java.lang.String getAttachmentName() {
		return this.__attachment_name == null ? null : (this.__attachment_name.indexOf("%") >= 0 ? this.__attachment_name : "%"+this.__attachment_name+"%");
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.String getAttachmentCode() {
		return this.__attachment_code == null ? null : (this.__attachment_code.indexOf("%") >= 0 ? this.__attachment_code : "%"+this.__attachment_code+"%");
	}

	public void setAttachmentCode( java.lang.String value ) {
		this.__attachment_code = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getAttachmentName() != null) sb.append(__wrapString(1, "attachmentName", getAttachmentName()));
		if(getAttachmentCode() != null) sb.append(__wrapString(1, "attachmentCode", getAttachmentCode()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("attachmentCode")) != null) setAttachmentCode(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
	}

	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.String __attachment_name = null;
	private java.lang.String __attachment_code = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
}

