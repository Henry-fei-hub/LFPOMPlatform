package pomplatform.preprojecttransferrecordpors.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseForPreproJectTransFerrecordpor extends GenericBase implements BaseFactory<BaseForPreproJectTransFerrecordpor>, Comparable<BaseForPreproJectTransFerrecordpor> 
{


	public static BaseForPreproJectTransFerrecordpor newInstance(){
		return new BaseForPreproJectTransFerrecordpor();
	}

	@Override
	public BaseForPreproJectTransFerrecordpor make(){
		BaseForPreproJectTransFerrecordpor b = new BaseForPreproJectTransFerrecordpor();
		return b;
	}

	public final static java.lang.String CS_PRE_PROJECT_TRANSFER_RECORD_ID = "pre_project_transfer_record_id" ;
	public final static java.lang.String CS_PRE_PROJECT_ID = "pre_project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_TRANSFER_EMPLOYEE_ID = "transfer_employee_id" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目id,原报备人,转交人,操作人,操作时间";

	public java.lang.Integer getPreProjectTransferRecordId() {
		return this.__pre_project_transfer_record_id;
	}

	public void setPreProjectTransferRecordId( java.lang.Integer value ) {
		this.__pre_project_transfer_record_id = value;
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getTransferEmployeeId() {
		return this.__transfer_employee_id;
	}

	public void setTransferEmployeeId( java.lang.Integer value ) {
		this.__transfer_employee_id = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public void cloneCopy(BaseForPreproJectTransFerrecordpor __bean){
		__bean.setPreProjectTransferRecordId(getPreProjectTransferRecordId());
		__bean.setPreProjectId(getPreProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setTransferEmployeeId(getTransferEmployeeId());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPreProjectTransferRecordId() == null ? "" : getPreProjectTransferRecordId());
		sb.append(",");
		sb.append(getPreProjectId() == null ? "" : getPreProjectId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getTransferEmployeeId() == null ? "" : getTransferEmployeeId());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseForPreproJectTransFerrecordpor o) {
		return __pre_project_transfer_record_id == null ? -1 : __pre_project_transfer_record_id.compareTo(o.getPreProjectTransferRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pre_project_transfer_record_id);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__transfer_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseForPreproJectTransFerrecordpor o = (BaseForPreproJectTransFerrecordpor)obj;
		if(!Objects.equals(this.__pre_project_transfer_record_id, o.getPreProjectTransferRecordId())) return false;
		if(!Objects.equals(this.__pre_project_id, o.getPreProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__transfer_employee_id, o.getTransferEmployeeId())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPreProjectTransferRecordId() != null) sb.append(__wrapNumber(count++, "preProjectTransferRecordId", getPreProjectTransferRecordId()));
		if(getPreProjectId() != null) sb.append(__wrapNumber(count++, "preProjectId", getPreProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getTransferEmployeeId() != null) sb.append(__wrapNumber(count++, "transferEmployeeId", getTransferEmployeeId()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("preProjectTransferRecordId")) != null) setPreProjectTransferRecordId(__getInt(val)); 
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("transferEmployeeId")) != null) setTransferEmployeeId(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __pre_project_transfer_record_id ;
	protected java.lang.Integer  __pre_project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __transfer_employee_id ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
}
