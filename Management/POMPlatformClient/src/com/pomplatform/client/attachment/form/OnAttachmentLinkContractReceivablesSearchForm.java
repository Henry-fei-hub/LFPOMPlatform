package com.pomplatform.client.attachment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.attachment.datasource.CDOnAttachmentLinkContractReceivables;

public class OnAttachmentLinkContractReceivablesSearchForm extends SearchForm
{


	private final TextItem personnelBusinessIdItem;
	private final TextItem contractIdItem;
	private final SelectItem parentIdItem;

	public OnAttachmentLinkContractReceivablesSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnAttachmentLinkContractReceivables.getInstance());
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "流程主表编码");
		contractIdItem = new TextItem("contractId", "合同id");
		parentIdItem = new SelectItem("parentId", "收款阶段id的父节点");
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdItem);

		setItems(personnelBusinessIdItem, contractIdItem, parentIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
