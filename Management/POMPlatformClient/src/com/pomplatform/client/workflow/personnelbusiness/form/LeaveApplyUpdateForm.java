package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.UploadReimbursementAttachments;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSLeaveApply;
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
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.layout.VLayout;

public class LeaveApplyUpdateForm extends AbstractWizadPage
{
private static final Logger logger = Logger.getLogger("");

	private final TextItem personnelBusinessIdItem;
	private final SelectItem processTypeItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem typeItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;
	private final TextItem daysItem;
	private final TextItem reasonItem;
	private final TextAreaItem remarkItem;
	private final SelectItem subTypeItem;
	private final TextItem hoursItem;
	private final SelectItem companyProvinceItem;
	private final ComboBoxItem targetProvinceItem;
	private final IntegerItem numberOfBabyItem;
	private final TextItem attachmentItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private String errorMsg;
	private VLayout formLayout;//存放表单数据
	private VLayout vLayout;//表单+上传附件按钮

	public LeaveApplyUpdateForm() {
		DSLeaveApply ds = DSLeaveApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "人事业务编码");
		personnelBusinessIdItem.setDisabled(true);
		personnelBusinessIdItem.setRequired(true);
		personnelBusinessIdItem.hide();
		IsIntegerValidator personnelBusinessIdValidator = new IsIntegerValidator();
		personnelBusinessIdItem.setValidators(personnelBusinessIdValidator);
		__formItems.add(personnelBusinessIdItem);
		
		processTypeItem = new SelectItem("processType", "类型 12请假  13出差  14打卡  15外出  16加班");
		processTypeItem.setValueMap(KeyValueManager.getValueMap("system_process_types"));
		processTypeItem.hide();
		__formItems.add(processTypeItem);
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDisabled(true);
		employeeIdItem.setWidth("*");
		__formItems.add(employeeIdItem);
		
