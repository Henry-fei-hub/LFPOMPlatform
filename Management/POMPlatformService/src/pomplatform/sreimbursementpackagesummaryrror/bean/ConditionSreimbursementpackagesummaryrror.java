package pomplatform.sreimbursementpackagesummaryrror.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSreimbursementpackagesummaryrror extends GenericCondition{

	public ConditionSreimbursementpackagesummaryrror(){
		setParameterCount(2);
	}

	public java.lang.Integer getReimbursementPackageSummaryId() {
		return this.__reimbursement_package_summary_id;
	}

	public void setReimbursementPackageSummaryId( java.lang.Integer value ) {
		this.__reimbursement_package_summary_id = value;
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
		if(getReimbursementPackageSummaryId() != null) sb.append(__wrapNumber(1, "reimbursementPackageSummaryId", getReimbursementPackageSummaryId()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(1, "reimbursementPackageId", getReimbursementPackageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("reimbursementPackageSummaryId")) != null) setReimbursementPackageSummaryId(__getInt(val)); 
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
	}

	private java.lang.Integer __reimbursement_package_summary_id = null;
	private java.lang.Integer __reimbursement_package_id = null;
}

