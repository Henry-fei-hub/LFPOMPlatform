package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractCommissionDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractCommissionDetail extends AbstractTable<BaseContractCommissionDetail>
{

	public ContractCommissionDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "contract_commission_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractCommissionDetail.CS_CONTRACT_COMMISSION_DETAIL_ID;
		__column_names[1] = BaseContractCommissionDetail.CS_CONTRACT_CODE;
		__column_names[2] = BaseContractCommissionDetail.CS_CONTRACT_ID;
		__column_names[3] = BaseContractCommissionDetail.CS_PLATE_ID;
		__column_names[4] = BaseContractCommissionDetail.CS_YEAR;
		__column_names[5] = BaseContractCommissionDetail.CS_MONTH;
		__column_names[6] = BaseContractCommissionDetail.CS_RATE;
		__column_names[7] = BaseContractCommissionDetail.CS_CONTRACT_NAME;
		__column_names[8] = BaseContractCommissionDetail.CS_BILLING_RATIO;
		__column_names[9] = BaseContractCommissionDetail.CS_AMOUNT;
		__column_names[10] = BaseContractCommissionDetail.CS_IS_ORIGINAL;
		__column_names[11] = BaseContractCommissionDetail.CS_IS_SUB_PROJECT;
		__column_names[12] = BaseContractCommissionDetail.CS_TOTAL_RATE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
	}

	public void setPrimaryKeyFromBase(BaseContractCommissionDetail b) {
		clear();
		setContractCommissionDetailIdClear(b.getContractCommissionDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractCommissionDetailId() == null;
	}

	@Override
	public BaseContractCommissionDetail generateBase(){
		BaseContractCommissionDetail b = new BaseContractCommissionDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractCommissionDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractCommissionDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBillingRatio(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsOriginal(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsSubProject(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setTotalRate(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractCommissionDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractCommissionDetailId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getContractId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getRate();
		buff[count++] = b.getContractName();
		buff[count++] = b.getBillingRatio();
		buff[count++] = b.getAmount();
		buff[count++] = b.getIsOriginal();
		buff[count++] = b.getIsSubProject();
		buff[count++] = b.getTotalRate();
	}

	@Override
	public void setDataFromBase(BaseContractCommissionDetail b){
		if(b.getContractCommissionDetailId() != null) setContractCommissionDetailIdClear(b.getContractCommissionDetailId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getRate() != null) setRate(b.getRate());
		if(b.getContractName() != null) setContractName(b.getContractName());
		if(b.getBillingRatio() != null) setBillingRatio(b.getBillingRatio());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getIsOriginal() != null) setIsOriginal(b.getIsOriginal());
		if(b.getIsSubProject() != null) setIsSubProject(b.getIsSubProject());
		if(b.getTotalRate() != null) setTotalRate(b.getTotalRate());
	}

	@Override
	public BaseContractCommissionDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractCommissionDetail b = new BaseContractCommissionDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractCommissionDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCommissionDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBillingRatio(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsOriginal(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSubProject(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalRate(GenericBase.__getDecimal(val));
	}

	public void setContractCommissionDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractCommissionDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractCommissionDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setRate(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getRate() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setContractName(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getContractName() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setBillingRatio(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getBillingRatio() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setIsOriginal(java.lang.Boolean val) {
		setCurrentData(10, val);
	}

	public java.lang.Boolean getIsOriginal() {
		return GenericBase.__getBoolean(__current_data[10]);
	}

	public void setIsSubProject(java.lang.Boolean val) {
		setCurrentData(11, val);
	}

	public java.lang.Boolean getIsSubProject() {
		return GenericBase.__getBoolean(__current_data[11]);
	}

	public void setTotalRate(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getTotalRate() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setConditionContractCommissionDetailId(String op, java.lang.Integer val) {
		setConditionContractCommissionDetailId(op, val, CONDITION_AND);
	}

	public void setConditionContractCommissionDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractCommissionDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRate(String op, java.math.BigDecimal val) {
		setConditionRate(op, val, CONDITION_AND);
	}

	public void setConditionRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionContractName(String op, java.lang.String val) {
		setConditionContractName(op, val, CONDITION_AND);
	}

	public void setConditionContractName(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectContractName(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionBillingRatio(String op, java.lang.String val) {
		setConditionBillingRatio(op, val, CONDITION_AND);
	}

	public void setConditionBillingRatio(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectBillingRatio(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionIsOriginal(String op, java.lang.Boolean val) {
		setConditionIsOriginal(op, val, CONDITION_AND);
	}

	public void setConditionIsOriginal(String op, java.lang.Boolean val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectIsOriginal(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionIsSubProject(String op, java.lang.Boolean val) {
		setConditionIsSubProject(op, val, CONDITION_AND);
	}

	public void setConditionIsSubProject(String op, java.lang.Boolean val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectIsSubProject(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionTotalRate(String op, java.math.BigDecimal val) {
		setConditionTotalRate(op, val, CONDITION_AND);
	}

	public void setConditionTotalRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectTotalRate(boolean val) {
		__select_flags[12] = val;
	}


}

