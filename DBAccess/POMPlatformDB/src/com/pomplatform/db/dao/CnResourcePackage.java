package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCnResourcePackage;


public class CnResourcePackage extends AbstractTable<BaseCnResourcePackage>
{

	public CnResourcePackage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "cn_resource_packages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCnResourcePackage.CS_RESOURCE_PACKAGE_ID;
		__column_names[1] = BaseCnResourcePackage.CS_PACKAGE_NAME;
		__column_names[2] = BaseCnResourcePackage.CS_PACKAGE_CODE;
		__column_names[3] = BaseCnResourcePackage.CS_CREATOR;
		__column_names[4] = BaseCnResourcePackage.CS_CREATE_TIME;
		__column_names[5] = BaseCnResourcePackage.CS_DELETE_FLAG;
		__column_names[6] = BaseCnResourcePackage.CS_ORGANIZATION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCnResourcePackage b) {
		clear();
		setResourcePackageIdClear(b.getResourcePackageId());
	}

	public boolean isPrimaryKeyNull() {
		return getResourcePackageId() == null;
	}

	@Override
	public BaseCnResourcePackage generateBase(){
		BaseCnResourcePackage b = new BaseCnResourcePackage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCnResourcePackage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setResourcePackageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPackageName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPackageCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrganizationId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCnResourcePackage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getResourcePackageId();
		buff[count++] = b.getPackageName();
		buff[count++] = b.getPackageCode();
		buff[count++] = b.getCreator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getOrganizationId();
	}

	@Override
	public void setDataFromBase(BaseCnResourcePackage b){
		if(b.getResourcePackageId() != null) setResourcePackageIdClear(b.getResourcePackageId());
		if(b.getPackageName() != null) setPackageName(b.getPackageName());
		if(b.getPackageCode() != null) setPackageCode(b.getPackageCode());
		if(b.getCreator() != null) setCreator(b.getCreator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getOrganizationId() != null) setOrganizationId(b.getOrganizationId());
	}

	@Override
	public BaseCnResourcePackage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCnResourcePackage b = new BaseCnResourcePackage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCnResourcePackage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourcePackageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPackageName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPackageCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrganizationId(GenericBase.__getInt(val));
	}

	public void setResourcePackageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getResourcePackageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setResourcePackageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPackageName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getPackageName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setPackageCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getPackageCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setCreator(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCreator() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setOrganizationId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOrganizationId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setConditionResourcePackageId(String op, java.lang.Integer val) {
		setConditionResourcePackageId(op, val, CONDITION_AND);
	}

	public void setConditionResourcePackageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectResourcePackageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPackageName(String op, java.lang.String val) {
		setConditionPackageName(op, val, CONDITION_AND);
	}

	public void setConditionPackageName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPackageName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPackageCode(String op, java.lang.String val) {
		setConditionPackageCode(op, val, CONDITION_AND);
	}

	public void setConditionPackageCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPackageCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCreator(String op, java.lang.Integer val) {
		setConditionCreator(op, val, CONDITION_AND);
	}

	public void setConditionCreator(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCreator(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val) {
		setConditionOrganizationId(op, val, CONDITION_AND);
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOrganizationId(boolean val) {
		__select_flags[6] = val;
	}


}

