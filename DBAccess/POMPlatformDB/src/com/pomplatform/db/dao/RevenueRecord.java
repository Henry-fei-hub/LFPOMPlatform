package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseRevenueRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class RevenueRecord extends AbstractTable<BaseRevenueRecord>
{

	public RevenueRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 20;

		initTables();

		__tableName            = "revenue_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseRevenueRecord.CS_REVENUE_RECORD_ID;
		__column_names[1] = BaseRevenueRecord.CS_CONTRACT_ID;
		__column_names[2] = BaseRevenueRecord.CS_CODE;
		__column_names[3] = BaseRevenueRecord.CS_NAME;
		__column_names[4] = BaseRevenueRecord.CS_MONEY;
		__column_names[5] = BaseRevenueRecord.CS_FINISH_PERCENT;
		__column_names[6] = BaseRevenueRecord.CS_FINISH_PERCENT_VIEW;
		__column_names[7] = BaseRevenueRecord.CS_REVENUE_MONEY;
		__column_names[8] = BaseRevenueRecord.CS_INVOICE_AMOUNT;
		__column_names[9] = BaseRevenueRecord.CS_BORROW_MONEY;
		__column_names[10] = BaseRevenueRecord.CS_PARENT_ID;
		__column_names[11] = BaseRevenueRecord.CS_SIGNING_COMPANY;
		__column_names[12] = BaseRevenueRecord.CS_IS_FINISH;
		__column_names[13] = BaseRevenueRecord.CS_ACCOUNT_DATE;
		__column_names[14] = BaseRevenueRecord.CS_MONTH;
		__column_names[15] = BaseRevenueRecord.CS_FLAG;
		__column_names[16] = BaseRevenueRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[17] = BaseRevenueRecord.CS_OPERATE_TIME;
		__column_names[18] = BaseRevenueRecord.CS_FINISH_PERCENT_DETAIL;
		__column_names[19] = BaseRevenueRecord.CS_FINISH_PERCENT_DETAIL_VIEW;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseRevenueRecord b) {
		clear();
		setRevenueRecordIdClear(b.getRevenueRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getRevenueRecordId() == null;
	}

	@Override
	public BaseRevenueRecord generateBase(){
		BaseRevenueRecord b = new BaseRevenueRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseRevenueRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setRevenueRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinishPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinishPercentView(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRevenueMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSigningCompany(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsFinish(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setAccountDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setFinishPercentDetail(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinishPercentDetailView(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseRevenueRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getRevenueRecordId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getCode();
		buff[count++] = b.getName();
		buff[count++] = b.getMoney();
		buff[count++] = b.getFinishPercent();
		buff[count++] = b.getFinishPercentView();
		buff[count++] = b.getRevenueMoney();
		buff[count++] = b.getInvoiceAmount();
		buff[count++] = b.getBorrowMoney();
		buff[count++] = b.getParentId();
		buff[count++] = b.getSigningCompany();
		buff[count++] = b.getIsFinish();
		buff[count++] = generateTimestampFromDate(b.getAccountDate());
		buff[count++] = b.getMonth();
		buff[count++] = b.getFlag();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getFinishPercentDetail();
		buff[count++] = b.getFinishPercentDetailView();
	}

	@Override
	public void setDataFromBase(BaseRevenueRecord b){
		if(b.getRevenueRecordId() != null) setRevenueRecordIdClear(b.getRevenueRecordId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getName() != null) setName(b.getName());
		if(b.getMoney() != null) setMoney(b.getMoney());
		if(b.getFinishPercent() != null) setFinishPercent(b.getFinishPercent());
		if(b.getFinishPercentView() != null) setFinishPercentView(b.getFinishPercentView());
		if(b.getRevenueMoney() != null) setRevenueMoney(b.getRevenueMoney());
		if(b.getInvoiceAmount() != null) setInvoiceAmount(b.getInvoiceAmount());
		if(b.getBorrowMoney() != null) setBorrowMoney(b.getBorrowMoney());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getSigningCompany() != null) setSigningCompany(b.getSigningCompany());
		if(b.getIsFinish() != null) setIsFinish(b.getIsFinish());
		if(b.getAccountDate() != null) setAccountDate(b.getAccountDate());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getFlag() != null) setFlag(b.getFlag());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getFinishPercentDetail() != null) setFinishPercentDetail(b.getFinishPercentDetail());
		if(b.getFinishPercentDetailView() != null) setFinishPercentDetailView(b.getFinishPercentDetailView());
	}

	@Override
	public BaseRevenueRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseRevenueRecord b = new BaseRevenueRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseRevenueRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRevenueRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinishPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinishPercentView(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRevenueMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSigningCompany(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsFinish(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinishPercentDetail(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinishPercentDetailView(GenericBase.__getString(val));
	}

	public void setRevenueRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getRevenueRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setRevenueRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setMoney(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getMoney() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setFinishPercent(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getFinishPercent() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setFinishPercentView(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getFinishPercentView() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setRevenueMoney(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getRevenueMoney() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setInvoiceAmount(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setBorrowMoney(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getBorrowMoney() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setSigningCompany(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getSigningCompany() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setIsFinish(java.lang.Boolean val) {
		setCurrentData(12, val);
	}

	public java.lang.Boolean getIsFinish() {
		return GenericBase.__getBoolean(__current_data[12]);
	}

	public void setAccountDate(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getAccountDate() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setFlag(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getFlag() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setFinishPercentDetail(java.math.BigDecimal val) {
		setCurrentData(18, val);
	}

	public java.math.BigDecimal getFinishPercentDetail() {
		return GenericBase.__getDecimal(__current_data[18]);
	}

	public void setFinishPercentDetailView(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getFinishPercentDetailView() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setConditionRevenueRecordId(String op, java.lang.Integer val) {
		setConditionRevenueRecordId(op, val, CONDITION_AND);
	}

	public void setConditionRevenueRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectRevenueRecordId(boolean val) {
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

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionMoney(String op, java.math.BigDecimal val) {
		setConditionMoney(op, val, CONDITION_AND);
	}

	public void setConditionMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMoney(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionFinishPercent(String op, java.math.BigDecimal val) {
		setConditionFinishPercent(op, val, CONDITION_AND);
	}

	public void setConditionFinishPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectFinishPercent(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionFinishPercentView(String op, java.lang.String val) {
		setConditionFinishPercentView(op, val, CONDITION_AND);
	}

	public void setConditionFinishPercentView(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectFinishPercentView(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRevenueMoney(String op, java.math.BigDecimal val) {
		setConditionRevenueMoney(op, val, CONDITION_AND);
	}

	public void setConditionRevenueMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRevenueMoney(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionInvoiceAmount(String op, java.math.BigDecimal val) {
		setConditionInvoiceAmount(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectInvoiceAmount(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionBorrowMoney(String op, java.math.BigDecimal val) {
		setConditionBorrowMoney(op, val, CONDITION_AND);
	}

	public void setConditionBorrowMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectBorrowMoney(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSigningCompany(String op, java.lang.Integer val) {
		setConditionSigningCompany(op, val, CONDITION_AND);
	}

	public void setConditionSigningCompany(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSigningCompany(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionIsFinish(String op, java.lang.Boolean val) {
		setConditionIsFinish(op, val, CONDITION_AND);
	}

	public void setConditionIsFinish(String op, java.lang.Boolean val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectIsFinish(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionAccountDate(String op, java.util.Date val) {
		setConditionAccountDate(op, val, CONDITION_AND);
	}

	public void setConditionAccountDate(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAccountDate(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionFlag(String op, java.lang.Integer val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionFinishPercentDetail(String op, java.math.BigDecimal val) {
		setConditionFinishPercentDetail(op, val, CONDITION_AND);
	}

	public void setConditionFinishPercentDetail(String op, java.math.BigDecimal val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectFinishPercentDetail(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionFinishPercentDetailView(String op, java.lang.String val) {
		setConditionFinishPercentDetailView(op, val, CONDITION_AND);
	}

	public void setConditionFinishPercentDetailView(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectFinishPercentDetailView(boolean val) {
		__select_flags[19] = val;
	}


}

