package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCnLabelDetailed;


public class CnLabelDetailed extends AbstractTable<BaseCnLabelDetailed>
{

	public CnLabelDetailed() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "cn_label_detaileds";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCnLabelDetailed.CS_LABEL_DETAILED_ID;
		__column_names[1] = BaseCnLabelDetailed.CS_USER_ID;
		__column_names[2] = BaseCnLabelDetailed.CS_LABEL_ID;
		__column_names[3] = BaseCnLabelDetailed.CS_ORGANIZATION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCnLabelDetailed b) {
		clear();
		setLabelDetailedIdClear(b.getLabelDetailedId());
	}

	public boolean isPrimaryKeyNull() {
		return getLabelDetailedId() == null;
	}

	@Override
	public BaseCnLabelDetailed generateBase(){
		BaseCnLabelDetailed b = new BaseCnLabelDetailed();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCnLabelDetailed b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setLabelDetailedId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUserId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLabelId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrganizationId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCnLabelDetailed b, Object[] buff){
		int count = 0;
		buff[count++] = b.getLabelDetailedId();
		buff[count++] = b.getUserId();
		buff[count++] = b.getLabelId();
		buff[count++] = b.getOrganizationId();
	}

	@Override
	public void setDataFromBase(BaseCnLabelDetailed b){
		if(b.getLabelDetailedId() != null) setLabelDetailedIdClear(b.getLabelDetailedId());
		if(b.getUserId() != null) setUserId(b.getUserId());
		if(b.getLabelId() != null) setLabelId(b.getLabelId());
		if(b.getOrganizationId() != null) setOrganizationId(b.getOrganizationId());
	}

	@Override
	public BaseCnLabelDetailed generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCnLabelDetailed b = new BaseCnLabelDetailed();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCnLabelDetailed __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLabelDetailedId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUserId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLabelId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrganizationId(GenericBase.__getInt(val));
	}

	public void setLabelDetailedId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getLabelDetailedId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setLabelDetailedIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setUserId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getUserId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setLabelId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getLabelId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOrganizationId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOrganizationId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setConditionLabelDetailedId(String op, java.lang.Integer val) {
		setConditionLabelDetailedId(op, val, CONDITION_AND);
	}

	public void setConditionLabelDetailedId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectLabelDetailedId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionUserId(String op, java.lang.Integer val) {
		setConditionUserId(op, val, CONDITION_AND);
	}

	public void setConditionUserId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectUserId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionLabelId(String op, java.lang.Integer val) {
		setConditionLabelId(op, val, CONDITION_AND);
	}

	public void setConditionLabelId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectLabelId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val) {
		setConditionOrganizationId(op, val, CONDITION_AND);
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOrganizationId(boolean val) {
		__select_flags[3] = val;
	}


}

