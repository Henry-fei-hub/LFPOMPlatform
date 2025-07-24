package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseNormalReimbursementLinkProject;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class NormalReimbursementLinkProject extends AbstractTable<BaseNormalReimbursementLinkProject>
{

	public NormalReimbursementLinkProject() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "normal_reimbursement_link_projects";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseNormalReimbursementLinkProject.CS_NORMAL_REIMBURSEMENT_LINK_PROJECT_ID;
		__column_names[1] = BaseNormalReimbursementLinkProject.CS_PROJECT_NORMAL_REIMBURSEMENT_ID;
		__column_names[2] = BaseNormalReimbursementLinkProject.CS_PROJECT_ID;
		__column_names[3] = BaseNormalReimbursementLinkProject.CS_CONTRACT_CODE;
		__column_names[4] = BaseNormalReimbursementLinkProject.CS_PLATE_ID;
		__column_names[5] = BaseNormalReimbursementLinkProject.CS_AMOUNT;
		__column_names[6] = BaseNormalReimbursementLinkProject.CS_INPUT_TAX;
		__column_names[7] = BaseNormalReimbursementLinkProject.CS_FINAL_AMOUNT;
		__column_names[8] = BaseNormalReimbursementLinkProject.CS_IS_PERSONAL_FEE;
		__column_names[9] = BaseNormalReimbursementLinkProject.CS_MAIN_ITEM_ID;
		__column_names[10] = BaseNormalReimbursementLinkProject.CS_SUB_ITEM_ID;
		__column_names[11] = BaseNormalReimbursementLinkProject.CS_REMARK;
		__column_names[12] = BaseNormalReimbursementLinkProject.CS_INPUT_TAX_REBATE;
		__column_names[13] = BaseNormalReimbursementLinkProject.CS_HAVE_ELECTRONIC_INVOICE;
		__column_names[14] = BaseNormalReimbursementLinkProject.CS_INVOICE_LINK_KEY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseNormalReimbursementLinkProject b) {
		clear();
		setNormalReimbursementLinkProjectIdClear(b.getNormalReimbursementLinkProjectId());
	}

	public boolean isPrimaryKeyNull() {
		return getNormalReimbursementLinkProjectId() == null;
	}

	@Override
	public BaseNormalReimbursementLinkProject generateBase(){
		BaseNormalReimbursementLinkProject b = new BaseNormalReimbursementLinkProject();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseNormalReimbursementLinkProject b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setNormalReimbursementLinkProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectNormalReimbursementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInputTax(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsPersonalFee(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setMainItemId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubItemId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInputTaxRebate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHaveElectronicInvoice(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceLinkKey(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseNormalReimbursementLinkProject b, Object[] buff){
		int count = 0;
		buff[count++] = b.getNormalReimbursementLinkProjectId();
		buff[count++] = b.getProjectNormalReimbursementId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getAmount();
		buff[count++] = b.getInputTax();
		buff[count++] = b.getFinalAmount();
		buff[count++] = b.getIsPersonalFee();
		buff[count++] = b.getMainItemId();
		buff[count++] = b.getSubItemId();
		buff[count++] = b.getRemark();
		buff[count++] = b.getInputTaxRebate();
		buff[count++] = b.getHaveElectronicInvoice();
		buff[count++] = b.getInvoiceLinkKey();
	}

	@Override
	public void setDataFromBase(BaseNormalReimbursementLinkProject b){
		if(b.getNormalReimbursementLinkProjectId() != null) setNormalReimbursementLinkProjectIdClear(b.getNormalReimbursementLinkProjectId());
		if(b.getProjectNormalReimbursementId() != null) setProjectNormalReimbursementId(b.getProjectNormalReimbursementId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getInputTax() != null) setInputTax(b.getInputTax());
		if(b.getFinalAmount() != null) setFinalAmount(b.getFinalAmount());
		if(b.getIsPersonalFee() != null) setIsPersonalFee(b.getIsPersonalFee());
		if(b.getMainItemId() != null) setMainItemId(b.getMainItemId());
		if(b.getSubItemId() != null) setSubItemId(b.getSubItemId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getInputTaxRebate() != null) setInputTaxRebate(b.getInputTaxRebate());
		if(b.getHaveElectronicInvoice() != null) setHaveElectronicInvoice(b.getHaveElectronicInvoice());
		if(b.getInvoiceLinkKey() != null) setInvoiceLinkKey(b.getInvoiceLinkKey());
	}

	@Override
	public BaseNormalReimbursementLinkProject generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseNormalReimbursementLinkProject b = new BaseNormalReimbursementLinkProject();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseNormalReimbursementLinkProject __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNormalReimbursementLinkProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectNormalReimbursementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTax(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsPersonalFee(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainItemId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubItemId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTaxRebate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHaveElectronicInvoice(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceLinkKey(GenericBase.__getInt(val));
	}

	public void setNormalReimbursementLinkProjectId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getNormalReimbursementLinkProjectId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setNormalReimbursementLinkProjectIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectNormalReimbursementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectNormalReimbursementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setInputTax(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getInputTax() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setFinalAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getFinalAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setIsPersonalFee(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getIsPersonalFee() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setMainItemId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getMainItemId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setSubItemId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getSubItemId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setInputTaxRebate(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getInputTaxRebate() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setHaveElectronicInvoice(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getHaveElectronicInvoice() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setInvoiceLinkKey(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getInvoiceLinkKey() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setConditionNormalReimbursementLinkProjectId(String op, java.lang.Integer val) {
		setConditionNormalReimbursementLinkProjectId(op, val, CONDITION_AND);
	}

	public void setConditionNormalReimbursementLinkProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectNormalReimbursementLinkProjectId(boolean val) {
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

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionInputTax(String op, java.math.BigDecimal val) {
		setConditionInputTax(op, val, CONDITION_AND);
	}

	public void setConditionInputTax(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectInputTax(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val) {
		setConditionFinalAmount(op, val, CONDITION_AND);
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectFinalAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionIsPersonalFee(String op, java.lang.Boolean val) {
		setConditionIsPersonalFee(op, val, CONDITION_AND);
	}

	public void setConditionIsPersonalFee(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIsPersonalFee(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionMainItemId(String op, java.lang.Integer val) {
		setConditionMainItemId(op, val, CONDITION_AND);
	}

	public void setConditionMainItemId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMainItemId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionSubItemId(String op, java.lang.Integer val) {
		setConditionSubItemId(op, val, CONDITION_AND);
	}

	public void setConditionSubItemId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectSubItemId(boolean val) {
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

	public void setConditionInputTaxRebate(String op, java.math.BigDecimal val) {
		setConditionInputTaxRebate(op, val, CONDITION_AND);
	}

	public void setConditionInputTaxRebate(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectInputTaxRebate(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionHaveElectronicInvoice(String op, java.lang.Integer val) {
		setConditionHaveElectronicInvoice(op, val, CONDITION_AND);
	}

	public void setConditionHaveElectronicInvoice(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectHaveElectronicInvoice(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionInvoiceLinkKey(String op, java.lang.Integer val) {
		setConditionInvoiceLinkKey(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceLinkKey(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectInvoiceLinkKey(boolean val) {
		__select_flags[14] = val;
	}


}

