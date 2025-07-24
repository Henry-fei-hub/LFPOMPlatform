package pomplatform.sreimbursementpackagedetailrror.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSreimbursementpackagedetailrror extends GenericCondition{

	public ConditionSreimbursementpackagedetailrror(){
		setParameterCount(2);
	}

	public java.lang.Integer getReimbursementPackageDetailId() {
		return this.__reimbursement_package_detail_id;
	}

	public void setReimbursementPackageDetailId( java.lang.Integer value ) {
		this.__reimbursement_package_detail_id = value;
	}

	public java.lang.Integer getReimbursementPackageId() {
		return this.__reimbursement_package_id;
	}

	public void setReimbursementPackageId( java.lang.Integer value ) {
		this.__reimbursement_package_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getReimbursementPackageDetailId() != null) sb.append(__wrapNumber(1, "reimbursementPackageDetailId", getReimbursementPackageDetailId()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(1, "reimbursementPackageId", getReimbursementPackageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("reimbursementPackageDetailId")) != null) setReimbursementPackageDetailId(__getInt(val)); 
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
	}

	private java.lang.Integer __reimbursement_package_detail_id = null;
	private java.lang.Integer __reimbursement_package_id = null;
}

