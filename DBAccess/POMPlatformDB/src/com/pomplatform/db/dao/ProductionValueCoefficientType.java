package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseProductionValueCoefficientType;


public class ProductionValueCoefficientType extends AbstractTable<BaseProductionValueCoefficientType>
{

	public ProductionValueCoefficientType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 2;

		initTables();

		__tableName            = "production_value_coefficient_type";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProductionValueCoefficientType.CS_PRODUCTION_VALUE_COEFFICIENT_TYPE_ID;
		__column_names[1] = BaseProductionValueCoefficientType.CS_COEFFICIENT_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProductionValueCoefficientType b) {
		clear();
		setProductionValueCoefficientTypeIdClear(b.getProductionValueCoefficientTypeId());
	}

	public boolean isPrimaryKeyNull() {
		return getProductionValueCoefficientTypeId() == null;
	}

	@Override
	public BaseProductionValueCoefficientType generateBase(){
		BaseProductionValueCoefficientType b = new BaseProductionValueCoefficientType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProductionValueCoefficientType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProductionValueCoefficientTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCoefficientType(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProductionValueCoefficientType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProductionValueCoefficientTypeId();
		buff[count++] = b.getCoefficientType();
	}

	@Override
	public void setDataFromBase(BaseProductionValueCoefficientType b){
		if(b.getProductionValueCoefficientTypeId() != null) setProductionValueCoefficientTypeIdClear(b.getProductionValueCoefficientTypeId());
		if(b.getCoefficientType() != null) setCoefficientType(b.getCoefficientType());
	}

	@Override
	public BaseProductionValueCoefficientType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProductionValueCoefficientType b = new BaseProductionValueCoefficientType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProductionValueCoefficientType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductionValueCoefficientTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCoefficientType(GenericBase.__getString(val));
	}

	public void setProductionValueCoefficientTypeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProductionValueCoefficientTypeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProductionValueCoefficientTypeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCoefficientType(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCoefficientType() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setConditionProductionValueCoefficientTypeId(String op, java.lang.Integer val) {
		setConditionProductionValueCoefficientTypeId(op, val, CONDITION_AND);
	}

	public void setConditionProductionValueCoefficientTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProductionValueCoefficientTypeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setProductionValueCoefficientTypeIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionCoefficientType(String op, java.lang.String val) {
		setConditionCoefficientType(op, val, CONDITION_AND);
	}

	public void setConditionCoefficientType(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCoefficientType(boolean val) {
		__select_flags[1] = val;
	}

	public void setCoefficientTypeExpression(String val) {
		__dataExpressions[1] = val;
	}

}

