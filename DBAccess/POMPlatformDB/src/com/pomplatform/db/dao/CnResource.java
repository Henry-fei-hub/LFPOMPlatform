package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCnResource;


public class CnResource extends AbstractTable<BaseCnResource>
{

	public CnResource() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "cn_resources";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCnResource.CS_RESOURCE_ID;
		__column_names[1] = BaseCnResource.CS_RESOURCE_PACKAGE_ID;
		__column_names[2] = BaseCnResource.CS_TITLE;
		__column_names[3] = BaseCnResource.CS_DESCRIPTION;
		__column_names[4] = BaseCnResource.CS_REMARK;
		__column_names[5] = BaseCnResource.CS_EXTERNAL_URL;
		__column_names[6] = BaseCnResource.CS_SOURCE_TYPE;
		__column_names[7] = BaseCnResource.CS_RESOURCE_TYPE;
		__column_names[8] = BaseCnResource.CS_CREATOR;
		__column_names[9] = BaseCnResource.CS_CREATE_TIME;
		__column_names[10] = BaseCnResource.CS_FILE_MANAGE_ID;
		__column_names[11] = BaseCnResource.CS_DELETE_FLAG;
		__column_names[12] = BaseCnResource.CS_ORGANIZATION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCnResource b) {
		clear();
		setResourceIdClear(b.getResourceId());
	}

	public boolean isPrimaryKeyNull() {
		return getResourceId() == null;
	}

	@Override
	public BaseCnResource generateBase(){
		BaseCnResource b = new BaseCnResource();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCnResource b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setResourceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setResourcePackageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTitle(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDescription(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setExternalUrl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSourceType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setResourceType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setFileManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrganizationId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCnResource b, Object[] buff){
		int count = 0;
		buff[count++] = b.getResourceId();
		buff[count++] = b.getResourcePackageId();
		buff[count++] = b.getTitle();
		buff[count++] = b.getDescription();
		buff[count++] = b.getRemark();
		buff[count++] = b.getExternalUrl();
		buff[count++] = b.getSourceType();
		buff[count++] = b.getResourceType();
		buff[count++] = b.getCreator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getFileManageId();
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getOrganizationId();
	}

	@Override
	public void setDataFromBase(BaseCnResource b){
		if(b.getResourceId() != null) setResourceIdClear(b.getResourceId());
		if(b.getResourcePackageId() != null) setResourcePackageId(b.getResourcePackageId());
		if(b.getTitle() != null) setTitle(b.getTitle());
		if(b.getDescription() != null) setDescription(b.getDescription());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getExternalUrl() != null) setExternalUrl(b.getExternalUrl());
		if(b.getSourceType() != null) setSourceType(b.getSourceType());
		if(b.getResourceType() != null) setResourceType(b.getResourceType());
		if(b.getCreator() != null) setCreator(b.getCreator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getFileManageId() != null) setFileManageId(b.getFileManageId());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getOrganizationId() != null) setOrganizationId(b.getOrganizationId());
	}

	@Override
	public BaseCnResource generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCnResource b = new BaseCnResource();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCnResource __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourcePackageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTitle(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDescription(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExternalUrl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSourceType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrganizationId(GenericBase.__getInt(val));
	}

	public void setResourceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getResourceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setResourceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setResourcePackageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getResourcePackageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setTitle(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getTitle() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setDescription(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getDescription() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setExternalUrl(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getExternalUrl() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setSourceType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getSourceType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setResourceType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getResourceType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setCreator(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getCreator() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setFileManageId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getFileManageId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setOrganizationId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getOrganizationId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setConditionResourceId(String op, java.lang.Integer val) {
		setConditionResourceId(op, val, CONDITION_AND);
	}

	public void setConditionResourceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectResourceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionResourcePackageId(String op, java.lang.Integer val) {
		setConditionResourcePackageId(op, val, CONDITION_AND);
	}

	public void setConditionResourcePackageId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectResourcePackageId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionTitle(String op, java.lang.String val) {
		setConditionTitle(op, val, CONDITION_AND);
	}

	public void setConditionTitle(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTitle(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDescription(String op, java.lang.String val) {
		setConditionDescription(op, val, CONDITION_AND);
	}

	public void setConditionDescription(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDescription(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionExternalUrl(String op, java.lang.String val) {
		setConditionExternalUrl(op, val, CONDITION_AND);
	}

	public void setConditionExternalUrl(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectExternalUrl(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionSourceType(String op, java.lang.Integer val) {
		setConditionSourceType(op, val, CONDITION_AND);
	}

	public void setConditionSourceType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectSourceType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionResourceType(String op, java.lang.Integer val) {
		setConditionResourceType(op, val, CONDITION_AND);
	}

	public void setConditionResourceType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectResourceType(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCreator(String op, java.lang.Integer val) {
		setConditionCreator(op, val, CONDITION_AND);
	}

	public void setConditionCreator(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCreator(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionFileManageId(String op, java.lang.Integer val) {
		setConditionFileManageId(op, val, CONDITION_AND);
	}

	public void setConditionFileManageId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectFileManageId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val) {
		setConditionOrganizationId(op, val, CONDITION_AND);
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectOrganizationId(boolean val) {
		__select_flags[12] = val;
	}


}

