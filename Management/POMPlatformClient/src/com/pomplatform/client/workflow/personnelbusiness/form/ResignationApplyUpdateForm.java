package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DownloadFileByUrl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSResignationApply;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ResignationApplyUpdateForm extends AbstractWizadPage
{


	private final ComboBoxItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final ComboBoxItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final SelectItem typeItem;
	private final TextItem cardItem;
	private final DateItem startDateItem;
	private final DateTimeItem endDateItem;
	private final TextItem reasonItem;
	private final TextItem remarkItem;
	private final TextItem drafterItem;
	private final ComboBoxItem dutyIdItem;
	private final VLayout mainLayout;
	private String processName;
	private final DateTimeItem createTimeItem;
//	private final DoubleItem housingFinanceItem;
//	private final DoubleItem livingExpensesItem;
//	private final DoubleItem feeItem;
//	private final TextItem unitItem;
//	private final TextItem contactPersonItem;
//	private final SelectItem targetProvinceItem;
	private final SelectItem startDateDetailItem;
	private final SelectItem endDateDetailItem;
	private final SelectItem subTypeItem;
	private final TextItem subTypeStrItem;
	private final TextItem planItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem addressItem;
//	private final TextAreaItem transportationItem;
//	private final IntegerItem companyProvinceItem;
//	private final IntegerItem numberOfBabyItem;
//	private final TextItem equivalentNumberItem;
//	private final BooleanItem isRemoteCityItem;
//	private final DoubleItem severanceItem;
	private final String other = "其他";
	private static final int TYPE = 1;
	private WorkHandoverPanel workPanel;
	private final HLayout buttonLayout;

	//离职申请书
	private final LinkItem contactPersonItem;
	private final TextItem projectIdItem;
	//解除劳动合同申请书
	private final LinkItem equivalentNumberItem;
	private final TextItem companyProvinceItem;
	//离职承诺书
	private final LinkItem transportationItem;
	private final TextItem parentIdItem;
	//项目交接表
	private final LinkItem unitItem;
	private final TextItem projectIdsItem;
	//离职登记表
	private final LinkItem basicProportionStrItem;
	private final TextItem costAttributionItem;
	//解除劳动合同合同协议书
	private final LinkItem attachmentNameItem;
	private final TextItem attachmentItem;

	private IButton downloadButOne;
	private IButton uploadButTempOne;

	private IButton downloadButTwo;
	private IButton uploadButTempTwo;

	private IButton downloadButThree;
	private IButton uploadButTempThree;

	private IButton downloadButFour;
	private IButton uploadButTempFour;

	private IButton downloadButFive;

	private IButton uploadButSix;
	private IButton downloadButSix;



	private static final Logger __LOGGER = Logger.getLogger("");

	/**
	 * 人事专员
	 */
	private String processName1 = "人事专员";

	/**
	 * 申请人
	 */
	private String processName2 = "申请人";

	public ResignationApplyUpdateForm(String processName) {
		setProcessName(processName);

		setWidth100();
		setHeight100();

		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		mainLayout.setLayoutBottomMargin(0);
		
		DSResignationApply ds = DSResignationApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setValueMap(KeyValueManager.getValueMap("employees"));
		drafterItem.setWidth("*");
		drafterItem.setDisabled(true);
		drafterItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(drafterItem);
		
		companyIdItem = new SelectItem("companyId", "离职员工归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setDisabled(true);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setControlStyle("customInputTextStyle");
		__formItems.add(companyIdItem);
		
		typeItem = new SelectItem("type", "离职类型");
		typeItem.setWidth("*");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_94"));
		typeItem.setControlStyle("customInputTextStyle");
		typeItem.setDisabled(true);
		__formItems.add(typeItem);
		typeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					if(ClientUtil.checkAndGetIntValue(event.getValue()) == TYPE){
						//主动辞职
						if(null != workPanel) {
							workPanel.setEmployeeId(ClientUtil.getEmployeeId());
						}
						String employeeId = ClientUtil.getUserId();
						employeeIdItem.setValue(employeeId);
						getUserBasicInfo(employeeId);
						employeeIdItem.setDisabled(true);
						subTypeItem.show();
						endDateDetailItem.show();
						remarkItem.show();
					}else{
						//辞退员工
						if(null != workPanel) {
							workPanel.setEmployeeId(BaseHelpUtils.getIntValue(employeeIdItem.getValue()));
						}
						employeeIdItem.setDisabled(false);
						subTypeItem.hide();
						endDateDetailItem.hide();
						remarkItem.hide();
						projectCodeItem.hide();
						projectNameItem.hide();
						addressItem.hide();
					}
				}
			}
		});
		
		departmentIdItem = new ComboBoxItem("departmentId", "离职员工所在部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setControlStyle("customInputTextStyle");
		departmentIdItem.setChangeOnKeypress(false);
		departmentIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(departmentIdItem);
		
		ListGridField eNoField = new ListGridField("employeeNo");
		ListGridField eNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		
		employeeIdItem = new ComboBoxItem("employeeId", "离职员工姓名(支持姓名模糊搜索)");
		employeeIdItem.setWidth("*");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		employeeIdItem.setOptionCriteria(c);
		employeeIdItem.setValueField("employeeId");
		employeeIdItem.setDisplayField("employeeName");
		employeeIdItem.setPickListFields(eNoField, eNameField, departmentIdField);
		employeeIdItem.setControlStyle("customInputTextStyle");
		__formItems.add(employeeIdItem);
		employeeIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					getUserBasicInfo(event.getValue());
					if(BaseHelpUtils.getIntValue(typeItem.getValue()) == TYPE) {
						//主动辞职
						workPanel.setEmployeeId(ClientUtil.getEmployeeId());
					}else {
						//辞退员工
						workPanel.setEmployeeId(BaseHelpUtils.getIntValue(employeeIdItem.getValue()));
					}
				}else{
					employeeNoItem.clearValue();
					departmentIdItem.clearValue();
					companyIdItem.clearValue();
					cardItem.clearValue();
					startDateItem.clearValue();
				}
			}
		});
		
		employeeNoItem = new TextItem("employeeNo", "离职员工工号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(employeeNoItem);
		
		startDateItem = new DateItem("startDate", "入职日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.setDisabled(true);
		startDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(startDateItem);
		
		cardItem = new TextItem("card", "离职员工身份证");
		cardItem.setWidth("*");
		cardItem.setDisabled(true);
		cardItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(cardItem);
		
		endDateItem = new DateTimeItem("endDate", "最后工作时间");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		endDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(endDateItem);
		
		dutyIdItem = new ComboBoxItem("dutyId", "职务");
		dutyIdItem.setWidth("*");
		dutyIdItem.setDisabled(true);
		dutyIdItem.setControlStyle("customInputTextStyle");
		dutyIdItem.setValueMap(KeyValueManager.getValueMap("duties"));
		dutyIdItem.setChangeOnKeypress(false);
		dutyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(dutyIdItem);
		
		startDateDetailItem = new SelectItem("startDateDetail", "离职原因");
		startDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_101"));
		startDateDetailItem.setWidth("*");
		startDateDetailItem.setControlStyle("customInputTextStyle");
		startDateDetailItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					String value = KeyValueManager.getValue("system_dictionary_101", event.getValue().toString());
					//当选中了"其他"的时候，显示"其他的输入框"，让用户输入其他原因
					if(value.equals(other)){
						projectCodeItem.show();
						projectCodeItem.clearValue();
					}else{
						projectCodeItem.hide();
						projectCodeItem.clearValue();
					}
				}
			}
		});
		__formItems.add(startDateDetailItem);
		
		projectCodeItem = new TextItem("projectCode", "离职原因（其他）");
		projectCodeItem.setWidth("*");
		projectCodeItem.hide();
		projectCodeItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(projectCodeItem);
		
		reasonItem = new TextItem("reason", "离职原因");
		reasonItem.setWidth("*");
		reasonItem.hide();
		reasonItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(reasonItem);
		

		subTypeItem = new SelectItem("subType", "您认为公司哪些方面需要改善（最多三项）");
		subTypeItem.setMultiple(true);
		subTypeItem.setWidth("*");
		subTypeItem.setControlStyle("customInputTextStyle");
		subTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_102"));
		subTypeItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue()){
					Object[] arr = (Object[]) event.getValue();
					if(arr.length > 3){
						SC.say("最多只能选择三项！");
						event.cancel();
					}else{
						boolean show = false;
						for(Object obj : arr){
							String value = KeyValueManager.getValue("system_dictionary_102", obj.toString());
							if(value.equals(other)){
								show = true;
							}
							if(show){
								projectNameItem.show();
								if(!subTypeItem.getDisplayValue().contains(other)){
									projectNameItem.clearValue();
								}
							}else{
								projectNameItem.hide();
							}
						}
					}
				}
			}
		});
		__formItems.add(subTypeItem);
		
		projectNameItem = new TextItem("projectName", "您认为公司哪些方面需要改善（其他）");
		projectNameItem.setWidth("*");
		projectNameItem.hide();
		projectNameItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(projectNameItem);

		subTypeStrItem = new TextItem("subTypeStr", "您认为公司哪些方面需要改善");
		subTypeStrItem.setWidth("*");
		subTypeStrItem.hide();
		subTypeStrItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(subTypeStrItem);
		
		endDateDetailItem = new SelectItem("endDateDetail", "您离职后的计划");
		endDateDetailItem.setWidth("*");
		endDateDetailItem.hide();
		endDateDetailItem.setControlStyle("customInputTextStyle");
		endDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_103"));
		endDateDetailItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					String value = KeyValueManager.getValue("system_dictionary_103", event.getValue().toString());
					if(value.equals(other)){
						addressItem.show();
						addressItem.clearValue();
					}else{
						addressItem.hide();
						addressItem.clearValue();
					}
				}
			}
		});
		__formItems.add(endDateDetailItem);
		
		addressItem = new TextItem("address", "您离职后的计划（其他）");
		addressItem.setWidth("*");
		addressItem.hide();
		addressItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(addressItem);
		addressItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					planItem.setValue(event.getValue());
				}
			}
		});
		
		planItem = new TextItem("plan", "您离职后的计划");
		planItem.setWidth("*");
		planItem.hide();
		planItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(planItem);
		
		remarkItem = new TextItem("remark", "给公司的建议");
		remarkItem.setWidth("*");
		remarkItem.hide();
		remarkItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(remarkItem);

		createTimeItem = new DateTimeItem("createTime", "申请时间");
		createTimeItem.setWidth("*");
		createTimeItem.setDisabled(true);
		createTimeItem.setUseTextField(true);
		createTimeItem.setUseMask(true);
		createTimeItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(createTimeItem);
		
		/*targetProvinceItem = new SelectItem("targetProvince", "当月绩效情况");
		targetProvinceItem.hide();
		targetProvinceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_99"));
		targetProvinceItem.setControlStyle("customInputTextStyle");
		targetProvinceItem.setWidth("*");
		__formItems.add(targetProvinceItem);
		
		contactPersonItem = new TextItem("contactPerson", "借款情况");
		contactPersonItem.setWidth("*");
		contactPersonItem.hide();
		contactPersonItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(contactPersonItem);
		
		livingExpensesItem = new DoubleItem("livingExpenses", "最终账户积分");
		livingExpensesItem.setWidth("*");
		livingExpensesItem.setTextBoxStyle("customInputTextStyle");
		livingExpensesItem.setLength(18);
		livingExpensesItem.setDecimalPad(2);
		livingExpensesItem.setFormat("#,###,###,###,###,##0.00");
		livingExpensesItem.hide();
		__formItems.add(livingExpensesItem);
		livingExpensesItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					BigDecimal number = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					livingExpensesItem.setValue(number);
				}else{
					livingExpensesItem.setValue(0);
				}
			}
		});
		
		housingFinanceItem = new DoubleItem("housingFinance", "冻结积分");
		housingFinanceItem.setWidth("*");
		housingFinanceItem.setTextBoxStyle("customInputTextStyle");
		housingFinanceItem.setLength(18);
		housingFinanceItem.setDecimalPad(2);
		housingFinanceItem.setFormat("#,###,###,###,###,##0.00");
		housingFinanceItem.hide();
		__formItems.add(housingFinanceItem);
		housingFinanceItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				BigDecimal amount = new BigDecimal(livingExpensesItem.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
				if(null != event.getValue()){
					BigDecimal number = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					housingFinanceItem.setValue(number);
					feeItem.setValue(amount.subtract(number));
				}else{
					housingFinanceItem.setValue(0);
					feeItem.setValue(amount);
				}
			}
		});
		
		feeItem = new DoubleItem("fee", "设计师离职奖金");
		feeItem.setWidth("*");
		feeItem.setTextBoxStyle("customInputTextStyle");
		feeItem.setLength(18);
		feeItem.setDecimalPad(2);
		feeItem.setFormat("#,###,###,###,###,##0.00");
		feeItem.hide();
		__formItems.add(feeItem);
		feeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				BigDecimal amount = new BigDecimal(livingExpensesItem.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
				if(null != event.getValue()){
					BigDecimal number = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					feeItem.setValue(number);
					housingFinanceItem.setValue(amount.subtract(number));
				}else{
					feeItem.setValue(0);
					housingFinanceItem.setValue(amount);
				}
			}
		});
		
		severanceItem = new DoubleItem("severance", "离职补偿金");
		severanceItem.setWidth("*");
		severanceItem.setTextBoxStyle("customInputTextStyle");
		severanceItem.setLength(18);
		severanceItem.setDecimalPad(2);
		severanceItem.setFormat("#,###,###,###,###,##0.00");
		severanceItem.hide();
		__formItems.add(severanceItem);
		severanceItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					BigDecimal number = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					severanceItem.setValue(number);
				}else{
					severanceItem.setValue(0);
				}
			}
		});
		
		unitItem = new TextItem("unit", "社保/公积金停缴月份");
		unitItem.setWidth("*");
		unitItem.hide();
		unitItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(unitItem);
		
		transportationItem = new TextAreaItem("transportation", "离职考勤");
		transportationItem.setWidth("*");
		transportationItem.setColSpan(2);
		transportationItem.setRowSpan(3);
		transportationItem.setTextBoxStyle("customTextAreaStyle");
		transportationItem.hide();
		__formItems.add(transportationItem);
		
		equivalentNumberItem = new TextItem("equivalentNumber", "办公电脑等设备");
		equivalentNumberItem.setTextBoxStyle("customInputTextStyle");
		equivalentNumberItem.hide();
		__formItems.add(equivalentNumberItem);
		
		companyProvinceItem = new IntegerItem("companyProvince", "拖柜钥匙数量");
		companyProvinceItem.setTextBoxStyle("customInputTextStyle");
		companyProvinceItem.hide();
		__formItems.add(companyProvinceItem);
		
		numberOfBabyItem = new IntegerItem("numberOfBaby", "储物柜钥匙数量");
		numberOfBabyItem.setTextBoxStyle("customInputTextStyle");
		numberOfBabyItem.hide();
		__formItems.add(numberOfBabyItem);
		
		isRemoteCityItem = new BooleanItem("isRemoteCity", "工卡是否已回收");
		isRemoteCityItem.hide();
		__formItems.add(isRemoteCityItem);*/

		contactPersonItem = new LinkItem("contactPerson");
		contactPersonItem.setWidth("*");
		contactPersonItem.setTitle("离职申请书");
		__formItems.add(contactPersonItem);

		projectIdItem = new TextItem("projectId", "离职申请书");
		projectIdItem.setWidth("*");
		projectIdItem.hide();
		__formItems.add(projectIdItem);

		equivalentNumberItem = new LinkItem("equivalentNumber");
		equivalentNumberItem.setWidth("*");
		equivalentNumberItem.setTitle("解除劳动合同申请书");
		__formItems.add(equivalentNumberItem);

		companyProvinceItem = new TextItem("companyProvince", "解除劳动合同申请书");
		companyProvinceItem.setWidth("*");
		companyProvinceItem.hide();
		__formItems.add(companyProvinceItem);

		transportationItem = new LinkItem("transportation");
		transportationItem.setWidth("*");
		transportationItem.hide();
		transportationItem.setTitle("离职承诺书");
		__formItems.add(transportationItem);

		parentIdItem = new TextItem("parentId", "离职承诺书");
		parentIdItem.setWidth("*");
		parentIdItem.hide();
		__formItems.add(parentIdItem);

		unitItem = new LinkItem("unit");
		unitItem.setWidth("*");
		unitItem.hide();
		unitItem.setTitle("项目交接表");
		__formItems.add(unitItem);

		projectIdsItem = new TextItem("projectIds", "项目交接表");
		projectIdsItem.setWidth("*");
		projectIdsItem.hide();
		__formItems.add(projectIdsItem);

		basicProportionStrItem = new LinkItem("basicProportionStr");
		basicProportionStrItem.setWidth("*");
		basicProportionStrItem.hide();
		basicProportionStrItem.setTitle("离职登记表");
		__formItems.add(basicProportionStrItem);

		costAttributionItem = new TextItem("costAttribution", "离职登记表");
		costAttributionItem.setWidth("*");
		costAttributionItem.hide();
		__formItems.add(costAttributionItem);

		attachmentNameItem = new LinkItem("attachmentName");
		attachmentNameItem.setWidth("*");
		attachmentNameItem.hide();
		attachmentNameItem.setTitle("解除劳动合同协议书");
		__formItems.add(attachmentNameItem);

		attachmentItem = new TextItem("attachment", "解除劳动合同协议书");
		attachmentItem.setWidth("*");
		attachmentItem.hide();
		__formItems.add(attachmentItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		__form.setCellPadding(10);
		mainLayout.addMember(__form);

		buttonLayout = new HLayout();
		buttonLayout.setMembersMargin(10);
		mainLayout.addMember(buttonLayout);

		//离职申请书附件
		downloadButOne = new IButton("离职申请书(下载)");
		downloadButOne.setWidth("130");
		downloadButOne.hide();
//		downloadButOne.setBaseStyle("customButton");
		buttonLayout.addMember(downloadButOne);
		downloadButOne.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DownloadFileByUrl.download("/files/离职申请书.doc");
			}
		});
		uploadButTempOne = new IButton("离职申请书(上传)");
		uploadButTempOne.setWidth("130");
		uploadButTempOne.hide();
		buttonLayout.addMember(uploadButTempOne);
