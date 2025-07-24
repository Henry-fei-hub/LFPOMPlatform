package pomplatform.employee.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionContractDistributionNew extends GenericCondition{

	public ConditionContractDistributionNew(){
		setParameterCount(6);
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
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

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getOrderStatus() {
		return this.__order_status;
	}

	public void setOrderStatus( java.lang.Integer value ) {
		this.__order_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getBusinessType() != null) sb.append(__wrapString(1, "businessType", getBusinessType()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getOrderStatus() != null) sb.append(__wrapNumber(1, "orderStatus", getOrderStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val));
		if((val = values.get("orderStatus")) != null) setOrderStatus(__getInt(val));
	}

	private java.lang.String __contract_code = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.String __contract_name = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.String __business_type = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __order_status = null;
}

