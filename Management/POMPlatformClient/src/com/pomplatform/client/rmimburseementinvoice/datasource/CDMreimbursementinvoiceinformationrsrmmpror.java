package com.pomplatform.client.rmimburseementinvoice.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMreimbursementinvoiceinformationrsrmmpror extends DataSource
{


	public static CDMreimbursementinvoiceinformationrsrmmpror instance = null;

	public static CDMreimbursementinvoiceinformationrsrmmpror getInstance() {
		if(instance == null) {
			instance = new CDMreimbursementinvoiceinformationrsrmmpror("CDMreimbursementinvoiceinformationrsrmmpror");
		}
		return instance;
	}

	private final DataSourceDateTimeField minCompleteTimeField;
	private final DataSourceDateTimeField maxCompleteTimeField;
	private final DataSourceTextField packageCodeField;
	private final DataSourceTextField rmiCodeField;

	public CDMreimbursementinvoiceinformationrsrmmpror(String dataSourceID) {

		setID(dataSourceID);
		minCompleteTimeField = new DataSourceDateTimeField("minCompleteTime", "最早完成时间");
		minCompleteTimeField.setRequired(false);
		minCompleteTimeField.setHidden(false);

		maxCompleteTimeField = new DataSourceDateTimeField("maxCompleteTime", "最晚完成时间");
		maxCompleteTimeField.setRequired(false);
		maxCompleteTimeField.setHidden(false);

		packageCodeField = new DataSourceTextField("packageCode", "汇总单号");
		packageCodeField.setRequired(false);
		packageCodeField.setLength(255);
		packageCodeField.setHidden(false);

		rmiCodeField = new DataSourceTextField("rmiCode", "报销单号");
		rmiCodeField.setRequired(true);
		rmiCodeField.setLength(255);
		rmiCodeField.setHidden(false);

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


		setFields(minCompleteTimeField, maxCompleteTimeField, packageCodeField, rmiCodeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

