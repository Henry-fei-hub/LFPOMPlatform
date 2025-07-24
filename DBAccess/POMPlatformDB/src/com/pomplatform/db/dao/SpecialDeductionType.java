package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSpecialDeductionType;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SpecialDeductionType extends AbstractTable<BaseSpecialDeductionType>
{

	public SpecialDeductionType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "special_deduction_types";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSpecialDeductionType.CS_SPECIAL_DEDUCTION_TYPE_ID;
		__column_names[1] = BaseSpecialDeductionType.CS_SPECIAL_DEDUCTION_TYPE_NAME;
		__column_names[2] = BaseSpecialDeductionType.CS_SCOPE_APPLICATION;
		__column_names[3] = BaseSpecialDeductionType.CS_RANGE_APPLICATION;
		__column_names[4] = BaseSpecialDeductionType.CS_AMOUNT_DESCRIPTION;
		__column_names[5] = BaseSpecialDeductionType.CS_DATE_DESCRIPTION;
		__column_names[6] = BaseSpecialDeductionType.CS_IS_ENABLE;
		__column_names[7] = BaseSpecialDeductionType.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSpecialDeductionType b) {
		clear();
		setSpecialDeductionTypeIdClear(b.getSpecialDeductionTypeId());
	}

	public boolean isPrimaryKeyNull() {
		return getSpecialDeductionTypeId() == null;
	}

	@Override
	public BaseSpecialDeductionType generateBase(){
		BaseSpecialDeductionType b = new BaseSpecialDeductionType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSpecialDeductionType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSpecialDeductionTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSpecialDeductionTypeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setScopeApplication(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRangeApplication(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAmountDescription(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDateDescription(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsEnable(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSpecialDeductionType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSpecialDeductionTypeId();
		buff[count++] = b.getSpecialDeductionTypeName();
		buff[count++] = b.getScopeApplication();
		buff[count++] = b.getRangeApplication();
		buff[count++] = b.getAmountDescription();
		buff[count++] = b.getDateDescription();
		buff[count++] = b.getIsEnable();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSpecialDeductionType b){
		if(b.getSpecialDeductionTypeId() != null) setSpecialDeductionTypeIdClear(b.getSpecialDeductionTypeId());
		if(b.getSpecialDeductionTypeName() != null) setSpecialDeductionTypeName(b.getSpecialDeductionTypeName());
		if(b.getScopeApplication() != null) setScopeApplication(b.getScopeApplication());
		if(b.getRangeApplication() != null) setRangeApplication(b.getRangeApplication());
		if(b.getAmountDescription() != null) setAmountDescription(b.getAmountDescription());
		if(b.getDateDescription() != null) setDateDescription(b.getDateDescription());
		if(b.getIsEnable() != null) setIsEnable(b.getIsEnable());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSpecialDeductionType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSpecialDeductionType b = new BaseSpecialDeductionType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSpecialDeductionType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDeductionTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDeductionTypeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setScopeApplication(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRangeApplication(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmountDescription(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDateDescription(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSpecialDeductionTypeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSpecialDeductionTypeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSpecialDeductionTypeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSpecialDeductionTypeName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getSpecialDeductionTypeName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setScopeApplication(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getScopeApplication() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setRangeApplication(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getRangeApplication() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setAmountDescription(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getAmountDescription() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setDateDescription(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getDateDescription() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setIsEnable(java.lang.Boolean val) {
		setCurrentData(6, val);
	}

	public java.lang.Boolean getIsEnable() {
		return GenericBase.__getBoolean(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setConditionSpecialDeductionTypeId(String op, java.lang.Integer val) {
		setConditionSpecialDeductionTypeId(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDeductionTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSpecialDeductionTypeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSpecialDeductionTypeName(String op, java.lang.String val) {
		setConditionSpecialDeductionTypeName(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDeductionTypeName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSpecialDeductionTypeName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionScopeApplication(String op, java.lang.String val) {
		setConditionScopeApplication(op, val, CONDITION_AND);
	}

	public void setConditionScopeApplication(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectScopeApplication(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionRangeApplication(String op, java.lang.String val) {
		setConditionRangeApplication(op, val, CONDITION_AND);
	}

	public void setConditionRangeApplication(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRangeApplication(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAmountDescription(String op, java.lang.String val) {
		setConditionAmountDescription(op, val, CONDITION_AND);
	}

	public void setConditionAmountDescription(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAmountDescription(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDateDescription(String op, java.lang.String val) {
		setConditionDateDescription(op, val, CONDITION_AND);
	}

	public void setConditionDateDescription(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDateDescription(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val) {
		setConditionIsEnable(op, val, CONDITION_AND);
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectIsEnable(boolean val) {
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

