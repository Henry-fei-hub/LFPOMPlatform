package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseOldProjectRevenue;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class OldProjectRevenue extends AbstractTable<BaseOldProjectRevenue>
{

	public OldProjectRevenue() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "old_project_revenues";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseOldProjectRevenue.CS_OLD_PROJECT_REVENUE_ID;
		__column_names[1] = BaseOldProjectRevenue.CS_CONTRACT_CODE;
		__column_names[2] = BaseOldProjectRevenue.CS_PROJECT_CODE;
		__column_names[3] = BaseOldProjectRevenue.CS_PROJECT_NAME;
		__column_names[4] = BaseOldProjectRevenue.CS_AMOUNT;
		__column_names[5] = BaseOldProjectRevenue.CS_PALTE_ID;
		__column_names[6] = BaseOldProjectRevenue.CS_IS_FINISH;
		__column_names[7] = BaseOldProjectRevenue.CS_BUNIESS_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseOldProjectRevenue b) {
		clear();
		setOldProjectRevenueIdClear(b.getOldProjectRevenueId());
	}

	public boolean isPrimaryKeyNull() {
		return getOldProjectRevenueId() == null;
	}

	@Override
	public BaseOldProjectRevenue generateBase(){
		BaseOldProjectRevenue b = new BaseOldProjectRevenue();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseOldProjectRevenue b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setOldProjectRevenueId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPalteId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsFinish(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBuniessType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseOldProjectRevenue b, Object[] buff){
		int count = 0;
		buff[count++] = b.getOldProjectRevenueId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getAmount();
		buff[count++] = b.getPalteId();
		buff[count++] = b.getIsFinish();
		buff[count++] = b.getBuniessType();
	}

	@Override
	public void setDataFromBase(BaseOldProjectRevenue b){
		if(b.getOldProjectRevenueId() != null) setOldProjectRevenueIdClear(b.getOldProjectRevenueId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getPalteId() != null) setPalteId(b.getPalteId());
		if(b.getIsFinish() != null) setIsFinish(b.getIsFinish());
		if(b.getBuniessType() != null) setBuniessType(b.getBuniessType());
	}

	@Override
	public BaseOldProjectRevenue generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseOldProjectRevenue b = new BaseOldProjectRevenue();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseOldProjectRevenue __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOldProjectRevenueId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPalteId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsFinish(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBuniessType(GenericBase.__getInt(val));
	}

	public void setOldProjectRevenueId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getOldProjectRevenueId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setOldProjectRevenueIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setPalteId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getPalteId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setIsFinish(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getIsFinish() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setBuniessType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getBuniessType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setConditionOldProjectRevenueId(String op, java.lang.Integer val) {
		setConditionOldProjectRevenueId(op, val, CONDITION_AND);
	}

	public void setConditionOldProjectRevenueId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectOldProjectRevenueId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPalteId(String op, java.lang.Integer val) {
		setConditionPalteId(op, val, CONDITION_AND);
	}

	public void setConditionPalteId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPalteId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionIsFinish(String op, java.lang.Integer val) {
		setConditionIsFinish(op, val, CONDITION_AND);
	}

	public void setConditionIsFinish(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectIsFinish(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionBuniessType(String op, java.lang.Integer val) {
		setConditionBuniessType(op, val, CONDITION_AND);
	}

	public void setConditionBuniessType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectBuniessType(boolean val) {
		__select_flags[7] = val;
	}


}

