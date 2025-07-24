package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePaymentTemplateDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PaymentTemplateDetail extends AbstractTable<BasePaymentTemplateDetail>
{

	public PaymentTemplateDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "payment_template_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePaymentTemplateDetail.CS_PAYMENT_TEMPLATE_DETAIL_ID;
		__column_names[1] = BasePaymentTemplateDetail.CS_PAYMENT_TEMPLATE_ID;
		__column_names[2] = BasePaymentTemplateDetail.CS_PAYMENT_NAME;
		__column_names[3] = BasePaymentTemplateDetail.CS_DELAY_DAY;
		__column_names[4] = BasePaymentTemplateDetail.CS_ORDER_NUM;
		__column_names[5] = BasePaymentTemplateDetail.CS_CREATE_TIME;
		__column_names[6] = BasePaymentTemplateDetail.CS_PAYMENT_CONDITION;
		__column_names[7] = BasePaymentTemplateDetail.CS_REMARK;
		__column_names[8] = BasePaymentTemplateDetail.CS_PAYMENT_RATIO;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePaymentTemplateDetail b) {
		clear();
		setPaymentTemplateDetailIdClear(b.getPaymentTemplateDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getPaymentTemplateDetailId() == null;
	}

	@Override
	public BasePaymentTemplateDetail generateBase(){
		BasePaymentTemplateDetail b = new BasePaymentTemplateDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePaymentTemplateDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPaymentTemplateDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPaymentTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPaymentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDelayDay(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPaymentCondition(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPaymentRatio(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BasePaymentTemplateDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPaymentTemplateDetailId();
		buff[count++] = b.getPaymentTemplateId();
		buff[count++] = b.getPaymentName();
		buff[count++] = b.getDelayDay();
		buff[count++] = b.getOrderNum();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getPaymentCondition();
		buff[count++] = b.getRemark();
		buff[count++] = b.getPaymentRatio();
	}

	@Override
	public void setDataFromBase(BasePaymentTemplateDetail b){
		if(b.getPaymentTemplateDetailId() != null) setPaymentTemplateDetailIdClear(b.getPaymentTemplateDetailId());
		if(b.getPaymentTemplateId() != null) setPaymentTemplateId(b.getPaymentTemplateId());
		if(b.getPaymentName() != null) setPaymentName(b.getPaymentName());
		if(b.getDelayDay() != null) setDelayDay(b.getDelayDay());
		if(b.getOrderNum() != null) setOrderNum(b.getOrderNum());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getPaymentCondition() != null) setPaymentCondition(b.getPaymentCondition());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getPaymentRatio() != null) setPaymentRatio(b.getPaymentRatio());
	}

	@Override
	public BasePaymentTemplateDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePaymentTemplateDetail b = new BasePaymentTemplateDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePaymentTemplateDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentTemplateDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDelayDay(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentCondition(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentRatio(GenericBase.__getDecimal(val));
	}

	public void setPaymentTemplateDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPaymentTemplateDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPaymentTemplateDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPaymentTemplateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPaymentTemplateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPaymentName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getPaymentName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setDelayDay(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDelayDay() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setOrderNum(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOrderNum() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setPaymentCondition(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getPaymentCondition() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setPaymentRatio(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getPaymentRatio() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setConditionPaymentTemplateDetailId(String op, java.lang.Integer val) {
		setConditionPaymentTemplateDetailId(op, val, CONDITION_AND);
	}

	public void setConditionPaymentTemplateDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPaymentTemplateDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPaymentTemplateId(String op, java.lang.Integer val) {
		setConditionPaymentTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionPaymentTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPaymentTemplateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPaymentName(String op, java.lang.String val) {
		setConditionPaymentName(op, val, CONDITION_AND);
	}

	public void setConditionPaymentName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPaymentName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDelayDay(String op, java.lang.Integer val) {
		setConditionDelayDay(op, val, CONDITION_AND);
	}

	public void setConditionDelayDay(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDelayDay(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOrderNum(String op, java.lang.Integer val) {
		setConditionOrderNum(op, val, CONDITION_AND);
	}

	public void setConditionOrderNum(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOrderNum(boolean val) {
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

	public void setConditionPaymentCondition(String op, java.lang.String val) {
		setConditionPaymentCondition(op, val, CONDITION_AND);
	}

	public void setConditionPaymentCondition(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPaymentCondition(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionPaymentRatio(String op, java.math.BigDecimal val) {
		setConditionPaymentRatio(op, val, CONDITION_AND);
	}

	public void setConditionPaymentRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectPaymentRatio(boolean val) {
		__select_flags[8] = val;
	}


}

