package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProcessBillList;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProcessBillList extends AbstractTable<BaseProcessBillList>
{

	public ProcessBillList() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 27;

		initTables();

		__tableName            = "process_bill_list";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProcessBillList.CS_PROCESS_BILL_LIST_ID;
		__column_names[1] = BaseProcessBillList.CS_PROCESS_INSTANCE_ID;
		__column_names[2] = BaseProcessBillList.CS_PROCESS_TYPE;
		__column_names[3] = BaseProcessBillList.CS_BUSINESS_ID;
		__column_names[4] = BaseProcessBillList.CS_PAY_FOR;
		__column_names[5] = BaseProcessBillList.CS_EMPLOYEE_OR_COMPANY_ID;
		__column_names[6] = BaseProcessBillList.CS_MONEY_ATTRIBUTE;
		__column_names[7] = BaseProcessBillList.CS_PAYEE_NAME;
		__column_names[8] = BaseProcessBillList.CS_SELF_BANK_NAME;
		__column_names[9] = BaseProcessBillList.CS_SELF_BANK_ACCOUNT;
		__column_names[10] = BaseProcessBillList.CS_OTHER_NAME;
		__column_names[11] = BaseProcessBillList.CS_OTHER_BANK_NAME;
		__column_names[12] = BaseProcessBillList.CS_OTHER_BANK_ACCOUNT;
		__column_names[13] = BaseProcessBillList.CS_PAY_MONEY;
		__column_names[14] = BaseProcessBillList.CS_BALANCE_AMOUNT;
		__column_names[15] = BaseProcessBillList.CS_IS_COMPLETE;
		__column_names[16] = BaseProcessBillList.CS_REMARK;
		__column_names[17] = BaseProcessBillList.CS_CREATE_TIME;
		__column_names[18] = BaseProcessBillList.CS_OPERATOR;
		__column_names[19] = BaseProcessBillList.CS_EQUIVALENT_NUMBER;
		__column_names[20] = BaseProcessBillList.CS_COMPANY_ID;
		__column_names[21] = BaseProcessBillList.CS_YEAR;
		__column_names[22] = BaseProcessBillList.CS_MONTH;
		__column_names[23] = BaseProcessBillList.CS_PAY_TYPE;
		__column_names[24] = BaseProcessBillList.CS_PERSONNEL_BUSINESS_ID;
		__column_names[25] = BaseProcessBillList.CS_FUNDRAISING_PROJECT_TYPE_ID;
		__column_names[26] = BaseProcessBillList.CS_EMPLOYEE_FUND_ISSUANCE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProcessBillList b) {
		clear();
		setProcessBillListIdClear(b.getProcessBillListId());
	}

	public boolean isPrimaryKeyNull() {
		return getProcessBillListId() == null;
	}

	@Override
	public BaseProcessBillList generateBase(){
		BaseProcessBillList b = new BaseProcessBillList();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProcessBillList b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProcessBillListId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayFor(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeOrCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMoneyAttribute(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSelfBankName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherName(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOtherBankName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPayMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBalanceAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsComplete(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEquivalentNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFundraisingProjectTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeFundIssuanceId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProcessBillList b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProcessBillListId();
		buff[count++] = b.getProcessInstanceId();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getPayFor();
		buff[count++] = b.getEmployeeOrCompanyId();
		buff[count++] = b.getMoneyAttribute();
		buff[count++] = b.getPayeeName();
		buff[count++] = b.getSelfBankName();
		buff[count++] = b.getSelfBankAccount();
		buff[count++] = b.getOtherName();
		buff[count++] = b.getOtherBankName();
		buff[count++] = b.getOtherBankAccount();
		buff[count++] = b.getPayMoney();
		buff[count++] = b.getBalanceAmount();
		buff[count++] = b.getIsComplete();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getOperator();
		buff[count++] = b.getEquivalentNumber();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getPayType();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getFundraisingProjectTypeId();
		buff[count++] = b.getEmployeeFundIssuanceId();
	}

	@Override
	public void setDataFromBase(BaseProcessBillList b){
		if(b.getProcessBillListId() != null) setProcessBillListIdClear(b.getProcessBillListId());
		if(b.getProcessInstanceId() != null) setProcessInstanceId(b.getProcessInstanceId());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getPayFor() != null) setPayFor(b.getPayFor());
		if(b.getEmployeeOrCompanyId() != null) setEmployeeOrCompanyId(b.getEmployeeOrCompanyId());
		if(b.getMoneyAttribute() != null) setMoneyAttribute(b.getMoneyAttribute());
		if(b.getPayeeName() != null) setPayeeName(b.getPayeeName());
		if(b.getSelfBankName() != null) setSelfBankName(b.getSelfBankName());
		if(b.getSelfBankAccount() != null) setSelfBankAccount(b.getSelfBankAccount());
		if(b.getOtherName() != null) setOtherName(b.getOtherName());
		if(b.getOtherBankName() != null) setOtherBankName(b.getOtherBankName());
		if(b.getOtherBankAccount() != null) setOtherBankAccount(b.getOtherBankAccount());
		if(b.getPayMoney() != null) setPayMoney(b.getPayMoney());
		if(b.getBalanceAmount() != null) setBalanceAmount(b.getBalanceAmount());
		if(b.getIsComplete() != null) setIsComplete(b.getIsComplete());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getEquivalentNumber() != null) setEquivalentNumber(b.getEquivalentNumber());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getPayType() != null) setPayType(b.getPayType());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getFundraisingProjectTypeId() != null) setFundraisingProjectTypeId(b.getFundraisingProjectTypeId());
		if(b.getEmployeeFundIssuanceId() != null) setEmployeeFundIssuanceId(b.getEmployeeFundIssuanceId());
	}

	@Override
	public BaseProcessBillList generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProcessBillList b = new BaseProcessBillList();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProcessBillList __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessBillListId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayFor(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeOrCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSelfBankName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherName(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherBankName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBalanceAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsComplete(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEquivalentNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFundraisingProjectTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeFundIssuanceId(GenericBase.__getInt(val));
	}

	public void setProcessBillListId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProcessBillListId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProcessBillListIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProcessInstanceId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProcessInstanceId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setPayFor(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getPayFor() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setEmployeeOrCompanyId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getEmployeeOrCompanyId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setMoneyAttribute(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getMoneyAttribute() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setPayeeName(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getPayeeName() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setSelfBankName(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getSelfBankName() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setSelfBankAccount(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getSelfBankAccount() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setOtherName(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getOtherName() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setOtherBankName(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getOtherBankName() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setOtherBankAccount(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getOtherBankAccount() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setPayMoney(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getPayMoney() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setBalanceAmount(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getBalanceAmount() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setIsComplete(java.lang.Boolean val) {
		setCurrentData(15, val);
	}

	public java.lang.Boolean getIsComplete() {
		return GenericBase.__getBoolean(__current_data[15]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setEquivalentNumber(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getEquivalentNumber() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setPayType(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getPayType() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(24, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setFundraisingProjectTypeId(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getFundraisingProjectTypeId() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setEmployeeFundIssuanceId(java.lang.Integer val) {
		setCurrentData(26, val);
	}

	public java.lang.Integer getEmployeeFundIssuanceId() {
		return GenericBase.__getInt(__current_data[26]);
	}

	public void setConditionProcessBillListId(String op, java.lang.Integer val) {
		setConditionProcessBillListId(op, val, CONDITION_AND);
	}

	public void setConditionProcessBillListId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProcessBillListId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val) {
		setConditionProcessInstanceId(op, val, CONDITION_AND);
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProcessInstanceId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPayFor(String op, java.lang.Integer val) {
		setConditionPayFor(op, val, CONDITION_AND);
	}

	public void setConditionPayFor(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPayFor(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionEmployeeOrCompanyId(String op, java.lang.Integer val) {
		setConditionEmployeeOrCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeOrCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectEmployeeOrCompanyId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMoneyAttribute(String op, java.lang.Integer val) {
		setConditionMoneyAttribute(op, val, CONDITION_AND);
	}

	public void setConditionMoneyAttribute(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMoneyAttribute(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionPayeeName(String op, java.lang.String val) {
		setConditionPayeeName(op, val, CONDITION_AND);
	}

	public void setConditionPayeeName(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPayeeName(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSelfBankName(String op, java.lang.String val) {
		setConditionSelfBankName(op, val, CONDITION_AND);
	}

	public void setConditionSelfBankName(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSelfBankName(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionSelfBankAccount(String op, java.lang.String val) {
		setConditionSelfBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionSelfBankAccount(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectSelfBankAccount(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOtherName(String op, java.lang.Integer val) {
		setConditionOtherName(op, val, CONDITION_AND);
	}

	public void setConditionOtherName(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOtherName(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOtherBankName(String op, java.lang.String val) {
		setConditionOtherBankName(op, val, CONDITION_AND);
	}

	public void setConditionOtherBankName(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectOtherBankName(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionOtherBankAccount(String op, java.lang.String val) {
		setConditionOtherBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionOtherBankAccount(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectOtherBankAccount(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionPayMoney(String op, java.math.BigDecimal val) {
		setConditionPayMoney(op, val, CONDITION_AND);
	}

	public void setConditionPayMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectPayMoney(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionBalanceAmount(String op, java.math.BigDecimal val) {
		setConditionBalanceAmount(op, val, CONDITION_AND);
	}

	public void setConditionBalanceAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectBalanceAmount(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionIsComplete(String op, java.lang.Boolean val) {
		setConditionIsComplete(op, val, CONDITION_AND);
	}

	public void setConditionIsComplete(String op, java.lang.Boolean val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectIsComplete(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionEquivalentNumber(String op, java.lang.String val) {
		setConditionEquivalentNumber(op, val, CONDITION_AND);
	}

	public void setConditionEquivalentNumber(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectEquivalentNumber(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionPayType(String op, java.lang.Integer val) {
		setConditionPayType(op, val, CONDITION_AND);
	}

	public void setConditionPayType(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectPayType(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionFundraisingProjectTypeId(String op, java.lang.Integer val) {
		setConditionFundraisingProjectTypeId(op, val, CONDITION_AND);
	}

	public void setConditionFundraisingProjectTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectFundraisingProjectTypeId(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionEmployeeFundIssuanceId(String op, java.lang.Integer val) {
		setConditionEmployeeFundIssuanceId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeFundIssuanceId(String op, java.lang.Integer val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectEmployeeFundIssuanceId(boolean val) {
		__select_flags[26] = val;
	}


}

