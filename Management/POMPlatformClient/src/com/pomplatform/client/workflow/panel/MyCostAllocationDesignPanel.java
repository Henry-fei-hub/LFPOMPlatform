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
import com.delicacy.client.process.SystemProcessConstants;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.applyprojectquotetemplate.panel.ApplyProjectQuoteTemplatePanel;
import com.pomplatform.client.applysupplierinfo.panel.ApplySupplierInfoPanel;
import com.pomplatform.client.attentionprojectquotetemplate.panel.AttentionProjectQuoteTemplatePanel;
import com.pomplatform.client.attentionsupplierinfo.panel.AttentionSupplierInfoPanel;
import com.pomplatform.client.auditprojectquotetemplate.panel.AuditProjectQuoteTemplatePanel;
import com.pomplatform.client.auditsupplierinfo.panel.AuditSupplierInfoPanel;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.pomplatform.client.mainprojectinfo.panel.OnLoadApplyListOfBidPaySheetProjectPanel;
import com.pomplatform.client.mainprojectinfo.panel.OnLoadAttentionListOfBidPaySheetProjectPanel;
import com.pomplatform.client.mainprojectinfo.panel.OnLoadAuditListOfBidPaySheetProjectPanel;
import com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.panel.OnLoadRefuseListOfCostAllocationPanelNewFourPanel;
import com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.panel.OnLoadRefuseListOfCostAllocationPanelNewThreePanel;
import com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.panel.OnLoadRefuseListOfCostAllocationPanelNewTwoPanel;
import com.pomplatform.client.outquotations.panel.OnLoadApplyListOfOutQuotationsPanel;
import com.pomplatform.client.outquotations.panel.OnLoadAttentionListOfOutQuotationsPanel;
import com.pomplatform.client.outquotations.panel.OnLoadAuditListOfOutQuotationsPanel;
import com.pomplatform.client.preprojects.panel.ApplyListOfMainProjectReportPanel;
import com.pomplatform.client.preprojects.panel.ApplyListOfPreProjectReportPanel;
import com.pomplatform.client.preprojects.panel.AttentionListOfMainProjectReportPanel;
import com.pomplatform.client.preprojects.panel.AttentionListOfPreProjectReportPanel;
import com.pomplatform.client.preprojects.panel.AuditListOfMainProjectBuisnessDataPanel;
import com.pomplatform.client.preprojects.panel.AuditListOfPreProjectReportPanel;
import com.pomplatform.client.preprojects.panel.RefuseListOfMainProjectReportPanel;
import com.pomplatform.client.preprojects.panel.RefuseListOfPreProjectReportPanel;
import com.pomplatform.client.projectemployee.panel.OnLoadApplyListOfProjectEmployeesPanel;
import com.pomplatform.client.projectemployee.panel.OnLoadAttentionListOfProjectEmployeesPanel;
import com.pomplatform.client.projectemployee.panel.OnLoadAuditListOfProjectEmployeesPanel;
import com.pomplatform.client.projectsettlement.panel.OnLoadApplyListOfProjectSettlementPanel;
import com.pomplatform.client.projectsettlement.panel.OnLoadAttentionListOfProjectSettlementPanel;
import com.pomplatform.client.projectsettlement.panel.OnLoadAuditListOfProjectSettlementPanel;
import com.pomplatform.client.projectstages.panel.OnLoadApplyListOfProjectStagesPanel;
import com.pomplatform.client.projectstages.panel.OnLoadAttentionListOfProjectStagesPanel;
import com.pomplatform.client.projectstages.panel.OnLoadAuditListOfProjectStagesPanel;
import com.pomplatform.client.refuseprojectquotetemplate.panel.RefuseProjectQuoteTemplatePanel;
import com.pomplatform.client.refusesupplierinfo.panel.RefuseSupplierInfoPanel;
import com.pomplatform.client.workflow.contractstatus.panel.ApplyListOfChangeContractStatusPanel;
import com.pomplatform.client.workflow.contractstatus.panel.AttentionListOfChangeContractStatusPanel;
import com.pomplatform.client.workflow.contractstatus.panel.AuditListOfChangeContractStatusPanel;
import com.pomplatform.client.workflow.datasource.DSMyWorkflowDatasource;
import com.pomplatform.client.workflow.operation.panel.OnLoadApplyListOfCostAllocationNewPanel;
import com.pomplatform.client.workflow.operation.panel.OnLoadApplyListOfCostAllocationPanel;
import com.pomplatform.client.workflow.operation.panel.OnLoadAttentionListOfCostAllocationPanel;
import com.pomplatform.client.workflow.operation.panel.OnLoadAuditListOfCostAllocationPanel;
import com.pomplatform.client.workflow.operation.panel.OnLoadRefuseListOfCostAllocationPanel;
import com.pomplatform.client.workflow.personnel.panel.OnLoadApplyListOfPersonnelPanel;
import com.pomplatform.client.workflow.personnel.panel.OnLoadAttentionListOfPersonnelPanel;
import com.pomplatform.client.workflow.personnel.panel.OnLoadAuditListOfPersonnelPanel;
import com.pomplatform.client.workflow.personnel.panel.OnLoadRefuseListOfPersonnelPanel;
import com.pomplatform.client.workflow.professional.panel.OnLoadApplyListOfProfessionalApprovalPanel;
import com.pomplatform.client.workflow.professional.panel.OnLoadAttentionListOfProfessionalApprovalPanel;
import com.pomplatform.client.workflow.professional.panel.OnLoadAuditListOfProfessionalApprovalPanel;
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

public class MyCostAllocationDesignPanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("");
	private static final String PROCESSID = "processId";
	//定义模块类型
	/**
	 * 我的发起(发起/进行中)
	 */
  	public static final int ACTIVITY_TYPE_1 = 1;
  	/**
  	 * 我的驳回(已驳回)
  	 */
  	public static final int ACTIVITY_TYPE_2 = 2;
  	/**
  	 * 我的归档(已完成)
  	 */
  	public static final int ACTIVITY_TYPE_3 = 3;
  	/**
  	 * 待办-审核
  	 */
  	public static final int ACTIVITY_TYPE_4 = 4;
  	/**
  	 * 待办-知会
  	 */
  	public static final int ACTIVITY_TYPE_5 = 5;
  	/**
  	 * 待办-任务池
  	 */
  	public static final int ACTIVITY_TYPE_6 = 6;
  	/**
  	 * 已办-审核
  	 */
  	public static final int ACTIVITY_TYPE_7 = 7;
  	/**
  	 * 已办-知会
  	 */
  	public static final int ACTIVITY_TYPE_8 = 8;
  	/**
  	 * 已办-任务池
  	 */
  	public static final int ACTIVITY_TYPE_9 = 9;
  	
  	//定义流程类型
  	public static final int PROCESS_TYPE_27 = 27;//确认函申请
  	public static final int PROCESS_TYPE_39 = 39;//成本调节
  	public static final int PROCESS_TYPE_42 = 42;//项目报备
  	public static final int PROCESS_TYPE_43 = 43;//前期项目立项
  	public static final int PROCESS_TYPE_44 = 44;//前期项目关闭
  	public static final int PROCESS_TYPE_46 = 46;//前期项目转单
  	public static final int PROCESS_TYPE_51 = 51;//订单跨阶段评审流程
  	public static final int PROCESS_TYPE_60 = 60;//自定义项目阶段模板评审流程
  	public static final int PROCESS_TYPE_53 = 53;//供应商入库流程
  	public static final int PROCESS_TYPE_56 = 56;//项目报价流程
  	public static final int PROCESS_TYPE_61 = 61;//权限申请流程
  	public static final int PROCESS_TYPE_73 = 73;//落标申请流程
  	
  	public static final int PROCESS_TYPE_75 = 75;//报价单流程
  	public static final int PROCESS_TYPE_76 = 76;//可分配阶段确认流程
  	public static final int PROCESS_TYPE_79 = 79;//团队组建流程
  	public static final int PROCESS_TYPE_80 = 80;//经费结算流程
	public static final int PROCESS_TYPE_84 = 84;//我的工时
	public static final int PROCESS_TYPE_85 = 85;//专业负责人审批
	public static final int PROCESS_TYPE_86 = 86;//订单下达

  	/**
  	 * 合同状态变更
  	 */
    public static final int PROCESS_TYPE_64 = 64;

	public static final int PROCESS_TYPE_71 = 71;//盖章申请流程
	
	public static final String PROCESS_TYPE_64_EXECUTE_NAME = "Change_Contract_Status";//合同状态变更

	public static final int PROCESS_TYPE_72 = 72;//调档申请流程
    //定义面板样式
    private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
    public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    //定义主面板，分上下分层，top层是我的发起图片按钮，button层是我的事务层
    private VLayout mainLayout;
    //定义top层，即装载图片按钮
    private HLayout topLayout;
    
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
    
    public MyCostAllocationDesignPanel() {
    	//主面板
    	mainLayout = new VLayout(20);
    	mainLayout.setBackgroundColor("#FFF");
    	mainLayout.setHeight100();
    	mainLayout.setWidth100();
    	mainLayout.setMembersMargin(20);
    	addMember(mainLayout);
    	
    	//头部面板
    	topLayout = new HLayout(20);
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
    	myBackLayout.addMember(myBackGrid);
    	
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
    	param.put("parentProcessTypeId",PomPlatformClientUtil.PARENT_PROCESS_TYPE_4);
    	param.put("optType","onLoadFLowProcessTypeNum");
    	DBDataSource.callOperation("EP_OnWrokflowProcess", "find", param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	Record[] records = dsResponse.getData();
                	if(records.length > 0){
                		reloadData(records);
                		for(Record record :records){
                			logger.info(record.toMap().toString());
                		}
                	}else{
                		logger.info("没数据");
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
    	
    	Record[] mybackData = new Record[myBackMap.size()];
    	i = 0;
    	for(Integer processType : myBackMap.keySet()){
    		mybackData[i] = myBackMap.get(processType);
    		i++;
    	}
    	myBackGrid.setData(mybackData);
    	myBackGrid.redraw();
    	
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
        case PROCESS_TYPE_27://确认函申请
        	popupWindow.setTitle("确认函申请");
        	break;
        case PROCESS_TYPE_39://成本调节
        	popupWindow.setTitle("成本调节");
        	break;
        case PROCESS_TYPE_42://项目报备
        	popupWindow.setTitle("项目报备");
        	break;
        case PROCESS_TYPE_43://前期项目立项
        	popupWindow.setTitle("前期项目立项");
        	break;
        case PROCESS_TYPE_44://前期项目关闭
        	popupWindow.setTitle("前期项目关闭");
        	break;
        case PROCESS_TYPE_46://前期项目转单
        	popupWindow.setTitle("前期项目转单");
        	break;
        case PROCESS_TYPE_51://订单跨阶段评审流程
        	popupWindow.setTitle("订单跨阶段评审流程");
        	break;
        case PROCESS_TYPE_56://项目报价流程
        	popupWindow.setTitle("项目报价流程");
        	break;
        case PROCESS_TYPE_64://合同状态变更
        	popupWindow.setTitle("合同状态变更");
        	break;
        case PROCESS_TYPE_73://落标申请
        	popupWindow.setTitle("落标申请");
        	break;
        case PROCESS_TYPE_75://报价单流程
        	popupWindow.setTitle("报价单流程");
        	break;
        case PROCESS_TYPE_76://可分配阶段申请
        	popupWindow.setTitle("可分配阶段申请");
        	break;
        case PROCESS_TYPE_79://团队组建流程
        	popupWindow.setTitle("团队组建流程");
        	break;
        case PROCESS_TYPE_80://经费结算流程
        	popupWindow.setTitle("经费结算流程");
        	break;
        case PROCESS_TYPE_84:
			popupWindow.setTitle("我的工时");
        	break;
        case PROCESS_TYPE_85:
			popupWindow.setTitle("专业负责人审批");
			break;
        case PROCESS_TYPE_86:
			popupWindow.setTitle("订单下达");
        	break;
        default:
        	break;
        }


        //项目报备
        if(PROCESS_TYPE_42 == processType){
        	if(ACTIVITY_TYPE_1 == activityType){//发起/进行中
        		ApplyListOfPreProjectReportPanel applyPanel = new ApplyListOfPreProjectReportPanel();
        		applyPanel.setProcessType(processType);
        		applyPanel.commonQuery();
        		popupWindow.addItem(applyPanel);
        	}else if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){//驳回/已完成
        		RefuseListOfPreProjectReportPanel applyPanel = new RefuseListOfPreProjectReportPanel();
        		applyPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_2 == activityType){
        			applyPanel.setProcessStatus(5);
        		}else if(ACTIVITY_TYPE_3 == activityType){
        			applyPanel.setProcessStatus(3);
        		}
        		applyPanel.commonQuery();
        		popupWindow.addItem(applyPanel);
        	}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
        		AuditListOfPreProjectReportPanel auditPanel = new AuditListOfPreProjectReportPanel();;
        		auditPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_4 == activityType) {
        			auditPanel.setStatus(1);
        		}else {
        			auditPanel.setStatus(2);
        		}
        		auditPanel.commonQuery();
        		popupWindow.addItem(auditPanel);
        	}else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
        		AttentionListOfPreProjectReportPanel attentionPanel = new AttentionListOfPreProjectReportPanel();
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
        //前期项目立项,前期项目关闭
        else if(PROCESS_TYPE_43 == processType || PROCESS_TYPE_44 == processType){
        	if(ACTIVITY_TYPE_1 == activityType){//发起/进行中
//        		ApplyListOfPreProjectReportPanel applyPanel = new ApplyListOfPreProjectReportPanel();
        		ApplyListOfMainProjectReportPanel applyPanel = new ApplyListOfMainProjectReportPanel();
        		applyPanel.setProcessType(processType);
        		applyPanel.commonQuery();
        		popupWindow.addItem(applyPanel);
        	}else if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){//驳回/已完成
//        		RefuseListOfPreProjectReportPanel applyPanel = new RefuseListOfPreProjectReportPanel();
        		RefuseListOfMainProjectReportPanel applyPanel = new RefuseListOfMainProjectReportPanel();
        		applyPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_2 == activityType){
        			applyPanel.setProcessStatus(5);
        		}else if(ACTIVITY_TYPE_3 == activityType){
        			applyPanel.setProcessStatus(3);
        		}
        		applyPanel.commonQuery();
        		popupWindow.addItem(applyPanel);
        	}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
        		AuditListOfMainProjectBuisnessDataPanel auditPanel = new AuditListOfMainProjectBuisnessDataPanel();
        		auditPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_4 == activityType) {
        			auditPanel.setStatus(1);
        		}else {
        			auditPanel.setStatus(2);
        		}
        		auditPanel.commonQuery();
        		popupWindow.addItem(auditPanel);
        	}else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
