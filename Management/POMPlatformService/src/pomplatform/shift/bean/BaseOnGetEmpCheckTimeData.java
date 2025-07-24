package pomplatform.shift.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnGetEmpCheckTimeData extends GenericBase implements BaseFactory<BaseOnGetEmpCheckTimeData>, Comparable<BaseOnGetEmpCheckTimeData> 
{


	public static BaseOnGetEmpCheckTimeData newInstance(){
		return new BaseOnGetEmpCheckTimeData();
	}

	@Override
	public BaseOnGetEmpCheckTimeData make(){
		BaseOnGetEmpCheckTimeData b = new BaseOnGetEmpCheckTimeData();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CHECK_DATE = "check_date" ;
	public final static java.lang.String CS_CHECKIN = "checkin" ;
	public final static java.lang.String CS_CHECKOUT = "checkout" ;
	public final static java.lang.String CS_CHECK_NUM = "check_num" ;
	public final static java.lang.String CS_ACROSS_CHECK_TIME = "across_check_time" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,考勤日期,,,,";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getCheckDate() {
		return this.__check_date;
	}

	public void setCheckDate( java.util.Date value ) {
		this.__check_date = value;
	}

	public java.util.Date getCheckin() {
		return this.__checkin;
	}

	public void setCheckin( java.util.Date value ) {
		this.__checkin = value;
	}

	public java.util.Date getCheckout() {
		return this.__checkout;
	}

	public void setCheckout( java.util.Date value ) {
		this.__checkout = value;
	}

	public java.lang.Long getCheckNum() {
		return this.__check_num;
	}

	public void setCheckNum( java.lang.Long value ) {
		this.__check_num = value;
	}

	public java.util.Date getAcrossCheckTime() {
		return this.__across_check_time;
	}

	public void setAcrossCheckTime( java.util.Date value ) {
		this.__across_check_time = value;
	}

	public void cloneCopy(BaseOnGetEmpCheckTimeData __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCheckDate(getCheckDate());
		__bean.setCheckin(getCheckin());
		__bean.setCheckout(getCheckout());
		__bean.setCheckNum(getCheckNum());
		__bean.setAcrossCheckTime(getAcrossCheckTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getCheckDate() == null ? "" : sdf.format(getCheckDate()));
		sb.append(",");
		sb.append(getCheckin() == null ? "" : sdf.format(getCheckin()));
		sb.append(",");
		sb.append(getCheckout() == null ? "" : sdf.format(getCheckout()));
		sb.append(",");
		sb.append(getCheckNum() == null ? "" : getCheckNum());
		sb.append(",");
		sb.append(getAcrossCheckTime() == null ? "" : sdf.format(getAcrossCheckTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnGetEmpCheckTimeData o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__check_date);
		hash = 97 * hash + Objects.hashCode(this.__checkin);
		hash = 97 * hash + Objects.hashCode(this.__checkout);
		hash = 97 * hash + Objects.hashCode(this.__check_num);
		hash = 97 * hash + Objects.hashCode(this.__across_check_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnGetEmpCheckTimeData o = (BaseOnGetEmpCheckTimeData)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__check_date, o.getCheckDate())) return false;
		if(!Objects.equals(this.__checkin, o.getCheckin())) return false;
		if(!Objects.equals(this.__checkout, o.getCheckout())) return false;
		if(!Objects.equals(this.__check_num, o.getCheckNum())) return false;
		if(!Objects.equals(this.__across_check_time, o.getAcrossCheckTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCheckDate() != null) sb.append(__wrapDate(count++, "checkDate", getCheckDate()));
		if(getCheckin() != null) sb.append(__wrapDate(count++, "checkin", getCheckin()));
		if(getCheckout() != null) sb.append(__wrapDate(count++, "checkout", getCheckout()));
		if(getCheckNum() != null) sb.append(__wrapNumber(count++, "checkNum", getCheckNum()));
		if(getAcrossCheckTime() != null) sb.append(__wrapDate(count++, "acrossCheckTime", getAcrossCheckTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("checkDate")) != null) setCheckDate(__getDate(val)); 
		if((val = values.get("checkin")) != null) setCheckin(__getDate(val)); 
		if((val = values.get("checkout")) != null) setCheckout(__getDate(val)); 
		if((val = values.get("checkNum")) != null) setCheckNum(__getLong(val)); 
		if((val = values.get("acrossCheckTime")) != null) setAcrossCheckTime(__getDate(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __check_date ;
	protected java.util.Date  __checkin ;
	protected java.util.Date  __checkout ;
	protected java.lang.Long  __check_num ;
	protected java.util.Date  __across_check_time ;
}
