package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeOnboardInformation;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.HeaderItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.EditorExitEvent;
import com.smartgwt.client.widgets.form.fields.events.EditorExitHandler;
import com.smartgwt.client.widgets.form.validator.IsStringValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class EmployeeOnboardInformationBasicinfoNew extends AbstractWizadPage
{

	private final Logger __logger = Logger.getLogger("");
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNameEnItem;
	private final TextItem cardItem;
	private final SelectItem genderItem;
	private final DateItem birthItem;
	private final SelectItem politicalFaceItem;
	private final TextItem birthplaceItem;
	private final SelectItem marriedStatusItem;
	private final TextItem healthItem;
	private final TextItem countryItem;
	private final TextItem accountLocationItem;
	private final TextItem languagesItem;
	private final DateItem startWorkDateItem;
	private final ComboBoxItem nationalityItem;
	private final TextItem socialComputerNumberItem;
	private final TextItem fundAccountItem;
	private final TextItem bankCardNumItem;
	private final SelectItem householdRegistrationItem;
	private final TextItem fileNumberItem;
	private final SelectItem workYearTypeItem;
	private final TextItem ageItem;
	private final DateItem onboardDateItem;
	private final DateItem positiveDateItem;
	private final TextItem tryTimeItem;
	private final TextItem workAddressItem;
	private final SelectItem statusItem;
	private final DateItem contractStartDateItem;
	private final DateItem contractEndDateItem;
	private final SelectItem ownedCompanyItem;
	private final IPickTreeItem departmentIdItem;
	private final ComboBoxItem dutyIdItem;
	private final ComboBoxItem gradeIdItem;
	private final TextItem jobsItem;
	private final TextItem selfIntroductionItem;
	private final TextItem personalBusinessRemarkItem;
	private final CheckboxItem isCheckItem;
	private final TextItem phoneItem;
	private final TextItem mobileItem;
	private final TextItem emailItem;
	private final TextItem homePhoneItem;
	private final SelectItem educationItem;
	private final SelectItem degreeItem;
	private final SelectItem employeeShiftItem;
	private final TextItem applyEmployeeIdItem;
	private final SelectItem plateIdItem;
	private HLayout allLayout;
	private VLayout leftLayout;
	private VLayout rightLayou;
	private EmployeeOnboardInformationEmployeeattachmentNew attachment;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static final Logger logger = Logger.getLogger("");
	private DynamicForm roleform;
	private SelectItem roleIdItem;

	public EmployeeOnboardInformationBasicinfoNew(EmployeeOnboardInformationContactinfoNew nextPanel) {
		DSEmployeeOnboardInformation ds = DSEmployeeOnboardInformation.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		HeaderItem IdCardReaderItem = new HeaderItem();
		IdCardReaderItem.setDefaultValue("<font style=\"color:blue;font-weight:bold;font-size:16px;\">点击自动获取身份证信息>></font>");
		IdCardReaderItem.setWidth("*");
		IdCardReaderItem.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final LoadingWindow loading = new LoadingWindow();
				DBDataSource.callOperation(new DSCallback() {
					@SuppressWarnings("deprecation")
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						loading.destroy();
						String escapeed = JsonUtils.escapeJsonForEval(data.toString());
						JSONValue result = JSONParser.parseLenient(escapeed);
						JSONObject jso = result.isObject();
						//获取返回代码
						int ret = BaseHelpUtils.getIntValue(jso.get("ret").toString().trim());
						//ret:0:成功;10:没有找到卡
						if(ret == 0){//操作成功
							JSONObject Certificate = jso.get("Certificate").isObject();
							//获取姓名
							String employeeName = BaseHelpUtils.getString(Certificate.get("Name").toString().replaceAll("\"","").trim());
							employeeNameItem.setValue(employeeName);
							//获取性别
							String sex = BaseHelpUtils.getString(Certificate.get("Sex").toString().replaceAll("\"","").trim());
							if(sex.equals("男")){
								genderItem.setValue(1);
							}else{
								genderItem.setValue(2);
							}
							//获取名族
							String Nation = BaseHelpUtils.getString(Certificate.get("Nation").toString().replaceAll("\"","").trim());
							nationalityItem.setValue(Nation+"族");
							//获取出生日期
							String Birthday = BaseHelpUtils.getString(Certificate.get("Birthday").toString().replaceAll("\"","").trim());
							DateTimeFormat df = DateTimeFormat.getFormat("yyyyMMdd");
							Date birthDate = df.parse(Birthday);
							birthItem.setValue(birthDate);
							Date dateNow = new Date();
							int yearNow = dateNow.getYear();
					        int monthNow = dateNow.getMonth();
					        int dayOfMonthNow = dateNow.getDate();

					        int yearBirth = birthDate.getYear();
					        int monthBirth = birthDate.getMonth();
					        int dayOfMonthBirth = birthDate.getDate();
					        int age = yearNow - yearBirth;
					        if (monthNow <= monthBirth) {
					            if (monthNow == monthBirth) {
					                if (dayOfMonthNow < dayOfMonthBirth) age--;
					            }else{
					                age--;
					            }
					        }
					        ageItem.setValue(age);
							//获取地址
							String Address = BaseHelpUtils.getString(Certificate.get("Address").toString().replaceAll("\"","").trim());
							accountLocationItem.setValue(Address);
							nextPanel.cardAddressItem.setValue(Address);
							//获取身份证号
							String IDNumber = BaseHelpUtils.getString(Certificate.get("IDNumber").toString().replaceAll("\"","").trim());
							cardItem.setValue(IDNumber);
						}else if(ret == 10){//没有找到卡,请
							SC.say("提示","请将二代身份证放到读卡区域...");
						}else{//操作失败
							SC.say("提示","操作失败:请安装相关硬件驱动!");
						}
					}
				});
			}
		});
		__formItems.add(IdCardReaderItem);
		employeeNoItem = new TextItem("employeeNo", shouldNotBeNull + "员工编号");
		employeeNoItem.setStartRow(true);
		employeeNoItem.setRequired(true);
		IsStringValidator employeeNoValidator = new IsStringValidator();
		LengthRangeValidator employeeNoLengthValidator = new LengthRangeValidator();
		employeeNoLengthValidator.setMax(64);
		employeeNoItem.setValidators(employeeNoValidator, employeeNoLengthValidator);
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);

		employeeNameItem = new TextItem("employeeName", shouldNotBeNull + "员工姓名");
		employeeNameItem.setRequired(true);
		IsStringValidator employeeNameValidator = new IsStringValidator();
		LengthRangeValidator employeeNameLengthValidator = new LengthRangeValidator();
		employeeNameLengthValidator.setMax(64);
		employeeNameItem.setValidators(employeeNameValidator, employeeNameLengthValidator);
		employeeNameItem.setWidth("*");
		__formItems.add(employeeNameItem);
		//根据姓名自动生成企业邮箱
