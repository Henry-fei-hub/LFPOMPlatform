package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSSpersonnelbusinesppor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ReadOnlyDisplayAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.TitleClickEvent;
import com.smartgwt.client.widgets.form.fields.events.TitleClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class DelaySpersonnelbusinespporNewForm extends AbstractWizadPage {

	private final DateItem startDateItem;
	private final SelectItem startDateDetailItem;
	private final DateItem endDateItem;
	private final SelectItem endDateDetailItem;
//	private final FloatItem daysItem;
	private final TextAreaItem remarkItem;
//	private final FloatItem livingExpensesItem;
//	private final FloatItem housingFinanceItem;
	private final LinkItem attachmentItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
	private final FloatItem feeItem;

	private final HLayout mainLayout;

	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	public int processType;
	
	private final DetailViewer detailViewer;

	private Record parentData;
	
	private boolean isDelay;

	public DelaySpersonnelbusinespporNewForm(int processType) {
		DSSpersonnelbusinesppor ds = DSSpersonnelbusinesppor.getInstance();
		this.processType = processType;
		isDelay = processType == 22 ? true : false;
		detailViewer = new DetailViewer();
		detailViewer.setWidth("50%");
		detailViewer.setHeight100();
		detailViewer.setDataSource(ds);
		
		__form.setWidth100();
		__form.setHeight100();
		
		mainLayout = new HLayout();

		startDateItem = new DateItem("startDate", shouldNotBeNull + "延期驻场开始日期");
		startDateItem.setRequired(true);
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.setWidth("*");
		if(isDelay){
			startDateItem.setDisabled(true);
			__formItems.add(startDateItem);
		}
		startDateItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null != event.getValue() && null != endDateItem.getValue()) {
					countDays((Date) event.getValue(), endDateItem.getValueAsDate(),
							startDateDetailItem.getValueAsString(), endDateDetailItem.getValueAsString(), event);
				}
			}
		});

		startDateDetailItem = new SelectItem("startDateDetail", shouldNotBeNull + "延期驻场开始时段");
		startDateDetailItem.setRequired(true);
		startDateDetailItem.setDefaultValue(0);
		startDateDetailItem.setWidth("*");
		startDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));
		if(isDelay){
			startDateDetailItem.setDisabled(true);
			__formItems.add(startDateDetailItem);
		}
		startDateDetailItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null != startDateItem.getValue() && null != endDateItem.getValue()) {
					countDays(startDateItem.getValueAsDate(), endDateItem.getValueAsDate(), event.getValue().toString(),
							endDateDetailItem.getValueAsString(), event);
				}
			}
		});

		endDateItem = new DateItem("endDate", shouldNotBeNull + "延期驻场结束日期");
		endDateItem.setRequired(true);
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		endDateItem.setWidth("*");
		if(isDelay)__formItems.add(endDateItem);
		endDateItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null != startDateItem.getValue() && null != event.getValue()) {
					countDays(startDateItem.getValueAsDate(), (Date) event.getValue(),
							startDateDetailItem.getValueAsString(), endDateDetailItem.getValueAsString(), event);
				}
			}
		});

		endDateDetailItem = new SelectItem("endDateDetail", shouldNotBeNull + "延期驻场结束时段");
		endDateDetailItem.setRequired(true);
		endDateDetailItem.setDefaultValue(0);
		endDateDetailItem.setWidth("*");
		endDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));
		if(isDelay)__formItems.add(endDateDetailItem);
		endDateDetailItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null != startDateItem.getValue() && null != endDateItem.getValue()) {
					countDays(startDateItem.getValueAsDate(), endDateItem.getValueAsDate(),
							startDateDetailItem.getValueAsString(), event.getValue().toString(), event);
				}
			}
		});

