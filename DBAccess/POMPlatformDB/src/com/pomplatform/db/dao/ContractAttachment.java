package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractAttachment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractAttachment extends AbstractTable<BaseContractAttachment>
{

	public ContractAttachment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "contract_attachments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractAttachment.CS_CONTRACT_ATTACHMENT_ID;
		__column_names[1] = BaseContractAttachment.CS_FILE_ID;
		__column_names[2] = BaseContractAttachment.CS_ATTACHMENT_CODE;
		__column_names[3] = BaseContractAttachment.CS_ATTACHMENT_NAME;
		__column_names[4] = BaseContractAttachment.CS_COMPANY_ID;
		__column_names[5] = BaseContractAttachment.CS_YEAR;
		__column_names[6] = BaseContractAttachment.CS_FLAG;
		__column_names[7] = BaseContractAttachment.CS_SIGNING_MONEY_SUM;
		__column_names[8] = BaseContractAttachment.CS_UPLOAD_EMPLOYEE_ID;
		__column_names[9] = BaseContractAttachment.CS_UPLOAD_TIME;
		__column_names[10] = BaseContractAttachment.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractAttachment b) {
		clear();
		setContractAttachmentIdClear(b.getContractAttachmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractAttachmentId() == null;
	}

	@Override
	public BaseContractAttachment generateBase(){
		BaseContractAttachment b = new BaseContractAttachment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractAttachment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUploadEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUploadTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractAttachment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractAttachmentId();
		buff[count++] = b.getFileId();
		buff[count++] = b.getAttachmentCode();
		buff[count++] = b.getAttachmentName();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getYear();
		buff[count++] = b.getFlag();
		buff[count++] = b.getSigningMoneySum();
		buff[count++] = b.getUploadEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getUploadTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseContractAttachment b){
		if(b.getContractAttachmentId() != null) setContractAttachmentIdClear(b.getContractAttachmentId());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getAttachmentCode() != null) setAttachmentCode(b.getAttachmentCode());
		if(b.getAttachmentName() != null) setAttachmentName(b.getAttachmentName());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getFlag() != null) setFlag(b.getFlag());
		if(b.getSigningMoneySum() != null) setSigningMoneySum(b.getSigningMoneySum());
		if(b.getUploadEmployeeId() != null) setUploadEmployeeId(b.getUploadEmployeeId());
		if(b.getUploadTime() != null) setUploadTime(b.getUploadTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseContractAttachment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractAttachment b = new BaseContractAttachment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractAttachment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploadEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploadTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setContractAttachmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractAttachmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractAttachmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAttachmentCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getAttachmentCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setAttachmentName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getAttachmentName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setFlag(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getFlag() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSigningMoneySum(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setUploadEmployeeId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getUploadEmployeeId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setUploadTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getUploadTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setConditionContractAttachmentId(String op, java.lang.Integer val) {
		setConditionContractAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionContractAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractAttachmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAttachmentCode(String op, java.lang.String val) {
		setConditionAttachmentCode(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAttachmentCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAttachmentName(String op, java.lang.String val) {
		setConditionAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAttachmentName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionFlag(String op, java.lang.Integer val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSigningMoneySum(String op, java.math.BigDecimal val) {
		setConditionSigningMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionSigningMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSigningMoneySum(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionUploadEmployeeId(String op, java.lang.Integer val) {
		setConditionUploadEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionUploadEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectUploadEmployeeId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionUploadTime(String op, java.util.Date val) {
		setConditionUploadTime(op, val, CONDITION_AND);
	}

	public void setConditionUploadTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUploadTime(boolean val) {
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


}

