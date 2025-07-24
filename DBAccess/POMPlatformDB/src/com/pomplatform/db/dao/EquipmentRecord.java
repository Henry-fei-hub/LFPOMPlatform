package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseEquipmentRecord;


public class EquipmentRecord extends AbstractTable<BaseEquipmentRecord>
{

	public EquipmentRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "equipment_records";

		__key_columns          = new int[0];

		__column_names[0] = BaseEquipmentRecord.CS_OPERATION_TYPE;
		__column_names[1] = BaseEquipmentRecord.CS_COUNT;
		__column_names[2] = BaseEquipmentRecord.CS_FOLLOW_STATUS;
		__column_names[3] = BaseEquipmentRecord.CS_OPERATION_PERSON;
		__column_names[4] = BaseEquipmentRecord.CS_OPERATION_TIME;
		__column_names[5] = BaseEquipmentRecord.CS_EQUIPMENT_ID;
		__column_names[6] = BaseEquipmentRecord.CS_FOLLOW_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
	}

	public void setPrimaryKeyFromBase(BaseEquipmentRecord b) {
		clear();
	}

	public boolean isPrimaryKeyNull() {
		return true;
	}

	@Override
	public BaseEquipmentRecord generateBase(){
		BaseEquipmentRecord b = new BaseEquipmentRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEquipmentRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setOperationType(GenericBase.__getShort(val));
		if((val = __current_data[count++]) != null) b.setCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFollowStatus(GenericBase.__getShort(val));
		if((val = __current_data[count++]) != null) b.setOperationPerson(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperationTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEquipmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFollowId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setOperationType(GenericBase.__getShort(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCount(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFollowStatus(GenericBase.__getShort(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperationPerson(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperationTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEquipmentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFollowId(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseEquipmentRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getOperationType();
		buff[count++] = b.getCount();
		buff[count++] = b.getFollowStatus();
		buff[count++] = b.getOperationPerson();
		buff[count++] = generateTimestampFromDate(b.getOperationTime());
		buff[count++] = b.getEquipmentId();
		buff[count++] = b.getFollowId();
	}

	@Override
	public void setDataFromBase(BaseEquipmentRecord b){
		if(b.getOperationType() != null) setOperationType(b.getOperationType());
		if(b.getCount() != null) setCount(b.getCount());
		if(b.getFollowStatus() != null) setFollowStatus(b.getFollowStatus());
		if(b.getOperationPerson() != null) setOperationPerson(b.getOperationPerson());
		if(b.getOperationTime() != null) setOperationTime(b.getOperationTime());
		if(b.getEquipmentId() != null) setEquipmentId(b.getEquipmentId());
		if(b.getFollowId() != null) setFollowId(b.getFollowId());
	}

	@Override
	public BaseEquipmentRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEquipmentRecord b = new BaseEquipmentRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEquipmentRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperationType(GenericBase.__getShort(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFollowStatus(GenericBase.__getShort(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperationPerson(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperationTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEquipmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFollowId(GenericBase.__getInt(val));
	}

	public void setOperationType(java.lang.Short val) {
		setCurrentData(0, val);
	}

	public java.lang.Short getOperationType() {
		return GenericBase.__getShort(__current_data[0]);
	}

	public void setCount(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCount() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setFollowStatus(java.lang.Short val) {
		setCurrentData(2, val);
	}

	public java.lang.Short getFollowStatus() {
		return GenericBase.__getShort(__current_data[2]);
	}

	public void setOperationPerson(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOperationPerson() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setOperationTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getOperationTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setEquipmentId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getEquipmentId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setFollowId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getFollowId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setConditionOperationType(String op, java.lang.Short val) {
		setConditionOperationType(op, val, CONDITION_AND);
	}

	public void setConditionOperationType(String op, java.lang.Short val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectOperationType(boolean val) {
		__select_flags[0] = val;
	}

	public void setOperationTypeExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionCount(String op, java.lang.Integer val) {
		setConditionCount(op, val, CONDITION_AND);
	}

	public void setConditionCount(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCount(boolean val) {
		__select_flags[1] = val;
	}

	public void setCountExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionFollowStatus(String op, java.lang.Short val) {
		setConditionFollowStatus(op, val, CONDITION_AND);
	}

	public void setConditionFollowStatus(String op, java.lang.Short val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFollowStatus(boolean val) {
		__select_flags[2] = val;
	}

	public void setFollowStatusExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionOperationPerson(String op, java.lang.Integer val) {
		setConditionOperationPerson(op, val, CONDITION_AND);
	}

	public void setConditionOperationPerson(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOperationPerson(boolean val) {
		__select_flags[3] = val;
	}

	public void setOperationPersonExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionOperationTime(String op, java.util.Date val) {
		setConditionOperationTime(op, val, CONDITION_AND);
	}

	public void setConditionOperationTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperationTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setOperationTimeExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionEquipmentId(String op, java.lang.Integer val) {
		setConditionEquipmentId(op, val, CONDITION_AND);
	}

	public void setConditionEquipmentId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectEquipmentId(boolean val) {
		__select_flags[5] = val;
	}

	public void setEquipmentIdExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionFollowId(String op, java.lang.Integer val) {
		setConditionFollowId(op, val, CONDITION_AND);
	}

	public void setConditionFollowId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectFollowId(boolean val) {
		__select_flags[6] = val;
	}

	public void setFollowIdExpression(String val) {
		__dataExpressions[6] = val;
	}


}

