package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCnLabel;


public class CnLabel extends AbstractTable<BaseCnLabel>
{

	public CnLabel() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "cn_labels";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCnLabel.CS_LABEL_ID;
		__column_names[1] = BaseCnLabel.CS_LABEL_NAME;
		__column_names[2] = BaseCnLabel.CS_ORGANIZATION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCnLabel b) {
		clear();
		setLabelIdClear(b.getLabelId());
	}

	public boolean isPrimaryKeyNull() {
		return getLabelId() == null;
	}

	@Override
	public BaseCnLabel generateBase(){
		BaseCnLabel b = new BaseCnLabel();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCnLabel b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setLabelId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLabelName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOrganizationId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCnLabel b, Object[] buff){
		int count = 0;
		buff[count++] = b.getLabelId();
		buff[count++] = b.getLabelName();
		buff[count++] = b.getOrganizationId();
	}

	@Override
	public void setDataFromBase(BaseCnLabel b){
		if(b.getLabelId() != null) setLabelIdClear(b.getLabelId());
		if(b.getLabelName() != null) setLabelName(b.getLabelName());
		if(b.getOrganizationId() != null) setOrganizationId(b.getOrganizationId());
	}

	@Override
	public BaseCnLabel generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCnLabel b = new BaseCnLabel();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCnLabel __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLabelId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLabelName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrganizationId(GenericBase.__getInt(val));
	}

	public void setLabelId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getLabelId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setLabelIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setLabelName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getLabelName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setOrganizationId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getOrganizationId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setConditionLabelId(String op, java.lang.Integer val) {
		setConditionLabelId(op, val, CONDITION_AND);
	}

	public void setConditionLabelId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectLabelId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionLabelName(String op, java.lang.String val) {
		setConditionLabelName(op, val, CONDITION_AND);
	}

	public void setConditionLabelName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectLabelName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val) {
		setConditionOrganizationId(op, val, CONDITION_AND);
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectOrganizationId(boolean val) {
		__select_flags[2] = val;
	}


}

