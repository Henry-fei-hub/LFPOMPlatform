package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBudgetDetailType;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class BudgetDetailType extends AbstractTable<BaseBudgetDetailType>
{

	public BudgetDetailType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "budget_detail_type";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseBudgetDetailType.CS_BUDGET_DETAIL_TYPE;
		__column_names[1] = BaseBudgetDetailType.CS_BUDGET_DETAIL_TYPE_KEY;
		__column_names[2] = BaseBudgetDetailType.CS_BUDGET_DETAIL_TYPE_VALUE;
		__column_names[3] = BaseBudgetDetailType.CS_IS_ENABLE;
		__column_names[4] = BaseBudgetDetailType.CS_TYPE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseBudgetDetailType b) {
		clear();
		setBudgetDetailTypeClear(b.getBudgetDetailType());
	}

	public boolean isPrimaryKeyNull() {
		return getBudgetDetailType() == null;
	}

	@Override
	public BaseBudgetDetailType generateBase(){
		BaseBudgetDetailType b = new BaseBudgetDetailType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBudgetDetailType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBudgetDetailType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetDetailTypeKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBudgetDetailTypeValue(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsEnable(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setTypeId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseBudgetDetailType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBudgetDetailType();
		buff[count++] = b.getBudgetDetailTypeKey();
		buff[count++] = b.getBudgetDetailTypeValue();
		buff[count++] = b.getIsEnable();
		buff[count++] = b.getTypeId();
	}

	@Override
	public void setDataFromBase(BaseBudgetDetailType b){
		if(b.getBudgetDetailType() != null) setBudgetDetailTypeClear(b.getBudgetDetailType());
		if(b.getBudgetDetailTypeKey() != null) setBudgetDetailTypeKey(b.getBudgetDetailTypeKey());
		if(b.getBudgetDetailTypeValue() != null) setBudgetDetailTypeValue(b.getBudgetDetailTypeValue());
		if(b.getIsEnable() != null) setIsEnable(b.getIsEnable());
		if(b.getTypeId() != null) setTypeId(b.getTypeId());
	}

	@Override
	public BaseBudgetDetailType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBudgetDetailType b = new BaseBudgetDetailType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBudgetDetailType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetDetailType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetDetailTypeKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetDetailTypeValue(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTypeId(GenericBase.__getInt(val));
	}

	public void setBudgetDetailType(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBudgetDetailType() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setBudgetDetailTypeClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBudgetDetailTypeKey(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getBudgetDetailTypeKey() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setBudgetDetailTypeValue(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getBudgetDetailTypeValue() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setIsEnable(java.lang.Boolean val) {
		setCurrentData(3, val);
	}

	public java.lang.Boolean getIsEnable() {
		return GenericBase.__getBoolean(__current_data[3]);
	}

	public void setTypeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getTypeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setConditionBudgetDetailType(String op, java.lang.Integer val) {
		setConditionBudgetDetailType(op, val, CONDITION_AND);
	}

	public void setConditionBudgetDetailType(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBudgetDetailType(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBudgetDetailTypeKey(String op, java.lang.String val) {
		setConditionBudgetDetailTypeKey(op, val, CONDITION_AND);
	}

	public void setConditionBudgetDetailTypeKey(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBudgetDetailTypeKey(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBudgetDetailTypeValue(String op, java.lang.String val) {
		setConditionBudgetDetailTypeValue(op, val, CONDITION_AND);
	}

	public void setConditionBudgetDetailTypeValue(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBudgetDetailTypeValue(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val) {
		setConditionIsEnable(op, val, CONDITION_AND);
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIsEnable(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTypeId(String op, java.lang.Integer val) {
		setConditionTypeId(op, val, CONDITION_AND);
	}

	public void setConditionTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTypeId(boolean val) {
		__select_flags[4] = val;
	}


}