//        		AttentionListOfPreProjectReportPanel attentionPanel = new AttentionListOfPreProjectReportPanel();
        		AttentionListOfMainProjectReportPanel attentionPanel = new AttentionListOfMainProjectReportPanel();
        		attentionPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_5 == activityType){//待办
        			attentionPanel.setStatus(1);
        		}else{//已办
        			attentionPanel.setStatus(2);
        		}
        		attentionPanel.commonQuery();
        		popupWindow.addItem(attentionPanel);
        	}
        }else if(PROCESS_TYPE_46 == processType) {//前期项目转单
        	if(ACTIVITY_TYPE_1 == activityType){//发起/进行中
        		OnLoadApplyListOfCostAllocationNewPanel applyPanel = new OnLoadApplyListOfCostAllocationNewPanel();
        		applyPanel.setProcessType(processType);
        		applyPanel.commonQuery();
        		popupWindow.addItem(applyPanel);
        	}else if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){//驳回/已完成
        		OnLoadRefuseListOfCostAllocationPanelNewTwoPanel applyPanel = new OnLoadRefuseListOfCostAllocationPanelNewTwoPanel();
        		applyPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_2 == activityType){
        			applyPanel.setProcessStatus(5);
        		}else if(ACTIVITY_TYPE_3 == activityType){
        			applyPanel.setProcessStatus(3);
        		}
        		applyPanel.commonQuery();
        		popupWindow.addItem(applyPanel);
        	}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
        		OnLoadRefuseListOfCostAllocationPanelNewThreePanel auditPanel =  new OnLoadRefuseListOfCostAllocationPanelNewThreePanel();
        		auditPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_4 == activityType) {
        			auditPanel.setStatus(1);
        		}else {
        			auditPanel.setStatus(2);
        		}
        		auditPanel.commonQuery();
        		popupWindow.addItem(auditPanel);
        	}/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
        		OnLoadRefuseListOfCostAllocationPanelNewThreePanel auditPanel =  new OnLoadRefuseListOfCostAllocationPanelNewThreePanel();
        		auditPanel.setProcessType(processType);
         		auditPanel.setStatus(2);
        		auditPanel.commonQuery();
        		popupWindow.addItem(auditPanel);
        	}*/else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
        		OnLoadRefuseListOfCostAllocationPanelNewFourPanel attentionPanel = new OnLoadRefuseListOfCostAllocationPanelNewFourPanel();
        		attentionPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_5 == activityType){//待办
        			attentionPanel.setStatus(1);
        		}else{//已办
        			attentionPanel.setStatus(2);
        		}
        		attentionPanel.commonQuery();
        		popupWindow.addItem(attentionPanel);
        	}/*else if(ACTIVITY_TYPE_6 == activityType || ACTIVITY_TYPE_9 == activityType){//待办、已办任务池
        		OnLoadRefuseListOfCostAllocationPanelNewFivePanel taskPanel = new OnLoadRefuseListOfCostAllocationPanelNewFivePanel();
        		taskPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_6 == activityType){//待办
        			taskPanel.setStatus(1);
        		}else{//已办
        			taskPanel.setStatus(2);
        		}
        		taskPanel.commonQuery();
        		popupWindow.addItem(taskPanel);
        	}*/

        }else if(PROCESS_TYPE_27 == processType){
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
	        	auditPanel.setProcessType(processType);
	        	auditPanel.setParentProcessType("spt.parent_process_type_id = 38");
	        	if(ACTIVITY_TYPE_4 == activityType) {
	        		auditPanel.setStatus(1);
	        	}else if(ACTIVITY_TYPE_7 == activityType){
		        	auditPanel.setStatus(2);
		        }
	        	auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
	        }/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
	        	MyAuditListOfPersonnelPanel auditPanel = new MyAuditListOfPersonnelPanel();
	        	auditPanel.setProcessType(processType);
	        	auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
	        }*/else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
	        	OnLoadAttentionListOfPersonnelPanel attentionPanel = new OnLoadAttentionListOfPersonnelPanel();
	        	attentionPanel.setProcessType(processType);
	        	if(ACTIVITY_TYPE_5 == activityType){//待办
	        		attentionPanel.setStatus(1);
	        	}else{//已办
	        		attentionPanel.setStatus(2);
	        	}
	        	attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
	        }/*else if(ACTIVITY_TYPE_6 == activityType || ACTIVITY_TYPE_9 == activityType){//待办、已办任务池
	        	OnLoadTaskListOfPersonnelPanel taskPanel = new OnLoadTaskListOfPersonnelPanel();
	        	taskPanel.setProcessType(processType);
	        	if(ACTIVITY_TYPE_6 == activityType){//待办
	        		taskPanel.setStatus(1);
	        	}else{//已办
	        		taskPanel.setStatus(2);
	        	}
	        	taskPanel.commonQuery();
				popupWindow.addItem(taskPanel);
	        }*/
        }else if(PROCESS_TYPE_51 == processType){
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
	        	auditPanel.setParentProcessType("spt.parent_process_type_id = 38");
	        	if(ACTIVITY_TYPE_4 == activityType) {
	        		auditPanel.setStatus(1);
	        	}else if(ACTIVITY_TYPE_7 == activityType){
	        		auditPanel.setStatus(2);
	        	}
	        	auditPanel.setProcessType(processType);
	        	auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
	        }/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
	        	MyAuditListOfPersonnelPanel auditPanel = new MyAuditListOfPersonnelPanel();
	        	auditPanel.setProcessType(processType);
	        	auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
	        }*/else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
	        	OnLoadAttentionListOfPersonnelPanel attentionPanel = new OnLoadAttentionListOfPersonnelPanel();
	        	attentionPanel.setProcessType(processType);
	        	if(ACTIVITY_TYPE_5 == activityType){//待办
	        		attentionPanel.setStatus(1);
	        	}else{//已办
	        		attentionPanel.setStatus(2);
	        	}
	        	attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
	        }/*else if(ACTIVITY_TYPE_6 == activityType || ACTIVITY_TYPE_9 == activityType){//待办、已办任务池
	        	OnLoadTaskListOfPersonnelPanel taskPanel = new OnLoadTaskListOfPersonnelPanel();
	        	taskPanel.setProcessType(processType);
	        	if(ACTIVITY_TYPE_6 == activityType){//待办
	        		taskPanel.setStatus(1);
	        	}else{//已办
	        		taskPanel.setStatus(2);
	        	}
	        	taskPanel.commonQuery();
				popupWindow.addItem(taskPanel);
	        }*/
        }else if(PROCESS_TYPE_56 == processType){//项目报价流程
        	if(ACTIVITY_TYPE_1 == activityType ){
	    		//我的发起面板
        		ApplyProjectQuoteTemplatePanel applyPanel = new ApplyProjectQuoteTemplatePanel();
        		applyPanel.setProcessType(processType);
        		applyPanel.commonQuery();
        		popupWindow.addItem(applyPanel);
	        }else if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){//驳回/已完成
	        	RefuseProjectQuoteTemplatePanel applyPanel = new RefuseProjectQuoteTemplatePanel();
        		applyPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_2 == activityType){
        			applyPanel.setProcessStatus(5);
        		}else if(ACTIVITY_TYPE_3 == activityType){
        			applyPanel.setProcessStatus(3);
        		}
        		applyPanel.commonQuery();
        		popupWindow.addItem(applyPanel);
        	}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
        		AuditProjectQuoteTemplatePanel auditPanel =  new AuditProjectQuoteTemplatePanel();
        		auditPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_4 == activityType) {
        			auditPanel.setStatus(1);
        		}else {
        			auditPanel.setStatus(2);
        		}
        		auditPanel.commonQuery();
        		popupWindow.addItem(auditPanel);
        	}else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
        		AttentionProjectQuoteTemplatePanel attentionPanel = new AttentionProjectQuoteTemplatePanel();
        		attentionPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_5 == activityType){//待办
        			attentionPanel.setStatus(1);
        		}else{//已办
        			attentionPanel.setStatus(2);
        		}
        		attentionPanel.commonQuery();
        		popupWindow.addItem(attentionPanel);
        	}
        }else if(PROCESS_TYPE_53 == processType){//供应商入库流程
        	if(ACTIVITY_TYPE_1 == activityType ){
	    		//我的发起面板
        		ApplySupplierInfoPanel applyPanel = new ApplySupplierInfoPanel();
        		applyPanel.setProcessType(processType);
        		applyPanel.commonQuery();
        		popupWindow.addItem(applyPanel);
	        }else if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){//驳回/已完成
	        	RefuseSupplierInfoPanel refusePanel = new RefuseSupplierInfoPanel();
	        	refusePanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_2 == activityType){
        			refusePanel.setProcessStatus(5);
        		}else if(ACTIVITY_TYPE_3 == activityType){
        			refusePanel.setProcessStatus(3);
        		}
        		refusePanel.commonQuery();
        		popupWindow.addItem(refusePanel);
        	}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
        		AuditSupplierInfoPanel auditPanel =  new AuditSupplierInfoPanel();
        		auditPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_4 == activityType) {
        			auditPanel.setStatus(1);
        		}else {
        			auditPanel.setStatus(2);
        		}
        		auditPanel.commonQuery();
        		popupWindow.addItem(auditPanel);
        	}else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
        		AttentionSupplierInfoPanel attentionPanel = new AttentionSupplierInfoPanel();
        		attentionPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_5 == activityType){//待办
        			attentionPanel.setStatus(1);
        		}else{//已办
        			attentionPanel.setStatus(2);
        		}
        		attentionPanel.commonQuery();
        		popupWindow.addItem(attentionPanel);
        	}
        }else if(PROCESS_TYPE_61 == processType) {//权限申请流程
			if (ACTIVITY_TYPE_1 == activityType) {
				//我的发起面板
				OnLoadApplyListOfPersonnelPanel applyPanel = new OnLoadApplyListOfPersonnelPanel();
				applyPanel.setProcessType(processType);
				applyPanel.createUploadButton();
				applyPanel.commonQuery();
				popupWindow.addItem(applyPanel);
			} else if (ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType) {
				OnLoadRefuseListOfPersonnelPanel refusePanel = new OnLoadRefuseListOfPersonnelPanel();
				refusePanel.setProcessType(processType);
				if (ACTIVITY_TYPE_2 == activityType) {//已驳回
					refusePanel.setStatus(5);
				} else {//已完成
					refusePanel.setStatus(3);
				}
				refusePanel.commonQuery();
				popupWindow.addItem(refusePanel);
			} else if (ACTIVITY_TYPE_4 == activityType || ACTIVITY_TYPE_7 == activityType) {//待办审批
				OnLoadAuditListOfPersonnelPanel auditPanel = new OnLoadAuditListOfPersonnelPanel();
				auditPanel.setParentProcessType("spt.parent_process_type_id = 38");
				if (ACTIVITY_TYPE_4 == activityType) {
					auditPanel.setStatus(1);
				} else if (ACTIVITY_TYPE_7 == activityType) {
					auditPanel.setStatus(2);
				}
				auditPanel.setProcessType(processType);
				auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
			} else if (ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType) {//待办、已办知会
				OnLoadAttentionListOfPersonnelPanel attentionPanel = new OnLoadAttentionListOfPersonnelPanel();
				attentionPanel.setProcessType(processType);
				if (ACTIVITY_TYPE_5 == activityType) {//待办
					attentionPanel.setStatus(1);
				} else {//已办
					attentionPanel.setStatus(2);
				}
				attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
			}
		}else if(processType == PROCESS_TYPE_64) {
			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){//发起/进行中  + 驳回/已完成
				ApplyListOfChangeContractStatusPanel panel = new ApplyListOfChangeContractStatusPanel();
				panel.setProcessType(processType);
				panel.setActivityType(activityType);
				panel.resetDataSource();
				panel.commonQuery();
				popupWindow.addItem(panel);
			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批 + 已办审批
				AuditListOfChangeContractStatusPanel panel = new AuditListOfChangeContractStatusPanel();
				panel.setProcessType(processType);
				panel.setActivityType(activityType);
				panel.resetDataSource();
        		panel.commonQuery();
        		popupWindow.addItem(panel);
			}else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办知会 + 已办知会
        		AttentionListOfChangeContractStatusPanel panel = new AttentionListOfChangeContractStatusPanel();
        		panel.setProcessType(processType);
        		if(ACTIVITY_TYPE_5 == activityType){//待办
        			panel.setStatus(SystemProcessConstants.ATTENTION_STATUS_ACTIVE);
        		}else{//已办
        			panel.setStatus(SystemProcessConstants.ATTENTION_STATUS_DONE);
        		}
        		panel.resetDataSource();
        		panel.commonQuery();
        		popupWindow.addItem(panel);
        	}
		}else if(processType == PROCESS_TYPE_73) {//落标申请流程
        	if(ACTIVITY_TYPE_1 == activityType ||ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
	    		//我的发起面板
        		OnLoadApplyListOfBidPaySheetProjectPanel applyPanel = new OnLoadApplyListOfBidPaySheetProjectPanel();
        		if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType) {
        			applyPanel.setStatus(2);
        		}
	        	applyPanel.commonQuery();
				popupWindow.addItem(applyPanel);
	        }else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
	        	OnLoadAuditListOfBidPaySheetProjectPanel auditPanel =  new OnLoadAuditListOfBidPaySheetProjectPanel();
	        	if(ACTIVITY_TYPE_4 == activityType) {
	        		auditPanel.setStatus(1);
	        	}else if(ACTIVITY_TYPE_7 == activityType){
	        		auditPanel.setStatus(2);
	        	}
	        	auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
	        }else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
	        	OnLoadAttentionListOfBidPaySheetProjectPanel attentionPanel = new OnLoadAttentionListOfBidPaySheetProjectPanel();
	        	if(ACTIVITY_TYPE_5 == activityType){//待办
	        		attentionPanel.setStatus(1);
	        	}else{//已办
	        		attentionPanel.setStatus(2);
	        	}
	        	attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
	        }
		}else if(processType == PROCESS_TYPE_75) {//报价单申请流程
        	if(ACTIVITY_TYPE_1 == activityType ||ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
	    		//我的发起面板
        		OnLoadApplyListOfOutQuotationsPanel applyPanel = new OnLoadApplyListOfOutQuotationsPanel();
        		if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType) {
        			applyPanel.setStatus(2);
        		}
	        	applyPanel.commonQuery();
				popupWindow.addItem(applyPanel);
	        }else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
	        	OnLoadAuditListOfOutQuotationsPanel auditPanel =  new OnLoadAuditListOfOutQuotationsPanel();
	        	if(ACTIVITY_TYPE_4 == activityType) {
	        		auditPanel.setStatus(1);
	        	}else if(ACTIVITY_TYPE_7 == activityType){
	        		auditPanel.setStatus(2);
	        	}
	        	auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
	        }else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
	        	OnLoadAttentionListOfOutQuotationsPanel attentionPanel = new OnLoadAttentionListOfOutQuotationsPanel();
	        	if(ACTIVITY_TYPE_5 == activityType){//待办
	        		attentionPanel.setStatus(1);
	        	}else{//已办
	        		attentionPanel.setStatus(2);
	        	}
	        	attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
	        }
		}else if(processType == PROCESS_TYPE_76) {
        	if(ACTIVITY_TYPE_1 == activityType ||ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
	    		//我的发起面板
//        		OnLoadApplyListOfOutQuotationsPanel applyPanel = new OnLoadApplyListOfOutQuotationsPanel();
        		OnLoadApplyListOfProjectStagesPanel applyPanel = new OnLoadApplyListOfProjectStagesPanel();
        		if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType) {
        			applyPanel.setStatus(2);
        		}
	        	applyPanel.commonQuery();
				popupWindow.addItem(applyPanel);
	        }else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
