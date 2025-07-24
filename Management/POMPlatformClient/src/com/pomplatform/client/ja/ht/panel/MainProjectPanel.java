package com.pomplatform.client.ja.ht.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.*;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.ja.check.panel.CheckDesignConsiderationPanel;
import com.pomplatform.client.ja.check.panel.CheckOutAllDesignConsiderationPanel;
import com.pomplatform.client.ja.ht.datasource.DSMainProject;
import com.pomplatform.client.ja.ht.form.MainProjectSearchForm;
import com.pomplatform.client.ja.ht.form.MainProjectViewer;
import com.pomplatform.client.ja.ht.form.NewSformalcontractcccorForm;
import com.pomplatform.client.ja.ht.form.UpdateMainProjectForm;
import com.pomplatform.client.mainprojectinfo.panel.MmainprojectclientccmorPanel;
import com.pomplatform.client.newcontract.form.NewNewContractForm;
import com.pomplatform.client.preprojects.form.projectPreInfomationsViewer;
import com.pomplatform.client.preprojects.panel.UpdatePreProjectInformationForm;
import com.pomplatform.client.signatory.panel.MainProjectMajorEmployeePanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class MainProjectPanel extends AbstractSearchPanel
{

	private static Logger __LOGGER = Logger.getLogger("");
	//选中的项目是否有主合同 false 无 true 有
	private static boolean isZHT=false;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			MainProjectPanel cm = new MainProjectPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "MainProject";
		}

	}

	@Override
	public void initComponents() {
		//标题从新写
        resultGrid.setHeaderHeight(60);  
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("信息栏", new String[] {"infoCode","projectCode","projectName","businessType","projectBaseOn","bidType","outsource","customerName","designTeam","secretary","leader","chargePerson","manager"}),
		   new HeaderSpan("进度栏", new String[] {"projectApprovalTime", "hasOutQuotations","hasOutQuotationTime","hasSplitPrice","hasOrderRelease","hasOrderReleaseTime","hasFormalContracts","hasFormalContractTime","hasDeposit","hasRateOfPayment"})
	    });
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				// TODO Auto-generated method stub
				showDetail();
			}
		});
		
		IButton down = new IButton("导出");
		down.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
//                Criteria record = searchForm.getValuesAsCriteria();
//                Map param = record.getValues();
//                ClientUtil.departmentParameterProcess(param);
				Map<String,Object> param  = generateCriteria();
                DBDataSource.downloadFile("DW_MainProject", param);
            }
        });
		controlLayout.addMember(down);


		//报价单按钮
		IButton ibtn01= PermissionControl.createPermissionButton("查看报价单", ERPPermissionStatic.PROJECT_INFO_BJD_BUTTON);
//		controlLayout.addMember(ibtn01);
		ibtn01.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                boolean hasOutQuotations=selected[0].getAttributeAsBoolean("hasOutQuotations");
                
                if(hasOutQuotations){
            	    String infoCode = BaseHelpUtils.getString(selected[0].getAttribute("infoCode"));
                    String projectCode = BaseHelpUtils.getString(selected[0].getAttribute("projectCode"));
                    int outQuotationId = BaseHelpUtils.getIntValue(selected[0].getAttributeAsInt("outQuotationId"));
                	PopupWindow pw = new PopupWindow("查看报价单");
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
                }else{
                	SC.say("没有报价单");
                }
				
                
			}
		});
		
		
		
		
		//拆分价按钮
		IButton ibtn02=
				PermissionControl.createPermissionButton("查看拆分价", ERPPermissionStatic.PROJECT_INFO_CFJ_BUTTON);
