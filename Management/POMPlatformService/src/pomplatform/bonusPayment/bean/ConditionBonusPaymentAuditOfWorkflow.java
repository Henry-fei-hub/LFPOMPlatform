package pomplatform.bonusPayment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionBonusPaymentAuditOfWorkflow extends GenericCondition{

	public ConditionBonusPaymentAuditOfWorkflow(){
		setParameterCount(8);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
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

	public java.util.Date getPayDate() {
		return this.__pay_date;
	}

	public void setPayDate( java.util.Date value ) {
		this.__pay_date = value;
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
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getBonusPaymentRecordId() != null) sb.append(__wrapNumber(1, "bonusPaymentRecordId", getBonusPaymentRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getPayDate() != null) sb.append(__wrapDate(1, "payDate", getPayDate()));
		if(getApplicant() != null) sb.append(__wrapNumber(1, "applicant", getApplicant()));
		if(getState() != null) sb.append(__wrapNumber(1, "state", getState()));
		if(getAuditor() != null) sb.append(__wrapNumber(1, "auditor", getAuditor()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("bonusPaymentRecordId")) != null) setBonusPaymentRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("payDate")) != null) setPayDate(__getDate(val)); 
		if((val = values.get("applicant")) != null) setApplicant(__getInt(val)); 
		if((val = values.get("state")) != null) setState(__getInt(val)); 
		if((val = values.get("auditor")) != null) setAuditor(__getInt(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __bonus_payment_record_id = null;
	private java.lang.Integer __plate_id = null;
	private java.util.Date __pay_date = null;
	private java.lang.Integer __applicant = null;
	private java.lang.Integer __state = null;
	private java.lang.Integer __auditor = null;
}

