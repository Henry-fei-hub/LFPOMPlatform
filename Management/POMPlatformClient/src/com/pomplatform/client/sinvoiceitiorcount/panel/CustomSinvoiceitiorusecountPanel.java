package com.pomplatform.client.sinvoiceitiorcount.panel;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.Label;
import com.pomplatform.client.sinvoiceorusecount.datasource.DSSinvoiceorusecount;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.layout.VLayout;

public class CustomSinvoiceitiorusecountPanel extends AbstractWizadPage implements HasHandlers{
	
	private final Label msgLabel;
	
	private final SelectItem invoiceType;
	
	private DelicacyListGrid resultGrid;
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
	
	public CustomSinvoiceitiorusecountPanel(){
		setPadding(5);
//		setBorder(BORDER_STYLE);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout mainH =new VLayout();
		mainH.setWidth100();
		mainH.setHeight100();
		
		
		VLayout controlLayout = new VLayout();
		
		invoiceType = new SelectItem("发票类型");
		msgLabel = new Label();
		
		resultGrid = new DelicacyListGrid();
		resultGrid.setDataSource(DSSinvoiceorusecount.getInstance());
		resultGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		resultGrid.setCanEdit(false);
		resultGrid.setHeight("96%");
		mainH.addMember(msgLabel);
		mainH.addMember(resultGrid);
		addMember(mainH);
		addMember(controlLayout);
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if(null == this.params){
			this.params = new HashMap<>();
		}
		params.put("opt_type", "useInvoicesCount");
		DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", getParams(), new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus()  > 0){
					resultGrid.setData(dsResponse.getData());
					msgLabel.setText(dsResponse.getErrors().get("errorMsg").toString());;
				}
				
			}
		});
	}
	
	private Map params;
	
	private Window fatherWindow;
	
	public Map getParams() {
		return params;
	}

	public void setParams(Map params) {
		this.params = params;
	}

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
