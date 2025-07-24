package com.pomplatform.client.capitaldsitributionemployee.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.capitaldsitributionemployee.datasource.DSMemployeeaccountrecordespemmor;
import com.pomplatform.client.capitaldsitributionemployee.form.MemployeeaccountrecordespemmorViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class MemployeeaccountrecordespemmorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private Integer employeeId = null;
	
	private Integer plateId = null;
	
	private Date minRecordDate = null;
	
	private Date maxRecordDate = null;
	
	private Object confirmIntegral; 

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MemployeeaccountrecordespemmorPanel cm = new MemployeeaccountrecordespemmorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Memployeeaccountrecordespemmor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
		ListGridField dicTypeValueField = new ListGridField("dicTypeValue");
		dicTypeValueField.setShowGridSummary(false);
		ListGridField integralField = new ListGridField("integral");
		resultGrid.setShowGridSummary(true);
		ListGridField confirmIntegralField = new ListGridField("confirmIntegral");
		resultGrid.setShowGridSummary(true);
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setFields(dicTypeValueField, integralField, confirmIntegralField);
		// IButton refreshButton = new IButton("刷新");
		// controlLayout.addMember(refreshButton);
		// refreshButton.setIcon("[SKIN]/actions/refresh.png");
		// refreshButton.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// commonQuery();
		// }
		// });
		//
		// resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
		// @Override
		// public void onDoubleClick(DoubleClickEvent event) {
		// showDetail();
		// }
		// });
		// IButton viewButton = new IButton("查看详细");
		// viewButton.addClickHandler(new ClickHandler(){
		// @Override
		// public void onClick(ClickEvent event) {
		// showDetail();
		// }
		// });
		// controlLayout.addMember(viewButton);
		// commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}

			@Override
			public void onSuccess() {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Memployeeaccountrecordespemmor");
				detail.setWidth100();
				detail.setHeight100();
				MemployeeaccountrecordespemmorViewer detailForm = new MemployeeaccountrecordespemmorViewer();
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
        final LoadingWindow loading = new LoadingWindow();
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	loading.destroy();
                if (searchForm != null) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                if (dsResponse.getStatus() >= 0) {
                	Record [] records = dsResponse.getData();
                	for (Record record : records) {
                		int type = record.getAttributeAsInt("businessTypeId");
                		if(type == 1){
                			record.setAttribute("confirmIntegral", getConfirmIntegral());
                		}else{
                			record.setAttribute("confirmIntegral", record.getAttribute("integral"));
                		}
						
					}
                    resultGrid.setData(records);
                    afterDataReceived(dsResponse.getData());
                    if (isNeedPagenation() && pager != null) {
                        if (currentPage == 1) {
                            totalPages = dsResponse.getAttributeAsInt("totalPages");
                            pager.getTotalPages().setContents(String.valueOf(totalPages));
                        }
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                if (showPagination() && pager != null) {
                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
                }
            }
        });
    }

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", getEmployeeId());
		criteria.put("plateId", getPlateId());
		criteria.put("minRecordDate", getMinRecordDate());
		criteria.put("maxRecordDate", getMaxRecordDate());
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		// return new MemployeeaccountrecordespemmorSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSMemployeeaccountrecordespemmor.getInstance();
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getPlateId() {
		return plateId;
	}

	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}

	public Date getMinRecordDate() {
		return minRecordDate;
	}

	public void setMinRecordDate(Date minRecordDate) {
		this.minRecordDate = minRecordDate;
	}

	public Date getMaxRecordDate() {
		return maxRecordDate;
	}

	public void setMaxRecordDate(Date maxRecordDate) {
		this.maxRecordDate = maxRecordDate;
	}

	public Object getConfirmIntegral() {
		return confirmIntegral;
	}

	public void setConfirmIntegral(Object confirmIntegral) {
		this.confirmIntegral = confirmIntegral;
	}

}
