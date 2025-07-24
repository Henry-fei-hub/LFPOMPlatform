package pomplatform.OnRevenue.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnSheetAttachmentOfRevenue extends GenericCondition{

	public ConditionOnSheetAttachmentOfRevenue(){
		setParameterCount(2);
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Boolean getIsHandle() {
		return this.__is_handle;
	}

	public void setIsHandle( java.lang.Boolean value ) {
		this.__is_handle = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getIsHandle() != null) sb.append(__wrapBoolean(1, "isHandle", getIsHandle()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("isHandle")) != null) setIsHandle(__getBoolean(val));
	}

	private java.lang.String __contract_code = null;
	private java.lang.Boolean __is_handle = null;
}

