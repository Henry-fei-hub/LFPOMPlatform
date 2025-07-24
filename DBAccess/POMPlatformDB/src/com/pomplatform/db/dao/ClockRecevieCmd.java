package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseClockRecevieCmd;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ClockRecevieCmd extends AbstractTable<BaseClockRecevieCmd>
{

	public ClockRecevieCmd() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 21;

		initTables();

		__tableName            = "clock_recevie_cmds";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseClockRecevieCmd.CS_CLOCK_RECEVIE_CMD_ID;
		__column_names[1] = BaseClockRecevieCmd.CS_SN;
		__column_names[2] = BaseClockRecevieCmd.CS_CMD_CONTENT;
		__column_names[3] = BaseClockRecevieCmd.CS_CMD_COMMIT_TIME;
		__column_names[4] = BaseClockRecevieCmd.CS_CMD_TRANS_TIME;
		__column_names[5] = BaseClockRecevieCmd.CS_CMD_RETURN;
		__column_names[6] = BaseClockRecevieCmd.CS_PROCESS_COUNT;
		__column_names[7] = BaseClockRecevieCmd.CS_SUCCESS_FLAG;
		__column_names[8] = BaseClockRecevieCmd.CS_RECEIVE_DATA;
		__column_names[9] = BaseClockRecevieCmd.CS_CMD_TYPE;
		__column_names[10] = BaseClockRecevieCmd.CS_CMD_SYSTEM;
		__column_names[11] = BaseClockRecevieCmd.CS_CMD_OVER_TIME;
		__column_names[12] = BaseClockRecevieCmd.CS_UPDATE_DB;
		__column_names[13] = BaseClockRecevieCmd.CS_USER_ID;
		__column_names[14] = BaseClockRecevieCmd.CS_CHANGE_OPERATOR;
		__column_names[15] = BaseClockRecevieCmd.CS_CHANGE_TIME;
		__column_names[16] = BaseClockRecevieCmd.CS_CREATE_OPERATOR;
		__column_names[17] = BaseClockRecevieCmd.CS_CREATE_TIME;
		__column_names[18] = BaseClockRecevieCmd.CS_DELETE_OPERATOR;
		__column_names[19] = BaseClockRecevieCmd.CS_DELETE_TIME;
		__column_names[20] = BaseClockRecevieCmd.CS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseClockRecevieCmd b) {
		clear();
		setClockRecevieCmdIdClear(b.getClockRecevieCmdId());
	}

	public boolean isPrimaryKeyNull() {
		return getClockRecevieCmdId() == null;
	}

	@Override
	public BaseClockRecevieCmd generateBase(){
		BaseClockRecevieCmd b = new BaseClockRecevieCmd();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseClockRecevieCmd b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setClockRecevieCmdId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCmdContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCmdCommitTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCmdTransTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCmdReturn(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSuccessFlag(GenericBase.__getShort(val));
		if((val = __current_data[count++]) != null) b.setReceiveData(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCmdType(GenericBase.__getShort(val));
		if((val = __current_data[count++]) != null) b.setCmdSystem(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCmdOverTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateDb(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setUserId(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setChangeOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setChangeTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDeleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getShort(val));
	}

	@Override
	public void setBaseToBuffer(BaseClockRecevieCmd b, Object[] buff){
		int count = 0;
		buff[count++] = b.getClockRecevieCmdId();
		buff[count++] = b.getSn();
		buff[count++] = b.getCmdContent();
		buff[count++] = generateTimestampFromDate(b.getCmdCommitTime());
		buff[count++] = generateTimestampFromDate(b.getCmdTransTime());
		buff[count++] = b.getCmdReturn();
		buff[count++] = b.getProcessCount();
		buff[count++] = b.getSuccessFlag();
		buff[count++] = b.getReceiveData();
		buff[count++] = b.getCmdType();
		buff[count++] = b.getCmdSystem();
		buff[count++] = generateTimestampFromDate(b.getCmdOverTime());
		buff[count++] = b.getUpdateDb();
		buff[count++] = b.getUserId();
		buff[count++] = b.getChangeOperator();
		buff[count++] = generateTimestampFromDate(b.getChangeTime());
		buff[count++] = b.getCreateOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteOperator();
		buff[count++] = generateTimestampFromDate(b.getDeleteTime());
		buff[count++] = b.getStatus();
	}

	@Override
	public void setDataFromBase(BaseClockRecevieCmd b){
		if(b.getClockRecevieCmdId() != null) setClockRecevieCmdIdClear(b.getClockRecevieCmdId());
		if(b.getSn() != null) setSn(b.getSn());
		if(b.getCmdContent() != null) setCmdContent(b.getCmdContent());
		if(b.getCmdCommitTime() != null) setCmdCommitTime(b.getCmdCommitTime());
		if(b.getCmdTransTime() != null) setCmdTransTime(b.getCmdTransTime());
		if(b.getCmdReturn() != null) setCmdReturn(b.getCmdReturn());
		if(b.getProcessCount() != null) setProcessCount(b.getProcessCount());
		if(b.getSuccessFlag() != null) setSuccessFlag(b.getSuccessFlag());
		if(b.getReceiveData() != null) setReceiveData(b.getReceiveData());
		if(b.getCmdType() != null) setCmdType(b.getCmdType());
		if(b.getCmdSystem() != null) setCmdSystem(b.getCmdSystem());
		if(b.getCmdOverTime() != null) setCmdOverTime(b.getCmdOverTime());
		if(b.getUpdateDb() != null) setUpdateDb(b.getUpdateDb());
		if(b.getUserId() != null) setUserId(b.getUserId());
		if(b.getChangeOperator() != null) setChangeOperator(b.getChangeOperator());
		if(b.getChangeTime() != null) setChangeTime(b.getChangeTime());
		if(b.getCreateOperator() != null) setCreateOperator(b.getCreateOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteOperator() != null) setDeleteOperator(b.getDeleteOperator());
		if(b.getDeleteTime() != null) setDeleteTime(b.getDeleteTime());
		if(b.getStatus() != null) setStatus(b.getStatus());
	}

	@Override
	public BaseClockRecevieCmd generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseClockRecevieCmd b = new BaseClockRecevieCmd();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseClockRecevieCmd __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClockRecevieCmdId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmdContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmdCommitTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmdTransTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmdReturn(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSuccessFlag(GenericBase.__getShort(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveData(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmdType(GenericBase.__getShort(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmdSystem(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmdOverTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateDb(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUserId(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setChangeOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setChangeTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getShort(val));
	}

	public void setClockRecevieCmdId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getClockRecevieCmdId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setClockRecevieCmdIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSn(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getSn() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setCmdContent(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCmdContent() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setCmdCommitTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCmdCommitTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setCmdTransTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCmdTransTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setCmdReturn(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getCmdReturn() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setProcessCount(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getProcessCount() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSuccessFlag(java.lang.Short val) {
		setCurrentData(7, val);
	}

	public java.lang.Short getSuccessFlag() {
		return GenericBase.__getShort(__current_data[7]);
	}

	public void setReceiveData(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getReceiveData() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setCmdType(java.lang.Short val) {
		setCurrentData(9, val);
	}

	public java.lang.Short getCmdType() {
		return GenericBase.__getShort(__current_data[9]);
	}

	public void setCmdSystem(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getCmdSystem() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setCmdOverTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getCmdOverTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setUpdateDb(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getUpdateDb() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setUserId(java.lang.Long val) {
		setCurrentData(13, val);
	}

	public java.lang.Long getUserId() {
		return GenericBase.__getLong(__current_data[13]);
	}

	public void setChangeOperator(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getChangeOperator() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setChangeTime(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getChangeTime() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setCreateOperator(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getCreateOperator() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setDeleteOperator(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getDeleteOperator() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setDeleteTime(java.util.Date val) {
		setCurrentData(19, generateTimestampFromDate(val));
	}

	public java.util.Date getDeleteTime() {
		return GenericBase.__getDateFromSQL(__current_data[19]);
	}

	public void setStatus(java.lang.Short val) {
		setCurrentData(20, val);
	}

	public java.lang.Short getStatus() {
		return GenericBase.__getShort(__current_data[20]);
	}

	public void setConditionClockRecevieCmdId(String op, java.lang.Integer val) {
		setConditionClockRecevieCmdId(op, val, CONDITION_AND);
	}

	public void setConditionClockRecevieCmdId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectClockRecevieCmdId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSn(String op, java.lang.String val) {
		setConditionSn(op, val, CONDITION_AND);
	}

	public void setConditionSn(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSn(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCmdContent(String op, java.lang.String val) {
		setConditionCmdContent(op, val, CONDITION_AND);
	}

	public void setConditionCmdContent(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCmdContent(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCmdCommitTime(String op, java.util.Date val) {
		setConditionCmdCommitTime(op, val, CONDITION_AND);
	}

	public void setConditionCmdCommitTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCmdCommitTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCmdTransTime(String op, java.util.Date val) {
		setConditionCmdTransTime(op, val, CONDITION_AND);
	}

	public void setConditionCmdTransTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCmdTransTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCmdReturn(String op, java.lang.Integer val) {
		setConditionCmdReturn(op, val, CONDITION_AND);
	}

	public void setConditionCmdReturn(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCmdReturn(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionProcessCount(String op, java.lang.Integer val) {
		setConditionProcessCount(op, val, CONDITION_AND);
	}

	public void setConditionProcessCount(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProcessCount(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSuccessFlag(String op, java.lang.Short val) {
		setConditionSuccessFlag(op, val, CONDITION_AND);
	}

	public void setConditionSuccessFlag(String op, java.lang.Short val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSuccessFlag(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionReceiveData(String op, java.lang.String val) {
		setConditionReceiveData(op, val, CONDITION_AND);
	}

	public void setConditionReceiveData(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectReceiveData(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCmdType(String op, java.lang.Short val) {
		setConditionCmdType(op, val, CONDITION_AND);
	}

	public void setConditionCmdType(String op, java.lang.Short val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCmdType(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCmdSystem(String op, java.lang.Integer val) {
		setConditionCmdSystem(op, val, CONDITION_AND);
	}

	public void setConditionCmdSystem(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectCmdSystem(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionCmdOverTime(String op, java.util.Date val) {
		setConditionCmdOverTime(op, val, CONDITION_AND);
	}

	public void setConditionCmdOverTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCmdOverTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionUpdateDb(String op, java.lang.String val) {
		setConditionUpdateDb(op, val, CONDITION_AND);
	}

	public void setConditionUpdateDb(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectUpdateDb(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionUserId(String op, java.lang.Long val) {
		setConditionUserId(op, val, CONDITION_AND);
	}

	public void setConditionUserId(String op, java.lang.Long val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectUserId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionChangeOperator(String op, java.lang.Integer val) {
		setConditionChangeOperator(op, val, CONDITION_AND);
	}

	public void setConditionChangeOperator(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectChangeOperator(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionChangeTime(String op, java.util.Date val) {
		setConditionChangeTime(op, val, CONDITION_AND);
	}

	public void setConditionChangeTime(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectChangeTime(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionCreateOperator(String op, java.lang.Integer val) {
		setConditionCreateOperator(op, val, CONDITION_AND);
	}

	public void setConditionCreateOperator(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectCreateOperator(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionDeleteOperator(String op, java.lang.Integer val) {
		setConditionDeleteOperator(op, val, CONDITION_AND);
	}

	public void setConditionDeleteOperator(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectDeleteOperator(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionDeleteTime(String op, java.util.Date val) {
		setConditionDeleteTime(op, val, CONDITION_AND);
	}

	public void setConditionDeleteTime(String op, java.util.Date val, String relation) {
		addCondition(19, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectDeleteTime(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionStatus(String op, java.lang.Short val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Short val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[20] = val;
	}


}

