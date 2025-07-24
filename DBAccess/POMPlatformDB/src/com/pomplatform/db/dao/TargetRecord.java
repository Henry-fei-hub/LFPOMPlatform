package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseTargetRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class TargetRecord extends AbstractTable<BaseTargetRecord>
{

	public TargetRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "target_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTargetRecord.CS_TARGET_RECORD_ID;
		__column_names[1] = BaseTargetRecord.CS_BUSINESS_LINE;
		__column_names[2] = BaseTargetRecord.CS_YEAR;
		__column_names[3] = BaseTargetRecord.CS_MONTH;
		__column_names[4] = BaseTargetRecord.CS_TARGET;
		__column_names[5] = BaseTargetRecord.CS_TARGET_STR;
		__column_names[6] = BaseTargetRecord.CS_TYPE;
		__column_names[7] = BaseTargetRecord.CS_REMARK;
		__column_names[8] = BaseTargetRecord.CS_OPERATE_DATE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTargetRecord b) {
		clear();
		setTargetRecordIdClear(b.getTargetRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getTargetRecordId() == null;
	}

	@Override
	public BaseTargetRecord generateBase(){
		BaseTargetRecord b = new BaseTargetRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTargetRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTargetRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessLine(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTarget(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTargetStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperateDate(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseTargetRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTargetRecordId();
		buff[count++] = b.getBusinessLine();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getTarget();
		buff[count++] = b.getTargetStr();
		buff[count++] = b.getType();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getOperateDate());
	}

	@Override
	public void setDataFromBase(BaseTargetRecord b){
		if(b.getTargetRecordId() != null) setTargetRecordIdClear(b.getTargetRecordId());
		if(b.getBusinessLine() != null) setBusinessLine(b.getBusinessLine());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getTarget() != null) setTarget(b.getTarget());
		if(b.getTargetStr() != null) setTargetStr(b.getTargetStr());
		if(b.getType() != null) setType(b.getType());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getOperateDate() != null) setOperateDate(b.getOperateDate());
	}

	@Override
	public BaseTargetRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTargetRecord b = new BaseTargetRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTargetRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTargetRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessLine(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTarget(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTargetStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateDate(GenericBase.__getDateFromSQL(val));
	}

	public void setTargetRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTargetRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTargetRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBusinessLine(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBusinessLine() {
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

	public void setTarget(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getTarget() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setTargetStr(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getTargetStr() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setOperateDate(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateDate() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setConditionTargetRecordId(String op, java.lang.Integer val) {
		setConditionTargetRecordId(op, val, CONDITION_AND);
	}

	public void setConditionTargetRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTargetRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBusinessLine(String op, java.lang.Integer val) {
		setConditionBusinessLine(op, val, CONDITION_AND);
	}

	public void setConditionBusinessLine(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBusinessLine(boolean val) {
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

	public void setConditionTarget(String op, java.math.BigDecimal val) {
		setConditionTarget(op, val, CONDITION_AND);
	}

	public void setConditionTarget(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTarget(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionTargetStr(String op, java.lang.String val) {
		setConditionTargetStr(op, val, CONDITION_AND);
	}

	public void setConditionTargetStr(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectTargetStr(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectType(boolean val) {
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

	public void setConditionOperateDate(String op, java.util.Date val) {
		setConditionOperateDate(op, val, CONDITION_AND);
	}

	public void setConditionOperateDate(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateDate(boolean val) {
		__select_flags[8] = val;
	}


}

