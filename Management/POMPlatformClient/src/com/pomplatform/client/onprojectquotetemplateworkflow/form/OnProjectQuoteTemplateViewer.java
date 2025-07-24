package com.pomplatform.client.onprojectquotetemplateworkflow.form;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.DataChangedEvent;
import com.smartgwt.client.widgets.grid.events.DataChangedHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.onprojectquotetemplateworkflow.datasource.DSOnProjectQuoteTemplate;
import com.pomplatform.client.onprojectquotetemplateworkflow.datasource.DSProjectQuoteDetail;

public class OnProjectQuoteTemplateViewer extends AbstractDetailViewer
{
	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private SelectItem projectTypeItem; 
	private SelectItem projectQuoteTemplatesParentIdItem; 
	private SelectItem customerTypeItem;
	private TextItem totalBuildingAreasItem;
	private TextItem provinceItem;
	private TextItem cityItem;
	private  DynamicForm form;
	private  DynamicForm topLeftForm;
	private  DynamicForm topRightForm;
	private TextItem competitionNameItem;
	private Label TitleView;
	private VLayout mainLayout;
	private VLayout formLayout;
	private HLayout topLayout;
	private HLayout topRightLayout;
	private HLayout topLeftLayout;
	private HLayout btnLayout;
	private TextAreaItem  remarkItem;
	private DoubleItem  basicAmountItem;//基准总额
	private DoubleItem  totalAmountItem;//小计总额
	private DoubleItem  upAmountItem;//上浮金额
	private DoubleItem  upPercentItem;//上浮系数
	private DoubleItem  preferentialAmountItem;//优惠金额
	private DoubleItem  perferentialPercentItem;//优惠系数
	private DoubleItem  specialDiscountAmountItem;//特殊折扣金额
	private DoubleItem  specialDiscountPercentItem;//特殊折扣系数
	private DoubleItem  finalAmountItem;//不含税合计
	private DoubleItem  finalPercentItem;//最终系数
	private DoubleItem  taxAmountItem;//税率
	private DoubleItem  getTaxAmountItem;//设计上税金额
	private DoubleItem  otherTaxAmountItem;//采买税率（其他）
	private DoubleItem  getOtherTaxAmountItem;//采买上税金额
	private DoubleItem  taxFinalAmountItem;//含税合计
	private DoubleItem  DesignPriceItem;//设计合计金额 
	private DoubleItem  ALLBuyPriceItem;//采买合计金额
	private TextItem   projectIdItem;//项目id

	private DelicacyListGrid grid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;


	public OnProjectQuoteTemplateViewer() {
	}

