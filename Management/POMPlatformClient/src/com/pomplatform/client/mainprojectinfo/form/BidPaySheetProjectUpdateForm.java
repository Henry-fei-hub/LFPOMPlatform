package com.pomplatform.client.mainprojectinfo.form;

import java.math.BigDecimal;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ReadOnlyDisplayAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.mainprojectinfo.datasource.DSBidPaySheetProject;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;

public class BidPaySheetProjectUpdateForm extends AbstractWizadPage
{
	
	
	private final TextItem personnelBusinessIdItem;
	private final TextItem processTypeItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem planItem;
	private final DateItem startDateItem;
	private final SelectItem startDateDetailItem;
	private final IntegerItem endDateDetailItem;
	private final TextAreaItem reasonItem;
	private final TextItem addressItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
	private final LinkItem linkItem;
	private final TextItem projectIdItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
//	private final DoubleItem housingFinanceItem;
	private final DoubleItem livingExpensesItem;
	private final DoubleItem severanceItem;
//	private final BooleanItem provideAccommodationItem;
	private final TextItem dutyIdItem;
	private final TextItem linkIdItem;
	private final TextItem transportationItem;
	private final SelectItem companyProvinceItem;
	private final SelectItem projectTypeItem;
	private final TextItem unitItem;
	private VLayout vLayout;// 表单+上传附件按钮

