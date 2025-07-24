package pomplatform.contractInfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionContractInfo extends GenericCondition{

	public ConditionContractInfo(){
		setParameterCount(3);
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type == null ? null : (this.__business_type.indexOf("%") >= 0 ? this.__business_type : "%"+this.__business_type+"%");
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getBusinessType() != null) sb.append(__wrapString(1, "businessType", getBusinessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
	}

	private java.lang.String __contract_code = null;
	private java.lang.String __project_code = null;
	private java.lang.String __business_type = null;
}

