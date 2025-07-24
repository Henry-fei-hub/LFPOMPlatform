package com.pomplatform.client.capitaldistribution.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.capitaldistribution.datasource.DSCapitalDifference;
import com.pomplatform.client.capitaldistribution.form.CapitalDistributionAnalyzeSearchForm;
import com.pomplatform.client.common.ClientStaticUtils;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CapitalDistributionAnalyzePanel extends VLayout{
	
	private static final Logger logger = Logger.getLogger("");
	
	private CapitalDistributionAnalyzeSearchForm searchForm;
	private DelicacyListGrid leftGrid;
	private DelicacyListGrid rightGrid;
	private String contents = "<div><p style='display:inline-block;width:250px;text-align:right;'>账单流水[合同款，保理+商票]总额：</p><input type='text' value='capitalAmount' style='border:none;border-bottom:1px solid #000;text-align:right;' readonly='true'><br>"
    		+ "<p style='display:inline-block;width:250px;text-align:right;margin:0;'>回款分配：</p><input type='text' value='distributionAmount' style='border:none;border-bottom:1px solid #000;text-align:right;' readonly='true'><br>"
    		+ "<p style='display:inline-block;width:250px;text-align:right;'>部门回款分配：</p><input type='text' value='departmentAmount' style='border:none;border-bottom:1px solid #000;text-align:right;' readonly='true'><br></div>";
	private HTMLPane htmlPane;
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			CapitalDistributionAnalyzePanel cm = new CapitalDistributionAnalyzePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CapitalDistributionAnalyze";
		}

	}
	
	public CapitalDistributionAnalyzePanel(){
		setWidth100();
        setHeight100();
        initComponents();
	}
	
	public void initComponents() {
		HLayout topLayout = new HLayout();
		topLayout.setWidth100();
		topLayout.setRight(70);
		topLayout.setLayoutTopMargin(5);
		topLayout.setLayoutLeftMargin(10);
		topLayout.setMembersMargin(10);
		addMember(topLayout);
		
		htmlPane = new HTMLPane();  
        htmlPane.setWidth("40%");  
        htmlPane.setHeight(130);
        htmlPane.setShowEdges(false);  
        htmlPane.setSelectContentOnSelectAll(true);  
        
        topLayout.addMember(htmlPane);
		
		VLayout serchLayout = new VLayout();
		serchLayout.setWidth("50%");
		topLayout.addMember(serchLayout);
		
		searchForm = new CapitalDistributionAnalyzeSearchForm();
		searchForm.setHeight(65);
		serchLayout.addMember(searchForm);
		
		HLayout buttonLayout = new HLayout();
		buttonLayout.setWidth("50%");
		buttonLayout.setHeight(65);
		buttonLayout.setMembersMargin(10);
		buttonLayout.setLayoutTopMargin(15);
		buttonLayout.setLayoutLeftMargin(5);
		serchLayout.addMember(buttonLayout);
		
		IButton searchButton = new IButton("搜索");
		searchButton.setBaseStyle("customButton");
		searchButton.setWidth(130);
		buttonLayout.addMember(searchButton);
		searchButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				loadData();
			}
		});
		
		
		IButton resetButton = new IButton("重置");
		resetButton.setBaseStyle("customButton");
		resetButton.setWidth(130);
		buttonLayout.addMember(resetButton);
		resetButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				searchForm.editNewRecord();
			}
		});
		
		IButton downloadLeftButton = new IButton("导出左边列表数据");
		downloadLeftButton.setBaseStyle("customButton");
		downloadLeftButton.setWidth(130);
		buttonLayout.addMember(downloadLeftButton);
		downloadLeftButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map map = generateLeftCriteria();
				DBDataSource.downloadFile("DW_CapitalDifference", map);
			}
		});
		
		IButton downloadRightButton = new IButton("导出右边列表数据");
		downloadRightButton.setBaseStyle("customButton");
		downloadRightButton.setWidth(130);
		buttonLayout.addMember(downloadRightButton);
		downloadRightButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map map = generateRightCriteria();
				DBDataSource.downloadFile("DW_CapitalDifference", map);
			}
		});
		
		
		HLayout contentLayout = new HLayout();
		contentLayout.setWidth100();
		contentLayout.setHeight("95%");
		addMember(contentLayout);
		
		VLayout contentLeft = new VLayout();
		contentLeft.setWidth("50%");
		contentLeft.setBackgroundColor("#f60");
		contentLayout.addMember(contentLeft);
		
		leftGrid = new DelicacyListGrid();
		leftGrid.setDataSource(DSCapitalDifference.getInstance());
		leftGrid.setAutoFitFieldWidths(false);
		leftGrid.setShowGridSummary(true);
		leftGrid.setTitle("账单流水和回款分配的差异明细");
		leftGrid.setHeaderHeight(60);
		leftGrid.setHeaderSpans(new HeaderSpan[] {
				new HeaderSpan("账单流水和回款分配的差异明细", new String[] { "happenDate", "borrowMoney", "remark", "contractCode", "contractName" }) });
		ListGridField[] leftFields = new ListGridField[5];
		int leftIndex = 0;
		leftFields[leftIndex] = new ListGridField("happenDate");
		leftFields[leftIndex].setShowGridSummary(false);
		leftFields[leftIndex++].setWidth(100);
		leftFields[leftIndex++] = new ListGridField("borrowMoney");
		leftFields[leftIndex] = new ListGridField("remark");
		leftFields[leftIndex++].setShowGridSummary(false);
		leftFields[leftIndex] = new ListGridField("contractCode");
		leftFields[leftIndex++].setShowGridSummary(false);
		leftFields[leftIndex] = new ListGridField("contractName");
		leftFields[leftIndex].setShowGridSummary(false);
		leftGrid.setFields(leftFields);
		contentLeft.addMember(leftGrid);
		
		VLayout contentRight = new VLayout();
		contentRight.setWidth("50%");
		contentRight.setBackgroundColor("black");
		contentLayout.addMember(contentRight);
		
		rightGrid = new DelicacyListGrid();
		rightGrid.setDataSource(DSCapitalDifference.getInstance());
		rightGrid.setAutoFitFieldWidths(false);
		rightGrid.setShowGridSummary(true);
		rightGrid.setTitle("回款分配和部门回款分配的差异明细");
		rightGrid.setHeaderHeight(60);
		rightGrid.setHeaderSpans(new HeaderSpan[] {
				new HeaderSpan("回款分配和部门回款分配的差异明细", new String[] { "happenDate", "borrowMoney", "leftAmount", "remark", "contractCode", "contractName" }) });
		ListGridField[] rightFields = new ListGridField[5];
		int rightIndex = 0;
		rightFields[rightIndex] = new ListGridField("happenDate");
		rightFields[rightIndex].setShowGridSummary(false);
		rightFields[rightIndex++].setWidth(100);
		rightFields[rightIndex] = new ListGridField("borrowMoney");
		rightFields[rightIndex++].setShowGridSummary(false);
		rightFields[rightIndex++] = new ListGridField("leftAmount");
		rightFields[rightIndex] = new ListGridField("remark");
		rightFields[rightIndex++].setShowGridSummary(false);
		rightFields[rightIndex] = new ListGridField("contractCode");
		rightFields[rightIndex++].setShowGridSummary(false);
		rightFields[rightIndex] = new ListGridField("contractName");
		rightFields[rightIndex].setShowGridSummary(false);
		rightGrid.setFields(rightFields);
		contentRight.addMember(rightGrid);
	}
	
	public void loadData(){
		Map map = searchForm.getValues();
		map.put("optType", "capitalDistributionAnalyze");
		DBDataSource.callOperation("EP_CapitalDistributionProcessor", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					if(!BaseHelpUtils.isNullOrEmpty(dsResponse.getAttribute("userData")) && dsResponse.getAttribute("userData").length() > 0){
						Map dataMap = dsResponse.getAttributeAsMap("userData");
						htmlPane.setContents(contents.replace("capitalAmount", BaseHelpUtils.getString(dataMap.get("capitalAmount"))).replace("distributionAmount", BaseHelpUtils.getString(dataMap.get("distributionAmount"))).replace("departmentAmount", BaseHelpUtils.getString(dataMap.get("departmentAmount"))));
						htmlPane.redraw();
					}
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
		List<Map> keyvalues = new ArrayList<>();
		Map<String, String> kv2 = new HashMap<>();
		kv2.put("key", "where a.money_attribute = ?");
		kv2.put("value", "where a.money_attribute = ? and a.money_attribute in (" + ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_1 + ", " + ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_11 + ", " + ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_13 + ")");
		keyvalues.add(kv2);
		map.put("keyValues", keyvalues);
		DBDataSource.callOperation("NQ_CapitalDifference", map, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					leftGrid.setData(new Record[0]);
					rightGrid.setData(new Record[0]);
					for(Record record : records){
						if(BaseHelpUtils.getIntValue(record.getAttributeAsObject("projectNum")) == 0){
							leftGrid.addData(record);
						}else{
							rightGrid.addData(record);
						}
					}
					leftGrid.redraw();
					rightGrid.redraw();
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
	
	public Map generateLeftCriteria(){
		Map map = searchForm.getValues();
		List<Map> keyValues = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		kv.put("key", "where a.money_attribute = ?");
		kv.put("value", "where a.money_attribute = ? and a.money_attribute in (" + ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_1 + ", " + ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_11 + ", " + ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_13 + ")");
		keyValues.add(kv);
		Map<String, String> kv1 = new HashMap<>();
		kv1.put("key", ", d.contract_code, d.contract_name ) abc");
		kv1.put("value", ", d.contract_code, d.contract_name ) abc where abc.project_num = 0");
		keyValues.add(kv1);
		map.put("keyValues", keyValues);
		return map;
	}
	
	public Map generateRightCriteria(){
		Map map = searchForm.getValues();
		List<Map> keyValues = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		kv.put("key", ", d.contract_code, d.contract_name ) abc");
		kv.put("value", ", d.contract_code, d.contract_name ) abc where abc.project_num > 0");
		keyValues.add(kv);
		Map<String, String> kv2 = new HashMap<>();
		kv2.put("key", "where a.money_attribute = ?");
		kv2.put("value", "where a.money_attribute = ? and a.money_attribute in (" + ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_1 + ", " + ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_11 + ", " + ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_13 + ")");
		keyValues.add(kv2);
		map.put("keyValues", keyValues);
		return map;
	}
}
