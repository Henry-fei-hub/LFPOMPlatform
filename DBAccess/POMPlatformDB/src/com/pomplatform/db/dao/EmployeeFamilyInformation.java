package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeFamilyInformation;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeFamilyInformation extends AbstractTable<BaseEmployeeFamilyInformation>
{

	public EmployeeFamilyInformation() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "employee_family_informations";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeFamilyInformation.CS_EMPLOYEE_FAMILY_INFORMATION_ID;
		__column_names[1] = BaseEmployeeFamilyInformation.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeFamilyInformation.CS_FAMILY_MEMBER_NAME;
		__column_names[3] = BaseEmployeeFamilyInformation.CS_RELATION;
		__column_names[4] = BaseEmployeeFamilyInformation.CS_FAMILY_WORK_PLACE;
		__column_names[5] = BaseEmployeeFamilyInformation.CS_TELEPHONE;
		__column_names[6] = BaseEmployeeFamilyInformation.CS_FAMILY_MEMBER_CARD;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeFamilyInformation b) {
		clear();
		setEmployeeFamilyInformationIdClear(b.getEmployeeFamilyInformationId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeFamilyInformationId() == null;
	}

	@Override
	public BaseEmployeeFamilyInformation generateBase(){
		BaseEmployeeFamilyInformation b = new BaseEmployeeFamilyInformation();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeFamilyInformation b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeFamilyInformationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFamilyMemberName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRelation(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFamilyWorkPlace(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTelephone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFamilyMemberCard(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeFamilyInformation b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeFamilyInformationId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getFamilyMemberName();
		buff[count++] = b.getRelation();
		buff[count++] = b.getFamilyWorkPlace();
		buff[count++] = b.getTelephone();
		buff[count++] = b.getFamilyMemberCard();
	}

	@Override
	public void setDataFromBase(BaseEmployeeFamilyInformation b){
		if(b.getEmployeeFamilyInformationId() != null) setEmployeeFamilyInformationIdClear(b.getEmployeeFamilyInformationId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getFamilyMemberName() != null) setFamilyMemberName(b.getFamilyMemberName());
		if(b.getRelation() != null) setRelation(b.getRelation());
		if(b.getFamilyWorkPlace() != null) setFamilyWorkPlace(b.getFamilyWorkPlace());
		if(b.getTelephone() != null) setTelephone(b.getTelephone());
		if(b.getFamilyMemberCard() != null) setFamilyMemberCard(b.getFamilyMemberCard());
	}

	@Override
	public BaseEmployeeFamilyInformation generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeFamilyInformation b = new BaseEmployeeFamilyInformation();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeFamilyInformation __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeFamilyInformationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFamilyMemberName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelation(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFamilyWorkPlace(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTelephone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFamilyMemberCard(GenericBase.__getString(val));
	}

	public void setEmployeeFamilyInformationId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeFamilyInformationId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeFamilyInformationIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setFamilyMemberName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getFamilyMemberName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setRelation(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getRelation() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setFamilyWorkPlace(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getFamilyWorkPlace() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setTelephone(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getTelephone() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setFamilyMemberCard(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getFamilyMemberCard() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionEmployeeFamilyInformationId(String op, java.lang.Integer val) {
		setConditionEmployeeFamilyInformationId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeFamilyInformationId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeFamilyInformationId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionFamilyMemberName(String op, java.lang.String val) {
		setConditionFamilyMemberName(op, val, CONDITION_AND);
	}

	public void setConditionFamilyMemberName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFamilyMemberName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionRelation(String op, java.lang.String val) {
		setConditionRelation(op, val, CONDITION_AND);
	}

	public void setConditionRelation(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRelation(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionFamilyWorkPlace(String op, java.lang.String val) {
		setConditionFamilyWorkPlace(op, val, CONDITION_AND);
	}

	public void setConditionFamilyWorkPlace(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectFamilyWorkPlace(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionTelephone(String op, java.lang.String val) {
		setConditionTelephone(op, val, CONDITION_AND);
	}

	public void setConditionTelephone(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectTelephone(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionFamilyMemberCard(String op, java.lang.String val) {
		setConditionFamilyMemberCard(op, val, CONDITION_AND);
	}

	public void setConditionFamilyMemberCard(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectFamilyMemberCard(boolean val) {
		__select_flags[6] = val;
	}


}

