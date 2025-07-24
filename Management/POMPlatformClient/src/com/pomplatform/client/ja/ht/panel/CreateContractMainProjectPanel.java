package com.pomplatform.client.ja.ht.panel;

import java.util.HashMap;
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
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.ja.ht.datasource.DSMainProject;
import com.pomplatform.client.ja.ht.form.MainProjectSearchForm;
import com.pomplatform.client.ja.ht.form.MainProjectViewer;
import com.pomplatform.client.newcontract.form.NewNewContractForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
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

public class CreateContractMainProjectPanel extends AbstractSearchPanel
{

	private static Logger __LOGGER = Logger.getLogger("");
	private static String isBeforeAfter;
	
	private static ListGridField[] fields = new ListGridField[4];
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			CreateContractMainProjectPanel cm = new CreateContractMainProjectPanel();
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
		fields[idx] = new ListGridField("hasOutQuotations");
		idx++;
		fields[idx] = new ListGridField("hasSplitPrice");
		idx++;
		fields[idx] = new ListGridField("hasFormalContracts");
		
		resultGrid.setFields(fields);
		//标题从新写
        resultGrid.setHeaderHeight(60);  
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("立项信息", new String[] {"infoCode","projectCode","projectName","businessType","projectBaseOn"}),
		   new HeaderSpan("进度栏", new String[] {"hasOutQuotations","hasSplitPrice","hasFormalContracts"}),
	    });
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		IButton operation4Button = PermissionControl.createPermissionButton("创建合同", ERPPermissionStatic.FINALLTY_INFO_MANAGEMENT_CREATE_BUTTON);
		controlLayout.addMember(operation4Button);
		operation4Button.setIcon("[SKIN]/actions/add.png");
		//创建合同....
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
							SC.say("请选择一条数据创建合同");
							return;
						}
						final ListGridRecord[] selected = resultGrid.getSelectedRecords();
						//立项依据
//						int projectBaseOn=selected[0].getAttributeAsInt("projectBaseOn");
						//投标立项的项目 可以直接创建正式合同
//						if(projectBaseOn==1){//投标立项的
//							SC.say("投标立项,可以直接创建正式合同,还未开放");
//						}else{//其他的要需要有拆分价，才能创建内部合同，之后可以转成正式合同
							boolean hasOutQuotations=selected[0].getAttributeAsBoolean("hasOutQuotations");
							boolean hasSplitPrice=selected[0].getAttributeAsBoolean("hasSplitPrice");
							boolean hasFormalContracts=selected[0].getAttributeAsBoolean("hasFormalContracts");
							//获取parentId,当parentId>0时,表示是补充协议
							int parentId = BaseHelpUtils.getIntValue(selected[0].getAttribute("parentId"));
							hasFormalContracts = false;
							if(hasFormalContracts){
								SC.say("已经创建合同");
								return;
							}
							hasOutQuotations = true;
							hasSplitPrice = true;
							if(hasOutQuotations){
								if(hasSplitPrice){
									Map m1=new HashMap<>();
									m1.put("infoCode", selected[0].getAttribute("infoCode"));
									m1.put("parentId", parentId);
									m1.put("opt_type", "selectSuccessQuotation");
									
									DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", m1, new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											Record result = dsResponse.getData()[0];
											final double moneySum = BaseHelpUtils.get2Double(result.getAttribute("moneySum"));
											//获取合同编号(用的是项目编号字段来暂存合同编号)
											String contractCode = BaseHelpUtils.getString(result.getAttribute("projectCode"));
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
														map.put("projectTotalInvestment", moneySum);
														map.put("contractCode", contractCode);
														
														NewNewContractForm contractForm = new NewNewContractForm();
														contractForm.setTitle("创建合同");
														contractForm.addDataEditedHandler(new DataEditedHandler() {
										                	@Override
										                	public void onDataEdited(DataEditEvent event) {
										                		commonQuery();
										                	}
										                });
														
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
								}else{
									SC.say("没有拆分价");
								}
							}else{
								SC.say("没有报价单");
							}
//						}
					}
				});
			}
		});
		commonQuery();
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
		criteria.put("addtionalCondition", "order by main_project_id");
		criteria.put("is_before_after", isBeforeAfter);
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
//        main.addMember(mainCanvas);
        layout.addMember(resultLayout);
        
        IButton beforeButton=new IButton("前期信息");
        beforeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(null == isBeforeAfter || !"before".equals(isBeforeAfter)){
					currentPage = 1;
				}
				fields = new ListGridField[3];
				int idx = 0;
				fields[idx] = new ListGridField("infoCode");
				idx++;
				fields[idx] = new ListGridField("projectName");
				idx++;
				fields[idx] = new ListGridField("businessType");
				idx++;
				fields[idx] = new ListGridField("projectBaseOn");
				idx++;
				fields[idx] = new ListGridField("hasOutQuotations");
				
				resultGrid.setFields(fields);
				//标题从新写
		        resultGrid.setHeaderHeight(60);  
				resultGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("前期信息", new String[] {"infoCode","projectName","businessType","projectBaseOn","hasOutQuotations"}),
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
				fields = new ListGridField[4];
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
				fields[idx] = new ListGridField("hasOutQuotations");
				idx++;
				fields[idx] = new ListGridField("hasSplitPrice");
				idx++;
				fields[idx] = new ListGridField("hasFormalContracts");
				resultGrid.setFields(fields);
				//标题从新写
		        resultGrid.setHeaderHeight(60);  
				resultGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("立项信息", new String[] {"infoCode","projectCode","projectName","businessType","projectBaseOn"}),
				   new HeaderSpan("进度栏", new String[] {"hasOutQuotations","hasSplitPrice","hasFormalContracts"}),
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
//        boxLayout.setHeight("");
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

