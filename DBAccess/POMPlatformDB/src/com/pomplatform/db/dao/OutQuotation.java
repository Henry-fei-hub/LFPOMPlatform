package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseOutQuotation;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class OutQuotation extends AbstractTable<BaseOutQuotation>
{

	public OutQuotation() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "out_quotations";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseOutQuotation.CS_OUT_QUOTATION_ID;
		__column_names[1] = BaseOutQuotation.CS_QUOTATION_NUMBER;
		__column_names[2] = BaseOutQuotation.CS_QUOTATION_NAME;
		__column_names[3] = BaseOutQuotation.CS_MONEY_SUM;
		__column_names[4] = BaseOutQuotation.CS_CREATE_TIME;
		__column_names[5] = BaseOutQuotation.CS_INFO_CODE;
		__column_names[6] = BaseOutQuotation.CS_PROJECT_CODE;
		__column_names[7] = BaseOutQuotation.CS_BUSINESS_TYPE;
		__column_names[8] = BaseOutQuotation.CS_PROJECT_TYPE;
		__column_names[9] = BaseOutQuotation.CS_QUOTATION_FILES;
		__column_names[10] = BaseOutQuotation.CS_QUOTATION_STATUS;
		__column_names[11] = BaseOutQuotation.CS_DISABLE_TYPE;
		__column_names[12] = BaseOutQuotation.CS_EMPLOYEE_ID;
		__column_names[13] = BaseOutQuotation.CS_CONTRACT_ID;
		__column_names[14] = BaseOutQuotation.CS_UPDATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseOutQuotation b) {
		clear();
		setOutQuotationIdClear(b.getOutQuotationId());
	}

	public boolean isPrimaryKeyNull() {
		return getOutQuotationId() == null;
	}

	@Override
	public BaseOutQuotation generateBase(){
		BaseOutQuotation b = new BaseOutQuotation();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseOutQuotation b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setQuotationNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setQuotationName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setQuotationFiles(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setQuotationStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDisableType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseOutQuotation b, Object[] buff){
		int count = 0;
		buff[count++] = b.getOutQuotationId();
		buff[count++] = b.getQuotationNumber();
		buff[count++] = b.getQuotationName();
		buff[count++] = b.getMoneySum();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getInfoCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getQuotationFiles();
		buff[count++] = b.getQuotationStatus();
		buff[count++] = b.getDisableType();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getContractId();
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
	}

	@Override
	public void setDataFromBase(BaseOutQuotation b){
		if(b.getOutQuotationId() != null) setOutQuotationIdClear(b.getOutQuotationId());
		if(b.getQuotationNumber() != null) setQuotationNumber(b.getQuotationNumber());
		if(b.getQuotationName() != null) setQuotationName(b.getQuotationName());
		if(b.getMoneySum() != null) setMoneySum(b.getMoneySum());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getQuotationFiles() != null) setQuotationFiles(b.getQuotationFiles());
		if(b.getQuotationStatus() != null) setQuotationStatus(b.getQuotationStatus());
		if(b.getDisableType() != null) setDisableType(b.getDisableType());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
	}

	@Override
	public BaseOutQuotation generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseOutQuotation b = new BaseOutQuotation();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseOutQuotation __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setQuotationNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setQuotationName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setQuotationFiles(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setQuotationStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDisableType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setOutQuotationId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getOutQuotationId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setOutQuotationIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setQuotationNumber(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getQuotationNumber() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setQuotationName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getQuotationName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setMoneySum(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getMoneySum() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setQuotationFiles(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getQuotationFiles() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setQuotationStatus(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getQuotationStatus() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setDisableType(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getDisableType() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setConditionOutQuotationId(String op, java.lang.Integer val) {
		setConditionOutQuotationId(op, val, CONDITION_AND);
	}

	public void setConditionOutQuotationId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectOutQuotationId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionQuotationNumber(String op, java.lang.String val) {
		setConditionQuotationNumber(op, val, CONDITION_AND);
	}

	public void setConditionQuotationNumber(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectQuotationNumber(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionQuotationName(String op, java.lang.String val) {
		setConditionQuotationName(op, val, CONDITION_AND);
	}

	public void setConditionQuotationName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectQuotationName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val) {
		setConditionMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMoneySum(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionQuotationFiles(String op, java.lang.String val) {
		setConditionQuotationFiles(op, val, CONDITION_AND);
	}

	public void setConditionQuotationFiles(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectQuotationFiles(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionQuotationStatus(String op, java.lang.Integer val) {
		setConditionQuotationStatus(op, val, CONDITION_AND);
	}

	public void setConditionQuotationStatus(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectQuotationStatus(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionDisableType(String op, java.lang.Integer val) {
		setConditionDisableType(op, val, CONDITION_AND);
	}

	public void setConditionDisableType(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectDisableType(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[14] = val;
	}


}

