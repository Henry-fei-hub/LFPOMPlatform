package com.pomplatform.client.sreimbursementpackagemmror.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.reimbursementpackage.datasource.DSNewReimbursementPackage;
import com.pomplatform.client.sreimbursementpackagedetailrror.datasource.DSSreimbursementpackagedetailrror;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

public class ViewAllReimbursementPanel extends AbstractWizadPage implements HasHandlers {

	private static final Logger __LOGGER = Logger.getLogger("");

	private Integer packageId;

	public final static String BORDER_STYLE = "1px solid #ABABAB";
	public final static String BACKGROUND_COLOR = "azure";
	public final static String BUTTON_BACKGROUND_COLOR = "azure";
	public final static String FORM_BORDER_STYLE = "1px solid #808080";


	private final ListGrid sourceGrid = new ListGrid();
	
	
	public ViewAllReimbursementPanel() {
		setBorder(BORDER_STYLE);
		int idx = 0;
		ListGridField[] fields = new ListGridField[4];
		fields[idx] = new ListGridField("processType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("code");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("employeeId");
		fields[idx].setShowGridSummary(false);
//		idx++;
//		fields[idx] = new ListGridField("departmentId");
//		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("companyId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("inputTax", "进项税");
		fields[idx].setAlign(Alignment.RIGHT);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("approveName", "审批人");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("financeName", "复核");
		fields[idx].setShowGridSummary(false);
		sourceGrid.setFields(fields);
		sourceGrid.setShowRowNumbers(true);
		sourceGrid.setCanSelectText(true);
		sourceGrid.setCanDragSelectText(true);
		sourceGrid.setSaveLocally(true);
		sourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		sourceGrid.setDataSource(DSNewReimbursementPackage.getInstance());
		sourceGrid.setShowGridSummary(true);
		sourceGrid.setHeaderHeight(60);
		sourceGrid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("报销单信息", new String[] { "processType", "code", "employeeId", /*"departmentId", */
					 "companyId", "amount", "inputTax", "approveName", "financeName"}) });
		sourceGrid.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (!sourceGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
				ListGridRecord selected = sourceGrid.getSelectedRecord();
				Map params = selected.toMap();
				params.put("opt_type", "getSystemInstanceData");
				DBDataSource.callOperation("EP_CollectionDistribution", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() > 0){
							Record __record = dsResponse.getData()[0];
							ViewProcessWindow Reimbursement = new ViewProcessWindow();
			                Reimbursement.setWidth("80%");
			                Reimbursement.setHeight("80%");
			                Reimbursement.setLayoutMode(0);
			                Reimbursement.setInstanceData(__record);
			                Reimbursement.initComponents();
			                Reimbursement.setTitle(ClientUtil.getProcessTypeName(__record));
			                Reimbursement.show();
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
						
					}
				});
				
			}
		});
		//画框框 布局。。。
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.addMember(sourceGrid);
		addMember(mainLayout);
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		return false;
	}

	@Override
	public void startEdit() {
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getReimbursementsByPacakgeId");
		params.put("packageId", getPackageId());
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", "getReimbursementsByPacakgeId", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() > 0){
					sourceGrid.setData(dsResponse.getData());
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}

	public DSSreimbursementpackagedetailrror getDataSource() {
		return DSSreimbursementpackagedetailrror.getInstance();
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
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
	
}
