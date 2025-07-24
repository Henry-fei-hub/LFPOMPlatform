package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseMainProjectEmployee;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class MainProjectEmployee extends AbstractTable<BaseMainProjectEmployee>
{

	public MainProjectEmployee() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "main_project_employees";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMainProjectEmployee.CS_MAIN_PROJECT_EMPLOYEE_ID;
		__column_names[1] = BaseMainProjectEmployee.CS_MAIN_PROJECT_ID;
		__column_names[2] = BaseMainProjectEmployee.CS_EMPLOYEE_ID;
		__column_names[3] = BaseMainProjectEmployee.CS_RELATION;
		__column_names[4] = BaseMainProjectEmployee.CS_PRE_PROJECT_ID;
		__column_names[5] = BaseMainProjectEmployee.CS_MAIN_AND_ASSISTANCE;
		__column_names[6] = BaseMainProjectEmployee.CS_IS_PLATE_MANAGER;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMainProjectEmployee b) {
		clear();
		setMainProjectEmployeeIdClear(b.getMainProjectEmployeeId());
	}

	public boolean isPrimaryKeyNull() {
		return getMainProjectEmployeeId() == null;
	}

	@Override
	public BaseMainProjectEmployee generateBase(){
		BaseMainProjectEmployee b = new BaseMainProjectEmployee();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMainProjectEmployee b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMainProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRelation(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPreProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainAndAssistance(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsPlateManager(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseMainProjectEmployee b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMainProjectEmployeeId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getRelation();
		buff[count++] = b.getPreProjectId();
		buff[count++] = b.getMainAndAssistance();
		buff[count++] = b.getIsPlateManager();
	}

	@Override
	public void setDataFromBase(BaseMainProjectEmployee b){
		if(b.getMainProjectEmployeeId() != null) setMainProjectEmployeeIdClear(b.getMainProjectEmployeeId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getRelation() != null) setRelation(b.getRelation());
		if(b.getPreProjectId() != null) setPreProjectId(b.getPreProjectId());
		if(b.getMainAndAssistance() != null) setMainAndAssistance(b.getMainAndAssistance());
		if(b.getIsPlateManager() != null) setIsPlateManager(b.getIsPlateManager());
	}

	@Override
	public BaseMainProjectEmployee generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMainProjectEmployee b = new BaseMainProjectEmployee();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMainProjectEmployee __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelation(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainAndAssistance(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsPlateManager(GenericBase.__getBoolean(val));
	}

	public void setMainProjectEmployeeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMainProjectEmployeeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMainProjectEmployeeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setRelation(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getRelation() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setPreProjectId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getPreProjectId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setMainAndAssistance(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getMainAndAssistance() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setIsPlateManager(java.lang.Boolean val) {
		setCurrentData(6, val);
	}

	public java.lang.Boolean getIsPlateManager() {
		return GenericBase.__getBoolean(__current_data[6]);
	}

	public void setConditionMainProjectEmployeeId(String op, java.lang.Integer val) {
		setConditionMainProjectEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMainProjectEmployeeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[1] = val;
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

	public void setConditionRelation(String op, java.lang.Integer val) {
		setConditionRelation(op, val, CONDITION_AND);
	}

	public void setConditionRelation(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRelation(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPreProjectId(String op, java.lang.Integer val) {
		setConditionPreProjectId(op, val, CONDITION_AND);
	}

	public void setConditionPreProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPreProjectId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionMainAndAssistance(String op, java.lang.Integer val) {
		setConditionMainAndAssistance(op, val, CONDITION_AND);
	}

	public void setConditionMainAndAssistance(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectMainAndAssistance(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionIsPlateManager(String op, java.lang.Boolean val) {
		setConditionIsPlateManager(op, val, CONDITION_AND);
	}

	public void setConditionIsPlateManager(String op, java.lang.Boolean val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectIsPlateManager(boolean val) {
		__select_flags[6] = val;
	}


}

