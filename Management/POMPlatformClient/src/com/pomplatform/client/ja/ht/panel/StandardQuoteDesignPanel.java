package com.pomplatform.client.ja.ht.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.ja.check.panel.CheckOutAllDesignConsiderationPanel;
import com.pomplatform.client.ja.ht.datasource.DSStandardQuote;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class StandardQuoteDesignPanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("");
  	
    //定义面板样式
    private final String layoutGroupStyle = "1px solid #5E9FFB;border-top-width:22px;border-radius:5px;";
    public final static String BORDER_STYLE = "1px solid #5E9FFB;border-radius:1px;border-top-width:3px";
    public final static String BORDER_STYLE2 = "0px solid #f2f2f2;border-radius:20px;border-bottom-width:1px";
    public final static String BORDER_STYLE3 = "0px solid #808080;border-right-width:2px";
    public final static String COLOR2 = "#FFF";
    public final static String COLOR3 = "#FFF";
    //定义主面板，分上下分层，top层是我的发起图片按钮，button层是我的事务层
    private VLayout mainLayout;
    //定义top层，即装载图片按钮
    private VLayout topLayout;
    //定义top层搜索栏layout
    private HLayout searchLayout;
    //定义中层
    private HLayout middleLayout;
    //定义button层
    private VLayout buttonLayout;
    //定义搜索栏表单
    private DynamicForm __searchForm; 
    //定义搜索按钮
    private IButton searchButton; 
    private IButton resetButton; 
    
    //搜索栏栏*********************************
    private DateItem startDateItem;
    private DateItem endDateItem;
    private TextItem customNameItem;
    
    private DelicacyListGrid grid;
    
    //业务类别单选框
    private RadioGroupItem businessTypeRadios;
    //项目等级单选框
    private RadioGroupItem projectLevelRadios;
    //客户等级单选框
    private RadioGroupItem customLevelRadios;
    //区域等级单选框
    private RadioGroupItem areaLevelRadios;
    //面积区间单选框
    private RadioGroupItem sizeRadios;
    
    private Label avgTitle;
    private Label zsTotalPrice;
    private Label zsPrice;
    private Label zsPricePercent;
    private Label jdTotalPrice;
    private Label jdPrice;
    private Label jdPricePercent;
    private Label dgTotalPrice;
    private Label dgPrice;
    private Label dgPricePercent;
    private Label csTotalPrice;
    private Label csPrice;
    private Label csPricePercent;
    private Label pmTotalPrice;
    private Label pmPrice;
    private Label pmPricePercent;
    private Label hjTotalPrice;
    private Label hjPrice;
    private Label hjPricePercent; 
    
    private Label maxTitle;
    private Label maxZsTotalPrice;
    private Label maxZsPrice;
    private Label maxZsPricePercent;
    private Label maxJdTotalPrice;
    private Label maxJdPrice;
    private Label maxJdPricePercent;
    private Label maxDgTotalPrice;
    private Label maxDgPrice;
    private Label maxDgPricePercent;
    private Label maxCsTotalPrice;
    private Label maxCsPrice;
    private Label maxCsPricePercent;
    private Label maxPmTotalPrice;
    private Label maxPmPrice;
    private Label maxPmPricePercent;
    private Label maxHjTotalPrice;
    private Label maxHjPrice;
    private Label maxHjPricePercent;    
    
    private Label minTitle;
    private Label minZsTotalPrice;
    private Label minZsPrice;
    private Label minZsPricePercent;
    private Label minJdTotalPrice;
    private Label minJdPrice;
    private Label minJdPricePercent;
    private Label minDgTotalPrice;
    private Label minDgPrice;
    private Label minDgPricePercent;
    private Label minCsTotalPrice;
    private Label minCsPrice;
    private Label minCsPricePercent;
    private Label minPmTotalPrice;
    private Label minPmPrice;
    private Label minPmPricePercent;
    private Label minHjTotalPrice;
    private Label minHjPrice;
    private Label minHjPricePercent;   
    
    private Label recentTitle;
    private Label recentZsTotalPrice;
    private Label recentZsPrice;
    private Label recentZsPricePercent;
    private Label recentJdTotalPrice;
    private Label recentJdPrice;
    private Label recentJdPricePercent;
    private Label recentDgTotalPrice;
    private Label recentDgPrice;
    private Label recentDgPricePercent;
    private Label recentCsTotalPrice;
    private Label recentCsPrice;
    private Label recentCsPricePercent;
    private Label recentPmTotalPrice;
    private Label recentPmPrice;
    private Label recentPmPricePercent;
    private Label recentHjTotalPrice;
    private Label recentHjPrice;
    private Label recentHjPricePercent;   
    
    public StandardQuoteDesignPanel() {
    	//主面板
    	mainLayout = new VLayout(20);
    	mainLayout.setBackgroundColor("#FFF");
    	mainLayout.setHeight(1400);
    	mainLayout.setWidth100();
    	mainLayout.setMembersMargin(20);
    	addMember(mainLayout);
    	
    	//头部面板
    	topLayout = new VLayout(20);
    	topLayout.setHeight("25%");
    	topLayout.setBorder(BORDER_STYLE);
    	topLayout.setWidth100();
    	topLayout.setMembersMargin(0);
    	mainLayout.addMember(topLayout);
    	
    	searchLayout = new HLayout(10);
    	searchLayout.setHeight("50%");
    	searchLayout.setWidth100();
    	searchLayout.setAlign(Alignment.LEFT);
    	searchLayout.setBackgroundColor("#FCE4D6");
    	
    	__searchForm = new DynamicForm();
    	__searchForm.setWidth("60%");
    	__searchForm.setHeight100();
    	__searchForm.setNumCols(6);
    	__searchForm.setMargin(5);
		ClientUtil.DynamicFormProcessAccordingToDevice(__searchForm);
		searchLayout.addMember(__searchForm);
		startDateItem = new DateItem("startDate","开始日期");
		startDateItem.setUseTextField(true);
		startDateItem.setWidth("*");
		endDateItem = new DateItem("endDate","结束日期");
		endDateItem.setUseTextField(true);
		endDateItem.setWidth("*");
		customNameItem = new TextItem("customName","客户名称");
		customNameItem.setWidth("*");
		__searchForm.setFields(startDateItem,endDateItem,customNameItem);
		
		HLayout seLayout = new HLayout(10);
		seLayout.setHeight100();
		seLayout.setWidth("40%");
		seLayout.setLayoutTopMargin(10);
		seLayout.setAlign(Alignment.LEFT);
		searchButton= new IButton("搜索");
		seLayout.addMember(searchButton);
		resetButton= new IButton("重置");
		seLayout.addMember(resetButton);
		searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				startEdit();
			}
		});
		resetButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				startDateItem.setValue("");
				endDateItem.setValue("");
				customNameItem.setValue("");
			}
		});
		
		searchLayout.addMember(seLayout);
		topLayout.addMember(searchLayout);
		
		HLayout businessTypeLayout = new HLayout();
		businessTypeLayout.setWidth100();
		businessTypeLayout.setHeight("15%");
		businessTypeLayout.setBorder(BORDER_STYLE2);
		topLayout.addMember(businessTypeLayout);
		
		Label businessTypeNo = new Label();
		businessTypeNo.setContents("不限");
		businessTypeNo.setStyleName("customlabelView");
		businessTypeLayout.addMember(businessTypeNo);
		businessTypeNo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				businessTypeRadios.setValue("");
			}
		});
		
		VLayout businessTypeClassLayout = new VLayout(10);
		businessTypeClassLayout.setLayoutLeftMargin(10);
		businessTypeLayout.addMember(businessTypeClassLayout);
		
		HLayout businessTypeTitleLayout = new HLayout();
		businessTypeTitleLayout.setLayoutTopMargin(10);
		businessTypeClassLayout.addMember(businessTypeTitleLayout);
		
		Label businessTitle = new Label();
		businessTitle.setContents("商业");
		businessTitle.setStyleName("customRadioTitle");
		businessTypeTitleLayout.addMember(businessTitle);
		
		Label hotelTitle = new Label();
		hotelTitle.setContents("酒店");
		hotelTitle.setStyleName("customRadioTitle");
		businessTypeTitleLayout.addMember(hotelTitle);
		
		Label officeTitle = new Label();
		officeTitle.setContents("办公");
		officeTitle.setStyleName("customRadioTitle");
		businessTypeTitleLayout.addMember(officeTitle);
		
		Label orbitTitle = new Label();
		orbitTitle.setContents("轨道交通");
		orbitTitle.setStyleName("customRadioTitle");
		businessTypeTitleLayout.addMember(orbitTitle);
		
		Label housingTitle = new Label();
		housingTitle.setContents("住宅");
		housingTitle.setStyleName("customRadioTitle");
		businessTypeTitleLayout.addMember(housingTitle);
		
		Label medicalTitle = new Label();
		medicalTitle.setContents("医养");
		medicalTitle.setStyleName("customRadioTitle");
		businessTypeTitleLayout.addMember(medicalTitle);
		
		Label publicBuildTitle = new Label();
		publicBuildTitle.setContents("公共建筑");
		publicBuildTitle.setStyleName("customRadioTitle");
		businessTypeTitleLayout.addMember(publicBuildTitle);
		
		Label shoppingTitle = new Label();
		shoppingTitle.setContents("采买");
		shoppingTitle.setStyleName("customRadioTitle");
		businessTypeTitleLayout.addMember(shoppingTitle);
		
		Label otherTitle = new Label();
		otherTitle.setContents("其他");
		otherTitle.setStyleName("customRadioTitle");
		businessTypeTitleLayout.addMember(otherTitle);
		
		businessTypeRadios = new RadioGroupItem("商业");
		businessTypeRadios.setTitleAlign(Alignment.LEFT);
		businessTypeRadios.setTitleStyle("customRadioTitle");
		businessTypeRadios.setVertical(false);
		businessTypeRadios.setValueMap("商业-区域","商业-商业街","商业-旧改","商业-主题");
		
		DynamicForm __businessTypeform = new DynamicForm();
		__businessTypeform.setNumCols(2);
		__businessTypeform.setFields(businessTypeRadios);
		businessTypeClassLayout.addMember(__businessTypeform);
		
		businessTitle.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				businessTypeRadios.setValue("");
				businessTypeRadios.setTitle("商业");
				businessTypeRadios.setValueMap("商业-区域","商业-商业街","商业-旧改","商业-主题");
			}
		});
		
		hotelTitle.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				businessTypeRadios.setValue("");
				businessTypeRadios.setTitle("酒店");
				businessTypeRadios.setValueMap("酒店-国际品牌","酒店-国内品牌","酒店-酒店式公寓","酒店-度假","酒店-商务");
			}
		});
		
		officeTitle.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				businessTypeRadios.setValue("");
				businessTypeRadios.setTitle("办公");
				businessTypeRadios.setValueMap("办公-展示样板层","办公-营销中心","办公-甲级写字楼","办公-科技","办公-金融");
			}
		});
		
		orbitTitle.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				businessTypeRadios.setValue("");
				businessTypeRadios.setTitle("轨道交通");
				businessTypeRadios.setValueMap("轨道交通-总体设计","轨道交通-车站设计","轨道交通-地下商业设计");
			}
		});
		
		housingTitle.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				businessTypeRadios.setValue("");
				businessTypeRadios.setTitle("住宅");
				businessTypeRadios.setValueMap("住宅-会所","住宅-售楼中心","住宅-样板房","住宅-别墅","住宅-公寓");
			}
		});
		
		medicalTitle.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				businessTypeRadios.setValue("");
				businessTypeRadios.setTitle("医养");
				businessTypeRadios.setValueMap("医养-医疗","医养-养老地产");
			}
		});
		
		publicBuildTitle.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				businessTypeRadios.setValue("");
				businessTypeRadios.setTitle("公共建筑");
				businessTypeRadios.setValueMap("公共建筑-市政设施","公共建筑-大学城","公共建筑-产业园");
			}
		});
		
		shoppingTitle.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				businessTypeRadios.setValue("");
				businessTypeRadios.setTitle("采买");
				businessTypeRadios.setValueMap("采买-购物中心","采买-办公","采买-样板会所","采买-酒店");
			}
		});
		
		otherTitle.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				businessTypeRadios.setValue("");
				businessTypeRadios.setTitle("其他");
				businessTypeRadios.setValueMap("其他-其他");
			}
		});
		
		//项目等级模块**********************
		HLayout projectLevelLayout = new HLayout();
		projectLevelLayout.setWidth100();
		projectLevelLayout.setHeight("10%");
		projectLevelLayout.setBorder(BORDER_STYLE2);
		topLayout.addMember(projectLevelLayout);
		
		Label projectLevelNo = new Label();
		projectLevelNo.setContents("不限");
		projectLevelNo.setStyleName("customlabelView");
		projectLevelLayout.addMember(projectLevelNo);
		projectLevelNo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				projectLevelRadios.setValue("");
			}
		});
		
		DynamicForm projectLevelform = new DynamicForm();
		projectLevelform.setWidth("70%");
		projectLevelform.setHeight100();
		projectLevelform.setNumCols(2);
		projectLevelform.setMargin(10);
		projectLevelLayout.addMember(projectLevelform);
		
		projectLevelRadios = new RadioGroupItem("项目等级");
		projectLevelRadios.setTitleAlign(Alignment.LEFT);
		projectLevelRadios.setTitleStyle("customRadioTitle");
		projectLevelRadios.setVertical(false);
		LinkedHashMap<Integer,String> projectLevelMap = new LinkedHashMap<>();
		projectLevelMap.put(1,"特级项目");
		projectLevelMap.put(2,"一级项目");
		projectLevelMap.put(3,"二级项目");
		projectLevelMap.put(4,"三级项目");
		projectLevelMap.put(5,"四级项目");
		projectLevelMap.put(6,"精品项目");
		projectLevelRadios.setValueMap(projectLevelMap);
		projectLevelform.setFields(projectLevelRadios);
		
		//客户等级模块**********************
		HLayout customLevelLayout = new HLayout();
		customLevelLayout.setWidth100();
		customLevelLayout.setHeight("10%");
		customLevelLayout.setBorder(BORDER_STYLE2);
		topLayout.addMember(customLevelLayout);
		
		Label customLevelNo = new Label();
		customLevelNo.setContents("不限");
		customLevelNo.setStyleName("customlabelView");
		customLevelLayout.addMember(customLevelNo);
		customLevelNo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				customLevelRadios.setValue("");
			}
		});
		
		DynamicForm customLevelform = new DynamicForm();
		customLevelform.setWidth("70%");
		customLevelform.setHeight100();
		customLevelform.setNumCols(2);
		customLevelform.setMargin(10);
		customLevelLayout.addMember(customLevelform);
		
		customLevelRadios = new RadioGroupItem("客户等级");
		customLevelRadios.setTitleAlign(Alignment.LEFT);
		customLevelRadios.setTitleStyle("customRadioTitle");
		customLevelRadios.setVertical(false);
		LinkedHashMap<Integer,String> customLevelMap = new LinkedHashMap<>();
		customLevelMap.put(1,"一级客户");
		customLevelMap.put(2,"二级客户");
		customLevelMap.put(3,"三级客户");
		customLevelRadios.setValueMap(customLevelMap);
		customLevelform.setFields(customLevelRadios);
		
		//区域等级模块**********************
		HLayout areaLevelLayout = new HLayout();
		areaLevelLayout.setWidth100();
		areaLevelLayout.setHeight("10%");
		areaLevelLayout.setBorder(BORDER_STYLE2);
		topLayout.addMember(areaLevelLayout);
		
		Label areaLevelNo = new Label();
		areaLevelNo.setContents("不限");
		areaLevelNo.setStyleName("customlabelView");
		areaLevelLayout.addMember(areaLevelNo);
		areaLevelNo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				areaLevelRadios.setValue("");
			}
		});
		
		DynamicForm areaLevelform = new DynamicForm();
		areaLevelform.setWidth("70%");
		areaLevelform.setHeight100();
		areaLevelform.setNumCols(2);
		areaLevelform.setMargin(10);
		areaLevelLayout.addMember(areaLevelform);
		
		areaLevelRadios = new RadioGroupItem("区域等级");
		areaLevelRadios.setTitleAlign(Alignment.LEFT);
		areaLevelRadios.setTitleStyle("customRadioTitle");
		areaLevelRadios.setVertical(false);
		LinkedHashMap<Integer,String> areaLevelMap = new LinkedHashMap<>();
		areaLevelMap.put(1,"一线城市");
		areaLevelMap.put(2,"二线城市");
		areaLevelMap.put(3,"三线城市");
		areaLevelRadios.setValueMap(areaLevelMap);
		areaLevelform.setFields(areaLevelRadios);
		
		//面积大小模块**********************
		HLayout sizeLayout = new HLayout();
		sizeLayout.setWidth100();
		sizeLayout.setHeight("10%");
		sizeLayout.setBorder(BORDER_STYLE2);
		topLayout.addMember(sizeLayout);
		
		Label sizeNo = new Label();
		sizeNo.setContents("不限");
		sizeNo.setStyleName("customlabelView");
		sizeLayout.addMember(sizeNo);
		sizeNo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				sizeRadios.setValue("");
			}
		});
		
		DynamicForm sizeform = new DynamicForm();
		sizeform.setWidth("70%");
		sizeform.setHeight100();
		sizeform.setNumCols(2);
		sizeform.setMargin(10);
		sizeLayout.addMember(sizeform);
		
		sizeRadios = new RadioGroupItem("区域区间");
		sizeRadios.setTitleAlign(Alignment.LEFT);
		sizeRadios.setTitleStyle("customRadioTitle");
		sizeRadios.setVertical(false);
		LinkedHashMap<Integer,String> sizeMap = new LinkedHashMap<>();
		sizeMap.put(1,"5000以下");
		sizeMap.put(2,"5000-10000");
		sizeMap.put(3,"10000-20000");
		sizeMap.put(4,"20000-30000");
		sizeMap.put(5,"30000平以上");
		sizeRadios.setValueMap(sizeMap);
		sizeform.setFields(sizeRadios);
		
		//中部面板
    	middleLayout = new HLayout();
    	middleLayout.setHeight("35%");
    	middleLayout.setIsGroup(true);
    	middleLayout.setGroupBorderCSS(layoutGroupStyle);
    	middleLayout.setGroupLabelBackgroundColor("#5E9FFB");
    	middleLayout.setGroupTitle("报价分析");
    	middleLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	middleLayout.setWidth100();
