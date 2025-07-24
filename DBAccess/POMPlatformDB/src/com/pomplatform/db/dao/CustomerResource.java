package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCustomerResource;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CustomerResource extends AbstractTable<BaseCustomerResource>
{

	public CustomerResource() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "customer_resources";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCustomerResource.CS_CUSTOMER_RESOURCE_ID;
		__column_names[1] = BaseCustomerResource.CS_COMPANY_NAME;
		__column_names[2] = BaseCustomerResource.CS_COMPANY_ADDRESS;
		__column_names[3] = BaseCustomerResource.CS_NAME;
		__column_names[4] = BaseCustomerResource.CS_GRADE;
		__column_names[5] = BaseCustomerResource.CS_TELEPHONE;
		__column_names[6] = BaseCustomerResource.CS_EMAIL;
		__column_names[7] = BaseCustomerResource.CS_BIRTH_DATE;
		__column_names[8] = BaseCustomerResource.CS_GENDER;
		__column_names[9] = BaseCustomerResource.CS_OPERATE_EMPLOYEE_ID;
		__column_names[10] = BaseCustomerResource.CS_OPERATE_TIME;
		__column_names[11] = BaseCustomerResource.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCustomerResource b) {
		clear();
		setCustomerResourceIdClear(b.getCustomerResourceId());
	}

	public boolean isPrimaryKeyNull() {
		return getCustomerResourceId() == null;
	}

	@Override
	public BaseCustomerResource generateBase(){
		BaseCustomerResource b = new BaseCustomerResource();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCustomerResource b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCustomerResourceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setGrade(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTelephone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmail(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBirthDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setGender(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCustomerResource b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCustomerResourceId();
		buff[count++] = b.getCompanyName();
		buff[count++] = b.getCompanyAddress();
		buff[count++] = b.getName();
		buff[count++] = b.getGrade();
		buff[count++] = b.getTelephone();
		buff[count++] = b.getEmail();
		buff[count++] = generateTimestampFromDate(b.getBirthDate());
		buff[count++] = b.getGender();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseCustomerResource b){
		if(b.getCustomerResourceId() != null) setCustomerResourceIdClear(b.getCustomerResourceId());
		if(b.getCompanyName() != null) setCompanyName(b.getCompanyName());
		if(b.getCompanyAddress() != null) setCompanyAddress(b.getCompanyAddress());
		if(b.getName() != null) setName(b.getName());
		if(b.getGrade() != null) setGrade(b.getGrade());
		if(b.getTelephone() != null) setTelephone(b.getTelephone());
		if(b.getEmail() != null) setEmail(b.getEmail());
		if(b.getBirthDate() != null) setBirthDate(b.getBirthDate());
		if(b.getGender() != null) setGender(b.getGender());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseCustomerResource generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCustomerResource b = new BaseCustomerResource();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCustomerResource __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerResourceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGrade(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTelephone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmail(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBirthDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGender(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setCustomerResourceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCustomerResourceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCustomerResourceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCompanyName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCompanyName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setCompanyAddress(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCompanyAddress() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setGrade(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getGrade() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setTelephone(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getTelephone() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setEmail(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getEmail() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setBirthDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getBirthDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setGender(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getGender() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setConditionCustomerResourceId(String op, java.lang.Integer val) {
		setConditionCustomerResourceId(op, val, CONDITION_AND);
	}

	public void setConditionCustomerResourceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCustomerResourceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCompanyName(String op, java.lang.String val) {
		setConditionCompanyName(op, val, CONDITION_AND);
	}

	public void setConditionCompanyName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCompanyName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCompanyAddress(String op, java.lang.String val) {
		setConditionCompanyAddress(op, val, CONDITION_AND);
	}

	public void setConditionCompanyAddress(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCompanyAddress(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionGrade(String op, java.lang.String val) {
		setConditionGrade(op, val, CONDITION_AND);
	}

	public void setConditionGrade(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectGrade(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionTelephone(String op, java.lang.String val) {
		setConditionTelephone(op, val, CONDITION_AND);
	}

	public void setConditionTelephone(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectTelephone(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionEmail(String op, java.lang.String val) {
		setConditionEmail(op, val, CONDITION_AND);
	}

	public void setConditionEmail(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectEmail(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionBirthDate(String op, java.util.Date val) {
		setConditionBirthDate(op, val, CONDITION_AND);
	}

	public void setConditionBirthDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectBirthDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionGender(String op, java.lang.Integer val) {
		setConditionGender(op, val, CONDITION_AND);
	}

	public void setConditionGender(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectGender(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[11] = val;
	}


}

