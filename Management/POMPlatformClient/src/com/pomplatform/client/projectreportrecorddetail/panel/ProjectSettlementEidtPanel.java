package com.pomplatform.client.projectreportrecorddetail.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.employeedetail.panel.ProjectCostDetailPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectSettlementEidtPanel extends VLayout implements HasHandlers {

	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private Window parentWindow;
	private DynamicForm form;
	private DelicacyListGrid  setGrid;
	private DelicacyListGrid  setDetailGrid;
	private DelicacyListGrid  plateAcountGrid;
	private DelicacyListGrid  projectCostGrid;
	private DelicacyListGrid  projectAttamgrid;
	private Record record;
	private VLayout mianLayout;
	private HLayout topLayout;
	private VLayout topRightLayout;
	private HLayout middleLayout;
	private HLayout bottomLayout;
	private ComboBoxItem projectIdItem;
	private TextItem contractCodeItem;
	private DoubleItem projectIntegralItem;
	private HLayout  butLayout;
	private IButton delBut;
	private IButton editBut;
	private IButton resetBut;


	public void initComponents() {
		mianLayout=new VLayout();
		mianLayout.setWidth100();
		mianLayout.setHeight100();
		addMember(mianLayout);


		topLayout=new HLayout(10);
		topLayout.setWidth("95%");
		topLayout.setHeight("10%");
		mianLayout.addMember(topLayout);

		topRightLayout=new VLayout();
		topRightLayout.setHeight("100%");
		topRightLayout.setWidth("5%");
		topRightLayout.setMembersMargin(10);
		topLayout.addMember(topRightLayout);


		butLayout=new HLayout();
		butLayout.setMembersMargin(10);
		butLayout.setWidth100();
		butLayout.setHeight("5%");
		mianLayout.addMember(butLayout);


		middleLayout=new HLayout(10);
		middleLayout.setWidth100();
		middleLayout.setMargin(10);
		middleLayout.setHeight("45%");
		mianLayout.addMember(middleLayout);

		bottomLayout=new HLayout(10);
		bottomLayout.setWidth100();
		bottomLayout.setHeight("45%");
		mianLayout.addMember(bottomLayout);



		projectIdItem=new ComboBoxItem("projectId","订单名称");
		projectIdItem.setWidth("*");
		projectIdItem.setChangeOnKeypress(false);
		projectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		getProjectInfo();
		projectIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int projectId=BaseHelpUtils.getIntValue(event.getValue());
				Map<String,Object> map=new HashMap<>();
				map.put("projectId", projectId);
				Record record=SyncDataUtil.getValueByTableName("ST_Project", "find", map);
				BigDecimal projectIntegral=BaseHelpUtils.getBigDecimalValue(record.getAttribute("projectIntegral"));
				String contractCode=BaseHelpUtils.getString(record.getAttribute("contractCode"));
				projectIntegralItem.setValue(projectIntegral);
				contractCodeItem.setValue(contractCode);
				lodaData(projectId);
			}
		});


		contractCodeItem=new TextItem("contractCode","订单编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setCanEdit(false);


		projectIntegralItem=new DoubleItem("projectIntegral","订单积分");
		projectIntegralItem.setFormat("##,###,###,###,##0.00");
		projectIntegralItem.setWidth("*");
		projectIntegralItem.setCanEdit(false);

		form=new DynamicForm();
		form.setWidth100();
		form.setNumCols(6);
		form.setHeight("5%");
		form.setItems(projectIdItem,contractCodeItem,projectIntegralItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		topRightLayout.addMember(form);


		editBut=new IButton("修改结算时间");
		butLayout.addMember(editBut);
		editBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!setGrid.anySelected()) {
					SC.say("请选择一条项目结算表数据");
					return;
				}
				final PopupWindow popupWindow = new PopupWindow("修改结算日期");
				popupWindow.setWidth("30%");
				popupWindow.setHeight("30%");
				SettlementEidtDatePanel buttonPanel = new SettlementEidtDatePanel();
				Record record=setGrid.getSelectedRecord();
				buttonPanel.setRecord(record);
				buttonPanel.initComponents();
				popupWindow.addItem(buttonPanel);
				buttonPanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						int projectId=BaseHelpUtils.getIntValue(event.getData().getAttribute("projectId"));
						lodaData(projectId);
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				buttonPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();



			}
		});

		delBut=new IButton("删除结算记录");
		delBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!setGrid.anySelected()) {
					SC.say("请选择一条项目结算表数据");
					return;
				}
				Record record=setGrid.getSelectedRecord();
				Date settlementDate=record.getAttributeAsDate("settlementDate");
				int projectId=BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
				int settlementId=BaseHelpUtils.getIntValue(record.getAttribute("settlementId"));
				if(projectId<=0) {
					SC.say("错误，项目ID获取值小于等于0");
					return;
				}
				if(settlementId<=0) {
					SC.say("错误，结算主编ID获取值小于等于0");
					return;
				}
				SC.ask("你确定删除此条订单在["+DateUtil.format(settlementDate)+"]"+"的所有结算记录吗？（谨慎操作）",new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value) {
							Map<String,Object> params = new HashMap<>();
							params.put("projectId",projectId);
							params.put("settlementId",settlementId);
							params.put("optType", "delSetData");
							DBDataSource.callOperation("EP_AboutProjectStageAudit",params, new DSCallback(){
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0) {
										SC.say("删除成功");
										int projectId=BaseHelpUtils.getIntValue(projectIdItem.getValue());
										lodaData(projectId);
									}else {
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
						}
					}
				} );


			}
		});
		butLayout.addMember(delBut);
		
		
		resetBut=new IButton("刷新订单");
		resetBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int projectId=BaseHelpUtils.getIntValue(projectIdItem.getValue());
				lodaData(projectId);
			}
		});
		butLayout.addMember(resetBut);



		LinkedHashMap<Object, Object> linkmap=new LinkedHashMap<>();
		linkmap.put(1, "待确认");
		linkmap.put(2, "已确认");
		linkmap.put(3, "已驳回");


		setGrid=new DelicacyListGrid();
		setGrid.setWidth("46%");
		int a = 0;
		ListGridField[] aFields = new ListGridField[9];
		aFields[a] = new ListGridField("settlementId","结算主键");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("projectId","项目id");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("projectAmount","项目积分");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		aFields[a].setWidth("25%");
		a++;
		aFields[a] = new ListGridField("totalCost","分摊成本");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		aFields[a].setWidth("25%");
		a++;
		aFields[a] = new ListGridField("totalAmount","确认积分");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		aFields[a].setWidth("25%");
		a++;
		aFields[a] = new ListGridField("stageId","阶段");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		aFields[a].setWidth("25%");
		KeyValueManager.loadValueMap("system_dictionary_7", aFields[a]);
		a++;
		aFields[a] = new ListGridField("settlementStatus","结算状态");
		aFields[a].setCanEdit(false);
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setValueMap(linkmap);
		a++;
		aFields[a] = new ListGridField("employeeId","操作人");
		aFields[a].setCanEdit(false);
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.CENTER);
		KeyValueManager.loadValueMap("employees", aFields[a]);
		a++;
		aFields[a] = new ListGridField("settlementDate","结算日期");
		aFields[a].setCanEdit(false);
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.CENTER);
		DateTimeItem  dateItems=new DateTimeItem();
		dateItems.setUseTextField(true);
		aFields[a].setEditorProperties(dateItems);
		a++;
		aFields[a] = new ListGridField("remark","备注");
		aFields[a].setCanEdit(false);
		aFields[a].setWidth("30%");
		aFields[a].setAlign(Alignment.CENTER);
		KeyValueManager.loadValueMap("employees", aFields[a]);
		setGrid.setFields(aFields);
		setGrid.setAutoFitFieldWidths(false);
		setGrid.setCanRemoveRecords(false);
		setGrid.setCanDragSelectText(true);
		setGrid.setShowGridSummary(true);
		setGrid.setHeaderHeight(60);
		setGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"项目结算表", new String[] {"settlementId","projectId","projectAmount","totalCost","totalAmount","stageId","settlementStatus","employeeId","settlementDate","remark"}));
		setGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record record=setGrid.getSelectedRecord();
				int projectId=BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
				int settlementId=BaseHelpUtils.getIntValue(record.getAttribute("settlementId"));
				Map<String,Object> params = new HashMap<>();
				params.put("projectId",projectId);
				params.put("settlementId",settlementId);
				DBDataSource.callOperation("ST_ProjectSettlementDetail", "find", params, new DSCallback(){
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							setDetailGrid.setData(dsResponse.getData());
						}
					}
				});
				
				DBDataSource.callOperation("ST_PlateProjectAccountRecord", "find", params, new DSCallback(){
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							plateAcountGrid.setData(dsResponse.getData());
						}
					}
				});
				
				DBDataSource.callOperation("ST_ProjectCost", "find", params, new DSCallback(){
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							projectCostGrid.setData(dsResponse.getData());
						}
					}
				});
			}
		});

		middleLayout.addMember(setGrid);


		setDetailGrid=new DelicacyListGrid();
		setDetailGrid.setWidth("46%");
		int b = 0;
		ListGridField[] aFieldss = new ListGridField[9];
		aFieldss[b] = new ListGridField("settlementId","结算主表主键");
		aFieldss[b].setCanEdit(false);
		aFieldss[b].setHidden(true);
		b++;
		aFieldss[b] = new ListGridField("projectId","项目id");
		aFieldss[b].setCanEdit(false);
		aFieldss[b].setHidden(true);
		b++;
		aFieldss[b] = new ListGridField("planAmount","预分配积分");
		aFieldss[b].setAlign(Alignment.RIGHT);
		aFieldss[b].setWidth("25%");
		aFieldss[b].setType(ListGridFieldType.FLOAT);
		aFieldss[b].setFormat("##,###,###,###,##0.00");
		aFieldss[b].setCanEdit(false);
		b++;
		aFieldss[b] = new ListGridField("projectCost","分摊成本");
		aFieldss[b].setAlign(Alignment.RIGHT);
		aFieldss[b].setWidth("25%");
		aFieldss[b].setType(ListGridFieldType.FLOAT);
		aFieldss[b].setFormat("##,###,###,###,##0.00");
		aFieldss[b].setCanEdit(false);
		b++;
		aFieldss[b] = new ListGridField("realAmount","确认积分");
		aFieldss[b].setAlign(Alignment.RIGHT);
		aFieldss[b].setWidth("25%");
		aFieldss[b].setType(ListGridFieldType.FLOAT);
		aFieldss[b].setFormat("##,###,###,###,##0.00");
		aFieldss[b].setCanEdit(false);
		b++;
		aFieldss[b] = new ListGridField("employeeId","结算人");
		aFieldss[b].setCanEdit(false);
		aFieldss[b].setWidth("25%");
		aFieldss[b].setAlign(Alignment.CENTER);
		KeyValueManager.loadValueMap("employees", aFieldss[b]);
		b++;
		aFieldss[b] = new ListGridField("settlementDate","结算日期");
		aFieldss[b].setCanEdit(false);
		aFieldss[b].setWidth("25%");
		aFieldss[b].setAlign(Alignment.CENTER);
		aFieldss[b].setEditorProperties(dateItems);
		b++;
		aFieldss[b] = new ListGridField("settlementStatus","结算状态");
		aFieldss[b].setCanEdit(false);
		aFieldss[b].setWidth("25%");
		aFieldss[b].setAlign(Alignment.CENTER);
		aFieldss[b].setValueMap(linkmap);
		setDetailGrid.setFields(aFieldss);
		setDetailGrid.setAutoFitFieldWidths(false);
		setDetailGrid.setCanDragSelectText(true);
		setDetailGrid.setCanRemoveRecords(false);
		setDetailGrid.setShowGridSummary(true);
		setDetailGrid.setHeaderHeight(60);
		setDetailGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"项目结算明细表", new String[] {"settlementId","projectId","planAmount","projectCost","realAmount","employeeId","settlementDate","settlementStatus"}));
		middleLayout.addMember(setDetailGrid);



		plateAcountGrid=new DelicacyListGrid();
		plateAcountGrid.setWidth("100%");
		int c = 0;
		ListGridField[] aFieldsss = new ListGridField[9];
		aFieldsss[c] = new ListGridField("plateProjectAccountRecordId","主键");
		aFieldsss[c].setCanEdit(false);
		aFieldsss[c].setHidden(true);
		c++;
		aFieldsss[c] = new ListGridField("plateId","部门");
		aFieldsss[c].setCanEdit(false);
		aFieldsss[c].setAlign(Alignment.CENTER);
		KeyValueManager.loadValueMap("plate_records", aFieldsss[c]);
		c++;
		aFieldsss[c] = new ListGridField("stageId","阶段");
		aFieldsss[c].setAlign(Alignment.CENTER);
		aFieldsss[c].setCanEdit(false);
		KeyValueManager.loadValueMap("system_dictionary_7", aFieldsss[c]);
		c++;
		aFieldsss[c] = new ListGridField("accountIntegral","结算积分");
		aFieldsss[c].setAlign(Alignment.RIGHT);
		aFieldsss[c].setType(ListGridFieldType.FLOAT);
		aFieldsss[c].setFormat("##,###,###,###,##0.00");
		aFieldsss[c].setCanEdit(false);
		c++;
		aFieldsss[c] = new ListGridField("accountDate","结算日期");
		aFieldsss[c].setCanEdit(false);
		aFieldsss[c].setWidth("25%");
		aFieldsss[c].setAlign(Alignment.CENTER);
		aFieldsss[c].setEditorProperties(dateItems);
		c++;
		aFieldsss[c] = new ListGridField("remark","备注");
		aFieldsss[c].setAlign(Alignment.CENTER);
		aFieldsss[c].setCanEdit(false);


		plateAcountGrid.setFields(aFieldsss);
		plateAcountGrid.setAutoFitFieldWidths(false);
		plateAcountGrid.setCanDragSelectText(true);
		plateAcountGrid.setCanRemoveRecords(false);
		plateAcountGrid.setShowGridSummary(true);
		plateAcountGrid.setHeaderHeight(60);
		plateAcountGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"部门结算表", new String[] {"plateProjectAccountRecordId","plateId","stageId","accountIntegral","accountDate","remark"}));
		bottomLayout.addMember(plateAcountGrid);


		LinkedHashMap<Object, Object> coskmap=new LinkedHashMap<>();
		coskmap.put(0, "未结算");
		coskmap.put(1, "已结算");


		projectCostGrid=new DelicacyListGrid();
		projectCostGrid.setWidth("100%");
		int d = 0;
		ListGridField[] aFielda = new ListGridField[9];
		aFielda[d] = new ListGridField("projectCostId","主键");
		aFielda[d].setCanEdit(false);
		aFielda[d].setHidden(true);
		d++;
		aFielda[d] = new ListGridField("projectId","项目id");
		aFielda[d].setCanEdit(false);
		aFielda[d].setAlign(Alignment.CENTER);
		aFielda[d].setHidden(true);
		d++;
		aFielda[d] = new ListGridField("costType","费用类型");
		aFielda[d].setCanEdit(false);
		aFielda[d].setWidth("25%");
		aFielda[d].setAlign(Alignment.CENTER);
		KeyValueManager.loadValueMap("system_dictionary_9", aFielda[d]);
		d++;
		aFielda[d] = new ListGridField("amount","金额");
		aFielda[d].setAlign(Alignment.RIGHT);
		aFielda[d].setWidth("25%");
		aFielda[d].setType(ListGridFieldType.FLOAT);
		aFielda[d].setFormat("##,###,###,###,##0.00");
		aFielda[d].setCanEdit(false);
		d++;
		aFielda[d] = new ListGridField("employeeId","经办人");
		aFielda[d].setCanEdit(false);
		aFielda[d].setWidth("25%");
		aFielda[d].setAlign(Alignment.CENTER);
		KeyValueManager.loadValueMap("employees", aFielda[d]);
		d++;
		aFielda[d] = new ListGridField("costDate","日期");
		aFielda[d].setCanEdit(false);
		aFielda[d].setWidth("30%");
		aFielda[d].setAlign(Alignment.CENTER);
		aFielda[d].setEditorProperties(dateItems);
		d++;
		aFielda[d] = new ListGridField("status","状态");
		aFielda[d].setCanEdit(false);
		aFielda[d].setWidth("25%");
		aFielda[d].setAlign(Alignment.CENTER);
		aFielda[d].setValueMap(coskmap);


		projectCostGrid.setFields(aFielda);
		projectCostGrid.setAutoFitFieldWidths(false);
		projectCostGrid.setCanDragSelectText(true);
		projectCostGrid.setCanRemoveRecords(false);
		projectCostGrid.setShowGridSummary(true);
		projectCostGrid.setHeaderHeight(60);
		projectCostGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"项目成本表", new String[] {"projectCostId","projectId","costType","amount","employeeId","costDate","status"}));
		bottomLayout.addMember(projectCostGrid);


		projectAttamgrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				String fieldName = projectAttamgrid.getFieldName(colNum);
				if(fieldName.equals("attachmentFile")) {
					String url = BaseHelpUtils.getString(record.getAttribute("attachmentFile"));
					record.setAttribute("attachmentFile", linkHTML(url, "确认函下载/预览"));
				}
				return super.getCellCSSText(record, rowNum, colNum);
			}
		};
		projectAttamgrid.setWidth("100%");
		int e = 0;
		ListGridField[] aFieldas = new ListGridField[9];
		aFieldas[e] = new ListGridField("projectAttachmentId","主键");
		aFieldas[e].setCanEdit(false);
		aFieldas[e].setHidden(true);
		e++;
		aFieldas[e] = new ListGridField("projectId","项目id");
		aFieldas[e].setCanEdit(false);
		aFieldas[e].setHidden(true);
		e++;
		aFieldas[e] = new ListGridField("stageId","阶段");
		aFieldas[e].setAlign(Alignment.CENTER);
		aFieldas[e].setCanEdit(false);
		aFieldas[e].setWidth("25%");
		KeyValueManager.loadValueMap("system_dictionary_7", aFieldas[e]);
		e++;
		aFieldas[e] = new ListGridField("attachmentFile","确认函文件");
		aFieldas[e].setAlign(Alignment.CENTER);
		aFieldas[e].setWidth("25%");
		aFieldas[e].setCanEdit(false);
		e++;
		aFieldas[e] = new ListGridField("uploadTime","上传时间");
		aFieldas[e].setCanEdit(false);
		aFieldas[e].setWidth("25%");
		aFieldas[e].setAlign(Alignment.CENTER);
		aFieldas[e].setEditorProperties(dateItems);
		e++;
		aFieldas[e] = new ListGridField("remark","备注");
		aFieldas[e].setCanEdit(false);
		aFieldas[e].setWidth("25%");
		aFieldas[e].setAlign(Alignment.CENTER);


		projectAttamgrid.setFields(aFieldas);
		projectAttamgrid.setAutoFitFieldWidths(false);
		projectAttamgrid.setCanDragSelectText(true);
		projectAttamgrid.setCanRemoveRecords(false);
		projectAttamgrid.setShowGridSummary(true);
		projectAttamgrid.setHeaderHeight(60);
		projectAttamgrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"项目关联的确认函", new String[] {"projectAttachmentId","projectId","stageId","attachmentFile","uploadTime","remark"}));
		bottomLayout.addMember(projectAttamgrid);


















	}


	public void lodaData(int project) {
		Map<String,Object> params = new HashMap<>();
		params.put("projectId",project);
		DBDataSource.callOperation("ST_ProjectSettlement", "find", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					setGrid.setData(dsResponse.getData());
					DBDataSource.callOperation("ST_ProjectSettlementDetail", "find", params, new DSCallback(){
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0) {
								setDetailGrid.setData(dsResponse.getData());
								DBDataSource.callOperation("ST_PlateProjectAccountRecord", "find", params, new DSCallback(){
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() >= 0) {
											plateAcountGrid.setData(dsResponse.getData());
											DBDataSource.callOperation("ST_ProjectCost", "find", params, new DSCallback(){
												@Override
												public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
													if(dsResponse.getStatus() >= 0) {
														projectCostGrid.setData(dsResponse.getData());

													}
												}
											});
										}
									}
								});
							}
						}
					});
				}
			}
		});

		DBDataSource.callOperation("ST_ProjectAttachment", "find", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					projectAttamgrid.setData(dsResponse.getData());
				}
			}
		});

	}

	public void checkData() {

	}


	public Record getRecord() {
		return record;
	}


	public void setRecord(Record record) {
		this.record = record;
	}


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

	public void getProjectInfo() {
		LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();
		DBDataSource.callOperation("EP_GetProjectByProjectName", new HashMap<>(), new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] record = dsResponse.getData();
					for (Record obj : record) {
						projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
					}
					projectIdItem.setValueMap(projectMap);
				}
			}
		});
	}
}
