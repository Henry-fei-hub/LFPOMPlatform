package com.pomplatform.client.templet.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.ja.ht.panel.CustomOutDesignConsiderationPanel;
import com.pomplatform.client.templet.datasource.DSOutTemplet;
import com.pomplatform.client.templet.form.OutTempletSearchForm;
import com.pomplatform.client.templet.form.OutTempletViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.Map;
import java.util.logging.Logger;

public class OutTempletPanel extends AbstractSearchPanel
{

	private static Logger __LOGGER = Logger.getLogger("");
	
	public static PopupWindow popupWindow;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OutTempletPanel cm = new OutTempletPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OutTemplet";
		}

	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton templetButton = new IButton("应用模板");
		controlLayout.addMember(templetButton);
		templetButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				final int outTempletId=selected.getAttributeAsInt("outTempletId");
				final int businessType=selected.getAttributeAsInt("businessType");
				
				
				__LOGGER.info("infoCode="+infoCode+"  projectCode="+projectCode+"  outQuotationId="+outQuotationId+"  outTempletId="+outTempletId+"  businessType="+businessType);
				PopupWindow pw = new PopupWindow("报价单的子项");
				/**
				 * outTempletId 模板id
				 * outQuotationId 报价单id
				 * infoCode 信息编号
				 * infoCode 项目编号
				 * businessType 模板类型(业务类型)
				 */
//				CustomOutDesignConsiderationPanel panel=new CustomOutDesignConsiderationPanel(infoCode, projectCode, outQuotationId,0,outTempletId,businessType,1);
//				panel.startEdit();
//				pw.addItem(panel);
//                pw.setWidth100();
//                pw.setHeight100();
//                pw.centerInPage();
//                pw.show();
//                popupWindow.destroy();//销毁父弹出框
				
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
				detail.setTitle("模板表"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OutTempletViewer detailForm = new OutTempletViewer();
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
		criteria.put("businessType", criteria.get("businessType"));
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new OutTempletSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOutTemplet.getInstance();
	}
	@Override
    public int getSearchFormHeight() {
        return 60;
    }
	@Override
    public Canvas getViewPanel() {
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

        HLayout dataLayout = new HLayout();
        dataLayout.setHeight100();
        dataLayout.setWidth100();
        resultLayout.addMember(dataLayout);

        resultGrid = new DelicacyListGrid();
        resultGrid.setDataSource(getDataSource());
//        resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        resultGrid.selectRecord(0);
        dataLayout.addMember(resultGrid);
        if (showControlPanel()) {
            controlLayout = new VLayout();
            controlLayout.setHeight100();
            controlLayout.setLayoutTopMargin(30);
            controlLayout.setLayoutLeftMargin(5);
            controlLayout.setLayoutRightMargin(5);
            controlLayout.setMembersMargin(10);

            dataLayout.addMember(controlLayout);
        }

        layout.addMember(resultLayout);
    
        initComponents();
        if (showControlPanel()) {
            setControlLayoutWidth();
        }
        return layout;
    }

    public void setControlLayoutWidth() {
        setControlLayoutWidth(120);
    }

    public boolean showPagination() {
        return true;
    }

    public void setControlLayoutWidth(int w) {
        controlLayout.setWidth(w);
        Canvas[] mems = controlLayout.getMembers();
        if (mems != null && mems.length > 0) {
            for (Canvas c : mems) {
                c.setWidth(w - 10);
            }
        }
    }

    public void commonQuery() {
        Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        if (searchForm != null) {
            searchButton.setIcon("loading38.gif");
        }
        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (searchForm != null) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                if (dsResponse.getStatus() >= 0) {
                    resultGrid.setData(dsResponse.getData());
                    afterDataReceived(dsResponse.getData());
                    if (showPagination()) {
                        if (currentPage == 1) {
//                            totalPages = dsResponse.getAttributeAsInt("totalPages");
//                            pager.getTotalPages().setContents(String.valueOf(totalPages));
                        }
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                if (showPagination()) {
//                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
                }
            }
        });
    }
    private int outQuotationId=0;
	private String infoCode;
	private String projectCode;
	private int outTempletId;
	private int businessType;

	public int getOutTempletId() {
		return outTempletId;
	}

	public void setOutTempletId(int outTempletId) {
		this.outTempletId = outTempletId;
	}

	public int getBusinessType() {
		return businessType;
	}

	public void setBusinessType(int businessType) {
		this.businessType = businessType;
	}

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

	public int getOutQuotationId() {
		return outQuotationId;
	}

	public void setOutQuotationId(int outQuotationId) {
		this.outQuotationId = outQuotationId;
	}
}

