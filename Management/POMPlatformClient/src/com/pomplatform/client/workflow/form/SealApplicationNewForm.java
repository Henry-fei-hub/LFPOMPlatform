package com.pomplatform.client.workflow.form;

import java.util.*;

import java.util.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.panel.CommonUploadWindow;
import com.delicacy.client.panel.UploadCallBack;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.datasource.DSSealApplication;

public class SealApplicationNewForm extends AbstractWizadPage
{


	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final TextItem typeItem;
	private final DateTimeItem startDateItem;
	private final TextItem startDateDetailItem;
	private final DateTimeItem endDateItem;
	private final TextItem endDateDetailItem;
	private final TextItem daysItem;
	private final TextItem reasonItem;
	private final TextItem remarkItem;
	private final TextItem addressItem;
	private final TextItem planItem;
	private final TextItem transportationItem;
	private final TextItem feeItem;
	private final TextItem unitItem;
	private final TextItem contactPersonItem;
	private final DateTimeItem createTimeItem;
	private final TextItem deleteFlagItem;
	private final SelectItem nextAuditorItem;
	private final TextItem subTypeItem;
	private final TextItem hoursItem;
	private final TextItem companyProvinceItem;
	private final TextItem targetProvinceItem;
	private final TextItem numberOfBabyItem;
	private final TextItem attachmentItem;
	private final CheckboxItem isCompletedItem;
	private final TextItem subTypeStrItem;
	private final TextItem projectTypeItem;
	private final TextItem projectIdItem;
	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;
	private final TextItem parentIdItem;
	private final CheckboxItem isRemoteCityItem;
	private final CheckboxItem provideAccommodationItem;
	private final TextItem livingExpensesItem;
	private final TextItem housingFinanceItem;
	private final TextItem drafterItem;
	private final TextItem cardItem;
	private final TextItem dutyIdItem;
	private final TextItem equivalentNumberItem;
	private final TextItem linkIdItem;
	private final TextItem severanceItem;
	private final PickTreeItem salary1Item;
	private final SelectItem salary2Item;
	private final TextItem originalPayItem;
	private final TextItem monthPayItem;
	private final TextItem basicProportionStrItem;
	private final TextItem basicProportionItem;
	private final TextItem monthBasicPayItem;
	private final TextItem monthPerformancePayItem;
	private final TextItem foremanPayItem;
	private final TextItem otherSubsidyItem;
	private final TextItem totalPayItem;
	private final TextItem annualPerformanceItem;
	private final TextItem costAttributionItem;
	private final DateTimeItem certificationTimeItem;
	private final TextItem projectIdsItem;
	private final TextItem paymentSequenceIdItem;
	private final TextItem budgetManagementIdItem;
	private final TextItem budgetAttachmentIdItem;
	private final TextItem stageIdItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
	private final  TextItem employeeIdItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private final ButtonItem uploadButton7;

