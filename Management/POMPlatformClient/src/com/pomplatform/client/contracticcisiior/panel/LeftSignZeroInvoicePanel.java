package com.pomplatform.client.contracticcisiior.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.sinvoiceitior.datasource.DSSinvoiceitior;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * 
 * @ClassName: LeftSignZeroInvoicePanel 
 * @Description:  未使用的发票面板
 * @author CL
 * @date 2016年11月7日 
 *
 */
public class LeftSignZeroInvoicePanel extends AbstractWizadPage implements HasHandlers{
	
	public DelicacyListGrid SourceGrid;
	
	private final ComboBoxItem ticketingCompanyItem;
	private final TextItem invoiceNumberItem;
	
    public final static String BORDER_STYLE = "1px solid #ABABAB";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
	
	public LeftSignZeroInvoicePanel(){
		setBorder(BORDER_STYLE);
		setPadding(5);
		setMargin(5);
//		setBackgroundColor(BACKGROUND_COLOR);
		VLayout allH =new VLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		
		ticketingCompanyItem = new ComboBoxItem("ticketingCompany", "购票公司");
		ticketingCompanyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_54"));
		ticketingCompanyItem.setWidth("*");
		ticketingCompanyItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				String __ticketingCompanyItem = ticketingCompanyItem.getValueAsString();
				int ticketingCompany = Integer.parseInt(BaseHelpUtils.isNullOrEmpty(__ticketingCompanyItem) ? "-1" : __ticketingCompanyItem);
				DynamicForm form = event.getForm();
				Map<String, Object> params = new HashMap<>();
				params.put("ticketingCompany", ticketingCompany);
				params.put("invoiceNumber", form.getValue("invoiceNumber"));
				params.put("opt_type", "getInvoiceByCompany");
				if(null != getInvoiceType()){
					params.put("invoiceType", getInvoiceType());
				}
				DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "getInvoiceByCompany", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						SourceGrid.setData(dsResponse.getData());
					}
				});
				
			}
		});
		
		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码");
		invoiceNumberItem.setLength(64);
		invoiceNumberItem.setWidth("*");
		invoiceNumberItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				String __invoiceNumberItem = invoiceNumberItem.getValueAsString();
				DynamicForm form = event.getForm();
				Map<String, Object> params = new HashMap<>();
				params.put("ticketingCompany", form.getValue("ticketingCompany"));
				params.put("invoiceNumber", __invoiceNumberItem);
				params.put("opt_type", "getInvoiceByCompany");
				if(null != getInvoiceType()){
					params.put("invoiceType", getInvoiceType());
				}
				DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "getInvoiceByCompany", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						SourceGrid.setData(dsResponse.getData());
					}
				});
				
			}
		});
		
		__formItems.add(ticketingCompanyItem);
		__formItems.add(invoiceNumberItem);
		__form.setItems(getFormItemArray());
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setHeight(60);
		__form.setWidth100();
		
		allH.addMember(__form);
		
		SourceGrid = new DelicacyListGrid();
		int idx = 0;
		ListGridField [] fields = new ListGridField[3];
		fields[idx] = new ListGridField("invoiceType");
		idx++ ;
		fields[idx] = new ListGridField("invoiceCode");
		idx++ ;
		fields[idx] = new ListGridField("invoiceNumber");
		idx++ ;
		fields[idx] = new ListGridField("ticketingCompany");
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		SourceGrid.setDataSource(DSSinvoiceitior.getInstance());
		allH.addMember(SourceGrid);
		
		addMember(allH);
		
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
		Map<String, Object> params = new HashMap<>();
		params.put("ticketingCompany", "-1");
		params.put("opt_type", "getInvoiceByCompany");
		if(null != getInvoiceType()){
			params.put("invoiceType", getInvoiceType());
		}
		DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "getInvoiceByCompany", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				SourceGrid.setData(dsResponse.getData());
			}
		});
	}
	
	private Integer invoiceType;

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}
	
}
