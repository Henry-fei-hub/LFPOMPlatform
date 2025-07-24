package pomplatform.projectteambuild.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectEmployeePlanIntegralProgress extends GenericBase implements BaseFactory<BaseProjectEmployeePlanIntegralProgress>, Comparable<BaseProjectEmployeePlanIntegralProgress> 
{


	public static BaseProjectEmployeePlanIntegralProgress newInstance(){
		return new BaseProjectEmployeePlanIntegralProgress();
	}

	@Override
	public BaseProjectEmployeePlanIntegralProgress make(){
		BaseProjectEmployeePlanIntegralProgress b = new BaseProjectEmployeePlanIntegralProgress();
		return b;
	}

	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_PLAN_INTEGRAL = "plan_integral" ;
	public final static java.lang.String CS_REAL_INTEGRAL = "real_integral" ;
	public final static java.lang.String CS_ALTERNATE_FIELD1 = "alternate_field1" ;
	public final static java.lang.String CS_ALTERNATE_FIELD2 = "alternate_field2" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编号,合同编号,项目名称,员工编码,阶段Id,预分配积分,实际获得积分,上一次预分配积分,//状态值  1待审批    2同意  3不同意";

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
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

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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

	public java.math.BigDecimal getRealIntegral() {
		return this.__real_integral;
	}

	public void setRealIntegral( java.math.BigDecimal value ) {
		this.__real_integral = value;
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

	public void cloneCopy(BaseProjectEmployeePlanIntegralProgress __bean){
		__bean.setProjectCode(getProjectCode());
		__bean.setContractCode(getContractCode());
		__bean.setProjectName(getProjectName());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setStageId(getStageId());
		__bean.setPlanIntegral(getPlanIntegral());
		__bean.setRealIntegral(getRealIntegral());
		__bean.setAlternateField1(getAlternateField1());
		__bean.setAlternateField2(getAlternateField2());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getPlanIntegral() == null ? "" : getPlanIntegral());
		sb.append(",");
		sb.append(getRealIntegral() == null ? "" : getRealIntegral());
		sb.append(",");
		sb.append(getAlternateField1() == null ? "" : getAlternateField1());
		sb.append(",");
		sb.append(getAlternateField2() == null ? "" : getAlternateField2());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectEmployeePlanIntegralProgress o) {
		return __project_code == null ? -1 : __project_code.compareTo(o.getProjectCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__real_integral);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field1);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field2);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectEmployeePlanIntegralProgress o = (BaseProjectEmployeePlanIntegralProgress)obj;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__plan_integral, o.getPlanIntegral())) return false;
		if(!Objects.equals(this.__real_integral, o.getRealIntegral())) return false;
		if(!Objects.equals(this.__alternate_field1, o.getAlternateField1())) return false;
		if(!Objects.equals(this.__alternate_field2, o.getAlternateField2())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getPlanIntegral() != null) sb.append(__wrapDecimal(count++, "planIntegral", getPlanIntegral()));
		if(getRealIntegral() != null) sb.append(__wrapDecimal(count++, "realIntegral", getRealIntegral()));
		if(getAlternateField1() != null) sb.append(__wrapString(count++, "alternateField1", getAlternateField1()));
		if(getAlternateField2() != null) sb.append(__wrapString(count++, "alternateField2", getAlternateField2()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getStageId() != null) res.put("stageId", getStageId());
		if(getPlanIntegral() != null) res.put("planIntegral", getPlanIntegral());
		if(getRealIntegral() != null) res.put("realIntegral", getRealIntegral());
		if(getAlternateField1() != null) res.put("alternateField1", getAlternateField1());
		if(getAlternateField2() != null) res.put("alternateField2", getAlternateField2());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("planIntegral")) != null) setPlanIntegral(__getDecimal(val));  
		if((val = values.get("realIntegral")) != null) setRealIntegral(__getDecimal(val));  
		if((val = values.get("alternateField1")) != null) setAlternateField1(__getString(val));
		if((val = values.get("alternateField2")) != null) setAlternateField2(__getString(val));
	}

	protected java.lang.String  __project_code ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.math.BigDecimal  __plan_integral ;
	protected java.math.BigDecimal  __real_integral ;
	protected java.lang.String  __alternate_field1 ;
	protected java.lang.String  __alternate_field2 ;
}
