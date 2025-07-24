package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeViolationCharge;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeViolationCharge extends AbstractTable<BaseEmployeeViolationCharge>
{

	public EmployeeViolationCharge() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "employee_violation_charges";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeViolationCharge.CS_EMPLOYEE_VIOLATION_CHARGES_ID;
		__column_names[1] = BaseEmployeeViolationCharge.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeViolationCharge.CS_PLATE_ID;
		__column_names[3] = BaseEmployeeViolationCharge.CS_VIOLATION_CHARGES;
		__column_names[4] = BaseEmployeeViolationCharge.CS_VIOLATION_DATE;
		__column_names[5] = BaseEmployeeViolationCharge.CS_OPERATOR;
		__column_names[6] = BaseEmployeeViolationCharge.CS_OPERATE_TIME;
		__column_names[7] = BaseEmployeeViolationCharge.CS_REMARK;
		__column_names[8] = BaseEmployeeViolationCharge.CS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeViolationCharge b) {
		clear();
		setEmployeeViolationChargesIdClear(b.getEmployeeViolationChargesId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeViolationChargesId() == null;
	}

	@Override
	public BaseEmployeeViolationCharge generateBase(){
		BaseEmployeeViolationCharge b = new BaseEmployeeViolationCharge();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeViolationCharge b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeViolationChargesId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setViolationCharges(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setViolationDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeViolationCharge b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeViolationChargesId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getViolationCharges();
		buff[count++] = generateTimestampFromDate(b.getViolationDate());
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getStatus();
	}

	@Override
	public void setDataFromBase(BaseEmployeeViolationCharge b){
		if(b.getEmployeeViolationChargesId() != null) setEmployeeViolationChargesIdClear(b.getEmployeeViolationChargesId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getViolationCharges() != null) setViolationCharges(b.getViolationCharges());
		if(b.getViolationDate() != null) setViolationDate(b.getViolationDate());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getStatus() != null) setStatus(b.getStatus());
	}

	@Override
	public BaseEmployeeViolationCharge generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeViolationCharge b = new BaseEmployeeViolationCharge();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeViolationCharge __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeViolationChargesId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setViolationCharges(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setViolationDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
	}

	public void setEmployeeViolationChargesId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeViolationChargesId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeViolationChargesIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setViolationCharges(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getViolationCharges() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setViolationDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getViolationDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOperator() {
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

	public void setStatus(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setConditionEmployeeViolationChargesId(String op, java.lang.Integer val) {
		setConditionEmployeeViolationChargesId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeViolationChargesId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeViolationChargesId(boolean val) {
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

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionViolationCharges(String op, java.math.BigDecimal val) {
		setConditionViolationCharges(op, val, CONDITION_AND);
	}

	public void setConditionViolationCharges(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectViolationCharges(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionViolationDate(String op, java.util.Date val) {
		setConditionViolationDate(op, val, CONDITION_AND);
	}

	public void setConditionViolationDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectViolationDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
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

