package com.pomplatform.client.budgetmanagementworkflow.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.budgetmanagementworkflow.datasource.DSBudgetManagementWorkFlow;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.getbudgetuplodanews.panel.GetBudgetUplodaNewsPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class BudgetManagementWorkFlowUpdateForm extends AbstractWizadPage implements HasHandlers
{


	private  DynamicForm  searchForm;
	private VLayout mainLayout;
	private HLayout topLayout;
	private HLayout middleLayout;
	private VLayout middleRightButtonLaout;
	private SelectItem bdtypeItem;
	private DoubleItem  bdTotalAmountItem;
	private  DoubleItem signingMoneyItem;
	private DoubleItem  totalIntegralItem;
	private DoubleItem  sheetAmountItem;
	private SelectItem outSourceTypeItem;
	private DateTimeItem  bdApplyTimeItem;
	private DateTimeItem  bdEstimatecloseTimeItem;
	private TextAreaItem  remarkItem;
	private ComboBoxItem  CostBearingItem;
	private ComboBoxItem  bdApplyEmployeeIdItem;
	private TextItem companyIdItem;
	private ComboBoxItem departmentIdItem;
	private  ComboBoxItem projectItem;
	private TextItem percentItem;
	private TextItem bdSupplierPersonItem;
	private SelectItem bdSupplierCompanyItem;
	private DelicacyListGrid bdDetailGrid;
	private IButton addButton;
	private IButton orderInfoBut;
	private IButton uplodaBut;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	private CheckboxItem  IsProcessItem;

	private static Logger __logger = Logger.getLogger("");
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private final LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();

	public BudgetManagementWorkFlowUpdateForm() {
		setPadding(5);
		mainLayout=new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		topLayout=new HLayout();
		topLayout.setWidth100();
		topLayout.setMargin(10);
		topLayout.setAlign(Alignment.CENTER);
		topLayout.setHeight("10%");
		mainLayout.addMember(topLayout);

		bdtypeItem=new SelectItem("bdType",shouldNotBeNull+"预算类型");
		KeyValueManager.loadValueMap("system_dictionary_191", bdtypeItem);
		bdtypeItem.setRequired(true);
		bdtypeItem.setCanEdit(false);
		bdtypeItem.setDisabled(true);
		bdtypeItem.setWidth("*");
		bdtypeItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				int bdtype=BaseHelpUtils.getIntValue(event.getValue());
				RecordList recordlist=new RecordList();
				switch (bdtype) {
				case 1://采买预算
					bdTotalAmountItem.clearValue();
					projectItem.clearValue();
					signingMoneyItem.clearValue();
					percentItem.clearValue();
					outSourceTypeItem.clearValue();
					sheetAmountItem.clearValue();
					totalIntegralItem.clearValue();
					bdSupplierPersonItem.clearValue();
					bdSupplierCompanyItem.clearValue();
					CostBearingItem.clearValue();
					bdSupplierPersonItem.setRequired(false);
					bdSupplierCompanyItem.setRequired(false);
					bdSupplierPersonItem.hide();
					departmentIdItem.setRequired(true);
					departmentIdItem.show();
					bdSupplierCompanyItem.hide();
					projectItem.show();
					signingMoneyItem.hide();
					percentItem.show();
					outSourceTypeItem.hide();
					outSourceTypeItem.setRequired(false);
					sheetAmountItem.hide();
					totalIntegralItem.hide();
					orderInfoBut.hide();
					IsProcessItem.hide();
					Record record=new Record();
					Map<String,Object> map=new HashMap<>();
					String value="质保金";
					map.put("budgetDetailTypeKey", value);
					record=SyncDataUtil.getValueByTableName("ST_BudgetDetailType","find",map);
					if(record!=null) {
						String typeValue=BaseHelpUtils.getString(record.getAttribute("budgetDetailTypeValue"));
						record.setAttribute("bddType", typeValue);
						recordlist.add(record);
						bdDetailGrid.setData(recordlist);//清空grid数据
					}
					lodaBddType(bdtype);
					break;
				case 2://行政预算
					bdTotalAmountItem.clearValue();
					projectItem.clearValue();
					signingMoneyItem.clearValue();
					percentItem.clearValue();
					outSourceTypeItem.clearValue();
					sheetAmountItem.clearValue();
					totalIntegralItem.clearValue();
					bdSupplierPersonItem.clearValue();
					bdSupplierCompanyItem.clearValue();
					CostBearingItem.clearValue();
					bdSupplierPersonItem.setRequired(false);
					bdSupplierCompanyItem.setRequired(false);
					departmentIdItem.setRequired(true);
					departmentIdItem.show();
					bdSupplierPersonItem.hide();
					bdSupplierCompanyItem.hide();
					projectItem.hide();
					signingMoneyItem.hide();
					percentItem.hide();
					outSourceTypeItem.hide();
					outSourceTypeItem.setRequired(false);
					sheetAmountItem.hide();
					IsProcessItem.show();
					totalIntegralItem.hide();
					orderInfoBut.hide();
					bdDetailGrid.setData(recordlist);
					lodaBddType(bdtype);
					break;
				case 3://项目预算
					bdTotalAmountItem.clearValue();
					projectItem.clearValue();
					signingMoneyItem.clearValue();
					percentItem.clearValue();
					outSourceTypeItem.clearValue();
					sheetAmountItem.clearValue();
					totalIntegralItem.clearValue();
					bdSupplierPersonItem.clearValue();
					bdSupplierCompanyItem.clearValue();
					CostBearingItem.clearValue();
					bdSupplierPersonItem.setRequired(false);
					bdSupplierCompanyItem.setRequired(false);
					departmentIdItem.setRequired(true);
					departmentIdItem.show();
					bdSupplierPersonItem.hide();
					bdSupplierCompanyItem.hide();
					projectItem.show();
					signingMoneyItem.hide();
					percentItem.show();
					outSourceTypeItem.hide();
					outSourceTypeItem.setRequired(false);
					sheetAmountItem.hide();
					totalIntegralItem.hide();
					orderInfoBut.hide();
					IsProcessItem.hide();
					bdDetailGrid.setData(recordlist);
					lodaBddType(bdtype);
					break;
				case 4://外包预算
					bdTotalAmountItem.clearValue();
					projectItem.clearValue();
					signingMoneyItem.clearValue();
					departmentIdItem.clearValue();
					percentItem.clearValue();
					bdSupplierPersonItem.show();
					bdSupplierCompanyItem.show();
					bdSupplierPersonItem.setRequired(true);
					bdSupplierCompanyItem.setRequired(true);
					projectItem.show();
					orderInfoBut.show();
					signingMoneyItem.hide();
					percentItem.hide();
					departmentIdItem.hide();
					IsProcessItem.hide();
					outSourceTypeItem.show();
					outSourceTypeItem.setRequired(true);
					departmentIdItem.setRequired(false);
					bdDetailGrid.setData(recordlist);
					CostBearingItem.setValue("项目承担");
					lodaBddType(bdtype);
					break;
				}
			}
		});

		outSourceTypeItem=new SelectItem("outSourceType",shouldNotBeNull+"外包类型");
		KeyValueManager.loadValueMap("system_dictionary_206", outSourceTypeItem);
		outSourceTypeItem.setWidth("*");
		outSourceTypeItem.hide();
		outSourceTypeItem.setRequired(false);
		outSourceTypeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int outSourceType=BaseHelpUtils.getIntValue(event.getValue());
				if(outSourceType==1) {//公司外包
					sheetAmountItem.show();
					totalIntegralItem.hide();
					CostBearingItem.setValue("公司承担");
				}else if(outSourceType==2) {//项目外包
					sheetAmountItem.show();
					totalIntegralItem.show();
					CostBearingItem.setValue("项目承担");
				}

			}
		});


		bdTotalAmountItem=new DoubleItem("bdTotalAmount",shouldNotBeNull+"预算总金额");
		bdTotalAmountItem.setRequired(true);
		bdTotalAmountItem.setFormat("##,###,###,###,##0.00");
		bdTotalAmountItem.setWidth("*");
		bdTotalAmountItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				BigDecimal val=BaseHelpUtils.getBigDecimalValue(event.getValue()).setScale(2, BigDecimal.ROUND_HALF_UP);
				bdTotalAmountItem.setValue(val);
			}
		});

		bdApplyTimeItem=new DateTimeItem("bdApplyTime",shouldNotBeNull+"申请时间");
		bdApplyTimeItem.setRequired(true);
		bdApplyTimeItem.setDefaultValue(new Date());
		bdApplyTimeItem.setCanEdit(false);
		bdApplyTimeItem.setDisabled(true);
		bdApplyTimeItem.setWidth("*");

		bdEstimatecloseTimeItem=new DateTimeItem("bdEstimatecloseTime","预期关闭时间");
		bdEstimatecloseTimeItem.setWidth("*");

		bdApplyEmployeeIdItem=new ComboBoxItem("bdApplyEmployeeId","申请人");
		bdApplyEmployeeIdItem.setWidth("*");
		bdApplyEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		bdApplyEmployeeIdItem.setRequired(true);
		bdApplyEmployeeIdItem.setCanEdit(false);
		bdApplyEmployeeIdItem.setDisabled(true);

		companyIdItem=new TextItem("companyId","归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setRequired(true);
		companyIdItem.setWidth("*");
		companyIdItem.setCanEdit(false);
		companyIdItem.setDisabled(true);

		departmentIdItem=new ComboBoxItem("departmentId",shouldNotBeNull+"承接部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		departmentIdItem.setRequired(true);
		departmentIdItem.setWidth("*");

		projectItem=new ComboBoxItem("projectId","项目");
		projectItem.setWidth("*");
//		projectItem.setHint("默认加载申请人相关的项目,若要加载全部项目,请单击Enter");
		projectItem.setShowHintInField(true);
		projectItem.setChangeOnKeypress(false);
		projectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null == projectItem.getValue()) {signingMoneyItem .hide(); percentItem.hide();}
				if(null != projectItem.getValue() && null != projectMap && !projectMap.isEmpty()){
					Map<String, Object> map = new HashMap<>();
					int projectId=BaseHelpUtils.getIntValue(event.getValue());
					map.put("projectId",projectId);
//					DBDataSource.callOperation("NQ_Mcontractppspcccfscsiiicpor","find",map, new DSCallback() {
//						@Override
//						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//							if (dsResponse.getStatus() >= 0) {
//								Record record[] = dsResponse.getData();
//								for (Record obj : record) {
//									signingMoneyItem .setValue(BaseHelpUtils.getBigDecimalValue(obj.getAttribute("signingMoneySum")));
//								}
//								DBDataSource.callOperation("ST_Project", "find", map, new DSCallback(){
//									@Override
//									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//										if(dsResponse.getStatus() >= 0) {
//											Record[] recordss=dsResponse.getData();
//											int plateId=0;
//											for (Record records : recordss) {
//												plateId=BaseHelpUtils.getIntValue(records.getAttribute("plateId"));
//											}
//											departmentIdItem.setValue(plateId);
//										}
//									}
//								});
//							}
//						}
//					});
				}
			}
		});

		signingMoneyItem=new DoubleItem("signingMoneySum","签约合同金额");  
		signingMoneyItem.setWidth("*");
		signingMoneyItem.setDecimalPad(2);
		signingMoneyItem.setFormat("##,###,###,###,##0.00");
		signingMoneyItem.setHidden(false);
		signingMoneyItem.setCanEdit(false);
		signingMoneyItem.setDisabled(true);

		totalIntegralItem=new DoubleItem("totalIntegral","订单总积分");
		totalIntegralItem.setWidth("*");
		totalIntegralItem.hide();
		totalIntegralItem.setDecimalPad(2);
		totalIntegralItem.setFormat("##,###,###,###,##0.00");
		totalIntegralItem.setHidden(false);
		totalIntegralItem.setCanEdit(false);
		totalIntegralItem.setDisabled(true);

		sheetAmountItem=new DoubleItem("sheetAmount","订单合同金额");
		sheetAmountItem.hide();
		sheetAmountItem.setWidth("*");
		sheetAmountItem.setDecimalPad(2);
		sheetAmountItem.setFormat("##,###,###,###,##0.00");
		sheetAmountItem.setHidden(false);
		sheetAmountItem.setCanEdit(false);
		sheetAmountItem.setDisabled(true);


		percentItem=new TextItem("预算百分比(%)");
		percentItem.setWidth("*");
		percentItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int events=BaseHelpUtils.getIntValue(event.getValue());
				if(events>100||events<0) {
					SC.say("百分比不能大于100%或不能小于0");
					return;
				}
				//获取百分比
				BigDecimal percent=new BigDecimal(100);
				BigDecimal percentValue=BaseHelpUtils.getBigDecimalValue(event.getValue()).divide(percent);
				//获取项目总金额
				BigDecimal projectIntegral=BaseHelpUtils.getBigDecimalValue(signingMoneyItem.getValue());
				//预算金额
				BigDecimal  bdTotalAmount=projectIntegral.multiply(percentValue).setScale(2, BigDecimal.ROUND_HALF_UP);
				if(bdTotalAmount.compareTo(BigDecimal.ZERO)>=0) {
					bdTotalAmountItem.setValue(bdTotalAmount);
				}
			}
		});

		CostBearingItem=new ComboBoxItem("costBearing",shouldNotBeNull+"费用承担");
		CostBearingItem.setValueMap("项目承担","部门承担","公司承担");
		CostBearingItem.setRequired(true);
		CostBearingItem.setWidth("*");

		remarkItem=new TextAreaItem("bdRemark","备注");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(4);
		remarkItem.setLength(2048);

		bdSupplierPersonItem=new TextItem("bdSupplierPerson",shouldNotBeNull+"拟供应商主要负责人");
		bdSupplierPersonItem.setRequired(false);
		bdSupplierPersonItem.hide();
		bdSupplierPersonItem.setWidth("*");


		bdSupplierCompanyItem=new SelectItem("bdSupplierCompany",shouldNotBeNull+"拟外协供应商(公司)");
		Map<String,Object> subMap=new HashMap<>();
		subMap.put("isUse", 1);
		subMap.put("supplierType", 1);
		Record[] supRecord=SyncDataUtil.getValueByTableNames("ST_Supplier", "find", subMap);
		if(!BaseHelpUtils.isNullOrEmpty(supRecord)) {
			LinkedHashMap<String, String> supLinkMap=new LinkedHashMap<>();
			for (Record record : supRecord) {
				supLinkMap.put(BaseHelpUtils.getString(record.getAttribute("supplierName")), BaseHelpUtils.getString(record.getAttribute("supplierName")));
			}
			bdSupplierCompanyItem.setValueMap(supLinkMap);
		}
		//bdSupplierCompanyItem.setHint("若无供应商所属公司,请填写无");
		bdSupplierCompanyItem.setShowHintInField(true);
		bdSupplierCompanyItem.setRequired(false);
		bdSupplierCompanyItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		bdSupplierCompanyItem.hide();
		bdSupplierCompanyItem.setWidth("*");


		IsProcessItem = new CheckboxItem("isProcess", "是否关联流程");
		IsProcessItem.hide();
		IsProcessItem.setCanEdit(false);
		IsProcessItem.setWidth("*");
		IsProcessItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				Record record = new Record();
				record.setAttribute("flag", (Boolean)event.getValue());
				if((Boolean)event.getValue()){
				}else{
				}
				DataEditEvent dee = new DataEditEvent();
				dee.setData(record);
				fireEvent(dee);
			}
		});


		searchForm=new DynamicForm();
		searchForm.setNumCols(4);
		searchForm.setPadding(3);
		searchForm.setMargin(5);
		searchForm.setWidth("100%");;
		searchForm.setHeight("20%");
		searchForm.setFields(bdtypeItem,bdTotalAmountItem,bdSupplierCompanyItem,bdSupplierPersonItem,outSourceTypeItem,bdApplyTimeItem,bdEstimatecloseTimeItem,bdApplyEmployeeIdItem,departmentIdItem,companyIdItem,projectItem,sheetAmountItem,totalIntegralItem,signingMoneyItem ,percentItem,IsProcessItem,CostBearingItem,remarkItem);
		topLayout.addMember(searchForm);
		CostBearingItem.setColSpan(4);
		bdSupplierPersonItem.setColSpan(1);
		bdSupplierCompanyItem.setColSpan(1);



		middleLayout=new HLayout();
		middleLayout.setWidth100();
		middleLayout.setHeight("80%");
		middleLayout.setMargin(15);
		middleLayout.setAlign(Alignment.CENTER);
		mainLayout.addMember(middleLayout);

		bdDetailGrid = new DelicacyListGrid();
		bdDetailGrid.setWidth("99%");
		bdDetailGrid.setAlign(Alignment.RIGHT);
		int a = 0;
		ListGridField[] aFields = new ListGridField[2];
		aFields[a] = new ListGridField("budgetManagemenDetailId","预算详情id");
		aFields[a].setCanEdit(true);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("budgetManagementId","预算管理Id");
		aFields[a].setCanEdit(true);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("bddType","预算类别");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("bddAmount","预算金额");
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(true);
		aFields[a].addChangedHandler(new com.smartgwt.client.widgets.grid.events.ChangedHandler() {

			@Override
			public void onChanged(com.smartgwt.client.widgets.grid.events.ChangedEvent event) {
				BigDecimal val=BaseHelpUtils.getBigDecimalValue(event.getValue()).setScale(2, BigDecimal.ROUND_HALF_UP);
				event.getForm().getItem("bddAmount").setValue(val);
			}
		});
		a++;
		aFields[a] = new ListGridField("projectId","项目id");
		aFields[a].setCanEdit(true);
		aFields[a].setHidden(true);
		bdDetailGrid.setFields(aFields);
		bdDetailGrid.setAutoFitFieldWidths(false);
		bdDetailGrid.setCanRemoveRecords(true);
		bdDetailGrid.setShowGridSummary(true);
		bdDetailGrid.setHeaderHeight(60);
		bdDetailGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"预算详情", new String[] {"budgetManagemenDetailId","budgetManagementId","bddType","bddAmount","projectId"}));

		addButton = new IButton("新增");
		addButton.setMargin(1);
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				bdDetailGrid.startEditingNew();
			}
		});
		middleLayout.addMember(bdDetailGrid);

		orderInfoBut=new IButton("订单详情");
		orderInfoBut.hide();
		orderInfoBut.setMargin(1);
		orderInfoBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int projectId=BaseHelpUtils.getIntValue(projectItem.getValue());
				if(projectId<=0) {SC.say("请选择一条项目");return;}
				final PopupWindow popupWindow = new PopupWindow("合同下的订单信息");
				popupWindow.setWidth("80%");
				popupWindow.setHeight("60%");
				BudgetOutOrderInfoPanel OrderInfo = new BudgetOutOrderInfoPanel();
				OrderInfo.initComponents();
				OrderInfo.setProjectId(projectId);
				OrderInfo.lodaData();
				popupWindow.addItem(OrderInfo);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				OrderInfo.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});

		uplodaBut=new IButton("查看附件");
		uplodaBut.hide();
		uplodaBut.setMargin(1);
		uplodaBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final PopupWindow popupWindow = new PopupWindow("附件信息");
				popupWindow.setWidth("80%");
				popupWindow.setHeight("60%");
				GetBudgetUplodaNewsPanel infoPanel = new GetBudgetUplodaNewsPanel();
				infoPanel.initComponents();
				infoPanel.setRecord(getRecord());
				infoPanel.lodaDate();
				popupWindow.addItem(infoPanel);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});

		middleRightButtonLaout=new VLayout(10);
		middleRightButtonLaout.setWidth("1%");
		middleRightButtonLaout.setHeight("20%");
		middleRightButtonLaout.addMember(addButton);
		middleRightButtonLaout.addMember(orderInfoBut);
		middleRightButtonLaout.addMember(uplodaBut);
		middleLayout.addMember(middleRightButtonLaout);


		addMember(mainLayout);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) searchForm.editRecord(getRecord());
		int projectId=BaseHelpUtils.getIntValue(projectItem.getValue());
		Map<String, Object> map = new HashMap<>();
		if(projectId>0) {
			map.put("projectId",projectId);
		}
		int bdtype=BaseHelpUtils.getIntValue(bdtypeItem.getValue());
		int fileId=BaseHelpUtils.getIntValue(getRecord().getAttribute("fileId"));
		if(fileId>0) {
			uplodaBut.show();
		}
		if(bdtype==2) {//行政预算
			projectItem.hide();
			signingMoneyItem.hide();
			percentItem.hide();
			IsProcessItem.show();
			Boolean value=BaseHelpUtils.getBoolean(IsProcessItem.getValue());
			if(value) {
				Record record = new Record();
				record.setAttribute("flag", value);
				DataEditEvent dee = new DataEditEvent();
				dee.setData(record);
				fireEvent(dee);
			}
		}else if(bdtype==4) {//外包预算
			bdSupplierPersonItem.show();
			bdSupplierCompanyItem.show();
			bdSupplierPersonItem.setRequired(true);
			bdSupplierCompanyItem.setRequired(true);
			outSourceTypeItem.setRequired(true);
			orderInfoBut.show();
			outSourceTypeItem.show();
			percentItem.hide();
			departmentIdItem.hide();
			Record record=SyncDataUtil.getValueByTableName("ST_Project","find",map);
			BigDecimal totalIntegral=BaseHelpUtils.getBigDecimalValue(record.getAttribute("totalIntegral"));
			BigDecimal sheetAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("sheetAmount"));
			totalIntegralItem.setValue(totalIntegral);
			sheetAmountItem.setValue(sheetAmount);
			int outSourceType=BaseHelpUtils.getIntValue(outSourceTypeItem.getValue());
			if(outSourceType==1) {//公司外包
				signingMoneyItem.hide();
				sheetAmountItem.show();
				totalIntegralItem.hide();
			}else if(outSourceType==2) {//项目外包
				signingMoneyItem.hide();
				sheetAmountItem.show();
				totalIntegralItem.show();
			}
		}
		Map condition = new HashMap();
		condition.put("budgetManagementId", BaseHelpUtils.getIntValue(getRecord().getAttribute("budgetManagementId")));
		DBDataSource.callOperation("ST_BudgetManagementDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {

					bdDetailGrid.setData(dsResponse.getData());

				}
			}
		});
		//获取发起人Id
		int bdApplyEmployeeId=BaseHelpUtils.getIntValue(getRecord().getAttribute("bdApplyEmployeeId"));
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("employeeId", bdApplyEmployeeId);
		mapa.put("optType", "getMainProjectName");
		DBDataSource.callOperation("EP_GetUserInfoById", mapa, new DSCallback() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Map userMap = BaseHelpUtils.getResponseUserData(dsResponse);
					if(!BaseHelpUtils.isNullOrEmpty(userMap) && userMap.size() > 0) {
						projectMap.putAll(userMap);
						projectItem.setValueMap(projectMap);
					}
				}
			}
		});

