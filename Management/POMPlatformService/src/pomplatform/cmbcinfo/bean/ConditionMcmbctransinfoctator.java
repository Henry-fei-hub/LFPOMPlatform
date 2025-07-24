package pomplatform.cmbcinfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcmbctransinfoctator extends GenericCondition{

	public ConditionMcmbctransinfoctator(){
		setParameterCount(24);
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account == null ? null : (this.__bank_account.indexOf("%") >= 0 ? this.__bank_account : "%"+this.__bank_account+"%");
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.Integer getCompanyRecordId() {
		return this.__company_record_id;
	}

	public void setCompanyRecordId( java.lang.Integer value ) {
		this.__company_record_id = value;
	}

	public java.lang.String getNaryur() {
		return this.__naryur == null ? null : (this.__naryur.indexOf("%") >= 0 ? this.__naryur : "%"+this.__naryur+"%");
	}

	public void setNaryur( java.lang.String value ) {
		this.__naryur = value;
	}

	public java.lang.String getRefnbr() {
		return this.__refnbr == null ? null : (this.__refnbr.indexOf("%") >= 0 ? this.__refnbr : "%"+this.__refnbr+"%");
	}

	public void setRefnbr( java.lang.String value ) {
		this.__refnbr = value;
	}

	public java.lang.String getReqnbr() {
		return this.__reqnbr == null ? null : (this.__reqnbr.indexOf("%") >= 0 ? this.__reqnbr : "%"+this.__reqnbr+"%");
	}

	public void setReqnbr( java.lang.String value ) {
		this.__reqnbr = value;
	}

	public java.lang.String getBusnam() {
		return this.__busnam == null ? null : (this.__busnam.indexOf("%") >= 0 ? this.__busnam : "%"+this.__busnam+"%");
	}

	public void setBusnam( java.lang.String value ) {
		this.__busnam = value;
	}

	public java.lang.String getNusage() {
		return this.__nusage == null ? null : (this.__nusage.indexOf("%") >= 0 ? this.__nusage : "%"+this.__nusage+"%");
	}

	public void setNusage( java.lang.String value ) {
		this.__nusage = value;
	}

	public java.lang.String getYurref() {
		return this.__yurref == null ? null : (this.__yurref.indexOf("%") >= 0 ? this.__yurref : "%"+this.__yurref+"%");
	}

	public void setYurref( java.lang.String value ) {
		this.__yurref = value;
	}

	public java.lang.String getRpynam() {
		return this.__rpynam == null ? null : (this.__rpynam.indexOf("%") >= 0 ? this.__rpynam : "%"+this.__rpynam+"%");
	}

	public void setRpynam( java.lang.String value ) {
		this.__rpynam = value;
	}

	public java.lang.String getRpyacc() {
		return this.__rpyacc == null ? null : (this.__rpyacc.indexOf("%") >= 0 ? this.__rpyacc : "%"+this.__rpyacc+"%");
	}

	public void setRpyacc( java.lang.String value ) {
		this.__rpyacc = value;
	}

	public java.lang.String getRpybnk() {
		return this.__rpybnk == null ? null : (this.__rpybnk.indexOf("%") >= 0 ? this.__rpybnk : "%"+this.__rpybnk+"%");
	}

	public void setRpybnk( java.lang.String value ) {
		this.__rpybnk = value;
	}

	public java.lang.String getRpyadr() {
		return this.__rpyadr == null ? null : (this.__rpyadr.indexOf("%") >= 0 ? this.__rpyadr : "%"+this.__rpyadr+"%");
	}

	public void setRpyadr( java.lang.String value ) {
		this.__rpyadr = value;
	}

	public java.util.Date getMinTransDate() {
		return this.__min_trans_date;
	}

	public void setMinTransDate( java.util.Date value ) {
		this.__min_trans_date = value;
	}

	public java.util.Date getMaxTransDate() {
		return this.__max_trans_date;
	}

	public void setMaxTransDate( java.util.Date value ) {
		this.__max_trans_date = value;
	}

	public java.util.Date getMinVltdat() {
		return this.__min_vltdat;
	}

	public void setMinVltdat( java.util.Date value ) {
		this.__min_vltdat = value;
	}

	public java.util.Date getMaxVltdat() {
		return this.__max_vltdat;
	}

	public void setMaxVltdat( java.util.Date value ) {
		this.__max_vltdat = value;
	}

	public java.util.Date getMinCreateTime() {
		return this.__min_create_time;
	}

	public void setMinCreateTime( java.util.Date value ) {
		this.__min_create_time = value;
	}

	public java.util.Date getMaxCreateTime() {
		return this.__max_create_time;
	}

	public void setMaxCreateTime( java.util.Date value ) {
		this.__max_create_time = value;
	}

	public java.util.Date getMinUpdateTime() {
		return this.__min_update_time;
	}

	public void setMinUpdateTime( java.util.Date value ) {
		this.__min_update_time = value;
	}

	public java.util.Date getMaxUpdateTime() {
		return this.__max_update_time;
	}

	public void setMaxUpdateTime( java.util.Date value ) {
		this.__max_update_time = value;
	}

	public java.lang.Integer getCmbcTransInfoId() {
		return this.__cmbc_trans_info_id;
	}

	public void setCmbcTransInfoId( java.lang.Integer value ) {
		this.__cmbc_trans_info_id = value;
	}

	public java.lang.String getTrscod() {
		return this.__trscod;
	}

	public void setTrscod( java.lang.String value ) {
		this.__trscod = value;
	}

	public java.lang.String getAmtcdr() {
		return this.__amtcdr;
	}

	public void setAmtcdr( java.lang.String value ) {
		this.__amtcdr = value;
	}

	public java.lang.String getTrsanl() {
		return this.__trsanl;
	}

	public void setTrsanl( java.lang.String value ) {
		this.__trsanl = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBankAccount() != null) sb.append(__wrapString(1, "bankAccount", getBankAccount()));
		if(getCompanyRecordId() != null) sb.append(__wrapNumber(1, "companyRecordId", getCompanyRecordId()));
		if(getNaryur() != null) sb.append(__wrapString(1, "naryur", getNaryur()));
		if(getRefnbr() != null) sb.append(__wrapString(1, "refnbr", getRefnbr()));
		if(getReqnbr() != null) sb.append(__wrapString(1, "reqnbr", getReqnbr()));
		if(getBusnam() != null) sb.append(__wrapString(1, "busnam", getBusnam()));
		if(getNusage() != null) sb.append(__wrapString(1, "nusage", getNusage()));
		if(getYurref() != null) sb.append(__wrapString(1, "yurref", getYurref()));
		if(getRpynam() != null) sb.append(__wrapString(1, "rpynam", getRpynam()));
		if(getRpyacc() != null) sb.append(__wrapString(1, "rpyacc", getRpyacc()));
		if(getRpybnk() != null) sb.append(__wrapString(1, "rpybnk", getRpybnk()));
		if(getRpyadr() != null) sb.append(__wrapString(1, "rpyadr", getRpyadr()));
		if(getMinTransDate() != null) sb.append(__wrapDate(1, "minTransDate", getMinTransDate()));
		if(getMaxTransDate() != null) sb.append(__wrapDate(1, "maxTransDate", getMaxTransDate()));
		if(getMinVltdat() != null) sb.append(__wrapDate(1, "minVltdat", getMinVltdat()));
		if(getMaxVltdat() != null) sb.append(__wrapDate(1, "maxVltdat", getMaxVltdat()));
		if(getMinCreateTime() != null) sb.append(__wrapDate(1, "minCreateTime", getMinCreateTime()));
		if(getMaxCreateTime() != null) sb.append(__wrapDate(1, "maxCreateTime", getMaxCreateTime()));
		if(getMinUpdateTime() != null) sb.append(__wrapDate(1, "minUpdateTime", getMinUpdateTime()));
		if(getMaxUpdateTime() != null) sb.append(__wrapDate(1, "maxUpdateTime", getMaxUpdateTime()));
		if(getCmbcTransInfoId() != null) sb.append(__wrapNumber(1, "cmbcTransInfoId", getCmbcTransInfoId()));
		if(getTrscod() != null) sb.append(__wrapString(1, "trscod", getTrscod()));
		if(getAmtcdr() != null) sb.append(__wrapString(1, "amtcdr", getAmtcdr()));
		if(getTrsanl() != null) sb.append(__wrapString(1, "trsanl", getTrsanl()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("companyRecordId")) != null) setCompanyRecordId(__getInt(val)); 
		if((val = values.get("naryur")) != null) setNaryur(__getString(val));
		if((val = values.get("refnbr")) != null) setRefnbr(__getString(val));
		if((val = values.get("reqnbr")) != null) setReqnbr(__getString(val));
		if((val = values.get("busnam")) != null) setBusnam(__getString(val));
		if((val = values.get("nusage")) != null) setNusage(__getString(val));
		if((val = values.get("yurref")) != null) setYurref(__getString(val));
		if((val = values.get("rpynam")) != null) setRpynam(__getString(val));
		if((val = values.get("rpyacc")) != null) setRpyacc(__getString(val));
		if((val = values.get("rpybnk")) != null) setRpybnk(__getString(val));
		if((val = values.get("rpyadr")) != null) setRpyadr(__getString(val));
		if((val = values.get("minTransDate")) != null) setMinTransDate(__getDate(val)); 
		if((val = values.get("maxTransDate")) != null) setMaxTransDate(__getDate(val)); 
		if((val = values.get("minVltdat")) != null) setMinVltdat(__getDate(val)); 
		if((val = values.get("maxVltdat")) != null) setMaxVltdat(__getDate(val)); 
		if((val = values.get("minCreateTime")) != null) setMinCreateTime(__getDate(val)); 
		if((val = values.get("maxCreateTime")) != null) setMaxCreateTime(__getDate(val)); 
		if((val = values.get("minUpdateTime")) != null) setMinUpdateTime(__getDate(val)); 
		if((val = values.get("maxUpdateTime")) != null) setMaxUpdateTime(__getDate(val)); 
		if((val = values.get("cmbcTransInfoId")) != null) setCmbcTransInfoId(__getInt(val)); 
		if((val = values.get("trscod")) != null) setTrscod(__getString(val));
		if((val = values.get("amtcdr")) != null) setAmtcdr(__getString(val));
		if((val = values.get("trsanl")) != null) setTrsanl(__getString(val));
	}

	private java.lang.String __bank_account = null;
	private java.lang.Integer __company_record_id = null;
	private java.lang.String __naryur = null;
	private java.lang.String __refnbr = null;
	private java.lang.String __reqnbr = null;
	private java.lang.String __busnam = null;
	private java.lang.String __nusage = null;
	private java.lang.String __yurref = null;
	private java.lang.String __rpynam = null;
	private java.lang.String __rpyacc = null;
	private java.lang.String __rpybnk = null;
	private java.lang.String __rpyadr = null;
	private java.util.Date __min_trans_date = null;
	private java.util.Date __max_trans_date = null;
	private java.util.Date __min_vltdat = null;
	private java.util.Date __max_vltdat = null;
	private java.util.Date __min_create_time = null;
	private java.util.Date __max_create_time = null;
	private java.util.Date __min_update_time = null;
	private java.util.Date __max_update_time = null;
	private java.lang.Integer __cmbc_trans_info_id = null;
	private java.lang.String __trscod = null;
	private java.lang.String __amtcdr = null;
	private java.lang.String __trsanl = null;
}

