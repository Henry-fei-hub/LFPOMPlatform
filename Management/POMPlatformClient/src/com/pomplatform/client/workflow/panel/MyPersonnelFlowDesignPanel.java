package com.pomplatform.client.workflow.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.bonuspayment.panel.BonusPaymentApplyOfWorkflowPanel;
import com.pomplatform.client.bonuspayment.panel.BonusPaymentAttentionOfWorkflowPanel;
import com.pomplatform.client.bonuspayment.panel.BonusPaymentAuditOfWorkflowPanel;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.pomplatform.client.employee.panel.EmployeeInfoOfNoSalaryAdjustmentPanel;
import com.pomplatform.client.employee.panel.PositiveEmployeeInfoPanel;
import com.pomplatform.client.trainingmanagement.panel.trainingManagementAttentionOfWorkflowPanel;
import com.pomplatform.client.trainingmanagement.panel.trainingManagementAuditOfWorkflowPanel;
import com.pomplatform.client.trainingmanagement.panel.trainingManagementsApplyOfWorkflowPanel;
import com.pomplatform.client.workflow.datasource.DSMyWorkflowDatasource;
import com.pomplatform.client.workflow.personnel.panel.ApplicationInForFilingListOfPersonnelPanel;
import com.pomplatform.client.workflow.personnel.panel.ApplicationInForFilingPanel;
import com.pomplatform.client.workflow.personnel.panel.ApplyOfEmployeeOnboardPanel;
import com.pomplatform.client.workflow.personnel.panel.AttentionOfEmployeeOnboardPanel;
import com.pomplatform.client.workflow.personnel.panel.AuditOfEmployeeOnboardPanel;
import com.pomplatform.client.workflow.personnel.panel.OnLoadApplyListOfPersonnelPanel;
import com.pomplatform.client.workflow.personnel.panel.OnLoadAttentionListOfPersonnelPanel;
import com.pomplatform.client.workflow.personnel.panel.OnLoadAuditListOfPersonnelPanel;
import com.pomplatform.client.workflow.personnel.panel.OnLoadRefuseListOfPersonnelPanel;
import com.pomplatform.client.workflow.personnel.panel.RefuseOfEmployeeOnboardPanel;
import com.pomplatform.client.workflow.personnelbusiness.panel.EmployeeSalaryAdjustmentDetailPanel;
import com.pomplatform.client.workflow.personnelbusiness.panel.OnLoadApplyListOfSalaryAdjustmentPanel;
import com.pomplatform.client.workflow.personnelbusiness.panel.OnLoadAttentionListOfSalaryAdjustmentPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class MyPersonnelFlowDesignPanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("");
	private static final String PROCESSID = "processId";
	//定义模块类型
  	public static final int ACTIVITY_TYPE_1 = 1;//我的发起(发起/进行中)
  	public static final int ACTIVITY_TYPE_2 = 2;//我的驳回(已驳回)
  	public static final int ACTIVITY_TYPE_3 = 3;//我的归档(已完成)
  	public static final int ACTIVITY_TYPE_4 = 4;//待办-审核
  	public static final int ACTIVITY_TYPE_5 = 5;//待办-知会
  	public static final int ACTIVITY_TYPE_6 = 6;//待办-任务池
  	public static final int ACTIVITY_TYPE_7 = 7;//已办-审核
  	public static final int ACTIVITY_TYPE_8 = 8;//已办-知会
  	public static final int ACTIVITY_TYPE_9 = 9;//已办-任务池
  	
  	//定义流程类型
  	public static final int PROCESS_TYPE_13 = 13;//请假申请
  	public static final int PROCESS_TYPE_14 = 14;//出差申请
  	public static final int PROCESS_TYPE_15 = 15;//打卡申请
  	public static final int PROCESS_TYPE_16 = 16;//外出申请
  	public static final int PROCESS_TYPE_17 = 17;//加班申请
  	public static final int PROCESS_TYPE_18 = 18;//项目出差申请
  	public static final int PROCESS_TYPE_19 = 19;//出差延期申请
  	public static final int PROCESS_TYPE_20 = 20;//出差更改行程申请
  	public static final int PROCESS_TYPE_21 = 21;//项目派驻申请
  	public static final int PROCESS_TYPE_22 = 22;//项目派驻申请延期
  	public static final int PROCESS_TYPE_23 = 23;//项目派驻确认申请
  	public static final int PROCESS_TYPE_24 = 24;//入职申请
  	public static final int PROCESS_TYPE_25 = 25;//离职申请
  	public static final int PROCESS_TYPE_26 = 26;//转岗申请
  	public static final int PROCESS_TYPE_27 = 27;//确认函申请
  	public static final int PROCESS_TYPE_28 = 28;//员工还款申请
  	public static final int PROCESS_TYPE_29 = 29;//转正申请
  	public static final int PROCESS_TYPE_30 = 30;//调薪申请
  	public static final int PROCESS_TYPE_37 = 37;//薪资发放申请
  	public static final int PROCESS_TYPE_41 = 41;//薪资发放申请
  	public static final int PROCESS_TYPE_45 = 45;//工资异常申请
  	public static final int PROCESS_TYPE_59 = 59;//培训申请流程

	public static final int PROCESS_TYPE_72 = 72;//调档申请流程

  	public static final int PROCESS_TYPE_63 = 63;//奖金发放申请流程
	public static final int PROCESS_TYPE_62 = 62;//劳动合同续签流程
	public static final int PROCESS_TYPE_84 = 84;//劳动合同续签流程

    //定义面板样式
    private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
    public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    //定义主面板，分上下分层，top层是我的发起图片按钮，button层是我的事务层
    private VLayout mainLayout;
    //定义top层，即装载图片按钮
    private VLayout topLayout;
    
    //定义button层，即我的事务层,包括三层，第一层是待办，第二层是已办，第三层是其它
    private VLayout buttonLayout;
    //定义待办层
    private HLayout toDoListLayout;
    //定义已办层
    private HLayout doneListLayout;
    //定义驳回层
    private HLayout otherLayout;
    //定义底层的待办审批
    private VLayout todoListAuditLayout;
    //定义底层的待办知会
    private VLayout todoListAttentionLayout;
    //定义底层的待办任务池
    private VLayout todoListPoolLayout;
    //定义底层的已办审批
    private VLayout doneListAuditLayout;
    //定义底层的已办知会
    private VLayout doneListAttentionLayout;
    //定义底层的已办任务池
    private VLayout doneListPoolLayout;
    //定义底层的我的申请
    private VLayout myApplyLayout;
    //定义底层的我的驳回
    private VLayout myBackLayout;
    //定义底层的我的驳回
    private VLayout myFinishLayout;
    
    
    //定义数据集的gird开始***********************
    
    //待办审批gird
    private DelicacyListGrid todoListAuditGrid;
    //待办知会gird
    private DelicacyListGrid todoListAttentionGrid;
    //待办任务池gird
    private DelicacyListGrid todoListPoolGrid;
    //已办审批gird
    private DelicacyListGrid doneListAuditGrid;
    //已办知会gird
    private DelicacyListGrid doneListAttentionGrid;
    //已办任务池gird
    private DelicacyListGrid doneListPoolGrid;
    //发起/进行中gird
    private DelicacyListGrid myApplyGrid;
    //已驳回gird
    private DelicacyListGrid myBackGrid;
    //已完成gird
    private DelicacyListGrid myFinishGrid;
    
    //定义数据集的girdgird结束***********************
    
    public MyPersonnelFlowDesignPanel() {
    	//主面板
    	mainLayout = new VLayout(20);
    	mainLayout.setBackgroundColor("#FFF");
    	mainLayout.setHeight100();
    	mainLayout.setWidth100();
    	mainLayout.setMembersMargin(20);
    	addMember(mainLayout);
    	
    	//头部面板
    	topLayout = new VLayout(20);
    	topLayout.setHeight("10%");
    	topLayout.setBorder(BORDER_STYLE);
    	topLayout.setBackgroundColor("#f2f2f2");
    	topLayout.setWidth100();
    	topLayout.setMembersMargin(0);
    	mainLayout.addMember(topLayout);
    	getViewPanel();
    	
    	//底部面板
    	buttonLayout = new VLayout(20);
    	buttonLayout.setHeight("90%");
    	buttonLayout.setWidth100();
    	buttonLayout.setMembersMargin(20);
    	mainLayout.addMember(buttonLayout);
    	
    	//待办面板
    	toDoListLayout = new HLayout(20);
    	toDoListLayout.setHeight("30%");
    	toDoListLayout.setWidth100();
    	toDoListLayout.setMembersMargin(20);
    	buttonLayout.addMember(toDoListLayout);
    	
    	//已办面板
    	doneListLayout = new HLayout(20);
    	doneListLayout.setLayoutTopMargin(10);
    	doneListLayout.setHeight("30%");
    	doneListLayout.setWidth100();
    	doneListLayout.setMembersMargin(20);
    	buttonLayout.addMember(doneListLayout);
    	
    	//其它面板
    	otherLayout = new HLayout(20);
    	otherLayout.setLayoutTopMargin(10);
    	otherLayout.setHeight("30%");
    	otherLayout.setWidth100();
    	otherLayout.setMembersMargin(20);
    	buttonLayout.addMember(otherLayout);
    	
    	//定义待办审批面板
    	todoListAuditLayout = new VLayout(20);
    	todoListAuditLayout.setIsGroup(true);
    	todoListAuditLayout.setGroupBorderCSS(layoutGroupStyle);
    	todoListAuditLayout.setGroupLabelBackgroundColor("#555555");
    	todoListAuditLayout.setGroupTitle("待办→审批");
    	todoListAuditLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	todoListAuditLayout.setHeight100();
    	todoListAuditLayout.setWidth("45%");
    	todoListAuditLayout.setMembersMargin(20);
    	toDoListLayout.addMember(todoListAuditLayout);
    	
    	//定义待办知会面板
    	todoListAttentionLayout = new VLayout(20);
    	todoListAttentionLayout.setIsGroup(true);
    	todoListAttentionLayout.setGroupBorderCSS(layoutGroupStyle);
    	todoListAttentionLayout.setGroupLabelBackgroundColor("#555555");
    	todoListAttentionLayout.setGroupTitle("待办→知会");
    	todoListAttentionLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	todoListAttentionLayout.setHeight100();
    	todoListAttentionLayout.setWidth("45%");
    	todoListAttentionLayout.setMembersMargin(20);
    	toDoListLayout.addMember(todoListAttentionLayout);
    	
    	//定义待办任务池面板
    	todoListPoolLayout = new VLayout(20);
    	todoListPoolLayout.setIsGroup(true);
    	todoListPoolLayout.setGroupBorderCSS(layoutGroupStyle);
    	todoListPoolLayout.setGroupLabelBackgroundColor("#555555");
    	todoListPoolLayout.setGroupTitle("待办→任务池");
    	todoListPoolLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	todoListPoolLayout.setHeight100();
    	todoListPoolLayout.setWidth("30%");
    	todoListPoolLayout.setMembersMargin(20);
//    	toDoListLayout.addMember(todoListPoolLayout);
    	
    	//定义已办审批面板
    	doneListAuditLayout = new VLayout(20);
    	doneListAuditLayout.setIsGroup(true);
    	doneListAuditLayout.setGroupBorderCSS(layoutGroupStyle);
    	doneListAuditLayout.setGroupLabelBackgroundColor("#555555");
    	doneListAuditLayout.setGroupTitle("已办→审批");
    	doneListAuditLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	doneListAuditLayout.setHeight100();
    	doneListAuditLayout.setWidth("45%");
    	doneListAuditLayout.setMembersMargin(20);
    	doneListLayout.addMember(doneListAuditLayout);
    	
    	//定义已办知会面板
    	doneListAttentionLayout = new VLayout(20);
    	doneListAttentionLayout.setIsGroup(true);
    	doneListAttentionLayout.setGroupBorderCSS(layoutGroupStyle);
    	doneListAttentionLayout.setGroupLabelBackgroundColor("#555555");
    	doneListAttentionLayout.setGroupTitle("已办→知会");
    	doneListAttentionLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	doneListAttentionLayout.setHeight100();
    	doneListAttentionLayout.setWidth("45%");
    	doneListAttentionLayout.setMembersMargin(20);
    	doneListLayout.addMember(doneListAttentionLayout);
    	
    	//定义已办任务池面板
    	doneListPoolLayout = new VLayout(20);
    	doneListPoolLayout.setIsGroup(true);
    	doneListPoolLayout.setGroupBorderCSS(layoutGroupStyle);
    	doneListPoolLayout.setGroupLabelBackgroundColor("#555555");
    	doneListPoolLayout.setGroupTitle("已办→任务池");
    	doneListPoolLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	doneListPoolLayout.setHeight100();
    	doneListPoolLayout.setWidth("30%");
    	doneListPoolLayout.setMembersMargin(20);
//    	doneListLayout.addMember(doneListPoolLayout);
    	
    	//定义我的申请面板
    	myApplyLayout = new VLayout(20);
    	myApplyLayout.setIsGroup(true);
    	myApplyLayout.setGroupBorderCSS(layoutGroupStyle);
    	myApplyLayout.setGroupLabelBackgroundColor("#555555");
    	myApplyLayout.setGroupTitle("发起/进行中");
    	myApplyLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	myApplyLayout.setHeight100();
    	myApplyLayout.setWidth("45%");
    	myApplyLayout.setMembersMargin(20);
    	otherLayout.addMember(myApplyLayout);
    	
    	//定义我的驳回面板
    	myBackLayout = new VLayout(20);
    	myBackLayout.setIsGroup(true);
    	myBackLayout.setGroupBorderCSS(layoutGroupStyle);
    	myBackLayout.setGroupLabelBackgroundColor("#555555");
    	myBackLayout.setGroupTitle("已驳回");
    	myBackLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	myBackLayout.setHeight100();
    	myBackLayout.setWidth("30%");
    	myBackLayout.setMembersMargin(20);
//    	otherLayout.addMember(myBackLayout);
    	
    	//定义已完成面板
    	myFinishLayout = new VLayout(20);
    	myFinishLayout.setIsGroup(true);
    	myFinishLayout.setGroupBorderCSS(layoutGroupStyle);
    	myFinishLayout.setGroupLabelBackgroundColor("#555555");
    	myFinishLayout.setGroupTitle("已驳回/已完成");
    	myFinishLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
    	myFinishLayout.setHeight100();
    	myFinishLayout.setWidth("45%");
    	myFinishLayout.setMembersMargin(20);
    	otherLayout.addMember(myFinishLayout);
    	
    	DSMyWorkflowDatasource source = DSMyWorkflowDatasource.getInstance();
    	//待办审批
    	todoListAuditGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			return "font-weight:bold; color:#27DC35;";  
    		}
    	};
    	todoListAuditGrid.setHeight100();
    	todoListAuditGrid.setWidth100();
    	todoListAuditGrid.setDataSource(source);
    	todoListAuditGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	todoListAuditGrid.setAutoFitFieldWidths(true);
    	todoListAuditGrid.setCanExpandRecords(true);
    	todoListAuditGrid.setCanDragSelectText(true);
    	todoListAuditLayout.addMember(todoListAuditGrid);
    	
    	//待办知会
    	todoListAttentionGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			return "font-weight:bold; color:#27DC35;";  
    		}
    	};
    	todoListAttentionGrid.setHeight100();
    	todoListAttentionGrid.setWidth100();
    	todoListAttentionGrid.setDataSource(source);
    	todoListAttentionGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	todoListAttentionGrid.setAutoFitFieldWidths(true);
    	todoListAttentionGrid.setCanExpandRecords(true);
    	todoListAttentionGrid.setCanDragSelectText(true);
    	todoListAttentionLayout.addMember(todoListAttentionGrid);
    	
    	//待办任务池
    	todoListPoolGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			return "font-weight:bold; color:#27DC35;";  
    		}
    	};
    	todoListPoolGrid.setHeight100();
    	todoListPoolGrid.setWidth100();
    	todoListPoolGrid.setDataSource(source);
    	todoListPoolGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	todoListPoolGrid.setAutoFitFieldWidths(true);
    	todoListPoolGrid.setCanExpandRecords(true);
    	todoListPoolGrid.setCanDragSelectText(true);
    	todoListPoolLayout.addMember(todoListPoolGrid);
    	
    	//已办审核
    	doneListAuditGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			return "font-weight:bold; color:#555555;";  
    		}
    	};
    	doneListAuditGrid.setHeight100();
    	doneListAuditGrid.setWidth100();
    	doneListAuditGrid.setDataSource(source);
    	doneListAuditGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	doneListAuditGrid.setAutoFitFieldWidths(true);
    	doneListAuditGrid.setCanExpandRecords(true);
    	doneListAuditGrid.setCanDragSelectText(true);
    	doneListAuditLayout.addMember(doneListAuditGrid);
    	
    	//已办知会
    	doneListAttentionGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			return "font-weight:bold; color:#555555;";  
    		}
    	};
    	doneListAttentionGrid.setHeight100();
    	doneListAttentionGrid.setWidth100();
    	doneListAttentionGrid.setDataSource(source);
    	doneListAttentionGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	doneListAttentionGrid.setAutoFitFieldWidths(true);
    	doneListAttentionGrid.setCanExpandRecords(true);
    	doneListAttentionGrid.setCanDragSelectText(true);
    	doneListAttentionLayout.addMember(doneListAttentionGrid);
    	
    	//已办任务池
    	doneListPoolGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			return "font-weight:bold; color:#555555;";  
    		}
    	};
    	doneListPoolGrid.setHeight100();
    	doneListPoolGrid.setWidth100();
    	doneListPoolGrid.setDataSource(source);
    	doneListPoolGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	doneListPoolGrid.setAutoFitFieldWidths(true);
    	doneListPoolGrid.setCanExpandRecords(true);
    	doneListPoolGrid.setCanDragSelectText(true);
    	doneListPoolLayout.addMember(doneListPoolGrid);
    	
    	//我的发起/进行中
    	myApplyGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			return "font-weight:bold; color:red;";  
    		}
    	};
    	myApplyGrid.setHeight100();
    	myApplyGrid.setWidth100();
    	myApplyGrid.setDataSource(source);
    	myApplyGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	myApplyGrid.setAutoFitFieldWidths(true);
    	myApplyGrid.setCanExpandRecords(true);
    	myApplyGrid.setCanDragSelectText(true);
    	myApplyLayout.addMember(myApplyGrid);
    	
    	//已驳回
    	myBackGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			return "font-weight:bold; color:#4fabff;";  
    		}
    	};
    	myBackGrid.setHeight100();
    	myBackGrid.setWidth100();
    	myBackGrid.setDataSource(source);
    	myBackGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	myBackGrid.setAutoFitFieldWidths(true);
    	myBackGrid.setCanExpandRecords(true);
    	myBackGrid.setCanDragSelectText(true);