	public SealApplicationNewForm() {
		DSSealApplication ds = DSSealApplication.getInstance();
		__form.setWidth100();
		__form.setHeight100();

		Map<Integer,String> map = new HashMap<>();
		map.put(0,"商务合同盖章");
		map.put(1,"人资行政盖章");
		map.put(2,"日常投标文件盖章");

		Map<Integer,String> prams = new HashMap<>();
		prams.put(0,"变更单（普通）");
		prams.put(1,"项目报审文件");
		prams.put(2,"变更单（重大变更）");
		prams.put(3,"设计变更出图及晒图");
		prams.put(4,"项目费用请款");
		prams.put(5,"外包合同");



		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		employeeIdItem.setDisabled(true);
		employeeIdItem.hide();
		__formItems.add(employeeIdItem);

		nextAuditorItem = new SelectItem("nextAuditor", shouldNotBeNull+"盖章类型");
		nextAuditorItem.setValueMap(map);
		nextAuditorItem.setDefaultValue(0);
		nextAuditorItem.setWidth("*");
//		nextAuditorItem.addChangedHandler(new ChangedHandler() {
//			@Override
//			public void onChanged(ChangedEvent changedEvent) {
//				int type = BaseHelpUtils.getIntValue(changedEvent.getValue());
//				SC.debugger();
//				if (type == 1){
//					projectIdItem.show();
//					cardItem.hide();
//					cardItem.setValue("");
//					salary2Item.show();
//				}else {
//					projectIdItem.hide();
//					projectIdItem.setValue("");
//					salary2Item.hide();
//					salary2Item.setValue("");
//					cardItem.show();
//
//					projectCodeItem.setValue("");
//					projectNameItem.setValue("");
//				}
//			}
//		});
		__formItems.add(nextAuditorItem);


		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		__formItems.add(departmentIdItem);

		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.hide();
		__formItems.add(companyIdItem);



		planItem = new TextItem("plan", "薪资2");
		planItem.hide();
		__formItems.add(planItem);


		salary2Item = new SelectItem("salary2", shouldNotBeNull+"盖章内容");
		salary2Item.setWidth("*");
		salary2Item.setValueMap(prams);
		salary2Item.hide();
		__formItems.add(salary2Item);


		cardItem = new TextItem("card", shouldNotBeNull+"盖章内容");
		cardItem.setWidth("*");
		cardItem.show();
		__formItems.add(cardItem);


		companyProvinceItem = new TextItem("companyProvince", "归属公司");
		companyProvinceItem.setWidth("*");
		companyProvinceItem.setDefaultValue(ClientUtil.getCompanyId());
		companyProvinceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyProvinceItem.setTextBoxStyle("customInputTextStyle");
		companyProvinceItem.setDisabled(true);
		__formItems.add(companyProvinceItem);



		addressItem = new TextItem("address", "薪资1");
		addressItem.hide();
		__formItems.add(addressItem);

		salary1Item = new PickTreeItem("salary1", shouldNotBeNull + "请选择印章种类");
		salary1Item.setValueTree(KeyValueManager.getTree("system_dictionary_107"));
		salary1Item.setWidth("*");
//		addressItem.setValueField("treeId");
		salary1Item.setCanSelectParentItems(false);
		salary1Item.setMultiple(true);
		salary1Item.setControlStyle("customInputTextStyle");
		salary1Item.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()) {
					String[] ids = event.getValue().toString().split("/");
					int length = ids.length;
					StringBuilder sb = new StringBuilder();
					for(int i = 1; i < length; i++) {
						if(sb.length() > 0) {
							sb.append("/");
						}
						sb.append(KeyValueManager.getValue("system_dictionary_107", ids[i]));
					}
					if(!BaseHelpUtils.isNullOrEmpty(contactPersonItem.getValue())){
						String contactPerson =BaseHelpUtils.getString(contactPersonItem.getValue()) ;
						String[] strings = contactPerson.split(",");
						String sbname = (sb.toString().split("/"))[0];
						String name = ((strings[0]).split("/"))[0];
						SC.debugger();
						//判断是否是相同的公司
						if(sbname.equals(name)){
							Set set = new HashSet();
							for (int i = 0 ; i<strings.length;i++){
								set.add(strings[i]);
							}
							boolean bool = set.contains(sb.toString());
							if(!bool){
								contactPersonItem.setValue(contactPerson+","+sb.toString());
							}
						}else {
							SC.say("只能选择相同公司的印章");
						}

					}else {
						contactPersonItem.setValue(sb.toString());
					}

				}
			}
		});
		__formItems.add(salary1Item);

		typeItem = new TextItem("type", shouldNotBeNull + "");
		typeItem.setWidth("*");
		typeItem.setTextBoxStyle("customInputTextStyle");
		typeItem.hide();
		typeItem.setCanEdit(false);
		__formItems.add(typeItem);

		contactPersonItem = new TextItem("contactPerson", shouldNotBeNull + "选中的印章种类");
		contactPersonItem.setWidth("*");
		contactPersonItem.setTextBoxStyle("customInputTextStyle");
		contactPersonItem.setCanEdit(false);
		contactPersonItem.setRequired(true);
		__formItems.add(contactPersonItem);

		originalPayItem = new TextItem("originalPay", "附件ID");
		originalPayItem.hide();
		__formItems.add(originalPayItem);


		reasonItem = new TextItem("reason", "附件ID");
		reasonItem.hide();
		__formItems.add(reasonItem);

		unitItem = new TextItem("unit", shouldNotBeNull+"盖章内容扫描件");
		unitItem.setWidth("*");
		unitItem.setRequired(true);


		__formItems.add(unitItem);
		unitItem.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if(!BaseHelpUtils.isNullOrEmpty(unitItem.getValue())){

					Window.open(unitItem.getValue().toString(), "查看附件", "");
				}
			}
		});


		uploadButton7 = new ButtonItem("上传扫描件");
		uploadButton7.setStartRow(false);
		uploadButton7.setWidth(120);
		uploadButton7.setVAlign(VerticalAlignment.BOTTOM);
		uploadButton7.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				new CommonUploadWindow("上传盖章内容扫描件", false, 500, 2, 1, new UploadCallBack() {

					@Override
					public void execute(Map<String, Record> data) {
						// 上传附件文件成功

						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							originalPayItem.setValue(fileId);
							Map<String,Object> params = new HashMap<>();
							params.put("fileId",fileId);
							SC.debugger();
							DBDataSource.callOperation("NQ_FileManages","find", params, new DSCallback() {

								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										Record record = dsResponse.getData()[0];
										SC.debugger();
										unitItem.setValue(record.getAttribute("fileUrl"));

									}
								}
							});
						}
					}
				});
			}
		});
		__formItems.add(uploadButton7);


		projectIdItem = new ComboBoxItem("projectId", shouldNotBeNull+"盖章项目");
		projectIdItem.setWidth("*");
		projectIdItem.hide();
		KeyValueManager.loadValueMap("projects" , projectIdItem);
		__formItems.add(projectIdItem);

		projectIdItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()) {
					HashMap<String, Integer> params = new HashMap<>();
					SC.debugger();
					params.put("projectId", BaseHelpUtils.getIntValue(BaseHelpUtils.getIntValue(projectIdItem.getValue())));
					DBDataSource.callOperation("ST_Project", "find", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
							int status = dsResponse.getStatus();
							if (status >= 0) {
								Record record = dsResponse.getData()[0];
								if (null != record) {
									String contractCode = record.getAttributeAsString("contractCode");
									projectCodeItem.setValue(contractCode);
								}
							}
						}
					});

					projectNameItem.setDefaultValue(projectIdItem.getDisplayValue());
				}
			}
		});

		feeItem = new TextItem("fee", "预计费用");
		feeItem.hide();
		__formItems.add(feeItem);


		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.hide();
		employeeNoItem.setWidth("*");
		HashMap<String, Integer> params = new HashMap<>();
		SC.debugger();
		params.put("employeeId", BaseHelpUtils.getIntValue(BaseHelpUtils.getIntValue(ClientUtil.getEmployeeId())));
		DBDataSource.callOperation("ST_Employee", "find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				int status = dsResponse.getStatus();
				if (status >= 0) {
					Record record = dsResponse.getData()[0];
					if (null != record) {
						String employeeNo = record.getAttributeAsString("employeeNo");
						employeeNoItem.setValue(employeeNo);
					}
				}
			}
		});
		__formItems.add(employeeNoItem);

		transportationItem = new TextItem("transportation", "交通工具");
		transportationItem.hide();
		__formItems.add(transportationItem);




		startDateItem = new DateTimeItem("startDate", "开始日期");
		startDateItem.hide();
		__formItems.add(startDateItem);

		startDateDetailItem = new TextItem("startDateDetail", "0上午   1下午");
		startDateDetailItem.hide();
		__formItems.add(startDateDetailItem);

		endDateItem = new DateTimeItem("endDate", "截止日期");
		endDateItem.hide();
		__formItems.add(endDateItem);

		endDateDetailItem = new TextItem("endDateDetail", "0上午   1下午");
		endDateDetailItem.hide();
		__formItems.add(endDateDetailItem);

		daysItem = new TextItem("days", "天数");
		daysItem.hide();
		__formItems.add(daysItem);




		remarkItem = new TextItem("remark", "备注");
		remarkItem.hide();
		__formItems.add(remarkItem);



		subTypeItem = new TextItem("subType", "假期类型明细项");
		__formItems.add(subTypeItem);
		subTypeItem.hide();


		hoursItem = new TextItem("hours", "小时");
		hoursItem.hide();
		__formItems.add(hoursItem);





		createTimeItem = new DateTimeItem("createTime", "起草时间");
		createTimeItem.hide();
		__formItems.add(createTimeItem);


		deleteFlagItem = new TextItem("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagItem.hide();
		__formItems.add(deleteFlagItem);


		targetProvinceItem = new TextItem("targetProvince", "目标省份");
		targetProvinceItem.hide();
		__formItems.add(targetProvinceItem);


		numberOfBabyItem = new TextItem("numberOfBaby", "多胞胎假请填写婴儿数量");
		numberOfBabyItem.hide();
		__formItems.add(numberOfBabyItem);


		attachmentItem = new TextItem("attachment", "附件");
		attachmentItem.hide();
		__formItems.add(attachmentItem);


		isCompletedItem = new CheckboxItem("isCompleted", "是否审批通过");
		isCompletedItem.hide();
		__formItems.add(isCompletedItem);


		subTypeStrItem = new TextItem("subTypeStr", "假期类型明细项");
		subTypeStrItem.hide();
		__formItems.add(subTypeStrItem);


		projectTypeItem = new TextItem("projectType", "项目类型 1项目 2前期项目");
		projectTypeItem.hide();
		__formItems.add(projectTypeItem);


		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.hide();
		__formItems.add(projectNameItem);


		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.hide();
		__formItems.add(projectCodeItem);


		parentIdItem = new TextItem("parentId", "父级编码  用于记录是根据哪一条记录进行延期");
		parentIdItem.hide();
		__formItems.add(parentIdItem);


		isRemoteCityItem = new CheckboxItem("isRemoteCity", "是否为边远城市");
		isRemoteCityItem.hide();
		__formItems.add(isRemoteCityItem);


		provideAccommodationItem = new CheckboxItem("provideAccommodation", "是否提供住宿");
		provideAccommodationItem.hide();
		__formItems.add(provideAccommodationItem);


		livingExpensesItem = new TextItem("livingExpenses", "生活费用(元/月)");
		livingExpensesItem.hide();
		__formItems.add(livingExpensesItem);


		housingFinanceItem = new TextItem("housingFinance", "住房费用(元/月)");
		housingFinanceItem.hide();
		__formItems.add(housingFinanceItem);


		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getEmployeeId());
		drafterItem.hide();
		__formItems.add(drafterItem);

		dutyIdItem = new TextItem("dutyId", "职务");
		dutyIdItem.hide();
		__formItems.add(dutyIdItem);


		equivalentNumberItem = new TextItem("equivalentNumber", "对等号  与  冲账结合实现 借款与冲账与还款");
		equivalentNumberItem.hide();
		__formItems.add(equivalentNumberItem);


		linkIdItem = new TextItem("linkId", "关联表编码");
		linkIdItem.hide();
		__formItems.add(linkIdItem);

		severanceItem = new TextItem("severance", "离职补偿金");
		severanceItem.hide();
		__formItems.add(severanceItem);








		monthPayItem = new TextItem("monthPay", "月薪");
		monthPayItem.hide();
		__formItems.add(monthPayItem);

		basicProportionStrItem = new TextItem("basicProportionStr", "基本比例（显示用）");
		basicProportionStrItem.hide();
		basicProportionStrItem.hide();
		__formItems.add(basicProportionStrItem);

		basicProportionItem = new TextItem("basicProportion", "基本比例（计算用）");
		basicProportionItem.hide();
		__formItems.add(basicProportionItem);

		monthBasicPayItem = new TextItem("monthBasicPay", "月基本工资");
		monthBasicPayItem.hide();
		__formItems.add(monthBasicPayItem);

		monthPerformancePayItem = new TextItem("monthPerformancePay", "月绩效工资");
		monthPerformancePayItem.hide();
		__formItems.add(monthPerformancePayItem);

		foremanPayItem = new TextItem("foremanPay", "工龄工资");
		foremanPayItem.hide();
		__formItems.add(foremanPayItem);

		otherSubsidyItem = new TextItem("otherSubsidy", "其他补贴");
		otherSubsidyItem.hide();
		__formItems.add(otherSubsidyItem);

		totalPayItem = new TextItem("totalPay", "全薪");
		totalPayItem.hide();
		__formItems.add(totalPayItem);

		annualPerformanceItem = new TextItem("annualPerformance", "年度绩效");
		annualPerformanceItem.hide();
		__formItems.add(annualPerformanceItem);

		costAttributionItem = new TextItem("costAttribution", "费用归属(1IT人员,2管理人员,3设计人员,4研发人员,5营销人员)");
		costAttributionItem.hide();
		__formItems.add(costAttributionItem);

		certificationTimeItem = new DateTimeItem("certificationTime", "领证时间");
		certificationTimeItem.hide();
		__formItems.add(certificationTimeItem);

		projectIdsItem = new TextItem("projectIds", "项目编码");
		projectIdsItem.hide();
		__formItems.add(projectIdsItem);


		paymentSequenceIdItem = new TextItem("paymentSequenceId", "付款序列编码");
		paymentSequenceIdItem.hide();
		__formItems.add(paymentSequenceIdItem);


		budgetManagementIdItem = new TextItem("budgetManagementId", "预算管理编码");
		budgetManagementIdItem.hide();
		__formItems.add(budgetManagementIdItem);


		budgetAttachmentIdItem = new TextItem("budgetAttachmentId", "预算附件编码");
		budgetAttachmentIdItem.hide();
		__formItems.add(budgetAttachmentIdItem);


		stageIdItem = new TextItem("stageId", "阶段id");
		stageIdItem.hide();
		__formItems.add(stageIdItem);

		attachmentIdItem = new TextItem("attachmentId", "附件编码");
		attachmentIdItem.hide();
		__formItems.add(attachmentIdItem);


		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.hide();
		__formItems.add(attachmentNameItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		SC.debugger();
		int type = BaseHelpUtils.getIntValue(nextAuditorItem.getValue());
		if(null == employeeIdItem.getValue()){
			SC.say("请重新登录之后再申请本流程");
			return false;
		}
		if(null == nextAuditorItem.getValue()){
			SC.say("请选择盖章类型");
			return  false;
		}
		if(null ==salary1Item.getValue()){
			SC.say("请选择印章种类");
			return  false;
		}
		if(null ==unitItem.getValue()){
			SC.say("请提交盖章内容扫描件");
			return  false;
		}
//		if(type==1){
//			if(null == projectIdItem.getValue()){
//				SC.say("请选择盖章项目");
//				return  false;
//			}else if(null==salary2Item.getValue()){
//				SC.say("请填写盖章内容");
//				return false;
//			}
//
//		}else {
			if (null == cardItem.getValue()) {
				SC.say("请填写盖章内容");
				return false;
			}
//		}


		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSealApplication.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
