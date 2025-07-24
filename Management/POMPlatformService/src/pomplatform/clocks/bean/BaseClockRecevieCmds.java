package pomplatform.clocks.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseClockRecevieCmds extends GenericBase implements BaseFactory<BaseClockRecevieCmds>, Comparable<BaseClockRecevieCmds> 
{


	public static BaseClockRecevieCmds newInstance(){
		return new BaseClockRecevieCmds();
	}

	@Override
	public BaseClockRecevieCmds make(){
		BaseClockRecevieCmds b = new BaseClockRecevieCmds();
		return b;
	}

	public final static java.lang.String CS_DEVICE_NAME = "device_name" ;
	public final static java.lang.String CS_CLOCK_RECEVIE_CMD_ID = "clock_recevie_cmd_id" ;
	public final static java.lang.String CS_SN = "sn" ;
	public final static java.lang.String CS_CMD_CONTENT = "cmd_content" ;
	public final static java.lang.String CS_CMD_COMMIT_TIME = "cmd_commit_time" ;
	public final static java.lang.String CS_CMD_TRANS_TIME = "cmd_trans_time" ;
	public final static java.lang.String CS_CMD_RETURN = "cmd_return" ;
	public final static java.lang.String CS_PROCESS_COUNT = "process_count" ;
	public final static java.lang.String CS_SUCCESS_FLAG = "success_flag" ;
	public final static java.lang.String CS_RECEIVE_DATA = "receive_data" ;
	public final static java.lang.String CS_CMD_TYPE = "cmd_type" ;
	public final static java.lang.String CS_CMD_SYSTEM = "cmd_system" ;
	public final static java.lang.String CS_CMD_OVER_TIME = "cmd_over_time" ;
	public final static java.lang.String CS_UPDATE_DB = "update_db" ;
	public final static java.lang.String CS_USER_ID = "user_id" ;
	public final static java.lang.String CS_CHANGE_OPERATOR = "change_operator" ;
	public final static java.lang.String CS_CHANGE_TIME = "change_time" ;
	public final static java.lang.String CS_CREATE_OPERATOR = "create_operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_OPERATOR = "delete_operator" ;
	public final static java.lang.String CS_DELETE_TIME = "delete_time" ;
	public final static java.lang.String CS_STATUS = "status" ;

	public final static java.lang.String ALL_CAPTIONS = "设备名称,主键编码,序列号,命令内容,提交时间,传送时间,返回值,返回条数,返回成功标志,返回数据,命令内容,系统,返回时间,数据库更新标记,操作人,修改人,修改时间,创建人,创建时间,删除人,删除时间,状态";

	public java.lang.String getDeviceName() {
		return this.__device_name;
	}

	public void setDeviceName( java.lang.String value ) {
		this.__device_name = value;
	}

	public java.lang.Integer getClockRecevieCmdId() {
		return this.__clock_recevie_cmd_id;
	}

	public void setClockRecevieCmdId( java.lang.Integer value ) {
		this.__clock_recevie_cmd_id = value;
	}

	public java.lang.String getSn() {
		return this.__sn;
	}

	public void setSn( java.lang.String value ) {
		this.__sn = value;
	}

	public java.lang.String getCmdContent() {
		return this.__cmd_content;
	}

	public void setCmdContent( java.lang.String value ) {
		this.__cmd_content = value;
	}

	public java.util.Date getCmdCommitTime() {
		return this.__cmd_commit_time;
	}

	public void setCmdCommitTime( java.util.Date value ) {
		this.__cmd_commit_time = value;
	}

	public java.util.Date getCmdTransTime() {
		return this.__cmd_trans_time;
	}

	public void setCmdTransTime( java.util.Date value ) {
		this.__cmd_trans_time = value;
	}

	public java.lang.Integer getCmdReturn() {
		return this.__cmd_return;
	}

	public void setCmdReturn( java.lang.Integer value ) {
		this.__cmd_return = value;
	}

	public java.lang.Integer getProcessCount() {
		return this.__process_count;
	}

	public void setProcessCount( java.lang.Integer value ) {
		this.__process_count = value;
	}

	public java.lang.Short getSuccessFlag() {
		return this.__success_flag;
	}

	public void setSuccessFlag( java.lang.Short value ) {
		this.__success_flag = value;
	}

	public java.lang.String getReceiveData() {
		return this.__receive_data;
	}

	public void setReceiveData( java.lang.String value ) {
		this.__receive_data = value;
	}

	public java.lang.Short getCmdType() {
		return this.__cmd_type;
	}

	public void setCmdType( java.lang.Short value ) {
		this.__cmd_type = value;
	}

	public java.lang.Integer getCmdSystem() {
		return this.__cmd_system;
	}

	public void setCmdSystem( java.lang.Integer value ) {
		this.__cmd_system = value;
	}

	public java.util.Date getCmdOverTime() {
		return this.__cmd_over_time;
	}

	public void setCmdOverTime( java.util.Date value ) {
		this.__cmd_over_time = value;
	}

	public java.lang.String getUpdateDb() {
		return this.__update_db;
	}

	public void setUpdateDb( java.lang.String value ) {
		this.__update_db = value;
	}

	public java.lang.Long getUserId() {
		return this.__user_id;
	}

	public void setUserId( java.lang.Long value ) {
		this.__user_id = value;
	}

	public java.lang.Integer getChangeOperator() {
		return this.__change_operator;
	}

	public void setChangeOperator( java.lang.Integer value ) {
		this.__change_operator = value;
	}

	public java.util.Date getChangeTime() {
		return this.__change_time;
	}

	public void setChangeTime( java.util.Date value ) {
		this.__change_time = value;
	}

	public java.lang.Integer getCreateOperator() {
		return this.__create_operator;
	}

	public void setCreateOperator( java.lang.Integer value ) {
		this.__create_operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDeleteOperator() {
		return this.__delete_operator;
	}

	public void setDeleteOperator( java.lang.Integer value ) {
		this.__delete_operator = value;
	}

	public java.util.Date getDeleteTime() {
		return this.__delete_time;
	}

	public void setDeleteTime( java.util.Date value ) {
		this.__delete_time = value;
	}

	public java.lang.Short getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Short value ) {
		this.__status = value;
	}

	public void cloneCopy(BaseClockRecevieCmds __bean){
		__bean.setDeviceName(getDeviceName());
		__bean.setClockRecevieCmdId(getClockRecevieCmdId());
		__bean.setSn(getSn());
		__bean.setCmdContent(getCmdContent());
		__bean.setCmdCommitTime(getCmdCommitTime());
		__bean.setCmdTransTime(getCmdTransTime());
		__bean.setCmdReturn(getCmdReturn());
		__bean.setProcessCount(getProcessCount());
		__bean.setSuccessFlag(getSuccessFlag());
		__bean.setReceiveData(getReceiveData());
		__bean.setCmdType(getCmdType());
		__bean.setCmdSystem(getCmdSystem());
		__bean.setCmdOverTime(getCmdOverTime());
		__bean.setUpdateDb(getUpdateDb());
		__bean.setUserId(getUserId());
		__bean.setChangeOperator(getChangeOperator());
		__bean.setChangeTime(getChangeTime());
		__bean.setCreateOperator(getCreateOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteOperator(getDeleteOperator());
		__bean.setDeleteTime(getDeleteTime());
		__bean.setStatus(getStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDeviceName() == null ? "" : getDeviceName());
		sb.append(",");
		sb.append(getClockRecevieCmdId() == null ? "" : getClockRecevieCmdId());
		sb.append(",");
		sb.append(getSn() == null ? "" : getSn());
		sb.append(",");
		sb.append(getCmdContent() == null ? "" : getCmdContent());
		sb.append(",");
		sb.append(getCmdCommitTime() == null ? "" : sdf.format(getCmdCommitTime()));
		sb.append(",");
		sb.append(getCmdTransTime() == null ? "" : sdf.format(getCmdTransTime()));
		sb.append(",");
		sb.append(getCmdReturn() == null ? "" : getCmdReturn());
		sb.append(",");
		sb.append(getProcessCount() == null ? "" : getProcessCount());
		sb.append(",");
		sb.append(getSuccessFlag() == null ? "" : getSuccessFlag());
		sb.append(",");
		sb.append(getReceiveData() == null ? "" : getReceiveData());
		sb.append(",");
		sb.append(getCmdType() == null ? "" : getCmdType());
		sb.append(",");
		sb.append(getCmdSystem() == null ? "" : getCmdSystem());
		sb.append(",");
		sb.append(getCmdOverTime() == null ? "" : sdf.format(getCmdOverTime()));
		sb.append(",");
		sb.append(getUpdateDb() == null ? "" : getUpdateDb());
		sb.append(",");
		sb.append(getUserId() == null ? "" : getUserId());
		sb.append(",");
		sb.append(getChangeOperator() == null ? "" : getChangeOperator());
		sb.append(",");
		sb.append(getChangeTime() == null ? "" : sdf.format(getChangeTime()));
		sb.append(",");
		sb.append(getCreateOperator() == null ? "" : getCreateOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteOperator() == null ? "" : getDeleteOperator());
		sb.append(",");
		sb.append(getDeleteTime() == null ? "" : sdf.format(getDeleteTime()));
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_61", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseClockRecevieCmds o) {
		return __clock_recevie_cmd_id == null ? -1 : __clock_recevie_cmd_id.compareTo(o.getClockRecevieCmdId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__device_name);
		hash = 97 * hash + Objects.hashCode(this.__clock_recevie_cmd_id);
		hash = 97 * hash + Objects.hashCode(this.__sn);
		hash = 97 * hash + Objects.hashCode(this.__cmd_content);
		hash = 97 * hash + Objects.hashCode(this.__cmd_commit_time);
		hash = 97 * hash + Objects.hashCode(this.__cmd_trans_time);
		hash = 97 * hash + Objects.hashCode(this.__cmd_return);
		hash = 97 * hash + Objects.hashCode(this.__process_count);
		hash = 97 * hash + Objects.hashCode(this.__success_flag);
		hash = 97 * hash + Objects.hashCode(this.__receive_data);
		hash = 97 * hash + Objects.hashCode(this.__cmd_type);
		hash = 97 * hash + Objects.hashCode(this.__cmd_system);
		hash = 97 * hash + Objects.hashCode(this.__cmd_over_time);
		hash = 97 * hash + Objects.hashCode(this.__update_db);
		hash = 97 * hash + Objects.hashCode(this.__user_id);
		hash = 97 * hash + Objects.hashCode(this.__change_operator);
		hash = 97 * hash + Objects.hashCode(this.__change_time);
		hash = 97 * hash + Objects.hashCode(this.__create_operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_operator);
		hash = 97 * hash + Objects.hashCode(this.__delete_time);
		hash = 97 * hash + Objects.hashCode(this.__status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseClockRecevieCmds o = (BaseClockRecevieCmds)obj;
		if(!Objects.equals(this.__device_name, o.getDeviceName())) return false;
		if(!Objects.equals(this.__clock_recevie_cmd_id, o.getClockRecevieCmdId())) return false;
		if(!Objects.equals(this.__sn, o.getSn())) return false;
		if(!Objects.equals(this.__cmd_content, o.getCmdContent())) return false;
		if(!Objects.equals(this.__cmd_commit_time, o.getCmdCommitTime())) return false;
		if(!Objects.equals(this.__cmd_trans_time, o.getCmdTransTime())) return false;
		if(!Objects.equals(this.__cmd_return, o.getCmdReturn())) return false;
		if(!Objects.equals(this.__process_count, o.getProcessCount())) return false;
		if(!Objects.equals(this.__success_flag, o.getSuccessFlag())) return false;
		if(!Objects.equals(this.__receive_data, o.getReceiveData())) return false;
		if(!Objects.equals(this.__cmd_type, o.getCmdType())) return false;
		if(!Objects.equals(this.__cmd_system, o.getCmdSystem())) return false;
		if(!Objects.equals(this.__cmd_over_time, o.getCmdOverTime())) return false;
		if(!Objects.equals(this.__update_db, o.getUpdateDb())) return false;
		if(!Objects.equals(this.__user_id, o.getUserId())) return false;
		if(!Objects.equals(this.__change_operator, o.getChangeOperator())) return false;
		if(!Objects.equals(this.__change_time, o.getChangeTime())) return false;
		if(!Objects.equals(this.__create_operator, o.getCreateOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_operator, o.getDeleteOperator())) return false;
		if(!Objects.equals(this.__delete_time, o.getDeleteTime())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDeviceName() != null) sb.append(__wrapString(count++, "deviceName", getDeviceName()));
		if(getClockRecevieCmdId() != null) sb.append(__wrapNumber(count++, "clockRecevieCmdId", getClockRecevieCmdId()));
		if(getSn() != null) sb.append(__wrapString(count++, "sn", getSn()));
		if(getCmdContent() != null) sb.append(__wrapString(count++, "cmdContent", getCmdContent()));
		if(getCmdCommitTime() != null) sb.append(__wrapDate(count++, "cmdCommitTime", getCmdCommitTime()));
		if(getCmdTransTime() != null) sb.append(__wrapDate(count++, "cmdTransTime", getCmdTransTime()));
		if(getCmdReturn() != null) sb.append(__wrapNumber(count++, "cmdReturn", getCmdReturn()));
		if(getProcessCount() != null) sb.append(__wrapNumber(count++, "processCount", getProcessCount()));
		if(getSuccessFlag() != null) sb.append(__wrapNumber(count++, "successFlag", getSuccessFlag()));
		if(getReceiveData() != null) sb.append(__wrapString(count++, "receiveData", getReceiveData()));
		if(getCmdType() != null) sb.append(__wrapNumber(count++, "cmdType", getCmdType()));
		if(getCmdSystem() != null) sb.append(__wrapNumber(count++, "cmdSystem", getCmdSystem()));
		if(getCmdOverTime() != null) sb.append(__wrapDate(count++, "cmdOverTime", getCmdOverTime()));
		if(getUpdateDb() != null) sb.append(__wrapString(count++, "updateDb", getUpdateDb()));
		if(getUserId() != null) sb.append(__wrapNumber(count++, "userId", getUserId()));
		if(getChangeOperator() != null) sb.append(__wrapNumber(count++, "changeOperator", getChangeOperator()));
		if(getChangeTime() != null) sb.append(__wrapDate(count++, "changeTime", getChangeTime()));
		if(getCreateOperator() != null) sb.append(__wrapNumber(count++, "createOperator", getCreateOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteOperator() != null) sb.append(__wrapNumber(count++, "deleteOperator", getDeleteOperator()));
		if(getDeleteTime() != null) sb.append(__wrapDate(count++, "deleteTime", getDeleteTime()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("deviceName")) != null) setDeviceName(__getString(val));
		if((val = values.get("clockRecevieCmdId")) != null) setClockRecevieCmdId(__getInt(val)); 
		if((val = values.get("sn")) != null) setSn(__getString(val));
		if((val = values.get("cmdContent")) != null) setCmdContent(__getString(val));
		if((val = values.get("cmdCommitTime")) != null) setCmdCommitTime(__getDate(val)); 
		if((val = values.get("cmdTransTime")) != null) setCmdTransTime(__getDate(val)); 
		if((val = values.get("cmdReturn")) != null) setCmdReturn(__getInt(val)); 
		if((val = values.get("processCount")) != null) setProcessCount(__getInt(val)); 
		if((val = values.get("successFlag")) != null) setSuccessFlag(__getShort(val));
		if((val = values.get("receiveData")) != null) setReceiveData(__getString(val));
		if((val = values.get("cmdType")) != null) setCmdType(__getShort(val));
		if((val = values.get("cmdSystem")) != null) setCmdSystem(__getInt(val)); 
		if((val = values.get("cmdOverTime")) != null) setCmdOverTime(__getDate(val)); 
		if((val = values.get("updateDb")) != null) setUpdateDb(__getString(val));
		if((val = values.get("userId")) != null) setUserId(__getLong(val)); 
		if((val = values.get("changeOperator")) != null) setChangeOperator(__getInt(val)); 
		if((val = values.get("changeTime")) != null) setChangeTime(__getDate(val)); 
		if((val = values.get("createOperator")) != null) setCreateOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteOperator")) != null) setDeleteOperator(__getInt(val)); 
		if((val = values.get("deleteTime")) != null) setDeleteTime(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getShort(val));
	}

	protected java.lang.String  __device_name ;
	protected java.lang.Integer  __clock_recevie_cmd_id ;
	protected java.lang.String  __sn ;
	protected java.lang.String  __cmd_content ;
	protected java.util.Date  __cmd_commit_time ;
	protected java.util.Date  __cmd_trans_time ;
	protected java.lang.Integer  __cmd_return ;
	protected java.lang.Integer  __process_count ;
	protected java.lang.Short  __success_flag ;
	protected java.lang.String  __receive_data ;
	protected java.lang.Short  __cmd_type ;
	protected java.lang.Integer  __cmd_system ;
	protected java.util.Date  __cmd_over_time ;
	protected java.lang.String  __update_db ;
	protected java.lang.Long  __user_id ;
	protected java.lang.Integer  __change_operator ;
	protected java.util.Date  __change_time ;
	protected java.lang.Integer  __create_operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_operator ;
	protected java.util.Date  __delete_time ;
	protected java.lang.Short  __status ;
}
