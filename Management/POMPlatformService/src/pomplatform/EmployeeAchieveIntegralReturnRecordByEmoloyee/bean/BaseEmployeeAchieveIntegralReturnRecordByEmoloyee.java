package pomplatform.EmployeeAchieveIntegralReturnRecordByEmoloyee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeAchieveIntegralReturnRecordByEmoloyee extends GenericBase implements BaseFactory<BaseEmployeeAchieveIntegralReturnRecordByEmoloyee>, Comparable<BaseEmployeeAchieveIntegralReturnRecordByEmoloyee> 
{


	public static BaseEmployeeAchieveIntegralReturnRecordByEmoloyee newInstance(){
		return new BaseEmployeeAchieveIntegralReturnRecordByEmoloyee();
	}

	@Override
	public BaseEmployeeAchieveIntegralReturnRecordByEmoloyee make(){
		BaseEmployeeAchieveIntegralReturnRecordByEmoloyee b = new BaseEmployeeAchieveIntegralReturnRecordByEmoloyee();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral" ;
	public final static java.lang.String CS_STATUS = "status" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,员工,工号,姓名,回流积分,回流类型";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
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

	public java.math.BigDecimal getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral( java.math.BigDecimal value ) {
		this.__achieve_integral = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public void cloneCopy(BaseEmployeeAchieveIntegralReturnRecordByEmoloyee __bean){
		__bean.setPlateId(getPlateId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setAchieveIntegral(getAchieveIntegral());
		__bean.setStatus(getStatus());
	}

	public java.lang.String toCSVString() {

		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_37", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeAchieveIntegralReturnRecordByEmoloyee o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeAchieveIntegralReturnRecordByEmoloyee o = (BaseEmployeeAchieveIntegralReturnRecordByEmoloyee)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__achieve_integral, o.getAchieveIntegral())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getAchieveIntegral() != null) sb.append(__wrapDecimal(count++, "achieveIntegral", getAchieveIntegral()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("achieveIntegral")) != null) setAchieveIntegral(__getDecimal(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val));
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.math.BigDecimal  __achieve_integral ;
	protected java.lang.Integer  __status ;
}
