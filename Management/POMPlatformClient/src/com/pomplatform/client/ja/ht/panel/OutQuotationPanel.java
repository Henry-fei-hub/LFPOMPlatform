package com.pomplatform.client.ja.ht.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.ja.ht.datasource.DSOutQuotation;
import com.pomplatform.client.soutdesignconsiderationoor.datasource.DSSoutdesignconsiderationoor;
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
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;

//public class OutQuotationPanel extends AbstractExpansionRelatedPage {
public class OutQuotationPanel extends AbstractSearchPanel {

	private static Logger __LOGGER = Logger.getLogger("");
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OutQuotationPanel cm = new OutQuotationPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OutQuotation";
		}

	}

	EditCompleteEvent editCompleteEvent;

	@Override
	public void initComponents() {

//		resultGrid.setCanEdit(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		ListGridField[] fields = new ListGridField[9];
		int idx = 0;
		fields[idx] = new ListGridField("outQuotationId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("infoCode");
		fields[idx].setDefaultValue(infoCode);
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(false);
		idx++;
		fields[idx] = new ListGridField("projectCode");
		fields[idx].setDefaultValue(projectCode);
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(false);
		idx++;
		fields[idx] = new ListGridField("quotationNumber");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("quotationName");
		idx++;
		fields[idx] = new ListGridField("moneySum");
		idx++;
		fields[idx] = new ListGridField("businessType");
		SelectItem selectBusinessTypeItem = new SelectItem();
		selectBusinessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		fields[idx].setEditorProperties(selectBusinessTypeItem);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("projectType");
		SelectItem selectProjectTypeItem = new SelectItem();
		selectProjectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		fields[idx].setEditorProperties(selectProjectTypeItem);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("quotationStatus");
		idx++;
		fields[idx] = new ListGridField("createTime");
		fields[idx].setCanEdit(false);
		idx++;

		resultGrid.setFields(fields);
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton newButton = PermissionControl.createPermissionButton("填写报价单",
				ERPPermissionStatic.BJD_ADD_BTN);
//		controlLayout.addMember(newButton);
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("outQuotationId", 0);
				paramMap.put("infoCode", infoCode);
				paramMap.put("allOrOne", true);
				DBDataSource.callOperation("EP_CustomQuotationStatus", paramMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							Record result = dsResponse.getData()[0];
							int status = BaseHelpUtils.getIntValue(result.getAttribute("quotationStatus"));
							if (status == 3) {
								SC.say("已有报价中报价单,不能填写报价单!");
							} else if (status == 1) {
								SC.say("已有成功报价单,不能填写报价单!");
							} else {
								Map<String, Object> paramMap = new HashMap<>();
								paramMap.put("infoCode", infoCode);
								paramMap.put("clone", false);
								DBDataSource.callOperation("EP_CustomQuotationNumber", paramMap, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() < 0) {
											ClientUtil.displayErrorMessage(dsResponse);
										} else {
											Record result = dsResponse.getData()[0];
											resultGrid.startEditingNew(result);
										}
									}
								});
							}

						}
					}
				});
			}
		});
		
		IButton submitButton = new IButton("提交报价单");
		controlLayout.addMember(submitButton);
		submitButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.debugger();
				if(!resultGrid.anySelected()){
					SC.say("请选择需要提交的报价单");
					return ;
				}
				if(resultGrid.getSelectedRecord().getAttributeAsInt("quotationStatus") != 3){
					SC.say("只有处于报价中的报价单才能进行提交");
					return ;
				}
				SC.debugger();
				Record record = resultGrid.getSelectedRecord();
				record.setAttribute("quotationStatus", 3);
				record.setAttribute("updateTime", new Date());
				int outQuotationId = BaseHelpUtils.getIntValue(record.getAttribute("outQuotationId"));
				
				Map params = new HashMap<>();
				params.put("outQuotationId", outQuotationId);
				params.put("projectCode", BaseHelpUtils.getString(record.getAttribute("projectCode")));
				
				DBDataSource.callOperation("EP_CheckQuotationStatus", "find", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
//							String newCreateQuotationName = BaseHelpUtils.getString(dsResponse.getData()[0].getAttribute("newCreateQuotationName"));
//							record.setAttribute("newCreateQuotationName", newCreateQuotationName);
							 //获取流程process_id
							String processId = "";
							Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
							if(!PomPlatformClientUtil.isNullOrEmpty(str)){
								String[] arr = str.split(",");
								for(String tempStr : arr){
									String[] tempArr = tempStr.split(":");
									//获取父级ID
									if(tempArr[0].replaceAll("\"", "").equals("Out_Quotation_Application")){
										processId = tempArr[1];
									}
								}
							}
							
			                NewProcessWindow panel = new NewProcessWindow();
							panel.setTitle("报价单审核申请");
							panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
							panel.setLayoutMode(0);
							panel.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									commonQuery();
								}
							});
							panel.setData(record);
							panel.initComponents();
							panel.setWidth100();
							panel.setHeight100();
							panel.centerInPage();
							panel.show();
						
						}
					}
				});
			}
		});
		
		IButton cloneButton = PermissionControl.createPermissionButton("报价单变更",
				ERPPermissionStatic.BJD_CLONE_BTN);
		controlLayout.addMember(cloneButton);
		cloneButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