//	        	OnLoadAuditListOfOutQuotationsPanel auditPanel =  new OnLoadAuditListOfOutQuotationsPanel();
	        	OnLoadAuditListOfProjectStagesPanel auditPanel =  new OnLoadAuditListOfProjectStagesPanel();
	        	if(ACTIVITY_TYPE_4 == activityType) {
	        		auditPanel.setStatus(1);
	        	}else if(ACTIVITY_TYPE_7 == activityType){
	        		auditPanel.setStatus(2);
	        	}
	        	auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
	        }else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
//	        	OnLoadAttentionListOfOutQuotationsPanel attentionPanel = new OnLoadAttentionListOfOutQuotationsPanel();
	        	OnLoadAttentionListOfProjectStagesPanel attentionPanel = new OnLoadAttentionListOfProjectStagesPanel();
	        	if(ACTIVITY_TYPE_5 == activityType){//待办
	        		attentionPanel.setStatus(1);
	        	}else{//已办
	        		attentionPanel.setStatus(2);
	        	}
	        	attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
	        }
		}else if(processType == PROCESS_TYPE_79) {
			if(ACTIVITY_TYPE_1 == activityType ||ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
				//我的发起面板
//				OnLoadApplyListOfProjectStagesPanel applyPanel = new OnLoadApplyListOfProjectStagesPanel();
				OnLoadApplyListOfProjectEmployeesPanel applyPanel = new OnLoadApplyListOfProjectEmployeesPanel();
				if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType) {
					applyPanel.setStatus(2);
				}
				applyPanel.commonQuery();
				popupWindow.addItem(applyPanel);
			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
//				OnLoadAuditListOfProjectStagesPanel auditPanel =  new OnLoadAuditListOfProjectStagesPanel();
				OnLoadAuditListOfProjectEmployeesPanel auditPanel =  new OnLoadAuditListOfProjectEmployeesPanel();
				if(ACTIVITY_TYPE_4 == activityType) {
					auditPanel.setStatus(1);
				}else if(ACTIVITY_TYPE_7 == activityType){
					auditPanel.setStatus(2);
				}
				auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
			}else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