//		employeeNameItem.addEditorExitHandler(new EditorExitHandler() {
//			
//			@Override
//			public void onEditorExit(EditorExitEvent event) {
//				Map<String,Object> param = new HashMap<>();
//				param.put("optType", "createEmailByName");
//				if(!BaseHelpUtils.isNullOrEmpty(employeeNameItem.getValue())){
//					param.put("employeeName", employeeNameItem.getValue());
//					DBDataSource.callOperation("EP_MyPersonnelProcessor", param, new DSCallback() {
//						@Override
//						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//							if(dsResponse.getStatus() >= 0){
//								Map<String,Object> map = dsResponse.getAttributeAsMap("userData");
//								if(!BaseHelpUtils.isNullOrEmpty(map)){
//									emailItem.setValue(map.get("name"));
//								}
//							}
//						}
//					});
//				}
//			}
//		});

		employeeNameEnItem = new TextItem("employeeNameEn", "英文名");
		employeeNameEnItem.setWidth("*");
		__formItems.add(employeeNameEnItem);

		fileNumberItem = new TextItem("fileNumber", "档案号");
		fileNumberItem.setWidth("*");
		fileNumberItem.setRequired(false);
		__formItems.add(fileNumberItem);

		homePhoneItem = new TextItem("homePhone", shouldNotBeNull + "护照号");
		homePhoneItem.setWidth("*");
		__formItems.add(homePhoneItem);

		cardItem = new TextItem("card", shouldNotBeNull + "身份证号");
		cardItem.setWidth("*");
		__formItems.add(cardItem);
		cardItem.addEditorExitHandler(new EditorExitHandler() {

			@Override
			public void onEditorExit(EditorExitEvent event) {
				Map<String,Object> params = new HashMap<>();
				params.put("optType", "onIdValidate");
				params.put("id", cardItem.getValue());
				DBDataSource.callOperation("EP_OnHrManageProcess", params, new DSCallback() {

					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record record = dsResponse.getData()[0];
							Date birthDate = record.getAttributeAsDate("birth");
							birthItem.setValue(birthDate);
							ageItem.setValue(record.getAttribute("age"));
						}else{
							SC.say("提示",dsResponse.getErrors().get("errorMsg").toString());
						}
					}
				});
			}
		});

		birthItem = new DateItem("birth", "出生日期");
		birthItem.setWidth("*");
		birthItem.setUseTextField(true);
		birthItem.setUseMask(true);
		__formItems.add(birthItem);

		ageItem = new TextItem("age", "年龄");
		ageItem.setWidth("*");
		__formItems.add(ageItem);

		genderItem = new SelectItem("gender", shouldNotBeNull + "性别");
		genderItem.setWidth("*");
		genderItem.setRequired(true);
		genderItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));
		__formItems.add(genderItem);

		phoneItem = new TextItem("phone", "办公电话");
		phoneItem.setWidth("*");
		__formItems.add(phoneItem);

		mobileItem = new TextItem("mobile", shouldNotBeNull + "手机号码");
		mobileItem.setWidth("*");
		mobileItem.setRequired(true);
		mobileItem.setValidators(ValidateUtils.mobileValidator());
		__formItems.add(mobileItem);

		emailItem = new TextItem("companyEmail", "企业邮箱");
		emailItem.setRequired(false);
		emailItem.setWidth("*");
		emailItem.setValidators(ValidateUtils.emailValidator());
		__formItems.add(emailItem);

		countryItem = new TextItem("country", "国籍");
		countryItem.setWidth("*");
		__formItems.add(countryItem);

		birthplaceItem = new TextItem("birthplace", "籍贯");
		birthplaceItem.setWidth("*");
		__formItems.add(birthplaceItem);

		accountLocationItem = new TextItem("accountLocation", shouldNotBeNull + "户口所在地");
		accountLocationItem.setWidth("*");
		accountLocationItem.setRequired(true);
		__formItems.add(accountLocationItem);

		householdRegistrationItem = new SelectItem("householdRegistration",shouldNotBeNull + "户籍");
		householdRegistrationItem.setWidth("*");
		householdRegistrationItem.setRequired(true);
		householdRegistrationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_81"));;
		__formItems.add(householdRegistrationItem);

		nationalityItem = new ComboBoxItem("nationality", shouldNotBeNull + "民族");
		KeyValueManager.loadValueMap("nationalities", nationalityItem);
		nationalityItem.setWidth("*");
		nationalityItem.setRequired(true);
		nationalityItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(nationalityItem);

		marriedStatusItem = new SelectItem("marriedStatus", shouldNotBeNull + "婚姻状况");
		marriedStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_77"));
		marriedStatusItem.setWidth("*");
		marriedStatusItem.setRequired(true);
		__formItems.add(marriedStatusItem);

		healthItem = new TextItem("health", "健康状况");
		healthItem.setWidth("*");
		__formItems.add(healthItem);

		politicalFaceItem = new SelectItem("politicalFace", "政治面貌");
		politicalFaceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_76"));
		politicalFaceItem.setWidth("*");
		__formItems.add(politicalFaceItem);

		educationItem = new SelectItem("education","学历");
		educationItem.setWidth("*");
		educationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_80"));
		__formItems.add(educationItem);

		degreeItem = new SelectItem("degree","学位");
		degreeItem.setWidth("*");
		degreeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_78"));
		__formItems.add(degreeItem);

		startWorkDateItem = new DateItem("startWorkDate", "参加工作时间");
		startWorkDateItem.setWidth("*");
		startWorkDateItem.setUseTextField(true);
		startWorkDateItem.setUseMask(true);
		__formItems.add(startWorkDateItem);

		languagesItem = new TextItem("languages", "外语语种");
		languagesItem.setWidth("*");
		__formItems.add(languagesItem);

		onboardDateItem = new DateItem("onboardDate",shouldNotBeNull + "入职日期");
		onboardDateItem.setWidth("*");
		onboardDateItem.setUseTextField(true);
		onboardDateItem.setUseMask(true);
		onboardDateItem.setRequired(true);
		__formItems.add(onboardDateItem);
		onboardDateItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				Date onboardDate = (Date) onboardDateItem.getValue();
				Date positiveDate = (Date) positiveDateItem.getValue();
				if(null != positiveDate){
					if(onboardDateItem.getValueAsDate().after(positiveDateItem.getValueAsDate())){
						SC.say("入职日期必须小于转正日期");
						onboardDateItem.setValue("");
					}else{
						long days = (((positiveDate.getTime() - onboardDate.getTime())/(24*60*60*1000))%365)/30;
						tryTimeItem.setValue(days+"  个月");
					}
				}
			}
		});

		positiveDateItem = new DateItem("positiveDate", shouldNotBeNull + "转正日期");
		positiveDateItem.setWidth("*");
		positiveDateItem.setRequired(true);
		positiveDateItem.setUseTextField(true);
		positiveDateItem.setUseMask(true);
		__formItems.add(positiveDateItem);
		positiveDateItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				Date onboardDate = (Date) onboardDateItem.getValue();
				Date positiveDate = (Date) positiveDateItem.getValue();
				if(null != onboardDate){
					if(onboardDateItem.getValueAsDate().after(positiveDateItem.getValueAsDate())){
						SC.say("转正日期必须大于入职日期");
						positiveDateItem.setValue("");
					}else{
						long a=positiveDate.getTime() - onboardDate.getTime();
						__logger.info("a+++++++++++++++++++++++++++++++++++++++++++++++++++++"+a);
						long days = (((positiveDate.getTime() - onboardDate.getTime())/(24*60*60*1000))%365)/30;
						tryTimeItem.setValue(days+"  个月");
					}
				}
			}
		});

		tryTimeItem = new TextItem("tryTime", "试用期");
		tryTimeItem.setWidth("*");
		__formItems.add(tryTimeItem);

		workYearTypeItem = new SelectItem("workYearType", shouldNotBeNull + "工龄工资状态");
		workYearTypeItem.setWidth("*");
		workYearTypeItem.setRequired(true);
		workYearTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_115"));
		__formItems.add(workYearTypeItem);

		workAddressItem = new TextItem("workAddress", "工作地点");
		workAddressItem.setWidth("*");
		__formItems.add(workAddressItem);

		statusItem = new SelectItem("onboardStatus", "人事状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_96"));
		statusItem.setWidth("*");
		__formItems.add(statusItem);

		contractStartDateItem = new DateItem("contractStartDate", shouldNotBeNull + "劳动合同开始时间");
		contractStartDateItem.setWidth("*");
		contractStartDateItem.setUseTextField(true);
		contractStartDateItem.setUseMask(true);
		contractStartDateItem.setRequired(true);
		__formItems.add(contractStartDateItem);

		contractEndDateItem = new DateItem("contractEndDate", shouldNotBeNull + "劳动合同到期时间");
		contractEndDateItem.setWidth("*");
		contractEndDateItem.setRequired(true);
		contractEndDateItem.setUseTextField(true);
		contractEndDateItem.setEndDate(new Date("2028-01-01"));
		contractEndDateItem.setUseMask(true);
		__formItems.add(contractEndDateItem);

		ownedCompanyItem = new SelectItem("ownedCompany", shouldNotBeNull + "所属公司");
		ownedCompanyItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		ownedCompanyItem.setWidth("*");
		ownedCompanyItem.setRequired(true);
		__formItems.add(ownedCompanyItem);
		ownedCompanyItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				if(!BaseHelpUtils.isNullOrEmpty(plateIdItem.getValue())){
					makeEmployeeNo();
				}
			}
		});

		departmentIdItem = new IPickTreeItem("departmentId", shouldNotBeNull + "所属部门");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setRequired(true);
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> param = new HashMap<>();
				int departmentId = BaseHelpUtils.getIntValue(departmentIdItem.getValue());
				param.put("departmentId",departmentId);
				DBDataSource.callOperation("NQ_DepartmentIdFindPlate", param, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record record = dsResponse.getData()[0];
							int plateId = record.getAttributeAsInt("plateId");
							plateIdItem.setValue(plateId);
							if(!BaseHelpUtils.isNullOrEmpty(ownedCompanyItem.getValue())){
								makeEmployeeNo();
							}
						}
					}
				});
			}
		});
		__formItems.add(departmentIdItem);

		plateIdItem = new SelectItem("plateId", shouldNotBeNull + "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdItem.setWidth("*");
		plateIdItem.setRequired(true);
		__formItems.add(plateIdItem);
		plateIdItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				if(!BaseHelpUtils.isNullOrEmpty(ownedCompanyItem.getValue())){
					makeEmployeeNo();
				}
			}
		});

		dutyIdItem = new ComboBoxItem("dutyId", shouldNotBeNull + "岗位");
		dutyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		dutyIdItem.setValueMap(KeyValueManager.getValueMap("duties"));
		dutyIdItem.setWidth("*");
		dutyIdItem.setRequired(true);
		__formItems.add(dutyIdItem);

		gradeIdItem = new ComboBoxItem("gradeId", "职级");
		gradeIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));
		gradeIdItem.setWidth("*");
		gradeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(gradeIdItem);

		jobsItem = new TextItem("jobs", "职务");
		jobsItem.setWidth("*");
		__formItems.add(jobsItem);

		isCheckItem = new CheckboxItem("isCheck", "参与考勤");
		isCheckItem.setWidth("*");
		isCheckItem.setDefaultValue(true);
		__formItems.add(isCheckItem);

		socialComputerNumberItem = new TextItem("socialComputerNumber", "社保电脑号");
		socialComputerNumberItem.setWidth("*");
		__formItems.add(socialComputerNumberItem);

		fundAccountItem = new TextItem("fundAccount", "公积金账号");
		fundAccountItem.setWidth("*");
		__formItems.add(fundAccountItem);

		bankCardNumItem = new TextItem("bankCardNum", "银行卡号");
		bankCardNumItem.setWidth("*");
		__formItems.add(bankCardNumItem);

		employeeShiftItem = new SelectItem("employeeShift", shouldNotBeNull + "员工排班");
		employeeShiftItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_83"));
		employeeShiftItem.setWidth("*");
		employeeShiftItem.setRequired(true);
		__formItems.add(employeeShiftItem);
		isCheckItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(BaseHelpUtils.getBoolean(isCheckItem.getValue())){
					employeeShiftItem.setDisabled(false);
					employeeShiftItem.setRequired(true);
				}else{
					employeeShiftItem.setDisabled(true);
					employeeShiftItem.setRequired(false);
				}
			}
		});


		selfIntroductionItem = new TextItem("selfIntroduction", "个人介绍及特长爱好");
		selfIntroductionItem.setWidth("*");
		__formItems.add(selfIntroductionItem);

		personalBusinessRemarkItem = new TextItem("personalBusinessRemark", "人事备注");
		personalBusinessRemarkItem.setWidth("*");
		personalBusinessRemarkItem.setStartRow(true);
		__formItems.add(personalBusinessRemarkItem);

		applyEmployeeIdItem = new TextItem("applyEmployeeId", "发起人");
		applyEmployeeIdItem.setWidth("*");
		applyEmployeeIdItem.setDefaultValue(ClientUtil.getUserId());
		applyEmployeeIdItem.setHidden(true);
		__formItems.add(applyEmployeeIdItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(8);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		ownedCompanyItem.setColSpan(4);
		departmentIdItem.setColSpan(2);
		plateIdItem.setColSpan(2);
		selfIntroductionItem.setColSpan(8);
		personalBusinessRemarkItem.setColSpan(8);
		setName("职员基本信息");

		allLayout = new HLayout(10);
		allLayout.setWidth100();
		allLayout.setHeight100();

		leftLayout = new VLayout(10);
		leftLayout.setHeight100();
		leftLayout.setWidth("70%");
		leftLayout.addMember(__form);
		allLayout.addMember(leftLayout);


		attachment = new EmployeeOnboardInformationEmployeeattachmentNew();
		rightLayou = new VLayout(10);
		rightLayou.setHeight100();
		rightLayou.setWidth("30%");
		rightLayou.setLayoutLeftMargin(50);
		rightLayou.addMember(attachment);

		VLayout rightRoleLayout = new VLayout(10);
		rightRoleLayout.setHeight("10%");
		rightRoleLayout.setWidth100();

		roleform = new DynamicForm();
		roleIdItem = new SelectItem("roleId", shouldNotBeNull + "员工角色");
//		roleIdItem.setValueMap(KeyValueManager.getValueMap("roles_select"));
		KeyValueManager.loadValueMap("roles_select",roleIdItem);
		roleIdItem.setWidth("*");
		roleIdItem.setAllowEmptyValue(true);
		roleIdItem.setRequired(true);
		roleform.setItems(roleIdItem);
		roleform.setDataSource(ds);
		roleform.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(roleform);
		rightRoleLayout.addMember(roleform);
		rightLayou.addMember(rightRoleLayout);

		allLayout.addMember(rightLayou);

		addMember(allLayout);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) {
			__form.editRecord(getRecord());
			attachment.startEdit();
		}
		else {
			__form.editNewRecord();
		}
		//自动生成档案号