		companyProvinceItem = new SelectItem("companyProvince", shouldNotBeNull + "公司所在省份");
		companyProvinceItem.setWidth("*");
		companyProvinceItem.setValueMap(KeyValueManager.getValueMap("areas"));
		companyProvinceItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				typeItem.clearValue();
				normalClearValue();
				if(null != event.getValue()){
					Map<String, Object> params = new HashMap<>();
					params.put("optType", "getLeaveTypes");
					params.put("employeeId", ClientUtil.getUserId());
					params.put("provinceId", event.getValue());
					DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record[] records = dsResponse.getData();
								LinkedHashMap<String, String> valueMap = new LinkedHashMap<>();
								for(Record record : records){
									valueMap.put(record.getAttribute("leaveTypeId"), record.getAttribute("leaveTypeName"));
								}
								typeItem.setValueMap(valueMap);
							}else{
								ClientUtil.displayErrorMessage(dsResponse);
							}
							
						}
					});
				}
			}
		});
		__formItems.add(companyProvinceItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setWidth("*");
		__formItems.add(employeeNoItem);
		
		typeItem = new SelectItem("type", shouldNotBeNull + "假期类型");
		typeItem.setWidth("*");
		typeItem.setValueMap(new LinkedHashMap<>());
		typeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				normalClearValue();
				if(null == event.getValue()){
					subTypeItem.setValueMap(new LinkedHashMap<>());
				}else{
					subTypeItem.setValueMap(KeyValueManager.getValueMap("leave_types", event.getValue().toString()));
					String value = KeyValueManager.getValue("leave_types", event.getValue().toString());
					if(value.equals("产假")){
						subTypeItem.setMultiple(true);
					}else{
						subTypeItem.setMultiple(false);
					}
				}
				
			}
		});
		__formItems.add(typeItem);
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setDisabled(true);
		departmentIdItem.setWidth("*");
		__formItems.add(departmentIdItem);
		
		subTypeItem = new SelectItem("subType", "假期类型明细项(产假和计划生育假必填)");
		subTypeItem.setValueMap(new LinkedHashMap<>());
		subTypeItem.setWidth("*");
		__formItems.add(subTypeItem);
		
		numberOfBabyItem = new IntegerItem("numberOfBaby", "婴儿数量(多胞胎假填写)");
		numberOfBabyItem.setWidth("*");
		__formItems.add(numberOfBabyItem);
		
		targetProvinceItem = new ComboBoxItem("targetProvince", "目标省份(丧假填写)");
		targetProvinceItem.setValueMap(KeyValueManager.getValueMap("provinces"));
		targetProvinceItem.setWidth("*");
		targetProvinceItem.setChangeOnKeypress(false);
		targetProvinceItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(targetProvinceItem);
		
		startDateItem = new DateTimeItem("startDate", shouldNotBeNull + "开始时间");
		startDateItem.setWidth("*");
		startDateItem.setUseMask(true);
		startDateItem.setUseTextField(true);
		__formItems.add(startDateItem);
		startDateItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue() && null != typeItem.getValue() && null != endDateItem.getValue()){
					Map<String, Object> params = getValuesAsMap();
					params.put("optType", "calculateDaysAndHours");
					params.put("startDate", event.getValue());
					DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record[] records = dsResponse.getData();
								for(Record record : records){
									daysItem.setValue(record.getAttribute("days"));
									hoursItem.setValue(record.getAttribute("hours"));
								}
							}else{
								errorMsg = dsResponse.getErrors().get("errorMsg").toString();
								SC.say(errorMsg);
								event.cancel();
							}
							
						}
					});
				}
			}
		});
		
		endDateItem = new DateTimeItem("endDate", shouldNotBeNull + "结束时间");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		__formItems.add(endDateItem);
		endDateItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue() && null != typeItem.getValue() && null != startDateItem.getValue()){
					Map<String, Object> params = getValuesAsMap();
					params.put("optType", "calculateDaysAndHours");
					params.put("endDate", event.getValue());
					DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record[] records = dsResponse.getData();
								for(Record record : records){
									daysItem.setValue(record.getAttribute("days"));
									hoursItem.setValue(record.getAttribute("hours"));
								}
							}else{
								errorMsg = dsResponse.getErrors().get("errorMsg").toString();
								SC.say(errorMsg);
								event.cancel();
							}
							
						}
					});
				}
			}
		});
		
		daysItem = new TextItem("days", "请假天数");
		daysItem.setWidth("*");
		daysItem.setDisabled(true);
		__formItems.add(daysItem);
		
		hoursItem = new TextItem("hours", "请假小时数(仅限事假和病假)");
		hoursItem.setWidth("*");
		hoursItem.setDisabled(true);
		__formItems.add(hoursItem);
		
		reasonItem = new TextItem("reason", shouldNotBeNull + "申请缘由");
		reasonItem.setWidth("*");
		__formItems.add(reasonItem);
		
		attachmentItem = new TextItem("attachment", "附件");
		attachmentItem.setWidth("*");
		attachmentItem.setDisabled(true);
		__formItems.add(attachmentItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		
		formLayout = new VLayout();
		formLayout.addMember(__form);
		formLayout.setWidth100();
		formLayout.setHeight("80%");
		
		IButton uploadButton = new IButton("上传附件", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> map = new HashMap<>();
				map.put("employeeId", ClientUtil.getUserId());
				UploadReimbursementAttachments uploadPanel = new UploadReimbursementAttachments(map, DBDataSource.getServerURL("UP_UploadPersonnelBusinessAttachments"));
                uploadPanel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        //上传附件确认函成功
                        attachmentItem.setValue(event.getData().getAttribute("attachmentUrl"));
                    }
                });
                uploadPanel.show();
			}
		});
		
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(6);
		vLayout.addMember(formLayout);
		Label label = new Label("<font style='color:#FF7F27; font-weight:bold;'>♥ 温馨提示：病假、婚假、产假、产检假、陪护假请点击上方“上传附件”按钮，上传相关证明文件</font>");
		vLayout.addMember(uploadButton);
		vLayout.addMember(label);
		addMember(vLayout);
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			__form.editRecord(getRecord());
			String str = getRecord().getAttribute("subType");
			if(!ClientUtil.isNullOrEmpty(str)){
				subTypeItem.setValues(str.split(","));
			}
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSLeaveApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null == companyProvinceItem.getValue()){
			SC.say("请选择公司所在省份");
			return false;
		}
		if(null == typeItem.getValue()){
			SC.say("请选择假期类型");
			return false;
		}
		if(null != typeItem.getValue() && (typeItem.getDisplayValue().equals("产假") || typeItem.getDisplayValue().equals("计划生育假")) && null == subTypeItem.getValue()){
			SC.say("请选择假期类型明细项");
			return false;
		}
		if(null != typeItem.getValue() && typeItem.getDisplayValue().equals("丧假") && null == targetProvinceItem.getValue()){
			SC.say("请填写上目标省份");
			return false;
		}
		if(null != subTypeItem.getValue() && subTypeItem.getDisplayValue().contains("多胞胎假") && null == numberOfBabyItem.getValue()){
			SC.say("申请多胞胎假需要填写上婴儿数量");
			return false;
		}
		if(null == startDateItem.getValue()){
			SC.say("请填写开始时间");
			return false;
		}
		if(null == endDateItem.getValue()){
			SC.say("请填写结束时间");
			return false;
		}
		if(startDateItem.getValueAsDate().after(endDateItem.getValueAsDate())){
			SC.say("开始时间必须小于等于结束时间");
			return false;
		}
		if(null == reasonItem.getValue()){
			SC.say("请填写申请缘由");
			return false;
		}
		String type = typeItem.getDisplayValue();
		if(type.equals("调休")){
			Date startDate = startDateItem.getValueAsDate();
			Date endDate = endDateItem.getValueAsDate();
			logger.info((endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000)+"");
			if((endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) > 8) {
				SC.say("单次申请调休总天数不超过8天（含节假日、公众休息日）");
				return false;
			}
		}else if(type.equals("婚假") || type.equals("产假") || type.equals("产检假") || type.equals("陪护假")){
			if(null == attachmentItem.getValue()){
				SC.say("请上传相关的证明文件");
				return false;
			}
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
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
			map.put("subTypeStr", subTypeItem.getDisplayValue());
		}
		return map;
	}

	private void normalClearValue() {
		subTypeItem.clearValue();
		startDateItem.clearValue();
		endDateItem.clearValue();
		daysItem.clearValue();
		hoursItem.clearValue();
		numberOfBabyItem.clearValue();
		targetProvinceItem.clearValue();
	}
}
