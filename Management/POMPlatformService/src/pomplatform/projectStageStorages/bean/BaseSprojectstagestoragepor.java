package pomplatform.projectStageStorages.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectstagestoragepor extends GenericBase implements BaseFactory<BaseSprojectstagestoragepor>, Comparable<BaseSprojectstagestoragepor> 
{


	public static BaseSprojectstagestoragepor newInstance(){
		return new BaseSprojectstagestoragepor();
	}

	@Override
	public BaseSprojectstagestoragepor make(){
		BaseSprojectstagestoragepor b = new BaseSprojectstagestoragepor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_STAGE_STORAGE_ID = "project_stage_storage_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_PROJECT_AMOUNT = "project_amount" ;
	public final static java.lang.String CS_STAGE_NAME = "stage_name" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "id,项目编码,阶段代码,占比(%),项目积分,阶段名称,备注";

	public java.lang.Integer getProjectStageStorageId() {
		return this.__project_stage_storage_id;
	}

	public void setProjectStageStorageId( java.lang.Integer value ) {
		this.__project_stage_storage_id = value;
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

	public java.lang.Integer getPercent() {
		return this.__percent;
	}

	public void setPercent( java.lang.Integer value ) {
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

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSprojectstagestoragepor __bean){
		__bean.setProjectStageStorageId(getProjectStageStorageId());
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
		__bean.setPercent(getPercent());
		__bean.setProjectAmount(getProjectAmount());
		__bean.setStageName(getStageName());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectStageStorageId() == null ? "" : getProjectStageStorageId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getProjectAmount() == null ? "" : getProjectAmount());
		sb.append(",");
		sb.append(getStageName() == null ? "" : getStageName());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectstagestoragepor o) {
		return __project_stage_storage_id == null ? -1 : __project_stage_storage_id.compareTo(o.getProjectStageStorageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_stage_storage_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__project_amount);
		hash = 97 * hash + Objects.hashCode(this.__stage_name);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectstagestoragepor o = (BaseSprojectstagestoragepor)obj;
		if(!Objects.equals(this.__project_stage_storage_id, o.getProjectStageStorageId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__project_amount, o.getProjectAmount())) return false;
		if(!Objects.equals(this.__stage_name, o.getStageName())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectStageStorageId() != null) sb.append(__wrapNumber(count++, "projectStageStorageId", getProjectStageStorageId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getPercent() != null) sb.append(__wrapNumber(count++, "percent", getPercent()));
		if(getProjectAmount() != null) sb.append(__wrapDecimal(count++, "projectAmount", getProjectAmount()));
		if(getStageName() != null) sb.append(__wrapString(count++, "stageName", getStageName()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectStageStorageId")) != null) setProjectStageStorageId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("percent")) != null) setPercent(__getInt(val)); 
		if((val = values.get("projectAmount")) != null) setProjectAmount(__getDecimal(val));  
		if((val = values.get("stageName")) != null) setStageName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __project_stage_storage_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.Integer  __percent ;
	protected java.math.BigDecimal  __project_amount ;
	protected java.lang.String  __stage_name ;
	protected java.lang.String  __remark ;
}
