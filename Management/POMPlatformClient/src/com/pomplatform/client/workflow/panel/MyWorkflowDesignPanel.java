package com.pomplatform.client.workflow.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
import com.pomplatform.client.approvalbudgetmanagementapplywork.panel.ApprovalBudgetManagementApplyWorkPanel;
import com.pomplatform.client.attachmentapprovalapply.panel.AttachmentApprovalApplyPanel;
import com.pomplatform.client.attachmentapprovalupcoming.panel.AttachmentApprovalUpcomingPanel;
import com.pomplatform.client.budgetmanagementapplywork.panel.BudgetManagementApplyWorkPanel;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.pomplatform.client.knowapprovalbudgetmanagementapplywork.panel.knowApprovalBudgetManagementApplyWorkPanel;
import com.pomplatform.client.knowattachmentapproval.panel.KnowAttachmentApprovalPanel;
import com.pomplatform.client.scapitaldistributionor.panel.CapitalDistributionsApplyOfWorkflowPanel;
import com.pomplatform.client.scapitaldistributionor.panel.CapitalDistributionsAttentionOfWorkflowPanel;
import com.pomplatform.client.scapitaldistributionor.panel.CapitalDistributionsAuditOfWorkflowPanel;
import com.pomplatform.client.scapitaldistributionor.panel.CapitalDistributionsPoolOfWorkflowPanel;
import com.pomplatform.client.specialdeduction.panel.SpecialDeductionRecordsApplyOfWorkflowPanel;
import com.pomplatform.client.specialdeduction.panel.SpecialDeductionRecordsAttentionOfWorkflowPanel;
import com.pomplatform.client.specialdeduction.panel.SpecialDeductionRecordsAuditOfWorkflowPanel;
import com.pomplatform.client.workflow.datasource.DSMyWorkflowDatasource;
import com.pomplatform.client.workflow.personnel.panel.OnLoadApplyListOfPersonnelPanel;
import com.pomplatform.client.workflow.personnel.panel.OnLoadAttentionListOfPersonnelPanel;
import com.pomplatform.client.workflow.personnel.panel.OnLoadAuditListOfPersonnelPanel;
import com.pomplatform.client.workflow.personnel.panel.OnLoadRefuseListOfPersonnelPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.KeyUpEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyUpHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class MyWorkflowDesignPanel extends AbstractWizadPage {
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
  	public static final int PROCESS_TYPE_2 = 2;//项目日常报销
  	public static final int PROCESS_TYPE_3 = 3;//普通日常报销
  	public static final int PROCESS_TYPE_4 = 4;//项目差旅报销
  	public static final int PROCESS_TYPE_5 = 5;//普通差旅报销
  	public static final int PROCESS_TYPE_6 = 6;//借款申请
  	public static final int PROCESS_TYPE_7 = 7;//付款申请
  	public static final int PROCESS_TYPE_8 = 8;//前期项目日常报销
  	public static final int PROCESS_TYPE_9 = 9;//前期项目差旅报销
  	public static final int PROCESS_TYPE_10 = 10;//公司日常报销
  	public static final int PROCESS_TYPE_11 = 11;//回款分配流程
  	public static final int PROCESS_TYPE_52 = 52;//预算单立项流程
  	public static final int PROCESS_TYPE_54 = 54;//预算附件审批流程
  	public static final int PROCESS_TYPE_58 = 58;//个税专项扣除审批流程
  	
    //定义面板样式
    private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
    public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    //定义主面板，分上下分层，top层是我的发起图片按钮，button层是我的事务层
    private VLayout mainLayout;
    //定义top层，即装载图片按钮
    private VLayout topLayout;
    
    //定义一个快速检索
    private HLayout superSearchLayout;
    
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
    //
    private DynamicForm __infoForm; 
    private TextItem superSearchTextItem;
    private IButton superSearchIbutton;
    
    //定义数据集的girdgird结束***********************
    
    public MyWorkflowDesignPanel() {
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
    	
    	//快速检索
    	superSearchLayout = new HLayout(2);
    	superSearchLayout.setHeight(60);
    	superSearchLayout.setBorder(BORDER_STYLE);
    	superSearchLayout.setBackgroundColor("#f2f2f2");
    	superSearchLayout.setWidth100();
    	superSearchLayout.setMembersMargin(10);
    	
    	__infoForm = new DynamicForm();
		__infoForm.setWidth(360);
		__infoForm.setHeight100();
		__infoForm.setNumCols(2);
		__infoForm.setMargin(10);
		
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
    	superSearchTextItem=new TextItem("superSearchText","编号");
    	superSearchTextItem.setWidth(280);
    	superSearchTextItem.setHeight(26);
    	
    	VLayout vbtn=new VLayout(10);
        superSearchIbutton=new IButton("快速检索");
        superSearchIbutton.setHeight(26);
        vbtn.setLayoutTopMargin(15);
        vbtn.addMember(superSearchIbutton);
        
        __infoForm.setFields(superSearchTextItem);
        superSearchLayout.addMember(__infoForm);
        superSearchLayout.addMember(vbtn);
        
        //给对应的人开权限   ，财务人员
        if(Objects.equals(ClientUtil.getEmployeeId(), 4)||
        		Objects.equals(ClientUtil.getEmployeeId(), 8)||
        		Objects.equals(ClientUtil.getEmployeeId(), 97)||
        		Objects.equals(ClientUtil.getEmployeeId(), 124)||
        		Objects.equals(ClientUtil.getEmployeeId(), 248)||
        		Objects.equals(ClientUtil.getEmployeeId(), 627)||
        		Objects.equals(ClientUtil.getEmployeeId(), 1101) 
        		|| ClientUtil.checkIsHavePermission(ERPPermissionStatic.MY_FINANCIAL_SEARCH_BILL)){
        	mainLayout.addMember(superSearchLayout);
        }
        superSearchTextItem.addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				String originalCode= BaseHelpUtils.getString(__infoForm.getItem("superSearchText").getValue());
				if(originalCode.length()==13){
					//取第一位，为了兼容，当第一位为8去掉
					String first=originalCode.substring(0, 1);
					//分为2段
					String startStr=originalCode.substring(0,6),
					endStr=originalCode.substring(7,12);
					
					String resultCode=startStr+"-"+endStr;
					if(Objects.equals(first, "8")){
						startStr=startStr.substring(1);
					}
					originalCode=resultCode;
					
					String code=originalCode;
					logger.info("resultCode========="+resultCode);
					
					__infoForm.getItem("superSearchText").setValue(code);
					
					if(BaseHelpUtils.isNullOrEmpty(code)){
						SC.say("编号不能为空");
						return;
					}
					Map<Object,Object> param = new HashMap<>();
					param.put("opt_type","getInspectionReport");
			    	param.put("employeeId",ClientUtil.getEmployeeId());
			    	param.put("code",originalCode);
			    	DBDataSource.callOperation("EP_CustomInspectionReport", param, new DSCallback() {
			            @Override
			            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
			            	if (dsResponse.getStatus() >= 0 && null != dsResponse.getData() && dsResponse.getData().length > 0) {
			                	Record[] records = dsResponse.getData();
		                		//获取模块类型 
		                		int type=BaseHelpUtils.getIntValue(records[0].getAttribute("type"));
		    					int activityType = 0;
		    					//获取流程类型
		    					int processType = BaseHelpUtils.getIntValue(records[0].getAttribute("processType")); 
		    					if(Objects.equals(type, 0)){
		    						activityType = 4;
		    					}else if(Objects.equals(type, 1)){
		    						activityType = 6;
		    					}
		    					operPanel(activityType,processType,code);
			                } else {
			                	SC.ask("本单子没有到你这或者不存在，是否发送企业微信消息给报销人？", new BooleanCallback() {
									
									@Override
									public void execute(Boolean value) {
										if(value){
											param.put("opt_type", "sendMsgToDrafter");
											DBDataSource.callOperation("EP_CustomInspectionReport", param, new DSCallback() {
									            @Override
									            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									            	
									                if (dsResponse.getStatus() >= 0) {
									                	SC.say("消息发送成功！");
									                } else {
									                	ClientUtil.displayErrorMessage(dsResponse);
									                }
									            }
									        });
										}
									}
								});
			                }
			                superSearchTextItem.clearValue();
			            }
			        });
				}
				
			}
		});
    	//快速检索 btn
    	superSearchIbutton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String code= BaseHelpUtils.getString(__infoForm.getItem("superSearchText").getValue());
				if(BaseHelpUtils.isNullOrEmpty(code)){
					SC.say("编号不能为空");
					return;
				}
				Map<Object,Object> param = new HashMap<>();
				param.put("opt_type","getInspectionReport");
		    	param.put("employeeId",ClientUtil.getEmployeeId());
		    	param.put("code",code);
		    	DBDataSource.callOperation("EP_CustomInspectionReport", param, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                if (dsResponse.getStatus() >= 0 && null != dsResponse.getData() && dsResponse.getData().length > 0) {
		                	Record[] records = dsResponse.getData();
	                		//获取模块类型 
	                		int type=BaseHelpUtils.getIntValue(records[0].getAttribute("type"));
	    					int activityType = 0;
	    					//获取流程类型
	    					int processType = BaseHelpUtils.getIntValue(records[0].getAttribute("processType")); 
	    					if(Objects.equals(type, 0)){
	    						activityType = 4;
	    					}else if(Objects.equals(type, 1)){
	    						activityType = 6;
	    					}
	    					operPanel(activityType,processType,code);
		                } else {
		                	SC.ask("本单子没有到你这或者不存在，是否发送企业微信消息给报销人？", new BooleanCallback() {
								
								@Override
								public void execute(Boolean value) {
									if(value){
										param.put("opt_type", "sendMsgToDrafter");
										DBDataSource.callOperation("EP_CustomInspectionReport", param, new DSCallback() {
								            @Override
								            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								            	
								                if (dsResponse.getStatus() >= 0) {
								                	SC.say("消息发送成功！");
								                } else {
								                	ClientUtil.displayErrorMessage(dsResponse);
								                }
								            }
								        });
									}
								}
							});
		                }
		            }
		        });
			}
		});
    	
    	
    	
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
//    	todoListPoolLayout.addMember(todoListPoolGrid);
    	
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
//    	doneListPoolLayout.addMember(doneListPoolGrid);
    	
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
    	param.put("parentProcessTypeId",PomPlatformClientUtil.PARENT_PROCESS_TYPE_1);
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
    	logger.info("code========="+code);
    	PopupWindow popupWindow = new PopupWindow(" ");
        popupWindow.setWidth100();
        popupWindow.setHeight100();
        popupWindow.centerInPage();
        SC.debugger();
    	switch(processType){
    		case PROCESS_TYPE_2://项目日常报销
    			popupWindow.setTitle("项目日常报销");
    			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
    				NormalReimbursementsApplyOfWorkflowPanel panel = new NormalReimbursementsApplyOfWorkflowPanel();
    	        	if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){//已驳回
    	        		panel.setStatus("spi.process_status IN ( 3, 5 )");
    	        	}
    				panel.setActivityType(activityType);
    				panel.setProcessType(processType);
    				panel.setParentCanvas(popupWindow);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批/已办审批
    				NormalReimbursementsAuditOfWorkflowPanel panel = new NormalReimbursementsAuditOfWorkflowPanel();
    				panel.setProcessType(processType);
    				if(ACTIVITY_TYPE_4 == activityType) {
    					panel.setStatus(1);
    				}else {
    					panel.setStatus(2);
    				}
    				panel.setCode(code);
    				panel.setParentProcessTypeId(1);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
    				AuditedNormalReimbursementPanel panel = new AuditedNormalReimbursementPanel();
    				panel.setProcessType(processType);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/else if(ACTIVITY_TYPE_5 == activityType){//待办知会
    				NormalReimbursementsAttentionOfWorkflowPanel panel = new NormalReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_8 == activityType){//已办知会
    				NormalReimbursementsAttentionOfWorkflowPanel panel = new NormalReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_6 == activityType){//待办任务池
    				NormalReimbursementsPoolOfWorkflowPanel panel = new NormalReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_9 == activityType){//已办任务池
    				NormalReimbursementsPoolOfWorkflowPanel panel = new NormalReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/
    			break;
    		case PROCESS_TYPE_3://普通日常报销
    			popupWindow.setTitle("普通日常报销");
    			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
    				NormalReimbursementsApplyOfWorkflowPanel panel = new NormalReimbursementsApplyOfWorkflowPanel();
    				if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){
    	        		panel.setStatus("spi.process_status IN ( 3, 5 )");
    	        	}
    	        	SC.debugger();
    				panel.setActivityType(activityType);
    				panel.setProcessType(processType);
    				panel.setParentCanvas(popupWindow);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批  //已办审批
    				NormalReimbursementsAuditOfWorkflowPanel panel = new NormalReimbursementsAuditOfWorkflowPanel();
    				panel.setProcessType(processType);
    				if(ACTIVITY_TYPE_4 == activityType) {
    					panel.setStatus(1);
    				}else {
    					panel.setStatus(2);
    				}
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_7 == activityType){
    				AuditedNormalReimbursementPanel panel = new AuditedNormalReimbursementPanel();
    				panel.setProcessType(processType);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/else if(ACTIVITY_TYPE_5 == activityType){//待办知会
    				NormalReimbursementsAttentionOfWorkflowPanel panel = new NormalReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_8 == activityType){//已办知会
    				NormalReimbursementsAttentionOfWorkflowPanel panel = new NormalReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_6 == activityType){//待办任务池
    				NormalReimbursementsPoolOfWorkflowPanel panel = new NormalReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_9 == activityType){//已办任务池
    				NormalReimbursementsPoolOfWorkflowPanel panel = new NormalReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/
    			break;
    		case PROCESS_TYPE_4://项目差旅报销
    			popupWindow.setTitle("项目差旅报销");
    			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
    				TravelReimbursementsApplyOfWorkflowPanel panel = new TravelReimbursementsApplyOfWorkflowPanel();
    				if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){
    	        		panel.setStatus("spi.process_status IN ( 3, 5 )");
    	        	}
    				panel.setActivityType(activityType);
    				panel.setProcessType(processType);
    				panel.setParentCanvas(popupWindow);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
    				TravelReimbursementsAuditOfWorkflowPanel panel = new TravelReimbursementsAuditOfWorkflowPanel();
    				panel.setProcessType(processType);
    				if(ACTIVITY_TYPE_4 == activityType) {
    					panel.setStatus(1);
    				}else {
    					panel.setStatus(2);
    				}
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
    				AuditedTravelReimbursementPanel panel = new AuditedTravelReimbursementPanel();
    				panel.setProcessType(processType);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/else if(ACTIVITY_TYPE_5 == activityType){//待办知会
    				TravelReimbursementsAttentionOfWorkflowPanel panel = new TravelReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_8 == activityType){//已办知会
    				TravelReimbursementsAttentionOfWorkflowPanel panel = new TravelReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel.getViewPanel());
    			}/*else if(ACTIVITY_TYPE_6 == activityType){//待办任务池
    				TravelReimbursementsPoolOfWorkflowPanel panel = new TravelReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_9 == activityType){//已办任务池
    				TravelReimbursementsPoolOfWorkflowPanel panel = new TravelReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/
    			break;
    		case PROCESS_TYPE_5://普通差旅报销
    			popupWindow.setTitle("普通差旅报销");
    			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
    				TravelReimbursementsApplyOfWorkflowPanel panel = new TravelReimbursementsApplyOfWorkflowPanel();
    				if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){
    	        		panel.setStatus("spi.process_status IN ( 3, 5 )");
    	        	}
    				panel.setActivityType(activityType);
    				panel.setProcessType(processType);
    				panel.setParentCanvas(popupWindow);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
    				TravelReimbursementsAuditOfWorkflowPanel panel = new TravelReimbursementsAuditOfWorkflowPanel();
    				panel.setProcessType(processType);
    				if(ACTIVITY_TYPE_4 == activityType) {
    					panel.setStatus(1);
    				}else {
    					panel.setStatus(2);
    				}
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
    				AuditedTravelReimbursementPanel panel = new AuditedTravelReimbursementPanel();
    				panel.setProcessType(processType);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/else if(ACTIVITY_TYPE_5 == activityType){//待办知会
    				TravelReimbursementsAttentionOfWorkflowPanel panel = new TravelReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_8 == activityType){//已办知会
    				TravelReimbursementsAttentionOfWorkflowPanel panel = new TravelReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_6 == activityType){//待办任务池
    				TravelReimbursementsPoolOfWorkflowPanel panel = new TravelReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_9 == activityType){//已办任务池
    				TravelReimbursementsPoolOfWorkflowPanel panel = new TravelReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/
    			break;
    		case PROCESS_TYPE_6://借款申请
    			popupWindow.setTitle("借款申请");
    			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
    				EmployeeMoneyApplyOfWorkflowPanel panel = new EmployeeMoneyApplyOfWorkflowPanel();
    				if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){
    	        		panel.setStatus("spi.process_status IN ( 3, 5 )");
    	        	}
    				panel.setActivityType(activityType);
    				panel.setParentCanvas(popupWindow);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
    				EmployeeMoneyAuditOfWorkflowPanel panel = new EmployeeMoneyAuditOfWorkflowPanel();
    				if(ACTIVITY_TYPE_4 == activityType) {
    					panel.setStatus(1);
    				}else {
    					panel.setStatus(2);
    				}
    				panel.setProcessType(processType);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
    				AuditedEmployeeBorrowMoneyPanel panel = new AuditedEmployeeBorrowMoneyPanel();
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/else if(ACTIVITY_TYPE_5 == activityType){//待办知会
    				EmployeeMoneyAttentionOfWorkflowPanel panel = new EmployeeMoneyAttentionOfWorkflowPanel();
    				panel.setStatus(1);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_8 == activityType){//已办知会
    				EmployeeMoneyAttentionOfWorkflowPanel panel = new EmployeeMoneyAttentionOfWorkflowPanel();
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_6 == activityType){//待办任务池
    				EmployeeMoneyPoolOfWorkflowPanel panel = new EmployeeMoneyPoolOfWorkflowPanel();
    				panel.setStatus(1);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_9 == activityType){//已办任务池
    				EmployeeMoneyPoolOfWorkflowPanel panel = new EmployeeMoneyPoolOfWorkflowPanel();
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/
    			break;
    		case PROCESS_TYPE_7://预付款申请
    			popupWindow.setTitle("付款申请");
    			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
    				PayMoneyApplyOfWorkflowPanel payMoneyPanel = new PayMoneyApplyOfWorkflowPanel();
    				if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){
    					payMoneyPanel.setStatus("spi.process_status IN ( 3, 5 )");
    	        	}
    				payMoneyPanel.setActivityType(activityType);
    				payMoneyPanel.setParentCanvas(popupWindow);
    				payMoneyPanel.commonQuery();
    				popupWindow.addItem(payMoneyPanel);
    			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
    				PayMoneyAuditOfWorkflowPanel panel = new PayMoneyAuditOfWorkflowPanel();
    				if(ACTIVITY_TYPE_4 == activityType) {
    					panel.setStatus(1);
    				}else {
    					panel.setStatus(2);
    				}
    				panel.setProcessType(processType);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
    				AuditedPayMoneyPanel panel = new AuditedPayMoneyPanel();
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/else if(ACTIVITY_TYPE_5 == activityType){//待办知会
    				PayMoneyAttentionOfWorkflowPanel panel = new PayMoneyAttentionOfWorkflowPanel();
    				panel.setStatus(1);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_8 == activityType){//已办知会
    				PayMoneyAttentionOfWorkflowPanel panel = new PayMoneyAttentionOfWorkflowPanel();
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_6 == activityType){//待办任务池
    				PayMoneyPoolOfWorkflowPanel panel = new PayMoneyPoolOfWorkflowPanel();
    				panel.setStatus(1);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_9 == activityType){//已办任务池
    				PayMoneyPoolOfWorkflowPanel panel = new PayMoneyPoolOfWorkflowPanel();
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/
    			break;
    		case PROCESS_TYPE_8:
    			popupWindow.setTitle("前期项目日常报销");
    			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
    				NormalReimbursementsApplyOfWorkflowPanel panel = new NormalReimbursementsApplyOfWorkflowPanel();
    				if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){
    					panel.setStatus("spi.process_status IN ( 3, 5 )");
    	        	}
    				panel.setActivityType(activityType);
    				panel.setProcessType(processType);
    				panel.setParentCanvas(popupWindow);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
    				NormalReimbursementsAuditOfWorkflowPanel panel = new NormalReimbursementsAuditOfWorkflowPanel();
    				panel.setProcessType(processType);
    				if(ACTIVITY_TYPE_4 == activityType) {
    					panel.setStatus(1);
    				}else {
    					panel.setStatus(2);
    				}
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
    				AuditedNormalReimbursementPanel panel = new AuditedNormalReimbursementPanel();
    				panel.setProcessType(processType);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/else if(ACTIVITY_TYPE_5 == activityType){//待办知会
    				NormalReimbursementsAttentionOfWorkflowPanel panel = new NormalReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_8 == activityType){//已办知会
    				NormalReimbursementsAttentionOfWorkflowPanel panel = new NormalReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_6 == activityType){//待办任务池
    				NormalReimbursementsPoolOfWorkflowPanel panel = new NormalReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_9 == activityType){//已办任务池
    				NormalReimbursementsPoolOfWorkflowPanel panel = new NormalReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/
    			break;
    		case PROCESS_TYPE_9:
    			popupWindow.setTitle("前期项目差旅报销");
    			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
    				TravelReimbursementsApplyOfWorkflowPanel panel = new TravelReimbursementsApplyOfWorkflowPanel();
    				if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){
    					panel.setStatus("spi.process_status IN ( 3, 5 )");
    	        	}
    				panel.setActivityType(activityType);
    				panel.setProcessType(processType);
    				panel.setParentCanvas(popupWindow);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
    				TravelReimbursementsAuditOfWorkflowPanel panel = new TravelReimbursementsAuditOfWorkflowPanel();
    				panel.setProcessType(processType);
    				if(ACTIVITY_TYPE_4 == activityType) {
    					panel.setStatus(1);
    				}else {
    					panel.setStatus(2);
    				}
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
    				AuditedTravelReimbursementPanel panel = new AuditedTravelReimbursementPanel();
    				panel.setProcessType(processType);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/else if(ACTIVITY_TYPE_5 == activityType){//待办知会
    				TravelReimbursementsAttentionOfWorkflowPanel panel = new TravelReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_8 == activityType){//已办知会
    				TravelReimbursementsAttentionOfWorkflowPanel panel = new TravelReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_6 == activityType){//待办任务池
    				TravelReimbursementsPoolOfWorkflowPanel panel = new TravelReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_9 == activityType){//已办任务池
    				TravelReimbursementsPoolOfWorkflowPanel panel = new TravelReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/
    			break;
    		case PROCESS_TYPE_10:
    			popupWindow.setTitle("公司日常报销");
    			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
    				NormalReimbursementsApplyOfWorkflowPanel panel = new NormalReimbursementsApplyOfWorkflowPanel();
    				if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){
    					panel.setStatus("spi.process_status IN ( 3, 5 )");
    	        	}
    				panel.setActivityType(activityType);
    				panel.setProcessType(processType);
    				panel.setParentCanvas(popupWindow);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
    				NormalReimbursementsAuditOfWorkflowPanel panel = new NormalReimbursementsAuditOfWorkflowPanel();
    				panel.setProcessType(processType);
    				if(ACTIVITY_TYPE_4 == activityType) {
    					panel.setStatus(1);
    				}else {
    					panel.setStatus(2);
    				}
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
    				AuditedNormalReimbursementPanel panel = new AuditedNormalReimbursementPanel();
    				panel.setProcessType(processType);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/else if(ACTIVITY_TYPE_5 == activityType){//待办知会
    				NormalReimbursementsAttentionOfWorkflowPanel panel = new NormalReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_8 == activityType){//已办知会
    				NormalReimbursementsAttentionOfWorkflowPanel panel = new NormalReimbursementsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_6 == activityType){//待办任务池
    				NormalReimbursementsPoolOfWorkflowPanel panel = new NormalReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_9 == activityType){//已办任务池
    				NormalReimbursementsPoolOfWorkflowPanel panel = new NormalReimbursementsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}*/
    			break;
    		case PROCESS_TYPE_11:
    			popupWindow.setTitle("回款分配");
    			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
    				CapitalDistributionsApplyOfWorkflowPanel panel = new CapitalDistributionsApplyOfWorkflowPanel();
    				if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){
    					panel.setStatus("spi.process_status IN ( 3, 5 )");
    	        	}
    				panel.setActivityType(activityType);
    				panel.setProcessType(processType);
    				panel.setParentCanvas(popupWindow);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_4 == activityType){//待办审批
    				CapitalDistributionsAuditOfWorkflowPanel panel = new CapitalDistributionsAuditOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_7 == activityType){//已办审批
    				CapitalDistributionsAuditOfWorkflowPanel panel = new CapitalDistributionsAuditOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_5 == activityType){//待办知会
    				CapitalDistributionsAttentionOfWorkflowPanel panel = new CapitalDistributionsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_8 == activityType){//已办知会
    				CapitalDistributionsAttentionOfWorkflowPanel panel = new CapitalDistributionsAttentionOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_6 == activityType){//待办任务池
    				CapitalDistributionsPoolOfWorkflowPanel panel = new CapitalDistributionsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(1);
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_9 == activityType){//已办任务池
    				CapitalDistributionsPoolOfWorkflowPanel panel = new CapitalDistributionsPoolOfWorkflowPanel();
    				panel.setProcessType(processType);
    				panel.setStatus(2);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}
    			break;
    		  	/*public static final int ACTIVITY_TYPE_1 = 1;//我的发起(发起/进行中)
    		  	public static final int ACTIVITY_TYPE_2 = 2;//我的驳回(已驳回)
    		  	public static final int ACTIVITY_TYPE_3 = 3;//我的归档(已完成)
    		  	public static final int ACTIVITY_TYPE_4 = 4;//待办-审核
    		  	public static final int ACTIVITY_TYPE_5 = 5;//待办-知会
    		  	public static final int ACTIVITY_TYPE_6 = 6;//待办-任务池
    		  	public static final int ACTIVITY_TYPE_7 = 7;//已办-审核
    		  	public static final int ACTIVITY_TYPE_8 = 8;//已办-知会
    		  	public static final int ACTIVITY_TYPE_9 = 9;//已办-任务池
*/    			
    		    case PROCESS_TYPE_52://预算单立项
    		    popupWindow.setTitle("预算单立项");
    			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType) {
    				BudgetManagementApplyWorkPanel panel=new BudgetManagementApplyWorkPanel();
    				if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){
    					panel.setStatus("spi.process_status IN ( 3, 5 )");
    	        	}
    				panel.setActivityType(activityType);
    				panel.setProcessType(processType);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
    				ApprovalBudgetManagementApplyWorkPanel panel=new ApprovalBudgetManagementApplyWorkPanel();
    				panel.setProcessType(processType);
    				if(ACTIVITY_TYPE_4 == activityType){//待办
    					panel.setStatus(1);
		        	}else{//已办
		        		panel.setStatus(2);
		        	}
    				panel.setCode(code);
    				panel.commonQuery();
    				popupWindow.addItem(panel);
    			}/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
    				AlreadyApprovalBudgetManagementApplyWorkPanel Panel =new AlreadyApprovalBudgetManagementApplyWorkPanel();
    				Panel.setProcessType(processType);
    				Panel.commonQuery();
					popupWindow.addItem(Panel);
		        }*/else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
		        	knowApprovalBudgetManagementApplyWorkPanel attentionPanel=new knowApprovalBudgetManagementApplyWorkPanel();
		        	attentionPanel.setProcessType(processType);
		        	if(ACTIVITY_TYPE_5 == activityType){//待办
		        		attentionPanel.setStatus(1);
		        	}else{//已办
		        		attentionPanel.setStatus(2);
		        	}
		        	attentionPanel.commonQuery();
					popupWindow.addItem(attentionPanel);
		        }/*else if(ACTIVITY_TYPE_6 == activityType || ACTIVITY_TYPE_9 == activityType){//待办、已办任务池
		        	TaskApprovalBudgetManagementApplyWorkPanel taskPanel=new TaskApprovalBudgetManagementApplyWorkPanel();
		        	taskPanel.setProcessType(processType);
		        	if(ACTIVITY_TYPE_6 == activityType){//待办
		        		taskPanel.setStatus(1);
		        	}else{//已办
		        		taskPanel.setStatus(2);
		        	}
		        	taskPanel.commonQuery();
					popupWindow.addItem(taskPanel);
		        }*/
    			break;
    		    case PROCESS_TYPE_54://预算附件审批
    		    	popupWindow.setTitle("预算附件审批");
    		    	if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType) {
    		    		AttachmentApprovalApplyPanel panel=new AttachmentApprovalApplyPanel();
    		    		if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){
        					panel.setStatus("spi.process_status IN ( 3, 5 )");
        	        	}
    		    		panel.setActivityType(activityType);
        				panel.setProcessType(processType);
        				panel.commonQuery();
        				popupWindow.addItem(panel);
    		    	}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批
    		    		AttachmentApprovalUpcomingPanel panel=new AttachmentApprovalUpcomingPanel();
        				panel.setProcessType(processType);
        				if(ACTIVITY_TYPE_4 == activityType){//待办
        					panel.setStatus(1);
    		        	}else{//已办
    		        		panel.setStatus(2);
    		        	}
        				panel.setCode(code);
        				panel.commonQuery();
        				popupWindow.addItem(panel);
        			}/*else if(ACTIVITY_TYPE_7 == activityType){//已办审批
        				AttachmentApprovalAlreadyPanel Panel =new AttachmentApprovalAlreadyPanel();
        				Panel.setProcessType(processType);
        				Panel.commonQuery();
    					popupWindow.addItem(Panel);
    		        }*/else if(ACTIVITY_TYPE_5 == activityType || ACTIVITY_TYPE_8 == activityType){//待办、已办知会
    		        	KnowAttachmentApprovalPanel attentionPanel=new KnowAttachmentApprovalPanel();
    		        	attentionPanel.setProcessType(processType);
    		        	if(ACTIVITY_TYPE_5 == activityType){//待办
    		        		attentionPanel.setStatus(1);
    		        	}else{//已办
    		        		attentionPanel.setStatus(2);
    		        	}
    		        	attentionPanel.commonQuery();
    					popupWindow.addItem(attentionPanel);
    		        }/*else if(ACTIVITY_TYPE_6 == activityType || ACTIVITY_TYPE_9 == activityType){//待办、已办任务池
    		        	TaskAttachmentApprovalsPanel taskPanel=new TaskAttachmentApprovalsPanel();
    		        	taskPanel.setProcessType(processType);
    		        	if(ACTIVITY_TYPE_6 == activityType){//待办
    		        		taskPanel.setStatus(1);
    		        	}else{//已办
    		        		taskPanel.setStatus(2);
    		        	}
    		        	taskPanel.commonQuery();
    					popupWindow.addItem(taskPanel);
    		        }*/
    		    	break;	
        	case PROCESS_TYPE_58://专项审批
        			popupWindow.setTitle("个税专项扣除申请");
        			if(ACTIVITY_TYPE_1 == activityType || ACTIVITY_TYPE_2 == activityType || ACTIVITY_TYPE_3 == activityType){
        				SpecialDeductionRecordsApplyOfWorkflowPanel panel = new SpecialDeductionRecordsApplyOfWorkflowPanel();
        	        	if(ACTIVITY_TYPE_2 == activityType||ACTIVITY_TYPE_3 == activityType){//已驳回
        	        		panel.setStatus(1);
        	        	}else {
        	        		panel.setStatus(2);
        	        	}
        				panel.setActivityType(activityType);
        				panel.setParentCanvas(popupWindow);
        				panel.commonQuery();
        				popupWindow.addItem(panel);
        			}else if(ACTIVITY_TYPE_4 == activityType||ACTIVITY_TYPE_7 == activityType){//待办审批/已办审批
        				SpecialDeductionRecordsAuditOfWorkflowPanel panel = new SpecialDeductionRecordsAuditOfWorkflowPanel();
        				panel.setProcessType(processType);
        				if(ACTIVITY_TYPE_4 == activityType) {
        					panel.setStatus(1);
        				}else {
        					panel.setStatus(2);
        				}
        				panel.commonQuery();
        				popupWindow.addItem(panel);
        			}else if(ACTIVITY_TYPE_5 == activityType||ACTIVITY_TYPE_8 == activityType){//待办知会  已办知会
        				SpecialDeductionRecordsAttentionOfWorkflowPanel panel = new SpecialDeductionRecordsAttentionOfWorkflowPanel();
        				if(ACTIVITY_TYPE_5 == activityType) {
        					panel.setStatus(1);
        				}else {
        					panel.setStatus(2);
        				}
        				panel.commonQuery();
        				popupWindow.addItem(panel);
        			}
        		break;
			default:
				if(ACTIVITY_TYPE_1 == activityType ){
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
		        	auditPanel.setParentProcessType("spt.parent_process_type_id = 1");
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
				break;
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
    	Map<String, String> params = new HashMap<>();
    	params.put("optType", "employeeReimbursable");
    	params.put("employeeId", ClientUtil.getUserId());
    	DBDataSource.callOperation("EP_FinancicalTransAccountProcessor", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				boolean reimbursable = true;
				if(dsResponse.getStatus() < 0) {
					reimbursable = false;
				}
				Map<String,String> processIdMap = PomPlatformClientUtil.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_1);
				Map<String,String> processIconMap = PomPlatformClientUtil.getUserProcessIcon(PomPlatformClientUtil.PARENT_PROCESS_TYPE_1);
				int maxWidth = topLayout.getWidth();
				int totalWidth = 0;
				HLayout oneLayout = new HLayout();
				HLayout twoLayout = new HLayout();
				for(String key : processIdMap.keySet()){
					if(key.equals("Attachment_Approval")) {
						continue;
					}
					Integer value = ClientUtil.checkAndGetIntValue(processIdMap.get(key));
					if(null == value || value.intValue() == 0) {
						continue;
					}
					if(!reimbursable && (key.equals(ClientStaticUtils.BORROW_MONEY_MANAGE) || key.equals(ClientStaticUtils.PAY_MONEY_MANAGE))) {
						continue;
					}
					if(null != value && value.intValue() > 0){
						final ImgButton button = new ImgButton();
						button.setWidth(ClientStaticUtils.FLOW_IMG_WIDTH);
						button.setHeight(ClientStaticUtils.FLOW_IMG_HEIGHT);
						button.setSrc(ClientUtil.getStringFromMap(processIconMap, key));
						button.setCursor(Cursor.POINTER);
						button.setMargin(10);
						button.setID(PROCESSID + "_" + value);
						button.addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								newPanel(value+"", 0);
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
		});
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
        return "ST_MyWorkflowPanel";
    }
    
}
