package com.pomplatform.client.websitenews.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PaginationPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.websitenews.datasource.DSSProjectExperience;
import com.pomplatform.client.websitenews.form.ProjectExperienceSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
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
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class ProjectExperiencePanel extends AbstractSearchPanel
{
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ProjectExperiencePanel cm = new ProjectExperiencePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectExperiencePanel";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setCanEdit(true);
		ListGridField[] fields = new ListGridField[11];
		int idx = 0;
		fields[idx] = new ListGridField("JaidFunctionMaintenanceId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("nameZh");
		idx ++;
		fields[idx] = new ListGridField("projectAddressZh");
		idx ++;
		fields[idx] = new ListGridField("designTimeZh");
		idx ++;
		fields[idx] = new ListGridField("finishTimeZh");
		idx ++;
		fields[idx] = new ListGridField("projectArea");
		idx ++;
		fields[idx] = new ListGridField("mainThemeZh");
		idx ++;
		fields[idx] = new ListGridField("orderId");
		idx ++;
		fields[idx] = new ListGridField("publishTime");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("auditType");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("operateAddress");
		fields[idx].setCanEdit(false);
		fields[idx].setLinkText("修改");
		idx ++;
		resultGrid.setFields(fields);
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		IButton newButton = new IButton("新建");
		controlLayout.addMember(newButton);
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				resultGrid.startEditingNew();
			}
		});
		
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择您需删除的数据");
					return;
				}
				ListGridRecord selected = resultGrid.getSelectedRecord();
				//获取是否审核
				boolean isAudited = BaseHelpUtils.getBoolean(selected.getAttribute("isAudited"));
				//如果已经审核过，则不可进行删除
				if(isAudited){
					SC.say("该信息已审核，不可进行删除");
					return;
				}
				//获取主键Id
				int jaidFunctionMaintenanceId = BaseHelpUtils.getIntValue(selected.getAttribute("jaidFunctionMaintenanceId"));
				Map<String,Object> map = new HashMap<>();
				map.put("jaidFunctionMaintenanceId",jaidFunctionMaintenanceId);
				DBDataSource.callOperation("ST_JaidFunctionMaintenance", "delete", map, new DSCallback() {
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
		});
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				params.put("operateEmployeeId", ClientUtil.getEmployeeId());
				params.put("publishTime",new Date());
				params.put("operateTime",new Date());
				params.put("type",type);
				params.put("typeDetail", typeDetail);
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_JaidFunctionMaintenance", "saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
							DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
							resultGrid.redraw();
						}
					}
				});
			}
		});
		commonQuery();
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
        
        HLayout buttonLayout = new HLayout(10);
        buttonLayout.setWidth100();
        buttonLayout.setHeight("5%");
        IButton buttonOne = new IButton("购物中心");
        buttonOne.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setTypeDetail(1);
				commonQuery();
			}
		});
        IButton buttonTwo = new IButton("酒店会所");
        buttonTwo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setTypeDetail(2);
				commonQuery();
			}
		});
        IButton buttonThree = new IButton("总部办公");
        buttonThree.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setTypeDetail(3);
				commonQuery();
			}
		});
        IButton buttonFour = new IButton("公共建筑");
        buttonFour.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setTypeDetail(4);
				commonQuery();
			}
		});
        IButton buttonFive = new IButton("轨道交通");
        buttonFive.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setTypeDetail(5);
				commonQuery();
			}
		});
        IButton buttonSix = new IButton("医疗养老");
        buttonSix.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setTypeDetail(6);
				commonQuery();
			}
		});
        IButton buttonSeven = new IButton("建筑");
        buttonSeven.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setTypeDetail(7);
				commonQuery();
			}
		});
        IButton buttonEight = new IButton("机电");
        buttonEight.addClickHandler(new ClickHandler() {
        	@Override
        	public void onClick(ClickEvent event) {
        		setTypeDetail(8);
        		commonQuery();
        	}
        });
        IButton buttonNine = new IButton("住宅地产");
        buttonNine.addClickHandler(new ClickHandler() {
        	@Override
        	public void onClick(ClickEvent event) {
        		setTypeDetail(9);
        		commonQuery();
        	}
        });
        buttonLayout.addMember(buttonOne);
        buttonLayout.addMember(buttonTwo);
        buttonLayout.addMember(buttonThree);
        buttonLayout.addMember(buttonFour);
        buttonLayout.addMember(buttonFive);
        buttonLayout.addMember(buttonSix);
        buttonLayout.addMember(buttonSeven);
        buttonLayout.addMember(buttonEight);
        buttonLayout.addMember(buttonNine);
        layout.addMember(buttonLayout);
        
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
        resultGrid.setCanDragSelectText(true);
        main.addMember(mainCanvas);
        if (__needControl && __controlPosition == LayoutConstant.RIGHT) {
            main.addMember(controlLayout);
        }
        if (__needControl && __controlPosition == LayoutConstant.BOTTOM) {
            resultLayout.addMember(toolBar);
        }
        layout.addMember(resultLayout);
        
        if(__needViewPage){
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
        }

        initComponents();
        if (showControlPanel()) {
            setControlLayoutWidth();
        }
        return layout;
	}
	
	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				int jaidFunctionMaintenanceId = BaseHelpUtils.getIntValue(record.getAttribute("jaidFunctionMaintenanceId"));
				if(jaidFunctionMaintenanceId > 0 ){
					record.setAttribute("operateAddress",url+"&id="+jaidFunctionMaintenanceId);
				}
				boolean isAudited = BaseHelpUtils.getBoolean(record.getAttribute("isAudited"));
				if (!isAudited) {
					record.setAttribute("auditType", "未审核");
					return "color: red;";
				} else {
					record.setAttribute("auditType", "已审核");
					return super.getCellCSSText(record, rowNum, colNum);
				}
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		return resultGrid;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("type",type);
		criteria.put("typeDetail",typeDetail);
		criteria.put("addtionalCondition", "ORDER BY type,type_detail asc");
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ProjectExperienceSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSProjectExperience.getInstance();
	}

	private static int type = 1;
	private static int typeDetail = 1;
	private static String url = "http://119.23.124.241/?root=projectExperience";
	
	public static int getTypeDetail() {
		return typeDetail;
	}

	public static void setTypeDetail(int typeDetail) {
		ProjectExperiencePanel.typeDetail = typeDetail;
	}

}

