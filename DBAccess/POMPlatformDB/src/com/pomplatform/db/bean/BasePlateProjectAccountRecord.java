package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePlateProjectAccountRecord extends GenericBase implements BaseFactory<BasePlateProjectAccountRecord>, Comparable<BasePlateProjectAccountRecord> 
{


	public static BasePlateProjectAccountRecord newInstance(){
		return new BasePlateProjectAccountRecord();
	}

	@Override
	public BasePlateProjectAccountRecord make(){
		BasePlateProjectAccountRecord b = new BasePlateProjectAccountRecord();
		return b;
	}

	public final static java.lang.String CS_PLATE_PROJECT_ACCOUNT_RECORD_ID = "plate_project_account_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_ACCOUNT_INTEGRAL = "account_integral" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_ACCOUNT_DATE = "account_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_SETTLEMENT_ID = "settlement_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务部门,项目结算的预留积分,项目,结算阶段,结算日期,备注,结算id";

	public java.lang.Integer getPlateProjectAccountRecordId() {
		return this.__plate_project_account_record_id;
	}

	public void setPlateProjectAccountRecordId( java.lang.Integer value ) {
		this.__plate_project_account_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getAccountIntegral() {
		return this.__account_integral;
	}

	public void setAccountIntegral( java.math.BigDecimal value ) {
		this.__account_integral = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.util.Date getAccountDate() {
		return this.__account_date;
	}

	public void setAccountDate( java.util.Date value ) {
		this.__account_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getSettlementId() {
		return this.__settlement_id;
	}

	public void setSettlementId( java.lang.Integer value ) {
		this.__settlement_id = value;
	}

	public void cloneCopy(BasePlateProjectAccountRecord __bean){
		__bean.setPlateProjectAccountRecordId(getPlateProjectAccountRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setAccountIntegral(getAccountIntegral());
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
		__bean.setAccountDate(getAccountDate());
		__bean.setRemark(getRemark());
		__bean.setSettlementId(getSettlementId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateProjectAccountRecordId() == null ? "" : getPlateProjectAccountRecordId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getAccountIntegral() == null ? "" : getAccountIntegral());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getAccountDate() == null ? "" : sdf.format(getAccountDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getSettlementId() == null ? "" : getSettlementId());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateProjectAccountRecord o) {
		return __plate_project_account_record_id == null ? -1 : __plate_project_account_record_id.compareTo(o.getPlateProjectAccountRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_project_account_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__account_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__account_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__settlement_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateProjectAccountRecord o = (BasePlateProjectAccountRecord)obj;
		if(!Objects.equals(this.__plate_project_account_record_id, o.getPlateProjectAccountRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__account_integral, o.getAccountIntegral())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__account_date, o.getAccountDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__settlement_id, o.getSettlementId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateProjectAccountRecordId() != null) sb.append(__wrapNumber(count++, "plateProjectAccountRecordId", getPlateProjectAccountRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getAccountIntegral() != null) sb.append(__wrapDecimal(count++, "accountIntegral", getAccountIntegral()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getAccountDate() != null) sb.append(__wrapDate(count++, "accountDate", getAccountDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getSettlementId() != null) sb.append(__wrapNumber(count++, "settlementId", getSettlementId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPlateProjectAccountRecordId() != null) res.put("plateProjectAccountRecordId", getPlateProjectAccountRecordId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getAccountIntegral() != null) res.put("accountIntegral", getAccountIntegral());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getStageId() != null) res.put("stageId", getStageId());
		if(getAccountDate() != null) res.put("accountDate", getAccountDate());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getSettlementId() != null) res.put("settlementId", getSettlementId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateProjectAccountRecordId")) != null) setPlateProjectAccountRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("accountIntegral")) != null) setAccountIntegral(__getDecimal(val));  
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("accountDate")) != null) setAccountDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("settlementId")) != null) setSettlementId(__getInt(val)); 
	}

	protected java.lang.Integer  __plate_project_account_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __account_integral ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.util.Date  __account_date ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __settlement_id ;
}
