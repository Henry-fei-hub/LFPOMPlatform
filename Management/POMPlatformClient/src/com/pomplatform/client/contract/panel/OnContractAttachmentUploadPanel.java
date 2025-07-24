package com.pomplatform.client.contract.panel;

import java.math.BigDecimal;
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
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class OnContractAttachmentUploadPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private TextItem employeeNameItem;
	private TextItem employeeNoItem;
	private TextItem departmentIdItem;
	private ComboBoxItem companyIdItem;
	private DoubleItem signingMoneySumItem;
	private ComboBoxItem contractIdsItem;
	private TextItem attachmentNameItem;
	private ButtonItem uploadItem;
	private TextAreaItem remarkItem;
	private IButton okBtn;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public void initComponents() {
		setWidth("98%");
		setHeight100();
		setPadding(10);
		setMembersMargin(5);

		VLayout formLayout = new VLayout();
		formLayout.setHeight("98%");
		formLayout.setMembersMargin(5);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);

		HLayout messageLayout = new HLayout();
		messageLayout.setWidth100();
		messageLayout.setHeight("80%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(5);
		form.setWidth100();
		form.setHeight100();

		employeeNameItem = new TextItem("employeeName", "申请人");
		employeeNameItem.setWidth("*");
		employeeNameItem.setDisabled(true);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));

		companyIdItem = new ComboBoxItem("companyId",shouldNotBeNull + "我方签约公司");
		companyIdItem.setWidth("*");
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setChangeOnKeypress(false);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		
		signingMoneySumItem = new DoubleItem("signingMoneySum", "合同金额");
		signingMoneySumItem.setLength(18);
		signingMoneySumItem.setDecimalPad(2);
		signingMoneySumItem.setFormat("#,###,###,###,###,##0.00");
		signingMoneySumItem.setWidth("*");
		
		contractIdsItem = new ComboBoxItem("contractIds","绑定合同");
		contractIdsItem.setWidth("*");
		contractIdsItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contractIdsItem.setChangeOnKeypress(false);
//		contractIdsItem.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", contractIdsItem);
		
		attachmentNameItem = new TextItem("attachmentName", shouldNotBeNull + "文件名称");
		attachmentNameItem.setWidth("*");
		
		uploadItem = new ButtonItem("上传附件");
		uploadItem.setStartRow(false);
		uploadItem.setVAlign(VerticalAlignment.BOTTOM);
		uploadItem.setColSpan(1);
		uploadItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				CommonUploadWindow contractForm = new CommonUploadWindow("合同文件上传",false, null, null, null, new UploadCallBack() {
					@Override
					public void execute(Map<String, Record> data) {
						if(!BaseHelpUtils.isNullOrEmpty(data)){
							for(String key : data.keySet()){
								//获取文件Id和文件名称
								int fId = BaseHelpUtils.getIntValue(data.get(key).getAttribute("fileId"));
								String fileName = BaseHelpUtils.getString(data.get(key).getAttribute("fileName"));
								attachmentNameItem.setValue(fileName);
								setFileId(fId);
								break;
							}
						}
					}
				});
				contractForm.centerInPage();
				contractForm.show();
			}
		});
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(6);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");
		
		form.setItems(employeeNameItem, employeeNoItem,departmentIdItem,companyIdItem,signingMoneySumItem,contractIdsItem,attachmentNameItem,uploadItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("20%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		okBtn = new IButton("确认");
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if(fileId <= 0){
					SC.say("提示","请上传合同文件");
					return;
				}
				//获取我方签约公司
				int companyId = BaseHelpUtils.getIntValue(companyIdItem.getValue());
				//获取文件名称
				String attachmentName = BaseHelpUtils.getString(attachmentNameItem.getValue());
				if(BaseHelpUtils.isNullOrEmpty(attachmentName)){
					SC.say("提示","文件名称不可为空");
					return;
				}
				//获取签约合同金额
				BigDecimal signingMoneySum = BaseHelpUtils.getBigDecimalValue(signingMoneySumItem.getValue());
				//获取备注信息
				final String remark =remarkItem.getValueAsString();
				//获取当前操作人
				Map<Object,Object> params = new HashMap<>();
				params.put("fileId", fileId);
				params.put("companyId", companyId);
				params.put("attachmentName", attachmentName);
				params.put("signingMoneySum", signingMoneySum);
				params.put("contractId", contractIdsItem.getValue());
				params.put("remark", remark);
				params.put("uploadEmployeeId", ClientUtil.getEmployeeId());
				params.put("optType", "onSaveContractAttachment");
				okBtn.setDisabled(false);
				DBDataSource.callOperation("EP_OnCommonContractProcess",params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							okBtn.setDisabled(true);
							if (getParentWindow() == null) {
								return;
							}
							getParentWindow().destroy();
							DataEditEvent dee = new DataEditEvent();
							fireEvent(dee);
						} else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});
			}
		});
		
		IButton cleanBtn = new IButton("关闭");
		cleanBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (getParentWindow() == null) {
					return;
				}
				getParentWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
			}
		});
		btnLayout.addMember(okBtn);
		btnLayout.addMember(cleanBtn);
		formLayout.addMember(btnLayout);
		
		//加载登录人员相关信息
		loadData();
	}
	
	/**
	 * 加载登录人员相关信息
	 */
	private void loadData(){
		//获取当前登录人Id
		int employeeId = ClientUtil.getEmployeeId();
		//加载该职员信息
		Map<String,Object> params = new HashMap<>();
		params.put("employeeId",employeeId);
		DBDataSource.callOperation("ST_Employee","find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record record = dsResponse.getData()[0];
					employeeNameItem.setValue(record.getAttribute("employeeName"));
					employeeNoItem.setValue(record.getAttribute("employeeNo"));
					departmentIdItem.setValue(record.getAttribute("departmentId"));
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
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

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}
	
	private int fileId;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
}
