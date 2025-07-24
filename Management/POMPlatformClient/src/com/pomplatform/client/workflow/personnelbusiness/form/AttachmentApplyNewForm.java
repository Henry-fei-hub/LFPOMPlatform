package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
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
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSBusinessTripApply;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ReadOnlyDisplayAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.TitleClickEvent;
import com.smartgwt.client.widgets.form.fields.events.TitleClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class AttachmentApplyNewForm extends AbstractWizadPage implements HasHandlers{
	private static final Logger logger = Logger.getLogger("");

	private final VLayout mainLayout;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final TextItem reasonItem;
	private final TextAreaItem planItem;
	private final TextAreaItem remarkItem;
	private final TextItem addressItem;
	private final ComboBoxItem projectSelectItem;
	private final CheckboxItem isRemoteCityItem;
	private final TextItem attachmentIdItem;
	private final LinkItem attachmentItem;
	private final FloatItem feeItem;
	private final TextItem drafterItem;
	private final FloatItem recItem;
	private final FloatItem invItem;
	private final TextAreaItem paymentGradeDescriptionItem;
	
	private Map<String, Object> contractMap ;

	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	private AttachmentLinkContractReceivablesPanel alrPanel;
	private AttachmentLinkInvoiceApplysPanel aliaPanel;
	private AttachmentLinkInvoicesPanel aliPanel;

	public AttachmentApplyNewForm(int processType) {

		// 项目信息字段
		ListGridField projectIdField = new ListGridField("contractId");
		ListGridField contractCodeField = new ListGridField("contractCode");
		ListGridField projectNameField = new ListGridField("contractName");

		mainLayout = new VLayout();
		DSBusinessTripApply ds = DSBusinessTripApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		// __form.setMargin(5);
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);

		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);

		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);

		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);

		companyIdItem = new SelectItem("companyId", shouldNotBeNull + "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setRequired(true);
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
		companyIdItem.setWidth("*");
		__formItems.add(companyIdItem);

		reasonItem = new TextItem("reason", shouldNotBeNull + "附件名称");
		reasonItem.setRequired(true);
		reasonItem.setWidth("*");
		__formItems.add(reasonItem);

		addressItem = new TextItem("attachment", shouldNotBeNull + "附件路径");
		addressItem.setDisabled(true);
		addressItem.setRequired(true);
		addressItem.setWidth("*");
		__formItems.add(addressItem);

		projectSelectItem = new ComboBoxItem("projectId", shouldNotBeNull + "选择合同");
		projectSelectItem.setRequired(true);
		projectSelectItem.setChangeOnKeypress(false);
		projectSelectItem.setWidth("*");
		projectSelectItem.show();
//		projectSelectItem.setOptionDataSource(DSSelectGridContractValue.getInstance());
		projectSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
/*		projectSelectItem.setValueField(projectIdField.getName());
		projectSelectItem.setDisplayField(projectNameField.getName());
		projectSelectItem.setPickListFields(projectIdField, projectNameField, contractCodeField);*/
		projectSelectItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					SC.debugger();
//					SC.say(event.getValue()+"");
					alrPanel.setContractId(BaseHelpUtils.getIntValue(event.getValue()));
					alrPanel.reloadDetailTableData();
					aliaPanel.setContractId(BaseHelpUtils.getIntValue(event.getValue()));
					aliaPanel.reloadDetailTableData();
					aliPanel.setContractId(BaseHelpUtils.getIntValue(event.getValue()));
					aliPanel.reloadDetailTableData();
					
					loadUpRemark(BaseHelpUtils.getIntValue(event.getValue()));
//					planItem.setValue(projectSelectItem.getSelectedRecord().getAttribute("attachmentRemark"));
				}
				
			}
		});
		__formItems.add(projectSelectItem);
		
		attachmentIdItem = new TextItem("numberOfBaby", "附件ID");
		attachmentIdItem.hide();
		__formItems.add(attachmentIdItem);
		
		attachmentItem = new LinkItem("上传确认函");
		attachmentItem.setLinkTitle("尚未上传确认函,请点击标题【上传确认函】上传");
		attachmentItem.setWidth("*");
		attachmentItem.setTitleStyle("labelTitleStyleClick");
		attachmentItem.setCanEdit(false);
		attachmentItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.DISABLED);
		attachmentItem.setRequired(true);
		__formItems.add(attachmentItem);
		attachmentItem.addTitleClickHandler(new TitleClickHandler() {
			@Override
			public void onTitleClick(TitleClickEvent event) {
				new CommonUploadWindow("上传确认函", false, 100, 2, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						//上传附件确认函成功
                    	attachmentItem.setTitle("更新确认函");
                    	attachmentItem.setTitleStyle("labelTitleStyleClick");
                    	attachmentItem.setCanEdit(false);
                    	attachmentItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
                    	attachmentItem.setLinkTitle("已上传确认函,点击可下载/预览(点击【更新确认函】上传新的确认函)");
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileUrl = data.get(key).getAttribute("fileUrl");
							attachmentIdItem.setValue(fileId);
							attachmentItem.setValue(fileUrl);
							addressItem.setValue(fileUrl);
							reasonItem.setValue(data.get(key).getAttribute("fileName"));
						}
						attachmentItem.redraw();
					}
				});
			}
		});
		
		feeItem = new FloatItem("fee", shouldNotBeNull + "确认函金额");
		feeItem.setRequired(true);
		feeItem.setWidth("*");
		__formItems.add(feeItem);
		
		recItem = new FloatItem("rec", "被绑定收款阶段总金额");
		recItem.setFormat("#,###,###,###,###,##0.00");
		recItem.setDisabled(true);
		recItem.setWidth("*");
		__formItems.add(recItem);
		
		invItem = new FloatItem("inv", "被绑定发票的总金额");
		invItem.setFormat("#,###,###,###,###,##0.00");
		invItem.setDisabled(true);
		invItem.setWidth("*");
		__formItems.add(invItem);
		
		remarkItem = new TextAreaItem("remark", "备注(提示给财务部的信息)");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		paymentGradeDescriptionItem = new TextAreaItem("address", "收款阶段描述(EP:商业方案/动线/概念 等等)");
		paymentGradeDescriptionItem.setColSpan(4);
		paymentGradeDescriptionItem.setRowSpan(3);
		paymentGradeDescriptionItem.setWidth("*");
		__formItems.add(paymentGradeDescriptionItem);
		
		planItem= new TextAreaItem("plan", "特殊事项备注(该备注会在下次申请确认函(同一个合同)显示)");
		planItem.setColSpan(4);
		planItem.setRowSpan(3);
		planItem.setWidth("*");
		__formItems.add(planItem);

		isRemoteCityItem = new CheckboxItem("isRemoteCity", "是否开发票");
		isRemoteCityItem.setDefaultValue(true);
		isRemoteCityItem.setWidth("*");
		isRemoteCityItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				Record record = new Record();
				record.setAttribute("flag", (Boolean)event.getValue());
				if((Boolean)event.getValue()){
					recItem.show();
					invItem.show();
				}else{
					recItem.hide();
					invItem.hide();
				}
				DataEditEvent dee = new DataEditEvent();
				dee.setData(record);
				fireEvent(dee);
			}
		});
		__formItems.add(isRemoteCityItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		mainLayout.addMember(__form);
		projectSelectItem.setColSpan(4);
		attachmentItem.setColSpan(4);
//		Label label = new Label(
//				"<font style=\"font-weight:bold\">温馨提示：以<font style=\"color:#FF7F27\">开始日期</font>的月份为准，该月份的加班/外出/出差申请须在次月5日前（包括次月5日）提出申请</font>");
//		mainLayout.addMember(label);
		addMember(mainLayout);
		loadContracts();
	}

	@Override
	public boolean checkData() {
		if(__form.validate()){
			return true;
		}else{
			SC.say("请您按系统提示填好信息。");
			return false;
		}
	}
	
	public void loadUpRemark(int contractId){
		Map<String, Object> params = new HashMap<>();
		params.put("contractId", contractId);
		params.put("opt_type", "getUpRemark");
		DBDataSource.callOperation("EP_CustomAttachmentWorkProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() > 0){
					Record record = dsResponse.getData()[0];
					if(null != record.getAttribute("plan")){
						planItem.setValue(record.getAttribute("plan"));
					}
					
				}
				
			}
		});
	}
	
	
	public void loadContracts(){
		Map<String, Object> params = new HashMap<>();
		params.put("optType", "loadContracts");
		DBDataSource.callOperation("EP_OnProjectWithStageCommon", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					SC.debugger();
					Record[] records = dsResponse.getData();
					contractMap = new HashMap<>();
					if(records.length>0) {
						for (Record record : records) {
							String attribute = record.getAttribute("contractId");
							contractMap.put(record.getAttribute("contractId"), record.getAttribute("contractCode")+"--"+record.getAttribute("contractName"));
						}
						projectSelectItem.setValueMap(contractMap);
					}
				}
				
			}
		});
	}
	

	@Override
	public void startEdit() {
		if (getRecord() != null){
			__form.editRecord(getRecord());
			//获取附件值，如果有值，则重定义标题显示
			String attachmentFile = BaseHelpUtils.getString(getRecord().getAttribute("attachment"));
			if(!BaseHelpUtils.isNullOrEmpty(attachmentFile)){
				attachmentItem.setTitle("更新附件");
				attachmentItem.setTitleStyle("labelTitleStyleClick");
                attachmentItem.setCanEdit(false);
                attachmentItem.setReadOnlyDisplay(ReadOnlyDisplayAppearance.READONLY);
                attachmentItem.setLinkTitle("已上传附件,点击可下载/预览(点击【更新附件】上传新的附件)");
                attachmentItem.setValue(attachmentFile);
                attachmentItem.redraw();
			}
			Record record = new Record();
			record.setAttribute("flag", getRecord().getAttributeAsBoolean("isRemoteCity"));
			DataEditEvent dee = new DataEditEvent();
			dee.setData(record);
			fireEvent(dee);
			
		}else{
			__form.editNewRecord();
		}	
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSBusinessTripApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map valueMap = __form.getValues();
		if(null != projectSelectItem.getValue() && null != projectSelectItem.getSelectedRecord()){
			Record record = projectSelectItem.getSelectedRecord();
			valueMap.put("projectName", record.getAttribute("contractName"));
			valueMap.put("projectCode", record.getAttribute("contractCode"));
		}
		return valueMap;
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

	public AttachmentLinkContractReceivablesPanel getAlrPanel() {
		return alrPanel;
	}

	public void setAlrPanel(AttachmentLinkContractReceivablesPanel alrPanel) {
		this.alrPanel = alrPanel;
	}

	public AttachmentLinkInvoiceApplysPanel getAliaPanel() {
		return aliaPanel;
	}

	public void setAliaPanel(AttachmentLinkInvoiceApplysPanel aliaPanel) {
		this.aliaPanel = aliaPanel;
	}

	public AttachmentLinkInvoicesPanel getAliPanel() {
		return aliPanel;
	}

	public void setAliPanel(AttachmentLinkInvoicesPanel aliPanel) {
		this.aliPanel = aliPanel;
	}
	
}
