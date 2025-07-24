package com.pomplatform.client.contractinfo.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.commonNormalReimbursement.datasource.DSNormalReimbursementWithDepartment;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 * @author CL
 */
public class CustomAddSubContractMainTwoPanel extends VLayout implements HasHandlers {

	private static final Logger __logger = Logger.getLogger("");
	public static CustomAddChildContractStartPanel childContract;//子订单列表
	public static CustomAddConsiderationPanel consideration;//项目信息列表
	public static CustomAddChildManageContractStartPanel childManageContract;//管理订单列表
	private Window parentWindow;
	public static DynamicForm __infoForm;
    public static TextAreaItem subContractRemark;//整个子订单的备注
    public static IButton saveRemarkBtn;
    public static IButton uploadButton;
    public static DelicacyListGrid childManageGrid;
    private static DelicacyListGrid reserveGrid;
    private static DelicacyListGrid detailGrid;
    private static DataSource childSheetDetailSource;
    private static DataSource reserveSheetDetailSource;
    private static DataSourceIntegerField businessTypeField;
    //附件
	private final LinkItem attachmentItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
    //定义map来存放每个业务部门对应的父级部门Id
    private static Map<Integer,Integer> plateMap = new HashMap<>();

	@SuppressWarnings({ "deprecation", "static-access" })
	public CustomAddSubContractMainTwoPanel(int contractId, Record record, int flowStatus,Map<String,String> map) {
		setHeight100();
		setMembersMargin(5);
		final int __contractId = contractId;
		// 获取项目编号
		final String projectCode = record.getAttribute("projectCode");
		//获取项目名称
		final String projectName = record.getAttribute("contractName");
		
		SectionStack leftSectionStack = new SectionStack();  
		leftSectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
		leftSectionStack.setWidth("38%");  
		leftSectionStack.setHeight100(); 
        //左侧列表
        SectionStackSection bjSection = new SectionStackSection("项目信息列表");  
        bjSection.setExpanded(true); 
        bjSection.setCanCollapse(false); 
        consideration = new CustomAddConsiderationPanel();
        consideration.setHeight("50%");
		consideration.setContractId(contractId);
		consideration.startEdit();
		bjSection.addItem(consideration);
		leftSectionStack.addSection(bjSection);
		
		SectionStackSection manageSection = new SectionStackSection("管理订单列表");  
		manageSection.setExpanded(true); 
		manageSection.setCanCollapse(false);
		childManageContract = new CustomAddChildManageContractStartPanel(flowStatus,map);
		childManageContract.setContractId(contractId);
		childManageContract.setHeight("50%");
		childManageContract.startEdit();
		manageSection.addItem(childManageContract);
		leftSectionStack.addSection(manageSection);
		
		//右侧列表
		SectionStack rightSectionStack = new SectionStack();  
		rightSectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
		rightSectionStack.setWidth("50%");  
		rightSectionStack.setHeight100(); 
		
		SectionStackSection childSheetSection = new SectionStackSection("子订单列表");  
		childSheetSection.setExpanded(true); 
		childSheetSection.setCanCollapse(false);
		childContract = new CustomAddChildContractStartPanel(flowStatus,consideration);
		childContract.setHeight("50%");
		childContract.setContractId(contractId);
		childContract.setLoadAll(false);
		childContract.startEdit();
		childContract.SourceGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
				Record record = event.getRecord();
				Map<String,Object> params = new HashMap<>();
				params.put("subContractId", record.getAttribute("subContractId"));
				DBDataSource.callOperation("ST_DesignConsideration","find",params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							detailGrid.setDataSource(childSheetDetailSource);
							detailGrid.setData(dsResponse.getData());
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		childSheetSection.addItem(childContract);
		rightSectionStack.addSection(childSheetSection);
		
		//拆分价字段
		DataSourceTextField mainDesignAreaNameField = new DataSourceTextField("mainDesignAreaName","区域(设计范围)");
		DataSourceTextField designAreaField = new DataSourceTextField("designArea","计容建筑面积(㎡)");
		DataSourceTextField designUnitPriceField = new DataSourceTextField("designUnitPrice","设计单价(元)");
		DataSourceTextField splitPriceField = new DataSourceTextField("splitPrice","拆分价金额");
		//公用字段
		DataSourceTextField subContractIdField = new DataSourceTextField("subContractId","子合同Id");
		subContractIdField.setHidden(true);
		DataSourceTextField parentIdField = new DataSourceTextField("parentId","合同Id");
		parentIdField.setHidden(true);
		DataSourceTextField projectCodeField = new DataSourceTextField("projectCode","项目编号");
		projectCodeField.setHidden(true);
		projectCodeField.setCanEdit(false);
		DataSourceTextField subContractCodeField = new DataSourceTextField("subContractCode","订单编号");
		subContractCodeField.setCanEdit(false);
		businessTypeField = new DataSourceIntegerField("businessType","业务类别");
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		DataSourceIntegerField projectTypeField = new DataSourceIntegerField("projectType","项目类别");
		projectTypeField.setCanEdit(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		DataSourceIntegerField departmentIdField = new DataSourceIntegerField("departmentId","承接部门");
		departmentIdField.setCanEdit(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		DataSourceFloatField sheetTotalIntegralField = new DataSourceFloatField("sheetTotalIntegral","订单总积分");
		sheetTotalIntegralField.setDecimalPad(2);
		sheetTotalIntegralField.setFormat("##,###,###,###,##0.00");
		DataSourceBooleanField isHistoryField = new DataSourceBooleanField("isHistory","变更前订单");
		isHistoryField.setCanEdit(false);
		DataSourceTextField subContractNameField = new DataSourceTextField("subContractName","订单名称");
		subContractNameField.setCanEdit(false);
		TextAreaItem textAreaItem = new TextAreaItem();  
        textAreaItem.setHeight(70);  
        subContractNameField.setEditorType(textAreaItem); 
		DataSourceTextField remarkField = new DataSourceTextField("remark","备注");
		remarkField.setEditorType(textAreaItem); 
		
		//拆分价dataSource定义
		childSheetDetailSource = new DataSource();
		childSheetDetailSource.addField(businessTypeField);
		childSheetDetailSource.addField(projectTypeField);
		childSheetDetailSource.addField(mainDesignAreaNameField);
		childSheetDetailSource.addField(designAreaField);
		childSheetDetailSource.addField(designUnitPriceField);
		childSheetDetailSource.addField(splitPriceField);
		childSheetDetailSource.addField(remarkField);
        
		// 创建子合同按钮
		IButton showButto = new IButton("创建订单");
		showButto.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] records = consideration.resultGrid.getRecords();
				if (records.length > 0) {
					SC.ask("提示", "确认创建？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								SC.debugger();
								Record r = records[0];
								int outQuotationId = BaseHelpUtils.getIntValue(r.getAttribute("outQuotationId"));
								int mainProjectId = BaseHelpUtils.getIntValue(r.getAttribute("mainProjectId"));
								if(!BaseHelpUtils.isNullOrEmpty(r)) {
									Map<String, Object> params = new HashMap<>();
									params.put("opt_type", "addSubContractByMainProjectBusinessType");
									params.put("contractId", __contractId);
									params.put("projectCode", projectCode);
									params.put("outQuotationId", outQuotationId);
									params.put("mainProjectId", mainProjectId);
									DBDataSource.callOperation("EP_CustomSubContractHandler", "", params, new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() > 0) {
												childContract.startEdit();
												consideration.startEdit();
											}
										}
									});
								}else {
									SC.say("项目信息不能为空");
								}
							}
						}
					});
				} else {
					SC.say("项目信息不能为空");
				}
			}
		});

		// 撤销按钮
		IButton revertButto = new IButton("撤销订单");
		revertButto.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record[] records = childContract.SourceGrid.getSelectedRecords();
				if (records.length > 0) {
					if(records[0].getAttributeAsBoolean("isHistory")){
						SC.say("历史订单,不可以撤销!");
						return;
					}
					SC.ask("提示", "确认撤销？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								// 获取子合同主键
								int subContractId = records[0].getAttributeAsInt("subContractId");
								Map<String, Object> params = new HashMap<>();
								params.put("subContractId", subContractId);
								params.put("contractId", contractId);
								params.put("opt_type", "delelteSubContract");
								params.put("isLoadAll", false);
								params.put("type", 0);
								DBDataSource.callOperation("EP_CustomSubContractHandler", "", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() > 0) {
											childContract.startEdit();
											consideration.startEdit();
										}
									}
								});
							}
						}
					});
				} else {
					SC.say("请选择子订单");
				}
			}
		});
		
		IButton bindingBtn = new IButton("关联绑定");
		bindingBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!consideration.resultGrid.anySelected()){
					SC.say("请选择需要绑定的拆分价");
					return;
				}
				if(!CustomAddChildContractStartPanel.SourceGrid.anySelected()){
					SC.say("请选择需要绑定的子订单");
					return;
				}else{
					if(!CustomAddChildContractStartPanel.SourceGrid.getSelectedRecord().getAttributeAsBoolean("isHistory")){
						SC.say("请选择变更前的子订单进行绑定");
						return;
					}
				}
				SC.ask("确认绑定?", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							final ListGridRecord[] records = consideration.resultGrid.getSelectedRecords();
							int subContractId = CustomAddChildContractStartPanel.SourceGrid.getSelectedRecord().getAttributeAsInt("subContractId");
							// 获取拆分价Id信息
							String ids = "";
							for (int i = 0; i < records.length; i++) {
								int desiderationId = BaseHelpUtils
										.getIntValue(records[i].getAttribute("designConsiderationId"));
								if (i != 0) {
									ids = ids + ",";
								}
								ids = ids + desiderationId;
							}
							Map<String, Object> params = new HashMap<>();
							params.put("ids", ids);
							params.put("opt_type", "considerateBindSubcontract");
							params.put("projectCode", projectCode);
							params.put("contractId", __contractId);
							params.put("subContractId", subContractId);
							DBDataSource.callOperation("EP_CustomSubContractHandler", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() > 0) {
										childContract.startEdit();
										consideration.startEdit();
									}
								}
							});
						}
						
					}
				});
			}
		});
		
		IButton unBindBtn = new IButton("取消绑定");
		unBindBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord[] records = childContract.SourceGrid.getSelectedRecords();
				
				if (records.length > 0) {
					if(!records[0].getAttributeAsBoolean("isHistory")){
						SC.say("只有历史订单才能执行取消绑定功能。");
						return;
					}
					SC.ask("提示", "确认取消绑定？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								// 获取子合同主键
								int subContractId = records[0].getAttributeAsInt("subContractId");
								Map<String, Object> params = new HashMap<>();
								params.put("subContractId", subContractId);
								params.put("opt_type", "delelteSubContract");
								params.put("type", 1);
								DBDataSource.callOperation("EP_CustomSubContractHandler", "", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() > 0) {
											childContract.startEdit();
											consideration.startEdit();
										}
									}
								});
							}
						}
					});
				} else {
					SC.say("请选择子订单");
				}
			}
		});
		
		// 提交按钮
		IButton submitButto = new IButton("提交订单");
		submitButto.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String subContractRemark=BaseHelpUtils.getString(__infoForm.getItem("subContractRemark").getValue());
				if(BaseHelpUtils.isNullOrEmpty(subContractRemark)){
					SC.say("订单备注不能空");
					return;
				}
				String attachment=BaseHelpUtils.getString(__infoForm.getItem("attachment").getValue());
				String attachmentId=BaseHelpUtils.getString(__infoForm.getItem("attachmentId").getValue());
				String attachmentName=BaseHelpUtils.getString(__infoForm.getItem("attachmentName").getValue());
