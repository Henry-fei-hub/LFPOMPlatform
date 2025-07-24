package pomplatform.shift.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadAttendanceStatus extends GenericBase implements BaseFactory<BaseOnLoadAttendanceStatus>, Comparable<BaseOnLoadAttendanceStatus> 
{


	public static BaseOnLoadAttendanceStatus newInstance(){
		return new BaseOnLoadAttendanceStatus();
	}

	@Override
	public BaseOnLoadAttendanceStatus make(){
		BaseOnLoadAttendanceStatus b = new BaseOnLoadAttendanceStatus();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_PERSONNEL_NUM = "personnel_num" ;
	public final static java.lang.String CS_TYPE_NAME = "type_name" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,类型 13请假  14出差  15打卡  16外出  17加班,人数,业务名称";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getPersonnelNum() {
		return this.__personnel_num;
	}

	public void setPersonnelNum( java.lang.Integer value ) {
		this.__personnel_num = value;
	}

	public java.lang.String getTypeName() {
		return this.__type_name;
	}

	public void setTypeName( java.lang.String value ) {
		this.__type_name = value;
	}

	public void cloneCopy(BaseOnLoadAttendanceStatus __bean){
		__bean.setPlateId(getPlateId());
		__bean.setProcessType(getProcessType());
		__bean.setPersonnelNum(getPersonnelNum());
		__bean.setTypeName(getTypeName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getPersonnelNum() == null ? "" : getPersonnelNum());
		sb.append(",");
		sb.append(getTypeName() == null ? "" : getTypeName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadAttendanceStatus o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__personnel_num);
		hash = 97 * hash + Objects.hashCode(this.__type_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadAttendanceStatus o = (BaseOnLoadAttendanceStatus)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__personnel_num, o.getPersonnelNum())) return false;
		if(!Objects.equals(this.__type_name, o.getTypeName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getPersonnelNum() != null) sb.append(__wrapNumber(count++, "personnelNum", getPersonnelNum()));
		if(getTypeName() != null) sb.append(__wrapString(count++, "typeName", getTypeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("personnelNum")) != null) setPersonnelNum(__getInt(val)); 
		if((val = values.get("typeName")) != null) setTypeName(__getString(val));
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __personnel_num ;
	protected java.lang.String  __type_name ;
}
