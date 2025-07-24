package pomplatform.sProjectEmployeeAdvanceRecordpor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSProjectEmployeeAdvanceRecordpor extends GenericBase implements BaseFactory<BaseSProjectEmployeeAdvanceRecordpor>, Comparable<BaseSProjectEmployeeAdvanceRecordpor> 
{


	public static BaseSProjectEmployeeAdvanceRecordpor newInstance(){
		return new BaseSProjectEmployeeAdvanceRecordpor();
	}

	@Override
	public BaseSProjectEmployeeAdvanceRecordpor make(){
		BaseSProjectEmployeeAdvanceRecordpor b = new BaseSProjectEmployeeAdvanceRecordpor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ADVANCE_INTEGRAL = "advance_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "补贴项目,员工姓名,补贴积分";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.String value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getAdvanceIntegral() {
		return this.__advance_integral;
	}

	public void setAdvanceIntegral( java.math.BigDecimal value ) {
		this.__advance_integral = value;
	}

	public void cloneCopy(BaseSProjectEmployeeAdvanceRecordpor __bean){
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setAdvanceIntegral(getAdvanceIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getAdvanceIntegral() == null ? "" : getAdvanceIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSProjectEmployeeAdvanceRecordpor o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__advance_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSProjectEmployeeAdvanceRecordpor o = (BaseSProjectEmployeeAdvanceRecordpor)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__advance_integral, o.getAdvanceIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapString(count++, "employeeId", getEmployeeId()));
		if(getAdvanceIntegral() != null) sb.append(__wrapDecimal(count++, "advanceIntegral", getAdvanceIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getString(val));
		if((val = values.get("advanceIntegral")) != null) setAdvanceIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __employee_id ;
	protected java.math.BigDecimal  __advance_integral ;
}
