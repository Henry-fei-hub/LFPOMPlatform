package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeOnboardInformation;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsStringValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class EmployeeOnboardViewDetail extends AbstractWizadPage
{

	private  TextItem employeeNoItem;
	private  TextItem employeeNameItem;
	private  TextItem employeeNameEnItem;
	private  TextItem cardItem;
	private  SelectItem genderItem;
	private  DateItem birthItem;
	private  SelectItem politicalFaceItem;
	private  TextItem birthplaceItem;
	private  SelectItem marriedStatusItem;
	private  TextItem healthItem;
	private  TextItem countryItem;
	private  TextItem accountLocationItem;
	private  TextItem languagesItem;
	private  DateItem startWorkDateItem;
	private  SelectItem nationalityItem;
	private  TextItem socialComputerNumberItem;
	private  TextItem fundAccountItem;
	private  SelectItem householdRegistrationItem;
	private  TextItem fileNumberItem;
	private  TextItem selfIntroductionItem;
	private  Img designerPhoto;
	private  TextItem foremanItem;
	private  DateItem onboardDateItem;
	private  DateItem positiveDateItem;
	private  TextItem tryTimeItem;
	private  TextItem workAddressItem;
	private  SelectItem statusItem;
	private  DateItem contractStartDateItem;
	private  DateItem contractEndDateItem;
	private  SelectItem ownedCompanyItem;
	private  IPickTreeItem departmentIdItem;
	private  SelectItem dutyIdItem;
	private  ComboBoxItem gradeIdItem;
	private  TextItem jobsItem;
	private  TextItem phoneItem;
	private  TextItem mobileItem;
	private  TextItem emailItem;
	private  TextItem homePhoneItem;
	private  SelectItem plateIdItem;
	private  TextItem emergencyContactPersonItem;
	private  TextItem emergencyContactPhoneItem;
	private  TextItem nowAddressItem;
	private  TextItem roleIdItem;
	private  TextItem tryTimePayItem;
	private  TextItem positivePayItem;
	private  TextItem annualPerformanceItem;
	private  TextItem annualBonusItem;
	private  LinkItem cardAttachmentItem;
	private  LinkItem educationProofItem;
	private  LinkItem degreeProofItem;
	private  LinkItem laborAttachmentsItem;
	private  LinkItem technicalAttachmentItem;
	private  LinkItem bankCardAttachmentItem;
	private  TextItem attachmentRemarkItem;
	
	private static  Logger __LOGGER = Logger.getLogger("");
	private VLayout allLayout;
	private HLayout oneHLayout;
	private VLayout oneLeftLayout;
	private VLayout photoLayout;
	private HLayout twoHLayout;
	private HLayout threeHLayout;
	private HLayout fourHLayout;
	private HLayout fiveHLayout;
	
	protected DynamicForm __formOne;
	protected DynamicForm __formOnePhoto;
	protected DynamicForm __formTwo;
	protected DynamicForm __formThree;
	protected DynamicForm __formFour;
	protected DynamicForm __formFive;
	
	
	public EmployeeOnboardViewDetail(String processName) {
		
		ifShowPay = processName;
		
		DSEmployeeOnboardInformation ds = DSEmployeeOnboardInformation.getInstance();
        allLayout = new VLayout(10);
        allLayout.setWidth100();
        allLayout.setHeight100();
        
        oneHLayout = new HLayout(10);
        oneHLayout.setWidth100();
        oneHLayout.setHeight(470);
        
        oneLeftLayout = new VLayout();
        oneLeftLayout.setWidth100();
        oneLeftLayout.setHeight100();
        
        employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setRequired(true);
		IsStringValidator employeeNoValidator = new IsStringValidator();
		LengthRangeValidator employeeNoLengthValidator = new LengthRangeValidator();
		employeeNoLengthValidator.setMax(64);
		employeeNoItem.setValidators(employeeNoValidator, employeeNoLengthValidator);
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setRequired(true);
		IsStringValidator employeeNameValidator = new IsStringValidator();
		LengthRangeValidator employeeNameLengthValidator = new LengthRangeValidator();
		employeeNameLengthValidator.setMax(64);
		employeeNameItem.setValidators(employeeNameValidator, employeeNameLengthValidator);
		employeeNameItem.setWidth("*");
		
		employeeNameEnItem = new TextItem("employeeNameEn", "英文名");
		employeeNameEnItem.setWidth("*");
		
		fileNumberItem = new TextItem("fileNumber", "档案号");
		fileNumberItem.setWidth("*");

		homePhoneItem = new TextItem("homePhone","护照");
		homePhoneItem.setWidth("*");

		cardItem = new TextItem("card", "身份证号");
		cardItem.setWidth("*");
		
		birthItem = new DateItem("birth", "出生日期");
		birthItem.setWidth("*");
		birthItem.setUseTextField(true);
		birthItem.setUseMask(true);
		
		genderItem = new SelectItem("gender", "性别");
		genderItem.setWidth("*");
		genderItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));
		
		countryItem = new TextItem("country", "国籍");
		countryItem.setWidth("*");
		
		birthplaceItem = new TextItem("birthplace", "籍贯");
		birthplaceItem.setWidth("*");
		
		accountLocationItem = new TextItem("accountLocation", "户口所在地");
		accountLocationItem.setWidth("*");
		
		householdRegistrationItem = new SelectItem("householdRegistration","户籍");
		householdRegistrationItem.setWidth("*");
		householdRegistrationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_81"));;
		
		nationalityItem = new SelectItem("nationality","民族");
		nationalityItem.setValueMap(KeyValueManager.getValueMap("nationalities"));
		nationalityItem.setWidth("*");

		marriedStatusItem = new SelectItem("marriedStatus", "婚姻状况");
		marriedStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_77"));
		marriedStatusItem.setWidth("*");

		healthItem = new TextItem("health", "健康状况");
		healthItem.setWidth("*");
		
		politicalFaceItem = new SelectItem("politicalFace", "政治面貌");
		politicalFaceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_76"));
		politicalFaceItem.setWidth("*");
		
		startWorkDateItem = new DateItem("startWorkDate", "参加工作时间");
		startWorkDateItem.setWidth("*");
		startWorkDateItem.setUseTextField(true);
		startWorkDateItem.setUseMask(true);
		
		languagesItem = new TextItem("languages", "外语语种");
		languagesItem.setWidth("*");
		
		socialComputerNumberItem = new TextItem("socialComputerNumber", "社保电脑号");
		socialComputerNumberItem.setWidth("*");
		
		fundAccountItem = new TextItem("fundAccount", "公积金账号");
		fundAccountItem.setWidth("*");
		
		roleIdItem = new TextItem("roleId","员工角色");
		roleIdItem.setWidth("*");
		
		selfIntroductionItem = new TextItem("selfIntroduction", "个人介绍及特长爱好");
		selfIntroductionItem.setWidth("*");
		
		__formOne = new DynamicForm();
		__formOne.setItems(employeeNoItem,employeeNameItem,employeeNameEnItem,homePhoneItem,cardItem,genderItem,birthItem,politicalFaceItem,birthplaceItem,marriedStatusItem,healthItem,countryItem,accountLocationItem,languagesItem,startWorkDateItem,nationalityItem,socialComputerNumberItem,fundAccountItem,householdRegistrationItem,fileNumberItem,roleIdItem,selfIntroductionItem);
		__formOne.setDataSource(ds);
		__formOne.setNumCols(6);
		__formOne.setIsGroup(true);
		__formOne.setGroupTitle("基本信息");
		__formOne.setCanEdit(false);
		ClientUtil.DynamicFormProcessAccordingToDevice(__formOne);
		employeeNoItem.setTitleOrientation(TitleOrientation.LEFT);
		employeeNameItem.setTitleOrientation(TitleOrientation.LEFT);
		employeeNameEnItem.setTitleOrientation(TitleOrientation.LEFT);
		cardItem.setTitleOrientation(TitleOrientation.LEFT);
		genderItem.setTitleOrientation(TitleOrientation.LEFT);
		birthItem.setTitleOrientation(TitleOrientation.LEFT);
		politicalFaceItem.setTitleOrientation(TitleOrientation.LEFT);
		birthplaceItem.setTitleOrientation(TitleOrientation.LEFT);
		marriedStatusItem.setTitleOrientation(TitleOrientation.LEFT);
		healthItem.setTitleOrientation(TitleOrientation.LEFT);
		countryItem.setTitleOrientation(TitleOrientation.LEFT);
		accountLocationItem.setTitleOrientation(TitleOrientation.LEFT);
		startWorkDateItem.setTitleOrientation(TitleOrientation.LEFT);
		nationalityItem.setTitleOrientation(TitleOrientation.LEFT);
		socialComputerNumberItem.setTitleOrientation(TitleOrientation.LEFT);
		fundAccountItem.setTitleOrientation(TitleOrientation.LEFT);
		householdRegistrationItem.setTitleOrientation(TitleOrientation.LEFT);
		fileNumberItem.setTitleOrientation(TitleOrientation.LEFT);
		selfIntroductionItem.setTitleOrientation(TitleOrientation.LEFT);
		languagesItem.setTitleOrientation(TitleOrientation.LEFT);
		roleIdItem.setTitleOrientation(TitleOrientation.LEFT);
		selfIntroductionItem.setColSpan(6);
		oneHLayout.addMember(__formOne);
		
		designerPhoto = new Img();
        designerPhoto.setHeight(150);
        designerPhoto.setWidth(120);
        designerPhoto.setSrc("/images/photo_view.png");
        
		photoLayout = new VLayout(10);
        photoLayout.setWidth("10%");
        photoLayout.setHeight100();
        photoLayout.addMember(designerPhoto);
