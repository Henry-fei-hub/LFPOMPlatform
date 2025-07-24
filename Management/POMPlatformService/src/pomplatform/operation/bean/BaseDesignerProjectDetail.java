package pomplatform.operation.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseDesignerProjectDetail extends GenericBase implements BaseFactory<BaseDesignerProjectDetail>, Comparable<BaseDesignerProjectDetail> 
{


	public static BaseDesignerProjectDetail newInstance(){
		return new BaseDesignerProjectDetail();
	}

	@Override
	public BaseDesignerProjectDetail make(){
		BaseDesignerProjectDetail b = new BaseDesignerProjectDetail();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_SHEET_CODE = "sheet_code" ;
	public final static java.lang.String CS_SHEET_NAME = "sheet_name" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_PLAN_INTEGRAL = "plan_integral" ;
	public final static java.lang.String CS_REAL_INTEGRAL = "real_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_COST = "cost" ;
	public final static java.lang.String CS_PROJECT_COST = "project_cost" ;
	public final static java.lang.String CS_REAL_AMOUNT = "real_amount" ;
	public final static java.lang.String CS_PROJECT_FLAG = "project_flag" ;
	public final static java.lang.String CS_REAL_AMOUNTS = "real_amounts" ;
	public final static java.lang.String CS_ADVANCED_INTEGRAL = "advanced_integral" ;
	public final static java.lang.String CS_ALTERNATE_FIELD2 = "alternate_field2" ;
	public final static java.lang.String CS_COUNT = "count" ;

	public final static java.lang.String ALL_CAPTIONS = "项目代码,专业负责人,,,结算操作人,员工编号,员工姓名,预分配积分,实际获得积分,,费用,分摊费用,实际分配,4投标项目),,已补贴积分,//状态值  1待审批    2同意  3不同意,";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.String getSheetCode() {
		return this.__sheet_code;
	}

	public void setSheetCode( java.lang.String value ) {
		this.__sheet_code = value;
	}

	public java.lang.String getSheetName() {
		return this.__sheet_name;
	}

	public void setSheetName( java.lang.String value ) {
		this.__sheet_name = value;
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

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getCost() {
		return this.__cost;
	}

	public void setCost( java.math.BigDecimal value ) {
		this.__cost = value;
	}

	public java.math.BigDecimal getProjectCost() {
		return this.__project_cost;
	}

	public void setProjectCost( java.math.BigDecimal value ) {
		this.__project_cost = value;
	}

	public java.math.BigDecimal getRealAmount() {
		return this.__real_amount;
	}

	public void setRealAmount( java.math.BigDecimal value ) {
		this.__real_amount = value;
	}

	public java.lang.Integer getProjectFlag() {
		return this.__project_flag;
	}

	public void setProjectFlag( java.lang.Integer value ) {
		this.__project_flag = value;
	}

	public java.math.BigDecimal getRealAmounts() {
		return this.__real_amounts;
	}

	public void setRealAmounts( java.math.BigDecimal value ) {
		this.__real_amounts = value;
	}

	public java.math.BigDecimal getAdvancedIntegral() {
		return this.__advanced_integral;
	}

	public void setAdvancedIntegral( java.math.BigDecimal value ) {
		this.__advanced_integral = value;
	}

	public java.lang.String getAlternateField2() {
		return this.__alternate_field2;
	}

	public void setAlternateField2( java.lang.String value ) {
		this.__alternate_field2 = value;
	}

	public java.lang.Integer getCount() {
		return this.__count;
	}

	public void setCount( java.lang.Integer value ) {
		this.__count = value;
	}

	public void cloneCopy(BaseDesignerProjectDetail __bean){
		__bean.setProjectId(getProjectId());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setSheetCode(getSheetCode());
		__bean.setSheetName(getSheetName());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setPlanIntegral(getPlanIntegral());
		__bean.setRealIntegral(getRealIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setCost(getCost());
		__bean.setProjectCost(getProjectCost());
		__bean.setRealAmount(getRealAmount());
		__bean.setProjectFlag(getProjectFlag());
		__bean.setRealAmounts(getRealAmounts());
		__bean.setAdvancedIntegral(getAdvancedIntegral());
		__bean.setAlternateField2(getAlternateField2());
		__bean.setCount(getCount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getSheetCode() == null ? "" : getSheetCode());
		sb.append(",");
		sb.append(getSheetName() == null ? "" : getSheetName());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getPlanIntegral() == null ? "" : getPlanIntegral());
		sb.append(",");
		sb.append(getRealIntegral() == null ? "" : getRealIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getCost() == null ? "" : getCost());
		sb.append(",");
		sb.append(getProjectCost() == null ? "" : getProjectCost());
		sb.append(",");
		sb.append(getRealAmount() == null ? "" : getRealAmount());
		sb.append(",");
		sb.append(getProjectFlag() == null ? "" : getProjectFlag());
		sb.append(",");
		sb.append(getRealAmounts() == null ? "" : getRealAmounts());
		sb.append(",");
		sb.append(getAdvancedIntegral() == null ? "" : getAdvancedIntegral());
		sb.append(",");
		sb.append(getAlternateField2() == null ? "" : getAlternateField2());
		sb.append(",");
		sb.append(getCount() == null ? "" : getCount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseDesignerProjectDetail o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__sheet_code);
		hash = 97 * hash + Objects.hashCode(this.__sheet_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__real_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__cost);
		hash = 97 * hash + Objects.hashCode(this.__project_cost);
		hash = 97 * hash + Objects.hashCode(this.__real_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_flag);
		hash = 97 * hash + Objects.hashCode(this.__real_amounts);
		hash = 97 * hash + Objects.hashCode(this.__advanced_integral);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field2);
		hash = 97 * hash + Objects.hashCode(this.__count);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseDesignerProjectDetail o = (BaseDesignerProjectDetail)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__sheet_code, o.getSheetCode())) return false;
		if(!Objects.equals(this.__sheet_name, o.getSheetName())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__plan_integral, o.getPlanIntegral())) return false;
		if(!Objects.equals(this.__real_integral, o.getRealIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__cost, o.getCost())) return false;
		if(!Objects.equals(this.__project_cost, o.getProjectCost())) return false;
		if(!Objects.equals(this.__real_amount, o.getRealAmount())) return false;
		if(!Objects.equals(this.__project_flag, o.getProjectFlag())) return false;
		if(!Objects.equals(this.__real_amounts, o.getRealAmounts())) return false;
		if(!Objects.equals(this.__advanced_integral, o.getAdvancedIntegral())) return false;
		if(!Objects.equals(this.__alternate_field2, o.getAlternateField2())) return false;
		if(!Objects.equals(this.__count, o.getCount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getSheetCode() != null) sb.append(__wrapString(count++, "sheetCode", getSheetCode()));
		if(getSheetName() != null) sb.append(__wrapString(count++, "sheetName", getSheetName()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getPlanIntegral() != null) sb.append(__wrapDecimal(count++, "planIntegral", getPlanIntegral()));
		if(getRealIntegral() != null) sb.append(__wrapDecimal(count++, "realIntegral", getRealIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getCost() != null) sb.append(__wrapDecimal(count++, "cost", getCost()));
		if(getProjectCost() != null) sb.append(__wrapDecimal(count++, "projectCost", getProjectCost()));
		if(getRealAmount() != null) sb.append(__wrapDecimal(count++, "realAmount", getRealAmount()));
		if(getProjectFlag() != null) sb.append(__wrapNumber(count++, "projectFlag", getProjectFlag()));
		if(getRealAmounts() != null) sb.append(__wrapDecimal(count++, "realAmounts", getRealAmounts()));
		if(getAdvancedIntegral() != null) sb.append(__wrapDecimal(count++, "advancedIntegral", getAdvancedIntegral()));
		if(getAlternateField2() != null) sb.append(__wrapString(count++, "alternateField2", getAlternateField2()));
		if(getCount() != null) sb.append(__wrapNumber(count++, "count", getCount()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getProjectManageId() != null) res.put("projectManageId", getProjectManageId());
		if(getSheetCode() != null) res.put("sheetCode", getSheetCode());
		if(getSheetName() != null) res.put("sheetName", getSheetName());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getPlanIntegral() != null) res.put("planIntegral", getPlanIntegral());
		if(getRealIntegral() != null) res.put("realIntegral", getRealIntegral());
		if(getSureIntegral() != null) res.put("sureIntegral", getSureIntegral());
		if(getCost() != null) res.put("cost", getCost());
		if(getProjectCost() != null) res.put("projectCost", getProjectCost());
		if(getRealAmount() != null) res.put("realAmount", getRealAmount());
		if(getProjectFlag() != null) res.put("projectFlag", getProjectFlag());
		if(getRealAmounts() != null) res.put("realAmounts", getRealAmounts());
		if(getAdvancedIntegral() != null) res.put("advancedIntegral", getAdvancedIntegral());
		if(getAlternateField2() != null) res.put("alternateField2", getAlternateField2());
		if(getCount() != null) res.put("count", getCount());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("sheetCode")) != null) setSheetCode(__getString(val));
		if((val = values.get("sheetName")) != null) setSheetName(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("planIntegral")) != null) setPlanIntegral(__getDecimal(val));  
		if((val = values.get("realIntegral")) != null) setRealIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("cost")) != null) setCost(__getDecimal(val));  
		if((val = values.get("projectCost")) != null) setProjectCost(__getDecimal(val));  
		if((val = values.get("realAmount")) != null) setRealAmount(__getDecimal(val));  
		if((val = values.get("projectFlag")) != null) setProjectFlag(__getInt(val)); 
		if((val = values.get("realAmounts")) != null) setRealAmounts(__getDecimal(val));  
		if((val = values.get("advancedIntegral")) != null) setAdvancedIntegral(__getDecimal(val));  
		if((val = values.get("alternateField2")) != null) setAlternateField2(__getString(val));
		if((val = values.get("count")) != null) setCount(__getInt(val)); 
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.String  __sheet_code ;
	protected java.lang.String  __sheet_name ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.math.BigDecimal  __plan_integral ;
	protected java.math.BigDecimal  __real_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __cost ;
	protected java.math.BigDecimal  __project_cost ;
	protected java.math.BigDecimal  __real_amount ;
	protected java.lang.Integer  __project_flag ;
	protected java.math.BigDecimal  __real_amounts ;
	protected java.math.BigDecimal  __advanced_integral ;
	protected java.lang.String  __alternate_field2 ;
	protected java.lang.Integer  __count ;
}
