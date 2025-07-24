package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BasePersonnelBusinessLinkReturn;


public class PersonnelBusinessLinkReturn extends AbstractTable<BasePersonnelBusinessLinkReturn>
{

	public PersonnelBusinessLinkReturn() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "personnel_business_link_returns";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePersonnelBusinessLinkReturn.CS_PERSONNEL_BUSINESS_LINK_RETURN_ID;
		__column_names[1] = BasePersonnelBusinessLinkReturn.CS_PERSONNEL_BUSINESS_ID;
		__column_names[2] = BasePersonnelBusinessLinkReturn.CS_TYPE;
		__column_names[3] = BasePersonnelBusinessLinkReturn.CS_PERSONNEL_BUSINESS_LINK_EQUIPMENT_ID;
		__column_names[4] = BasePersonnelBusinessLinkReturn.CS_RETURN_AMOUNT;
		__column_names[5] = BasePersonnelBusinessLinkReturn.CS_RETURN_TIME;
		__column_names[6] = BasePersonnelBusinessLinkReturn.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePersonnelBusinessLinkReturn b) {
		clear();
		setPersonnelBusinessLinkReturnIdClear(b.getPersonnelBusinessLinkReturnId());
	}

	public boolean isPrimaryKeyNull() {
		return getPersonnelBusinessLinkReturnId() == null;
	}

	@Override
	public BasePersonnelBusinessLinkReturn generateBase(){
		BasePersonnelBusinessLinkReturn b = new BasePersonnelBusinessLinkReturn();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePersonnelBusinessLinkReturn b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessLinkReturnId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessLinkEquipmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReturnAmount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReturnTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
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
			if(val != null && !val.isEmpty()) setPersonnelBusinessLinkReturnId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPersonnelBusinessId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPersonnelBusinessLinkEquipmentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReturnAmount(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReturnTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
	}

	@Override
	public void setBaseToBuffer(BasePersonnelBusinessLinkReturn b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPersonnelBusinessLinkReturnId();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getType();
		buff[count++] = b.getPersonnelBusinessLinkEquipmentId();
		buff[count++] = b.getReturnAmount();
		buff[count++] = generateTimestampFromDate(b.getReturnTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePersonnelBusinessLinkReturn b){
		if(b.getPersonnelBusinessLinkReturnId() != null) setPersonnelBusinessLinkReturnIdClear(b.getPersonnelBusinessLinkReturnId());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getType() != null) setType(b.getType());
		if(b.getPersonnelBusinessLinkEquipmentId() != null) setPersonnelBusinessLinkEquipmentId(b.getPersonnelBusinessLinkEquipmentId());
		if(b.getReturnAmount() != null) setReturnAmount(b.getReturnAmount());
		if(b.getReturnTime() != null) setReturnTime(b.getReturnTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePersonnelBusinessLinkReturn generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePersonnelBusinessLinkReturn b = new BasePersonnelBusinessLinkReturn();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePersonnelBusinessLinkReturn __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessLinkReturnId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessLinkEquipmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReturnAmount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReturnTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPersonnelBusinessLinkReturnId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPersonnelBusinessLinkReturnId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPersonnelBusinessLinkReturnIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPersonnelBusinessLinkEquipmentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPersonnelBusinessLinkEquipmentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setReturnAmount(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getReturnAmount() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setReturnTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getReturnTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionPersonnelBusinessLinkReturnId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessLinkReturnId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessLinkReturnId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPersonnelBusinessLinkReturnId(boolean val) {
		__select_flags[0] = val;
	}

	public void setPersonnelBusinessLinkReturnIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[1] = val;
	}

	public void setPersonnelBusinessIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[2] = val;
	}

	public void setTypeExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionPersonnelBusinessLinkEquipmentId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessLinkEquipmentId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessLinkEquipmentId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPersonnelBusinessLinkEquipmentId(boolean val) {
		__select_flags[3] = val;
	}

	public void setPersonnelBusinessLinkEquipmentIdExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionReturnAmount(String op, java.lang.Integer val) {
		setConditionReturnAmount(op, val, CONDITION_AND);
	}

	public void setConditionReturnAmount(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectReturnAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setReturnAmountExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionReturnTime(String op, java.util.Date val) {
		setConditionReturnTime(op, val, CONDITION_AND);
	}

	public void setConditionReturnTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectReturnTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setReturnTimeExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[6] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[6] = val;
	}


}

