package pomplatform.plateIntegralAssignRecord.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSplateIntegralAssignRecord extends GenericBase implements BaseFactory<BaseSplateIntegralAssignRecord>, Comparable<BaseSplateIntegralAssignRecord> 
{


	public static BaseSplateIntegralAssignRecord newInstance(){
		return new BaseSplateIntegralAssignRecord();
	}

	@Override
	public BaseSplateIntegralAssignRecord make(){
		BaseSplateIntegralAssignRecord b = new BaseSplateIntegralAssignRecord();
		return b;
	}

	public final static java.lang.String CS_PLATE_INTEGRAL_ASSIGN_RECORD_ID = "plate_integral_assign_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ASSIGN_INTEGRAL = "assign_integral" ;
	public final static java.lang.String CS_ASSIGN_DATE = "assign_date" ;
	public final static java.lang.String CS_PLATE_EMPLOYEE_ID = "plate_employee_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务部门,发放人员,发放积分,发放日期,部门负责人,备注";

	public java.lang.Integer getPlateIntegralAssignRecordId() {
		return this.__plate_integral_assign_record_id;
	}

	public void setPlateIntegralAssignRecordId( java.lang.Integer value ) {
		this.__plate_integral_assign_record_id = value;
	}

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

	public java.math.BigDecimal getAssignIntegral() {
		return this.__assign_integral;
	}

	public void setAssignIntegral( java.math.BigDecimal value ) {
		this.__assign_integral = value;
	}

	public java.util.Date getAssignDate() {
		return this.__assign_date;
	}

	public void setAssignDate( java.util.Date value ) {
		this.__assign_date = value;
	}

	public java.lang.Integer getPlateEmployeeId() {
		return this.__plate_employee_id;
	}

	public void setPlateEmployeeId( java.lang.Integer value ) {
		this.__plate_employee_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSplateIntegralAssignRecord __bean){
		__bean.setPlateIntegralAssignRecordId(getPlateIntegralAssignRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setAssignIntegral(getAssignIntegral());
		__bean.setAssignDate(getAssignDate());
		__bean.setPlateEmployeeId(getPlateEmployeeId());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateIntegralAssignRecordId() == null ? "" : getPlateIntegralAssignRecordId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getAssignIntegral() == null ? "" : getAssignIntegral());
		sb.append(",");
		sb.append(getAssignDate() == null ? "" : sdf.format(getAssignDate()));
		sb.append(",");
		String strPlateEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getPlateEmployeeId()));
		sb.append(strPlateEmployeeId == null ? "" : strPlateEmployeeId);
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSplateIntegralAssignRecord o) {
		return __plate_integral_assign_record_id == null ? -1 : __plate_integral_assign_record_id.compareTo(o.getPlateIntegralAssignRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_integral_assign_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__assign_integral);
		hash = 97 * hash + Objects.hashCode(this.__assign_date);
		hash = 97 * hash + Objects.hashCode(this.__plate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSplateIntegralAssignRecord o = (BaseSplateIntegralAssignRecord)obj;
		if(!Objects.equals(this.__plate_integral_assign_record_id, o.getPlateIntegralAssignRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__assign_integral, o.getAssignIntegral())) return false;
		if(!Objects.equals(this.__assign_date, o.getAssignDate())) return false;
		if(!Objects.equals(this.__plate_employee_id, o.getPlateEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateIntegralAssignRecordId() != null) sb.append(__wrapNumber(count++, "plateIntegralAssignRecordId", getPlateIntegralAssignRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getAssignIntegral() != null) sb.append(__wrapDecimal(count++, "assignIntegral", getAssignIntegral()));
		if(getAssignDate() != null) sb.append(__wrapDate(count++, "assignDate", getAssignDate()));
		if(getPlateEmployeeId() != null) sb.append(__wrapNumber(count++, "plateEmployeeId", getPlateEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateIntegralAssignRecordId")) != null) setPlateIntegralAssignRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("assignIntegral")) != null) setAssignIntegral(__getDecimal(val));  
		if((val = values.get("assignDate")) != null) setAssignDate(__getDate(val)); 
		if((val = values.get("plateEmployeeId")) != null) setPlateEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __plate_integral_assign_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __assign_integral ;
	protected java.util.Date  __assign_date ;
	protected java.lang.Integer  __plate_employee_id ;
	protected java.lang.String  __remark ;
}
