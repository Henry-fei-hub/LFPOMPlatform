package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCnResourceKeyword;


public class CnResourceKeyword extends AbstractTable<BaseCnResourceKeyword>
{

	public CnResourceKeyword() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "cn_resource_keywords";

		__key_columns          = new int[0];

		__column_names[0] = BaseCnResourceKeyword.CS_RESOURCE_KEYWORD_ID;
		__column_names[1] = BaseCnResourceKeyword.CS_KEY_NAME;
		__column_names[2] = BaseCnResourceKeyword.CS_RESOURCE_ID;
		__column_names[3] = BaseCnResourceKeyword.CS_CREATE_TIME;
		__column_names[4] = BaseCnResourceKeyword.CS_ORGANIZATION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCnResourceKeyword b) {
		clear();
	}

	public boolean isPrimaryKeyNull() {
		return true;
	}

	@Override
	public BaseCnResourceKeyword generateBase(){
		BaseCnResourceKeyword b = new BaseCnResourceKeyword();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCnResourceKeyword b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setResourceKeywordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setKeyName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setResourceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOrganizationId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCnResourceKeyword b, Object[] buff){
		int count = 0;
		buff[count++] = b.getResourceKeywordId();
		buff[count++] = b.getKeyName();
		buff[count++] = b.getResourceId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getOrganizationId();
	}

	@Override
	public void setDataFromBase(BaseCnResourceKeyword b){
		if(b.getResourceKeywordId() != null) setResourceKeywordId(b.getResourceKeywordId());
		if(b.getKeyName() != null) setKeyName(b.getKeyName());
		if(b.getResourceId() != null) setResourceId(b.getResourceId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getOrganizationId() != null) setOrganizationId(b.getOrganizationId());
	}

	@Override
	public BaseCnResourceKeyword generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCnResourceKeyword b = new BaseCnResourceKeyword();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCnResourceKeyword __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceKeywordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setKeyName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrganizationId(GenericBase.__getInt(val));
	}

	public void setResourceKeywordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getResourceKeywordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setKeyName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getKeyName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setResourceId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getResourceId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setOrganizationId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOrganizationId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setConditionResourceKeywordId(String op, java.lang.Integer val) {
		setConditionResourceKeywordId(op, val, CONDITION_AND);
	}

	public void setConditionResourceKeywordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectResourceKeywordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionKeyName(String op, java.lang.String val) {
		setConditionKeyName(op, val, CONDITION_AND);
	}

	public void setConditionKeyName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectKeyName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionResourceId(String op, java.lang.Integer val) {
		setConditionResourceId(op, val, CONDITION_AND);
	}

	public void setConditionResourceId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectResourceId(boolean val) {
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

	public void setConditionOrganizationId(String op, java.lang.Integer val) {
		setConditionOrganizationId(op, val, CONDITION_AND);
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOrganizationId(boolean val) {
		__select_flags[4] = val;
	}


}

