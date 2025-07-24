package com.pomplatform.client.company.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.CommonFormat;
import com.pomplatform.client.company.datasource.DSBusinessTypeReportDataSource;
import com.pomplatform.client.company.datasource.DSCompanyIntegralAchieveDataSource;
import com.pomplatform.client.company.datasource.DSCompanyIntegralAnalyzeDataSource;
import com.pomplatform.client.company.datasource.DSCompanyIntegralPayDataSource;
import com.pomplatform.client.company.datasource.DSCompanyIntegralSourceDataSource;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.pomplatform.client.company.datasource.DSSheetTotalByBusinessTypeDataSource;
import com.pomplatform.client.company.datasource.DSSheetTotalByProjectTypeDataSource;
import com.pomplatform.client.company.datasource.DSsheetTotalByPlateIdDataSource;
import com.pomplatform.client.plateIntegralSends.datasource.DSPlateIntegralSend;
import com.pomplatform.client.plateIntegralSends.panel.CustomPlateIntegralSendPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CompanyReportIntegralForm2 extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    
    private VLayout totalLayout;
    private HLayout topVLayout;
    private HLayout topLeftHLayout;
    private VLayout topRightHLayout;
    private VLayout contextVLayout;
    private DynamicForm dateForm;
    private final HLayout hLayout;
    private final VLayout vLayout;
    private VLayout girdVLayout;
    private final VLayout controlLayout;
    private DelicacyListGrid resultGrid;
    
    private DateItem startDateItem;
    private DateItem endDateItem;
    private IButton calculateButton;
    
    private final IButton searchButton;
    private final IButton refreshButton;
    private final IButton totalButton;
    private final IButton companySubsidyButton;
    private final IButton winButton;
    private final IButton complaintButton;
    
    //定义左边gird的字段名称开始*************************
    private final String sheetTotalIntegral = "订单总积分";
    private final String companySubsidy = "公司补贴";
    private final String winIntegral = "中标奖金";
    
    private final String complaintIntegral = "投诉保证金";
    private final String projectIntegralExtract = "项目积分提取";
    
    private final String awardSend = "奖金发放";
    
    private final String achieveIntegral = "账户余额";
    private final String signingMoneySum = "合同总额";
    private final String percent = "比率";
    
    private final String total = "汇总";
    
    //设置默认加载订单总积分
    private String loadFlag =  sheetTotalIntegral;
    
    //定义左边gird的字段名称结束*************************
    
    //定义左边的汇总数据集的gird开始***********************
    
    //印钞机gird
    private DelicacyListGrid sourceGrid;
    //收入gird
    private DelicacyListGrid achieveGrid;
    //支出grid
    private DelicacyListGrid payGrid;
    //分析栏grid
    private DelicacyListGrid analyzeGrid;
    
    //定义左边的汇总数据集的gird结束***********************
    
    //业务类别 搜索框
    private ComboBoxItem businessType;
    //项目类别 搜索框
    private ComboBoxItem projectType;
    //承接部门 搜索框
    private ComboBoxItem plateId;
    
    //定义订单总积分的明细操作标示
    //业务类别
    public static final int flag_businessType = 1;
    //项目类别
    public static final int flag_projectType = 2;
    //承接部门
    public static final int flag_plateId = 3;
    //搜索操作
    public static final int flag_default = 4;
    //加载订单总积分或者订单积分的时候默认加载搜索操作
    public int sheet_type_flag = flag_default;

    public CompanyReportIntegralForm2() {
    	//印钞机gird
    	sourceGrid = new DelicacyListGrid();
    	sourceGrid.setHeight("25%");
    	DSCompanyIntegralSourceDataSource recordDataSource = DSCompanyIntegralSourceDataSource.getInstance();
    	sourceGrid.setDataSource(recordDataSource);
    	
    	//收入gird
    	achieveGrid = new DelicacyListGrid();
    	achieveGrid.setHeight("25%");
    	DSCompanyIntegralAchieveDataSource achieveDataSource = DSCompanyIntegralAchieveDataSource.getInstance();
    	achieveGrid.setDataSource(achieveDataSource);
    	
    	//支出grid
    	payGrid = new DelicacyListGrid();
    	payGrid.setHeight("25%");
    	DSCompanyIntegralPayDataSource payDataSource = DSCompanyIntegralPayDataSource.getInstance();
    	payGrid.setDataSource(payDataSource);
    	
    	//分析栏grid
    	analyzeGrid = new DelicacyListGrid();
    	analyzeGrid.setHeight("25%");
    	DSCompanyIntegralAnalyzeDataSource analyzeDataSouce = DSCompanyIntegralAnalyzeDataSource.getInstance();
    	analyzeGrid.setDataSource(analyzeDataSouce);
        
        vLayout = new VLayout(10);
        vLayout.setBackgroundColor("#e2e2e2");
        vLayout.setHeight100();
        vLayout.setWidth("25%");
        vLayout.setOverflow(Overflow.AUTO);
        vLayout.setMargin(20);
        vLayout.addMember(sourceGrid);
        vLayout.addMember(achieveGrid);
        vLayout.addMember(payGrid);
        vLayout.addMember(analyzeGrid);
        
        hLayout = new HLayout(10);
        hLayout.setWidth100();
        hLayout.setHeight100();
        hLayout.addMember(vLayout);
        
        girdVLayout = new VLayout(10);
        girdVLayout.setWidth("70%");
        girdVLayout.setHeight100();
        
        resultGrid = new DelicacyListGrid();
        resultGrid.setShowRowNumbers(true);
        
        girdVLayout.addMember(resultGrid);
		
		hLayout.addMember(girdVLayout);
		
		controlLayout = new VLayout();
		controlLayout.setBackgroundColor("#e2e2e2");
        controlLayout.setHeight100();
        controlLayout.setWidth("5%");
        controlLayout.setLayoutTopMargin(10);
        controlLayout.setLayoutLeftMargin(5);
        controlLayout.setLayoutRightMargin(5);
        controlLayout.setMembersMargin(10);
        
        searchButton = new IButton("搜索");
        refreshButton = new IButton("重置");
        totalButton = new IButton("汇总");
        companySubsidyButton = PermissionControl.createPermissionButton("公司补贴",ERPPermissionStatic.COMPANY_ACCOUNT_COMPANY_ADVANCE);
        winButton = PermissionControl.createPermissionButton("中标奖金",ERPPermissionStatic.COMPANY_ACCOUNT_WIN_AWARD);;
        complaintButton = PermissionControl.createPermissionButton("投诉处理",ERPPermissionStatic.COMPANY_ACCOUNT_COMPLAINT_HANDEL);;
        
        controlLayout.addMember(searchButton);
        controlLayout.addMember(refreshButton);
        controlLayout.addMember(totalButton);
        controlLayout.addMember(companySubsidyButton);
        controlLayout.addMember(winButton);
        controlLayout.addMember(complaintButton);
        hLayout.addMember(controlLayout);
        
        topLeftHLayout = new HLayout();
        topLeftHLayout.setWidth("25%");
        
        startDateItem = new DateItem("startDate", "开始年月份");
        startDateItem.setDefaultValue(new Date());
        startDateItem.setShowIcons(false);
        startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        endDateItem = new DateItem("endDate", "结束年月份");
        endDateItem.setDefaultValue(new Date());
        endDateItem.setShowIcons(false);
        endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        dateForm = new DynamicForm();
        dateForm.setWidth("70%");
        dateForm.setHeight100();
        dateForm.setNumCols(5);
        dateForm.setMargin(10);
        dateForm.setItems(startDateItem,endDateItem);
        
        calculateButton = new IButton("账户统计");
        
        topRightHLayout = new VLayout();
        topRightHLayout.setBackgroundColor("#e2e2e2");
        topRightHLayout.setHeight100();
        topRightHLayout.setWidth("5%");
        topRightHLayout.setLayoutTopMargin(10);
        topRightHLayout.setLayoutLeftMargin(5);
        topRightHLayout.setLayoutRightMargin(5);
        topRightHLayout.setMembersMargin(10);
        
        topRightHLayout.addMember(calculateButton);
        
        topVLayout = new HLayout();
        topVLayout.setWidth100();
        topVLayout.setHeight("5%");
        topVLayout.setBackgroundColor("#e2e2e2");
        topVLayout.addMember(topLeftHLayout);
        topVLayout.addMember(dateForm);
        topVLayout.addMember(topRightHLayout);
        
        contextVLayout = new VLayout();
        contextVLayout.setWidth100();
        contextVLayout.setHeight("95%");
        contextVLayout.addMember(hLayout);
        
        totalLayout = new VLayout(10);
        totalLayout.setWidth100();
        totalLayout.setHeight100();
        totalLayout.addMember(topVLayout);
        totalLayout.addMember(contextVLayout);
        
        addMember(totalLayout);
        
        calculateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				onSearch();
			}
		});
        
    	//左边grid双击事件处理开始**********************************
        sourceGrid.addDoubleClickHandler(new com.smartgwt.client.widgets.events.DoubleClickHandler() {
			@Override
			public void onDoubleClick(com.smartgwt.client.widgets.events.DoubleClickEvent event) {
				ListGridRecord[] selected = sourceGrid.getSelectedRecords();
				//获取名称
				String name = selected[0].getAttribute("name");
				if(sheetTotalIntegral.equals(name)){//订单总积分双击
					loadFlag = sheetTotalIntegral;
					sheet_type_flag = flag_default;
					getDefaultLoad();
				}else if(companySubsidy.equals(name)){//公司补贴双击
					loadFlag = companySubsidy;
					removeChilds();
					DSPlateIntegralSend ds = DSPlateIntegralSend.getInstance();
					resultGrid.setDataSource(ds);
		            girdVLayout.addMember(resultGrid);
		            getLoad();
				}else if(winIntegral.equals(name)){//中标奖金双击
					
				}
			}
		});
        
        //左边grid双击事件处理结束**********************************
        
        //右边按钮点击事件处理开始***********************************
        
        //搜索按钮处理事件
        searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				DSBusinessTypeReportDataSource ds;
				switch(loadFlag){
		    	case sheetTotalIntegral://订单总积分
		    		__logger.info("订单总积分");
		    		sheet_type_flag = flag_default;
		    		ds = DSBusinessTypeReportDataSource.getInstance();
		        	resultGrid.setDataSource(ds);
		    		getLoad();
		    		break;
		    	case companySubsidy://公司补贴
		    		__logger.info("公司补贴");
		    		break;
		    	case winIntegral://中标奖金
		    		__logger.info("中标奖金");
		    		break;
		    	}
			}
		});
        
        //重置按钮处理事件
        refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				switch(loadFlag){
		    	case sheetTotalIntegral://订单总积分
		    		__logger.info("订单总积分");
		    		sheet_type_flag = flag_default;
		    		businessType.setValue("");
		    		projectType.setValue("");
		    		plateId.setValue("");
		    		getLoad();
		    		break;
		    	case companySubsidy://公司补贴
		    		__logger.info("公司补贴");
		    		getLoad();
		    		break;
		    	case winIntegral://中标奖金
		    		__logger.info("中标奖金");
		    		break;
		    	}
				
			}
		});
        
        //汇总按钮处理事件
        totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				switch(loadFlag){
		    	case sheetTotalIntegral://订单总积分
		    		__logger.info("订单总积分");
		    		onSheetIntegralTotal();
		    		break;
		    	case companySubsidy://公司补贴
		    		__logger.info("公司补贴");
		    		onCompanyAdvanceTotal();
		    		break;
		    	case winIntegral://中标奖金
		    		__logger.info("中标奖金");
		    		break;
		    	}
				
			}
		});
        
        //公司补贴按钮点击触发事件
        companySubsidyButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				CustomPlateIntegralSendPanel panel = new CustomPlateIntegralSendPanel();
				double achieveIntegral = 0;
				panel.setAchieveIntegral(new BigDecimal(achieveIntegral));
				PopupWindow window = new PopupWindow();
				window.setTitle("公司补贴（公司余额："+CommonFormat.doubleFormat(achieveIntegral)+"）");
				window.setWidth100();
				window.setHeight100();
				window.addMember(panel);
				window.centerInPage();
				panel.commonQuery();
				window.show();
			}
		});
        
    }

    @Override
    public void startEdit() {
    	onSearch();
    	getDefaultLoad();
    }
    
    //搜索方法
    private void onSearch(){
    	//获取开始日期
		Date startDateValue = startDateItem.getValueAsDate();
		//开始日期初始化为第一天
		startDateValue.setDate(1);
		//获取结束日期
		Date endDateValue = endDateItem.getValueAsDate();
		int month = endDateValue.getMonth();
		//设置当前月累加一个月,并初始化为第一天
		endDateValue.setMonth(month+1);
		endDateValue.setDate(1);
		if(startDateValue.after(endDateValue)){
			SC.say("提示","开始年月份不可大于结束年月份");
			return;
		}
		setStartDate(startDateValue);
		setEndDate(endDateValue);
		getGridData();
    }
    
    //加载页面时加载左边gird的数据集
    public void getGridData(){
    	Map param = new HashMap<>();
		param.put("optType","onAccountCompanyIntegral");
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		DBDataSource.callOperation("EP_OnAboutCompanyIntegral", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record record = dsResponse.getData()[0];
					if(record != null){
						//定义印钞机数据集存放的map
						Map<String,Object> sourceMap = new HashMap<>();
						//订单总积分
						double sheetTotalIntegralValue = ClientUtil.checkAndGetDoubleValue(record.getAttribute("sheetTotalIntegral"));
						sourceMap.put(sheetTotalIntegral,sheetTotalIntegralValue);
						//公司补贴
						double companySubsidyValue = ClientUtil.checkAndGetDoubleValue(record.getAttribute("companySubsidy"));
						sourceMap.put(companySubsidy,companySubsidyValue);
						//中标奖金
						double winIntegralValue = ClientUtil.checkAndGetDoubleValue(record.getAttribute("winIntegral"));
						sourceMap.put(winIntegral,winIntegralValue);
						//汇总
						double sourceTotal = sheetTotalIntegralValue+companySubsidyValue+winIntegralValue;
						sourceMap.put(total,sourceTotal);
						
						//定义收入数据集存放的map
						Map<String,Object> achieveMap = new HashMap<>();
						//投诉保证金
						double complaintIntegralValue = ClientUtil.checkAndGetDoubleValue(record.getAttribute("complaintIntegral"));
						achieveMap.put(complaintIntegral,complaintIntegralValue);
						//项目积分提取
						double projectIntegralExtractValue = ClientUtil.checkAndGetDoubleValue(record.getAttribute("projectIntegralExtract"));
						achieveMap.put(projectIntegralExtract,projectIntegralExtractValue);
						//汇总
						double achieveTotal = complaintIntegralValue+projectIntegralExtractValue;
						achieveMap.put(total, achieveTotal);
						
						//定义支出数据集存放的map
						Map<String,Object> payMap = new HashMap<>();
						//奖金发放
						payMap.put(awardSend,record.getAttribute("awardSend"));
						
						//定义分析数据集存放的map
						Map<String,Object> analyzeMap = new HashMap<>();
						//账户余额
						analyzeMap.put(achieveIntegral,record.getAttribute("achieveIntegral"));
						//合同总额
						analyzeMap.put(signingMoneySum,record.getAttribute("signingMoneySum"));
						//比率
						analyzeMap.put(percent,record.getAttribute("percent"));
						
						//遍历map设置girdData值
						Record[] sourceRecords = new Record[sourceMap.size()];
						Record sourceRecord;
						int source_i = 0;
						for(String key : sourceMap.keySet()){
							sourceRecord = new Record();
							sourceRecord.setAttribute("name",key);
							sourceRecord.setAttribute("integral", sourceMap.get(key));
							sourceRecords[source_i] = sourceRecord;
							source_i++;
						}
						sourceGrid.setData(sourceRecords);
						sourceGrid.selectRecord(0);
						
						Record[] achieveRecords = new Record[achieveMap.size()];
						Record achieveRecord;
						int achieve_i = 0;
						for(String key : achieveMap.keySet()){
							achieveRecord = new Record();
							achieveRecord.setAttribute("name",key);
							achieveRecord.setAttribute("integral", achieveMap.get(key));
							achieveRecords[achieve_i] = achieveRecord;
							achieve_i++;
						}
						achieveGrid.setData(achieveRecords);
						
						Record[] payRecords = new Record[payMap.size()];
						Record payRecord;
						int pay_i = 0;
						for(String key : payMap.keySet()){
							payRecord = new Record();
							payRecord.setAttribute("name",key);
							payRecord.setAttribute("integral", payMap.get(key));
							payRecords[pay_i] = payRecord;
							pay_i++;
						}
						payGrid.setData(payRecords);
						
						Record[] analyzeRecords = new Record[analyzeMap.size()];
						Record analyzeRecord;
						int analyze_i = 0;
						for(String key : analyzeMap.keySet()){
							analyzeRecord = new Record();
							analyzeRecord.setAttribute("name",key);
							analyzeRecord.setAttribute("result", analyzeMap.get(key));
							analyzeRecords[analyze_i] = analyzeRecord;
							analyze_i++;
						}
						analyzeGrid.setData(analyzeRecords);
					}
					
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
    	
    }

    //加载页面时默认加载订单总积分
    public void getDefaultLoad() {
    	removeChilds();
    	//按钮搜搜栏
    	HLayout searchButtonHLayout = new HLayout(10);
    	searchButtonHLayout.setWidth100();
    	searchButtonHLayout.setHeight("5%");
    	searchButtonHLayout.setBackgroundColor("#e2e2e2");
    	searchButtonHLayout.setLayoutTopMargin(10);
    	searchButtonHLayout.setAlign(Alignment.CENTER);
    	
    	//文本搜索栏
    	HLayout searchTextHLayout = new HLayout(10);
    	searchTextHLayout.setWidth100();
    	searchTextHLayout.setHeight("5%");
    	searchTextHLayout.setBackgroundColor("#e2e2e2");
    	
    	//向按钮搜索栏添加搜索按钮
    	IButton businessTypeButton = new IButton("业务类别");
    	IButton projectTypeButton = new IButton("项目类别");
    	IButton plateIdButton = new IButton("承接部门");
    	searchButtonHLayout.addMember(businessTypeButton);
    	searchButtonHLayout.addMember(projectTypeButton);
    	searchButtonHLayout.addMember(plateIdButton);
    	
    	//按钮搜索事件处理开始************************************
    	//业务类别按钮点击事件处理
    	businessTypeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				sheet_type_flag = flag_businessType;
				DSSheetTotalByBusinessTypeDataSource ds = DSSheetTotalByBusinessTypeDataSource.getInstance();
				resultGrid.setDataSource(ds);
				getLoad();
			}
		});
    	//项目类别按钮处理事件
    	projectTypeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				sheet_type_flag = flag_projectType;
				DSSheetTotalByProjectTypeDataSource ds = DSSheetTotalByProjectTypeDataSource.getInstance();
				resultGrid.setDataSource(ds);
				getLoad();
			}
		});
    	//承接部门按钮处理事件
    	plateIdButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				sheet_type_flag = flag_plateId;
				DSsheetTotalByPlateIdDataSource ds = DSsheetTotalByPlateIdDataSource.getInstance();
				resultGrid.setDataSource(ds);
				getLoad();
			}
		});
    	//按钮搜索事件处理结束************************************
    	
    	//项目文本搜索栏添加文本搜索项
    	DynamicForm __searchForm = new DynamicForm();
    	__searchForm.setNumCols(7);
    	ClientUtil.DynamicFormProcessAccordingToDevice(__searchForm);
    	businessType = new ComboBoxItem("业务类别");
    	businessType.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
    	projectType = new ComboBoxItem("项目类别");
    	projectType.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
    	plateId = new ComboBoxItem("承接部门");
    	plateId.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
    	__searchForm.setItems(businessType,projectType,plateId);
    	searchTextHLayout.addMember(__searchForm);
    	
    	resultGrid.setWidth100();
    	DSBusinessTypeReportDataSource ds = DSBusinessTypeReportDataSource.getInstance();
    	resultGrid.setDataSource(ds);
        resultGrid.setHeight("90%");
        girdVLayout.addMember(searchButtonHLayout);
        girdVLayout.addMember(searchTextHLayout);
        girdVLayout.addMember(resultGrid);
        getLoad();
    }
    
    //中间明细面板初始化
    public void removeChilds(){
    	Canvas[] childs = girdVLayout.getChildren();
    	if(childs.length > 0){
    		for(Canvas child : childs){
    			girdVLayout.removeChild(child);
    		}
    	}
    }
    
    //加载gird的数据集
    public void getLoad() {
    	Map<String, Object> param;
    	switch(loadFlag){
    	case sheetTotalIntegral://订单总积分
    		__logger.info("订单总积分");
    		param = new HashMap<>();
    		param.put("startDate", startDate);
    		param.put("endDate", endDate);
    		if(sheet_type_flag == flag_businessType){
    			param.put("optType","onLoadSheetIntegralBusinessType");
    		}else if(sheet_type_flag == flag_projectType){
    			param.put("optType","onLoadSheetIntegralProjectType");
    		}else if(sheet_type_flag == flag_plateId){
    			param.put("optType","onLoadSheetIntegralPlateId");
    		}else{
    			param.put("optType","onLoadSheetIntegralDefault");
    		}
    		param.put("businessType",businessType.getValue());
    		param.put("projectType",projectType.getValue());
    		param.put("plateId",plateId.getValue());
    		DBDataSource.callOperation("EP_OnAboutCompanyIntegral", param, new DSCallback() {
    			@Override
    			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
    				if (dsResponse.getStatus() >= 0) {
    					resultGrid.setData(dsResponse.getData());
    				} else {
    					SC.say(dsResponse.getErrors().get("errorMsg").toString());
    				}
    			}
    		});
    		break;
    	case companySubsidy://公司补贴
    		__logger.info("公司补贴");
    		param = new HashMap<>();
    		param.put("startDate", startDate);
    		param.put("endDate", endDate);
    		param.put("optType","onLoadCompanyAdvance");
    		DBDataSource.callOperation("EP_OnAboutCompanyIntegral", param, new DSCallback() {
    			@Override
    			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
    				if (dsResponse.getStatus() >= 0) {
    					resultGrid.setData(dsResponse.getData());
    				} else {
    					SC.say(dsResponse.getErrors().get("errorMsg").toString());
    				}
    			}
    		});
    		break;
    	case winIntegral://中标奖金
    		__logger.info("中标奖金");
    		param = new HashMap<>();
    		param.put("startDate", startDate);
    		param.put("endDate", endDate);
    		param.put("optType","onAccountCompanyIntegral");
    		DBDataSource.callOperation("EP_OnAboutCompanyIntegral", param, new DSCallback() {
    			@Override
    			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
    				if (dsResponse.getStatus() >= 0) {
    					resultGrid.setData(dsResponse.getData());
    				} else {
    					SC.say(dsResponse.getErrors().get("errorMsg").toString());
    				}
    			}
    		});
    		break;
    	}
    }
    
    //订单总积分的汇总
    private void onSheetIntegralTotal(){
    	ListGridRecord[] recordList = resultGrid.getRecords();
    	int len = recordList.length;
    	Record[] records = new Record[len + 1];
    	if(sheet_type_flag == flag_businessType){
			if (len > 0) {
				double sheetTotalIntegral = 0;
				for (int i = 0; i < len; i++) {
					if ("汇总".equals(recordList[i].getAttribute("businessType"))) {// 如果已经存在汇总，则不可再进行汇总
						return;
					}
					sheetTotalIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("sheetTotalIntegral"));
					records[i] = recordList[i];
				}
				Record record = new Record();
				record.setAttribute("businessType", "汇总");
				record.setAttribute("sheetTotalIntegral", sheetTotalIntegral);
				records[len] = record;
				resultGrid.setData(records);
				resultGrid.redraw();
			}
		}else if(sheet_type_flag == flag_projectType){
			if (len > 0) {
				double sheetTotalIntegral = 0;
				for (int i = 0; i < len; i++) {
					if ("汇总".equals(recordList[i].getAttribute("projectType"))) {// 如果已经存在汇总，则不可再进行汇总
						return;
					}
					sheetTotalIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("sheetTotalIntegral"));
					records[i] = recordList[i];
				}
				Record record = new Record();
				record.setAttribute("projectType", "汇总");
				record.setAttribute("sheetTotalIntegral", sheetTotalIntegral);
				records[len] = record;
				resultGrid.setData(records);
				resultGrid.redraw();
			}
		}else if(sheet_type_flag == flag_plateId){
			if (len > 0) {
				double sheetTotalIntegral = 0;
				for (int i = 0; i < len; i++) {
					if ("汇总".equals(recordList[i].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
						return;
					}
					sheetTotalIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("sheetTotalIntegral"));
					records[i] = recordList[i];
				}
				Record record = new Record();
				record.setAttribute("plateId", "汇总");
				record.setAttribute("sheetTotalIntegral", sheetTotalIntegral);
				records[len] = record;
				resultGrid.setData(records);
				resultGrid.redraw();
			}
		}else{
			if (len > 0) {
				double sheetTotalIntegral = 0;
				for (int i = 0; i < len; i++) {
					if ("汇总".equals(recordList[i].getAttribute("businessType"))) {// 如果已经存在汇总，则不可再进行汇总
						return;
					}
					sheetTotalIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("sheetTotalIntegral"));
					records[i] = recordList[i];
				}
				Record record = new Record();
				record.setAttribute("businessType", "汇总");
				record.setAttribute("sheetTotalIntegral", sheetTotalIntegral);
				records[len] = record;
				resultGrid.setData(records);
				resultGrid.redraw();
			}
		}
    }
    
    //公司补贴的汇总
    private void onCompanyAdvanceTotal(){
    	ListGridRecord[] recordList = resultGrid.getRecords();
    	int len = recordList.length;
    	Record[] records = new Record[len + 1];
    	if (len > 0) {
    		double sendIntegral = 0;
    		for (int i = 0; i < len; i++) {
    			if ("汇总".equals(recordList[i].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
    				return;
    			}
    			sendIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("sendIntegral"));
    			records[i] = recordList[i];
    		}
    		Record record = new Record();
    		record.setAttribute("plateId", "汇总");
    		record.setAttribute("sendIntegral", sendIntegral);
    		records[len] = record;
    		resultGrid.setData(records);
    		resultGrid.redraw();
    	}
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSCompanyReportIntegralDataSource.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_CompanyReportIntegral";
    }
    
    private Date startDate = new Date();
    private Date endDate = new Date();

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
}
