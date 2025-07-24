package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseFinanceReceiveBill;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class FinanceReceiveBill extends AbstractTable<BaseFinanceReceiveBill>
{

	public FinanceReceiveBill() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "finance_receive_bills";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFinanceReceiveBill.CS_FINANCE_RECEIVE_BILL_ID;
		__column_names[1] = BaseFinanceReceiveBill.CS_COMPANY_ID;
		__column_names[2] = BaseFinanceReceiveBill.CS_DEPARTMENT_ID;
		__column_names[3] = BaseFinanceReceiveBill.CS_APPLICANT;
		__column_names[4] = BaseFinanceReceiveBill.CS_CODE;
		__column_names[5] = BaseFinanceReceiveBill.CS_PROCESS_TYPE;
		__column_names[6] = BaseFinanceReceiveBill.CS_BUSINESS_ID;
		__column_names[7] = BaseFinanceReceiveBill.CS_AMOUNT;
		__column_names[8] = BaseFinanceReceiveBill.CS_SENDEE;
		__column_names[9] = BaseFinanceReceiveBill.CS_HANDLE_PERSON;
		__column_names[10] = BaseFinanceReceiveBill.CS_REMARK;
		__column_names[11] = BaseFinanceReceiveBill.CS_DETAIL_REMARK;
		__column_names[12] = BaseFinanceReceiveBill.CS_RECEIVE_STATUS;
		__column_names[13] = BaseFinanceReceiveBill.CS_CREATE_TIME;
		__column_names[14] = BaseFinanceReceiveBill.CS_UPDATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFinanceReceiveBill b) {
		clear();
		setFinanceReceiveBillIdClear(b.getFinanceReceiveBillId());
	}

	public boolean isPrimaryKeyNull() {
		return getFinanceReceiveBillId() == null;
	}

	@Override
	public BaseFinanceReceiveBill generateBase(){
		BaseFinanceReceiveBill b = new BaseFinanceReceiveBill();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFinanceReceiveBill b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFinanceReceiveBillId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setApplicant(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSendee(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHandlePerson(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDetailRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReceiveStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseFinanceReceiveBill b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFinanceReceiveBillId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getApplicant();
		buff[count++] = b.getCode();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getAmount();
		buff[count++] = b.getSendee();
		buff[count++] = b.getHandlePerson();
		buff[count++] = b.getRemark();
		buff[count++] = b.getDetailRemark();
		buff[count++] = b.getReceiveStatus();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
	}

	@Override
	public void setDataFromBase(BaseFinanceReceiveBill b){
		if(b.getFinanceReceiveBillId() != null) setFinanceReceiveBillIdClear(b.getFinanceReceiveBillId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getApplicant() != null) setApplicant(b.getApplicant());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getSendee() != null) setSendee(b.getSendee());
		if(b.getHandlePerson() != null) setHandlePerson(b.getHandlePerson());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getDetailRemark() != null) setDetailRemark(b.getDetailRemark());
		if(b.getReceiveStatus() != null) setReceiveStatus(b.getReceiveStatus());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
	}

	@Override
	public BaseFinanceReceiveBill generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFinanceReceiveBill b = new BaseFinanceReceiveBill();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFinanceReceiveBill __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinanceReceiveBillId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplicant(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendee(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHandlePerson(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDetailRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setFinanceReceiveBillId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFinanceReceiveBillId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFinanceReceiveBillIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setApplicant(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getApplicant() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setSendee(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getSendee() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setHandlePerson(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getHandlePerson() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setDetailRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getDetailRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setReceiveStatus(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getReceiveStatus() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setConditionFinanceReceiveBillId(String op, java.lang.Integer val) {
		setConditionFinanceReceiveBillId(op, val, CONDITION_AND);
	}

	public void setConditionFinanceReceiveBillId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFinanceReceiveBillId(boolean val) {
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

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionApplicant(String op, java.lang.Integer val) {
		setConditionApplicant(op, val, CONDITION_AND);
	}

	public void setConditionApplicant(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectApplicant(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSendee(String op, java.lang.Integer val) {
		setConditionSendee(op, val, CONDITION_AND);
	}

	public void setConditionSendee(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSendee(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionHandlePerson(String op, java.lang.Integer val) {
		setConditionHandlePerson(op, val, CONDITION_AND);
	}

	public void setConditionHandlePerson(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectHandlePerson(boolean val) {
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

	public void setConditionDetailRemark(String op, java.lang.String val) {
		setConditionDetailRemark(op, val, CONDITION_AND);
	}

	public void setConditionDetailRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectDetailRemark(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionReceiveStatus(String op, java.lang.Integer val) {
		setConditionReceiveStatus(op, val, CONDITION_AND);
	}

	public void setConditionReceiveStatus(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectReceiveStatus(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
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

