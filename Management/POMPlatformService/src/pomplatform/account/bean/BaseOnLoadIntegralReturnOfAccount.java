package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadIntegralReturnOfAccount extends GenericBase implements BaseFactory<BaseOnLoadIntegralReturnOfAccount>, Comparable<BaseOnLoadIntegralReturnOfAccount> 
{


	public static BaseOnLoadIntegralReturnOfAccount newInstance(){
		return new BaseOnLoadIntegralReturnOfAccount();
	}

	@Override
	public BaseOnLoadIntegralReturnOfAccount make(){
		BaseOnLoadIntegralReturnOfAccount b = new BaseOnLoadIntegralReturnOfAccount();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ACHIEVEINTEGRAL = "achieveintegral" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_GRADE_ID = "grade_id" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,价值积分,员工编号,员工姓名,业务部门,4删除),等级";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getAchieveintegral() {
		return this.__achieveintegral;
	}

	public void setAchieveintegral( java.math.BigDecimal value ) {
		this.__achieveintegral = value;
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

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getGradeId() {
		return this.__grade_id;
	}

	public void setGradeId( java.lang.Integer value ) {
		this.__grade_id = value;
	}

	public void cloneCopy(BaseOnLoadIntegralReturnOfAccount __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setAchieveintegral(getAchieveintegral());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setPlateId(getPlateId());
		__bean.setStatus(getStatus());
		__bean.setGradeId(getGradeId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getAchieveintegral() == null ? "" : getAchieveintegral());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_39", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		String strGradeId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_2", String.valueOf(getGradeId()));
		sb.append(strGradeId == null ? "" : strGradeId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadIntegralReturnOfAccount o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__achieveintegral);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__grade_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadIntegralReturnOfAccount o = (BaseOnLoadIntegralReturnOfAccount)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__achieveintegral, o.getAchieveintegral())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__grade_id, o.getGradeId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getAchieveintegral() != null) sb.append(__wrapDecimal(count++, "achieveintegral", getAchieveintegral()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getGradeId() != null) sb.append(__wrapNumber(count++, "gradeId", getGradeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("achieveintegral")) != null) setAchieveintegral(__getDecimal(val));  
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("gradeId")) != null) setGradeId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __achieveintegral ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __grade_id ;
}
