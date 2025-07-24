package pomplatform.payment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSendIntegralOfEmpPaymentDetail extends GenericCondition{

	public ConditionSendIntegralOfEmpPaymentDetail(){
		setParameterCount(5);
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getPlateType() {
		return this.__plate_type;
	}

	public void setPlateType( java.lang.Integer value ) {
		this.__plate_type = value;
	}

	public java.util.Date getDetailDate() {
		return this.__detail_date;
	}

	public void setDetailDate( java.util.Date value ) {
		this.__detail_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getPlateType() != null) sb.append(__wrapNumber(1, "plateType", getPlateType()));
		if(getDetailDate() != null) sb.append(__wrapDate(1, "detailDate", getDetailDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateType")) != null) setPlateType(__getInt(val)); 
		if((val = values.get("detailDate")) != null) setDetailDate(__getDate(val)); 
	}

	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __plate_type = null;
	private java.util.Date __detail_date = null;
}

