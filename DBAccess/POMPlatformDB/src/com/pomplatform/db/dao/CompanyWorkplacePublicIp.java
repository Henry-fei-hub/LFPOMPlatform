package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCompanyWorkplacePublicIp;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CompanyWorkplacePublicIp extends AbstractTable<BaseCompanyWorkplacePublicIp>
{

	public CompanyWorkplacePublicIp() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "company_workplace_public_ips";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCompanyWorkplacePublicIp.CS_COMPANY_WORKPLACE_PUBLIC_IP_ID;
		__column_names[1] = BaseCompanyWorkplacePublicIp.CS_COMPANY_WORKPLACE_ID;
		__column_names[2] = BaseCompanyWorkplacePublicIp.CS_IP_ADDRESS;
		__column_names[3] = BaseCompanyWorkplacePublicIp.CS_ACTIVE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCompanyWorkplacePublicIp b) {
		clear();
		setCompanyWorkplacePublicIpIdClear(b.getCompanyWorkplacePublicIpId());
	}

	public boolean isPrimaryKeyNull() {
		return getCompanyWorkplacePublicIpId() == null;
	}

	@Override
	public BaseCompanyWorkplacePublicIp generateBase(){
		BaseCompanyWorkplacePublicIp b = new BaseCompanyWorkplacePublicIp();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCompanyWorkplacePublicIp b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCompanyWorkplacePublicIpId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyWorkplaceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIpAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setActive(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseCompanyWorkplacePublicIp b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCompanyWorkplacePublicIpId();
		buff[count++] = b.getCompanyWorkplaceId();
		buff[count++] = b.getIpAddress();
		buff[count++] = b.getActive();
	}

	@Override
	public void setDataFromBase(BaseCompanyWorkplacePublicIp b){
		if(b.getCompanyWorkplacePublicIpId() != null) setCompanyWorkplacePublicIpIdClear(b.getCompanyWorkplacePublicIpId());
		if(b.getCompanyWorkplaceId() != null) setCompanyWorkplaceId(b.getCompanyWorkplaceId());
		if(b.getIpAddress() != null) setIpAddress(b.getIpAddress());
		if(b.getActive() != null) setActive(b.getActive());
	}

	@Override
	public BaseCompanyWorkplacePublicIp generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCompanyWorkplacePublicIp b = new BaseCompanyWorkplacePublicIp();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCompanyWorkplacePublicIp __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyWorkplacePublicIpId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyWorkplaceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIpAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActive(GenericBase.__getBoolean(val));
	}

	public void setCompanyWorkplacePublicIpId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCompanyWorkplacePublicIpId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCompanyWorkplacePublicIpIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCompanyWorkplaceId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCompanyWorkplaceId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setIpAddress(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getIpAddress() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setActive(java.lang.Boolean val) {
		setCurrentData(3, val);
	}

	public java.lang.Boolean getActive() {
		return GenericBase.__getBoolean(__current_data[3]);
	}

	public void setConditionCompanyWorkplacePublicIpId(String op, java.lang.Integer val) {
		setConditionCompanyWorkplacePublicIpId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyWorkplacePublicIpId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCompanyWorkplacePublicIpId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCompanyWorkplaceId(String op, java.lang.Integer val) {
		setConditionCompanyWorkplaceId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyWorkplaceId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCompanyWorkplaceId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionIpAddress(String op, java.lang.String val) {
		setConditionIpAddress(op, val, CONDITION_AND);
	}

	public void setConditionIpAddress(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectIpAddress(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionActive(String op, java.lang.Boolean val) {
		setConditionActive(op, val, CONDITION_AND);
	}

	public void setConditionActive(String op, java.lang.Boolean val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectActive(boolean val) {
		__select_flags[3] = val;
	}


}

