package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadFinishStagePercent extends GenericBase implements BaseFactory<BaseOnLoadFinishStagePercent>, Comparable<BaseOnLoadFinishStagePercent> 
{


	public static BaseOnLoadFinishStagePercent newInstance(){
		return new BaseOnLoadFinishStagePercent();
	}

	@Override
	public BaseOnLoadFinishStagePercent make(){
		BaseOnLoadFinishStagePercent b = new BaseOnLoadFinishStagePercent();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PERCENT = "percent" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编码,阶段比例";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPercent() {
		return this.__percent;
	}

	public void setPercent( java.lang.Integer value ) {
		this.__percent = value;
	}

	public void cloneCopy(BaseOnLoadFinishStagePercent __bean){
		__bean.setProjectId(getProjectId());
		__bean.setPercent(getPercent());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadFinishStagePercent o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadFinishStagePercent o = (BaseOnLoadFinishStagePercent)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPercent() != null) sb.append(__wrapNumber(count++, "percent", getPercent()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("percent")) != null) setPercent(__getInt(val)); 
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __percent ;
}
