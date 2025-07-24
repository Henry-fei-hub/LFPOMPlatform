package pomplatform.k3voucher.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAllVoucherDetail extends GenericCondition{

	public ConditionAllVoucherDetail(){
		setParameterCount(5);
	}

	public java.lang.Integer getVoucherYear() {
		return this.__voucher_year;
	}

	public void setVoucherYear( java.lang.Integer value ) {
		this.__voucher_year = value;
	}

	public java.lang.Integer getVoucherMonth() {
		return this.__voucher_month;
	}

	public void setVoucherMonth( java.lang.Integer value ) {
		this.__voucher_month = value;
	}

	public java.lang.Integer getVoucherType() {
		return this.__voucher_type;
	}

	public void setVoucherType( java.lang.Integer value ) {
		this.__voucher_type = value;
	}

	public java.lang.Integer getSequenceNumber() {
		return this.__sequence_number;
	}

	public void setSequenceNumber( java.lang.Integer value ) {
		this.__sequence_number = value;
	}

	public java.util.Date getVestingDate() {
		return this.__vesting_date;
	}

	public void setVestingDate( java.util.Date value ) {
		this.__vesting_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getVoucherYear() != null) sb.append(__wrapNumber(1, "voucherYear", getVoucherYear()));
		if(getVoucherMonth() != null) sb.append(__wrapNumber(1, "voucherMonth", getVoucherMonth()));
		if(getVoucherType() != null) sb.append(__wrapNumber(1, "voucherType", getVoucherType()));
		if(getSequenceNumber() != null) sb.append(__wrapNumber(1, "sequenceNumber", getSequenceNumber()));
		if(getVestingDate() != null) sb.append(__wrapDate(1, "vestingDate", getVestingDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("voucherYear")) != null) setVoucherYear(__getInt(val)); 
		if((val = values.get("voucherMonth")) != null) setVoucherMonth(__getInt(val)); 
		if((val = values.get("voucherType")) != null) setVoucherType(__getInt(val)); 
		if((val = values.get("sequenceNumber")) != null) setSequenceNumber(__getInt(val)); 
		if((val = values.get("vestingDate")) != null) setVestingDate(__getDate(val)); 
	}

	private java.lang.Integer __voucher_year = null;
	private java.lang.Integer __voucher_month = null;
	private java.lang.Integer __voucher_type = null;
	private java.lang.Integer __sequence_number = null;
	private java.util.Date __vesting_date = null;
}

