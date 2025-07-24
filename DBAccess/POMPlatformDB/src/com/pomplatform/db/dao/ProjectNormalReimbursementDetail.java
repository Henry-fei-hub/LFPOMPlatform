package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectNormalReimbursementDetail extends AbstractTable<BaseProjectNormalReimbursementDetail>
{

	public ProjectNormalReimbursementDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "project_normal_reimbursement_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectNormalReimbursementDetail.CS_PROJECT_NORMAL_REIMBURSEMENT_DETAIL_ID;
		__column_names[1] = BaseProjectNormalReimbursementDetail.CS_PROJECT_NORMAL_REIMBURSEMENT_ID;
		__column_names[2] = BaseProjectNormalReimbursementDetail.CS_MAIN_ITEM_ID;
		__column_names[3] = BaseProjectNormalReimbursementDetail.CS_SUB_ITEM_ID;
		__column_names[4] = BaseProjectNormalReimbursementDetail.CS_AMOUNT;
		__column_names[5] = BaseProjectNormalReimbursementDetail.CS_REIMBURSEMENT_TIME;
		__column_names[6] = BaseProjectNormalReimbursementDetail.CS_STATUS;
		__column_names[7] = BaseProjectNormalReimbursementDetail.CS_REMARK;
		__column_names[8] = BaseProjectNormalReimbursementDetail.CS_IDENTIFICATION;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectNormalReimbursementDetail b) {
		clear();
		setProjectNormalReimbursementDetailIdClear(b.getProjectNormalReimbursementDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectNormalReimbursementDetailId() == null;
	}

	@Override
	public BaseProjectNormalReimbursementDetail generateBase(){
		BaseProjectNormalReimbursementDetail b = new BaseProjectNormalReimbursementDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectNormalReimbursementDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectNormalReimbursementDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectNormalReimbursementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainItemId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubItemId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReimbursementTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIdentification(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectNormalReimbursementDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectNormalReimbursementDetailId();
		buff[count++] = b.getProjectNormalReimbursementId();
		buff[count++] = b.getMainItemId();
		buff[count++] = b.getSubItemId();
		buff[count++] = b.getAmount();
		buff[count++] = generateTimestampFromDate(b.getReimbursementTime());
		buff[count++] = b.getStatus();
		buff[count++] = b.getRemark();
		buff[count++] = b.getIdentification();
	}

	@Override
	public void setDataFromBase(BaseProjectNormalReimbursementDetail b){
		if(b.getProjectNormalReimbursementDetailId() != null) setProjectNormalReimbursementDetailIdClear(b.getProjectNormalReimbursementDetailId());
		if(b.getProjectNormalReimbursementId() != null) setProjectNormalReimbursementId(b.getProjectNormalReimbursementId());
		if(b.getMainItemId() != null) setMainItemId(b.getMainItemId());
		if(b.getSubItemId() != null) setSubItemId(b.getSubItemId());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getReimbursementTime() != null) setReimbursementTime(b.getReimbursementTime());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getIdentification() != null) setIdentification(b.getIdentification());
	}

	@Override
	public BaseProjectNormalReimbursementDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectNormalReimbursementDetail b = new BaseProjectNormalReimbursementDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectNormalReimbursementDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectNormalReimbursementDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectNormalReimbursementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainItemId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubItemId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIdentification(GenericBase.__getString(val));
	}

	public void setProjectNormalReimbursementDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectNormalReimbursementDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectNormalReimbursementDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectNormalReimbursementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectNormalReimbursementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMainItemId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getMainItemId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setSubItemId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getSubItemId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setReimbursementTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getReimbursementTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setIdentification(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getIdentification() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setConditionProjectNormalReimbursementDetailId(String op, java.lang.Integer val) {
		setConditionProjectNormalReimbursementDetailId(op, val, CONDITION_AND);
	}

	public void setConditionProjectNormalReimbursementDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectNormalReimbursementDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectNormalReimbursementId(String op, java.lang.Integer val) {
		setConditionProjectNormalReimbursementId(op, val, CONDITION_AND);
	}

	public void setConditionProjectNormalReimbursementId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectNormalReimbursementId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionMainItemId(String op, java.lang.Integer val) {
		setConditionMainItemId(op, val, CONDITION_AND);
	}

	public void setConditionMainItemId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMainItemId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSubItemId(String op, java.lang.Integer val) {
		setConditionSubItemId(op, val, CONDITION_AND);
	}

	public void setConditionSubItemId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSubItemId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionReimbursementTime(String op, java.util.Date val) {
		setConditionReimbursementTime(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectReimbursementTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionIdentification(String op, java.lang.String val) {
		setConditionIdentification(op, val, CONDITION_AND);
	}

	public void setConditionIdentification(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIdentification(boolean val) {
		__select_flags[8] = val;
	}


}