//    	middleLayout.setBackgroundColor("#FFEB9C");
    	mainLayout.addMember(middleLayout);
    	
    	VLayout rightLayout = new VLayout();
    	rightLayout.setHeight100();
    	rightLayout.setWidth100();
    	middleLayout.addMember(rightLayout);
    	
    	//******************平均报价模块**********
    	HLayout avgTotalLayout = new HLayout();
    	avgTotalLayout.setHeight("25%");
    	avgTotalLayout.setBorder("1px solid #808080");
    	rightLayout.addMember(avgTotalLayout);
    	
    	avgTitle = new Label();
    	avgTitle.setContents("平均报价");  
    	avgTitle.setAlign(Alignment.CENTER);
    	avgTitle.setBackgroundColor("#FFEB9C");
    	avgTitle.setHeight(148); 
    	avgTitle.setWidth("10%");
    	avgTotalLayout.addMember(avgTitle);
    	
    	VLayout avgLayout = new VLayout();
    	avgLayout.setWidth100();
    	avgLayout.setHeight("25%");
    	avgLayout.setWidth("90%");
    	avgLayout.setBorder("1px solid #808080");
    	avgTotalLayout.addMember(avgLayout);
    	//****************平均报价-title部分******
    	HLayout titleLayout = new HLayout();
    	titleLayout.setHeight("16%");
    	titleLayout.setWidth100();
    	titleLayout.setBorder("1px solid #808080");
    	avgLayout.addMember(titleLayout);
    	
    	Label typeTitle = new Label("专业");
    	typeTitle.setAlign(Alignment.CENTER);
    	typeTitle.setBackgroundColor("#FFEB9C");
    	typeTitle.setBorder(BORDER_STYLE3);
    	typeTitle.setWidth("25%");
    	
    	Label totalTitle = new Label("总价(元)");
    	totalTitle.setAlign(Alignment.CENTER);
    	totalTitle.setBackgroundColor("#FFEB9C");
    	totalTitle.setBorder(BORDER_STYLE3);
    	totalTitle.setWidth("25%");
    	
    	Label percentTitle = new Label("金额占比(%)");
    	percentTitle.setAlign(Alignment.CENTER);
    	percentTitle.setBackgroundColor("#FFEB9C");
    	percentTitle.setBorder(BORDER_STYLE3);
    	percentTitle.setWidth("25%");
    	
    	Label priceTitle = new Label("单价(元)");
    	priceTitle.setAlign(Alignment.CENTER);
    	priceTitle.setBackgroundColor("#FFEB9C");
    	priceTitle.setBorder(BORDER_STYLE3);
    	priceTitle.setWidth("25%");
    	
    	titleLayout.addMember(typeTitle);
    	titleLayout.addMember(totalTitle);
    	titleLayout.addMember(percentTitle);
    	titleLayout.addMember(priceTitle);
    	
    	//****************平均报价-综合部分******
    	HLayout avgHjLayout = new HLayout();
    	avgHjLayout.setHeight("14%");
    	avgHjLayout.setWidth100();
    	avgHjLayout.setBorder("1px solid #808080");
    	avgLayout.addMember(avgHjLayout);
    	
    	Label hjTitle = new Label("综合");
    	hjTitle.setAlign(Alignment.CENTER);
    	hjTitle.setBorder(BORDER_STYLE3);
    	hjTitle.setBackgroundColor("#FFEB9C");
    	hjTitle.setWidth("25%");
    	
    	hjTotalPrice = new Label("0");
    	hjTotalPrice.setAlign(Alignment.CENTER);
    	hjTotalPrice.setBorder(BORDER_STYLE3);
    	hjTotalPrice.setBackgroundColor(COLOR2);
    	hjTotalPrice.setWidth("25%");
    	
    	hjPricePercent = new Label("0");
    	hjPricePercent.setAlign(Alignment.CENTER);
    	hjPricePercent.setBorder(BORDER_STYLE3);
    	hjPricePercent.setBackgroundColor(COLOR2);
    	hjPricePercent.setWidth("25%");
    	
    	hjPrice = new Label("0");
    	hjPrice.setAlign(Alignment.CENTER);
    	hjPrice.setBorder(BORDER_STYLE3);
    	hjPrice.setBackgroundColor(COLOR3);
    	hjPrice.setWidth("25%");
    	
    	avgHjLayout.addMember(hjTitle);
    	avgHjLayout.addMember(hjTotalPrice);
    	avgHjLayout.addMember(hjPricePercent);
    	avgHjLayout.addMember(hjPrice);
    	//****************平均报价-装饰部分******
    	HLayout avgZsLayout = new HLayout();
    	avgZsLayout.setHeight("14%");
    	avgZsLayout.setWidth100();
    	avgZsLayout.setBorder("1px solid #808080");
    	avgLayout.addMember(avgZsLayout);
    	
    	Label zsTitle = new Label("装饰");
    	zsTitle.setAlign(Alignment.CENTER);
    	zsTitle.setBorder(BORDER_STYLE3);
    	zsTitle.setBackgroundColor("#FFEB9C");
    	zsTitle.setWidth("25%");
    	
    	zsTotalPrice = new Label("0");
    	zsTotalPrice.setAlign(Alignment.CENTER);
    	zsTotalPrice.setBorder(BORDER_STYLE3);
    	zsTotalPrice.setBackgroundColor(COLOR2);
    	zsTotalPrice.setWidth("25%");
    	
    	zsPricePercent = new Label("0");
    	zsPricePercent.setAlign(Alignment.CENTER);
    	zsPricePercent.setBorder(BORDER_STYLE3);
    	zsPricePercent.setBackgroundColor(COLOR2);
    	zsPricePercent.setWidth("25%");
    	
    	zsPrice = new Label("0");
    	zsPrice.setAlign(Alignment.CENTER);
    	zsPrice.setBorder(BORDER_STYLE3);
    	zsPrice.setBackgroundColor(COLOR3);
    	zsPrice.setWidth("25%");
    	
    	avgZsLayout.addMember(zsTitle);
    	avgZsLayout.addMember(zsTotalPrice);
    	avgZsLayout.addMember(zsPricePercent);
    	avgZsLayout.addMember(zsPrice);
    	
    	//****************平均报价-机电部分******
    	HLayout jdLayout = new HLayout();
    	jdLayout.setHeight("14%");
    	jdLayout.setWidth100();
    	jdLayout.setBorder("1px solid #808080");
    	avgLayout.addMember(jdLayout);
    	
    	Label jdTitle = new Label("机电");
    	jdTitle.setAlign(Alignment.CENTER);
    	jdTitle.setBorder(BORDER_STYLE3);
    	jdTitle.setBackgroundColor("#FFEB9C");
    	jdTitle.setWidth("25%");
    	
    	jdTotalPrice = new Label("0");
    	jdTotalPrice.setAlign(Alignment.CENTER);
    	jdTotalPrice.setBorder(BORDER_STYLE3);
    	jdTotalPrice.setBackgroundColor(COLOR2);
    	jdTotalPrice.setWidth("25%");
    	
    	jdPricePercent = new Label("0");
    	jdPricePercent.setAlign(Alignment.CENTER);
    	jdPricePercent.setBorder(BORDER_STYLE3);
    	jdPricePercent.setBackgroundColor(COLOR2);
    	jdPricePercent.setWidth("25%");
    	
    	jdPrice = new Label("0");
    	jdPrice.setAlign(Alignment.CENTER);
    	jdPrice.setBorder(BORDER_STYLE3);
    	jdPrice.setBackgroundColor(COLOR3);
    	jdPrice.setWidth("25%");
    	
    	jdLayout.addMember(jdTitle);
    	jdLayout.addMember(jdTotalPrice);
    	jdLayout.addMember(jdPricePercent);
    	jdLayout.addMember(jdPrice);
    	
    	//****************平均报价-灯光部分******
    	HLayout dgLayout = new HLayout();
    	dgLayout.setHeight("14%");
    	dgLayout.setWidth100();
    	dgLayout.setBorder("1px solid #808080");
    	avgLayout.addMember(dgLayout);
    	
    	Label dgTitle = new Label("灯光");
    	dgTitle.setAlign(Alignment.CENTER);
    	dgTitle.setBorder(BORDER_STYLE3);
    	dgTitle.setBackgroundColor("#FFEB9C");
    	dgTitle.setWidth("25%");
    	
    	dgTotalPrice = new Label("0");
    	dgTotalPrice.setAlign(Alignment.CENTER);
    	dgTotalPrice.setBorder(BORDER_STYLE3);
    	dgTotalPrice.setBackgroundColor(COLOR2);
    	dgTotalPrice.setWidth("25%");
    	
    	dgPricePercent = new Label("0");
    	dgPricePercent.setAlign(Alignment.CENTER);
    	dgPricePercent.setBorder(BORDER_STYLE3);
    	dgPricePercent.setBackgroundColor(COLOR2);
    	dgPricePercent.setWidth("25%");
    	
    	dgPrice = new Label("0");
    	dgPrice.setAlign(Alignment.CENTER);
    	dgPrice.setBorder(BORDER_STYLE3);
    	dgPrice.setBackgroundColor(COLOR3);
    	dgPrice.setWidth("25%");
    	
    	dgLayout.addMember(dgTitle);
    	dgLayout.addMember(dgTotalPrice);
    	dgLayout.addMember(dgPricePercent);
    	dgLayout.addMember(dgPrice);
    	
    	//****************平均报价-陈设部分******
    	HLayout csLayout = new HLayout();
    	csLayout.setHeight("14%");
    	csLayout.setWidth100();
    	csLayout.setBorder("1px solid #808080");
    	avgLayout.addMember(csLayout);
    	
    	Label csTitle = new Label("陈设");
    	csTitle.setAlign(Alignment.CENTER);
    	csTitle.setBorder(BORDER_STYLE3);
    	csTitle.setBackgroundColor("#FFEB9C");
    	csTitle.setWidth("25%");
    	
    	csTotalPrice = new Label("0");
    	csTotalPrice.setAlign(Alignment.CENTER);
    	csTotalPrice.setBorder(BORDER_STYLE3);
    	csTotalPrice.setBackgroundColor(COLOR2);
    	csTotalPrice.setWidth("25%");
    	
    	csPricePercent = new Label("0");
    	csPricePercent.setAlign(Alignment.CENTER);
    	csPricePercent.setBorder(BORDER_STYLE3);
    	csPricePercent.setBackgroundColor(COLOR2);
    	csPricePercent.setWidth("25%");

    	csPrice = new Label("0");
    	csPrice.setAlign(Alignment.CENTER);
    	csPrice.setBorder(BORDER_STYLE3);
    	csPrice.setBackgroundColor(COLOR3);
    	csPrice.setWidth("25%");
    	
    	csLayout.addMember(csTitle);
    	csLayout.addMember(csTotalPrice);
    	csLayout.addMember(csPricePercent);
    	csLayout.addMember(csPrice);
    	
    	//****************平均报价-平面部分******
    	HLayout pmLayout = new HLayout();
    	pmLayout.setHeight("14%");
    	pmLayout.setWidth100();
    	avgLayout.addMember(pmLayout);
    	
    	Label pmTitle = new Label("平面");
    	pmTitle.setAlign(Alignment.CENTER);
    	pmTitle.setBorder(BORDER_STYLE3);
    	pmTitle.setBackgroundColor("#FFEB9C");
    	pmTitle.setWidth("25%");
    	
    	pmTotalPrice = new Label("0");
    	pmTotalPrice.setAlign(Alignment.CENTER);
    	pmTotalPrice.setBorder(BORDER_STYLE3);
    	pmTotalPrice.setBackgroundColor(COLOR2);
    	pmTotalPrice.setWidth("25%");
    	
    	pmPricePercent = new Label("0");
    	pmPricePercent.setAlign(Alignment.CENTER);
    	pmPricePercent.setBorder(BORDER_STYLE3);
    	pmPricePercent.setBackgroundColor(COLOR2);
    	pmPricePercent.setWidth("25%");

    	pmPrice = new Label("0");
    	pmPrice.setAlign(Alignment.CENTER);
    	pmPrice.setBorder(BORDER_STYLE3);
    	pmPrice.setBackgroundColor(COLOR3);
    	pmPrice.setWidth("25%");
    	
    	pmLayout.addMember(pmTitle);
    	pmLayout.addMember(pmTotalPrice);
    	pmLayout.addMember(pmPricePercent);
    	pmLayout.addMember(pmPrice);
    	
    	
    	//******************最高报价模块**********
    	HLayout maxTotalLayout = new HLayout();
    	maxTotalLayout.setHeight("25%");
    	maxTotalLayout.setBorder("1px solid #808080");
    	rightLayout.addMember(maxTotalLayout);
    	
    	maxTitle = new Label();
    	maxTitle.setHeight(125);
    	maxTitle.setWidth("10%");
    	maxTitle.setContents("最高报价"); 
    	maxTitle.setAlign(Alignment.CENTER); 
    	maxTitle.setBackgroundColor("#FFEB9C");
    	maxTotalLayout.addMember(maxTitle);
    	maxTitle.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(maxValue.compareTo(BigDecimal.ZERO) > 0){
					ListGridRecord[] records = grid.getRecords();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						for(ListGridRecord r : records){
							//获取金额
							BigDecimal moneySum = BaseHelpUtils.getBigDecimalValue(r.getAttribute("moneySum"));
							if(maxValue.compareTo(moneySum) == 0){
								grid.deselectAllRecords();
								grid.selectRecord(r);
								grid.sort("moneySum", SortDirection.DESCENDING);
								grid.redraw();
								break;
							}
						}
					}
				}
			}
		});
    	
    	VLayout maxLayout = new VLayout();
    	maxLayout.setWidth("90%");
    	maxLayout.setHeight100();
    	maxTotalLayout.addMember(maxLayout);
    	
    	//****************最高报价-综合部分******
    	HLayout maxHjLayout = new HLayout();
    	maxHjLayout.setHeight("20%");
    	maxHjLayout.setWidth100();
    	maxHjLayout.setBorder("1px solid #808080");
    	maxLayout.addMember(maxHjLayout);
    	
    	Label maxHjTitle = new Label("综合");
    	maxHjTitle.setAlign(Alignment.CENTER);
    	maxHjTitle.setBorder(BORDER_STYLE3);
    	maxHjTitle.setBackgroundColor("#FFEB9C");
    	maxHjTitle.setWidth("25%");

    	maxHjTotalPrice = new Label("0");
    	maxHjTotalPrice.setAlign(Alignment.CENTER);
    	maxHjTotalPrice.setBorder(BORDER_STYLE3);
    	maxHjTotalPrice.setBackgroundColor(COLOR2);
    	maxHjTotalPrice.setWidth("25%");
    	
    	maxHjPricePercent = new Label("0");
    	maxHjPricePercent.setAlign(Alignment.CENTER);
    	maxHjPricePercent.setBorder(BORDER_STYLE3);
    	maxHjPricePercent.setBackgroundColor(COLOR2);
    	maxHjPricePercent.setWidth("25%");

    	maxHjPrice = new Label("0");
    	maxHjPrice.setAlign(Alignment.CENTER);
    	maxHjPrice.setBorder(BORDER_STYLE3);
    	maxHjPrice.setBackgroundColor(COLOR3);
    	maxHjPrice.setWidth("25%");
    	
    	maxHjLayout.addMember(maxHjTitle);
    	maxHjLayout.addMember(maxHjTotalPrice);
    	maxHjLayout.addMember(maxHjPricePercent);
    	maxHjLayout.addMember(maxHjPrice);
    	
    	//****************最高报价-装饰部分******
    	HLayout maxZsLayout = new HLayout();
    	maxZsLayout.setHeight("16%");
    	maxZsLayout.setWidth100();
    	maxZsLayout.setBorder("1px solid #808080");
    	maxLayout.addMember(maxZsLayout);
    	
    	Label maxZsTitle = new Label("装饰");
    	maxZsTitle.setAlign(Alignment.CENTER);
    	maxZsTitle.setBorder(BORDER_STYLE3);
    	maxZsTitle.setBackgroundColor("#FFEB9C");
    	maxZsTitle.setWidth("25%");
    	
    	maxZsTotalPrice = new Label("0");
    	maxZsTotalPrice.setAlign(Alignment.CENTER);
    	maxZsTotalPrice.setBorder(BORDER_STYLE3);
    	maxZsTotalPrice.setBackgroundColor(COLOR2);
    	maxZsTotalPrice.setWidth("25%");
    	
    	maxZsPricePercent = new Label("0");
    	maxZsPricePercent.setAlign(Alignment.CENTER);
    	maxZsPricePercent.setBorder(BORDER_STYLE3);
    	maxZsPricePercent.setBackgroundColor(COLOR2);
    	maxZsPricePercent.setWidth("25%");
    	
    	maxZsPrice = new Label("0");
    	maxZsPrice.setAlign(Alignment.CENTER);
    	maxZsPrice.setBorder(BORDER_STYLE3);
    	maxZsPrice.setBackgroundColor(COLOR3);
    	maxZsPrice.setWidth("25%");
    	
    	maxZsLayout.addMember(maxZsTitle);
    	maxZsLayout.addMember(maxZsTotalPrice);
    	maxZsLayout.addMember(maxZsPricePercent);
    	maxZsLayout.addMember(maxZsPrice);
    	
    	//****************最高报价-机电部分******
    	HLayout maxJdLayout = new HLayout();
    	maxJdLayout.setHeight("16%");
    	maxJdLayout.setWidth100();
    	maxJdLayout.setBorder("1px solid #808080");
    	maxLayout.addMember(maxJdLayout);
    	
    	Label maxJdTitle = new Label("机电");
    	maxJdTitle.setAlign(Alignment.CENTER);
    	maxJdTitle.setBorder(BORDER_STYLE3);
    	maxJdTitle.setBackgroundColor("#FFEB9C");
    	maxJdTitle.setWidth("25%");
    	
    	maxJdTotalPrice = new Label("0");
    	maxJdTotalPrice.setAlign(Alignment.CENTER);
    	maxJdTotalPrice.setBorder(BORDER_STYLE3);
    	maxJdTotalPrice.setBackgroundColor(COLOR2);
    	maxJdTotalPrice.setWidth("25%");
    	
    	maxJdPricePercent = new Label("0");
    	maxJdPricePercent.setAlign(Alignment.CENTER);
    	maxJdPricePercent.setBorder(BORDER_STYLE3);
    	maxJdPricePercent.setBackgroundColor(COLOR2);
    	maxJdPricePercent.setWidth("25%");
    	

    	maxJdPrice = new Label("0");
    	maxJdPrice.setAlign(Alignment.CENTER);
    	maxJdPrice.setBorder(BORDER_STYLE3);
    	maxJdPrice.setBackgroundColor(COLOR3);
    	maxJdPrice.setWidth("25%");
    	
    	maxJdLayout.addMember(maxJdTitle);
    	maxJdLayout.addMember(maxJdTotalPrice);
    	maxJdLayout.addMember(maxJdPricePercent);
    	maxJdLayout.addMember(maxJdPrice);
    	
    	//****************最高报价-灯光部分******
    	HLayout maxDgLayout = new HLayout();
    	maxDgLayout.setHeight("16%");
    	maxDgLayout.setWidth100();
    	maxDgLayout.setBorder("1px solid #808080");
    	maxLayout.addMember(maxDgLayout);
    	
    	Label maxDgTitle = new Label("灯光");
    	maxDgTitle.setAlign(Alignment.CENTER);
    	maxDgTitle.setBorder(BORDER_STYLE3);
    	maxDgTitle.setBackgroundColor("#FFEB9C");
    	maxDgTitle.setWidth("25%");
    	
    	maxDgTotalPrice = new Label("0");
    	maxDgTotalPrice.setAlign(Alignment.CENTER);
    	maxDgTotalPrice.setBorder(BORDER_STYLE3);
    	maxDgTotalPrice.setBackgroundColor(COLOR2);
    	maxDgTotalPrice.setWidth("25%");
    	
    	maxDgPricePercent = new Label("0");
    	maxDgPricePercent.setAlign(Alignment.CENTER);
    	maxDgPricePercent.setBorder(BORDER_STYLE3);
    	maxDgPricePercent.setBackgroundColor(COLOR2);
    	maxDgPricePercent.setWidth("25%");
    	
    	maxDgPrice = new Label("0");
    	maxDgPrice.setAlign(Alignment.CENTER);
    	maxDgPrice.setBorder(BORDER_STYLE3);
    	maxDgPrice.setBackgroundColor(COLOR3);
    	maxDgPrice.setWidth("25%");
    	
    	maxDgLayout.addMember(maxDgTitle);
    	maxDgLayout.addMember(maxDgTotalPrice);
    	maxDgLayout.addMember(maxDgPricePercent);
    	maxDgLayout.addMember(maxDgPrice);
    	
    	//****************最高报价-陈设部分******
    	HLayout maxCsLayout = new HLayout();
    	maxCsLayout.setHeight("16%");
    	maxCsLayout.setWidth100();
    	maxCsLayout.setBorder("1px solid #808080");
    	maxLayout.addMember(maxCsLayout);
    	
    	Label maxCsTitle = new Label("陈设");
    	maxCsTitle.setAlign(Alignment.CENTER);
    	maxCsTitle.setBorder(BORDER_STYLE3);
    	maxCsTitle.setBackgroundColor("#FFEB9C");
    	maxCsTitle.setWidth("25%");
    	
    	maxCsTotalPrice = new Label("0");
    	maxCsTotalPrice.setAlign(Alignment.CENTER);
    	maxCsTotalPrice.setBorder(BORDER_STYLE3);
    	maxCsTotalPrice.setBackgroundColor(COLOR2);
    	maxCsTotalPrice.setWidth("25%");
    	
    	maxCsPricePercent = new Label("0");
    	maxCsPricePercent.setAlign(Alignment.CENTER);
    	maxCsPricePercent.setBorder(BORDER_STYLE3);
    	maxCsPricePercent.setBackgroundColor(COLOR2);
    	maxCsPricePercent.setWidth("25%");
    	
    	maxCsPrice = new Label("0");
    	maxCsPrice.setAlign(Alignment.CENTER);
    	maxCsPrice.setBorder(BORDER_STYLE3);
    	maxCsPrice.setBackgroundColor(COLOR3);
    	maxCsPrice.setWidth("25%");
    	
    	maxCsLayout.addMember(maxCsTitle);
    	maxCsLayout.addMember(maxCsTotalPrice);
    	maxCsLayout.addMember(maxCsPricePercent);
    	maxCsLayout.addMember(maxCsPrice);
    	
    	//****************最高报价-平面部分******
    	HLayout maxPmLayout = new HLayout();
    	maxPmLayout.setHeight("16%");
    	maxPmLayout.setWidth100();
    	maxPmLayout.setBorder("1px solid #808080");
    	maxLayout.addMember(maxPmLayout);
    	
    	Label maxPpmTitle = new Label("平面");
    	maxPpmTitle.setAlign(Alignment.CENTER);
    	maxPpmTitle.setBorder(BORDER_STYLE3);
    	maxPpmTitle.setBackgroundColor("#FFEB9C");
    	maxPpmTitle.setWidth("25%");
    	
    	maxPmTotalPrice = new Label("0");
    	maxPmTotalPrice.setAlign(Alignment.CENTER);
    	maxPmTotalPrice.setBorder(BORDER_STYLE3);
    	maxPmTotalPrice.setBackgroundColor(COLOR2);
    	maxPmTotalPrice.setWidth("25%");
    	
    	maxPmPricePercent = new Label("0");
    	maxPmPricePercent.setAlign(Alignment.CENTER);
    	maxPmPricePercent.setBorder(BORDER_STYLE3);
    	maxPmPricePercent.setBackgroundColor(COLOR2);
    	maxPmPricePercent.setWidth("25%");
    	

    	maxPmPrice = new Label("0");
    	maxPmPrice.setAlign(Alignment.CENTER);
    	maxPmPrice.setBorder(BORDER_STYLE3);
    	maxPmPrice.setBackgroundColor(COLOR3);
    	maxPmPrice.setWidth("25%");
    	
    	maxPmLayout.addMember(maxPpmTitle);
    	maxPmLayout.addMember(maxPmTotalPrice);
    	maxPmLayout.addMember(maxPmPricePercent);
    	maxPmLayout.addMember(maxPmPrice);
    	
    	//******************最低报价模块**********
    	HLayout minTotalLayout = new HLayout();
    	minTotalLayout.setHeight("25%");
    	minTotalLayout.setBorder("1px solid #808080");
    	rightLayout.addMember(minTotalLayout);
    	
    	minTitle = new Label();
    	minTitle.setHeight(125);
    	minTitle.setWidth("10%");
    	minTitle.setContents("最低报价"); 
    	minTitle.setAlign(Alignment.CENTER); 
    	minTitle.setBackgroundColor("#FFEB9C");
    	minTotalLayout.addMember(minTitle);
    	minTitle.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(minValue.compareTo(BigDecimal.ZERO) > 0){
					ListGridRecord[] records = grid.getRecords();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						for(ListGridRecord r : records){
							//获取金额
							BigDecimal moneySum = BaseHelpUtils.getBigDecimalValue(r.getAttribute("moneySum"));
							if(minValue.compareTo(moneySum) == 0){
								grid.deselectAllRecords();
								grid.selectRecord(r);
								grid.sort("moneySum", SortDirection.ASCENDING);
								grid.redraw();
								break;
							}
						}
					}
				}
			}
		});
    	
    	VLayout minLayout = new VLayout();
    	minLayout.setWidth("90%");
    	minLayout.setHeight100();
    	minTotalLayout.addMember(minLayout);
    	
    	//****************最低报价-综合部分******
    	HLayout minHjLayout = new HLayout();
    	minHjLayout.setHeight("20%");
    	minHjLayout.setWidth100();
    	minHjLayout.setBorder("1px solid #808080");
    	minLayout.addMember(minHjLayout);
    	
    	Label minHjTitle = new Label("综合");
    	minHjTitle.setAlign(Alignment.CENTER);
    	minHjTitle.setBorder(BORDER_STYLE3);
    	minHjTitle.setBackgroundColor("#FFEB9C");
    	minHjTitle.setWidth("25%");
    	
    	minHjTotalPrice = new Label("0");
    	minHjTotalPrice.setAlign(Alignment.CENTER);
    	minHjTotalPrice.setBorder(BORDER_STYLE3);
    	minHjTotalPrice.setBackgroundColor(COLOR2);
    	minHjTotalPrice.setWidth("25%");
    	
    	minHjPricePercent = new Label("0");
    	minHjPricePercent.setAlign(Alignment.CENTER);
    	minHjPricePercent.setBorder(BORDER_STYLE3);
    	minHjPricePercent.setBackgroundColor(COLOR2);
    	minHjPricePercent.setWidth("25%");
    	

    	minHjPrice = new Label("0");
    	minHjPrice.setAlign(Alignment.CENTER);
    	minHjPrice.setBorder(BORDER_STYLE3);
    	minHjPrice.setBackgroundColor(COLOR3);
    	minHjPrice.setWidth("25%");
    	
    	minHjLayout.addMember(minHjTitle);
    	minHjLayout.addMember(minHjTotalPrice);
    	minHjLayout.addMember(minHjPricePercent);
    	minHjLayout.addMember(minHjPrice);
    	
    	//****************最低报价-装饰部分******
    	HLayout minZsLayout = new HLayout();
    	minZsLayout.setHeight("16%");
    	minZsLayout.setWidth100();
    	minZsLayout.setBorder("1px solid #808080");
    	minLayout.addMember(minZsLayout);
    	
    	Label minZsTitle = new Label("装饰");
    	minZsTitle.setAlign(Alignment.CENTER);
    	minZsTitle.setBorder(BORDER_STYLE3);
    	minZsTitle.setBackgroundColor("#FFEB9C");
    	minZsTitle.setWidth("25%");
    	
    	minZsTotalPrice = new Label("0");
    	minZsTotalPrice.setAlign(Alignment.CENTER);
    	minZsTotalPrice.setBorder(BORDER_STYLE3);
    	minZsTotalPrice.setBackgroundColor(COLOR2);
    	minZsTotalPrice.setWidth("25%");
    	
    	minZsPricePercent = new Label("0");
    	minZsPricePercent.setAlign(Alignment.CENTER);
    	minZsPricePercent.setBorder(BORDER_STYLE3);
    	minZsPricePercent.setBackgroundColor(COLOR2);
    	minZsPricePercent.setWidth("25%");

    	minZsPrice = new Label("0");
    	minZsPrice.setAlign(Alignment.CENTER);
    	minZsPrice.setBorder(BORDER_STYLE3);
    	minZsPrice.setBackgroundColor(COLOR3);
    	minZsPrice.setWidth("25%");
    	
    	minZsLayout.addMember(minZsTitle);
    	minZsLayout.addMember(minZsTotalPrice);
    	minZsLayout.addMember(minZsPricePercent);
    	minZsLayout.addMember(minZsPrice);
    	
    	//****************最低报价-机电部分******
    	HLayout minJdLayout = new HLayout();
    	minJdLayout.setHeight("16%");
    	minJdLayout.setWidth100();
    	minJdLayout.setBorder("1px solid #808080");
    	minLayout.addMember(minJdLayout);
    	
    	Label minJdTitle = new Label("机电");
    	minJdTitle.setAlign(Alignment.CENTER);
    	minJdTitle.setBorder(BORDER_STYLE3);
    	minJdTitle.setBackgroundColor("#FFEB9C");
    	minJdTitle.setWidth("25%");
    	
    	minJdTotalPrice = new Label("0");
    	minJdTotalPrice.setAlign(Alignment.CENTER);
    	minJdTotalPrice.setBorder(BORDER_STYLE3);
    	minJdTotalPrice.setBackgroundColor(COLOR2);
    	minJdTotalPrice.setWidth("25%");
    	
    	minJdPricePercent = new Label("0");
    	minJdPricePercent.setAlign(Alignment.CENTER);
    	minJdPricePercent.setBorder(BORDER_STYLE3);
    	minJdPricePercent.setBackgroundColor(COLOR2);
    	minJdPricePercent.setWidth("25%");
    	
    	minJdPrice = new Label("0");
    	minJdPrice.setAlign(Alignment.CENTER);
    	minJdPrice.setBorder(BORDER_STYLE3);
    	minJdPrice.setBackgroundColor(COLOR3);
    	minJdPrice.setWidth("25%");
    	
    	minJdLayout.addMember(minJdTitle);
    	minJdLayout.addMember(minJdTotalPrice);
    	minJdLayout.addMember(minJdPricePercent);
    	minJdLayout.addMember(minJdPrice);
    	
    	//****************最低报价-灯光部分******
    	HLayout minDgLayout = new HLayout();
    	minDgLayout.setHeight("16%");
    	minDgLayout.setWidth100();
    	minDgLayout.setBorder("1px solid #808080");
    	minLayout.addMember(minDgLayout);
    	
    	Label minDgTitle = new Label("灯光");
    	minDgTitle.setAlign(Alignment.CENTER);
    	minDgTitle.setBorder(BORDER_STYLE3);
    	minDgTitle.setBackgroundColor("#FFEB9C");
    	minDgTitle.setWidth("25%");
    	
    	minDgTotalPrice = new Label("0");
    	minDgTotalPrice.setAlign(Alignment.CENTER);
    	minDgTotalPrice.setBorder(BORDER_STYLE3);
    	minDgTotalPrice.setBackgroundColor(COLOR2);
    	minDgTotalPrice.setWidth("25%");
    	
    	minDgPricePercent = new Label("0");
    	minDgPricePercent.setAlign(Alignment.CENTER);
    	minDgPricePercent.setBorder(BORDER_STYLE3);
    	minDgPricePercent.setBackgroundColor(COLOR2);
    	minDgPricePercent.setWidth("25%");
    	

    	minDgPrice = new Label("0");
    	minDgPrice.setAlign(Alignment.CENTER);
    	minDgPrice.setBorder(BORDER_STYLE3);
    	minDgPrice.setBackgroundColor(COLOR3);
    	minDgPrice.setWidth("25%");
    	
    	minDgLayout.addMember(minDgTitle);
    	minDgLayout.addMember(minDgTotalPrice);
    	minDgLayout.addMember(minDgPricePercent);
    	minDgLayout.addMember(minDgPrice);
    	
    	//****************最低报价-陈设部分******
    	HLayout minCsLayout = new HLayout();
    	minCsLayout.setHeight("16%");
    	minCsLayout.setWidth100();
    	minCsLayout.setBorder("1px solid #808080");
    	minLayout.addMember(minCsLayout);
    	
    	Label minCsTitle = new Label("陈设");
    	minCsTitle.setAlign(Alignment.CENTER);
    	minCsTitle.setBorder(BORDER_STYLE3);
    	minCsTitle.setBackgroundColor("#FFEB9C");
    	minCsTitle.setWidth("25%");
    	
    	minCsTotalPrice = new Label("0");
    	minCsTotalPrice.setAlign(Alignment.CENTER);
    	minCsTotalPrice.setBorder(BORDER_STYLE3);
    	minCsTotalPrice.setBackgroundColor(COLOR2);
    	minCsTotalPrice.setWidth("25%");
    	
    	minCsPricePercent = new Label("0");
    	minCsPricePercent.setAlign(Alignment.CENTER);
    	minCsPricePercent.setBorder(BORDER_STYLE3);
    	minCsPricePercent.setBackgroundColor(COLOR2);
    	minCsPricePercent.setWidth("25%");

    	minCsPrice = new Label("0");
    	minCsPrice.setAlign(Alignment.CENTER);
    	minCsPrice.setBorder(BORDER_STYLE3);
    	minCsPrice.setBackgroundColor(COLOR3);
    	minCsPrice.setWidth("25%");
    	
    	minCsLayout.addMember(minCsTitle);
    	minCsLayout.addMember(minCsTotalPrice);
    	minCsLayout.addMember(minCsPricePercent);
    	minCsLayout.addMember(minCsPrice);
    	
    	//****************最低报价-平面部分******
    	HLayout minPmLayout = new HLayout();
    	minPmLayout.setHeight("16%");
    	minPmLayout.setWidth100();
    	minPmLayout.setBorder("1px solid #808080");
    	minLayout.addMember(minPmLayout);
    	
    	Label minPmTitle = new Label("平面");
    	minPmTitle.setAlign(Alignment.CENTER);
    	minPmTitle.setBorder(BORDER_STYLE3);
    	minPmTitle.setBackgroundColor("#FFEB9C");;
    	minPmTitle.setWidth("25%");
    	
    	minPmTotalPrice = new Label("0");
    	minPmTotalPrice.setAlign(Alignment.CENTER);
    	minPmTotalPrice.setBorder(BORDER_STYLE3);
    	minPmTotalPrice.setBackgroundColor(COLOR2);
    	minPmTotalPrice.setWidth("25%");
    	
    	minPmPricePercent = new Label("0");
    	minPmPricePercent.setAlign(Alignment.CENTER);
    	minPmPricePercent.setBorder(BORDER_STYLE3);
    	minPmPricePercent.setBackgroundColor(COLOR2);
    	minPmPricePercent.setWidth("25%");

    	minPmPrice = new Label("0");
    	minPmPrice.setAlign(Alignment.CENTER);
    	minPmPrice.setBorder(BORDER_STYLE3);
    	minPmPrice.setBackgroundColor(COLOR3);
    	minPmPrice.setWidth("25%");
    	
    	minPmLayout.addMember(minPmTitle);
    	minPmLayout.addMember(minPmTotalPrice);
    	minPmLayout.addMember(minPmPricePercent);
    	minPmLayout.addMember(minPmPrice);
    	
    	//******************最近报价模块**********
    	HLayout recentTotalLayout = new HLayout();
    	recentTotalLayout.setHeight("25%");
    	recentTotalLayout.setBorder("1px solid #808080");
    	rightLayout.addMember(recentTotalLayout);
    	
    	recentTitle = new Label();
    	recentTitle.setHeight(125);
    	recentTitle.setWidth("10%");
    	recentTitle.setContents("最近报价"); 
    	recentTitle.setAlign(Alignment.CENTER); 
    	recentTitle.setBackgroundColor("#FFEB9C");
    	recentTotalLayout.addMember(recentTitle);
    	recentTitle.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(recentValue.compareTo(BigDecimal.ZERO) > 0){
					ListGridRecord[] records = grid.getRecords();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						for(ListGridRecord r : records){
							//获取金额
							BigDecimal moneySum = BaseHelpUtils.getBigDecimalValue(r.getAttribute("moneySum"));
							if(recentValue.compareTo(moneySum) == 0){
								grid.deselectAllRecords();
								grid.selectRecord(r);
								grid.sort("projectApprovalTime", SortDirection.DESCENDING);
								grid.redraw();
								break;
							}
						}
					}
				}
			}
		});
    	
    	VLayout recentLayout = new VLayout();
    	recentLayout.setWidth("90%");
    	recentLayout.setHeight100();
    	recentTotalLayout.addMember(recentLayout);
    	
    	//****************最近报价-综合部分******
    	HLayout recentHjLayout = new HLayout();
    	recentHjLayout.setHeight("20%");
    	recentHjLayout.setWidth100();
    	recentHjLayout.setBorder("1px solid #808080");
    	recentLayout.addMember(recentHjLayout);
    	
    	Label recentHjTitle = new Label("综合");
    	recentHjTitle.setAlign(Alignment.CENTER);
    	recentHjTitle.setBorder(BORDER_STYLE3);
    	recentHjTitle.setBackgroundColor("#FFEB9C");
    	recentHjTitle.setWidth("25%");
    	
    	recentHjTotalPrice = new Label("0");
    	recentHjTotalPrice.setAlign(Alignment.CENTER);
    	recentHjTotalPrice.setBorder(BORDER_STYLE3);
    	recentHjTotalPrice.setBackgroundColor(COLOR2);
    	recentHjTotalPrice.setWidth("25%");
    	
    	recentHjPricePercent = new Label("0");
    	recentHjPricePercent.setAlign(Alignment.CENTER);
    	recentHjPricePercent.setBorder(BORDER_STYLE3);
    	recentHjPricePercent.setBackgroundColor(COLOR2);
    	recentHjPricePercent.setWidth("25%");
    	
    	recentHjPrice = new Label("0");
    	recentHjPrice.setAlign(Alignment.CENTER);
    	recentHjPrice.setBorder(BORDER_STYLE3);
    	recentHjPrice.setBackgroundColor(COLOR3);
    	recentHjPrice.setWidth("25%");
    	
    	recentHjLayout.addMember(recentHjTitle);
    	recentHjLayout.addMember(recentHjTotalPrice);
    	recentHjLayout.addMember(recentHjPricePercent);
    	recentHjLayout.addMember(recentHjPrice);
    	
    	//****************最近报价-装饰部分******
    	HLayout recentZsLayout = new HLayout();
    	recentZsLayout.setHeight("16%");
    	recentZsLayout.setWidth100();
    	recentZsLayout.setBorder("1px solid #808080");
    	recentLayout.addMember(recentZsLayout);
    	
    	Label recentZsTitle = new Label("装饰");
    	recentZsTitle.setAlign(Alignment.CENTER);
    	recentZsTitle.setBorder(BORDER_STYLE3);
    	recentZsTitle.setBackgroundColor("#FFEB9C");
    	recentZsTitle.setWidth("25%");
    	
    	recentZsTotalPrice = new Label("0");
    	recentZsTotalPrice.setAlign(Alignment.CENTER);
    	recentZsTotalPrice.setBorder(BORDER_STYLE3);
    	recentZsTotalPrice.setBackgroundColor(COLOR2);
    	recentZsTotalPrice.setWidth("25%");
    	
    	recentZsPricePercent = new Label("0");
    	recentZsPricePercent.setAlign(Alignment.CENTER);
    	recentZsPricePercent.setBorder(BORDER_STYLE3);
    	recentZsPricePercent.setBackgroundColor(COLOR2);
    	recentZsPricePercent.setWidth("25%");

    	recentZsPrice = new Label("0");
    	recentZsPrice.setAlign(Alignment.CENTER);
    	recentZsPrice.setBorder(BORDER_STYLE3);
    	recentZsPrice.setBackgroundColor(COLOR3);
    	recentZsPrice.setWidth("25%");
    	
    	recentZsLayout.addMember(recentZsTitle);
    	recentZsLayout.addMember(recentZsTotalPrice);
    	recentZsLayout.addMember(recentZsPricePercent);
    	recentZsLayout.addMember(recentZsPrice);
    	
    	//****************最近报价-机电部分******
    	HLayout recentJdLayout = new HLayout();
    	recentJdLayout.setHeight("16%");
    	recentJdLayout.setWidth100();
    	recentJdLayout.setBorder("1px solid #808080");
    	recentLayout.addMember(recentJdLayout);
    	
    	Label recentJdTitle = new Label("机电");
    	recentJdTitle.setAlign(Alignment.CENTER);
    	recentJdTitle.setBorder(BORDER_STYLE3);
    	recentJdTitle.setBackgroundColor("#FFEB9C");
    	recentJdTitle.setWidth("25%");
    	
    	recentJdTotalPrice = new Label("0");
    	recentJdTotalPrice.setAlign(Alignment.CENTER);
    	recentJdTotalPrice.setBorder(BORDER_STYLE3);
    	recentJdTotalPrice.setBackgroundColor(COLOR2);
    	recentJdTotalPrice.setWidth("25%");
    	
    	recentJdPricePercent = new Label("0");
    	recentJdPricePercent.setAlign(Alignment.CENTER);
    	recentJdPricePercent.setBorder(BORDER_STYLE3);
    	recentJdPricePercent.setBackgroundColor(COLOR2);
    	recentJdPricePercent.setWidth("25%");

    	recentJdPrice = new Label("0");
    	recentJdPrice.setAlign(Alignment.CENTER);
    	recentJdPrice.setBorder(BORDER_STYLE3);
    	recentJdPrice.setBackgroundColor(COLOR3);
    	recentJdPrice.setWidth("25%");
    	
    	recentJdLayout.addMember(recentJdTitle);
    	recentJdLayout.addMember(recentJdTotalPrice);
    	recentJdLayout.addMember(recentJdPricePercent);
    	recentJdLayout.addMember(recentJdPrice);
    	
    	//****************最近报价-灯光部分******
    	HLayout recentDgLayout = new HLayout();
    	recentDgLayout.setHeight("16%");
    	recentDgLayout.setWidth100();
    	recentDgLayout.setBorder("1px solid #808080");
    	recentLayout.addMember(recentDgLayout);
    	
    	Label recentDgTitle = new Label("灯光");
    	recentDgTitle.setAlign(Alignment.CENTER);
    	recentDgTitle.setBorder(BORDER_STYLE3);
    	recentDgTitle.setBackgroundColor("#FFEB9C");
    	recentDgTitle.setWidth("25%");
    	
    	recentDgTotalPrice = new Label("0");
    	recentDgTotalPrice.setAlign(Alignment.CENTER);
    	recentDgTotalPrice.setBorder(BORDER_STYLE3);
    	recentDgTotalPrice.setBackgroundColor(COLOR2);
    	recentDgTotalPrice.setWidth("25%");
    	
    	recentDgPricePercent = new Label("0");
    	recentDgPricePercent.setAlign(Alignment.CENTER);
    	recentDgPricePercent.setBorder(BORDER_STYLE3);
    	recentDgPricePercent.setBackgroundColor(COLOR2);
    	recentDgPricePercent.setWidth("25%");

    	recentDgPrice = new Label("0");
    	recentDgPrice.setAlign(Alignment.CENTER);
    	recentDgPrice.setBorder(BORDER_STYLE3);
    	recentDgPrice.setBackgroundColor(COLOR3);
    	recentDgPrice.setWidth("25%");
    	
    	recentDgLayout.addMember(recentDgTitle);
    	recentDgLayout.addMember(recentDgTotalPrice);
    	recentDgLayout.addMember(recentDgPricePercent);
    	recentDgLayout.addMember(recentDgPrice);
    	
    	//****************最低报价-陈设部分******
    	HLayout recentCsLayout = new HLayout();
    	recentCsLayout.setHeight("16%");
    	recentCsLayout.setWidth100();
    	recentCsLayout.setBorder("1px solid #808080");
    	recentLayout.addMember(recentCsLayout);
    	
    	Label recentCsTitle = new Label("陈设");
    	recentCsTitle.setAlign(Alignment.CENTER);
    	recentCsTitle.setBorder(BORDER_STYLE3);
    	recentCsTitle.setBackgroundColor("#FFEB9C");
    	recentCsTitle.setWidth("25%");
    	
    	recentCsTotalPrice = new Label("0");
    	recentCsTotalPrice.setAlign(Alignment.CENTER);
    	recentCsTotalPrice.setBorder(BORDER_STYLE3);
    	recentCsTotalPrice.setBackgroundColor(COLOR2);
    	recentCsTotalPrice.setWidth("25%");
    	
    	recentCsPricePercent = new Label("0");
    	recentCsPricePercent.setAlign(Alignment.CENTER);
    	recentCsPricePercent.setBorder(BORDER_STYLE3);
    	recentCsPricePercent.setBackgroundColor(COLOR2);
    	recentCsPricePercent.setWidth("25%");

    	recentCsPrice = new Label("0");
    	recentCsPrice.setAlign(Alignment.CENTER);
    	recentCsPrice.setBorder(BORDER_STYLE3);
    	recentCsPrice.setBackgroundColor(COLOR3);
    	recentCsPrice.setWidth("25%");
    	
    	recentCsLayout.addMember(recentCsTitle);
    	recentCsLayout.addMember(recentCsTotalPrice);
    	recentCsLayout.addMember(recentCsPricePercent);
    	recentCsLayout.addMember(recentCsPrice);
    	
    	//****************最近报价-平面部分******
    	HLayout recentPmLayout = new HLayout();
    	recentPmLayout.setHeight("16%");
    	recentPmLayout.setWidth100();
    	recentPmLayout.setBorder("1px solid #808080");
    	recentLayout.addMember(recentPmLayout);
    	
    	Label recentPpmTitle = new Label("平面");
    	recentPpmTitle.setAlign(Alignment.CENTER);
    	recentPpmTitle.setBorder(BORDER_STYLE3);
    	recentPpmTitle.setBackgroundColor("#FFEB9C");
    	recentPpmTitle.setWidth("25%");
    	
    	recentPmTotalPrice = new Label("0");
    	recentPmTotalPrice.setAlign(Alignment.CENTER);
    	recentPmTotalPrice.setBorder(BORDER_STYLE3);
    	recentPmTotalPrice.setBackgroundColor(COLOR2);
    	recentPmTotalPrice.setWidth("25%");
    	
    	recentPmPricePercent = new Label("0");
    	recentPmPricePercent.setAlign(Alignment.CENTER);
    	recentPmPricePercent.setBorder(BORDER_STYLE3);
    	recentPmPricePercent.setBackgroundColor(COLOR2);
    	recentPmPricePercent.setWidth("25%");
    	
    	recentPmPrice = new Label("0");
    	recentPmPrice.setAlign(Alignment.CENTER);
    	recentPmPrice.setBorder(BORDER_STYLE3);
    	recentPmPrice.setBackgroundColor(COLOR3);
    	recentPmPrice.setWidth("25%");
    	
    	recentPmLayout.addMember(recentPpmTitle);
    	recentPmLayout.addMember(recentPmTotalPrice);
    	recentPmLayout.addMember(recentPmPricePercent);
    	recentPmLayout.addMember(recentPmPrice);
    	
    	//底部面板
    	buttonLayout = new VLayout(20);
    	buttonLayout.setHeight("40%");
    	buttonLayout.setIsGroup(true);
    	buttonLayout.setGroupBorderCSS(layoutGroupStyle);
    	buttonLayout.setGroupLabelBackgroundColor("#5E9FFB");
    	buttonLayout.setGroupTitle("匹配项目");
    	buttonLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	buttonLayout.setWidth100();
    	mainLayout.addMember(buttonLayout);
    	
    	DSStandardQuote source = DSStandardQuote.getInstance();
    	grid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			//获取立项依据
				int projectBaseOn = BaseHelpUtils.getIntValue(record.getAttribute("projectBaseOn"));
				if(projectBaseOn == 2 || projectBaseOn == 3){
					record.setAttribute("bidType","");
				}
    			return null;
    		}
    	};
    	grid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(!grid.anySelected()){ SC.say("请选择一条数据"); return;}
                ListGridRecord[] selected = grid.getSelectedRecords();
                String infoCode = BaseHelpUtils.getString(selected[0].getAttribute("infoCode"));
                String projectCode = BaseHelpUtils.getString(selected[0].getAttribute("projectCode"));
                int outQuotationId = BaseHelpUtils.getIntValue(selected[0].getAttributeAsInt("outQuotationId"));
                String projectName = BaseHelpUtils.getString(selected[0].getAttribute("projectName"));
            	PopupWindow pw = new PopupWindow(projectName+"报价单");
				CheckOutAllDesignConsiderationPanel panel=new CheckOutAllDesignConsiderationPanel();
				panel.setInfoCode(infoCode);
				panel.setProjectCode(projectCode);
				panel.setOutQuotationId(outQuotationId);
				panel.startEdit();
				pw.addItem(panel);
				pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
			}
		});
    	grid.setHeight100();
    	grid.setWidth100();
    	grid.setDataSource(source);
    	grid.setAutoFitFieldWidths(false);
    	grid.setShowRowNumbers(true);
    	buttonLayout.addMember(grid);
    	
    	startEdit();
    }

    @Override
    public void startEdit() {
    	Map<Object,Object> param = new HashMap<>();
    	param.put("startDate",startDateItem.getValue());
    	param.put("endDate",endDateItem.getValue());
    	param.put("customName",customNameItem.getValue());
    	param.put("sizeType",sizeRadios.getValue());
    	param.put("projectLevelType",projectLevelRadios.getValue());
    	param.put("businessType",businessTypeRadios.getValue());
    	param.put("customLevelType",customLevelRadios.getValue());
    	param.put("areaLevelType",areaLevelRadios.getValue());
    	param.put("optType","onLoadStandardQuoteData");
    	final LoadingWindow loading = new LoadingWindow();
    	DBDataSource.callOperation("EP_OnProjectCommonProcess",param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	Record[] records = dsResponse.getData();
                	grid.setData(records);
                	//获取最高报价
                	BigDecimal maxPrice = BaseHelpUtils.getBigDecimalValue(dsResponse.getAttributeAsMap("userData").get("maxPrice"));
                	//获取最低报价
                	BigDecimal minPrice = BaseHelpUtils.getBigDecimalValue(dsResponse.getAttributeAsMap("userData").get("minPrice"));
                	//获取最近报价
                	BigDecimal recentPrice = BaseHelpUtils.getBigDecimalValue(dsResponse.getAttributeAsMap("userData").get("recentPrice"));
                	setMaxValue(maxPrice);
                	setMinValue(minPrice);
                	setRecentValue(recentPrice);
                	
                	//获取平均报价的专业项
                	String avgZsTotalPrice = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgZsTotalPrice"));
                	String avgZsPrice = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgZsPrice"));
                	String avgZsPricePercent = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgZsPricePercent"));
                	String avgJdTotalPrice = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgJdTotalPrice"));
                	String avgJdPrice = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgJdPrice"));
                	String avgJdPricePercent = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgJdPricePercent"));
                	String avgDgTotalPrice = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgDgTotalPrice"));
                	String avgDgPrice = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgDgPrice"));
                	String avgDgPricePercent = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgDgPricePercent"));
                	String avgCsTotalPrice = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgCsTotalPrice"));
                	String avgCsPrice = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgCsPrice"));
                	String avgCsPricePercent = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgCsPricePercent"));
                	String avgPmTotalPrice = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgPmTotalPrice"));
                	String avgPmPrice = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgPmPrice"));
                	String avgPmPricePercent = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgPmPricePercent"));
                	String avgHjTotalPrice = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgHjTotalPrice"));
                	String avgHjPrice = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgHjPrice"));
                	String avgHjPricePercent = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("avgHjPricePercent"));
                	if(!BaseHelpUtils.isNullOrEmpty(avgZsTotalPrice))zsTotalPrice.setContents(avgZsTotalPrice);
                	if(!BaseHelpUtils.isNullOrEmpty(avgZsPrice))zsPrice.setContents(avgZsPrice);
                	if(!BaseHelpUtils.isNullOrEmpty(avgZsPricePercent))zsPricePercent.setContents(avgZsPricePercent);
                	if(!BaseHelpUtils.isNullOrEmpty(avgJdTotalPrice))jdTotalPrice.setContents(avgJdTotalPrice);
                	if(!BaseHelpUtils.isNullOrEmpty(avgJdPrice))jdPrice.setContents(avgJdPrice);
                	if(!BaseHelpUtils.isNullOrEmpty(avgJdPricePercent))jdPricePercent.setContents(avgJdPricePercent);
                	if(!BaseHelpUtils.isNullOrEmpty(avgDgTotalPrice))dgTotalPrice.setContents(avgDgTotalPrice);
                	if(!BaseHelpUtils.isNullOrEmpty(avgDgPrice))dgPrice.setContents(avgDgPrice);
                	if(!BaseHelpUtils.isNullOrEmpty(avgDgPricePercent))dgPricePercent.setContents(avgDgPricePercent);
                	if(!BaseHelpUtils.isNullOrEmpty(avgCsTotalPrice))csTotalPrice.setContents(avgCsTotalPrice);
                	if(!BaseHelpUtils.isNullOrEmpty(avgCsPrice))csPrice.setContents(avgCsPrice);
                	if(!BaseHelpUtils.isNullOrEmpty(avgCsPricePercent))csPricePercent.setContents(avgCsPricePercent);
                	if(!BaseHelpUtils.isNullOrEmpty(avgPmTotalPrice))pmTotalPrice.setContents(avgPmTotalPrice);
                	if(!BaseHelpUtils.isNullOrEmpty(avgPmPrice))pmPrice.setContents(avgPmPrice);
                	if(!BaseHelpUtils.isNullOrEmpty(avgPmPricePercent))pmPricePercent.setContents(avgPmPricePercent);
                	if(!BaseHelpUtils.isNullOrEmpty(avgHjTotalPrice))hjTotalPrice.setContents(avgHjTotalPrice);
                	if(!BaseHelpUtils.isNullOrEmpty(avgHjPrice))hjPrice.setContents(avgHjPrice);
                	if(!BaseHelpUtils.isNullOrEmpty(avgHjPricePercent))hjPricePercent.setContents(avgHjPricePercent);
                	
                	//获取最高报价的专业项
                	String maxZsTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxZsTotalPrice"));
                	String maxZsPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxZsPrice"));
                	String maxZsPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxZsPricePercent"));
                	
                	String maxJdTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxJdTotalPrice"));
                	String maxJdPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxJdPrice"));
                	String maxJdPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxJdPricePercent"));
                	
                	String maxDgTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxDgTotalPrice"));
                	String maxDgPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxDgPrice"));
                	String maxDgPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxDgPricePercent"));
                	
                	String maxCsTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxCsTotalPrice"));
                	String maxCsPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxCsPrice"));
                	String maxCsPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxCsPricePercent"));
                	
                	String maxPmTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxPmTotalPrice"));
                	String maxPmPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxPmPrice"));
                	String maxPmPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxPmPricePercent"));
                	
                	String maxHjTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxHjTotalPrice"));
                	String maxHjPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxHjPrice"));
                	String maxHjPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("maxHjPricePercent"));
                	if(!BaseHelpUtils.isNullOrEmpty(maxZsTotalPriceValue))maxZsTotalPrice.setContents(maxZsTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(maxZsPriceValue))maxZsPrice.setContents(maxZsPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(maxZsPricePercentValue))maxZsPricePercent.setContents(maxZsPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(maxJdTotalPriceValue))maxJdTotalPrice.setContents(maxJdTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(maxJdPriceValue))maxJdPrice.setContents(maxJdPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(maxJdPricePercentValue))maxJdPricePercent.setContents(maxJdPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(maxDgTotalPriceValue))maxDgTotalPrice.setContents(maxDgTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(maxDgPriceValue))maxDgPrice.setContents(maxDgPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(maxDgPricePercentValue))maxDgPricePercent.setContents(maxDgPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(maxCsTotalPriceValue))maxCsTotalPrice.setContents(maxCsTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(maxCsPriceValue))maxCsPrice.setContents(maxCsPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(maxCsPricePercentValue))maxCsPricePercent.setContents(maxCsPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(maxPmTotalPriceValue))maxPmTotalPrice.setContents(maxPmTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(maxPmPriceValue))maxPmPrice.setContents(maxPmPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(maxPmPricePercentValue))maxPmPricePercent.setContents(maxPmPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(maxHjTotalPriceValue))maxHjTotalPrice.setContents(maxHjTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(maxHjPriceValue))maxHjPrice.setContents(maxHjPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(maxHjPricePercentValue))maxHjPricePercent.setContents(maxHjPricePercentValue);
                	//获取最低报价的专业项
                	String minZsTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minZsTotalPrice"));
                	String minZsPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minZsPrice"));
                	String minZsPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minZsPricePercent"));
                	
                	String minJdTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minJdTotalPrice"));
                	String minJdPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minJdPrice"));
                	String minJdPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minJdPricePercent"));
                	
                	String minDgTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minDgTotalPrice"));
                	String minDgPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minDgPrice"));
                	String minDgPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minDgPricePercent"));
                	
                	String minCsTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minCsTotalPrice"));
                	String minCsPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minCsPrice"));
                	String minCsPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minCsPricePercent"));
                	
                	String minPmTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minPmTotalPrice"));
                	String minPmPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minPmPrice"));
                	String minPmPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minPmPricePercent"));
                	
                	String minHjTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minHjTotalPrice"));
                	String minHjPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minHjPrice"));
                	String minHjPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("minHjPricePercent"));
                	if(!BaseHelpUtils.isNullOrEmpty(minZsTotalPriceValue))minZsTotalPrice.setContents(minZsTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(minZsPriceValue))minZsPrice.setContents(minZsPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(minZsPricePercentValue))minZsPricePercent.setContents(minZsPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(minJdTotalPriceValue))minJdTotalPrice.setContents(minJdTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(minJdPriceValue))minJdPrice.setContents(minJdPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(minJdPricePercentValue))minJdPricePercent.setContents(minJdPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(minDgTotalPriceValue))minDgTotalPrice.setContents(minDgTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(minDgPriceValue))minDgPrice.setContents(minDgPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(minDgPricePercentValue))minDgPricePercent.setContents(minDgPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(minCsTotalPriceValue))minCsTotalPrice.setContents(minCsTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(minCsPriceValue))minCsPrice.setContents(minCsPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(minCsPricePercentValue))minCsPricePercent.setContents(minCsPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(minPmTotalPriceValue))minPmTotalPrice.setContents(minPmTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(minPmPriceValue))minPmPrice.setContents(minPmPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(minPmPricePercentValue))minPmPricePercent.setContents(minPmPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(minHjTotalPriceValue))minHjTotalPrice.setContents(minHjTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(minHjPriceValue))minHjPrice.setContents(minHjPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(minHjPricePercentValue))minHjPricePercent.setContents(minHjPricePercentValue);
                	//获取最近报价的专业项
                	String recentZsTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentZsTotalPrice"));
                	String recentZsPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentZsPrice"));
                	String recentZsPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentZsPricePercent"));
                	
                	String recentJdTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentJdTotalPrice"));
                	String recentJdPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentJdPrice"));
                	String recentJdPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentJdPricePercent"));
                	
                	String recentDgTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentDgTotalPrice"));
                	String recentDgPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentDgPrice"));
                	String recentDgPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentDgPricePercent"));
                	
                	String recentCsTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentCsTotalPrice"));
                	String recentCsPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentCsPrice"));
                	String recentCsPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentCsPricePercent"));
                	
                	String recentPmTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentPmTotalPrice"));
                	String recentPmPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentPmPrice"));
                	String recentPmPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentPmPricePercent"));
                	
                	String recentHjTotalPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentHjTotalPrice"));
                	String recentHjPriceValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentHjPrice"));
                	String recentHjPricePercentValue = BaseHelpUtils.getString(dsResponse.getAttributeAsMap("userData").get("recentHjPricePercent"));
                	if(!BaseHelpUtils.isNullOrEmpty(recentZsTotalPriceValue))recentZsTotalPrice.setContents(recentZsTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(recentZsPriceValue))recentZsPrice.setContents(recentZsPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(recentZsPricePercentValue))recentZsPricePercent.setContents(recentZsPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(recentJdTotalPriceValue))recentJdTotalPrice.setContents(recentJdTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(recentJdPriceValue))recentJdPrice.setContents(recentJdPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(recentJdPricePercentValue))recentJdPricePercent.setContents(recentJdPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(recentDgTotalPriceValue))recentDgTotalPrice.setContents(recentDgTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(recentDgPriceValue))recentDgPrice.setContents(recentDgPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(recentDgPricePercentValue))recentDgPricePercent.setContents(recentDgPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(recentCsTotalPriceValue))recentCsTotalPrice.setContents(recentCsTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(recentCsPriceValue))recentCsPrice.setContents(recentCsPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(recentCsPricePercentValue))recentCsPricePercent.setContents(recentCsPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(recentPmTotalPriceValue))recentPmTotalPrice.setContents(recentPmTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(recentPmPriceValue))recentPmPrice.setContents(recentPmPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(recentPmPricePercentValue))recentPmPricePercent.setContents(recentPmPricePercentValue);
                	
                	if(!BaseHelpUtils.isNullOrEmpty(recentHjTotalPriceValue))recentHjTotalPrice.setContents(recentHjTotalPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(recentHjPriceValue))recentHjPrice.setContents(recentHjPriceValue);
                	if(!BaseHelpUtils.isNullOrEmpty(recentHjPricePercentValue))recentHjPricePercent.setContents(recentHjPricePercentValue);
                	
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                loading.destroy();
            }
        });
    }
    
    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSStandardQuote.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @SuppressWarnings("rawtypes")
	@Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_StandardQuoteDesign";
    }
    
    private BigDecimal maxValue;
    private BigDecimal minValue;
    private BigDecimal recentValue;

	public BigDecimal getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}

	public BigDecimal getMinValue() {
		return minValue;
	}

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	public BigDecimal getRecentValue() {
		return recentValue;
	}

	public void setRecentValue(BigDecimal recentValue) {
		this.recentValue = recentValue;
	}
    
}