//    	myBackLayout.addMember(myBackGrid);
    	
    	//已完成    	
    	myFinishGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    				return "font-weight:bold; color:#555555;";  
    		}
    	};
    	myFinishGrid.setHeight100();
    	myFinishGrid.setWidth100();
    	myFinishGrid.setDataSource(source);
    	myFinishGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	myFinishGrid.setAutoFitFieldWidths(true);
    	myFinishGrid.setCanExpandRecords(true);
    	myFinishGrid.setCanDragSelectText(true);
    	myFinishLayout.addMember(myFinishGrid);
    	
    	//gird 点击事件开始***********************
    	//待办-审核点击事件
    	todoListAuditGrid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = todoListAuditGrid.getSelectedRecord();
				if(record != null){
					//获取模块类型
					int activityType = BaseHelpUtils.getIntValue(record.getAttribute("activityType"));
					//获取流程类型
					int processType = BaseHelpUtils.getIntValue(record.getAttribute("processType")); 
					operPanel(activityType,processType,"");
				}
			}
		});
    	//待办-知会点击事件
    	todoListAttentionGrid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = todoListAttentionGrid.getSelectedRecord();
				if(record != null){
					//获取模块类型
					int activityType = BaseHelpUtils.getIntValue(record.getAttribute("activityType"));
					//获取流程类型
					int processType = BaseHelpUtils.getIntValue(record.getAttribute("processType")); 
					operPanel(activityType,processType,"");
				}
			}
		});
    	//待办-任务池点击事件
    	todoListPoolGrid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = todoListPoolGrid.getSelectedRecord();
				if(record != null){
					//获取模块类型
					int activityType = BaseHelpUtils.getIntValue(record.getAttribute("activityType"));
					//获取流程类型
					int processType = BaseHelpUtils.getIntValue(record.getAttribute("processType")); 
					operPanel(activityType,processType,"");
				}
			}
		});
    	//已办-审核点击事件
    	doneListAuditGrid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = doneListAuditGrid.getSelectedRecord();
				if(record != null){
					//获取模块类型
					int activityType = BaseHelpUtils.getIntValue(record.getAttribute("activityType"));
					//获取流程类型
					int processType = BaseHelpUtils.getIntValue(record.getAttribute("processType")); 
					operPanel(activityType,processType,"");
				}
			}
		});
    	//已办-知会点击事件
    	doneListAttentionGrid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = doneListAttentionGrid.getSelectedRecord();
				if(record != null){
					//获取模块类型
					int activityType = BaseHelpUtils.getIntValue(record.getAttribute("activityType"));
					//获取流程类型
					int processType = BaseHelpUtils.getIntValue(record.getAttribute("processType")); 
					operPanel(activityType,processType,"");
				}
			}
		});
    	//已办-任务池点击事件
    	doneListPoolGrid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = doneListPoolGrid.getSelectedRecord();
				if(record != null){
					//获取模块类型
					int activityType = BaseHelpUtils.getIntValue(record.getAttribute("activityType"));
					//获取流程类型
					int processType = BaseHelpUtils.getIntValue(record.getAttribute("processType")); 
					operPanel(activityType,processType,"");
				}
			}
		});
    	//我的发起点击事件
    	myApplyGrid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = myApplyGrid.getSelectedRecord();
				if(record != null){
					//获取模块类型
					int activityType = BaseHelpUtils.getIntValue(record.getAttribute("activityType"));
					//获取流程类型
					int processType = BaseHelpUtils.getIntValue(record.getAttribute("processType")); 
					operPanel(activityType,processType,"");
				}
			}
		});
    	//已驳回点击事件
    	myBackGrid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = myBackGrid.getSelectedRecord();
				if(record != null){
					//获取模块类型
					int activityType = BaseHelpUtils.getIntValue(record.getAttribute("activityType"));
					//获取流程类型
					int processType = BaseHelpUtils.getIntValue(record.getAttribute("processType")); 
					operPanel(activityType,processType,"");
				}
			}
		});
    	//已完成点击事件
    	myFinishGrid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = myFinishGrid.getSelectedRecord();
				if(record != null){
					//获取模块类型
					int activityType = BaseHelpUtils.getIntValue(record.getAttribute("activityType"));
					//获取流程类型
					int processType = BaseHelpUtils.getIntValue(record.getAttribute("processType")); 
					operPanel(activityType,processType,"");
				}
			}
		});
    	//gird 点击事件结束***********************
    	
    	startEdit();
    }

    @Override
    public void startEdit() {
    	Map<Object,Object> param = new HashMap<>();
    	param.put("employeeId",ClientUtil.getEmployeeId());
    	param.put("parentProcessTypeId",PomPlatformClientUtil.PARENT_PROCESS_TYPE_2);
    	param.put("optType","onLoadFLowProcessTypeNum");
    	DBDataSource.callOperation("EP_OnWrokflowProcess", "find", param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	Record[] records = dsResponse.getData();
                	if(records.length > 0){
                		reloadData(records);
                	}
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
            }
        });
    }
    
    //数据归集并封装
    public void reloadData(Record[] records){
    	//定义待办审批map
    	Map<Integer,Record> todoListAuditMap = new HashMap<>();
    	//定义待办知会map
    	Map<Integer,Record> todoListAttentionMap = new HashMap<>();
    	//定义待办任务池map
    	Map<Integer,Record> todoListPoolMap = new HashMap<>();
    	//定义已办审批map
    	Map<Integer,Record> doneListAuditMap = new HashMap<>();
    	//定义已办知会map
    	Map<Integer,Record> doneListAttentionMap = new HashMap<>();
    	//定义已办任务池map
    	Map<Integer,Record> doneListPoolMap = new HashMap<>();
    	//定义我的发起map
    	Map<Integer,Record> myApplyMap = new HashMap<>();
    	//定义已驳回map
    	Map<Integer,Record> myBackMap = new HashMap<>();
    	//定义已完成map
    	Map<Integer,Record> myFinishMap = new HashMap<>();
    	for(Record e : records){
    		//获取模块类型
    		int activityType = BaseHelpUtils.getIntValue(e.getAttribute("activityType"));
    		//获取流程类型
    		int processType = BaseHelpUtils.getIntValue(e.getAttribute("processType"));
    		if(ACTIVITY_TYPE_1 == activityType){//我的发起(发起/进行中)
    			myApplyMap.put(processType,e);
    		}else if(ACTIVITY_TYPE_2 == activityType){//我的驳回(已驳回)
    			myBackMap.put(processType,e);
    		}else if(ACTIVITY_TYPE_3 == activityType){//我的归档(已完成)
    			myFinishMap.put(processType,e);
    		}else if(ACTIVITY_TYPE_4 == activityType){//待办-审核
    			todoListAuditMap.put(processType,e);
    		}else if(ACTIVITY_TYPE_5 == activityType){//待办-知会
    			todoListAttentionMap.put(processType,e);
    		}else if(ACTIVITY_TYPE_6 == activityType){//待办-任务池
    			todoListPoolMap.put(processType,e);
    		}else if(ACTIVITY_TYPE_7 == activityType){//已办-审核
    			doneListAuditMap.put(processType,e);
    		}else if(ACTIVITY_TYPE_8 == activityType){//已办-知会
    			doneListAttentionMap.put(processType,e);
    		}else if(ACTIVITY_TYPE_9 == activityType){//已办-任务池
    			doneListPoolMap.put(processType,e);
    		}
    	}
    	Record[] myApplyData = new Record[myApplyMap.size()];
    	int i = 0;
    	for(Integer processType : myApplyMap.keySet()){
    		myApplyData[i] = myApplyMap.get(processType);
    		i++;
    	}
    	myApplyGrid.setData(myApplyData);
    	myApplyGrid.redraw();
    	
/*    	Record[] mybackData = new Record[myBackMap.size()];
    	i = 0;
    	for(Integer processType : myBackMap.keySet()){
    		mybackData[i] = myBackMap.get(processType);
    		i++;
    	}
    	myBackGrid.setData(mybackData);
    	myBackGrid.redraw();*/

    	Record[] myfinishData = new Record[myFinishMap.size()];
    	i = 0;
    	for(Integer processType : myFinishMap.keySet()){
    		myfinishData[i] = myFinishMap.get(processType);
    		i++;
    	}
    	myFinishGrid.setData(myfinishData);
    	myFinishGrid.redraw();
    	
    	Record[] todoListAuditData = new Record[todoListAuditMap.size()];
    	i = 0;
    	for(Integer processType : todoListAuditMap.keySet()){
    		todoListAuditData[i] = todoListAuditMap.get(processType);
    		i++;
    	}
    	todoListAuditGrid.setData(todoListAuditData);
    	todoListAuditGrid.redraw();
    	
    	Record[] todoListAttentionData = new Record[todoListAttentionMap.size()];
    	i = 0;
    	for(Integer processType : todoListAttentionMap.keySet()){
    		todoListAttentionData[i] = todoListAttentionMap.get(processType);
    		i++;
    	}
    	todoListAttentionGrid.setData(todoListAttentionData);
    	todoListAttentionGrid.redraw();
    	
    	Record[] todoListPoolData = new Record[todoListPoolMap.size()];
    	i = 0;
    	for(Integer processType : todoListPoolMap.keySet()){
    		todoListPoolData[i] = todoListPoolMap.get(processType);
    		i++;
    	}
    	todoListPoolGrid.setData(todoListPoolData);
    	todoListPoolGrid.redraw();
    	
    	Record[] doneListAuditData = new Record[doneListAuditMap.size()];
    	i = 0;
    	for(Integer processType : doneListAuditMap.keySet()){
    		doneListAuditData[i] = doneListAuditMap.get(processType);
    		i++;
    	}
    	doneListAuditGrid.setData(doneListAuditData);
    	doneListAuditGrid.redraw();
    	
    	Record[] doneListAttentionData = new Record[doneListAttentionMap.size()];
    	i = 0;
    	for(Integer processType : doneListAttentionMap.keySet()){
    		doneListAttentionData[i] = doneListAttentionMap.get(processType);
    		i++;
    	}
    	doneListAttentionGrid.setData(doneListAttentionData);
    	doneListAttentionGrid.redraw();
    	
    	Record[] doneListPoolData = new Record[doneListPoolMap.size()];
    	i = 0;
    	for(Integer processType : doneListPoolMap.keySet()){
    		doneListPoolData[i] = doneListPoolMap.get(processType);
    		i++;
    	}
    	doneListPoolGrid.setData(doneListPoolData);
    	doneListPoolGrid.redraw();
    	
    }
    
    //根据模块点击事件打开对应的面板
    public void operPanel(int activityType,int processType,String code){
    	logger.info("activityType========="+activityType);
    	logger.info("processType========="+processType);
    	PopupWindow popupWindow = new PopupWindow(" ");
        popupWindow.setWidth100();
        popupWindow.setHeight100();
        popupWindow.centerInPage();
        switch(processType){
        case PROCESS_TYPE_13://请假申请
        	popupWindow.setTitle("请假申请");
        	break;
        case PROCESS_TYPE_14://出差申请
        	popupWindow.setTitle("非项目出差申请");
        	break;
        case PROCESS_TYPE_15://打卡申请
        	popupWindow.setTitle("打卡申请");
        	break;
        case PROCESS_TYPE_16://外出申请
        	popupWindow.setTitle("外出申请");
        	break;
        case PROCESS_TYPE_17://加班申请
        	popupWindow.setTitle("加班申请");
        	break;
        case PROCESS_TYPE_18://项目出差申请
        	popupWindow.setTitle("项目出差申请");
        	break;
        case PROCESS_TYPE_19://出差延期申请
        	popupWindow.setTitle("出差延期申请");
        	break;
        case PROCESS_TYPE_20://出差更改行程申请
        	popupWindow.setTitle("出差更改行程申请");
        	break;
        case PROCESS_TYPE_21://项目派驻申请
        	popupWindow.setTitle("项目派驻申请");
        	break;
        case PROCESS_TYPE_22://项目派驻延期申请
        	popupWindow.setTitle("项目派驻延期申请");
        	break;
        case PROCESS_TYPE_23://项目派驻确认申请
        	popupWindow.setTitle("项目派驻确认申请");
        	break;
        case PROCESS_TYPE_24://入职申请
        	popupWindow.setTitle("入职申请");
        	break;
        case PROCESS_TYPE_25://离职申请
        	popupWindow.setTitle("离职申请");
        	break;
        case PROCESS_TYPE_26://转岗申请
        	popupWindow.setTitle("转岗申请");
        	break;
        case PROCESS_TYPE_28://员工还款申请
        	popupWindow.setTitle("员工还款申请");
        	break;
        case PROCESS_TYPE_29://转正申请
        	popupWindow.setTitle("转正申请");
        	break;
        case PROCESS_TYPE_30://调休申请
        	popupWindow.setTitle("调薪申请");
        	break;
        case PROCESS_TYPE_37://薪资发放申请
        	popupWindow.setTitle("薪资发放申请");
        	break;
        case PROCESS_TYPE_45://考勤异常处理
        	popupWindow.setTitle("工资异常申请");
        	break;
        case PROCESS_TYPE_59:
        	popupWindow.setTitle("培训申请流程");

			case PROCESS_TYPE_72:
				popupWindow.setTitle("调档申请");

        	break;
		case PROCESS_TYPE_62:
			popupWindow.setTitle("劳动合同续签流程");
			break;
		case PROCESS_TYPE_63:
			popupWindow.setTitle("奖金发放申请流程");
			break;

        default:
        	break;
        }
        if(PROCESS_TYPE_24 == processType){
        	if(ACTIVITY_TYPE_1 == activityType ){
        		ApplyOfEmployeeOnboardPanel applyPanel = new ApplyOfEmployeeOnboardPanel();
	        	applyPanel.setProcessType(processType);
	        	applyPanel.commonQuery();
				popupWindow.addItem(applyPanel);
	        }else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){  //ACTIVITY_TYPE_4：待办审核   ACTIVITY_TYPE_7 ：待办审核   / 待办、已办任务池
	        	AuditOfEmployeeOnboardPanel auditPanel = new AuditOfEmployeeOnboardPanel();
				if(ACTIVITY_TYPE_4 == activityType) {
					auditPanel.setStatus(1);//待办审核
				}else if(ACTIVITY_TYPE_7 == activityType){
					auditPanel.setStatus(2);//待办审核
				}
				auditPanel.setProcessType(processType);
	        	auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
	        }
	        else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
	        	AttentionOfEmployeeOnboardPanel attentionPanel = new AttentionOfEmployeeOnboardPanel();
	        	attentionPanel.setProcessType(processType);
	        	if(ACTIVITY_TYPE_5 == activityType){//待办
	        		attentionPanel.setStatus(1);
	        	}else{//已办
	        		attentionPanel.setStatus(2);
	        	}
	        	attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
	        }else if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
	        	RefuseOfEmployeeOnboardPanel refusePanel = new RefuseOfEmployeeOnboardPanel();
	        	refusePanel.setProcessType(processType);
	        	if(ACTIVITY_TYPE_2 == activityType){//已驳回
	        		refusePanel.setStatus(5);
	        	}else{//已完成
	        		refusePanel.setStatus(3);
	        	}
	        	refusePanel.commonQuery();
				popupWindow.addItem(refusePanel);
	        }
        }else if(PROCESS_TYPE_30 == processType){
        	//调薪
	    	if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
	    		OnLoadApplyListOfSalaryAdjustmentPanel applyPanel = new OnLoadApplyListOfSalaryAdjustmentPanel();
	        	if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){
	        		//驳回/完成
	        		applyPanel.setProcessStatus("a.process_status in (3,5)");
	        	}
	        	applyPanel.commonQuery();
				popupWindow.addItem(applyPanel);
	        }else if(ACTIVITY_TYPE_4 == activityType || ACTIVITY_TYPE_7 == activityType){
	        	EmployeeSalaryAdjustmentDetailPanel auditPanel =  new EmployeeSalaryAdjustmentDetailPanel();
	        	auditPanel.setProcessType(processType);
	        	if(ACTIVITY_TYPE_4 == activityType){
	        		//待办审批
	        		auditPanel.setAudit(false);
	        	}else{
	        		//已办审批
	        		auditPanel.setAudit(true);
	        	}
	        	auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
	        }else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
	        	OnLoadAttentionListOfSalaryAdjustmentPanel attentionPanel = new OnLoadAttentionListOfSalaryAdjustmentPanel();
	        	if(ACTIVITY_TYPE_5 == activityType){
	        		//待办
	        		attentionPanel.setStatus(1);
	        	}else{
	        		//已办
	        		attentionPanel.setStatus(2);
	        	}
	        	attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
	        }
        }else if(PROCESS_TYPE_59 == processType){//培训申请流程
        	popupWindow.setTitle("培训申请流程");
			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
				trainingManagementsApplyOfWorkflowPanel panel = new trainingManagementsApplyOfWorkflowPanel();
	        	if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){//已驳回
	        		panel.setStatus("spi.process_status IN ( 3, 5 )");
	        	}
				panel.setActivityType(activityType);
				panel.setParentCanvas(popupWindow);
				panel.commonQuery();
				popupWindow.addItem(panel);
			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批/已办审批
				trainingManagementAuditOfWorkflowPanel panel = new trainingManagementAuditOfWorkflowPanel();
				if(ACTIVITY_TYPE_4 == activityType) {
					panel.setStatus(1);
				}else {
					panel.setStatus(2);
				}
				panel.commonQuery();
				popupWindow.addItem(panel);
			}else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办知会  已办知会
				trainingManagementAttentionOfWorkflowPanel panel = new trainingManagementAttentionOfWorkflowPanel();
				if(ACTIVITY_TYPE_5 == activityType) {
					panel.setStatus(1);
				}else {
					panel.setStatus(2);
				}
				panel.commonQuery();
				popupWindow.addItem(panel);
			}

        }else if(PROCESS_TYPE_72 == processType){//调档申请流程
			popupWindow.setTitle("调档申请");
			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
                ApplicationInForFilingPanel panel = new ApplicationInForFilingPanel();
				if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){//已驳回
					panel.setStatus("spi.process_status IN ( 3, 5 )");
				}
                panel.setProcessType(processType);
				panel.setParentCanvas(popupWindow);
				panel.commonQuery();
				popupWindow.addItem(panel);
			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
				ApplicationInForFilingListOfPersonnelPanel auditPanel =  new ApplicationInForFilingListOfPersonnelPanel();
                if(ACTIVITY_TYPE_4 == activityType) {
                    auditPanel.setStatus(1);
                }else if(ACTIVITY_TYPE_7 == activityType){
                    auditPanel.setStatus(2);
                }
                auditPanel.setProcessType(processType);
                auditPanel.commonQuery();
                popupWindow.addItem(auditPanel);
            }else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
                OnLoadAttentionListOfPersonnelPanel attentionPanel = new OnLoadAttentionListOfPersonnelPanel();
                attentionPanel.setProcessType(processType);
                if(ACTIVITY_TYPE_5 == activityType){//待办
                    attentionPanel.setStatus(1);
                }else{//已办
                    attentionPanel.setStatus(2);
                }
                attentionPanel.commonQuery();
                popupWindow.addItem(attentionPanel);
			}
		} else if(PROCESS_TYPE_63 == processType){//奖金发放申请流程
        	popupWindow.setTitle("奖金发放申请流程");
			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
				BonusPaymentApplyOfWorkflowPanel panel = new BonusPaymentApplyOfWorkflowPanel();
	        	if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){//已驳回
	        		panel.setStatus("spi.process_status IN ( 3, 5 )");
	        	}
				panel.setActivityType(activityType);
				panel.setParentCanvas(popupWindow);
				panel.commonQuery();
				popupWindow.addItem(panel);
			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批/已办审批
				BonusPaymentAuditOfWorkflowPanel panel = new BonusPaymentAuditOfWorkflowPanel();
				if(ACTIVITY_TYPE_4 == activityType) {
					panel.setStatus(1);
				}else {
					panel.setStatus(2);
				}
				panel.commonQuery();
				popupWindow.addItem(panel);
			}else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办知会  已办知会
				BonusPaymentAttentionOfWorkflowPanel panel = new BonusPaymentAttentionOfWorkflowPanel();
				if(ACTIVITY_TYPE_5 == activityType) {
					panel.setStatus(1);
				}else {
					panel.setStatus(2);
				}
				panel.commonQuery();
				popupWindow.addItem(panel);
			}
        }else if(PROCESS_TYPE_62 == processType){
        	//劳动合同续签流程
			popupWindow.setTitle("劳动合同续签流程");
			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
				EmployeeContractPanel panel = new EmployeeContractPanel();
				if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){//已驳回
					panel.setStatus("A.process_status IN ( 3, 5 )");
				}
				panel.setActivityType(activityType);
				panel.setParentCanvas(popupWindow);
				panel.commonQuery();
				popupWindow.addItem(panel);
			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批/已办审批
				SC.debugger();
				Integer a = activityType;
				EmployeeContractAuditOfWorkflowPanel panel = new EmployeeContractAuditOfWorkflowPanel();
				if(ACTIVITY_TYPE_4 == activityType) {
					panel.setStatus(1);
				}else {
					panel.setStatus(2);
				}
				panel.commonQuery();
				popupWindow.addItem(panel);
			}else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办知会  已办知会
				EmployeeContractAttentionOfWorkflowPanel panel = new EmployeeContractAttentionOfWorkflowPanel();
				if(ACTIVITY_TYPE_5 == activityType) {
					panel.setStatus(1);
				}else {
					panel.setStatus(2);
				}
				panel.commonQuery();
				popupWindow.addItem(panel);
			}
		}else{
	    	if(ACTIVITY_TYPE_1 == activityType ){
	    		//我的发起面板
	        	OnLoadApplyListOfPersonnelPanel applyPanel = new OnLoadApplyListOfPersonnelPanel();
	        	applyPanel.setProcessType(processType);
	        	applyPanel.createUploadButton();
	        	applyPanel.commonQuery();
				popupWindow.addItem(applyPanel);
	        }else if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
	        	OnLoadRefuseListOfPersonnelPanel refusePanel = new OnLoadRefuseListOfPersonnelPanel();
	        	refusePanel.setProcessType(processType);
	        	if(ACTIVITY_TYPE_2 == activityType){//已驳回
	        		refusePanel.setStatus(5);
	        	}else{//已完成
	        		refusePanel.setStatus(3);
	        	}
	        	refusePanel.commonQuery();
				popupWindow.addItem(refusePanel);
	        }else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
	        	OnLoadAuditListOfPersonnelPanel auditPanel =  new OnLoadAuditListOfPersonnelPanel();
	        	if(ACTIVITY_TYPE_4 == activityType) {
	        		auditPanel.setStatus(1);
	        	}else if(ACTIVITY_TYPE_7 == activityType){
	        		auditPanel.setStatus(2);
	        	}
	        	auditPanel.setProcessType(processType);
	        	auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
	        }else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
	        	OnLoadAttentionListOfPersonnelPanel attentionPanel = new OnLoadAttentionListOfPersonnelPanel();
	        	attentionPanel.setProcessType(processType);
	        	if(ACTIVITY_TYPE_5 == activityType){//待办
	        		attentionPanel.setStatus(1);
	        	}else{//已办
	        		attentionPanel.setStatus(2);
	        	}
	        	attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
	        }
        }
    	
    	popupWindow.addCloseClickHandler(new CloseClickHandler() {
			@Override
			public void onCloseClick(CloseClickEvent event) {
				startEdit();
			}
		});
    	popupWindow.show();
    }
    
    
    //获取申请事项的面板
    public void getViewPanel() {
		Map<String,String> processIdMap = PomPlatformClientUtil.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_2);
		Map<String,String> processIconMap = PomPlatformClientUtil.getUserProcessIcon(PomPlatformClientUtil.PARENT_PROCESS_TYPE_2);
		int maxWidth = topLayout.getWidth();
		int totalWidth = 0;
		HLayout oneLayout = new HLayout();
		HLayout twoLayout = new HLayout();
		
		for(String key : processIdMap.keySet()){
			Integer value = ClientUtil.checkAndGetIntValue(processIdMap.get(key));
			if(null != value && value.intValue() > 0 && !BaseHelpUtils.isNullOrEmpty(ClientUtil.getStringFromMap(processIconMap, key))){
				final ImgButton button = new ImgButton();
				//只有拥有培训申请权限的，培训申请按钮才会显示出来
				if(key.equals("training_management_information") && !ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_PERSONNEL_TRAINING_APPLY_BUTTON)){
					continue;
				}
				
				//只有拥有入职申请权限的，入职申请按钮才会显示出来
				if(key.equals("Employee_onboard_apply") && !ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_PERSONNEL_ONBOARD_BUTTON)){
					continue;
				}
				
				//只有拥有转正申请权限的，转正申请按钮才会显示出来
				if(key.equals("Regular_employee_apply") && !ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_PERSONNEL_REGULAR_EMPLOYEE_BUTTON)){
					continue;
				}
				
				//只有拥有薪资发放权限的，薪资发放申请按钮才会显示出来
				if(key.equals("Payroll_apply") && !ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_PERSONNEL_PAYROLL_APPLY_BUTTON)){
					continue;
				}
				//
				if(key.equals("Bonus_Application")){
					continue;
				}
				if (key.equals("Labor_contract_renewal")) {
					continue;
				}
				button.setWidth(ClientStaticUtils.FLOW_IMG_WIDTH);
				button.setHeight(ClientStaticUtils.FLOW_IMG_HEIGHT);
				button.setSrc(ClientUtil.getStringFromMap(processIconMap, key));
				button.setCursor(Cursor.POINTER);
				button.setMargin(10);
				button.setID(PROCESSID + "_" + value);
				button.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						if(key.equals("Salary_adjustment_apply")){//调薪申请
							EmployeeInfoOfNoSalaryAdjustmentPanel panel = new EmployeeInfoOfNoSalaryAdjustmentPanel();
							PopupWindow window = new PopupWindow("员工调薪");
							window.addMember(panel);
							window.setWidth100();
							window.setHeight100();
							window.centerInPage();
							window.show();
						}else if(key.equals("Regular_employee_apply")) {//转正申请
							PositiveEmployeeInfoPanel panel = new PositiveEmployeeInfoPanel();
							PopupWindow window = new PopupWindow("待转正员工");
							window.addMember(panel);
							window.setWidth100();
							window.setHeight100();
							window.centerInPage();
							window.show();
						}else {
							newPanel(value+"", 0);
						}
					}
				});
				totalWidth += ClientStaticUtils.FLOW_IMG_WIDTH+10;
				//如果所有按钮宽度累计起来大于了topLayout的宽度，则自适应换行显示
				if(totalWidth+ClientStaticUtils.FLOW_IMG_WIDTH > maxWidth) {
					twoLayout.addMember(button);
				}else {
					oneLayout.addMember(button);
				}
			}
		}
		topLayout.addMember(oneLayout);
		if(totalWidth+ClientStaticUtils.FLOW_IMG_WIDTH > maxWidth) {
			topLayout.setHeight("20%");
			topLayout.addMember(twoLayout);
		}
	}
    
    
    private void newPanel(String processId, int layoutMode){
		NewProcessWindow Reimbursement = new NewProcessWindow();
		Reimbursement.setTitle(KeyValueManager.getValue("employee_processes", processId));
		Reimbursement.show();
		Reimbursement.addDataEditedHandler(new DataEditedHandler() {
			@Override
			public void onDataEdited(DataEditEvent event) {
				//操作成功
				startEdit();
			}
		});
		Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(processId));
		Reimbursement.setLayoutMode(layoutMode);
		Reimbursement.initComponents();
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
        return "ST_MyPersonnelFlowPanel";
    }
    
    
    
    
}
