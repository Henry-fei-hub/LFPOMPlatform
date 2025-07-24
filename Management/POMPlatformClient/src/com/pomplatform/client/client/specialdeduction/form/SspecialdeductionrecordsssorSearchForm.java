package com.pomplatform.client.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.client.specialdeduction.datasource.CDSspecialdeductionrecordsssor;

public class SspecialdeductionrecordsssorSearchForm extends SearchForm
{


	private final TextItem specialDeductionRecordIdItem;
	private final TextItem specialDeductionRecordNameItem;
	private final SelectItem specialDeductionTypeItem;
	private final SelectItem specialDeductionEducationItem;
	private final SelectItem specialDeductionSupOldItem;
	private final TextItem specialDeductionIdItem;
	private final TextItem alternateField1Item;
	private final TextItem alternateField2Item;
	private final TextItem alternateField3Item;
	private final CheckboxItem isEnableItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public SspecialdeductionrecordsssorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSspecialdeductionrecordsssor.getInstance());
		specialDeductionRecordIdItem = new TextItem("specialDeductionRecordId", "编码");
		specialDeductionRecordIdItem.hide();
		specialDeductionRecordNameItem = new TextItem("specialDeductionRecordName", "名字");
		specialDeductionRecordNameItem.setWidth("*");
		specialDeductionTypeItem = new SelectItem("specialDeductionType", "子项类型");
		specialDeductionTypeItem.setWidth("*");
		specialDeductionTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_215"));
		specialDeductionEducationItem = new SelectItem("specialDeductionEducation", "教育类型");
		specialDeductionEducationItem.setWidth("*");
		specialDeductionEducationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_216"));
		specialDeductionSupOldItem = new SelectItem("specialDeductionSupOld", "是否独生");
		specialDeductionSupOldItem.setWidth("*");
		specialDeductionSupOldItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		specialDeductionIdItem = new TextItem("specialDeductionId", "file编码");
		specialDeductionIdItem.hide();
		alternateField1Item = new TextItem("alternateField1", "备用字段1");
		alternateField1Item.hide();
		alternateField2Item = new TextItem("alternateField2", "备用字段2");
		alternateField2Item.hide();
		alternateField3Item = new TextItem("alternateField3", "备用字段3");
		alternateField3Item.hide();
		isEnableItem = new CheckboxItem("isEnable", "是否可用");
		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.setWidth("*");
		endDateItem = new DateItem("endDate", "结束时间");
		endDateItem.setWidth("*");

		setItems(specialDeductionRecordIdItem, specialDeductionRecordNameItem, specialDeductionTypeItem, specialDeductionEducationItem, specialDeductionSupOldItem, specialDeductionIdItem, alternateField1Item, alternateField2Item, alternateField3Item,startDateItem,endDateItem, isEnableItem);

		setNumCols(13);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
