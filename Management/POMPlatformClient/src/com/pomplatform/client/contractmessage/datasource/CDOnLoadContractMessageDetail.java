package com.pomplatform.client.contractmessage.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadContractMessageDetail extends DataSource
{


	public static CDOnLoadContractMessageDetail instance = null;

	public static CDOnLoadContractMessageDetail getInstance() {
		if(instance == null) {
			instance = new CDOnLoadContractMessageDetail("CDOnLoadContractMessageDetail");
		}
		return instance;
	}

	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField contractMessageDetailIdField;
	private final DataSourceIntegerField contractMessageIdField;
	private final DataSourceIntegerField contractIdField;

	public CDOnLoadContractMessageDetail(String dataSourceID) {

		setID(dataSourceID);
		remarkField = new DataSourceTextField("remark", "消息推送人员");
		remarkField.setRequired(false);
		remarkField.setLength(256);
		remarkField.setHidden(false);

		contractMessageDetailIdField = new DataSourceIntegerField("contractMessageDetailId", "id");
		contractMessageDetailIdField.setRequired(true);
		contractMessageDetailIdField.setLength(11);
		contractMessageDetailIdField.setPrimaryKey(true);
		contractMessageDetailIdField.setHidden(true);

		contractMessageIdField = new DataSourceIntegerField("contractMessageId", "父id");
		contractMessageIdField.setRequired(false);
		contractMessageIdField.setLength(11);
		contractMessageIdField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(remarkField, contractMessageDetailIdField, contractMessageIdField, contractIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

