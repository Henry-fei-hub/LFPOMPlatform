package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.common.UploadReimbursementAttachments;
import com.pomplatform.client.payment.panel.OnSalaryAnnualBonusByPlatePanel;
import com.pomplatform.client.payment.panel.OnSalaryPlateBonusByPlatePanel;
import com.pomplatform.client.payment.panel.OnSalaryReportByPlatePanel;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSSpersonnelbusinesppor;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ReadOnlyDisplayAppearance;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.TitleClickEvent;
import com.smartgwt.client.widgets.form.fields.events.TitleClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class PayrollApplyNewForm extends AbstractWizadPage {

	private final TextAreaItem remarkItem;
	private final LinkItem attachmentItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
	private final FloatItem feeItem;
	private final SelectItem companyProvinceItem; //年份
	private final SelectItem targetProvinceItem; // 月份
	
	private final TextItem drafterItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final SelectItem typeItem;

	private final VLayout mainLayout;
	
	private OnSalaryReportByPlatePanel salaryPanel;
	private OnSalaryPlateBonusByPlatePanel bonusPanel;
	private OnSalaryAnnualBonusByPlatePanel yearBonusPanel;

	public PayrollApplyNewForm() {
		DSSpersonnelbusinesppor ds = DSSpersonnelbusinesppor.getInstance();
		
		__form.setWidth100();
		__form.setHeight("42%");
		
		mainLayout = new VLayout();
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);

		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);

		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		
		__formItems.add(employeeNoItem);

		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);

		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setRequired(true);
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
		companyIdItem.setWidth("*");
		companyIdItem.setHidden(true);
		__formItems.add(companyIdItem);
		
		Date date = new Date();
		DateTimeFormat yearDf = DateTimeFormat.getFormat("yyyy");
		int year = BaseHelpUtils.getIntValue(yearDf.format(date));
		DateTimeFormat monthDf = DateTimeFormat.getFormat("MM");
		int month = BaseHelpUtils.getIntValue(monthDf.format(date));
		companyProvinceItem = new SelectItem("companyProvince", "年份");
		companyProvinceItem.setRequired(true);
		companyProvinceItem.setDefaultValue(year);
		companyProvinceItem.setWidth("*");
		companyProvinceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		__formItems.add(companyProvinceItem);
		
		targetProvinceItem = new SelectItem("targetProvince", "月份");
		targetProvinceItem.setRequired(true);
		targetProvinceItem.setDefaultValue(month);
		targetProvinceItem.setWidth("*");
		targetProvinceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		__formItems.add(targetProvinceItem);
		
		feeItem = new FloatItem("fee", "发放总金额");
		feeItem.setRequired(true);
		feeItem.setWidth("*");
		__formItems.add(feeItem);
		
		typeItem = new SelectItem("type", "发放类型");
		typeItem.setRequired(true);
		typeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					int type = BaseHelpUtils.getIntValue(event.getValue());
					if(1 == type){
						salaryPanel.show();
						bonusPanel.hide();
						yearBonusPanel.hide();
					}else if(2 == type){
						salaryPanel.hide();
						bonusPanel.setFlowStatus(0);
						bonusPanel.setPersonnelBusinessId(0);
						bonusPanel.show();
						yearBonusPanel.hide();
					}else if(3 == type){
						salaryPanel.hide();
						bonusPanel.hide();
						yearBonusPanel.initSearchData(-1, null, 0, 0);
						yearBonusPanel.show();
					}
				}
				
			}
		});
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_127"));
		typeItem.setDefaultValue("1");
		typeItem.setWidth("*");
		__formItems.add(typeItem);
		
		attachmentIdItem = new TextItem("attachmentId", "附件ID");
		attachmentIdItem.setHidden(true);
		__formItems.add(attachmentIdItem);
		
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setHidden(true);
		__formItems.add(attachmentNameItem);
		
		attachmentItem = new LinkItem("上传附件");
		attachmentItem.setLinkTitle("尚未上传附件,请点击标题【上传附件】上传");
		attachmentItem.setWidth("*");
		attachmentItem.setTitleStyle("labelTitleStyleClick");
		attachmentItem.setCanEdit(false);
		attachmentItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.DISABLED);
		attachmentItem.setRequired(true);
		attachmentItem.hide();
		__formItems.add(attachmentItem);
		attachmentItem.addTitleClickHandler(new TitleClickHandler() {
			@Override
			public void onTitleClick(TitleClickEvent event) {
				new CommonUploadWindow("上传附件", false, 100, 2, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
                        //上传附件确认函成功
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							String fileName = data.get(key).getAttribute("fileName");
							attachmentItem.setTitle("更新附件");
							attachmentItem.setTitleStyle("labelTitleStyleClick");
							attachmentItem.setCanEdit(false);
							attachmentItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
							attachmentItem.setLinkTitle("已上传附件,点击可下载/预览(点击【更新附件】上传新的附件)");
							attachmentItem.setValue(fileUrl);
							attachmentItem.redraw();
							attachmentIdItem.setValue(fileId);
							attachmentNameItem.setValue(fileName);
						}
					}
				});
			}
		});
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(8);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(8);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		mainLayout.addMember(__form);
		
		salaryPanel= new OnSalaryReportByPlatePanel();
		salaryPanel.setHeight("100%");
		mainLayout.addMember(salaryPanel);
		
		bonusPanel = new OnSalaryPlateBonusByPlatePanel();
		bonusPanel.setHeight("100%");
		bonusPanel.hide();
		mainLayout.addMember(bonusPanel);
		
		yearBonusPanel = new OnSalaryAnnualBonusByPlatePanel();
		yearBonusPanel.setHeight("100%");
		yearBonusPanel.hide();
		mainLayout.addMember(yearBonusPanel);
		
		addMember(mainLayout);

	}

	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSpersonnelbusinesppor.getInstance());
		manager.addMember(__form);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public java.util.Map getValuesAsMap() {
		Map valueMap = __form.getValues();
		return valueMap;
	}
	
}
