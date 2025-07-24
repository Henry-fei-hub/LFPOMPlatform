package com.pomplatform.client.hr.panel;

import java.util.ArrayList;
import java.util.Date;
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
import com.pomplatform.client.common.UploadEmployeeOnboardInformation;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class EmployeeContractDetailPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private TextItem employeeNoItem;
	private TextItem employeeNameItem;
	private TextItem departmentIdItem;
	private TextItem statusItem;
	private TextItem onboardDateItem;
	private TextItem plateIdItem;
	private IButton okBtn;

	private LinkItem viewContract1;
	private LinkItem uploadContract1;
	private LinkItem viewContract2;
	private LinkItem uploadContract2;
	private LinkItem viewContract3;
	private LinkItem uploadContract3;
	private LinkItem viewContract4;
	private LinkItem uploadContract4;
	private Map<String,Object> param = new HashMap<>();
	private UploadEmployeeOnboardInformation uploadPanel;
	private ListGrid contractGrid;
	
	public void initComponents(int employeeId) {
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
		messageLayout.setHeight("40%");
		messageLayout.setAlign(Alignment.CENTER);

		DynamicForm form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(5);
		form.setWidth100();
		form.setHeight100();

		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setCanEdit(false);
		employeeNoItem.setLength(18);
		employeeNoItem.setWidth("*");
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setCanEdit(false);
		employeeNameItem.setLength(18);
		employeeNameItem.setWidth("*");
		
		departmentIdItem = new TextItem("departmentId", "所属部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanEdit(false);
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		
		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setCanEdit(false);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		
		statusItem = new TextItem("status", "员工状态");
		statusItem.setWidth("*");
		statusItem.setCanEdit(false);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));

		onboardDateItem = new TextItem("onboardDate", "入职日期");
		onboardDateItem.setWidth("*");
		onboardDateItem.setCanEdit(false);
		
		form.setItems(employeeNoItem,employeeNameItem,departmentIdItem,plateIdItem,statusItem,onboardDateItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		HLayout contractFormLayout = new HLayout(10);
		contractFormLayout.setWidth100();
		contractFormLayout.setHeight("50%");
		
		DynamicForm contractForm = new DynamicForm();
		contractForm.setNumCols(4);
		contractForm.setAlign(Alignment.LEFT);
		contractForm.setPadding(5);
		contractForm.setMargin(5);
		contractForm.setWidth("50%");
		contractForm.setHeight100();
		
		viewContract1 = new LinkItem("保密协议");
		viewContract1.setTitleStyle("");
		viewContract1.setLinkTitle("未上传附件");
		viewContract1.setDisabled(true);
		uploadContract1 = new LinkItem("上传");
		uploadContract1.setLinkTitle("附件上传");
		uploadContract1.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				param.put("path", "/files/ConfidentialityAgreement/");
            	param.put("optType", "onUploadOnboardAttachments");
            	uploadPanel = new UploadEmployeeOnboardInformation(param, DBDataSource.getServerURL("UP_OnCommonUploadFileProcess"));
                uploadPanel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        //上传成功
                    	viewContract1.setLinkTitle("附件已更新，点击预览");
                    	viewContract1.setValue(event.getData().getAttribute("attachmentUrl"));
                    	viewContract1.setDisabled(false);
                    	viewContract1.redraw();
                    }
                });
                uploadPanel.show();
			}
		});
		viewContract2 = new LinkItem("顾问协议");
		viewContract2.setTitleStyle("");
		viewContract2.setLinkTitle("未上传附件");
		viewContract2.setDisabled(true);
		uploadContract2 = new LinkItem("上传");
		uploadContract2.setLinkTitle("附件上传");
		uploadContract2.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				param.put("path", "/files/ConsultantAgreement/");
            	param.put("optType", "onUploadOnboardAttachments");
            	uploadPanel = new UploadEmployeeOnboardInformation(param, DBDataSource.getServerURL("UP_OnCommonUploadFileProcess"));
                uploadPanel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        //上传成功
                    	viewContract2.setLinkTitle("附件已更新，点击预览");
                    	viewContract2.setValue(event.getData().getAttribute("attachmentUrl"));
                    	viewContract2.setDisabled(false);
                    	viewContract2.redraw();
                    }
                });
                uploadPanel.show();
			}
		});
		viewContract3 = new LinkItem("劳动合同");
		viewContract3.setTitleStyle("");
		viewContract3.setLinkTitle("未上传附件");
		viewContract3.setDisabled(true);
		uploadContract3 = new LinkItem("上传");
		uploadContract3.setLinkTitle("附件上传");
		uploadContract3.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				param.put("path", "/files/laborContract/");
            	param.put("optType", "onUploadOnboardAttachments");
            	uploadPanel = new UploadEmployeeOnboardInformation(param, DBDataSource.getServerURL("UP_OnCommonUploadFileProcess"));
                uploadPanel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        //上传成功
                    	viewContract3.setLinkTitle("附件已更新，点击预览");
                    	viewContract3.setValue(event.getData().getAttribute("attachmentUrl"));
                    	viewContract3.setDisabled(false);
                    	viewContract3.redraw();
                    }
                });
                uploadPanel.show();
			}
		});
		viewContract4 = new LinkItem("实习协议");
		viewContract4.setTitleStyle("");
		viewContract4.setLinkTitle("未上传附件");
		viewContract4.setDisabled(true);
		uploadContract4 = new LinkItem("上传");
		uploadContract4.setLinkTitle("附件上传");
		uploadContract4.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				param.put("path", "/files/InternshipAgreement/");
            	param.put("optType", "onUploadOnboardAttachments");
            	uploadPanel = new UploadEmployeeOnboardInformation(param, DBDataSource.getServerURL("UP_OnCommonUploadFileProcess"));
                uploadPanel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        //上传成功
                    	viewContract4.setLinkTitle("附件已更新，点击预览");
                    	viewContract4.setValue(event.getData().getAttribute("attachmentUrl"));
                    	viewContract4.setDisabled(false);
                    	viewContract4.redraw();
                    }
                });
                uploadPanel.show();
			}
		});
		contractForm.setItems(viewContract1,uploadContract1,viewContract2,uploadContract2,viewContract3,uploadContract3,viewContract4,uploadContract4);
		contractFormLayout.addMember(contractForm);
		formLayout.addMember(contractFormLayout);
		
		
		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("10%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		okBtn = new IButton("保存");
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> param = new HashMap<>();
				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
				param.put("attachmentName", viewContract1.getTitle());
				param.put("attachmentUrl", viewContract1.getValue());
				param.put("employeeContractAttachmentId", getEmployeeContractAttachmentId1());
				list.add(param);
				param = new HashMap<>();
				param.put("attachmentName", viewContract2.getTitle());
				param.put("attachmentUrl", viewContract2.getValue());
				param.put("employeeContractAttachmentId", getEmployeeContractAttachmentId2());
				list.add(param);
				param = new HashMap<>();
				param.put("attachmentName", viewContract3.getTitle());
				param.put("attachmentUrl", viewContract3.getValue());
				param.put("employeeContractAttachmentId", getEmployeeContractAttachmentId3());
				list.add(param);
				param = new HashMap<>();
				param.put("attachmentName", viewContract4.getTitle());
				param.put("attachmentUrl", viewContract4.getValue());
				param.put("employeeContractAttachmentId", getEmployeeContractAttachmentId4());
				list.add(param);
				Map<String,Object> listParam = new HashMap<>();
				listParam.put("list", list);
				listParam.put("employeeId",employeeId);
				listParam.put("operateEmployeeId", ClientUtil.getUserId());
				DBDataSource.callOperation("EP_OnEmployeeContractAttachment" ,listParam, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.say("保存成功");
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
	}

	/**
	 * 加载数据
	 * @param employeeId
	 */
	public void load(Map<String,Object> param){
		
		employeeNoItem.setValue(param.get("employeeNo"));
		employeeNameItem.setValue(param.get("employeeName"));
		statusItem.setValue(param.get("status"));
		departmentIdItem.setValue(param.get("departmentId"));
		Date onboardDate = new Date(BaseHelpUtils.getLongValue(param.get("onboardDate")));
		onboardDateItem.setValue(onboardDate);
		plateIdItem.setValue(param.get("plateId"));
		
		int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
		Map<String,Object> map = new HashMap<>();
		map.put("employeeId", employeeId);
		DBDataSource.callOperation("NQ_EmployeeContractAttachment",map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
//					contractGrid.setData(dsResponse.getData());
					Record[] records = dsResponse.getData();
					for(Record record : records){
						String attachmentName = record.getAttributeAsString("attachmentName");
						if(attachmentName.equals("保密协议")){
							employeeContractAttachmentId1 = record.getAttributeAsInt("employeeContractAttachmentId");
							if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("attachmentUrl"))){
								viewContract1.setLinkTitle("附件已上传，点击预览");
								viewContract1.setValue(record.getAttribute("attachmentUrl"));
								viewContract1.setDisabled(false);
							}else{
								viewContract1.setLinkTitle("未上传附件");
								viewContract1.setDisabled(true);
							}
							viewContract1.redraw();
						}else if(attachmentName.equals("顾问协议")){
							employeeContractAttachmentId2 = record.getAttributeAsInt("employeeContractAttachmentId");
							if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("attachmentUrl"))){
								viewContract2.setLinkTitle("附件已上传，点击预览");
								viewContract2.setValue(record.getAttribute("attachmentUrl"));
								viewContract2.setDisabled(false);
							}else{
								viewContract2.setLinkTitle("未上传附件");
								viewContract2.setDisabled(true);
							}
							viewContract2.redraw();
						}else if(attachmentName.equals("劳动合同")){
							employeeContractAttachmentId3 = record.getAttributeAsInt("employeeContractAttachmentId");
							if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("attachmentUrl"))){
								viewContract3.setLinkTitle("附件已上传，点击预览");
								viewContract3.setValue(record.getAttribute("attachmentUrl"));
								viewContract3.setDisabled(false);
							}else{
								viewContract3.setLinkTitle("未上传附件");
								viewContract3.setDisabled(true);
							}
							viewContract3.redraw();
						}else if(attachmentName.equals("实习协议")){
							employeeContractAttachmentId4 = records[3].getAttributeAsInt("employeeContractAttachmentId");
							if(!BaseHelpUtils.isNullOrEmpty(records[3].getAttribute("attachmentUrl"))){
								viewContract4.setLinkTitle("附件已上传，点击预览");
								viewContract4.setValue(records[3].getAttribute("attachmentUrl"));
								viewContract4.setDisabled(false);
							}else{
								viewContract4.setLinkTitle("未上传附件");
								viewContract4.setDisabled(true);
							}
							viewContract4.redraw();
						}
					}
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

	int employeeContractAttachmentId1;
	public int getEmployeeContractAttachmentId1() {
		return employeeContractAttachmentId1;
	}

	public void setEmployeeContractAttachmentId1(int employeeContractAttachmentId1) {
		this.employeeContractAttachmentId1 = employeeContractAttachmentId1;
	}

	public int getEmployeeContractAttachmentId2() {
		return employeeContractAttachmentId2;
	}

	public void setEmployeeContractAttachmentId2(int employeeContractAttachmentId2) {
		this.employeeContractAttachmentId2 = employeeContractAttachmentId2;
	}

	public int getEmployeeContractAttachmentId3() {
		return employeeContractAttachmentId3;
	}

	public void setEmployeeContractAttachmentId3(int employeeContractAttachmentId3) {
		this.employeeContractAttachmentId3 = employeeContractAttachmentId3;
	}

	public int getEmployeeContractAttachmentId4() {
		return employeeContractAttachmentId4;
	}

	public void setEmployeeContractAttachmentId4(int employeeContractAttachmentId4) {
		this.employeeContractAttachmentId4 = employeeContractAttachmentId4;
	}



	int employeeContractAttachmentId2;
	int employeeContractAttachmentId3;
	int employeeContractAttachmentId4;
	

}
