package pomplatform.checking.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAttendanceManagementStatisticsStatus extends GenericBase implements BaseFactory<BaseAttendanceManagementStatisticsStatus>, Comparable<BaseAttendanceManagementStatisticsStatus> 
{


	public static BaseAttendanceManagementStatisticsStatus newInstance(){
		return new BaseAttendanceManagementStatisticsStatus();
	}

	@Override
	public BaseAttendanceManagementStatisticsStatus make(){
		BaseAttendanceManagementStatisticsStatus b = new BaseAttendanceManagementStatisticsStatus();
		return b;
	}

	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_TYPE_NUM = "type_num" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;

	public final static java.lang.String ALL_CAPTIONS = "类型 ,人数,是否审批通过";

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Long getTypeNum() {
		return this.__type_num;
	}

	public void setTypeNum( java.lang.Long value ) {
		this.__type_num = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public void cloneCopy(BaseAttendanceManagementStatisticsStatus __bean){
		__bean.setProcessType(getProcessType());
		__bean.setTypeNum(getTypeNum());
		__bean.setIsCompleted(getIsCompleted());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getTypeNum() == null ? "" : getTypeNum());
		sb.append(",");
		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttendanceManagementStatisticsStatus o) {
		return __process_type == null ? -1 : __process_type.compareTo(o.getProcessType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__type_num);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttendanceManagementStatisticsStatus o = (BaseAttendanceManagementStatisticsStatus)obj;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__type_num, o.getTypeNum())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getTypeNum() != null) sb.append(__wrapNumber(count++, "typeNum", getTypeNum()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("typeNum")) != null) setTypeNum(__getLong(val)); 
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
	}

	protected java.lang.Integer  __process_type ;
	protected java.lang.Long  __type_num ;
	protected java.lang.Boolean  __is_completed ;
}
