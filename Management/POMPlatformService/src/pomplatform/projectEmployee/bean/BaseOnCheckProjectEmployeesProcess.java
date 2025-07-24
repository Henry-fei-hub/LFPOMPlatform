package pomplatform.projectEmployee.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnCheckProjectEmployeesProcess extends GenericBase implements BaseFactory<BaseOnCheckProjectEmployeesProcess>, Comparable<BaseOnCheckProjectEmployeesProcess> 
{


	public static BaseOnCheckProjectEmployeesProcess newInstance(){
		return new BaseOnCheckProjectEmployeesProcess();
	}

	@Override
	public BaseOnCheckProjectEmployeesProcess make(){
		BaseOnCheckProjectEmployeesProcess b = new BaseOnCheckProjectEmployeesProcess();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;

	public final static java.lang.String ALL_CAPTIONS = "项目主键,流程状态 0 发起中  1";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public void cloneCopy(BaseOnCheckProjectEmployeesProcess __bean){
		__bean.setProjectId(getProjectId());
		__bean.setProcessStatus(getProcessStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnCheckProjectEmployeesProcess o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnCheckProjectEmployeesProcess o = (BaseOnCheckProjectEmployeesProcess)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __process_status ;
}
