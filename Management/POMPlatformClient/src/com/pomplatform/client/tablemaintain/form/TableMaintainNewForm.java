package com.pomplatform.client.tablemaintain.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.tablemaintain.datasource.DSTableMaintain;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

import java.util.HashMap;
import java.util.Map;

public class TableMaintainNewForm extends AbstractWizadPage
{


	private final ComboBoxItem tableNameItem;
	private final TextItem remarkItem;

	public TableMaintainNewForm() {
		DSTableMaintain ds = DSTableMaintain.getInstance();
		__form.setWidth100();
		__form.setHeight100();


		tableNameItem = new ComboBoxItem("tableName", "数据库名称");
		tableNameItem.setWidth("*");
		__formItems.add(tableNameItem);

		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		SC.debugger();
		Map<String, String> map = new HashMap<>();
		DBDataSource.callOperation("NQ_getAllTables", "find", new HashMap(), new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] data = dsResponse.getData();
					for (Record datum : data) {
						map.put(datum.getAttribute("tablename"), datum.getAttribute("tablename"));
					}
					tableNameItem.setValueMap(map);
				}
			}
		});
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSTableMaintain.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
