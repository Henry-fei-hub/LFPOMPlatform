package com.pomplatform.client.bonuspayment.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.bonuspayment.datasource.DSBonusPaymentDetailAudit;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class BonusPaymentAuditPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger logger = Logger.getLogger("");
	private TextItem plateIdItem;
	private DateItem payDateItem;
	private DoubleItem payIntegralItem;
	private TextAreaItem remarkItem;
	public static DelicacyListGrid grid;
	private int bonusPaymentRecordId;

	public void initComponents(String plateName) {
		grid = new DelicacyListGrid();
		grid.setCanEdit(true);
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
		messageLayout.setHeight("25%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setPadding(5);
		form.setMargin(5);
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setWidth100();
		form.setHeight100();

		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.setWidth("*");
		plateIdItem.setDisabled(true);

		payDateItem = new DateItem("payDate", "发放年月");
		payDateItem.setWidth("*");
		payDateItem.setShowIcons(false);
		payDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		payDateItem.setDisabled(true);

		payIntegralItem = new DoubleItem("payIntegral", "发放积分");
		payIntegralItem.setLength(12);
		payIntegralItem.setDecimalPad(2);
		payIntegralItem.setFormat("#,###,###,##0.00");
		payIntegralItem.setWidth("*");
		payIntegralItem.setDisabled(true);

		remarkItem = new TextAreaItem("remark", "申请缘由");
		remarkItem.setLength(512);
		remarkItem.setColSpan(6);
		remarkItem.setRowSpan(2);
		remarkItem.setWidth("*");
		remarkItem.setDisabled(true);

		form.setItems(plateIdItem, payDateItem, payIntegralItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		grid.setDataSource(DSBonusPaymentDetailAudit.getInstance());
		grid.setHeight("70%");
		grid.setWidth100();
		grid.setCanEdit(false);

		formLayout.addMember(grid);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("5%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		IButton downloadButton = new IButton("数据导出");
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (null == map || map.isEmpty()) {
					return;
				}
				bonusPaymentRecordId = ClientUtil.checkAndGetIntValue(map.get("bonusPaymentRecordId"));
				if(bonusPaymentRecordId == 0){
					return;
				}
				Map<String, Object> params = new HashMap<>();
				params.put("bonusPaymentRecordId", bonusPaymentRecordId);
				DBDataSource.downloadFile("DW_BonusPaymentDetailDownload", params);
			}
		});
		
		IButton okButton = new IButton("通过申请");
		okButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				if(bonusPaymentRecordId != 0){
					SC.ask("提示", "确定同意本次奖金发放申请吗？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								Map<String, Object> params = new HashMap<>();
								params.put("opt_type", "agreeApply");
								params.put("bonusPaymentRecordId", bonusPaymentRecordId);
								params.put("auditor", ClientUtil.getEmployeeId());
								DBDataSource.callOperation("EP_BonusPaymentProcessor", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() >= 0) {
											SC.say("审核成功");
	//										getParentWindow().destroy();
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
									}
								});
							}
						}
					});
				}else{
					SC.warn("提示","没有数据可供审核");
				}
			}
		});
		IButton cancelButton = new IButton("驳回申请");
		cancelButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SC.askforValue("驳回申请", "请输入驳回申请的原因", new ValueCallback() {
					
					@Override
					public void execute(String value) {
						if(null!=value&&value.length()>0){
							Map<String, Object> params = new HashMap<>();
							params.put("opt_type", "disagreeApply");
							params.put("bonusPaymentRecordId", bonusPaymentRecordId);
							params.put("opinion", value);
							params.put("auditor", ClientUtil.getEmployeeId());
							DBDataSource.callOperation("EP_BonusPaymentProcessor", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										SC.say("该奖金发放申请已成功驳回");
//										getParentWindow().destroy();
									}else{
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
						}else{
							SC.warn("提示", "请填写驳回申请的原因");
						}
					}
				});
			}
		});
		btnLayout.addMember(downloadButton);
		btnLayout.addMember(okButton);
		btnLayout.addMember(cancelButton);
		formLayout.addMember(btnLayout);

	}

	/**
	 * 加载页面时加载该方法
	 */
	public void load() {
		if (null == map || map.isEmpty()) {
			return;
		}
		bonusPaymentRecordId = ClientUtil.checkAndGetIntValue(map.get("bonusPaymentRecordId"));
		if(bonusPaymentRecordId == 0){
			return;
		}
		if(null == plateIdItem.getValue()){
			plateIdItem.setValue(map.get("plateId"));
			payDateItem.setValue(map.get("payDate"));
			payIntegralItem.setValue(map.get("payIntegral"));
			remarkItem.setValue(map.get("remark"));
		}
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "prepareAuditInfo");
		params.put("bonusPaymentRecordId", bonusPaymentRecordId);
		DBDataSource.callOperation("EP_BonusPaymentProcessor", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					int len = records.length;
					Record[] newRecords = new Record[len + 1];
					if (len > 0) {
						double payIntegral = 0;
						double firstIntegral = 0;
						double secondIntegral = 0;
						double thirdIntegral = 0;
						for (int i = 0; i < len; i++) {
							if ("汇总".equals(records[i].getAttribute("employeeNo"))) {// 如果已经存在汇总，则不可再进行汇总
								return;
							}
							payIntegral += ClientUtil.checkAndGetDoubleValue(records[i].getAttribute("payIntegral"));
							firstIntegral += ClientUtil.checkAndGetDoubleValue(records[i].getAttribute("firstIntegral"));
							secondIntegral += ClientUtil.checkAndGetDoubleValue(records[i].getAttribute("secondIntegral"));
							thirdIntegral += ClientUtil.checkAndGetDoubleValue(records[i].getAttribute("thirdIntegral"));
							newRecords[i] = records[i];
						}
						Record record = new Record();
						record.setAttribute("employeeNo", "汇总");
						record.setAttribute("payIntegral", payIntegral);
						record.setAttribute("firstIntegral", firstIntegral);
						record.setAttribute("secondIntegral", secondIntegral);
						record.setAttribute("thirdIntegral", thirdIntegral);
						newRecords[len] = record;
						grid.setData(newRecords);
						grid.redraw();
					}
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

	private Map map;
	
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

}