//		controlLayout.addMember(ibtn02);
		ibtn02.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                boolean hasSplitPrice=selected[0].getAttributeAsBoolean("hasSplitPrice");
                if(hasSplitPrice){
                	String infoCode = BaseHelpUtils.getString(selected[0].getAttribute("infoCode"));
                    String projectCode = BaseHelpUtils.getString(selected[0].getAttribute("projectCode"));
                    int outQuotationId = BaseHelpUtils.getIntValue(selected[0].getAttributeAsInt("outQuotationId"));
                	PopupWindow pw = new PopupWindow("查看拆分价");
    				CheckDesignConsiderationPanel panel=new CheckDesignConsiderationPanel(infoCode,projectCode,outQuotationId);
    				panel.startEdit();
    				pw.addItem(panel);
    				pw.setWidth100();
                    pw.setHeight100();
                    pw.centerInPage();
                    pw.show();
                }else{
                	SC.say("没有拆分价");
                }
			}
		});
		//订单下达按钮
		IButton ibtn03=
				PermissionControl.createPermissionButton("查看订单下达", ERPPermissionStatic.PROJECT_INFO_DDXD_BUTTON);
		controlLayout.addMember(ibtn03);
		//正式合同按钮
		IButton ibtn04=
		PermissionControl.createPermissionButton("查看正式合同", ERPPermissionStatic.PROJECT_INFO_ZSHT_BUTTON);
		controlLayout.addMember(ibtn04);
		//定金信息按钮
		IButton ibtn05=
		PermissionControl.createPermissionButton("查看定金信息", ERPPermissionStatic.PROJECT_INFO_DJXX_BUTTON);
		controlLayout.addMember(ibtn05);		
		//回款率信息按钮
		IButton ibtn06=
		PermissionControl.createPermissionButton("查看回款率", ERPPermissionStatic.PROJECT_INFO_HKL_BUTTON);
		controlLayout.addMember(ibtn06);		
				
		IButton infoBL = PermissionControl.createPermissionButton("信息补录", ERPPermissionStatic.PROJECT_INFO_UPDATE_PROJECT_BUTTON);
		controlLayout.addMember(infoBL);
		infoBL.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据录入|修改"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateMainProjectForm detailForm = new UpdateMainProjectForm();
						detailForm.setTitle("信息录入|修改");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), selected1);
							}
						});
//						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());
					}
				});
			}
		});
		
		IButton operation8Button = PermissionControl.createPermissionButton("查看联系人", ERPPermissionStatic.PROJECT_INFO_VIEW_LINKMAN_BUTTON);
		controlLayout.addMember(operation8Button);
        operation8Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                String mainProjectId = selected[0].getAttribute("mainProjectId");
                PopupWindow pw = new PopupWindow("联系人");
                MmainprojectclientccmorPanel panel = new MmainprojectclientccmorPanel();
                panel.setMainProjectId(ClientUtil.checkAndGetIntValue(mainProjectId));
                pw.addItem(panel.getViewPanel());
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
                panel.commonQuery();
            }
        });
        
		IButton operation6Button = PermissionControl.createPermissionButton("报价单", ERPPermissionStatic.BJD_MANAGEMENT);
		//controlLayout.addMember(operation6Button);
		operation6Button.setTitle("报价单");
		operation6Button.setIcon("[SKIN]/actions/edit.png");
		operation6Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条报价单数据"); return;}
						ListGridRecord[] selected = resultGrid.getSelectedRecords();
		                String infoCode = selected[0].getAttribute("infoCode");
		                String projectCode = selected[0].getAttribute("projectCode");
		                if(!BaseHelpUtils.isNullOrEmpty(infoCode)){
		                	PopupWindow pw = new PopupWindow("报价单");
		                	OutQuotationPanel panel=new OutQuotationPanel();
		                    panel.setInfoCode(infoCode);
		                    panel.setProjectCode(projectCode);
		                    pw.addItem(panel.getViewPanel());
		                    pw.setWidth100();
		                    pw.setHeight100();
		                    pw.centerInPage();
		                    pw.show();
		                    panel.commonQuery();
		                }
					}
				});
			}
		});
		IButton operation4Button = PermissionControl.createPermissionButton("创建主订单", ERPPermissionStatic.PROJECT_INFO_ADD_CONTRACTS_BUTTON);