//		uploadButTempOne.setBaseStyle("customButton");
		uploadButTempOne.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				new CommonUploadWindow("上传附件", false, 100, 3 ,null, new UploadCallBack() {

					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							contactPersonItem.setValue(fileUrl);
							projectIdItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							contactPersonItem.setLinkTitle(fileName);
						}
					}
				});
			}
		});

		//解除劳动合同申请书
		downloadButTwo = new IButton("解除劳动合同申请书(下载)");
		downloadButTwo.setWidth("180");
		downloadButTwo.hide();
//		downloadButTwo.setBaseStyle("customButton");
		buttonLayout.addMember(downloadButTwo);
		downloadButTwo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DownloadFileByUrl.download("/files/解除劳动合同申请书.doc");
			}
		});
		uploadButTempTwo = new IButton("解除劳动合同申请书(上传)");
		uploadButTempTwo.setWidth("180");
		uploadButTempTwo.hide();
//		uploadButTempTwo.setBaseStyle("customButton");
		buttonLayout.addMember(uploadButTempTwo);
		uploadButTempTwo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				new CommonUploadWindow("上传附件", false, 100, 3, null, new UploadCallBack() {

					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							equivalentNumberItem.setValue(fileUrl);
							companyProvinceItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							equivalentNumberItem.setLinkTitle(fileName);
						}
					}
				});
			}
		});

		//解除劳动合同申请书
		downloadButThree = new IButton("离职承诺书(下载)");
		downloadButThree.setWidth(150);
		downloadButThree.hide();
