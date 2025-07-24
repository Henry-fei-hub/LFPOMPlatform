package pomplatform.leavetype.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSearchLeaveTypes extends GenericBase implements BaseFactory<BaseSearchLeaveTypes>, Comparable<BaseSearchLeaveTypes> 
{


	public static BaseSearchLeaveTypes newInstance(){
		return new BaseSearchLeaveTypes();
	}

	@Override
	public BaseSearchLeaveTypes make(){
		BaseSearchLeaveTypes b = new BaseSearchLeaveTypes();
		return b;
	}

	public final static java.lang.String CS_LEAVE_TYPE_ID = "leave_type_id" ;
	public final static java.lang.String CS_LEAVE_TYPE_NAME = "leave_type_name" ;
	public final static java.lang.String CS_DAYS = "days" ;

	public final static java.lang.String ALL_CAPTIONS = "请假类型,请假类型名称,天数";

	public java.lang.Integer getLeaveTypeId() {
		return this.__leave_type_id;
	}

	public void setLeaveTypeId( java.lang.Integer value ) {
		this.__leave_type_id = value;
	}

	public java.lang.String getLeaveTypeName() {
		return this.__leave_type_name;
	}

	public void setLeaveTypeName( java.lang.String value ) {
		this.__leave_type_name = value;
	}

	public java.math.BigDecimal getDays() {
		return this.__days;
	}

	public void setDays( java.math.BigDecimal value ) {
		this.__days = value;
	}

	public java.lang.Integer getPlateType() {
		return __plate_type;
	}

	public void setPlateType(Integer __plate_type) {
		this.__plate_type = __plate_type;
	}


	public void cloneCopy(BaseSearchLeaveTypes __bean){
		__bean.setLeaveTypeId(getLeaveTypeId());
		__bean.setLeaveTypeName(getLeaveTypeName());
		__bean.setDays(getDays());
		__bean.setPlateType(getPlateType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getLeaveTypeId() == null ? "" : getLeaveTypeId());
		sb.append(",");
		sb.append(getLeaveTypeName() == null ? "" : getLeaveTypeName());
		sb.append(",");
		sb.append(getDays() == null ? "" : getDays());
		sb.append(",");
		sb.append(getPlateType() == null ? "" : getPlateType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSearchLeaveTypes o) {
		return __leave_type_id == null ? -1 : __leave_type_id.compareTo(o.getLeaveTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__leave_type_id);
		hash = 97 * hash + Objects.hashCode(this.__leave_type_name);
		hash = 97 * hash + Objects.hashCode(this.__days);
		hash = 97 * hash + Objects.hashCode(this.__plate_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSearchLeaveTypes o = (BaseSearchLeaveTypes)obj;
		if(!Objects.equals(this.__leave_type_id, o.getLeaveTypeId())) return false;
		if(!Objects.equals(this.__leave_type_name, o.getLeaveTypeName())) return false;
		if(!Objects.equals(this.__days, o.getDays())) return false;
		if(!Objects.equals(this.__plate_type, o.getPlateType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getLeaveTypeId() != null) sb.append(__wrapNumber(count++, "leaveTypeId", getLeaveTypeId()));
		if(getLeaveTypeName() != null) sb.append(__wrapString(count++, "leaveTypeName", getLeaveTypeName()));
		if(getDays() != null) sb.append(__wrapDecimal(count++, "days", getDays()));
		if(getPlateType() != null) sb.append(__wrapNumber(count++, "plateType", getPlateType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("leaveTypeId")) != null) setLeaveTypeId(__getInt(val)); 
		if((val = values.get("leaveTypeName")) != null) setLeaveTypeName(__getString(val));
		if((val = values.get("days")) != null) setDays(__getDecimal(val));
		if((val = values.get("platetype")) != null) setPlateType(__getInt(val));
	}

	protected java.lang.Integer  __leave_type_id ;
	protected java.lang.String  __leave_type_name ;
	protected java.math.BigDecimal  __days ;
	protected java.lang.Integer __plate_type;
}
