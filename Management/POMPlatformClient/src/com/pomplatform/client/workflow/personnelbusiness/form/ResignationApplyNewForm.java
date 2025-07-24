package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DownloadFileByUrl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.ERPPermissionStatic;
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

public class ResignationApplyNewForm extends AbstractWizadPage
{


	private final SelectItem processTypeItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final SelectItem typeItem;
	private final TextItem cardItem;
	private final DateItem startDateItem;
	private final DateTimeItem endDateItem;
	private final TextItem reasonItem;
	private final TextItem remarkItem;

	private final TextItem drafterItem;
	private final TextItem dutyIdItem;
	private final SelectItem startDateDetailItem;
	private final SelectItem endDateDetailItem;
	private final SelectItem subTypeItem;
	private final TextItem subTypeStrItem;
	private final TextItem planItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem addressItem;

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
	//解除劳动合同合同协议书
	private final LinkItem attachmentNameItem;
	private final TextItem attachmentItem;

	private final VLayout mainLayout;
	private final HLayout buttonLayout;
	private final String other = "其他";
	private final int type = 1;
	private static final Logger logger = Logger.getLogger("");
	private WorkHandoverPanel workPanel;

	private IButton downloadButOne;
	private IButton uploadButTempOne;

	private IButton downloadButTwo;
	private IButton uploadButTempTwo;

	private IButton downloadButThree;
	private IButton uploadButTempThree;

	private IButton downloadButFour;
	private IButton uploadButTempFour;

	private IButton downloadButFive;

	public String processName;

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	/**
	 * 离职员工
	 */
	private String processName_1 = "发起人";

	/**
	 * 人事专员
	 */
	private String processName_2 = "人事专员";

