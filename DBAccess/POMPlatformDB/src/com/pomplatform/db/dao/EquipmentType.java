package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseEquipmentType;


public class EquipmentType extends AbstractTable<BaseEquipmentType>
{

	public EquipmentType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "equipment_types";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEquipmentType.CS_EQUIPMENT_TYPE_ID;
		__column_names[1] = BaseEquipmentType.CS_NAME;
		__column_names[2] = BaseEquipmentType.CS_ENABLED;
		__column_names[3] = BaseEquipmentType.CS_PRICE;
		__column_names[4] = BaseEquipmentType.CS_TYPE;
		__column_names[5] = BaseEquipmentType.CS_UPDATE_TIME;
		__column_names[6] = BaseEquipmentType.CS_UPDATE_PERSON;
		__column_names[7] = BaseEquipmentType.CS_COUNT;
		__column_names[8] = BaseEquipmentType.CS_IS_DELETE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEquipmentType b) {
		clear();
		setEquipmentTypeIdClear(b.getEquipmentTypeId());
	}

	public boolean isPrimaryKeyNull() {
		return getEquipmentTypeId() == null;
	}

	@Override
	public BaseEquipmentType generateBase(){
		BaseEquipmentType b = new BaseEquipmentType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEquipmentType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEquipmentTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEnabled(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdatePerson(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsDelete(GenericBase.__getBoolean(val));
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
			if(val != null && !val.isEmpty()) setEquipmentTypeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEnabled(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPrice(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setUpdateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setUpdatePerson(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCount(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsDelete(GenericBase.__getBoolean(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseEquipmentType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEquipmentTypeId();
		buff[count++] = b.getName();
		buff[count++] = b.getEnabled();
		buff[count++] = b.getPrice();
		buff[count++] = b.getType();
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getUpdatePerson();
		buff[count++] = b.getCount();
		buff[count++] = b.getIsDelete();
	}

	@Override
	public void setDataFromBase(BaseEquipmentType b){
		if(b.getEquipmentTypeId() != null) setEquipmentTypeIdClear(b.getEquipmentTypeId());
		if(b.getName() != null) setName(b.getName());
		if(b.getEnabled() != null) setEnabled(b.getEnabled());
		if(b.getPrice() != null) setPrice(b.getPrice());
		if(b.getType() != null) setType(b.getType());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getUpdatePerson() != null) setUpdatePerson(b.getUpdatePerson());
		if(b.getCount() != null) setCount(b.getCount());
		if(b.getIsDelete() != null) setIsDelete(b.getIsDelete());
	}

	@Override
	public BaseEquipmentType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEquipmentType b = new BaseEquipmentType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEquipmentType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEquipmentTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEnabled(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdatePerson(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsDelete(GenericBase.__getBoolean(val));
	}

	public void setEquipmentTypeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEquipmentTypeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEquipmentTypeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setEnabled(java.lang.Boolean val) {
		setCurrentData(2, val);
	}

	public java.lang.Boolean getEnabled() {
		return GenericBase.__getBoolean(__current_data[2]);
	}

	public void setPrice(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getPrice() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setUpdatePerson(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getUpdatePerson() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCount(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getCount() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setIsDelete(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getIsDelete() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setConditionEquipmentTypeId(String op, java.lang.Integer val) {
		setConditionEquipmentTypeId(op, val, CONDITION_AND);
	}

	public void setConditionEquipmentTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEquipmentTypeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setEquipmentTypeIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[1] = val;
	}

	public void setNameExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionEnabled(String op, java.lang.Boolean val) {
		setConditionEnabled(op, val, CONDITION_AND);
	}

	public void setConditionEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEnabled(boolean val) {
		__select_flags[2] = val;
	}

	public void setEnabledExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionPrice(String op, java.math.BigDecimal val) {
		setConditionPrice(op, val, CONDITION_AND);
	}

	public void setConditionPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPrice(boolean val) {
		__select_flags[3] = val;
	}

	public void setPriceExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[4] = val;
	}

	public void setTypeExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setUpdateTimeExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionUpdatePerson(String op, java.lang.Integer val) {
		setConditionUpdatePerson(op, val, CONDITION_AND);
	}

	public void setConditionUpdatePerson(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectUpdatePerson(boolean val) {
		__select_flags[6] = val;
	}

	public void setUpdatePersonExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionCount(String op, java.lang.Integer val) {
		setConditionCount(op, val, CONDITION_AND);
	}

	public void setConditionCount(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCount(boolean val) {
		__select_flags[7] = val;
	}

	public void setCountExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionIsDelete(String op, java.lang.Boolean val) {
		setConditionIsDelete(op, val, CONDITION_AND);
	}

	public void setConditionIsDelete(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIsDelete(boolean val) {
		__select_flags[8] = val;
	}

	public void setIsDeleteExpression(String val) {
		__dataExpressions[8] = val;
	}


}

