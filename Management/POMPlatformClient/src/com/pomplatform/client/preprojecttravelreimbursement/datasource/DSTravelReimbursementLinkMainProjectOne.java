package com.pomplatform.client.preprojecttravelreimbursement.datasource;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.personnel.datasource.DSOnLoadFlowTravelReimbursementsApplyBuisnessData;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSTravelReimbursementLinkMainProjectOne extends DBDataSource
{


	public static DSTravelReimbursementLinkMainProjectOne instance = null;

	public static DSTravelReimbursementLinkMainProjectOne getInstance() {
		if(instance == null) {
			instance = new DSTravelReimbursementLinkMainProjectOne("DSTravelReimbursementLinkMainProject");
		}
		return instance;
	}

	private final DataSourceIntegerField travelReimbursementLinkMainProjectIdField;
	private final DataSourceIntegerField travelReimbursementIdField;
	private final DataSourceTextField mainProjectIdField;
	private final DataSourceTextField mainProjectNameField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceFloatField amountField;
	private final DataSourceTextField remarkField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceFloatField finalAmountField;
	private final DataSourceIntegerField plateIdField;

	public DSTravelReimbursementLinkMainProjectOne(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("TravelReimbursementLinkMainProject");


		travelReimbursementLinkMainProjectIdField = new DataSourceIntegerField("travelReimbursementLinkMainProjectId", "主键编码");
		travelReimbursementLinkMainProjectIdField.setLength(11);
		travelReimbursementLinkMainProjectIdField.setRequired(true);
		travelReimbursementLinkMainProjectIdField.setHidden(true);


		travelReimbursementIdField = new DataSourceIntegerField("travelReimbursementId", "日常报销编码");
		travelReimbursementIdField.setLength(11);
		travelReimbursementIdField.setRequired(false);
		travelReimbursementIdField.setHidden(true);
		travelReimbursementIdField.setForeignKey("DSOnLoadFlowTravelReimbursementsApplyBuisnessData.businessId");


		mainProjectIdField = new DataSourceTextField("mainProjectId", "项目");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(false);
		//加载前期项目数据，以供费用分拆时使用
		Map projectMap=new HashMap<>();
		Map preparams = new HashMap<>();
		DBDataSource.callOperation("EP_CustomPreCodeProjectName", preparams, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() < 0) {
					ClientUtil.displayErrorMessage(dsResponse);
				} else {
					Record record[]=dsResponse.getData();
					for(Record obj:record){
						projectMap.put(obj.getAttribute("preProjectReimbursementNumberId"), obj.getAttributeAsString("projectName"));
					}
				}
				mainProjectIdField.setValueMap(projectMap);
			}
		});

		mainProjectNameField = new DataSourceTextField("mainProjectName", "前期项目名称");
		mainProjectNameField.setLength(512);
		mainProjectNameField.setRequired(false);
		mainProjectNameField.setHidden(true);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		amountField = new DataSourceFloatField("amount", "费用");
		amountField.setLength(18);
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);

		
		inputTaxField = new DataSourceFloatField("inputTax", "进项税");
		inputTaxField.setLength(18);
		inputTaxField.setDecimalPad(5);
		inputTaxField.setFormat("#,###,###,###,##0.00");
		inputTaxField.setRequired(false);
		inputTaxField.setHidden(false);
		
		
		finalAmountField = new DataSourceFloatField("finalAmount", "成本");
		finalAmountField.setLength(18);
		finalAmountField.setDecimalPad(5);
		finalAmountField.setFormat("#,###,###,###,##0.00");
		finalAmountField.setRequired(false);
		finalAmountField.setHidden(false);
		
		
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		setFields(travelReimbursementLinkMainProjectIdField, travelReimbursementIdField, mainProjectIdField, mainProjectNameField, infoCodeField, plateIdField, amountField, remarkField, inputTaxField, finalAmountField);
	}


}

