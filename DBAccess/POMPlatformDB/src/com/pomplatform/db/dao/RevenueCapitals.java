package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseRevenueCapitals;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class RevenueCapitals extends AbstractTable<BaseRevenueCapitals>
{

	public RevenueCapitals() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "revenue_capitals";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseRevenueCapitals.CS_REVENUE_CAPITALS_ID;
		__column_names[1] = BaseRevenueCapitals.CS_YEAR;
		__column_names[2] = BaseRevenueCapitals.CS_MONTH;
		__column_names[3] = BaseRevenueCapitals.CS_CONTRACT_ID;
		__column_names[4] = BaseRevenueCapitals.CS_CAPITAL_AMOUNT;
		__column_names[5] = BaseRevenueCapitals.CS_REVENUE_AMOUNT;
		__column_names[6] = BaseRevenueCapitals.CS_IS_TRUE;
		__column_names[7] = BaseRevenueCapitals.CS_OPERATE_EMPLOYEE_ID;
		__column_names[8] = BaseRevenueCapitals.CS_OPERATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseRevenueCapitals b) {
		clear();
		setRevenueCapitalsIdClear(b.getRevenueCapitalsId());
	}

	public boolean isPrimaryKeyNull() {
		return getRevenueCapitalsId() == null;
	}

	@Override
	public BaseRevenueCapitals generateBase(){
		BaseRevenueCapitals b = new BaseRevenueCapitals();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseRevenueCapitals b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setRevenueCapitalsId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCapitalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRevenueAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsTrue(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseRevenueCapitals b, Object[] buff){
		int count = 0;
		buff[count++] = b.getRevenueCapitalsId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getContractId();
		buff[count++] = b.getCapitalAmount();
		buff[count++] = b.getRevenueAmount();
		buff[count++] = b.getIsTrue();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
	}

	@Override
	public void setDataFromBase(BaseRevenueCapitals b){
		if(b.getRevenueCapitalsId() != null) setRevenueCapitalsIdClear(b.getRevenueCapitalsId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getCapitalAmount() != null) setCapitalAmount(b.getCapitalAmount());
		if(b.getRevenueAmount() != null) setRevenueAmount(b.getRevenueAmount());
		if(b.getIsTrue() != null) setIsTrue(b.getIsTrue());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
	}

	@Override
	public BaseRevenueCapitals generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseRevenueCapitals b = new BaseRevenueCapitals();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseRevenueCapitals __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRevenueCapitalsId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRevenueAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsTrue(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setRevenueCapitalsId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getRevenueCapitalsId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setRevenueCapitalsIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCapitalAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getCapitalAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setRevenueAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getRevenueAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setIsTrue(java.lang.Boolean val) {
		setCurrentData(6, val);
	}

	public java.lang.Boolean getIsTrue() {
		return GenericBase.__getBoolean(__current_data[6]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setConditionRevenueCapitalsId(String op, java.lang.Integer val) {
		setConditionRevenueCapitalsId(op, val, CONDITION_AND);
	}

	public void setConditionRevenueCapitalsId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectRevenueCapitalsId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCapitalAmount(String op, java.math.BigDecimal val) {
		setConditionCapitalAmount(op, val, CONDITION_AND);
	}

	public void setConditionCapitalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCapitalAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRevenueAmount(String op, java.math.BigDecimal val) {
		setConditionRevenueAmount(op, val, CONDITION_AND);
	}

	public void setConditionRevenueAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRevenueAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionIsTrue(String op, java.lang.Boolean val) {
		setConditionIsTrue(op, val, CONDITION_AND);
	}

	public void setConditionIsTrue(String op, java.lang.Boolean val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectIsTrue(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[8] = val;
	}


}

