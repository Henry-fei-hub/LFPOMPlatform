package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DownloadFileByUrl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSRegularEmployeeApply;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.PrintPreviewCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.PrintCanvas;
import com.smartgwt.client.widgets.PrintWindow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.EditorExitEvent;
import com.smartgwt.client.widgets.form.fields.events.EditorExitHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class RegularEmployeeApplyUpdateForm extends AbstractWizadPage
{


	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final SelectItem typeItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextAreaItem reasonItem;
	private final TextAreaItem remarkItem;
	private final TextItem attachmentItem;
	private final TextItem dutyIdItem;
	private final SelectItem targetProvinceItem;
	private final TextItem feeItem;
	private final DoubleItem originalPayItem;
	private final DoubleItem monthPayItem;
	private final TextItem basicProportionStrItem;
	private final DoubleItem monthBasicPayItem;
	private final DoubleItem monthPerformancePayItem;
	private final DoubleItem foremanPayItem;
	private final DoubleItem otherSubsidyItem;
	private final DoubleItem totalPayItem;
	private final DoubleItem annualPerformanceItem;
	private final SelectItem companyProvinceItem;
	private final VLayout mainLayout;
	private final HLayout buttonLayout;
	private final IButton button_1;


	private final LinkItem addressItem;
	private final TextItem projectIdItem;

	private final LinkItem planItem;
	private final TextItem projectNameItem;

	private final LinkItem transportationItem;
	private final TextItem projectCodeItem;

	private IButton employeeAttachmentDownloadButton;
	private IButton employeeAttachmentUploadButton;

	private IButton professionalQualityAttachmentDownloadButton;
	private IButton professionalQualityAttachmentUpButton;

	private IButton SalaryAttachmentDownloadButton;
	private IButton SalaryUpButton;

	/**
	 * 转正员工
	 */
	private String processName_1 = "转正员工";
	/**
	 * 部门经理
	 */
	private String processName_2 = "部门经理";
	/**
	 * 人事经理
	 */
	private String processName_3 = "人事经理";
	/**
	 * 部门分管领导
	 */
	private String processName_4 = "部门分管领导";
	/**
	 * 人资部
	 */
	private String processName_5 = "人资部";
	/**
	 * 薪酬专员
	 */
	private String processName_6 = "薪酬专员";

	public RegularEmployeeApplyUpdateForm() {
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		DSRegularEmployeeApply ds = DSRegularEmployeeApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		employeeIdItem = new TextItem("employeeId", "转正员工姓名(支持姓名模糊搜索)");
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(employeeIdItem);

		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setDisabled(true);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(companyIdItem);
		
		startDateItem = new DateItem("startDate", "入职日期");
		startDateItem.setDisabled(true);
		startDateItem.setWidth("*");
		startDateItem.setUseMask(true);
		startDateItem.setUseTextField(true);
		startDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(startDateItem);

		departmentIdItem = new TextItem("departmentId", "所在部门");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		__formItems.add(departmentIdItem);

		typeItem = new SelectItem("type", "转正类型");//按期转正、提前转正
		typeItem.setWidth("*");
		typeItem.setControlStyle("customInputTextStyle");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_98"));
		__formItems.add(typeItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setWidth("*");
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(employeeNoItem);
		
		endDateItem = new DateItem("endDate", "转正日期");
		endDateItem.setWidth("*");
		endDateItem.setUseMask(true);
		endDateItem.setUseTextField(true);
		endDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(endDateItem);
		
		dutyIdItem = new TextItem("dutyId", "职务");
		dutyIdItem.setWidth("*");
		dutyIdItem.setTextBoxStyle("customInputTextStyle");
//		dutyIdItem.setValueMap(KeyValueManager.getValueMap("duties"));
		KeyValueManager.loadValueMap("duties", dutyIdItem);
		dutyIdItem.setDisabled(true);
		__formItems.add(dutyIdItem);
		
		attachmentItem = new TextItem("attachment", "附件");
		attachmentItem.setWidth("*");
		attachmentItem.setDisabled(true);
		attachmentItem.setTextBoxStyle("customInputTextStyle");
		attachmentItem.hide();
		__formItems.add(attachmentItem);
		
		targetProvinceItem = new SelectItem("targetProvince", "职级");
		targetProvinceItem.setWidth("*");
		targetProvinceItem.setControlStyle("customInputTextStyle");
		targetProvinceItem.hide();
		targetProvinceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));
		__formItems.add(targetProvinceItem);
		
		feeItem = new TextItem("fee", "个人效益指数");
		feeItem.setWidth("*");
		feeItem.setDisabled(true);
		feeItem.setTextBoxStyle("customInputTextStyle");
		feeItem.hide();
		__formItems.add(feeItem);
		
		originalPayItem = new DoubleItem("originalPay", "试用期薪资");
		originalPayItem.setWidth("*");
		originalPayItem.setTextBoxStyle("customInputTextStyle");
		originalPayItem.setLength(18);
		originalPayItem.setDecimalPad(2);
		originalPayItem.setFormat("#,###,###,###,###,##0.00");
		originalPayItem.hide();
		__formItems.add(originalPayItem);
		
		totalPayItem = new DoubleItem("totalPay", "转正后薪资");
		totalPayItem.setWidth("*");
		totalPayItem.setTextBoxStyle("customInputTextStyle");
		totalPayItem.setLength(18);
		totalPayItem.setDecimalPad(2);
		totalPayItem.setFormat("#,###,###,###,###,##0.00");
		totalPayItem.hide();
		__formItems.add(totalPayItem);
		totalPayItem.addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				if(null != event.getValue()){
					BigDecimal totalPay = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					BigDecimal foremanPay = BaseHelpUtils.getBigDecimalValue(foremanPayItem.getValue().toString());
					monthPayItem.setValue(totalPay.subtract(foremanPay));
					totalPayItem.setValue(totalPay);
				}else{
					totalPayItem.clearValue();
					monthPayItem.clearValue();
				}
				
			}
		});
		
		monthPayItem = new DoubleItem("monthPay", "月薪");
		monthPayItem.setWidth("*");
		monthPayItem.setTextBoxStyle("customInputTextStyle");
		monthPayItem.setLength(18);
		monthPayItem.setDecimalPad(2);
		monthPayItem.hide();
		monthPayItem.setFormat("#,###,###,###,###,##0.00");
		__formItems.add(monthPayItem);
		monthPayItem.addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				if(null != event.getValue()){
					BigDecimal sum = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					BigDecimal percent = new BigDecimal(null == basicProportionStrItem.getValue() ? "100" : basicProportionStrItem.getValue().toString().replace("%", ""));
					BigDecimal monthBasicPay = sum.multiply(percent).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN);
					monthPayItem.setValue(sum);
					monthBasicPayItem.setValue(monthBasicPay);
					monthPerformancePayItem.setValue(sum.subtract(monthBasicPay));
					if(null == processName || !processName.equals(processName_6)){
						BigDecimal foremanPay = BaseHelpUtils.getBigDecimalValue(foremanPayItem.getValue());
						totalPayItem.setValue(foremanPay.add(sum));
					}else if(null != processName || processName.equals(processName_6)){
						BigDecimal totalPay = BaseHelpUtils.getBigDecimalValue(totalPayItem.getValue());
						foremanPayItem.setValue(totalPay.subtract(sum));
					}
				}else{
					basicProportionStrItem.clearValue();
					monthBasicPayItem.clearValue();
					monthPerformancePayItem.clearValue();
				}
			}
		});
		
		foremanPayItem = new DoubleItem("foremanPay", "工龄工资");
		foremanPayItem.setWidth("*");
		foremanPayItem.setTextBoxStyle("customInputTextStyle");
		foremanPayItem.setLength(18);
		foremanPayItem.setDecimalPad(2);
		foremanPayItem.setFormat("#,###,###,###,###,##0.00");
		foremanPayItem.hide();
		__formItems.add(foremanPayItem);
		foremanPayItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				numberFormat(event.getValue(), event.getItem());
				if(null == processName || !processName.equals(processName_6)){
					BigDecimal monthPay = BaseHelpUtils.getBigDecimalValue(monthPayItem.getValue());
					BigDecimal foremanPay = BaseHelpUtils.getBigDecimalValue(foremanPayItem.getValue());
					totalPayItem.setValue(monthPay.add(foremanPay));
				}else if(null != processName || processName.equals(processName_6)){
					BigDecimal totalPay = BaseHelpUtils.getBigDecimalValue(totalPayItem.getValue());
					monthPayItem.setValue(totalPay.subtract(BaseHelpUtils.getBigDecimalValue(foremanPayItem.getValue())));
				}
			}
		});
		
		basicProportionStrItem = new TextItem("basicProportionStr", "基本比例(%)");
		basicProportionStrItem.setWidth("*");
		basicProportionStrItem.setTextBoxStyle("customInputTextStyle");
		basicProportionStrItem.hide();
		__formItems.add(basicProportionStrItem);
		basicProportionStrItem.addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				if(null != event.getValue()){
					String value = event.getValue().toString().replace("%", "");
					BigDecimal percent = new BigDecimal(value).setScale(0, BigDecimal.ROUND_DOWN);
					BigDecimal sum = new BigDecimal(null == monthPayItem.getValue() ? "0" : monthPayItem.getValue().toString());
					BigDecimal monthBasicPay = sum.multiply(percent).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN);
					basicProportionStrItem.setValue(percent+"%");
					monthBasicPayItem.setValue(monthBasicPay);
					monthPerformancePayItem.setValue(sum.subtract(monthBasicPay));
				}else{
					basicProportionStrItem.clearValue();
					monthBasicPayItem.clearValue();
					monthPerformancePayItem.clearValue();
				}
			}
		});
		
		otherSubsidyItem = new DoubleItem("otherSubsidy", "其他补贴");
		otherSubsidyItem.setWidth("*");
		otherSubsidyItem.setTextBoxStyle("customInputTextStyle");
		otherSubsidyItem.setLength(18);
		otherSubsidyItem.setDecimalPad(2);
		otherSubsidyItem.setFormat("#,###,###,###,###,##0.00");
		otherSubsidyItem.hide();
		__formItems.add(otherSubsidyItem);
		otherSubsidyItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				numberFormat(event.getValue(), event.getItem());
			}
		});
		
		monthBasicPayItem = new DoubleItem("monthBasicPay", "月基本工资");
		monthBasicPayItem.setWidth("*");
		monthBasicPayItem.setTextBoxStyle("customInputTextStyle");
		monthBasicPayItem.setLength(18);
		monthBasicPayItem.setDecimalPad(2);
		monthBasicPayItem.setFormat("#,###,###,###,###,##0.00");
		monthBasicPayItem.setDisabled(true);
		monthBasicPayItem.hide();
		__formItems.add(monthBasicPayItem);
		
		annualPerformanceItem = new DoubleItem("annualPerformance", "年度绩效");
		annualPerformanceItem.setWidth("*");
		annualPerformanceItem.setTextBoxStyle("customInputTextStyle");
		annualPerformanceItem.setLength(18);
		annualPerformanceItem.setDecimalPad(2);
		annualPerformanceItem.setFormat("#,###,###,###,###,##0.00");
		annualPerformanceItem.hide();
		__formItems.add(annualPerformanceItem);
		annualPerformanceItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				numberFormat(event.getValue(), event.getItem());
			}
		});
		
		monthPerformancePayItem = new DoubleItem("monthPerformancePay", "月绩效工资");
		monthPerformancePayItem.setWidth("*");
		monthPerformancePayItem.setTextBoxStyle("customInputTextStyle");
		monthPerformancePayItem.setLength(18);
		monthPerformancePayItem.setDecimalPad(2);
		monthPerformancePayItem.setFormat("#,###,###,###,###,##0.00");
		monthPerformancePayItem.setDisabled(true);
		monthPerformancePayItem.hide();
		__formItems.add(monthPerformancePayItem);
		
		companyProvinceItem = new SelectItem("costAttribution", "费用归属");
		companyProvinceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_114"));
		companyProvinceItem.setWidth("*");
		companyProvinceItem.setControlStyle("customInputTextStyle");
		companyProvinceItem.hide();
		__formItems.add(companyProvinceItem);
		
		
		reasonItem = new TextAreaItem("reason", "自我鉴定");
		reasonItem.setWidth("*");
		reasonItem.setHeight(200);
		reasonItem.setColSpan(2);
		reasonItem.setTextBoxStyle("customTextAreaStyle");
		reasonItem.hide();
		__formItems.add(reasonItem);
		
		remarkItem = new TextAreaItem("remark", "试用期工作总结");
		remarkItem.setWidth("*");
		remarkItem.setHeight(200);
		remarkItem.setColSpan(2);
		remarkItem.setTextBoxStyle("customTextAreaStyle");
		remarkItem.hide();
		__formItems.add(remarkItem);

		addressItem = new LinkItem("address");
		addressItem.setWidth("*");
		addressItem.setCanEdit(false);
		addressItem.setTitle("转正员工附件");
		addressItem.setHidden(false);
		__formItems.add(addressItem);

		projectIdItem = new TextItem("projectId", "转正员工附加ID");
		projectIdItem.setHidden(true);
		__formItems.add(projectIdItem);


		planItem = new LinkItem("plan");
		planItem.setWidth("*");
		planItem.setCanEdit(false);
		planItem.setTitle("职业素质考评表附件");
		planItem.setHidden(false);
		__formItems.add(planItem);

		projectNameItem = new TextItem("projectName", "职业素质考评表");
		projectNameItem.setHidden(true);
		__formItems.add(projectNameItem);


		transportationItem = new LinkItem("transportation");
		transportationItem.setWidth("*");
		transportationItem.setCanEdit(false);
		transportationItem.setHidden(false);
		transportationItem.setTitle("职位薪资说明表附件");
		__formItems.add(transportationItem);



		projectCodeItem = new TextItem("projectCode", "职位薪资说明表");
		projectCodeItem.setHidden(true);
		__formItems.add(projectCodeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		__form.setCellPadding(10);
		mainLayout.addMember(__form);


		
		button_1 = new IButton("打印转正申请书");
		button_1.setBaseStyle("customButton");
		button_1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					
					@Override
					public void onSuccess() {
						/*if(null == reasonItem.getValue() || null == remarkItem.getValue()){
							SC.say("请先填写自我鉴定和工作总结之后，再打印转正申请书");
							return;
						}*/
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "getRegularEmployeeHtml");
						params.put("businessId", getRecord().getAttribute("personnelBusinessId"));
						params.put("processType", getRecord().getAttribute("processType"));
						params.put("employeeName", KeyValueManager.getValue("employees", employeeIdItem.getValueAsString()));
						params.put("department", KeyValueManager.getValue("departments", departmentIdItem.getValueAsString()));
						params.put("duty", KeyValueManager.getValue("duties", dutyIdItem.getValueAsString()));
						params.put("grade", KeyValueManager.getValue("system_dictionary_3", targetProvinceItem.getValueAsString()));
						DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									Map userData = dsResponse.getAttributeAsMap("userData");
									if(null != userData){
										PopupWindow window = new PopupWindow();
										HTMLPane htmlPane = new HTMLPane();  
										htmlPane.setWidth100();  
										htmlPane.setHeight100();  
										htmlPane.setShowEdges(true);  
										htmlPane.setBackgroundColor("#fff");
										htmlPane.setContents(userData.get("html").toString());  
										htmlPane.setSelectContentOnSelectAll(true);  
										htmlPane.draw(); 
										htmlPane.show();
										window.addMember(htmlPane);
										window.setWidth100();
										window.setHeight100();
										window.centerInPage();
										window.show();
										Object[] arr = new Object[1];
										arr[0] = htmlPane;
										showPrintPreview(arr, null, "转正申请书", new PrintPreviewCallback() {
											@Override
											public void execute(PrintCanvas printCanvas, PrintWindow printWindow) {
												printWindow.addCloseClickHandler(new CloseClickHandler() {
													@Override
													public void onCloseClick(CloseClickEvent event) {
														htmlPane.destroy();
														window.destroy();
													}
												});
											}
										});
									}
								}else{
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
				});
			}
		});
		
		button_1.setWidth(120);
		button_1.hide();
		buttonLayout = new HLayout();
		buttonLayout.setMembersMargin(10);
		buttonLayout.addMember(button_1);
		mainLayout.addMember(buttonLayout);

		//下载附件模板
		setStyleName("customBackground");
		employeeAttachmentDownloadButton = new IButton("转正员工附件(下载)");
		employeeAttachmentDownloadButton.setWidth(150);
		employeeAttachmentDownloadButton.setBaseStyle("customButton");
		buttonLayout.addMember(employeeAttachmentDownloadButton);
		employeeAttachmentDownloadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DownloadFileByUrl.download("/files/新员工转正自我评价表.doc");
			}
		});

		employeeAttachmentUploadButton = new IButton("转正员工附件(上传)");
		employeeAttachmentUploadButton.setWidth(150);
		employeeAttachmentUploadButton.setBaseStyle("customButton");
		buttonLayout.addMember(employeeAttachmentUploadButton);
		employeeAttachmentUploadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				new CommonUploadWindow("上传附件", false, 100, 3, 1, new UploadCallBack() {

					@Override
					public void execute(Map<String, Record> data) {
						SC.debugger();
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							addressItem.setValue(fileUrl);
							projectIdItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							addressItem.setLinkTitle(fileName);
						}
					}
				});
			}
		});


		professionalQualityAttachmentDownloadButton = new IButton("职业素质考评表(下载)");
		professionalQualityAttachmentDownloadButton.setWidth(150);
		professionalQualityAttachmentDownloadButton.setBaseStyle("customButton");
		buttonLayout.addMember(professionalQualityAttachmentDownloadButton);
		professionalQualityAttachmentDownloadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DownloadFileByUrl.download("/files/职业素质考评表.doc");
			}
		});


		professionalQualityAttachmentUpButton = new IButton("职业素质考评表(上传)");
		professionalQualityAttachmentUpButton.setWidth(150);
		professionalQualityAttachmentUpButton.setBaseStyle("customButton");
		buttonLayout.addMember(professionalQualityAttachmentUpButton);
		professionalQualityAttachmentUpButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				new CommonUploadWindow("上传附件", false, 100, 3, 1, new UploadCallBack() {

					@Override
					public void execute(Map<String, Record> data) {
						SC.debugger();
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							planItem.setValue(fileUrl);
							projectNameItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							planItem.setLinkTitle(fileName);
						}
					}
				});
			}
		});

		SalaryAttachmentDownloadButton = new IButton("职位薪资说明表(下载)");
		SalaryAttachmentDownloadButton.setWidth(150);
		SalaryAttachmentDownloadButton.setBaseStyle("customButton");
		buttonLayout.addMember(SalaryAttachmentDownloadButton);
		SalaryAttachmentDownloadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DownloadFileByUrl.download("/files/职务及薪资说明表.doc");
			}
		});

		SalaryUpButton = new IButton("职位薪资说明表(上传)");
		SalaryUpButton.setWidth(150);
		SalaryUpButton.setBaseStyle("customButton");
		buttonLayout.addMember(SalaryUpButton);
		SalaryUpButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				new CommonUploadWindow("上传附件", false, 100, 3, 1, new UploadCallBack() {

					@Override
					public void execute(Map<String, Record> data) {
						SC.debugger();
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							transportationItem.setValue(fileUrl);
							projectCodeItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							transportationItem.setLinkTitle(fileName);
						}
					}
				});
			}
		});

		addMember(mainLayout);
		FormItem[] items = __form.getFields();
		int width = (mainLayout.getWidth()-30)/23*10;
		int width2 = width * 7 / 10;
		mainLayout.setLayoutLeftMargin(width * 3 / 10 + 10);
		mainLayout.setLayoutRightMargin(0);
		for(FormItem item : items){
			item.setWidth(width2);
		}
	}
	
	@Override
	public void startEdit() {
		Record record = getRecord();
		SC.debugger();
		if(record != null){
			__form.editRecord(record);
			if(null != processName && processName.equals(processName_1)){
				typeItem.setDisabled(true);
				endDateItem.setDisabled(true);
//				addressItem.setHidden(false);
//				planItem.hide();
//				transportationItem.hide();

				employeeAttachmentDownloadButton.show();
				employeeAttachmentUploadButton.show();
				professionalQualityAttachmentDownloadButton.hide();
				professionalQualityAttachmentUpButton.hide();
				SalaryAttachmentDownloadButton.hide();
				SalaryUpButton.hide();
//				reasonItem.show();
//				remarkItem.show();
			}else if(null != processName && processName.equals(processName_2)){
				typeItem.setDisabled(true);
				endDateItem.setDisabled(true);
//				addressItem.setHidden(false);
//				planItem.show();
//				transportationItem.hide();

				employeeAttachmentDownloadButton.hide();
				employeeAttachmentUploadButton.hide();
				professionalQualityAttachmentDownloadButton.show();
				professionalQualityAttachmentUpButton.show();
				SalaryAttachmentDownloadButton.hide();
				SalaryUpButton.hide();
//				reasonItem.setDisabled(true);
//				remarkItem.setDisabled(true);
			}else if(null != processName && (processName.equals(processName_3) )){
				typeItem.setDisabled(true);
				endDateItem.setDisabled(true);
//				addressItem.setHidden(false);
//				planItem.show();
//				transportationItem.show();

				employeeAttachmentDownloadButton.hide();
				employeeAttachmentUploadButton.hide();
				professionalQualityAttachmentDownloadButton.hide();
				professionalQualityAttachmentUpButton.hide();
				SalaryAttachmentDownloadButton.show();
				SalaryUpButton.show();

				targetProvinceItem.show();

			}
			if(null != record.getAttribute("reason")){
//				reasonItem.show();
			}
			if(null != record.getAttribute("remark")){
//				remarkItem.show();
			}
			if(null != record.getAttributeAsObject("drafter") && record.getAttribute("drafter").equals(ClientUtil.getUserId())){
				button_1.show();
			}
			//获取转正员工的附件
			int projectId = BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
			if (projectId != 0) {
				Map<Object, Object> params = new HashMap<>();
				getFileNameById(projectId, addressItem);
			}

			//获取职业素质考评表
			int projectName = BaseHelpUtils.getIntValue(record.getAttribute("projectName"));
			if (projectName != 0) {
				Map<Object, Object> params = new HashMap<>();
				getFileNameById(projectName, planItem);
			}

			//获取职务和薪资说明表
			int projectCode = BaseHelpUtils.getIntValue(record.getAttribute("projectCode"));
			if (projectCode != 0) {
				Map<Object, Object> params = new HashMap<>();
				getFileNameById(projectCode, transportationItem);
			}
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSRegularEmployeeApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null == typeItem.getValue()){
			SC.say("请选择转正类型");
			return false;
		}
		if(null == employeeIdItem.getValue()){
			SC.say("请填写上转正员工姓名");
			return false;
		}
		if(null == endDateItem.getValue()){
			SC.say("请填写上转正日期");
			return false;
		}
		if(null != processName && processName.equals(processName_1)){
			/*if(null == reasonItem.getValue()){
				SC.say("请填写上自我鉴定");
				return false;
			}
			if(null == remarkItem.getValue()){
				SC.say("请填写上试用期工作总结");
				return false;
			}*/


			if (BaseHelpUtils.isNullOrEmpty(addressItem.getValue())) {
				SC.say("提示", "请上传员工转正表附件");
				return false;
			}


		}else if(null != processName && processName.equals(processName_4)){
			if(null == totalPayItem.getValue()){
				SC.say("请填写转正工资");
				return false;
			}
			if(BaseHelpUtils.getBigDecimalValue(totalPayItem.getValue()).compareTo(BigDecimal.ZERO) <= 0){
				SC.say("请正确填写转正工资");
				return false;
			}
		}else if(null != processName && processName.equals(processName_2)){
			//部门经理节点必须上传附件才能提交
			Object value = planItem.getValue();
			if (BaseHelpUtils.isNullOrEmpty(value)) {
				SC.say("提示", "请上传职业素质考评表附件");
				return false;
			}
		} else if (null != processName && processName.equals(processName_3)) {
//			if (BaseHelpUtils.isNullOrEmpty(transportationItem.getValue())) {
//				SC.say("请上传职位薪资说明表附件");
//				return false;
//			}
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		if(map.containsKey("basicProportionStr")){
			String value = map.get("basicProportionStr").toString().replaceAll("%", "");
			BigDecimal percent = (new BigDecimal(value)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN);
			map.put("basicProportion", percent);
		}
		if(null != processName && (processName.equals(processName_3) || processName.equals(processName_4))){
			map.put("monthPay", BaseHelpUtils.getBigDecimalValue(map.get("totalPay")).subtract(BaseHelpUtils.getBigDecimalValue(map.get("foremanPay"))));
		}
		return map;
	}

	private String processName;

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	public void numberFormat(Object value, FormItem item){
		if(null != value){
			BigDecimal number = new BigDecimal(value.toString()).setScale(2, BigDecimal.ROUND_DOWN);
			item.setValue(number);
		}
	}

	/**
	 * @author liubin
	 * @date 2019/12/27 10:38
	 * @param
	 * @param addressItem
	 * @return
	 * @description:
	 */
	private void getFileNameById(Integer fileId, LinkItem addressItem) {
		Map<String, Object> params = new HashMap<>();
		params.put("fileId", fileId);
		DBDataSource.callOperation("ST_FileManage", "find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record datum = dsResponse.getData()[0];
					String fileName = BaseHelpUtils.getString(datum.getAttribute("fileName"));
					addressItem.setLinkTitle(fileName);
				} else {
					addressItem.setLinkTitle("转正员工附件");
				}
			}
		});
	}
}
