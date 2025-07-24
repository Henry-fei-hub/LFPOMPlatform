package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionBonusApplication extends GenericCondition{

	public ConditionBonusApplication(){
		setParameterCount(5);
	}

	public java.lang.Integer getBonusPaymentRecordId() {
		return this.__bonus_payment_record_id;
	}

	public void setBonusPaymentRecordId( java.lang.Integer value ) {
		this.__bonus_payment_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getApplicant() {
		return this.__applicant;
	}

	public void setApplicant( java.lang.Integer value ) {
		this.__applicant = value;
	}

	public java.lang.Integer getState() {
		return this.__state;
	}

	public void setState( java.lang.Integer value ) {
		this.__state = value;
	}

	public java.lang.Integer getAuditor() {
		return this.__auditor;
	}

	public void setAuditor( java.lang.Integer value ) {
		this.__auditor = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBonusPaymentRecordId() != null) sb.append(__wrapNumber(1, "bonusPaymentRecordId", getBonusPaymentRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getApplicant() != null) sb.append(__wrapNumber(1, "applicant", getApplicant()));
		if(getState() != null) sb.append(__wrapNumber(1, "state", getState()));
		if(getAuditor() != null) sb.append(__wrapNumber(1, "auditor", getAuditor()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("bonusPaymentRecordId")) != null) setBonusPaymentRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("applicant")) != null) setApplicant(__getInt(val)); 
		if((val = values.get("state")) != null) setState(__getInt(val)); 
		if((val = values.get("auditor")) != null) setAuditor(__getInt(val)); 
	}

	private java.lang.Integer __bonus_payment_record_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __applicant = null;
	private java.lang.Integer __state = null;
	private java.lang.Integer __auditor = null;
}

