package com.pomplatform.client.sinvoiceitiorcount.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.sinvoiceitiorcount.datasource.DSSinvoiceitiorcount;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class CustomSinvoiceitiorContractPanel extends AbstractWizadPage implements HasHandlers{
	
	
	public final ComboBoxItem contractIdItem;
	
	public final TextItem contractCodeItem;
	
	public final BooleanItem isFillInItem;//是否为手工填写
	
	public DelicacyListGrid resultGrid;
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
	
	public CustomSinvoiceitiorContractPanel(){
		setPadding(5);
//		setBorder(BORDER_STYLE);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout mainH =new VLayout();
		mainH.setWidth100();
		mainH.setHeight100();
		
		resultGrid = new DelicacyListGrid();
		
		int idx = 0;
		ListGridField [] fields = new ListGridField[16];
		fields[idx] = new ListGridField("ticketingCompany");
		fields[idx].setShowGridSummary(false);
		idx++ ;
		fields[idx] = new ListGridField("contractName");
		fields[idx].setShowGridSummary(false);
		idx++ ;
		fields[idx] = new ListGridField("contractCode");
		fields[idx].setShowGridSummary(false);
		idx++ ;
		fields[idx] = new ListGridField("invoiceType");
		fields[idx].setShowGridSummary(false);
		idx++ ;
		fields[idx] = new ListGridField("invoiceCode");
		fields[idx].setShowGridSummary(false);
		idx++ ;
		fields[idx] = new ListGridField("invoiceNumber");
		fields[idx].setShowGridSummary(false);
		idx++ ;
		fields[idx] = new ListGridField("customerId");
		KeyValueManager.loadValueMap("customers", fields[idx]);
		fields[idx].setShowGridSummary(false);
		idx++ ;
		fields[idx] = new ListGridField("invoiceAmount");
		idx++ ;
		fields[idx] = new ListGridField("taxRate");
		fields[idx].setShowGridSummary(false);
		idx++ ;
		fields[idx] = new ListGridField("noTaxAmount");
		idx++ ;
		fields[idx] = new ListGridField("outputTax");
		idx++ ;
		fields[idx] = new ListGridField("sign");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceDate");
		idx++ ;
		fields[idx] = new ListGridField("primaryInvoiceCode");
		fields[idx].setShowGridSummary(false);
		idx++ ;
		fields[idx] = new ListGridField("primaryInvoiceNumber");
		fields[idx].setShowGridSummary(false);
		resultGrid.setFields(fields);
		
		resultGrid.setDataSource(DSSinvoiceitiorcount.getInstance());
		resultGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		resultGrid.setCanEdit(false);
		resultGrid.setShowGridSummary(true);
		resultGrid.setCanRemoveRecords(true);
		
		contractIdItem = new ComboBoxItem("contractId", "选择合同");
		contractIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contractIdItem.setWidth("*");
		__formItems.add(contractIdItem);
		
		contractCodeItem = new TextItem("contractCode", "输入合同编号");
		contractCodeItem.setWidth("*");
		__formItems.add(contractCodeItem);
		
		isFillInItem = new BooleanItem("isFillIn", "以手工输入为准(是则以手工输入,否则为下拉选择)");
		isFillInItem.setWidth("*");
		__formItems.add(isFillInItem);
		
		__form.setItems(getFormItemArray());
		__form.setNumCols(6);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setHeight100();
		__form.setWidth100();
		__form.setBorder(FORM_BORDER_STYLE);
		
		// 底部工具栏添加
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		IButton saveBtn = new IButton("确认关联");
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord [] records = resultGrid.getRecords();
				if(records.length > 0){
					String ids = "";
					for (int i = 0; i < records.length; i++) {
						if(0 != i){
							ids += ",";
						}
						ids += records[i].getAttributeAsString("invoiceId");
					}
					Map<String, Object> params = new HashMap<>();
					params.put("opt_type", "invoicesConnectContract");
					params.put("isFillIn", isFillInItem.getValueAsBoolean());
					params.put("ids", ids);
					boolean flag = true;
					if(isFillInItem.getValueAsBoolean()){
						String contractCode = contractCodeItem.getValueAsString();
						if(BaseHelpUtils.isNullOrEmpty(contractCode)){
							SC.say("请填写合同编号");
							flag =false;
						}else{
							params.put("contractCode", contractCode);
						}
					}else{
						if(BaseHelpUtils.isNullOrEmpty(contractIdItem.getValue())){
							SC.say("请选择合同");
							flag =false;
						}else{
							Integer contractId = Integer.parseInt(contractIdItem.getValueAsString()) ;
							params.put("contractId", contractId);
						}
					}
					if(flag){
						DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() > 0){
									getFatherWindow().destroy();
									DataEditEvent dee = new DataEditEvent();
		                            fireEvent(dee);
								}else{
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
						
					}
				}else{
					SC.say("没有关联的发票数据,请关闭页面重新选择！");
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
		
		//设置下拉值
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getContractToInvoice");
		KeyValueManager.setValueMapFromQuery("EP_CustomSinvoiceitiorHandler", MapUtils.toJSON(params), contractIdItem);
		__form.setHeight(60);
		mainH.addMember(__form);
		mainH.addMember(resultGrid);
		mainH.addMember(btnLayout);
		addMember(mainH);
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
//		if(null == this.params){
//			this.params = new HashMap<>();
//		}
//		params.put("opt_type", "useInvoicesCount");
//		DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", getParams(), new DSCallback() {
//			
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if(dsResponse.getStatus()  > 0){
//					resultGrid.setData(dsResponse.getData());
//					msgLabel.setText(dsResponse.getErrors().get("errorMsg").toString());;
//				}
//				
//			}
//		});
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
