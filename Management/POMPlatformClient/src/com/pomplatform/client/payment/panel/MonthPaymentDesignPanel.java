package com.pomplatform.client.payment.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.pomplatform.client.payment.datasource.DSOnLoadEmployeePayment;
import com.pomplatform.client.payment.datasource.DSOnLoadEmployeePaymentDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class MonthPaymentDesignPanel extends AbstractWizadPage {
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
    //定义月薪详情面板
    private HLayout monthPaymentLayout;
    //定义月薪详情设计面板
    private VLayout monthPaymentDesignLayout;
    
    //定义数据集的gird开始***********************
    
    //调薪详细gird
    private DelicacyListGrid paymentGrid;
    //月薪详情gird
    private DelicacyListGrid monthPaymentGrid;
    
    private DynamicForm __infoForm; 
    private SelectItem yearItem;
    private SelectItem monthItem;
    private IButton searchIbutton;
    private IButton resetIbutton;
    
    //定义数据集的girdgird结束***********************
    
    @SuppressWarnings("deprecation")
	public MonthPaymentDesignPanel() {
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
		
		Date currentDate = new Date();
		yearItem=new SelectItem("year","年份");
		yearItem.setWidth(280);
		yearItem.setHeight(26);
		yearItem.setDefaultValue(currentDate.getYear()+1900);
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		monthItem=new SelectItem("month","月份");
		monthItem.setWidth(280);
		monthItem.setHeight(26);
		monthItem.setDefaultValue(currentDate.getMonth()+1);
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
    	
    	HLayout vbtn=new HLayout(10);
        searchIbutton=new IButton("搜索");
        searchIbutton.setHeight(26);
        resetIbutton=new IButton("重置");
        resetIbutton.setHeight(26);
        vbtn.setLayoutTopMargin(15);
        vbtn.addMember(searchIbutton);
        vbtn.addMember(resetIbutton);
        
        __infoForm.setFields(yearItem,monthItem);
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
    	
    	//月薪详情面板
    	monthPaymentLayout = new HLayout(20);
    	monthPaymentLayout.setLayoutTopMargin(10);
    	monthPaymentLayout.setHeight("80%");
    	monthPaymentLayout.setWidth100();
    	monthPaymentLayout.setMembersMargin(20);
    	buttonLayout.addMember(monthPaymentLayout);
    	
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
    	monthPaymentDesignLayout = new VLayout(20);
    	monthPaymentDesignLayout.setIsGroup(true);
    	monthPaymentDesignLayout.setGroupBorderCSS(layoutGroupStyle);
    	monthPaymentDesignLayout.setGroupLabelBackgroundColor("#555555");
    	monthPaymentDesignLayout.setGroupTitle("月薪详情");
    	monthPaymentDesignLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	monthPaymentDesignLayout.setHeight100();
    	monthPaymentDesignLayout.setWidth100();
    	monthPaymentDesignLayout.setMembersMargin(20);
    	monthPaymentLayout.addMember(monthPaymentDesignLayout);
    	
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
    	
    	int index = 0;
    	ListGridField[] fields = new ListGridField[12];
    	fields[index] = new ListGridField("year","年份");
    	index++;
    	fields[index] = new ListGridField("month","月份");
    	index++;
    	fields[index] = new ListGridField("monthPay","月薪");
    	index++;
    	fields[index] = new ListGridField("basicProportionStr","基本比例");
    	index++;
    	fields[index] = new ListGridField("monthBasicPay","月基本工资");
    	index++;
    	fields[index] = new ListGridField("monthPerformancePay","月绩效工资");
    	index++;
    	fields[index] = new ListGridField("foremanPay","工龄工资");
    	index++;
    	fields[index] = new ListGridField("otherSubsidy","其他补贴");
    	index++;
    	fields[index] = new ListGridField("totalPay","全薪");
    	index++;
    	fields[index] = new ListGridField("annualPerformance","年度绩效");
    	index++;
    	fields[index] = new ListGridField("costAttribution","费用归属");
    	fields[index].setValueMap(KeyValueManager.getValueMap("system_dictionary_114"));
    	
    	//月薪详情
    	monthPaymentGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			return "font-weight:bold; color:#555555;";  
    		}
    	};
    	monthPaymentGrid.setFields(fields);
    	monthPaymentGrid.setHeight100();
    	monthPaymentGrid.setWidth100();
    	monthPaymentGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	monthPaymentGrid.setCanExpandRecords(true);
    	monthPaymentGrid.setCanDragSelectText(true);
    	monthPaymentGrid.setShowGridSummary(true);
    	monthPaymentGrid.setAutoFitFieldWidths(false);
    	monthPaymentDesignLayout.addMember(monthPaymentGrid);
    	
    	//按钮点击事件开始******************************************
    	searchIbutton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//加载月薪详情数据集
		    	loadMonthPaymentData();
			}
		});
    	
    	resetIbutton.hide();
    	resetIbutton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				
			}
		});
    }

    @Override
    public void startEdit() {
    	//加载调薪详情数据集
    	loadPaymentData();
    	//加载日薪详情数据集
    	loadMonthPaymentData();
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
    
    //加载月薪详情数据集
    public void loadMonthPaymentData(){
    	Map<Object,Object> param = new HashMap<>();
    	param.put("employeeId",employeeId);
    	param.put("year", yearItem.getValue());
    	param.put("month", monthItem.getValue());
    	DBDataSource.callOperation("NQ_OnloadEmployeePaymentMonthDetail", "find", param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	monthPaymentGrid.setData(dsResponse.getData());
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
        return "ST_EmployeePaymentMonthDetail";
    }
    
    public int employeeId;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
    
}
