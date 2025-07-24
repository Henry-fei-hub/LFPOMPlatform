package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePreProjectReimbursementNumber;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PreProjectReimbursementNumber extends AbstractTable<BasePreProjectReimbursementNumber>
{

	public PreProjectReimbursementNumber() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "pre_project_reimbursement_numbers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePreProjectReimbursementNumber.CS_PRE_PROJECT_REIMBURSEMENT_NUMBER_ID;
		__column_names[1] = BasePreProjectReimbursementNumber.CS_CUSTOM_NUMBER;
		__column_names[2] = BasePreProjectReimbursementNumber.CS_MAIN_PROJECT_ID;
		__column_names[3] = BasePreProjectReimbursementNumber.CS_PROJECT_MANAGER;
		__column_names[4] = BasePreProjectReimbursementNumber.CS_OPERATOR;
		__column_names[5] = BasePreProjectReimbursementNumber.CS_CREATE_TIME;
		__column_names[6] = BasePreProjectReimbursementNumber.CS_REMARK;
		__column_names[7] = BasePreProjectReimbursementNumber.CS_PRE_PROJECT_TYPE;
		__column_names[8] = BasePreProjectReimbursementNumber.CS_PLATE_ID;
		__column_names[9] = BasePreProjectReimbursementNumber.CS_PRE_BUSINESS_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePreProjectReimbursementNumber b) {
		clear();
		setPreProjectReimbursementNumberIdClear(b.getPreProjectReimbursementNumberId());
	}

	public boolean isPrimaryKeyNull() {
		return getPreProjectReimbursementNumberId() == null;
	}

	@Override
	public BasePreProjectReimbursementNumber generateBase(){
		BasePreProjectReimbursementNumber b = new BasePreProjectReimbursementNumber();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePreProjectReimbursementNumber b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPreProjectReimbursementNumberId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCustomNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectManager(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPreProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPreBusinessType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BasePreProjectReimbursementNumber b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPreProjectReimbursementNumberId();
		buff[count++] = b.getCustomNumber();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getProjectManager();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getPreProjectType();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getPreBusinessType();
	}

	@Override
	public void setDataFromBase(BasePreProjectReimbursementNumber b){
		if(b.getPreProjectReimbursementNumberId() != null) setPreProjectReimbursementNumberIdClear(b.getPreProjectReimbursementNumberId());
		if(b.getCustomNumber() != null) setCustomNumber(b.getCustomNumber());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getProjectManager() != null) setProjectManager(b.getProjectManager());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getPreProjectType() != null) setPreProjectType(b.getPreProjectType());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getPreBusinessType() != null) setPreBusinessType(b.getPreBusinessType());
	}

	@Override
	public BasePreProjectReimbursementNumber generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePreProjectReimbursementNumber b = new BasePreProjectReimbursementNumber();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePreProjectReimbursementNumber __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectReimbursementNumberId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManager(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreBusinessType(GenericBase.__getInt(val));
	}

	public void setPreProjectReimbursementNumberId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPreProjectReimbursementNumberId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPreProjectReimbursementNumberIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCustomNumber(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCustomNumber() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setProjectManager(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getProjectManager() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setPreProjectType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getPreProjectType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setPreBusinessType(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getPreBusinessType() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setConditionPreProjectReimbursementNumberId(String op, java.lang.Integer val) {
		setConditionPreProjectReimbursementNumberId(op, val, CONDITION_AND);
	}

	public void setConditionPreProjectReimbursementNumberId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPreProjectReimbursementNumberId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCustomNumber(String op, java.lang.String val) {
		setConditionCustomNumber(op, val, CONDITION_AND);
	}

	public void setConditionCustomNumber(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCustomNumber(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProjectManager(String op, java.lang.Integer val) {
		setConditionProjectManager(op, val, CONDITION_AND);
	}

	public void setConditionProjectManager(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectManager(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionPreProjectType(String op, java.lang.Integer val) {
		setConditionPreProjectType(op, val, CONDITION_AND);
	}

	public void setConditionPreProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPreProjectType(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionPreBusinessType(String op, java.lang.Integer val) {
		setConditionPreBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionPreBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectPreBusinessType(boolean val) {
		__select_flags[9] = val;
	}


}

