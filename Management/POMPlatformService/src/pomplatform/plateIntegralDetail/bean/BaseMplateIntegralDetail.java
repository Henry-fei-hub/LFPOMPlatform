package pomplatform.plateIntegralDetail.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMplateIntegralDetail extends GenericBase implements BaseFactory<BaseMplateIntegralDetail>, Comparable<BaseMplateIntegralDetail> 
{


	public static BaseMplateIntegralDetail newInstance(){
		return new BaseMplateIntegralDetail();
	}

	@Override
	public BaseMplateIntegralDetail make(){
		BaseMplateIntegralDetail b = new BaseMplateIntegralDetail();
		return b;
	}

	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_COST_INTEGRAL = "cost_integral" ;
	public final static java.lang.String CS_SALARY_INTEGRAL = "salary_integral" ;
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "分类,标示,板块,预留积分,确认积分,成本积分,人工成本,价值积分";

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Long getReserveIntegral() {
		return this.__reserve_integral;
	}

	public void setReserveIntegral( java.lang.Long value ) {
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

	public java.lang.Long getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral( java.lang.Long value ) {
		this.__achieve_integral = value;
	}

	public void cloneCopy(BaseMplateIntegralDetail __bean){
		__bean.setName(getName());
		__bean.setFlag(getFlag());
		__bean.setPlateId(getPlateId());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setCostIntegral(getCostIntegral());
		__bean.setSalaryIntegral(getSalaryIntegral());
		__bean.setAchieveIntegral(getAchieveIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		String strFlag = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_34", String.valueOf(getFlag()));
		sb.append(strFlag == null ? "" : strFlag);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getCostIntegral() == null ? "" : getCostIntegral());
		sb.append(",");
		sb.append(getSalaryIntegral() == null ? "" : getSalaryIntegral());
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMplateIntegralDetail o) {
		return __name == null ? -1 : __name.compareTo(o.getName());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__cost_integral);
		hash = 97 * hash + Objects.hashCode(this.__salary_integral);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMplateIntegralDetail o = (BaseMplateIntegralDetail)obj;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__cost_integral, o.getCostIntegral())) return false;
		if(!Objects.equals(this.__salary_integral, o.getSalaryIntegral())) return false;
		if(!Objects.equals(this.__achieve_integral, o.getAchieveIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getReserveIntegral() != null) sb.append(__wrapNumber(count++, "reserveIntegral", getReserveIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapNumber(count++, "sureIntegral", getSureIntegral()));
		if(getCostIntegral() != null) sb.append(__wrapNumber(count++, "costIntegral", getCostIntegral()));
		if(getSalaryIntegral() != null) sb.append(__wrapNumber(count++, "salaryIntegral", getSalaryIntegral()));
		if(getAchieveIntegral() != null) sb.append(__wrapNumber(count++, "achieveIntegral", getAchieveIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getLong(val)); 
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getLong(val)); 
		if((val = values.get("costIntegral")) != null) setCostIntegral(__getLong(val)); 
		if((val = values.get("salaryIntegral")) != null) setSalaryIntegral(__getLong(val)); 
		if((val = values.get("achieveIntegral")) != null) setAchieveIntegral(__getLong(val)); 
	}

	protected java.lang.String  __name ;
	protected java.lang.Integer  __flag ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Long  __reserve_integral ;
	protected java.lang.Long  __sure_integral ;
	protected java.lang.Long  __cost_integral ;
	protected java.lang.Long  __salary_integral ;
	protected java.lang.Long  __achieve_integral ;
}
