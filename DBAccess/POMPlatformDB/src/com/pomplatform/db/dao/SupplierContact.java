package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSupplierContact;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SupplierContact extends AbstractTable<BaseSupplierContact>
{

	public SupplierContact() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "supplier_contacts";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSupplierContact.CS_SUPPLIER_CONTACT_ID;
		__column_names[1] = BaseSupplierContact.CS_SUPPLIER_ID;
		__column_names[2] = BaseSupplierContact.CS_CONTACT_NAME;
		__column_names[3] = BaseSupplierContact.CS_CONTACT_POSITION;
		__column_names[4] = BaseSupplierContact.CS_CONTACT_GENDER;
		__column_names[5] = BaseSupplierContact.CS_CONTACT_PHONE;
		__column_names[6] = BaseSupplierContact.CS_CONTACT_EMAIL;
		__column_names[7] = BaseSupplierContact.CS_CONTACT_FAX;
		__column_names[8] = BaseSupplierContact.CS_CONTACT_TYPE;
		__column_names[9] = BaseSupplierContact.CS_ENABLED;
		__column_names[10] = BaseSupplierContact.CS_CREATE_EMPLOYEE_ID;
		__column_names[11] = BaseSupplierContact.CS_CREATE_TIME;
		__column_names[12] = BaseSupplierContact.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSupplierContact b) {
		clear();
		setSupplierContactIdClear(b.getSupplierContactId());
	}

	public boolean isPrimaryKeyNull() {
		return getSupplierContactId() == null;
	}

	@Override
	public BaseSupplierContact generateBase(){
		BaseSupplierContact b = new BaseSupplierContact();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSupplierContact b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSupplierContactId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContactName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactPosition(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactGender(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContactPhone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactEmail(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactFax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEnabled(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSupplierContact b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSupplierContactId();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getContactName();
		buff[count++] = b.getContactPosition();
		buff[count++] = b.getContactGender();
		buff[count++] = b.getContactPhone();
		buff[count++] = b.getContactEmail();
		buff[count++] = b.getContactFax();
		buff[count++] = b.getContactType();
		buff[count++] = b.getEnabled();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSupplierContact b){
		if(b.getSupplierContactId() != null) setSupplierContactIdClear(b.getSupplierContactId());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getContactName() != null) setContactName(b.getContactName());
		if(b.getContactPosition() != null) setContactPosition(b.getContactPosition());
		if(b.getContactGender() != null) setContactGender(b.getContactGender());
		if(b.getContactPhone() != null) setContactPhone(b.getContactPhone());
		if(b.getContactEmail() != null) setContactEmail(b.getContactEmail());
		if(b.getContactFax() != null) setContactFax(b.getContactFax());
		if(b.getContactType() != null) setContactType(b.getContactType());
		if(b.getEnabled() != null) setEnabled(b.getEnabled());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSupplierContact generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSupplierContact b = new BaseSupplierContact();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSupplierContact __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierContactId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactPosition(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactGender(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactPhone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactEmail(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactFax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEnabled(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSupplierContactId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSupplierContactId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSupplierContactIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setContactName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getContactName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setContactPosition(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getContactPosition() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setContactGender(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getContactGender() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setContactPhone(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getContactPhone() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setContactEmail(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getContactEmail() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setContactFax(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getContactFax() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setContactType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getContactType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setEnabled(java.lang.Boolean val) {
		setCurrentData(9, val);
	}

	public java.lang.Boolean getEnabled() {
		return GenericBase.__getBoolean(__current_data[9]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setConditionSupplierContactId(String op, java.lang.Integer val) {
		setConditionSupplierContactId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierContactId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSupplierContactId(boolean val) {
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

	public void setConditionContactName(String op, java.lang.String val) {
		setConditionContactName(op, val, CONDITION_AND);
	}

	public void setConditionContactName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContactName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContactPosition(String op, java.lang.String val) {
		setConditionContactPosition(op, val, CONDITION_AND);
	}

	public void setConditionContactPosition(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContactPosition(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionContactGender(String op, java.lang.Integer val) {
		setConditionContactGender(op, val, CONDITION_AND);
	}

	public void setConditionContactGender(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectContactGender(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionContactPhone(String op, java.lang.String val) {
		setConditionContactPhone(op, val, CONDITION_AND);
	}

	public void setConditionContactPhone(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectContactPhone(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionContactEmail(String op, java.lang.String val) {
		setConditionContactEmail(op, val, CONDITION_AND);
	}

	public void setConditionContactEmail(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectContactEmail(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionContactFax(String op, java.lang.String val) {
		setConditionContactFax(op, val, CONDITION_AND);
	}

	public void setConditionContactFax(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectContactFax(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionContactType(String op, java.lang.Integer val) {
		setConditionContactType(op, val, CONDITION_AND);
	}

	public void setConditionContactType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectContactType(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionEnabled(String op, java.lang.Boolean val) {
		setConditionEnabled(op, val, CONDITION_AND);
	}

	public void setConditionEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectEnabled(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[12] = val;
	}


}

