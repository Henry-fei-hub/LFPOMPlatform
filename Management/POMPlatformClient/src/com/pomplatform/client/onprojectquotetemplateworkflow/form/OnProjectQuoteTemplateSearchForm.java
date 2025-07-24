package com.pomplatform.client.onprojectquotetemplateworkflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onprojectquotetemplateworkflow.datasource.CDOnProjectQuoteTemplate;

public class OnProjectQuoteTemplateSearchForm extends SearchForm
{


	private final TextItem projectQuoteIdItem;
	private final TextItem projectIdItem;
	private final TextItem titleNameItem;
	private final TextItem fileIdItem;
	private final TextItem versionNumberItem;
	private final TextItem quoteStatusItem;
	private final TextItem basicAmountItem;
	private final TextItem totalAmountItem;
	private final TextItem upAmountItem;
	private final TextItem upPercentItem;
	private final TextItem preferentialAmountItem;
	private final TextItem perferentialPercentItem;
	private final TextItem specialDiscountAmountItem;
	private final TextItem specialDiscountPercentItem;
	private final TextItem taxAmountItem;
	private final TextItem otherTaxAmountItem;
	private final TextItem finalPercentItem;
	private final TextItem finalAmountItem;
	private final TextItem taxFinalAmountItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem remarkItem;
	private final TextItem companyIdItem;

	public OnProjectQuoteTemplateSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnProjectQuoteTemplate.getInstance());
		projectQuoteIdItem = new TextItem("projectQuoteId", "主键编码");
		projectIdItem = new TextItem("projectId", "项目id");
		titleNameItem = new TextItem("titleName", "主题名称");
		fileIdItem = new TextItem("fileId", "过往合作项目报价图片");
		versionNumberItem = new TextItem("versionNumber", "版本号");
		quoteStatusItem = new TextItem("quoteStatus", "2已报价)");
		basicAmountItem = new TextItem("basicAmount", "基准总额");
		totalAmountItem = new TextItem("totalAmount", "小计总额");
		upAmountItem = new TextItem("upAmount", "上浮金额");
		upPercentItem = new TextItem("upPercent", "上浮系数");
		preferentialAmountItem = new TextItem("preferentialAmount", "优惠金额");
		perferentialPercentItem = new TextItem("perferentialPercent", "优惠系数");
		specialDiscountAmountItem = new TextItem("specialDiscountAmount", "特殊折扣金额");
		specialDiscountPercentItem = new TextItem("specialDiscountPercent", "特殊折扣系数");
		taxAmountItem = new TextItem("taxAmount", "税金");
		otherTaxAmountItem = new TextItem("otherTaxAmount", "其它税金（采买）");
		finalPercentItem = new TextItem("finalPercent", "最终系数");
		finalAmountItem = new TextItem("finalAmount", "不含税合计");
		taxFinalAmountItem = new TextItem("taxFinalAmount", "含税合计");
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		operateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, operateTimeItem);
			}
		});
		remarkItem = new TextItem("remark", "备注");
		companyIdItem = new TextItem("companyId", "公司id");

		setItems(projectQuoteIdItem, projectIdItem, titleNameItem, fileIdItem, versionNumberItem, quoteStatusItem, basicAmountItem, totalAmountItem, upAmountItem, upPercentItem, preferentialAmountItem, perferentialPercentItem, specialDiscountAmountItem, specialDiscountPercentItem, taxAmountItem, otherTaxAmountItem, finalPercentItem, finalAmountItem, taxFinalAmountItem, operateEmployeeIdItem, operateTimeItem, remarkItem, companyIdItem);

		setNumCols(46);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
