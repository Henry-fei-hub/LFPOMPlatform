package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnGetBenefitsOfEmployee extends GenericBase implements BaseFactory<BaseOnGetBenefitsOfEmployee>, Comparable<BaseOnGetBenefitsOfEmployee> 
{


	public static BaseOnGetBenefitsOfEmployee newInstance(){
		return new BaseOnGetBenefitsOfEmployee();
	}

	@Override
	public BaseOnGetBenefitsOfEmployee make(){
		BaseOnGetBenefitsOfEmployee b = new BaseOnGetBenefitsOfEmployee();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_INTEGRAL = "integral" ;
	public final static java.lang.String CS_BUSINESS_TYPE_ID = "business_type_id" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,积分,10绩效奖金)";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public java.lang.Integer getBusinessTypeId() {
		return this.__business_type_id;
	}

	public void setBusinessTypeId( java.lang.Integer value ) {
		this.__business_type_id = value;
	}

	public void cloneCopy(BaseOnGetBenefitsOfEmployee __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setIntegral(getIntegral());
		__bean.setBusinessTypeId(getBusinessTypeId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		sb.append(",");
		sb.append(getBusinessTypeId() == null ? "" : getBusinessTypeId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnGetBenefitsOfEmployee o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		hash = 97 * hash + Objects.hashCode(this.__business_type_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnGetBenefitsOfEmployee o = (BaseOnGetBenefitsOfEmployee)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		if(!Objects.equals(this.__business_type_id, o.getBusinessTypeId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		if(getBusinessTypeId() != null) sb.append(__wrapNumber(count++, "businessTypeId", getBusinessTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));  
		if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __integral ;
	protected java.lang.Integer  __business_type_id ;
}
