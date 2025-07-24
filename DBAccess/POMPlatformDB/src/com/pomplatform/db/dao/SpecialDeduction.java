package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSpecialDeduction;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SpecialDeduction extends AbstractTable<BaseSpecialDeduction>
{

	public SpecialDeduction() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "special_deductions";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSpecialDeduction.CS_SPECIAL_DEDUCTION_ID;
		__column_names[1] = BaseSpecialDeduction.CS_EMPLOYE_ID;
		__column_names[2] = BaseSpecialDeduction.CS_PLATE_ID;
		__column_names[3] = BaseSpecialDeduction.CS_COMPANY_ID;
		__column_names[4] = BaseSpecialDeduction.CS_CREATE_DATE;
		__column_names[5] = BaseSpecialDeduction.CS_IS_ENABLE;
		__column_names[6] = BaseSpecialDeduction.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSpecialDeduction b) {
		clear();
		setSpecialDeductionIdClear(b.getSpecialDeductionId());
	}

	public boolean isPrimaryKeyNull() {
		return getSpecialDeductionId() == null;
	}

	@Override
	public BaseSpecialDeduction generateBase(){
		BaseSpecialDeduction b = new BaseSpecialDeduction();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSpecialDeduction b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSpecialDeductionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsEnable(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSpecialDeduction b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSpecialDeductionId();
		buff[count++] = b.getEmployeId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getCompanyId();
		buff[count++] = generateTimestampFromDate(b.getCreateDate());
		buff[count++] = b.getIsEnable();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSpecialDeduction b){
		if(b.getSpecialDeductionId() != null) setSpecialDeductionIdClear(b.getSpecialDeductionId());
		if(b.getEmployeId() != null) setEmployeId(b.getEmployeId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCreateDate() != null) setCreateDate(b.getCreateDate());
		if(b.getIsEnable() != null) setIsEnable(b.getIsEnable());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSpecialDeduction generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSpecialDeduction b = new BaseSpecialDeduction();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSpecialDeduction __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDeductionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSpecialDeductionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSpecialDeductionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSpecialDeductionIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setIsEnable(java.lang.Boolean val) {
		setCurrentData(5, val);
	}

	public java.lang.Boolean getIsEnable() {
		return GenericBase.__getBoolean(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionSpecialDeductionId(String op, java.lang.Integer val) {
		setConditionSpecialDeductionId(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDeductionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSpecialDeductionId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeId(String op, java.lang.Integer val) {
		setConditionEmployeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeId(boolean val) {
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

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateDate(String op, java.util.Date val) {
		setConditionCreateDate(op, val, CONDITION_AND);
	}

	public void setConditionCreateDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val) {
		setConditionIsEnable(op, val, CONDITION_AND);
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectIsEnable(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[6] = val;
	}


}

