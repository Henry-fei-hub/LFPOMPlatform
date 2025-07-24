package pomplatform.k3voucher.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetCompanyBankAccountK3Code extends GenericCondition{

	public ConditionGetCompanyBankAccountK3Code(){
		setParameterCount(1);
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBankAccount() != null) sb.append(__wrapString(1, "bankAccount", getBankAccount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
	}

	private java.lang.String __bank_account = null;
}

