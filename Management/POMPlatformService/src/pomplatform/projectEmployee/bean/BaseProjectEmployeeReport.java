package pomplatform.projectEmployee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectEmployeeReport extends GenericBase implements BaseFactory<BaseProjectEmployeeReport>, Comparable<BaseProjectEmployeeReport> 
{


	public static BaseProjectEmployeeReport newInstance(){
		return new BaseProjectEmployeeReport();
	}

	@Override
	public BaseProjectEmployeeReport make(){
		BaseProjectEmployeeReport b = new BaseProjectEmployeeReport();
		return b;
	}

	public final static java.lang.String CS_PROJECT_EMPLOYEE_ID = "project_employee_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_EMPLOYEE_PLATE_ID = "employee_plate_id" ;
	public final static java.lang.String CS_PLAN_INTEGRAL = "plan_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "项目组建编码,项目编码,订单所在业务部门,订单编号,订单名称,项目阶段,员工编码,工号,姓名,员工所在业务部门,预分配积分,确认积分";

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

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
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

	public java.lang.Integer getEmployeePlateId() {
		return this.__employee_plate_id;
	}

	public void setEmployeePlateId( java.lang.Integer value ) {
		this.__employee_plate_id = value;
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

	public void cloneCopy(BaseProjectEmployeeReport __bean){
		__bean.setProjectEmployeeId(getProjectEmployeeId());
		__bean.setProjectId(getProjectId());
		__bean.setPlateId(getPlateId());
		__bean.setContractCode(getContractCode());
		__bean.setProjectName(getProjectName());
		__bean.setStageId(getStageId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setEmployeePlateId(getEmployeePlateId());
		__bean.setPlanIntegral(getPlanIntegral());
		__bean.setSureIntegral(getSureIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectEmployeeId() == null ? "" : getProjectEmployeeId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String strStageId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_7", String.valueOf(getStageId()));
		sb.append(strStageId == null ? "" : strStageId);
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strEmployeePlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getEmployeePlateId()));
		sb.append(strEmployeePlateId == null ? "" : strEmployeePlateId);
		sb.append(",");
		sb.append(getPlanIntegral() == null ? "" : getPlanIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectEmployeeReport o) {
		return __project_employee_id == null ? -1 : __project_employee_id.compareTo(o.getProjectEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_plate_id);
		hash = 97 * hash + Objects.hashCode(this.__plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectEmployeeReport o = (BaseProjectEmployeeReport)obj;
		if(!Objects.equals(this.__project_employee_id, o.getProjectEmployeeId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__employee_plate_id, o.getEmployeePlateId())) return false;
		if(!Objects.equals(this.__plan_integral, o.getPlanIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectEmployeeId() != null) sb.append(__wrapNumber(count++, "projectEmployeeId", getProjectEmployeeId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getEmployeePlateId() != null) sb.append(__wrapNumber(count++, "employeePlateId", getEmployeePlateId()));
		if(getPlanIntegral() != null) sb.append(__wrapDecimal(count++, "planIntegral", getPlanIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectEmployeeId")) != null) setProjectEmployeeId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeePlateId")) != null) setEmployeePlateId(__getInt(val)); 
		if((val = values.get("planIntegral")) != null) setPlanIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_employee_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __employee_plate_id ;
	protected java.math.BigDecimal  __plan_integral ;
	protected java.math.BigDecimal  __sure_integral ;
}
