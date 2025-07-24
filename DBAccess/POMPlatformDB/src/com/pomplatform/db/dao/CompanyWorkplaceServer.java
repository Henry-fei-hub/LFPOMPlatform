package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCompanyWorkplaceServer;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CompanyWorkplaceServer extends AbstractTable<BaseCompanyWorkplaceServer>
{

	public CompanyWorkplaceServer() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "company_workplace_servers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCompanyWorkplaceServer.CS_WORKPLACE_SERVER_ID;
		__column_names[1] = BaseCompanyWorkplaceServer.CS_WORKPLACE_ID;
		__column_names[2] = BaseCompanyWorkplaceServer.CS_INTRANET_SERVER_ADDRESS;
		__column_names[3] = BaseCompanyWorkplaceServer.CS_INTRANET_SERVER_PORT;
		__column_names[4] = BaseCompanyWorkplaceServer.CS_EXTERNAL_SERVER_ADDRESS;
		__column_names[5] = BaseCompanyWorkplaceServer.CS_EXTERNAL_SERVER_PORT;
		__column_names[6] = BaseCompanyWorkplaceServer.CS_EXTERNAL_SERVER_USEABLE;
		__column_names[7] = BaseCompanyWorkplaceServer.CS_URL;
		__column_names[8] = BaseCompanyWorkplaceServer.CS_ACTIVE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCompanyWorkplaceServer b) {
		clear();
		setWorkplaceServerIdClear(b.getWorkplaceServerId());
	}

	public boolean isPrimaryKeyNull() {
		return getWorkplaceServerId() == null;
	}

	@Override
	public BaseCompanyWorkplaceServer generateBase(){
		BaseCompanyWorkplaceServer b = new BaseCompanyWorkplaceServer();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCompanyWorkplaceServer b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setWorkplaceServerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkplaceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIntranetServerAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIntranetServerPort(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setExternalServerAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setExternalServerPort(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setExternalServerUseable(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setUrl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setActive(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseCompanyWorkplaceServer b, Object[] buff){
		int count = 0;
		buff[count++] = b.getWorkplaceServerId();
		buff[count++] = b.getWorkplaceId();
		buff[count++] = b.getIntranetServerAddress();
		buff[count++] = b.getIntranetServerPort();
		buff[count++] = b.getExternalServerAddress();
		buff[count++] = b.getExternalServerPort();
		buff[count++] = b.getExternalServerUseable();
		buff[count++] = b.getUrl();
		buff[count++] = b.getActive();
	}

	@Override
	public void setDataFromBase(BaseCompanyWorkplaceServer b){
		if(b.getWorkplaceServerId() != null) setWorkplaceServerIdClear(b.getWorkplaceServerId());
		if(b.getWorkplaceId() != null) setWorkplaceId(b.getWorkplaceId());
		if(b.getIntranetServerAddress() != null) setIntranetServerAddress(b.getIntranetServerAddress());
		if(b.getIntranetServerPort() != null) setIntranetServerPort(b.getIntranetServerPort());
		if(b.getExternalServerAddress() != null) setExternalServerAddress(b.getExternalServerAddress());
		if(b.getExternalServerPort() != null) setExternalServerPort(b.getExternalServerPort());
		if(b.getExternalServerUseable() != null) setExternalServerUseable(b.getExternalServerUseable());
		if(b.getUrl() != null) setUrl(b.getUrl());
		if(b.getActive() != null) setActive(b.getActive());
	}

	@Override
	public BaseCompanyWorkplaceServer generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCompanyWorkplaceServer b = new BaseCompanyWorkplaceServer();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCompanyWorkplaceServer __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkplaceServerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkplaceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIntranetServerAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIntranetServerPort(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExternalServerAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExternalServerPort(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExternalServerUseable(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUrl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActive(GenericBase.__getBoolean(val));
	}

	public void setWorkplaceServerId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getWorkplaceServerId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setWorkplaceServerIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setWorkplaceId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getWorkplaceId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setIntranetServerAddress(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getIntranetServerAddress() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setIntranetServerPort(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getIntranetServerPort() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setExternalServerAddress(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getExternalServerAddress() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setExternalServerPort(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getExternalServerPort() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setExternalServerUseable(java.lang.Boolean val) {
		setCurrentData(6, val);
	}

	public java.lang.Boolean getExternalServerUseable() {
		return GenericBase.__getBoolean(__current_data[6]);
	}

	public void setUrl(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getUrl() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setActive(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getActive() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setConditionWorkplaceServerId(String op, java.lang.Integer val) {
		setConditionWorkplaceServerId(op, val, CONDITION_AND);
	}

	public void setConditionWorkplaceServerId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectWorkplaceServerId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionWorkplaceId(String op, java.lang.Integer val) {
		setConditionWorkplaceId(op, val, CONDITION_AND);
	}

	public void setConditionWorkplaceId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectWorkplaceId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionIntranetServerAddress(String op, java.lang.String val) {
		setConditionIntranetServerAddress(op, val, CONDITION_AND);
	}

	public void setConditionIntranetServerAddress(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectIntranetServerAddress(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIntranetServerPort(String op, java.lang.Integer val) {
		setConditionIntranetServerPort(op, val, CONDITION_AND);
	}

	public void setConditionIntranetServerPort(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIntranetServerPort(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionExternalServerAddress(String op, java.lang.String val) {
		setConditionExternalServerAddress(op, val, CONDITION_AND);
	}

	public void setConditionExternalServerAddress(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectExternalServerAddress(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionExternalServerPort(String op, java.lang.Integer val) {
		setConditionExternalServerPort(op, val, CONDITION_AND);
	}

	public void setConditionExternalServerPort(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectExternalServerPort(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionExternalServerUseable(String op, java.lang.Boolean val) {
		setConditionExternalServerUseable(op, val, CONDITION_AND);
	}

	public void setConditionExternalServerUseable(String op, java.lang.Boolean val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectExternalServerUseable(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionUrl(String op, java.lang.String val) {
		setConditionUrl(op, val, CONDITION_AND);
	}

	public void setConditionUrl(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectUrl(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionActive(String op, java.lang.Boolean val) {
		setConditionActive(op, val, CONDITION_AND);
	}

	public void setConditionActive(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectActive(boolean val) {
		__select_flags[8] = val;
	}


}

