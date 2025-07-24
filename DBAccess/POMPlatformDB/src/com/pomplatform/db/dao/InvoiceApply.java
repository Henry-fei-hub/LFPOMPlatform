package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseInvoiceApply;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class InvoiceApply extends AbstractTable<BaseInvoiceApply>
{

	public InvoiceApply() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 26;

		initTables();

		__tableName            = "invoice_apply";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseInvoiceApply.CS_INVOICE_APPLY_ID;
		__column_names[1] = BaseInvoiceApply.CS_APPLICANT_ID;
		__column_names[2] = BaseInvoiceApply.CS_APPLICANT_DEPARMENT_ID;
		__column_names[3] = BaseInvoiceApply.CS_CONTRACT_ID;
		__column_names[4] = BaseInvoiceApply.CS_INVOICE_TYPE;
		__column_names[5] = BaseInvoiceApply.CS_COMPANY_NAME;
		__column_names[6] = BaseInvoiceApply.CS_DUTY_PARAGRAPH;
		__column_names[7] = BaseInvoiceApply.CS_CUSTOMER_NAME;
		__column_names[8] = BaseInvoiceApply.CS_CUSTOMER_PHONE;
		__column_names[9] = BaseInvoiceApply.CS_REGISTERED_ADDRESS;
		__column_names[10] = BaseInvoiceApply.CS_BANK_NAME;
		__column_names[11] = BaseInvoiceApply.CS_BANK_ACCOUNT;
		__column_names[12] = BaseInvoiceApply.CS_APPLY_TIME;
		__column_names[13] = BaseInvoiceApply.CS_APPLY_SUM_MONEY;
		__column_names[14] = BaseInvoiceApply.CS_APPLY_REMARK;
		__column_names[15] = BaseInvoiceApply.CS_OPERATOR_ID;
		__column_names[16] = BaseInvoiceApply.CS_OPERATOR_TIME;
		__column_names[17] = BaseInvoiceApply.CS_OPERATOR_REMARK;
		__column_names[18] = BaseInvoiceApply.CS_INVOICE_APPLY_STATUS;
		__column_names[19] = BaseInvoiceApply.CS_CREATE_TIME;
		__column_names[20] = BaseInvoiceApply.CS_UPDATE_TIME;
		__column_names[21] = BaseInvoiceApply.CS_QQ;
		__column_names[22] = BaseInvoiceApply.CS_EMAIL;
		__column_names[23] = BaseInvoiceApply.CS_LANDLINE;
		__column_names[24] = BaseInvoiceApply.CS_FAX;
		__column_names[25] = BaseInvoiceApply.CS_DELETE_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseInvoiceApply b) {
		clear();
		setInvoiceApplyIdClear(b.getInvoiceApplyId());
	}

	public boolean isPrimaryKeyNull() {
		return getInvoiceApplyId() == null;
	}

	@Override
	public BaseInvoiceApply generateBase(){
		BaseInvoiceApply b = new BaseInvoiceApply();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseInvoiceApply b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setInvoiceApplyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setApplicantId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setApplicantDeparmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDutyParagraph(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCustomerName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCustomerPhone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRegisteredAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBankName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setApplySumMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setApplyRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatorTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperatorRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInvoiceApplyStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setQq(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmail(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLandline(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseInvoiceApply b, Object[] buff){
		int count = 0;
		buff[count++] = b.getInvoiceApplyId();
		buff[count++] = b.getApplicantId();
		buff[count++] = b.getApplicantDeparmentId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getInvoiceType();
		buff[count++] = b.getCompanyName();
		buff[count++] = b.getDutyParagraph();
		buff[count++] = b.getCustomerName();
		buff[count++] = b.getCustomerPhone();
		buff[count++] = b.getRegisteredAddress();
		buff[count++] = b.getBankName();
		buff[count++] = b.getBankAccount();
		buff[count++] = generateTimestampFromDate(b.getApplyTime());
		buff[count++] = b.getApplySumMoney();
		buff[count++] = b.getApplyRemark();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getOperatorTime());
		buff[count++] = b.getOperatorRemark();
		buff[count++] = b.getInvoiceApplyStatus();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getQq();
		buff[count++] = b.getEmail();
		buff[count++] = b.getLandline();
		buff[count++] = b.getFax();
		buff[count++] = b.getDeleteFlag();
	}

	@Override
	public void setDataFromBase(BaseInvoiceApply b){
		if(b.getInvoiceApplyId() != null) setInvoiceApplyIdClear(b.getInvoiceApplyId());
		if(b.getApplicantId() != null) setApplicantId(b.getApplicantId());
		if(b.getApplicantDeparmentId() != null) setApplicantDeparmentId(b.getApplicantDeparmentId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getInvoiceType() != null) setInvoiceType(b.getInvoiceType());
		if(b.getCompanyName() != null) setCompanyName(b.getCompanyName());
		if(b.getDutyParagraph() != null) setDutyParagraph(b.getDutyParagraph());
		if(b.getCustomerName() != null) setCustomerName(b.getCustomerName());
		if(b.getCustomerPhone() != null) setCustomerPhone(b.getCustomerPhone());
		if(b.getRegisteredAddress() != null) setRegisteredAddress(b.getRegisteredAddress());
		if(b.getBankName() != null) setBankName(b.getBankName());
		if(b.getBankAccount() != null) setBankAccount(b.getBankAccount());
		if(b.getApplyTime() != null) setApplyTime(b.getApplyTime());
		if(b.getApplySumMoney() != null) setApplySumMoney(b.getApplySumMoney());
		if(b.getApplyRemark() != null) setApplyRemark(b.getApplyRemark());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getOperatorTime() != null) setOperatorTime(b.getOperatorTime());
		if(b.getOperatorRemark() != null) setOperatorRemark(b.getOperatorRemark());
		if(b.getInvoiceApplyStatus() != null) setInvoiceApplyStatus(b.getInvoiceApplyStatus());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getQq() != null) setQq(b.getQq());
		if(b.getEmail() != null) setEmail(b.getEmail());
		if(b.getLandline() != null) setLandline(b.getLandline());
		if(b.getFax() != null) setFax(b.getFax());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
	}

	@Override
	public BaseInvoiceApply generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseInvoiceApply b = new BaseInvoiceApply();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseInvoiceApply __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceApplyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplicantId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplicantDeparmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDutyParagraph(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerPhone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegisteredAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplySumMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceApplyStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setQq(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmail(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLandline(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
	}

	public void setInvoiceApplyId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getInvoiceApplyId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setInvoiceApplyIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setApplicantId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getApplicantId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setApplicantDeparmentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getApplicantDeparmentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setInvoiceType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getInvoiceType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCompanyName(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getCompanyName() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setDutyParagraph(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getDutyParagraph() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setCustomerName(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getCustomerName() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setCustomerPhone(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getCustomerPhone() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setRegisteredAddress(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRegisteredAddress() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setBankName(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getBankName() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setBankAccount(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getBankAccount() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setApplyTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getApplyTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setApplySumMoney(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getApplySumMoney() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setApplyRemark(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getApplyRemark() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setOperatorTime(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getOperatorTime() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setOperatorRemark(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getOperatorRemark() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setInvoiceApplyStatus(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getInvoiceApplyStatus() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(19, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[19]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(20, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[20]);
	}

	public void setQq(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getQq() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setEmail(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getEmail() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setLandline(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getLandline() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setFax(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getFax() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setConditionInvoiceApplyId(String op, java.lang.Integer val) {
		setConditionInvoiceApplyId(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceApplyId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectInvoiceApplyId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionApplicantId(String op, java.lang.Integer val) {
		setConditionApplicantId(op, val, CONDITION_AND);
	}

	public void setConditionApplicantId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectApplicantId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionApplicantDeparmentId(String op, java.lang.Integer val) {
		setConditionApplicantDeparmentId(op, val, CONDITION_AND);
	}

	public void setConditionApplicantDeparmentId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectApplicantDeparmentId(boolean val) {
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

	public void setConditionInvoiceType(String op, java.lang.Integer val) {
		setConditionInvoiceType(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectInvoiceType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCompanyName(String op, java.lang.String val) {
		setConditionCompanyName(op, val, CONDITION_AND);
	}

	public void setConditionCompanyName(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCompanyName(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDutyParagraph(String op, java.lang.String val) {
		setConditionDutyParagraph(op, val, CONDITION_AND);
	}

	public void setConditionDutyParagraph(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDutyParagraph(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCustomerName(String op, java.lang.String val) {
		setConditionCustomerName(op, val, CONDITION_AND);
	}

	public void setConditionCustomerName(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCustomerName(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCustomerPhone(String op, java.lang.String val) {
		setConditionCustomerPhone(op, val, CONDITION_AND);
	}

	public void setConditionCustomerPhone(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCustomerPhone(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRegisteredAddress(String op, java.lang.String val) {
		setConditionRegisteredAddress(op, val, CONDITION_AND);
	}

	public void setConditionRegisteredAddress(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRegisteredAddress(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionBankName(String op, java.lang.String val) {
		setConditionBankName(op, val, CONDITION_AND);
	}

	public void setConditionBankName(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectBankName(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionBankAccount(String op, java.lang.String val) {
		setConditionBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionBankAccount(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectBankAccount(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionApplyTime(String op, java.util.Date val) {
		setConditionApplyTime(op, val, CONDITION_AND);
	}

	public void setConditionApplyTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectApplyTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionApplySumMoney(String op, java.math.BigDecimal val) {
		setConditionApplySumMoney(op, val, CONDITION_AND);
	}

	public void setConditionApplySumMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectApplySumMoney(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionApplyRemark(String op, java.lang.String val) {
		setConditionApplyRemark(op, val, CONDITION_AND);
	}

	public void setConditionApplyRemark(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectApplyRemark(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionOperatorTime(String op, java.util.Date val) {
		setConditionOperatorTime(op, val, CONDITION_AND);
	}

	public void setConditionOperatorTime(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperatorTime(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionOperatorRemark(String op, java.lang.String val) {
		setConditionOperatorRemark(op, val, CONDITION_AND);
	}

	public void setConditionOperatorRemark(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectOperatorRemark(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionInvoiceApplyStatus(String op, java.lang.Integer val) {
		setConditionInvoiceApplyStatus(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceApplyStatus(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectInvoiceApplyStatus(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(19, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(20, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionQq(String op, java.lang.String val) {
		setConditionQq(op, val, CONDITION_AND);
	}

	public void setConditionQq(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectQq(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionEmail(String op, java.lang.String val) {
		setConditionEmail(op, val, CONDITION_AND);
	}

	public void setConditionEmail(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectEmail(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionLandline(String op, java.lang.String val) {
		setConditionLandline(op, val, CONDITION_AND);
	}

	public void setConditionLandline(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectLandline(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionFax(String op, java.lang.String val) {
		setConditionFax(op, val, CONDITION_AND);
	}

	public void setConditionFax(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectFax(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[25] = val;
	}


}

