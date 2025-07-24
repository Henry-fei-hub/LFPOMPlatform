package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSupplierApprais;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SupplierApprais extends AbstractTable<BaseSupplierApprais>
{

	public SupplierApprais() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "supplier_appraises";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSupplierApprais.CS_SUPPLIER_APPRAISE_ID;
		__column_names[1] = BaseSupplierApprais.CS_SUPPLIER_ID;
		__column_names[2] = BaseSupplierApprais.CS_TITLE;
		__column_names[3] = BaseSupplierApprais.CS_PROVIDE_PRODUCT;
		__column_names[4] = BaseSupplierApprais.CS_SCORE;
		__column_names[5] = BaseSupplierApprais.CS_REASON;
		__column_names[6] = BaseSupplierApprais.CS_APPRAISE_STATUS;
		__column_names[7] = BaseSupplierApprais.CS_ADVICE;
		__column_names[8] = BaseSupplierApprais.CS_FINISH_TIME;
		__column_names[9] = BaseSupplierApprais.CS_CREATE_EMPLOYEE_ID;
		__column_names[10] = BaseSupplierApprais.CS_CREATE_TIME;
		__column_names[11] = BaseSupplierApprais.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSupplierApprais b) {
		clear();
		setSupplierAppraiseIdClear(b.getSupplierAppraiseId());
	}

	public boolean isPrimaryKeyNull() {
		return getSupplierAppraiseId() == null;
	}

	@Override
	public BaseSupplierApprais generateBase(){
		BaseSupplierApprais b = new BaseSupplierApprais();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSupplierApprais b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSupplierAppraiseId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTitle(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProvideProduct(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setScore(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReason(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAppraiseStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAdvice(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFinishTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSupplierApprais b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSupplierAppraiseId();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getTitle();
		buff[count++] = b.getProvideProduct();
		buff[count++] = b.getScore();
		buff[count++] = b.getReason();
		buff[count++] = b.getAppraiseStatus();
		buff[count++] = b.getAdvice();
		buff[count++] = generateTimestampFromDate(b.getFinishTime());
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSupplierApprais b){
		if(b.getSupplierAppraiseId() != null) setSupplierAppraiseIdClear(b.getSupplierAppraiseId());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getTitle() != null) setTitle(b.getTitle());
		if(b.getProvideProduct() != null) setProvideProduct(b.getProvideProduct());
		if(b.getScore() != null) setScore(b.getScore());
		if(b.getReason() != null) setReason(b.getReason());
		if(b.getAppraiseStatus() != null) setAppraiseStatus(b.getAppraiseStatus());
		if(b.getAdvice() != null) setAdvice(b.getAdvice());
		if(b.getFinishTime() != null) setFinishTime(b.getFinishTime());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSupplierApprais generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSupplierApprais b = new BaseSupplierApprais();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSupplierApprais __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierAppraiseId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTitle(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvideProduct(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setScore(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReason(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAppraiseStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdvice(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinishTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSupplierAppraiseId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSupplierAppraiseId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSupplierAppraiseIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setTitle(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getTitle() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProvideProduct(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProvideProduct() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setScore(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getScore() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setReason(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getReason() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setAppraiseStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getAppraiseStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setAdvice(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getAdvice() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setFinishTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getFinishTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setConditionSupplierAppraiseId(String op, java.lang.Integer val) {
		setConditionSupplierAppraiseId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierAppraiseId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSupplierAppraiseId(boolean val) {
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

	public void setConditionTitle(String op, java.lang.String val) {
		setConditionTitle(op, val, CONDITION_AND);
	}

	public void setConditionTitle(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTitle(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProvideProduct(String op, java.lang.String val) {
		setConditionProvideProduct(op, val, CONDITION_AND);
	}

	public void setConditionProvideProduct(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProvideProduct(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionScore(String op, java.math.BigDecimal val) {
		setConditionScore(op, val, CONDITION_AND);
	}

	public void setConditionScore(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectScore(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionReason(String op, java.lang.String val) {
		setConditionReason(op, val, CONDITION_AND);
	}

	public void setConditionReason(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectReason(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAppraiseStatus(String op, java.lang.Integer val) {
		setConditionAppraiseStatus(op, val, CONDITION_AND);
	}

	public void setConditionAppraiseStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAppraiseStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionAdvice(String op, java.lang.String val) {
		setConditionAdvice(op, val, CONDITION_AND);
	}

	public void setConditionAdvice(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAdvice(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionFinishTime(String op, java.util.Date val) {
		setConditionFinishTime(op, val, CONDITION_AND);
	}

	public void setConditionFinishTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectFinishTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[11] = val;
	}


}

