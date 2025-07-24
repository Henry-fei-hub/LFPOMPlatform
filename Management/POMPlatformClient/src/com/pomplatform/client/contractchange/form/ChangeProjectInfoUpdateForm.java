package com.pomplatform.client.contractchange.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.contractchange.datasource.DSChangeProjectInfo;

public class ChangeProjectInfoUpdateForm extends AbstractWizadPage
{


	private final TextItem projectChangeIdItem;
	private final SelectItem projectIdItem;
	private final TextItem sheetAmountItem;
	private final TextItem sheetChangeAmountItem;
	private final TextItem sheetFinalAmountItem;
	private final TextItem sheetChangeViewItem;
	private final TextItem totalIntegralItem;
	private final TextItem totalChangeIntegralItem;
	private final TextItem totalFinalIntegralItem;
	private final TextItem totalChangeViewItem;
	private final TextItem commonAreaItem;
	private final TextItem logisticsAreaItem;
	private final TextItem designAreaItem;
	private final TextItem complaintPercentageItem;
	private final TextItem complaintIntegralItem;
	private final TextItem flagItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem remarkItem;

	public ChangeProjectInfoUpdateForm() {
		DSChangeProjectInfo ds = DSChangeProjectInfo.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectChangeIdItem = new TextItem("projectChangeId", "主键编码");
		projectChangeIdItem.setDisabled(true);
		projectChangeIdItem.setRequired(true);
		IsIntegerValidator projectChangeIdValidator = new IsIntegerValidator();
		projectChangeIdItem.setValidators(projectChangeIdValidator);
		__formItems.add(projectChangeIdItem);
		projectIdItem = new SelectItem("projectId", "项目编码");
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects",projectIdItem);
		__formItems.add(projectIdItem);
		sheetAmountItem = new TextItem("sheetAmount", "订单合同金额");
		__formItems.add(sheetAmountItem);
		sheetChangeAmountItem = new TextItem("sheetChangeAmount", "订单合同变更金额");
		__formItems.add(sheetChangeAmountItem);
		sheetFinalAmountItem = new TextItem("sheetFinalAmount", "订单合同变更后金额");
		__formItems.add(sheetFinalAmountItem);
		sheetChangeViewItem = new TextItem("sheetChangeView", "订单合同金额变更显示");
		__formItems.add(sheetChangeViewItem);
		totalIntegralItem = new TextItem("totalIntegral", "订单总积分");
		__formItems.add(totalIntegralItem);
		totalChangeIntegralItem = new TextItem("totalChangeIntegral", "订单变更积分");
		__formItems.add(totalChangeIntegralItem);
		totalFinalIntegralItem = new TextItem("totalFinalIntegral", "订单变更后总积分");
		__formItems.add(totalFinalIntegralItem);
		totalChangeViewItem = new TextItem("totalChangeView", "订单总积分变更显示");
		__formItems.add(totalChangeViewItem);
		commonAreaItem = new TextItem("commonArea", "公区面积");
		__formItems.add(commonAreaItem);
		logisticsAreaItem = new TextItem("logisticsArea", "后勤面积");
		__formItems.add(logisticsAreaItem);
		designAreaItem = new TextItem("designArea", "设计面积");
		__formItems.add(designAreaItem);
		complaintPercentageItem = new TextItem("complaintPercentage", "投诉保证金比例");
		__formItems.add(complaintPercentageItem);
		complaintIntegralItem = new TextItem("complaintIntegral", "投诉保证金");
		__formItems.add(complaintIntegralItem);
		flagItem = new TextItem("flag", "状态");
		__formItems.add(flagItem);
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		__formItems.add(operateEmployeeIdItem);
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		__formItems.add(operateTimeItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSChangeProjectInfo.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
