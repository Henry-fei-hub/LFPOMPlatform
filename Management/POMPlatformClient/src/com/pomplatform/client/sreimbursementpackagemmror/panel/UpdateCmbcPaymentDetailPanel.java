package com.pomplatform.client.sreimbursementpackagemmror.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.DSMreimbursementpackagesummarycrtppor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class UpdateCmbcPaymentDetailPanel extends AbstractWizadPage implements HasHandlers{
	
	private final TextItem payeeNameItem;
	
	private final TextItem selfBankNameItem;
	
	private final TextItem amountItem;
	
	private final TextItem selfBankAccountItem;
	
	private final TextItem otherBankNameItem;
	
	private final TextItem otherBankAccountItem;
	
	private final TextItem otherNameItem;
	
	private final ComboBoxItem crtpvcItem;
	
	private final ComboBoxItem crtctyItem;
	
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
	private static final Logger __LOGGER = Logger.getLogger("");

	public UpdateCmbcPaymentDetailPanel(){
//		setBorder(BORDER_STYLE);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout mainLayout = new VLayout();
		
		HLayout allH =new HLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		
		VLayout leftLayout = new VLayout();//左边的表单
		leftLayout.setWidth("25%");
		leftLayout.setHeight100();
		
		payeeNameItem = new TextItem("payeeName");
		payeeNameItem.setRequired(true);
		payeeNameItem.setDisabled(true);
		payeeNameItem.setWidth("*");
		__formItems.add(payeeNameItem);
		
		selfBankNameItem = new TextItem("selfBankName");
		selfBankNameItem.setRequired(true);
		selfBankNameItem.setDisabled(true);
		selfBankNameItem.setWidth("*");
		__formItems.add(selfBankNameItem);
		
		selfBankAccountItem = new TextItem("selfBankAccount");
		selfBankAccountItem.setRequired(true);
		selfBankAccountItem.disable();
		selfBankAccountItem.setWidth("*");
		__formItems.add(selfBankAccountItem);
		
		otherNameItem = new TextItem("otherName");
		otherNameItem.setRequired(true);
		otherNameItem.disable();
		otherNameItem.setWidth("*");
		__formItems.add(otherNameItem);
		
		otherBankNameItem = new TextItem("otherBankName");
		otherBankNameItem.setRequired(true);
		otherBankNameItem.disable();
		otherBankNameItem.setWidth("*");
		__formItems.add(otherBankNameItem);
		
		otherBankAccountItem = new TextItem("otherBankAccount");
		otherBankAccountItem.setRequired(true);
		otherBankAccountItem.disable();
		otherBankAccountItem.setWidth("*");
		__formItems.add(otherBankAccountItem);
		
		amountItem = new TextItem("amount");
		amountItem.setRequired(true);
		amountItem.disable();
		amountItem.setWidth("*");
		__formItems.add(amountItem);
		
		crtpvcItem = new ComboBoxItem("crtpvc", "省份");
		crtpvcItem.setValueMap(KeyValueManager.getValueMap("provinces"));
		crtpvcItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		crtpvcItem.setChangeOnKeypress(false);
		crtpvcItem.setRequired(true);
		crtpvcItem.setWidth("*");
		__formItems.add(crtpvcItem);
		crtpvcItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				crtctyItem.clearValue();
				if(null != event.getValue()){
					Object value = event.getValue();
					Map<String, Object> condition = new HashMap<>();
				    condition.put("parentId", value);
				    DBDataSource.callOperation("ST_Area", "find", condition, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								LinkedHashMap<String, Object> params = new LinkedHashMap<>();
								Record [] records = dsResponse.getData();
								for (int i = 0; i < records.length; i++) {
									params.put(records[i].getAttribute("areaId"), records[i].getAttribute("areaName"));
								}
								crtctyItem.setValueMap(params);
							}
							
						}
					});
				}else{
					crtctyItem.setValueMap(new LinkedHashMap<>());
				}
				
			}
		});
		
		crtctyItem = new ComboBoxItem("crtcty", "城市");
		crtctyItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		crtctyItem.setChangeOnKeypress(false);
		crtctyItem.setRequired(true);
		crtctyItem.setWidth("*");
		crtctyItem.setValueMap(KeyValueManager.getValueMap("areas"));
		__formItems.add(crtctyItem);
		
		
		__form.setItems(getFormItemArray());
		__form.setNumCols(2);
		__form.setDataSource(DSMreimbursementpackagesummarycrtppor.getInstance());
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setHeight100();
		__form.setWidth100();
		__form.setBorder(FORM_BORDER_STYLE);
		
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		
		String title = "修改并重新发起支付";
		IButton saveBtn = new IButton(title);
		saveBtn.setWidth(160);
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
							
				if(checkData()){
					SC.ask("提示", "确定[" + title + "]?", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								Map<String, Object> params = __form.getValues();
								
								params.put("opt_type", "updatePaydataRepayDefeatDraw");
								DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() >= 0) {
											getFatherWindow().destroy();
											DataEditEvent dee = new DataEditEvent();
											dee.setData(dsResponse.getData()[0]);
				                            fireEvent(dee);
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
										
									}
								});
							}
						}
					});
				}
				
			}
		});
		
		IButton cancelBtn = new IButton("取消");
		cancelBtn.setIcon("[SKIN]/actions/close.png");
		btnLayout.addMember(cancelBtn);
		btnLayout.addSpacer(10);
		cancelBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
					getFatherWindow().destroy();
			}
		});
		
		leftLayout.addMember(__form);
		allH.addMember(leftLayout);
		mainLayout.addMember(allH);
		mainLayout.addMember(btnLayout);
		addMember(mainLayout);
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		if( __form.validate()){
			return true;
		} else{
			SC.say("请按照系统提示将信息补充完整！");
			return false;
		}
		
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

	@Override
	public void startEdit() {
		if(null != getRecord()){
			__form.editRecord(getRecord());
			loadInitData(getRecord().toMap());
		}
	}
	
	public void loadInitData(Map params){
		params.put("opt_type", "getPaymentProvinceAndCity");
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() > 0){
					Record record = dsResponse.getData()[0];
					if(null != record.getAttribute("province")){
						crtpvcItem.setValue(record.getAttribute("province"));
					}
					if(null != record.getAttribute("city")){
						crtctyItem.setValue(record.getAttribute("city"));
					}
				}
				
			}
		});
		
	}
    
}
