package com.pomplatform.client.ja.ht.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PaginationPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.ja.ht.datasource.DSMainProject;
import com.pomplatform.client.ja.ht.form.MainProjectSearchForm;
import com.pomplatform.client.ja.ht.form.MainProjectViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class OrderMainProjectPanel extends AbstractSearchPanel
{

	private static Logger __LOGGER = Logger.getLogger("");
	//选中的项目是否有主合同 false 无 true 有
	private static boolean isZHT=false;
	
	private static String isBeforeAfter = "";
	
	private static ListGridField[] fields = new ListGridField[4];
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OrderMainProjectPanel cm = new OrderMainProjectPanel();
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
		resultGrid.setCanDragSelectText(true);
		int idx = 0;
		fields[idx] = new ListGridField("infoCode");
		idx++;
		fields[idx] = new ListGridField("projectCode");
		idx++;
		fields[idx] = new ListGridField("projectName");
		idx++;
		fields[idx] = new ListGridField("businessType");
		idx++;
		fields[idx] = new ListGridField("projectBaseOn");
		idx++;
		fields[idx] = new ListGridField("bidType");
		idx++;
		fields[idx] = new ListGridField("hasOutQuotations");
		resultGrid.setFields(fields);
		//标题从新写
        resultGrid.setHeaderHeight(60);  
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("立项信息", new String[] {"infoCode","projectCode","projectName","businessType","projectBaseOn","bidType","hasOutQuotations"}),
	    });
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
        
		IButton operation6Button = PermissionControl.createPermissionButton("报价单", ERPPermissionStatic.BJD_MANAGEMENT);
		controlLayout.addMember(operation6Button);
		operation6Button.setTitle("报价单");
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
						//先去判断是否有报价单，没有创建一个默认的
						ListGridRecord[] selected = resultGrid.getSelectedRecords();
						/*//获取立项依据  --------------- 去除投标订单不能立项的依据
						int projectBaseOn = BaseHelpUtils.getIntValue(selected[0].getAttribute("projectBaseOn"));
						if(projectBaseOn == 1 || projectBaseOn == 4){
							//获取投标结果类型，如果是未出结果或者落标，则不可进行此操作
							int bidType = BaseHelpUtils.getIntValue(selected[0].getAttribute("bidType"));
							if(bidType == 1){
								SC.say("提示","该投标项目未出结果，如需更新项目情况，请联系运营专员");
								return;
							}
							if(bidType == 3){
								SC.say("提示","该投标项目已落标，不能填写报价单");
								return;
							}
						}*/
		                final String infoCode = selected[0].getAttribute("infoCode");
		                if(BaseHelpUtils.isNullOrEmpty(infoCode)) {
		                	SC.say("提示","获取信息编号失败");
		                	return;
		                }
		                final String projectCode = selected[0].getAttribute("projectCode");
		                Map<String,Object> m=new HashMap<>();
		                if(BaseHelpUtils.isNullOrEmpty(projectCode)) {
		                	SC.say("提示","获取订单编号失败");
		                	return;
		                }
		                m.put("opt_type", "settingDefaultQuotation");
		                m.put("infoCode", infoCode);
		                m.put("projectCode", projectCode);
		                m.put("projectName", selected[0].getAttribute("projectName"));
		                m.put("employeeId", ClientUtil.getEmployeeId());
						DBDataSource.callOperation("CustomDesigneConsiderationHandler", "", m, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() >= 0) {
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
				                    pw.addCloseClickHandler(new CloseClickHandler() {
				                    	@Override
				                    	public void onCloseClick(CloseClickEvent event) {
				                    		commonQuery();
				                    	}
				                    });
								} else {
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
				});
			}
		});
		
		IButton operation7Button = PermissionControl.createPermissionButton("补充协议", ERPPermissionStatic.CREATE_AGREEMENT_BTN);
