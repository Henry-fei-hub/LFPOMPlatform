package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.payment.panel.OnSalaryAnnualBonusByCompanyPanel;
import com.pomplatform.client.payment.panel.OnSalaryBonusSendDataPanel;
import com.pomplatform.client.payment.panel.OnSalaryBonusTotalDataPanel;
import com.pomplatform.client.payment.panel.OnSalaryReportByCompanyPanel;
import com.pomplatform.client.payment.panel.OnSalarySendDataPanel;
import com.pomplatform.client.payment.panel.OnSalaryTaxDataPanel;
import com.pomplatform.client.salary.panel.SalaryAnnualbonusSendPanel;
import com.pomplatform.client.salary.panel.SalaryAnnualbonusTaxPanel;
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
import com.smartgwt.client.widgets.form.fields.events.TitleClickEvent;
import com.smartgwt.client.widgets.form.fields.events.TitleClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class PayrollApplyUpdateForm extends AbstractWizadPage {

	private final TextAreaItem remarkItem;
	private final LinkItem attachmentItem;
	private final LinkItem attachment1Item;
	private final LinkItem attachment2Item;
	private final LinkItem attachment3Item;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentId1Item;
	private final TextItem attachmentId2Item;
	private final TextItem attachmentId3Item;
	
	private final FloatItem feeItem;
	private final SelectItem companyProvinceItem; //年份
	private final SelectItem targetProvinceItem; // 月份
	
	private final TextItem reasonItem;
	private final TextItem addressItem;
	private final TextItem planItem;
	private final TextItem transportationItem;

	private final VLayout mainLayout;
	
	private final TextItem drafterItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final SelectItem typeItem;
	
	private OnSalarySendDataPanel salarySendPanel;
	
	private OnSalaryReportByCompanyPanel salaryReportPanel;
	
	private OnSalaryBonusSendDataPanel bonusSendPanel;
	
	private OnSalaryBonusTotalDataPanel bonusReportPanel;
	
	private SalaryAnnualbonusSendPanel salaryAnnualSendPanel;
	
	private OnSalaryAnnualBonusByCompanyPanel salaryAnnualReportPanel;
	
	private OnSalaryTaxDataPanel salaryTaxPanel;
	
	private SalaryAnnualbonusTaxPanel salaryAnnualPanel;
	
	private String processName;

	public PayrollApplyUpdateForm(String processName) {
		DSSpersonnelbusinesppor ds = DSSpersonnelbusinesppor.getInstance();
		
		__form.setWidth100();
		__form.setHeight100();
		
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
		
		companyProvinceItem = new SelectItem("companyProvince", "年份");
		companyProvinceItem.setDisabled(true);
		companyProvinceItem.setRequired(true);
		companyProvinceItem.setWidth("*");
		companyProvinceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		__formItems.add(companyProvinceItem);
		
		targetProvinceItem = new SelectItem("targetProvince", "月份");
		targetProvinceItem.setDisabled(true);
		targetProvinceItem.setRequired(true);
		targetProvinceItem.setWidth("*");
		targetProvinceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		__formItems.add(targetProvinceItem);
		
		feeItem = new FloatItem("fee", "发放总金额");
		feeItem.setDisabled(true);
		feeItem.setRequired(true);
		feeItem.setWidth("*");
		__formItems.add(feeItem);
		
		typeItem = new SelectItem("type", "发放类型");
		typeItem.setRequired(true);
		typeItem.setDisabled(true);
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_127"));
		typeItem.setWidth("*");
		__formItems.add(typeItem);
		
		reasonItem = new TextItem("reason", "(武汉、大连)发放凭证");
		reasonItem.setWidth("*");
		reasonItem.setHidden(true);
		reasonItem.setRequired(true);
		reasonItem.setDisabled(true);
		__formItems.add(reasonItem);
		
		addressItem = new TextItem("address", "(上海)发放凭证");
		addressItem.setWidth("*");
		addressItem.setHidden(true);
		addressItem.setRequired(true);
		addressItem.setDisabled(true);
		__formItems.add(addressItem);
		
		planItem = new TextItem("plan", "(北京)发放凭证");
		planItem.setHidden(true);
		planItem.setWidth("*");
		planItem.setRequired(true);
		planItem.setDisabled(true);
		__formItems.add(planItem);
		
		transportationItem = new TextItem("transportation", "(深圳)发放凭证");
		transportationItem.setHidden(true);
		transportationItem.setWidth("*");
		transportationItem.setRequired(true);
		transportationItem.setDisabled(true);
		__formItems.add(transportationItem);
		
		attachmentIdItem = new TextItem("projectType", "(武汉、大连)发放凭证ID");
		attachmentIdItem.setHidden(true);
		__formItems.add(attachmentIdItem);
		
		attachmentId1Item = new TextItem("dutyId", "(上海)发放凭证ID");
		attachmentId1Item.setHidden(true);
		__formItems.add(attachmentId1Item);
		
		attachmentId2Item = new TextItem("startDateDetail", "(北京)发放凭证ID");
		attachmentId2Item.setHidden(true);
		__formItems.add(attachmentId2Item);
		
		attachmentId3Item = new TextItem("endDateDetail", "(深圳)发放凭证ID");
		attachmentId3Item.setHidden(true);
		__formItems.add(attachmentId3Item);
		
		attachmentItem = new LinkItem("上传发放凭证(武汉、大连)");
		attachmentItem.hide();
		attachmentItem.setLinkTitle("尚未上传发放凭证,请点击标题【上传发放凭证】上传");
		attachmentItem.setWidth("*");
		attachmentItem.setTitleStyle("labelTitleStyleClick");
		attachmentItem.setCanEdit(false);
		attachmentItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.DISABLED);
		attachmentItem.setRequired(true);
		__formItems.add(attachmentItem);
		attachmentItem.addTitleClickHandler(new TitleClickHandler() {
			@Override
			public void onTitleClick(TitleClickEvent event) {
				new CommonUploadWindow("上传发放凭证", false, 100, 2, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
                        //上传附件确认函成功
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							attachmentItem.setTitle("更新发放凭证");
							attachmentItem.setTitleStyle("labelTitleStyleClick");
							attachmentItem.setCanEdit(false);
							attachmentItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
							attachmentItem.setLinkTitle("已上传发放凭证,点击可下载/预览(点击【更新发放凭证】上传新的发放凭证)");
							attachmentItem.setValue(fileUrl);
							attachmentItem.redraw();
							reasonItem.setValue(fileUrl);
							attachmentIdItem.setValue(fileId);
						}
					}
				});
			}
		});
		
		attachment1Item = new LinkItem("上传发放凭证(上海)");
		attachment1Item.hide();
		attachment1Item.setLinkTitle("尚未上传发放凭证,请点击标题【上传发放凭证】上传");
		attachment1Item.setWidth("*");
		attachment1Item.setTitleStyle("labelTitleStyleClick");
		attachment1Item.setCanEdit(false);
		attachment1Item.setReadOnlyDisplay(ReadOnlyDisplayAppearance.DISABLED);
		attachment1Item.setRequired(true);
		__formItems.add(attachment1Item);
		attachment1Item.addTitleClickHandler(new TitleClickHandler() {
			@Override
			public void onTitleClick(TitleClickEvent event) {
				new CommonUploadWindow("上传发放凭证", false, 100, 2, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
                        //上传附件确认函成功
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							attachment1Item.setTitle("更新发放凭证");
							attachment1Item.setTitleStyle("labelTitleStyleClick");
							attachment1Item.setCanEdit(false);
							attachment1Item.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
							attachment1Item.setLinkTitle("已上传发放凭证,点击可下载/预览(点击【更新发放凭证】上传新的发放凭证)");
							attachment1Item.setValue(fileUrl);
							attachment1Item.redraw();
							addressItem.setValue(fileUrl);
							attachmentId1Item.setValue(fileId);
						}
					}
				});
			}
		});
		
		attachment2Item = new LinkItem("上传发放凭证(北京)");
		attachment2Item.hide();
		attachment2Item.setLinkTitle("尚未上传发放凭证,请点击标题【上传发放凭证】上传");
		attachment2Item.setWidth("*");
		attachment2Item.setTitleStyle("labelTitleStyleClick");
		attachment2Item.setCanEdit(false);
		attachment2Item.setReadOnlyDisplay(ReadOnlyDisplayAppearance.DISABLED);
		attachment2Item.setRequired(true);
		__formItems.add(attachment2Item);
		attachment2Item.addTitleClickHandler(new TitleClickHandler() {
			@Override
			public void onTitleClick(TitleClickEvent event) {
				new CommonUploadWindow("上传发放凭证", false, 100, 2, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
                        //上传附件确认函成功
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							attachment2Item.setTitle("更新发放凭证");
							attachment2Item.setTitleStyle("labelTitleStyleClick");
							attachment2Item.setCanEdit(false);
							attachment2Item.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
							attachment2Item.setLinkTitle("已上传发放凭证,点击可下载/预览(点击【更新发放凭证】上传新的发放凭证)");
							attachment2Item.setValue(fileUrl);
							attachment2Item.redraw();
							planItem.setValue(fileUrl);
							attachmentId2Item.setValue(fileId);
						}
					}
				});
			}
		});
		
		attachment3Item = new LinkItem("上传发放凭证(深圳)");
		attachment3Item.hide();
		attachment3Item.setLinkTitle("尚未上传发放凭证,请点击标题【上传发放凭证】上传");
		attachment3Item.setWidth("*");
		attachment3Item.setTitleStyle("labelTitleStyleClick");
		attachment3Item.setCanEdit(false);
		attachment3Item.setReadOnlyDisplay(ReadOnlyDisplayAppearance.DISABLED);
		attachment3Item.setRequired(true);
		__formItems.add(attachment3Item);
		attachment3Item.addTitleClickHandler(new TitleClickHandler() {
			@Override
			public void onTitleClick(TitleClickEvent event) {
				new CommonUploadWindow("上传发放凭证", false, 100, 2, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
                        //上传附件确认函成功
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							attachment3Item.setTitle("更新发放凭证");
							attachment3Item.setTitleStyle("labelTitleStyleClick");
							attachment3Item.setCanEdit(false);
							attachment3Item.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
							attachment3Item.setLinkTitle("已上传发放凭证,点击可下载/预览(点击【更新发放凭证】上传新的发放凭证)");
							attachment3Item.setValue(fileUrl);
							attachment3Item.redraw();
							transportationItem.setValue(fileUrl);
							attachmentId3Item.setValue(fileId);
						}
					}
				});
			}
		});
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(6);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(6);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		mainLayout.addMember(__form);
		if(processName.contains("出纳") || processName.contains("报销") || processName.contains("报税")){
			__form.setHeight("50%");
		}
