package pomplatform.preProjects.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSearchMainProjectEmployeeData extends GenericBase implements BaseFactory<BaseSearchMainProjectEmployeeData>, Comparable<BaseSearchMainProjectEmployeeData> 
{


	public static BaseSearchMainProjectEmployeeData newInstance(){
		return new BaseSearchMainProjectEmployeeData();
	}

	@Override
	public BaseSearchMainProjectEmployeeData make(){
		BaseSearchMainProjectEmployeeData b = new BaseSearchMainProjectEmployeeData();
		return b;
	}

	public final static java.lang.String CS_MAIN_PROJECT_EMPLOYEE_ID = "main_project_employee_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_RELATION = "relation" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_MAIN_AND_ASSISTANCE = "main_and_assistance" ;
	public final static java.lang.String CS_IS_PLATE_MANAGER = "is_plate_manager" ;

	public final static java.lang.String ALL_CAPTIONS = "编码,主项目编码,员工编码,员工和主项目的关系    1项目营销专员   2项目营销团队负责人   3项目经理   4项目主管领导,员工编号,员工姓名,板块,主要跟进人或协助跟进人（1主要跟进人，2协助跟进人）,是否事业部负责人";

	public java.lang.Integer getMainProjectEmployeeId() {
		return this.__main_project_employee_id;
	}

	public void setMainProjectEmployeeId( java.lang.Integer value ) {
		this.__main_project_employee_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getRelation() {
		return this.__relation;
	}

	public void setRelation( java.lang.Integer value ) {
		this.__relation = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getMainAndAssistance() {
		return this.__main_and_assistance;
	}

	public void setMainAndAssistance( java.lang.Integer value ) {
		this.__main_and_assistance = value;
	}

	public java.lang.Boolean getIsPlateManager() {
		return this.__is_plate_manager;
	}

	public void setIsPlateManager( java.lang.Boolean value ) {
		this.__is_plate_manager = value;
	}

	public void cloneCopy(BaseSearchMainProjectEmployeeData __bean){
		__bean.setMainProjectEmployeeId(getMainProjectEmployeeId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setRelation(getRelation());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setPlateId(getPlateId());
		__bean.setMainAndAssistance(getMainAndAssistance());
		__bean.setIsPlateManager(getIsPlateManager());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectEmployeeId() == null ? "" : getMainProjectEmployeeId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getRelation() == null ? "" : getRelation());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getMainAndAssistance() == null ? "" : getMainAndAssistance());
		sb.append(",");
		sb.append(getIsPlateManager() == null ? "" : getIsPlateManager());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSearchMainProjectEmployeeData o) {
		return __main_project_employee_id == null ? -1 : __main_project_employee_id.compareTo(o.getMainProjectEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__relation);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__main_and_assistance);
		hash = 97 * hash + Objects.hashCode(this.__is_plate_manager);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSearchMainProjectEmployeeData o = (BaseSearchMainProjectEmployeeData)obj;
		if(!Objects.equals(this.__main_project_employee_id, o.getMainProjectEmployeeId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__relation, o.getRelation())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__main_and_assistance, o.getMainAndAssistance())) return false;
		if(!Objects.equals(this.__is_plate_manager, o.getIsPlateManager())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectEmployeeId() != null) sb.append(__wrapNumber(count++, "mainProjectEmployeeId", getMainProjectEmployeeId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getRelation() != null) sb.append(__wrapNumber(count++, "relation", getRelation()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getMainAndAssistance() != null) sb.append(__wrapNumber(count++, "mainAndAssistance", getMainAndAssistance()));
		if(getIsPlateManager() != null) sb.append(__wrapBoolean(count++, "isPlateManager", getIsPlateManager()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMainProjectEmployeeId() != null) res.put("mainProjectEmployeeId", getMainProjectEmployeeId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getRelation() != null) res.put("relation", getRelation());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getMainAndAssistance() != null) res.put("mainAndAssistance", getMainAndAssistance());
		if(getIsPlateManager() != null) res.put("isPlateManager", getIsPlateManager());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectEmployeeId")) != null) setMainProjectEmployeeId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("relation")) != null) setRelation(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("mainAndAssistance")) != null) setMainAndAssistance(__getInt(val)); 
		if((val = values.get("isPlateManager")) != null) setIsPlateManager(__getBoolean(val));
	}

	protected java.lang.Integer  __main_project_employee_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __relation ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __main_and_assistance ;
	protected java.lang.Boolean  __is_plate_manager ;
}