//        oneHLayout.addMember(photoLayout);
		allLayout.addMember(oneHLayout);
        
        twoHLayout = new HLayout(10);
        twoHLayout.setWidth100();
        twoHLayout.setHeight(330);
        
        onboardDateItem = new DateItem("onboardDate","入职日期");
		onboardDateItem.setWidth("*");
		onboardDateItem.setUseTextField(true);
		onboardDateItem.setUseMask(true);
		
		positiveDateItem = new DateItem("positiveDate", "转正日期");
		positiveDateItem.setWidth("*");
		positiveDateItem.setUseTextField(true);
		positiveDateItem.setUseMask(true);
		
		tryTimeItem = new TextItem("tryTime", "试用期");
		tryTimeItem.setWidth("*");
		
		foremanItem = new TextItem("foreman", "司龄");
		foremanItem.setWidth("*");
		
		workAddressItem = new TextItem("workAddress", "工作地点");
		workAddressItem.setWidth("*");
		
		statusItem = new SelectItem("status", "人事状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
		statusItem.setWidth("*");
		
		contractStartDateItem = new DateItem("contractStartDate", "劳动合同开始时间");
		contractStartDateItem.setWidth("*");
		contractStartDateItem.setUseTextField(true);
		contractStartDateItem.setUseMask(true);
		
		contractEndDateItem = new DateItem("contractEndDate",  "劳动合同到期时间");
		contractEndDateItem.setWidth("*");
		contractEndDateItem.setUseTextField(true);
		contractEndDateItem.setUseMask(true);

		ownedCompanyItem = new SelectItem("ownedCompany", "所属公司");
		ownedCompanyItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		ownedCompanyItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId", "所属部门");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setWidth("*");
		
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdItem.setWidth("*");
		
		dutyIdItem = new SelectItem("dutyId", "岗位");
		dutyIdItem.setValueMap(KeyValueManager.getValueMap("duties"));
		dutyIdItem.setWidth("*");
		
		gradeIdItem = new ComboBoxItem("gradeId", "职级");
		gradeIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));
		gradeIdItem.setWidth("*");
		gradeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		jobsItem = new TextItem("jobs", "职务");
		jobsItem.setWidth("*");
        
		__formTwo = new DynamicForm();
		__formTwo.setItems(onboardDateItem,positiveDateItem,tryTimeItem,foremanItem,workAddressItem,statusItem,contractStartDateItem,contractEndDateItem,ownedCompanyItem,departmentIdItem,plateIdItem,dutyIdItem,gradeIdItem,jobsItem);
		__formTwo.setNumCols(6);
		__formTwo.setIsGroup(true);
		__formTwo.setDataSource(ds);
		__formTwo.setGroupTitle("人事信息");
		__formTwo.setCanEdit(false);
		ClientUtil.DynamicFormProcessAccordingToDevice(__formTwo);
		onboardDateItem.setTitleOrientation(TitleOrientation.LEFT);
		positiveDateItem.setTitleOrientation(TitleOrientation.LEFT);
		tryTimeItem.setTitleOrientation(TitleOrientation.LEFT);
		foremanItem.setTitleOrientation(TitleOrientation.LEFT);
		workAddressItem.setTitleOrientation(TitleOrientation.LEFT);
		statusItem.setTitleOrientation(TitleOrientation.LEFT);
		contractStartDateItem.setTitleOrientation(TitleOrientation.LEFT);
		contractEndDateItem.setTitleOrientation(TitleOrientation.LEFT);
		ownedCompanyItem.setTitleOrientation(TitleOrientation.LEFT);
		departmentIdItem.setTitleOrientation(TitleOrientation.LEFT);
		plateIdItem.setTitleOrientation(TitleOrientation.LEFT);
		dutyIdItem.setTitleOrientation(TitleOrientation.LEFT);
		gradeIdItem.setTitleOrientation(TitleOrientation.LEFT);
		jobsItem.setTitleOrientation(TitleOrientation.LEFT);
		twoHLayout.addMember(__formTwo);
		allLayout.addMember(twoHLayout);
		
        threeHLayout = new HLayout(10);
        threeHLayout.setWidth100();
        threeHLayout.setHeight(190);
        
        phoneItem = new TextItem("phone","办公电话");
        phoneItem.setWidth("*");
        
    	mobileItem = new TextItem("mobile","手机号码");
    	mobileItem.setWidth("*");
    	
    	emailItem = new TextItem("companyEmail","企业邮箱");
    	emailItem.setWidth("*");
    	

    	
    	emergencyContactPersonItem = new TextItem("emergencyContactPerson","紧急联系人");
		emergencyContactPersonItem.setWidth("*");
		
		emergencyContactPhoneItem = new TextItem("emergencyContactPhone","紧急联系人电话");
		emergencyContactPhoneItem.setWidth("*");
		
		nowAddressItem = new TextItem("nowAddress", "现居住地址");
		nowAddressItem.setWidth("*");
        
        __formThree = new DynamicForm();
        __formThree.setItems(phoneItem,mobileItem,emailItem,emergencyContactPersonItem,emergencyContactPhoneItem,nowAddressItem);
        __formThree.setNumCols(6);
        __formThree.setIsGroup(true);
        __formThree.setDataSource(ds);
        __formThree.setGroupTitle("联系信息");
        __formThree.setCanEdit(false);
		ClientUtil.DynamicFormProcessAccordingToDevice(__formThree);
		phoneItem.setTitleOrientation(TitleOrientation.LEFT);
		mobileItem.setTitleOrientation(TitleOrientation.LEFT);
		emailItem.setTitleOrientation(TitleOrientation.LEFT);
		homePhoneItem.setTitleOrientation(TitleOrientation.LEFT);
		emergencyContactPersonItem.setTitleOrientation(TitleOrientation.LEFT);
		emergencyContactPhoneItem.setTitleOrientation(TitleOrientation.LEFT);
		nowAddressItem.setTitleOrientation(TitleOrientation.LEFT);
		threeHLayout.addMember(__formThree);
		allLayout.addMember(threeHLayout);
        
		//发起人 和 知会的部门助理 不可看到薪酬信息
		if(!BaseHelpUtils.isNullOrEmpty(ifShowPay) && !ifShowPay.equals("部门助理")){
			fourHLayout = new HLayout(10);
	        fourHLayout.setWidth100();
	        fourHLayout.setHeight(100);
	        
	        tryTimePayItem = new TextItem("tryTimePay", "试用期工资");
			tryTimePayItem.setWidth("*");
			
			positivePayItem = new TextItem("positivePay", "转正工资");
			positivePayItem.setWidth("*");
			
			annualPerformanceItem = new TextItem("annualPerformance", "年度绩效");
			annualPerformanceItem.setWidth("*");
			
			annualBonusItem = new TextItem("annualBonus", "年度奖金");
			annualBonusItem.setWidth("*");
			
			__formFour = new DynamicForm();
	        __formFour.setItems(tryTimePayItem,positivePayItem,annualPerformanceItem,annualBonusItem);
	        __formFour.setNumCols(6);
	        __formFour.setIsGroup(true);
	        __formFour.setGroupTitle("薪酬信息");
	        __formFour.setDataSource(ds);
	        __formFour.setCanEdit(false);
			ClientUtil.DynamicFormProcessAccordingToDevice(__formFour);
			tryTimePayItem.setTitleOrientation(TitleOrientation.LEFT);
			positivePayItem.setTitleOrientation(TitleOrientation.LEFT);
			annualPerformanceItem.setTitleOrientation(TitleOrientation.LEFT);
			annualBonusItem.setTitleOrientation(TitleOrientation.LEFT);
			fourHLayout.addMember(__formFour);
			allLayout.addMember(fourHLayout);
		}
        
        fiveHLayout = new HLayout(10);
        fiveHLayout.setWidth100();
        fiveHLayout.setHeight(210);
        
        cardAttachmentItem = new LinkItem("身份证附件");
    	educationProofItem = new LinkItem("学历证附件");
    	degreeProofItem = new LinkItem("学位证附件");
    	laborAttachmentsItem = new LinkItem("劳动合同");
    	technicalAttachmentItem = new LinkItem("职称证附件");
    	bankCardAttachmentItem = new LinkItem("银行卡附件");
    	attachmentRemarkItem = new TextItem("附件备注");
    	attachmentRemarkItem.setWidth("*");
        
    	__formFive = new DynamicForm();
        __formFive.setItems(cardAttachmentItem,educationProofItem,degreeProofItem,laborAttachmentsItem,technicalAttachmentItem,bankCardAttachmentItem,attachmentRemarkItem);
        __formFive.setNumCols(2);
        __formFive.setIsGroup(true);
        __formFive.setGroupTitle("附件信息");
        __formFive.setDataSource(ds);
        __formFive.setCanEdit(false);
        ClientUtil.DynamicFormProcessAccordingToDevice(__formFive);
        cardAttachmentItem.setTitleOrientation(TitleOrientation.LEFT);
        educationProofItem.setTitleOrientation(TitleOrientation.LEFT);
        degreeProofItem.setTitleOrientation(TitleOrientation.LEFT);
        laborAttachmentsItem.setTitleOrientation(TitleOrientation.LEFT);
        technicalAttachmentItem.setTitleOrientation(TitleOrientation.LEFT);
        bankCardAttachmentItem.setTitleOrientation(TitleOrientation.LEFT);
        attachmentRemarkItem.setTitleOrientation(TitleOrientation.LEFT);
        fiveHLayout.addMember(__formFive);
		allLayout.addMember(fiveHLayout);
		
		addMember(allLayout);
	}

	public void loadData(){
		Map<String, Object> param = new HashMap<>();
		param.put("employeeId", employeeId);
		DBDataSource.callOperation("ST_Employee","find", param,new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					__formOne.setValues(record.toMap());
					__formTwo.setValues(record.toMap());
					__formThree.setValues(record.toMap());
					if(!BaseHelpUtils.isNullOrEmpty(ifShowPay) && !ifShowPay.equals("部门助理")){
						__formFour.setValues(record.toMap());
					}
				
					cardAttachmentItem.setValue(record.getAttribute("cardAttachment"));
					educationProofItem.setValue(record.getAttribute("educationProof"));
					degreeProofItem.setValue(record.getAttribute("degreeProof"));
					laborAttachmentsItem.setValue(record.getAttribute("laborAttachments"));
					technicalAttachmentItem.setValue(record.getAttribute("technicalAttachment"));
					bankCardAttachmentItem.setValue(record.getAttribute("bankCardAttachment"));
					attachmentRemarkItem.setValue(record.getAttribute("attachmentRemark"));
				}
			}
		} );
	}
	
	
	private int employeeId;
	private String ifShowPay;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getIfShowPay() {
		return ifShowPay;
	}

	public void setIfShowPay(String ifShowPay) {
		this.ifShowPay = ifShowPay;
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		return false;
	}

	@Override
	public void startEdit() {
	}
	
	
}