//				OnLoadAttentionListOfProjectStagesPanel attentionPanel = new OnLoadAttentionListOfProjectStagesPanel();
				OnLoadAttentionListOfProjectEmployeesPanel attentionPanel = new OnLoadAttentionListOfProjectEmployeesPanel();
				if(ACTIVITY_TYPE_5 == activityType){//待办
					attentionPanel.setStatus(1);
				}else{//已办
					attentionPanel.setStatus(2);
				}
				attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
			}
		}else if(processType == PROCESS_TYPE_80) {
			if(ACTIVITY_TYPE_1 == activityType ||ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
				//我的发起面板
//				OnLoadApplyListOfProjectEmployeesPanel applyPanel = new OnLoadApplyListOfProjectEmployeesPanel();
				OnLoadApplyListOfProjectSettlementPanel applyPanel = new OnLoadApplyListOfProjectSettlementPanel();
				if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType) {
					applyPanel.setStatus(2);
				}
				applyPanel.commonQuery();
				popupWindow.addItem(applyPanel);
			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
//				OnLoadAuditListOfProjectEmployeesPanel auditPanel =  new OnLoadAuditListOfProjectEmployeesPanel();
				OnLoadAuditListOfProjectSettlementPanel auditPanel =  new OnLoadAuditListOfProjectSettlementPanel();
				if(ACTIVITY_TYPE_4 == activityType) {
					auditPanel.setStatus(1);
				}else if(ACTIVITY_TYPE_7 == activityType){
					auditPanel.setStatus(2);
				}
				auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
			}else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
