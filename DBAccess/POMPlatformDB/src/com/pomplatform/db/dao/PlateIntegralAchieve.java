package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlateIntegralAchieve;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlateIntegralAchieve extends AbstractTable<BasePlateIntegralAchieve>
{

	public PlateIntegralAchieve() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "plate_integral_achieves";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateIntegralAchieve.CS_PLATE_INTEGRAL_ACHIEVE_ID;
		__column_names[1] = BasePlateIntegralAchieve.CS_FROM_PLATE_ID;
		__column_names[2] = BasePlateIntegralAchieve.CS_TO_PLATE_ID;
		__column_names[3] = BasePlateIntegralAchieve.CS_SEND_INTEGRAL;
		__column_names[4] = BasePlateIntegralAchieve.CS_SEND_DATE;
		__column_names[5] = BasePlateIntegralAchieve.CS_OPERATE_EMPLOYEE_ID;
		__column_names[6] = BasePlateIntegralAchieve.CS_OPERATE_TIME;
		__column_names[7] = BasePlateIntegralAchieve.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateIntegralAchieve b) {
		clear();
		setPlateIntegralAchieveIdClear(b.getPlateIntegralAchieveId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateIntegralAchieveId() == null;
	}

	@Override
	public BasePlateIntegralAchieve generateBase(){
		BasePlateIntegralAchieve b = new BasePlateIntegralAchieve();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateIntegralAchieve b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateIntegralAchieveId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFromPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setToPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSendIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSendDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePlateIntegralAchieve b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateIntegralAchieveId();
		buff[count++] = b.getFromPlateId();
		buff[count++] = b.getToPlateId();
		buff[count++] = b.getSendIntegral();
		buff[count++] = generateTimestampFromDate(b.getSendDate());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePlateIntegralAchieve b){
		if(b.getPlateIntegralAchieveId() != null) setPlateIntegralAchieveIdClear(b.getPlateIntegralAchieveId());
		if(b.getFromPlateId() != null) setFromPlateId(b.getFromPlateId());
		if(b.getToPlateId() != null) setToPlateId(b.getToPlateId());
		if(b.getSendIntegral() != null) setSendIntegral(b.getSendIntegral());
		if(b.getSendDate() != null) setSendDate(b.getSendDate());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePlateIntegralAchieve generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateIntegralAchieve b = new BasePlateIntegralAchieve();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateIntegralAchieve __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateIntegralAchieveId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFromPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setToPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPlateIntegralAchieveId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateIntegralAchieveId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateIntegralAchieveIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFromPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getFromPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setToPlateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getToPlateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setSendIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getSendIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setSendDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getSendDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
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

	public void setConditionPlateIntegralAchieveId(String op, java.lang.Integer val) {
		setConditionPlateIntegralAchieveId(op, val, CONDITION_AND);
	}

	public void setConditionPlateIntegralAchieveId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateIntegralAchieveId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFromPlateId(String op, java.lang.Integer val) {
		setConditionFromPlateId(op, val, CONDITION_AND);
	}

	public void setConditionFromPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFromPlateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionToPlateId(String op, java.lang.Integer val) {
		setConditionToPlateId(op, val, CONDITION_AND);
	}

	public void setConditionToPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectToPlateId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSendIntegral(String op, java.math.BigDecimal val) {
		setConditionSendIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSendIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSendIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSendDate(String op, java.util.Date val) {
		setConditionSendDate(op, val, CONDITION_AND);
	}

	public void setConditionSendDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSendDate(boolean val) {
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

