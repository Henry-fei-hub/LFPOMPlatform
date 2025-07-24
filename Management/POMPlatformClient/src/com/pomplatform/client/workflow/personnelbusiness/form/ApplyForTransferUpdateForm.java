package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSApplyForTransfer;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSSpersonnelbusinesppor;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ReadOnlyDisplayAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.TitleClickEvent;
import com.smartgwt.client.widgets.form.fields.events.TitleClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class ApplyForTransferUpdateForm extends AbstractWizadPage {

	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextAreaItem remarkItem;
	private final TextAreaItem reasonItem;
	private final IPickTreeItem parentIdItem;
	private final TextItem addressItem;
	private final LinkItem attachmentItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
	private final TextItem drafterItem;
	private final ComboBoxItem dutyIdItem;

	private final VLayout mainLayout;

	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public ApplyForTransferUpdateForm(String processName) {
		boolean isApply = false;
		boolean isManage = false;
		if(processName.contains("申请人")){
			isApply = true;
		}
		if(processName.contains("运营")){
			isManage = true;
		}
		if(processName.contains("人事")){
			isManage = true;
		}
		DSSpersonnelbusinesppor ds = DSSpersonnelbusinesppor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		mainLayout = new VLayout();
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setRequired(true);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);

		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setRequired(true);
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);

		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setRequired(true);
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);

		companyIdItem = new SelectItem("companyId", shouldNotBeNull + "转调归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setRequired(true);
		companyIdItem.setWidth("*");
		__formItems.add(companyIdItem);
		
		parentIdItem = new IPickTreeItem("parentId", shouldNotBeNull + "转调部门");
		parentIdItem.setValueField("treeId");
		parentIdItem.setRequired(true);
		parentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		parentIdItem.setWidth("*");
		parentIdItem.setDisabled(isApply);
		__formItems.add(parentIdItem);
		
		dutyIdItem = new ComboBoxItem("dutyId", shouldNotBeNull + "转调岗位");
		dutyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		dutyIdItem.setValueMap(KeyValueManager.getValueMap("duties"));
		dutyIdItem.setWidth("*");
		dutyIdItem.setRequired(true);
		__formItems.add(dutyIdItem);

		startDateItem = new DateItem("startDate", shouldNotBeNull + "申请调岗日期");
		startDateItem.setDefaultValue(new Date());
		startDateItem.setRequired(true);
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.setWidth("*");
		startDateItem.setDisabled(isApply);
		__formItems.add(startDateItem);

		endDateItem = new DateItem("endDate", shouldNotBeNull + "实际调岗日期");
		endDateItem.setRequired(true);
		endDateItem.setDefaultValue(new Date());
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		endDateItem.setWidth("*");
		if(isManage)__formItems.add(endDateItem);
		
		addressItem = new TextItem("attachment", shouldNotBeNull + "附件路径");
		addressItem.setDisabled(true);
		addressItem.setRequired(true);
		addressItem.setWidth("*");
		if(isApply)__formItems.add(addressItem);
		
		attachmentIdItem = new TextItem("attachmentId", "附件ID");
		attachmentIdItem.setHidden(true);
		__formItems.add(attachmentIdItem);
		
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setHidden(true);
		__formItems.add(attachmentNameItem);
		
		attachmentItem = new LinkItem("上传转岗单");
		attachmentItem.setLinkTitle("尚未上传转岗单,请点击标题【上传转岗单】上传");
		attachmentItem.setWidth("*");
		attachmentItem.setTitleStyle("labelTitleStyleClick");
		attachmentItem.setCanEdit(false);
		attachmentItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.DISABLED);
		attachmentItem.setRequired(true);
		if(isApply)__formItems.add(attachmentItem);
		attachmentItem.addTitleClickHandler(new TitleClickHandler() {
			@Override
			public void onTitleClick(TitleClickEvent event) {
				new CommonUploadWindow("上传附件", false, 100, 2, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						//上传附件转岗单成功
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							String fileName = data.get(key).getAttribute("fileName");
							attachmentIdItem.setValue(fileId);
							attachmentNameItem.setValue(fileName);
	                    	attachmentItem.setTitle("更新转岗单");
	                    	attachmentItem.setTitleStyle("labelTitleStyleClick");
	                    	attachmentItem.setCanEdit(false);
	                    	attachmentItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
	                    	attachmentItem.setLinkTitle("已上传转岗单,点击可下载/预览(点击【更新转岗单函】上传新的转岗单)");
	                    	attachmentItem.setValue(fileUrl);
	                    	addressItem.setValue(fileUrl);
	                    	attachmentItem.redraw();
						}
					}
				});
			}
		});

		reasonItem = new TextAreaItem("reason", shouldNotBeNull + "申请缘由");
		reasonItem.setColSpan(4);
		reasonItem.setRowSpan(3);
		reasonItem.setRequired(true);
		reasonItem.setWidth("*");
		reasonItem.setDisabled(isApply);
		__formItems.add(reasonItem);

		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		mainLayout.addMember(__form);
		addMember(mainLayout);

	}

	@Override
	public boolean checkData() {
		if(__form.validate()){
			return true;
		}else{
			SC.say("请您按系统提示填好信息。");
			return false;
		}
	}

	@Override
	public void startEdit() {
		if (getRecord() != null){
			__form.editRecord(getRecord());
			//获取附件值，如果有值，则重定义标题显示
			String attachmentFile = BaseHelpUtils.getString(getRecord().getAttribute("attachment"));
			if(!BaseHelpUtils.isNullOrEmpty(attachmentFile)){
				attachmentItem.setTitle("更新转岗单");
				attachmentItem.setTitleStyle("labelTitleStyleClick");
                attachmentItem.setCanEdit(false);
                attachmentItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
                attachmentItem.setLinkTitle("已上传转岗单,点击可下载/预览(点击【更新转岗单】上传新的转岗单)");
                attachmentItem.setValue(attachmentFile);
                attachmentItem.redraw();
			}
		}else{
			__form.editNewRecord();
		}	
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSApplyForTransfer.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}
	
}
