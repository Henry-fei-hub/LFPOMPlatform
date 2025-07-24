package pomplatform.cmbcinfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcmbcaccoutinfoccacbscor extends GenericCondition{

	public ConditionMcmbcaccoutinfoccacbscor(){
		setParameterCount(6);
	}

	public java.lang.Integer getCompanyRecordId() {
		return this.__company_record_id;
	}

	public void setCompanyRecordId( java.lang.Integer value ) {
		this.__company_record_id = value;
	}

	public java.lang.String getAccnbr() {
		return this.__accnbr == null ? null : (this.__accnbr.indexOf("%") >= 0 ? this.__accnbr : "%"+this.__accnbr+"%");
	}

	public void setAccnbr( java.lang.String value ) {
		this.__accnbr = value;
	}

	public java.lang.Integer getCmbcAccoutInfoId() {
		return this.__cmbc_accout_info_id;
	}

	public void setCmbcAccoutInfoId( java.lang.Integer value ) {
		this.__cmbc_accout_info_id = value;
	}

	public java.lang.String getBbknbr() {
		return this.__bbknbr;
	}

	public void setBbknbr( java.lang.String value ) {
		this.__bbknbr = value;
	}

	public java.lang.String getStscod() {
		return this.__stscod;
	}

	public void setStscod( java.lang.String value ) {
		this.__stscod = value;
	}

	public java.lang.String getCcynbr() {
		return this.__ccynbr;
	}

	public void setCcynbr( java.lang.String value ) {
		this.__ccynbr = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCompanyRecordId() != null) sb.append(__wrapNumber(1, "companyRecordId", getCompanyRecordId()));
		if(getAccnbr() != null) sb.append(__wrapString(1, "accnbr", getAccnbr()));
		if(getCmbcAccoutInfoId() != null) sb.append(__wrapNumber(1, "cmbcAccoutInfoId", getCmbcAccoutInfoId()));
		if(getBbknbr() != null) sb.append(__wrapString(1, "bbknbr", getBbknbr()));
		if(getStscod() != null) sb.append(__wrapString(1, "stscod", getStscod()));
		if(getCcynbr() != null) sb.append(__wrapString(1, "ccynbr", getCcynbr()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("companyRecordId")) != null) setCompanyRecordId(__getInt(val)); 
		if((val = values.get("accnbr")) != null) setAccnbr(__getString(val));
		if((val = values.get("cmbcAccoutInfoId")) != null) setCmbcAccoutInfoId(__getInt(val)); 
		if((val = values.get("bbknbr")) != null) setBbknbr(__getString(val));
		if((val = values.get("stscod")) != null) setStscod(__getString(val));
		if((val = values.get("ccynbr")) != null) setCcynbr(__getString(val));
	}

	private java.lang.Integer __company_record_id = null;
	private java.lang.String __accnbr = null;
	private java.lang.Integer __cmbc_accout_info_id = null;
	private java.lang.String __bbknbr = null;
	private java.lang.String __stscod = null;
	private java.lang.String __ccynbr = null;
}