	public BidPaySheetProjectUpdateForm() {
		DSBidPaySheetProject ds = DSBidPaySheetProject.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		personnelBusinessIdItem=new TextItem("personnelBusinessId","personnelBusinessId");
		personnelBusinessIdItem.hide();
		__formItems.add(personnelBusinessIdItem);
		processTypeItem = new TextItem("processType", "processType");
//		processTypeItem.setDefaultValue(73);
		processTypeItem.hide();
		__formItems.add(processTypeItem);
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setDisabled(true);
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
//		employeeIdItem.hide();
		__formItems.add(employeeIdItem);
		employeeNoItem = new TextItem("employeeNo", "合同编号");
		employeeNoItem.setDisabled(true);
		employeeNoItem.hide();
		employeeNoItem.setWidth("*");
		__formItems.add(employeeNoItem);
		planItem = new TextItem("plan", "合同名称");
		planItem.setDisabled(true);
		planItem.hide();
		planItem.setWidth("*");
		__formItems.add(planItem);
		projectIdItem = new TextItem("projectId", "订单ID");
//		projectIdItem.setDefaultValue(data.getAttribute("projectId"));
		projectIdItem.setDisabled(true);
		projectIdItem.setWidth("*");
		projectIdItem.hide();
//		__formItems.add(projectIdItem);
		
		unitItem = new TextItem("unit", "信息编号");
		unitItem.setDisabled(true);
		unitItem.setWidth("*");
		__formItems.add(unitItem);
		
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setDisabled(true);
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		transportationItem = new TextItem("transportation", "客户名称");
		transportationItem.setDisabled(true);
		transportationItem.setWidth("*");
		__formItems.add(transportationItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		projectNameItem.setDisabled(true);
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);
		
		companyProvinceItem = new SelectItem("companyProvince", "主办设计团队");
		companyProvinceItem.setWidth("*");
		companyProvinceItem.setDisabled(true);
		companyProvinceItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		__formItems.add(companyProvinceItem);
		
		
		linkIdItem = new TextItem("linkId", "contractId");
//		linkIdItem.setDefaultValue(data.getAttribute("contractId"));
		linkIdItem.hide();
		__formItems.add(linkIdItem);
		dutyIdItem = new TextItem("dutyId", "mainProjectId");
//		dutyIdItem.setDefaultValue(data.getAttribute("mainProjectId"));
		dutyIdItem.hide();
		__formItems.add(dutyIdItem);
		livingExpensesItem = new DoubleItem("livingExpenses", "投标金额(元)");
		livingExpensesItem.setWidth("*");
		__formItems.add(livingExpensesItem);
		startDateItem = new DateItem("startDate", "投标日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		__formItems.add(startDateItem);
		startDateDetailItem = new SelectItem("startDateDetail","投标类型");
		startDateDetailItem.setWidth("*");
		startDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_129"));
		__formItems.add(startDateDetailItem);
		endDateDetailItem = new IntegerItem("endDateDetail","投标单位总数");
		endDateDetailItem.setWidth("*");
		__formItems.add(endDateDetailItem);
		addressItem = new TextItem("address","我方排名");
		addressItem.setWidth("*");
		__formItems.add(addressItem);

		severanceItem = new DoubleItem("severance","甲方补偿金额");
		severanceItem.setWidth("*");
		__formItems.add(severanceItem);
		
		projectTypeItem = new SelectItem("projectType","关闭原因");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_169"));
		projectTypeItem.setWidth("*");
		__formItems.add(projectTypeItem);
		
		
		reasonItem = new TextAreaItem("reason", "落标原因详情");
		reasonItem.setWidth("*");
		reasonItem.setRowSpan(3);
		reasonItem.setColSpan(4);
		reasonItem.setRequired(true);
		IsStringValidator remarkValidator = new IsStringValidator();
		LengthRangeValidator remarkLengthValidator = new LengthRangeValidator();
		remarkLengthValidator.setMax(1024);
		reasonItem.setValidators(remarkValidator, remarkLengthValidator);
		__formItems.add(reasonItem);
		
		
		attachmentIdItem = new TextItem("attachmentId", "附件ID");
		attachmentIdItem.hide();
		__formItems.add(attachmentIdItem);
		
		attachmentNameItem = new TextItem("attachmentName", "附件");
		attachmentNameItem.setWidth("*");
		attachmentNameItem.hide();
		__formItems.add(attachmentNameItem);
		
		
		
		linkItem = new LinkItem("上传报价单附件");
		linkItem.setLinkTitle("尚未上传报价单附件,请点击标题【上传报价单附件】上传");
		linkItem.setWidth("*");
		linkItem.setTitleStyle("labelTitleStyleClick");
		linkItem.setCanEdit(false);
		linkItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.DISABLED);
		linkItem.setRequired(true);
		__formItems.add(linkItem);
		linkItem.addTitleClickHandler(new TitleClickHandler() {
			@Override
			public void onTitleClick(TitleClickEvent event) {
				new CommonUploadWindow("上传报价单附件", false, 100, 2, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						//上传附件确认函成功
						linkItem.setTitle("更新附件");
						linkItem.setTitleStyle("labelTitleStyleClick");
						linkItem.setCanEdit(false);
						linkItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
						linkItem.setLinkTitle("已上传附件,点击可下载/预览(点击【更新附件】上传新的确认函)");
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							attachmentIdItem.setValue(fileId);
							attachmentNameItem.setValue(fileUrl);
							linkItem.setValue(fileUrl);
						}
						linkItem.redraw();
						attachmentNameItem.redraw();
					}
				});
			}
		});
		
		
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) {
			__form.editRecord(getRecord());
			//获取附件值，如果有值，则重定义标题显示
			String attachmentFile = BaseHelpUtils.getString(getRecord().getAttribute("attachmentName"));
			if(!BaseHelpUtils.isNullOrEmpty(attachmentFile)){
				linkItem.setTitle("更新附件");
				linkItem.setTitleStyle("labelTitleStyleClick");
				linkItem.setCanEdit(false);
				linkItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
				linkItem.setLinkTitle("已上传附件,点击可下载/预览(点击【更新附件】上传新的附件)");
				linkItem.setValue(attachmentFile);
				linkItem.redraw();
			}
			Record record = new Record();
			DataEditEvent dee = new DataEditEvent();
			dee.setData(record);
			fireEvent(dee);
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSBidPaySheetProject.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		SC.debugger();
		if(BaseHelpUtils.getIntValue(employeeIdItem.getValue())<=0) {
			SC.say("提示","申请人不能为空");
			return false;
		}else if(BaseHelpUtils.isNullOrEmpty(startDateItem.getValue())){
			SC.say("提示","投标日期不可为空");
			return false;
		}else if(BaseHelpUtils.getBigDecimalValue(livingExpensesItem.getValue()).compareTo(BigDecimal.ZERO) <= 0){
			SC.say("提示","投标金额不能小于或等于0");
			return false;
		}else if(BaseHelpUtils.isNullOrEmpty(startDateDetailItem.getValue())){
			SC.say("提示","投标类型不能为空");
			return false;
		}else if(BaseHelpUtils.isNullOrEmpty(endDateDetailItem.getValue())){
			SC.say("提示","投标单位总数不能为空");
			return false;
		}else if(BaseHelpUtils.isNullOrEmpty(addressItem.getValue())){
			SC.say("提示","我方排名不能为空");
			return false;
		}else if(BaseHelpUtils.isNullOrEmpty(severanceItem.getValue())){
			SC.say("提示","甲方赔偿金额不能为空");
			return false;
		}else if(BaseHelpUtils.isNullOrEmpty(projectTypeItem.getValue())){
			SC.say("提示","关闭原因不能为空");
			return false;
		}else if(BaseHelpUtils.isNullOrEmpty(reasonItem.getValue())){
			SC.say("提示","落标原因详情不能为空");
			return false;
		}else if(BaseHelpUtils.isNullOrEmpty(attachmentIdItem.getValue())||BaseHelpUtils.isNullOrEmpty(attachmentNameItem.getValue())){
			SC.say("提示","请上传附件");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
