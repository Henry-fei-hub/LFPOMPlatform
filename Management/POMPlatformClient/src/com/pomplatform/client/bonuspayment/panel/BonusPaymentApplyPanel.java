package com.pomplatform.client.bonuspayment.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.bonuspayment.datasource.DSBonusPaymentDetail;
import com.pomplatform.client.common.ClientStaticUtils;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class BonusPaymentApplyPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger logger = Logger.getLogger("");
	private SelectItem plateIdItem;
	private DateItem payDateItem;
	private DoubleItem payIntegralItem;
	private TextAreaItem remarkItem;
	public static DelicacyListGrid grid;
	public void initComponents(String plateName) {
		grid = new DelicacyListGrid();
		grid.setCanEdit(true);
		grid.setShowRowNumbers(true);
		grid.setAutoFitFieldWidths(false);
		setWidth100();
		setHeight100();
		setPadding(10);
		setMembersMargin(5);

		VLayout formLayout = new VLayout();
		formLayout.setHeight100();
		formLayout.setMembersMargin(5);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);

		HLayout messageLayout = new HLayout();
		messageLayout.setWidth100();
		messageLayout.setHeight("19%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setPadding(5);
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setWidth100();
		form.setHeight100();

		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.setWidth("*");
		plateIdItem.setValue(plateId);
		if (null != plateIdArray && plateIdArray.length > 0) {
			plateIdItem.addChangeHandler(new ChangeHandler() {

				@Override
				public void onChange(ChangeEvent event) {
					String tempPlateId = BaseHelpUtils.getString(event.getValue());
					boolean hasChanged = false;
					for (String str : plateIdArray) {
						if (tempPlateId.equals(str)) {
							plateId = BaseHelpUtils.getIntValue(str);
							hasChanged = true;
//							load();
							grid.setData(new RecordList());
							break;
						}
					}
					if (!hasChanged) {
						plateIdItem.setValue(event.getOldValue());
						SC.warn("提示", "您没有该部门的奖金发放申请权限");
					}
				}
			});
		} else {
			plateIdItem.setDisabled(true);
		}

		payDateItem = new DateItem("payDate", "申请日期");
		payDateItem.setWidth("*");
		payDateItem.setDisabled(true);
		payDateItem.setUseTextField(true);
		payDateItem.setDefaultValue(new Date());
		payDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

		payIntegralItem = new DoubleItem("payIntegral", "发放积分");
		payIntegralItem.setLength(12);
		payIntegralItem.setDecimalPad(2);
		payIntegralItem.setFormat("#,###,###,##0.00");
		payIntegralItem.setWidth("*");
		payIntegralItem.setCanEdit(false);

		remarkItem = new TextAreaItem("remark", "申请缘由");
		remarkItem.setLength(512);
		remarkItem.setColSpan(6);
		remarkItem.setRowSpan(2);
		remarkItem.setWidth("*");
		remarkItem.setHeight(70);

		form.setItems(plateIdItem, payDateItem, payIntegralItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);
		
		Label label = new Label("<font style='color:#F48719;font-weight:bold;'>请选择发放第几季度的奖金：");
		label.setHeight(20);
		formLayout.addMember(label);
		HLayout buttonLayout = new HLayout(10);
		buttonLayout.setHeight("5%");
		buttonLayout.setWidth100();
		IButton firstItem = new IButton("第一季度");
		firstItem.setWidth("*");
		IButton twoItem = new IButton("第二季度");
		twoItem.setWidth("*");
		IButton threeItem = new IButton("第三季度");
		threeItem.setWidth("*");
		IButton fourItem = new IButton("第四季度");
		fourItem.setWidth("*");
		buttonLayout.addMember(firstItem);
		buttonLayout.addMember(twoItem);
		buttonLayout.addMember(threeItem);
		buttonLayout.addMember(fourItem);
		formLayout.addMember(buttonLayout);
		
		firstItem.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				//加载第一季度的数据
				Date date = new Date();
				date.setMonth(2);
				setPayDate(date);
				load();
			}
		});
		
		twoItem.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				//加载第二季度的数据
				Date date = new Date();
				date.setMonth(5);
				setPayDate(date);
				load();
			}
		});
		
		threeItem.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				//加载第三季度的数据
				Date date = new Date();
				date.setMonth(8);
				setPayDate(date);
				load();
			}
		});
		
		fourItem.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				//加载第四季度的数据
				Date date = new Date();
				//如果当前月份为1月份，那么该第四季度是上一年的，年份改为上一年的年份
				if(date.getMonth() == 0){
					int currentYear = date.getYear();
					date.setYear(currentYear-1);
				}
				date.setMonth(11);
				setPayDate(date);
				load();
			}
		});
		
		int index = 0;
		ListGridField[] fields = new ListGridField[11];
		fields[index] = new ListGridField("bonusPaymentRecordId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("bonusPaymentDetailId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("employeeNo");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("employeeName");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("achieveIntegral");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("payPercent");
		fields[index].setCanEdit(true);
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("payIntegral");
		fields[index].setCanEdit(true);
		index++;
		fields[index] = new ListGridField("leftIntegral");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("plateId");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("status");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("sendNumber");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(true);
		fields[index].addChangeHandler(new com.smartgwt.client.widgets.grid.events.ChangeHandler() {
			@Override
			public void onChange(com.smartgwt.client.widgets.grid.events.ChangeEvent event) {
				int sendNumber=BaseHelpUtils.getIntValue(event.getValue());
				if(sendNumber>3||sendNumber<=0) {
					SC.say("发放次数不能超过3次或小于等于0");
					event.cancel();
				}
			}
		});
		index++;
		fields[index] = new ListGridField("firstIntegral");
		fields[index].setCanEdit(true);
		fields[index].addChangeHandler(new com.smartgwt.client.widgets.grid.events.ChangeHandler() {
			@Override
			public void onChange(com.smartgwt.client.widgets.grid.events.ChangeEvent event) {
				BigDecimal firstIntegral=BaseHelpUtils.getBigDecimalValue(event.getValue());
				if(firstIntegral.compareTo(BigDecimal.ZERO)<0) {
					SC.say("发放积分不能小于0");
					event.cancel();
				}
			}
		});
		index++;
		fields[index] = new ListGridField("secondIntegral");
		fields[index].setCanEdit(true);
		fields[index].addChangeHandler(new com.smartgwt.client.widgets.grid.events.ChangeHandler() {
			@Override
			public void onChange(com.smartgwt.client.widgets.grid.events.ChangeEvent event) {
				BigDecimal secondIntegral=BaseHelpUtils.getBigDecimalValue(event.getValue());
				if(secondIntegral.compareTo(BigDecimal.ZERO)<0) {
					SC.say("发放积分不能小于0");
					event.cancel();
				}
			}
		});
		index++;
		fields[index] = new ListGridField("thirdIntegral");
		fields[index].setCanEdit(true);
		fields[index].addChangeHandler(new com.smartgwt.client.widgets.grid.events.ChangeHandler() {
			@Override
			public void onChange(com.smartgwt.client.widgets.grid.events.ChangeEvent event) {
				BigDecimal thirdIntegral=BaseHelpUtils.getBigDecimalValue(event.getValue());
				if(thirdIntegral.compareTo(BigDecimal.ZERO)<0) {
					SC.say("发放积分不能小于0");
					event.cancel();
				}
			}
		});
		grid.setFields(fields);
		grid.setDataSource(DSBonusPaymentDetail.getInstance());
		grid.setHeight("65%");
		grid.setWidth100();
		grid.setShowGridSummary(true);
		grid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onSuccess() {
						ListGridRecord record = grid.getSelectedRecord();
						if(record.getAttributeAsBoolean("canEdit")){
							grid.startEditing(grid.getRowNum(record));
						}else{
							grid.cancelEditing();
						}
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		grid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Record record = grid.getRecord(event.getRowNum());
				int colNum = event.getColNum();
				String fileName = grid.getFieldName(colNum);
				
				BigDecimal payIntegral = new BigDecimal(payIntegralItem.getValueAsString())
						.subtract(new BigDecimal(record.getAttribute("payIntegral")));
				BigDecimal achieveIntegral = new BigDecimal(record.getAttribute("achieveIntegral"));
				
				BigDecimal firstIntegral=BaseHelpUtils.getBigDecimalValue(record.getAttribute("firstIntegral"));//第一次发放积分
				BigDecimal secondIntegral=BaseHelpUtils.getBigDecimalValue(record.getAttribute("secondIntegral"));//第二次发放积分
				BigDecimal thirdIntegral=BaseHelpUtils.getBigDecimalValue(record.getAttribute("thirdIntegral"));//第三次发放积分
				
				
				if(fileName.equals("payPercent")){//修改比例，发放积分自动计算
					BigDecimal temp = new BigDecimal(
							ClientUtil.checkAndGetDoubleValue(record.getAttribute("payPercent")) / 100);
					//限制奖金发放比例最大只能为100%
					if (temp.compareTo(BigDecimal.ONE) > 0) {
						temp = BigDecimal.ONE;
						record.setAttribute("payPercent", 100);
					}
					temp = achieveIntegral.multiply(temp).divide(BigDecimal.ONE,2,BigDecimal.ROUND_DOWN);
					payIntegral = payIntegral.add(temp);
					payIntegralItem.setValue(payIntegral);
					record.setAttribute("payIntegral", temp);
					record.setAttribute("leftIntegral", achieveIntegral.subtract(temp));
					
					//发放次数
					int sendNumber=BaseHelpUtils.getIntValue(record.getAttribute("sendNumber"));
					if(sendNumber<=0) {
						SC.say("发放次数不能超过3次或小于等于0");
					}
					
					BigDecimal leftIntegral = BigDecimal.ZERO;
					BigDecimal value = BigDecimal.ZERO;
					switch (sendNumber) {
					case 1:
						record.setAttribute("firstIntegral", temp);
						record.setAttribute("secondIntegral", BigDecimal.ZERO);
						record.setAttribute("thirdIntegral", BigDecimal.ZERO);
						break;
					case 2:
						BigDecimal two = new BigDecimal("2");
						value=temp.divide(two,2,BigDecimal.ROUND_DOWN);
						leftIntegral = temp.subtract(value.multiply(two));
						record.setAttribute("firstIntegral", value);
						record.setAttribute("secondIntegral", value.add(leftIntegral));
						record.setAttribute("thirdIntegral", BigDecimal.ZERO);
						break;
					case 3:
						BigDecimal three = new BigDecimal("3");
						value=temp.divide(three,2,BigDecimal.ROUND_DOWN);
						leftIntegral = temp.subtract(value.multiply(three));
						record.setAttribute("firstIntegral", value);
						record.setAttribute("secondIntegral", value);
						record.setAttribute("thirdIntegral", value.add(leftIntegral));
						break;
					}
					
				}else if(fileName.equals("payIntegral")){//修改发放积分，相应比例自动计算
					BigDecimal newIntegral = BaseHelpUtils.format(BaseHelpUtils.getBigDecimalValue(record.getAttribute("payIntegral")), 2);
					if(newIntegral.compareTo(achieveIntegral) > 0){
						newIntegral = achieveIntegral;
						record.setAttribute("payIntegral", newIntegral);
					}
					Record[] records = grid.getRecords();
					BigDecimal totalIntegral = BigDecimal.ZERO;
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						for(Record e : records){
							totalIntegral = totalIntegral.add(BaseHelpUtils.getBigDecimalValue(e.getAttribute("payIntegral")));
						}
					}
					payIntegralItem.setValue(totalIntegral);
					BigDecimal percent = newIntegral.multiply(BigDecimal.valueOf(100)).divide(achieveIntegral,2,BigDecimal.ROUND_HALF_UP);
					record.setAttribute("payPercent", percent);
					record.setAttribute("leftIntegral", achieveIntegral.subtract(newIntegral));
					
					//发放次数
					int sendNumber=BaseHelpUtils.getIntValue(record.getAttribute("sendNumber"));
					if(sendNumber<=0) {
						SC.say("发放次数不能超过3次或小于等于0");
					}
					
					BigDecimal leftIntegral = BigDecimal.ZERO;
					BigDecimal value = BigDecimal.ZERO;
					switch (sendNumber) {
					case 1:
						record.setAttribute("firstIntegral", newIntegral);
						record.setAttribute("secondIntegral", BigDecimal.ZERO);
						record.setAttribute("thirdIntegral", BigDecimal.ZERO);
						break;
					case 2:
						BigDecimal two = new BigDecimal("2");
						value=newIntegral.divide(two,2,BigDecimal.ROUND_DOWN);
						leftIntegral = newIntegral.subtract(value.multiply(two));
						record.setAttribute("firstIntegral", value);
						record.setAttribute("secondIntegral", value.add(leftIntegral));
						record.setAttribute("thirdIntegral", BigDecimal.ZERO);
						break;
					case 3:
						BigDecimal three = new BigDecimal("3");
						value=newIntegral.divide(three,2,BigDecimal.ROUND_DOWN);
						leftIntegral = newIntegral.subtract(value.multiply(three));
						record.setAttribute("firstIntegral", value);
						record.setAttribute("secondIntegral", value);
						record.setAttribute("thirdIntegral", value.add(leftIntegral));
						break;
					}
					
				}else if(fileName.equals("sendNumber")) {//发放次数
					int sendNumber=BaseHelpUtils.getIntValue(record.getAttribute("sendNumber"));
					BigDecimal payIntegrals=BaseHelpUtils.getBigDecimalValue(record.getAttribute("payIntegral"));//价值积分
					BigDecimal leftIntegral = BigDecimal.ZERO;
					BigDecimal value = BigDecimal.ZERO;
					switch (sendNumber) {
					case 1:
						record.setAttribute("firstIntegral", payIntegrals);
						record.setAttribute("secondIntegral", BigDecimal.ZERO);
						record.setAttribute("thirdIntegral", BigDecimal.ZERO);
						break;
					case 2:
						BigDecimal two = new BigDecimal("2");
						value=payIntegrals.divide(two,2,BigDecimal.ROUND_DOWN);
						leftIntegral = payIntegrals.subtract(value.multiply(two));
						record.setAttribute("firstIntegral", value);
						record.setAttribute("secondIntegral", value.add(leftIntegral));
						record.setAttribute("thirdIntegral", BigDecimal.ZERO);
						break;
					case 3:
						BigDecimal three = new BigDecimal("3");
						value=payIntegrals.divide(three,2,BigDecimal.ROUND_DOWN);
						leftIntegral = payIntegrals.subtract(value.multiply(three));
						record.setAttribute("firstIntegral", value);
						record.setAttribute("secondIntegral", value);
						record.setAttribute("thirdIntegral", value.add(leftIntegral));
						break;
					}
				}else if (fileName.equals("firstIntegral")||fileName.equals("secondIntegral")||fileName.equals("thirdIntegral")) {
					int number=0;
					if(firstIntegral.compareTo(BigDecimal.ZERO)>0&&secondIntegral.compareTo(BigDecimal.ZERO)<=0&&thirdIntegral.compareTo(BigDecimal.ZERO)<=0) {
						number=1;
					}else if(secondIntegral.compareTo(BigDecimal.ZERO)>0&&firstIntegral.compareTo(BigDecimal.ZERO)<=0&&thirdIntegral.compareTo(BigDecimal.ZERO)<=0) {
						number=1;
					}else if(thirdIntegral.compareTo(BigDecimal.ZERO)>0&&firstIntegral.compareTo(BigDecimal.ZERO)<=0&&secondIntegral.compareTo(BigDecimal.ZERO)<=0) {
						number=1;
					}else if(firstIntegral.compareTo(BigDecimal.ZERO)>0&&secondIntegral.compareTo(BigDecimal.ZERO)>0&&thirdIntegral.compareTo(BigDecimal.ZERO)<=0) {
						number=2;
					}else if(firstIntegral.compareTo(BigDecimal.ZERO)>0&&secondIntegral.compareTo(BigDecimal.ZERO)<=0&&thirdIntegral.compareTo(BigDecimal.ZERO)>0) {
						number=2;
					}else if(firstIntegral.compareTo(BigDecimal.ZERO)<=0&&secondIntegral.compareTo(BigDecimal.ZERO)>0&&thirdIntegral.compareTo(BigDecimal.ZERO)>0) {
						number=2;
					}else if(firstIntegral.compareTo(BigDecimal.ZERO)>0&&secondIntegral.compareTo(BigDecimal.ZERO)>0&&thirdIntegral.compareTo(BigDecimal.ZERO)>0) {
						number=3;
					}
					record.setAttribute("sendNumber", number);
				}
				
				
				
				
				
				RecordList list = grid.getDataAsRecordList();
				list.set(event.getRowNum(), record);
				grid.setData(list);
				grid.redraw();
			}
		});

		formLayout.addMember(grid);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("5%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		IButton totalButton = new IButton("汇总");
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = grid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double achieveIntegral = 0;
					double payIntegral = 0;
					double leftIntegral = 0;
					double firstIntegral = 0;
					double secondIntegral = 0;
					double thirdIntegral = 0;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("employeeNo"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						achieveIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("achieveIntegral"));
						payIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("payIntegral"));
						leftIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("leftIntegral"));
						firstIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("firstIntegral"));
						secondIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("secondIntegral"));
						thirdIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("thirdIntegral"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("employeeNo", "汇总");
					record.setAttribute("achieveIntegral", achieveIntegral);
					record.setAttribute("payIntegral", payIntegral);
					record.setAttribute("leftIntegral", leftIntegral);
					record.setAttribute("firstIntegral", firstIntegral);
					record.setAttribute("secondIntegral", secondIntegral);
					record.setAttribute("thirdIntegral", thirdIntegral);
					records[len] = record;
					grid.setData(records);
					grid.redraw();
					grid.setCanEdit(false);
				}
			}
		});

		IButton okButton = new IButton("申请");
		okButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (plateId == 0) {
					SC.warn("提示", "当前部门无法进行奖金发放申请");
					return;
				}
				final RecordList records = grid.getDataAsRecordList();
				Record[]  recorda=grid.getRecords();
				for (Record record : recorda) {
					//限制三次发放金额必须等于发放总金额
					String employeeName=BaseHelpUtils.getString(record.getAttribute("employeeName"));
					BigDecimal payIntegrala=BaseHelpUtils.getBigDecimalValue(record.getAttribute("payIntegral"));//发放积分
					BigDecimal firstIntegral=BaseHelpUtils.getBigDecimalValue(record.getAttribute("firstIntegral"));//第一次发放积分
					BigDecimal secondIntegral=BaseHelpUtils.getBigDecimalValue(record.getAttribute("secondIntegral"));//第二次发放积分
					BigDecimal thirdIntegral=BaseHelpUtils.getBigDecimalValue(record.getAttribute("thirdIntegral"));//第三次发放积分
					BigDecimal totalIntegrals=firstIntegral.add(secondIntegral).add(thirdIntegral);
					if(payIntegrala.compareTo(totalIntegrals)!=0) {
						SC.say("【"+employeeName+"】的发放次数总积分【"+totalIntegrals+"】必须等于发放积分【"+payIntegrala+"】,请核对");
						return;
					}
				}
				final int length = records.getLength();
				if (length == 0) {
					SC.warn("提示", "没有人员可以申请奖金发放");
					return;
				}
				if (new BigDecimal(payIntegralItem.getValueAsString()).compareTo(BigDecimal.ZERO) == 0) {
					SC.warn("提示", "奖金发放总额不能为0");
					return;
				}
				final String remark = remarkItem.getValueAsString();
				if (null == remark || remark.length() == 0) {
					SC.warn("提示", "请填写上本次奖金发放的申请缘由");
					return;
				}

				SC.ask("提示", "请确认本次奖金发放申请信息是否正确", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							Map<String, Object> params = new HashMap<>();
							if (null == records.get(length - 1).getAttribute("employeeId")) {
								records.removeAt(length - 1);
							}
							params.put("opt_type", "apply");
							params.put("plateId", plateId);
							params.put("payIntegral", payIntegralItem.getValueAsString());
							params.put("payDate", payDate);
							params.put("applicant", ClientUtil.getUserId());
							params.put("remark", remark);
							params.put("applyTime", payDateItem.getValueAsDate());
							MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params,
									"bonusPaymentDetails");
							DBDataSource.callOperation("EP_BonusPaymentProcessor", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										SC.say("奖金发放申请信息已成功提交，请耐心等候相关人员进行审核");
										// getParentWindow().destroy();
									} else {
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
						}
					}
				});

			}
		});
		IButton cancelButton = new IButton("取消");
		cancelButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (getParentWindow() == null) {
					return;
				}
				getParentWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
			}
		});
		btnLayout.addMember(totalButton);
		btnLayout.addMember(okButton);
		btnLayout.addMember(cancelButton);
		formLayout.addMember(btnLayout);

	}

	/**
	 * 加载页面时加载该方法
	 */
	public void load() {
		grid.setData(new Record[0]);
		if (null == plateId || plateId == 0) {
			return;
		}
		if (null != payDate && null == payDateItem.getValue()) {
			payDateItem.setValue(payDate);
		}
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "prepareApplyInfo");
		params.put("plateId", plateId);
		params.put("payDate", payDate);
		DBDataSource.callOperation("EP_BonusPaymentProcessor", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					int length = records.length;
					if (length == 0) {
						payIntegralItem.setValue(0);
					} else {
						BigDecimal sum = BigDecimal.ZERO;
						BigDecimal sixPercent = BigDecimal.valueOf(0.6);
						for(Record r : records){
							//如果是商业事业部：1万以下的100%，1万（包括1万）以上的60%
							if(plateId == 1){
								//获取价值积分
								BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(r.getAttribute("achieveIntegral"));
								if(achieveIntegral.compareTo(BigDecimal.valueOf(10000)) >= 0 && BaseHelpUtils.getIntValue(r.getAttribute("status")) == ClientStaticUtils.EMPLOYEE_NORMAL){
									BigDecimal payIntegral = BaseHelpUtils.format(achieveIntegral.multiply(sixPercent), 2);
									BigDecimal leftIntegral = achieveIntegral.subtract(payIntegral);
									r.setAttribute("payIntegral", payIntegral);
									r.setAttribute("payPercent", "60");
									r.setAttribute("leftIntegral", leftIntegral);
								}
							}
							sum = sum.add(new BigDecimal(r.getAttribute("payIntegral")));
							r.setAttribute("sendNumber", 1);
							r.setAttribute("firstIntegral", BaseHelpUtils.getBigDecimalValue(r.getAttribute("achieveIntegral")));
						}
						payIntegralItem.setValue(sum);
					}
					grid.setData(records);
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}

	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	private String[] plateIdArray;
	private Integer plateId;
	private Date payDate = new Date();

	public String[] getPlateIdArray() {
		return plateIdArray;
	}

	public void setPlateIdArray(String[] plateIdArray) {
		this.plateIdArray = plateIdArray;
	}

	public Integer getPlateId() {
		return plateId;
	}

	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

}
