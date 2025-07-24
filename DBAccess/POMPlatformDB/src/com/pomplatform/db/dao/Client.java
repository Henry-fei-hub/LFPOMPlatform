package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseClient;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Client extends AbstractTable<BaseClient>
{

	public Client() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "clients";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseClient.CS_CLIENT_ID;
		__column_names[1] = BaseClient.CS_CLIENT_NAME;
		__column_names[2] = BaseClient.CS_CLIENT_PHONE;
		__column_names[3] = BaseClient.CS_CLIENT_COMPANY;
		__column_names[4] = BaseClient.CS_CLIENT_ADDRESS;
		__column_names[5] = BaseClient.CS_CLIENT_JOB;
		__column_names[6] = BaseClient.CS_CLIENT_WEIXIN;
		__column_names[7] = BaseClient.CS_CLIENT_QQ;
		__column_names[8] = BaseClient.CS_CLIENT_EMAIL;
		__column_names[9] = BaseClient.CS_CLIENT_ROLE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseClient b) {
		clear();
		setClientIdClear(b.getClientId());
	}

	public boolean isPrimaryKeyNull() {
		return getClientId() == null;
	}

	@Override
	public BaseClient generateBase(){
		BaseClient b = new BaseClient();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseClient b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setClientId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setClientName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setClientPhone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setClientCompany(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setClientAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setClientJob(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setClientWeixin(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setClientQq(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setClientEmail(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setClientRole(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseClient b, Object[] buff){
		int count = 0;
		buff[count++] = b.getClientId();
		buff[count++] = b.getClientName();
		buff[count++] = b.getClientPhone();
		buff[count++] = b.getClientCompany();
		buff[count++] = b.getClientAddress();
		buff[count++] = b.getClientJob();
		buff[count++] = b.getClientWeixin();
		buff[count++] = b.getClientQq();
		buff[count++] = b.getClientEmail();
		buff[count++] = b.getClientRole();
	}

	@Override
	public void setDataFromBase(BaseClient b){
		if(b.getClientId() != null) setClientIdClear(b.getClientId());
		if(b.getClientName() != null) setClientName(b.getClientName());
		if(b.getClientPhone() != null) setClientPhone(b.getClientPhone());
		if(b.getClientCompany() != null) setClientCompany(b.getClientCompany());
		if(b.getClientAddress() != null) setClientAddress(b.getClientAddress());
		if(b.getClientJob() != null) setClientJob(b.getClientJob());
		if(b.getClientWeixin() != null) setClientWeixin(b.getClientWeixin());
		if(b.getClientQq() != null) setClientQq(b.getClientQq());
		if(b.getClientEmail() != null) setClientEmail(b.getClientEmail());
		if(b.getClientRole() != null) setClientRole(b.getClientRole());
	}

	@Override
	public BaseClient generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseClient b = new BaseClient();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseClient __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientPhone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientCompany(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientJob(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientWeixin(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientQq(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientEmail(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientRole(GenericBase.__getInt(val));
	}

	public void setClientId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getClientId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setClientIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setClientName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getClientName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setClientPhone(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getClientPhone() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setClientCompany(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getClientCompany() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setClientAddress(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getClientAddress() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setClientJob(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getClientJob() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setClientWeixin(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getClientWeixin() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setClientQq(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getClientQq() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setClientEmail(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getClientEmail() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setClientRole(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getClientRole() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setConditionClientId(String op, java.lang.Integer val) {
		setConditionClientId(op, val, CONDITION_AND);
	}

	public void setConditionClientId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectClientId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionClientName(String op, java.lang.String val) {
		setConditionClientName(op, val, CONDITION_AND);
	}

	public void setConditionClientName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectClientName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionClientPhone(String op, java.lang.String val) {
		setConditionClientPhone(op, val, CONDITION_AND);
	}

	public void setConditionClientPhone(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectClientPhone(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionClientCompany(String op, java.lang.String val) {
		setConditionClientCompany(op, val, CONDITION_AND);
	}

	public void setConditionClientCompany(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectClientCompany(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionClientAddress(String op, java.lang.String val) {
		setConditionClientAddress(op, val, CONDITION_AND);
	}

	public void setConditionClientAddress(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectClientAddress(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionClientJob(String op, java.lang.String val) {
		setConditionClientJob(op, val, CONDITION_AND);
	}

	public void setConditionClientJob(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectClientJob(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionClientWeixin(String op, java.lang.String val) {
		setConditionClientWeixin(op, val, CONDITION_AND);
	}

	public void setConditionClientWeixin(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectClientWeixin(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionClientQq(String op, java.lang.String val) {
		setConditionClientQq(op, val, CONDITION_AND);
	}

	public void setConditionClientQq(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectClientQq(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionClientEmail(String op, java.lang.String val) {
		setConditionClientEmail(op, val, CONDITION_AND);
	}

	public void setConditionClientEmail(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectClientEmail(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionClientRole(String op, java.lang.Integer val) {
		setConditionClientRole(op, val, CONDITION_AND);
	}

	public void setConditionClientRole(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectClientRole(boolean val) {
		__select_flags[9] = val;
	}


}

