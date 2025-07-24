package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseUsedVacationLeave extends GenericBase implements BaseFactory<BaseUsedVacationLeave>, Comparable<BaseUsedVacationLeave> 
{


	public static BaseUsedVacationLeave newInstance(){
		return new BaseUsedVacationLeave();
	}

	@Override
	public BaseUsedVacationLeave make(){
		BaseUsedVacationLeave b = new BaseUsedVacationLeave();
		return b;
	}

	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_USED = "used" ;

	public final static java.lang.String ALL_CAPTIONS = "人事业务编码,申请人,";

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getUsed() {
		return this.__used;
	}

	public void setUsed( java.math.BigDecimal value ) {
		this.__used = value;
	}

	public void cloneCopy(BaseUsedVacationLeave __bean){
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setUsed(getUsed());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getUsed() == null ? "" : getUsed());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseUsedVacationLeave o) {
		return __personnel_business_id == null ? -1 : __personnel_business_id.compareTo(o.getPersonnelBusinessId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__used);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseUsedVacationLeave o = (BaseUsedVacationLeave)obj;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__used, o.getUsed())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getUsed() != null) sb.append(__wrapDecimal(count++, "used", getUsed()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPersonnelBusinessId() != null) res.put("personnelBusinessId", getPersonnelBusinessId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getUsed() != null) res.put("used", getUsed());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("used")) != null) setUsed(__getDecimal(val));  
	}

	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __used ;
}
