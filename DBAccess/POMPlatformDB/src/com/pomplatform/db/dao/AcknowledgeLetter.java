package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAcknowledgeLetter;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class AcknowledgeLetter extends AbstractTable<BaseAcknowledgeLetter>
{

	public AcknowledgeLetter() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "acknowledge_letters";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAcknowledgeLetter.CS_ACKNOWLEDGE_LETTER_ID;
		__column_names[1] = BaseAcknowledgeLetter.CS_INFO_CODE;
		__column_names[2] = BaseAcknowledgeLetter.CS_PROJECT_CODE;
		__column_names[3] = BaseAcknowledgeLetter.CS_CONTRACT_CODE;
		__column_names[4] = BaseAcknowledgeLetter.CS_PROJECT_NAME;
		__column_names[5] = BaseAcknowledgeLetter.CS_RECEIVABLE_IDS;
		__column_names[6] = BaseAcknowledgeLetter.CS_SIGN_COMPANY;
		__column_names[7] = BaseAcknowledgeLetter.CS_SIGNATORY;
		__column_names[8] = BaseAcknowledgeLetter.CS_SIGN_DATE;
		__column_names[9] = BaseAcknowledgeLetter.CS_REGISTRATION_DATE;
		__column_names[10] = BaseAcknowledgeLetter.CS_REMARK;
		__column_names[11] = BaseAcknowledgeLetter.CS_ACKNOWLEDGE_LETTER_FILE;
		__column_names[12] = BaseAcknowledgeLetter.CS_HAS_INVOICES;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAcknowledgeLetter b) {
		clear();
		setAcknowledgeLetterIdClear(b.getAcknowledgeLetterId());
	}

	public boolean isPrimaryKeyNull() {
		return getAcknowledgeLetterId() == null;
	}

	@Override
	public BaseAcknowledgeLetter generateBase(){
		BaseAcknowledgeLetter b = new BaseAcknowledgeLetter();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAcknowledgeLetter b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAcknowledgeLetterId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReceivableIds(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSignCompany(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSignatory(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSignDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRegistrationDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAcknowledgeLetterFile(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setHasInvoices(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseAcknowledgeLetter b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAcknowledgeLetterId();
		buff[count++] = b.getInfoCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getReceivableIds();
		buff[count++] = b.getSignCompany();
		buff[count++] = b.getSignatory();
		buff[count++] = generateTimestampFromDate(b.getSignDate());
		buff[count++] = generateTimestampFromDate(b.getRegistrationDate());
		buff[count++] = b.getRemark();
		buff[count++] = b.getAcknowledgeLetterFile();
		buff[count++] = b.getHasInvoices();
	}

	@Override
	public void setDataFromBase(BaseAcknowledgeLetter b){
		if(b.getAcknowledgeLetterId() != null) setAcknowledgeLetterIdClear(b.getAcknowledgeLetterId());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getReceivableIds() != null) setReceivableIds(b.getReceivableIds());
		if(b.getSignCompany() != null) setSignCompany(b.getSignCompany());
		if(b.getSignatory() != null) setSignatory(b.getSignatory());
		if(b.getSignDate() != null) setSignDate(b.getSignDate());
		if(b.getRegistrationDate() != null) setRegistrationDate(b.getRegistrationDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getAcknowledgeLetterFile() != null) setAcknowledgeLetterFile(b.getAcknowledgeLetterFile());
		if(b.getHasInvoices() != null) setHasInvoices(b.getHasInvoices());
	}

	@Override
	public BaseAcknowledgeLetter generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAcknowledgeLetter b = new BaseAcknowledgeLetter();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAcknowledgeLetter __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAcknowledgeLetterId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceivableIds(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignCompany(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignatory(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegistrationDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAcknowledgeLetterFile(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasInvoices(GenericBase.__getBoolean(val));
	}

	public void setAcknowledgeLetterId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAcknowledgeLetterId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAcknowledgeLetterIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setReceivableIds(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getReceivableIds() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setSignCompany(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getSignCompany() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSignatory(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getSignatory() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setSignDate(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getSignDate() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRegistrationDate(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getRegistrationDate() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setAcknowledgeLetterFile(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getAcknowledgeLetterFile() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setHasInvoices(java.lang.Boolean val) {
		setCurrentData(12, val);
	}

	public java.lang.Boolean getHasInvoices() {
		return GenericBase.__getBoolean(__current_data[12]);
	}

	public void setConditionAcknowledgeLetterId(String op, java.lang.Integer val) {
		setConditionAcknowledgeLetterId(op, val, CONDITION_AND);
	}

	public void setConditionAcknowledgeLetterId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAcknowledgeLetterId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
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

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionReceivableIds(String op, java.lang.String val) {
		setConditionReceivableIds(op, val, CONDITION_AND);
	}

	public void setConditionReceivableIds(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectReceivableIds(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionSignCompany(String op, java.lang.Integer val) {
		setConditionSignCompany(op, val, CONDITION_AND);
	}

	public void setConditionSignCompany(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectSignCompany(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSignatory(String op, java.lang.String val) {
		setConditionSignatory(op, val, CONDITION_AND);
	}

	public void setConditionSignatory(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSignatory(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSignDate(String op, java.util.Date val) {
		setConditionSignDate(op, val, CONDITION_AND);
	}

	public void setConditionSignDate(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSignDate(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRegistrationDate(String op, java.util.Date val) {
		setConditionRegistrationDate(op, val, CONDITION_AND);
	}

	public void setConditionRegistrationDate(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRegistrationDate(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionAcknowledgeLetterFile(String op, java.lang.String val) {
		setConditionAcknowledgeLetterFile(op, val, CONDITION_AND);
	}

	public void setConditionAcknowledgeLetterFile(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectAcknowledgeLetterFile(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionHasInvoices(String op, java.lang.Boolean val) {
		setConditionHasInvoices(op, val, CONDITION_AND);
	}

	public void setConditionHasInvoices(String op, java.lang.Boolean val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectHasInvoices(boolean val) {
		__select_flags[12] = val;
	}


}

