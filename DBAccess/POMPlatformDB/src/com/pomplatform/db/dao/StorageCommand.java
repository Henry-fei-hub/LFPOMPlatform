package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseStorageCommand;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class StorageCommand extends AbstractTable<BaseStorageCommand>
{

	public StorageCommand() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "storage_commands";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseStorageCommand.CS_STORAGE_COMMAND_ID;
		__column_names[1] = BaseStorageCommand.CS_COMMAND_TYPE;
		__column_names[2] = BaseStorageCommand.CS_WORKPLACE_ID;
		__column_names[3] = BaseStorageCommand.CS_REMARK;
		__column_names[4] = BaseStorageCommand.CS_CREATE_TIME;
		__column_names[5] = BaseStorageCommand.CS_COMPLETE_TIME;
		__column_names[6] = BaseStorageCommand.CS_DELETE_FLAG;
		__column_names[7] = BaseStorageCommand.CS_COPY_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseStorageCommand b) {
		clear();
		setStorageCommandIdClear(b.getStorageCommandId());
	}

	public boolean isPrimaryKeyNull() {
		return getStorageCommandId() == null;
	}

	@Override
	public BaseStorageCommand generateBase(){
		BaseStorageCommand b = new BaseStorageCommand();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseStorageCommand b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setStorageCommandId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCommandType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkplaceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCopyType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseStorageCommand b, Object[] buff){
		int count = 0;
		buff[count++] = b.getStorageCommandId();
		buff[count++] = b.getCommandType();
		buff[count++] = b.getWorkplaceId();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getCompleteTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getCopyType();
	}

	@Override
	public void setDataFromBase(BaseStorageCommand b){
		if(b.getStorageCommandId() != null) setStorageCommandIdClear(b.getStorageCommandId());
		if(b.getCommandType() != null) setCommandType(b.getCommandType());
		if(b.getWorkplaceId() != null) setWorkplaceId(b.getWorkplaceId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getCompleteTime() != null) setCompleteTime(b.getCompleteTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getCopyType() != null) setCopyType(b.getCopyType());
	}

	@Override
	public BaseStorageCommand generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseStorageCommand b = new BaseStorageCommand();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseStorageCommand __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStorageCommandId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCommandType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkplaceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCopyType(GenericBase.__getInt(val));
	}

	public void setStorageCommandId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getStorageCommandId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setStorageCommandIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCommandType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCommandType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setWorkplaceId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getWorkplaceId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setCompleteTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCompleteTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCopyType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getCopyType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setConditionStorageCommandId(String op, java.lang.Integer val) {
		setConditionStorageCommandId(op, val, CONDITION_AND);
	}

	public void setConditionStorageCommandId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectStorageCommandId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCommandType(String op, java.lang.Integer val) {
		setConditionCommandType(op, val, CONDITION_AND);
	}

	public void setConditionCommandType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCommandType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionWorkplaceId(String op, java.lang.Integer val) {
		setConditionWorkplaceId(op, val, CONDITION_AND);
	}

	public void setConditionWorkplaceId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectWorkplaceId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCompleteTime(String op, java.util.Date val) {
		setConditionCompleteTime(op, val, CONDITION_AND);
	}

	public void setConditionCompleteTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCompleteTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCopyType(String op, java.lang.Integer val) {
		setConditionCopyType(op, val, CONDITION_AND);
	}

	public void setConditionCopyType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCopyType(boolean val) {
		__select_flags[7] = val;
	}


}

