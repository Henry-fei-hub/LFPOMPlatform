package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCnUser;


public class CnUser extends AbstractTable<BaseCnUser>
{

	public CnUser() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "cn_user";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCnUser.CS_USER_ID;
		__column_names[1] = BaseCnUser.CS_USER_NAME;
		__column_names[2] = BaseCnUser.CS_USER_PASSWORD;
		__column_names[3] = BaseCnUser.CS_PHONE;
		__column_names[4] = BaseCnUser.CS_ORGANIZATION_ID;
		__column_names[5] = BaseCnUser.CS_USER_FILE_IMAGE;
		__column_names[6] = BaseCnUser.CS_PROFESSIONAL_TYPE_ID;
		__column_names[7] = BaseCnUser.CS_USER_AUTOGRAPH;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCnUser b) {
		clear();
		setUserIdClear(b.getUserId());
	}

	public boolean isPrimaryKeyNull() {
		return getUserId() == null;
	}

	@Override
	public BaseCnUser generateBase(){
		BaseCnUser b = new BaseCnUser();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCnUser b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setUserId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUserName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setUserPassword(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPhone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOrganizationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUserFileImage(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProfessionalTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUserAutograph(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCnUser b, Object[] buff){
		int count = 0;
		buff[count++] = b.getUserId();
		buff[count++] = b.getUserName();
		buff[count++] = b.getUserPassword();
		buff[count++] = b.getPhone();
		buff[count++] = b.getOrganizationId();
		buff[count++] = b.getUserFileImage();
		buff[count++] = b.getProfessionalTypeId();
		buff[count++] = b.getUserAutograph();
	}

	@Override
	public void setDataFromBase(BaseCnUser b){
		if(b.getUserId() != null) setUserIdClear(b.getUserId());
		if(b.getUserName() != null) setUserName(b.getUserName());
		if(b.getUserPassword() != null) setUserPassword(b.getUserPassword());
		if(b.getPhone() != null) setPhone(b.getPhone());
		if(b.getOrganizationId() != null) setOrganizationId(b.getOrganizationId());
		if(b.getUserFileImage() != null) setUserFileImage(b.getUserFileImage());
		if(b.getProfessionalTypeId() != null) setProfessionalTypeId(b.getProfessionalTypeId());
		if(b.getUserAutograph() != null) setUserAutograph(b.getUserAutograph());
	}

	@Override
	public BaseCnUser generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCnUser b = new BaseCnUser();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCnUser __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUserId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUserName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUserPassword(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPhone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrganizationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUserFileImage(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProfessionalTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUserAutograph(GenericBase.__getString(val));
	}

	public void setUserId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getUserId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setUserIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setUserName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getUserName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setUserPassword(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getUserPassword() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setPhone(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getPhone() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setOrganizationId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOrganizationId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setUserFileImage(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getUserFileImage() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setProfessionalTypeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getProfessionalTypeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setUserAutograph(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getUserAutograph() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setConditionUserId(String op, java.lang.Integer val) {
		setConditionUserId(op, val, CONDITION_AND);
	}

	public void setConditionUserId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectUserId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionUserName(String op, java.lang.String val) {
		setConditionUserName(op, val, CONDITION_AND);
	}

	public void setConditionUserName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectUserName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionUserPassword(String op, java.lang.String val) {
		setConditionUserPassword(op, val, CONDITION_AND);
	}

	public void setConditionUserPassword(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectUserPassword(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPhone(String op, java.lang.String val) {
		setConditionPhone(op, val, CONDITION_AND);
	}

	public void setConditionPhone(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPhone(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val) {
		setConditionOrganizationId(op, val, CONDITION_AND);
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOrganizationId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionUserFileImage(String op, java.lang.Integer val) {
		setConditionUserFileImage(op, val, CONDITION_AND);
	}

	public void setConditionUserFileImage(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectUserFileImage(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionProfessionalTypeId(String op, java.lang.Integer val) {
		setConditionProfessionalTypeId(op, val, CONDITION_AND);
	}

	public void setConditionProfessionalTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProfessionalTypeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionUserAutograph(String op, java.lang.String val) {
		setConditionUserAutograph(op, val, CONDITION_AND);
	}

	public void setConditionUserAutograph(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectUserAutograph(boolean val) {
		__select_flags[7] = val;
	}


}

