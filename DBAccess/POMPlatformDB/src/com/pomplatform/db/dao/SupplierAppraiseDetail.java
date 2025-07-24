package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSupplierAppraiseDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SupplierAppraiseDetail extends AbstractTable<BaseSupplierAppraiseDetail>
{

	public SupplierAppraiseDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "supplier_appraise_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSupplierAppraiseDetail.CS_SUPPLIER_APPRAISE_DETAIL_ID;
		__column_names[1] = BaseSupplierAppraiseDetail.CS_SUPPLIER_ID;
		__column_names[2] = BaseSupplierAppraiseDetail.CS_SUPPLIER_APPRAISE_ID;
		__column_names[3] = BaseSupplierAppraiseDetail.CS_APPRAISE_TYPE;
		__column_names[4] = BaseSupplierAppraiseDetail.CS_SCORE_TYPE;
		__column_names[5] = BaseSupplierAppraiseDetail.CS_SCORE;
		__column_names[6] = BaseSupplierAppraiseDetail.CS_CREATE_EMPLOYEE_ID;
		__column_names[7] = BaseSupplierAppraiseDetail.CS_CREATE_TIME;
		__column_names[8] = BaseSupplierAppraiseDetail.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSupplierAppraiseDetail b) {
		clear();
		setSupplierAppraiseDetailIdClear(b.getSupplierAppraiseDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getSupplierAppraiseDetailId() == null;
	}

	@Override
	public BaseSupplierAppraiseDetail generateBase(){
		BaseSupplierAppraiseDetail b = new BaseSupplierAppraiseDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSupplierAppraiseDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSupplierAppraiseDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierAppraiseId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAppraiseType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setScoreType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setScore(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSupplierAppraiseDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSupplierAppraiseDetailId();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getSupplierAppraiseId();
		buff[count++] = b.getAppraiseType();
		buff[count++] = b.getScoreType();
		buff[count++] = b.getScore();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSupplierAppraiseDetail b){
		if(b.getSupplierAppraiseDetailId() != null) setSupplierAppraiseDetailIdClear(b.getSupplierAppraiseDetailId());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getSupplierAppraiseId() != null) setSupplierAppraiseId(b.getSupplierAppraiseId());
		if(b.getAppraiseType() != null) setAppraiseType(b.getAppraiseType());
		if(b.getScoreType() != null) setScoreType(b.getScoreType());
		if(b.getScore() != null) setScore(b.getScore());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSupplierAppraiseDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSupplierAppraiseDetail b = new BaseSupplierAppraiseDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSupplierAppraiseDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierAppraiseDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierAppraiseId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAppraiseType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setScoreType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setScore(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSupplierAppraiseDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSupplierAppraiseDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSupplierAppraiseDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSupplierAppraiseId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getSupplierAppraiseId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAppraiseType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getAppraiseType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setScoreType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getScoreType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setScore(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getScore() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setConditionSupplierAppraiseDetailId(String op, java.lang.Integer val) {
		setConditionSupplierAppraiseDetailId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierAppraiseDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSupplierAppraiseDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSupplierId(String op, java.lang.Integer val) {
		setConditionSupplierId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSupplierId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSupplierAppraiseId(String op, java.lang.Integer val) {
		setConditionSupplierAppraiseId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierAppraiseId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSupplierAppraiseId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAppraiseType(String op, java.lang.Integer val) {
		setConditionAppraiseType(op, val, CONDITION_AND);
	}

	public void setConditionAppraiseType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAppraiseType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionScoreType(String op, java.lang.Integer val) {
		setConditionScoreType(op, val, CONDITION_AND);
	}

	public void setConditionScoreType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectScoreType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionScore(String op, java.math.BigDecimal val) {
		setConditionScore(op, val, CONDITION_AND);
	}

	public void setConditionScore(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectScore(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[8] = val;
	}


}

