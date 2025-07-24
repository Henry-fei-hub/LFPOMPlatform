package com.pomplatform.client.revenue.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.revenue.datasource.DSSaleIntegralRecord;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PlateSaleIntegralPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private TextItem yearItem;
	private TextItem monthItem;
	private DoubleItem saleIntegralItem;
	private TextAreaItem remarkItem;
	private IButton okBtn;
	public static DelicacyListGrid grid;

	public void initComponents(final int year,final int month) {
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
		messageLayout.setHeight("35%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setWidth("95%");
		form.setHeight100();

		yearItem = new TextItem("year", "提取年份");
		yearItem.setWidth("*");
		yearItem.setDefaultValue(year);
		yearItem.setDisabled(true);

		monthItem = new TextItem("month", "提取月份");
		monthItem.setWidth("*");
		monthItem.setDefaultValue(month);
		monthItem.setDisabled(true);
		
		saleIntegralItem = new DoubleItem("saleIntegral", "销售积分");
		saleIntegralItem.setDisabled(true);
		saleIntegralItem.setLength(18);
		saleIntegralItem.setDecimalPad(2);
		saleIntegralItem.setFormat("#,###,###,###,###,##0.00");
		saleIntegralItem.setDefaultValue(0.0);
		saleIntegralItem.setWidth("*");
		
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(6);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");
        form.setItems(yearItem,monthItem,saleIntegralItem,remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		grid.setDataSource(DSSaleIntegralRecord.getInstance());
		grid.setHeight("60%");
		grid.setWidth100();
		grid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record record = grid.getSelectedRecord();
				//获取营收金额
				BigDecimal currentRevenue = BaseHelpUtils.getBigDecimalValue(record.getAttribute("currentRevenue"));
				if(currentRevenue.compareTo(BigDecimal.ZERO) != 0){
					SC.askforValue("提示", "请输入营收提点",new ValueCallback(){
						@Override
						public void execute(String value) {
							if(BaseHelpUtils.isNullOrEmpty(value)){
								return;
							}
							//获取新输入的数据
							BigDecimal percent = BaseHelpUtils.getBigDecimalValue(value);
							if(percent.compareTo(BigDecimal.ONE) > 0){
								SC.say("提示","营收提点不可大于1");
								return;
							}
							if(percent.compareTo(BigDecimal.ZERO) < 0){
								SC.say("提示","营收提点不可小于0");
								return;
							}
							//获取改变前的销售积分
							BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(record.getAttribute("saleIntegral"));
							//计算新的销售积分=输入值*营收金额
							BigDecimal newValue = BaseHelpUtils.format(percent.multiply(currentRevenue),2);
							//设置改变后的最终值
							BigDecimal finalValue = newValue.subtract(oldValue);
							record.setAttribute("percent", percent);
							record.setAttribute("saleIntegral", oldValue.add(finalValue));
							grid.updateData(record);
							BigDecimal saleIntegralTotal = BaseHelpUtils.getBigDecimalValue(saleIntegralItem.getValue());
							saleIntegralItem.setValue(saleIntegralTotal.add(finalValue));
						}
					});
				}
			}
		});

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
				SC.ask("提示", "您确认要提取积分吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							//销售积分
							BigDecimal saleIntegral = BaseHelpUtils.getBigDecimalValue(saleIntegralItem.getValue());
							if(saleIntegral.compareTo(BigDecimal.ZERO) <= 0){
								SC.say("提示", "销售积分不可小于或等于0");
								return;
							}
							okBtn.setDisabled(true);
							//获取备注信息
							final String remark =remarkItem.getValueAsString();
							//获取当前操作人
							int operateEmployeeId = ClientUtil.getEmployeeId();
							Map<Object,Object> params = new HashMap<>();
							params.put("year", year);
							params.put("month", month);
							params.put("saleIntegral", saleIntegral);
							params.put("remark", remark);
							params.put("operateEmployeeId", operateEmployeeId);
							params.put("optType", "onSaveSaleIntegral");
							MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params,"saleIntegralRecords");
							DBDataSource.callOperation("EP_AccountManageProcess",params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										okBtn.setDisabled(true);
										SC.say("提示","操作成功");
										if (getParentWindow() == null) {
											return;
										}
										getParentWindow().destroy();
										DataEditEvent dee = new DataEditEvent();
										fireEvent(dee);
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
			}
		});
		btnLayout.addMember(okBtn);
		btnLayout.addMember(cleanBtn);
		formLayout.addMember(btnLayout);
		load(year, month);
	}
	
	/**
	 * 加载页面时加载该方法
	 * 
	 * @param plateId
	 */
	public void load(int year,int month) {
		Map<String,Object> params = new HashMap<>();
		params.put("year",year);
		params.put("month",month);
		DBDataSource.callOperation("NQ_OnLoadSaleIntegralFromPlate", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					BigDecimal saleIntegralTotal = BigDecimal.ZERO;
					for (Record record : records) {
						//获取销售积分
						BigDecimal saleIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("saleIntegral"));
						saleIntegralTotal = saleIntegralTotal.add(saleIntegral);
					}
					saleIntegralItem.setValue(saleIntegralTotal);
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