//		if(processName.contains("出纳")){
//			__form.setHeight("50%");
//			salarySendPanel = new OnSalarySendDataPanel();
//			salarySendPanel.hide();
//			bonusSendPanel = new OnSalaryBonusSendDataPanel();
//			bonusSendPanel.hide();
//			salaryAnnualSendPanel = new SalaryAnnualbonusSendPanel();
//			salaryAnnualSendPanel.hide();
//			mainLayout.addMember(salarySendPanel); 
//			mainLayout.addMember(bonusSendPanel);
//			mainLayout.addMember(salaryAnnualSendPanel);
//		}else if(processName.contains("报销")){
//			__form.setHeight("50%");
//			salaryReportPanel = new OnSalaryReportByCompanyPanel();
//			salaryReportPanel.hide();
//			bonusReportPanel = new OnSalaryBonusTotalDataPanel();
//			bonusReportPanel.hide();
//			salaryAnnualReportPanel = new OnSalaryAnnualBonusByCompanyPanel();
//			salaryAnnualReportPanel.hide();
//			mainLayout.addMember(bonusReportPanel);
//			mainLayout.addMember(salaryReportPanel);
//			mainLayout.addMember(salaryAnnualReportPanel);
//		}else if(processName.contains("报税")){
//			__form.setHeight("50%");
//			salaryTaxPanel = new OnSalaryTaxDataPanel();
//			salaryTaxPanel.hide();
//			salaryAnnualPanel = new SalaryAnnualbonusTaxPanel();
//			salaryAnnualPanel.hide();
//			mainLayout.addMember(salaryTaxPanel);
//			mainLayout.addMember(salaryAnnualPanel);
//		}
		addMember(mainLayout);

	}

	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if (getRecord() != null){
			__form.editRecord(getRecord());
			int year = getRecord().getAttributeAsInt("companyProvince");
			int month = getRecord().getAttributeAsInt("targetProvince");
			int type = getRecord().getAttributeAsInt("type");
			if(type == 1){//薪资发放
				Integer personnelBusinessId = getRecord().getAttributeAsInt("personnelBusinessId");
				if(processName.contains("出纳")){
					OnSalarySendDataPanel panel = new OnSalarySendDataPanel();
					panel.initPanel(1, year, month);
					panel.commonQuery();
					mainLayout.addMember(panel);
				}else if(processName.contains("报销")){
					OnSalaryReportByCompanyPanel panel = new OnSalaryReportByCompanyPanel();
					panel.setPersonnelBusinessId(personnelBusinessId);
					panel.initPanel(this.processName, year, month);
					panel.commonQuery();
					mainLayout.addMember(panel);
				}else if(processName.contains("报税")){
					OnSalaryTaxDataPanel panel = new OnSalaryTaxDataPanel();
					mainLayout.addMember(panel);
				}
			}else if(type == 2){//奖金发放
				Integer personnelBusinessId = getRecord().getAttributeAsInt("personnelBusinessId");
				if(processName.contains("出纳")){
					OnSalaryBonusSendDataPanel panel = new OnSalaryBonusSendDataPanel();
					panel.initPanel(1, year, month );
					panel.setPersonnelBusinessId(personnelBusinessId);
					panel.commonQuery();
					mainLayout.addMember(panel);
				}else if(processName.contains("报销")){
					OnSalaryBonusTotalDataPanel panel = new OnSalaryBonusTotalDataPanel();
					panel.initPanel(this.processName, year, month);
					panel.setPersonnelBusinessId(personnelBusinessId);
					panel.commonQuery();
					mainLayout.addMember(panel);
				}
			}else if(type == 3){
				Integer personnelBusinessId = getRecord().getAttributeAsInt("personnelBusinessId");
				if(processName.contains("出纳")){
					SalaryAnnualbonusSendPanel panel = new SalaryAnnualbonusSendPanel();
					panel.initPanel(1, year, personnelBusinessId);
					panel.commonQuery();
					mainLayout.addMember(panel);
				}else if(processName.contains("报销")){
					OnSalaryAnnualBonusByCompanyPanel panel = new OnSalaryAnnualBonusByCompanyPanel();
					panel.initPanel(this.processName, year, personnelBusinessId);
					panel.commonQuery();
					mainLayout.addMember(panel);
				}else if(processName.contains("报税")){
					SalaryAnnualbonusTaxPanel panel = new SalaryAnnualbonusTaxPanel();
					panel.initSearchData(year, personnelBusinessId);
					panel.commonQuery();
					mainLayout.addMember(panel);
				}
			}
		}
		else{
			__form.editNewRecord();
		}
	}
	
