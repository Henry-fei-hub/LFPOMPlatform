package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetProjectManagerByProjectId extends GenericBase implements BaseFactory<BaseGetProjectManagerByProjectId>, Comparable<BaseGetProjectManagerByProjectId> 
{


	public static BaseGetProjectManagerByProjectId newInstance(){
		return new BaseGetProjectManagerByProjectId();
	}

	@Override
	public BaseGetProjectManagerByProjectId make(){
		BaseGetProjectManagerByProjectId b = new BaseGetProjectManagerByProjectId();
		return b;
	}

	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;

	public final static java.lang.String ALL_CAPTIONS = "专业负责人";

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public void cloneCopy(BaseGetProjectManagerByProjectId __bean){
		__bean.setProjectManageId(getProjectManageId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectManageId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectManageId()));
		sb.append(strProjectManageId == null ? "" : strProjectManageId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetProjectManagerByProjectId o) {
		return __project_manage_id == null ? -1 : __project_manage_id.compareTo(o.getProjectManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetProjectManagerByProjectId o = (BaseGetProjectManagerByProjectId)obj;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_manage_id ;
}
