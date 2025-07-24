package com.pomplatform.client.companyarea.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.companyarea.datasource.CDCompanyarea;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class CompanyareaSearchForm extends SearchForm
{


	private final ComboBoxItem areaIdItem;
	private final SelectItem companyRecordIdItem;

	public CompanyareaSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCompanyarea.getInstance());
		areaIdItem = new ComboBoxItem("areaId", "区域");
		areaIdItem.setWidth("*");
		areaIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		areaIdItem.setValueMap(KeyValueManager.getValueMap("areas"));
		companyRecordIdItem = new SelectItem("companyRecordId", "公司");
		companyRecordIdItem.setWidth("*");
		companyRecordIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		setItems(areaIdItem, companyRecordIdItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
