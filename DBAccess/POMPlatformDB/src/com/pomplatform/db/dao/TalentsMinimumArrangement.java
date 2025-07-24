package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseTalentsMinimumArrangement;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class TalentsMinimumArrangement extends AbstractTable<BaseTalentsMinimumArrangement>
{

	public TalentsMinimumArrangement() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "talents_minimum_arrangements";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTalentsMinimumArrangement.CS_TALENTS_MINIMUM_ARRANGEMENT_ID;
		__column_names[1] = BaseTalentsMinimumArrangement.CS_PLATE_ID;
		__column_names[2] = BaseTalentsMinimumArrangement.CS_HIGH_DESIGNER;
		__column_names[3] = BaseTalentsMinimumArrangement.CS_MIDDLE_DESIGNER;
		__column_names[4] = BaseTalentsMinimumArrangement.CS_INITIAL_DESIGNER;
		__column_names[5] = BaseTalentsMinimumArrangement.CS_PROJECT_LEVEL;
		__column_names[6] = BaseTalentsMinimumArrangement.CS_OPERATE_EMPLOYEE_ID;
		__column_names[7] = BaseTalentsMinimumArrangement.CS_OPERATE_TIME;
		__column_names[8] = BaseTalentsMinimumArrangement.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTalentsMinimumArrangement b) {
		clear();
		setTalentsMinimumArrangementIdClear(b.getTalentsMinimumArrangementId());
	}

	public boolean isPrimaryKeyNull() {
		return getTalentsMinimumArrangementId() == null;
	}

	@Override
	public BaseTalentsMinimumArrangement generateBase(){
		BaseTalentsMinimumArrangement b = new BaseTalentsMinimumArrangement();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTalentsMinimumArrangement b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTalentsMinimumArrangementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHighDesigner(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMiddleDesigner(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInitialDesigner(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseTalentsMinimumArrangement b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTalentsMinimumArrangementId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getHighDesigner();
		buff[count++] = b.getMiddleDesigner();
		buff[count++] = b.getInitialDesigner();
		buff[count++] = b.getProjectLevel();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseTalentsMinimumArrangement b){
		if(b.getTalentsMinimumArrangementId() != null) setTalentsMinimumArrangementIdClear(b.getTalentsMinimumArrangementId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getHighDesigner() != null) setHighDesigner(b.getHighDesigner());
		if(b.getMiddleDesigner() != null) setMiddleDesigner(b.getMiddleDesigner());
		if(b.getInitialDesigner() != null) setInitialDesigner(b.getInitialDesigner());
		if(b.getProjectLevel() != null) setProjectLevel(b.getProjectLevel());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseTalentsMinimumArrangement generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTalentsMinimumArrangement b = new BaseTalentsMinimumArrangement();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTalentsMinimumArrangement __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTalentsMinimumArrangementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHighDesigner(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMiddleDesigner(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInitialDesigner(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setTalentsMinimumArrangementId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTalentsMinimumArrangementId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTalentsMinimumArrangementIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setHighDesigner(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getHighDesigner() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMiddleDesigner(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getMiddleDesigner() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setInitialDesigner(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getInitialDesigner() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setProjectLevel(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getProjectLevel() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setConditionTalentsMinimumArrangementId(String op, java.lang.Integer val) {
		setConditionTalentsMinimumArrangementId(op, val, CONDITION_AND);
	}

	public void setConditionTalentsMinimumArrangementId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTalentsMinimumArrangementId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionHighDesigner(String op, java.lang.Integer val) {
		setConditionHighDesigner(op, val, CONDITION_AND);
	}

	public void setConditionHighDesigner(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectHighDesigner(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMiddleDesigner(String op, java.lang.Integer val) {
		setConditionMiddleDesigner(op, val, CONDITION_AND);
	}

	public void setConditionMiddleDesigner(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMiddleDesigner(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionInitialDesigner(String op, java.lang.Integer val) {
		setConditionInitialDesigner(op, val, CONDITION_AND);
	}

	public void setConditionInitialDesigner(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectInitialDesigner(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProjectLevel(String op, java.lang.Integer val) {
		setConditionProjectLevel(op, val, CONDITION_AND);
	}

	public void setConditionProjectLevel(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProjectLevel(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[8] = val;
	}


}

