package com.pomplatform.client.employeeaccountrecordeeppccmmpebor.panel;

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
import com.pomplatform.client.capitaldsitributionemployee.panel.MemployeeaccountrecordespemmorPanel;
import com.pomplatform.client.employeeaccountrecordeeppccmmpebor.datasource.DSMemployeeaccountrecordeeppccmmpebor;
import com.pomplatform.client.employeeaccountrecordeeppccmmpebor.form.MemployeeaccountrecordeeppccmmpeborSearchForm;
import com.pomplatform.client.employeeaccountrecordeeppccmmpebor.form.MemployeeaccountrecordeeppccmmpeborViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class MemployeeaccountrecordeeppccmmpeborPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private Integer employeeId = null;
	
	private Integer plateId = null;
	
	private MemployeeaccountrecordespemmorPanel miPanel;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MemployeeaccountrecordeeppccmmpeborPanel cm = new MemployeeaccountrecordeeppccmmpeborPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Memployeeaccountrecordeeppccmmpebor";
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
		resultGrid.setDataSource(getDataSource());
		int index = 0;
		ListGridField [] fields = new ListGridField[8];
		fields[index] = new ListGridField("employeeName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("sheetCode");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("sheetName");
		fields[index].setMaxWidth(200);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("integral");
		index ++;
		fields[index] = new ListGridField("sheetAmount");
		index ++;
		fields[index] = new ListGridField("money");
		index ++;
		fields[index] = new ListGridField("percente");
		fields[index].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
            	if(null == value){
					return "0%";
				}
				return value.toString() + "%";
            }  
        });  
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("confirmIntegral");
		resultGrid.setShowGridSummary(true);
		resultGrid.setFields(fields);
		// resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
		// @Override
		// public void onDoubleClick(DoubleClickEvent event) {
		// showDetail();
		// }
		// });
		// IButton operation1Button = new IButton("查看详情");
		// controlLayout.addMember(operation1Button);
		// operation1Button.setIcon("[SKIN]/actions/view.png");
		// operation1Button.addClickHandler(new ClickHandler(){
		// @Override
		// public void onClick(ClickEvent event) {
		// showDetail();
		// }
		// });
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
				detail.setTitle("Memployeeaccountrecordeeppccmmpebor");
				detail.setWidth100();
				detail.setHeight100();
				MemployeeaccountrecordeeppccmmpeborViewer detailForm = new MemployeeaccountrecordeeppccmmpeborViewer();
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
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by employee_account_record_id");
		criteria.put("businessTypeId", 1);
		if(null == getEmployeeId()){
			return false;
		}
		criteria.put("employeeId", getEmployeeId());
		criteria.put("plateId", getPlateId());
		getMiPanel().setPlateId(getPlateId());
		getMiPanel().setEmployeeId(getEmployeeId());
		if(null != criteria.get("minRecordDate")){
			getMiPanel().setMinRecordDate((Date)criteria.get("minRecordDate"));
		}
		if(null != criteria.get("maxRecordDate")){
			getMiPanel().setMaxRecordDate((Date)criteria.get("maxRecordDate"));
		}
		return true;
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
                    resultGrid.setData(dsResponse.getData());
                    Record [] records = dsResponse.getData();
                    if(records.length > 0){
                    	BigDecimal con = BigDecimal.ZERO;
                    	for (Record record : records) {
                    		if(null != record.getAttribute("confirmIntegral")){
                    			con = con.add(new BigDecimal(record.getAttribute("confirmIntegral")));
                    		}
						}
                    	getMiPanel().setConfirmIntegral(con);
                    } else {
                    	getMiPanel().setEmployeeId(-9);
                    }
                    getMiPanel().commonQuery();
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
	public SearchForm generateSearchForm() {
		return new MemployeeaccountrecordeeppccmmpeborSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMemployeeaccountrecordeeppccmmpebor.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 50;
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

	public MemployeeaccountrecordespemmorPanel getMiPanel() {
		return miPanel;
	}

	public void setMiPanel(MemployeeaccountrecordespemmorPanel miPanel) {
		this.miPanel = miPanel;
	}
	
}
