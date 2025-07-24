package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectQuote;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectQuote extends AbstractTable<BaseProjectQuote>
{

	public ProjectQuote() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 24;

		initTables();

		__tableName            = "project_quotes";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectQuote.CS_PROJECT_QUOTE_ID;
		__column_names[1] = BaseProjectQuote.CS_PROJECT_ID;
		__column_names[2] = BaseProjectQuote.CS_TITLE_NAME;
		__column_names[3] = BaseProjectQuote.CS_FILE_ID;
		__column_names[4] = BaseProjectQuote.CS_VERSION_NUMBER;
		__column_names[5] = BaseProjectQuote.CS_QUOTE_STATUS;
		__column_names[6] = BaseProjectQuote.CS_BASIC_AMOUNT;
		__column_names[7] = BaseProjectQuote.CS_TOTAL_AMOUNT;
		__column_names[8] = BaseProjectQuote.CS_UP_AMOUNT;
		__column_names[9] = BaseProjectQuote.CS_UP_PERCENT;
		__column_names[10] = BaseProjectQuote.CS_PREFERENTIAL_AMOUNT;
		__column_names[11] = BaseProjectQuote.CS_PERFERENTIAL_PERCENT;
		__column_names[12] = BaseProjectQuote.CS_SPECIAL_DISCOUNT_AMOUNT;
		__column_names[13] = BaseProjectQuote.CS_SPECIAL_DISCOUNT_PERCENT;
		__column_names[14] = BaseProjectQuote.CS_TAX_AMOUNT;
		__column_names[15] = BaseProjectQuote.CS_OTHER_TAX_AMOUNT;
		__column_names[16] = BaseProjectQuote.CS_FINAL_PERCENT;
		__column_names[17] = BaseProjectQuote.CS_FINAL_AMOUNT;
		__column_names[18] = BaseProjectQuote.CS_TAX_FINAL_AMOUNT;
		__column_names[19] = BaseProjectQuote.CS_OPERATE_EMPLOYEE_ID;
		__column_names[20] = BaseProjectQuote.CS_OPERATE_TIME;
		__column_names[21] = BaseProjectQuote.CS_REMARK;
		__column_names[22] = BaseProjectQuote.CS_PROJECT_QUOTE_TEMPLATES_PARENT_ID;
		__column_names[23] = BaseProjectQuote.CS_BUSINESS_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectQuote b) {
		clear();
		setProjectQuoteIdClear(b.getProjectQuoteId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectQuoteId() == null;
	}

	@Override
	public BaseProjectQuote generateBase(){
		BaseProjectQuote b = new BaseProjectQuote();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectQuote b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectQuoteId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTitleName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setVersionNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setQuoteStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBasicAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUpAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUpPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPreferentialAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPerferentialPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDiscountAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDiscountPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTaxAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOtherTaxAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinalPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTaxFinalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectQuoteTemplatesParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectQuote b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectQuoteId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getTitleName();
		buff[count++] = b.getFileId();
		buff[count++] = b.getVersionNumber();
		buff[count++] = b.getQuoteStatus();
		buff[count++] = b.getBasicAmount();
		buff[count++] = b.getTotalAmount();
		buff[count++] = b.getUpAmount();
		buff[count++] = b.getUpPercent();
		buff[count++] = b.getPreferentialAmount();
		buff[count++] = b.getPerferentialPercent();
		buff[count++] = b.getSpecialDiscountAmount();
		buff[count++] = b.getSpecialDiscountPercent();
		buff[count++] = b.getTaxAmount();
		buff[count++] = b.getOtherTaxAmount();
		buff[count++] = b.getFinalPercent();
		buff[count++] = b.getFinalAmount();
		buff[count++] = b.getTaxFinalAmount();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getProjectQuoteTemplatesParentId();
		buff[count++] = b.getBusinessType();
	}

	@Override
	public void setDataFromBase(BaseProjectQuote b){
		if(b.getProjectQuoteId() != null) setProjectQuoteIdClear(b.getProjectQuoteId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getTitleName() != null) setTitleName(b.getTitleName());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getVersionNumber() != null) setVersionNumber(b.getVersionNumber());
		if(b.getQuoteStatus() != null) setQuoteStatus(b.getQuoteStatus());
		if(b.getBasicAmount() != null) setBasicAmount(b.getBasicAmount());
		if(b.getTotalAmount() != null) setTotalAmount(b.getTotalAmount());
		if(b.getUpAmount() != null) setUpAmount(b.getUpAmount());
		if(b.getUpPercent() != null) setUpPercent(b.getUpPercent());
		if(b.getPreferentialAmount() != null) setPreferentialAmount(b.getPreferentialAmount());
		if(b.getPerferentialPercent() != null) setPerferentialPercent(b.getPerferentialPercent());
		if(b.getSpecialDiscountAmount() != null) setSpecialDiscountAmount(b.getSpecialDiscountAmount());
		if(b.getSpecialDiscountPercent() != null) setSpecialDiscountPercent(b.getSpecialDiscountPercent());
		if(b.getTaxAmount() != null) setTaxAmount(b.getTaxAmount());
		if(b.getOtherTaxAmount() != null) setOtherTaxAmount(b.getOtherTaxAmount());
		if(b.getFinalPercent() != null) setFinalPercent(b.getFinalPercent());
		if(b.getFinalAmount() != null) setFinalAmount(b.getFinalAmount());
		if(b.getTaxFinalAmount() != null) setTaxFinalAmount(b.getTaxFinalAmount());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getProjectQuoteTemplatesParentId() != null) setProjectQuoteTemplatesParentId(b.getProjectQuoteTemplatesParentId());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
	}

	@Override
	public BaseProjectQuote generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectQuote b = new BaseProjectQuote();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectQuote __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectQuoteId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTitleName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVersionNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setQuoteStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreferentialAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPerferentialPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDiscountAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDiscountPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherTaxAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinalPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxFinalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectQuoteTemplatesParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
	}

	public void setProjectQuoteId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectQuoteId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectQuoteIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setTitleName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getTitleName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setVersionNumber(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getVersionNumber() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setQuoteStatus(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getQuoteStatus() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setBasicAmount(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getBasicAmount() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setTotalAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getTotalAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setUpAmount(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getUpAmount() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setUpPercent(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getUpPercent() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setPreferentialAmount(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getPreferentialAmount() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setPerferentialPercent(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getPerferentialPercent() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setSpecialDiscountAmount(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getSpecialDiscountAmount() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setSpecialDiscountPercent(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getSpecialDiscountPercent() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setTaxAmount(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getTaxAmount() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setOtherTaxAmount(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getOtherTaxAmount() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setFinalPercent(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getFinalPercent() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setFinalAmount(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getFinalAmount() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setTaxFinalAmount(java.math.BigDecimal val) {
		setCurrentData(18, val);
	}

	public java.math.BigDecimal getTaxFinalAmount() {
		return GenericBase.__getDecimal(__current_data[18]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(20, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[20]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setProjectQuoteTemplatesParentId(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getProjectQuoteTemplatesParentId() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setConditionProjectQuoteId(String op, java.lang.Integer val) {
		setConditionProjectQuoteId(op, val, CONDITION_AND);
	}

	public void setConditionProjectQuoteId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectQuoteId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionTitleName(String op, java.lang.String val) {
		setConditionTitleName(op, val, CONDITION_AND);
	}

	public void setConditionTitleName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTitleName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionVersionNumber(String op, java.lang.Integer val) {
		setConditionVersionNumber(op, val, CONDITION_AND);
	}

	public void setConditionVersionNumber(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectVersionNumber(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionQuoteStatus(String op, java.lang.Integer val) {
		setConditionQuoteStatus(op, val, CONDITION_AND);
	}

	public void setConditionQuoteStatus(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectQuoteStatus(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionBasicAmount(String op, java.math.BigDecimal val) {
		setConditionBasicAmount(op, val, CONDITION_AND);
	}

	public void setConditionBasicAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectBasicAmount(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val) {
		setConditionTotalAmount(op, val, CONDITION_AND);
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectTotalAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionUpAmount(String op, java.math.BigDecimal val) {
		setConditionUpAmount(op, val, CONDITION_AND);
	}

	public void setConditionUpAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectUpAmount(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionUpPercent(String op, java.math.BigDecimal val) {
		setConditionUpPercent(op, val, CONDITION_AND);
	}

	public void setConditionUpPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectUpPercent(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionPreferentialAmount(String op, java.math.BigDecimal val) {
		setConditionPreferentialAmount(op, val, CONDITION_AND);
	}

	public void setConditionPreferentialAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectPreferentialAmount(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionPerferentialPercent(String op, java.math.BigDecimal val) {
		setConditionPerferentialPercent(op, val, CONDITION_AND);
	}

	public void setConditionPerferentialPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectPerferentialPercent(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionSpecialDiscountAmount(String op, java.math.BigDecimal val) {
		setConditionSpecialDiscountAmount(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDiscountAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectSpecialDiscountAmount(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionSpecialDiscountPercent(String op, java.math.BigDecimal val) {
		setConditionSpecialDiscountPercent(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDiscountPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectSpecialDiscountPercent(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionTaxAmount(String op, java.math.BigDecimal val) {
		setConditionTaxAmount(op, val, CONDITION_AND);
	}

	public void setConditionTaxAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectTaxAmount(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionOtherTaxAmount(String op, java.math.BigDecimal val) {
		setConditionOtherTaxAmount(op, val, CONDITION_AND);
	}

	public void setConditionOtherTaxAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectOtherTaxAmount(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionFinalPercent(String op, java.math.BigDecimal val) {
		setConditionFinalPercent(op, val, CONDITION_AND);
	}

	public void setConditionFinalPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectFinalPercent(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val) {
		setConditionFinalAmount(op, val, CONDITION_AND);
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectFinalAmount(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionTaxFinalAmount(String op, java.math.BigDecimal val) {
		setConditionTaxFinalAmount(op, val, CONDITION_AND);
	}

	public void setConditionTaxFinalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectTaxFinalAmount(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(20, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionProjectQuoteTemplatesParentId(String op, java.lang.Integer val) {
		setConditionProjectQuoteTemplatesParentId(op, val, CONDITION_AND);
	}

	public void setConditionProjectQuoteTemplatesParentId(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectProjectQuoteTemplatesParentId(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[23] = val;
	}


}

