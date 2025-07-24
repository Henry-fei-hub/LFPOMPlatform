package com.pomplatform.client.platereportrecorddetail.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.platereportrecorddetail.datasource.DSIntegralReturnOfPlate;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class IntegralReturnOfPlateAccountPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private TextItem plateNameItem;
	private DoubleItem achieveIntegralItem;
	private DateItem recordDateItem;
	private DoubleItem integralreturnofplateItem;
	public static DelicacyListGrid grid;

	public void initComponents(final int plateId, String plateName, final BigDecimal achieveIntegral) {
		grid = new DelicacyListGrid();
		grid.setAutoFitFieldWidths(false);
		grid.setShowRowNumbers(true);
		setWidth("98%");
		setHeight100();
		setPadding(10);
		setMembersMargin(5);

		VLayout formLayout = new VLayout();
		formLayout.setHeight100();
		formLayout.setMembersMargin(5);
		formLayout.setWidth("98%");
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);

		HLayout messageLayout = new HLayout();
		messageLayout.setWidth100();
		messageLayout.setHeight("20%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setNumCols(4);
		form.setAlign(Alignment.CENTER);
		form.setWidth("95%");
		form.setHeight100();

		plateNameItem = new TextItem("plateName", "业务部门");
		plateNameItem.setWidth("*");
		plateNameItem.setDefaultValue(plateName);
		plateNameItem.setCanEdit(false);

		achieveIntegralItem = new DoubleItem("achieveIntegral", "部门价值积分");
		achieveIntegralItem.setCanEdit(false);
		achieveIntegralItem.setLength(18);
		achieveIntegralItem.setDecimalPad(2);
		achieveIntegralItem.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralItem.setDefaultValue(achieveIntegral);
		achieveIntegralItem.setWidth("*");

		recordDateItem = new DateItem("recordDate", "收款日期");
		recordDateItem.setWidth("*");
		recordDateItem.setDefaultValue(new Date());
		recordDateItem.setUseTextField(true);
		recordDateItem.setDisabled(true);
		recordDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

		integralreturnofplateItem = new DoubleItem("integralreturnofplate", "可收款积分");
		integralreturnofplateItem.setCanEdit(false);
		integralreturnofplateItem.setLength(18);
		integralreturnofplateItem.setDecimalPad(2);
		integralreturnofplateItem.setFormat("#,###,###,###,###,##0.00");
		integralreturnofplateItem.setDefaultValue(0);
		integralreturnofplateItem.setWidth("*");

		form.setItems(plateNameItem, achieveIntegralItem, recordDateItem, integralreturnofplateItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		grid.setDataSource(DSIntegralReturnOfPlate.getInstance());
		grid.setHeight("75%");
		grid.setWidth100();
		grid.setSelectionAppearance(SelectionAppearance.CHECKBOX);

		formLayout.addMember(grid);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("5%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		IButton okBtn = new IButton("确认");
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) { 
				ListGridRecord[] records = grid.getRecords();
				if (records.length == 0) {
					SC.say("提示", "没有可收款的人员");
					return;
				}

				// 获取需要收款的总积分
				final BigDecimal integralreturnofplate = BaseHelpUtils.getBigDecimalValue(integralreturnofplateItem.getValue());

				if (integralreturnofplate.compareTo(BigDecimal.ZERO) <= 0) {
					SC.say("提示", "没有可收款的积分");
					return;
				}

				SC.ask("提示", "您确认要对当前人员进行收款吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							// 获取补贴年月份
							okBtn.setDisabled(true);
							final Date recordDate = recordDateItem.getValueAsDate();
							LinkedHashMap<String,Object> params = new LinkedHashMap<>();
							params.put("plateId", plateId);
							params.put("recordDate", recordDate);
							params.put("integralreturnofplate", integralreturnofplate);
							params.put("operator", ClientUtil.getUserId());
							MapUtils.convertRecordToMap(grid.getDataSource(), grid.getSelectedRecords(), params,"integralReturnOfPlate");
							final LoadingWindow loading = new LoadingWindow();
							DBDataSource.callOperation("EP_OnIntegralReturnOfPlate", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									okBtn.setDisabled(false);
									loading.destroy();
									if (dsResponse.getStatus() >= 0) {
										load(plateId);
									} else {
										SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
									}
								}
							});
						}
					}
				});

			}
		});
		IButton cleanBtn = new IButton("关闭");
		cleanBtn.addClickHandler(new ClickHandler() {

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
		btnLayout.addMember(okBtn);
		btnLayout.addMember(cleanBtn);
		formLayout.addMember(btnLayout);
		
	}

	/**
	 * 加载页面时加载该方法
	 * 
	 * @param plateId
	 */
	public void load(int plateId) {
		if (plateId == 0) {
			return;
		}
		Map<String,Object> params = new HashMap<>();
		params.put("plateId", plateId);
		params.put("optType", "onPlateAccountIntegralReturnEmpData");
		DBDataSource.callOperation("EP_AccountManageProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					BigDecimal integralreturnofplate = BigDecimal.ZERO;
					for (Record record : records) {
						//获取欠款积分
						BigDecimal integral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("integralreturnofplate"));
						//获取价值积分
						BigDecimal achieveintegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("achieveintegral"));
						//只回收价值积分大于0的积分，且当价值积分小于欠款积分时，只回收价值积分的积分
						if(achieveintegral.compareTo(BigDecimal.ZERO) > 0){
							if(achieveintegral.compareTo(integral) <= 0){
								integralreturnofplate = integralreturnofplate.add(achieveintegral);
							}else{
								integralreturnofplate = integralreturnofplate.add(integral);
							}
						}
					}
					integralreturnofplateItem.setValue(integralreturnofplate);
					grid.setData(records);
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

}
