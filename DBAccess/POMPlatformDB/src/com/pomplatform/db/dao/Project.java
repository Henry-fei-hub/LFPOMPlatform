package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProject;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Project extends AbstractTable<BaseProject>
{

	public Project() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 63;

		initTables();

		__tableName            = "projects";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProject.CS_PROJECT_ID;
		__column_names[1] = BaseProject.CS_CONTRACT_CODE;
		__column_names[2] = BaseProject.CS_PROJECT_CODE;
		__column_names[3] = BaseProject.CS_PROJECT_NAME;
		__column_names[4] = BaseProject.CS_PROJECT_TYPE;
		__column_names[5] = BaseProject.CS_PLATE_ID;
		__column_names[6] = BaseProject.CS_DESIGN_TYPE;
		__column_names[7] = BaseProject.CS_DEPARTMENT_ID;
		__column_names[8] = BaseProject.CS_DESIGN_PHASE;
		__column_names[9] = BaseProject.CS_PROJECT_LEVEL;
		__column_names[10] = BaseProject.CS_STATUS;
		__column_names[11] = BaseProject.CS_PROJECT_MANAGE_ID;
		__column_names[12] = BaseProject.CS_WORK_HOURS;
		__column_names[13] = BaseProject.CS_PLAN_START_DATE;
		__column_names[14] = BaseProject.CS_PLAN_END_DATE;
		__column_names[15] = BaseProject.CS_START_DATE;
		__column_names[16] = BaseProject.CS_END_DATE;
		__column_names[17] = BaseProject.CS_COMMON_AREA;
		__column_names[18] = BaseProject.CS_LOGISTICS_AREA;
		__column_names[19] = BaseProject.CS_PERCENTAGE;
		__column_names[20] = BaseProject.CS_OLD_PROJECT_DISCOUNT;
		__column_names[21] = BaseProject.CS_BUDGET;
		__column_names[22] = BaseProject.CS_TOTAL_INTEGRAL;
		__column_names[23] = BaseProject.CS_RESERVE_INTEGRAL;
		__column_names[24] = BaseProject.CS_TOTAL_AMOUNT;
		__column_names[25] = BaseProject.CS_PROJECT_INTEGRAL;
		__column_names[26] = BaseProject.CS_PROJECT_PROGRESS;
		__column_names[27] = BaseProject.CS_PROJECT_SIZE;
		__column_names[28] = BaseProject.CS_PROJECT_DESCRIPTION;
		__column_names[29] = BaseProject.CS_AUDIT_REASON;
		__column_names[30] = BaseProject.CS_DEPARTMENT_MANAGER_ID;
		__column_names[31] = BaseProject.CS_BIM_AREA;
		__column_names[32] = BaseProject.CS_CAD_AREA;
		__column_names[33] = BaseProject.CS_HUMAN_AMOUNT;
		__column_names[34] = BaseProject.CS_APPEND_TOTAL_INTEGRAL;
		__column_names[35] = BaseProject.CS_APPEND_INTEGRAL;
		__column_names[36] = BaseProject.CS_REMARK;
		__column_names[37] = BaseProject.CS_PROJECT_FINISH_PERCENT;
		__column_names[38] = BaseProject.CS_PARENT_ID;
		__column_names[39] = BaseProject.CS_TOTAL_FINISH_PERCENT;
		__column_names[40] = BaseProject.CS_PROJECT_GRADE_TYPE;
		__column_names[41] = BaseProject.CS_PLATE_MANAGER_ID;
		__column_names[42] = BaseProject.CS_LAST_PERCENT;
		__column_names[43] = BaseProject.CS_COMPLAINT_PERCENTAGE;
		__column_names[44] = BaseProject.CS_COMPLAINT_INTEGRAL;
		__column_names[45] = BaseProject.CS_REVENUE_PLATE_ID;
		__column_names[46] = BaseProject.CS_SHEET_AMOUNT;
		__column_names[47] = BaseProject.CS_CREATE_TIME;
		__column_names[48] = BaseProject.CS_PROJECT_FLAG;
		__column_names[49] = BaseProject.CS_BUSINESS_TYPE;
		__column_names[50] = BaseProject.CS_CONTRACT_ID;
		__column_names[51] = BaseProject.CS_SUB_CONTRACT_ID;
		__column_names[52] = BaseProject.CS_IS_ECMC_PROJECT;
		__column_names[53] = BaseProject.CS_MONEY_SUM;
		__column_names[54] = BaseProject.CS_PROJECT_SETUP_FLAG;
		__column_names[55] = BaseProject.CS_IS_LOCK;
		__column_names[56] = BaseProject.CS_IS_AUTO;
		__column_names[57] = BaseProject.CS_TIME_CYCLE;
		__column_names[58] = BaseProject.CS_RESERVE_SHEET_ID;
		__column_names[59] = BaseProject.CS_BUSINESS_LINE;
		__column_names[60] = BaseProject.CS_PRICING_TYPE;
		__column_names[61] = BaseProject.CS_IS_HAS_PRICE;
		__column_names[62] = BaseProject.CS_COMMISSION_RATE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProject b) {
		clear();
		setProjectIdClear(b.getProjectId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectId() == null;
	}

	@Override
	public BaseProject generateBase(){
		BaseProject b = new BaseProject();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProject b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDesignType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDesignPhase(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkHours(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPercentage(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOldProjectDiscount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBudget(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectProgress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectSize(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectDescription(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAuditReason(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBimArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCadArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHumanAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAppendTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAppendIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectFinishPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalFinishPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectGradeType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLastPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setComplaintPercentage(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRevenuePlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setProjectFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsEcmcProject(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectSetupFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsLock(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsAuto(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setTimeCycle(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReserveSheetId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessLine(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPricingType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsHasPrice(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCommissionRate(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseProject b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getDesignType();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getDesignPhase();
		buff[count++] = b.getProjectLevel();
		buff[count++] = b.getStatus();
		buff[count++] = b.getProjectManageId();
		buff[count++] = b.getWorkHours();
		buff[count++] = generateTimestampFromDate(b.getPlanStartDate());
		buff[count++] = generateTimestampFromDate(b.getPlanEndDate());
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getCommonArea();
		buff[count++] = b.getLogisticsArea();
		buff[count++] = b.getPercentage();
		buff[count++] = b.getOldProjectDiscount();
		buff[count++] = b.getBudget();
		buff[count++] = b.getTotalIntegral();
		buff[count++] = b.getReserveIntegral();
		buff[count++] = b.getTotalAmount();
		buff[count++] = b.getProjectIntegral();
		buff[count++] = b.getProjectProgress();
		buff[count++] = b.getProjectSize();
		buff[count++] = b.getProjectDescription();
		buff[count++] = b.getAuditReason();
		buff[count++] = b.getDepartmentManagerId();
		buff[count++] = b.getBimArea();
		buff[count++] = b.getCadArea();
		buff[count++] = b.getHumanAmount();
		buff[count++] = b.getAppendTotalIntegral();
		buff[count++] = b.getAppendIntegral();
		buff[count++] = b.getRemark();
		buff[count++] = b.getProjectFinishPercent();
		buff[count++] = b.getParentId();
		buff[count++] = b.getTotalFinishPercent();
		buff[count++] = b.getProjectGradeType();
		buff[count++] = b.getPlateManagerId();
		buff[count++] = b.getLastPercent();
		buff[count++] = b.getComplaintPercentage();
		buff[count++] = b.getComplaintIntegral();
		buff[count++] = b.getRevenuePlateId();
		buff[count++] = b.getSheetAmount();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getProjectFlag();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getContractId();
		buff[count++] = b.getSubContractId();
		buff[count++] = b.getIsEcmcProject();
		buff[count++] = b.getMoneySum();
		buff[count++] = b.getProjectSetupFlag();
		buff[count++] = b.getIsLock();
		buff[count++] = b.getIsAuto();
		buff[count++] = b.getTimeCycle();
		buff[count++] = b.getReserveSheetId();
		buff[count++] = b.getBusinessLine();
		buff[count++] = b.getPricingType();
		buff[count++] = b.getIsHasPrice();
		buff[count++] = b.getCommissionRate();
	}

	@Override
	public void setDataFromBase(BaseProject b){
		if(b.getProjectId() != null) setProjectIdClear(b.getProjectId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getDesignType() != null) setDesignType(b.getDesignType());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getDesignPhase() != null) setDesignPhase(b.getDesignPhase());
		if(b.getProjectLevel() != null) setProjectLevel(b.getProjectLevel());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getProjectManageId() != null) setProjectManageId(b.getProjectManageId());
		if(b.getWorkHours() != null) setWorkHours(b.getWorkHours());
		if(b.getPlanStartDate() != null) setPlanStartDate(b.getPlanStartDate());
		if(b.getPlanEndDate() != null) setPlanEndDate(b.getPlanEndDate());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getCommonArea() != null) setCommonArea(b.getCommonArea());
		if(b.getLogisticsArea() != null) setLogisticsArea(b.getLogisticsArea());
		if(b.getPercentage() != null) setPercentage(b.getPercentage());
		if(b.getOldProjectDiscount() != null) setOldProjectDiscount(b.getOldProjectDiscount());
		if(b.getBudget() != null) setBudget(b.getBudget());
		if(b.getTotalIntegral() != null) setTotalIntegral(b.getTotalIntegral());
		if(b.getReserveIntegral() != null) setReserveIntegral(b.getReserveIntegral());
		if(b.getTotalAmount() != null) setTotalAmount(b.getTotalAmount());
		if(b.getProjectIntegral() != null) setProjectIntegral(b.getProjectIntegral());
		if(b.getProjectProgress() != null) setProjectProgress(b.getProjectProgress());
		if(b.getProjectSize() != null) setProjectSize(b.getProjectSize());
		if(b.getProjectDescription() != null) setProjectDescription(b.getProjectDescription());
		if(b.getAuditReason() != null) setAuditReason(b.getAuditReason());
		if(b.getDepartmentManagerId() != null) setDepartmentManagerId(b.getDepartmentManagerId());
		if(b.getBimArea() != null) setBimArea(b.getBimArea());
		if(b.getCadArea() != null) setCadArea(b.getCadArea());
		if(b.getHumanAmount() != null) setHumanAmount(b.getHumanAmount());
		if(b.getAppendTotalIntegral() != null) setAppendTotalIntegral(b.getAppendTotalIntegral());
		if(b.getAppendIntegral() != null) setAppendIntegral(b.getAppendIntegral());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getProjectFinishPercent() != null) setProjectFinishPercent(b.getProjectFinishPercent());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getTotalFinishPercent() != null) setTotalFinishPercent(b.getTotalFinishPercent());
		if(b.getProjectGradeType() != null) setProjectGradeType(b.getProjectGradeType());
		if(b.getPlateManagerId() != null) setPlateManagerId(b.getPlateManagerId());
		if(b.getLastPercent() != null) setLastPercent(b.getLastPercent());
		if(b.getComplaintPercentage() != null) setComplaintPercentage(b.getComplaintPercentage());
		if(b.getComplaintIntegral() != null) setComplaintIntegral(b.getComplaintIntegral());
		if(b.getRevenuePlateId() != null) setRevenuePlateId(b.getRevenuePlateId());
		if(b.getSheetAmount() != null) setSheetAmount(b.getSheetAmount());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getProjectFlag() != null) setProjectFlag(b.getProjectFlag());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getSubContractId() != null) setSubContractId(b.getSubContractId());
		if(b.getIsEcmcProject() != null) setIsEcmcProject(b.getIsEcmcProject());
		if(b.getMoneySum() != null) setMoneySum(b.getMoneySum());
		if(b.getProjectSetupFlag() != null) setProjectSetupFlag(b.getProjectSetupFlag());
		if(b.getIsLock() != null) setIsLock(b.getIsLock());
		if(b.getIsAuto() != null) setIsAuto(b.getIsAuto());
		if(b.getTimeCycle() != null) setTimeCycle(b.getTimeCycle());
		if(b.getReserveSheetId() != null) setReserveSheetId(b.getReserveSheetId());
		if(b.getBusinessLine() != null) setBusinessLine(b.getBusinessLine());
		if(b.getPricingType() != null) setPricingType(b.getPricingType());
		if(b.getIsHasPrice() != null) setIsHasPrice(b.getIsHasPrice());
		if(b.getCommissionRate() != null) setCommissionRate(b.getCommissionRate());
	}

	@Override
	public BaseProject generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProject b = new BaseProject();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProject __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkHours(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercentage(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOldProjectDiscount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBudget(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectProgress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectSize(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectDescription(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAuditReason(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBimArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCadArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHumanAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAppendTotalIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAppendIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectFinishPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalFinishPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectGradeType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLastPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComplaintPercentage(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRevenuePlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEcmcProject(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectSetupFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLock(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsAuto(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTimeCycle(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReserveSheetId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessLine(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPricingType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsHasPrice(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCommissionRate(GenericBase.__getDecimal(val));
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setDesignType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getDesignType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setDesignPhase(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getDesignPhase() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setProjectLevel(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getProjectLevel() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setProjectManageId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getProjectManageId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setWorkHours(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getWorkHours() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setPlanStartDate(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getPlanStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setPlanEndDate(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getPlanEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setCommonArea(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getCommonArea() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setLogisticsArea(java.math.BigDecimal val) {
		setCurrentData(18, val);
	}

	public java.math.BigDecimal getLogisticsArea() {
		return GenericBase.__getDecimal(__current_data[18]);
	}

	public void setPercentage(java.math.BigDecimal val) {
		setCurrentData(19, val);
	}

	public java.math.BigDecimal getPercentage() {
		return GenericBase.__getDecimal(__current_data[19]);
	}

	public void setOldProjectDiscount(java.math.BigDecimal val) {
		setCurrentData(20, val);
	}

	public java.math.BigDecimal getOldProjectDiscount() {
		return GenericBase.__getDecimal(__current_data[20]);
	}

	public void setBudget(java.math.BigDecimal val) {
		setCurrentData(21, val);
	}

	public java.math.BigDecimal getBudget() {
		return GenericBase.__getDecimal(__current_data[21]);
	}

	public void setTotalIntegral(java.math.BigDecimal val) {
		setCurrentData(22, val);
	}

	public java.math.BigDecimal getTotalIntegral() {
		return GenericBase.__getDecimal(__current_data[22]);
	}

	public void setReserveIntegral(java.math.BigDecimal val) {
		setCurrentData(23, val);
	}

	public java.math.BigDecimal getReserveIntegral() {
		return GenericBase.__getDecimal(__current_data[23]);
	}

	public void setTotalAmount(java.math.BigDecimal val) {
		setCurrentData(24, val);
	}

	public java.math.BigDecimal getTotalAmount() {
		return GenericBase.__getDecimal(__current_data[24]);
	}

	public void setProjectIntegral(java.math.BigDecimal val) {
		setCurrentData(25, val);
	}

	public java.math.BigDecimal getProjectIntegral() {
		return GenericBase.__getDecimal(__current_data[25]);
	}

	public void setProjectProgress(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getProjectProgress() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setProjectSize(java.lang.String val) {
		setCurrentData(27, val);
	}

	public java.lang.String getProjectSize() {
		return GenericBase.__getString(__current_data[27]);
	}

	public void setProjectDescription(java.lang.String val) {
		setCurrentData(28, val);
	}

	public java.lang.String getProjectDescription() {
		return GenericBase.__getString(__current_data[28]);
	}

	public void setAuditReason(java.lang.String val) {
		setCurrentData(29, val);
	}

	public java.lang.String getAuditReason() {
		return GenericBase.__getString(__current_data[29]);
	}

	public void setDepartmentManagerId(java.lang.Integer val) {
		setCurrentData(30, val);
	}

	public java.lang.Integer getDepartmentManagerId() {
		return GenericBase.__getInt(__current_data[30]);
	}

	public void setBimArea(java.math.BigDecimal val) {
		setCurrentData(31, val);
	}

	public java.math.BigDecimal getBimArea() {
		return GenericBase.__getDecimal(__current_data[31]);
	}

	public void setCadArea(java.math.BigDecimal val) {
		setCurrentData(32, val);
	}

	public java.math.BigDecimal getCadArea() {
		return GenericBase.__getDecimal(__current_data[32]);
	}

	public void setHumanAmount(java.math.BigDecimal val) {
		setCurrentData(33, val);
	}

	public java.math.BigDecimal getHumanAmount() {
		return GenericBase.__getDecimal(__current_data[33]);
	}

	public void setAppendTotalIntegral(java.math.BigDecimal val) {
		setCurrentData(34, val);
	}

	public java.math.BigDecimal getAppendTotalIntegral() {
		return GenericBase.__getDecimal(__current_data[34]);
	}

	public void setAppendIntegral(java.math.BigDecimal val) {
		setCurrentData(35, val);
	}

	public java.math.BigDecimal getAppendIntegral() {
		return GenericBase.__getDecimal(__current_data[35]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(36, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[36]);
	}

	public void setProjectFinishPercent(java.math.BigDecimal val) {
		setCurrentData(37, val);
	}

	public java.math.BigDecimal getProjectFinishPercent() {
		return GenericBase.__getDecimal(__current_data[37]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(38, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[38]);
	}

	public void setTotalFinishPercent(java.math.BigDecimal val) {
		setCurrentData(39, val);
	}

	public java.math.BigDecimal getTotalFinishPercent() {
		return GenericBase.__getDecimal(__current_data[39]);
	}

	public void setProjectGradeType(java.lang.Integer val) {
		setCurrentData(40, val);
	}

	public java.lang.Integer getProjectGradeType() {
		return GenericBase.__getInt(__current_data[40]);
	}

	public void setPlateManagerId(java.lang.Integer val) {
		setCurrentData(41, val);
	}

	public java.lang.Integer getPlateManagerId() {
		return GenericBase.__getInt(__current_data[41]);
	}

	public void setLastPercent(java.math.BigDecimal val) {
		setCurrentData(42, val);
	}

	public java.math.BigDecimal getLastPercent() {
		return GenericBase.__getDecimal(__current_data[42]);
	}

	public void setComplaintPercentage(java.math.BigDecimal val) {
		setCurrentData(43, val);
	}

	public java.math.BigDecimal getComplaintPercentage() {
		return GenericBase.__getDecimal(__current_data[43]);
	}

	public void setComplaintIntegral(java.math.BigDecimal val) {
		setCurrentData(44, val);
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return GenericBase.__getDecimal(__current_data[44]);
	}

	public void setRevenuePlateId(java.lang.Integer val) {
		setCurrentData(45, val);
	}

	public java.lang.Integer getRevenuePlateId() {
		return GenericBase.__getInt(__current_data[45]);
	}

	public void setSheetAmount(java.math.BigDecimal val) {
		setCurrentData(46, val);
	}

	public java.math.BigDecimal getSheetAmount() {
		return GenericBase.__getDecimal(__current_data[46]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(47, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[47]);
	}

	public void setProjectFlag(java.lang.Integer val) {
		setCurrentData(48, val);
	}

	public java.lang.Integer getProjectFlag() {
		return GenericBase.__getInt(__current_data[48]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(49, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[49]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(50, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[50]);
	}

	public void setSubContractId(java.lang.Integer val) {
		setCurrentData(51, val);
	}

	public java.lang.Integer getSubContractId() {
		return GenericBase.__getInt(__current_data[51]);
	}

	public void setIsEcmcProject(java.lang.Boolean val) {
		setCurrentData(52, val);
	}

	public java.lang.Boolean getIsEcmcProject() {
		return GenericBase.__getBoolean(__current_data[52]);
	}

	public void setMoneySum(java.math.BigDecimal val) {
		setCurrentData(53, val);
	}

	public java.math.BigDecimal getMoneySum() {
		return GenericBase.__getDecimal(__current_data[53]);
	}

	public void setProjectSetupFlag(java.lang.Integer val) {
		setCurrentData(54, val);
	}

	public java.lang.Integer getProjectSetupFlag() {
		return GenericBase.__getInt(__current_data[54]);
	}

	public void setIsLock(java.lang.Boolean val) {
		setCurrentData(55, val);
	}

	public java.lang.Boolean getIsLock() {
		return GenericBase.__getBoolean(__current_data[55]);
	}

	public void setIsAuto(java.lang.Boolean val) {
		setCurrentData(56, val);
	}

	public java.lang.Boolean getIsAuto() {
		return GenericBase.__getBoolean(__current_data[56]);
	}

	public void setTimeCycle(java.lang.Integer val) {
		setCurrentData(57, val);
	}

	public java.lang.Integer getTimeCycle() {
		return GenericBase.__getInt(__current_data[57]);
	}

	public void setReserveSheetId(java.lang.Integer val) {
		setCurrentData(58, val);
	}

	public java.lang.Integer getReserveSheetId() {
		return GenericBase.__getInt(__current_data[58]);
	}

	public void setBusinessLine(java.lang.Integer val) {
		setCurrentData(59, val);
	}

	public java.lang.Integer getBusinessLine() {
		return GenericBase.__getInt(__current_data[59]);
	}

	public void setPricingType(java.lang.Integer val) {
		setCurrentData(60, val);
	}

	public java.lang.Integer getPricingType() {
		return GenericBase.__getInt(__current_data[60]);
	}

	public void setIsHasPrice(java.lang.Boolean val) {
		setCurrentData(61, val);
	}

	public java.lang.Boolean getIsHasPrice() {
		return GenericBase.__getBoolean(__current_data[61]);
	}

	public void setCommissionRate(java.math.BigDecimal val) {
		setCurrentData(62, val);
	}

	public java.math.BigDecimal getCommissionRate() {
		return GenericBase.__getDecimal(__current_data[62]);
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
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

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDesignType(String op, java.lang.Integer val) {
		setConditionDesignType(op, val, CONDITION_AND);
	}

	public void setConditionDesignType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDesignType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionDesignPhase(String op, java.lang.Integer val) {
		setConditionDesignPhase(op, val, CONDITION_AND);
	}

	public void setConditionDesignPhase(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectDesignPhase(boolean val) {
		__select_flags[8] = val;
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

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val) {
		setConditionProjectManageId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectProjectManageId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionWorkHours(String op, java.lang.Integer val) {
		setConditionWorkHours(op, val, CONDITION_AND);
	}

	public void setConditionWorkHours(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectWorkHours(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionPlanStartDate(String op, java.util.Date val) {
		setConditionPlanStartDate(op, val, CONDITION_AND);
	}

	public void setConditionPlanStartDate(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPlanStartDate(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionPlanEndDate(String op, java.util.Date val) {
		setConditionPlanEndDate(op, val, CONDITION_AND);
	}

	public void setConditionPlanEndDate(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPlanEndDate(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCommonArea(String op, java.math.BigDecimal val) {
		setConditionCommonArea(op, val, CONDITION_AND);
	}

	public void setConditionCommonArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectCommonArea(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionLogisticsArea(String op, java.math.BigDecimal val) {
		setConditionLogisticsArea(op, val, CONDITION_AND);
	}

	public void setConditionLogisticsArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectLogisticsArea(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionPercentage(String op, java.math.BigDecimal val) {
		setConditionPercentage(op, val, CONDITION_AND);
	}

	public void setConditionPercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectPercentage(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionOldProjectDiscount(String op, java.math.BigDecimal val) {
		setConditionOldProjectDiscount(op, val, CONDITION_AND);
	}

	public void setConditionOldProjectDiscount(String op, java.math.BigDecimal val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectOldProjectDiscount(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionBudget(String op, java.math.BigDecimal val) {
		setConditionBudget(op, val, CONDITION_AND);
	}

	public void setConditionBudget(String op, java.math.BigDecimal val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectBudget(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionTotalIntegral(String op, java.math.BigDecimal val) {
		setConditionTotalIntegral(op, val, CONDITION_AND);
	}

	public void setConditionTotalIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectTotalIntegral(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionReserveIntegral(String op, java.math.BigDecimal val) {
		setConditionReserveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionReserveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectReserveIntegral(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val) {
		setConditionTotalAmount(op, val, CONDITION_AND);
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectTotalAmount(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionProjectIntegral(String op, java.math.BigDecimal val) {
		setConditionProjectIntegral(op, val, CONDITION_AND);
	}

	public void setConditionProjectIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectProjectIntegral(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionProjectProgress(String op, java.lang.String val) {
		setConditionProjectProgress(op, val, CONDITION_AND);
	}

	public void setConditionProjectProgress(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectProjectProgress(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionProjectSize(String op, java.lang.String val) {
		setConditionProjectSize(op, val, CONDITION_AND);
	}

	public void setConditionProjectSize(String op, java.lang.String val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectProjectSize(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionProjectDescription(String op, java.lang.String val) {
		setConditionProjectDescription(op, val, CONDITION_AND);
	}

	public void setConditionProjectDescription(String op, java.lang.String val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectProjectDescription(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionAuditReason(String op, java.lang.String val) {
		setConditionAuditReason(op, val, CONDITION_AND);
	}

	public void setConditionAuditReason(String op, java.lang.String val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectAuditReason(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionDepartmentManagerId(String op, java.lang.Integer val) {
		setConditionDepartmentManagerId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentManagerId(String op, java.lang.Integer val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectDepartmentManagerId(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionBimArea(String op, java.math.BigDecimal val) {
		setConditionBimArea(op, val, CONDITION_AND);
	}

	public void setConditionBimArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectBimArea(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionCadArea(String op, java.math.BigDecimal val) {
		setConditionCadArea(op, val, CONDITION_AND);
	}

	public void setConditionCadArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectCadArea(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionHumanAmount(String op, java.math.BigDecimal val) {
		setConditionHumanAmount(op, val, CONDITION_AND);
	}

	public void setConditionHumanAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectHumanAmount(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionAppendTotalIntegral(String op, java.math.BigDecimal val) {
		setConditionAppendTotalIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAppendTotalIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectAppendTotalIntegral(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionAppendIntegral(String op, java.math.BigDecimal val) {
		setConditionAppendIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAppendIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectAppendIntegral(boolean val) {
		__select_flags[35] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[36] = val;
	}

	public void setConditionProjectFinishPercent(String op, java.math.BigDecimal val) {
		setConditionProjectFinishPercent(op, val, CONDITION_AND);
	}

	public void setConditionProjectFinishPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectProjectFinishPercent(boolean val) {
		__select_flags[37] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[38] = val;
	}

	public void setConditionTotalFinishPercent(String op, java.math.BigDecimal val) {
		setConditionTotalFinishPercent(op, val, CONDITION_AND);
	}

	public void setConditionTotalFinishPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(39, op, relation, val);
	}

	public void setSelectTotalFinishPercent(boolean val) {
		__select_flags[39] = val;
	}

	public void setConditionProjectGradeType(String op, java.lang.Integer val) {
		setConditionProjectGradeType(op, val, CONDITION_AND);
	}

	public void setConditionProjectGradeType(String op, java.lang.Integer val, String relation) {
		addCondition(40, op, relation, val);
	}

	public void setSelectProjectGradeType(boolean val) {
		__select_flags[40] = val;
	}

	public void setConditionPlateManagerId(String op, java.lang.Integer val) {
		setConditionPlateManagerId(op, val, CONDITION_AND);
	}

	public void setConditionPlateManagerId(String op, java.lang.Integer val, String relation) {
		addCondition(41, op, relation, val);
	}

	public void setSelectPlateManagerId(boolean val) {
		__select_flags[41] = val;
	}

	public void setConditionLastPercent(String op, java.math.BigDecimal val) {
		setConditionLastPercent(op, val, CONDITION_AND);
	}

	public void setConditionLastPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(42, op, relation, val);
	}

	public void setSelectLastPercent(boolean val) {
		__select_flags[42] = val;
	}

	public void setConditionComplaintPercentage(String op, java.math.BigDecimal val) {
		setConditionComplaintPercentage(op, val, CONDITION_AND);
	}

	public void setConditionComplaintPercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(43, op, relation, val);
	}

	public void setSelectComplaintPercentage(boolean val) {
		__select_flags[43] = val;
	}

	public void setConditionComplaintIntegral(String op, java.math.BigDecimal val) {
		setConditionComplaintIntegral(op, val, CONDITION_AND);
	}

	public void setConditionComplaintIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(44, op, relation, val);
	}

	public void setSelectComplaintIntegral(boolean val) {
		__select_flags[44] = val;
	}

	public void setConditionRevenuePlateId(String op, java.lang.Integer val) {
		setConditionRevenuePlateId(op, val, CONDITION_AND);
	}

	public void setConditionRevenuePlateId(String op, java.lang.Integer val, String relation) {
		addCondition(45, op, relation, val);
	}

	public void setSelectRevenuePlateId(boolean val) {
		__select_flags[45] = val;
	}

	public void setConditionSheetAmount(String op, java.math.BigDecimal val) {
		setConditionSheetAmount(op, val, CONDITION_AND);
	}

	public void setConditionSheetAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(46, op, relation, val);
	}

	public void setSelectSheetAmount(boolean val) {
		__select_flags[46] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(47, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[47] = val;
	}

	public void setConditionProjectFlag(String op, java.lang.Integer val) {
		setConditionProjectFlag(op, val, CONDITION_AND);
	}

	public void setConditionProjectFlag(String op, java.lang.Integer val, String relation) {
		addCondition(48, op, relation, val);
	}

	public void setSelectProjectFlag(boolean val) {
		__select_flags[48] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(49, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[49] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(50, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[50] = val;
	}

	public void setConditionSubContractId(String op, java.lang.Integer val) {
		setConditionSubContractId(op, val, CONDITION_AND);
	}

	public void setConditionSubContractId(String op, java.lang.Integer val, String relation) {
		addCondition(51, op, relation, val);
	}

	public void setSelectSubContractId(boolean val) {
		__select_flags[51] = val;
	}

	public void setConditionIsEcmcProject(String op, java.lang.Boolean val) {
		setConditionIsEcmcProject(op, val, CONDITION_AND);
	}

	public void setConditionIsEcmcProject(String op, java.lang.Boolean val, String relation) {
		addCondition(52, op, relation, val);
	}

	public void setSelectIsEcmcProject(boolean val) {
		__select_flags[52] = val;
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val) {
		setConditionMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(53, op, relation, val);
	}

	public void setSelectMoneySum(boolean val) {
		__select_flags[53] = val;
	}

	public void setConditionProjectSetupFlag(String op, java.lang.Integer val) {
		setConditionProjectSetupFlag(op, val, CONDITION_AND);
	}

	public void setConditionProjectSetupFlag(String op, java.lang.Integer val, String relation) {
		addCondition(54, op, relation, val);
	}

	public void setSelectProjectSetupFlag(boolean val) {
		__select_flags[54] = val;
	}

	public void setConditionIsLock(String op, java.lang.Boolean val) {
		setConditionIsLock(op, val, CONDITION_AND);
	}

	public void setConditionIsLock(String op, java.lang.Boolean val, String relation) {
		addCondition(55, op, relation, val);
	}

	public void setSelectIsLock(boolean val) {
		__select_flags[55] = val;
	}

	public void setConditionIsAuto(String op, java.lang.Boolean val) {
		setConditionIsAuto(op, val, CONDITION_AND);
	}

	public void setConditionIsAuto(String op, java.lang.Boolean val, String relation) {
		addCondition(56, op, relation, val);
	}

	public void setSelectIsAuto(boolean val) {
		__select_flags[56] = val;
	}

	public void setConditionTimeCycle(String op, java.lang.Integer val) {
		setConditionTimeCycle(op, val, CONDITION_AND);
	}

	public void setConditionTimeCycle(String op, java.lang.Integer val, String relation) {
		addCondition(57, op, relation, val);
	}

	public void setSelectTimeCycle(boolean val) {
		__select_flags[57] = val;
	}

	public void setConditionReserveSheetId(String op, java.lang.Integer val) {
		setConditionReserveSheetId(op, val, CONDITION_AND);
	}

	public void setConditionReserveSheetId(String op, java.lang.Integer val, String relation) {
		addCondition(58, op, relation, val);
	}

	public void setSelectReserveSheetId(boolean val) {
		__select_flags[58] = val;
	}

	public void setConditionBusinessLine(String op, java.lang.Integer val) {
		setConditionBusinessLine(op, val, CONDITION_AND);
	}

	public void setConditionBusinessLine(String op, java.lang.Integer val, String relation) {
		addCondition(59, op, relation, val);
	}

	public void setSelectBusinessLine(boolean val) {
		__select_flags[59] = val;
	}

	public void setConditionPricingType(String op, java.lang.Integer val) {
		setConditionPricingType(op, val, CONDITION_AND);
	}

	public void setConditionPricingType(String op, java.lang.Integer val, String relation) {
		addCondition(60, op, relation, val);
	}

	public void setSelectPricingType(boolean val) {
		__select_flags[60] = val;
	}

	public void setConditionIsHasPrice(String op, java.lang.Boolean val) {
		setConditionIsHasPrice(op, val, CONDITION_AND);
	}

	public void setConditionIsHasPrice(String op, java.lang.Boolean val, String relation) {
		addCondition(61, op, relation, val);
	}

	public void setSelectIsHasPrice(boolean val) {
		__select_flags[61] = val;
	}

	public void setConditionCommissionRate(String op, java.math.BigDecimal val) {
		setConditionCommissionRate(op, val, CONDITION_AND);
	}

	public void setConditionCommissionRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(62, op, relation, val);
	}

	public void setSelectCommissionRate(boolean val) {
		__select_flags[62] = val;
	}


}

