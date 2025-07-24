package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCapitalDistributionLinkDepartment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CapitalDistributionLinkDepartment extends AbstractTable<BaseCapitalDistributionLinkDepartment>
{

	public CapitalDistributionLinkDepartment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "capital_distribution_link_departments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCapitalDistributionLinkDepartment.CS_CAPITAL_DISTRIBUTION_LINK_DEPARTMENT_ID;
		__column_names[1] = BaseCapitalDistributionLinkDepartment.CS_CAPITAL_DISTRIBUTION_ID;
		__column_names[2] = BaseCapitalDistributionLinkDepartment.CS_DEPARTMENT_ID;
		__column_names[3] = BaseCapitalDistributionLinkDepartment.CS_MONEY;
		__column_names[4] = BaseCapitalDistributionLinkDepartment.CS_CAPITAL_ID;
		__column_names[5] = BaseCapitalDistributionLinkDepartment.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCapitalDistributionLinkDepartment b) {
		clear();
		setCapitalDistributionLinkDepartmentIdClear(b.getCapitalDistributionLinkDepartmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getCapitalDistributionLinkDepartmentId() == null;
	}

	@Override
	public BaseCapitalDistributionLinkDepartment generateBase(){
		BaseCapitalDistributionLinkDepartment b = new BaseCapitalDistributionLinkDepartment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCapitalDistributionLinkDepartment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCapitalDistributionLinkDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCapitalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCapitalDistributionLinkDepartment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCapitalDistributionLinkDepartmentId();
		buff[count++] = b.getCapitalDistributionId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getMoney();
		buff[count++] = b.getCapitalId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCapitalDistributionLinkDepartment b){
		if(b.getCapitalDistributionLinkDepartmentId() != null) setCapitalDistributionLinkDepartmentIdClear(b.getCapitalDistributionLinkDepartmentId());
		if(b.getCapitalDistributionId() != null) setCapitalDistributionId(b.getCapitalDistributionId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getMoney() != null) setMoney(b.getMoney());
		if(b.getCapitalId() != null) setCapitalId(b.getCapitalId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCapitalDistributionLinkDepartment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCapitalDistributionLinkDepartment b = new BaseCapitalDistributionLinkDepartment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCapitalDistributionLinkDepartment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalDistributionLinkDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCapitalDistributionLinkDepartmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCapitalDistributionLinkDepartmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCapitalDistributionLinkDepartmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCapitalDistributionId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCapitalDistributionId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMoney(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getMoney() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setCapitalId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCapitalId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionCapitalDistributionLinkDepartmentId(String op, java.lang.Integer val) {
		setConditionCapitalDistributionLinkDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalDistributionLinkDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCapitalDistributionLinkDepartmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCapitalDistributionId(String op, java.lang.Integer val) {
		setConditionCapitalDistributionId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalDistributionId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCapitalDistributionId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMoney(String op, java.math.BigDecimal val) {
		setConditionMoney(op, val, CONDITION_AND);
	}

	public void setConditionMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMoney(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCapitalId(String op, java.lang.Integer val) {
		setConditionCapitalId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCapitalId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[5] = val;
	}


}

