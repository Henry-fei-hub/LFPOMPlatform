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
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.DSSreimbursementpackagemmror;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class UpdateReimbursementpackagePanel extends AbstractWizadPage implements HasHandlers{
	
	private final ViewAllReimbursementPanel viewAllReimbursementPanel;
	
	private final UpdateReimbursementpackageDetailsPanel reimbursementpackageDetailsPanel;//
	
	private final UpdateReimbursementpackageSummaryPanel reimbursementpackageSummaryPanel;//
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
    public DelicacyListGrid contractGrid;
    
	private static final Logger __LOGGER = Logger.getLogger("");
	
	private int __packageId;
	
	private static DetailViewer view;
	
	public int getPackageId() {
		return __packageId;
	}

	public void setPackageId(int __packageId) {
		this.__packageId = __packageId;
	}

	public UpdateReimbursementpackagePanel(final int packageId, boolean topUpdate, boolean bottomUpdate, boolean isCompleted, Integer companyId){
//		setBorder(BORDER_STYLE);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout mainLayout = new VLayout();
		
		HLayout allH =new HLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		
		//左边显示查看的数据
		view = new DetailViewer();
		view.setCanSelectText(true);
		view.setDataSource(DSSreimbursementpackagemmror.getInstance());
		
		VLayout leftLayout = new VLayout();//左边的表单
		leftLayout.setWidth("25%");
		leftLayout.setHeight100();
		leftLayout.addMember(view);
		
		VLayout rightLayout = new VLayout();//右边详情与汇总的面板
		rightLayout.setWidth("75%");
		rightLayout.setHeight100();
		
		viewAllReimbursementPanel = new ViewAllReimbursementPanel();
		viewAllReimbursementPanel.setPackageId(packageId);
		rightLayout.addMember(viewAllReimbursementPanel);
		viewAllReimbursementPanel.setHeight("33%");
		viewAllReimbursementPanel.startEdit();
		
		reimbursementpackageDetailsPanel = new UpdateReimbursementpackageDetailsPanel(topUpdate);
		reimbursementpackageDetailsPanel.setMainView(view);
		reimbursementpackageDetailsPanel.setPackageId(packageId);
		reimbursementpackageDetailsPanel.setHeight("33%");
		rightLayout.addMember(reimbursementpackageDetailsPanel);
		reimbursementpackageDetailsPanel.startEdit();
		reimbursementpackageDetailsPanel.addDataEditedHandler(new DataEditedHandler() {
			
			@Override
			public void onDataEdited(DataEditEvent event) {
				reimbursementpackageDetailsPanel.startEdit();
				reimbursementpackageSummaryPanel.startEdit();
				startEdit();
			}
		});
		
		
		reimbursementpackageSummaryPanel= new UpdateReimbursementpackageSummaryPanel(bottomUpdate, isCompleted, companyId);
		reimbursementpackageSummaryPanel.setPackageId(packageId);
		reimbursementpackageSummaryPanel.setHeight("34%");
		rightLayout.addMember(reimbursementpackageSummaryPanel);
		reimbursementpackageSummaryPanel.startEdit();
		reimbursementpackageSummaryPanel.addDataEditedHandler(new DataEditedHandler() {
			
			@Override
			public void onDataEdited(DataEditEvent event) {
				getFatherWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
                fireEvent(dee);
			}
		});
		
		allH.addMember(leftLayout);
		allH.addMember(rightLayout);
		mainLayout.addMember(allH);
		addMember(mainLayout);
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getPackageDetailById");
		params.put("packageId", getPackageId());
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", "getPackageDetailById", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() > 0){
					view.setData(dsResponse.getData());
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
	
	private Window fatherWindow;

	public Window getFatherWindow() {
		return fatherWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.fatherWindow = fatherWindow;
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
