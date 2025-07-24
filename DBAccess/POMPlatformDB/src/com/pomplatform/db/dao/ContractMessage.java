package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseContractMessage;


public class ContractMessage extends AbstractTable<BaseContractMessage>
{

	public ContractMessage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "contract_messages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractMessage.CS_CONTRACT_MESSAGE_ID;
		__column_names[1] = BaseContractMessage.CS_CONTRACT_ID;
		__column_names[2] = BaseContractMessage.CS_BUSINESS_ID;
		__column_names[3] = BaseContractMessage.CS_MSG_COUNT;
		__column_names[4] = BaseContractMessage.CS_MSG_STATUS;
		__column_names[5] = BaseContractMessage.CS_OPERATOR;
		__column_names[6] = BaseContractMessage.CS_CREATE_TIME;
		__column_names[7] = BaseContractMessage.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractMessage b) {
		clear();
		setContractMessageIdClear(b.getContractMessageId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractMessageId() == null;
	}

	@Override
	public BaseContractMessage generateBase(){
		BaseContractMessage b = new BaseContractMessage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractMessage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractMessageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMsgCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMsgStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	public void setDataFromCSV(String csvLine){
		setDataFromCSV(csvLine, null);
	}

	public void setDataFromCSV(String csvLine, String names){
		int count = 0; String val;
		Integer num = null;
		setInputNames(names);
		String[] values = JsonParser.csvLine(csvLine, ',');
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractMessageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMsgCount(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMsgStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperator(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCreateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseContractMessage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractMessageId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getMsgCount();
		buff[count++] = b.getMsgStatus();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseContractMessage b){
		if(b.getContractMessageId() != null) setContractMessageIdClear(b.getContractMessageId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getMsgCount() != null) setMsgCount(b.getMsgCount());
		if(b.getMsgStatus() != null) setMsgStatus(b.getMsgStatus());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseContractMessage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractMessage b = new BaseContractMessage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractMessage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractMessageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMsgCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMsgStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setContractMessageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractMessageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractMessageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMsgCount(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getMsgCount() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setMsgStatus(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getMsgStatus() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setConditionContractMessageId(String op, java.lang.Integer val) {
		setConditionContractMessageId(op, val, CONDITION_AND);
	}

	public void setConditionContractMessageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractMessageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setContractMessageIdExpression(String val) {
		__dataExpressions[0] = val;
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

	public void setContractIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[2] = val;
	}

	public void setBusinessIdExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionMsgCount(String op, java.lang.Integer val) {
		setConditionMsgCount(op, val, CONDITION_AND);
	}

	public void setConditionMsgCount(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMsgCount(boolean val) {
		__select_flags[3] = val;
	}

	public void setMsgCountExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionMsgStatus(String op, java.lang.Integer val) {
		setConditionMsgStatus(op, val, CONDITION_AND);
	}

	public void setConditionMsgStatus(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMsgStatus(boolean val) {
		__select_flags[4] = val;
	}

	public void setMsgStatusExpression(String val) {
		__dataExpressions[4] = val;
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

	public void setOperatorExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setCreateTimeExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[7] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[7] = val;
	}


}

