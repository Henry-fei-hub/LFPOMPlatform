package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectStageProcessDetail extends GenericBase implements BaseFactory<BaseProjectStageProcessDetail>, Comparable<BaseProjectStageProcessDetail> 
{


	public static BaseProjectStageProcessDetail newInstance(){
		return new BaseProjectStageProcessDetail();
	}

	@Override
	public BaseProjectStageProcessDetail make(){
		BaseProjectStageProcessDetail b = new BaseProjectStageProcessDetail();
		return b;
	}

	public final static java.lang.String CS_PROJECT_STAGE_PROCESS_DETAIL_ID = "project_stage_process_detail_id" ;
	public final static java.lang.String CS_PROJECT_STAGE_PROCESS_RECORD_ID = "project_stage_process_record_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_PROJECT_AMOUNT = "project_amount" ;
	public final static java.lang.String CS_STAGE_NAME = "stage_name" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;

	public final static java.lang.String ALL_CAPTIONS = "id,project_stage_process_record_id,阶段id,占比,阶段积分,阶段名称,contract_id,main_project_id";

	public java.lang.Integer getProjectStageProcessDetailId() {
		return this.__project_stage_process_detail_id;
	}

	public void setProjectStageProcessDetailId( java.lang.Integer value ) {
		this.__project_stage_process_detail_id = value;
	}

	public java.lang.Integer getProjectStageProcessRecordId() {
		return this.__project_stage_process_record_id;
	}

	public void setProjectStageProcessRecordId( java.lang.Integer value ) {
		this.__project_stage_process_record_id = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.math.BigDecimal getProjectAmount() {
		return this.__project_amount;
	}

	public void setProjectAmount( java.math.BigDecimal value ) {
		this.__project_amount = value;
	}

	public java.lang.String getStageName() {
		return this.__stage_name;
	}

	public void setStageName( java.lang.String value ) {
		this.__stage_name = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public void cloneCopy(BaseProjectStageProcessDetail __bean){
		__bean.setProjectStageProcessDetailId(getProjectStageProcessDetailId());
		__bean.setProjectStageProcessRecordId(getProjectStageProcessRecordId());
		__bean.setStageId(getStageId());
		__bean.setPercent(getPercent());
		__bean.setProjectAmount(getProjectAmount());
		__bean.setStageName(getStageName());
		__bean.setContractId(getContractId());
		__bean.setMainProjectId(getMainProjectId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectStageProcessDetailId() == null ? "" : getProjectStageProcessDetailId());
		sb.append(",");
		sb.append(getProjectStageProcessRecordId() == null ? "" : getProjectStageProcessRecordId());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getProjectAmount() == null ? "" : getProjectAmount());
		sb.append(",");
		sb.append(getStageName() == null ? "" : getStageName());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectStageProcessDetail o) {
		return __project_stage_process_detail_id == null ? -1 : __project_stage_process_detail_id.compareTo(o.getProjectStageProcessDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_stage_process_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__project_stage_process_record_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__project_amount);
		hash = 97 * hash + Objects.hashCode(this.__stage_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectStageProcessDetail o = (BaseProjectStageProcessDetail)obj;
		if(!Objects.equals(this.__project_stage_process_detail_id, o.getProjectStageProcessDetailId())) return false;
		if(!Objects.equals(this.__project_stage_process_record_id, o.getProjectStageProcessRecordId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__project_amount, o.getProjectAmount())) return false;
		if(!Objects.equals(this.__stage_name, o.getStageName())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectStageProcessDetailId() != null) sb.append(__wrapNumber(count++, "projectStageProcessDetailId", getProjectStageProcessDetailId()));
		if(getProjectStageProcessRecordId() != null) sb.append(__wrapNumber(count++, "projectStageProcessRecordId", getProjectStageProcessRecordId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getProjectAmount() != null) sb.append(__wrapDecimal(count++, "projectAmount", getProjectAmount()));
		if(getStageName() != null) sb.append(__wrapString(count++, "stageName", getStageName()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectStageProcessDetailId() != null) res.put("projectStageProcessDetailId", getProjectStageProcessDetailId());
		if(getProjectStageProcessRecordId() != null) res.put("projectStageProcessRecordId", getProjectStageProcessRecordId());
		if(getStageId() != null) res.put("stageId", getStageId());
		if(getPercent() != null) res.put("percent", getPercent());
		if(getProjectAmount() != null) res.put("projectAmount", getProjectAmount());
		if(getStageName() != null) res.put("stageName", getStageName());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectStageProcessDetailId")) != null) setProjectStageProcessDetailId(__getInt(val)); 
		if((val = values.get("projectStageProcessRecordId")) != null) setProjectStageProcessRecordId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("projectAmount")) != null) setProjectAmount(__getDecimal(val));  
		if((val = values.get("stageName")) != null) setStageName(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_stage_process_detail_id ;
	protected java.lang.Integer  __project_stage_process_record_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.math.BigDecimal  __percent ;
	protected java.math.BigDecimal  __project_amount ;
	protected java.lang.String  __stage_name ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __main_project_id ;
}
