package com.pomplatform.client.projectreportrecorddetail.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ChangeBuyIntegralPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private TextItem contractCodeItem;
	private TextItem projectNameItem;
	private TextItem leftIntegralItem;
	private TextItem fromProjectIdItem;
	public static DelicacyListGrid grid;
	public void initComponents(Map<String,Object> map) {
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
		messageLayout.setHeight("15%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setWidth("95%");
		form.setHeight100();

		fromProjectIdItem = new TextItem("fromProjectId", "项目编号");
		fromProjectIdItem.setWidth("*");
		fromProjectIdItem.setCanEdit(false);
		fromProjectIdItem.hide();
		
		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setCanEdit(false);

		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setCanEdit(false);
		projectNameItem.setWidth("*");

		leftIntegralItem = new TextItem("leftIntegral", "订单剩余额度");
		leftIntegralItem.setWidth("*");
		leftIntegralItem.setCanEdit(false);
		
		form.setItems(fromProjectIdItem,contractCodeItem, projectNameItem, leftIntegralItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		form.setValues(map);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		int idx = 0;
		ListGridField[] fields = new ListGridField[5];
		fields[idx] = new ListGridField("contractCode","订单编号");
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth("20%");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("projectName","订单名称");
		fields[idx].setWidth("40%");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("totalIntegral","订单额度");
		fields[idx].setShowGridSummary(false);
		fields[idx].setWidth("20%");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("changeIntegral","调整额度");
		fields[idx].setShowGridSummary(false);
		fields[idx].setDecimalPad(2);
		fields[idx].setFormat("##,###,##0.00");
		fields[idx].setValidators(ValidateUtils.isFloatValidator());
		fields[idx].setWidth("20%");
		
		grid.setCanEdit(true);
		grid.setFields(fields);
		grid.setHeight("85%");
		grid.setWidth100();
		grid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				BigDecimal leftIntegral = BaseHelpUtils.isNullOrEmpty(map.get("leftIntegral")) ? BigDecimal.ZERO : BaseHelpUtils.getBigDecimalValue(map.get("leftIntegral"));
				Record[] record = grid.getRecords();
				BigDecimal changeIntegralTotal = BigDecimal.ZERO;
				for(Record e : record){
					if(!BaseHelpUtils.isNullOrEmpty(e.getAttribute("changeIntegral"))){
						changeIntegralTotal = changeIntegralTotal.add(BaseHelpUtils.getBigDecimalValue(e.getAttribute("changeIntegral")));
					}
				}
				leftIntegralItem.setValue(leftIntegral.subtract(changeIntegralTotal));
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
				BigDecimal leftIntegral = BaseHelpUtils.isNullOrEmpty(leftIntegralItem.getValue()) ? BigDecimal.ZERO : BaseHelpUtils.getBigDecimalValue(leftIntegralItem.getValue());
				if(leftIntegral.compareTo(new BigDecimal(0)) < 0){
					SC.say("订单剩余额度不能为负");
					return;
				}
				SC.ask("提示", "您确认要进行额度调整吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value){
							Record[] records = grid.getRecords();
							List<Map<String,Object>> list = new ArrayList<>();
							for(Record e : records){
								if(!BaseHelpUtils.isNullOrEmpty(e.getAttribute("changeIntegral"))){
									list.add(e.toMap());
								}
							}
//							MapUtils.convertRecordToMap(grid, grid.getRecords(), map, "list");
							map.put("optType", "saveChangeIntegralProject");
							map.put("list", list);
							map.put("fromProjectId", fromProjectIdItem.getValue());
							DBDataSource.callOperation("EP_ProjectOfChangeBuyIntegral", map, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										SC.say("提示","操作成功");
										getParentWindow().destroy();
										DataEditEvent dee = new DataEditEvent();
										fireEvent(dee);
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
	 * 加载未结束、可能需要调整额度的采买成本订单
	 * @param 
	 */
	public void load() {
		Map<String,Object> params = new HashMap<>();
		params.put("optType", "changeIntegralProject");
		DBDataSource.callOperation("EP_ProjectOfChangeBuyIntegral", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] record = dsResponse.getData(); 
					grid.setData(record);
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
