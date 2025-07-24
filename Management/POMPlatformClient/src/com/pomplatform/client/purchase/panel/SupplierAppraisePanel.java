package com.pomplatform.client.purchase.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.purchase.datasource.DSOnSupplierAppraiseSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SupplierAppraisePanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private TextItem supplierNameItem;
	private DoubleItem scoreItem;
	private TextItem titleItem;
	private TextItem provideProductItem;
	private TextAreaItem reasonItem;
	public static DelicacyListGrid grid;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	//积分高管角色ID
	public static final int ROLE_INTEGRAL_EXECUTIVE = 42;
	public void initComponents(final int supplierId, String supplierName) {
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
		messageLayout.setHeight("40%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setNumCols(4);
		form.setAlign(Alignment.CENTER);
		form.setWidth("95%");
		form.setHeight100();

		supplierNameItem = new TextItem("supplierName", "供应商名称");
		supplierNameItem.setWidth("*");
		supplierNameItem.setDefaultValue(supplierName);
		supplierNameItem.setDisabled(true);
		
		scoreItem = new DoubleItem("score", "评价累计得分");
		scoreItem.setDisabled(true);
		scoreItem.setLength(6);
		scoreItem.setDecimalPad(2);
		scoreItem.setFormat("#,###,###,###,###,##0.00");
		scoreItem.setDefaultValue(0);
		scoreItem.setWidth("*");
		
		titleItem = new TextItem("title", shouldNotBeNull+"主题");
		titleItem.setWidth("*");
		
		provideProductItem = new TextItem("provideProduct","提供产品");
		provideProductItem.setWidth("*");

		reasonItem = new TextAreaItem("reason",shouldNotBeNull+"事由");
		reasonItem.setWidth("*");
		reasonItem.setColSpan(4);

		form.setItems(supplierNameItem,scoreItem,titleItem,provideProductItem, reasonItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		grid.setDataSource(DSOnSupplierAppraiseSource.getInstance());
		grid.setHeight("75%");
		grid.setWidth100();
		grid.setCanEdit(true);
		grid.addEditCompleteHandler(new EditCompleteHandler() {
			@SuppressWarnings("rawtypes")
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				int colNum = event.getColNum();
				//获取列名
				String colName = BaseHelpUtils.getString(grid.getFieldName(colNum));
				if(colName.equals("scoreType")) {
					Map newValues = event.getNewValues();
					//获取值
					int scordId = BaseHelpUtils.getIntValue(newValues, "scoreType");
					if(scordId > 0) {
						Map<String,Object> params = new HashMap<>();
						params.put("scordId", scordId);
						DBDataSource.callOperation("ST_SupplierScoreRecord","find",params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() >= 0) {
									//获取数据集
									Record[] records = dsResponse.getData();
									if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
										Record record = records[0];
										//获取分数
										BigDecimal score = BaseHelpUtils.getBigDecimalValue(record.getAttribute("scord"));
										Record newRecord = grid.getRecord(event.getRowNum());
										newRecord.setAttribute("score",score);
										grid.updateData(newRecord);
										grid.redraw();
										//获取累计得分
										BigDecimal scoreTotal = BaseHelpUtils.getBigDecimalValue(scoreItem.getValue());
										scoreTotal = scoreTotal.add(score);
										scoreItem.setValue(scoreTotal);
									}
								} else {
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
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
				ListGridRecord[] records = grid.getRecords();
				if (records.length == 0) {
					SC.say("提示", "没有评分类型值");
					return;
				}
				//获取主题
				String title = BaseHelpUtils.getString(titleItem.getValue());
				if(BaseHelpUtils.isNullOrEmpty(title)) {
					SC.say("提示","主题不可为空");
					return;
				}
				//获取累计得分
				BigDecimal score = BaseHelpUtils.getBigDecimalValue(scoreItem.getValue());
				if(score.compareTo(BigDecimal.ZERO) <= 0) {
					SC.say("提示","获取累计得分异常");
					return;
				}
				//获取提供产品
				String provideProduct = BaseHelpUtils.getString(provideProductItem.getValue());
				//获取事由
				String reason = BaseHelpUtils.getString(reasonItem.getValue());
				if(BaseHelpUtils.isNullOrEmpty(reason)) {
					SC.say("提示","事由不可为空");
					return;
				}
				//获取创建人
				int createEmployeeId = ClientUtil.getEmployeeId();
				// 获取补贴年月份
				okBtn.setDisabled(true);
				LinkedHashMap<String,Object> params = new LinkedHashMap<>();
				params.put("supplierId", supplierId);
				params.put("title", title);
				params.put("score", score);
				params.put("provideProduct", provideProduct);
				params.put("reason", reason);
				params.put("createEmployeeId", createEmployeeId);
				params.put("optType", "onSaveSupplierAppraise");
				MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params,"appraiseScore");
				final LoadingWindow loading = new LoadingWindow();
				DBDataSource.callOperation("EP_OnPurchaseProcess", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						okBtn.setDisabled(false);
						loading.destroy();
						if (dsResponse.getStatus() >= 0) {
							if (getParentWindow() == null) {
								return;
							}
							getParentWindow().destroy();
							DataEditEvent dee = new DataEditEvent();
							fireEvent(dee);
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
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
	 */
	public void load() {
		Map<String, String> params = KeyValueManager.getValueMap("system_dictionary_190");
		if(!BaseHelpUtils.isNullOrEmpty(params)) {
			RecordList data = new RecordList();
			for(String key : params.keySet()) {
				Record re = new Record();
				re.setAttribute("appraiseType",key);
				re.setAttribute("scoreType","");
				re.setAttribute("score","");
				data.add(re);
			}
			grid.setData(data);
		}
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
