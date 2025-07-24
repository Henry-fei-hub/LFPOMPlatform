package com.pomplatform.client.payment.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.pomplatform.client.payment.datasource.DSOnLoadEmployeePayment;
import com.pomplatform.client.payment.datasource.DSOnLoadEmployeePaymentDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class DayPaymentDesignPanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("");
  	
    //定义面板样式
    private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
    public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    //定义主面板，分上下分层，top层是我的发起图片按钮，button层是我的事务层
    private VLayout mainLayout;
    //定义top层，即装载图片按钮
    private HLayout topLayout;
    
    //定义button层，即我的事务层,包括三层，第一层是待办，第二层是已办，第三层是其它
    private VLayout buttonLayout;
    //定义调薪详情面板
    private HLayout paymentLayout;
    //定义调薪详情设计面板
    private VLayout paymentDesignLayout;
    //定义日薪详情面板
    private HLayout dayPaymentLayout;
    //定义日薪详情设计面板
    private VLayout dayPaymentDesignLayout;
    
    //定义数据集的gird开始***********************
    
    //调薪详细gird
    private DelicacyListGrid paymentGrid;
    //日薪详情gird
    private DelicacyListGrid dayPaymentGrid;
    
    private DynamicForm __infoForm; 
    private DateItem startDateItem;
    private DateItem endDateItem;
    private IButton searchIbutton;
    private IButton resetIbutton;
    
    //定义数据集的girdgird结束***********************
    
    @SuppressWarnings("deprecation")
	public DayPaymentDesignPanel() {
    	//主面板
    	mainLayout = new VLayout(20);
    	mainLayout.setBackgroundColor("#FFF");
    	mainLayout.setHeight100();
    	mainLayout.setWidth100();
    	mainLayout.setMembersMargin(0);
    	addMember(mainLayout);
    	
    	//头部面板
    	topLayout = new HLayout(20);
    	topLayout.setHeight("10%");
    	topLayout.setBorder(BORDER_STYLE);
    	topLayout.setBackgroundColor("#f2f2f2");
    	topLayout.setWidth100();
    	topLayout.setLayoutTopMargin(20);
    	topLayout.setMembersMargin(0);
    	mainLayout.addMember(topLayout);
    	
    	__infoForm = new DynamicForm();
		__infoForm.setWidth("50%");
		__infoForm.setHeight100();
		__infoForm.setNumCols(4);
		__infoForm.setMargin(10);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		
		Date startDate = new Date();
		startDate.setDate(1);
		startDateItem=new DateItem("startDate","开始日期");
		startDateItem.setWidth(280);
		startDateItem.setHeight(26);
		startDateItem.setDefaultValue(startDate);
		startDateItem.setUseTextField(true);
		
		endDateItem=new DateItem("endDate","结束日期");
		endDateItem.setWidth(280);
		endDateItem.setHeight(26);
		endDateItem.setDefaultValue(new Date());
		endDateItem.setUseTextField(true);
    	
    	HLayout vbtn=new HLayout(10);
        searchIbutton=new IButton("搜索");
        searchIbutton.setHeight(26);
        resetIbutton=new IButton("日薪统计");
        resetIbutton.setHeight(26);
        vbtn.setLayoutTopMargin(15);
        vbtn.addMember(searchIbutton);
        vbtn.addMember(resetIbutton);
        
        __infoForm.setFields(startDateItem,endDateItem);
        topLayout.addMember(__infoForm);
        topLayout.addMember(vbtn);
        
    	//底部面板
    	buttonLayout = new VLayout(20);
    	buttonLayout.setHeight("90%");
    	buttonLayout.setWidth100();
    	buttonLayout.setMembersMargin(10);
    	mainLayout.addMember(buttonLayout);
    	
    	//调薪详情面板
    	paymentLayout = new HLayout(20);
    	paymentLayout.setHeight("20%");
    	paymentLayout.setWidth100();
    	paymentLayout.setMembersMargin(20);
    	buttonLayout.addMember(paymentLayout);
    	
    	//日薪详情面板
    	dayPaymentLayout = new HLayout(20);
    	dayPaymentLayout.setLayoutTopMargin(10);
    	dayPaymentLayout.setHeight("80%");
    	dayPaymentLayout.setWidth100();
    	dayPaymentLayout.setMembersMargin(20);
    	buttonLayout.addMember(dayPaymentLayout);
    	
    	//调薪详情设计面板
    	paymentDesignLayout = new VLayout(20);
    	paymentDesignLayout.setIsGroup(true);
    	paymentDesignLayout.setGroupBorderCSS(layoutGroupStyle);
    	paymentDesignLayout.setGroupLabelBackgroundColor("#555555");
    	paymentDesignLayout.setGroupTitle("调薪详情");
    	paymentDesignLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	paymentDesignLayout.setHeight100();
    	paymentDesignLayout.setWidth100();
    	paymentDesignLayout.setMembersMargin(20);
    	paymentLayout.addMember(paymentDesignLayout);
    	
    	//日薪详情设计面板
    	dayPaymentDesignLayout = new VLayout(20);
    	dayPaymentDesignLayout.setIsGroup(true);
    	dayPaymentDesignLayout.setGroupBorderCSS(layoutGroupStyle);
    	dayPaymentDesignLayout.setGroupLabelBackgroundColor("#555555");
    	dayPaymentDesignLayout.setGroupTitle("日薪详情");
    	dayPaymentDesignLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	dayPaymentDesignLayout.setHeight100();
    	dayPaymentDesignLayout.setWidth100();
    	dayPaymentDesignLayout.setMembersMargin(20);
    	dayPaymentLayout.addMember(dayPaymentDesignLayout);
    	
    	DSOnLoadEmployeePayment paymentSource = DSOnLoadEmployeePayment.getInstance();
    	//调薪详情
    	paymentGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			if(rowNum == 0){
    				return "font-weight:bold; color:#27DC35;";  
    			}else{
    				return "font-weight:bold; color:#555555;";
    			}
    		}
    	};
    	paymentGrid.setHeight100();
    	paymentGrid.setWidth100();
    	paymentGrid.setDataSource(paymentSource);
    	paymentGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	paymentGrid.setAutoFitFieldWidths(false);
    	paymentGrid.setCanExpandRecords(true);
    	paymentGrid.setCanDragSelectText(true);
    	paymentDesignLayout.addMember(paymentGrid);
    	
    	DSOnLoadEmployeePaymentDetail source = DSOnLoadEmployeePaymentDetail.getInstance();
    	//日薪详情
    	dayPaymentGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			return "font-weight:bold; color:#555555;";  
    		}
    	};
    	dayPaymentGrid.setHeight100();
    	dayPaymentGrid.setWidth100();
    	dayPaymentGrid.setDataSource(source);
    	dayPaymentGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	dayPaymentGrid.setCanExpandRecords(true);
    	dayPaymentGrid.setCanDragSelectText(true);
    	dayPaymentGrid.setShowGridSummary(true);
    	dayPaymentDesignLayout.addMember(dayPaymentGrid);
    	
    	//按钮点击事件开始******************************************
    	searchIbutton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//加载日薪详情数据集
		    	loadDayPaymentData();
			}
		});
    	
    	resetIbutton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<Object,Object> param = new HashMap<>();
		    	param.put("optType","onResetEmpDayPayment");
		    	param.put("employeeId",employeeId);
		    	//开始日期一定要大于或等于最近调薪的调薪日期
		    	//获取开始日期
		    	Date startDate = startDateItem.getValueAsDate();
		    	//获取结束日期
		    	Date endDate = endDateItem.getValueAsDate();
		    	if(endDate.before(startDate)){
		    		SC.say("提示","结束日期不能早于开始日期");
		    		return;
		    	}
		    	//获取开始日期也结束日期的年月份
		    	DateTimeFormat yearDf = DateTimeFormat.getFormat("yyyy");
		    	DateTimeFormat monthDf = DateTimeFormat.getFormat("MM");
		    	int startDateYear = BaseHelpUtils.getIntValue(yearDf.format(startDate));
		    	int startDateMonth = BaseHelpUtils.getIntValue(monthDf.format(startDate));
		    	int endDateYear = BaseHelpUtils.getIntValue(yearDf.format(endDate));
		    	int endDateMonth = BaseHelpUtils.getIntValue(monthDf.format(endDate));
		    	if(startDateYear != endDateYear && startDateMonth != endDateMonth){
		    		SC.say("提示","开始日期和结束日期需同年同月");
		    		return;
		    	}
		    	param.put("startDate",startDate);
		    	param.put("endDate",endDate);
		    	final LoadingWindow loading = new LoadingWindow();
		    	DBDataSource.callOperation("EP_OnPaymentManageProcess", "find", param, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		            	loading.destroy();
		                if (dsResponse.getStatus() >= 0) {
		                	loadDayPaymentData();
		                } else {
		                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
		                }
		            }
		        });
			}
		});
    }

    @Override
    public void startEdit() {
    	//加载调薪详情数据集
    	loadPaymentData();
    	//加载日薪详情数据集
    	loadDayPaymentData();
    }
    
    //加载调薪详情数据集
    public void loadPaymentData(){
    	Map<Object,Object> param = new HashMap<>();
    	param.put("employeeId",employeeId);
    	DBDataSource.callOperation("NQ_OnLoadEmployeePayment", "find", param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	paymentGrid.setData(dsResponse.getData());
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
            }
        });
    }
    
    //加载日薪详情数据集
    public void loadDayPaymentData(){
    	Map<Object,Object> param = new HashMap<>();
    	param.put("employeeId",employeeId);
    	param.put("startDate",startDateItem.getValue());
    	param.put("endDate",endDateItem.getValue());
    	DBDataSource.callOperation("NQ_OnLoadEmployeePaymentDetail", "find", param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	dayPaymentGrid.setData(dsResponse.getData());
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
            }
        });
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
        return "ST_DayPaymentDesignPanel";
    }
    
    public int employeeId;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
    
}
