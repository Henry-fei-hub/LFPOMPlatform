package pomplatform.bank.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionBankManager extends GenericCondition{

	public ConditionBankManager(){
		setParameterCount(1);
	}

	public java.lang.String getBankName() {
		return this.__bank_name == null ? null : (this.__bank_name.indexOf("%") >= 0 ? this.__bank_name : "%"+this.__bank_name+"%");
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBankName() != null) sb.append(__wrapString(1, "bankName", getBankName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
	}

	private java.lang.String __bank_name = null;
}