//		downloadButThree.setBaseStyle("customButton");
		buttonLayout.addMember(downloadButThree);
		downloadButThree.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DownloadFileByUrl.download("/files/离职承诺书.doc");
			}
		});
		uploadButTempThree = new IButton("离职承诺书(上传)");
		uploadButTempThree.setWidth(150);
		uploadButTempThree.hide();
//		uploadButTempThree.setBaseStyle("customButton");
		buttonLayout.addMember(uploadButTempThree);
		uploadButTempThree.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				new CommonUploadWindow("上传附件", false, 100, 2, null, new UploadCallBack() {

					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							transportationItem.setValue(fileUrl);
							parentIdItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							transportationItem.setLinkTitle(fileName);
						}
					}
				});
			}
		});

		//项目交接表
		downloadButFour = new IButton("项目交接表(下载)");
		downloadButFour.setWidth(150);
		downloadButFour.hide();
		buttonLayout.addMember(downloadButFour);
//		downloadButFour.setBaseStyle("customButton");
		downloadButFour.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DownloadFileByUrl.download("/files/项目交接表.doc");
			}
		});
		uploadButTempFour = new IButton("项目交接表(上传)");
		uploadButTempFour.setWidth(150);
		uploadButTempFour.hide();
//		uploadButTempFour.setBaseStyle("customButton");
		buttonLayout.addMember(uploadButTempFour);
		uploadButTempFour.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				new CommonUploadWindow("上传附件", false, 100, 2, null, new UploadCallBack() {
					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							unitItem.setValue(fileUrl);
							projectIdsItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							unitItem.setLinkTitle(fileName);
						}
					}
				});
			}
		});


		//离职登记表
		downloadButSix = new IButton("离职登记表(下载)");
		downloadButSix.setWidth(150);
		downloadButSix.hide();
		buttonLayout.addMember(downloadButSix);
		downloadButSix.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DownloadFileByUrl.download("/files/离职登记表.doc");
			}
		});

		uploadButSix= new IButton("离职登记表(上传)");
		uploadButSix.setWidth(150);
		uploadButSix.hide();
		buttonLayout.addMember(uploadButSix);
		uploadButSix.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				new CommonUploadWindow("上传附件", false, 100, 2, null, new UploadCallBack() {
					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							basicProportionStrItem.setValue(fileUrl);
							costAttributionItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							basicProportionStrItem.setLinkTitle(fileName);
						}
					}
				});
			}
		});


		//解除劳动合同协议书
		downloadButFive = new IButton("解除劳动合同协议书(上传)");
		downloadButFive.setWidth(180);
		downloadButFive.hide();