//				if(BaseHelpUtils.isNullOrEmpty(attachment)|| BaseHelpUtils.isNullOrEmpty(attachmentId) ||BaseHelpUtils.isNullOrEmpty(attachmentName)){
//					SC.say("附件不能空");
//					return;
//				}
				boolean pass = true;// 检测是否还存在
				
				BigDecimal moneySum = BigDecimal.ZERO;
				BigDecimal sheetTotalIntegral = BigDecimal.ZERO;
				BigDecimal sheetIntegral = BigDecimal.ZERO;
				BigDecimal percentage = BigDecimal.ZERO;
				
				//子订单列表
				ListGridRecord[] list = childContract.SourceGrid.getRecords();
				if(list.length<=0) {
					SC.say("子订单列表不能空");
					return;
				}else {
					for (ListGridRecord listGridRecord : list) {
						 moneySum =moneySum.add( BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("moneySum")));
						 sheetTotalIntegral =sheetTotalIntegral.add( BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("sheetTotalIntegral")));
						 sheetIntegral = sheetIntegral.add( BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("sheetIntegral")));
						 percentage =percentage.add( BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("percentage")));
					}
				}

				Record[] manageList = childManageContract.SourceGrid.getRecords();
				for(Record e : manageList){
					int projectType = BaseHelpUtils.getIntValue(e.getAttribute("projectType"));
					if(projectType == 16 && BaseHelpUtils.isNullOrEmpty(e.getAttribute("projectManageId"))){
						SC.say("提示","项目管理费的项目经理不能为空");
						return;
					}
					if(BaseHelpUtils.isNullOrEmpty(e.getAttribute("subContractCode"))){
						SC.say("提示","订单编号不能为空，请选择业务类别和承接部门");
						return;
					}
					if(BaseHelpUtils.isNullOrEmpty(e.getAttribute("sheetTotalIntegral"))){
						SC.say("提示","订单总积分不能为空");
						return;
					}
				}
				if (pass) {
					SC.ask("提示", "确认提交订单？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								Record[] childRecords = childManageContract.SourceGrid.getRecords();
								Map<String, Object> params = new HashMap<>();
								params.put("opt_type", "saveContentInfo");
								params.put("employeeId", ClientUtil.getEmployeeId());
								params.put("contractId", __contractId);
								params.put("contentInfo", __infoForm.getItem("subContractRemark").getValue());
								params.put("attachmentId", __infoForm.getItem("attachmentId").getValue());
								params.put("attachment", __infoForm.getItem("attachment").getValue());
								DBDataSource.callOperation("EP_CustomSubContractHandler", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() > 0) {
											// 获取子合同主键
											Map<String, Object> params = new HashMap<>();
											params.put("contractId", __contractId);
											params.put("opt_type", "goFlowMainContract");
											params.put("flowStatus", 3);
											Map<Integer,Boolean> idMap = new HashMap<>();
											for(Record e : childRecords){
												int subContractId = BaseHelpUtils.getIntValue(e.getAttribute("subContractId"));
												idMap.put(subContractId,Boolean.FALSE);
											}
											for(Record e : manageList){
												int subContractId = BaseHelpUtils.getIntValue(e.getAttribute("subContractId"));
												idMap.put(subContractId,Boolean.TRUE);
											}
											params.put("idMap", idMap);
											MapUtils.convertRecordToMap(childManageContract.SourceGrid.getDataSource(), manageList, params, "twoSubContract");
											DBDataSource.callOperation("EP_CustomMainContractHandler", "", params,
											new DSCallback() {
												@Override
												public void execute(DSResponse dsResponse, Object data,
														DSRequest dsRequest) {
													if (dsResponse.getStatus() > 0) {
														getParentWindow().destroy();
														DataEditEvent dee = new DataEditEvent();
														fireEvent(dee);
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
				} else {
					SC.say("还存在有拆分价金额的报价单没进行订单创建,不准许提交！");
				}
			}
		});
//		IButton projectManageBtn = new IButton("项目管理");
//		projectManageBtn.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				// 先将数据保存数据库
//				Map<String, Object> params = new HashMap<>();
//				params.put("contractId", __contractId);
//				params.put("opt_type", "addProjectManageSubContract");
//				DBDataSource.callOperation("EP_CustomSubContractHandler", params, new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if (dsResponse.getStatus() > 0) {
//							childContract.SourceGrid.setData(dsResponse.getData());
//							int index=childContract.SourceGrid.getRecordList().getLength();
//							CustomAddChildContractStartPanel.SourceGrid.startEditing(index-1);
//						} else {
//							ClientUtil.displayErrorMessage(dsResponse);
//						}
//					}
//				});
//			}
//		});
		
		
		IButton addMlgBtn = new IButton("添加管理订单");
		addMlgBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SC.debugger();
				Record newRecord = new Record();
				newRecord.setAttribute("contractId",__contractId);
				newRecord.setAttribute("projectType",16);//设置为管理订单
				newRecord.setAttribute("subContractName","(项目管理)"+projectName);
				newRecord.setAttribute("projectCode",projectCode);
				newRecord.setAttribute("isAuto",Boolean.TRUE);
				newRecord.setAttribute("parentId",__contractId);
				newRecord.setAttribute("moneySum",BigDecimal.ZERO);
				newRecord.setAttribute("sheetAmount",BigDecimal.ZERO);
				newRecord.setAttribute("sheetTotalIntegral",BigDecimal.ZERO);
				newRecord.setAttribute("complaintPercentage",BigDecimal.ZERO);
//				childManageContract.SourceGrid.addData(newRecord);
//				childManageContract.SourceGrid.selectRecord(newRecord);
				
				Record[] manageList =new Record[1];
				manageList[0] = newRecord;
				// 先将数据保存数据库
				Map<String, Object> params = new HashMap<>();
				params.put("opt_type", "addProjectManageSubContract");
				params.put("contractId", __contractId);
				MapUtils.convertRecordToMap(childManageContract.SourceGrid.getDataSource(), manageList, params, "twoSubContract");
				DBDataSource.callOperation("EP_CustomSubContractHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						SC.debugger();
						if (dsResponse.getStatus() > 0) {
							childManageContract.startEdit();
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		IButton delMlgBtn = new IButton("删除管理订单");
		delMlgBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				
				ListGridRecord selectedRecord = childManageContract.SourceGrid.getSelectedRecord();
				if(BaseHelpUtils.isNullOrEmpty(selectedRecord)) {
					SC.say("提示","请选择一条数据");
					return;
				}
				Map<String, Object> params = new HashMap<>();
				params.put("subContractId", BaseHelpUtils.getIntValue(selectedRecord.getAttribute("subContractId")));
				DBDataSource.callOperation("ST_SubContract","delete", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							childManageContract.startEdit();
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		
		SectionStackSection remarkSection = new SectionStackSection("备注详情");  
		remarkSection.setExpanded(true); 
		remarkSection.setCanCollapse(false); 
		//添加备注框
        __infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight100();
		__infoForm.setDataSource(DSNormalReimbursementWithDepartment.getInstance());
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		subContractRemark=new TextAreaItem("subContractRemark","订单备注");
		subContractRemark.setWidth("*");
		
		attachmentItem = new LinkItem("attachment");
		attachmentItem.setWidth("*");
		attachmentItem.setCanEdit(false);
		
		attachmentIdItem = new TextItem("attachmentId", "附件ID");
		attachmentIdItem.setHidden(true);
		
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setHidden(true);
		
		
		saveRemarkBtn=new IButton("保存");
		VLayout saveVL=new VLayout(10);
		saveVL.setLayoutTopMargin(40);
		saveVL.setLayoutRightMargin(3);
//		saveVL.addMember(saveRemarkBtn);
		saveRemarkBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				
//				if(__infoForm.getItem("attachmentId").getValue()==null || __infoForm.getItem("attachment").getValue() ==null) {
//					SC.say("提示","附件不能为空");
//					return;
//				}
				if(__infoForm.getItem("subContractRemark").getValue() ==null) {
					SC.say("提示","备注不能为空");
					return;
				}
				
				Map<String, Object> params = new HashMap<>();
				params.put("opt_type", "saveContentInfo");
				params.put("employeeId", ClientUtil.getEmployeeId());
				params.put("contractId", __contractId);
				params.put("contentInfo", __infoForm.getItem("subContractRemark").getValue());
				params.put("attachmentId", __infoForm.getItem("attachmentId").getValue());
				params.put("attachment", __infoForm.getItem("attachment").getValue());
				
				DBDataSource.callOperation("EP_CustomSubContractHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() > 0) {
							SC.say("save success");
						}
					}
				});
				
			}
		});
		
		uploadButton= new IButton("上传启动函", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				new CommonUploadWindow("上传启动函", false, 100, null, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							attachmentItem.setValue(data.get(key).getAttribute("fileUrl"));
							attachmentIdItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							attachmentItem.setLinkTitle(fileName);
							attachmentNameItem.setValue(fileName);
						}
					}
				});
			}
		});
		
		
		__infoForm.setFields(subContractRemark,attachmentItem,attachmentIdItem,attachmentNameItem);
		
		HLayout remarkLayout=new HLayout(10);
		remarkLayout.setHeight("50%");
		remarkLayout.addMember(__infoForm);
		remarkLayout.addMember(saveVL);
		remarkSection.addItem(remarkLayout);
		rightSectionStack.addSection(remarkSection);
		
		Label breakLabel = new Label("");
		// 左边操作按钮面板
		VLayout leftButtonLayout = new VLayout(5);
		leftButtonLayout.setLayoutTopMargin(45);
		leftButtonLayout.setWidth("6%");
		leftButtonLayout.setHeight100();
		leftButtonLayout.addMember(showButto);
		leftButtonLayout.addMember(revertButto);
		leftButtonLayout.addMember(breakLabel);
		leftButtonLayout.addMember(bindingBtn);
		leftButtonLayout.addMember(unBindBtn);
		leftButtonLayout.addMember(breakLabel);
		leftButtonLayout.addMember(breakLabel);
		leftButtonLayout.addMember(breakLabel);
