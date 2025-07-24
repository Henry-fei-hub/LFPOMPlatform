package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseOutTempletOption;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class OutTempletOption extends AbstractTable<BaseOutTempletOption>
{

	public OutTempletOption() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "out_templet_options";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseOutTempletOption.CS_OUT_TEMPLET_OPTION_ID;
		__column_names[1] = BaseOutTempletOption.CS_BUSINESS_TYPE;
		__column_names[2] = BaseOutTempletOption.CS_OPTION_TYPE;
		__column_names[3] = BaseOutTempletOption.CS_OPTION_NAME;
		__column_names[4] = BaseOutTempletOption.CS_CREATE_TIME;
		__column_names[5] = BaseOutTempletOption.CS_DISABLE_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseOutTempletOption b) {
		clear();
		setOutTempletOptionIdClear(b.getOutTempletOptionId());
	}

	public boolean isPrimaryKeyNull() {
		return getOutTempletOptionId() == null;
	}

	@Override
	public BaseOutTempletOption generateBase(){
		BaseOutTempletOption b = new BaseOutTempletOption();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseOutTempletOption b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setOutTempletOptionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOptionType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOptionName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDisableType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseOutTempletOption b, Object[] buff){
		int count = 0;
		buff[count++] = b.getOutTempletOptionId();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getOptionType();
		buff[count++] = b.getOptionName();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDisableType();
	}

	@Override
	public void setDataFromBase(BaseOutTempletOption b){
		if(b.getOutTempletOptionId() != null) setOutTempletOptionIdClear(b.getOutTempletOptionId());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getOptionType() != null) setOptionType(b.getOptionType());
		if(b.getOptionName() != null) setOptionName(b.getOptionName());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDisableType() != null) setDisableType(b.getDisableType());
	}

	@Override
	public BaseOutTempletOption generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseOutTempletOption b = new BaseOutTempletOption();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseOutTempletOption __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutTempletOptionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOptionType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOptionName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDisableType(GenericBase.__getInt(val));
	}

	public void setOutTempletOptionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getOutTempletOptionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setOutTempletOptionIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setOptionType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getOptionType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOptionName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getOptionName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setDisableType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDisableType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setConditionOutTempletOptionId(String op, java.lang.Integer val) {
		setConditionOutTempletOptionId(op, val, CONDITION_AND);
	}

	public void setConditionOutTempletOptionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectOutTempletOptionId(boolean val) {
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

	public void setConditionOptionType(String op, java.lang.Integer val) {
		setConditionOptionType(op, val, CONDITION_AND);
	}

	public void setConditionOptionType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectOptionType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOptionName(String op, java.lang.String val) {
		setConditionOptionName(op, val, CONDITION_AND);
	}

	public void setConditionOptionName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOptionName(boolean val) {
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