//		projectItem.addKeyPressHandler(new KeyPressHandler() {
//			@Override
//			public void onKeyPress(final KeyPressEvent event) {
//				if (event.getKeyName().equals("Enter")) {
//					final String value = projectItem.getValueAsString();
//					Map<String, Object> map = new HashMap<>();
//					map.put("projectName", value);
//					DBDataSource.callOperation("EP_GetProjectByProjectName", map, new DSCallback() {
//						@Override
//						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//							if (dsResponse.getStatus() >= 0) {
//								Record[] record = dsResponse.getData();
//								projectMap.clear();
//								for (Record obj : record) {
//									projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
//								}
//								projectItem.setValueMap(projectMap);
//							} else {
//								SC.say("没有找到与关键字：【" + value + "】相匹配的项目");
//							}
//							event.cancel();
//						}
//					});
//				}
//
//			}
//		});

		DBDataSource.callOperation("NQ_Mcontractppspcccfscsiiicpor","find",map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record record[] = dsResponse.getData();
					for (Record obj : record) {
						BigDecimal signingMoney=BaseHelpUtils.getBigDecimalValue(obj.getAttribute("signingMoneySum"));
						//获取预算总金额
						BigDecimal bdTotalAmount=BaseHelpUtils.getBigDecimalValue(bdTotalAmountItem.getValue());
						//比例
						BigDecimal percent=new BigDecimal(100);
						signingMoneyItem .setValue(signingMoney);
						BigDecimal percentValue=bdTotalAmount.divide(signingMoney,2,BigDecimal.ROUND_UP).multiply(percent);
						percentItem.setValue(percentValue);
					}
				}
			}
		});
	}



	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSBudgetManagementWorkFlow.getInstance());
		manager.addMember(__form);

	}	

	@Override
	public boolean checkData() {
		BigDecimal toalbddAmount=BigDecimal.ZERO;
		ListGridRecord[]  records=bdDetailGrid.getGridSummaryData();
		for (ListGridRecord record : records) {
			toalbddAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("bddAmount")).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		//获取预算总金额
		BigDecimal bdTotalAmount=BaseHelpUtils.getBigDecimalValue(bdTotalAmountItem.getValue());
		//获取预算类型
		int bdtype=BaseHelpUtils.getIntValue(bdtypeItem.getValue());
		//获取项目ID
		int projectId=BaseHelpUtils.getIntValue(projectItem.getValue());
		if(!searchForm.validate()) {
			SC.say("请按系统提示修改信息");
			return false;
		}else if(bdDetailGrid.getRecords().length==0) {
			SC.say("预算详情不能为空");
			return false;
		}else if(bdTotalAmount.compareTo(toalbddAmount)!=0) {
			SC.say("预算类别总金额必须等于预算总金额，当前"+"预算总金额为["+bdTotalAmount+"]，"+"预算类别总金额为["+toalbddAmount+"]，相差金额为["+bdTotalAmount.subtract(toalbddAmount)+"]");
			return false;
		}else if(bdtype==1) {//采买
			if(projectId<=0) {
				SC.say("采买预算中项目不能为空");
				return false;
			}
			//获取质保金
			/*Record[] reocrds=bdDetailGrid.getRecords();
			for (Record record : reocrds) {
				//获取预算类别
				String bddType=BaseHelpUtils.getString(record.getAttribute("bddType"));
				//获取预算类别金额
				BigDecimal bddAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("bddAmount"));
				if(!bddType.equals("质保金")) {
					SC.say("采买预算中质保金不能为空");
					return false;
				}else {
					if(bddAmount.compareTo(BigDecimal.ZERO)==0) {
						SC.say("质保金的金额不能为空");
						return false;
					}
				}
			}*/
			return true;
		}else if(bdtype==2) {//行政
			if(projectId>0) {
				SC.say("行政预算不能选择项目");
				return false;
			}
			return true;
		}else if(bdtype==3) {//项目
			if(projectId<=0) {
				SC.say("部门预算中项目不能为空");
				return false;
			}
			return true;
		}else if(bdtype==4) {//外包
			if(projectId<=0) {
				SC.say("外包预算中项目不能为空");
				return false;
			}
			return true;
		}else {
			return true;
		}
	}

	@Override
	public Map getValuesAsMap() {
		Map<String,Object> valuesMap= searchForm.getValues();
		MapUtils.convertRecordToMap(bdDetailGrid,bdDetailGrid.getRecords(),valuesMap,"detailBudgetManagementDetail");
		return valuesMap;
	}

	public void lodaBddType(Integer typeId) {
		Map<String,Object> map=new HashMap<>();
		map.put("typeId", typeId);
		DBDataSource.callOperation("ST_BudgetDetailType", "find", map, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					LinkedHashMap<String, String> linkmap=new LinkedHashMap<>();
					Record[] records=dsResponse.getData();
					for (Record record : records) {
						linkmap.put(record.getAttribute("budgetDetailTypeKey"), record.getAttribute("budgetDetailTypeValue"));
					}
					ComboBoxItem bddTpyeBoxItem = new ComboBoxItem();
					bddTpyeBoxItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
					bdDetailGrid.getField("bddType").setEditorProperties(bddTpyeBoxItem);
					bdDetailGrid.getField("bddType").setValueMap(linkmap);
				}
			}
		});
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public CheckboxItem getIsProcessItem() {
		return IsProcessItem;
	}

	public void setIsProcessItem(CheckboxItem isProcessItem) {
		IsProcessItem = isProcessItem;
	}

}

