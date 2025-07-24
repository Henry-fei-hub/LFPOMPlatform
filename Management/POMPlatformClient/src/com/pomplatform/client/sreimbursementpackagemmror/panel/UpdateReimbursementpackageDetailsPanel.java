package com.pomplatform.client.sreimbursementpackagemmror.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.sreimbursementpackagedetailrror.datasource.DSSreimbursementpackagedetailrror;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class UpdateReimbursementpackageDetailsPanel extends AbstractWizadPage implements HasHandlers {

	private static final Logger __LOGGER = Logger.getLogger("");

	private Integer packageId;

	public final static String BORDER_STYLE = "1px solid #ABABAB";
	public final static String BACKGROUND_COLOR = "azure";
	public final static String BUTTON_BACKGROUND_COLOR = "azure";
	public final static String FORM_BORDER_STYLE = "1px solid #808080";


	private final ListGrid sourceGrid = new ListGrid();
	
	private DetailViewer mainView;
	
	public UpdateReimbursementpackageDetailsPanel(boolean isUpdate) {
		setBorder(BORDER_STYLE);
		int idx = 0;
		ListGridField[] fields = new ListGridField[4];
		fields[idx] = new ListGridField("processTypeId");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("code");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("drafter");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("payeeName");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("selfBankName");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("selfBankAccount");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("paymentAmount");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("strikeABalanceAmount");
		fields[idx].setCanEdit(isUpdate);
		fields[idx].setShowGridSummary(true);
		sourceGrid.setFields(fields);
		sourceGrid.setCanSelectText(true);
		sourceGrid.setShowRowNumbers(true);
		sourceGrid.setCanDragSelectText(true);
		sourceGrid.setSaveLocally(true);
		sourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		sourceGrid.setDataSource(DSSreimbursementpackagedetailrror.getInstance());
		sourceGrid.setCanEdit(isUpdate);
		sourceGrid.setShowGridSummary(true);
		sourceGrid.setHeaderHeight(60);
		sourceGrid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("明细信息", new String[] { "processTypeId", "code", "drafter", "payeeName", 
					"selfBankName", "selfBankAccount", "paymentAmount", "strikeABalanceAmount"}) });
		
		
		IButton updateBtn = PermissionControl.createPermissionButton("确认修改", ERPPermissionStatic.RP_UPDATE_BLANCE);
		updateBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.confirm("确认修改", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							Double allBlanceAmount = 0d;
							Double paymentAmount = 0d;
							ListGridRecord [] records = sourceGrid.getRecords();
							for (ListGridRecord listGridRecord : records) {
								if(null != listGridRecord.getAttributeAsDouble("strikeABalanceAmount")){
									allBlanceAmount += listGridRecord.getAttributeAsDouble("strikeABalanceAmount");
									paymentAmount += listGridRecord.getAttributeAsDouble("paymentAmount");
								}
							}
							Map<String, Object> params = new HashMap<>();
							params.put("opt_type", "updateBalanceAmount");
							params.put("records", records);
							params.put("packageId", getPackageId());
							DBDataSource.callOperation("EP_ReimbursementPackageProcessor", "updateBalanceAmount", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() > 0){
										DataEditEvent dee = new DataEditEvent();
			                            fireEvent(dee);
										SC.say("修改成功");
									}else{
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
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
		if(isUpdate){
			HLayout btnLayout = new HLayout();
			btnLayout.setPadding(5);
			btnLayout.setAlign(Alignment.RIGHT);
			btnLayout.setHeight("40");
			btnLayout.setWidth100();
			btnLayout.addMember(updateBtn);
			mainLayout.addMember(btnLayout);
		}
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
		params.put("opt_type", "getPackageDetailByPackageId");
		params.put("packageId", getPackageId());
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", "getPackageDetailByPackageId", params, new DSCallback() {
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
	
	public DetailViewer getMainView() {
		return mainView;
	}

	public void setMainView(DetailViewer mainView) {
		this.mainView = mainView;
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
