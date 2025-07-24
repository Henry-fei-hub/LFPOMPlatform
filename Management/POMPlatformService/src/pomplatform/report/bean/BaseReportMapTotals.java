package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportMapTotals extends GenericBase implements BaseFactory<BaseReportMapTotals>, Comparable<BaseReportMapTotals> 
{


	public static BaseReportMapTotals newInstance(){
		return new BaseReportMapTotals();
	}

	@Override
	public BaseReportMapTotals make(){
		BaseReportMapTotals b = new BaseReportMapTotals();
		return b;
	}

	public final static String CS_PROJECT_CODE = "project_code" ;
	public final static String CS_PROJECT_NAME = "project_name" ;
	public final static String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static String CS_DEPARTMENT_NAME = "department_name" ;
	public final static String CS_MAP_TYPE = "map_type" ;
	public final static String CS_SPECIAL_NAME = "special_name" ;
	public final static String CS_MAP_VERSION = "map_version" ;
	public final static String CS_START_DATE = "start_date" ;
	public final static String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;

	public final static String ALL_CAPTIONS = "项目编号,项目名称,申请人,部门,出图类型,专业,版本,出图日期,出图备注";

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getDepartmentName() {
		return this.__department_name;
	}

	public void setDepartmentName( java.lang.String value ) {
		this.__department_name = value;
	}

	public java.lang.String getMapType() {
		return this.__map_type;
	}

	public void setMapType( java.lang.String value ) {
		this.__map_type = value;
	}

	public java.lang.String getSpecialName() {
		return this.__special_name;
	}

	public void setSpecialName( java.lang.String value ) {
		this.__special_name = value;
	}

	public java.lang.String getMapVersion() {
		return this.__map_version;
	}

	public void setMapVersion( java.lang.String value ) {
		this.__map_version = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public void cloneCopy(BaseReportMapTotals __bean){
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentName(getDepartmentName());
		__bean.setMapType(getMapType());
		__bean.setSpecialName(getSpecialName());
		__bean.setMapVersion(getMapVersion());
		__bean.setStartDate(getStartDate());
		__bean.setRemark(getRemark());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessType(getProcessType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getDepartmentName() == null ? "" : getDepartmentName());
		sb.append(",");
		sb.append(getMapType() == null ? "" : getMapType());
		sb.append(",");
		sb.append(getSpecialName() == null ? "" : getSpecialName());
		sb.append(",");
		sb.append(getMapVersion() == null ? "" : getMapVersion());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportMapTotals o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_name);
		hash = 97 * hash + Objects.hashCode(this.__map_type);
		hash = 97 * hash + Objects.hashCode(this.__special_name);
		hash = 97 * hash + Objects.hashCode(this.__map_version);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportMapTotals o = (BaseReportMapTotals)obj;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_name, o.getDepartmentName())) return false;
		if(!Objects.equals(this.__map_type, o.getMapType())) return false;
		if(!Objects.equals(this.__special_name, o.getSpecialName())) return false;
		if(!Objects.equals(this.__map_version, o.getMapVersion())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentName() != null) sb.append(__wrapString(count++, "departmentName", getDepartmentName()));
		if(getMapType() != null) sb.append(__wrapString(count++, "mapType", getMapType()));
		if(getSpecialName() != null) sb.append(__wrapString(count++, "specialName", getSpecialName()));
		if(getMapVersion() != null) sb.append(__wrapString(count++, "mapVersion", getMapVersion()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getDepartmentName() != null) res.put("departmentName", getDepartmentName());
		if(getMapType() != null) res.put("mapType", getMapType());
		if(getSpecialName() != null) res.put("specialName", getSpecialName());
		if(getMapVersion() != null) res.put("mapVersion", getMapVersion());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getProcessId() != null) res.put("processId", getProcessId());
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getProcessType() != null) res.put("processType", getProcessType());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("mapType")) != null) setMapType(__getString(val));
		if((val = values.get("specialName")) != null) setSpecialName(__getString(val));
		if((val = values.get("mapVersion")) != null) setMapVersion(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val));
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val));
		if((val = values.get("processType")) != null) setProcessType(__getInt(val));
	}

	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __department_name ;
	protected java.lang.String  __map_type ;
	protected java.lang.String  __special_name ;
	protected java.lang.String  __map_version ;
	protected java.util.Date  __start_date ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_type ;
}
