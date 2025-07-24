package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.leavetype.panel.PersonalLeaveTypePanel;
import com.pomplatform.client.shift.panel.AttendanceRecordPanel;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSLeaveApply;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class LeaveApplyNewForm2 extends AbstractWizadPage
{

	private final Logger logger = Logger.getLogger("");
	
	/**
	 * 婚假
	 */
	private final String LEAVE_TYPE_1 = "婚假";
	/**
	 * 事假
	 */
	private final String LEAVE_TYPE_2 = "事假";
	/**
	 * 调休
	 */
	private final String LEAVE_TYPE_3 = "调休";
	/**
	 * 陪护假
	 */
	private final String LEAVE_TYPE_4 = "陪护假";
	/**
	 * 年假
	 */
	private final String LEAVE_TYPE_5 = "年假";
	/**
	 * 其他假期
	 */
	private final String LEAVE_TYPE_6 = "其他假期";
	/**
	 * 产假
	 */
	private final String LEAVE_TYPE_7 = "产假";
	/**
	 * 计划生育假
	 */
	private final String LEAVE_TYPE_8 = "计划生育假";
	/**
	 * 丧假
	 */
	private final String LEAVE_TYPE_9 = "丧假";
	/**
	 * 多胞胎假
	 */
	private final String LEAVE_TYPE_10 = "多胞胎假";
	/**
	 * 难产假
	 */
	private final String LEAVE_TYPE_11 = "难产假";
	/**
	 * 产检假
	 */
	private final String LEAVE_TYPE_12 = "产检假";

	/**
	 * 病假
	 */
	private final String LEAVE_TYPE_13 = "病假";


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
	private final LinkItem attachmentItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
	private final DateItem certificationTimeItem;
	private final ComboBoxItem nextAuditorItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private String errorMsg;
	private boolean canApply = true;
	private VLayout left;
	private VLayout right;
	protected DynamicForm formLeft = new DynamicForm();
	protected DynamicForm formRight = new DynamicForm();
	private Map<Object, Object> daysMap = new HashMap<>();
	private double maxDays = 0;
	private double actualDays = 0;
	private final TextItem drafterItem;
	private final TextItem plateTypeItem;

	private final SelectItem unitItem;
	//入职时间
	private Date onboardDate;

	private  IButton viewButton1;

	public LeaveApplyNewForm2() {
		left = new VLayout();
		left.setWidth100();
		left.setHeight100();
		left.setLayoutTopMargin(10);
		right = new VLayout();
		right.setWidth100();
		right.setHeight100();
		right.setLayoutTopMargin(10);
		setMembersMargin(20);
		addMember(left);
		addMember(right);
		
		formLeft.setWidth100();
		formRight.setWidth100();


		Map<String,String> prams = new HashMap<>();
		prams.put("祖父","祖父");
		prams.put("祖母","祖母");
		prams.put("父亲","父亲");
		prams.put("母亲","母亲");
		prams.put("配偶","配偶");
		prams.put("配偶父亲","配偶父亲");
		prams.put("配偶母亲","配偶母亲");
		prams.put("子/女","子/女");

		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();




		int employeeId = ClientUtil.getEmployeeId();


		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDisabled(true);
		employeeIdItem.setWidth("*");
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setWidth("*");
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setDisabled(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());

		plateTypeItem = new TextItem("plateType","模板类型");
		plateTypeItem.hide();

        companyProvinceItem = new SelectItem("companyProvince", "公司所在地");
		companyProvinceItem.setWidth("*");
		companyProvinceItem.setDisabled(true);
		companyProvinceItem.setControlStyle("customInputTextStyle");
		companyProvinceItem.setValueMap(KeyValueManager.getValueMap("areas"));

		typeItem = new SelectItem("type", shouldNotBeNull + "假期类型");
		typeItem.setWidth("*");
		typeItem.setControlStyle("customInputTextStyle");
		typeItem.setValueMap(new LinkedHashMap<>());
		typeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				normalClearValue();
				if(null == event.getValue()){
					subTypeItem.setValueMap(new LinkedHashMap<>());
				}else{
					int type = BaseHelpUtils.getIntValue(typeItem.getValue());
					SC.debugger();
					if(type==9){
						unitItem.show();
						reasonItem.hide();
					}else if(type==21){//调休
						unitItem.hide();
						reasonItem.hide();
					}else{
						unitItem.hide();
						reasonItem.show();
					}
					if(type==21){//调休
						viewButton1.show();
						remarkItem.hide();
					}else {
						viewButton1.hide();
						remarkItem.show();
					}

					maxDays = ClientUtil.checkAndGetDoubleValue(daysMap.get(event.getValue()));
					Map<String, Object> params = new HashMap<>();
					params.put("optType", "getLeaveTypes");
					params.put("employeeId", ClientUtil.getUserId());
					params.put("areaId", companyProvinceItem.getValue());
					params.put("parentId", event.getValue());
					DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									Record[] records = dsResponse.getData();
									LinkedHashMap<String, String> valueMap = new LinkedHashMap<>();
									Integer plateType = 0;
									for(Record record : records){
										valueMap.put(record.getAttribute("leaveTypeId"), record.getAttribute("leaveTypeName"));
										daysMap.put(record.getAttribute("leaveTypeId"), record.getAttribute("days"));
										plateType = BaseHelpUtils.getIntValue(record.getAttribute("plateType"));
									}
									subTypeItem.setValueMap(valueMap);
									plateTypeItem.setDefaultValue(plateType);
									canApply = true;
								}else{
									errorMsg = dsResponse.getErrors().get("errorMsg").toString();
									SC.say(errorMsg);
									canApply = false;
								}

							}
					});
					String value = KeyValueManager.getValue("leave_types", event.getValue().toString());
					//切换背景图片
					resetBackgroundImage(value);
					if(value.equals(LEAVE_TYPE_7)){
						subTypeItem.show();
						subTypeItem.setMultiple(true);
					}else{
						subTypeItem.setMultiple(false);
					}
					if(value.equals(LEAVE_TYPE_8)){
						subTypeItem.show();
					}
					if(value.equals(LEAVE_TYPE_9)){
						subTypeItem.show();
						targetProvinceItem.show();
					}
					if(value.equals(LEAVE_TYPE_1)){
						certificationTimeItem.show();
					}
					if(!value.equals(LEAVE_TYPE_7) && !value.equals(LEAVE_TYPE_8) && !value.equals(LEAVE_TYPE_9)) {
						Integer plateType =BaseHelpUtils.getIntValue(plateTypeItem.getValue()) ;
						SC.debugger();
						if (plateType!=1) {
							if (maxDays > 0) {
								actualDays = maxDays;
								if (value.equals(LEAVE_TYPE_3)) {
									daysItem.setTitle("请假天数");//20240602调整：所有员工不显示可调休时长
//									daysItem.setTitle("请假天数(最多可请假<font style = 'color:red'>" + actualDays + "</font>小时)");
								} else {
									daysItem.setTitle("请假天数(最多可请假<font style = 'color:red'>" + actualDays + "</font>天)");
								}
							} else {
								daysItem.setTitle("请假天数");
							}
						} else {
							daysItem.setTitle("请假天数");
						}
					}
					formRight.redraw();
				}
				
			}
		});
		
		subTypeItem = new SelectItem("subType", shouldNotBeNull + "假期类型明细项");
		subTypeItem.hide();
		subTypeItem.setControlStyle("customInputTextStyle");
		subTypeItem.setValueMap(new LinkedHashMap<>());
		subTypeItem.setWidth("*");
		subTypeItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				boolean show = false;
				double days = 0;
				if(subTypeItem.getMultiple()){
					Object[] arr = (Object[]) event.getValue();
					for(Object obj : arr){
						if(KeyValueManager.getValue("leave_types", obj.toString()).equals(LEAVE_TYPE_10)){
							show = true;
							if(null != numberOfBabyItem.getValue()){
								int num = ClientUtil.checkAndGetIntValue(numberOfBabyItem.getValue());
								days += ClientUtil.checkAndGetDoubleValue(daysMap.get(obj)) * (num - 2);
							}
						}
						days += ClientUtil.checkAndGetDoubleValue(daysMap.get(obj));
					}
				}else{
					if(KeyValueManager.getValue("leave_types", event.getValue().toString()).equals(LEAVE_TYPE_10)){
						show = true;
						if(null != numberOfBabyItem.getValue()){
							int num = ClientUtil.checkAndGetIntValue(numberOfBabyItem.getValue());
							days += ClientUtil.checkAndGetDoubleValue(daysMap.get(event.getValue())) * (num - 2);
						}
					}
					days += ClientUtil.checkAndGetDoubleValue(daysMap.get(event.getValue()));
				}
				if(typeItem.getDisplayValue().equals(LEAVE_TYPE_7)){
					actualDays = days;
				}else{
					if(days > maxDays){
						actualDays = maxDays;
					}else{
						actualDays = days;
					}
				}
				if(actualDays > 0){
					daysItem.setTitle("请假天数(最多可请假<font style = 'color:red'>"+actualDays+"</font>天)");
				}else{
					daysItem.setTitle("请假天数");
				}
				formRight.redraw();
				if(show){
					numberOfBabyItem.show();
				}else{
					numberOfBabyItem.hide();
				}
			}
		});


		nextAuditorItem = new ComboBoxItem("nextAuditor",  shouldNotBeNull +"交接人");
		nextAuditorItem.setWidth("*");
		nextAuditorItem.hide();
		nextAuditorItem.setValueMap(KeyValueManager.getValueMap("use_employees"));


		numberOfBabyItem = new IntegerItem("numberOfBaby", shouldNotBeNull + "婴儿数量");
		numberOfBabyItem.setWidth("*");
		numberOfBabyItem.setTextBoxStyle("customInputTextStyle");
		numberOfBabyItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				double days = 0;
				if(null == event.getValue()){
					numberOfBabyItem.setValue(0);
				}else{
					int num = ClientUtil.checkAndGetIntValue(event.getValue());
					if(num > 0){
						numberOfBabyItem.setValue(num);
						days += ClientUtil.checkAndGetDoubleValue(daysMap.get("5")) * (num - 2);
					}else{
						numberOfBabyItem.setValue(0);
					}
				}
				String[] arr = subTypeItem.getValues();
				for(String obj : arr){
					days += ClientUtil.checkAndGetDoubleValue(daysMap.get(obj));
				}
				actualDays = days;
				if(actualDays > 0){
					daysItem.setTitle("请假天数(最多可请假<font style = 'color:red'>"+actualDays+"</font>天)");
				}else{
					daysItem.setTitle("请假天数");
				}
				formRight.redraw();
			}
		});
		numberOfBabyItem.hide();
		
		targetProvinceItem = new ComboBoxItem("targetProvince", shouldNotBeNull + "目标省份");
		targetProvinceItem.setValueMap(KeyValueManager.getValueMap("provinces"));
		targetProvinceItem.setControlStyle("customInputTextStyle");
		targetProvinceItem.setWidth("*");
		targetProvinceItem.hide();
		targetProvinceItem.setChangeOnKeypress(false);
		targetProvinceItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		startDateItem = new DateTimeItem("startDate", shouldNotBeNull + "开始时间");
		startDateItem.setTextBoxStyle("customInputTextStyle");
		startDateItem.setWidth("*");
		startDateItem.setUseMask(true);
		startDateItem.setUseTextField(true);
		startDateItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue() && null != typeItem.getValue() && null != endDateItem.getValue()){
					Map<String, Object> params = getValuesAsMap();
					params.put("optType", "calculateDaysAndHours");
					params.put("startDate", event.getValue());
					params.put("maxDays", actualDays);
					DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record[] records = dsResponse.getData();
								for(Record record : records){
									daysItem.setValue(record.getAttribute("days"));
								hoursItem.setValue(record.getAttribute("hours"));
							}
								canApply = true;
							}else{
								daysItem.setValue(0);
								hoursItem.setValue(0);
								errorMsg = dsResponse.getErrors().get("errorMsg").toString();
								SC.say(errorMsg);
								canApply = false;
								event.cancel();
							}
							
						}
					});
				}
			}
		});

		startDateItem.addBlurHandler(new BlurHandler() {

			@Override
			public void onBlur(BlurEvent event) {
				if(null != startDateItem.getValue() && null != typeItem.getValue() && null != endDateItem.getValue()){
					Map<String, Object> params = getValuesAsMap();
					params.put("optType", "calculateDaysAndHours");
					params.put("maxDays", actualDays);
					DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {

						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record[] records = dsResponse.getData();
								for(Record record : records){
									daysItem.setValue(record.getAttribute("days"));
									hoursItem.setValue(record.getAttribute("hours"));
								}
								canApply = true;
							}else{
								daysItem.setValue(0);
								hoursItem.setValue(0);
								errorMsg = dsResponse.getErrors().get("errorMsg").toString();
								SC.say(errorMsg);
								canApply = false;
							}

						}
					});
				}
			}
		});
		
		endDateItem = new DateTimeItem("endDate", shouldNotBeNull + "结束时间");
		endDateItem.setTextBoxStyle("customInputTextStyle");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		endDateItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue() && null != typeItem.getValue() && null != startDateItem.getValue()){
					Map<String, Object> params = getValuesAsMap();
					params.put("optType", "calculateDaysAndHours");
					params.put("endDate", event.getValue());
					params.put("maxDays", actualDays);
					params.put("plateType",plateTypeItem.getValue());
					SC.debugger();
					DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								SC.debugger();
								Record[] records = dsResponse.getData();
								for(Record record : records){
									daysItem.setValue(record.getAttribute("days"));
									hoursItem.setValue(record.getAttribute("hours"));
								}
								canApply = true;
							}else{
								daysItem.setValue(0);
								hoursItem.setValue(0);
								errorMsg = dsResponse.getErrors().get("errorMsg").toString();
								SC.say(errorMsg);
								canApply = false;
								event.cancel();
							}
							
						}
					});
				}
			}
		});

		startDateItem.addBlurHandler(new BlurHandler() {

			@Override
			public void onBlur(BlurEvent event) {
				if(null != startDateItem.getValue() && null != typeItem.getValue() && null != endDateItem.getValue()){
					Map<String, Object> params = getValuesAsMap();
					params.put("optType", "calculateDaysAndHours");
					params.put("maxDays", actualDays);
					params.put("plateType",plateTypeItem.getValue());
					SC.debugger();
					DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								SC.debugger();
								Record[] records = dsResponse.getData();
								for(Record record : records){
									daysItem.setValue(record.getAttribute("days"));
									hoursItem.setValue(record.getAttribute("hours"));
								}
								canApply = true;
							}else{
								daysItem.setValue(0);
								hoursItem.setValue(0);
								errorMsg = dsResponse.getErrors().get("errorMsg").toString();
								SC.say(errorMsg);
								canApply = false;
							}

						}
					});
				}
			}
		});


		daysItem = new TextItem("days", "请假天数");
		daysItem.setTextBoxStyle("customInputTextStyle");
		daysItem.setWidth("*");
		daysItem.setDisabled(true);
		
		hoursItem = new TextItem("hours", "请假小时数(仅限调休)");
		hoursItem.setTextBoxStyle("customInputTextStyle");
		hoursItem.setWidth("*");
		hoursItem.setDisabled(true);


		unitItem = new SelectItem("unit",shouldNotBeNull + "亲人过世");
		unitItem.setTextBoxStyle("customInputTextStyle");
		unitItem.setValueMap(prams);
		unitItem.setWidth("*");

		reasonItem = new TextItem("reason", shouldNotBeNull + "申请缘由");
		reasonItem.setTextBoxStyle("customInputTextStyle");
		reasonItem.setWidth("*");
		
		attachmentItem = new LinkItem("attachment");
		attachmentItem.setWidth("*");
		attachmentItem.setCanEdit(false);
		attachmentItem.setTitle("附件");
		
		attachmentIdItem = new TextItem("attachmentId", "附件ID");
		attachmentIdItem.setHidden(true);
		
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setHidden(true);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		remarkItem.setTextBoxStyle("customTextAreaStyle");
		
		certificationTimeItem = new DateItem("certificationTime", "领证时间");
		certificationTimeItem.setTextBoxStyle("customInputTextStyle");
		certificationTimeItem.setWidth("*");
		certificationTimeItem.setUseTextField(true);
		certificationTimeItem.setUseMask(true);
		certificationTimeItem.setHidden(true);
		certificationTimeItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				if(null != event.getValue()){
					Map<String, Object> params = new HashMap<>();
					params.put("employeeId", ClientUtil.getUserId());
					DBDataSource.callOperation("ST_Employee", "find", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record[] records = dsResponse.getData();
								if(null != records && records.length > 0){
									Record record = records[0];
									onboardDate = record.getAttributeAsDate("onboardDate");
									if(null != onboardDate && ((Date)event.getValue()).before(onboardDate)){
										SC.say("对不起，只有在入职本公司之后领取结婚证的员工才能够申请婚假");
										event.cancel();
									}
								}
							}else{
								ClientUtil.displayErrorMessage(dsResponse);
								event.cancel();
							}
							
						}
					});
				}
			}
		});
		