//	@Override
//	public void startEdit() {
//		if (getRecord() != null){
//			__form.editRecord(getRecord());
//			int year = getRecord().getAttributeAsInt("companyProvince");
//			int month = getRecord().getAttributeAsInt("targetProvince");
//			int type = getRecord().getAttributeAsInt("type");
//			if(type == 1){//薪资发放
//				if(null != salarySendPanel){
//					salarySendPanel.show();
//					salarySendPanel.initPanel(1, year, month);
//					salarySendPanel.commonQuery();
//				}
//				if(null != salaryReportPanel){
//					salaryReportPanel.show();
//					salaryReportPanel.initPanel(this.processName, year, month);
//					salaryReportPanel.commonQuery();
//				}
//			}else if(type == 2){//奖金发放
//				if(null != bonusSendPanel){
//					bonusSendPanel.show();
//					bonusSendPanel.initPanel(1, year, month);
//					bonusSendPanel.commonQuery();
//				}
//				if(null != bonusReportPanel){
//					bonusReportPanel.show();
//					bonusReportPanel.initPanel(this.processName, year, month);
//					bonusReportPanel.commonQuery();
//				}
//			}else if(type == 3){
//				
//			}
//		}
//		else{
//			__form.editNewRecord();
//		}
//	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSpersonnelbusinesppor.getInstance());
		manager.addMember(__form);
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public java.util.Map getValuesAsMap() {
		Map valueMap = __form.getValues();
		return valueMap;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	
	public void initPanel(){
		if(!BaseHelpUtils.isNullOrEmpty(getProcessName())){
			
			if(this.processName.contains("出纳")){
				int employeeId = ClientUtil.getEmployeeId();
				if(employeeId == 109){// 武汉、大连
					attachmentItem.show();
				}else if(employeeId == 8){ //深圳
					attachment3Item.show();
				}else if(employeeId == 81){//北京
					attachment2Item.show();
				}else if(employeeId == 37){//上海
					attachment1Item.show();
				}
			}else if(this.processName.contains("报税")){
				
			}else if(this.processName.contains("报销")){
				
			}
		}
	}
}
