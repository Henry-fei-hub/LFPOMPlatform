package com.pomplatform.client.platereportrecorddetail.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

import java.util.LinkedHashMap;

public class DSprojectAdvanceDetail extends DBDataSource
{


	public static DSprojectAdvanceDetail instance = null;

	public static DSprojectAdvanceDetail getInstance() {
		if(instance == null) {
			instance = new DSprojectAdvanceDetail("DSprojectAdvanceDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField plateNameField;
	private final DataSourceFloatField advanceIntegralField;
	private final DataSourceFloatField remainingIntegralField;
	private final DataSourceFloatField assignedIntegralField;
	private final DataSourceIntegerField flagField;

	public DSprojectAdvanceDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("projectAdvanceDetail");


		projectIdField = new DataSourceIntegerField("projectId", "补贴项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		plateNameField = new DataSourceTextField("plateName", "业务部门");
		plateNameField.setLength(64);
		plateNameField.setRequired(false);
		plateNameField.setHidden(false);


		advanceIntegralField = new DataSourceFloatField("advanceIntegral", "补贴积分");
		advanceIntegralField.setLength(18);
		advanceIntegralField.setDecimalPad(2);
		advanceIntegralField.setFormat("#,###,###,###,###,##0.00");
		advanceIntegralField.setRequired(false);
		advanceIntegralField.setHidden(false);


		remainingIntegralField = new DataSourceFloatField("remainingIntegral", "剩余积分");
		remainingIntegralField.setLength(18);
		remainingIntegralField.setDecimalPad(2);
		remainingIntegralField.setFormat("#,###,###,###,###,##0.00");
		remainingIntegralField.setRequired(true);
		remainingIntegralField.setHidden(false);


		assignedIntegralField = new DataSourceFloatField("assignedIntegral", "确认积分");
		assignedIntegralField.setLength(18);
		assignedIntegralField.setDecimalPad(2);
		assignedIntegralField.setFormat("#,###,###,###,###,##0.00");
		assignedIntegralField.setRequired(true);
		assignedIntegralField.setHidden(false);


		flagField = new DataSourceIntegerField("flag", "类型");
		flagField.setLength(18);
		flagField.setRequired(false);
		flagField.setHidden(false);
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("1", "部门补贴到项目");
		map.put("2", "公司补贴到项目");
		flagField.setValueMap(map);


		setFields(projectIdField, plateIdField, contractCodeField, projectNameField, plateNameField, advanceIntegralField, remainingIntegralField, assignedIntegralField, flagField);
	}


}

