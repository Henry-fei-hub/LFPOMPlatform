package pomplatform.specialDeduction.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnCheckSpecialCountByYear extends GenericBase implements BaseFactory<BaseOnCheckSpecialCountByYear>, Comparable<BaseOnCheckSpecialCountByYear> 
{


	public static BaseOnCheckSpecialCountByYear newInstance(){
		return new BaseOnCheckSpecialCountByYear();
	}

	@Override
	public BaseOnCheckSpecialCountByYear make(){
		BaseOnCheckSpecialCountByYear b = new BaseOnCheckSpecialCountByYear();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_TYPE_ID = "special_deduction_type_id" ;
	public final static java.lang.String CS_COUNT = "count" ;

	public final static java.lang.String ALL_CAPTIONS = "创建人,专项类型,";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getSpecialDeductionTypeId() {
		return this.__special_deduction_type_id;
	}

	public void setSpecialDeductionTypeId( java.lang.Integer value ) {
		this.__special_deduction_type_id = value;
	}

	public java.lang.Integer getCount() {
		return this.__count;
	}

	public void setCount( java.lang.Integer value ) {
		this.__count = value;
	}

	public void cloneCopy(BaseOnCheckSpecialCountByYear __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setSpecialDeductionTypeId(getSpecialDeductionTypeId());
		__bean.setCount(getCount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getSpecialDeductionTypeId() == null ? "" : getSpecialDeductionTypeId());
		sb.append(",");
		sb.append(getCount() == null ? "" : getCount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnCheckSpecialCountByYear o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_type_id);
		hash = 97 * hash + Objects.hashCode(this.__count);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnCheckSpecialCountByYear o = (BaseOnCheckSpecialCountByYear)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__special_deduction_type_id, o.getSpecialDeductionTypeId())) return false;
		if(!Objects.equals(this.__count, o.getCount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(count++, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		if(getCount() != null) sb.append(__wrapNumber(count++, "count", getCount()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getSpecialDeductionTypeId() != null) res.put("specialDeductionTypeId", getSpecialDeductionTypeId());
		if(getCount() != null) res.put("count", getCount());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
		if((val = values.get("count")) != null) setCount(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __special_deduction_type_id ;
	protected java.lang.Integer  __count ;
}
