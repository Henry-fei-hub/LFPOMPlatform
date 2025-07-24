package pomplatform.equipment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMequipmentrecordedeor extends GenericBase implements BaseFactory<BaseMequipmentrecordedeor>, Comparable<BaseMequipmentrecordedeor> 
{


	public static BaseMequipmentrecordedeor newInstance(){
		return new BaseMequipmentrecordedeor();
	}

	@Override
	public BaseMequipmentrecordedeor make(){
		BaseMequipmentrecordedeor b = new BaseMequipmentrecordedeor();
		return b;
	}

	public final static String CS_OPERATION_TYPE = "operation_type" ;
	public final static String CS_COUNT = "count" ;
	public final static String CS_FOLLOW_STATUS = "follow_status" ;
	public final static String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static String CS_DEPARTMENT_NAME = "department_name" ;
	public final static String CS_OPERATION_TIME = "operation_time" ;

	public final static String ALL_CAPTIONS = "操作类型,数量,流程状态,员工姓名,部门名称,操作时间";

	public Short getOperationType() {
		return this.__operation_type;
	}

	public void setOperationType( Short value ) {
		this.__operation_type = value;
	}

	public Integer getCount() {
		return this.__count;
	}

	public void setCount( Integer value ) {
		this.__count = value;
	}

	public Short getFollowStatus() {
		return this.__follow_status;
	}

	public void setFollowStatus( Short value ) {
		this.__follow_status = value;
	}

	public String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( String value ) {
		this.__employee_name = value;
	}

	public String getDepartmentName() {
		return this.__department_name;
	}

	public void setDepartmentName( String value ) {
		this.__department_name = value;
	}

	public java.util.Date getOperationTime() {
		return this.__operation_time;
	}

	public void setOperationTime( java.util.Date value ) {
		this.__operation_time = value;
	}

	public void cloneCopy(BaseMequipmentrecordedeor __bean){
		__bean.setOperationType(getOperationType());
		__bean.setCount(getCount());
		__bean.setFollowStatus(getFollowStatus());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentName(getDepartmentName());
		__bean.setOperationTime(getOperationTime());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOperationType() == null ? "" : getOperationType());
		sb.append(",");
		sb.append(getCount() == null ? "" : getCount());
		sb.append(",");
		sb.append(getFollowStatus() == null ? "" : getFollowStatus());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getDepartmentName() == null ? "" : getDepartmentName());
		sb.append(",");
		sb.append(getOperationTime() == null ? "" : sdf.format(getOperationTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMequipmentrecordedeor o) {
		return __operation_type == null ? -1 : __operation_type.compareTo(o.getOperationType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__operation_type);
		hash = 97 * hash + Objects.hashCode(this.__count);
		hash = 97 * hash + Objects.hashCode(this.__follow_status);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_name);
		hash = 97 * hash + Objects.hashCode(this.__operation_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMequipmentrecordedeor o = (BaseMequipmentrecordedeor)obj;
		if(!Objects.equals(this.__operation_type, o.getOperationType())) return false;
		if(!Objects.equals(this.__count, o.getCount())) return false;
		if(!Objects.equals(this.__follow_status, o.getFollowStatus())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_name, o.getDepartmentName())) return false;
		if(!Objects.equals(this.__operation_time, o.getOperationTime())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOperationType() != null) sb.append(__wrapNumber(count++, "operationType", getOperationType()));
		if(getCount() != null) sb.append(__wrapNumber(count++, "count", getCount()));
		if(getFollowStatus() != null) sb.append(__wrapNumber(count++, "followStatus", getFollowStatus()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentName() != null) sb.append(__wrapString(count++, "departmentName", getDepartmentName()));
		if(getOperationTime() != null) sb.append(__wrapDate(count++, "operationTime", getOperationTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getOperationType() != null) res.put("operationType", getOperationType());
		if(getCount() != null) res.put("count", getCount());
		if(getFollowStatus() != null) res.put("followStatus", getFollowStatus());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getDepartmentName() != null) res.put("departmentName", getDepartmentName());
		if(getOperationTime() != null) res.put("operationTime", getOperationTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("operationType")) != null) setOperationType(__getShort(val));
		if((val = values.get("count")) != null) setCount(__getInt(val)); 
		if((val = values.get("followStatus")) != null) setFollowStatus(__getShort(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("operationTime")) != null) setOperationTime(__getDate(val)); 
	}

	protected Short  __operation_type ;
	protected Integer  __count ;
	protected Short  __follow_status ;
	protected String  __employee_name ;
	protected String  __department_name ;
	protected java.util.Date  __operation_time ;
}
