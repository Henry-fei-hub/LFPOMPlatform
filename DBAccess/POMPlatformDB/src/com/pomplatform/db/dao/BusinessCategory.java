package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBusinessCategory;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class BusinessCategory extends AbstractTable<BaseBusinessCategory>
{

	public BusinessCategory() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "business_category";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseBusinessCategory.CS_BUSINESS_CATEGORY_ID;
		__column_names[1] = BaseBusinessCategory.CS_BUSINESS_CATEGORY_NAME;
		__column_names[2] = BaseBusinessCategory.CS_BUSINESS_CATEGORY_CODE;
		__column_names[3] = BaseBusinessCategory.CS_PARENT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseBusinessCategory b) {
		clear();
		setBusinessCategoryIdClear(b.getBusinessCategoryId());
	}

	public boolean isPrimaryKeyNull() {
		return getBusinessCategoryId() == null;
	}

	@Override
	public BaseBusinessCategory generateBase(){
		BaseBusinessCategory b = new BaseBusinessCategory();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBusinessCategory b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBusinessCategoryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessCategoryName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessCategoryCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseBusinessCategory b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBusinessCategoryId();
		buff[count++] = b.getBusinessCategoryName();
		buff[count++] = b.getBusinessCategoryCode();
		buff[count++] = b.getParentId();
	}

	@Override
	public void setDataFromBase(BaseBusinessCategory b){
		if(b.getBusinessCategoryId() != null) setBusinessCategoryIdClear(b.getBusinessCategoryId());
		if(b.getBusinessCategoryName() != null) setBusinessCategoryName(b.getBusinessCategoryName());
		if(b.getBusinessCategoryCode() != null) setBusinessCategoryCode(b.getBusinessCategoryCode());
		if(b.getParentId() != null) setParentId(b.getParentId());
	}

	@Override
	public BaseBusinessCategory generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBusinessCategory b = new BaseBusinessCategory();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBusinessCategory __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessCategoryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessCategoryName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessCategoryCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
	}

	public void setBusinessCategoryId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBusinessCategoryId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setBusinessCategoryIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBusinessCategoryName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getBusinessCategoryName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setBusinessCategoryCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getBusinessCategoryCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setConditionBusinessCategoryId(String op, java.lang.Integer val) {
		setConditionBusinessCategoryId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessCategoryId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBusinessCategoryId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBusinessCategoryName(String op, java.lang.String val) {
		setConditionBusinessCategoryName(op, val, CONDITION_AND);
	}

	public void setConditionBusinessCategoryName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBusinessCategoryName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBusinessCategoryCode(String op, java.lang.String val) {
		setConditionBusinessCategoryCode(op, val, CONDITION_AND);
	}

	public void setConditionBusinessCategoryCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessCategoryCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[3] = val;
	}


}

