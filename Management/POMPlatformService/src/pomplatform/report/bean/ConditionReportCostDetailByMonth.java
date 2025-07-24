package pomplatform.report.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionReportCostDetailByMonth extends GenericCondition{

	public ConditionReportCostDetailByMonth(){
		setParameterCount(10);
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getFeeType() {
		return this.__fee_type;
	}

	public void setFeeType( java.lang.Integer value ) {
		this.__fee_type = value;
	}

	public java.lang.String getBearFeeCode() {
		return this.__bear_fee_code == null ? null : (this.__bear_fee_code.indexOf("%") >= 0 ? this.__bear_fee_code : "%"+this.__bear_fee_code+"%");
	}

	public void setBearFeeCode( java.lang.String value ) {
		this.__bear_fee_code = value;
	}

	public java.lang.String getBearFeeName() {
		return this.__bear_fee_name == null ? null : (this.__bear_fee_name.indexOf("%") >= 0 ? this.__bear_fee_name : "%"+this.__bear_fee_name+"%");
	}

	public void setBearFeeName( java.lang.String value ) {
		this.__bear_fee_name = value;
	}

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getFeeType() != null) sb.append(__wrapNumber(1, "feeType", getFeeType()));
		if(getBearFeeCode() != null) sb.append(__wrapString(1, "bearFeeCode", getBearFeeCode()));
		if(getBearFeeName() != null) sb.append(__wrapString(1, "bearFeeName", getBearFeeName()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("feeType")) != null) setFeeType(__getInt(val)); 
		if((val = values.get("bearFeeCode")) != null) setBearFeeCode(__getString(val));
		if((val = values.get("bearFeeName")) != null) setBearFeeName(__getString(val));
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
	}

	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Integer __process_type = null;
	private java.lang.Integer __fee_type = null;
	private java.lang.String __bear_fee_code = null;
	private java.lang.String __bear_fee_name = null;
	private java.lang.String __code = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __process_status = null;
}

