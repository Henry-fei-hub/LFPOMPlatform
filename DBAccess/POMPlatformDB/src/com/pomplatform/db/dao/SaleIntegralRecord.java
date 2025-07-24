package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSaleIntegralRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SaleIntegralRecord extends AbstractTable<BaseSaleIntegralRecord>
{

	public SaleIntegralRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "sale_integral_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSaleIntegralRecord.CS_SALE_INTEGRAL_RECORD_ID;
		__column_names[1] = BaseSaleIntegralRecord.CS_BUSINESS_NAME;
		__column_names[2] = BaseSaleIntegralRecord.CS_PLATE_ID;
		__column_names[3] = BaseSaleIntegralRecord.CS_YEAR;
		__column_names[4] = BaseSaleIntegralRecord.CS_MONTH;
		__column_names[5] = BaseSaleIntegralRecord.CS_CURRENT_REVENUE;
		__column_names[6] = BaseSaleIntegralRecord.CS_PERCENT;
		__column_names[7] = BaseSaleIntegralRecord.CS_SALE_INTEGRAL;
		__column_names[8] = BaseSaleIntegralRecord.CS_RECORD_DATE;
		__column_names[9] = BaseSaleIntegralRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[10] = BaseSaleIntegralRecord.CS_OPERATE_TIME;
		__column_names[11] = BaseSaleIntegralRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSaleIntegralRecord b) {
		clear();
		setSaleIntegralRecordIdClear(b.getSaleIntegralRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getSaleIntegralRecordId() == null;
	}

	@Override
	public BaseSaleIntegralRecord generateBase(){
		BaseSaleIntegralRecord b = new BaseSaleIntegralRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSaleIntegralRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSaleIntegralRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCurrentRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSaleIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSaleIntegralRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSaleIntegralRecordId();
		buff[count++] = b.getBusinessName();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getCurrentRevenue();
		buff[count++] = b.getPercent();
		buff[count++] = b.getSaleIntegral();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSaleIntegralRecord b){
		if(b.getSaleIntegralRecordId() != null) setSaleIntegralRecordIdClear(b.getSaleIntegralRecordId());
		if(b.getBusinessName() != null) setBusinessName(b.getBusinessName());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getCurrentRevenue() != null) setCurrentRevenue(b.getCurrentRevenue());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getSaleIntegral() != null) setSaleIntegral(b.getSaleIntegral());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSaleIntegralRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSaleIntegralRecord b = new BaseSaleIntegralRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSaleIntegralRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSaleIntegralRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrentRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSaleIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSaleIntegralRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSaleIntegralRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSaleIntegralRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBusinessName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getBusinessName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCurrentRevenue(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getCurrentRevenue() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setPercent(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getPercent() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setSaleIntegral(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getSaleIntegral() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setConditionSaleIntegralRecordId(String op, java.lang.Integer val) {
		setConditionSaleIntegralRecordId(op, val, CONDITION_AND);
	}

	public void setConditionSaleIntegralRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSaleIntegralRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBusinessName(String op, java.lang.String val) {
		setConditionBusinessName(op, val, CONDITION_AND);
	}

	public void setConditionBusinessName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBusinessName(boolean val) {
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

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCurrentRevenue(String op, java.math.BigDecimal val) {
		setConditionCurrentRevenue(op, val, CONDITION_AND);
	}

	public void setConditionCurrentRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCurrentRevenue(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPercent(String op, java.math.BigDecimal val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSaleIntegral(String op, java.math.BigDecimal val) {
		setConditionSaleIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSaleIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSaleIntegral(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[11] = val;
	}


}

