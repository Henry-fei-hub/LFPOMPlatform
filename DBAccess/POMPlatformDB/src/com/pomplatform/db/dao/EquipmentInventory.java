package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEquipmentInventory;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EquipmentInventory extends AbstractTable<BaseEquipmentInventory>
{

	public EquipmentInventory() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "equipment_inventories";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEquipmentInventory.CS_EQUIPMENT_INVENTORY_ID;
		__column_names[1] = BaseEquipmentInventory.CS_TYPE;
		__column_names[2] = BaseEquipmentInventory.CS_NAME;
		__column_names[3] = BaseEquipmentInventory.CS_CODE;
		__column_names[4] = BaseEquipmentInventory.CS_PRICE;
		__column_names[5] = BaseEquipmentInventory.CS_AMOUNT;
		__column_names[6] = BaseEquipmentInventory.CS_STATUS;
		__column_names[7] = BaseEquipmentInventory.CS_INPUT_DATE;
		__column_names[8] = BaseEquipmentInventory.CS_PULL_DATE;
		__column_names[9] = BaseEquipmentInventory.CS_REMARK;
		__column_names[10] = BaseEquipmentInventory.CS_CREATE_TIME;
		__column_names[11] = BaseEquipmentInventory.CS_UPDATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEquipmentInventory b) {
		clear();
		setEquipmentInventoryIdClear(b.getEquipmentInventoryId());
	}

	public boolean isPrimaryKeyNull() {
		return getEquipmentInventoryId() == null;
	}

	@Override
	public BaseEquipmentInventory generateBase(){
		BaseEquipmentInventory b = new BaseEquipmentInventory();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEquipmentInventory b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEquipmentInventoryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInputDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPullDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseEquipmentInventory b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEquipmentInventoryId();
		buff[count++] = b.getType();
		buff[count++] = b.getName();
		buff[count++] = b.getCode();
		buff[count++] = b.getPrice();
		buff[count++] = b.getAmount();
		buff[count++] = b.getStatus();
		buff[count++] = generateTimestampFromDate(b.getInputDate());
		buff[count++] = generateTimestampFromDate(b.getPullDate());
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
	}

	@Override
	public void setDataFromBase(BaseEquipmentInventory b){
		if(b.getEquipmentInventoryId() != null) setEquipmentInventoryIdClear(b.getEquipmentInventoryId());
		if(b.getType() != null) setType(b.getType());
		if(b.getName() != null) setName(b.getName());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getPrice() != null) setPrice(b.getPrice());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getInputDate() != null) setInputDate(b.getInputDate());
		if(b.getPullDate() != null) setPullDate(b.getPullDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
	}

	@Override
	public BaseEquipmentInventory generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEquipmentInventory b = new BaseEquipmentInventory();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEquipmentInventory __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEquipmentInventoryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPullDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setEquipmentInventoryId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEquipmentInventoryId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEquipmentInventoryIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setPrice(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getPrice() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setAmount(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getAmount() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setInputDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getInputDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setPullDate(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getPullDate() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setConditionEquipmentInventoryId(String op, java.lang.Integer val) {
		setConditionEquipmentInventoryId(op, val, CONDITION_AND);
	}

	public void setConditionEquipmentInventoryId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEquipmentInventoryId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPrice(String op, java.math.BigDecimal val) {
		setConditionPrice(op, val, CONDITION_AND);
	}

	public void setConditionPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPrice(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAmount(String op, java.lang.Integer val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionInputDate(String op, java.util.Date val) {
		setConditionInputDate(op, val, CONDITION_AND);
	}

	public void setConditionInputDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectInputDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionPullDate(String op, java.util.Date val) {
		setConditionPullDate(op, val, CONDITION_AND);
	}

	public void setConditionPullDate(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPullDate(boolean val) {
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

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[11] = val;
	}


}

