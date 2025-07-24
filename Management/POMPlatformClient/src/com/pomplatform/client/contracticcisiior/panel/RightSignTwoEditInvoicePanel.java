package com.pomplatform.client.contracticcisiior.panel;

import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.sinvoiceitior.datasource.DSSinvoiceitior;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class RightSignTwoEditInvoicePanel extends AbstractWizadPage implements HasHandlers{
	
	public DelicacyListGrid SourceGrid;
	
	
    public final static String BORDER_STYLE = "1px solid #ABABAB";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
	public RightSignTwoEditInvoicePanel(){
		setBorder(BORDER_STYLE);
		setPadding(5);
//		setBackgroundColor(BACKGROUND_COLOR);
		VLayout allH =new VLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		
		SourceGrid = new DelicacyListGrid();
		int idx = 0;
		ListGridField [] fields = new ListGridField[12];
		fields[idx] = new ListGridField("invoiceType");
		idx++ ;
		fields[idx] = new ListGridField("invoiceCode");
		idx++ ;
		fields[idx] = new ListGridField("invoiceNumber");
		idx++ ;
		fields[idx] = new ListGridField("ticketingCompany");
		idx++;
		fields[idx] = new ListGridField("customerId");
		fields[idx].setCanEdit(true);
		fields[idx].setRequired(true);
		KeyValueManager.loadValueMap("customers", fields[idx]);
		ComboBoxItem customerItem = new ComboBoxItem("customer");
		customerItem.setChangeOnKeypress(false);
		customerItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("customers", customerItem);
		fields[idx].setEditorProperties(customerItem);
		idx++;
		fields[idx] = new ListGridField("invoiceAmount");
		fields[idx].setRequired(true);
		fields[idx].setCanEdit(true);
		fields[idx].setValidators(ValidateUtils.isFloatValidator());
		fields[idx].addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					double thisVal = BaseHelpUtils.getDoubleValue(event.getValue());
					DynamicForm df = event.getForm();
					//先判断是否有填写开票金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("taxRate").getValue())){
						double taxRate = BaseHelpUtils.getDoubleValue(df.getField("taxRate").getValue()) ;
						double noTaxAmount = BaseHelpUtils.get2Double(thisVal / (1 + taxRate/100));
						double outputTax = BaseHelpUtils.get2Double(thisVal - noTaxAmount);
						df.getField("noTaxAmount").setValue(noTaxAmount);
						df.getField("outputTax").setValue(outputTax);
					}
				}
			}
		});
		idx++;
		fields[idx] = new ListGridField("taxRate");
		fields[idx].setRequired(true);
		fields[idx].setCanEdit(true);
		fields[idx].setValidators(ValidateUtils.isFloatValidator(), ValidateUtils.decimalRangeValidator(0.01f, 100f));
		fields[idx].addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					double thisVal = BaseHelpUtils.getDoubleValue(event.getValue());
					DynamicForm df = event.getForm();
					//先判断是否有填写开票金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("invoiceAmount").getValue())){
						double invoiceAmount = BaseHelpUtils.getDoubleValue(df.getField("invoiceAmount").getValue());
						double noTaxAmount = BaseHelpUtils.get2Double(invoiceAmount / (1 + thisVal/100));
						double outputTax = BaseHelpUtils.get2Double(invoiceAmount - noTaxAmount);
						df.getField("noTaxAmount").setValue(noTaxAmount);
						df.getField("outputTax").setValue(outputTax);
					}
				}
			}
		});
		idx++;
		fields[idx] = new ListGridField("noTaxAmount");
		fields[idx].setRequired(true);
		fields[idx].setCanEdit(true);
		fields[idx].setValidators(ValidateUtils.isFloatValidator());
		idx++;
		fields[idx] = new ListGridField("outputTax");
		fields[idx].setRequired(true);
		fields[idx].setCanEdit(true);
		fields[idx].setValidators(ValidateUtils.isFloatValidator());
		idx++;
		fields[idx] = new ListGridField("primaryInvoiceCode");
		fields[idx].setRequired(true);
		fields[idx].setCanEdit(true);
		fields[idx].setValidators(ValidateUtils.StringLenValidator(10, 10));
		idx++;
		fields[idx] = new ListGridField("primaryInvoiceNumber");
		fields[idx].setRequired(true);
		fields[idx].setCanEdit(true);
		fields[idx].setValidators(ValidateUtils.StringLenValidator(8, 8));
		idx++;
		fields[idx] = new ListGridField("invalidRemark");
		fields[idx].setCanEdit(true);
		SourceGrid.setDataSource(DSSinvoiceitior.getInstance());
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		
		
		Label title = new Label("待使用发票");
		title.setHeight(30);
		allH.addMember(title);
		allH.addMember(SourceGrid);
		
		addMember(allH);
		
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		boolean flag = true;
		ListGridRecord [] record = SourceGrid.getRecords();
		for (ListGridRecord listGridRecord : record) {
			int index =SourceGrid.getRowNum(listGridRecord);
			if(!SourceGrid.validateRow(index)){
				flag =false;
				break;
			}
		}
		return flag;
	}

	@Override
	public void startEdit() {
//		Map<String, Object> params = new HashMap<>();
//		params.put("ticketingCompany", "-1");
//		params.put("opt_type", "getInvoiceByCompany");
//		DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "getInvoiceByCompany", params, new DSCallback() {
//			
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				SourceGrid.setData(dsResponse.getData());
//			}
//		});
	}
	
}
