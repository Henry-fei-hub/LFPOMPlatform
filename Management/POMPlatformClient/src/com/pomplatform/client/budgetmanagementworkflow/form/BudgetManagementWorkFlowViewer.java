package com.pomplatform.client.budgetmanagementworkflow.form;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.budgetmanagementworkflow.datasource.DSBudgetManagementWorkFlow;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.getbudgetuplodanews.panel.GetBudgetUplodaNewsPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
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
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class BudgetManagementWorkFlowViewer extends AbstractDetailViewer
{

	private SearchForm __parentSearchForm;
	private  DynamicForm  searchForm;
	private VLayout mainLayout;
	private HLayout mainRightLayout;
	private HLayout topLayout;
	private HLayout middleLayout;
	private VLayout middleRightButtonLaout;
	private SelectItem bdtypeItem;
	private DoubleItem  totalIntegralItem;
	private DoubleItem  sheetAmountItem;
	private SelectItem outSourceTypeItem;
	private DoubleItem  bdTotalAmountItem;
	private  DoubleItem signingMoneyItem;
	private DateTimeItem  bdApplyTimeItem;
	private DateTimeItem  bdEstimatecloseTimeItem;
	private TextAreaItem  remarkItem;
	private TextItem  CostBearingItem;
	private ComboBoxItem  bdApplyEmployeeIdItem;
	private TextItem companyIdItem;
	private TextItem departmentIdItem;
	private  ComboBoxItem projectItem;
	private TextItem percentItem;
	private TextItem bdSupplierPersonItem;
	private TextItem bdSupplierCompanyItem;
	private DelicacyListGrid bdDetailGrid;
	private IButton orderInfoBut;
	private IButton uplodaBut;
	private CheckboxItem  IsProcessItem;

	private static Logger __logger = Logger.getLogger("");
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private final LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();


	public BudgetManagementWorkFlowViewer() {
	}

	@Override
	public void initComponents() {
		DSBudgetManagementWorkFlow ds = DSBudgetManagementWorkFlow.getInstance();
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
		bdtypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_191"));
		bdtypeItem.setRequired(true);
		bdtypeItem.setWidth("*");

		outSourceTypeItem=new SelectItem("outSourceType",shouldNotBeNull+"外包类型");
		outSourceTypeItem.setRequired(true);
		outSourceTypeItem.hide();
		KeyValueManager.loadValueMap("system_dictionary_206", outSourceTypeItem);
		outSourceTypeItem.setWidth("*");

		bdTotalAmountItem=new DoubleItem("bdTotalAmount",shouldNotBeNull+"预算总金额");
		bdTotalAmountItem.setDecimalPad(2);
		bdTotalAmountItem.setFormat("##,###,###,###,##0.00");
		bdTotalAmountItem.setRequired(true);
		bdTotalAmountItem.setWidth("*");

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
		bdApplyEmployeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		bdApplyEmployeeIdItem.setRequired(true);
		bdApplyEmployeeIdItem.setCanEdit(false);
		bdApplyEmployeeIdItem.setDisabled(true);

		companyIdItem=new TextItem("companyId","归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setRequired(true);
		companyIdItem.setWidth("*");
		companyIdItem.setCanEdit(false);
		companyIdItem.setDisabled(true);
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());

		departmentIdItem=new TextItem("departmentId",shouldNotBeNull+"承接部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		departmentIdItem.setRequired(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanEdit(false);
		departmentIdItem.setDisabled(true);
		
		IsProcessItem = new CheckboxItem("isProcess", "是否关联流程");
		IsProcessItem.hide();
		IsProcessItem.setWidth("*");
	   


		projectItem=new ComboBoxItem("projectId","项目");
		projectItem.setWidth("*");
		projectItem.setChangeOnKeypress(false);
		projectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);

		signingMoneyItem =new DoubleItem("signingMoneySum","签约合同金额");  
		signingMoneyItem.setWidth("*");
		signingMoneyItem.setDecimalPad(2);
		signingMoneyItem.setFormat("##,###,###,###,##0.00");
		//signingMoneyItem.setHidden(false);
		signingMoneyItem.setCanEdit(false);
		signingMoneyItem.setDisabled(true);

		totalIntegralItem=new DoubleItem("totalIntegral","订单总积分");
		totalIntegralItem.hide();
		totalIntegralItem.setWidth("*");
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

		CostBearingItem=new TextItem("costBearing",shouldNotBeNull+"费用承担");
		CostBearingItem.setRequired(true);
		CostBearingItem.setWidth("*");

		remarkItem=new TextAreaItem("bdRemark","备注");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(4);
		remarkItem.setLength(2048);
		
		bdSupplierPersonItem=new TextItem("bdSupplierPerson",shouldNotBeNull+"拟供应商主要负责人");
		bdSupplierPersonItem.setRequired(true);
		bdSupplierPersonItem.hide();
		bdSupplierPersonItem.setWidth("*");

		bdSupplierCompanyItem=new TextItem("bdSupplierCompany",shouldNotBeNull+"拟外协供应商(公司)");
		bdSupplierCompanyItem.setRequired(true);
		bdSupplierCompanyItem.hide();
		bdSupplierCompanyItem.setWidth("*");


		searchForm=new DynamicForm();
		searchForm.setNumCols(4);
		searchForm.setPadding(3);
		searchForm.setMargin(5);
		searchForm.setWidth("100%");;
		searchForm.setHeight("20%");
		searchForm.setCanEdit(false);
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
		ComboBoxItem bddTpyeBoxItem = new ComboBoxItem();
		bddTpyeBoxItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		aFields[a].setEditorProperties(bddTpyeBoxItem);
		aFields[a].setValueMap(KeyValueManager.getValueMap("budget_detail_type"));
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("bddAmount","预算类别金额");
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("projectId","项目id");
		aFields[a].setCanEdit(true);
		aFields[a].setHidden(true);
		bdDetailGrid.setFields(aFields);
		bdDetailGrid.setAutoFitFieldWidths(false);
		bdDetailGrid.setShowGridSummary(true);
		bdDetailGrid.setHeaderHeight(60);
		bdDetailGrid.setCanEdit(false);
		bdDetailGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"预算详情", new String[] {"budgetManagemenDetailId","budgetManagementId","bddType","bddAmount","projectId"}));
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


		middleRightButtonLaout=new VLayout(20);
		middleRightButtonLaout.setWidth("1%");
		middleRightButtonLaout.setHeight("20%");
		middleRightButtonLaout.setMargin(8);
		middleRightButtonLaout.addMember(orderInfoBut);
		middleRightButtonLaout.addMember(uplodaBut);
		middleLayout.addMember(middleRightButtonLaout);

		mainRightLayout=new HLayout();
		mainRightLayout.setWidth("60%");
		mainRightLayout.setHeight100();
		mainRightLayout.hide();
		

		addMember(mainLayout);
		addMember(mainRightLayout);

	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "预算单立项";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		return gcs;
	}

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("budgetManagementId", getBusinessId());
		DBDataSource.callOperation("NQ_BudgetManagementWorkFlow", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					for(DetailViewer v : detailViewers){
						v.setData(dsResponse.getData());
						if(dsResponse.getData().length == 0) continue;
						v.selectRecord(0);
						v.redraw();
					}
					setRecord(dsResponse.getData()[0]);
					viewDetailData();
				}
			}
		});
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	public void viewDetailData(){
		Record selected = getRecord();
		if(BaseHelpUtils.getBoolean(getRecord().getAttribute("isProcess"))) {
			BudgetManagementLinkProcessPanel alrPanel = new BudgetManagementLinkProcessPanel(false);
			alrPanel.setRecord(getRecord());
			alrPanel.setDetailView();
			mainRightLayout.show();
			mainRightLayout.addMember(alrPanel);
		}
		loadProjectMap();
		searchForm.editRecord(selected);
		Object val;
		Map condition = null;
		condition = new HashMap();
		int projectId=BaseHelpUtils.getIntValue(selected.getAttributeAsInt("projectId"));
		if(projectId>0) {
		condition.put("projectId",projectId);
		}

		int bdtype=BaseHelpUtils.getIntValue(bdtypeItem.getValue());
		int fileId=BaseHelpUtils.getIntValue(selected.getAttribute("fileId"));
		if(fileId>0) {
			uplodaBut.show();
		}
		if(bdtype==2) {//行政预算
			projectItem.hide();
			signingMoneyItem.hide();
			percentItem.hide();
		}else if(bdtype==4) {//外包预算
			bdSupplierPersonItem.show();
			bdSupplierCompanyItem.show();
			orderInfoBut.show();
			outSourceTypeItem.show();
			percentItem.hide();
			departmentIdItem.hide();
			Record record=SyncDataUtil.getValueByTableName("ST_Project","find",condition);
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

		condition.put("budgetManagementId", selected.getAttributeAsInt("budgetManagementId"));
		DBDataSource.callOperation("ST_BudgetManagementDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					bdDetailGrid.setData(dsResponse.getData());
				}
			}
		});

		DBDataSource.callOperation("NQ_Mcontractppspcccfscsiiicpor","find",condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record record[] = dsResponse.getData();
					BigDecimal signingMoney=BigDecimal.ZERO;
					for (Record obj : record) {
						if(bdtype==1) {
							signingMoney=BaseHelpUtils.getBigDecimalValue(obj.getAttribute("signingMoneySum"));
						}
					}
					signingMoneyItem .setValue(signingMoney);
					loadPercent();
				}
			}
		});

	}
	@Override
	public DataSource getMainDataSource() {
		return DSBudgetManagementWorkFlow.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		//res.add(bdDetailGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		//res.add("预算附件");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}

	public void loadProjectMap() {
		final String value = projectItem.getValueAsString();
		Map<String, Object> maps = new HashMap<>();
		maps.put("projectName", value);
		DBDataSource.callOperation("EP_GetProjectByProjectName", maps, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] record = dsResponse.getData();
					for (Record obj : record) {
						projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
					}
					projectItem.setValueMap(projectMap);
				} else {
					SC.say("没有找到与关键字：【" + value + "】相匹配的项目");
				}
			}
		});
	}

	public void  loadPercent() {
		//获取合同签约金额
		BigDecimal signingMoney=BaseHelpUtils.getBigDecimalValue(signingMoneyItem.getValue());
		if(signingMoney.compareTo(BigDecimal.ZERO)==0) {
			return;
		}
		//获取百分比
		BigDecimal percent=new BigDecimal(100);
		//获取预算总金额
		BigDecimal  bdTotalAmount=BaseHelpUtils.getBigDecimalValue(bdTotalAmountItem.getValue());
		//预算百分比
		BigDecimal bdpercent=bdTotalAmount.divide(signingMoney,2,BigDecimal.ROUND_UP).multiply(percent);
		percentItem.setValue(bdpercent);
	}
}

