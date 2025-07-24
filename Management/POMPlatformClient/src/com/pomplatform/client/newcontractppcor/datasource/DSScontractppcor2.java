package com.pomplatform.client.newcontractppcor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSScontractppcor2 extends DBDataSource
{


	public static DSScontractppcor2 instance = null;

	public static DSScontractppcor2 getInstance() {
		if(instance == null) {
			instance = new DSScontractppcor2("DSScontractppcor2");
		}
		return instance;
	}

	private final DataSourceIntegerField totalProjectTimeField;
	private final DataSourceFloatField designAreasField;
	private final DataSourceFloatField coveredAreaField;
	private final DataSourceTextField professionalCooperationField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceTextField customerAddressField;
	private final DataSourceTextField clientContractIdField;
	

	public DSScontractppcor2(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Scontractppcor");


		clientContractIdField = new DataSourceTextField("clientContractId", "客户合同编号");
		clientContractIdField.setLength(64);
		clientContractIdField.setRequired(false);
		clientContractIdField.setHidden(true);


		totalProjectTimeField = new DataSourceIntegerField("totalProjectTime", "项目总工期");
		totalProjectTimeField.setLength(11);
		totalProjectTimeField.setRequired(false);
		totalProjectTimeField.setHidden(false);


		designAreasField = new DataSourceFloatField("designAreas", "总设计面积");
		designAreasField.setLength(16);
		designAreasField.setDecimalPad(2);
		designAreasField.setFormat("##,###,###,###,##0.00");
		designAreasField.setRequired(false);
		designAreasField.setHidden(false);


		coveredAreaField = new DataSourceFloatField("coveredArea", "建筑面积");
		coveredAreaField.setLength(16);
		coveredAreaField.setDecimalPad(2);
		coveredAreaField.setFormat("##,###,###,###,##0.00");
		coveredAreaField.setRequired(false);
		coveredAreaField.setHidden(true);


		professionalCooperationField = new DataSourceTextField("professionalCooperation", "配合专业");
		professionalCooperationField.setLength(128);
		professionalCooperationField.setRequired(false);
		professionalCooperationField.setHidden(true);


		customerAddressField = new DataSourceTextField("customerAddress", "客户地址");
		customerAddressField.setLength(512);
		customerAddressField.setRequired(false);


		provinceField = new DataSourceTextField("province", "省份");
		provinceField.setLength(50);
		provinceField.setRequired(false);
		provinceField.setHidden(true);


		cityField = new DataSourceTextField("city", "城市");
		cityField.setLength(50);
		cityField.setRequired(false);
		cityField.setHidden(true);


		detailAddressField = new DataSourceTextField("detailAddress", "详细地址");
		detailAddressField.setLength(50);
		detailAddressField.setRequired(false);
		detailAddressField.setHidden(true);


		setFields(totalProjectTimeField, designAreasField, coveredAreaField, professionalCooperationField, provinceField, cityField, detailAddressField, customerAddressField, clientContractIdField);
	}


}

