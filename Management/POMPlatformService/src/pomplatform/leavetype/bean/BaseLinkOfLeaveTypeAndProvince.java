package pomplatform.leavetype.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseLinkOfLeaveTypeAndProvince extends GenericBase implements BaseFactory<BaseLinkOfLeaveTypeAndProvince>, Comparable<BaseLinkOfLeaveTypeAndProvince> 
{


	public static BaseLinkOfLeaveTypeAndProvince newInstance(){
		return new BaseLinkOfLeaveTypeAndProvince();
	}

	@Override
	public BaseLinkOfLeaveTypeAndProvince make(){
		BaseLinkOfLeaveTypeAndProvince b = new BaseLinkOfLeaveTypeAndProvince();
		return b;
	}

	public final static java.lang.String CS_LEAVE_TYPE_LINK_PROVINCE_ID = "leave_type_link_province_id" ;
	public final static java.lang.String CS_LEAVE_TYPE_ID = "leave_type_id" ;
	public final static java.lang.String CS_PROVINCE_ID = "province_id" ;
	public final static java.lang.String CS_DAYS = "days" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_IS_ENABLE = "is_enable" ;

	public final static java.lang.String ALL_CAPTIONS = "请假类型省份关联表,请假类型,适用省份,天数,备注,是否启用";

	public java.lang.Integer getLeaveTypeLinkProvinceId() {
		return this.__leave_type_link_province_id;
	}

	public void setLeaveTypeLinkProvinceId( java.lang.Integer value ) {
		this.__leave_type_link_province_id = value;
	}

	public java.lang.Integer getLeaveTypeId() {
		return this.__leave_type_id;
	}

	public void setLeaveTypeId( java.lang.Integer value ) {
		this.__leave_type_id = value;
	}

	public java.lang.Integer getProvinceId() {
		return this.__province_id;
	}

	public void setProvinceId( java.lang.Integer value ) {
		this.__province_id = value;
	}

	public java.math.BigDecimal getDays() {
		return this.__days;
	}

	public void setDays( java.math.BigDecimal value ) {
		this.__days = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
	}

	public void cloneCopy(BaseLinkOfLeaveTypeAndProvince __bean){
		__bean.setLeaveTypeLinkProvinceId(getLeaveTypeLinkProvinceId());
		__bean.setLeaveTypeId(getLeaveTypeId());
		__bean.setProvinceId(getProvinceId());
		__bean.setDays(getDays());
		__bean.setRemark(getRemark());
		__bean.setIsEnable(getIsEnable());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getLeaveTypeLinkProvinceId() == null ? "" : getLeaveTypeLinkProvinceId());
		sb.append(",");
		sb.append(getLeaveTypeId() == null ? "" : getLeaveTypeId());
		sb.append(",");
		String strProvinceId = delicacy.system.executor.SelectValueCache.getSelectValue("provinces", String.valueOf(getProvinceId()));
		sb.append(strProvinceId == null ? "" : strProvinceId);
		sb.append(",");
		sb.append(getDays() == null ? "" : getDays());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getIsEnable() == null ? "" : getIsEnable());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseLinkOfLeaveTypeAndProvince o) {
		return __leave_type_link_province_id == null ? -1 : __leave_type_link_province_id.compareTo(o.getLeaveTypeLinkProvinceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__leave_type_link_province_id);
		hash = 97 * hash + Objects.hashCode(this.__leave_type_id);
		hash = 97 * hash + Objects.hashCode(this.__province_id);
		hash = 97 * hash + Objects.hashCode(this.__days);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__is_enable);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseLinkOfLeaveTypeAndProvince o = (BaseLinkOfLeaveTypeAndProvince)obj;
		if(!Objects.equals(this.__leave_type_link_province_id, o.getLeaveTypeLinkProvinceId())) return false;
		if(!Objects.equals(this.__leave_type_id, o.getLeaveTypeId())) return false;
		if(!Objects.equals(this.__province_id, o.getProvinceId())) return false;
		if(!Objects.equals(this.__days, o.getDays())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__is_enable, o.getIsEnable())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getLeaveTypeLinkProvinceId() != null) sb.append(__wrapNumber(count++, "leaveTypeLinkProvinceId", getLeaveTypeLinkProvinceId()));
		if(getLeaveTypeId() != null) sb.append(__wrapNumber(count++, "leaveTypeId", getLeaveTypeId()));
		if(getProvinceId() != null) sb.append(__wrapNumber(count++, "provinceId", getProvinceId()));
		if(getDays() != null) sb.append(__wrapDecimal(count++, "days", getDays()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(count++, "isEnable", getIsEnable()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("leaveTypeLinkProvinceId")) != null) setLeaveTypeLinkProvinceId(__getInt(val)); 
		if((val = values.get("leaveTypeId")) != null) setLeaveTypeId(__getInt(val)); 
		if((val = values.get("provinceId")) != null) setProvinceId(__getInt(val)); 
		if((val = values.get("days")) != null) setDays(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
	}

	protected java.lang.Integer  __leave_type_link_province_id ;
	protected java.lang.Integer  __leave_type_id ;
	protected java.lang.Integer  __province_id ;
	protected java.math.BigDecimal  __days ;
	protected java.lang.String  __remark ;
	protected java.lang.Boolean  __is_enable ;
}