	@Override
	public void initComponents() {
		DSOnProjectQuoteTemplate ds = DSOnProjectQuoteTemplate.getInstance();
		mainLayout=new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		formLayout = new VLayout();
		formLayout.setHeight100();
		formLayout.setMembersMargin(5);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		mainLayout.addMember(formLayout);



		TitleView = new Label();
		TitleView.setContents("<font style=\"color:red;font-size:18px;font-weight:bold;\">项目报价</font>");
		TitleView.setWidth("100%");
		TitleView.setHeight("5%");
		TitleView.setAlign(Alignment.CENTER);
		formLayout.addMember(TitleView);

		projectTypeItem=new SelectItem("projectType","业态");
		projectTypeItem.setCanEdit(false);
		KeyValueManager.loadValueMap("pre_business_type",projectTypeItem);
		projectTypeItem.setWidth("*");


		projectQuoteTemplatesParentIdItem=new SelectItem("ProjectQuoteTemplatesParentId","报价模板");
		projectQuoteTemplatesParentIdItem.setCanEdit(true);
		projectQuoteTemplatesParentIdItem.setWidth("*");


		totalBuildingAreasItem=new TextItem("totalBuildingAreas","建筑面积");
		totalBuildingAreasItem.setCanEdit(false);
		totalBuildingAreasItem.setWidth("*");

		customerTypeItem=new SelectItem("CustomerType","客户类型");
		customerTypeItem.setCanEdit(false);
		customerTypeItem.setWidth("*"); 

		competitionNameItem=new TextItem("competitionName","竞争单位");
		competitionNameItem.setCanEdit(false);
		competitionNameItem.setWidth("*");


		provinceItem=new TextItem("province","省份");
		provinceItem.setCanEdit(false);
		provinceItem.setWidth("*");

		cityItem=new TextItem("city","城市");
		cityItem.setCanEdit(false);
		cityItem.setWidth("*");

		projectIdItem=new TextItem("preProjectId","项目ID");
		projectIdItem.setCanEdit(false);
		projectIdItem.setWidth("*");
		projectIdItem.setHidden(true);



		form = new DynamicForm();
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setCanEdit(false);
		form.setMargin(2);
		form.setWidth100();
		form.setHeight("15%");


		form.setItems(projectTypeItem,projectQuoteTemplatesParentIdItem,totalBuildingAreasItem,customerTypeItem,competitionNameItem,provinceItem,cityItem,projectIdItem);
		form.setNumCols(14);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		formLayout.addMember(form);

		basicAmountItem=new DoubleItem("basicAmount","基准总额");
		basicAmountItem.setFormat("#,###,###,###,###,##0.00");
		basicAmountItem.setHint("各项根据预设价格*面积的总和");
		basicAmountItem.setShowHintInField(true);
		basicAmountItem.setWidth("*");

		totalAmountItem=new DoubleItem("totalAmount","小计总额");
		totalAmountItem.setFormat("#,###,###,###,###,##0.00");
		totalAmountItem.setHint("小计全部相加");
		totalAmountItem.setShowHintInField(true);
		totalAmountItem.setWidth("*");

		upAmountItem=new DoubleItem("upAmount","上浮金额");
		upAmountItem.setFormat("#,###,###,###,###,##0.00");
		upAmountItem.setHint("小计总额-基准总额");
		upAmountItem.setShowHintInField(true);
		upAmountItem.setWidth("*");

		upPercentItem=new DoubleItem("upPercent","上浮系数");
		upPercentItem.setFormat("#,###,###,###,###,##0.00");
		upPercentItem.setHint("（小计总额-基准总额）/基准总额");
		upPercentItem.setShowHintInField(true);
		upPercentItem.setWidth("*");

		preferentialAmountItem=new DoubleItem("preferentialAmount","优惠金额"); 
		preferentialAmountItem.setFormat("#,###,###,###,###,##0.00");
		preferentialAmountItem.setHint("基准总额-小计总额");
		preferentialAmountItem.setShowHintInField(true);
		preferentialAmountItem.setWidth("*");


		perferentialPercentItem=new DoubleItem("perferentialPercent","优惠系数");
		perferentialPercentItem.setHint("（基准总额-小计总额）/基准总额");
		perferentialPercentItem.setShowHintInField(true);
		perferentialPercentItem.setWidth("*");

		specialDiscountAmountItem=new DoubleItem("specialDiscountAmount","特殊折扣金额");
		specialDiscountAmountItem.setFormat("#,###,###,###,###,##0.00");
		specialDiscountAmountItem.setHint("可手动输入特殊折扣金额");
		specialDiscountAmountItem.setShowHintInField(true);
		specialDiscountAmountItem.setWidth("*");

		specialDiscountPercentItem=new DoubleItem("specialDiscountPercent","特殊折扣系数");
		specialDiscountPercentItem.setHint("特殊折扣系数=特殊折扣/基准总价");
		specialDiscountPercentItem.setShowHintInField(true);
		specialDiscountPercentItem.setWidth("*");

		finalAmountItem=new DoubleItem("finalAmount","不含税合计金额"); 
		finalAmountItem.setFormat("#,###,###,###,###,##0.00");
		finalAmountItem.setWidth("*");

		DesignPriceItem =new DoubleItem("DesignPrice","设计不含税合计"); 
		DesignPriceItem.setFormat("#,###,###,###,###,##0.00");
		DesignPriceItem.setWidth("*");

		ALLBuyPriceItem=new DoubleItem("ALLBuyPrice","采买不含税合计");
		ALLBuyPriceItem.hide();
		ALLBuyPriceItem.setFormat("#,###,###,###,###,##0.00");
		ALLBuyPriceItem.setWidth("*");

		finalPercentItem=new DoubleItem("finalPercent","最终优惠系数");
		finalPercentItem.setWidth("*");

		taxAmountItem=new DoubleItem("taxAmount","税率(%)");
		taxAmountItem.setWidth("*");

		getTaxAmountItem=new DoubleItem("getTaxAmount","设计上税金额");
		getTaxAmountItem.setFormat("#,###,###,###,###,##0.00");
		getTaxAmountItem.setWidth("*");

		getOtherTaxAmountItem=new DoubleItem("getOtherTaxAmount","采买上税金额");
		getOtherTaxAmountItem.hide();
		getOtherTaxAmountItem.setFormat("#,###,###,###,###,##0.00");
		getOtherTaxAmountItem.setWidth("*");


		otherTaxAmountItem=new DoubleItem("otherTaxAmount","采买税率(%)");
		otherTaxAmountItem.hide();
		otherTaxAmountItem.setHint("需要手动填写");
		otherTaxAmountItem.setShowHintInField(true);
		otherTaxAmountItem.setWidth("*");


		taxFinalAmountItem=new DoubleItem("taxFinalAmount","含税合计金额");
		taxFinalAmountItem.setFormat("#,###,###,###,###,##0.00");
		taxFinalAmountItem.setWidth("*");

		topRightForm = new DynamicForm();
		topRightForm.setAlign(Alignment.RIGHT);
		topRightForm.setPadding(5);
		topRightForm.setMargin(2);
		topRightForm.setCanEdit(false);
		otherTaxAmountItem.setCanEdit(true);
		specialDiscountAmountItem.setCanEdit(true);
		topRightForm.setWidth100();
		topRightForm.setNumCols(4);
		topRightForm.setHeight("100%");
		topRightForm.setCanEdit(false);
		topRightForm.setItems(basicAmountItem,totalAmountItem,upAmountItem,upPercentItem,preferentialAmountItem,perferentialPercentItem,specialDiscountAmountItem,specialDiscountPercentItem,finalAmountItem,finalPercentItem,DesignPriceItem,ALLBuyPriceItem,taxAmountItem,otherTaxAmountItem,getTaxAmountItem,getOtherTaxAmountItem,taxFinalAmountItem);

		grid=new DelicacyListGrid () {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				record.setAttribute("addChoose","add.png");
				return super.getCellCSSText(record, rowNum, colNum);
			}
		};
		grid.setWidth("100%");
		grid.setHeight("100%");
		int a=0;
		ListGridRecord listRecord=new ListGridRecord();
		ListGridField[] aFields = new ListGridField[6];
		aFields[a] = new ListGridField("addChoose","新增");
		aFields[a].setWidth("10%");
		aFields[a].setAlign(Alignment.CENTER); 
		aFields[a].setType(ListGridFieldType.IMAGE);  
		aFields[a].setImageHeight(15);
		aFields[a].setImageWidth(15);
		aFields[a].addRecordClickHandler(new RecordClickHandler() {
			@Override
			public void onRecordClick(RecordClickEvent event) {
				int rownum=event.getRecordNum();

			}
		});
		a++;
		aFields[a] = new ListGridField("designTypeName","设计类型");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("designContent","设计内容");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		aFields[a].setWidth("25%");
		a++;
		aFields[a] = new ListGridField("remark","补充说明");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("35%");
		a++;
		aFields[a] = new ListGridField("designStage","设计阶段");
		aFields[a].setAlign(Alignment.CENTER);
		ComboBoxItem stageIdBoxItem = new ComboBoxItem();
		stageIdBoxItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("system_dictionary_7", aFields[a]);
		aFields[a].setEditorProperties(stageIdBoxItem);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("areaType","面积类型");
		ComboBoxItem areaTypeItem = new ComboBoxItem();
		areaTypeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("system_dictionary_203", aFields[a]);
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setDefaultValue(new Date());
		a++;
		aFields[a] = new ListGridField("area","面积");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setWidth("25%");
		aFields[a].setDefaultValue(new Date());
		a++;
		aFields[a] = new ListGridField("areaPrice","单价");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		aFields[a].addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				int rowNum=event.getRowNum();
				Record record=grid.getRecord(rowNum);
				//获取面积
				BigDecimal area=BaseHelpUtils.getBigDecimalValue(record.getAttribute("area"));
				//获取单价
				BigDecimal areaPrice=BaseHelpUtils.getBigDecimalValue(event.getValue());
				//小计
				BigDecimal totalPrice=BaseHelpUtils.getBigDecimalValue(area.multiply(areaPrice));
				event.getForm().getItem("totalPrice").setValue(totalPrice);

			}
		}); 
		a++;
		aFields[a] = new ListGridField("totalPrice","小计");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);  
		a++;
		aFields[a] = new ListGridField("companyId","归属公司");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		KeyValueManager.loadValueMap("company_records", aFields[a]);
		grid.setFields(aFields);
		grid.setCanResizeFields(true);  
		grid.setCanRemoveRecords(true);
		grid.setShowRecordComponents(true);          
		grid.setShowRecordComponentsByCell(true);
		grid.setAutoFitFieldWidths(false);
		grid.setShowGridSummary(true);
		grid.setCanEdit(false);
		grid.setDataSource(DSProjectQuoteDetail.getInstance());
		grid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("项目报价详情表");
				detail.setWidth(700); detail.setHeight(500); 
				ProjectQuoteDetailViewer viewer = new ProjectQuoteDetailViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});

		formLayout.addMember(grid);

		topLayout=new HLayout();
		topLayout.setWidth("100%");
		topLayout.setHeight("35%");
		mainLayout.addMember(topLayout);

		topLeftLayout=new HLayout();
		topLeftLayout.setHeight100();
		topLeftLayout.setWidth("40%");
		topLayout.addMember(topLeftLayout);

		topRightLayout=new HLayout();
		topRightLayout.setHeight100();
		topRightLayout.setWidth("60%");
		topLayout.addMember(topRightLayout);


		topRightLayout.addMember(topRightForm);

		remarkItem=new TextAreaItem("remark","备注:");
		remarkItem.setLength(500);
		remarkItem.setWidth("*");

		topLeftForm = new DynamicForm();
		topLeftForm.setAlign(Alignment.LEFT);
		topLeftForm.setPadding(15);
		topLeftForm.setMargin(2);
		topLeftForm.setWidth100();
		topLeftForm.setCanEdit(false);
		topLeftForm.setHeight("100%");
		topLeftForm.setItems(remarkItem);
		topLeftLayout.addMember(topLeftForm);

		addMember(mainLayout);
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "项目报价表";
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
		params.put("projectQuoteId", getBusinessId());
		DBDataSource.callOperation("NQ_OnProjectQuoteTemplate", "find", new DSCallback() {
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

	@SuppressWarnings("unchecked")
	public void viewDetailData(){
		Record selected = getRecord();
		__logger.info("selected+++++++++++++++++++++++++++++++++"+selected.toMap());
		java.util.Map condition = null;
		java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap() : __parentSearchForm.getValues();
		condition = new java.util.HashMap();
		//获取项目ID
		int projectId=BaseHelpUtils.getIntValue(selected.getAttribute("projectId")); 
		condition.put("preProjectId", projectId);
		Record record=SyncDataUtil.getValueByTableName("ST_PreProject", "find",condition);
		String infoCode=BaseHelpUtils.getString(record.getAttribute("infoCode"));
		condition.put("infoCode", infoCode);
		Record records=SyncDataUtil.getValueByTableName("NQ_projectPreInfomations", "find",condition);
		form.editRecord(records);
		String  customerName=BaseHelpUtils.getString(record.getAttribute("customerName"));
		Map<String, Object> maps = new HashMap<>();
		maps.put("customerName",customerName);
		Record recordss=SyncDataUtil.getValueByTableName("ST_Customer", "find", maps);
		int customerType=BaseHelpUtils.getIntValue(recordss.getAttribute("customerType"));
		customerTypeItem.setValue(customerType);
		KeyValueManager.loadValueMap("system_dictionary_151", customerTypeItem);

		condition.put("projectQuoteId", selected.getAttributeAsString("projectQuoteId"));
		DBDataSource.callOperation("ST_ProjectQuoteDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					grid.setData(dsResponse.getData());
				}
			}
		});

		DBDataSource.callOperation("ST_ProjectQuote", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					topRightForm.editRecord(dsResponse.getData()[0]);
					topLeftForm.editRecord(dsResponse.getData()[0]);
				}
			}
		});

		//获取模板父级ID
		int projectQuoteTemplatesParentId=BaseHelpUtils.getIntValue(selected.getAttribute("projectQuoteTemplatesParentId"));
		condition.put("projectQuoteTemplatesParentId",projectQuoteTemplatesParentId);
		Record quoteRecord=SyncDataUtil.getValueByTableName("ST_ProjectQuoteTemplatesParent", "find", maps);
		String parentName=BaseHelpUtils.getString(quoteRecord.getAttribute("parentName"));
		LinkedHashMap<Integer, String> linkmap=new LinkedHashMap<>();
		linkmap.put(projectQuoteTemplatesParentId, parentName);
		projectQuoteTemplatesParentIdItem.setValue(projectQuoteTemplatesParentId);
		projectQuoteTemplatesParentIdItem.setValueMap(linkmap);
		

	}

	@Override
	public DataSource getMainDataSource() {
		return DSOnProjectQuoteTemplate.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		//res.add(projectQuoteDetailsGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		//res.add("项目报价详情表");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

