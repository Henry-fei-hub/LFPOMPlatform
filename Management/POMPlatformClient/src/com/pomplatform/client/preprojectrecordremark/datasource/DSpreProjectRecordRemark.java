package com.pomplatform.client.preprojectrecordremark.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSpreProjectRecordRemark extends DBDataSource
{


	public static DSpreProjectRecordRemark instance = null;

	public static DSpreProjectRecordRemark getInstance() {
		if(instance == null) {
			instance = new DSpreProjectRecordRemark("DSpreProjectRecordRemark");
		}
		return instance;
	}

	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateTimeField registerDateField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceTextField isOriginalField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField gradeField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceFloatField estimateTheDesignAreasField;
	private final DataSourceTextField designPriceField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceDateField trackDateField;
	private final DataSourceTextField projectRecordRemarkField;
	private final DataSourceTextField competitiveUnitField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceTextField projectOriginationRemarkField;
	private final DataSourceTextField projectLeaderField;
	private final DataSourceTextField projectManagerField;
	private final DataSourceTextField winRateField;

	public DSpreProjectRecordRemark(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("preProjectRecordRemark");

		departmentIdField = new DataSourceIntegerField("departmentId", "项目营销团队");
		departmentIdField.setLength(11);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		
		
		
		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "报备人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(false);


		registerDateField = new DataSourceDateTimeField("registerDate", "登记时间");
		registerDateField.setRequired(true);
		registerDateField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setLength(512);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);


		isOriginalField = new DataSourceTextField("isOriginal", "是否原创");
		isOriginalField.setLength(-1);
		isOriginalField.setRequired(true);
		isOriginalField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		provinceField = new DataSourceTextField("province", "项目地址（省）");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceTextField("city", "项目地址（市）");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(false);


		contactNameField = new DataSourceTextField("contactName", "联系人");
		contactNameField.setLength(64);
		contactNameField.setRequired(false);
		contactNameField.setHidden(false);


		gradeField = new DataSourceTextField("grade", "职务");
		gradeField.setLength(64);
		gradeField.setRequired(false);
		gradeField.setHidden(false);


		contactPhoneField = new DataSourceTextField("contactPhone", "电话");
		contactPhoneField.setLength(128);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(false);


		estimateTheDesignAreasField = new DataSourceFloatField("estimateTheDesignAreas", "计容建筑面积(㎡)");
		estimateTheDesignAreasField.setLength(18);
		estimateTheDesignAreasField.setDecimalPad(2);
		estimateTheDesignAreasField.setFormat("#,###,###,###,###,##0.00");
		estimateTheDesignAreasField.setRequired(false);
		estimateTheDesignAreasField.setHidden(false);


		designPriceField = new DataSourceTextField("designPrice", "设计详细报价");
		designPriceField.setLength(512);
		designPriceField.setRequired(false);
		designPriceField.setHidden(false);


		contractAmountField = new DataSourceFloatField("contractAmount", "预估合同金额");
		contractAmountField.setLength(18);
		contractAmountField.setDecimalPad(2);
		contractAmountField.setFormat("#,###,###,###,###,##0.00");
		contractAmountField.setRequired(false);
		contractAmountField.setHidden(false);


		trackDateField = new DataSourceDateField("trackDate", "跟踪时间");
		trackDateField.setRequired(false);
		trackDateField.setHidden(false);


		projectRecordRemarkField = new DataSourceTextField("projectRecordRemark", "项目跟踪记录");
		projectRecordRemarkField.setLength(-1);
		projectRecordRemarkField.setRequired(true);
		projectRecordRemarkField.setHidden(false);


		competitiveUnitField = new DataSourceTextField("competitiveUnit", "竞争单位");
		competitiveUnitField.setLength(-1);
		competitiveUnitField.setRequired(true);
		competitiveUnitField.setHidden(false);


		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(false);


		projectOriginationRemarkField = new DataSourceTextField("projectOriginationRemark", "项目来源说明");
		projectOriginationRemarkField.setLength(2048);
		projectOriginationRemarkField.setRequired(false);
		projectOriginationRemarkField.setHidden(false);


		projectLeaderField = new DataSourceTextField("projectLeader", "项目主管领导");
		projectLeaderField.setLength(-1);
		projectLeaderField.setRequired(true);
		projectLeaderField.setHidden(false);


		projectManagerField = new DataSourceTextField("projectManager", "项目经理");
		projectManagerField.setLength(-1);
		projectManagerField.setRequired(true);
		projectManagerField.setHidden(false);


		winRateField = new DataSourceTextField("winRate", "赢率");
		winRateField.setLength(64);
		winRateField.setRequired(false);
		winRateField.setHidden(false);


		setFields(departmentIdField,applyEmployeeIdField, registerDateField, infoCodeField, projectNameField, businessTypeField, isOriginalField, customerNameField, provinceField, cityField, contactNameField, gradeField, contactPhoneField, estimateTheDesignAreasField, designPriceField, contractAmountField, trackDateField, projectRecordRemarkField, competitiveUnitField, projectOriginationField, projectOriginationRemarkField, projectLeaderField, projectManagerField, winRateField);
	}


}

