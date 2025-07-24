package com.pomplatform.client.contracticcisiior.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
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
import com.pomplatform.client.sinvoiceitior.datasource.DSSinvoiceitior;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

/**
 * 
 * @ClassName: UpdateContractInvoicePanel 
 * @Description:  修改填开发票面板
 * @author CL
 * @date 2016年11月10日 
 *
 */
public class UpdateContractInvoicePanel extends AbstractWizadPage implements HasHandlers{
	
	public DelicacyListGrid SourceGrid;
	
	
    public final static String BORDER_STYLE = "1px solid #ABABAB";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
	public UpdateContractInvoicePanel(){
		setBackgroundColor("azure");
		setBorder(BORDER_STYLE);
		setPadding(5);
//		setBackgroundColor(BACKGROUND_COLOR);
		HLayout allH =new HLayout();
		allH.setWidth100();
		allH.setHeight100();
		
		SourceGrid = new DelicacyListGrid();
		int idx = 0;
		ListGridField [] fields = new ListGridField[14];
		fields[idx] = new ListGridField("invoiceType");
		idx++ ;
		fields[idx] = new ListGridField("sign");
		idx++ ;
		fields[idx] = new ListGridField("invoiceCode");
		idx++ ;
		fields[idx] = new ListGridField("invoiceNumber");
		idx++ ;
		fields[idx] = new ListGridField("ticketingCompany");
		idx++;
		fields[idx] = new ListGridField("customerId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(true);
		fields[idx].setRequired(true);
		ComboBoxItem customerItem = new ComboBoxItem();
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
		fields[idx] = new ListGridField("invoiceDate");
		fields[idx].setRequired(true);
		fields[idx].setCanEdit(true);
		idx++;
		fields[idx] = new ListGridField("primaryInvoiceCode");
		idx++;
		fields[idx] = new ListGridField("primaryInvoiceNumber");
		idx++;
		fields[idx] = new ListGridField("invalidRemark");
		fields[idx].setCanEdit(true);
		SourceGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				if(SourceGrid.validateRow(event.getRowNum())){
					ListGridRecord record = SourceGrid.getRecord(event.getRowNum());
					Map params = record.toMap();
					params.put("opt_type", "updateOneInvoices");
					DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "updateOneInvoices", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0){ 
								ClientUtil.displayErrorMessage(dsResponse);
							}
						}
					});
				}else{
					SC.say("请按要求填写好合法的数据");
				}
			}
		});
		
		SourceGrid.setDataSource(DSSinvoiceitior.getInstance());
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		
		
		//右边操作栏添加
		VLayout rightLayout = new VLayout();
		rightLayout.setBorder(BORDER_STYLE);
		rightLayout.setPadding(10);
		rightLayout.setMembersMargin(10);
		rightLayout.setHeight100();
		
		IButton delButton = new IButton("删除");
		rightLayout.addMember(delButton);
		delButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!SourceGrid.anySelected()){
					SC.say("请选择一条要清除的数据！");
					return ;
				}
				
				SC.ask("确认清除该发票数据?点击确认后,该发票将还原为未使用发票！", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							ListGridRecord record = SourceGrid.getSelectedRecord();
							Map params = record.toMap();
							params.put("opt_type", "delEmptyInvoices");
							DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "updateOneInvoices", params, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										startEdit();
									} else {
										ClientUtil.displayErrorMessage(dsResponse);
									}
									
								}
							});
						}
					}
				});
				
			}
		});
		
		IButton saveBtn = new IButton("退出修改");
		rightLayout.addMember(saveBtn);
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getFatherWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
			}
		});
		
		
		// 底部工具栏添加
//		ToolStrip btnLayout = new ToolStrip();
//		btnLayout.setVPolicy(LayoutPolicy.FILL);
//		btnLayout.setPadding(5);
//		btnLayout.setHeight(40);
//		btnLayout.setWidth100();
//		btnLayout.addFill();
//		IButton saveBtn = new IButton("修改完成");
//		saveBtn.setIcon("[SKIN]/actions/save.png");
//		btnLayout.addMember(saveBtn);
//		btnLayout.addSpacer(10);
//		btnLayout.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				getFatherWindow().destroy();
//				DataEditEvent dee = new DataEditEvent();
//				fireEvent(dee);
//			}
//		});
		allH.addMember(SourceGrid);
		allH.addMember(rightLayout);
		addMember(allH);
//		addMember(btnLayout);
		
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
		if(null != getContractId()){
			Map<String, Object> params = new HashMap<>();
			params.put("contractId", getContractId());
			params.put("opt_type", "getInvoicesByContractId");
			DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "getInvoicesByContractId", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					SourceGrid.setData(dsResponse.getData());
				}
			});
		}else{
			SourceGrid.clear();
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
	
	private Integer contractId;//合同主键

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

}
