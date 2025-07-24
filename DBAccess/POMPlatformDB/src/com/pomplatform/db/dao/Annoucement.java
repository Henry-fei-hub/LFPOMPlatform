package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAnnoucement;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Annoucement extends AbstractTable<BaseAnnoucement>
{

	public Annoucement() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "annoucements";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAnnoucement.CS_ANNOUCEMENT_ID;
		__column_names[1] = BaseAnnoucement.CS_MAIN_PROJECT_ID;
		__column_names[2] = BaseAnnoucement.CS_CUSTOMER_ID;
		__column_names[3] = BaseAnnoucement.CS_ANNOUCEMENT_TITLE;
		__column_names[4] = BaseAnnoucement.CS_ANNOUCEMENT_CONTENT;
		__column_names[5] = BaseAnnoucement.CS_ANNOUCEMENT_TIME;
		__column_names[6] = BaseAnnoucement.CS_ANNOUCEMENT_EMPLOYEE_IDS;
		__column_names[7] = BaseAnnoucement.CS_ANNOUCEMENT_EMPLOYEE_NAMES;
		__column_names[8] = BaseAnnoucement.CS_OPERATE_EMPLOYEE_ID;
		__column_names[9] = BaseAnnoucement.CS_OPERATE_TIME;
		__column_names[10] = BaseAnnoucement.CS_REMARK;
		__column_names[11] = BaseAnnoucement.CS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAnnoucement b) {
		clear();
		setAnnoucementIdClear(b.getAnnoucementId());
	}

	public boolean isPrimaryKeyNull() {
		return getAnnoucementId() == null;
	}

	@Override
	public BaseAnnoucement generateBase(){
		BaseAnnoucement b = new BaseAnnoucement();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAnnoucement b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAnnoucementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCustomerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAnnoucementTitle(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAnnoucementContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAnnoucementTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAnnoucementEmployeeIds(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAnnoucementEmployeeNames(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseAnnoucement b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAnnoucementId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getCustomerId();
		buff[count++] = b.getAnnoucementTitle();
		buff[count++] = b.getAnnoucementContent();
		buff[count++] = generateTimestampFromDate(b.getAnnoucementTime());
		buff[count++] = b.getAnnoucementEmployeeIds();
		buff[count++] = b.getAnnoucementEmployeeNames();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getStatus();
	}

	@Override
	public void setDataFromBase(BaseAnnoucement b){
		if(b.getAnnoucementId() != null) setAnnoucementIdClear(b.getAnnoucementId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getCustomerId() != null) setCustomerId(b.getCustomerId());
		if(b.getAnnoucementTitle() != null) setAnnoucementTitle(b.getAnnoucementTitle());
		if(b.getAnnoucementContent() != null) setAnnoucementContent(b.getAnnoucementContent());
		if(b.getAnnoucementTime() != null) setAnnoucementTime(b.getAnnoucementTime());
		if(b.getAnnoucementEmployeeIds() != null) setAnnoucementEmployeeIds(b.getAnnoucementEmployeeIds());
		if(b.getAnnoucementEmployeeNames() != null) setAnnoucementEmployeeNames(b.getAnnoucementEmployeeNames());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getStatus() != null) setStatus(b.getStatus());
	}

	@Override
	public BaseAnnoucement generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAnnoucement b = new BaseAnnoucement();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAnnoucement __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAnnoucementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAnnoucementTitle(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAnnoucementContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAnnoucementTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAnnoucementEmployeeIds(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAnnoucementEmployeeNames(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
	}

	public void setAnnoucementId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAnnoucementId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAnnoucementIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCustomerId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCustomerId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAnnoucementTitle(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getAnnoucementTitle() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setAnnoucementContent(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getAnnoucementContent() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setAnnoucementTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getAnnoucementTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setAnnoucementEmployeeIds(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getAnnoucementEmployeeIds() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setAnnoucementEmployeeNames(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getAnnoucementEmployeeNames() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setConditionAnnoucementId(String op, java.lang.Integer val) {
		setConditionAnnoucementId(op, val, CONDITION_AND);
	}

	public void setConditionAnnoucementId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAnnoucementId(boolean val) {
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

	public void setConditionCustomerId(String op, java.lang.Integer val) {
		setConditionCustomerId(op, val, CONDITION_AND);
	}

	public void setConditionCustomerId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCustomerId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAnnoucementTitle(String op, java.lang.String val) {
		setConditionAnnoucementTitle(op, val, CONDITION_AND);
	}

	public void setConditionAnnoucementTitle(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAnnoucementTitle(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAnnoucementContent(String op, java.lang.String val) {
		setConditionAnnoucementContent(op, val, CONDITION_AND);
	}

	public void setConditionAnnoucementContent(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAnnoucementContent(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAnnoucementTime(String op, java.util.Date val) {
		setConditionAnnoucementTime(op, val, CONDITION_AND);
	}

	public void setConditionAnnoucementTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAnnoucementTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAnnoucementEmployeeIds(String op, java.lang.String val) {
		setConditionAnnoucementEmployeeIds(op, val, CONDITION_AND);
	}

	public void setConditionAnnoucementEmployeeIds(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAnnoucementEmployeeIds(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionAnnoucementEmployeeNames(String op, java.lang.String val) {
		setConditionAnnoucementEmployeeNames(op, val, CONDITION_AND);
	}

	public void setConditionAnnoucementEmployeeNames(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAnnoucementEmployeeNames(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[11] = val;
	}


}

