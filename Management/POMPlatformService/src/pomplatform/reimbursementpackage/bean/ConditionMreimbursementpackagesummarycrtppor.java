package pomplatform.reimbursementpackage.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMreimbursementpackagesummarycrtppor extends GenericCondition{

	public ConditionMreimbursementpackagesummarycrtppor(){
		setParameterCount(4);
	}

	public java.lang.Integer getReimbursementPackageId() {
		return this.__reimbursement_package_id;
	}

	public void setReimbursementPackageId( java.lang.Integer value ) {
		this.__reimbursement_package_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getPayResult() {
		return this.__pay_result;
	}

	public void setPayResult( java.lang.Integer value ) {
		this.__pay_result = value;
	}

	public java.lang.Integer getPayStatus() {
		return this.__pay_status;
	}

	public void setPayStatus( java.lang.Integer value ) {
		this.__pay_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(1, "reimbursementPackageId", getReimbursementPackageId()));
		if(getType() != null) sb.append(__wrapNumber(1, "type", getType()));
		if(getPayResult() != null) sb.append(__wrapNumber(1, "payResult", getPayResult()));
		if(getPayStatus() != null) sb.append(__wrapNumber(1, "payStatus", getPayStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("payResult")) != null) setPayResult(__getInt(val)); 
		if((val = values.get("payStatus")) != null) setPayStatus(__getInt(val)); 
	}

	private java.lang.Integer __reimbursement_package_id = null;
	private java.lang.Integer __type = null;
	private java.lang.Integer __pay_result = null;
	private java.lang.Integer __pay_status = null;
}

