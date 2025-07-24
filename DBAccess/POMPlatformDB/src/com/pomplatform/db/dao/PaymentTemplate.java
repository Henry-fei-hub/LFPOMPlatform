package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePaymentTemplate;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PaymentTemplate extends AbstractTable<BasePaymentTemplate>
{

	public PaymentTemplate() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "payment_templates";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePaymentTemplate.CS_PAYMENT_TEMPLATE_ID;
		__column_names[1] = BasePaymentTemplate.CS_TEMPLATE_NAME;
		__column_names[2] = BasePaymentTemplate.CS_PAYMENT_CYCLE;
		__column_names[3] = BasePaymentTemplate.CS_REMARK;
		__column_names[4] = BasePaymentTemplate.CS_OPERATOR_ID;
		__column_names[5] = BasePaymentTemplate.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePaymentTemplate b) {
		clear();
		setPaymentTemplateIdClear(b.getPaymentTemplateId());
	}

	public boolean isPrimaryKeyNull() {
		return getPaymentTemplateId() == null;
	}

	@Override
	public BasePaymentTemplate generateBase(){
		BasePaymentTemplate b = new BasePaymentTemplate();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePaymentTemplate b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPaymentTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTemplateName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPaymentCycle(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BasePaymentTemplate b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPaymentTemplateId();
		buff[count++] = b.getTemplateName();
		buff[count++] = b.getPaymentCycle();
		buff[count++] = b.getRemark();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BasePaymentTemplate b){
		if(b.getPaymentTemplateId() != null) setPaymentTemplateIdClear(b.getPaymentTemplateId());
		if(b.getTemplateName() != null) setTemplateName(b.getTemplateName());
		if(b.getPaymentCycle() != null) setPaymentCycle(b.getPaymentCycle());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BasePaymentTemplate generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePaymentTemplate b = new BasePaymentTemplate();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePaymentTemplate __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTemplateName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentCycle(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setPaymentTemplateId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPaymentTemplateId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPaymentTemplateIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTemplateName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getTemplateName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setPaymentCycle(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPaymentCycle() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionPaymentTemplateId(String op, java.lang.Integer val) {
		setConditionPaymentTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionPaymentTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPaymentTemplateId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionTemplateName(String op, java.lang.String val) {
		setConditionTemplateName(op, val, CONDITION_AND);
	}

	public void setConditionTemplateName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectTemplateName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPaymentCycle(String op, java.lang.Integer val) {
		setConditionPaymentCycle(op, val, CONDITION_AND);
	}

	public void setConditionPaymentCycle(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPaymentCycle(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[5] = val;
	}


}