//		downloadButFive.setBaseStyle("customButton");
		buttonLayout.addMember(downloadButFive);
		downloadButFive.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				new CommonUploadWindow("上传附件", false, 100, 2, null, new UploadCallBack() {
					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							attachmentNameItem.setValue(fileUrl);
							attachmentItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							attachmentNameItem.setLinkTitle(fileName);
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
		SC.debugger();
		Record record = getRecord();
		if(null != record){
			__form.editRecord(record);
			if(startDateDetailItem.getDisplayValue().equals(other)){
				projectCodeItem.show();
			}
			String str = record.getAttribute("subType");
			if(!ClientUtil.isNullOrEmpty(str)){
				subTypeItem.setValues(str.split(","));
			}
			if(null != record.getAttribute("type") && BaseHelpUtils.getIntValue(record.getAttribute("type")) == TYPE){
				employeeIdItem.setDisabled(true);
				if(ClientUtil.getUserId().equals(record.getAttribute("employeeId"))){
					subTypeItem.show();
					endDateDetailItem.show();
					remarkItem.show();
					/*String str = record.getAttribute("subType");
					if(!ClientUtil.isNullOrEmpty(str)){
						subTypeItem.setValues(str.split(","));
					}*/
					if(subTypeItem.getDisplayValue().contains(other)){
						projectNameItem.show();
					}
					if(endDateDetailItem.getDisplayValue().equals(other)){
						addressItem.show();
					}
				}
			}
			//获取离职申请书附件ID
			int projectId = BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
			if (projectId != 0) {
				getFileNameById(projectId, contactPersonItem);
			}
			//获取解除劳动合同申请书
			int companyProvince = BaseHelpUtils.getIntValue(record.getAttribute("companyProvince"));
			if (companyProvince != 0) {
				getFileNameById(companyProvince, equivalentNumberItem);
			}
			//获取离职承诺书
			int parentId = BaseHelpUtils.getIntValue(record.getAttribute("parentId"));
			if (companyProvince != 0) {
				getFileNameById(parentId, transportationItem);
			}
			//获取项目交接表
			int projectIds = BaseHelpUtils.getIntValue(record.getAttribute("projectIds"));
			if (companyProvince != 0) {
				getFileNameById(projectIds, unitItem);
			}
			//获取离职登记表
			int costAttribution = BaseHelpUtils.getIntValue(record.getAttribute("costAttribution"));
			if (companyProvince != 0) {
				getFileNameById(costAttribution, basicProportionStrItem);
			}
			//获取解除劳动合同合同协议书
			int attachment = BaseHelpUtils.getIntValue(record.getAttribute("attachment"));
			if (companyProvince != 0) {
				getFileNameById(attachment, attachmentNameItem);
			}
		}

		__LOGGER.info("------------------- processName :" + processName);
		if (BaseHelpUtils.isNullOrEmpty(processName)) {
			//主动离职
			__LOGGER.info("-------------------- typeItem.getValue()" + typeItem.getValue());
			if (BaseHelpUtils.getIntValue(typeItem.getValue()) == 1) {

				contactPersonItem.show();
				equivalentNumberItem.show();

				uploadButTempOne.show();
				uploadButTempTwo.show();

			} else {
				contactPersonItem.hide();
				equivalentNumberItem.hide();

				uploadButTempOne.hide();
				uploadButTempTwo.hide();
			}
		} else {
			if (BaseHelpUtils.getIntValue(typeItem.getValue()) == 1) {
				contactPersonItem.show();
				equivalentNumberItem.show();
				transportationItem.show();
				unitItem.show();
				basicProportionStrItem.show();
			}else{
				contactPersonItem.hide();
				equivalentNumberItem.hide();
				transportationItem.show();
				unitItem.show();
				basicProportionStrItem.show();
			}
			if (BaseHelpUtils.getIntValue(typeItem.getValue()) == 1) {
				if (processName2.equals(processName)) {
					/*subTypeItem.show();
					endDateDetailItem.show();
					remarkItem.show();
					transportationItem.show();
					basicProportionStrItem.show();
					unitItem.show();*/
					//申请自己上传离职承诺书和项目交接表以及离职登记表
					downloadButThree.show();
					uploadButTempThree.show();
					downloadButFour.show();
					uploadButTempFour.show();
					downloadButSix.show();
					uploadButSix.show();
				} else if (processName1.equals(processName)) {
					/*subTypeItem.show();
					endDateDetailItem.show();
					remarkItem.show();
					contactPersonItem.show();
					equivalentNumberItem.show();
					transportationItem.show();
					unitItem.show();*/

					attachmentNameItem.show();

					downloadButFive.show();
				}
			} else {
				subTypeItem.hide();
				downloadButOne.hide();
				uploadButTempOne.hide();
				downloadButTwo.hide();
				uploadButTempTwo.hide();

				startDateDetailItem.setCanEdit(false);
				employeeIdItem.setCanEdit(false);
				if (processName2.equals(processName)) {
					endDateItem.setCanEdit(false);
				/*	subTypeItem.show();
					endDateDetailItem.show();
					remarkItem.show();
					transportationItem.show();
					unitItem.show();*/
					//申请自己上传离职承诺书和项目交接表
					downloadButThree.show();
					uploadButTempThree.show();
					downloadButFour.show();
					uploadButTempFour.show();
					uploadButSix.show();
					downloadButSix.show();
				} else if (processName1.equals(processName)) {

					subTypeItem.setCanEdit(false);
					endDateDetailItem.setCanEdit(false);
					remarkItem.setCanEdit(false);

					/*subTypeItem.show();
					endDateDetailItem.show();
					remarkItem.show();
					contactPersonItem.hide();
					equivalentNumberItem.hide();
					transportationItem.show();
					unitItem.show();*/
					attachmentNameItem.show();
					downloadButFive.show();
				}
			}
		}

	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSResignationApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null == typeItem.getValue()){
			SC.say("请选择离职类型");
			return false;
		}
		if(null == employeeIdItem.getValue()){
			SC.say("请填写上离职员工姓名");
			return false;
		}
		if(null == endDateItem.getValue()){
			SC.say("请填写上最后工作时间");
			return false;
		}
		if(ClientUtil.checkAndGetIntValue(typeItem.getValue()) == TYPE){
			//主动离职的必填项控制
			if(null == startDateDetailItem.getValue()){
				SC.say("请选择离职原因");
				return false;
			}else{
				if(startDateDetailItem.getDisplayValue().equals(other) && (null == projectCodeItem.getValue() || (null != projectCodeItem.getValue() && projectCodeItem.getValue().toString().trim().length() == 0))){
					SC.say("请填写离职原因（其他）");
					return false;
				}
			}
			if(null == subTypeItem.getValue()){
				SC.say("请选择“您认为公司哪些方面需要改善（最多三项）”");
				return false;
			}else{
				String[] arr = subTypeItem.getValues();
				if(arr.length > 3){
					SC.say("“您认为公司哪些方面需要改善”最多只能选择三项");
					return false;
				}
				if(subTypeItem.getDisplayValue().contains(other) && (null == projectNameItem.getValue() || (null != projectNameItem.getValue() && projectNameItem.getValue().toString().trim().length() == 0))){
					SC.say("请填写“您认为公司哪些方面需要改善（其他）”");
					return false;
				}
			}
			if(null == endDateDetailItem.getValue()){
				SC.say("请选择您离职后的计划");
				return false;
			}else{
				if(endDateDetailItem.getDisplayValue().equals(other) && (null == addressItem.getValue() || (null != addressItem.getValue() && addressItem.getValue().toString().trim().length() == 0))){
					SC.say("请填写您离职后的计划（其他）");
					return false;
				}
			}
			if(null == remarkItem.getValue() || (null != remarkItem.getValue() && remarkItem.getValue().toString().trim().length() == 0)){
				SC.say("请填写您对公司的建议");
				return false;
			}

		}
		//离职人员需要上传《项目交接表》、《离职登记表》《离职承诺保证书》
		if (processName2.equals(processName)) {
			if (null == transportationItem.getValue()) {
				SC.say("请上传离职承诺书");
				return false;
			}
			if (null == unitItem.getValue()) {
				SC.say("请上传项目交接表");
				return false;
			}
			if (null == basicProportionStrItem.getValue()) {
				SC.say("请上传离职登记表");
				return false;
			}
		}
		//人事专员必须上传解除劳动合同协议书
		if (processName1.equals(processName)) {
			if (null == attachmentNameItem.getValue()) {
				SC.say("请上传解除劳动合同协议书");
				return false;
			}
		}
		//撤销修改界面必须上传离职申请书和解除劳动合同申请书
		if (BaseHelpUtils.isNullOrEmpty(processName)) {
			if (null == contactPersonItem.getValue()) {
				SC.say("请上传离职申请书");
				return false;
			}
			if (null == equivalentNumberItem.getValue()) {
				SC.say("请上传解除劳动合同申请书");
				return false;
			}
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		if(null != startDateDetailItem.getValue() && startDateDetailItem.getDisplayValue().equals("其他") && null != projectCodeItem.getValue()){
			map.put("reason", projectCodeItem.getValue());
		}else{
			map.put("reason", startDateDetailItem.getDisplayValue());
		}
		String[] arr = subTypeItem.getValues();
		if(null != arr && arr.length > 0){
			StringBuilder sb = new StringBuilder();
			for(String str : arr){
				if(sb.length() > 0){
					sb.append(",");
				}
				sb.append(str);
			}
			map.put("subType", sb.toString());
		}
		if(subTypeItem.isVisible()){
			if(null != subTypeItem.getValue() && subTypeItem.getDisplayValue().contains("其他") && null != projectNameItem.getValue()){
				map.put("subTypeStr", subTypeItem.getDisplayValue().replace("其他", projectNameItem.getValue().toString()));
			}else{
				map.put("subTypeStr", subTypeItem.getDisplayValue());
			}
		}
		
		if(null != endDateDetailItem.getValue() && endDateDetailItem.getDisplayValue().equals("其他") && null != addressItem.getValue()){
			map.put("plan", addressItem.getValue());
		}else{
			map.put("plan", endDateDetailItem.getDisplayValue());
		}
		return map;
	}

	public void getUserBasicInfo(Object employeeId) {
		Map<String, Object> params = new HashMap<>();
		params.put("optType", "getBasicInfo");
		params.put("employeeId", employeeId);
		DBDataSource.callOperation("EP_GetUserInfoById", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					if(null != record){
						if(null != record.getAttribute("employeeNo")){
							employeeNoItem.setValue(record.getAttribute("employeeNo"));
						}
						if(null != record.getAttribute("departmentId")){
							departmentIdItem.setValue(record.getAttribute("departmentId"));
						}
						if(null != record.getAttribute("companyId")){
							companyIdItem.setValue(record.getAttribute("companyId"));
						}
						if(null != record.getAttribute("card")){
							cardItem.setValue(record.getAttribute("card"));
						}
						if(null != record.getAttribute("onboardDate")){
							startDateItem.setValue(record.getAttributeAsDate("onboardDate"));
						}
						if(null != record.getAttribute("dutyId")){
							dutyIdItem.setValue(record.getAttribute("dutyId"));
						}
					}
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public WorkHandoverPanel getWorkPanel() {
		return workPanel;
	}

	public void setWorkPanel(WorkHandoverPanel workPanel) {
		this.workPanel = workPanel;
	}

	/**
	 * @author liubin
	 * @date 2019/12/27 12:10
	 * @param
	 * @return
	 * @description:  查询附件的名称
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