	public ResignationApplyNewForm() {
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		DSResignationApply ds = DSResignationApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		processTypeItem = new SelectItem("processType", "类型");
		processTypeItem.hide();
		processTypeItem.setValueMap(KeyValueManager.getValueMap("system_process_types"));
		__formItems.add(processTypeItem);
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.setValueMap(KeyValueManager.getValueMap("employees"));
		drafterItem.setWidth("*");
		drafterItem.setDisabled(true);
		drafterItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(drafterItem);
		
		companyIdItem = new TextItem("companyId", "离职员工归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setDisabled(true);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(companyIdItem);
		
		typeItem = new SelectItem("type", "离职类型");
		typeItem.setWidth("*");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_94"));
		typeItem.setControlStyle("customInputTextStyle");
		typeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				SC.debugger();
				if(BaseHelpUtils.getIntValue(typeItem.getValue()) == 2) {
					//辞退员工
//					workPanel.setEmployeeId(BaseHelpUtils.getIntValue(employeeIdItem.getValue()));

					contactPersonItem.hide();
					equivalentNumberItem.hide();

					uploadButTempOne.hide();
					downloadButTwo.hide();
					uploadButTempTwo.hide();
					__form.redraw();
				}else {
					//主动辞职
//					workPanel.setEmployeeId(ClientUtil.getEmployeeId());
					uploadButTempOne.show();
					downloadButTwo.show();
					uploadButTempTwo.show();
					__form.redraw();
				}
			}
		});
		__formItems.add(typeItem);
		
		departmentIdItem = new TextItem("departmentId", "离职员工所在部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
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
					if(BaseHelpUtils.getIntValue(typeItem.getValue()) == 2) {
						//辞退员工
						workPanel.setEmployeeId(BaseHelpUtils.getIntValue(employeeIdItem.getValue()));
					}else {
						//主动辞职
						workPanel.setEmployeeId(ClientUtil.getEmployeeId());
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
		
		dutyIdItem = new TextItem("dutyId", "职务");
		dutyIdItem.setWidth("*");
		dutyIdItem.setDisabled(true);
		dutyIdItem.setTextBoxStyle("customInputTextStyle");
		dutyIdItem.setValueMap(KeyValueManager.getValueMap("duties"));
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
		subTypeItem.hide();
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
							if(value.equals("其他")){
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

		attachmentNameItem = new LinkItem("attachmentName");
		attachmentNameItem.setWidth("*");
		attachmentNameItem.hide();
		attachmentNameItem.setTitle("解除劳动合同协议书");
		__formItems.add(attachmentNameItem);

		attachmentItem = new TextItem("attachment", "解除劳动合同协议书");
		attachmentItem.setWidth("*");
		attachmentItem.hide();
		__formItems.add(attachmentItem);

		
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_PERSONNEL_RESIGN_EMPLOYEE)){
			typeItem.setDefaultValue(type);
			typeItem.setDisabled(true);
			String employeeId = ClientUtil.getUserId();
			employeeIdItem.setDefaultValue(employeeId);
			getUserBasicInfo(employeeId);
			employeeIdItem.setDisabled(true);
			subTypeItem.show();
			endDateDetailItem.show();
			remarkItem.show();
		}else{
			typeItem.addChangedHandler(new ChangedHandler() {
				@Override
				public void onChanged(ChangedEvent event) {
					if(null != event.getValue()){
						if(ClientUtil.checkAndGetIntValue(event.getValue()) == type){
							String employeeId = ClientUtil.getUserId();
							employeeIdItem.setValue(employeeId);
							getUserBasicInfo(employeeId);
							employeeIdItem.setDisabled(true);
							subTypeItem.show();
							endDateDetailItem.show();
							remarkItem.show();
						}else{
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
		}

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setCellPadding(10);
		mainLayout.addMember(__form);

		buttonLayout = new HLayout();
		buttonLayout.setMembersMargin(10);
		mainLayout.addMember(buttonLayout);

		//离职申请书附件
		downloadButOne = new IButton("离职申请书(下载)");
		downloadButOne.setWidth("130");
		downloadButOne.hide();
		buttonLayout.addMember(downloadButOne);
		downloadButOne.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DownloadFileByUrl.download("/files/离职申请书.doc");
			}
		});
		uploadButTempOne = new IButton("离职申请书(上传)");
		uploadButTempOne.setWidth("130");
		buttonLayout.addMember(uploadButTempOne);
		uploadButTempOne.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				new CommonUploadWindow("上传附件", false, 100, 2 ,null, new UploadCallBack() {

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
		buttonLayout.addMember(downloadButTwo);
		downloadButTwo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DownloadFileByUrl.download("/files/解除劳动合同申请书.doc");
			}
		});
		uploadButTempTwo = new IButton("解除劳动合同申请书(上传)");
		uploadButTempTwo.setWidth("180");
		buttonLayout.addMember(uploadButTempTwo);
		uploadButTempTwo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				new CommonUploadWindow("上传附件", false, 100, 2, null, new UploadCallBack() {

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
		downloadButThree.hide();
		downloadButThree.setWidth("130");
		buttonLayout.addMember(downloadButThree);
		downloadButThree.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DownloadFileByUrl.download("/files/离职承诺书.doc");
			}
		});
		uploadButTempThree = new IButton("离职承诺书(上传)");
		uploadButTempThree.hide();
		uploadButTempThree.setWidth("130");
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
		downloadButFour.hide();
		downloadButFour.setWidth("130");
		buttonLayout.addMember(downloadButFour);
		downloadButFour.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DownloadFileByUrl.download("/files/项目交接表.doc");
			}
		});
		uploadButTempFour = new IButton("项目交接表(上传)");
		uploadButTempFour.hide();
		uploadButTempFour.setWidth("130");
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

		//解除劳动合同协议书
		downloadButFive = new IButton("解除劳动合同协议书(上传)");
		downloadButFive.hide();
		downloadButFive.setWidth("180");
		buttonLayout.addMember(downloadButFive);
		downloadButFive.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				new CommonUploadWindow("上传附件", false, 100, 3, null, new UploadCallBack() {
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

		Label label = new Label("<font style=\"font-weight:bold\">温馨提示：正式员工至少提前<font style=\"color:red\">三十天</font>提出离职，试用期内员工需提前<font style=\"color:red\">三个工作日</font>提出离职。离职申请提交后，请在“我的人事”→“发起/进行中”→“离职申请”页面打印一份离职申请书。</font>");
		mainLayout.addMember(label);
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
		if(ClientUtil.checkAndGetIntValue(typeItem.getValue()) == type){
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
			//被辞退时不需要填写离职申请书和解除劳动合同申请书
			if (ClientUtil.checkAndGetIntValue(typeItem.getValue()) == 1) {
				if (null == contactPersonItem.getValue()) {
					SC.say("请上传离职申请书");
					return false;
				}
				if (null == equivalentNumberItem.getValue()) {
					SC.say("请上传解除劳动合同申请书");
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSResignationApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		SC.debugger();
		Map map = __form.getValues();
		logger.info("---------------------------------- map :" + map);
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
		if(null != subTypeItem.getValue() && subTypeItem.getDisplayValue().contains("其他") && null != projectNameItem.getValue()){
			map.put("subTypeStr", subTypeItem.getDisplayValue().replace("其他", projectNameItem.getValue().toString()));
		}else{
			map.put("subTypeStr", subTypeItem.getDisplayValue());
		}
		
		if(null != endDateDetailItem.getValue() && endDateDetailItem.getDisplayValue().equals("其他") && null != addressItem.getValue()){
			map.put("plan", addressItem.getValue());
		}else{
			map.put("plan", endDateDetailItem.getDisplayValue());
		}
		logger.info(map.toString());
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

	public WorkHandoverPanel getWorkPanel() {
		return workPanel;
	}

	public void setWorkPanel(WorkHandoverPanel workPanel) {
		this.workPanel = workPanel;
	}
	
}
