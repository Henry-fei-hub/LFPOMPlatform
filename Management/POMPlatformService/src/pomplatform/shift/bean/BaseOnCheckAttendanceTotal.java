package pomplatform.shift.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseOnCheckAttendanceTotal extends GenericBase implements BaseFactory<BaseOnCheckAttendanceTotal>, Comparable<BaseOnCheckAttendanceTotal> 
{


	public static BaseOnCheckAttendanceTotal newInstance(){
		return new BaseOnCheckAttendanceTotal();
	}

	@Override
	public BaseOnCheckAttendanceTotal make(){
		BaseOnCheckAttendanceTotal b = new BaseOnCheckAttendanceTotal();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_BUSINESS_NUM = "business_num" ;
	public final static java.lang.String CS_OUT_NUM = "out_num" ;
	public final static java.lang.String CS_LATE_NUM = "late_num" ;
	public final static java.lang.String CS_EARLY_NUM = "early_num" ;
	public final static java.lang.String CS_LEAVE_NUM = "leave_num" ;
	public final static java.lang.String CS_ABSENCE_NUM = "absence_num" ;
	public final static java.lang.String CS_ATTENDANCE_RATE = "attendance_rate" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,出差,外出,迟到,早退,请假,旷工,出勤率";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getBusinessNum() {
		return this.__business_num;
	}

	public void setBusinessNum( java.lang.Integer value ) {
		this.__business_num = value;
	}

	public java.lang.Integer getOutNum() {
		return this.__out_num;
	}

	public void setOutNum( java.lang.Integer value ) {
		this.__out_num = value;
	}
	
	public java.lang.Integer getLateNum() {
		return this.__late_num;
	}
	
	public void setLateNum( java.lang.Integer value ) {
		this.__late_num = value;
	}
	
	public java.lang.Integer getEarlyNum() {
		return this.__early_num;
	}
	
	public void setEarlyNum( java.lang.Integer value ) {
		this.__early_num = value;
	}
	
	public java.lang.Integer getLeaveNum() {
		return this.__leave_num;
	}
	
	public void setLeaveNum( java.lang.Integer value ) {
		this.__leave_num = value;
	}
	
	public java.lang.Integer getAbsenceNum() {
		return this.__absence_num;
	}
	
	public void setAbsenceNum( java.lang.Integer value ) {
		this.__absence_num = value;
	}

	public java.lang.String getAttendanceRate() {
		return this.__attendance_rate;
	}

	public void setAttendanceRate( java.lang.String value ) {
		this.__attendance_rate = value;
	}

	public void cloneCopy(BaseOnCheckAttendanceTotal __bean){
		__bean.setPlateId(getPlateId());
		__bean.setBusinessNum(getBusinessNum());
		__bean.setOutNum(getOutNum());
		__bean.setLateNum(getLateNum());
		__bean.setEarlyNum(getEarlyNum());
		__bean.setLeaveNum(getLeaveNum());
		__bean.setAbsenceNum(getAbsenceNum());
		__bean.setAttendanceRate(getAttendanceRate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getBusinessNum() == null ? "" : getBusinessNum());
		sb.append(",");
		sb.append(getOutNum() == null ? "" : getOutNum());
		sb.append(",");
		sb.append(getLateNum() == null ? "" : getLateNum());
		sb.append(",");
		sb.append(getEarlyNum() == null ? "" : getEarlyNum());
		sb.append(",");
		sb.append(getLeaveNum() == null ? "" : getLeaveNum());
		sb.append(",");
		sb.append(getAbsenceNum() == null ? "" : getAbsenceNum());
		sb.append(",");
		sb.append(getAttendanceRate() == null ? "" : getAttendanceRate());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnCheckAttendanceTotal o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__business_num);
		hash = 97 * hash + Objects.hashCode(this.__out_num);
		hash = 97 * hash + Objects.hashCode(this.__late_num);
		hash = 97 * hash + Objects.hashCode(this.__early_num);
		hash = 97 * hash + Objects.hashCode(this.__leave_num);
		hash = 97 * hash + Objects.hashCode(this.__absence_num);
		hash = 97 * hash + Objects.hashCode(this.__attendance_rate);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnCheckAttendanceTotal o = (BaseOnCheckAttendanceTotal)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__business_num, o.getBusinessNum())) return false;
		if(!Objects.equals(this.__out_num, o.getOutNum())) return false;
		if(!Objects.equals(this.__late_num, o.getLateNum())) return false;
		if(!Objects.equals(this.__early_num, o.getEarlyNum())) return false;
		if(!Objects.equals(this.__leave_num, o.getLeaveNum())) return false;
		if(!Objects.equals(this.__absence_num, o.getAbsenceNum())) return false;
		if(!Objects.equals(this.__attendance_rate, o.getAttendanceRate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getBusinessNum() != null) sb.append(__wrapNumber(count++, "businessNum", getBusinessNum()));
		if(getOutNum() != null) sb.append(__wrapNumber(count++, "outNum", getOutNum()));
		if(getLateNum() != null) sb.append(__wrapNumber(count++, "lateNum", getLateNum()));
		if(getEarlyNum() != null) sb.append(__wrapNumber(count++, "earlyNum", getEarlyNum()));
		if(getLeaveNum() != null) sb.append(__wrapNumber(count++, "leaveNum", getLeaveNum()));
		if(getAbsenceNum() != null) sb.append(__wrapNumber(count++, "absenceNum", getAbsenceNum()));
		if(getAttendanceRate() != null) sb.append(__wrapString(count++, "attendanceRate", getAttendanceRate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("businessNum")) != null) setBusinessNum(__getInt(val)); 
		if((val = values.get("outNum")) != null) setOutNum(__getInt(val)); 
		if((val = values.get("lateNum")) != null) setLateNum(__getInt(val)); 
		if((val = values.get("earlyNum")) != null) setEarlyNum(__getInt(val)); 
		if((val = values.get("leaveNum")) != null) setLeaveNum(__getInt(val)); 
		if((val = values.get("absenceNum")) != null) setAbsenceNum(__getInt(val)); 
		if((val = values.get("attendanceRate")) != null) setAttendanceRate(__getString(val));
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __business_num ;
	protected java.lang.Integer  __out_num ;
	protected java.lang.Integer  __late_num ;
	protected java.lang.Integer  __early_num ;
	protected java.lang.Integer  __leave_num ;
	protected java.lang.Integer  __absence_num ;
	protected java.lang.String  __attendance_rate ;
}