//		controlLayout.addMember(operation4Button);
		operation4Button.setIcon("[SKIN]/actions/add.png");
		//创建主订单.....
		operation4Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据创建主订单");
							return;
						}
						final ListGridRecord[] selected = resultGrid.getSelectedRecords();
						Map m=new HashMap<>();
						m.put("infoCode", selected[0].getAttribute("infoCode"));
						m.put("projectCode", selected[0].getAttribute("projectCode"));
						DBDataSource.callOperation("EP_HasDesignConsiderationHistory", m, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									ClientUtil.displayErrorMessage(dsResponse);
									return;
								}else{
									
									Map<String, Object> map = new HashMap<>();
									map.put("infoCode", selected[0].getAttribute("infoCode"));
									map.put("projectCode", selected[0].getAttribute("projectCode"));
									map.put("projectName", selected[0].getAttribute("projectName"));
									//我方签约公司名称
									map.put("signCompany", selected[0].getAttribute("signCompany"));
									map.put("totalMoney", selected[0].getAttribute("totalMoney"));
									map.put("coveredArea", selected[0].getAttribute("coveredArea"));
									map.put("designArea", selected[0].getAttribute("designArea"));
									//客户名称
									map.put("customerName", selected[0].getAttribute("customerName"));
									//客户地址
									map.put("customerAddress", selected[0].getAttribute("customerAddress"));
									//项目等级
									map.put("projectLevel", selected[0].getAttribute("projectLevel"));
									map.put("address", selected[0].getAttribute("address"));
									map.put("serviceSuggestBook", selected[0].getAttribute("serviceSuggestBook"));
									
									//业务类别
									map.put("businessType", selected[0].getAttribute("businessType"));
									//项目类别
									map.put("projectType", selected[0].getAttribute("projectType"));
									//建筑总面积
									map.put("totalBuildingAreas", selected[0].getAttribute("totalBuildingAreas"));
									//实际设计面积
									map.put("actualDesignAreas", selected[0].getAttribute("actualDesignAreas"));
									//总投资
									map.put("projectTotalInvestment", selected[0].getAttribute("projectTotalInvestment"));
									
									NewNewContractForm contractForm = new NewNewContractForm();
									contractForm.setTitle("创建主订单");
									contractForm.setMap(map);
									contractForm.initComponents();
									contractForm.startEdit();
									contractForm.setWidth100();
									contractForm.setHeight100();
									contractForm.centerInPage();
									contractForm.show();
								}
							}
						});
					}
				});
			}
		});
		
		IButton zsButton = PermissionControl.createPermissionButton("申请合同", ERPPermissionStatic.PROJECT_INFO_ADD_HC_BUTTON);