//		leftButtonLayout.addMember(createReserveBtn);
		leftButtonLayout.addMember(addMlgBtn);
		leftButtonLayout.addMember(delMlgBtn);
		// 右边操作按钮面板
		VLayout rightButtonLayout = new VLayout(5);
		rightButtonLayout.setLayoutTopMargin(45);
		rightButtonLayout.setWidth("6%");
		rightButtonLayout.setHeight100();
		rightButtonLayout.addMember(submitButto);
		rightButtonLayout.addMember(breakLabel);
		rightButtonLayout.addMember(breakLabel);
		rightButtonLayout.addMember(breakLabel);
		rightButtonLayout.addMember(breakLabel);
		rightButtonLayout.addMember(saveRemarkBtn);
		rightButtonLayout.addMember(uploadButton);

		HLayout mainPanel = new HLayout(10);
		mainPanel.setWidth100();
		mainPanel.setHeight100();

		if (flowStatus == 0) {
			mainPanel.addMember(leftSectionStack);
			mainPanel.addMember(leftButtonLayout);
			mainPanel.addMember(rightSectionStack);
			mainPanel.addMember(rightButtonLayout);
		} else {
			mainPanel.addMember(leftSectionStack);
			mainPanel.addMember(rightSectionStack);
		}
		addMember(mainPanel);
		//加载业务部门的数据集
		onLoadPlateRecords();
		onLoadSubContractRemark(contractId);
	}

	
	public static void onLoadSubContractRemark(int contractId){
		// 先将数据保存数据库
		Map<String, Object> params = new HashMap<>();
		params.put("contractId", contractId);
		params.put("opt_type", "onLoadSubContractRemark");
		DBDataSource.callOperation("EP_CustomSubContractHandler", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				SC.debugger();
				if (dsResponse.getStatus() >= 0&&dsResponse.getData().length>0) {
					Record r = dsResponse.getData()[0];
					__infoForm.getItem("subContractRemark").setValue(BaseHelpUtils.getString(r.getAttribute("subContractRemarks")));
					__infoForm.getItem("attachment").setValue(BaseHelpUtils.getString(r.getAttribute("attachment")));
					__infoForm.getItem("attachmentId").setValue(BaseHelpUtils.getString(r.getAttribute("attachmentId")));
					__infoForm.getItem("attachmentName").setValue(BaseHelpUtils.getString(r.getAttribute("attachmentName")));
				} else {
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
	
//	public void addChildManageContract(int contractId){
//		// 先将数据保存数据库
//		Map<String, Object> params = new HashMap<>();
//		params.put("contractId", contractId);
//		params.put("opt_type", "addProjectManageSubContract");
//		DBDataSource.callOperation("EP_CustomSubContractHandler", params, new DSCallback() {
//			@SuppressWarnings("static-access")
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if (dsResponse.getStatus() > 0) {
//					childManageContract.SourceGrid.setData(dsResponse.getData());
//					childManageContract.SourceGrid.selectAllRecords();
//				} else {
//					ClientUtil.displayErrorMessage(dsResponse);
//				}
//			}
//		});
//	}
	
	//加载业务部门的数据集
	private void onLoadPlateRecords(){
		Map<String, Object> params = new HashMap<>();
		DBDataSource.callOperation("ST_PlateRecord","find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						for(Record r : records){
							//获取业务部门Id和父级部门Id
							int plateId = BaseHelpUtils.getIntValue(r.getAttribute("plateId"));
							int parentId = BaseHelpUtils.getIntValue(r.getAttribute("parentId"));
							plateMap.put(plateId,parentId);
						}
					}
				} else {
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
	
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}
	
}