//				paramMap.put("outQuotationId", outQuotationId);
				paramMap.put("infoCode", infoCode);
				paramMap.put("projectCode", projectCode);
				//只有存在成功的报价单时  才能进行报价单变更
				paramMap.put("employeeId", ClientUtil.getEmployeeId());
				paramMap.put("clone", true);
				DBDataSource.callOperation("EP_CustomQuotationNumber", paramMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							commonQuery();
						}
					}
				});
			
			}
		});


	 

		IButton Button3 = PermissionControl.createPermissionButton("填写拆分价",
				ERPPermissionStatic.CFJ_ADD_BTN);
//		controlLayout.addMember(Button3);
		Button3.setIcon("[SKIN]/actions/add.png");
		Button3.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				 ListGridRecord selected = resultGrid.getSelectedRecord();
				 int outQuotationId = selected.getAttributeAsInt("outQuotationId");
				 double moneySum = selected.getAttributeAsInt("moneySum");
				cf_outQuotationId = outQuotationId;
				cf_moneySum = moneySum;
				__LOGGER.info("拆分价 outQuotationId=" + outQuotationId);
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("outQuotationId", outQuotationId);
				paramMap.put("infoCode", infoCode);
				paramMap.put("allOrOne", false);
				DBDataSource.callOperation("EP_CustomQuotationStatus", paramMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							Record result = dsResponse.getData()[0];
							int status = BaseHelpUtils.getIntValue(result.getAttribute("quotationStatus"));
							__LOGGER.info("拆分价 status=" + status);
							// 拆分报价单
							if (status == 1) {
								PopupWindow pw = new PopupWindow("报价单拆分");
								CustomAddQuotationMainPanel panel = new CustomAddQuotationMainPanel(infoCode,
										projectCode);
								pw.addItem(panel);
								pw.setWidth100();
								pw.setHeight100();
								pw.centerInPage();
								pw.show();

							} else {
								SC.say("报价单状态为成功才能拆分");
							}

						}
					}
				});
			}
		});

		IButton removeButton = PermissionControl.createPermissionButton("删除",
				ERPPermissionStatic.BJD_DEL_BTN);
//		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
				}
				SC.ask("你确认要删除该报价单", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							 ListGridRecord selected = resultGrid.getSelectedRecord();
							int outQuotationId = selected.getAttributeAsInt("outQuotationId");
							__LOGGER.info("delete outQuotationId=" + outQuotationId);
							Map<String, Object> paramMap = new HashMap<String, Object>();
							paramMap.put("outQuotationId", outQuotationId);
							paramMap.put("infoCode", infoCode);
							paramMap.put("allOrOne", false);
							paramMap.put("flag", 1);//表示删除操作
							DBDataSource.callOperation("EP_CustomQuotationStatus", paramMap, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() < 0) {
										ClientUtil.displayErrorMessage(dsResponse);
									} else {
										Record result = dsResponse.getData()[0];
										int status = BaseHelpUtils.getIntValue(result.getAttribute("quotationStatus"));
										if (status == 3) {
											 ListGridRecord selected = resultGrid.getSelectedRecord();

											Map<String, Object> checkParamMap = selected.toMap();
											checkParamMap.put("outQuotationId", checkParamMap.get("outQuotationId"));
											checkParamMap.put("opt_type", checkParamMap.get("checkIsOutQuotation"));

											DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", checkParamMap,
													new DSCallback() {
														@Override
														public void execute(DSResponse dsResponse, Object data,
																DSRequest dsRequest) {
															if (dsResponse.getStatus() < 0) {
																ClientUtil.displayErrorMessage(dsResponse);
															} else {
																DBDataSource.callOperation("ST_OutQuotation", "delete",selected.toMap(), new DSCallback() {
																			@Override
																			public void execute(DSResponse dsResponse, Object data,
																					DSRequest dsRequest) {
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
														}
													});
										} else {
											SC.say("报价单只有在报价中可以删除");
											return;
										}
									}
								}
							});
						}
					}
				});
			}
		});
		
		commonQuery();
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSOutQuotation.getInstance();
	}

//	@Override
//	public DataSource getChildDataSource() {
//		return DSSoutdesignconsiderationoor.getInstance();
//	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by create_time desc");
		if(BaseHelpUtils.isNullOrEmpty(infoCode)||BaseHelpUtils.isNullOrEmpty(projectCode)){
			return false;
		}else{
			criteria.put("infoCode", infoCode);
			criteria.put("projectCode", projectCode);
			return true;
		}
	}

	int cf_outQuotationId = 0;
	double cf_moneySum = 0.0;
	private String infoCode;
	private String projectCode;

	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}

				Record result = resultGrid.getSelectedRecord();
				int outQuotationId = BaseHelpUtils.getIntValue(result.getAttribute("outQuotationId"));
				/**
				 * outTempletId 模板id
				 * outQuotationId 报价单id
				 * infoCode 信息编号
				 * projectCode 项目编号
				 * businessType 模板类型(业务类型)
				 */
				//报价单标题
				int businessType = 0;
				PopupWindow pw = new PopupWindow("报价单的子项");
				final CustomOutDesignConsideratioOnlyChecknPanel panel=new CustomOutDesignConsideratioOnlyChecknPanel(infoCode, projectCode,outQuotationId);
				panel.startEdit();
				panel.setPw(pw);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
						
					}
				});
				pw.addCloseClickHandler(new CloseClickHandler() {
					
					@Override
					public void onCloseClick(CloseClickEvent event) {
						DataEditEvent dee = new DataEditEvent();
						fireEvent(dee);
						commonQuery();
					}
				});
				pw.addItem(panel);
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();

			
			}
		});
	}
	
	
	
	
	
}
