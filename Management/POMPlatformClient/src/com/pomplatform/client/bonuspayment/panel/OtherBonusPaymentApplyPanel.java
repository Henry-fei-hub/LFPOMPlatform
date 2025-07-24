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
import com.smartgwt.client.types.RowSpanEditMode;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.DateUtil;
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
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class OtherBonusPaymentApplyPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger logger = Logger.getLogger("");
	private SelectItem plateIdItem;
	private DateItem payDateItem;
	private DoubleItem payIntegralItem;
	private TextAreaItem remarkItem;
	private IntegerItem integralPlateIdItem;
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
							integralPlateIdItem.setValue(plateId);
							break;
						}
					}
					if (!hasChanged) {
						plateIdItem.setValue(event.getOldValue());
						SC.warn("提示", "您没有该部门的奖金发放申请权限");
					}else{
						startEdit();
						grid.setData(new RecordList());
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

		payIntegralItem = new DoubleItem("payIntegral", "部门积分");
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
		
		integralPlateIdItem = new IntegerItem("integralPlateId");
		integralPlateIdItem.hide();
		integralPlateIdItem.setValue(plateId);

		form.setItems(plateIdItem, payDateItem, payIntegralItem, remarkItem,integralPlateIdItem);
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
				//如果当前月份为1月份或2月份，那么该第四季度是上一年的，年份改为上一年的年份
				if(date.getMonth() == 0 || date.getMonth() == 1){
					int currentYear = date.getYear();
					date.setYear(currentYear-1);
				}
				date.setMonth(11);
				setPayDate(date);
				load();
			}
		});
		
		grid.setDataSource(DSBonusPaymentDetail.getInstance());
		int index = 0;
		ListGridField[] fields = new ListGridField[11];
		fields[index] = new ListGridField("bonusPaymentRecordId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("employeeNo");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("employeeName");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("payIntegral");
		fields[index].setCanEdit(true);
		fields[index].setEmptyCellValue("0");
		index++;
		fields[index] = new ListGridField("plateId");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("status");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("isLevelTwo");
		index++;
		fields[index] = new ListGridField("sendNumber");
		index++;
		fields[index] = new ListGridField("firstIntegral");
		fields[index].setCanEdit(true);
		index++;
		fields[index] = new ListGridField("secondIntegral");
		fields[index].setCanEdit(true);
		index++;
		fields[index] = new ListGridField("thirdIntegral");
		fields[index].setCanEdit(true);
		grid.setFields(fields);
		grid.setHeight("65%");
		grid.setWidth100();
		formLayout.addMember(grid);

		grid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				BigDecimal totalIntegral = staticIntegral;
				BigDecimal sendIntegral = BigDecimal.ZERO;
				boolean is = true;
				Record oldValues = event.getOldValues();
				BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(oldValues.getAttribute("payIntegral"));
				Record[] editRecords = grid.getRecords();
				for(Record e : editRecords){
					sendIntegral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("payIntegral"));
					if(sendIntegral.compareTo(BigDecimal.ZERO) < 0){
						SC.say("发放积分不能小于0");
						e.setAttribute("payIntegral", 0);
						grid.updateData(e);
						is = false;
						break;
					}
					int nowPlateId = BaseHelpUtils.getIntValue(integralPlateIdItem.getValue());
					int ePlateId = BaseHelpUtils.getIntValue(e.getAttribute("plateId"));
					if(nowPlateId == ePlateId && ePlateId > 0 && nowPlateId > 0){
						totalIntegral = totalIntegral.subtract(sendIntegral);
					}
					if(totalIntegral.compareTo(BigDecimal.ZERO) < 0){
						SC.say("部门积分不足");
						e.setAttribute("payIntegral", oldValue);
						grid.updateData(e);
						payIntegralItem.setValue(totalIntegral.add(sendIntegral));
						is = false;
						break;
					}
				}
				if(is){
					payIntegralItem.setValue(totalIntegral);
				}
			}
		});
		
		grid.addCellClickHandler(new CellClickHandler() {
			
			@Override
			public void onCellClick(CellClickEvent event) {
				Record selected = grid.getSelectedRecord();
				int fieldPlateId = BaseHelpUtils.getIntValue(selected.getAttribute("plateId"));
				int thePlateId = BaseHelpUtils.getIntValue(plateIdItem.getValue());
				if(fieldPlateId != thePlateId){
					Map<String, Object> params = new HashMap<>();
					params.put("optType", "onLoadLeftIntegralOFPlateByTime");
					params.put("plateId", fieldPlateId);
					params.put("payDate", payDate);
					DBDataSource.callOperation("EP_AccountManageProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								String palteName = KeyValueManager.getValue("system_dictionary_1", fieldPlateId + "");
								payIntegralItem.setTitle("("+palteName+") 剩余积分");
								payIntegralItem.redraw();
								Record record = dsResponse.getData()[0];
								BigDecimal integral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("integral"));
								setStaticIntegral(integral);
								BigDecimal sendIntegral = BigDecimal.ZERO;
								Record[] records = grid.getRecords(); 
								for(Record rObj : records){
									int ePlateId = BaseHelpUtils.getIntValue(rObj.getAttribute("plateId"));
									if(fieldPlateId == ePlateId && ePlateId > 0 && fieldPlateId > 0){
										sendIntegral = BaseHelpUtils.getBigDecimalValue(rObj.getAttribute("payIntegral"));
										integral = integral.subtract(sendIntegral);
									}
								}
								payIntegralItem.setValue(integral);
								integralPlateIdItem.setValue(fieldPlateId);
							}
						}
					});
				}
			}
		});
		
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
					BigDecimal payIntegral = BigDecimal.ZERO;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("employeeNo"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						payIntegral = payIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("payIntegral")));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("employeeNo", "汇总");
					record.setAttribute("payIntegral", payIntegral);
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
				final int length = records.getLength();
				if (length == 0) {
					SC.warn("提示", "没有人员可以申请奖金发放");
					return;
				}
				applyIntegral = BigDecimal.ZERO;
				for(int i = 0;i < records.getLength();i++){
					if(!BaseHelpUtils.getString(records.get(i).getAttribute("employeeNo")).equals("汇总")){
						applyIntegral = applyIntegral.add(BaseHelpUtils.getBigDecimalValue(records.get(i).getAttribute("payIntegral")));
					}
				}
				if (applyIntegral.compareTo(BigDecimal.ZERO) == 0) {
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
							//去掉汇总
							if (null == records.get(length - 1).getAttribute("employeeId")) {
								records.removeAt(length - 1);
							}
							params.put("opt_type", "applyEmployeeData");
							params.put("plateId", plateId);
							params.put("payIntegral", applyIntegral);
							params.put("payDate", payDate);
							params.put("applicant", ClientUtil.getUserId());
							params.put("remark", remark);
							params.put("applyTime", payDateItem.getValueAsDate());
							Record[] applyRecords = grid.getRecords();
							if(!BaseHelpUtils.isNullOrEmpty(integralMap) && integralMap.size() > 0){
								params.put("isLevelTwo", Boolean.FALSE);
							}else{
								params.put("isLevelTwo", Boolean.TRUE);
								for(Record aa : applyRecords){
									aa.setAttribute("isLevelTwo", Boolean.TRUE);
									if(BaseHelpUtils.getString(aa.getAttribute("employeeNo")).equals("汇总")){
										aa = null;
									}
								}
							}
							MapUtils.convertRecordToMap(grid.getDataSource(), applyRecords, params,
									"bonusPaymentDetails");
							DBDataSource.callOperation("EP_BonusPaymentProcessor", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										SC.say("奖金发放申请信息已成功提交，请耐心等候相关人员进行审核");
										// getParentWindow().destroy();
									} else {
										SC.say(""+dsResponse.getErrors().get("errorMsg"));
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


	//加载部门实时余额
	public void startEdit(){
		Map<String, Object> params = new HashMap<>();
		//加载部门实时余额积分
		params.put("optType", "onLoadLeftIntegralOFPlate");
		params.put("plateId", plateId);
		DBDataSource.callOperation("EP_AccountManageProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record record = dsResponse.getData()[0];
					BigDecimal integral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("integral"));
					payIntegralItem.setValue(integral);
					setStaticIntegral(integral);
				}
			}
		});
	}
	
	/**
	 * 加载该季度可发放奖金的人员
	 */
	public void load() {
		grid.setData(new Record[0]);
		BigDecimal totalIntegral = BaseHelpUtils.getBigDecimalValue(payIntegralItem.getValue());
		if (null == plateId || plateId == 0) {
			return;
		}
		//如果部门积分为0或者负数，则不加载人员
		if(totalIntegral.compareTo(BigDecimal.ZERO) <= 0){
			SC.say("部门积分不足，无法发放奖金");
			return;
		}
		if (null != payDate && null == payDateItem.getValue()) {
			payDateItem.setValue(payDate);
		}
		Map<String,Object> map = new HashMap<>();
		map.put("plateId", plateId);
		map.put("payDate", payDate);
		map.put("opt_type", "applyEmployees");
		DBDataSource.callOperation("EP_BonusPaymentProcessor", map, new DSCallback() {
			@SuppressWarnings("unchecked")
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					//加载二级部门余额
					if(!BaseHelpUtils.isNullOrEmpty(dsResponse.getAttribute("userData")) && dsResponse.getAttribute("userData").length() > 0){
						setIntegralMap(dsResponse.getAttributeAsMap("userData"));
					}
					Record[]  records=dsResponse.getData();
					for (Record record : records) {
						record.setAttribute("sendNumber", 1);
					}
					grid.setData(records);
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
		loadChoosePlateIntegral();
	}
	
	//加载部门实时余额积分（带时间维度）
	public void loadChoosePlateIntegral(){
		//加载部门实时余额积分
		Map<String, Object> params = new HashMap<>();
		params.put("optType", "onLoadLeftIntegralOFPlateByTime");
		params.put("plateId", plateId);
		params.put("payDate", payDate);
		DBDataSource.callOperation("EP_AccountManageProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record record = dsResponse.getData()[0];
					BigDecimal integral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("integral"));
					payIntegralItem.setValue(integral);
					setStaticIntegral(integral);
				}
			}
		});
	};

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
	private BigDecimal staticIntegral;
	private BigDecimal applyIntegral = BigDecimal.ZERO;
	private Map<Integer,BigDecimal> integralMap = new HashMap<>();

	public Map<Integer, BigDecimal> getIntegralMap() {
		return integralMap;
	}

	public void setIntegralMap(Map<Integer, BigDecimal> integralMap) {
		this.integralMap = integralMap;
	}

	public BigDecimal getStaticIntegral() {
		return staticIntegral;
	}

	public void setStaticIntegral(BigDecimal staticIntegral) {
		this.staticIntegral = staticIntegral;
	}

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
