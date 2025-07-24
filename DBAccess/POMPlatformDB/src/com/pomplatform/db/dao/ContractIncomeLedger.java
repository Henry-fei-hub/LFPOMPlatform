package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractIncomeLedger;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractIncomeLedger extends AbstractTable<BaseContractIncomeLedger>
{

	public ContractIncomeLedger() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 26;

		initTables();

		__tableName            = "contract_income_ledgers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractIncomeLedger.CS_CONTRACT_INCOME_LEDGER_ID;
		__column_names[1] = BaseContractIncomeLedger.CS_CONTRACT_ID;
		__column_names[2] = BaseContractIncomeLedger.CS_CONTRACT_CODE;
		__column_names[3] = BaseContractIncomeLedger.CS_CONTRACT_NAME;
		__column_names[4] = BaseContractIncomeLedger.CS_COMPANY_ID;
		__column_names[5] = BaseContractIncomeLedger.CS_CLIENT_ID;
		__column_names[6] = BaseContractIncomeLedger.CS_PROJECT_MANAGER;
		__column_names[7] = BaseContractIncomeLedger.CS_PLATE_MANAGER;
		__column_names[8] = BaseContractIncomeLedger.CS_SIGNING_MONEY_SUM;
		__column_names[9] = BaseContractIncomeLedger.CS_RECEIVE_CONTRACT_AMOUNT;
		__column_names[10] = BaseContractIncomeLedger.CS_UNRECEIVED_CONTRACT_AMOUNT;
		__column_names[11] = BaseContractIncomeLedger.CS_INVOICE_DATE;
		__column_names[12] = BaseContractIncomeLedger.CS_INVOICE_NUMBER;
		__column_names[13] = BaseContractIncomeLedger.CS_INVOICE_STAGE;
		__column_names[14] = BaseContractIncomeLedger.CS_INVOICE_AMOUNT;
		__column_names[15] = BaseContractIncomeLedger.CS_CURRENT_RECEIVE_AMOUNT;
		__column_names[16] = BaseContractIncomeLedger.CS_CURRENT_RECEIVE_DATE;
		__column_names[17] = BaseContractIncomeLedger.CS_CURRENT_RECEIVE_REMARK;
		__column_names[18] = BaseContractIncomeLedger.CS_PROJECT_STATUS;
		__column_names[19] = BaseContractIncomeLedger.CS_REMARK;
		__column_names[20] = BaseContractIncomeLedger.CS_CONTACTS;
		__column_names[21] = BaseContractIncomeLedger.CS_LEDGER_YEAR;
		__column_names[22] = BaseContractIncomeLedger.CS_LEDGER_MONTH;
		__column_names[23] = BaseContractIncomeLedger.CS_CREATE_TIME;
		__column_names[24] = BaseContractIncomeLedger.CS_UPDATE_TIME;
		__column_names[25] = BaseContractIncomeLedger.CS_IS_LOCKED;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractIncomeLedger b) {
		clear();
		setContractIncomeLedgerIdClear(b.getContractIncomeLedgerId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractIncomeLedgerId() == null;
	}

	@Override
	public BaseContractIncomeLedger generateBase(){
		BaseContractIncomeLedger b = new BaseContractIncomeLedger();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractIncomeLedger b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractIncomeLedgerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setClientId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectManager(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlateManager(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReceiveContractAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnreceivedContractAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInvoiceDate(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInvoiceNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInvoiceStage(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCurrentReceiveAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCurrentReceiveDate(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCurrentReceiveRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectStatus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContacts(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLedgerYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLedgerMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsLocked(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractIncomeLedger b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractIncomeLedgerId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getContractName();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getClientId();
		buff[count++] = b.getProjectManager();
		buff[count++] = b.getPlateManager();
		buff[count++] = b.getSigningMoneySum();
		buff[count++] = b.getReceiveContractAmount();
		buff[count++] = b.getUnreceivedContractAmount();
		buff[count++] = b.getInvoiceDate();
		buff[count++] = b.getInvoiceNumber();
		buff[count++] = b.getInvoiceStage();
		buff[count++] = b.getInvoiceAmount();
		buff[count++] = b.getCurrentReceiveAmount();
		buff[count++] = b.getCurrentReceiveDate();
		buff[count++] = b.getCurrentReceiveRemark();
		buff[count++] = b.getProjectStatus();
		buff[count++] = b.getRemark();
		buff[count++] = b.getContacts();
		buff[count++] = b.getLedgerYear();
		buff[count++] = b.getLedgerMonth();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getIsLocked();
	}

	@Override
	public void setDataFromBase(BaseContractIncomeLedger b){
		if(b.getContractIncomeLedgerId() != null) setContractIncomeLedgerIdClear(b.getContractIncomeLedgerId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getContractName() != null) setContractName(b.getContractName());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getClientId() != null) setClientId(b.getClientId());
		if(b.getProjectManager() != null) setProjectManager(b.getProjectManager());
		if(b.getPlateManager() != null) setPlateManager(b.getPlateManager());
		if(b.getSigningMoneySum() != null) setSigningMoneySum(b.getSigningMoneySum());
		if(b.getReceiveContractAmount() != null) setReceiveContractAmount(b.getReceiveContractAmount());
		if(b.getUnreceivedContractAmount() != null) setUnreceivedContractAmount(b.getUnreceivedContractAmount());
		if(b.getInvoiceDate() != null) setInvoiceDate(b.getInvoiceDate());
		if(b.getInvoiceNumber() != null) setInvoiceNumber(b.getInvoiceNumber());
		if(b.getInvoiceStage() != null) setInvoiceStage(b.getInvoiceStage());
		if(b.getInvoiceAmount() != null) setInvoiceAmount(b.getInvoiceAmount());
		if(b.getCurrentReceiveAmount() != null) setCurrentReceiveAmount(b.getCurrentReceiveAmount());
		if(b.getCurrentReceiveDate() != null) setCurrentReceiveDate(b.getCurrentReceiveDate());
		if(b.getCurrentReceiveRemark() != null) setCurrentReceiveRemark(b.getCurrentReceiveRemark());
		if(b.getProjectStatus() != null) setProjectStatus(b.getProjectStatus());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getContacts() != null) setContacts(b.getContacts());
		if(b.getLedgerYear() != null) setLedgerYear(b.getLedgerYear());
		if(b.getLedgerMonth() != null) setLedgerMonth(b.getLedgerMonth());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getIsLocked() != null) setIsLocked(b.getIsLocked());
	}

	@Override
	public BaseContractIncomeLedger generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractIncomeLedger b = new BaseContractIncomeLedger();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractIncomeLedger __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractIncomeLedgerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManager(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateManager(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveContractAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnreceivedContractAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceDate(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceStage(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrentReceiveAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrentReceiveDate(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrentReceiveRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectStatus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContacts(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLedgerYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLedgerMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
	}

	public void setContractIncomeLedgerId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractIncomeLedgerId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractIncomeLedgerIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setContractName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getContractName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setClientId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getClientId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setProjectManager(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getProjectManager() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setPlateManager(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getPlateManager() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setSigningMoneySum(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setReceiveContractAmount(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getReceiveContractAmount() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setUnreceivedContractAmount(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getUnreceivedContractAmount() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setInvoiceDate(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getInvoiceDate() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setInvoiceNumber(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getInvoiceNumber() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setInvoiceStage(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getInvoiceStage() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setInvoiceAmount(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setCurrentReceiveAmount(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getCurrentReceiveAmount() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setCurrentReceiveDate(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getCurrentReceiveDate() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setCurrentReceiveRemark(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getCurrentReceiveRemark() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setProjectStatus(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getProjectStatus() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setContacts(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getContacts() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setLedgerYear(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getLedgerYear() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setLedgerMonth(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getLedgerMonth() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(23, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[23]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(24, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[24]);
	}

	public void setIsLocked(java.lang.Boolean val) {
		setCurrentData(25, val);
	}

	public java.lang.Boolean getIsLocked() {
		return GenericBase.__getBoolean(__current_data[25]);
	}

	public void setConditionContractIncomeLedgerId(String op, java.lang.Integer val) {
		setConditionContractIncomeLedgerId(op, val, CONDITION_AND);
	}

	public void setConditionContractIncomeLedgerId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractIncomeLedgerId(boolean val) {
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

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContractName(String op, java.lang.String val) {
		setConditionContractName(op, val, CONDITION_AND);
	}

	public void setConditionContractName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractName(boolean val) {
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

	public void setConditionClientId(String op, java.lang.Integer val) {
		setConditionClientId(op, val, CONDITION_AND);
	}

	public void setConditionClientId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectClientId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionProjectManager(String op, java.lang.String val) {
		setConditionProjectManager(op, val, CONDITION_AND);
	}

	public void setConditionProjectManager(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProjectManager(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionPlateManager(String op, java.lang.String val) {
		setConditionPlateManager(op, val, CONDITION_AND);
	}

	public void setConditionPlateManager(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPlateManager(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSigningMoneySum(String op, java.math.BigDecimal val) {
		setConditionSigningMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionSigningMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSigningMoneySum(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionReceiveContractAmount(String op, java.math.BigDecimal val) {
		setConditionReceiveContractAmount(op, val, CONDITION_AND);
	}

	public void setConditionReceiveContractAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectReceiveContractAmount(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionUnreceivedContractAmount(String op, java.math.BigDecimal val) {
		setConditionUnreceivedContractAmount(op, val, CONDITION_AND);
	}

	public void setConditionUnreceivedContractAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectUnreceivedContractAmount(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionInvoiceDate(String op, java.lang.String val) {
		setConditionInvoiceDate(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceDate(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectInvoiceDate(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionInvoiceNumber(String op, java.lang.String val) {
		setConditionInvoiceNumber(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceNumber(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectInvoiceNumber(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionInvoiceStage(String op, java.lang.String val) {
		setConditionInvoiceStage(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceStage(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectInvoiceStage(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionInvoiceAmount(String op, java.math.BigDecimal val) {
		setConditionInvoiceAmount(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectInvoiceAmount(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionCurrentReceiveAmount(String op, java.math.BigDecimal val) {
		setConditionCurrentReceiveAmount(op, val, CONDITION_AND);
	}

	public void setConditionCurrentReceiveAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectCurrentReceiveAmount(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionCurrentReceiveDate(String op, java.lang.String val) {
		setConditionCurrentReceiveDate(op, val, CONDITION_AND);
	}

	public void setConditionCurrentReceiveDate(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectCurrentReceiveDate(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCurrentReceiveRemark(String op, java.lang.String val) {
		setConditionCurrentReceiveRemark(op, val, CONDITION_AND);
	}

	public void setConditionCurrentReceiveRemark(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectCurrentReceiveRemark(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionProjectStatus(String op, java.lang.String val) {
		setConditionProjectStatus(op, val, CONDITION_AND);
	}

	public void setConditionProjectStatus(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectProjectStatus(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionContacts(String op, java.lang.String val) {
		setConditionContacts(op, val, CONDITION_AND);
	}

	public void setConditionContacts(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectContacts(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionLedgerYear(String op, java.lang.Integer val) {
		setConditionLedgerYear(op, val, CONDITION_AND);
	}

	public void setConditionLedgerYear(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectLedgerYear(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionLedgerMonth(String op, java.lang.Integer val) {
		setConditionLedgerMonth(op, val, CONDITION_AND);
	}

	public void setConditionLedgerMonth(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectLedgerMonth(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(23, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(24, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val) {
		setConditionIsLocked(op, val, CONDITION_AND);
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectIsLocked(boolean val) {
		__select_flags[25] = val;
	}


}