//		livingExpensesItem = new FloatItem("livingExpenses", shouldNotBeNull + "生活费用(元/月)");
//		livingExpensesItem.setWidth("*");
//		livingExpensesItem.setRequired(true);
//		if(isDelay)__formItems.add(livingExpensesItem);
//		
//		housingFinanceItem = new FloatItem("housingFinance", shouldNotBeNull + "住房费用(元/月)");
//		housingFinanceItem.setWidth("*");
//		housingFinanceItem.setRequired(true);
//		if(isDelay)__formItems.add(housingFinanceItem);
		
		feeItem = new FloatItem("fee", "预计费用（元）");
		feeItem.setWidth("*");
		if(isDelay)__formItems.add(feeItem);
		
//		reasonItem = new TextItem("reason", shouldNotBeNull + "申请缘由");
//		reasonItem.setRequired(true);
//		reasonItem.setWidth("*");
//		__formItems.add(reasonItem);
//
//		planItem = new TextAreaItem("plan", shouldNotBeNull + "行程安排");
//		planItem.setRequired(true);
//		planItem.setColSpan(4);
//		planItem.setRowSpan(3);
//		planItem.setWidth("*");
//		__formItems.add(planItem);
		
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
		if(!isDelay)__formItems.add(attachmentItem);
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
		
//		daysItem = new FloatItem("days", shouldNotBeNull + "可调休天数");
//		daysItem.setWidth("*");
//		daysItem.setDisabled(true);
//		if(isDelay)__formItems.add(daysItem);

		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
//		reasonItem.setColSpan(4);
		mainLayout.addMember(detailViewer);
		mainLayout.addMember(__form);
//		Label label = new Label(
//				"<font style=\"font-weight:bold\">温馨提示：以<font style=\"color:#FF7F27\">开始日期</font>的月份为准，该月份的加班/外出/出差申请须在次月5日前（包括次月5日）提出申请</font>");
//		mainLayout.addMember(label);
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
		valueMap.put("parentId", this.parentData.getAttribute("personnelBusinessId"));
		valueMap.put("companyId", this.parentData.getAttribute("companyId"));
		valueMap.put("projectType", this.parentData.getAttribute("projectType"));
		valueMap.put("projectId", this.parentData.getAttribute("projectId"));
		valueMap.put("projectName", this.parentData.getAttribute("projectName"));
		valueMap.put("projectCode", this.parentData.getAttribute("projectCode"));
		valueMap.put("employeeId", this.parentData.getAttribute("employeeId"));
		valueMap.put("employeeNo", this.parentData.getAttribute("employeeNo"));
		valueMap.put("departmentId", this.parentData.getAttribute("departmentId"));
		valueMap.put("nextAuditor", this.parentData.getAttribute("nextAuditor"));
		valueMap.put("drafter", this.parentData.getAttribute("drafter"));
		valueMap.put("attachment", attachmentItem.getValue());
		return valueMap;
	}
	
	public void initData(Record record){
		Map<String, Object> params = new HashMap<>();
		params.put("personnelBusinessId", record.getAttribute("businessId"));
		params.put("opt_type", "getPersonnelBusinessById");
		DBDataSource.callOperation("EP_CustomPersonnelBusinessProcess", params, new DSCallback() {

			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() > 0) {
					Record __record = dsResponse.getData()[0];
					parentData = __record;
					detailViewer.setData(new Record[] { parentData });
					if(isDelay){
						startDateItem.setValue(parentData.getAttributeAsDate("endDate"));
						startDateDetailItem.setValue(parentData.getAttribute("endDetail"));
					}
				}

			}
		});
	}
	
	private void countDays(Date startDate, Date endDate, String startDateDetail, String endDateDetail, ChangeEvent event){
		if(null!=startDate && null != endDate){
			long times = endDate.getTime()-startDate.getTime();
			if((times < 0) || (times == 0 && !startDateDetail.equals("0") && endDateDetail.equals("0"))){
				SC.say("开始日期必须早于截止日期");
				event.cancel();
			}else{
//				double startDays = 1;
//				double endDays = 0.5;
//				if(!startDateDetail.equals("0")){
//					startDays = 0.5;
//				}
//				if(!endDateDetail.equals("0")){
//					endDays = 0;
//				}
//				double days = times / 1000 / 3600 / 24;
//				days += startDays - endDays;
//				daysItem.setValue(days);
			}
		}
	}

}
