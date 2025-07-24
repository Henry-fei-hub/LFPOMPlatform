package com.pomplatform.client.budgetmanagement.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridReceiveUnitValue;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.sprocessbilllistpppor.datasource.DSSprocessbilllistpppor;
import com.pomplatform.client.workflow.panel.AddReceiveUnitPanel;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PaySeqReceiveInfo extends HLayout implements HasHandlers {

	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private VLayout  mainLayout;
	private RadioGroupItem payForItem;
	private  ComboBoxItem employeeOrCompanyIdItem;
	private  TextItem selfBankNameItem;
	private  TextItem selfBankAccountItem;
	private  TextItem payeeNameItem;
	private static final Logger _logger = Logger.getLogger("");
	private final DynamicForm form = new DynamicForm();
	private  VLayout vLayout;
	private IButton saveButton;
	private  IButton cancelButton;
	private IButton addUnitButton;
	private  HLayout buttonLayout;

	private  ComboBoxItem employeeSelectItem;
	private  ComboBoxItem companySelectItem;

	public void initComponents() {
		
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		
		ListGridField receiveUnitField = new ListGridField("receiveUnit");
		ListGridField bankAccountField = new ListGridField("bankAccount");
		ListGridField bankNameField = new ListGridField("bankName");
		
		
		mainLayout=new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);

		payForItem=new RadioGroupItem("payFor");
		payForItem.setWidth("*");
		payForItem.setAlign(Alignment.CENTER);
		payForItem.setVertical(false);
		payForItem.setShowTitle(false);  
		payForItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_67"));  
		payForItem.addChangedHandler(new ChangedHandler() {  

			@Override
			public void onChanged(ChangedEvent event) {
				int typeVal = BaseHelpUtils.getIntValue(event.getValue());
				employeeOrCompanyIdItem.clearValue();
				employeeSelectItem.clearValue();
				companySelectItem.clearValue();
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				if(typeVal == 1){//个人
					addUnitButton.hide();
					employeeSelectItem.show();
					companySelectItem.hide();
				}else{//公司
					addUnitButton.show();
					companySelectItem.show();
					employeeSelectItem.hide();
				}

			}  
		});  
       
		employeeSelectItem = new ComboBoxItem("employeeSelect", "收款方");
		employeeSelectItem.setChangeOnKeypress(false);
		employeeSelectItem.setRequired(true);
		employeeSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeSelectItem.setWidth("*");
		Criteria cd = new Criteria();
		cd.addCriteria("status", "0");
		employeeSelectItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		employeeSelectItem.setOptionCriteria(cd);
		employeeSelectItem.setValueField("employeeId");
		employeeSelectItem.setDisplayField("employeeName");
		employeeSelectItem.setPickListFields(employeeNoField, employeeNameField, departmentIdField);
		employeeSelectItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int __value = BaseHelpUtils.getIntValue(event.getValue());
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				employeeOrCompanyIdItem.setValue(__value);
				if(__value > 0){
					int __typeVal = BaseHelpUtils.getIntValue(payForItem.getValue());
					Map<String, Object> params = new HashMap<>();
					if(__typeVal == 1){
						params.put("opt_type", "getEmployeeBankInfoById");
						params.put("employeeId", __value);
					}else if(__typeVal == 2){//收款单位
						params.put("opt_type", "getReceiveUnitInfoById");
						params.put("receiveUnitManageId", __value);
					}
					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
								Record __record = dsResponse.getData()[0];
								if(__typeVal == 1){
									payeeNameItem.setValue(BaseHelpUtils.getString(event.getItem().getDisplayValue()));
									String bankId = BaseHelpUtils.getString(__record.getAttribute("bankId"));
									selfBankNameItem.setValue(KeyValueManager.getValueMap("system_dictionary_68").get(bankId));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}else if(__typeVal == 2){
									payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
									selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}
							}
						}
					});
				}
			}
		});
		
		companySelectItem= new ComboBoxItem("companySelect", "收款方");
		companySelectItem.setChangeOnKeypress(false);
		companySelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companySelectItem.setWidth("*");
		companySelectItem.hide();
		companySelectItem.setValueField("receiveUnitManageId");
		companySelectItem.setDisplayField("receiveUnit");
		companySelectItem.setPickListFields(receiveUnitField, bankNameField, bankAccountField);
		companySelectItem.setOptionDataSource(DSSelectGridReceiveUnitValue.getInstance());
		companySelectItem.setRequired(true);
		companySelectItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int __value = BaseHelpUtils.getIntValue(event.getValue());
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				employeeOrCompanyIdItem.setValue(__value);
				if(__value > 0){
					int __typeVal = BaseHelpUtils.getIntValue(payForItem.getValue());
					Map<String, Object> params = new HashMap<>();
					if(__typeVal == 1){
						params.put("opt_type", "getEmployeeBankInfoById");
						params.put("employeeId", __value);
					}else if(__typeVal == 2){//收款单位
						params.put("opt_type", "getReceiveUnitInfoById");
						params.put("receiveUnitManageId", __value);
					}
					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
								Record __record = dsResponse.getData()[0];
								if(__typeVal == 1){
									payeeNameItem.setValue(BaseHelpUtils.getString(event.getItem().getDisplayValue()));
									String bankId = BaseHelpUtils.getString(__record.getAttribute("bankId"));
									selfBankNameItem.setValue(KeyValueManager.getValueMap("system_dictionary_68").get(bankId));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}else if(__typeVal == 2){
									payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
									selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}
							}
						}
					});
				}
			}
		});
		
		employeeOrCompanyIdItem = new ComboBoxItem("employeeOrCompanyId", "收款方");
		employeeOrCompanyIdItem.setChangeOnKeypress(false);
		employeeOrCompanyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeOrCompanyIdItem.setWidth("*");
		employeeOrCompanyIdItem.setRequired(true);
		employeeOrCompanyIdItem.hide();

		payeeNameItem = new TextItem("payeeName", "收款人");
		payeeNameItem.setWidth("*");
		payeeNameItem.setHidden(true);
		
		selfBankNameItem = new TextItem("selfBankName", "银行名称");
		selfBankNameItem.setWidth("*");
		selfBankNameItem.setRequired(true);
		selfBankNameItem.setDisabled(true);

		selfBankAccountItem = new TextItem("selfBankAccount", "银行账号");
		selfBankAccountItem.setWidth("*");
		selfBankAccountItem.setDisabled(true);
		selfBankAccountItem.setRequired(true);
		
		
		form.setNumCols(2);
		form.setDataSource(DSSprocessbilllistpppor.getInstance());
		form.setItems(payForItem, employeeSelectItem, companySelectItem, employeeOrCompanyIdItem, payeeNameItem, selfBankNameItem, selfBankAccountItem);
	      ClientUtil.DynamicFormProcessAccordingToDevice(form);
	     vLayout.addMember(form);
	     form.setWidth100();
	     form.setHeight100();
	     mainLayout.addMember(vLayout);
	     addMember(mainLayout);
		
	     saveButton = new IButton("确定", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (DataValidate()&&getRecord()!=null) {
						int payFor=BaseHelpUtils.getIntValue(payForItem._getValue());
						int paymentSequenceId=BaseHelpUtils.getIntValue(record.getAttribute("paymentSequenceId"));
						String payeeName=BaseHelpUtils.getString(payeeNameItem.getValue());
						int employeeOrCompanyId=BaseHelpUtils.getIntValue(employeeOrCompanyIdItem._getValue());
						Map<String,Object> map=new HashMap<>();
						map.put("payFor", payFor);
						map.put("paymentSequenceId", paymentSequenceId);
						map.put("payName", payeeName);
						map.put("receiveUnitManageId", employeeOrCompanyId);
						DBDataSource.callOperation("ST_PaymentSequence","update",map,new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0) {
									getParentWindow().destroy();
									DataEditEvent dee = new DataEditEvent();
									fireEvent(dee);
									if (null == getParentWindow()) {
										return;
									}
								}else {
									SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
								}
							}
						});	
					} else {
						return;
					}
				}
			});

			cancelButton = new IButton("取消", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (null == getParentWindow()) {
						return;
					}
					getParentWindow().destroy();
				}
			});
			
			addUnitButton = new IButton("添加收款单位", new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					PopupWindow window = new PopupWindow();
					window.setWidth("30%");
					window.setHeight("95%");
					window.centerInPage();
					window.setTitle("添加收款单位");
					AddReceiveUnitPanel panel = new AddReceiveUnitPanel();
					panel.setParentWindow(window);
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							final Record __record = event.getData();
							Map params = __record.toMap();
							params.put("operateEmployeeId", ClientUtil.getEmployeeId());
							params.put("opt_type", "addReceiveUnitInfo");
							DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									int __id = BaseHelpUtils.getIntValue(data);
									companySelectItem.setValue(__id);
									employeeOrCompanyIdItem.setValue(__id);
									payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
									selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
//									setSelectValue();
								}
							});
						}
					});
					window.addItem(panel);
					window.show();
				}
			});
			
			buttonLayout = new HLayout();
			buttonLayout.setWidth100();
			buttonLayout.setHeight(20);
			buttonLayout.setMargin(8);
			buttonLayout.setMembersMargin(20);
			buttonLayout.setAlign(Alignment.CENTER);
			buttonLayout.addMember(saveButton);
			buttonLayout.addMember(cancelButton);
			buttonLayout.addMember(addUnitButton);
			vLayout.addMember(buttonLayout);

	}
	
	
	public void lodaData() {
		if(getRecord()!=null) {
			Map<String, Object> params = new HashMap<>();
			int payFor=BaseHelpUtils.getIntValue(record.getAttribute("payFor"));
			int receiveUnitManageId=BaseHelpUtils.getIntValue(record.getAttribute("receiveUnitManageId"));
			payForItem.setValue(payFor);
			if(payFor == 1){//个人
				addUnitButton.hide();
				employeeSelectItem.show();
				companySelectItem.hide();
			}else{//公司
				addUnitButton.show();
				companySelectItem.show();
				employeeSelectItem.hide();
			}
			if(payFor==1) {//个人
				/*employeeSelectItem.setValue(receiveUnitManageId);
				params.put("opt_type", "getEmployeeBankInfoById");
				params.put("employeeId", receiveUnitManageId);
				DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {

					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
							Record __record = dsResponse.getData()[0];
							payeeNameItem.setValue(BaseHelpUtils.getString(employeeSelectItem.getDisplayValue()));
							String bankId = BaseHelpUtils.getString(__record.getAttribute("bankId"));
							selfBankNameItem.setValue(KeyValueManager.getValueMap("system_dictionary_68").get(bankId));
							selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
						}
					}
				});*/
			}else {//公司
				companySelectItem.setValue(receiveUnitManageId);
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				employeeOrCompanyIdItem.setValue(receiveUnitManageId);
				params.put("opt_type", "getReceiveUnitInfoById");
				params.put("receiveUnitManageId", receiveUnitManageId);
				DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
							Record __record = dsResponse.getData()[0];
							payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
							selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
							selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
						}
					}
				});
			}
		}
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	
	public boolean DataValidate() {
		return form.validate();
	}
}