//		controlLayout.addMember(zsButton);
		zsButton.setIcon("[SKIN]/actions/add.png");
		//申请合同.....
		zsButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据");
							return;
						}
						final ListGridRecord[] selected = resultGrid.getSelectedRecords();
						if(!BaseHelpUtils.isNullOrEmpty(selected[0].getAttribute("hasContract"))){
							isZHT=BaseHelpUtils.getBoolean(selected[0].getAttribute("hasContract"));
						}
						String message = "{\"projectCode\":\"" + selected[0].getAttribute("projectCode") + "\"}";
						DBDataSource.callOperation("EP_CheckDesignConsideration", message, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									SC.say("该项目尚未拥有报价单，暂不能申请合同");
									return;
								}else{
									
									//判断是否有主合同，没有 创建正式合同的数据源，来源项目信息
									//有，创建正式合同的数据源，来源主合同信息
									//未做：根据权限判断谁能根据项目源直接创建正式合同;什么权限必须要有主合同才能创建正式合同
									//...
									
									__LOGGER.info("isZHT="+isZHT);
									if(isZHT){
										
									     SC.ask("申请正式合同", "是否要创建申请正式合同", new BooleanCallback() {
											
											@Override
											public void execute(Boolean value) {
												if(value){
													
													Map<String,Object> m=new HashMap<>();
													m.put("opt_type","createFormalContract");
													m.put("projectCode",selected[0].getAttribute("projectCode"));
													m.put("infoCode",selected[0].getAttribute("infoCode"));
													DBDataSource.callOperation("EP_CustomFormalContractHandler", m, new DSCallback() {
														@Override
														public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
															if (dsResponse.getStatus() < 0) {
																ClientUtil.displayErrorMessage(dsResponse);
																return;
															}else{
																SC.say("正式合同申请成功");
																commonQuery();
																
															}
														}
													});
												}
												
											}
										});
									}else{
										Map<String, Object> map = new HashMap<>();
										map.put("projectCode", selected[0].getAttribute("projectCode"));
										map.put("infoCode", selected[0].getAttribute("infoCode"));
										map.put("projectName", selected[0].getAttribute("projectName"));
										map.put("signCompany", selected[0].getAttribute("signCompany"));
										map.put("totalMoney", selected[0].getAttribute("totalMoney"));
										map.put("coveredArea", selected[0].getAttribute("coveredArea"));
										map.put("designArea", selected[0].getAttribute("designArea"));
										map.put("customerName", selected[0].getAttribute("customerName"));
										map.put("projectLevel", selected[0].getAttribute("projectLevel"));
										map.put("address", selected[0].getAttribute("address"));
										map.put("serviceSuggestBook", selected[0].getAttribute("serviceSuggestBook"));
										
										map.put("province", selected[0].getAttribute("province"));
										map.put("city", selected[0].getAttribute("infoCode"));
										map.put("detailAddress", selected[0].getAttribute("detailAddress"));
										map.put("equityedgeRemark", selected[0].getAttribute("equityedgeRemark"));
										//客户名称
										map.put("customerName", selected[0].getAttribute("customerName"));
										//客户地址
										map.put("customerAddress", selected[0].getAttribute("customerAddress"));
										//项目等级
										map.put("projectLevel", selected[0].getAttribute("projectLevel"));
										//业务类别
										map.put("businessType", selected[0].getAttribute("businessType"));
										//项目类别
										map.put("projectType", selected[0].getAttribute("projectType"));
										//建筑总面积
										map.put("totalBuildingAreas", selected[0].getAttribute("totalBuildingAreas"));
										//实际设计面积
										map.put("actualDesignAreas", selected[0].getAttribute("actualDesignAreas"));
										//总投资
										map.put("projectTotalInvestment", selected[0].getAttribute("projectTotalInvestment"));
										
										NewSformalcontractcccorForm contractForm = new NewSformalcontractcccorForm();
										contractForm.setTitle("申请合同");
										contractForm.setMap(map);
										contractForm.initComponents();
										contractForm.startEdit();
										contractForm.setWidth100();
										contractForm.setHeight100();
										contractForm.centerInPage();
										contractForm.show();
									}
								}
							}
						});
					}
				});
			}
		});
		
		//投标订单立项
		IButton bidButton = PermissionControl.createPermissionButton("投标订单立项", ERPPermissionStatic.PROJECT_INFO_BID_BUTTON);
		controlLayout.addMember(bidButton);
		//隐藏投标订单立项
		bidButton.hide();
		bidButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据");
							return;
						}
						Record record = resultGrid.getSelectedRecord();
						//获取投标结果类型，如果是中标或者落标，则不可进行此操作
						int bidType = BaseHelpUtils.getIntValue(record.getAttribute("bidType"));
						int projectBaseOn = BaseHelpUtils.getIntValue(record.getAttribute("projectBaseOn"));
						if(bidType > 1){
							SC.say("提示","该项目已做中标/落标处理,不可进行此操作");
							return;
						}
						if(projectBaseOn == 2 || projectBaseOn == 3){
							SC.say("提示","该项目不可进行投标订单立项");
							return;
						}
						//获取信息编号
						String infoCode = BaseHelpUtils.getString(record.getAttribute("infoCode"));
						int mainProjectId = BaseHelpUtils.getIntValue(record.getAttribute("mainProjectId"));
						Map<String,Object> param = new HashMap<>();
						param.put("infoCode",infoCode);
						//加载项目编码
						DBDataSource.callOperation("ST_Contract", "find",param, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									ClientUtil.displayErrorMessage(dsResponse);
								} else {
									if(dsResponse.getData().length<1){
										SC.say("提示","该项目没有合同,不可进行当前操作");
										return;
									}
									
									Record record = dsResponse.getData()[0];
									//获取合同编号和名称
									String contractCode = record.getAttribute("contractCode");
									String contractName = record.getAttribute("contractName");
									int contractId = BaseHelpUtils.getIntValue(record.getAttribute("contractId"));
									
									param.put("contractId",contractId);
									param.put("mainProjectId",mainProjectId);
									DBDataSource.callOperation("NQ_Msystemprocessinstanceppcmor", "find",param, new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() < 0) {
												ClientUtil.displayErrorMessage(dsResponse);
											} else {
												Record[] records = dsResponse.getData();
												if(records.length>0) {
													Record r = records[0];
													int processStatus = BaseHelpUtils.getIntValue(r.getAttribute("processStatus"));
													if(processStatus!=5) {
														SC.say("提示","该订单正在进行或已完成落标流程");
														return;
													}
												}
												String projectName = "(投标)"+contractName;
												record.setAttribute("contractId", contractId);
												record.setAttribute("contractCode", contractCode);
												record.setAttribute("contractName", contractName);
												record.setAttribute("projectCode",contractCode);
												record.setAttribute("projectName", projectName);
												record.setAttribute("projectIntegral", 0);
												record.setAttribute("projectFlag", 4);
												BidSheetProjectForm detailForm = new BidSheetProjectForm();
												detailForm.setTitle("投标订单立项");
												detailForm.setSearchForm(searchForm);
												detailForm.setRecord(record);
												detailForm.initComponents();
												detailForm.startEdit();
												detailForm.setWidth100();
												detailForm.setHeight100();
												detailForm.centerInPage();
												detailForm.show();
										}}
									});
								}
							}
						});
						
					}
				});
			}
		});
		
		//中标
		IButton bidGetButton = PermissionControl.createPermissionButton("中标", ERPPermissionStatic.PROJECT_INFO_BID_GET_BUTTON);
		controlLayout.addMember(bidGetButton);
		bidGetButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据");
							return;
						}
						Record record = resultGrid.getSelectedRecord();
						//获取投标结果类型，如果是中标或者落标，则不可进行此操作
						int bidType = BaseHelpUtils.getIntValue(record.getAttribute("bidType"));
						if(bidType > 1){
							SC.say("提示","该项目已做中标/落标处理,不可进行此操作");
							return;
						}
						//获取立项类型，非投标项目，则不可进行此操作
						int projectBaseOn = BaseHelpUtils.getIntValue(record.getAttribute("projectBaseOn"));
						if(projectBaseOn == 2 ||projectBaseOn == 3 ){
							SC.say("提示","该项目非投标项目，不可进行此操作");
							return;
						}
						
						String infoCode = BaseHelpUtils.getString(record.getAttribute("infoCode"));
						int mainProjectId = BaseHelpUtils.getIntValue(record.getAttribute("mainProjectId"));
						Map<String,Object> param = new HashMap<>();
						param.put("infoCode", infoCode);
						DBDataSource.callOperation("ST_Contract", "find",param, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									ClientUtil.displayErrorMessage(dsResponse);
								} else {
									if(dsResponse.getData().length<1){
										SC.say("提示","该项目没有合同,不可进行当前操作");
										return;
									}
									Record record = dsResponse.getData()[0];
									param.put("contractId",record.getAttribute("contractId"));
									param.put("mainProjectId",mainProjectId);
									DBDataSource.callOperation("NQ_Msystemprocessinstanceppcmor", "find", param, new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() < 0) {
												ClientUtil.displayErrorMessage(dsResponse);
											} else {

												SC.ask("确定要中标?", new BooleanCallback() {
													@Override
													public void execute(Boolean value) {
														if(value){
															Record[] records = dsResponse.getData();
															if(records.length>0) {
																Record r = records[0];
																int processStatus = BaseHelpUtils.getIntValue(r.getAttribute("processStatus"));
																if(processStatus!=5) {
																	SC.say("提示","该订单正在进行或已完成落标流程");
																	return;
																}
															}
															param.put("optType", "winBid");
//															param.put("mainProjectId",mainProjectId);
															param.put("operator", ClientUtil.getUserId());
															DBDataSource.callOperation("EP_OnProjectCommonProcess", "find", param, new DSCallback() {
																@Override
																public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
																	if (dsResponse.getStatus() < 0) {
																		ClientUtil.displayErrorMessage(dsResponse);
																	} else {
																		SC.say("提示","操作成功");
																		commonQuery();
																	}
																}
															});
														}
													}
												});
											}
										}
									});
							}}
						});
					}
				});
			}
		});
		
		//落标
		IButton bidPayButton = PermissionControl.createPermissionButton("落标", ERPPermissionStatic.PROJECT_INFO_BID_PAY_BUTTON);
		controlLayout.addMember(bidPayButton);
		bidPayButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据");
							return;
						}
						Record record = resultGrid.getSelectedRecord();
						//获取投标结果类型，如果是中标或者落标，则不可进行此操作
						int bidType = BaseHelpUtils.getIntValue(record.getAttribute("bidType"));
						if(bidType > 1){
							SC.say("提示","该项目已做中标/落标处理,不可进行此操作");
							return;
						}
						
						//获取立项类型，非投标项目，则不可进行此操作
						int projectBaseOn = BaseHelpUtils.getIntValue(record.getAttribute("projectBaseOn"));
						if(projectBaseOn == 2 ||projectBaseOn == 3 ){
							SC.say("提示","该项目非投标项目，不可进行此操作");
							return;
						}
						
						//获取信息编号
						String infoCode = BaseHelpUtils.getString(record.getAttribute("infoCode"));
						int mainProjectId = BaseHelpUtils.getIntValue(record.getAttribute("mainProjectId"));
						String projectName = BaseHelpUtils.getString(record.getAttribute("projectName"));
						String projectCode = BaseHelpUtils.getString(record.getAttribute("projectCode"));
						Map<String,Object> param = new HashMap<>();
						param.put("infoCode",infoCode);
						//加载项目编码
						DBDataSource.callOperation("ST_Contract", "find",param, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									ClientUtil.displayErrorMessage(dsResponse);
								} else {
									if(dsResponse.getData().length<1){
										SC.say("提示","该项目没有合同,不可进行当前操作");
										return;
									}
									Record value = new Record();
									Record record = dsResponse.getData()[0];
									//获取合同编号和名称
									String contractCode = record.getAttribute("contractCode");
									String contractName = record.getAttribute("contractName");
									String infoCode = record.getAttribute("infoCode");
									BigDecimal signingMoneySum = BaseHelpUtils.getBigDecimalValue(record.getAttribute("signingMoneySum"));
									int contractId = BaseHelpUtils.getIntValue(record.getAttribute("contractId"));
									param.put("contractId", contractId);
									DBDataSource.callOperation("NQ_Mcontractpmcior", "find",param, new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() < 0) {
												ClientUtil.displayErrorMessage(dsResponse);
											} else {
												Record[] records = dsResponse.getData();

												Record r = records[0];
												param.put("contractId", contractId);
												param.put("mainProjectId", mainProjectId);
												DBDataSource.callOperation("NQ_Msystemprocessinstanceppcmor",
														"find", param, new DSCallback() {
															@Override
															public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
																if (dsResponse.getStatus() < 0) {
																	ClientUtil.displayErrorMessage(dsResponse);
																} else {
																	SC.ask("确定要落标?", new BooleanCallback() {
																		@Override
																		public void execute(Boolean value) {
																			if(value){
																				Record[] records = dsResponse.getData();
																				if (records.length > 0) {
																					Record r = records[0];
																					int processStatus = BaseHelpUtils.getIntValue(r.getAttribute("processStatus"));
																					if (processStatus != 5) {
																						SC.say("提示", "该订单正在进行或已完成落标流程");
																						return;
																					}
																				}
																				//去掉落标流程 直接修改状态
																				Map<String, Object> params = new HashMap<>();
																				params.put("infoCode", infoCode);
																				params.put("projectCode", projectCode);
																				params.put("optType", "updatePreProject");
																				DBDataSource.callOperation("EP_MainProjectProcessor", params, new DSCallback() {
																					@Override
																					public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
																						if (dsResponse.getStatus() >= 0) {
																							SC.say("落标成功");
																						} else {
																							SC.say(dsResponse.getErrors().get("errorMsg").toString());
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
										}
									});
								}
							}
						});
						
					}
				});
			}
		});
		
		
		/*		bidPayButton.addClickHandler(new ClickHandler(){
		@Override
		public void onClick(ClickEvent event) {
			GWT.runAsync(new RunAsyncCallback() {
				@Override
				public void onFailure(Throwable reason) {
					SC.say("failure to download");
				}
				@Override
				public void onSuccess() {
					if (!resultGrid.anySelected()) {
						SC.say("请选择一条数据");
						return;
					}
					SC.debugger();
					Record record = resultGrid.getSelectedRecord();
					//获取投标结果类型，如果是中标或者落标，则不可进行此操作
					int bidType = BaseHelpUtils.getIntValue(record.getAttribute("bidType"));
					if(bidType > 1){
						SC.say("提示","该项目已做中标/落标处理,不可进行此操作");
						return;
					}
					//获取信息编号
					String infoCode = BaseHelpUtils.getString(record.getAttribute("infoCode"));
					int mainProjectId = BaseHelpUtils.getIntValue(record.getAttribute("mainProjectId"));
					Map<String,Object> param = new HashMap<>();
					param.put("infoCode",infoCode);
					//加载项目编码
					DBDataSource.callOperation("ST_Contract", "find",param, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								ClientUtil.displayErrorMessage(dsResponse);
							} else {
								if(dsResponse.getData().length<1){
									SC.say("提示","该项目没有合同,不可进行当前操作");
									return;
								}
								Record value = new Record();
								Record record = dsResponse.getData()[0];
								//获取合同编号和名称
								String contractCode = record.getAttribute("contractCode");
								String contractName = record.getAttribute("contractName");
								BigDecimal signingMoneySum = BaseHelpUtils.getBigDecimalValue(record.getAttribute("signingMoneySum"));
								int contractId = BaseHelpUtils.getIntValue(record.getAttribute("contractId"));
								param.put("contractId", contractId);
								param.put("projectType", 66);
								DBDataSource.callOperation("ST_Project", "find",param, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() < 0) {
											ClientUtil.displayErrorMessage(dsResponse);
										} else {
											Record[] records = dsResponse.getData();
											if (records.length>0) {
												Record r = records[0];
												value.setAttribute("projectCode", r.getAttribute("contractCode"));
												value.setAttribute("projectName", r.getAttribute("projectName"));
												value.setAttribute("projectId", r.getAttribute("projectId"));
												value.setAttribute("contractId", contractId);
												value.setAttribute("contractCode", contractCode);
												value.setAttribute("contractName", contractName);
												value.setAttribute("signingMoneySum", signingMoneySum);
												value.setAttribute("bidType", 3);
												value.setAttribute("mainProjectId", mainProjectId);
												BidPaySheetProjectForm detailForm = new BidPaySheetProjectForm();
												detailForm.addDataEditedHandler(new DataEditedHandler() {
													@Override
													public void onDataEdited(DataEditEvent event) {
														commonQuery();
													}
												});
												detailForm.setTitle("落标");
												detailForm.setSearchForm(searchForm);
												detailForm.setRecord(value);
												detailForm.initComponents();
												detailForm.startEdit();
												detailForm.setWidth100();
												detailForm.setHeight100();
												detailForm.centerInPage();
												detailForm.show();
											}
										}}
								});
							}
						}
					});
					
				}
			});
		}
	});*/
		
		IButton signatoryButton = PermissionControl.createPermissionButton("指定签署人", ERPPermissionStatic.PROJECT_INFO_SIGNATORY_BUTTON);
		controlLayout.addMember(signatoryButton);
		signatoryButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				if(selected.length > 0) {
					if(selected.length > 1) {
						SC.say("请只选择一条数据");
					} else {
						ListGridRecord record = selected[0];
						String mainProjectName = record.getAttribute("projectName");
						MainProjectMajorEmployeePanel panel = new MainProjectMajorEmployeePanel();
						panel.setMainProjectId(record.getAttributeAsInt("mainProjectId"));
						panel.commonQuery();
						PopupWindow pw = new PopupWindow();
						pw.setTitle("【" + mainProjectName + "】签署人指定");
						pw.addItem(panel);
						pw.setHeight("80%");
						pw.setWidth("60%");
						pw.centerInPage();
						pw.show();
					}
				} else {
					SC.say("请选择一条数据");
				}
				
			}
		});
		
		IButton ChangeOfProjectSecretaryButton = PermissionControl.createPermissionButton("更换项目相关人员", ERPPermissionStatic.CHANGE_OF_PROJECT_SECRETARY_BUTTON);
		controlLayout.addMember(ChangeOfProjectSecretaryButton);
		ChangeOfProjectSecretaryButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
