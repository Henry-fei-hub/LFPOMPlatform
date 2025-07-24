package pomplatform.financialtransactionaccount.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetTransDetailsNeedToDelete extends GenericCondition{

	public ConditionGetTransDetailsNeedToDelete(){
		setParameterCount(3);
	}

	public java.lang.Integer getTransDetailDeleteFlag() {
		return this.__trans_detail_delete_flag;
	}

	public void setTransDetailDeleteFlag( java.lang.Integer value ) {
		this.__trans_detail_delete_flag = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getSpiDeleteFlag() {
		return this.__spi_delete_flag;
	}

	public void setSpiDeleteFlag( java.lang.Integer value ) {
		this.__spi_delete_flag = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTransDetailDeleteFlag() != null) sb.append(__wrapNumber(1, "transDetailDeleteFlag", getTransDetailDeleteFlag()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getSpiDeleteFlag() != null) sb.append(__wrapNumber(1, "spiDeleteFlag", getSpiDeleteFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("transDetailDeleteFlag")) != null) setTransDetailDeleteFlag(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("spiDeleteFlag")) != null) setSpiDeleteFlag(__getInt(val)); 
	}

	private java.lang.Integer __trans_detail_delete_flag = null;
	private java.lang.Integer __process_status = null;
	private java.lang.Integer __spi_delete_flag = null;
}

