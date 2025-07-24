package pomplatform.leavetype.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePersonalLeaveType extends GenericBase implements BaseFactory<BasePersonalLeaveType>, Comparable<BasePersonalLeaveType> 
{


	public static BasePersonalLeaveType newInstance(){
		return new BasePersonalLeaveType();
	}

	@Override
	public BasePersonalLeaveType make(){
		BasePersonalLeaveType b = new BasePersonalLeaveType();
		return b;
	}

	public final static java.lang.String CS_LEAVE_TYPE_ID = "leave_type_id" ;
	public final static java.lang.String CS_LEAVE_TYPE_NAME = "leave_type_name" ;
	public final static java.lang.String CS_AREA_ID = "area_id" ;
	public final static java.lang.String CS_AREA_NAME = "area_name" ;
	public final static java.lang.String CS_DAYS = "days" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;

	public final static java.lang.String ALL_CAPTIONS = "请假类型,请假类型,适用区域,适用区域,天数,备注,父级编码";

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

	public java.lang.Integer getAreaId() {
		return this.__area_id;
	}

	public void setAreaId( java.lang.Integer value ) {
		this.__area_id = value;
	}

	public java.lang.String getAreaName() {
		return this.__area_name;
	}

	public void setAreaName( java.lang.String value ) {
		this.__area_name = value;
	}

	public java.lang.String getDays() {
		return this.__days;
	}

	public void setDays( java.lang.String value ) {
		this.__days = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public void cloneCopy(BasePersonalLeaveType __bean){
		__bean.setLeaveTypeId(getLeaveTypeId());
		__bean.setLeaveTypeName(getLeaveTypeName());
		__bean.setAreaId(getAreaId());
		__bean.setAreaName(getAreaName());
		__bean.setDays(getDays());
		__bean.setRemark(getRemark());
		__bean.setParentId(getParentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getLeaveTypeId() == null ? "" : getLeaveTypeId());
		sb.append(",");
		sb.append(getLeaveTypeName() == null ? "" : getLeaveTypeName());
		sb.append(",");
		String strProvinceId = delicacy.system.executor.SelectValueCache.getSelectValue("areas", String.valueOf(getAreaId()));
		sb.append(strProvinceId == null ? "" : strProvinceId);
		sb.append(",");
		sb.append(getAreaName() == null ? "" : getAreaName());
		sb.append(",");
		sb.append(getDays() == null ? "" : getDays());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts_1", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		return sb.toString();
	}

	@Override
	public int compareTo(BasePersonalLeaveType o) {
		return __leave_type_id == null ? -1 : __leave_type_id.compareTo(o.getLeaveTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__leave_type_id);
		hash = 97 * hash + Objects.hashCode(this.__leave_type_name);
		hash = 97 * hash + Objects.hashCode(this.__area_id);
		hash = 97 * hash + Objects.hashCode(this.__area_name);
		hash = 97 * hash + Objects.hashCode(this.__days);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePersonalLeaveType o = (BasePersonalLeaveType)obj;
		if(!Objects.equals(this.__leave_type_id, o.getLeaveTypeId())) return false;
		if(!Objects.equals(this.__leave_type_name, o.getLeaveTypeName())) return false;
		if(!Objects.equals(this.__area_id, o.getAreaId())) return false;
		if(!Objects.equals(this.__area_name, o.getAreaName())) return false;
		if(!Objects.equals(this.__days, o.getDays())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getLeaveTypeId() != null) sb.append(__wrapNumber(count++, "leaveTypeId", getLeaveTypeId()));
		if(getLeaveTypeName() != null) sb.append(__wrapString(count++, "leaveTypeName", getLeaveTypeName()));
		if(getAreaId() != null) sb.append(__wrapNumber(count++, "areaId", getAreaId()));
		if(getAreaName() != null) sb.append(__wrapString(count++, "areaName", getAreaName()));
		if(getDays() != null) sb.append(__wrapString(count++, "days", getDays()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("leaveTypeId")) != null) setLeaveTypeId(__getInt(val)); 
		if((val = values.get("leaveTypeName")) != null) setLeaveTypeName(__getString(val));
		if((val = values.get("areaId")) != null) setAreaId(__getInt(val)); 
		if((val = values.get("areaName")) != null) setAreaName(__getString(val));
		if((val = values.get("days")) != null) setDays(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
	}

	protected java.lang.Integer  __leave_type_id ;
	protected java.lang.String  __leave_type_name ;
	protected java.lang.Integer  __area_id ;
	protected java.lang.String  __area_name ;
	protected java.lang.String  __days ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __parent_id ;
}
