package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseReimbursementPackage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ReimbursementPackage extends AbstractTable<BaseReimbursementPackage>
{

	public ReimbursementPackage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 18;

		initTables();

		__tableName            = "reimbursement_packages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseReimbursementPackage.CS_REIMBURSEMENT_PACKAGE_ID;
		__column_names[1] = BaseReimbursementPackage.CS_COMPANY_ID;
		__column_names[2] = BaseReimbursementPackage.CS_AMOUNT;
		__column_names[3] = BaseReimbursementPackage.CS_PAYMENT_AMOUNT;
		__column_names[4] = BaseReimbursementPackage.CS_STRIKE_A_BALANCE_AMOUNT;
		__column_names[5] = BaseReimbursementPackage.CS_IS_COMPLETED;
		__column_names[6] = BaseReimbursementPackage.CS_REMARK;
		__column_names[7] = BaseReimbursementPackage.CS_EMPLOYEE_ID;
		__column_names[8] = BaseReimbursementPackage.CS_ROLE_ID;
		__column_names[9] = BaseReimbursementPackage.CS_OPERATOR_ID;
		__column_names[10] = BaseReimbursementPackage.CS_CODE;
		__column_names[11] = BaseReimbursementPackage.CS_CREATE_TIME;
		__column_names[12] = BaseReimbursementPackage.CS_UPDATE_TIME;
		__column_names[13] = BaseReimbursementPackage.CS_PACKAGE_SIZE;
		__column_names[14] = BaseReimbursementPackage.CS_IS_ONLINE_PAY;
		__column_names[15] = BaseReimbursementPackage.CS_PAY_STATUS;
		__column_names[16] = BaseReimbursementPackage.CS_MAKE_BILL_TIME;
		__column_names[17] = BaseReimbursementPackage.CS_PAY_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseReimbursementPackage b) {
		clear();
		setReimbursementPackageIdClear(b.getReimbursementPackageId());
	}

	public boolean isPrimaryKeyNull() {
		return getReimbursementPackageId() == null;
	}

	@Override
	public BaseReimbursementPackage generateBase(){
		BaseReimbursementPackage b = new BaseReimbursementPackage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseReimbursementPackage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setReimbursementPackageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPaymentAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStrikeABalanceAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRoleId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPackageSize(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsOnlinePay(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setPayStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMakeBillTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPayTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseReimbursementPackage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getReimbursementPackageId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getAmount();
		buff[count++] = b.getPaymentAmount();
		buff[count++] = b.getStrikeABalanceAmount();
		buff[count++] = b.getIsCompleted();
		buff[count++] = b.getRemark();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getRoleId();
		buff[count++] = b.getOperatorId();
		buff[count++] = b.getCode();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getPackageSize();
		buff[count++] = b.getIsOnlinePay();
		buff[count++] = b.getPayStatus();
		buff[count++] = generateTimestampFromDate(b.getMakeBillTime());
		buff[count++] = generateTimestampFromDate(b.getPayTime());
	}

	@Override
	public void setDataFromBase(BaseReimbursementPackage b){
		if(b.getReimbursementPackageId() != null) setReimbursementPackageIdClear(b.getReimbursementPackageId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getPaymentAmount() != null) setPaymentAmount(b.getPaymentAmount());
		if(b.getStrikeABalanceAmount() != null) setStrikeABalanceAmount(b.getStrikeABalanceAmount());
		if(b.getIsCompleted() != null) setIsCompleted(b.getIsCompleted());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getRoleId() != null) setRoleId(b.getRoleId());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getPackageSize() != null) setPackageSize(b.getPackageSize());
		if(b.getIsOnlinePay() != null) setIsOnlinePay(b.getIsOnlinePay());
		if(b.getPayStatus() != null) setPayStatus(b.getPayStatus());
		if(b.getMakeBillTime() != null) setMakeBillTime(b.getMakeBillTime());
		if(b.getPayTime() != null) setPayTime(b.getPayTime());
	}

	@Override
	public BaseReimbursementPackage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseReimbursementPackage b = new BaseReimbursementPackage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseReimbursementPackage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementPackageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStrikeABalanceAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRoleId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPackageSize(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsOnlinePay(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMakeBillTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayTime(GenericBase.__getDateFromSQL(val));
	}

	public void setReimbursementPackageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getReimbursementPackageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setReimbursementPackageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setPaymentAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getPaymentAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setStrikeABalanceAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getStrikeABalanceAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setIsCompleted(java.lang.Boolean val) {
		setCurrentData(5, val);
	}

	public java.lang.Boolean getIsCompleted() {
		return GenericBase.__getBoolean(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setRoleId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getRoleId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setPackageSize(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getPackageSize() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setIsOnlinePay(java.lang.Boolean val) {
		setCurrentData(14, val);
	}

	public java.lang.Boolean getIsOnlinePay() {
		return GenericBase.__getBoolean(__current_data[14]);
	}

	public void setPayStatus(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getPayStatus() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setMakeBillTime(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getMakeBillTime() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setPayTime(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getPayTime() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setConditionReimbursementPackageId(String op, java.lang.Integer val) {
		setConditionReimbursementPackageId(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementPackageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectReimbursementPackageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPaymentAmount(String op, java.math.BigDecimal val) {
		setConditionPaymentAmount(op, val, CONDITION_AND);
	}

	public void setConditionPaymentAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPaymentAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionStrikeABalanceAmount(String op, java.math.BigDecimal val) {
		setConditionStrikeABalanceAmount(op, val, CONDITION_AND);
	}

	public void setConditionStrikeABalanceAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectStrikeABalanceAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val) {
		setConditionIsCompleted(op, val, CONDITION_AND);
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectIsCompleted(boolean val) {
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

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRoleId(String op, java.lang.Integer val) {
		setConditionRoleId(op, val, CONDITION_AND);
	}

	public void setConditionRoleId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectRoleId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionPackageSize(String op, java.lang.Integer val) {
		setConditionPackageSize(op, val, CONDITION_AND);
	}

	public void setConditionPackageSize(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectPackageSize(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionIsOnlinePay(String op, java.lang.Boolean val) {
		setConditionIsOnlinePay(op, val, CONDITION_AND);
	}

	public void setConditionIsOnlinePay(String op, java.lang.Boolean val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectIsOnlinePay(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionPayStatus(String op, java.lang.Integer val) {
		setConditionPayStatus(op, val, CONDITION_AND);
	}

	public void setConditionPayStatus(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectPayStatus(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionMakeBillTime(String op, java.util.Date val) {
		setConditionMakeBillTime(op, val, CONDITION_AND);
	}

	public void setConditionMakeBillTime(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectMakeBillTime(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionPayTime(String op, java.util.Date val) {
		setConditionPayTime(op, val, CONDITION_AND);
	}

	public void setConditionPayTime(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPayTime(boolean val) {
		__select_flags[17] = val;
	}


}

