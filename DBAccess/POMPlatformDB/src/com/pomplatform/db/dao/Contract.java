package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseContract;


public class Contract extends AbstractTable<BaseContract>
{

	public Contract() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 57;

		initTables();

		__tableName            = "contracts";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContract.CS_CONTRACT_ID;
		__column_names[1] = BaseContract.CS_CONTRACT_CODE;
		__column_names[2] = BaseContract.CS_CONTRACT_NAME;
		__column_names[3] = BaseContract.CS_CUSTOMER_NAME;
		__column_names[4] = BaseContract.CS_START_DATE;
		__column_names[5] = BaseContract.CS_END_DATE;
		__column_names[6] = BaseContract.CS_STATUS;
		__column_names[7] = BaseContract.CS_PROJECT_CODE;
		__column_names[8] = BaseContract.CS_CONTRACT_TYPE;
		__column_names[9] = BaseContract.CS_PROJECT_LEVEL;
		__column_names[10] = BaseContract.CS_TOTAL_PROJECT_TIME;
		__column_names[11] = BaseContract.CS_SIGNING_MONEY_SUM;
		__column_names[12] = BaseContract.CS_DESIGN_AREAS;
		__column_names[13] = BaseContract.CS_CONTRACT_PRICE;
		__column_names[14] = BaseContract.CS_PROJECT_ADDRESS;
		__column_names[15] = BaseContract.CS_CONTRACT_FOLLOWER;
		__column_names[16] = BaseContract.CS_REMARK;
		__column_names[17] = BaseContract.CS_CONTRACT_DATE;
		__column_names[18] = BaseContract.CS_SIGNING_COMPANY_NAME;
		__column_names[19] = BaseContract.CS_CREATE_TIME;
		__column_names[20] = BaseContract.CS_UPDATE_TIME;
		__column_names[21] = BaseContract.CS_BUSINESS_TYPE;
		__column_names[22] = BaseContract.CS_FLOW_STATUS;
		__column_names[23] = BaseContract.CS_SERIAL_NUMBER;
		__column_names[24] = BaseContract.CS_PROJECT_TYPE;
		__column_names[25] = BaseContract.CS_COVERED_AREA;
		__column_names[26] = BaseContract.CS_PROFESSIONAL_COOPERATION;
		__column_names[27] = BaseContract.CS_PROVINCE;
		__column_names[28] = BaseContract.CS_CITY;
		__column_names[29] = BaseContract.CS_DETAIL_ADDRESS;
		__column_names[30] = BaseContract.CS_CUSTOMER_ADDRESS;
		__column_names[31] = BaseContract.CS_SERVICE_SUGGEST_BOOK;
		__column_names[32] = BaseContract.CS_PROJECT_APPROVAL_TIME;
		__column_names[33] = BaseContract.CS_ORDER_NO;
		__column_names[34] = BaseContract.CS_PARENT_ID;
		__column_names[35] = BaseContract.CS_INFO_CODE;
		__column_names[36] = BaseContract.CS_CONTRACT_STATUS;
		__column_names[37] = BaseContract.CS_CLIENT_CONTRACT_ID;
		__column_names[38] = BaseContract.CS_IS_FINISH;
		__column_names[39] = BaseContract.CS_IS_SYSTEM_ADD;
		__column_names[40] = BaseContract.CS_OPERATOR;
		__column_names[41] = BaseContract.CS_ATTACHMENT_REMARK;
		__column_names[42] = BaseContract.CS_FINANCIAL_CONTRACT_CODE;
		__column_names[43] = BaseContract.CS_CONTRACT_AREA;
		__column_names[44] = BaseContract.CS_CUSTOMER_ID;
		__column_names[45] = BaseContract.CS_CONTRACT_INFO_AUDITED;
		__column_names[46] = BaseContract.CS_CONTRACT_SIGNING_STATUS;
		__column_names[47] = BaseContract.CS_SENDING_DATE;
		__column_names[48] = BaseContract.CS_DEPARTMENT_ID;
		__column_names[49] = BaseContract.CS_RELEVANT_EMPLOYEES;
		__column_names[50] = BaseContract.CS_RELEVANT_EMPLOYEES_NAME;
		__column_names[51] = BaseContract.CS_SERVICE_SUGGEST_BOOK_ID;
		__column_names[52] = BaseContract.CS_CONTRACT_YEAR;
		__column_names[53] = BaseContract.CS_COPY_INCOME_LEDGER;
		__column_names[54] = BaseContract.CS_INCOME_LEDGER_NUMBER;
		__column_names[55] = BaseContract.CS_FILE_ID;
		__column_names[56] = BaseContract.CS_FILE_URL;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContract b) {
		clear();
		setContractIdClear(b.getContractId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractId() == null;
	}

	@Override
	public BaseContract generateBase(){
		BaseContract b = new BaseContract();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContract b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCustomerName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalProjectTime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDesignAreas(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractFollower(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSigningCompanyName(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFlowStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSerialNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCoveredArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProfessionalCooperation(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProvince(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCity(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDetailAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCustomerAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setServiceSuggestBook(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOrderNo(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setClientContractId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsFinish(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsSystemAdd(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFinancialContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractArea(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCustomerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractInfoAudited(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setContractSigningStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSendingDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRelevantEmployees(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRelevantEmployeesName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setServiceSuggestBookId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCopyIncomeLedger(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIncomeLedgerNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileUrl(GenericBase.__getString(val));
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
			if(val != null && !val.isEmpty()) setContractId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCustomerName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStartDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEndDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectLevel(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTotalProjectTime(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSigningMoneySum(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignAreas(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractPrice(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectAddress(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractFollower(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSigningCompanyName(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCreateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setUpdateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessType(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFlowStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSerialNumber(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectType(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCoveredArea(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProfessionalCooperation(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProvince(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCity(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDetailAddress(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCustomerAddress(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setServiceSuggestBook(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectApprovalTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOrderNo(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setParentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setInfoCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setClientContractId(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsFinish(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsSystemAdd(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperator(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAttachmentRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFinancialContractCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractArea(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCustomerId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractInfoAudited(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractSigningStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSendingDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDepartmentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRelevantEmployees(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRelevantEmployeesName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setServiceSuggestBookId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractYear(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCopyIncomeLedger(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIncomeLedgerNumber(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileUrl(GenericBase.__getString(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseContract b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getContractName();
		buff[count++] = b.getCustomerName();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getStatus();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getContractType();
		buff[count++] = b.getProjectLevel();
		buff[count++] = b.getTotalProjectTime();
		buff[count++] = b.getSigningMoneySum();
		buff[count++] = b.getDesignAreas();
		buff[count++] = b.getContractPrice();
		buff[count++] = b.getProjectAddress();
		buff[count++] = b.getContractFollower();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getContractDate());
		buff[count++] = b.getSigningCompanyName();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getFlowStatus();
		buff[count++] = b.getSerialNumber();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getCoveredArea();
		buff[count++] = b.getProfessionalCooperation();
		buff[count++] = b.getProvince();
		buff[count++] = b.getCity();
		buff[count++] = b.getDetailAddress();
		buff[count++] = b.getCustomerAddress();
		buff[count++] = b.getServiceSuggestBook();
		buff[count++] = generateTimestampFromDate(b.getProjectApprovalTime());
		buff[count++] = b.getOrderNo();
		buff[count++] = b.getParentId();
		buff[count++] = b.getInfoCode();
		buff[count++] = b.getContractStatus();
		buff[count++] = b.getClientContractId();
		buff[count++] = b.getIsFinish();
		buff[count++] = b.getIsSystemAdd();
		buff[count++] = b.getOperator();
		buff[count++] = b.getAttachmentRemark();
		buff[count++] = b.getFinancialContractCode();
		buff[count++] = b.getContractArea();
		buff[count++] = b.getCustomerId();
		buff[count++] = b.getContractInfoAudited();
		buff[count++] = b.getContractSigningStatus();
		buff[count++] = generateTimestampFromDate(b.getSendingDate());
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getRelevantEmployees();
		buff[count++] = b.getRelevantEmployeesName();
		buff[count++] = b.getServiceSuggestBookId();
		buff[count++] = b.getContractYear();
		buff[count++] = b.getCopyIncomeLedger();
		buff[count++] = b.getIncomeLedgerNumber();
		buff[count++] = b.getFileId();
		buff[count++] = b.getFileUrl();
	}

	@Override
	public void setDataFromBase(BaseContract b){
		if(b.getContractId() != null) setContractIdClear(b.getContractId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getContractName() != null) setContractName(b.getContractName());
		if(b.getCustomerName() != null) setCustomerName(b.getCustomerName());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getContractType() != null) setContractType(b.getContractType());
		if(b.getProjectLevel() != null) setProjectLevel(b.getProjectLevel());
		if(b.getTotalProjectTime() != null) setTotalProjectTime(b.getTotalProjectTime());
		if(b.getSigningMoneySum() != null) setSigningMoneySum(b.getSigningMoneySum());
		if(b.getDesignAreas() != null) setDesignAreas(b.getDesignAreas());
		if(b.getContractPrice() != null) setContractPrice(b.getContractPrice());
		if(b.getProjectAddress() != null) setProjectAddress(b.getProjectAddress());
		if(b.getContractFollower() != null) setContractFollower(b.getContractFollower());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getContractDate() != null) setContractDate(b.getContractDate());
		if(b.getSigningCompanyName() != null) setSigningCompanyName(b.getSigningCompanyName());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getFlowStatus() != null) setFlowStatus(b.getFlowStatus());
		if(b.getSerialNumber() != null) setSerialNumber(b.getSerialNumber());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getCoveredArea() != null) setCoveredArea(b.getCoveredArea());
		if(b.getProfessionalCooperation() != null) setProfessionalCooperation(b.getProfessionalCooperation());
		if(b.getProvince() != null) setProvince(b.getProvince());
		if(b.getCity() != null) setCity(b.getCity());
		if(b.getDetailAddress() != null) setDetailAddress(b.getDetailAddress());
		if(b.getCustomerAddress() != null) setCustomerAddress(b.getCustomerAddress());
		if(b.getServiceSuggestBook() != null) setServiceSuggestBook(b.getServiceSuggestBook());
		if(b.getProjectApprovalTime() != null) setProjectApprovalTime(b.getProjectApprovalTime());
		if(b.getOrderNo() != null) setOrderNo(b.getOrderNo());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
		if(b.getContractStatus() != null) setContractStatus(b.getContractStatus());
		if(b.getClientContractId() != null) setClientContractId(b.getClientContractId());
		if(b.getIsFinish() != null) setIsFinish(b.getIsFinish());
		if(b.getIsSystemAdd() != null) setIsSystemAdd(b.getIsSystemAdd());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getAttachmentRemark() != null) setAttachmentRemark(b.getAttachmentRemark());
		if(b.getFinancialContractCode() != null) setFinancialContractCode(b.getFinancialContractCode());
		if(b.getContractArea() != null) setContractArea(b.getContractArea());
		if(b.getCustomerId() != null) setCustomerId(b.getCustomerId());
		if(b.getContractInfoAudited() != null) setContractInfoAudited(b.getContractInfoAudited());
		if(b.getContractSigningStatus() != null) setContractSigningStatus(b.getContractSigningStatus());
		if(b.getSendingDate() != null) setSendingDate(b.getSendingDate());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getRelevantEmployees() != null) setRelevantEmployees(b.getRelevantEmployees());
		if(b.getRelevantEmployeesName() != null) setRelevantEmployeesName(b.getRelevantEmployeesName());
		if(b.getServiceSuggestBookId() != null) setServiceSuggestBookId(b.getServiceSuggestBookId());
		if(b.getContractYear() != null) setContractYear(b.getContractYear());
		if(b.getCopyIncomeLedger() != null) setCopyIncomeLedger(b.getCopyIncomeLedger());
		if(b.getIncomeLedgerNumber() != null) setIncomeLedgerNumber(b.getIncomeLedgerNumber());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getFileUrl() != null) setFileUrl(b.getFileUrl());
	}

	@Override
	public BaseContract generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContract b = new BaseContract();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContract __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalProjectTime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignAreas(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractFollower(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSigningCompanyName(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlowStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSerialNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCoveredArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProfessionalCooperation(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvince(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCity(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setServiceSuggestBook(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientContractId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsFinish(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSystemAdd(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinancialContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractArea(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractInfoAudited(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractSigningStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendingDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelevantEmployees(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelevantEmployeesName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setServiceSuggestBookId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCopyIncomeLedger(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIncomeLedgerNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileUrl(GenericBase.__getString(val));
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setContractName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getContractName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setCustomerName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getCustomerName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setContractType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getContractType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setProjectLevel(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getProjectLevel() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setTotalProjectTime(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getTotalProjectTime() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setSigningMoneySum(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setDesignAreas(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getDesignAreas() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setContractPrice(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getContractPrice() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setProjectAddress(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getProjectAddress() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setContractFollower(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getContractFollower() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setContractDate(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getContractDate() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setSigningCompanyName(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getSigningCompanyName() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(19, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[19]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(20, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[20]);
	}

	public void setBusinessType(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getBusinessType() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setFlowStatus(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getFlowStatus() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setSerialNumber(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getSerialNumber() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setProjectType(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getProjectType() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setCoveredArea(java.math.BigDecimal val) {
		setCurrentData(25, val);
	}

	public java.math.BigDecimal getCoveredArea() {
		return GenericBase.__getDecimal(__current_data[25]);
	}

	public void setProfessionalCooperation(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getProfessionalCooperation() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setProvince(java.lang.String val) {
		setCurrentData(27, val);
	}

	public java.lang.String getProvince() {
		return GenericBase.__getString(__current_data[27]);
	}

	public void setCity(java.lang.String val) {
		setCurrentData(28, val);
	}

	public java.lang.String getCity() {
		return GenericBase.__getString(__current_data[28]);
	}

	public void setDetailAddress(java.lang.String val) {
		setCurrentData(29, val);
	}

	public java.lang.String getDetailAddress() {
		return GenericBase.__getString(__current_data[29]);
	}

	public void setCustomerAddress(java.lang.String val) {
		setCurrentData(30, val);
	}

	public java.lang.String getCustomerAddress() {
		return GenericBase.__getString(__current_data[30]);
	}

	public void setServiceSuggestBook(java.lang.String val) {
		setCurrentData(31, val);
	}

	public java.lang.String getServiceSuggestBook() {
		return GenericBase.__getString(__current_data[31]);
	}

	public void setProjectApprovalTime(java.util.Date val) {
		setCurrentData(32, generateTimestampFromDate(val));
	}

	public java.util.Date getProjectApprovalTime() {
		return GenericBase.__getDateFromSQL(__current_data[32]);
	}

	public void setOrderNo(java.lang.Integer val) {
		setCurrentData(33, val);
	}

	public java.lang.Integer getOrderNo() {
		return GenericBase.__getInt(__current_data[33]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(34, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[34]);
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(35, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[35]);
	}

	public void setContractStatus(java.lang.Integer val) {
		setCurrentData(36, val);
	}

	public java.lang.Integer getContractStatus() {
		return GenericBase.__getInt(__current_data[36]);
	}

	public void setClientContractId(java.lang.String val) {
		setCurrentData(37, val);
	}

	public java.lang.String getClientContractId() {
		return GenericBase.__getString(__current_data[37]);
	}

	public void setIsFinish(java.lang.Boolean val) {
		setCurrentData(38, val);
	}

	public java.lang.Boolean getIsFinish() {
		return GenericBase.__getBoolean(__current_data[38]);
	}

	public void setIsSystemAdd(java.lang.Boolean val) {
		setCurrentData(39, val);
	}

	public java.lang.Boolean getIsSystemAdd() {
		return GenericBase.__getBoolean(__current_data[39]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(40, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[40]);
	}

	public void setAttachmentRemark(java.lang.String val) {
		setCurrentData(41, val);
	}

	public java.lang.String getAttachmentRemark() {
		return GenericBase.__getString(__current_data[41]);
	}

	public void setFinancialContractCode(java.lang.String val) {
		setCurrentData(42, val);
	}

	public java.lang.String getFinancialContractCode() {
		return GenericBase.__getString(__current_data[42]);
	}

	public void setContractArea(java.lang.Integer val) {
		setCurrentData(43, val);
	}

	public java.lang.Integer getContractArea() {
		return GenericBase.__getInt(__current_data[43]);
	}

	public void setCustomerId(java.lang.Integer val) {
		setCurrentData(44, val);
	}

	public java.lang.Integer getCustomerId() {
		return GenericBase.__getInt(__current_data[44]);
	}

	public void setContractInfoAudited(java.lang.Boolean val) {
		setCurrentData(45, val);
	}

	public java.lang.Boolean getContractInfoAudited() {
		return GenericBase.__getBoolean(__current_data[45]);
	}

	public void setContractSigningStatus(java.lang.Integer val) {
		setCurrentData(46, val);
	}

	public java.lang.Integer getContractSigningStatus() {
		return GenericBase.__getInt(__current_data[46]);
	}

	public void setSendingDate(java.util.Date val) {
		setCurrentData(47, generateTimestampFromDate(val));
	}

	public java.util.Date getSendingDate() {
		return GenericBase.__getDateFromSQL(__current_data[47]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(48, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[48]);
	}

	public void setRelevantEmployees(java.lang.String val) {
		setCurrentData(49, val);
	}

	public java.lang.String getRelevantEmployees() {
		return GenericBase.__getString(__current_data[49]);
	}

	public void setRelevantEmployeesName(java.lang.String val) {
		setCurrentData(50, val);
	}

	public java.lang.String getRelevantEmployeesName() {
		return GenericBase.__getString(__current_data[50]);
	}

	public void setServiceSuggestBookId(java.lang.Integer val) {
		setCurrentData(51, val);
	}

	public java.lang.Integer getServiceSuggestBookId() {
		return GenericBase.__getInt(__current_data[51]);
	}

	public void setContractYear(java.lang.Integer val) {
		setCurrentData(52, val);
	}

	public java.lang.Integer getContractYear() {
		return GenericBase.__getInt(__current_data[52]);
	}

	public void setCopyIncomeLedger(java.lang.Boolean val) {
		setCurrentData(53, val);
	}

	public java.lang.Boolean getCopyIncomeLedger() {
		return GenericBase.__getBoolean(__current_data[53]);
	}

	public void setIncomeLedgerNumber(java.lang.Integer val) {
		setCurrentData(54, val);
	}

	public java.lang.Integer getIncomeLedgerNumber() {
		return GenericBase.__getInt(__current_data[54]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(55, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[55]);
	}

	public void setFileUrl(java.lang.String val) {
		setCurrentData(56, val);
	}

	public java.lang.String getFileUrl() {
		return GenericBase.__getString(__current_data[56]);
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[0] = val;
	}

	public void setContractIdExpression(String val) {
		__dataExpressions[0] = val;
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

	public void setContractCodeExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionContractName(String op, java.lang.String val) {
		setConditionContractName(op, val, CONDITION_AND);
	}

	public void setConditionContractName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContractName(boolean val) {
		__select_flags[2] = val;
	}

	public void setContractNameExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionCustomerName(String op, java.lang.String val) {
		setConditionCustomerName(op, val, CONDITION_AND);
	}

	public void setConditionCustomerName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCustomerName(boolean val) {
		__select_flags[3] = val;
	}

	public void setCustomerNameExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setStartDateExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setEndDateExpression(String val) {
		__dataExpressions[5] = val;
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

	public void setStatusExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[7] = val;
	}

	public void setProjectCodeExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionContractType(String op, java.lang.Integer val) {
		setConditionContractType(op, val, CONDITION_AND);
	}

	public void setConditionContractType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectContractType(boolean val) {
		__select_flags[8] = val;
	}

	public void setContractTypeExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionProjectLevel(String op, java.lang.Integer val) {
		setConditionProjectLevel(op, val, CONDITION_AND);
	}

	public void setConditionProjectLevel(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectProjectLevel(boolean val) {
		__select_flags[9] = val;
	}

	public void setProjectLevelExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionTotalProjectTime(String op, java.lang.Integer val) {
		setConditionTotalProjectTime(op, val, CONDITION_AND);
	}

	public void setConditionTotalProjectTime(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectTotalProjectTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setTotalProjectTimeExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionSigningMoneySum(String op, java.math.BigDecimal val) {
		setConditionSigningMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionSigningMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSigningMoneySum(boolean val) {
		__select_flags[11] = val;
	}

	public void setSigningMoneySumExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionDesignAreas(String op, java.math.BigDecimal val) {
		setConditionDesignAreas(op, val, CONDITION_AND);
	}

	public void setConditionDesignAreas(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectDesignAreas(boolean val) {
		__select_flags[12] = val;
	}

	public void setDesignAreasExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionContractPrice(String op, java.math.BigDecimal val) {
		setConditionContractPrice(op, val, CONDITION_AND);
	}

	public void setConditionContractPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectContractPrice(boolean val) {
		__select_flags[13] = val;
	}

	public void setContractPriceExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionProjectAddress(String op, java.lang.String val) {
		setConditionProjectAddress(op, val, CONDITION_AND);
	}

	public void setConditionProjectAddress(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectProjectAddress(boolean val) {
		__select_flags[14] = val;
	}

	public void setProjectAddressExpression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionContractFollower(String op, java.lang.Integer val) {
		setConditionContractFollower(op, val, CONDITION_AND);
	}

	public void setConditionContractFollower(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectContractFollower(boolean val) {
		__select_flags[15] = val;
	}

	public void setContractFollowerExpression(String val) {
		__dataExpressions[15] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[16] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[16] = val;
	}

	public void setConditionContractDate(String op, java.util.Date val) {
		setConditionContractDate(op, val, CONDITION_AND);
	}

	public void setConditionContractDate(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectContractDate(boolean val) {
		__select_flags[17] = val;
	}

	public void setContractDateExpression(String val) {
		__dataExpressions[17] = val;
	}

	public void setConditionSigningCompanyName(String op, java.lang.Integer val) {
		setConditionSigningCompanyName(op, val, CONDITION_AND);
	}

	public void setConditionSigningCompanyName(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectSigningCompanyName(boolean val) {
		__select_flags[18] = val;
	}

	public void setSigningCompanyNameExpression(String val) {
		__dataExpressions[18] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(19, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[19] = val;
	}

	public void setCreateTimeExpression(String val) {
		__dataExpressions[19] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(20, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[20] = val;
	}

	public void setUpdateTimeExpression(String val) {
		__dataExpressions[20] = val;
	}

	public void setConditionBusinessType(String op, java.lang.String val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[21] = val;
	}

	public void setBusinessTypeExpression(String val) {
		__dataExpressions[21] = val;
	}

	public void setConditionFlowStatus(String op, java.lang.Integer val) {
		setConditionFlowStatus(op, val, CONDITION_AND);
	}

	public void setConditionFlowStatus(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectFlowStatus(boolean val) {
		__select_flags[22] = val;
	}

	public void setFlowStatusExpression(String val) {
		__dataExpressions[22] = val;
	}

	public void setConditionSerialNumber(String op, java.lang.String val) {
		setConditionSerialNumber(op, val, CONDITION_AND);
	}

	public void setConditionSerialNumber(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectSerialNumber(boolean val) {
		__select_flags[23] = val;
	}

	public void setSerialNumberExpression(String val) {
		__dataExpressions[23] = val;
	}

	public void setConditionProjectType(String op, java.lang.String val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[24] = val;
	}

	public void setProjectTypeExpression(String val) {
		__dataExpressions[24] = val;
	}

	public void setConditionCoveredArea(String op, java.math.BigDecimal val) {
		setConditionCoveredArea(op, val, CONDITION_AND);
	}

	public void setConditionCoveredArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectCoveredArea(boolean val) {
		__select_flags[25] = val;
	}

	public void setCoveredAreaExpression(String val) {
		__dataExpressions[25] = val;
	}

	public void setConditionProfessionalCooperation(String op, java.lang.String val) {
		setConditionProfessionalCooperation(op, val, CONDITION_AND);
	}

	public void setConditionProfessionalCooperation(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectProfessionalCooperation(boolean val) {
		__select_flags[26] = val;
	}

	public void setProfessionalCooperationExpression(String val) {
		__dataExpressions[26] = val;
	}

	public void setConditionProvince(String op, java.lang.String val) {
		setConditionProvince(op, val, CONDITION_AND);
	}

	public void setConditionProvince(String op, java.lang.String val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectProvince(boolean val) {
		__select_flags[27] = val;
	}

	public void setProvinceExpression(String val) {
		__dataExpressions[27] = val;
	}

	public void setConditionCity(String op, java.lang.String val) {
		setConditionCity(op, val, CONDITION_AND);
	}

	public void setConditionCity(String op, java.lang.String val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectCity(boolean val) {
		__select_flags[28] = val;
	}

	public void setCityExpression(String val) {
		__dataExpressions[28] = val;
	}

	public void setConditionDetailAddress(String op, java.lang.String val) {
		setConditionDetailAddress(op, val, CONDITION_AND);
	}

	public void setConditionDetailAddress(String op, java.lang.String val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectDetailAddress(boolean val) {
		__select_flags[29] = val;
	}

	public void setDetailAddressExpression(String val) {
		__dataExpressions[29] = val;
	}

	public void setConditionCustomerAddress(String op, java.lang.String val) {
		setConditionCustomerAddress(op, val, CONDITION_AND);
	}

	public void setConditionCustomerAddress(String op, java.lang.String val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectCustomerAddress(boolean val) {
		__select_flags[30] = val;
	}

	public void setCustomerAddressExpression(String val) {
		__dataExpressions[30] = val;
	}

	public void setConditionServiceSuggestBook(String op, java.lang.String val) {
		setConditionServiceSuggestBook(op, val, CONDITION_AND);
	}

	public void setConditionServiceSuggestBook(String op, java.lang.String val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectServiceSuggestBook(boolean val) {
		__select_flags[31] = val;
	}

	public void setServiceSuggestBookExpression(String val) {
		__dataExpressions[31] = val;
	}

	public void setConditionProjectApprovalTime(String op, java.util.Date val) {
		setConditionProjectApprovalTime(op, val, CONDITION_AND);
	}

	public void setConditionProjectApprovalTime(String op, java.util.Date val, String relation) {
		addCondition(32, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectProjectApprovalTime(boolean val) {
		__select_flags[32] = val;
	}

	public void setProjectApprovalTimeExpression(String val) {
		__dataExpressions[32] = val;
	}

	public void setConditionOrderNo(String op, java.lang.Integer val) {
		setConditionOrderNo(op, val, CONDITION_AND);
	}

	public void setConditionOrderNo(String op, java.lang.Integer val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectOrderNo(boolean val) {
		__select_flags[33] = val;
	}

	public void setOrderNoExpression(String val) {
		__dataExpressions[33] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[34] = val;
	}

	public void setParentIdExpression(String val) {
		__dataExpressions[34] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[35] = val;
	}

	public void setInfoCodeExpression(String val) {
		__dataExpressions[35] = val;
	}

	public void setConditionContractStatus(String op, java.lang.Integer val) {
		setConditionContractStatus(op, val, CONDITION_AND);
	}

	public void setConditionContractStatus(String op, java.lang.Integer val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectContractStatus(boolean val) {
		__select_flags[36] = val;
	}

	public void setContractStatusExpression(String val) {
		__dataExpressions[36] = val;
	}

	public void setConditionClientContractId(String op, java.lang.String val) {
		setConditionClientContractId(op, val, CONDITION_AND);
	}

	public void setConditionClientContractId(String op, java.lang.String val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectClientContractId(boolean val) {
		__select_flags[37] = val;
	}

	public void setClientContractIdExpression(String val) {
		__dataExpressions[37] = val;
	}

	public void setConditionIsFinish(String op, java.lang.Boolean val) {
		setConditionIsFinish(op, val, CONDITION_AND);
	}

	public void setConditionIsFinish(String op, java.lang.Boolean val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectIsFinish(boolean val) {
		__select_flags[38] = val;
	}

	public void setIsFinishExpression(String val) {
		__dataExpressions[38] = val;
	}

	public void setConditionIsSystemAdd(String op, java.lang.Boolean val) {
		setConditionIsSystemAdd(op, val, CONDITION_AND);
	}

	public void setConditionIsSystemAdd(String op, java.lang.Boolean val, String relation) {
		addCondition(39, op, relation, val);
	}

	public void setSelectIsSystemAdd(boolean val) {
		__select_flags[39] = val;
	}

	public void setIsSystemAddExpression(String val) {
		__dataExpressions[39] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(40, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[40] = val;
	}

	public void setOperatorExpression(String val) {
		__dataExpressions[40] = val;
	}

	public void setConditionAttachmentRemark(String op, java.lang.String val) {
		setConditionAttachmentRemark(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentRemark(String op, java.lang.String val, String relation) {
		addCondition(41, op, relation, val);
	}

	public void setSelectAttachmentRemark(boolean val) {
		__select_flags[41] = val;
	}

	public void setAttachmentRemarkExpression(String val) {
		__dataExpressions[41] = val;
	}

	public void setConditionFinancialContractCode(String op, java.lang.String val) {
		setConditionFinancialContractCode(op, val, CONDITION_AND);
	}

	public void setConditionFinancialContractCode(String op, java.lang.String val, String relation) {
		addCondition(42, op, relation, val);
	}

	public void setSelectFinancialContractCode(boolean val) {
		__select_flags[42] = val;
	}

	public void setFinancialContractCodeExpression(String val) {
		__dataExpressions[42] = val;
	}

	public void setConditionContractArea(String op, java.lang.Integer val) {
		setConditionContractArea(op, val, CONDITION_AND);
	}

	public void setConditionContractArea(String op, java.lang.Integer val, String relation) {
		addCondition(43, op, relation, val);
	}

	public void setSelectContractArea(boolean val) {
		__select_flags[43] = val;
	}

	public void setContractAreaExpression(String val) {
		__dataExpressions[43] = val;
	}

	public void setConditionCustomerId(String op, java.lang.Integer val) {
		setConditionCustomerId(op, val, CONDITION_AND);
	}

	public void setConditionCustomerId(String op, java.lang.Integer val, String relation) {
		addCondition(44, op, relation, val);
	}

	public void setSelectCustomerId(boolean val) {
		__select_flags[44] = val;
	}

	public void setCustomerIdExpression(String val) {
		__dataExpressions[44] = val;
	}

	public void setConditionContractInfoAudited(String op, java.lang.Boolean val) {
		setConditionContractInfoAudited(op, val, CONDITION_AND);
	}

	public void setConditionContractInfoAudited(String op, java.lang.Boolean val, String relation) {
		addCondition(45, op, relation, val);
	}

	public void setSelectContractInfoAudited(boolean val) {
		__select_flags[45] = val;
	}

	public void setContractInfoAuditedExpression(String val) {
		__dataExpressions[45] = val;
	}

	public void setConditionContractSigningStatus(String op, java.lang.Integer val) {
		setConditionContractSigningStatus(op, val, CONDITION_AND);
	}

	public void setConditionContractSigningStatus(String op, java.lang.Integer val, String relation) {
		addCondition(46, op, relation, val);
	}

	public void setSelectContractSigningStatus(boolean val) {
		__select_flags[46] = val;
	}

	public void setContractSigningStatusExpression(String val) {
		__dataExpressions[46] = val;
	}

	public void setConditionSendingDate(String op, java.util.Date val) {
		setConditionSendingDate(op, val, CONDITION_AND);
	}

	public void setConditionSendingDate(String op, java.util.Date val, String relation) {
		addCondition(47, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSendingDate(boolean val) {
		__select_flags[47] = val;
	}

	public void setSendingDateExpression(String val) {
		__dataExpressions[47] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(48, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[48] = val;
	}

	public void setDepartmentIdExpression(String val) {
		__dataExpressions[48] = val;
	}

	public void setConditionRelevantEmployees(String op, java.lang.String val) {
		setConditionRelevantEmployees(op, val, CONDITION_AND);
	}

	public void setConditionRelevantEmployees(String op, java.lang.String val, String relation) {
		addCondition(49, op, relation, val);
	}

	public void setSelectRelevantEmployees(boolean val) {
		__select_flags[49] = val;
	}

	public void setRelevantEmployeesExpression(String val) {
		__dataExpressions[49] = val;
	}

	public void setConditionRelevantEmployeesName(String op, java.lang.String val) {
		setConditionRelevantEmployeesName(op, val, CONDITION_AND);
	}

	public void setConditionRelevantEmployeesName(String op, java.lang.String val, String relation) {
		addCondition(50, op, relation, val);
	}

	public void setSelectRelevantEmployeesName(boolean val) {
		__select_flags[50] = val;
	}

	public void setRelevantEmployeesNameExpression(String val) {
		__dataExpressions[50] = val;
	}

	public void setConditionServiceSuggestBookId(String op, java.lang.Integer val) {
		setConditionServiceSuggestBookId(op, val, CONDITION_AND);
	}

	public void setConditionServiceSuggestBookId(String op, java.lang.Integer val, String relation) {
		addCondition(51, op, relation, val);
	}

	public void setSelectServiceSuggestBookId(boolean val) {
		__select_flags[51] = val;
	}

	public void setServiceSuggestBookIdExpression(String val) {
		__dataExpressions[51] = val;
	}

	public void setConditionContractYear(String op, java.lang.Integer val) {
		setConditionContractYear(op, val, CONDITION_AND);
	}

	public void setConditionContractYear(String op, java.lang.Integer val, String relation) {
		addCondition(52, op, relation, val);
	}

	public void setSelectContractYear(boolean val) {
		__select_flags[52] = val;
	}

	public void setContractYearExpression(String val) {
		__dataExpressions[52] = val;
	}

	public void setConditionCopyIncomeLedger(String op, java.lang.Boolean val) {
		setConditionCopyIncomeLedger(op, val, CONDITION_AND);
	}

	public void setConditionCopyIncomeLedger(String op, java.lang.Boolean val, String relation) {
		addCondition(53, op, relation, val);
	}

	public void setSelectCopyIncomeLedger(boolean val) {
		__select_flags[53] = val;
	}

	public void setCopyIncomeLedgerExpression(String val) {
		__dataExpressions[53] = val;
	}

	public void setConditionIncomeLedgerNumber(String op, java.lang.Integer val) {
		setConditionIncomeLedgerNumber(op, val, CONDITION_AND);
	}

	public void setConditionIncomeLedgerNumber(String op, java.lang.Integer val, String relation) {
		addCondition(54, op, relation, val);
	}

	public void setSelectIncomeLedgerNumber(boolean val) {
		__select_flags[54] = val;
	}

	public void setIncomeLedgerNumberExpression(String val) {
		__dataExpressions[54] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(55, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[55] = val;
	}

	public void setFileIdExpression(String val) {
		__dataExpressions[55] = val;
	}

	public void setConditionFileUrl(String op, java.lang.String val) {
		setConditionFileUrl(op, val, CONDITION_AND);
	}

	public void setConditionFileUrl(String op, java.lang.String val, String relation) {
		addCondition(56, op, relation, val);
	}

	public void setSelectFileUrl(boolean val) {
		__select_flags[56] = val;
	}

	public void setFileUrlExpression(String val) {
		__dataExpressions[56] = val;
	}


}

