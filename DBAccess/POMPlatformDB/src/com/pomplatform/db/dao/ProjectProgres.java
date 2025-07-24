package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectProgres;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectProgres extends AbstractTable<BaseProjectProgres>
{

	public ProjectProgres() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "project_progress";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectProgres.CS_PROJECT_PROGRESS_ID;
		__column_names[1] = BaseProjectProgres.CS_PROJECT_ID;
		__column_names[2] = BaseProjectProgres.CS_PROJECT_MANAGE_ID;
		__column_names[3] = BaseProjectProgres.CS_DESIGN_PHASE;
		__column_names[4] = BaseProjectProgres.CS_FINISH_DATE;
		__column_names[5] = BaseProjectProgres.CS_ALTERNATE_FIELD1;
		__column_names[6] = BaseProjectProgres.CS_ALTERNATE_FIELD2;
		__column_names[7] = BaseProjectProgres.CS_ALTERNATE_FIELD3;
		__column_names[8] = BaseProjectProgres.CS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectProgres b) {
		clear();
		setProjectProgressIdClear(b.getProjectProgressId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectProgressId() == null;
	}

	@Override
	public BaseProjectProgres generateBase(){
		BaseProjectProgres b = new BaseProjectProgres();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectProgres b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectProgressId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDesignPhase(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFinishDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAlternateField1(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAlternateField2(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAlternateField3(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectProgres b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectProgressId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getProjectManageId();
		buff[count++] = b.getDesignPhase();
		buff[count++] = generateTimestampFromDate(b.getFinishDate());
		buff[count++] = b.getAlternateField1();
		buff[count++] = b.getAlternateField2();
		buff[count++] = b.getAlternateField3();
		buff[count++] = b.getStatus();
	}

	@Override
	public void setDataFromBase(BaseProjectProgres b){
		if(b.getProjectProgressId() != null) setProjectProgressIdClear(b.getProjectProgressId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getProjectManageId() != null) setProjectManageId(b.getProjectManageId());
		if(b.getDesignPhase() != null) setDesignPhase(b.getDesignPhase());
		if(b.getFinishDate() != null) setFinishDate(b.getFinishDate());
		if(b.getAlternateField1() != null) setAlternateField1(b.getAlternateField1());
		if(b.getAlternateField2() != null) setAlternateField2(b.getAlternateField2());
		if(b.getAlternateField3() != null) setAlternateField3(b.getAlternateField3());
		if(b.getStatus() != null) setStatus(b.getStatus());
	}

	@Override
	public BaseProjectProgres generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectProgres b = new BaseProjectProgres();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectProgres __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectProgressId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinishDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAlternateField2(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAlternateField3(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
	}

	public void setProjectProgressId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectProgressId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectProgressIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectManageId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectManageId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setDesignPhase(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDesignPhase() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setFinishDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getFinishDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setAlternateField1(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getAlternateField1() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setAlternateField2(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getAlternateField2() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setAlternateField3(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getAlternateField3() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setConditionProjectProgressId(String op, java.lang.Integer val) {
		setConditionProjectProgressId(op, val, CONDITION_AND);
	}

	public void setConditionProjectProgressId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectProgressId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val) {
		setConditionProjectManageId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectManageId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDesignPhase(String op, java.lang.Integer val) {
		setConditionDesignPhase(op, val, CONDITION_AND);
	}

	public void setConditionDesignPhase(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDesignPhase(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionFinishDate(String op, java.util.Date val) {
		setConditionFinishDate(op, val, CONDITION_AND);
	}

	public void setConditionFinishDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectFinishDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAlternateField1(String op, java.lang.String val) {
		setConditionAlternateField1(op, val, CONDITION_AND);
	}

	public void setConditionAlternateField1(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAlternateField1(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAlternateField2(String op, java.lang.String val) {
		setConditionAlternateField2(op, val, CONDITION_AND);
	}

	public void setConditionAlternateField2(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAlternateField2(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionAlternateField3(String op, java.lang.String val) {
		setConditionAlternateField3(op, val, CONDITION_AND);
	}

	public void setConditionAlternateField3(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAlternateField3(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[8] = val;
	}


}

