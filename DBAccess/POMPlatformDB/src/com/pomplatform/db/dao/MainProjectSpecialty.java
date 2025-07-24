package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMainProjectSpecialty;


public class MainProjectSpecialty extends AbstractTable<BaseMainProjectSpecialty>
{

	public MainProjectSpecialty() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "main_project_specialty";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMainProjectSpecialty.CS_MAIN_PROJECT_SPECIALTY_ID;
		__column_names[1] = BaseMainProjectSpecialty.CS_MAIN_PROJECT_ID;
		__column_names[2] = BaseMainProjectSpecialty.CS_SPECIALTY_ID;
		__column_names[3] = BaseMainProjectSpecialty.CS_PRE_PROJECT_ID;
		__column_names[4] = BaseMainProjectSpecialty.CS_REGISTRATION_SEAL_EMPLOYEE_ID;
		__column_names[5] = BaseMainProjectSpecialty.CS_IS_OUTSOURCING;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMainProjectSpecialty b) {
		clear();
		setMainProjectSpecialtyIdClear(b.getMainProjectSpecialtyId());
	}

	public boolean isPrimaryKeyNull() {
		return getMainProjectSpecialtyId() == null;
	}

	@Override
	public BaseMainProjectSpecialty generateBase(){
		BaseMainProjectSpecialty b = new BaseMainProjectSpecialty();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMainProjectSpecialty b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMainProjectSpecialtyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSpecialtyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPreProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRegistrationSealEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsOutsourcing(GenericBase.__getBoolean(val));
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
			if(val != null && !val.isEmpty()) setMainProjectSpecialtyId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMainProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSpecialtyId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPreProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRegistrationSealEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsOutsourcing(GenericBase.__getBoolean(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMainProjectSpecialty b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMainProjectSpecialtyId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getSpecialtyId();
		buff[count++] = b.getPreProjectId();
		buff[count++] = b.getRegistrationSealEmployeeId();
		buff[count++] = b.getIsOutsourcing();
	}

	@Override
	public void setDataFromBase(BaseMainProjectSpecialty b){
		if(b.getMainProjectSpecialtyId() != null) setMainProjectSpecialtyIdClear(b.getMainProjectSpecialtyId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getSpecialtyId() != null) setSpecialtyId(b.getSpecialtyId());
		if(b.getPreProjectId() != null) setPreProjectId(b.getPreProjectId());
		if(b.getRegistrationSealEmployeeId() != null) setRegistrationSealEmployeeId(b.getRegistrationSealEmployeeId());
		if(b.getIsOutsourcing() != null) setIsOutsourcing(b.getIsOutsourcing());
	}

	@Override
	public BaseMainProjectSpecialty generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMainProjectSpecialty b = new BaseMainProjectSpecialty();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMainProjectSpecialty __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectSpecialtyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialtyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegistrationSealEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsOutsourcing(GenericBase.__getBoolean(val));
	}

	public void setMainProjectSpecialtyId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMainProjectSpecialtyId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMainProjectSpecialtyIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSpecialtyId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getSpecialtyId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPreProjectId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPreProjectId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setRegistrationSealEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getRegistrationSealEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setIsOutsourcing(java.lang.Boolean val) {
		setCurrentData(5, val);
	}

	public java.lang.Boolean getIsOutsourcing() {
		return GenericBase.__getBoolean(__current_data[5]);
	}

	public void setConditionMainProjectSpecialtyId(String op, java.lang.Integer val) {
		setConditionMainProjectSpecialtyId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectSpecialtyId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMainProjectSpecialtyId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMainProjectSpecialtyIdExpression(String val) {
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

	public void setConditionSpecialtyId(String op, java.lang.Integer val) {
		setConditionSpecialtyId(op, val, CONDITION_AND);
	}

	public void setConditionSpecialtyId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSpecialtyId(boolean val) {
		__select_flags[2] = val;
	}

	public void setSpecialtyIdExpression(String val) {
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

	public void setConditionRegistrationSealEmployeeId(String op, java.lang.Integer val) {
		setConditionRegistrationSealEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionRegistrationSealEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRegistrationSealEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setRegistrationSealEmployeeIdExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionIsOutsourcing(String op, java.lang.Boolean val) {
		setConditionIsOutsourcing(op, val, CONDITION_AND);
	}

	public void setConditionIsOutsourcing(String op, java.lang.Boolean val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectIsOutsourcing(boolean val) {
		__select_flags[5] = val;
	}

	public void setIsOutsourcingExpression(String val) {
		__dataExpressions[5] = val;
	}


}

