package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCnResourceDownload;


public class CnResourceDownload extends AbstractTable<BaseCnResourceDownload>
{

	public CnResourceDownload() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "cn_resource_downloads";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCnResourceDownload.CS_RESOURCE_DOWNLOAD_ID;
		__column_names[1] = BaseCnResourceDownload.CS_RESOURCE_ID;
		__column_names[2] = BaseCnResourceDownload.CS_RESOURCE_ATTACHMENT_ID;
		__column_names[3] = BaseCnResourceDownload.CS_DOWNLOADER;
		__column_names[4] = BaseCnResourceDownload.CS_CREATE_TIME;
		__column_names[5] = BaseCnResourceDownload.CS_ORGANIZATION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCnResourceDownload b) {
		clear();
		setResourceDownloadIdClear(b.getResourceDownloadId());
	}

	public boolean isPrimaryKeyNull() {
		return getResourceDownloadId() == null;
	}

	@Override
	public BaseCnResourceDownload generateBase(){
		BaseCnResourceDownload b = new BaseCnResourceDownload();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCnResourceDownload b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setResourceDownloadId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setResourceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setResourceAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDownloader(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOrganizationId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCnResourceDownload b, Object[] buff){
		int count = 0;
		buff[count++] = b.getResourceDownloadId();
		buff[count++] = b.getResourceId();
		buff[count++] = b.getResourceAttachmentId();
		buff[count++] = b.getDownloader();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getOrganizationId();
	}

	@Override
	public void setDataFromBase(BaseCnResourceDownload b){
		if(b.getResourceDownloadId() != null) setResourceDownloadIdClear(b.getResourceDownloadId());
		if(b.getResourceId() != null) setResourceId(b.getResourceId());
		if(b.getResourceAttachmentId() != null) setResourceAttachmentId(b.getResourceAttachmentId());
		if(b.getDownloader() != null) setDownloader(b.getDownloader());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getOrganizationId() != null) setOrganizationId(b.getOrganizationId());
	}

	@Override
	public BaseCnResourceDownload generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCnResourceDownload b = new BaseCnResourceDownload();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCnResourceDownload __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceDownloadId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDownloader(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrganizationId(GenericBase.__getInt(val));
	}

	public void setResourceDownloadId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getResourceDownloadId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setResourceDownloadIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setResourceId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getResourceId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setResourceAttachmentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getResourceAttachmentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setDownloader(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDownloader() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setOrganizationId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOrganizationId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setConditionResourceDownloadId(String op, java.lang.Integer val) {
		setConditionResourceDownloadId(op, val, CONDITION_AND);
	}

	public void setConditionResourceDownloadId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectResourceDownloadId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionResourceId(String op, java.lang.Integer val) {
		setConditionResourceId(op, val, CONDITION_AND);
	}

	public void setConditionResourceId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectResourceId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionResourceAttachmentId(String op, java.lang.Integer val) {
		setConditionResourceAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionResourceAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectResourceAttachmentId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDownloader(String op, java.lang.Integer val) {
		setConditionDownloader(op, val, CONDITION_AND);
	}

	public void setConditionDownloader(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDownloader(boolean val) {
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

	public void setConditionOrganizationId(String op, java.lang.Integer val) {
		setConditionOrganizationId(op, val, CONDITION_AND);
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOrganizationId(boolean val) {
		__select_flags[5] = val;
	}


}

