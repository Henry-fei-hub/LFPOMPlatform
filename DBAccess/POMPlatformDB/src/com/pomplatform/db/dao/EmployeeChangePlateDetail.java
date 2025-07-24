package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeChangePlateDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeChangePlateDetail extends AbstractTable<BaseEmployeeChangePlateDetail>
{

	public EmployeeChangePlateDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "employee_change_plate_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeChangePlateDetail.CS_EMPLOYEE_CHANGE_PLATE_DETAIL_ID;
		__column_names[1] = BaseEmployeeChangePlateDetail.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeChangePlateDetail.CS_YEAR;
		__column_names[3] = BaseEmployeeChangePlateDetail.CS_MONTH;
		__column_names[4] = BaseEmployeeChangePlateDetail.CS_OUT_PLATE_ID;
		__column_names[5] = BaseEmployeeChangePlateDetail.CS_IN_PLATE_ID;
		__column_names[6] = BaseEmployeeChangePlateDetail.CS_REMARK;
		__column_names[7] = BaseEmployeeChangePlateDetail.CS_CREATE_TIME;
		__column_names[8] = BaseEmployeeChangePlateDetail.CS_UPDATE_TIME;
		__column_names[9] = BaseEmployeeChangePlateDetail.CS_CHANGE_PLATE_DATE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeChangePlateDetail b) {
		clear();
		setEmployeeChangePlateDetailIdClear(b.getEmployeeChangePlateDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeChangePlateDetailId() == null;
	}

	@Override
	public BaseEmployeeChangePlateDetail generateBase(){
		BaseEmployeeChangePlateDetail b = new BaseEmployeeChangePlateDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeChangePlateDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeChangePlateDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOutPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setChangePlateDate(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeChangePlateDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeChangePlateDetailId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getOutPlateId();
		buff[count++] = b.getInPlateId();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = generateTimestampFromDate(b.getChangePlateDate());
	}

	@Override
	public void setDataFromBase(BaseEmployeeChangePlateDetail b){
		if(b.getEmployeeChangePlateDetailId() != null) setEmployeeChangePlateDetailIdClear(b.getEmployeeChangePlateDetailId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getOutPlateId() != null) setOutPlateId(b.getOutPlateId());
		if(b.getInPlateId() != null) setInPlateId(b.getInPlateId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getChangePlateDate() != null) setChangePlateDate(b.getChangePlateDate());
	}

	@Override
	public BaseEmployeeChangePlateDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeChangePlateDetail b = new BaseEmployeeChangePlateDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeChangePlateDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeChangePlateDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setChangePlateDate(GenericBase.__getDateFromSQL(val));
	}

	public void setEmployeeChangePlateDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeChangePlateDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeChangePlateDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setOutPlateId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOutPlateId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setInPlateId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getInPlateId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setChangePlateDate(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getChangePlateDate() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setConditionEmployeeChangePlateDetailId(String op, java.lang.Integer val) {
		setConditionEmployeeChangePlateDetailId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeChangePlateDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeChangePlateDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOutPlateId(String op, java.lang.Integer val) {
		setConditionOutPlateId(op, val, CONDITION_AND);
	}

	public void setConditionOutPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOutPlateId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionInPlateId(String op, java.lang.Integer val) {
		setConditionInPlateId(op, val, CONDITION_AND);
	}

	public void setConditionInPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectInPlateId(boolean val) {
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

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionChangePlateDate(String op, java.util.Date val) {
		setConditionChangePlateDate(op, val, CONDITION_AND);
	}

	public void setConditionChangePlateDate(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectChangePlateDate(boolean val) {
		__select_flags[9] = val;
	}


}

