package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.specialdeduction.datasource.CDMspecialdeductionrecordssyeseeshsppcor;

public class MspecialdeductionrecordssyeseeshsppcorSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final ComboBoxItem employeIdItem;
	private final SelectItem specialDeductionTypeIdItem;
	private final SelectItem educationTypeItem;
	private final SelectItem educationStageItem;
	private final SelectItem singleChildItem;
	private final SelectItem houseFirstItem;
	private final SelectItem schoolingItem;
	private final SelectItem processStatusItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem companyIdItem;

	public MspecialdeductionrecordssyeseeshsppcorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMspecialdeductionrecordssyeseeshsppcor.getInstance());
		yearItem = new SelectItem("year", "扣除年度");
		Date d = new Date();
		yearItem.setValue(d.getYear()+1900);
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		employeIdItem = new ComboBoxItem("employeId", "纳税申请人");
		employeIdItem.setWidth("*");
		employeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeIdItem.setChangeOnKeypress(false);
		employeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		specialDeductionTypeIdItem = new SelectItem("specialDeductionTypeId", "专项类型");
		specialDeductionTypeIdItem.setWidth("*");
		specialDeductionTypeIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_223"));
		
		educationTypeItem = new SelectItem("educationType", "继续教育类型");
		educationTypeItem.setWidth("*");
		educationTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_221"));
		
		educationStageItem = new SelectItem("educationStage", "教育阶段");
		educationStageItem.setWidth("*");
		educationStageItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_218"));
		
		singleChildItem = new SelectItem("singleChild", "是否独生");
		singleChildItem.setWidth("*");
		singleChildItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		
		houseFirstItem = new SelectItem("houseFirst", "是否首套房");
		houseFirstItem.setWidth("*");
		houseFirstItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		
		schoolingItem = new SelectItem("schooling", "当前受教育阶段");
		schoolingItem.hide();
		
		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.setWidth("*");
		processStatusItem.setValue(3);
		processStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.hide();

		setItems(yearItem, employeIdItem, specialDeductionTypeIdItem, educationTypeItem, educationStageItem, singleChildItem, houseFirstItem, schoolingItem, processStatusItem, plateIdItem, companyIdItem);

		setNumCols(22);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
