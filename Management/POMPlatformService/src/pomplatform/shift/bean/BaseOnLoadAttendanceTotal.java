package pomplatform.shift.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadAttendanceTotal extends GenericBase implements BaseFactory<BaseOnLoadAttendanceTotal>, Comparable<BaseOnLoadAttendanceTotal> 
{


	public static BaseOnLoadAttendanceTotal newInstance(){
		return new BaseOnLoadAttendanceTotal();
	}

	@Override
	public BaseOnLoadAttendanceTotal make(){
		BaseOnLoadAttendanceTotal b = new BaseOnLoadAttendanceTotal();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_TOTAL_NUM = "total_num" ;
	public final static java.lang.String CS_LEAVE_NUM = "leave_num" ;
	public final static java.lang.String CS_ABSENCE_NUM = "absence_num" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,人数,请假人数,旷工人数";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getTotalNum() {
		return this.__total_num;
	}

	public void setTotalNum( java.lang.Integer value ) {
		this.__total_num = value;
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

	public void cloneCopy(BaseOnLoadAttendanceTotal __bean){
		__bean.setPlateId(getPlateId());
		__bean.setTotalNum(getTotalNum());
		__bean.setLeaveNum(getLeaveNum());
		__bean.setAbsenceNum(getAbsenceNum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getTotalNum() == null ? "" : getTotalNum());
		sb.append(",");
		sb.append(getLeaveNum() == null ? "" : getLeaveNum());
		sb.append(",");
		sb.append(getAbsenceNum() == null ? "" : getAbsenceNum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadAttendanceTotal o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__total_num);
		hash = 97 * hash + Objects.hashCode(this.__leave_num);
		hash = 97 * hash + Objects.hashCode(this.__absence_num);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadAttendanceTotal o = (BaseOnLoadAttendanceTotal)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__total_num, o.getTotalNum())) return false;
		if(!Objects.equals(this.__leave_num, o.getLeaveNum())) return false;
		if(!Objects.equals(this.__absence_num, o.getAbsenceNum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getTotalNum() != null) sb.append(__wrapNumber(count++, "totalNum", getTotalNum()));
		if(getLeaveNum() != null) sb.append(__wrapNumber(count++, "leaveNum", getLeaveNum()));
		if(getAbsenceNum() != null) sb.append(__wrapNumber(count++, "absenceNum", getAbsenceNum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("totalNum")) != null) setTotalNum(__getInt(val)); 
		if((val = values.get("leaveNum")) != null) setLeaveNum(__getInt(val)); 
		if((val = values.get("absenceNum")) != null) setAbsenceNum(__getInt(val)); 
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __total_num ;
	protected java.lang.Integer  __leave_num ;
	protected java.lang.Integer  __absence_num ;
}
