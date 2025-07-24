package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractsRecords;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractsRecords extends AbstractTable<BaseContractsRecords>
{

	public ContractsRecords() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 17;

		initTables();

		__tableName            = "contracts_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractsRecords.CS_CONTRACTS_RECORDS_ID;
		__column_names[1] = BaseContractsRecords.CS_CONTRACT_ID;
		__column_names[2] = BaseContractsRecords.CS_CONTRACT_NAME;
		__column_names[3] = BaseContractsRecords.CS_CONTRACT_AMOUNT;
		__column_names[4] = BaseContractsRecords.CS_CONTRACT_STATUS;
		__column_names[5] = BaseContractsRecords.CS_REMARK;
		__column_names[6] = BaseContractsRecords.CS_TRACK_DATE;
		__column_names[7] = BaseContractsRecords.CS_REGISTER_EMPLOYEE;
		__column_names[8] = BaseContractsRecords.CS_REGISTER_DATE;
		__column_names[9] = BaseContractsRecords.CS_RELEVANT_EMPLOYEES;
		__column_names[10] = BaseContractsRecords.CS_RELEVANT_EMPLOYEES_NAME;
		__column_names[11] = BaseContractsRecords.CS_CUSTOMER_NAME;
		__column_names[12] = BaseContractsRecords.CS_CONTRACT_CODE;
		__column_names[13] = BaseContractsRecords.CS_CONTRACT_DATE;
		__column_names[14] = BaseContractsRecords.CS_SENDING_DATE;
		__column_names[15] = BaseContractsRecords.CS_TRACK_TYPE;
		__column_names[16] = BaseContractsRecords.CS_INFO_CODE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractsRecords b) {
		clear();
		setContractsRecordsIdClear(b.getContractsRecordsId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractsRecordsId() == null;
	}

	@Override
	public BaseContractsRecords generateBase(){
		BaseContractsRecords b = new BaseContractsRecords();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractsRecords b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractsRecordsId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTrackDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRegisterEmployee(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRegisterDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRelevantEmployees(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRelevantEmployeesName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCustomerName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSendingDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setTrackType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractsRecords b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractsRecordsId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getContractName();
		buff[count++] = b.getContractAmount();
		buff[count++] = b.getContractStatus();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getTrackDate());
		buff[count++] = b.getRegisterEmployee();
		buff[count++] = generateTimestampFromDate(b.getRegisterDate());
		buff[count++] = b.getRelevantEmployees();
		buff[count++] = b.getRelevantEmployeesName();
		buff[count++] = b.getCustomerName();
		buff[count++] = b.getContractCode();
		buff[count++] = generateTimestampFromDate(b.getContractDate());
		buff[count++] = generateTimestampFromDate(b.getSendingDate());
		buff[count++] = b.getTrackType();
		buff[count++] = b.getInfoCode();
	}

	@Override
	public void setDataFromBase(BaseContractsRecords b){
		if(b.getContractsRecordsId() != null) setContractsRecordsIdClear(b.getContractsRecordsId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getContractName() != null) setContractName(b.getContractName());
		if(b.getContractAmount() != null) setContractAmount(b.getContractAmount());
		if(b.getContractStatus() != null) setContractStatus(b.getContractStatus());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getTrackDate() != null) setTrackDate(b.getTrackDate());
		if(b.getRegisterEmployee() != null) setRegisterEmployee(b.getRegisterEmployee());
		if(b.getRegisterDate() != null) setRegisterDate(b.getRegisterDate());
		if(b.getRelevantEmployees() != null) setRelevantEmployees(b.getRelevantEmployees());
		if(b.getRelevantEmployeesName() != null) setRelevantEmployeesName(b.getRelevantEmployeesName());
		if(b.getCustomerName() != null) setCustomerName(b.getCustomerName());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getContractDate() != null) setContractDate(b.getContractDate());
		if(b.getSendingDate() != null) setSendingDate(b.getSendingDate());
		if(b.getTrackType() != null) setTrackType(b.getTrackType());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
	}

	@Override
	public BaseContractsRecords generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractsRecords b = new BaseContractsRecords();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractsRecords __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractsRecordsId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrackDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegisterEmployee(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegisterDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelevantEmployees(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelevantEmployeesName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendingDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrackType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
	}

	public void setContractsRecordsId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractsRecordsId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractsRecordsIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setContractName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getContractName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setContractAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getContractAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setContractStatus(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getContractStatus() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setTrackDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getTrackDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setRegisterEmployee(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getRegisterEmployee() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setRegisterDate(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getRegisterDate() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRelevantEmployees(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRelevantEmployees() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setRelevantEmployeesName(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRelevantEmployeesName() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setCustomerName(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getCustomerName() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setContractDate(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getContractDate() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setSendingDate(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getSendingDate() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setTrackType(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getTrackType() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setConditionContractsRecordsId(String op, java.lang.Integer val) {
		setConditionContractsRecordsId(op, val, CONDITION_AND);
	}

	public void setConditionContractsRecordsId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractsRecordsId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionContractName(String op, java.lang.String val) {
		setConditionContractName(op, val, CONDITION_AND);
	}

	public void setConditionContractName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContractName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val) {
		setConditionContractAmount(op, val, CONDITION_AND);
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionContractStatus(String op, java.lang.Integer val) {
		setConditionContractStatus(op, val, CONDITION_AND);
	}

	public void setConditionContractStatus(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectContractStatus(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionTrackDate(String op, java.util.Date val) {
		setConditionTrackDate(op, val, CONDITION_AND);
	}

	public void setConditionTrackDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectTrackDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRegisterEmployee(String op, java.lang.Integer val) {
		setConditionRegisterEmployee(op, val, CONDITION_AND);
	}

	public void setConditionRegisterEmployee(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRegisterEmployee(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRegisterDate(String op, java.util.Date val) {
		setConditionRegisterDate(op, val, CONDITION_AND);
	}

	public void setConditionRegisterDate(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRegisterDate(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRelevantEmployees(String op, java.lang.String val) {
		setConditionRelevantEmployees(op, val, CONDITION_AND);
	}

	public void setConditionRelevantEmployees(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRelevantEmployees(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionRelevantEmployeesName(String op, java.lang.String val) {
		setConditionRelevantEmployeesName(op, val, CONDITION_AND);
	}

	public void setConditionRelevantEmployeesName(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectRelevantEmployeesName(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionCustomerName(String op, java.lang.String val) {
		setConditionCustomerName(op, val, CONDITION_AND);
	}

	public void setConditionCustomerName(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectCustomerName(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionContractDate(String op, java.util.Date val) {
		setConditionContractDate(op, val, CONDITION_AND);
	}

	public void setConditionContractDate(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectContractDate(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionSendingDate(String op, java.util.Date val) {
		setConditionSendingDate(op, val, CONDITION_AND);
	}

	public void setConditionSendingDate(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSendingDate(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionTrackType(String op, java.lang.Integer val) {
		setConditionTrackType(op, val, CONDITION_AND);
	}

	public void setConditionTrackType(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectTrackType(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[16] = val;
	}


}

