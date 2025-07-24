package pomplatform.k3code.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionBankAccountK3Code extends GenericCondition{

	public ConditionBankAccountK3Code(){
		setParameterCount(2);
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.String getK3Code() {
		return this.__k3_code == null ? null : (this.__k3_code.indexOf("%") >= 0 ? this.__k3_code : "%"+this.__k3_code+"%");
	}

	public void setK3Code( java.lang.String value ) {
		this.__k3_code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBusinessId() != null) sb.append(__wrapNumber(1, "businessId", getBusinessId()));
		if(getK3Code() != null) sb.append(__wrapString(1, "k3Code", getK3Code()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("k3Code")) != null) setK3Code(__getString(val));
	}

	private java.lang.Integer __business_id = null;
	private java.lang.String __k3_code = null;
}

