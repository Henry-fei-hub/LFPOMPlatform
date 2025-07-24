package pomplatform.project.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadProjectEmpAndStageInfo extends GenericBase implements BaseFactory<BaseOnLoadProjectEmpAndStageInfo>, Comparable<BaseOnLoadProjectEmpAndStageInfo> 
{


	public static BaseOnLoadProjectEmpAndStageInfo newInstance(){
		return new BaseOnLoadProjectEmpAndStageInfo();
	}

	@Override
	public BaseOnLoadProjectEmpAndStageInfo make(){
		BaseOnLoadProjectEmpAndStageInfo b = new BaseOnLoadProjectEmpAndStageInfo();
		return b;
	}

	public final static java.lang.String CS_PROJECT_EMPLOYEE_ID = "project_employee_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_PLAN_INTEGRAL = "plan_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_GRADE_ID = "grade_id" ;
	public final static java.lang.String CS_ALTERNATE_FIELD1 = "alternate_field1" ;
	public final static java.lang.String CS_ALTERNATE_FIELD2 = "alternate_field2" ;

	public final static java.lang.String ALL_CAPTIONS = "项目组建编码,项目代码,结算操作人,员工编号,员工姓名,项目阶段,预分配积分,,等级,上一次预分配积分,//状态值  1待审批    2同意  3不同意";

	public java.lang.Integer getProjectEmployeeId() {
		return this.__project_employee_id;
	}

	public void setProjectEmployeeId( java.lang.Integer value ) {
		this.__project_employee_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.math.BigDecimal getPlanIntegral() {
		return this.__plan_integral;
	}

	public void setPlanIntegral( java.math.BigDecimal value ) {
		this.__plan_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.lang.Integer getGradeId() {
		return this.__grade_id;
	}

	public void setGradeId( java.lang.Integer value ) {
		this.__grade_id = value;
	}

	public java.lang.String getAlternateField1() {
		return this.__alternate_field1;
	}

	public void setAlternateField1( java.lang.String value ) {
		this.__alternate_field1 = value;
	}

	public java.lang.String getAlternateField2() {
		return this.__alternate_field2;
	}

	public void setAlternateField2( java.lang.String value ) {
		this.__alternate_field2 = value;
	}

	public void cloneCopy(BaseOnLoadProjectEmpAndStageInfo __bean){
		__bean.setProjectEmployeeId(getProjectEmployeeId());
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setStageId(getStageId());
		__bean.setPlanIntegral(getPlanIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setGradeId(getGradeId());
		__bean.setAlternateField1(getAlternateField1());
		__bean.setAlternateField2(getAlternateField2());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectEmployeeId() == null ? "" : getProjectEmployeeId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getPlanIntegral() == null ? "" : getPlanIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getGradeId() == null ? "" : getGradeId());
		sb.append(",");
		sb.append(getAlternateField1() == null ? "" : getAlternateField1());
		sb.append(",");
		sb.append(getAlternateField2() == null ? "" : getAlternateField2());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadProjectEmpAndStageInfo o) {
		return __project_employee_id == null ? -1 : __project_employee_id.compareTo(o.getProjectEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__grade_id);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field1);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field2);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadProjectEmpAndStageInfo o = (BaseOnLoadProjectEmpAndStageInfo)obj;
		if(!Objects.equals(this.__project_employee_id, o.getProjectEmployeeId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__plan_integral, o.getPlanIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__grade_id, o.getGradeId())) return false;
		if(!Objects.equals(this.__alternate_field1, o.getAlternateField1())) return false;
		if(!Objects.equals(this.__alternate_field2, o.getAlternateField2())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectEmployeeId() != null) sb.append(__wrapNumber(count++, "projectEmployeeId", getProjectEmployeeId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getPlanIntegral() != null) sb.append(__wrapDecimal(count++, "planIntegral", getPlanIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getGradeId() != null) sb.append(__wrapNumber(count++, "gradeId", getGradeId()));
		if(getAlternateField1() != null) sb.append(__wrapString(count++, "alternateField1", getAlternateField1()));
		if(getAlternateField2() != null) sb.append(__wrapString(count++, "alternateField2", getAlternateField2()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectEmployeeId() != null) res.put("projectEmployeeId", getProjectEmployeeId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getStageId() != null) res.put("stageId", getStageId());
		if(getPlanIntegral() != null) res.put("planIntegral", getPlanIntegral());
		if(getSureIntegral() != null) res.put("sureIntegral", getSureIntegral());
		if(getGradeId() != null) res.put("gradeId", getGradeId());
		if(getAlternateField1() != null) res.put("alternateField1", getAlternateField1());
		if(getAlternateField2() != null) res.put("alternateField2", getAlternateField2());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectEmployeeId")) != null) setProjectEmployeeId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("planIntegral")) != null) setPlanIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("gradeId")) != null) setGradeId(__getInt(val)); 
		if((val = values.get("alternateField1")) != null) setAlternateField1(__getString(val));
		if((val = values.get("alternateField2")) != null) setAlternateField2(__getString(val));
	}

	protected java.lang.Integer  __project_employee_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __stage_id ;
	protected java.math.BigDecimal  __plan_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.lang.Integer  __grade_id ;
	protected java.lang.String  __alternate_field1 ;
	protected java.lang.String  __alternate_field2 ;
}