//		Map<String,Object> params = new HashMap<>();
//		params.put("optType","onGetFileNo");
//		DBDataSource.callOperation("EP_OnHrManageProcess", params, new DSCallback() {
//			@SuppressWarnings("unchecked")
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if(dsResponse.getStatus() >= 0){
//					Map<String,Object> map = BaseHelpUtils.getResponseUserData(dsResponse);
//					int fileNumberMax = BaseHelpUtils.getIntValue(map.get("fileNumberMax"));
//					fileNumberItem.setValue(fileNumberMax);
//				}
//			}
//		});
	}

	@Override
	public boolean checkData() {
		if(!__form.validate()){
			SC.say("请按系统提示修改信息");
			return false;
		}
		if(null == employeeNoItem.getValue()){
			SC.say("员工编码不能为空");
			return false;
		}
		if(null == employeeNameItem.getValue()){
			SC.say("员工姓名不能为空");
			return false;
		}

		if(null == cardItem.getValue() && null == homePhoneItem.getValue()){
			SC.say("员工身份证号与护照号至少填一项");
			return false;
		}

		if(null == genderItem.getValue()){
			SC.say("员工性别不能为空");
			return false;
		}
		if(BaseHelpUtils.getBoolean(isCheckItem.getValue())){
			if(null == employeeShiftItem.getValue()){
				SC.say("员工排班不能为空");
				return false;
			}
		}
		if(null == accountLocationItem.getValue()){
			SC.say("户口所在地不能为空");
			return false;
		}
//		if(null == fileNumberItem.getValue()){
//			SC.say("档案号不能为空");
//			return false;
//		}
		if(null == mobileItem.getValue()){
			SC.say("手机号码不能为空");
			return false;
		}
		if(null == householdRegistrationItem.getValue()){
			SC.say("户籍不能为空");
			return false;
		}
		if(null == onboardDateItem.getValue()){
			SC.say("入职日期不能为空");
			return false;
		}
		if(null == positiveDateItem.getValue()){
			SC.say("转正日期不能为空");
			return false;
		}
		if(null == contractStartDateItem.getValue()){
			SC.say("劳动合同开始时间不能为空");
			return false;
		}
		if(null == contractEndDateItem.getValue()){
			SC.say("劳动合同到期时间不能为空");
			return false;
		}
		if(null == ownedCompanyItem.getValue()){
			SC.say("所属公司不能为空");
			return false;
		}
		if(null == departmentIdItem.getValue()){
			SC.say("所属部门不能为空");
			return false;
		}
		if(null == nationalityItem.getValue()){
			SC.say("民族不能为空");
			return false;
		}
		if(null == plateIdItem.getValue()){
			SC.say("业务部门不能为空");
			return false;
		}
		if(null == dutyIdItem.getValue()){
			SC.say("岗位不能为空");
			return false;
		}
		if(null == marriedStatusItem.getValue()){
			SC.say("婚姻状况不能为空");
			return false;
		}
		if(onboardDateItem.getValueAsDate().after(positiveDateItem.getValueAsDate())){
			SC.say("入职日期必须小于转正日期");
			return false;
		}
		if(contractStartDateItem.getValueAsDate().after(contractEndDateItem.getValueAsDate())){
			SC.say("劳动合同开始时间必须小于劳动合同到期时间");
			return false;
		}
		return true;
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSEmployeeOnboardInformation.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map values = __form.getValues();
		values.putAll(attachment.getValuesAsMap());
		values.put("roleId", roleIdItem.getValue());
		return values;
	}

	public void makeEmployeeNo(){
		if(BaseHelpUtils.isNullOrEmpty(ownedCompanyItem.getValue()) || BaseHelpUtils.isNullOrEmpty(plateIdItem.getValue())){
			return;
		}else{
			int ownedCompany = BaseHelpUtils.getIntValue(ownedCompanyItem.getValue());
			int plateId = BaseHelpUtils.getIntValue(plateIdItem.getValue());
			Map<String,Object> params = new HashMap<>();
			params.put("companyRecordId",ownedCompany);
			params.put("plateId",plateId);
			DBDataSource.callOperation("NQ_MakeEmployeeNo", params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						Record record = dsResponse.getData()[0];
						String companyCode = BaseHelpUtils.getString(record.getAttribute("companyCode"));
						String plateCode = BaseHelpUtils.getString(record.getAttribute("plateCode"));
						String num = BaseHelpUtils.getString(record.getAttribute("num"));
						if(num.length() == 0){
							num = "001";
						}else if(num.length() == 1){
							num = "00" + num;
						}else if(num.length() == 2){
							num = "0" + num;
						}
						employeeNoItem.setValue(companyCode+plateCode+num);
					}
				}
			});
		}
	}


}
