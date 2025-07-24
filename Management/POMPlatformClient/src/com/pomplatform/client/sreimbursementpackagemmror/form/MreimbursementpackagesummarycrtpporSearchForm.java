package com.pomplatform.client.sreimbursementpackagemmror.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.CDMreimbursementpackagesummarycrtppor;

public class MreimbursementpackagesummarycrtpporSearchForm extends SearchForm
{


	private final TextItem reimbursementPackageIdItem;
	private final TextItem typeItem;
	private final TextItem payResultItem;
	private final TextItem payStatusItem;

	public MreimbursementpackagesummarycrtpporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMreimbursementpackagesummarycrtppor.getInstance());
		reimbursementPackageIdItem = new TextItem("reimbursementPackageId", "报销打包表编码");
		typeItem = new TextItem("type", "类型 1支付 2代发工资 3代发奖金 4代发其他 5 内部转账");
		payResultItem = new TextItem("payResult", "4失败");
		payStatusItem = new TextItem("payStatus", "3支付完成(已返回处理结果)");

		setItems(reimbursementPackageIdItem, typeItem, payResultItem, payStatusItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
