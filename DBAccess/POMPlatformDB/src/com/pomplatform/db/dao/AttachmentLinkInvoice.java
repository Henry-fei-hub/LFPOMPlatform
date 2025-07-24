package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAttachmentLinkInvoice;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class AttachmentLinkInvoice extends AbstractTable<BaseAttachmentLinkInvoice>
{

	public AttachmentLinkInvoice() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "attachment_link_invoices";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAttachmentLinkInvoice.CS_ATTACHMENT_LINK_INVOICE_ID;
		__column_names[1] = BaseAttachmentLinkInvoice.CS_ATTACHMENT_MANAGE_ID;
		__column_names[2] = BaseAttachmentLinkInvoice.CS_INVOICE_ID;
		__column_names[3] = BaseAttachmentLinkInvoice.CS_OPERATE_EMPLOYEE_ID;
		__column_names[4] = BaseAttachmentLinkInvoice.CS_OPERATE_TIME;
		__column_names[5] = BaseAttachmentLinkInvoice.CS_REMARK;
		__column_names[6] = BaseAttachmentLinkInvoice.CS_PERSONNEL_BUSINESS_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAttachmentLinkInvoice b) {
		clear();
		setAttachmentLinkInvoiceIdClear(b.getAttachmentLinkInvoiceId());
	}

	public boolean isPrimaryKeyNull() {
		return getAttachmentLinkInvoiceId() == null;
	}

	@Override
	public BaseAttachmentLinkInvoice generateBase(){
		BaseAttachmentLinkInvoice b = new BaseAttachmentLinkInvoice();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAttachmentLinkInvoice b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAttachmentLinkInvoiceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseAttachmentLinkInvoice b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAttachmentLinkInvoiceId();
		buff[count++] = b.getAttachmentManageId();
		buff[count++] = b.getInvoiceId();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getPersonnelBusinessId();
	}

	@Override
	public void setDataFromBase(BaseAttachmentLinkInvoice b){
		if(b.getAttachmentLinkInvoiceId() != null) setAttachmentLinkInvoiceIdClear(b.getAttachmentLinkInvoiceId());
		if(b.getAttachmentManageId() != null) setAttachmentManageId(b.getAttachmentManageId());
		if(b.getInvoiceId() != null) setInvoiceId(b.getInvoiceId());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
	}

	@Override
	public BaseAttachmentLinkInvoice generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAttachmentLinkInvoice b = new BaseAttachmentLinkInvoice();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAttachmentLinkInvoice __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentLinkInvoiceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
	}

	public void setAttachmentLinkInvoiceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAttachmentLinkInvoiceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAttachmentLinkInvoiceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAttachmentManageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getAttachmentManageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setInvoiceId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getInvoiceId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setConditionAttachmentLinkInvoiceId(String op, java.lang.Integer val) {
		setConditionAttachmentLinkInvoiceId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentLinkInvoiceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAttachmentLinkInvoiceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionAttachmentManageId(String op, java.lang.Integer val) {
		setConditionAttachmentManageId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentManageId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectAttachmentManageId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionInvoiceId(String op, java.lang.Integer val) {
		setConditionInvoiceId(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectInvoiceId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[6] = val;
	}


}

