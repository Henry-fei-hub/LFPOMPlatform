package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCnProfessionalType;


public class CnProfessionalType extends AbstractTable<BaseCnProfessionalType>
{

	public CnProfessionalType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "cn_professional_types";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCnProfessionalType.CS_PROFESSIONAL_TYPE_ID;
		__column_names[1] = BaseCnProfessionalType.CS_PROFESSIONAL_TYPE_NAME;
		__column_names[2] = BaseCnProfessionalType.CS_ORGANIZATION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCnProfessionalType b) {
		clear();
		setProfessionalTypeIdClear(b.getProfessionalTypeId());
	}

	public boolean isPrimaryKeyNull() {
		return getProfessionalTypeId() == null;
	}

	@Override
	public BaseCnProfessionalType generateBase(){
		BaseCnProfessionalType b = new BaseCnProfessionalType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCnProfessionalType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProfessionalTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProfessionalTypeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOrganizationId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCnProfessionalType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProfessionalTypeId();
		buff[count++] = b.getProfessionalTypeName();
		buff[count++] = b.getOrganizationId();
	}

	@Override
	public void setDataFromBase(BaseCnProfessionalType b){
		if(b.getProfessionalTypeId() != null) setProfessionalTypeIdClear(b.getProfessionalTypeId());
		if(b.getProfessionalTypeName() != null) setProfessionalTypeName(b.getProfessionalTypeName());
		if(b.getOrganizationId() != null) setOrganizationId(b.getOrganizationId());
	}

	@Override
	public BaseCnProfessionalType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCnProfessionalType b = new BaseCnProfessionalType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCnProfessionalType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProfessionalTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProfessionalTypeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrganizationId(GenericBase.__getInt(val));
	}

	public void setProfessionalTypeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProfessionalTypeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProfessionalTypeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProfessionalTypeName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getProfessionalTypeName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setOrganizationId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getOrganizationId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setConditionProfessionalTypeId(String op, java.lang.Integer val) {
		setConditionProfessionalTypeId(op, val, CONDITION_AND);
	}

	public void setConditionProfessionalTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProfessionalTypeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProfessionalTypeName(String op, java.lang.String val) {
		setConditionProfessionalTypeName(op, val, CONDITION_AND);
	}

	public void setConditionProfessionalTypeName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProfessionalTypeName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val) {
		setConditionOrganizationId(op, val, CONDITION_AND);
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectOrganizationId(boolean val) {
		__select_flags[2] = val;
	}


}

