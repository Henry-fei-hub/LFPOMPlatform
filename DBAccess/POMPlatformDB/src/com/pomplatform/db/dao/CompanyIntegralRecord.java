package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCompanyIntegralRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CompanyIntegralRecord extends AbstractTable<BaseCompanyIntegralRecord>
{

	public CompanyIntegralRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "company_integral_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCompanyIntegralRecord.CS_COMPANY_INTEGRAL_RECORD_ID;
		__column_names[1] = BaseCompanyIntegralRecord.CS_PLATE_ID;
		__column_names[2] = BaseCompanyIntegralRecord.CS_INTEGRAL;
		__column_names[3] = BaseCompanyIntegralRecord.CS_RECORD_DATE;
		__column_names[4] = BaseCompanyIntegralRecord.CS_FLAG;
		__column_names[5] = BaseCompanyIntegralRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[6] = BaseCompanyIntegralRecord.CS_OPERATE_TIME;
		__column_names[7] = BaseCompanyIntegralRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCompanyIntegralRecord b) {
		clear();
		setCompanyIntegralRecordIdClear(b.getCompanyIntegralRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getCompanyIntegralRecordId() == null;
	}

	@Override
	public BaseCompanyIntegralRecord generateBase(){
		BaseCompanyIntegralRecord b = new BaseCompanyIntegralRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCompanyIntegralRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCompanyIntegralRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCompanyIntegralRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCompanyIntegralRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getIntegral();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getFlag();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseCompanyIntegralRecord b){
		if(b.getCompanyIntegralRecordId() != null) setCompanyIntegralRecordIdClear(b.getCompanyIntegralRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getIntegral() != null) setIntegral(b.getIntegral());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getFlag() != null) setFlag(b.getFlag());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseCompanyIntegralRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCompanyIntegralRecord b = new BaseCompanyIntegralRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCompanyIntegralRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyIntegralRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setCompanyIntegralRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCompanyIntegralRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCompanyIntegralRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setIntegral(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getIntegral() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setFlag(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getFlag() {
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

	public void setConditionCompanyIntegralRecordId(String op, java.lang.Integer val) {
		setConditionCompanyIntegralRecordId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyIntegralRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCompanyIntegralRecordId(boolean val) {
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

	public void setConditionIntegral(String op, java.math.BigDecimal val) {
		setConditionIntegral(op, val, CONDITION_AND);
	}

	public void setConditionIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectIntegral(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionFlag(String op, java.lang.Integer val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
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

