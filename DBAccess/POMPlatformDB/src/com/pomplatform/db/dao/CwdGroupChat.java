package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdGroupChat;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdGroupChat extends AbstractTable<BaseCwdGroupChat>
{

	public CwdGroupChat() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "cwd_group_chats";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdGroupChat.CS_GROUP_CHAT_ID;
		__column_names[1] = BaseCwdGroupChat.CS_MAIN_PROJECT_ID;
		__column_names[2] = BaseCwdGroupChat.CS_CHAT_NAME;
		__column_names[3] = BaseCwdGroupChat.CS_GROUP_TYPE;
		__column_names[4] = BaseCwdGroupChat.CS_WEIXIN_OWNER;
		__column_names[5] = BaseCwdGroupChat.CS_WEIXIN_CHAT_ID;
		__column_names[6] = BaseCwdGroupChat.CS_OPERATOR_ID;
		__column_names[7] = BaseCwdGroupChat.CS_CREATE_TIME;
		__column_names[8] = BaseCwdGroupChat.CS_CREATE_APPLICATION_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdGroupChat b) {
		clear();
		setGroupChatIdClear(b.getGroupChatId());
	}

	public boolean isPrimaryKeyNull() {
		return getGroupChatId() == null;
	}

	@Override
	public BaseCwdGroupChat generateBase(){
		BaseCwdGroupChat b = new BaseCwdGroupChat();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdGroupChat b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setGroupChatId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setChatName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setGroupType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWeixinOwner(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWeixinChatId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateApplicationType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdGroupChat b, Object[] buff){
		int count = 0;
		buff[count++] = b.getGroupChatId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getChatName();
		buff[count++] = b.getGroupType();
		buff[count++] = b.getWeixinOwner();
		buff[count++] = b.getWeixinChatId();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getCreateApplicationType();
	}

	@Override
	public void setDataFromBase(BaseCwdGroupChat b){
		if(b.getGroupChatId() != null) setGroupChatIdClear(b.getGroupChatId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getChatName() != null) setChatName(b.getChatName());
		if(b.getGroupType() != null) setGroupType(b.getGroupType());
		if(b.getWeixinOwner() != null) setWeixinOwner(b.getWeixinOwner());
		if(b.getWeixinChatId() != null) setWeixinChatId(b.getWeixinChatId());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getCreateApplicationType() != null) setCreateApplicationType(b.getCreateApplicationType());
	}

	@Override
	public BaseCwdGroupChat generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdGroupChat b = new BaseCwdGroupChat();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdGroupChat __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGroupChatId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setChatName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGroupType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWeixinOwner(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWeixinChatId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateApplicationType(GenericBase.__getInt(val));
	}

	public void setGroupChatId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getGroupChatId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setGroupChatIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setChatName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getChatName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setGroupType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getGroupType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setWeixinOwner(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getWeixinOwner() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setWeixinChatId(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getWeixinChatId() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setCreateApplicationType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getCreateApplicationType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setConditionGroupChatId(String op, java.lang.Integer val) {
		setConditionGroupChatId(op, val, CONDITION_AND);
	}

	public void setConditionGroupChatId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectGroupChatId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionChatName(String op, java.lang.String val) {
		setConditionChatName(op, val, CONDITION_AND);
	}

	public void setConditionChatName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectChatName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionGroupType(String op, java.lang.Integer val) {
		setConditionGroupType(op, val, CONDITION_AND);
	}

	public void setConditionGroupType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectGroupType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionWeixinOwner(String op, java.lang.String val) {
		setConditionWeixinOwner(op, val, CONDITION_AND);
	}

	public void setConditionWeixinOwner(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectWeixinOwner(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionWeixinChatId(String op, java.lang.String val) {
		setConditionWeixinChatId(op, val, CONDITION_AND);
	}

	public void setConditionWeixinChatId(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectWeixinChatId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCreateApplicationType(String op, java.lang.Integer val) {
		setConditionCreateApplicationType(op, val, CONDITION_AND);
	}

	public void setConditionCreateApplicationType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCreateApplicationType(boolean val) {
		__select_flags[8] = val;
	}


}