//				ChangeMainProjectEmployeePanel panel = new ChangeMainProjectEmployeePanel();
//				panel.commonQuery();
//				PopupWindow pw = new PopupWindow();
//				pw.setTitle("更换项目秘书");
//				pw.addItem(panel);
//				pw.setHeight("80%");
//				pw.setWidth("60%");
//				pw.centerInPage();
//				pw.show();
				ChangeMainProjectEmployeeForm detailForm = new ChangeMainProjectEmployeeForm();
//				detailForm.addDataEditedHandler(new DataEditedHandler() {
//					@Override
//					public void onDataEdited(DataEditEvent event) {
//						SC.say("提示","保存成功");
//					}
//				});
				detailForm.setTitle("更换项目相关人员");
				detailForm.initComponents();
				detailForm.startEdit();
				detailForm.setWidth100();
				detailForm.setHeight100();
				detailForm.centerInPage();
				detailForm.show();
				
			}
		});
		
		/*IButton operation3Button = new IButton("信息录入");
		controlLayout.addMember(operation3Button);
		operation3Button.setIcon("[SKIN]/actions/add.png");
		operation3Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						NewMainProjectForm detailForm = new NewMainProjectForm();
						detailForm.setTitle("信息录入");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								RecordList list = resultGrid.getDataAsRecordList();
								RecordList newList = new RecordList();
								newList.addList(list.getRange(0, list.getLength()));
								newList.add(event.getData());
								resultGrid.setData(newList);
								resultGrid.selectSingleRecord(newList.getLength()-1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});*/
		
		/*IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.setIcon("[SKIN]/actions/remove.png");
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				DBDataSource.callOperation("ST_MainProject", "delete", selected.toMap(), new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							int indexNum = resultGrid.getRowNum(selected);
							resultGrid.removeData(selected);
							resultGrid.selectSingleRecord(indexNum);
						}
					}
				});
			}
		});*/

		commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}

			public void onSuccess() {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("立项详情");
				detail.setWidth100();
				detail.setHeight100();
				MainProjectViewer detailForm = new MainProjectViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}
	
	@Override
	public void afterDataReceived(Record[] data) {
		if(data.length > 0){
			for(Record e : data){
				//获取立项依据
				int projectBaseOn = BaseHelpUtils.getIntValue(e.getAttribute("projectBaseOn"));
				if(projectBaseOn == 2 || projectBaseOn == 3){
					e.setAttribute("bidType","");
				}
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by info_register_time desc");
		SC.debugger();
		//如果没有查看全部的权限
		List<Map> keyvalues = new ArrayList<>();
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_INFO_MANAGEMENT_CHECK_ALL_DATA)&&!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_INFO_MANAGEMENT_CHECK_PLATE_DATA)){
			criteria.put("employeeId", ClientUtil.getEmployeeId());
			
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "OR P.apply_employee_id =? OR e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? )");
			kv.put("value", " and 1=? and 1=?");
			keyvalues.add(kv);
		}else if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_INFO_MANAGEMENT_CHECK_ALL_DATA)&&ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_INFO_MANAGEMENT_CHECK_PLATE_DATA)) {
		//如果没有查看部门的权限
			
			StringBuffer sb =new StringBuffer();
			String departmentIds = ClientUtil.getRoleDepartmentId();
			String departmentId = ClientUtil.getDepartmentId() + "";
			final String[] ids = departmentIds.split(",");
			if(BaseHelpUtils.isNullOrEmpty(departmentIds)){
				sb.append(departmentId);
			}else{
				sb.append(0);
				for (String str : ids) {
					sb.append(","+str);
				}
			}
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "OR P.apply_employee_id =? OR e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? )");
			kv.put("value", " and 1=? and 1 =?  and e.department_id IN("+sb.toString()+") ");
			keyvalues.add(kv);
		}
		
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues) && keyvalues.size() > 0){
			criteria.put("keyValues", keyvalues);
		}

		if(!BaseHelpUtils.isNullOrEmpty(criteria.get("leader"))){
				String leaderStr = KeyValueManager.getValue("employees",criteria.get("leader")+"");
				criteria.put("leader", leaderStr);
		}
		if(!BaseHelpUtils.isNullOrEmpty(criteria.get("secretary"))){
			String leaderStr = KeyValueManager.getValue("employees",criteria.get("secretary")+"");
			criteria.put("secretary", leaderStr);
		}
		if(!BaseHelpUtils.isNullOrEmpty(criteria.get("chargePerson"))){
			String leaderStr = KeyValueManager.getValue("employees",criteria.get("chargePerson")+"");
			criteria.put("chargePerson", leaderStr);
		}

		return true;
	}

	

	@Override
	public SearchForm generateSearchForm() {
		return new MainProjectSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMainProject.getInstance();
	}
	@Override
    public int getSearchFormHeight() {
        return 120;
    }
}