//		controlLayout.addMember(operation7Button);
		operation7Button.addClickHandler(new ClickHandler(){
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
						SC.ask("提示","您确定要增加补充协议？",new BooleanCallback() {
							@Override
							public void execute(Boolean value) {
								if(value){
									ListGridRecord[] selected = resultGrid.getSelectedRecords();
									//获取项目编号(只允许立项的信息创建补充协议)
									boolean hasOutQuotations = BaseHelpUtils.getBoolean(selected[0].getAttribute("hasOutQuotations"));
									boolean hasSplitPrice = BaseHelpUtils.getBoolean(selected[0].getAttribute("hasSplitPrice"));
									boolean hasFormalContracts = BaseHelpUtils.getBoolean(selected[0].getAttribute("hasFormalContracts"));
									int mainProjectId = BaseHelpUtils.getIntValue(selected[0].getAttribute("mainProjectId"));
									int parentId = BaseHelpUtils.getIntValue(selected[0].getAttribute("parentId"));
									if(!hasOutQuotations){
										SC.say("提示","没有报价单,不可进行补充协议操作");
										return;
									}
//									if(!hasSplitPrice){
//										SC.say("提示","没有拆分价,不可进行补充协议操作");
//										return;
//									}
									if(!hasFormalContracts){
										SC.say("提示","没有合同,不可进行补充协议操作");
										return;
									}
									if(parentId > 0){//说明是补充协议，不可再添加补充协议
										SC.say("提示","补充协议不可再次添加补充协议");
										return;
									}
									Map<String,Object> m=new HashMap<>();
									m.put("opt_type", "onCreateSupplementAgreement");
									m.put("mainProjectId", mainProjectId);
									DBDataSource.callOperation("CustomDesigneConsiderationHandler", "", m, new DSCallback() {
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
							}
						});
					}
				});
			}
		});
		
		
		commonQuery();
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

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("MainProject"); 
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
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by main_project_id desc");
//		criteria.put("is_before_after", isBeforeAfter);
		List<Map> keyvalues = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		if("before".equals(isBeforeAfter)){
			kv.put("key", "mp.project_code!=''");
			kv.put("value", "(mp.project_code IS NULL OR mp.project_code = '')");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		} else if ("after".equals(isBeforeAfter)){
			kv.put("key", "mp.project_code!=''");
			kv.put("value", "mp.project_code <> '' AND mp.project_code IS NOT NULL");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
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
        return 60;
    }
	@Override
    public Canvas getViewPanel() {
        init();
        searchForm = generateSearchForm();
        VLayout layout = new VLayout();
        layout.setWidth100();
        layout.setHeight100();
        layout.setBackgroundColor("#e2e2e2");

        if (searchForm != null) {
            ClientUtil.searchFormProcessAccordingToDevice(searchForm);
            if (getSearchFormHeight() > 0) {
                searchForm.setHeight(getSearchFormHeight());
            }
            HLayout searchLayout = new HLayout(5);
            searchLayout.setMargin(10);
            layout.addMember(searchLayout);

            searchForm.setWidth100();
            searchLayout.addMember(searchForm);

            VLayout buttonLayout = new VLayout(5);
            searchButton = new IButton("搜索");
            searchButton.setIcon("[SKIN]/actions/search.png");

            IButton resetButton = new IButton("重置");
            resetButton.setIcon("[SKIN]/actions/redo.png");

            buttonLayout.addMember(searchButton);
            buttonLayout.addMember(resetButton);

            searchLayout.addMember(buttonLayout);

            searchButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    currentPage = 1;
                    commonQuery();
                }
            });

            resetButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    searchForm.editNewRecord();
                }
            });
        }
        VLayout resultLayout = new VLayout();
        resultLayout.setWidth100();
        resultLayout.setHeight100();
        if (__needControl) {
            switch (__controlPosition) {
                case LayoutConstant.TOP:
                case LayoutConstant.BOTTOM:
                    toolBar = new ToolStrip();
                    toolBar.setHeight(40);
                    break;
                case LayoutConstant.RIGHT:
                case LayoutConstant.LEFT:
                    controlLayout = new VLayout();
                    controlLayout.setHeight100();
                    controlLayout.setWidth(120);
                    controlLayout.setLayoutTopMargin(30);
                    controlLayout.setLayoutLeftMargin(5);
                    controlLayout.setLayoutRightMargin(5);
                    controlLayout.setMembersMargin(10);
                    break;
            }
        }
        if (__needControl && __controlPosition == LayoutConstant.TOP) {
            resultLayout.addMember(toolBar);
        }
        HLayout main = new HLayout();
        main.setWidth100();
        main.setHeight100();
        resultLayout.addMember(main);
        if (__needControl && __controlPosition == LayoutConstant.LEFT) {
            main.addMember(controlLayout);
        }
        Canvas mainCanvas = null;
        if (__layoutMode == LayoutConstant.LEFTRIGHT) {
            mainCanvas = generateHDataCanvas();
        } else {
            mainCanvas = generateVDataCanvas();
        }
        main.addMember(mainCanvas);
        layout.addMember(resultLayout);
        
        IButton beforeButton=new IButton("前期信息");
        beforeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(null == isBeforeAfter || !"before".equals(isBeforeAfter)){
					currentPage = 1;
				}
				fields = new ListGridField[4];
				int idx = 0;
				fields[idx] = new ListGridField("infoCode");
				idx++;
				fields[idx] = new ListGridField("projectName");
				idx++;
				fields[idx] = new ListGridField("businessType");
				idx++;
				fields[idx] = new ListGridField("projectBaseOn");
				idx++;
				fields[idx] = new ListGridField("bidType");
				idx++;
				fields[idx] = new ListGridField("hasOutQuotations");
				
				resultGrid.setFields(fields);
				//标题从新写
		        resultGrid.setHeaderHeight(60);  
				resultGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("前期信息", new String[] {"infoCode","projectName","businessType","projectBaseOn","bidType","hasOutQuotations"}),
			    });
				
				
				
				isBeforeAfter = "before";
				commonQuery();
			}
		});
        IButton afterButton=new IButton("立项信息");
        afterButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(null == isBeforeAfter || !"after".equals(isBeforeAfter)){
					currentPage = 1;
				}
				fields = new ListGridField[5];
				int idx = 0;
				fields[idx] = new ListGridField("infoCode");
				idx++;
				fields[idx] = new ListGridField("projectCode");
				idx++;
				fields[idx] = new ListGridField("projectName");
				idx++;
				fields[idx] = new ListGridField("businessType");
				idx++;
				fields[idx] = new ListGridField("projectBaseOn");
				idx++;
				fields[idx] = new ListGridField("bidType");
				idx++;
				fields[idx] = new ListGridField("hasOutQuotations");
				idx++;
				fields[idx] = new ListGridField("hasFormalContracts");
				resultGrid.setFields(fields);
				//标题从新写
		        resultGrid.setHeaderHeight(60);  
				resultGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("立项信息", new String[] {"infoCode","projectCode","projectName","businessType","projectBaseOn","bidType"}),
				   new HeaderSpan("进度栏", new String[] {"hasOutQuotations","hasFormalContracts"}),
				});
				isBeforeAfter = "after";
				commonQuery();
			}
		});
        
        HLayout boxLayout=new HLayout(10);
        boxLayout.setWidth100();
        boxLayout.setLayoutLeftMargin(17);
        boxLayout.addMember(beforeButton);
        boxLayout.addMember(afterButton);
        
        VLayout centerLayout = new VLayout(5);
        centerLayout.addMember(boxLayout);
        boxLayout.setHeight("");
        centerLayout.addMember(mainCanvas);
        main.addMember(centerLayout);
        if (__needControl && __controlPosition == LayoutConstant.RIGHT) {
            main.addMember(controlLayout);
        }
        if (__needControl && __controlPosition == LayoutConstant.BOTTOM) {
            resultLayout.addMember(toolBar);
        }
        
        resultLayout.addMember(main);

        if (Browser.getIsDesktop() && showPagination()) {
            pager = new PaginationPanel();
            resultLayout.addMember(pager);

            pager.getGotoButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    TextItem item = pager.getGotoPage();
                    String strPageNo = item.getValueAsString();
                    if (strPageNo == null || strPageNo.equals("")) {
                        return;
                    }
                    currentPage = Integer.parseInt(strPageNo);
                    commonQuery();
                }
            });
            pager.getFirstButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    currentPage = 1;
                    commonQuery();
                }
            });
            pager.getPreviousButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (currentPage > 1) {
                        currentPage--;
                        commonQuery();
                    }
                }
            });
            pager.addKeyPressHandler(new KeyPressHandler() {

                @Override
                public void onKeyPress(KeyPressEvent event) {
                    if (event.getKeyName() != null) {
                        switch (event.getKeyName()) {
                            case "Arrow_Right":
                                if (currentPage < totalPages) {
                                    currentPage++;
                                    commonQuery();
                                }
                                break;
                            case "Arrow_Left":
                                if (currentPage > 1) {
                                    currentPage--;
                                    commonQuery();
                                }
                                break;
                        }
                    }
                }
            });
            pager.getNextButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (currentPage < totalPages) {
                        currentPage++;
                        commonQuery();
                    }
                }
            });
            pager.getLastButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (totalPages > 0) {
                        currentPage = totalPages;
                        commonQuery();
                    }
                }
            });
            pager.getRefreshButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    commonQuery();
                }
            });
        }
        initComponents();
        if (showControlPanel()) {
            setControlLayoutWidth();
        }
        return layout;
    }
}

