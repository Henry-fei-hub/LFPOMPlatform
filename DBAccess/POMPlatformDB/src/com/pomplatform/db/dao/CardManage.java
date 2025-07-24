package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCardManage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CardManage extends AbstractTable<BaseCardManage>
{

	public CardManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "card_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCardManage.CS_CARD_MANAGE_ID;
		__column_names[1] = BaseCardManage.CS_OBJECT_ID;
		__column_names[2] = BaseCardManage.CS_OBJECT_TYPE;
		__column_names[3] = BaseCardManage.CS_BANK_ID;
		__column_names[4] = BaseCardManage.CS_BANK_ACCOUNT;
		__column_names[5] = BaseCardManage.CS_BANK_ADDRESS;
		__column_names[6] = BaseCardManage.CS_CARD_TYPE;
		__column_names[7] = BaseCardManage.CS_DEFAULT_CARD;
		__column_names[8] = BaseCardManage.CS_ENABLED;
		__column_names[9] = BaseCardManage.CS_CURRENCY_TYPE;
		__column_names[10] = BaseCardManage.CS_CMBC_CODE_ID;
		__column_names[11] = BaseCardManage.CS_TRUE_PAYMENT;
		__column_names[12] = BaseCardManage.CS_BANK_NAME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCardManage b) {
		clear();
		setCardManageIdClear(b.getCardManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getCardManageId() == null;
	}

	@Override
	public BaseCardManage generateBase(){
		BaseCardManage b = new BaseCardManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCardManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCardManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setObjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setObjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBankId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBankAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCardType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDefaultCard(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setEnabled(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCurrencyType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCmbcCodeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTruePayment(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setBankName(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCardManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCardManageId();
		buff[count++] = b.getObjectId();
		buff[count++] = b.getObjectType();
		buff[count++] = b.getBankId();
		buff[count++] = b.getBankAccount();
		buff[count++] = b.getBankAddress();
		buff[count++] = b.getCardType();
		buff[count++] = b.getDefaultCard();
		buff[count++] = b.getEnabled();
		buff[count++] = b.getCurrencyType();
		buff[count++] = b.getCmbcCodeId();
		buff[count++] = b.getTruePayment();
		buff[count++] = b.getBankName();
	}

	@Override
	public void setDataFromBase(BaseCardManage b){
		if(b.getCardManageId() != null) setCardManageIdClear(b.getCardManageId());
		if(b.getObjectId() != null) setObjectId(b.getObjectId());
		if(b.getObjectType() != null) setObjectType(b.getObjectType());
		if(b.getBankId() != null) setBankId(b.getBankId());
		if(b.getBankAccount() != null) setBankAccount(b.getBankAccount());
		if(b.getBankAddress() != null) setBankAddress(b.getBankAddress());
		if(b.getCardType() != null) setCardType(b.getCardType());
		if(b.getDefaultCard() != null) setDefaultCard(b.getDefaultCard());
		if(b.getEnabled() != null) setEnabled(b.getEnabled());
		if(b.getCurrencyType() != null) setCurrencyType(b.getCurrencyType());
		if(b.getCmbcCodeId() != null) setCmbcCodeId(b.getCmbcCodeId());
		if(b.getTruePayment() != null) setTruePayment(b.getTruePayment());
		if(b.getBankName() != null) setBankName(b.getBankName());
	}

	@Override
	public BaseCardManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCardManage b = new BaseCardManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCardManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCardManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setObjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setObjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCardType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDefaultCard(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEnabled(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrencyType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmbcCodeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTruePayment(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankName(GenericBase.__getString(val));
	}

	public void setCardManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCardManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCardManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setObjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getObjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setObjectType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getObjectType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setBankId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getBankId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setBankAccount(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getBankAccount() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setBankAddress(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getBankAddress() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setCardType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getCardType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setDefaultCard(java.lang.Boolean val) {
		setCurrentData(7, val);
	}

	public java.lang.Boolean getDefaultCard() {
		return GenericBase.__getBoolean(__current_data[7]);
	}

	public void setEnabled(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getEnabled() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setCurrencyType(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getCurrencyType() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setCmbcCodeId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getCmbcCodeId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setTruePayment(java.lang.Boolean val) {
		setCurrentData(11, val);
	}

	public java.lang.Boolean getTruePayment() {
		return GenericBase.__getBoolean(__current_data[11]);
	}

	public void setBankName(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getBankName() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setConditionCardManageId(String op, java.lang.Integer val) {
		setConditionCardManageId(op, val, CONDITION_AND);
	}

	public void setConditionCardManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCardManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionObjectId(String op, java.lang.Integer val) {
		setConditionObjectId(op, val, CONDITION_AND);
	}

	public void setConditionObjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectObjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionObjectType(String op, java.lang.Integer val) {
		setConditionObjectType(op, val, CONDITION_AND);
	}

	public void setConditionObjectType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectObjectType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBankId(String op, java.lang.Integer val) {
		setConditionBankId(op, val, CONDITION_AND);
	}

	public void setConditionBankId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBankId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBankAccount(String op, java.lang.String val) {
		setConditionBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionBankAccount(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBankAccount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionBankAddress(String op, java.lang.String val) {
		setConditionBankAddress(op, val, CONDITION_AND);
	}

	public void setConditionBankAddress(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectBankAddress(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCardType(String op, java.lang.Integer val) {
		setConditionCardType(op, val, CONDITION_AND);
	}

	public void setConditionCardType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCardType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionDefaultCard(String op, java.lang.Boolean val) {
		setConditionDefaultCard(op, val, CONDITION_AND);
	}

	public void setConditionDefaultCard(String op, java.lang.Boolean val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectDefaultCard(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionEnabled(String op, java.lang.Boolean val) {
		setConditionEnabled(op, val, CONDITION_AND);
	}

	public void setConditionEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectEnabled(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCurrencyType(String op, java.lang.Integer val) {
		setConditionCurrencyType(op, val, CONDITION_AND);
	}

	public void setConditionCurrencyType(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCurrencyType(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCmbcCodeId(String op, java.lang.Integer val) {
		setConditionCmbcCodeId(op, val, CONDITION_AND);
	}

	public void setConditionCmbcCodeId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectCmbcCodeId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionTruePayment(String op, java.lang.Boolean val) {
		setConditionTruePayment(op, val, CONDITION_AND);
	}

	public void setConditionTruePayment(String op, java.lang.Boolean val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectTruePayment(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionBankName(String op, java.lang.String val) {
		setConditionBankName(op, val, CONDITION_AND);
	}

	public void setConditionBankName(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectBankName(boolean val) {
		__select_flags[12] = val;
	}


}

