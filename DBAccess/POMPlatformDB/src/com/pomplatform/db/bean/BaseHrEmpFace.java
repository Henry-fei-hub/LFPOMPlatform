package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseHrEmpFace extends GenericBase implements BaseFactory<BaseHrEmpFace>, Comparable<BaseHrEmpFace> 
{


	public static BaseHrEmpFace newInstance(){
		return new BaseHrEmpFace();
	}

	@Override
	public BaseHrEmpFace make(){
		BaseHrEmpFace b = new BaseHrEmpFace();
		return b;
	}

	public final static java.lang.String CS_HR_EMP_FACE_ID = "hr_emp_face_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SN = "sn" ;
	public final static java.lang.String CS_EMP_CODE = "emp_code" ;
	public final static java.lang.String CS_TMP = "tmp" ;
	public final static java.lang.String CS_SIZE = "size" ;
	public final static java.lang.String CS_VALID = "valid" ;
	public final static java.lang.String CS_ENABLED = "enabled" ;
	public final static java.lang.String CS_FID = "fid" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,设备序列号,考勤号码,人脸模板,大小,有效日期,是否可用,人脸序号";

	public java.lang.Integer getHrEmpFaceId() {
		return this.__hr_emp_face_id;
	}

	public void setHrEmpFaceId( java.lang.Integer value ) {
		this.__hr_emp_face_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getSn() {
		return this.__sn;
	}

	public void setSn( java.lang.String value ) {
		this.__sn = value;
	}

	public java.lang.String getEmpCode() {
		return this.__emp_code;
	}

	public void setEmpCode( java.lang.String value ) {
		this.__emp_code = value;
	}

	public java.lang.String getTmp() {
		return this.__tmp;
	}

	public void setTmp( java.lang.String value ) {
		this.__tmp = value;
	}

	public java.lang.Integer getSize() {
		return this.__size;
	}

	public void setSize( java.lang.Integer value ) {
		this.__size = value;
	}

	public java.lang.Integer getValid() {
		return this.__valid;
	}

	public void setValid( java.lang.Integer value ) {
		this.__valid = value;
	}

	public java.lang.Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( java.lang.Boolean value ) {
		this.__enabled = value;
	}

	public java.lang.Integer getFid() {
		return this.__fid;
	}

	public void setFid( java.lang.Integer value ) {
		this.__fid = value;
	}

	public void cloneCopy(BaseHrEmpFace __bean){
		__bean.setHrEmpFaceId(getHrEmpFaceId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setSn(getSn());
		__bean.setEmpCode(getEmpCode());
		__bean.setTmp(getTmp());
		__bean.setSize(getSize());
		__bean.setValid(getValid());
		__bean.setEnabled(getEnabled());
		__bean.setFid(getFid());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getHrEmpFaceId() == null ? "" : getHrEmpFaceId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getSn() == null ? "" : getSn());
		sb.append(",");
		sb.append(getEmpCode() == null ? "" : getEmpCode());
		sb.append(",");
		sb.append(getTmp() == null ? "" : getTmp());
		sb.append(",");
		sb.append(getSize() == null ? "" : getSize());
		sb.append(",");
		sb.append(getValid() == null ? "" : getValid());
		sb.append(",");
		sb.append(getEnabled() == null ? "" : getEnabled());
		sb.append(",");
		sb.append(getFid() == null ? "" : getFid());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseHrEmpFace o) {
		return __hr_emp_face_id == null ? -1 : __hr_emp_face_id.compareTo(o.getHrEmpFaceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__hr_emp_face_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__sn);
		hash = 97 * hash + Objects.hashCode(this.__emp_code);
		hash = 97 * hash + Objects.hashCode(this.__tmp);
		hash = 97 * hash + Objects.hashCode(this.__size);
		hash = 97 * hash + Objects.hashCode(this.__valid);
		hash = 97 * hash + Objects.hashCode(this.__enabled);
		hash = 97 * hash + Objects.hashCode(this.__fid);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseHrEmpFace o = (BaseHrEmpFace)obj;
		if(!Objects.equals(this.__hr_emp_face_id, o.getHrEmpFaceId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__sn, o.getSn())) return false;
		if(!Objects.equals(this.__emp_code, o.getEmpCode())) return false;
		if(!Objects.equals(this.__tmp, o.getTmp())) return false;
		if(!Objects.equals(this.__size, o.getSize())) return false;
		if(!Objects.equals(this.__valid, o.getValid())) return false;
		if(!Objects.equals(this.__enabled, o.getEnabled())) return false;
		if(!Objects.equals(this.__fid, o.getFid())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getHrEmpFaceId() != null) sb.append(__wrapNumber(count++, "hrEmpFaceId", getHrEmpFaceId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getSn() != null) sb.append(__wrapString(count++, "sn", getSn()));
		if(getEmpCode() != null) sb.append(__wrapString(count++, "empCode", getEmpCode()));
		if(getTmp() != null) sb.append(__wrapString(count++, "tmp", getTmp()));
		if(getSize() != null) sb.append(__wrapNumber(count++, "size", getSize()));
		if(getValid() != null) sb.append(__wrapNumber(count++, "valid", getValid()));
		if(getEnabled() != null) sb.append(__wrapBoolean(count++, "enabled", getEnabled()));
		if(getFid() != null) sb.append(__wrapNumber(count++, "fid", getFid()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("hrEmpFaceId")) != null) setHrEmpFaceId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("sn")) != null) setSn(__getString(val));
		if((val = values.get("empCode")) != null) setEmpCode(__getString(val));
		if((val = values.get("tmp")) != null) setTmp(__getString(val));
		if((val = values.get("size")) != null) setSize(__getInt(val)); 
		if((val = values.get("valid")) != null) setValid(__getInt(val)); 
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
		if((val = values.get("fid")) != null) setFid(__getInt(val)); 
	}

	protected java.lang.Integer  __hr_emp_face_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __sn ;
	protected java.lang.String  __emp_code ;
	protected java.lang.String  __tmp ;
	protected java.lang.Integer  __size ;
	protected java.lang.Integer  __valid ;
	protected java.lang.Boolean  __enabled ;
	protected java.lang.Integer  __fid ;
}
