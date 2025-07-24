package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseProjectNormalReimbursement;


public class ProjectNormalReimbursement extends AbstractTable<BaseProjectNormalReimbursement>
{

	public ProjectNormalReimbursement() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 40;

		initTables();

		__tableName            = "project_normal_reimbursements";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectNormalReimbursement.CS_PROJECT_NORMAL_REIMBURSEMENT_ID;
		__column_names[1] = BaseProjectNormalReimbursement.CS_CODE;
		__column_names[2] = BaseProjectNormalReimbursement.CS_PROCESS_INSTANCE_ID;
		__column_names[3] = BaseProjectNormalReimbursement.CS_APPLY_EMPLOYEE_ID;
		__column_names[4] = BaseProjectNormalReimbursement.CS_EMPLOYEE_ID;
		__column_names[5] = BaseProjectNormalReimbursement.CS_DEPARTMENT_ID;
		__column_names[6] = BaseProjectNormalReimbursement.CS_REIMBURSEMENT_NAME;
		__column_names[7] = BaseProjectNormalReimbursement.CS_REIMBURSEMENT_TIME;
		__column_names[8] = BaseProjectNormalReimbursement.CS_STATUS;
		__column_names[9] = BaseProjectNormalReimbursement.CS_AMOUNT;
		__column_names[10] = BaseProjectNormalReimbursement.CS_APPLY_TIME;
		__column_names[11] = BaseProjectNormalReimbursement.CS_COMPLETE_TIME;
		__column_names[12] = BaseProjectNormalReimbursement.CS_REMARK;
		__column_names[13] = BaseProjectNormalReimbursement.CS_STRIKE_A_BALANCE;
		__column_names[14] = BaseProjectNormalReimbursement.CS_ATTACHMENT;
		__column_names[15] = BaseProjectNormalReimbursement.CS_ATTACHMENT_NUMBER;
		__column_names[16] = BaseProjectNormalReimbursement.CS_COMPANY_ID;
		__column_names[17] = BaseProjectNormalReimbursement.CS_IS_PROJECT;
		__column_names[18] = BaseProjectNormalReimbursement.CS_DELETE_FLAG;
		__column_names[19] = BaseProjectNormalReimbursement.CS_RECEIVE_UNIT_MANAGE_ID;
		__column_names[20] = BaseProjectNormalReimbursement.CS_CURRENCY;
		__column_names[21] = BaseProjectNormalReimbursement.CS_IS_COMPLETED;
		__column_names[22] = BaseProjectNormalReimbursement.CS_BE_PACKED;
		__column_names[23] = BaseProjectNormalReimbursement.CS_VOUCHER_NO;
		__column_names[24] = BaseProjectNormalReimbursement.CS_POSTING_DATE;
		__column_names[25] = BaseProjectNormalReimbursement.CS_FEE_TYPE;
		__column_names[26] = BaseProjectNormalReimbursement.CS_EXCHANGE_RATE;
		__column_names[27] = BaseProjectNormalReimbursement.CS_PAYMENT_SEQUENCE_ID;
		__column_names[28] = BaseProjectNormalReimbursement.CS_BUDGET_MANAGEMENT_ID;
		__column_names[29] = BaseProjectNormalReimbursement.CS_BUDGET_ATTACHMENT_ID;
		__column_names[30] = BaseProjectNormalReimbursement.CS_WHITE_STRIP;
		__column_names[31] = BaseProjectNormalReimbursement.CS_ATTACHMENT_ID;
		__column_names[32] = BaseProjectNormalReimbursement.CS_ATTACHMENT_NAME;
		__column_names[33] = BaseProjectNormalReimbursement.CS_RELATED_TO_CONTRACT;
		__column_names[34] = BaseProjectNormalReimbursement.CS_CONTRACT_AMOUNT;
		__column_names[35] = BaseProjectNormalReimbursement.CS_RECEIVE_UNIT_ID;
		__column_names[36] = BaseProjectNormalReimbursement.CS_PURCHASER_DEPARTMENT;
		__column_names[37] = BaseProjectNormalReimbursement.CS_PURCHASER;
		__column_names[38] = BaseProjectNormalReimbursement.CS_PURCHASING_CATEGORY;
		__column_names[39] = BaseProjectNormalReimbursement.CS_REIMBURSEMENT_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectNormalReimbursement b) {
		clear();
		setProjectNormalReimbursementIdClear(b.getProjectNormalReimbursementId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectNormalReimbursementId() == null;
	}

	@Override
	public BaseProjectNormalReimbursement generateBase(){
		BaseProjectNormalReimbursement b = new BaseProjectNormalReimbursement();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectNormalReimbursement b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectNormalReimbursementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReimbursementName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReimbursementTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStrikeABalance(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setAttachment(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsProject(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCurrency(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setBePacked(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setVoucherNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPostingDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setFeeType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPaymentSequenceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWhiteStrip(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRelatedToContract(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnitId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchaserDepartment(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchaser(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchasingCategory(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReimbursementType(GenericBase.__getInt(val));
	}

	public void setDataFromCSV(String csvLine){
		setDataFromCSV(csvLine, null);
	}

	public void setDataFromCSV(String csvLine, String names){
		int count = 0; String val;
		Integer num = null;
		setInputNames(names);
		String[] values = JsonParser.csvLine(csvLine, ',');
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectNormalReimbursementId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProcessInstanceId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setApplyEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDepartmentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReimbursementName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReimbursementTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setApplyTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCompleteTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStrikeABalance(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAttachment(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAttachmentNumber(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCompanyId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsProject(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDeleteFlag(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReceiveUnitManageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCurrency(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsCompleted(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBePacked(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setVoucherNo(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPostingDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFeeType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setExchangeRate(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPaymentSequenceId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBudgetManagementId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBudgetAttachmentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setWhiteStrip(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAttachmentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAttachmentName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRelatedToContract(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReceiveUnitId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPurchaserDepartment(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPurchaser(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPurchasingCategory(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setReimbursementType(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseProjectNormalReimbursement b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectNormalReimbursementId();
		buff[count++] = b.getCode();
		buff[count++] = b.getProcessInstanceId();
		buff[count++] = b.getApplyEmployeeId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getReimbursementName();
		buff[count++] = generateTimestampFromDate(b.getReimbursementTime());
		buff[count++] = b.getStatus();
		buff[count++] = b.getAmount();
		buff[count++] = generateTimestampFromDate(b.getApplyTime());
		buff[count++] = generateTimestampFromDate(b.getCompleteTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getStrikeABalance();
		buff[count++] = b.getAttachment();
		buff[count++] = b.getAttachmentNumber();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getIsProject();
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getReceiveUnitManageId();
		buff[count++] = b.getCurrency();
		buff[count++] = b.getIsCompleted();
		buff[count++] = b.getBePacked();
		buff[count++] = b.getVoucherNo();
		buff[count++] = generateTimestampFromDate(b.getPostingDate());
		buff[count++] = b.getFeeType();
		buff[count++] = b.getExchangeRate();
		buff[count++] = b.getPaymentSequenceId();
		buff[count++] = b.getBudgetManagementId();
		buff[count++] = b.getBudgetAttachmentId();
		buff[count++] = b.getWhiteStrip();
		buff[count++] = b.getAttachmentId();
		buff[count++] = b.getAttachmentName();
		buff[count++] = b.getRelatedToContract();
		buff[count++] = b.getContractAmount();
		buff[count++] = b.getReceiveUnitId();
		buff[count++] = b.getPurchaserDepartment();
		buff[count++] = b.getPurchaser();
		buff[count++] = b.getPurchasingCategory();
		buff[count++] = b.getReimbursementType();
	}

	@Override
	public void setDataFromBase(BaseProjectNormalReimbursement b){
		if(b.getProjectNormalReimbursementId() != null) setProjectNormalReimbursementIdClear(b.getProjectNormalReimbursementId());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getProcessInstanceId() != null) setProcessInstanceId(b.getProcessInstanceId());
		if(b.getApplyEmployeeId() != null) setApplyEmployeeId(b.getApplyEmployeeId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getReimbursementName() != null) setReimbursementName(b.getReimbursementName());
		if(b.getReimbursementTime() != null) setReimbursementTime(b.getReimbursementTime());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getApplyTime() != null) setApplyTime(b.getApplyTime());
		if(b.getCompleteTime() != null) setCompleteTime(b.getCompleteTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getStrikeABalance() != null) setStrikeABalance(b.getStrikeABalance());
		if(b.getAttachment() != null) setAttachment(b.getAttachment());
		if(b.getAttachmentNumber() != null) setAttachmentNumber(b.getAttachmentNumber());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getIsProject() != null) setIsProject(b.getIsProject());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getReceiveUnitManageId() != null) setReceiveUnitManageId(b.getReceiveUnitManageId());
		if(b.getCurrency() != null) setCurrency(b.getCurrency());
		if(b.getIsCompleted() != null) setIsCompleted(b.getIsCompleted());
		if(b.getBePacked() != null) setBePacked(b.getBePacked());
		if(b.getVoucherNo() != null) setVoucherNo(b.getVoucherNo());
		if(b.getPostingDate() != null) setPostingDate(b.getPostingDate());
		if(b.getFeeType() != null) setFeeType(b.getFeeType());
		if(b.getExchangeRate() != null) setExchangeRate(b.getExchangeRate());
		if(b.getPaymentSequenceId() != null) setPaymentSequenceId(b.getPaymentSequenceId());
		if(b.getBudgetManagementId() != null) setBudgetManagementId(b.getBudgetManagementId());
		if(b.getBudgetAttachmentId() != null) setBudgetAttachmentId(b.getBudgetAttachmentId());
		if(b.getWhiteStrip() != null) setWhiteStrip(b.getWhiteStrip());
		if(b.getAttachmentId() != null) setAttachmentId(b.getAttachmentId());
		if(b.getAttachmentName() != null) setAttachmentName(b.getAttachmentName());
		if(b.getRelatedToContract() != null) setRelatedToContract(b.getRelatedToContract());
		if(b.getContractAmount() != null) setContractAmount(b.getContractAmount());
		if(b.getReceiveUnitId() != null) setReceiveUnitId(b.getReceiveUnitId());
		if(b.getPurchaserDepartment() != null) setPurchaserDepartment(b.getPurchaserDepartment());
		if(b.getPurchaser() != null) setPurchaser(b.getPurchaser());
		if(b.getPurchasingCategory() != null) setPurchasingCategory(b.getPurchasingCategory());
		if(b.getReimbursementType() != null) setReimbursementType(b.getReimbursementType());
	}

	@Override
	public BaseProjectNormalReimbursement generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectNormalReimbursement b = new BaseProjectNormalReimbursement();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectNormalReimbursement __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectNormalReimbursementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStrikeABalance(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachment(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsProject(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrency(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBePacked(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVoucherNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPostingDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFeeType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentSequenceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWhiteStrip(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelatedToContract(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnitId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaserDepartment(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaser(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchasingCategory(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementType(GenericBase.__getInt(val));
	}

	public void setProjectNormalReimbursementId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectNormalReimbursementId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectNormalReimbursementIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProcessInstanceId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProcessInstanceId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setApplyEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getApplyEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setReimbursementName(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getReimbursementName() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setReimbursementTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getReimbursementTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setApplyTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getApplyTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setCompleteTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getCompleteTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setStrikeABalance(java.lang.Boolean val) {
		setCurrentData(13, val);
	}

	public java.lang.Boolean getStrikeABalance() {
		return GenericBase.__getBoolean(__current_data[13]);
	}

	public void setAttachment(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getAttachment() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setAttachmentNumber(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getAttachmentNumber() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setIsProject(java.lang.Boolean val) {
		setCurrentData(17, val);
	}

	public java.lang.Boolean getIsProject() {
		return GenericBase.__getBoolean(__current_data[17]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setReceiveUnitManageId(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setCurrency(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getCurrency() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setIsCompleted(java.lang.Boolean val) {
		setCurrentData(21, val);
	}

	public java.lang.Boolean getIsCompleted() {
		return GenericBase.__getBoolean(__current_data[21]);
	}

	public void setBePacked(java.lang.Boolean val) {
		setCurrentData(22, val);
	}

	public java.lang.Boolean getBePacked() {
		return GenericBase.__getBoolean(__current_data[22]);
	}

	public void setVoucherNo(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getVoucherNo() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setPostingDate(java.util.Date val) {
		setCurrentData(24, generateTimestampFromDate(val));
	}

	public java.util.Date getPostingDate() {
		return GenericBase.__getDateFromSQL(__current_data[24]);
	}

	public void setFeeType(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getFeeType() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setExchangeRate(java.math.BigDecimal val) {
		setCurrentData(26, val);
	}

	public java.math.BigDecimal getExchangeRate() {
		return GenericBase.__getDecimal(__current_data[26]);
	}

	public void setPaymentSequenceId(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getPaymentSequenceId() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setBudgetManagementId(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getBudgetManagementId() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setBudgetAttachmentId(java.lang.Integer val) {
		setCurrentData(29, val);
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return GenericBase.__getInt(__current_data[29]);
	}

	public void setWhiteStrip(java.math.BigDecimal val) {
		setCurrentData(30, val);
	}

	public java.math.BigDecimal getWhiteStrip() {
		return GenericBase.__getDecimal(__current_data[30]);
	}

	public void setAttachmentId(java.lang.Integer val) {
		setCurrentData(31, val);
	}

	public java.lang.Integer getAttachmentId() {
		return GenericBase.__getInt(__current_data[31]);
	}

	public void setAttachmentName(java.lang.String val) {
		setCurrentData(32, val);
	}

	public java.lang.String getAttachmentName() {
		return GenericBase.__getString(__current_data[32]);
	}

	public void setRelatedToContract(java.lang.Boolean val) {
		setCurrentData(33, val);
	}

	public java.lang.Boolean getRelatedToContract() {
		return GenericBase.__getBoolean(__current_data[33]);
	}

	public void setContractAmount(java.math.BigDecimal val) {
		setCurrentData(34, val);
	}

	public java.math.BigDecimal getContractAmount() {
		return GenericBase.__getDecimal(__current_data[34]);
	}

	public void setReceiveUnitId(java.lang.Integer val) {
		setCurrentData(35, val);
	}

	public java.lang.Integer getReceiveUnitId() {
		return GenericBase.__getInt(__current_data[35]);
	}

	public void setPurchaserDepartment(java.lang.Integer val) {
		setCurrentData(36, val);
	}

	public java.lang.Integer getPurchaserDepartment() {
		return GenericBase.__getInt(__current_data[36]);
	}

	public void setPurchaser(java.lang.Integer val) {
		setCurrentData(37, val);
	}

	public java.lang.Integer getPurchaser() {
		return GenericBase.__getInt(__current_data[37]);
	}

	public void setPurchasingCategory(java.lang.String val) {
		setCurrentData(38, val);
	}

	public java.lang.String getPurchasingCategory() {
		return GenericBase.__getString(__current_data[38]);
	}

	public void setReimbursementType(java.lang.Integer val) {
		setCurrentData(39, val);
	}

	public java.lang.Integer getReimbursementType() {
		return GenericBase.__getInt(__current_data[39]);
	}

	public void setConditionProjectNormalReimbursementId(String op, java.lang.Integer val) {
		setConditionProjectNormalReimbursementId(op, val, CONDITION_AND);
	}

	public void setConditionProjectNormalReimbursementId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectNormalReimbursementId(boolean val) {
		__select_flags[0] = val;
	}

	public void setProjectNormalReimbursementIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setCodeExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val) {
		setConditionProcessInstanceId(op, val, CONDITION_AND);
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProcessInstanceId(boolean val) {
		__select_flags[2] = val;
	}

	public void setProcessInstanceIdExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionApplyEmployeeId(String op, java.lang.Integer val) {
		setConditionApplyEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionApplyEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectApplyEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setApplyEmployeeIdExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[4] = val;
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

	public void setDepartmentIdExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionReimbursementName(String op, java.lang.String val) {
		setConditionReimbursementName(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementName(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectReimbursementName(boolean val) {
		__select_flags[6] = val;
	}

	public void setReimbursementNameExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionReimbursementTime(String op, java.util.Date val) {
		setConditionReimbursementTime(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectReimbursementTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setReimbursementTimeExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[8] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[8] = val;
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

	public void setAmountExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionApplyTime(String op, java.util.Date val) {
		setConditionApplyTime(op, val, CONDITION_AND);
	}

	public void setConditionApplyTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectApplyTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setApplyTimeExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionCompleteTime(String op, java.util.Date val) {
		setConditionCompleteTime(op, val, CONDITION_AND);
	}

	public void setConditionCompleteTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCompleteTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setCompleteTimeExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[12] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionStrikeABalance(String op, java.lang.Boolean val) {
		setConditionStrikeABalance(op, val, CONDITION_AND);
	}

	public void setConditionStrikeABalance(String op, java.lang.Boolean val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectStrikeABalance(boolean val) {
		__select_flags[13] = val;
	}

	public void setStrikeABalanceExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionAttachment(String op, java.lang.String val) {
		setConditionAttachment(op, val, CONDITION_AND);
	}

	public void setConditionAttachment(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectAttachment(boolean val) {
		__select_flags[14] = val;
	}

	public void setAttachmentExpression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionAttachmentNumber(String op, java.lang.Integer val) {
		setConditionAttachmentNumber(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentNumber(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectAttachmentNumber(boolean val) {
		__select_flags[15] = val;
	}

	public void setAttachmentNumberExpression(String val) {
		__dataExpressions[15] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[16] = val;
	}

	public void setCompanyIdExpression(String val) {
		__dataExpressions[16] = val;
	}

	public void setConditionIsProject(String op, java.lang.Boolean val) {
		setConditionIsProject(op, val, CONDITION_AND);
	}

	public void setConditionIsProject(String op, java.lang.Boolean val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectIsProject(boolean val) {
		__select_flags[17] = val;
	}

	public void setIsProjectExpression(String val) {
		__dataExpressions[17] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[18] = val;
	}

	public void setDeleteFlagExpression(String val) {
		__dataExpressions[18] = val;
	}

	public void setConditionReceiveUnitManageId(String op, java.lang.Integer val) {
		setConditionReceiveUnitManageId(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnitManageId(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectReceiveUnitManageId(boolean val) {
		__select_flags[19] = val;
	}

	public void setReceiveUnitManageIdExpression(String val) {
		__dataExpressions[19] = val;
	}

	public void setConditionCurrency(String op, java.lang.Integer val) {
		setConditionCurrency(op, val, CONDITION_AND);
	}

	public void setConditionCurrency(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectCurrency(boolean val) {
		__select_flags[20] = val;
	}

	public void setCurrencyExpression(String val) {
		__dataExpressions[20] = val;
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val) {
		setConditionIsCompleted(op, val, CONDITION_AND);
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectIsCompleted(boolean val) {
		__select_flags[21] = val;
	}

	public void setIsCompletedExpression(String val) {
		__dataExpressions[21] = val;
	}

	public void setConditionBePacked(String op, java.lang.Boolean val) {
		setConditionBePacked(op, val, CONDITION_AND);
	}

	public void setConditionBePacked(String op, java.lang.Boolean val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectBePacked(boolean val) {
		__select_flags[22] = val;
	}

	public void setBePackedExpression(String val) {
		__dataExpressions[22] = val;
	}

	public void setConditionVoucherNo(String op, java.lang.String val) {
		setConditionVoucherNo(op, val, CONDITION_AND);
	}

	public void setConditionVoucherNo(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectVoucherNo(boolean val) {
		__select_flags[23] = val;
	}

	public void setVoucherNoExpression(String val) {
		__dataExpressions[23] = val;
	}

	public void setConditionPostingDate(String op, java.util.Date val) {
		setConditionPostingDate(op, val, CONDITION_AND);
	}

	public void setConditionPostingDate(String op, java.util.Date val, String relation) {
		addCondition(24, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPostingDate(boolean val) {
		__select_flags[24] = val;
	}

	public void setPostingDateExpression(String val) {
		__dataExpressions[24] = val;
	}

	public void setConditionFeeType(String op, java.lang.Integer val) {
		setConditionFeeType(op, val, CONDITION_AND);
	}

	public void setConditionFeeType(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectFeeType(boolean val) {
		__select_flags[25] = val;
	}

	public void setFeeTypeExpression(String val) {
		__dataExpressions[25] = val;
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val) {
		setConditionExchangeRate(op, val, CONDITION_AND);
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectExchangeRate(boolean val) {
		__select_flags[26] = val;
	}

	public void setExchangeRateExpression(String val) {
		__dataExpressions[26] = val;
	}

	public void setConditionPaymentSequenceId(String op, java.lang.Integer val) {
		setConditionPaymentSequenceId(op, val, CONDITION_AND);
	}

	public void setConditionPaymentSequenceId(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectPaymentSequenceId(boolean val) {
		__select_flags[27] = val;
	}

	public void setPaymentSequenceIdExpression(String val) {
		__dataExpressions[27] = val;
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val) {
		setConditionBudgetManagementId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectBudgetManagementId(boolean val) {
		__select_flags[28] = val;
	}

	public void setBudgetManagementIdExpression(String val) {
		__dataExpressions[28] = val;
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val) {
		setConditionBudgetAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectBudgetAttachmentId(boolean val) {
		__select_flags[29] = val;
	}

	public void setBudgetAttachmentIdExpression(String val) {
		__dataExpressions[29] = val;
	}

	public void setConditionWhiteStrip(String op, java.math.BigDecimal val) {
		setConditionWhiteStrip(op, val, CONDITION_AND);
	}

	public void setConditionWhiteStrip(String op, java.math.BigDecimal val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectWhiteStrip(boolean val) {
		__select_flags[30] = val;
	}

	public void setWhiteStripExpression(String val) {
		__dataExpressions[30] = val;
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val) {
		setConditionAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectAttachmentId(boolean val) {
		__select_flags[31] = val;
	}

	public void setAttachmentIdExpression(String val) {
		__dataExpressions[31] = val;
	}

	public void setConditionAttachmentName(String op, java.lang.String val) {
		setConditionAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectAttachmentName(boolean val) {
		__select_flags[32] = val;
	}

	public void setAttachmentNameExpression(String val) {
		__dataExpressions[32] = val;
	}

	public void setConditionRelatedToContract(String op, java.lang.Boolean val) {
		setConditionRelatedToContract(op, val, CONDITION_AND);
	}

	public void setConditionRelatedToContract(String op, java.lang.Boolean val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectRelatedToContract(boolean val) {
		__select_flags[33] = val;
	}

	public void setRelatedToContractExpression(String val) {
		__dataExpressions[33] = val;
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val) {
		setConditionContractAmount(op, val, CONDITION_AND);
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectContractAmount(boolean val) {
		__select_flags[34] = val;
	}

	public void setContractAmountExpression(String val) {
		__dataExpressions[34] = val;
	}

	public void setConditionReceiveUnitId(String op, java.lang.Integer val) {
		setConditionReceiveUnitId(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnitId(String op, java.lang.Integer val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectReceiveUnitId(boolean val) {
		__select_flags[35] = val;
	}

	public void setReceiveUnitIdExpression(String val) {
		__dataExpressions[35] = val;
	}

	public void setConditionPurchaserDepartment(String op, java.lang.Integer val) {
		setConditionPurchaserDepartment(op, val, CONDITION_AND);
	}

	public void setConditionPurchaserDepartment(String op, java.lang.Integer val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectPurchaserDepartment(boolean val) {
		__select_flags[36] = val;
	}

	public void setPurchaserDepartmentExpression(String val) {
		__dataExpressions[36] = val;
	}

	public void setConditionPurchaser(String op, java.lang.Integer val) {
		setConditionPurchaser(op, val, CONDITION_AND);
	}

	public void setConditionPurchaser(String op, java.lang.Integer val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectPurchaser(boolean val) {
		__select_flags[37] = val;
	}

	public void setPurchaserExpression(String val) {
		__dataExpressions[37] = val;
	}

	public void setConditionPurchasingCategory(String op, java.lang.String val) {
		setConditionPurchasingCategory(op, val, CONDITION_AND);
	}

	public void setConditionPurchasingCategory(String op, java.lang.String val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectPurchasingCategory(boolean val) {
		__select_flags[38] = val;
	}

	public void setPurchasingCategoryExpression(String val) {
		__dataExpressions[38] = val;
	}

	public void setConditionReimbursementType(String op, java.lang.Integer val) {
		setConditionReimbursementType(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementType(String op, java.lang.Integer val, String relation) {
		addCondition(39, op, relation, val);
	}

	public void setSelectReimbursementType(boolean val) {
		__select_flags[39] = val;
	}

	public void setReimbursementTypeExpression(String val) {
		__dataExpressions[39] = val;
	}


}

