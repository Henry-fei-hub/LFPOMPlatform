package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.specialdeduction.datasource.CDSspecialdeductionsepor;

public class SspecialdeductionseporSearchForm extends SearchForm
{


	private final TextItem specialDeductionIdItem;
	private final ComboBoxItem employeIdItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem companyIdItem;
	private final SelectItem documentTypeItem;
	private final SelectItem spouseDocumentTypeItem;
	private final CheckboxItem isEnableItem;

	public SspecialdeductionseporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSspecialdeductionsepor.getInstance());
		specialDeductionIdItem = new TextItem("specialDeductionId", "id");
		specialDeductionIdItem.hide();
		
		employeIdItem = new ComboBoxItem("employeId", "纳税人");
		employeIdItem.setWidth("*");
		employeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
	
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		
		documentTypeItem = new SelectItem("documentType", "身份证件类型");
		documentTypeItem.setWidth("*");
		documentTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_222"));

		spouseDocumentTypeItem = new SelectItem("spouseDocumentType", "配偶身份证件类型");
		spouseDocumentTypeItem.setWidth("*");
		spouseDocumentTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_222"));
		
		isEnableItem = new CheckboxItem("isEnable", "是否可用");
		isEnableItem.setWidth("*");
		setItems(specialDeductionIdItem, employeIdItem, plateIdItem, companyIdItem, documentTypeItem, spouseDocumentTypeItem, isEnableItem);

		setNumCols(14);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