//				OnLoadAttentionListOfProjectEmployeesPanel attentionPanel = new OnLoadAttentionListOfProjectEmployeesPanel();
				OnLoadAttentionListOfProjectSettlementPanel attentionPanel = new OnLoadAttentionListOfProjectSettlementPanel();
				if(ACTIVITY_TYPE_5 == activityType){//待办
					attentionPanel.setStatus(1);
				}else{//已办
					attentionPanel.setStatus(2);
				}
				attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
			}
		}else if(PROCESS_TYPE_84 == processType) {
			if (ACTIVITY_TYPE_1 == activityType) {
				//我的发起面板
				OnLoadApplyListOfPersonnelPanel applyPanel = new OnLoadApplyListOfPersonnelPanel();
				applyPanel.setProcessType(processType);
				applyPanel.createUploadButton();
				applyPanel.commonQuery();
				popupWindow.addItem(applyPanel);
			} else if (ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType) {
				OnLoadRefuseListOfPersonnelPanel refusePanel = new OnLoadRefuseListOfPersonnelPanel();
				refusePanel.setProcessType(processType);
				if (ACTIVITY_TYPE_2 == activityType) {//已驳回
					refusePanel.setStatus(5);
				} else {//已完成
					refusePanel.setStatus(3);
				}
				refusePanel.commonQuery();
				popupWindow.addItem(refusePanel);
			} else if (ACTIVITY_TYPE_4 == activityType || ACTIVITY_TYPE_7 == activityType) {//待办审批
				OnLoadAuditListOfPersonnelPanel auditPanel = new OnLoadAuditListOfPersonnelPanel();
				auditPanel.setProcessType(processType);
				auditPanel.setParentProcessType("spt.parent_process_type_id = 38");
				if (ACTIVITY_TYPE_4 == activityType) {
					auditPanel.setStatus(1);
				} else if (ACTIVITY_TYPE_7 == activityType) {
					auditPanel.setStatus(2);
				}
				auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
			}else if (ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType) {//待办、已办知会
				OnLoadAttentionListOfPersonnelPanel attentionPanel = new OnLoadAttentionListOfPersonnelPanel();
				attentionPanel.setProcessType(processType);
				if (ACTIVITY_TYPE_5 == activityType) {//待办
					attentionPanel.setStatus(1);
				} else {//已办
					attentionPanel.setStatus(2);
				}
				attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
			}
		}else if(PROCESS_TYPE_85 == processType) {
			if (ACTIVITY_TYPE_1 == activityType||ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType) {
				OnLoadApplyListOfProfessionalApprovalPanel applyPanel = new OnLoadApplyListOfProfessionalApprovalPanel();
				applyPanel.setProcessType(processType);
				applyPanel.setActivityType(activityType);
				if (ACTIVITY_TYPE_1 == activityType) {		//我的发起(发起/进行中)面板
					applyPanel.setStatus("( 0, 1 ) ");
				} else if(ACTIVITY_TYPE_2 == activityType){	//我的驳回(已驳回)面板
					applyPanel.setStatus("( 3, 5 ) ");
				}else {										//我的归档(已完成)面板
					applyPanel.setStatus("( 3, 5  ) ");
				}
				applyPanel.commonQuery();
				popupWindow.addItem(applyPanel);
			}else if (ACTIVITY_TYPE_4 == activityType || ACTIVITY_TYPE_7 == activityType) {//待办、已办审批
				OnLoadAuditListOfProfessionalApprovalPanel auditPanel = new OnLoadAuditListOfProfessionalApprovalPanel();
				auditPanel.setProcessType(processType);
				auditPanel.setActivityType(activityType);
				if (ACTIVITY_TYPE_4 == activityType) {			//待办-审核
					auditPanel.setStatus(1);
				} else if (ACTIVITY_TYPE_7 == activityType) {	//已办-审核
					auditPanel.setStatus(2);
				}
				auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
			}else if (ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType) {//待办、已办知会
				OnLoadAttentionListOfProfessionalApprovalPanel attentionPanel = new OnLoadAttentionListOfProfessionalApprovalPanel();
				attentionPanel.setProcessType(processType);
				attentionPanel.setActivityType(activityType);
				if (ACTIVITY_TYPE_5 == activityType) {			//待办-知会
					attentionPanel.setStatus(1);
				} else {										//已办-知会
					attentionPanel.setStatus(2);
				}
				attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
			}
		}else if(PROCESS_TYPE_86 == processType){
			if (ACTIVITY_TYPE_1 == activityType||ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType) {
				OnLoadApplyListOfOrderInfoPanel applyPanel = new OnLoadApplyListOfOrderInfoPanel();
				applyPanel.setActivityType(activityType);
				if (ACTIVITY_TYPE_1 == activityType) {		//我的发起(发起/进行中)面板
					applyPanel.setStatus("( 0, 1 ) ");
				} else if(ACTIVITY_TYPE_2 == activityType){	//我的驳回(已驳回)面板
					applyPanel.setStatus("( 3, 5 ) ");
				}else {										//我的归档(已完成)面板
					applyPanel.setStatus("( 3, 5  ) ");
				}
				applyPanel.setProcessType(processType);
				applyPanel.commonQuery();
				popupWindow.addItem(applyPanel);
			}else if (ACTIVITY_TYPE_4 == activityType || ACTIVITY_TYPE_7 == activityType) {//待办、已办审批
				OnLoadApproveContractRunDryPanel auditPanel = new OnLoadApproveContractRunDryPanel();
				auditPanel.setActivityType(activityType);
				if (ACTIVITY_TYPE_4 == activityType) {			//待办-审核
					auditPanel.setStatus(1);
				} else if (ACTIVITY_TYPE_7 == activityType) {	//已办-审核
					auditPanel.setStatus(2);
				}
				auditPanel.setProcessType(processType);
				auditPanel.commonQuery();
				popupWindow.addItem(auditPanel);
			}else if (ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType) {//待办、已办知会
				OnLoadAttentionListOfOrderInfoPanel attentionPanel = new OnLoadAttentionListOfOrderInfoPanel();
				SC.debugger();
				attentionPanel.setProcessType(processType);
				attentionPanel.setActivityType(activityType);
				if (ACTIVITY_TYPE_5 == activityType) {			//待办-知会
					attentionPanel.setStatus(1);
				} else {										//已办-知会
					attentionPanel.setStatus(2);
				}
				attentionPanel.commonQuery();
				popupWindow.addItem(attentionPanel);
			}
		}else{
        	if(ACTIVITY_TYPE_1 == activityType){//发起/进行中
        		OnLoadApplyListOfCostAllocationPanel applyPanel = new OnLoadApplyListOfCostAllocationPanel();
        		applyPanel.setProcessType(processType);
        		applyPanel.commonQuery();
        		popupWindow.addItem(applyPanel);
        	}else if(ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){//驳回/已完成
        		OnLoadRefuseListOfCostAllocationPanel applyPanel = new OnLoadRefuseListOfCostAllocationPanel();
        		applyPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_2 == activityType){
        			applyPanel.setProcessStatus(5);
        		}else if(ACTIVITY_TYPE_3 == activityType){
        			applyPanel.setProcessStatus(3);
        		}
        		applyPanel.commonQuery();
        		popupWindow.addItem(applyPanel);
        	}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
        		OnLoadAuditListOfCostAllocationPanel auditPanel =  new OnLoadAuditListOfCostAllocationPanel();
        		auditPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_4 == activityType) {
        			auditPanel.setStatus(1);
        		}else {
        			auditPanel.setStatus(2);
        		}
        		auditPanel.commonQuery();
        		popupWindow.addItem(auditPanel);
        	}/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
        		OnLoadAuditListOfCostAllocationPanel auditPanel =  new OnLoadAuditListOfCostAllocationPanel();
        		auditPanel.setProcessType(processType);
        		auditPanel.setStatus(2);
        		auditPanel.commonQuery();
        		popupWindow.addItem(auditPanel);
        	}*/else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
        		OnLoadAttentionListOfCostAllocationPanel attentionPanel = new OnLoadAttentionListOfCostAllocationPanel();
        		attentionPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_5 == activityType){//待办
        			attentionPanel.setStatus(1);
        		}else{//已办
        			attentionPanel.setStatus(2);
        		}
        		attentionPanel.commonQuery();
        		popupWindow.addItem(attentionPanel);
        	}/*else if(ACTIVITY_TYPE_6 == activityType || ACTIVITY_TYPE_9 == activityType){//待办、已办任务池
        		OnLoadTaskListOfCostAllocationPanel taskPanel = new OnLoadTaskListOfCostAllocationPanel();
        		taskPanel.setProcessType(processType);
        		if(ACTIVITY_TYPE_6 == activityType){//待办
        			taskPanel.setStatus(1);
        		}else{//已办
        			taskPanel.setStatus(2);
        		}
        		taskPanel.commonQuery();
        		popupWindow.addItem(taskPanel);
        	}*/
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
		Map<String,String> processIdMap = PomPlatformClientUtil.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_4);
		Map<String,String> processIconMap = PomPlatformClientUtil.getUserProcessIcon(PomPlatformClientUtil.PARENT_PROCESS_TYPE_4);
		for(String key : processIdMap.keySet()){
			Integer value = ClientUtil.checkAndGetIntValue(processIdMap.get(key));
			if (null != value && value.intValue() > 0
					&& !BaseHelpUtils.isNullOrEmpty(ClientUtil.getStringFromMap(processIconMap, key))) {
				if (!key.equals(PROCESS_TYPE_64_EXECUTE_NAME)) {
					continue;
				}
				final ImgButton button = new ImgButton();
				
				// 只有拥有成本调节申请权限的，成本调节按钮才会显示出来
				// if(key.equals("Cost_allocation") &&
				// !ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_ADMINISTRATION_GOODS_APPLY_BUTTON)){
				// button.hide();
				// }
				button.setWidth(155);
				button.setHeight(80);
				button.setSrc(ClientUtil.getStringFromMap(processIconMap, key));
				button.setCursor(Cursor.POINTER);
				button.setMargin(10);
				button.setID(PROCESSID + "_" + value);
				button.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						newPanel(value + "", 0);
					}
				});
				topLayout.addMember(button);
			}
		}
	}
    
    
    private void newPanel(String processId, int layoutMode){
		NewProcessWindow Reimbursement = new NewProcessWindow();
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
		Reimbursement.setTitle(KeyValueManager.getValue("employee_processes", processId));
		Reimbursement.setWidth("60%");
		Reimbursement.centerInPage();
		Reimbursement.show();
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
        return "ST_MyAdministrationDesignPanel";
    }
    
    
    
    
}