//		formLeft.setItems(employeeIdItem, employeeNoItem, departmentIdItem, startDateItem, endDateItem, daysItem, hoursItem, attachmentItem);
		formLeft.setItems(drafterItem, employeeIdItem, employeeNoItem, typeItem, subTypeItem,nextAuditorItem, numberOfBabyItem, targetProvinceItem, certificationTimeItem, unitItem,reasonItem, attachmentItem, attachmentIdItem, attachmentNameItem, remarkItem);
		formLeft.setColWidths("*", "*");
		formLeft.setCellPadding(10);
		formLeft.setTitleWidth(40);
		left.addMember(formLeft);
		left.setLayoutLeftMargin(ClientUtil.checkAndGetIntValue(left.getWidth()*0.2/2));
		left.setLayoutRightMargin(ClientUtil.checkAndGetIntValue(left.getWidth()*0.2/2));
		
//		formRight.setItems(companyProvinceItem, typeItem, subTypeItem, numberOfBabyItem, targetProvinceItem, reasonItem, remarkItem);
		formRight.setItems(companyProvinceItem, departmentIdItem, startDateItem, endDateItem, daysItem, hoursItem);
		formRight.setColWidths("*", "*");
		formRight.setCellPadding(10);
		formRight.setTitleWidth(40);
		right.addMember(formRight);
		right.setLayoutLeftMargin(ClientUtil.checkAndGetIntValue(right.getWidth()*0.2/4));
		right.setLayoutRightMargin(ClientUtil.checkAndGetIntValue(right.getWidth()*0.2/4*3));
		
		setStyleName("customBackground");
		IButton uploadButton = new IButton("上传附件", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				new CommonUploadWindow("上传附件", false, 100, 2, 1, new UploadCallBack() {

					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							attachmentItem.setValue(data.get(key).getAttribute("fileUrl"));
							attachmentIdItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							attachmentItem.setLinkTitle(fileName);
							attachmentNameItem.setValue(fileName);
						}
					}
				});
			}
		});

		IButton viewButton = new IButton("查看请假规则", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow();
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				PersonalLeaveTypePanel panel = new PersonalLeaveTypePanel();
				panel.setEmployeeId(ClientUtil.checkAndGetIntValue(employeeIdItem.getValue()));
				panel.setAreaId(ClientUtil.checkAndGetIntValue(companyProvinceItem.getValue()));
				panel.commonQuery();
				window.addMember(panel);
				window.setTitle("请假规则");
				window.show();
			}
		});


		viewButton1 = new IButton("查看考勤");
		viewButton1.setBaseStyle("customButton");
		viewButton1.hide();
		viewButton1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
					PopupWindow window = new PopupWindow(KeyValueManager.getValue("employees", employeeIdItem.getValueAsString())+"前一天考勤明细");
					Map<String, Object> params = getValuesAsMap();
					params.put("optType", "calculateDaysStartDate");
					logger.info("=======================" );
					Date date =new Date();
					SC.debugger();
					logger.info("======================="+date );
					params.put("startDate",date);
					DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							SC.debugger();
							if(dsResponse.getStatus() >= 0){
								Record record = dsResponse.getData()[0];
								Date startDate = record.getAttributeAsDate("checkInTime");
								Date endDate = record.getAttributeAsDate("checkOutTime");
								logger.info("=======================" + startDate);
								logger.info("=======================" + endDate);
								canApply = true;
								AttendanceRecordPanel panel = new AttendanceRecordPanel();
								panel.setEmployeeId(employeeIdItem.getValueAsString());
								panel.setStartDate(startDate);
								panel.setEndDate(endDate);
								panel.commonQuery();
								window.addMember(panel);
								window.setWidth100();
								window.setHeight100();
								window.centerInPage();
								window.show();
							}else{
								errorMsg = dsResponse.getErrors().get("errorMsg").toString();
								SC.say(errorMsg);
								canApply = false;
								event.cancel();
							}

						}
					});

			}
		});

		uploadButton.setBaseStyle("customButton");
		uploadButton.setWidth(120);
		uploadButton.setHeight(30);
		uploadButton.setLeft(0);
		viewButton.setBaseStyle("customButton");
		viewButton.setWidth(120);
		viewButton.setHeight(30);
		viewButton1.setWidth(120);
		viewButton1.setHeight(30);
		viewButton1.setLeft(0);
		HLayout buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight(viewButton.getHeight());
		buttonLayout.setMembersMargin(20);
		buttonLayout.addMember(uploadButton);
		buttonLayout.addMember(viewButton);
		buttonLayout.addMember(viewButton1);
		Label label = new Label("<font style='color:#FF7F27; font-weight:bold;'>♥ 温馨提示：病假、婚假、产假、产检假、陪护假请点击上方“上传附件”按钮，上传相关证明文件</font>");
		label.setHeight(40);
		label.addChild(uploadButton);
		left.setMembersMargin(10);
		left.addMember(buttonLayout);
		left.addMember(label);
		formLeft.setOverflow(Overflow.AUTO);
		formRight.setOverflow(Overflow.AUTO);
		FormItem[] items = formLeft.getFields();
		for(FormItem item : items){
			item.setTitleOrientation(TitleOrientation.TOP);
			item.setTitleAlign(Alignment.LEFT);
			item.setColSpan(2);
		}
		items = formRight.getFields();
		for(FormItem item : items){
			item.setTitleOrientation(TitleOrientation.TOP);
			item.setTitleAlign(Alignment.LEFT);
			item.setColSpan(2);
		}
	}



	@Override
	public boolean checkData() {
		if(null == companyProvinceItem.getValue()){
			SC.say("请选择公司所在地");
			return false;
		}
		if(null == typeItem.getValue()){
			SC.say("请选择假期类型");
			return false;
		}
		if(null != typeItem.getValue() && (typeItem.getDisplayValue().equals(LEAVE_TYPE_7) || typeItem.getDisplayValue().equals(LEAVE_TYPE_8) || typeItem.getDisplayValue().equals(LEAVE_TYPE_9)) && null == subTypeItem.getValue()){
			SC.say("请选择假期类型明细项");
			return false;
		}
		if(null != typeItem.getValue() && typeItem.getDisplayValue().equals(LEAVE_TYPE_7) && null != subTypeItem.getValue()){
			String value = subTypeItem.getDisplayValue();
			if(value.indexOf(",") >= 0 && value.indexOf(LEAVE_TYPE_11) >= 0){
				SC.say("难产假需要单独申请！");
				return false;
			}
		}
		if(null != typeItem.getValue() && typeItem.getDisplayValue().equals(LEAVE_TYPE_9) && null == targetProvinceItem.getValue()){
			SC.say("请填写上目标省份");
			return false;
		}
		if(null != subTypeItem.getValue() && subTypeItem.getDisplayValue().contains(LEAVE_TYPE_10)){
			if(null == numberOfBabyItem.getValue()){
				SC.say("申请多胞胎假需要填写上婴儿数量");
				return false;
			}else{
				if(ClientUtil.checkAndGetIntValue(numberOfBabyItem.getValue()) < 2){
					SC.say("只有婴儿数量>=2时，才能申请多胞胎假");
					return false;
				}
			}
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
		if((null == daysItem.getValue() || BaseHelpUtils.getBigDecimalValue(daysItem.getValue()).compareTo(BigDecimal.ZERO) == 0) && (null == hoursItem.getValue() || BaseHelpUtils.getBigDecimalValue(hoursItem.getValue()).compareTo(BigDecimal.ZERO) == 0)){
			SC.say("请假天数和小时数不能都为空或0");
			return false;
		}
//		if(null ==nextAuditorItem.getValue()){
//			SC.say("请填写交接人");
//			return false;
//		}

		String type = typeItem.getDisplayValue();
		SC.debugger();
		if(type.equals(LEAVE_TYPE_9)){
			if(null == unitItem.getValue()){
				SC.say("请填写过世亲人");
				return false;
			}
		}else  if(!type.equals(LEAVE_TYPE_9) && !type.equals(LEAVE_TYPE_3)) {
			if (null == reasonItem.getValue()) {
				SC.say("请填写申请缘由");
				return false;
			}
		}

		if(type.equals(LEAVE_TYPE_3)){
			Date startDate = startDateItem.getValueAsDate();
			Date endDate = endDateItem.getValueAsDate();
			logger.info((endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000)+"");
			if((endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) > 8) {
				SC.say("单次申请调休总天数不超过8天（含节假日、公众休息日）");
				return false;
			}
		}else if(type.equals(LEAVE_TYPE_1) || type.equals(LEAVE_TYPE_7) || type.equals(LEAVE_TYPE_12) || type.equals(LEAVE_TYPE_13) ||type.equals(LEAVE_TYPE_4) || type.equals(LEAVE_TYPE_8)){
			if(null == attachmentItem.getValue()){
				SC.say("请上传相关的证明文件");
				return false;
			}
			if(type.equals(LEAVE_TYPE_1)){
				if(certificationTimeItem.getValueAsDate().before(onboardDate)){
					SC.say("对不起，只有在入职本公司之后领取结婚证的员工才能够申请婚假");
					return false;
				}
			}
		}
		if(!canApply){
			SC.say(errorMsg);
			return false;
		}
		return true;
	}

	@Override
	public void startEdit() {
		unitItem.hide();
		reasonItem.show();
		Map<String, Object> params = new HashMap<>();
		String employeeId = ClientUtil.getUserId();
		params.put("optType", "getCompanyAndArea");
		params.put("employeeId", employeeId);
		DBDataSource.callOperation("EP_GetUserInfoById", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					String areaId = records[0].getAttribute("areaId");
					companyProvinceItem.setDefaultValue(areaId);
					Map<String, Object> params = new HashMap<>();
					params.put("optType", "getLeaveTypes");
					params.put("employeeId", employeeId);
					params.put("areaId", areaId);
					logger.info("-------------------- params :" + params);
					DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								SC.debugger();
								daysMap.clear();
								Record[] records = dsResponse.getData();
								LinkedHashMap<String, String> valueMap = new LinkedHashMap<>();
								for(Record record : records){
									valueMap.put(record.getAttribute("leaveTypeId"), record.getAttribute("leaveTypeName"));
									daysMap.put(record.getAttribute("leaveTypeId"), record.getAttribute("days"));
								}
								typeItem.setValueMap(valueMap);
								canApply = true;
							}else{
								errorMsg = dsResponse.getErrors().get("errorMsg").toString();
								SC.say(errorMsg);
								canApply = false;
							}
						}
					});
				}else{
					errorMsg = dsResponse.getErrors().get("errorMsg").toString();
					SC.say(errorMsg);
				}
				
			}
		});
		
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSLeaveApply.getInstance());
		manager.addMember(formLeft);
		manager.addMember(formRight);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = formLeft.getValues();
		FormItem[] leftItems = formRight.getFields();
		for(FormItem item : leftItems){
			map.remove(item.getName());
		}
		Map rightMap = formRight.getValues();
		FormItem[] rightItems = formLeft.getFields();
		for(FormItem item : rightItems){
			rightMap.remove(item.getName());
		}
		map.putAll(rightMap);
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
		certificationTimeItem.clearValue();
		subTypeItem.hide();
		numberOfBabyItem.hide();
		targetProvinceItem.hide();
		certificationTimeItem.hide();
		unitItem.hide();
	}
	
	public void resetBackgroundImage(String value) {
		if(value.equals(LEAVE_TYPE_1)){
			setBackgroundImage("/images/backgrounds/1.jpg");
		}else if(value.equals(LEAVE_TYPE_2)){
			setBackgroundImage("/images/backgrounds/1.jpg");
		}else if(value.equals(LEAVE_TYPE_3)){
			setBackgroundImage("/images/backgrounds/1.jpg");
		}else if(value.equals(LEAVE_TYPE_4)){
			setBackgroundImage("/images/backgrounds/1.jpg");
		}else if(value.equals(LEAVE_TYPE_5)){
			setBackgroundImage("/images/backgrounds/1.jpg");
		}else if(value.equals(LEAVE_TYPE_6)){
			setBackgroundImage("/images/backgrounds/1.jpg");
		}else if(value.equals(LEAVE_TYPE_7)){
			setBackgroundImage("/images/backgrounds/1.jpg");
		}else if(value.equals(LEAVE_TYPE_8)){
			setBackgroundImage("/images/backgrounds/1.jpg");
		}else if(value.equals(LEAVE_TYPE_9)){
			setBackgroundImage("/images/backgrounds/1.jpg");
		}
	}
}
