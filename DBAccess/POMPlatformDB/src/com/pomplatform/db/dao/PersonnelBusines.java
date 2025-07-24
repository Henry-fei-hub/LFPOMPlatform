package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePersonnelBusines;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PersonnelBusines extends AbstractTable<BasePersonnelBusines>
{

	public PersonnelBusines() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 67;

		initTables();

		__tableName            = "personnel_business";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePersonnelBusines.CS_PERSONNEL_BUSINESS_ID;
		__column_names[1] = BasePersonnelBusines.CS_PROCESS_TYPE;
		__column_names[2] = BasePersonnelBusines.CS_EMPLOYEE_ID;
		__column_names[3] = BasePersonnelBusines.CS_EMPLOYEE_NO;
		__column_names[4] = BasePersonnelBusines.CS_DEPARTMENT_ID;
		__column_names[5] = BasePersonnelBusines.CS_COMPANY_ID;
		__column_names[6] = BasePersonnelBusines.CS_TYPE;
		__column_names[7] = BasePersonnelBusines.CS_START_DATE;
		__column_names[8] = BasePersonnelBusines.CS_START_DATE_DETAIL;
		__column_names[9] = BasePersonnelBusines.CS_END_DATE;
		__column_names[10] = BasePersonnelBusines.CS_END_DATE_DETAIL;
		__column_names[11] = BasePersonnelBusines.CS_DAYS;
		__column_names[12] = BasePersonnelBusines.CS_REASON;
		__column_names[13] = BasePersonnelBusines.CS_REMARK;
		__column_names[14] = BasePersonnelBusines.CS_ADDRESS;
		__column_names[15] = BasePersonnelBusines.CS_PLAN;
		__column_names[16] = BasePersonnelBusines.CS_TRANSPORTATION;
		__column_names[17] = BasePersonnelBusines.CS_FEE;
		__column_names[18] = BasePersonnelBusines.CS_UNIT;
		__column_names[19] = BasePersonnelBusines.CS_CONTACT_PERSON;
		__column_names[20] = BasePersonnelBusines.CS_CREATE_TIME;
		__column_names[21] = BasePersonnelBusines.CS_DELETE_FLAG;
		__column_names[22] = BasePersonnelBusines.CS_NEXT_AUDITOR;
		__column_names[23] = BasePersonnelBusines.CS_SUB_TYPE;
		__column_names[24] = BasePersonnelBusines.CS_HOURS;
		__column_names[25] = BasePersonnelBusines.CS_COMPANY_PROVINCE;
		__column_names[26] = BasePersonnelBusines.CS_TARGET_PROVINCE;
		__column_names[27] = BasePersonnelBusines.CS_NUMBER_OF_BABY;
		__column_names[28] = BasePersonnelBusines.CS_ATTACHMENT;
		__column_names[29] = BasePersonnelBusines.CS_IS_COMPLETED;
		__column_names[30] = BasePersonnelBusines.CS_SUB_TYPE_STR;
		__column_names[31] = BasePersonnelBusines.CS_PROJECT_TYPE;
		__column_names[32] = BasePersonnelBusines.CS_PROJECT_ID;
		__column_names[33] = BasePersonnelBusines.CS_PROJECT_NAME;
		__column_names[34] = BasePersonnelBusines.CS_PROJECT_CODE;
		__column_names[35] = BasePersonnelBusines.CS_PARENT_ID;
		__column_names[36] = BasePersonnelBusines.CS_IS_REMOTE_CITY;
		__column_names[37] = BasePersonnelBusines.CS_PROVIDE_ACCOMMODATION;
		__column_names[38] = BasePersonnelBusines.CS_LIVING_EXPENSES;
		__column_names[39] = BasePersonnelBusines.CS_HOUSING_FINANCE;
		__column_names[40] = BasePersonnelBusines.CS_DRAFTER;
		__column_names[41] = BasePersonnelBusines.CS_CARD;
		__column_names[42] = BasePersonnelBusines.CS_DUTY_ID;
		__column_names[43] = BasePersonnelBusines.CS_EQUIVALENT_NUMBER;
		__column_names[44] = BasePersonnelBusines.CS_LINK_ID;
		__column_names[45] = BasePersonnelBusines.CS_SEVERANCE;
		__column_names[46] = BasePersonnelBusines.CS_SALARY_1;
		__column_names[47] = BasePersonnelBusines.CS_SALARY_2;
		__column_names[48] = BasePersonnelBusines.CS_ORIGINAL_PAY;
		__column_names[49] = BasePersonnelBusines.CS_MONTH_PAY;
		__column_names[50] = BasePersonnelBusines.CS_BASIC_PROPORTION_STR;
		__column_names[51] = BasePersonnelBusines.CS_BASIC_PROPORTION;
		__column_names[52] = BasePersonnelBusines.CS_MONTH_BASIC_PAY;
		__column_names[53] = BasePersonnelBusines.CS_MONTH_PERFORMANCE_PAY;
		__column_names[54] = BasePersonnelBusines.CS_FOREMAN_PAY;
		__column_names[55] = BasePersonnelBusines.CS_OTHER_SUBSIDY;
		__column_names[56] = BasePersonnelBusines.CS_TOTAL_PAY;
		__column_names[57] = BasePersonnelBusines.CS_ANNUAL_PERFORMANCE;
		__column_names[58] = BasePersonnelBusines.CS_COST_ATTRIBUTION;
		__column_names[59] = BasePersonnelBusines.CS_CERTIFICATION_TIME;
		__column_names[60] = BasePersonnelBusines.CS_PROJECT_IDS;
		__column_names[61] = BasePersonnelBusines.CS_PAYMENT_SEQUENCE_ID;
		__column_names[62] = BasePersonnelBusines.CS_BUDGET_MANAGEMENT_ID;
		__column_names[63] = BasePersonnelBusines.CS_BUDGET_ATTACHMENT_ID;
		__column_names[64] = BasePersonnelBusines.CS_STAGE_ID;
		__column_names[65] = BasePersonnelBusines.CS_ATTACHMENT_ID;
		__column_names[66] = BasePersonnelBusines.CS_ATTACHMENT_NAME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePersonnelBusines b) {
		clear();
		setPersonnelBusinessIdClear(b.getPersonnelBusinessId());
	}

	public boolean isPrimaryKeyNull() {
		return getPersonnelBusinessId() == null;
	}

	@Override
	public BasePersonnelBusines generateBase(){
		BasePersonnelBusines b = new BasePersonnelBusines();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePersonnelBusines b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStartDateDetail(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDateDetail(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReason(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlan(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTransportation(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFee(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnit(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactPerson(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNextAuditor(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubType(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCompanyProvince(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTargetProvince(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNumberOfBaby(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachment(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setSubTypeStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsRemoteCity(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setProvideAccommodation(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setLivingExpenses(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHousingFinance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDrafter(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCard(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDutyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEquivalentNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLinkId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSeverance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSalary1(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSalary2(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOriginalPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMonthPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBasicProportionStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBasicProportion(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthBasicPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMonthPerformancePay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setForemanPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherSubsidy(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAnnualPerformance(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCostAttribution(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCertificationTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setProjectIds(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPaymentSequenceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentName(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePersonnelBusines b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getType();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = b.getStartDateDetail();
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getEndDateDetail();
		buff[count++] = b.getDays();
		buff[count++] = b.getReason();
		buff[count++] = b.getRemark();
		buff[count++] = b.getAddress();
		buff[count++] = b.getPlan();
		buff[count++] = b.getTransportation();
		buff[count++] = b.getFee();
		buff[count++] = b.getUnit();
		buff[count++] = b.getContactPerson();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getNextAuditor();
		buff[count++] = b.getSubType();
		buff[count++] = b.getHours();
		buff[count++] = b.getCompanyProvince();
		buff[count++] = b.getTargetProvince();
		buff[count++] = b.getNumberOfBaby();
		buff[count++] = b.getAttachment();
		buff[count++] = b.getIsCompleted();
		buff[count++] = b.getSubTypeStr();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getParentId();
		buff[count++] = b.getIsRemoteCity();
		buff[count++] = b.getProvideAccommodation();
		buff[count++] = b.getLivingExpenses();
		buff[count++] = b.getHousingFinance();
		buff[count++] = b.getDrafter();
		buff[count++] = b.getCard();
		buff[count++] = b.getDutyId();
		buff[count++] = b.getEquivalentNumber();
		buff[count++] = b.getLinkId();
		buff[count++] = b.getSeverance();
		buff[count++] = b.getSalary1();
		buff[count++] = b.getSalary2();
		buff[count++] = b.getOriginalPay();
		buff[count++] = b.getMonthPay();
		buff[count++] = b.getBasicProportionStr();
		buff[count++] = b.getBasicProportion();
		buff[count++] = b.getMonthBasicPay();
		buff[count++] = b.getMonthPerformancePay();
		buff[count++] = b.getForemanPay();
		buff[count++] = b.getOtherSubsidy();
		buff[count++] = b.getTotalPay();
		buff[count++] = b.getAnnualPerformance();
		buff[count++] = b.getCostAttribution();
		buff[count++] = generateTimestampFromDate(b.getCertificationTime());
		buff[count++] = b.getProjectIds();
		buff[count++] = b.getPaymentSequenceId();
		buff[count++] = b.getBudgetManagementId();
		buff[count++] = b.getBudgetAttachmentId();
		buff[count++] = b.getStageId();
		buff[count++] = b.getAttachmentId();
		buff[count++] = b.getAttachmentName();
	}

	@Override
	public void setDataFromBase(BasePersonnelBusines b){
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessIdClear(b.getPersonnelBusinessId());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getType() != null) setType(b.getType());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getStartDateDetail() != null) setStartDateDetail(b.getStartDateDetail());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getEndDateDetail() != null) setEndDateDetail(b.getEndDateDetail());
		if(b.getDays() != null) setDays(b.getDays());
		if(b.getReason() != null) setReason(b.getReason());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getAddress() != null) setAddress(b.getAddress());
		if(b.getPlan() != null) setPlan(b.getPlan());
		if(b.getTransportation() != null) setTransportation(b.getTransportation());
		if(b.getFee() != null) setFee(b.getFee());
		if(b.getUnit() != null) setUnit(b.getUnit());
		if(b.getContactPerson() != null) setContactPerson(b.getContactPerson());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getNextAuditor() != null) setNextAuditor(b.getNextAuditor());
		if(b.getSubType() != null) setSubType(b.getSubType());
		if(b.getHours() != null) setHours(b.getHours());
		if(b.getCompanyProvince() != null) setCompanyProvince(b.getCompanyProvince());
		if(b.getTargetProvince() != null) setTargetProvince(b.getTargetProvince());
		if(b.getNumberOfBaby() != null) setNumberOfBaby(b.getNumberOfBaby());
		if(b.getAttachment() != null) setAttachment(b.getAttachment());
		if(b.getIsCompleted() != null) setIsCompleted(b.getIsCompleted());
		if(b.getSubTypeStr() != null) setSubTypeStr(b.getSubTypeStr());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getIsRemoteCity() != null) setIsRemoteCity(b.getIsRemoteCity());
		if(b.getProvideAccommodation() != null) setProvideAccommodation(b.getProvideAccommodation());
		if(b.getLivingExpenses() != null) setLivingExpenses(b.getLivingExpenses());
		if(b.getHousingFinance() != null) setHousingFinance(b.getHousingFinance());
		if(b.getDrafter() != null) setDrafter(b.getDrafter());
		if(b.getCard() != null) setCard(b.getCard());
		if(b.getDutyId() != null) setDutyId(b.getDutyId());
		if(b.getEquivalentNumber() != null) setEquivalentNumber(b.getEquivalentNumber());
		if(b.getLinkId() != null) setLinkId(b.getLinkId());
		if(b.getSeverance() != null) setSeverance(b.getSeverance());
		if(b.getSalary1() != null) setSalary1(b.getSalary1());
		if(b.getSalary2() != null) setSalary2(b.getSalary2());
		if(b.getOriginalPay() != null) setOriginalPay(b.getOriginalPay());
		if(b.getMonthPay() != null) setMonthPay(b.getMonthPay());
		if(b.getBasicProportionStr() != null) setBasicProportionStr(b.getBasicProportionStr());
		if(b.getBasicProportion() != null) setBasicProportion(b.getBasicProportion());
		if(b.getMonthBasicPay() != null) setMonthBasicPay(b.getMonthBasicPay());
		if(b.getMonthPerformancePay() != null) setMonthPerformancePay(b.getMonthPerformancePay());
		if(b.getForemanPay() != null) setForemanPay(b.getForemanPay());
		if(b.getOtherSubsidy() != null) setOtherSubsidy(b.getOtherSubsidy());
		if(b.getTotalPay() != null) setTotalPay(b.getTotalPay());
		if(b.getAnnualPerformance() != null) setAnnualPerformance(b.getAnnualPerformance());
		if(b.getCostAttribution() != null) setCostAttribution(b.getCostAttribution());
		if(b.getCertificationTime() != null) setCertificationTime(b.getCertificationTime());
		if(b.getProjectIds() != null) setProjectIds(b.getProjectIds());
		if(b.getPaymentSequenceId() != null) setPaymentSequenceId(b.getPaymentSequenceId());
		if(b.getBudgetManagementId() != null) setBudgetManagementId(b.getBudgetManagementId());
		if(b.getBudgetAttachmentId() != null) setBudgetAttachmentId(b.getBudgetAttachmentId());
		if(b.getStageId() != null) setStageId(b.getStageId());
		if(b.getAttachmentId() != null) setAttachmentId(b.getAttachmentId());
		if(b.getAttachmentName() != null) setAttachmentName(b.getAttachmentName());
	}

	@Override
	public BasePersonnelBusines generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePersonnelBusines b = new BasePersonnelBusines();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePersonnelBusines __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDateDetail(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDateDetail(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReason(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlan(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransportation(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFee(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnit(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactPerson(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNextAuditor(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubType(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyProvince(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTargetProvince(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNumberOfBaby(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachment(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubTypeStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsRemoteCity(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvideAccommodation(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLivingExpenses(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHousingFinance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDrafter(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCard(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDutyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEquivalentNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLinkId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSeverance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalary1(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalary2(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicProportionStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicProportion(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthBasicPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthPerformancePay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setForemanPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherSubsidy(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAnnualPerformance(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCostAttribution(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCertificationTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIds(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentSequenceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentName(GenericBase.__getString(val));
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPersonnelBusinessIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setStartDateDetail(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getStartDateDetail() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setEndDateDetail(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getEndDateDetail() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setDays(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getDays() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setReason(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getReason() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setAddress(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getAddress() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setPlan(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getPlan() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setTransportation(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getTransportation() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setFee(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getFee() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setUnit(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getUnit() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setContactPerson(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getContactPerson() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(20, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[20]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setNextAuditor(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getNextAuditor() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setSubType(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getSubType() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setHours(java.math.BigDecimal val) {
		setCurrentData(24, val);
	}

	public java.math.BigDecimal getHours() {
		return GenericBase.__getDecimal(__current_data[24]);
	}

	public void setCompanyProvince(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getCompanyProvince() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setTargetProvince(java.lang.Integer val) {
		setCurrentData(26, val);
	}

	public java.lang.Integer getTargetProvince() {
		return GenericBase.__getInt(__current_data[26]);
	}

	public void setNumberOfBaby(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getNumberOfBaby() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setAttachment(java.lang.String val) {
		setCurrentData(28, val);
	}

	public java.lang.String getAttachment() {
		return GenericBase.__getString(__current_data[28]);
	}

	public void setIsCompleted(java.lang.Boolean val) {
		setCurrentData(29, val);
	}

	public java.lang.Boolean getIsCompleted() {
		return GenericBase.__getBoolean(__current_data[29]);
	}

	public void setSubTypeStr(java.lang.String val) {
		setCurrentData(30, val);
	}

	public java.lang.String getSubTypeStr() {
		return GenericBase.__getString(__current_data[30]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(31, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[31]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(32, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[32]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(33, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[33]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(34, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[34]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(35, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[35]);
	}

	public void setIsRemoteCity(java.lang.Boolean val) {
		setCurrentData(36, val);
	}

	public java.lang.Boolean getIsRemoteCity() {
		return GenericBase.__getBoolean(__current_data[36]);
	}

	public void setProvideAccommodation(java.lang.Boolean val) {
		setCurrentData(37, val);
	}

	public java.lang.Boolean getProvideAccommodation() {
		return GenericBase.__getBoolean(__current_data[37]);
	}

	public void setLivingExpenses(java.math.BigDecimal val) {
		setCurrentData(38, val);
	}

	public java.math.BigDecimal getLivingExpenses() {
		return GenericBase.__getDecimal(__current_data[38]);
	}

	public void setHousingFinance(java.math.BigDecimal val) {
		setCurrentData(39, val);
	}

	public java.math.BigDecimal getHousingFinance() {
		return GenericBase.__getDecimal(__current_data[39]);
	}

	public void setDrafter(java.lang.Integer val) {
		setCurrentData(40, val);
	}

	public java.lang.Integer getDrafter() {
		return GenericBase.__getInt(__current_data[40]);
	}

	public void setCard(java.lang.String val) {
		setCurrentData(41, val);
	}

	public java.lang.String getCard() {
		return GenericBase.__getString(__current_data[41]);
	}

	public void setDutyId(java.lang.Integer val) {
		setCurrentData(42, val);
	}

	public java.lang.Integer getDutyId() {
		return GenericBase.__getInt(__current_data[42]);
	}

	public void setEquivalentNumber(java.lang.String val) {
		setCurrentData(43, val);
	}

	public java.lang.String getEquivalentNumber() {
		return GenericBase.__getString(__current_data[43]);
	}

	public void setLinkId(java.lang.Integer val) {
		setCurrentData(44, val);
	}

	public java.lang.Integer getLinkId() {
		return GenericBase.__getInt(__current_data[44]);
	}

	public void setSeverance(java.math.BigDecimal val) {
		setCurrentData(45, val);
	}

	public java.math.BigDecimal getSeverance() {
		return GenericBase.__getDecimal(__current_data[45]);
	}

	public void setSalary1(java.lang.String val) {
		setCurrentData(46, val);
	}

	public java.lang.String getSalary1() {
		return GenericBase.__getString(__current_data[46]);
	}

	public void setSalary2(java.lang.String val) {
		setCurrentData(47, val);
	}

	public java.lang.String getSalary2() {
		return GenericBase.__getString(__current_data[47]);
	}

	public void setOriginalPay(java.lang.String val) {
		setCurrentData(48, val);
	}

	public java.lang.String getOriginalPay() {
		return GenericBase.__getString(__current_data[48]);
	}

	public void setMonthPay(java.lang.String val) {
		setCurrentData(49, val);
	}

	public java.lang.String getMonthPay() {
		return GenericBase.__getString(__current_data[49]);
	}

	public void setBasicProportionStr(java.lang.String val) {
		setCurrentData(50, val);
	}

	public java.lang.String getBasicProportionStr() {
		return GenericBase.__getString(__current_data[50]);
	}

	public void setBasicProportion(java.math.BigDecimal val) {
		setCurrentData(51, val);
	}

	public java.math.BigDecimal getBasicProportion() {
		return GenericBase.__getDecimal(__current_data[51]);
	}

	public void setMonthBasicPay(java.lang.String val) {
		setCurrentData(52, val);
	}

	public java.lang.String getMonthBasicPay() {
		return GenericBase.__getString(__current_data[52]);
	}

	public void setMonthPerformancePay(java.lang.String val) {
		setCurrentData(53, val);
	}

	public java.lang.String getMonthPerformancePay() {
		return GenericBase.__getString(__current_data[53]);
	}

	public void setForemanPay(java.lang.String val) {
		setCurrentData(54, val);
	}

	public java.lang.String getForemanPay() {
		return GenericBase.__getString(__current_data[54]);
	}

	public void setOtherSubsidy(java.lang.String val) {
		setCurrentData(55, val);
	}

	public java.lang.String getOtherSubsidy() {
		return GenericBase.__getString(__current_data[55]);
	}

	public void setTotalPay(java.lang.String val) {
		setCurrentData(56, val);
	}

	public java.lang.String getTotalPay() {
		return GenericBase.__getString(__current_data[56]);
	}

	public void setAnnualPerformance(java.lang.String val) {
		setCurrentData(57, val);
	}

	public java.lang.String getAnnualPerformance() {
		return GenericBase.__getString(__current_data[57]);
	}

	public void setCostAttribution(java.lang.Integer val) {
		setCurrentData(58, val);
	}

	public java.lang.Integer getCostAttribution() {
		return GenericBase.__getInt(__current_data[58]);
	}

	public void setCertificationTime(java.util.Date val) {
		setCurrentData(59, generateTimestampFromDate(val));
	}

	public java.util.Date getCertificationTime() {
		return GenericBase.__getDateFromSQL(__current_data[59]);
	}

	public void setProjectIds(java.lang.Integer val) {
		setCurrentData(60, val);
	}

	public java.lang.Integer getProjectIds() {
		return GenericBase.__getInt(__current_data[60]);
	}

	public void setPaymentSequenceId(java.lang.Integer val) {
		setCurrentData(61, val);
	}

	public java.lang.Integer getPaymentSequenceId() {
		return GenericBase.__getInt(__current_data[61]);
	}

	public void setBudgetManagementId(java.lang.Integer val) {
		setCurrentData(62, val);
	}

	public java.lang.Integer getBudgetManagementId() {
		return GenericBase.__getInt(__current_data[62]);
	}

	public void setBudgetAttachmentId(java.lang.Integer val) {
		setCurrentData(63, val);
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return GenericBase.__getInt(__current_data[63]);
	}

	public void setStageId(java.lang.Integer val) {
		setCurrentData(64, val);
	}

	public java.lang.Integer getStageId() {
		return GenericBase.__getInt(__current_data[64]);
	}

	public void setAttachmentId(java.lang.Integer val) {
		setCurrentData(65, val);
	}

	public java.lang.Integer getAttachmentId() {
		return GenericBase.__getInt(__current_data[65]);
	}

	public void setAttachmentName(java.lang.String val) {
		setCurrentData(66, val);
	}

	public java.lang.String getAttachmentName() {
		return GenericBase.__getString(__current_data[66]);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionStartDateDetail(String op, java.lang.Integer val) {
		setConditionStartDateDetail(op, val, CONDITION_AND);
	}

	public void setConditionStartDateDetail(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectStartDateDetail(boolean val) {
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

	public void setConditionEndDateDetail(String op, java.lang.Integer val) {
		setConditionEndDateDetail(op, val, CONDITION_AND);
	}

	public void setConditionEndDateDetail(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectEndDateDetail(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionDays(String op, java.math.BigDecimal val) {
		setConditionDays(op, val, CONDITION_AND);
	}

	public void setConditionDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectDays(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionReason(String op, java.lang.String val) {
		setConditionReason(op, val, CONDITION_AND);
	}

	public void setConditionReason(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectReason(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionAddress(String op, java.lang.String val) {
		setConditionAddress(op, val, CONDITION_AND);
	}

	public void setConditionAddress(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectAddress(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionPlan(String op, java.lang.String val) {
		setConditionPlan(op, val, CONDITION_AND);
	}

	public void setConditionPlan(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectPlan(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionTransportation(String op, java.lang.String val) {
		setConditionTransportation(op, val, CONDITION_AND);
	}

	public void setConditionTransportation(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectTransportation(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionFee(String op, java.math.BigDecimal val) {
		setConditionFee(op, val, CONDITION_AND);
	}

	public void setConditionFee(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectFee(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionUnit(String op, java.lang.String val) {
		setConditionUnit(op, val, CONDITION_AND);
	}

	public void setConditionUnit(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectUnit(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionContactPerson(String op, java.lang.String val) {
		setConditionContactPerson(op, val, CONDITION_AND);
	}

	public void setConditionContactPerson(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectContactPerson(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(20, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionNextAuditor(String op, java.lang.Integer val) {
		setConditionNextAuditor(op, val, CONDITION_AND);
	}

	public void setConditionNextAuditor(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectNextAuditor(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionSubType(String op, java.lang.String val) {
		setConditionSubType(op, val, CONDITION_AND);
	}

	public void setConditionSubType(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectSubType(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionHours(String op, java.math.BigDecimal val) {
		setConditionHours(op, val, CONDITION_AND);
	}

	public void setConditionHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectHours(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionCompanyProvince(String op, java.lang.Integer val) {
		setConditionCompanyProvince(op, val, CONDITION_AND);
	}

	public void setConditionCompanyProvince(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectCompanyProvince(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionTargetProvince(String op, java.lang.Integer val) {
		setConditionTargetProvince(op, val, CONDITION_AND);
	}

	public void setConditionTargetProvince(String op, java.lang.Integer val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectTargetProvince(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionNumberOfBaby(String op, java.lang.Integer val) {
		setConditionNumberOfBaby(op, val, CONDITION_AND);
	}

	public void setConditionNumberOfBaby(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectNumberOfBaby(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionAttachment(String op, java.lang.String val) {
		setConditionAttachment(op, val, CONDITION_AND);
	}

	public void setConditionAttachment(String op, java.lang.String val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectAttachment(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val) {
		setConditionIsCompleted(op, val, CONDITION_AND);
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectIsCompleted(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionSubTypeStr(String op, java.lang.String val) {
		setConditionSubTypeStr(op, val, CONDITION_AND);
	}

	public void setConditionSubTypeStr(String op, java.lang.String val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectSubTypeStr(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[35] = val;
	}

	public void setConditionIsRemoteCity(String op, java.lang.Boolean val) {
		setConditionIsRemoteCity(op, val, CONDITION_AND);
	}

	public void setConditionIsRemoteCity(String op, java.lang.Boolean val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectIsRemoteCity(boolean val) {
		__select_flags[36] = val;
	}

	public void setConditionProvideAccommodation(String op, java.lang.Boolean val) {
		setConditionProvideAccommodation(op, val, CONDITION_AND);
	}

	public void setConditionProvideAccommodation(String op, java.lang.Boolean val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectProvideAccommodation(boolean val) {
		__select_flags[37] = val;
	}

	public void setConditionLivingExpenses(String op, java.math.BigDecimal val) {
		setConditionLivingExpenses(op, val, CONDITION_AND);
	}

	public void setConditionLivingExpenses(String op, java.math.BigDecimal val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectLivingExpenses(boolean val) {
		__select_flags[38] = val;
	}

	public void setConditionHousingFinance(String op, java.math.BigDecimal val) {
		setConditionHousingFinance(op, val, CONDITION_AND);
	}

	public void setConditionHousingFinance(String op, java.math.BigDecimal val, String relation) {
		addCondition(39, op, relation, val);
	}

	public void setSelectHousingFinance(boolean val) {
		__select_flags[39] = val;
	}

	public void setConditionDrafter(String op, java.lang.Integer val) {
		setConditionDrafter(op, val, CONDITION_AND);
	}

	public void setConditionDrafter(String op, java.lang.Integer val, String relation) {
		addCondition(40, op, relation, val);
	}

	public void setSelectDrafter(boolean val) {
		__select_flags[40] = val;
	}

	public void setConditionCard(String op, java.lang.String val) {
		setConditionCard(op, val, CONDITION_AND);
	}

	public void setConditionCard(String op, java.lang.String val, String relation) {
		addCondition(41, op, relation, val);
	}

	public void setSelectCard(boolean val) {
		__select_flags[41] = val;
	}

	public void setConditionDutyId(String op, java.lang.Integer val) {
		setConditionDutyId(op, val, CONDITION_AND);
	}

	public void setConditionDutyId(String op, java.lang.Integer val, String relation) {
		addCondition(42, op, relation, val);
	}

	public void setSelectDutyId(boolean val) {
		__select_flags[42] = val;
	}

	public void setConditionEquivalentNumber(String op, java.lang.String val) {
		setConditionEquivalentNumber(op, val, CONDITION_AND);
	}

	public void setConditionEquivalentNumber(String op, java.lang.String val, String relation) {
		addCondition(43, op, relation, val);
	}

	public void setSelectEquivalentNumber(boolean val) {
		__select_flags[43] = val;
	}

	public void setConditionLinkId(String op, java.lang.Integer val) {
		setConditionLinkId(op, val, CONDITION_AND);
	}

	public void setConditionLinkId(String op, java.lang.Integer val, String relation) {
		addCondition(44, op, relation, val);
	}

	public void setSelectLinkId(boolean val) {
		__select_flags[44] = val;
	}

	public void setConditionSeverance(String op, java.math.BigDecimal val) {
		setConditionSeverance(op, val, CONDITION_AND);
	}

	public void setConditionSeverance(String op, java.math.BigDecimal val, String relation) {
		addCondition(45, op, relation, val);
	}

	public void setSelectSeverance(boolean val) {
		__select_flags[45] = val;
	}

	public void setConditionSalary1(String op, java.lang.String val) {
		setConditionSalary1(op, val, CONDITION_AND);
	}

	public void setConditionSalary1(String op, java.lang.String val, String relation) {
		addCondition(46, op, relation, val);
	}

	public void setSelectSalary1(boolean val) {
		__select_flags[46] = val;
	}

	public void setConditionSalary2(String op, java.lang.String val) {
		setConditionSalary2(op, val, CONDITION_AND);
	}

	public void setConditionSalary2(String op, java.lang.String val, String relation) {
		addCondition(47, op, relation, val);
	}

	public void setSelectSalary2(boolean val) {
		__select_flags[47] = val;
	}

	public void setConditionOriginalPay(String op, java.lang.String val) {
		setConditionOriginalPay(op, val, CONDITION_AND);
	}

	public void setConditionOriginalPay(String op, java.lang.String val, String relation) {
		addCondition(48, op, relation, val);
	}

	public void setSelectOriginalPay(boolean val) {
		__select_flags[48] = val;
	}

	public void setConditionMonthPay(String op, java.lang.String val) {
		setConditionMonthPay(op, val, CONDITION_AND);
	}

	public void setConditionMonthPay(String op, java.lang.String val, String relation) {
		addCondition(49, op, relation, val);
	}

	public void setSelectMonthPay(boolean val) {
		__select_flags[49] = val;
	}

	public void setConditionBasicProportionStr(String op, java.lang.String val) {
		setConditionBasicProportionStr(op, val, CONDITION_AND);
	}

	public void setConditionBasicProportionStr(String op, java.lang.String val, String relation) {
		addCondition(50, op, relation, val);
	}

	public void setSelectBasicProportionStr(boolean val) {
		__select_flags[50] = val;
	}

	public void setConditionBasicProportion(String op, java.math.BigDecimal val) {
		setConditionBasicProportion(op, val, CONDITION_AND);
	}

	public void setConditionBasicProportion(String op, java.math.BigDecimal val, String relation) {
		addCondition(51, op, relation, val);
	}

	public void setSelectBasicProportion(boolean val) {
		__select_flags[51] = val;
	}

	public void setConditionMonthBasicPay(String op, java.lang.String val) {
		setConditionMonthBasicPay(op, val, CONDITION_AND);
	}

	public void setConditionMonthBasicPay(String op, java.lang.String val, String relation) {
		addCondition(52, op, relation, val);
	}

	public void setSelectMonthBasicPay(boolean val) {
		__select_flags[52] = val;
	}

	public void setConditionMonthPerformancePay(String op, java.lang.String val) {
		setConditionMonthPerformancePay(op, val, CONDITION_AND);
	}

	public void setConditionMonthPerformancePay(String op, java.lang.String val, String relation) {
		addCondition(53, op, relation, val);
	}

	public void setSelectMonthPerformancePay(boolean val) {
		__select_flags[53] = val;
	}

	public void setConditionForemanPay(String op, java.lang.String val) {
		setConditionForemanPay(op, val, CONDITION_AND);
	}

	public void setConditionForemanPay(String op, java.lang.String val, String relation) {
		addCondition(54, op, relation, val);
	}

	public void setSelectForemanPay(boolean val) {
		__select_flags[54] = val;
	}

	public void setConditionOtherSubsidy(String op, java.lang.String val) {
		setConditionOtherSubsidy(op, val, CONDITION_AND);
	}

	public void setConditionOtherSubsidy(String op, java.lang.String val, String relation) {
		addCondition(55, op, relation, val);
	}

	public void setSelectOtherSubsidy(boolean val) {
		__select_flags[55] = val;
	}

	public void setConditionTotalPay(String op, java.lang.String val) {
		setConditionTotalPay(op, val, CONDITION_AND);
	}

	public void setConditionTotalPay(String op, java.lang.String val, String relation) {
		addCondition(56, op, relation, val);
	}

	public void setSelectTotalPay(boolean val) {
		__select_flags[56] = val;
	}

	public void setConditionAnnualPerformance(String op, java.lang.String val) {
		setConditionAnnualPerformance(op, val, CONDITION_AND);
	}

	public void setConditionAnnualPerformance(String op, java.lang.String val, String relation) {
		addCondition(57, op, relation, val);
	}

	public void setSelectAnnualPerformance(boolean val) {
		__select_flags[57] = val;
	}

	public void setConditionCostAttribution(String op, java.lang.Integer val) {
		setConditionCostAttribution(op, val, CONDITION_AND);
	}

	public void setConditionCostAttribution(String op, java.lang.Integer val, String relation) {
		addCondition(58, op, relation, val);
	}

	public void setSelectCostAttribution(boolean val) {
		__select_flags[58] = val;
	}

	public void setConditionCertificationTime(String op, java.util.Date val) {
		setConditionCertificationTime(op, val, CONDITION_AND);
	}

	public void setConditionCertificationTime(String op, java.util.Date val, String relation) {
		addCondition(59, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCertificationTime(boolean val) {
		__select_flags[59] = val;
	}

	public void setConditionProjectIds(String op, java.lang.Integer val) {
		setConditionProjectIds(op, val, CONDITION_AND);
	}

	public void setConditionProjectIds(String op, java.lang.Integer val, String relation) {
		addCondition(60, op, relation, val);
	}

	public void setSelectProjectIds(boolean val) {
		__select_flags[60] = val;
	}

	public void setConditionPaymentSequenceId(String op, java.lang.Integer val) {
		setConditionPaymentSequenceId(op, val, CONDITION_AND);
	}

	public void setConditionPaymentSequenceId(String op, java.lang.Integer val, String relation) {
		addCondition(61, op, relation, val);
	}

	public void setSelectPaymentSequenceId(boolean val) {
		__select_flags[61] = val;
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val) {
		setConditionBudgetManagementId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetManagementId(String op, java.lang.Integer val, String relation) {
		addCondition(62, op, relation, val);
	}

	public void setSelectBudgetManagementId(boolean val) {
		__select_flags[62] = val;
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val) {
		setConditionBudgetAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionBudgetAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(63, op, relation, val);
	}

	public void setSelectBudgetAttachmentId(boolean val) {
		__select_flags[63] = val;
	}

	public void setConditionStageId(String op, java.lang.Integer val) {
		setConditionStageId(op, val, CONDITION_AND);
	}

	public void setConditionStageId(String op, java.lang.Integer val, String relation) {
		addCondition(64, op, relation, val);
	}

	public void setSelectStageId(boolean val) {
		__select_flags[64] = val;
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val) {
		setConditionAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(65, op, relation, val);
	}

	public void setSelectAttachmentId(boolean val) {
		__select_flags[65] = val;
	}

	public void setConditionAttachmentName(String op, java.lang.String val) {
		setConditionAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(66, op, relation, val);
	}

	public void setSelectAttachmentName(boolean val) {
		__select_flags[66] = val;
	}


}

