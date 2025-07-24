package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseProductionValueCoefficient;


public class ProductionValueCoefficient extends AbstractTable<BaseProductionValueCoefficient>
{

	public ProductionValueCoefficient() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "production_value_coefficients";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProductionValueCoefficient.CS_PRODUCTION_VALUE_COEFFICIENT_ID;
		__column_names[1] = BaseProductionValueCoefficient.CS_PRODUCTION_VALUE_COEFFICIENT_TYPE_ID;
		__column_names[2] = BaseProductionValueCoefficient.CS_PRODUCTION_MIN;
		__column_names[3] = BaseProductionValueCoefficient.CS_PRODUCTION_MAX;
		__column_names[4] = BaseProductionValueCoefficient.CS_INTERVAL_LINES;
		__column_names[5] = BaseProductionValueCoefficient.CS_COEFFICIENT;
		__column_names[6] = BaseProductionValueCoefficient.CS_EMPLOYEE_ID;
		__column_names[7] = BaseProductionValueCoefficient.CS_OPERATION_TIME;
		__column_names[8] = BaseProductionValueCoefficient.CS_CREATE_TIME;
		__column_names[9] = BaseProductionValueCoefficient.CS_INTERVAL_RANGE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProductionValueCoefficient b) {
		clear();
		setProductionValueCoefficientIdClear(b.getProductionValueCoefficientId());
	}

	public boolean isPrimaryKeyNull() {
		return getProductionValueCoefficientId() == null;
	}

	@Override
	public BaseProductionValueCoefficient generateBase(){
		BaseProductionValueCoefficient b = new BaseProductionValueCoefficient();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProductionValueCoefficient b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProductionValueCoefficientId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductionValueCoefficientTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductionMin(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProductionMax(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIntervalLines(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCoefficient(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperationTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIntervalRange(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProductionValueCoefficient b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProductionValueCoefficientId();
		buff[count++] = b.getProductionValueCoefficientTypeId();
		buff[count++] = b.getProductionMin();
		buff[count++] = b.getProductionMax();
		buff[count++] = b.getIntervalLines();
		buff[count++] = b.getCoefficient();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperationTime());
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getIntervalRange();
	}

	@Override
	public void setDataFromBase(BaseProductionValueCoefficient b){
		if(b.getProductionValueCoefficientId() != null) setProductionValueCoefficientIdClear(b.getProductionValueCoefficientId());
		if(b.getProductionValueCoefficientTypeId() != null) setProductionValueCoefficientTypeId(b.getProductionValueCoefficientTypeId());
		if(b.getProductionMin() != null) setProductionMin(b.getProductionMin());
		if(b.getProductionMax() != null) setProductionMax(b.getProductionMax());
		if(b.getIntervalLines() != null) setIntervalLines(b.getIntervalLines());
		if(b.getCoefficient() != null) setCoefficient(b.getCoefficient());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getOperationTime() != null) setOperationTime(b.getOperationTime());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getIntervalRange() != null) setIntervalRange(b.getIntervalRange());
	}

	@Override
	public BaseProductionValueCoefficient generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProductionValueCoefficient b = new BaseProductionValueCoefficient();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProductionValueCoefficient __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductionValueCoefficientId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductionValueCoefficientTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductionMin(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductionMax(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIntervalLines(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCoefficient(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperationTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIntervalRange(GenericBase.__getString(val));
	}

	public void setProductionValueCoefficientId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProductionValueCoefficientId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProductionValueCoefficientIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProductionValueCoefficientTypeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProductionValueCoefficientTypeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProductionMin(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getProductionMin() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setProductionMax(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getProductionMax() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setIntervalLines(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getIntervalLines() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setCoefficient(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getCoefficient() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setOperationTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getOperationTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setIntervalRange(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getIntervalRange() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionProductionValueCoefficientId(String op, java.lang.Integer val) {
		setConditionProductionValueCoefficientId(op, val, CONDITION_AND);
	}

	public void setConditionProductionValueCoefficientId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProductionValueCoefficientId(boolean val) {
		__select_flags[0] = val;
	}

	public void setProductionValueCoefficientIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionProductionValueCoefficientTypeId(String op, java.lang.Integer val) {
		setConditionProductionValueCoefficientTypeId(op, val, CONDITION_AND);
	}

	public void setConditionProductionValueCoefficientTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProductionValueCoefficientTypeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setProductionValueCoefficientTypeIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionProductionMin(String op, java.math.BigDecimal val) {
		setConditionProductionMin(op, val, CONDITION_AND);
	}

	public void setConditionProductionMin(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProductionMin(boolean val) {
		__select_flags[2] = val;
	}

	public void setProductionMinExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionProductionMax(String op, java.math.BigDecimal val) {
		setConditionProductionMax(op, val, CONDITION_AND);
	}

	public void setConditionProductionMax(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProductionMax(boolean val) {
		__select_flags[3] = val;
	}

	public void setProductionMaxExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionIntervalLines(String op, java.math.BigDecimal val) {
		setConditionIntervalLines(op, val, CONDITION_AND);
	}

	public void setConditionIntervalLines(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectIntervalLines(boolean val) {
		__select_flags[4] = val;
	}

	public void setIntervalLinesExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionCoefficient(String op, java.math.BigDecimal val) {
		setConditionCoefficient(op, val, CONDITION_AND);
	}

	public void setConditionCoefficient(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCoefficient(boolean val) {
		__select_flags[5] = val;
	}

	public void setCoefficientExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionOperationTime(String op, java.util.Date val) {
		setConditionOperationTime(op, val, CONDITION_AND);
	}

	public void setConditionOperationTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperationTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setOperationTimeExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setCreateTimeExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionIntervalRange(String op, java.lang.String val) {
		setConditionIntervalRange(op, val, CONDITION_AND);
	}

	public void setConditionIntervalRange(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectIntervalRange(boolean val) {
		__select_flags[9] = val;
	}

	public void setIntervalRangeExpression(String val) {
		__dataExpressions[9] = val;
	}


}

