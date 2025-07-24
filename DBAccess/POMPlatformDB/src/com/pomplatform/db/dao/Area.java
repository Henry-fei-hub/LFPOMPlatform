package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseArea;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Area extends AbstractTable<BaseArea>
{

	public Area() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "areas";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseArea.CS_AREA_ID;
		__column_names[1] = BaseArea.CS_AREA_NAME;
		__column_names[2] = BaseArea.CS_AREA_NAME_EN;
		__column_names[3] = BaseArea.CS_PARENT_ID;
		__column_names[4] = BaseArea.CS_ALL_NAME;
		__column_names[5] = BaseArea.CS_AREA_LEVEL;
		__column_names[6] = BaseArea.CS_REGION;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseArea b) {
		clear();
		setAreaIdClear(b.getAreaId());
	}

	public boolean isPrimaryKeyNull() {
		return getAreaId() == null;
	}

	@Override
	public BaseArea generateBase(){
		BaseArea b = new BaseArea();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseArea b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAreaId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAreaName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAreaNameEn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAllName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAreaLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRegion(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseArea b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAreaId();
		buff[count++] = b.getAreaName();
		buff[count++] = b.getAreaNameEn();
		buff[count++] = b.getParentId();
		buff[count++] = b.getAllName();
		buff[count++] = b.getAreaLevel();
		buff[count++] = b.getRegion();
	}

	@Override
	public void setDataFromBase(BaseArea b){
		if(b.getAreaId() != null) setAreaIdClear(b.getAreaId());
		if(b.getAreaName() != null) setAreaName(b.getAreaName());
		if(b.getAreaNameEn() != null) setAreaNameEn(b.getAreaNameEn());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getAllName() != null) setAllName(b.getAllName());
		if(b.getAreaLevel() != null) setAreaLevel(b.getAreaLevel());
		if(b.getRegion() != null) setRegion(b.getRegion());
	}

	@Override
	public BaseArea generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseArea b = new BaseArea();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseArea __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaNameEn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAllName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegion(GenericBase.__getInt(val));
	}

	public void setAreaId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAreaId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAreaIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAreaName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getAreaName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setAreaNameEn(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getAreaNameEn() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setAllName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getAllName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setAreaLevel(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getAreaLevel() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setRegion(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getRegion() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setConditionAreaId(String op, java.lang.Integer val) {
		setConditionAreaId(op, val, CONDITION_AND);
	}

	public void setConditionAreaId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAreaId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionAreaName(String op, java.lang.String val) {
		setConditionAreaName(op, val, CONDITION_AND);
	}

	public void setConditionAreaName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectAreaName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAreaNameEn(String op, java.lang.String val) {
		setConditionAreaNameEn(op, val, CONDITION_AND);
	}

	public void setConditionAreaNameEn(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAreaNameEn(boolean val) {
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

	public void setConditionAllName(String op, java.lang.String val) {
		setConditionAllName(op, val, CONDITION_AND);
	}

	public void setConditionAllName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAllName(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAreaLevel(String op, java.lang.Integer val) {
		setConditionAreaLevel(op, val, CONDITION_AND);
	}

	public void setConditionAreaLevel(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAreaLevel(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRegion(String op, java.lang.Integer val) {
		setConditionRegion(op, val, CONDITION_AND);
	}

	public void setConditionRegion(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRegion(boolean val) {
		__select_flags[6] = val;
	}


}

