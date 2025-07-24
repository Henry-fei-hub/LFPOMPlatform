package com.pomplatform.client.annoucement.form;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.activitympcor.datasource.DSSactivityMpcor;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class AnnoucementNewForm extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private final TextItem annoucementTitleItem;
	private final SelectItem annoucementEmployeeIdsItem;
	private final DateTimeItem annoucementTimeItem;
	private final TextAreaItem annoucementContentItem;
	private final TextAreaItem remarkItem;

	public AnnoucementNewForm() {
		DSSactivityMpcor ds = DSSactivityMpcor.getInstance();
		__form.setWidth100();
		__form.setHeight100();

		annoucementTitleItem = new TextItem("annoucementTitle", "公告主题");
		annoucementTitleItem.setWidth("*");
		__formItems.add(annoucementTitleItem);

		annoucementTimeItem = new DateTimeItem("annoucementTime", "公告时间");
		annoucementTimeItem.setWidth("*");
		annoucementTimeItem.setDefaultValue(new Date());
		annoucementTimeItem.setUseTextField(true);
		annoucementTimeItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH_DAY);
		__formItems.add(annoucementTimeItem);

		ListGridField eNoField = new ListGridField("employeeNo");
		ListGridField eNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		eNameField.setCanFilter(true);
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		annoucementEmployeeIdsItem = new SelectItem("annoucementEmployeeIds", "公告人员");
		annoucementEmployeeIdsItem.setWidth("*");
		annoucementEmployeeIdsItem.setMultiple(true);
		annoucementEmployeeIdsItem.setChangeOnKeypress(false);
		annoucementEmployeeIdsItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		annoucementEmployeeIdsItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		annoucementEmployeeIdsItem.setOptionCriteria(c);
		annoucementEmployeeIdsItem.setValueField("employeeId");
		annoucementEmployeeIdsItem.setDisplayField("employeeName");
		annoucementEmployeeIdsItem.setUseClientFiltering(true);
		annoucementEmployeeIdsItem.setPickListFields(eNoField, eNameField, departmentIdField);
		// ourEmployeesItem.setControlStyle("customInputTextStyle");
		__formItems.add(annoucementEmployeeIdsItem);

		annoucementContentItem = new TextAreaItem("annoucementContent", "公告内容");
		annoucementContentItem.setWidth("*");
		__formItems.add(annoucementContentItem);

		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
		annoucementTitleItem.setColSpan(4);
		annoucementEmployeeIdsItem.setColSpan(4);
		annoucementTimeItem.setColSpan(4);
		annoucementContentItem.setColSpan(4);
		remarkItem.setColSpan(4);

	}

	@Override
	public Map getValuesAsMap() {
		Map params = __form.getValues();
		String employeeIds = "";
		ListGridRecord[] reRecords = annoucementEmployeeIdsItem.getSelectedRecords();
		for (int i = 0; i < reRecords.length; i++) {
			if (i != 0) {
				employeeIds += ",";
			}
			employeeIds += reRecords[i].getAttribute("employeeId");
		}
		params.put("status", 1);
		params.put("annoucementEmployeeIds", employeeIds);
		params.put("annoucementEmployeeNames", annoucementEmployeeIdsItem.getDisplayValue());
		params.put("operateTime", new Date());
		params.put("operateEmployeeId", ClientUtil.getEmployeeId());
		// params.put("ourEmployees", ourEmployeesItem.getDisplayValue());
		return params;
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();

	}

}
