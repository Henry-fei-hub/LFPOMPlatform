package pomplatform.splateintegralsumrecordpysor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSplateintegralsumrecordpysor extends GenericBase implements BaseFactory<BaseSplateintegralsumrecordpysor>, Comparable<BaseSplateintegralsumrecordpysor> 
{


	public static BaseSplateintegralsumrecordpysor newInstance(){
		return new BaseSplateintegralsumrecordpysor();
	}

	@Override
	public BaseSplateintegralsumrecordpysor make(){
		BaseSplateintegralsumrecordpysor b = new BaseSplateintegralsumrecordpysor();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL_SUM = "project_integral_sum" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_COST_INTEGRAL = "cost_integral" ;
	public final static java.lang.String CS_SETTLEMENT_INTEGRAL = "settlement_integral" ;
	public final static java.lang.String CS_SALARY_INTEGRAL = "salary_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,价值积分,项目总积分,项目积分,预留积分,确认积分,成本积分,结算积分,人工成本";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral( java.math.BigDecimal value ) {
		this.__achieve_integral = value;
	}

	public java.math.BigDecimal getProjectIntegralSum() {
		return this.__project_integral_sum;
	}

	public void setProjectIntegralSum( java.math.BigDecimal value ) {
		this.__project_integral_sum = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getReserveIntegral() {
		return this.__reserve_integral;
	}

	public void setReserveIntegral( java.math.BigDecimal value ) {
		this.__reserve_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getCostIntegral() {
		return this.__cost_integral;
	}

	public void setCostIntegral( java.math.BigDecimal value ) {
		this.__cost_integral = value;
	}

	public java.math.BigDecimal getSettlementIntegral() {
		return this.__settlement_integral;
	}

	public void setSettlementIntegral( java.math.BigDecimal value ) {
		this.__settlement_integral = value;
	}

	public java.math.BigDecimal getSalaryIntegral() {
		return this.__salary_integral;
	}

	public void setSalaryIntegral( java.math.BigDecimal value ) {
		this.__salary_integral = value;
	}

	public void cloneCopy(BaseSplateintegralsumrecordpysor __bean){
		__bean.setPlateId(getPlateId());
		__bean.setAchieveIntegral(getAchieveIntegral());
		__bean.setProjectIntegralSum(getProjectIntegralSum());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setCostIntegral(getCostIntegral());
		__bean.setSettlementIntegral(getSettlementIntegral());
		__bean.setSalaryIntegral(getSalaryIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		sb.append(getProjectIntegralSum() == null ? "" : getProjectIntegralSum());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getCostIntegral() == null ? "" : getCostIntegral());
		sb.append(",");
		sb.append(getSettlementIntegral() == null ? "" : getSettlementIntegral());
		sb.append(",");
		sb.append(getSalaryIntegral() == null ? "" : getSalaryIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSplateintegralsumrecordpysor o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral_sum);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__cost_integral);
		hash = 97 * hash + Objects.hashCode(this.__settlement_integral);
		hash = 97 * hash + Objects.hashCode(this.__salary_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSplateintegralsumrecordpysor o = (BaseSplateintegralsumrecordpysor)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__achieve_integral, o.getAchieveIntegral())) return false;
		if(!Objects.equals(this.__project_integral_sum, o.getProjectIntegralSum())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__cost_integral, o.getCostIntegral())) return false;
		if(!Objects.equals(this.__settlement_integral, o.getSettlementIntegral())) return false;
		if(!Objects.equals(this.__salary_integral, o.getSalaryIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getAchieveIntegral() != null) sb.append(__wrapDecimal(count++, "achieveIntegral", getAchieveIntegral()));
		if(getProjectIntegralSum() != null) sb.append(__wrapDecimal(count++, "projectIntegralSum", getProjectIntegralSum()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, "reserveIntegral", getReserveIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getCostIntegral() != null) sb.append(__wrapDecimal(count++, "costIntegral", getCostIntegral()));
		if(getSettlementIntegral() != null) sb.append(__wrapDecimal(count++, "settlementIntegral", getSettlementIntegral()));
		if(getSalaryIntegral() != null) sb.append(__wrapDecimal(count++, "salaryIntegral", getSalaryIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("achieveIntegral")) != null) setAchieveIntegral(__getDecimal(val));  
		if((val = values.get("projectIntegralSum")) != null) setProjectIntegralSum(__getDecimal(val));  
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("costIntegral")) != null) setCostIntegral(__getDecimal(val));  
		if((val = values.get("settlementIntegral")) != null) setSettlementIntegral(__getDecimal(val));  
		if((val = values.get("salaryIntegral")) != null) setSalaryIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __achieve_integral ;
	protected java.math.BigDecimal  __project_integral_sum ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __cost_integral ;
	protected java.math.BigDecimal  __settlement_integral ;
	protected java.math.BigDecimal  __salary_integral ;
}
