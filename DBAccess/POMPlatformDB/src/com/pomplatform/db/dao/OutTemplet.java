package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseOutTemplet;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class OutTemplet extends AbstractTable<BaseOutTemplet>
{

	public OutTemplet() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "out_templets";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseOutTemplet.CS_OUT_TEMPLET_ID;
		__column_names[1] = BaseOutTemplet.CS_BUSINESS_TYPE;
		__column_names[2] = BaseOutTemplet.CS_TEMPLET_NAME;
		__column_names[3] = BaseOutTemplet.CS_CREATE_TIME;
		__column_names[4] = BaseOutTemplet.CS_DEFAULT_TEMPLET;
		__column_names[5] = BaseOutTemplet.CS_DISABLE_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseOutTemplet b) {
		clear();
		setOutTempletIdClear(b.getOutTempletId());
	}

	public boolean isPrimaryKeyNull() {
		return getOutTempletId() == null;
	}

	@Override
	public BaseOutTemplet generateBase(){
		BaseOutTemplet b = new BaseOutTemplet();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseOutTemplet b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setOutTempletId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTempletName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDefaultTemplet(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDisableType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseOutTemplet b, Object[] buff){
		int count = 0;
		buff[count++] = b.getOutTempletId();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getTempletName();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDefaultTemplet();
		buff[count++] = b.getDisableType();
	}

	@Override
	public void setDataFromBase(BaseOutTemplet b){
		if(b.getOutTempletId() != null) setOutTempletIdClear(b.getOutTempletId());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getTempletName() != null) setTempletName(b.getTempletName());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDefaultTemplet() != null) setDefaultTemplet(b.getDefaultTemplet());
		if(b.getDisableType() != null) setDisableType(b.getDisableType());
	}

	@Override
	public BaseOutTemplet generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseOutTemplet b = new BaseOutTemplet();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseOutTemplet __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutTempletId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTempletName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDefaultTemplet(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDisableType(GenericBase.__getInt(val));
	}

	public void setOutTempletId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getOutTempletId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setOutTempletIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setTempletName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getTempletName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setDefaultTemplet(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getDefaultTemplet() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setDisableType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDisableType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setConditionOutTempletId(String op, java.lang.Integer val) {
		setConditionOutTempletId(op, val, CONDITION_AND);
	}

	public void setConditionOutTempletId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectOutTempletId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionTempletName(String op, java.lang.String val) {
		setConditionTempletName(op, val, CONDITION_AND);
	}

	public void setConditionTempletName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTempletName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDefaultTemplet(String op, java.lang.Integer val) {
		setConditionDefaultTemplet(op, val, CONDITION_AND);
	}

	public void setConditionDefaultTemplet(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDefaultTemplet(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDisableType(String op, java.lang.Integer val) {
		setConditionDisableType(op, val, CONDITION_AND);
	}

	public void setConditionDisableType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDisableType(boolean val) {
		__select_flags[5] = val;
	}


}

