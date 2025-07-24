package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMainProjectStage extends GenericBase implements BaseFactory<BaseMainProjectStage>, Comparable<BaseMainProjectStage> 
{


	public static BaseMainProjectStage newInstance(){
		return new BaseMainProjectStage();
	}

	@Override
	public BaseMainProjectStage make(){
		BaseMainProjectStage b = new BaseMainProjectStage();
		return b;
	}

	public final static java.lang.String CS_MAIN_PROJECT_STAGE_ID = "main_project_stage_id" ;
	public final static java.lang.String CS_MAIN_STAGE_ID = "main_stage_id" ;
	public final static java.lang.String CS_MAIN_STAGE_CODE = "main_stage_code" ;
	public final static java.lang.String CS_MAIN_STAGE_NAME = "main_stage_name" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;

	public final static java.lang.String ALL_CAPTIONS = "项目阶段id,阶段id,阶段code,阶段名称,备注,阶段比例,父节点";

	public java.lang.Integer getMainProjectStageId() {
		return this.__main_project_stage_id;
	}

	public void setMainProjectStageId( java.lang.Integer value ) {
		this.__main_project_stage_id = value;
	}

	public java.lang.Integer getMainStageId() {
		return this.__main_stage_id;
	}

	public void setMainStageId( java.lang.Integer value ) {
		this.__main_stage_id = value;
	}

	public java.lang.String getMainStageCode() {
		return this.__main_stage_code;
	}

	public void setMainStageCode( java.lang.String value ) {
		this.__main_stage_code = value;
	}

	public java.lang.String getMainStageName() {
		return this.__main_stage_name;
	}

	public void setMainStageName( java.lang.String value ) {
		this.__main_stage_name = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public void cloneCopy(BaseMainProjectStage __bean){
		__bean.setMainProjectStageId(getMainProjectStageId());
		__bean.setMainStageId(getMainStageId());
		__bean.setMainStageCode(getMainStageCode());
		__bean.setMainStageName(getMainStageName());
		__bean.setRemark(getRemark());
		__bean.setPercent(getPercent());
		__bean.setParentId(getParentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectStageId() == null ? "" : getMainProjectStageId());
		sb.append(",");
		sb.append(getMainStageId() == null ? "" : getMainStageId());
		sb.append(",");
		sb.append(getMainStageCode() == null ? "" : getMainStageCode());
		sb.append(",");
		sb.append(getMainStageName() == null ? "" : getMainStageName());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMainProjectStage o) {
		return __main_project_stage_id == null ? -1 : __main_project_stage_id.compareTo(o.getMainProjectStageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_stage_id);
		hash = 97 * hash + Objects.hashCode(this.__main_stage_id);
		hash = 97 * hash + Objects.hashCode(this.__main_stage_code);
		hash = 97 * hash + Objects.hashCode(this.__main_stage_name);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMainProjectStage o = (BaseMainProjectStage)obj;
		if(!Objects.equals(this.__main_project_stage_id, o.getMainProjectStageId())) return false;
		if(!Objects.equals(this.__main_stage_id, o.getMainStageId())) return false;
		if(!Objects.equals(this.__main_stage_code, o.getMainStageCode())) return false;
		if(!Objects.equals(this.__main_stage_name, o.getMainStageName())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectStageId() != null) sb.append(__wrapNumber(count++, "mainProjectStageId", getMainProjectStageId()));
		if(getMainStageId() != null) sb.append(__wrapNumber(count++, "mainStageId", getMainStageId()));
		if(getMainStageCode() != null) sb.append(__wrapString(count++, "mainStageCode", getMainStageCode()));
		if(getMainStageName() != null) sb.append(__wrapString(count++, "mainStageName", getMainStageName()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMainProjectStageId() != null) res.put("mainProjectStageId", getMainProjectStageId());
		if(getMainStageId() != null) res.put("mainStageId", getMainStageId());
		if(getMainStageCode() != null) res.put("mainStageCode", getMainStageCode());
		if(getMainStageName() != null) res.put("mainStageName", getMainStageName());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getPercent() != null) res.put("percent", getPercent());
		if(getParentId() != null) res.put("parentId", getParentId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectStageId")) != null) setMainProjectStageId(__getInt(val)); 
		if((val = values.get("mainStageId")) != null) setMainStageId(__getInt(val)); 
		if((val = values.get("mainStageCode")) != null) setMainStageCode(__getString(val));
		if((val = values.get("mainStageName")) != null) setMainStageName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
	}

	protected java.lang.Integer  __main_project_stage_id ;
	protected java.lang.Integer  __main_stage_id ;
	protected java.lang.String  __main_stage_code ;
	protected java.lang.String  __main_stage_name ;
	protected java.lang.String  __remark ;
	protected java.math.BigDecimal  __percent ;
	protected java.lang.Integer  __parent_id ;
}
