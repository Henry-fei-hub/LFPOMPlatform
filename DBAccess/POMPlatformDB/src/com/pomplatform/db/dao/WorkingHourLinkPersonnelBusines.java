package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseWorkingHourLinkPersonnelBusines;


public class WorkingHourLinkPersonnelBusines extends AbstractTable<BaseWorkingHourLinkPersonnelBusines>
{

	public WorkingHourLinkPersonnelBusines() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "working_hour_link_personnel_business";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseWorkingHourLinkPersonnelBusines.CS_WORKING_HOUR_LINK_PERSONNEL_BUSINESS_ID;
		__column_names[1] = BaseWorkingHourLinkPersonnelBusines.CS_PERSONNEL_BUSINESS_ID;
		__column_names[2] = BaseWorkingHourLinkPersonnelBusines.CS_PROJECT_ID;
		__column_names[3] = BaseWorkingHourLinkPersonnelBusines.CS_WORK_HOUR;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseWorkingHourLinkPersonnelBusines b) {
		clear();
		setWorkingHourLinkPersonnelBusinessIdClear(b.getWorkingHourLinkPersonnelBusinessId());
	}

	public boolean isPrimaryKeyNull() {
		return getWorkingHourLinkPersonnelBusinessId() == null;
	}

	@Override
	public BaseWorkingHourLinkPersonnelBusines generateBase(){
		BaseWorkingHourLinkPersonnelBusines b = new BaseWorkingHourLinkPersonnelBusines();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseWorkingHourLinkPersonnelBusines b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setWorkingHourLinkPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkHour(GenericBase.__getDecimal(val));
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
			if(val != null && !val.isEmpty()) setWorkingHourLinkPersonnelBusinessId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPersonnelBusinessId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setWorkHour(GenericBase.__getDecimal(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseWorkingHourLinkPersonnelBusines b, Object[] buff){
		int count = 0;
		buff[count++] = b.getWorkingHourLinkPersonnelBusinessId();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getWorkHour();
	}

	@Override
	public void setDataFromBase(BaseWorkingHourLinkPersonnelBusines b){
		if(b.getWorkingHourLinkPersonnelBusinessId() != null) setWorkingHourLinkPersonnelBusinessIdClear(b.getWorkingHourLinkPersonnelBusinessId());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getWorkHour() != null) setWorkHour(b.getWorkHour());
	}

	@Override
	public BaseWorkingHourLinkPersonnelBusines generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseWorkingHourLinkPersonnelBusines b = new BaseWorkingHourLinkPersonnelBusines();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseWorkingHourLinkPersonnelBusines __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkingHourLinkPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkHour(GenericBase.__getDecimal(val));
	}

	public void setWorkingHourLinkPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getWorkingHourLinkPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setWorkingHourLinkPersonnelBusinessIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setWorkHour(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getWorkHour() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setConditionWorkingHourLinkPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionWorkingHourLinkPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionWorkingHourLinkPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectWorkingHourLinkPersonnelBusinessId(boolean val) {
		__select_flags[0] = val;
	}

	public void setWorkingHourLinkPersonnelBusinessIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[1] = val;
	}

	public void setPersonnelBusinessIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setProjectIdExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionWorkHour(String op, java.math.BigDecimal val) {
		setConditionWorkHour(op, val, CONDITION_AND);
	}

	public void setConditionWorkHour(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectWorkHour(boolean val) {
		__select_flags[3] = val;
	}

	public void setWorkHourExpression(String val) {
		__dataExpressions[3] = val;
	}


}

