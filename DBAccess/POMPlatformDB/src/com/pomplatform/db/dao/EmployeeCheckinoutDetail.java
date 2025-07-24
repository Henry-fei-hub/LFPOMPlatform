package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeCheckinoutDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeCheckinoutDetail extends AbstractTable<BaseEmployeeCheckinoutDetail>
{

	public EmployeeCheckinoutDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "employee_checkinout_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeCheckinoutDetail.CS_EMPLOYEE_CHECKINOUT_DETAIL_ID;
		__column_names[1] = BaseEmployeeCheckinoutDetail.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeCheckinoutDetail.CS_CHECK_DATE;
		__column_names[3] = BaseEmployeeCheckinoutDetail.CS_CHECK_TIME;
		__column_names[4] = BaseEmployeeCheckinoutDetail.CS_OA_EMPLOYEE_ID;
		__column_names[5] = BaseEmployeeCheckinoutDetail.CS_OPERATE_EMPLOYEE_ID;
		__column_names[6] = BaseEmployeeCheckinoutDetail.CS_OPERATE_TIME;
		__column_names[7] = BaseEmployeeCheckinoutDetail.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeCheckinoutDetail b) {
		clear();
		setEmployeeCheckinoutDetailIdClear(b.getEmployeeCheckinoutDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeCheckinoutDetailId() == null;
	}

	@Override
	public BaseEmployeeCheckinoutDetail generateBase(){
		BaseEmployeeCheckinoutDetail b = new BaseEmployeeCheckinoutDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeCheckinoutDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeCheckinoutDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCheckDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCheckTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOaEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeCheckinoutDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeCheckinoutDetailId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCheckDate());
		buff[count++] = generateTimestampFromDate(b.getCheckTime());
		buff[count++] = b.getOaEmployeeId();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseEmployeeCheckinoutDetail b){
		if(b.getEmployeeCheckinoutDetailId() != null) setEmployeeCheckinoutDetailIdClear(b.getEmployeeCheckinoutDetailId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getCheckDate() != null) setCheckDate(b.getCheckDate());
		if(b.getCheckTime() != null) setCheckTime(b.getCheckTime());
		if(b.getOaEmployeeId() != null) setOaEmployeeId(b.getOaEmployeeId());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseEmployeeCheckinoutDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeCheckinoutDetail b = new BaseEmployeeCheckinoutDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeCheckinoutDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeCheckinoutDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCheckDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCheckTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOaEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setEmployeeCheckinoutDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeCheckinoutDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeCheckinoutDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCheckDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getCheckDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setCheckTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCheckTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setOaEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOaEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setConditionEmployeeCheckinoutDetailId(String op, java.lang.Integer val) {
		setConditionEmployeeCheckinoutDetailId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeCheckinoutDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeCheckinoutDetailId(boolean val) {
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

	public void setConditionCheckDate(String op, java.util.Date val) {
		setConditionCheckDate(op, val, CONDITION_AND);
	}

	public void setConditionCheckDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCheckDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCheckTime(String op, java.util.Date val) {
		setConditionCheckTime(op, val, CONDITION_AND);
	}

	public void setConditionCheckTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCheckTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOaEmployeeId(String op, java.lang.Integer val) {
		setConditionOaEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOaEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOaEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[7] = val;
	}


}

