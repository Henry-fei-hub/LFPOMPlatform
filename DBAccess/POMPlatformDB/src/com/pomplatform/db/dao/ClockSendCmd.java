package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseClockSendCmd;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ClockSendCmd extends AbstractTable<BaseClockSendCmd>
{

	public ClockSendCmd() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "clock_send_cmds";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseClockSendCmd.CS_CLOCK_SEND_CMD_ID;
		__column_names[1] = BaseClockSendCmd.CS_SN;
		__column_names[2] = BaseClockSendCmd.CS_COUNT;
		__column_names[3] = BaseClockSendCmd.CS_TRANS_CONTEXT;
		__column_names[4] = BaseClockSendCmd.CS_TRANSTIME;
		__column_names[5] = BaseClockSendCmd.CS_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseClockSendCmd b) {
		clear();
		setClockSendCmdIdClear(b.getClockSendCmdId());
	}

	public boolean isPrimaryKeyNull() {
		return getClockSendCmdId() == null;
	}

	@Override
	public BaseClockSendCmd generateBase(){
		BaseClockSendCmd b = new BaseClockSendCmd();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseClockSendCmd b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setClockSendCmdId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTransContext(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTranstime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseClockSendCmd b, Object[] buff){
		int count = 0;
		buff[count++] = b.getClockSendCmdId();
		buff[count++] = b.getSn();
		buff[count++] = b.getCount();
		buff[count++] = b.getTransContext();
		buff[count++] = generateTimestampFromDate(b.getTranstime());
		buff[count++] = b.getFlag();
	}

	@Override
	public void setDataFromBase(BaseClockSendCmd b){
		if(b.getClockSendCmdId() != null) setClockSendCmdIdClear(b.getClockSendCmdId());
		if(b.getSn() != null) setSn(b.getSn());
		if(b.getCount() != null) setCount(b.getCount());
		if(b.getTransContext() != null) setTransContext(b.getTransContext());
		if(b.getTranstime() != null) setTranstime(b.getTranstime());
		if(b.getFlag() != null) setFlag(b.getFlag());
	}

	@Override
	public BaseClockSendCmd generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseClockSendCmd b = new BaseClockSendCmd();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseClockSendCmd __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClockSendCmdId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransContext(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTranstime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getString(val));
	}

	public void setClockSendCmdId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getClockSendCmdId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setClockSendCmdIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSn(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getSn() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setCount(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCount() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setTransContext(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getTransContext() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setTranstime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getTranstime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setFlag(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getFlag() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setConditionClockSendCmdId(String op, java.lang.Integer val) {
		setConditionClockSendCmdId(op, val, CONDITION_AND);
	}

	public void setConditionClockSendCmdId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectClockSendCmdId(boolean val) {
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

	public void setConditionCount(String op, java.lang.Integer val) {
		setConditionCount(op, val, CONDITION_AND);
	}

	public void setConditionCount(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCount(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTransContext(String op, java.lang.String val) {
		setConditionTransContext(op, val, CONDITION_AND);
	}

	public void setConditionTransContext(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectTransContext(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTranstime(String op, java.util.Date val) {
		setConditionTranstime(op, val, CONDITION_AND);
	}

	public void setConditionTranstime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectTranstime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionFlag(String op, java.lang.String val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
		__select_flags[5] = val;
	}


}

