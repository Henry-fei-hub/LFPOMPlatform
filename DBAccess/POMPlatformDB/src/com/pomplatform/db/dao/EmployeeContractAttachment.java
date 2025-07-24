package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeContractAttachment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeContractAttachment extends AbstractTable<BaseEmployeeContractAttachment>
{

	public EmployeeContractAttachment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 18;

		initTables();

		__tableName            = "employee_contract_attachments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeContractAttachment.CS_EMPLOYEE_CONTRACT_ATTACHMENT_ID;
		__column_names[1] = BaseEmployeeContractAttachment.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeContractAttachment.CS_ATTACHMENT_NAME;
		__column_names[3] = BaseEmployeeContractAttachment.CS_ATTACHMENT_URL;
		__column_names[4] = BaseEmployeeContractAttachment.CS_OPERATE_EMPLOYEE_ID;
		__column_names[5] = BaseEmployeeContractAttachment.CS_OPERATE_TIME;
		__column_names[6] = BaseEmployeeContractAttachment.CS_CONTRACT_TYPE;
		__column_names[7] = BaseEmployeeContractAttachment.CS_SIGN_TYPE;
		__column_names[8] = BaseEmployeeContractAttachment.CS_START_DATE;
		__column_names[9] = BaseEmployeeContractAttachment.CS_END_DATE;
		__column_names[10] = BaseEmployeeContractAttachment.CS_WILL_END;
		__column_names[11] = BaseEmployeeContractAttachment.CS_ATTACHMENT_ID;
		__column_names[12] = BaseEmployeeContractAttachment.CS_EMPLOYEE_NO;
		__column_names[13] = BaseEmployeeContractAttachment.CS_DEPARTMENT_ID;
		__column_names[14] = BaseEmployeeContractAttachment.CS_PLATE_ID;
		__column_names[15] = BaseEmployeeContractAttachment.CS_ONBOARD_DATE;
		__column_names[16] = BaseEmployeeContractAttachment.CS_EMPLOYEE_STATUS;
		__column_names[17] = BaseEmployeeContractAttachment.CS_DELETE_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeContractAttachment b) {
		clear();
		setEmployeeContractAttachmentIdClear(b.getEmployeeContractAttachmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeContractAttachmentId() == null;
	}

	@Override
	public BaseEmployeeContractAttachment generateBase(){
		BaseEmployeeContractAttachment b = new BaseEmployeeContractAttachment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeContractAttachment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeContractAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentUrl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setContractType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSignType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setWillEnd(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEmployeeStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeContractAttachment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeContractAttachmentId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getAttachmentName();
		buff[count++] = b.getAttachmentUrl();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getContractType();
		buff[count++] = b.getSignType();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getWillEnd();
		buff[count++] = b.getAttachmentId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getPlateId();
		buff[count++] = generateTimestampFromDate(b.getOnboardDate());
		buff[count++] = b.getEmployeeStatus();
		buff[count++] = b.getDeleteFlag();
	}

	@Override
	public void setDataFromBase(BaseEmployeeContractAttachment b){
		if(b.getEmployeeContractAttachmentId() != null) setEmployeeContractAttachmentIdClear(b.getEmployeeContractAttachmentId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getAttachmentName() != null) setAttachmentName(b.getAttachmentName());
		if(b.getAttachmentUrl() != null) setAttachmentUrl(b.getAttachmentUrl());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getContractType() != null) setContractType(b.getContractType());
		if(b.getSignType() != null) setSignType(b.getSignType());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getWillEnd() != null) setWillEnd(b.getWillEnd());
		if(b.getAttachmentId() != null) setAttachmentId(b.getAttachmentId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getOnboardDate() != null) setOnboardDate(b.getOnboardDate());
		if(b.getEmployeeStatus() != null) setEmployeeStatus(b.getEmployeeStatus());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
	}

	@Override
	public BaseEmployeeContractAttachment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeContractAttachment b = new BaseEmployeeContractAttachment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeContractAttachment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeContractAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentUrl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWillEnd(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
	}

	public void setEmployeeContractAttachmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeContractAttachmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeContractAttachmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAttachmentName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getAttachmentName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setAttachmentUrl(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getAttachmentUrl() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setContractType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getContractType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSignType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getSignType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setWillEnd(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getWillEnd() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setAttachmentId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getAttachmentId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setOnboardDate(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getOnboardDate() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setEmployeeStatus(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getEmployeeStatus() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setConditionEmployeeContractAttachmentId(String op, java.lang.Integer val) {
		setConditionEmployeeContractAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeContractAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeContractAttachmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAttachmentName(String op, java.lang.String val) {
		setConditionAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAttachmentName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAttachmentUrl(String op, java.lang.String val) {
		setConditionAttachmentUrl(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentUrl(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAttachmentUrl(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionContractType(String op, java.lang.Integer val) {
		setConditionContractType(op, val, CONDITION_AND);
	}

	public void setConditionContractType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectContractType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSignType(String op, java.lang.Integer val) {
		setConditionSignType(op, val, CONDITION_AND);
	}

	public void setConditionSignType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSignType(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionWillEnd(String op, java.lang.Integer val) {
		setConditionWillEnd(op, val, CONDITION_AND);
	}

	public void setConditionWillEnd(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectWillEnd(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val) {
		setConditionAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectAttachmentId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionOnboardDate(String op, java.util.Date val) {
		setConditionOnboardDate(op, val, CONDITION_AND);
	}

	public void setConditionOnboardDate(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOnboardDate(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionEmployeeStatus(String op, java.lang.Integer val) {
		setConditionEmployeeStatus(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeStatus(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectEmployeeStatus(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[17] = val;
	}


}

