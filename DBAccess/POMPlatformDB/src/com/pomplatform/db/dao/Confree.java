package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseConfree;


public class Confree extends AbstractTable<BaseConfree>
{

	public Confree() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "confrees";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseConfree.CS_CONFEREE_ID;
		__column_names[1] = BaseConfree.CS_MEETING_RELEVANCE_ID;
		__column_names[2] = BaseConfree.CS_EMPLOYEE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseConfree b) {
		clear();
		setConfereeIdClear(b.getConfereeId());
	}

	public boolean isPrimaryKeyNull() {
		return getConfereeId() == null;
	}

	@Override
	public BaseConfree generateBase(){
		BaseConfree b = new BaseConfree();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseConfree b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setConfereeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRelevanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setConfereeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRelevanceId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseConfree b, Object[] buff){
		int count = 0;
		buff[count++] = b.getConfereeId();
		buff[count++] = b.getMeetingRelevanceId();
		buff[count++] = b.getEmployeeId();
	}

	@Override
	public void setDataFromBase(BaseConfree b){
		if(b.getConfereeId() != null) setConfereeIdClear(b.getConfereeId());
		if(b.getMeetingRelevanceId() != null) setMeetingRelevanceId(b.getMeetingRelevanceId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
	}

	@Override
	public BaseConfree generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseConfree b = new BaseConfree();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseConfree __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setConfereeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRelevanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
	}

	public void setConfereeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getConfereeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setConfereeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMeetingRelevanceId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMeetingRelevanceId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setConditionConfereeId(String op, java.lang.Integer val) {
		setConditionConfereeId(op, val, CONDITION_AND);
	}

	public void setConditionConfereeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectConfereeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConfereeIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionMeetingRelevanceId(String op, java.lang.Integer val) {
		setConditionMeetingRelevanceId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRelevanceId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMeetingRelevanceId(boolean val) {
		__select_flags[1] = val;
	}

	public void setMeetingRelevanceIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[2] = val;
	}


}

