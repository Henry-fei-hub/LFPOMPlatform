package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseTableMaintain;


public class TableMaintain extends AbstractTable<BaseTableMaintain>
{

	public TableMaintain() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "table_maintains";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTableMaintain.CS_TABLE_MAINTAIN_ID;
		__column_names[1] = BaseTableMaintain.CS_TABLE_NAME;
		__column_names[2] = BaseTableMaintain.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTableMaintain b) {
		clear();
		setTableMaintainIdClear(b.getTableMaintainId());
	}

	public boolean isPrimaryKeyNull() {
		return getTableMaintainId() == null;
	}

	@Override
	public BaseTableMaintain generateBase(){
		BaseTableMaintain b = new BaseTableMaintain();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTableMaintain b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTableMaintainId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTableName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
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
			if(val != null && !val.isEmpty()) setTableMaintainId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTableName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseTableMaintain b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTableMaintainId();
		buff[count++] = b.getTableName();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseTableMaintain b){
		if(b.getTableMaintainId() != null) setTableMaintainIdClear(b.getTableMaintainId());
		if(b.getTableName() != null) setTableName(b.getTableName());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseTableMaintain generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTableMaintain b = new BaseTableMaintain();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTableMaintain __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTableMaintainId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTableName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setTableMaintainId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTableMaintainId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTableMaintainIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTableName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getTableName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setConditionTableMaintainId(String op, java.lang.Integer val) {
		setConditionTableMaintainId(op, val, CONDITION_AND);
	}

	public void setConditionTableMaintainId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTableMaintainId(boolean val) {
		__select_flags[0] = val;
	}

	public void setTableMaintainIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionTableName(String op, java.lang.String val) {
		setConditionTableName(op, val, CONDITION_AND);
	}

	public void setConditionTableName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectTableName(boolean val) {
		__select_flags[1] = val;
	}

	public void setTableNameExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[2] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[2] = val;
	}


}

