package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProductInquiryTotal;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProductInquiryTotal extends AbstractTable<BaseProductInquiryTotal>
{

	public ProductInquiryTotal() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "product_inquiry_totals";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProductInquiryTotal.CS_PRODUCT_INQUIRY_TOTAL_ID;
		__column_names[1] = BaseProductInquiryTotal.CS_MAJOR_TITLE;
		__column_names[2] = BaseProductInquiryTotal.CS_PROCESS_TYPE;
		__column_names[3] = BaseProductInquiryTotal.CS_REASON;
		__column_names[4] = BaseProductInquiryTotal.CS_EMPLOYEE_NO;
		__column_names[5] = BaseProductInquiryTotal.CS_DEPARTMENT_ID;
		__column_names[6] = BaseProductInquiryTotal.CS_CREATE_EMPLOYEE_ID;
		__column_names[7] = BaseProductInquiryTotal.CS_CREATE_TIME;
		__column_names[8] = BaseProductInquiryTotal.CS_DELETE_FLAG;
		__column_names[9] = BaseProductInquiryTotal.CS_REMARK;
		__column_names[10] = BaseProductInquiryTotal.CS_MAIN_PROJECT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProductInquiryTotal b) {
		clear();
		setProductInquiryTotalIdClear(b.getProductInquiryTotalId());
	}

	public boolean isPrimaryKeyNull() {
		return getProductInquiryTotalId() == null;
	}

	@Override
	public BaseProductInquiryTotal generateBase(){
		BaseProductInquiryTotal b = new BaseProductInquiryTotal();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProductInquiryTotal b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProductInquiryTotalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMajorTitle(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReason(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProductInquiryTotal b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProductInquiryTotalId();
		buff[count++] = b.getMajorTitle();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getReason();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getRemark();
		buff[count++] = b.getMainProjectId();
	}

	@Override
	public void setDataFromBase(BaseProductInquiryTotal b){
		if(b.getProductInquiryTotalId() != null) setProductInquiryTotalIdClear(b.getProductInquiryTotalId());
		if(b.getMajorTitle() != null) setMajorTitle(b.getMajorTitle());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getReason() != null) setReason(b.getReason());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
	}

	@Override
	public BaseProductInquiryTotal generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProductInquiryTotal b = new BaseProductInquiryTotal();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProductInquiryTotal __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductInquiryTotalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMajorTitle(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReason(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
	}

	public void setProductInquiryTotalId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProductInquiryTotalId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProductInquiryTotalIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMajorTitle(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getMajorTitle() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setReason(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getReason() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setConditionProductInquiryTotalId(String op, java.lang.Integer val) {
		setConditionProductInquiryTotalId(op, val, CONDITION_AND);
	}

	public void setConditionProductInquiryTotalId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProductInquiryTotalId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionMajorTitle(String op, java.lang.String val) {
		setConditionMajorTitle(op, val, CONDITION_AND);
	}

	public void setConditionMajorTitle(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMajorTitle(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionReason(String op, java.lang.String val) {
		setConditionReason(op, val, CONDITION_AND);
	}

	public void setConditionReason(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectReason(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
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

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[10] = val;
	}


}

