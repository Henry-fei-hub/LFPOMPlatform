package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnPayMoneyManageBusiness extends GenericCondition{

	public ConditionOnPayMoneyManageBusiness(){
		setParameterCount(4);
	}

	public java.lang.String getIdd() {
		return this.__idd;
	}

	public void setIdd( java.lang.String value ) {
		this.__idd = value;
	}

	public java.lang.String getVal() {
		return this.__val == null ? null : (this.__val.indexOf("%") >= 0 ? this.__val : "%"+this.__val+"%");
	}

	public void setVal( java.lang.String value ) {
		this.__val = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name;
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getIdd() != null) sb.append(__wrapString(1, "idd", getIdd()));
		if(getVal() != null) sb.append(__wrapString(1, "val", getVal()));
		if(getBankAccount() != null) sb.append(__wrapString(1, "bankAccount", getBankAccount()));
		if(getBankName() != null) sb.append(__wrapString(1, "bankName", getBankName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("idd")) != null) setIdd(__getString(val));
		if((val = values.get("val")) != null) setVal(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
	}

	private java.lang.String __idd = null;
	private java.lang.String __val = null;
	private java.lang.String __bank_account = null;
	private java.lang.String __bank_name = null;
}

