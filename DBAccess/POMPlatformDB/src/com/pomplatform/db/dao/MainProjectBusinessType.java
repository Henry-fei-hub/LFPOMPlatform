package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;


public class MainProjectBusinessType extends AbstractTable<BaseMainProjectBusinessType>
{

	public MainProjectBusinessType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "main_project_business_types";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMainProjectBusinessType.CS_MAIN_PROJECT_BUSINESS_TYPE_ID;
		__column_names[1] = BaseMainProjectBusinessType.CS_MAIN_PROJECT_ID;
		__column_names[2] = BaseMainProjectBusinessType.CS_BUSINESS_TYPE;
		__column_names[3] = BaseMainProjectBusinessType.CS_PRE_PROJECT_ID;
		__column_names[4] = BaseMainProjectBusinessType.CS_AREA;
		__column_names[5] = BaseMainProjectBusinessType.CS_OUTPUT_VALUE;
		__column_names[6] = BaseMainProjectBusinessType.CS_OUT_QUOTATION_ID;
		__column_names[7] = BaseMainProjectBusinessType.CS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMainProjectBusinessType b) {
		clear();
		setMainProjectBusinessTypeIdClear(b.getMainProjectBusinessTypeId());
	}

	public boolean isPrimaryKeyNull() {
		return getMainProjectBusinessTypeId() == null;
	}

	@Override
	public BaseMainProjectBusinessType generateBase(){
		BaseMainProjectBusinessType b = new BaseMainProjectBusinessType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMainProjectBusinessType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMainProjectBusinessTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPreProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOutputValue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
	}

	public void setDataFromCSV(String csvLine){
		setDataFromCSV(csvLine, null);
	}

	public void setDataFromCSV(String csvLine, String names){
		int count = 0; String val;
		Integer num = null;
		setInputNames(names);
		String[] values = JsonParser.csvLine(csvLine, ',');
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMainProjectBusinessTypeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMainProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPreProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setArea(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOutputValue(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOutQuotationId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMainProjectBusinessType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMainProjectBusinessTypeId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getPreProjectId();
		buff[count++] = b.getArea();
		buff[count++] = b.getOutputValue();
		buff[count++] = b.getOutQuotationId();
		buff[count++] = b.getStatus();
	}

	@Override
	public void setDataFromBase(BaseMainProjectBusinessType b){
		if(b.getMainProjectBusinessTypeId() != null) setMainProjectBusinessTypeIdClear(b.getMainProjectBusinessTypeId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getPreProjectId() != null) setPreProjectId(b.getPreProjectId());
		if(b.getArea() != null) setArea(b.getArea());
		if(b.getOutputValue() != null) setOutputValue(b.getOutputValue());
		if(b.getOutQuotationId() != null) setOutQuotationId(b.getOutQuotationId());
		if(b.getStatus() != null) setStatus(b.getStatus());
	}

	@Override
	public BaseMainProjectBusinessType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMainProjectBusinessType b = new BaseMainProjectBusinessType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMainProjectBusinessType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectBusinessTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutputValue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
	}

	public void setMainProjectBusinessTypeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMainProjectBusinessTypeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMainProjectBusinessTypeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPreProjectId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPreProjectId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setArea(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getArea() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setOutputValue(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getOutputValue() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setOutQuotationId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOutQuotationId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setConditionMainProjectBusinessTypeId(String op, java.lang.Integer val) {
		setConditionMainProjectBusinessTypeId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectBusinessTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMainProjectBusinessTypeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMainProjectBusinessTypeIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setMainProjectIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[2] = val;
	}

	public void setBusinessTypeExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionPreProjectId(String op, java.lang.Integer val) {
		setConditionPreProjectId(op, val, CONDITION_AND);
	}

	public void setConditionPreProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPreProjectId(boolean val) {
		__select_flags[3] = val;
	}

	public void setPreProjectIdExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionArea(String op, java.math.BigDecimal val) {
		setConditionArea(op, val, CONDITION_AND);
	}

	public void setConditionArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectArea(boolean val) {
		__select_flags[4] = val;
	}

	public void setAreaExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionOutputValue(String op, java.math.BigDecimal val) {
		setConditionOutputValue(op, val, CONDITION_AND);
	}

	public void setConditionOutputValue(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOutputValue(boolean val) {
		__select_flags[5] = val;
	}

	public void setOutputValueExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionOutQuotationId(String op, java.lang.Integer val) {
		setConditionOutQuotationId(op, val, CONDITION_AND);
	}

	public void setConditionOutQuotationId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOutQuotationId(boolean val) {
		__select_flags[6] = val;
	}

	public void setOutQuotationIdExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[7] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[7] = val;
	}


}

