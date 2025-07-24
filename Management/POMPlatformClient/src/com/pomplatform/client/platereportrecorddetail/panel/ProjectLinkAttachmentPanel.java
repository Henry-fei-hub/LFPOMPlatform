package com.pomplatform.client.platereportrecorddetail.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.NewProcessWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.platereportrecorddetail.datasource.DSProjectLinkAttachmentSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectLinkAttachmentPanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private TextItem contractCodeItem;
	private TextItem contractNameItem;
	private TextItem sheetCodeItem;
	private TextItem sheetNameItem;
	private TextAreaItem remarkItem;
	private DelicacyListGrid grid;

	public void initComponents(final int projectId) {
		grid = new DelicacyListGrid();
		grid.setShowRowNumbers(true);
		grid.setAutoFitFieldWidths(false);
		grid.setCanEdit(false);
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
		messageLayout.setHeight("35%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setNumCols(4);
		form.setAlign(Alignment.CENTER);
		form.setWidth("95%");
		form.setHeight100();

		contractCodeItem = new TextItem("contractCode","合同编号");
		contractCodeItem.setDisabled(true);
		contractCodeItem.setWidth("*");

		contractNameItem = new TextItem("contractName","合同名称");
		contractNameItem.setDisabled(true);
		contractNameItem.setWidth("*");

		sheetCodeItem = new TextItem("sheetCode","订单编号");
		sheetCodeItem.setDisabled(true);
		sheetCodeItem.setWidth("*");

		sheetNameItem = new TextItem("sheetName","订单名称");
		sheetNameItem.setDisabled(true);
		sheetNameItem.setWidth("*");

		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");

		form.setItems(contractCodeItem,contractNameItem,sheetCodeItem,sheetNameItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		grid.setDataSource(DSProjectLinkAttachmentSource.getInstance());
		grid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		grid.setSelectionType(SelectionStyle.SINGLE);
		grid.setHeight("60%");
		grid.setWidth100();
		ListGridField[] fields = new ListGridField[4];
		int idx = 0;
		fields[idx] = new ListGridField("attachmentManageId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("attachmentCode");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("attachmentName");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("attachmentAddress");
		fields[idx].setCanEdit(false);
		fields[idx].setLinkText("确认函下载/预览");
		idx ++;
		grid.setFields(fields);
		formLayout.addMember(grid);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("5%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		IButton applyBtn = new IButton("申请确认函");
		applyBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				NewProcessWindow distribution = new NewProcessWindow();
				distribution.setTitle("确认函申请");
				distribution.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						// 操作成功
						SC.say("提示","操作成功");
					}
				});
				Map<String, String> processIdMap = PomPlatformClientUtil
						.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_4);
				Integer value = ClientUtil.checkAndGetIntValue(processIdMap.get("Attachment_apply"));
				distribution.setProcessId(value);
				distribution.setLayoutMode(0);
				distribution.initComponents();
				distribution.setTitle(KeyValueManager.getValue("employee_processes", String.valueOf(value)));
				distribution.show();
			}
		});

		IButton okBtn = new IButton("确认");
		okBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!grid.anySelected()){ SC.say("请选择一条确认函"); return;}
				if(contractId==0){
					SC.say("提示","操作异常:合同不可为空");
					return;
				}
				if(projectId == 0){
					SC.say("提示","操作异常:订单不可为空");
					return;
				}
				if(BaseHelpUtils.isNullOrEmpty(stageId) || stageId < 0){
					SC.say("提示","操作异常:订单阶段不可为空");
					return;
				}
				final String remark =remarkItem.getValueAsString();
				LinkedHashMap<String,Object> params = new LinkedHashMap<>();
				params.put("contractId", contractId);
				params.put("projectId", projectId);
				params.put("stageId", stageId);
				params.put("contractCode", contractCodeItem.getValue());
				params.put("contractName", contractNameItem.getValue());
				params.put("sheetCode", sheetCodeItem.getValue());
				params.put("sheetName", sheetNameItem.getValue());
				params.put("remark", remark);
				params.put("operateEmployeeId",ClientUtil.getEmployeeId());
				params.put("operateTime",new Date());
				params.put("uploadTime",new Date());
				//获取绑定的确认函
				Record r = grid.getSelectedRecord();
				params.put("attachmentManageId",r.getAttribute("attachmentManageId"));
				params.put("attachmentCode",r.getAttribute("attachmentCode"));
				params.put("attachmentName",r.getAttribute("attachmentName"));
				params.put("attachmentAddress",r.getAttribute("attachmentAddress"));
				params.put("attachmentFile",r.getAttribute("attachmentAddress"));
				Record record=new Record();
				record.setAttribute("info", params);
				NewProcessWindow panel=new NewProcessWindow();
				panel.setTitle("确认函审批");
				panel.setProcessId(ClientUtil.checkAndGetIntValue(gerProcessId("Project_stage_audit")));
				panel.setData(record);
				panel.setLayoutMode(0);
				panel.initComponents();
				panel.setWidth("100%");
				panel.setHeight("100%");
				panel.centerInPage();
				panel.show();
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
		btnLayout.addMember(applyBtn);
		btnLayout.addMember(okBtn);
		btnLayout.addMember(cleanBtn);
		formLayout.addMember(btnLayout);

	}

	/**
	 * 加载页面时加载该方法
	 * 
	 * @param plateId
	 */
	public void load(int projectId) {
		if (projectId == 0) {
			return;
		}
		Map<String,Object> params = new HashMap<>();
		params.put("projectId", projectId);
		DBDataSource.callOperation("ST_Project", "find", params,new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record record = dsResponse.getData()[0];
					//获取合同ID
					int conId = BaseHelpUtils.getIntValue(record.getAttribute("contractId"));
					setContractId(conId);
					//获取订单编号和名称
					String sheetCode = BaseHelpUtils.getString(record.getAttribute("contractCode"));
					String sheetName = BaseHelpUtils.getString(record.getAttribute("projectName"));
					sheetCodeItem.setValue(sheetCode);
					sheetNameItem.setValue(sheetName);
					//加载合同信息
					params.put("contractId", conId);
					DBDataSource.callOperation("ST_Contract", "find", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Record e = dsResponse.getData()[0];
								//获取合同编号和名称
								String contractCode = BaseHelpUtils.getString(e.getAttribute("contractCode"));
								String contractName = BaseHelpUtils.getString(e.getAttribute("contractName"));
								contractCodeItem.setValue(contractCode);
								contractNameItem.setValue(contractName);
							}
						}
					});
					params.put("deleteFlag", 0);
					//加载合同下的确认函
					DBDataSource.callOperation("ST_AttachmentManage", "find", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Record[] records = dsResponse.getData();
								grid.setData(records);
							}
						}
					});
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

	private int contractId;
	private int stageId;

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getStageId() {
		return stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}

	//获取流程ID
	public String gerProcessId(String workName) {
		String processId = "";
		Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
		if(!PomPlatformClientUtil.isNullOrEmpty(str)){
			String[] arr = str.split(",");
			for(String tempStr : arr){
				String[] tempArr = tempStr.split(":");
				//获取父级ID
				if(tempArr[0].replaceAll("\"", "").equals(workName)){
					processId = tempArr[1];
				}
			}
		}
		return processId;
	}


}
