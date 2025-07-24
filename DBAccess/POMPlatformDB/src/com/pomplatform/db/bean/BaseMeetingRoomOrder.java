package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMeetingRoomOrder extends GenericBase implements BaseFactory<BaseMeetingRoomOrder>, Comparable<BaseMeetingRoomOrder> 
{


	public static BaseMeetingRoomOrder newInstance(){
		return new BaseMeetingRoomOrder();
	}

	@Override
	public BaseMeetingRoomOrder make(){
		BaseMeetingRoomOrder b = new BaseMeetingRoomOrder();
		return b;
	}

	public final static java.lang.String CS_MEETING_ROOM_ORDER_ID = "meeting_room_order_id" ;
	public final static java.lang.String CS_MEETING_ROOM_ID = "meeting_room_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_MOBILE = "mobile" ;
	public final static java.lang.String CS_MEETING_TITLE = "meeting_title" ;
	public final static java.lang.String CS_MEETING_MEMBER = "meeting_member" ;
	public final static java.lang.String CS_MEETING_NUM = "meeting_num" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;

	public final static java.lang.String ALL_CAPTIONS = "id,时间区间,预约人,预约部门,预约归属部门,预约日期,预约人联系方式,会议主题,会议成员,会议人数,预约状态（0已预约，1未预约，2禁止预约）,备注,删除状态（0已删除，1未删除）";

	public java.lang.Integer getMeetingRoomOrderId() {
		return this.__meeting_room_order_id;
	}

	public void setMeetingRoomOrderId( java.lang.Integer value ) {
		this.__meeting_room_order_id = value;
	}

	public java.lang.String getMeetingRoomId() {
		return this.__meeting_room_id;
	}

	public void setMeetingRoomId( java.lang.String value ) {
		this.__meeting_room_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.String getMobile() {
		return this.__mobile;
	}

	public void setMobile( java.lang.String value ) {
		this.__mobile = value;
	}

	public java.lang.String getMeetingTitle() {
		return this.__meeting_title;
	}

	public void setMeetingTitle( java.lang.String value ) {
		this.__meeting_title = value;
	}

	public java.lang.String getMeetingMember() {
		return this.__meeting_member;
	}

	public void setMeetingMember( java.lang.String value ) {
		this.__meeting_member = value;
	}

	public java.lang.Integer getMeetingNum() {
		return this.__meeting_num;
	}

	public void setMeetingNum( java.lang.Integer value ) {
		this.__meeting_num = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public void cloneCopy(BaseMeetingRoomOrder __bean){
		__bean.setMeetingRoomOrderId(getMeetingRoomOrderId());
		__bean.setMeetingRoomId(getMeetingRoomId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setRecordDate(getRecordDate());
		__bean.setMobile(getMobile());
		__bean.setMeetingTitle(getMeetingTitle());
		__bean.setMeetingMember(getMeetingMember());
		__bean.setMeetingNum(getMeetingNum());
		__bean.setStatus(getStatus());
		__bean.setRemark(getRemark());
		__bean.setDeleteFlag(getDeleteFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMeetingRoomOrderId() == null ? "" : getMeetingRoomOrderId());
		sb.append(",");
		sb.append(getMeetingRoomId() == null ? "" : getMeetingRoomId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getMobile() == null ? "" : getMobile());
		sb.append(",");
		sb.append(getMeetingTitle() == null ? "" : getMeetingTitle());
		sb.append(",");
		sb.append(getMeetingMember() == null ? "" : getMeetingMember());
		sb.append(",");
		sb.append(getMeetingNum() == null ? "" : getMeetingNum());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeetingRoomOrder o) {
		return __meeting_room_order_id == null ? -1 : __meeting_room_order_id.compareTo(o.getMeetingRoomOrderId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_order_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__mobile);
		hash = 97 * hash + Objects.hashCode(this.__meeting_title);
		hash = 97 * hash + Objects.hashCode(this.__meeting_member);
		hash = 97 * hash + Objects.hashCode(this.__meeting_num);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeetingRoomOrder o = (BaseMeetingRoomOrder)obj;
		if(!Objects.equals(this.__meeting_room_order_id, o.getMeetingRoomOrderId())) return false;
		if(!Objects.equals(this.__meeting_room_id, o.getMeetingRoomId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__mobile, o.getMobile())) return false;
		if(!Objects.equals(this.__meeting_title, o.getMeetingTitle())) return false;
		if(!Objects.equals(this.__meeting_member, o.getMeetingMember())) return false;
		if(!Objects.equals(this.__meeting_num, o.getMeetingNum())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMeetingRoomOrderId() != null) sb.append(__wrapNumber(count++, "meetingRoomOrderId", getMeetingRoomOrderId()));
		if(getMeetingRoomId() != null) sb.append(__wrapString(count++, "meetingRoomId", getMeetingRoomId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getMobile() != null) sb.append(__wrapString(count++, "mobile", getMobile()));
		if(getMeetingTitle() != null) sb.append(__wrapString(count++, "meetingTitle", getMeetingTitle()));
		if(getMeetingMember() != null) sb.append(__wrapString(count++, "meetingMember", getMeetingMember()));
		if(getMeetingNum() != null) sb.append(__wrapNumber(count++, "meetingNum", getMeetingNum()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingRoomOrderId() != null) res.put("meetingRoomOrderId", getMeetingRoomOrderId());
		if(getMeetingRoomId() != null) res.put("meetingRoomId", getMeetingRoomId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getRecordDate() != null) res.put("recordDate", getRecordDate());
		if(getMobile() != null) res.put("mobile", getMobile());
		if(getMeetingTitle() != null) res.put("meetingTitle", getMeetingTitle());
		if(getMeetingMember() != null) res.put("meetingMember", getMeetingMember());
		if(getMeetingNum() != null) res.put("meetingNum", getMeetingNum());
		if(getStatus() != null) res.put("status", getStatus());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("meetingRoomOrderId")) != null) setMeetingRoomOrderId(__getInt(val)); 
		if((val = values.get("meetingRoomId")) != null) setMeetingRoomId(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("mobile")) != null) setMobile(__getString(val));
		if((val = values.get("meetingTitle")) != null) setMeetingTitle(__getString(val));
		if((val = values.get("meetingMember")) != null) setMeetingMember(__getString(val));
		if((val = values.get("meetingNum")) != null) setMeetingNum(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __meeting_room_order_id ;
	protected java.lang.String  __meeting_room_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __mobile ;
	protected java.lang.String  __meeting_title ;
	protected java.lang.String  __meeting_member ;
	protected java.lang.Integer  __meeting_num ;
	protected java.lang.Integer  __status ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __delete_flag ;
}
