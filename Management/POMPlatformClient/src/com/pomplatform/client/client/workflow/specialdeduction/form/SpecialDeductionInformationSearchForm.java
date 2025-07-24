package com.pomplatform.client.client.workflow.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.client.workflow.specialdeduction.datasource.CDSpecialDeductionInformation;

public class SpecialDeductionInformationSearchForm extends SearchForm
{


	private final TextItem employeIdItem;
	private final TextItem specialDeductionTypeIdItem;
	private final TextItem yearItem;
	private final TextItem schoolingItem;
	private final TextItem educationTypeItem;
	private final TextItem educationStageItem;
	private final TextItem houseFirstItem;
	private final TextItem singleChildItem;
	private final TextItem cityItem;

	public SpecialDeductionInformationSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSpecialDeductionInformation.getInstance());
		employeIdItem = new TextItem("employeId", "纳税人id");
		specialDeductionTypeIdItem = new TextItem("specialDeductionTypeId", "专项类型");
		yearItem = new TextItem("year", "扣除年度");
		schoolingItem = new TextItem("schooling", "当前受教育阶段");
		educationTypeItem = new TextItem("educationType", "继续教育类型");
		educationStageItem = new TextItem("educationStage", "教育阶段");
		houseFirstItem = new TextItem("houseFirst", "是否婚前各自首套贷款且婚后分别扣除50%");
		singleChildItem = new TextItem("singleChild", "是否独生");
		cityItem = new TextItem("city", "租房城市");

		setItems(employeIdItem, specialDeductionTypeIdItem, yearItem, schoolingItem, educationTypeItem, educationStageItem, houseFirstItem, singleChildItem, cityItem);

		setNumCols(18);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
