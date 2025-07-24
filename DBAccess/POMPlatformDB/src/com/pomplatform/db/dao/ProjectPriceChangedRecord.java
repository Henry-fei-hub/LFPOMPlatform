package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectPriceChangedRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectPriceChangedRecord extends AbstractTable<BaseProjectPriceChangedRecord>
{

	public ProjectPriceChangedRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "project_price_changed_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectPriceChangedRecord.CS_PROJECT_PRICE_CHANGED_RECORD_ID;
		__column_names[1] = BaseProjectPriceChangedRecord.CS_PROJECT_ID;
		__column_names[2] = BaseProjectPriceChangedRecord.CS_CONTRACT_CODE;
		__column_names[3] = BaseProjectPriceChangedRecord.CS_PLATE_ID;
		__column_names[4] = BaseProjectPriceChangedRecord.CS_DEPARTMENT_ID;
		__column_names[5] = BaseProjectPriceChangedRecord.CS_YEAR;
		__column_names[6] = BaseProjectPriceChangedRecord.CS_MONTH;
		__column_names[7] = BaseProjectPriceChangedRecord.CS_RECORD_DATE;
		__column_names[8] = BaseProjectPriceChangedRecord.CS_RECORD_TIME;
		__column_names[9] = BaseProjectPriceChangedRecord.CS_MONEY;
		__column_names[10] = BaseProjectPriceChangedRecord.CS_SUBSIDIES_TYPE;
		__column_names[11] = BaseProjectPriceChangedRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[12] = BaseProjectPriceChangedRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectPriceChangedRecord b) {
		clear();
		setProjectPriceChangedRecordIdClear(b.getProjectPriceChangedRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectPriceChangedRecordId() == null;
	}

	@Override
	public BaseProjectPriceChangedRecord generateBase(){
		BaseProjectPriceChangedRecord b = new BaseProjectPriceChangedRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectPriceChangedRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectPriceChangedRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRecordTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSubsidiesType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectPriceChangedRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectPriceChangedRecordId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = generateTimestampFromDate(b.getRecordTime());
		buff[count++] = b.getMoney();
		buff[count++] = b.getSubsidiesType();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectPriceChangedRecord b){
		if(b.getProjectPriceChangedRecordId() != null) setProjectPriceChangedRecordIdClear(b.getProjectPriceChangedRecordId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getRecordTime() != null) setRecordTime(b.getRecordTime());
		if(b.getMoney() != null) setMoney(b.getMoney());
		if(b.getSubsidiesType() != null) setSubsidiesType(b.getSubsidiesType());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectPriceChangedRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectPriceChangedRecord b = new BaseProjectPriceChangedRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectPriceChangedRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectPriceChangedRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubsidiesType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectPriceChangedRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectPriceChangedRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectPriceChangedRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setYear(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getYear() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setMonth(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getMonth() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setRecordTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setMoney(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getMoney() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setSubsidiesType(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getSubsidiesType() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setConditionProjectPriceChangedRecordId(String op, java.lang.Integer val) {
		setConditionProjectPriceChangedRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectPriceChangedRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectPriceChangedRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionYear(String op, java.lang.String val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMonth(String op, java.lang.String val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRecordTime(String op, java.util.Date val) {
		setConditionRecordTime(op, val, CONDITION_AND);
	}

	public void setConditionRecordTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionMoney(String op, java.math.BigDecimal val) {
		setConditionMoney(op, val, CONDITION_AND);
	}

	public void setConditionMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMoney(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionSubsidiesType(String op, java.lang.Integer val) {
		setConditionSubsidiesType(op, val, CONDITION_AND);
	}

	public void setConditionSubsidiesType(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectSubsidiesType(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[12] = val;
	}


}

