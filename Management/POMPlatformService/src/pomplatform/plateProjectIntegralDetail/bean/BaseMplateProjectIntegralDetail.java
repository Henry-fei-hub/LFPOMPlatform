package pomplatform.plateProjectIntegralDetail.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMplateProjectIntegralDetail extends GenericBase implements BaseFactory<BaseMplateProjectIntegralDetail>, Comparable<BaseMplateProjectIntegralDetail> 
{


	public static BaseMplateProjectIntegralDetail newInstance(){
		return new BaseMplateProjectIntegralDetail();
	}

	@Override
	public BaseMplateProjectIntegralDetail make(){
		BaseMplateProjectIntegralDetail b = new BaseMplateProjectIntegralDetail();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_SUB_CONTRACT_CODE = "sub_contract_code" ;
	public final static java.lang.String CS_SUB_CONTRACT_NAME = "sub_contract_name" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_COST_INTEGRAL = "cost_integral" ;
	public final static java.lang.String CS_SALARY_INTEGRAL = "salary_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "项目代码,项目编号,子合同编号,子合同名称,项目名称,价值积分,项目积分,预留积分,确认积分,项目成本,人工成本";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getSubContractCode() {
		return this.__sub_contract_code;
	}

	public void setSubContractCode( java.lang.String value ) {
		this.__sub_contract_code = value;
	}

	public java.lang.String getSubContractName() {
		return this.__sub_contract_name;
	}

	public void setSubContractName( java.lang.String value ) {
		this.__sub_contract_name = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Long getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral( java.lang.Long value ) {
		this.__achieve_integral = value;
	}

	public java.lang.Long getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.lang.Long value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getReserveIntegral() {
		return this.__reserve_integral;
	}

	public void setReserveIntegral( java.math.BigDecimal value ) {
		this.__reserve_integral = value;
	}

	public java.lang.Long getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.lang.Long value ) {
		this.__sure_integral = value;
	}

	public java.lang.Long getCostIntegral() {
		return this.__cost_integral;
	}

	public void setCostIntegral( java.lang.Long value ) {
		this.__cost_integral = value;
	}

	public java.lang.Long getSalaryIntegral() {
		return this.__salary_integral;
	}

	public void setSalaryIntegral( java.lang.Long value ) {
		this.__salary_integral = value;
	}

	public void cloneCopy(BaseMplateProjectIntegralDetail __bean){
		__bean.setProjectId(getProjectId());
		__bean.setProjectCode(getProjectCode());
		__bean.setSubContractCode(getSubContractCode());
		__bean.setSubContractName(getSubContractName());
		__bean.setProjectName(getProjectName());
		__bean.setAchieveIntegral(getAchieveIntegral());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setCostIntegral(getCostIntegral());
		__bean.setSalaryIntegral(getSalaryIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getSubContractCode() == null ? "" : getSubContractCode());
		sb.append(",");
		sb.append(getSubContractName() == null ? "" : getSubContractName());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getCostIntegral() == null ? "" : getCostIntegral());
		sb.append(",");
		sb.append(getSalaryIntegral() == null ? "" : getSalaryIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMplateProjectIntegralDetail o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_code);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_name);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__cost_integral);
		hash = 97 * hash + Objects.hashCode(this.__salary_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMplateProjectIntegralDetail o = (BaseMplateProjectIntegralDetail)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__sub_contract_code, o.getSubContractCode())) return false;
		if(!Objects.equals(this.__sub_contract_name, o.getSubContractName())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__achieve_integral, o.getAchieveIntegral())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__cost_integral, o.getCostIntegral())) return false;
		if(!Objects.equals(this.__salary_integral, o.getSalaryIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getSubContractCode() != null) sb.append(__wrapString(count++, "subContractCode", getSubContractCode()));
		if(getSubContractName() != null) sb.append(__wrapString(count++, "subContractName", getSubContractName()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getAchieveIntegral() != null) sb.append(__wrapNumber(count++, "achieveIntegral", getAchieveIntegral()));
		if(getProjectIntegral() != null) sb.append(__wrapNumber(count++, "projectIntegral", getProjectIntegral()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, "reserveIntegral", getReserveIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapNumber(count++, "sureIntegral", getSureIntegral()));
		if(getCostIntegral() != null) sb.append(__wrapNumber(count++, "costIntegral", getCostIntegral()));
		if(getSalaryIntegral() != null) sb.append(__wrapNumber(count++, "salaryIntegral", getSalaryIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("subContractCode")) != null) setSubContractCode(__getString(val));
		if((val = values.get("subContractName")) != null) setSubContractName(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("achieveIntegral")) != null) setAchieveIntegral(__getLong(val)); 
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getLong(val)); 
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getLong(val)); 
		if((val = values.get("costIntegral")) != null) setCostIntegral(__getLong(val)); 
		if((val = values.get("salaryIntegral")) != null) setSalaryIntegral(__getLong(val)); 
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __sub_contract_code ;
	protected java.lang.String  __sub_contract_name ;
	protected java.lang.String  __project_name ;
	protected java.lang.Long  __achieve_integral ;
	protected java.lang.Long  __project_integral ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.lang.Long  __sure_integral ;
	protected java.lang.Long  __cost_integral ;
	protected java.lang.Long  __salary_integral ;
}
