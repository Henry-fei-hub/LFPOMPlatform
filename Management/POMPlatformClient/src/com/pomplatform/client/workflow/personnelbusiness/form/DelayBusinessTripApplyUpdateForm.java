package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSBusinessTripApply;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class DelayBusinessTripApplyUpdateForm extends AbstractWizadPage {
	private static final Logger logger = Logger.getLogger("");

	private final HLayout mainLayout;
	// private final TextItem employeeIdItem;
	// private final TextItem employeeNoItem;
	// private final TextItem departmentIdItem;
	// private final SelectItem companyIdItem;
	private final DateItem startDateItem;
	private final SelectItem startDateDetailItem;
	private final DateItem endDateItem;
	private final SelectItem endDateDetailItem;
	private final TextItem daysItem;
	private final TextItem reasonItem;
	// private final TextAreaItem remarkItem;
	private final TextItem addressItem;
	private final TextAreaItem planItem;
	private final TextItem transportationItem;
	private final TextItem feeItem;
	// private final ComboBoxItem projectIdItem;
	// private final TextItem projectNameItem;
	// private final TextItem projectCodeItem;

	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	private int processType;

	private final DetailViewer detailViewer;

	private Record parentData;

	public DelayBusinessTripApplyUpdateForm(int processType) {
		this.processType = processType;
		boolean isChangeAdress = processType == 20 ? true : false;
		String titleText = isChangeAdress ? "变更" : "延期";
		detailViewer = new DetailViewer();
		detailViewer.setWidth("50%");
		detailViewer.setHeight100();
		detailViewer.setDataSource(DSBusinessTripApply.getInstance());
		mainLayout = new HLayout();
		DSBusinessTripApply ds = DSBusinessTripApply.getInstance();
		__form.setWidth("50%");
		__form.setHeight100();
		// __form.setMargin(5);

		// employeeIdItem = new TextItem("employeeId", "申请人");
		// employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		// employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		// employeeIdItem.setWidth("*");
		// employeeIdItem.setDisabled(true);
		// __formItems.add(employeeIdItem);
		//
		// employeeNoItem = new TextItem("employeeNo", "工号");
		// employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		// employeeNoItem.setWidth("*");
		// employeeNoItem.setDisabled(true);
		// __formItems.add(employeeNoItem);
		//
		// departmentIdItem = new TextItem("departmentId", "部门");
		// departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		// departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		// departmentIdItem.setWidth("*");
		// departmentIdItem.setDisabled(true);
		// __formItems.add(departmentIdItem);
		//
		// companyIdItem = new SelectItem("companyId", shouldNotBeNull +
		// "归属公司");
		// companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		// companyIdItem.setRequired(true);
		// companyIdItem.setWidth("*");
		// __formItems.add(companyIdItem);

		startDateItem = new DateItem("startDate", shouldNotBeNull + titleText + "开始日期");
		startDateItem.setRequired(true);
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.setWidth("*");
		if(!isChangeAdress){startDateItem.setDisabled(true);}
		__formItems.add(startDateItem);
		startDateItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null != event.getValue() && null != endDateItem.getValue()) {
					countDays((Date) event.getValue(), endDateItem.getValueAsDate(),
							startDateDetailItem.getValueAsString(), endDateDetailItem.getValueAsString(), event);
				}
			}
		});

		startDateDetailItem = new SelectItem("startDateDetail", shouldNotBeNull + titleText + "开始时段");
		startDateDetailItem.setRequired(true);
		startDateDetailItem.setDefaultValue(0);
		startDateDetailItem.setWidth("*");
		startDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));
		if(!isChangeAdress){startDateDetailItem.setDisabled(true);}
		__formItems.add(startDateDetailItem);
		startDateDetailItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null != startDateItem.getValue() && null != endDateItem.getValue()) {
					countDays(startDateItem.getValueAsDate(), endDateItem.getValueAsDate(), event.getValue().toString(),
							endDateDetailItem.getValueAsString(), event);
				}
			}
		});

		endDateItem = new DateItem("endDate", shouldNotBeNull + titleText + "结束日期");
		endDateItem.setRequired(true);
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		endDateItem.setWidth("*");
		__formItems.add(endDateItem);
		endDateItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null != startDateItem.getValue() && null != event.getValue()) {
					countDays(startDateItem.getValueAsDate(), (Date) event.getValue(),
							startDateDetailItem.getValueAsString(), endDateDetailItem.getValueAsString(), event);
				}
			}
		});

		endDateDetailItem = new SelectItem("endDateDetail", shouldNotBeNull + titleText + "结束时段");
		endDateDetailItem.setRequired(true);
		endDateDetailItem.setDefaultValue(0);
		endDateDetailItem.setWidth("*");
		endDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));
		__formItems.add(endDateDetailItem);
		endDateDetailItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null != startDateItem.getValue() && null != endDateItem.getValue()) {
					countDays(startDateItem.getValueAsDate(), endDateItem.getValueAsDate(),
							startDateDetailItem.getValueAsString(), event.getValue().toString(), event);
				}
			}
		});

		daysItem = new TextItem("days", "天数");
		daysItem.setWidth("*");
		daysItem.setDisabled(true);
		__formItems.add(daysItem);

		addressItem = new TextItem("address", shouldNotBeNull + titleText + "出差地址");
		addressItem.setRequired(true);
		addressItem.setWidth("*");
		if (isChangeAdress)
			__formItems.add(addressItem);

		transportationItem = new TextItem("transportation", shouldNotBeNull + "交通工具");
		transportationItem.setRequired(true);
		transportationItem.setWidth("*");
		if (isChangeAdress)
			__formItems.add(transportationItem);

		feeItem = new TextItem("fee", titleText + "预计费用（元）");
		feeItem.setWidth("*");
		__formItems.add(feeItem);
		feeItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if (null == event.getValue()) {
					feeItem.setValue(0);
				} else if (!(event.getValue() instanceof Number)) {
					event.cancel();
				} else {
					BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					feeItem.setValue(value);
				}
			}
		});

		reasonItem = new TextItem("reason", shouldNotBeNull + titleText + "申请缘由");
		reasonItem.setRequired(true);
		reasonItem.setWidth("*");
		__formItems.add(reasonItem);

		planItem = new TextAreaItem("plan", shouldNotBeNull + titleText + "行程安排");
		planItem.setRequired(true);
		planItem.setColSpan(4);
		planItem.setRowSpan(3);
		planItem.setWidth("*");
		if (isChangeAdress)
			__formItems.add(planItem);

		// remarkItem = new TextAreaItem("remark", "备注");
		// remarkItem.setColSpan(4);
		// remarkItem.setRowSpan(3);
		// remarkItem.setWidth("*");
		// __formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		reasonItem.setColSpan(4);
		mainLayout.addMember(detailViewer);
		setPageMode(PAGE_MODE_UPDATE);
		mainLayout.addMember(__form);
		addMember(mainLayout);
	}

	public void initData(Record record) {
		Map<String, Object> params = new HashMap<>();
		params.put("personnelBusinessId", record.getAttribute("parentId"));
		params.put("opt_type", "getPersonnelBusinessById");
		DBDataSource.callOperation("EP_CustomPersonnelBusinessProcess", params, new DSCallback() {

			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() > 0) {
					Record __record = dsResponse.getData()[0];
					parentData = __record;
					detailViewer.setData(new Record[] { parentData });
				}

			}
		});

	}

	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if (getRecord() != null){
			__form.editRecord(getRecord());
			initData(getRecord());
		}
		else{
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSBusinessTripApply.getInstance());
		manager.addMember(__form);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public java.util.Map getValuesAsMap() {
		SC.debugger();
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
		if (this.processType == 19) {
			valueMap.put("address", this.parentData.getAttribute("address"));
			valueMap.put("plan", this.parentData.getAttribute("plan"));
			valueMap.put("transportation", this.parentData.getAttribute("transportation"));
		}
		return valueMap;
	}

	private void countDays(Date startDate, Date endDate, String startDateDetail, String endDateDetail,
			ChangeEvent event) {
		if (null != startDate && null != endDate) {
			long times = endDate.getTime() - startDate.getTime();
			if ((times < 0) || (times == 0 && !startDateDetail.equals("0") && endDateDetail.equals("0"))) {
				SC.say("开始日期必须早于截止日期");
				event.cancel();
			} else {
				double startDays = 1;
				double endDays = 0.5;
				if (!startDateDetail.equals("0")) {
					startDays = 0.5;
				}
				if (!endDateDetail.equals("0")) {
					endDays = 0;
				}
				double days = times / 1000 / 3600 / 24;
				days += startDays - endDays;
				daysItem.setValue(days);
			}
		}
	}
}
