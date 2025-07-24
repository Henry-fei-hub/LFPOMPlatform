package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractLog;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractLog extends AbstractTable<BaseContractLog>
{

	public ContractLog() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "contract_logs";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractLog.CS_CONTRACT_LOG_ID;
		__column_names[1] = BaseContractLog.CS_CONTRACT_ID;
		__column_names[2] = BaseContractLog.CS_ORIGINAL_STATUS;
		__column_names[3] = BaseContractLog.CS_NEW_STATUS;
		__column_names[4] = BaseContractLog.CS_CONTENT;
		__column_names[5] = BaseContractLog.CS_OPERATOR;
		__column_names[6] = BaseContractLog.CS_OPERATE_TIME;
		__column_names[7] = BaseContractLog.CS_DELETE_FLAG;
		__column_names[8] = BaseContractLog.CS_ATTACHMENT_ID;
		__column_names[9] = BaseContractLog.CS_REMARK;
		__column_names[10] = BaseContractLog.CS_PROCESS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractLog b) {
		clear();
		setContractLogIdClear(b.getContractLogId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractLogId() == null;
	}

	@Override
	public BaseContractLog generateBase(){
		BaseContractLog b = new BaseContractLog();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractLog b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractLogId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOriginalStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNewStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProcessStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractLog b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractLogId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getOriginalStatus();
		buff[count++] = b.getNewStatus();
		buff[count++] = b.getContent();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getAttachmentId();
		buff[count++] = b.getRemark();
		buff[count++] = b.getProcessStatus();
	}

	@Override
	public void setDataFromBase(BaseContractLog b){
		if(b.getContractLogId() != null) setContractLogIdClear(b.getContractLogId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getOriginalStatus() != null) setOriginalStatus(b.getOriginalStatus());
		if(b.getNewStatus() != null) setNewStatus(b.getNewStatus());
		if(b.getContent() != null) setContent(b.getContent());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getAttachmentId() != null) setAttachmentId(b.getAttachmentId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getProcessStatus() != null) setProcessStatus(b.getProcessStatus());
	}

	@Override
	public BaseContractLog generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractLog b = new BaseContractLog();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractLog __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractLogId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNewStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessStatus(GenericBase.__getInt(val));
	}

	public void setContractLogId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractLogId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractLogIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setOriginalStatus(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getOriginalStatus() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setNewStatus(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getNewStatus() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setContent(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getContent() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setAttachmentId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getAttachmentId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setProcessStatus(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getProcessStatus() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setConditionContractLogId(String op, java.lang.Integer val) {
		setConditionContractLogId(op, val, CONDITION_AND);
	}

	public void setConditionContractLogId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractLogId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionOriginalStatus(String op, java.lang.Integer val) {
		setConditionOriginalStatus(op, val, CONDITION_AND);
	}

	public void setConditionOriginalStatus(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectOriginalStatus(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionNewStatus(String op, java.lang.Integer val) {
		setConditionNewStatus(op, val, CONDITION_AND);
	}

	public void setConditionNewStatus(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectNewStatus(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionContent(String op, java.lang.String val) {
		setConditionContent(op, val, CONDITION_AND);
	}

	public void setConditionContent(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectContent(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val) {
		setConditionAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectAttachmentId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val) {
		setConditionProcessStatus(op, val, CONDITION_AND);
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectProcessStatus(boolean val) {
		__select_flags[10] = val;
	}


}

