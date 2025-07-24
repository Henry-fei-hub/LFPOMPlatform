package com.pomplatform.client.receivables.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.Print;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.receivables.datasource.DSIncomeMoneyForWeek;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class IncomeMoneyForWeekForm extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
	public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    private DynamicForm searchForm;
    private DelicacyListGrid oneGrid;
    private DelicacyListGrid twoGrid;
    
    private TextItem contractNameItem;
    private DateItem startDateItem;
    private DateItem endDateItem;
    
    private final IButton searchButton;
    private final IButton refreshButton;
    private final IButton printButton;
    private final IButton exportButton;
  
	private VLayout mainLayout;
	private HLayout searchLayout;
	private HLayout itemsLayout;
	private HLayout buttonLayout;
	private HLayout contentLayout;
	private VLayout leftLayout;
	private HLayout oneLayout;
	private HLayout twoLayout;
	private VLayout rightLayout;
	
	public IncomeMoneyForWeekForm() {
    	
		mainLayout = new VLayout(10);
		mainLayout.setWidth100();
		mainLayout.setHeight100();
    	
		searchLayout = new HLayout(10);
		searchLayout.setWidth100();
		searchLayout.setHeight("5%");
		searchLayout.setBackgroundColor("#e2e2e2");
		
		itemsLayout = new HLayout(10);
		itemsLayout.setWidth("80%");
		itemsLayout.setHeight100();
		
		contractNameItem = new TextItem("contractName", "项目名称");
		contractNameItem.setWidth("*");
        
		Date date = new Date();
		int startDay = date.getDate()-7;
		date.setDate(startDay);
		startDateItem = new DateItem("startDate","开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setDefaultValue(date);
        
		endDateItem = new DateItem("month","截止日期");
		endDateItem.setWidth("*");
		endDateItem.setDefaultValue(new Date());
		endDateItem.setUseTextField(true);
        
        searchForm = new DynamicForm();
        searchForm.setWidth100();
        searchForm.setHeight100();
        searchForm.setNumCols(6);
        searchForm.setMargin(10);
        searchForm.setItems(startDateItem,endDateItem);
        itemsLayout.addMember(searchForm);
    	
        searchButton = new IButton("搜索");
        refreshButton = new IButton("重置");
        //搜索按钮
        searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				startEdit();
			}
		});
        
        //重置按钮
        refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				searchForm.editNewRecord();
			}
		});
        
        buttonLayout = new HLayout(10);
        buttonLayout.setWidth("20%");
        buttonLayout.setHeight100();
        buttonLayout.setLayoutTopMargin(10);
        buttonLayout.addMember(searchButton);
        buttonLayout.addMember(refreshButton);
        
        searchLayout.addMember(itemsLayout);
        searchLayout.addMember(buttonLayout);
        mainLayout.addMember(searchLayout);
        
        contentLayout = new HLayout(10);
        contentLayout.setWidth100();
        contentLayout.setHeight("90%");
        
        leftLayout = new VLayout(10);
        leftLayout.setWidth("94%");
        leftLayout.setHeight("96%");
        leftLayout.setMembersMargin(30);
        contentLayout.addMember(leftLayout);
        
        oneLayout = new HLayout(10);
        oneLayout.setHeight("60%");
        oneLayout.setWidth100();
        oneLayout.setIsGroup(true);
        oneLayout.setGroupTitle("设计费");
        oneLayout.setGroupBorderCSS(layoutGroupStyle);
        oneLayout.setGroupLabelBackgroundColor("#555555");
        oneLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		
		oneGrid = new DelicacyListGrid();
		oneGrid.setShowRowNumbers(true);
		oneGrid.setAutoFitFieldWidths(false); 
		oneGrid.setDataSource(DSIncomeMoneyForWeek.getInstance());
		int indexOne = 0;
        ListGridField [] fieldsOne = new ListGridField[5];
        fieldsOne[indexOne] = new ListGridField("contractName");
        fieldsOne[indexOne].setWidth("30%");
		indexOne++;
		fieldsOne[indexOne] = new ListGridField("borrowMoney");
		fieldsOne[indexOne].setWidth("20%");
		indexOne++;
		fieldsOne[indexOne] = new ListGridField("signingMoneySum");
		fieldsOne[indexOne].setWidth("20%");
		indexOne++;
		fieldsOne[indexOne] = new ListGridField("percent");
		fieldsOne[indexOne].setWidth("10%");
		indexOne++;
		fieldsOne[indexOne] = new ListGridField("remark");
		fieldsOne[indexOne].setWidth("20%");
		oneGrid.setFields(fieldsOne);
		oneGrid.setAutoFitFieldWidths(false);
		oneGrid.setShowGridSummary(true);
		oneLayout.addMember(oneGrid);
		leftLayout.addMember(oneLayout);
        
		twoLayout = new HLayout(10);
		twoLayout.setHeight("40%");
		twoLayout.setWidth100();
		twoLayout.setIsGroup(true);
		twoLayout.setGroupTitle("其他费用");
		twoLayout.setGroupBorderCSS(layoutGroupStyle);
		twoLayout.setGroupLabelBackgroundColor("#555555");
		twoLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		
		twoGrid = new DelicacyListGrid();
		twoGrid.setShowRowNumbers(true);
		twoGrid.setAutoFitFieldWidths(false);  
		twoGrid.setDataSource(DSIncomeMoneyForWeek.getInstance());
		int index = 0;
        ListGridField [] fields = new ListGridField[4];
		fields[index] = new ListGridField("moneyAttribute");
		index++;
		fields[index] = new ListGridField("otherName");
		index++;
		fields[index] = new ListGridField("borrowMoney");
		index++;
		fields[index] = new ListGridField("remark");
		twoGrid.setFields(fields);
		twoGrid.setAutoFitFieldWidths(false);
		twoGrid.setShowGridSummary(true);
		twoLayout.addMember(twoGrid);
		leftLayout.addMember(twoLayout);
		
		rightLayout = new VLayout(10);
		rightLayout.setWidth("6%");
		rightLayout.setHeight100();
		rightLayout.setBackgroundColor("#e2e2e2");
		rightLayout.setLayoutMargin(5);
		rightLayout.setLayoutTopMargin(10);
		contentLayout.addMember(rightLayout);
		
		printButton = new IButton("打印");
		printButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int startMonth = ((Date)startDateItem.getValue()).getMonth();
				int endMonth = ((Date)endDateItem.getValue()).getMonth();
				if(startMonth != endMonth){
					return;
				}
				Map<String,Object> param = new HashMap<>();
				if(!BaseHelpUtils.isNullOrEmpty(startDateItem.getValue())){
					param.put("startDate", startDateItem.getValue());
		    	}
		    	if(!BaseHelpUtils.isNullOrEmpty(endDateItem.getValue())){
		    		param.put("endDate", endDateItem.getValue());
		    	}
		    	OnPrintIncomeMoneyForWeek printHtml = new OnPrintIncomeMoneyForWeek();
		    	Record[] records = oneGrid.getRecords();
		    	int length = records.length;
		    	for(Record e : twoGrid.getRecords()){
		    		records[length] = e;
		    		length++;
		    	}
		    	if(!BaseHelpUtils.isNullOrEmpty(totalRecords)){
		    		param.put("contractMoney", totalRecords.getAttribute("contractMoney"));
		    		param.put("rentMoney", totalRecords.getAttribute("rentMoney"));
		    		param.put("subsidyMoney", totalRecords.getAttribute("subsidyMoney"));
		    	}
		    	if(!BaseHelpUtils.isNullOrEmpty(yearTotalRecords)){
		    		param.put("yearContractMoney", yearTotalRecords.getAttribute("yearContractMoney"));
		    		param.put("yearRentMoney", yearTotalRecords.getAttribute("yearRentMoney"));
		    		param.put("yearSubsidyMoney", yearTotalRecords.getAttribute("yearSubsidyMoney"));
		    	}
		    	printHtml.setRecords(records);
				printHtml.setPrintData(param);
				Print.it(printHtml.generatePrintHTML());
			}
		});
		rightLayout.addMember(printButton);
		
		exportButton = new IButton("导出");
		rightLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				int startMonth = ((Date)startDateItem.getValue()).getMonth();
				int endMonth = ((Date)endDateItem.getValue()).getMonth();
				if(startMonth != endMonth){
					return;
				}
				Map<String,Object> condition = new HashMap<>();
				if(!BaseHelpUtils.isNullOrEmpty(startDateItem.getValue())){
					condition.put("startDate", DateUtil.format((Date)startDateItem.getValue()));
		    	}
		    	if(!BaseHelpUtils.isNullOrEmpty(endDateItem.getValue())){
		    		Date endDate = (Date)endDateItem.getValue();
		    		endDate.setHours(23);
		    		endDate.setMinutes(59);
		    		endDate.setSeconds(59);
		    		condition.put("endDate", endDate);
		    	}
		    	if(!BaseHelpUtils.isNullOrEmpty(totalRecords)){
		    		condition.put("contractMoney", totalRecords.getAttribute("contractMoney"));
		    		condition.put("rentMoney", totalRecords.getAttribute("rentMoney"));
		    		condition.put("subsidyMoney", totalRecords.getAttribute("subsidyMoney"));
		    	}
		    	if(!BaseHelpUtils.isNullOrEmpty(yearTotalRecords)){
		    		condition.put("yearContractMoney", yearTotalRecords.getAttribute("yearContractMoney"));
		    		condition.put("yearRentMoney", yearTotalRecords.getAttribute("yearRentMoney"));
		    		condition.put("yearSubsidyMoney", yearTotalRecords.getAttribute("yearSubsidyMoney"));
		    	}
				DBDataSource.downloadFile("DW_OnExportIncomeWeekMoney", condition);
			}
		});
		
		mainLayout.addMember(contentLayout);
    	addMember(mainLayout);
    	
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public void startEdit() {
    	Map<String,Object> map = new HashMap<>();
    	if(!BaseHelpUtils.isNullOrEmpty(startDateItem.getValue())){
    		map.put("startDate", DateUtil.format((Date)startDateItem.getValue()));
    	}
    	if(!BaseHelpUtils.isNullOrEmpty(endDateItem.getValue())){
    		Date endDate = (Date)endDateItem.getValue();
    		endDate.setHours(23);
    		endDate.setMinutes(59);
    		endDate.setSeconds(59);
    		map.put("endDate", endDate);
    	}
    	DBDataSource.callOperation("NQ_IncomeMoneyForWeek", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					ArrayList<Record> aList = new ArrayList<>();
					ArrayList<Record> bList = new ArrayList<>();
					for(Record e : records){
						int type = BaseHelpUtils.getIntValue(e.getAttribute("moneyAttribute"));
						if(type == 1){//合同款
							aList.add(e);
						}else{
							bList.add(e);
						}
					}
					Record aa = new Record();
					Record maAa = new Record();
					Map<String,Record> ma = new HashMap<>();
					for(int i = 0;i < aList.size();i++){
						aa = aList.get(i);
						String contractId = aa.getAttribute("contractId");
						if(ma.containsKey(contractId)){
							maAa = ma.get(contractId);
							BigDecimal borrowMoney1 = BaseHelpUtils.getBigDecimalValue(maAa.getAttribute("borrowMoney"));
							BigDecimal borrowMoney2 = BaseHelpUtils.getBigDecimalValue(aa.getAttribute("borrowMoney"));
							String remark1 = maAa.getAttribute("remark");
							String remark2 = aa.getAttribute("remark");
							maAa.setAttribute("borrowMoney",borrowMoney1.add(borrowMoney2));
							if(remark1 != remark2){
								maAa.setAttribute("remark",remark1+"，"+remark2);
							}
							ma.put(contractId, maAa);
						}else{
							ma.put(contractId, aa);
						}
					}
					Record[] contractMoney = new Record[ma.size()];
					int a = 0;
					for(String key : ma.keySet()){
						contractMoney[a] = ma.get(key);
						a++;
					}
					Record[] otherMoney = new Record[bList.size()];
					for(int i = 0;i < bList.size();i++){
						otherMoney[i] = bList.get(i);
					}
					oneGrid.setData(contractMoney);
					twoGrid.setData(otherMoney);
				}
			}
		});
    	//获取月汇总数
    	Map<String,Object> params = new HashMap<>();
    	Date date = (Date)endDateItem.getValue();
    	date.setHours(23);
    	date.setMinutes(59);
    	date.setSeconds(59);
    	params.put("endDate", date);
    	Date firstDate = (Date)endDateItem.getValue();
    	firstDate.setDate(1);
    	params.put("firstDate", DateUtil.format(firstDate));
    	DBDataSource.callOperation("NQ_GetTotalContractAndRentMoney", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					setTotalRecords(dsResponse.getData()[0]);
				}
			}
		});
    	//获取年汇总数
    	params = new HashMap<>();
//    	Date currentDate = new Date();
    	Date endDate = endDateItem.getValueAsDate();
    	params.put("year", endDate.getYear() + 1900);
    	params.put("happenDate", date);
    	DBDataSource.callOperation("NQ_Mcapitalhyhor", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					setYearTotalRecords(dsResponse.getData()[0]);
				}
			}
		});
    }
    
    private Record totalRecords;
    private Record yearTotalRecords;
    
	public Record getYearTotalRecords() {
		return yearTotalRecords;
	}

	public void setYearTotalRecords(Record yearTotalRecords) {
		this.yearTotalRecords = yearTotalRecords;
	}

	public Record getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Record totalRecords) {
		this.totalRecords = totalRecords;
	}

	@Override
    public boolean checkData() {
        return true;
    }

	@Override
	public Map getValuesAsMap() {
		return null;
	}

}
