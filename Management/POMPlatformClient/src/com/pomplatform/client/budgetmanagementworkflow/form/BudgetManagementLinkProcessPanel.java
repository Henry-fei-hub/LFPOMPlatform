package com.pomplatform.client.budgetmanagementworkflow.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.event.shared.HandlerManager;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.workflow.personnelbusiness.form.AttachmentLinkContractReceivablesPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class BudgetManagementLinkProcessPanel extends AbstractWizadPage {
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private Window parentWindow;
	private DynamicForm searchForm;
	private DelicacyListGrid  beforeGrid;
	private DelicacyListGrid  afterGrid;
	private Record record;
	private VLayout mainLayout;
	private HLayout serchLayout;
	private HLayout topLayout;
	private HLayout topRightLayout;
	private HLayout topLeftLayout;
	private HLayout bottomLayout;
	private HLayout bottomRightLayout;
	private HLayout bottomLetLayout;
	private IButton  selBut; 
	private IButton  delBut;
	private TextItem employeeNoItem;
	private ComboBoxItem employeeNameItem;
	private String employeeNo="";
	private String employeeName="";
	private BudgetManagementWorkFlowNewForm mainPanel;
	private BudgetManagementWorkFlowUpdateForm updatePanel;
	private BigDecimal  totalAmout=BigDecimal.ZERO;
	private boolean status; 

	public BudgetManagementLinkProcessPanel(Boolean status) {
		this.status=status;
		mainLayout=new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		addMember(mainLayout);

		serchLayout=new HLayout();
		serchLayout.setWidth100();
		serchLayout.setHeight("5%");
		serchLayout.setMembersMargin(10);
		mainLayout.addMember(serchLayout);

		employeeNoItem = new TextItem("employeeNo", "职员编号");
		employeeNoItem.setWidth("*");

		LinkedHashMap<String, String>  linkMap=new LinkedHashMap<>();
		HashMap<String, Object>  eMap=new HashMap<>();
		eMap.put("status", 0);
		Record[]  emrecord=SyncDataUtil.getValueByTableNames("ST_Employee", "find",eMap);
		for (Record record : emrecord) {
			String employeeName=BaseHelpUtils.getString(record.getAttribute("employeeName"));
			linkMap.put(employeeName, employeeName);
		}
		employeeNameItem = new ComboBoxItem("employeeName", "职员名称");
		employeeNameItem.setValueMap(linkMap);
		employeeNameItem.setWidth("*");

		searchForm = new DynamicForm();
		searchForm.setNumCols(4);
		searchForm.setWidth("60%");;
		searchForm.setHeight("10%");
		searchForm.setFields(employeeNoItem,employeeNameItem);
		serchLayout.addMember(searchForm);

		IButton searchBtn = new IButton("搜索");
		searchBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//获取职员编号信息
				String employeeNo = BaseHelpUtils.getString(employeeNoItem.getValue());
				String employeeName = BaseHelpUtils.getString(employeeNameItem.getValue());
				setEmployeeInfo(employeeName, employeeNo);
			}
		});
		serchLayout.addMember(searchBtn);

		IButton resetBtn = new IButton("重置");
		resetBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				cleanValue();
				startEdit();
			}
		});
		serchLayout.addMember(resetBtn);


		topLayout=new HLayout(10);
		topLayout.setWidth("100%");
		topLayout.setHeight("50%");
		topLayout.setMargin(10);
		mainLayout.addMember(topLayout);

		topLeftLayout=new HLayout();
		topLeftLayout.setWidth("95%");
		topLeftLayout.setHeight("100%");
		topLayout.addMember(topLeftLayout);


		topRightLayout=new HLayout();
		topRightLayout.setAlign(Alignment.CENTER);
		topRightLayout.setWidth("5%");
		topRightLayout.setHeight("100%");
		topLayout.addMember(topRightLayout);



		bottomLayout=new HLayout(10);
		bottomLayout.setWidth("100%");
		bottomLayout.setHeight("50%");
		bottomLayout.setMargin(10);
		mainLayout.addMember(bottomLayout);

		bottomLetLayout=new HLayout();
		bottomLetLayout.setWidth("95%");
		bottomLetLayout.setHeight("100%");
		bottomLayout.addMember(bottomLetLayout);

		bottomRightLayout=new HLayout();
		bottomRightLayout.setWidth("5%");
		bottomRightLayout.setHeight("100%");
		bottomLayout.addMember(bottomRightLayout);




		beforeGrid=new DelicacyListGrid();
		beforeGrid.setWidth100();
		beforeGrid.setHeight("100%");
		int a = 0;
		ListGridField[] aFields = new ListGridField[12]; 
		aFields[a] = new ListGridField("businessId"); 
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("processId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("processType");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("processInstanceId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("employeeNo","员工编号");
		aFields[a].setAlign(Alignment.CENTER);
		a++;
		aFields[a] = new ListGridField("employeeId","申请人");
		KeyValueManager.loadValueMap("employees", aFields[a]);
		aFields[a].setAlign(Alignment.CENTER);
		a++;
		aFields[a] = new ListGridField("departmentId","归属部门");
		KeyValueManager.loadValueMap("departments", aFields[a]);
		aFields[a].setAlign(Alignment.CENTER);
		a++;
		aFields[a] = new ListGridField("reason","申请缘由");
		aFields[a].setAlign(Alignment.CENTER);
		a++;
		aFields[a] = new ListGridField("createTime","领用日期");
		aFields[a].setAlign(Alignment.CENTER);
		DateTimeItem  dateItem=new DateTimeItem();
		dateItem.setUseTextField(true);
		aFields[a].setEditorProperties(dateItem);
		beforeGrid.setFields(aFields);
		beforeGrid.setCanDragSelectText(true);
		beforeGrid.setAutoFitFieldWidths(false);
		//beforeGrid.setSelectionType(SelectionStyle.SIMPLE);//设置多选属性
		beforeGrid.setCanRemoveRecords(false);
		beforeGrid.setHeaderHeight(60);
		beforeGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record selected = beforeGrid.getSelectedRecord();
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
				Reimbursement.setWidth("80%");
				Reimbursement.setHeight("80%");
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.show();
			}
		});
		beforeGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"物品领用", new String[] {"employeeNo","employeeId","departmentId","reason","createTime"}));
		topLeftLayout.addMember(beforeGrid);



		selBut=new IButton("关联");
		selBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addSelectedEmployee();
			}
		});
		topRightLayout.addMember(selBut);

		afterGrid=new DelicacyListGrid();
		afterGrid.setWidth100();
		afterGrid.setHeight("100%");
		int aa = 0;
		ListGridField[] aFieldss = new ListGridField[12];
		aFieldss[aa] = new ListGridField("businessId");
		aFieldss[aa].setHidden(true);
		aFieldss[aa].setShowGridSummary(false);
		aa++;
		aFieldss[aa] = new ListGridField("processId");
		aFieldss[aa].setHidden(true);
		aFieldss[aa].setShowGridSummary(false);
		aa++;
		aFieldss[aa] = new ListGridField("processType");
		aFieldss[aa].setHidden(true);
		aFieldss[aa].setShowGridSummary(false);
		aa++;
		aFieldss[aa] = new ListGridField("processInstanceId");
		aFieldss[aa].setHidden(true);
		aFieldss[aa].setShowGridSummary(false);
		aa++;
		aFieldss[aa] = new ListGridField("employeeNo","员工编号");
		aFieldss[aa].setAlign(Alignment.CENTER);
		aFieldss[aa].setShowGridSummary(false);
		aa++;
		aFieldss[aa] = new ListGridField("employeeId","申请人");
		KeyValueManager.loadValueMap("employees",aFieldss[aa]);
		aFieldss[aa].setAlign(Alignment.CENTER);
		aFieldss[aa].setShowGridSummary(false);
		aa++;
		aFieldss[aa] = new ListGridField("departmentId","归属部门");
		KeyValueManager.loadValueMap("departments",aFieldss[aa]);
		aFieldss[aa].setAlign(Alignment.CENTER);
		aFieldss[aa].setShowGridSummary(false);
		aa++;
		aFieldss[aa] = new ListGridField("totalPrice","总金额");
		aFieldss[aa].setAlign(Alignment.RIGHT);
		aFieldss[aa].setType(ListGridFieldType.FLOAT);
		aFieldss[aa].setFormat("##,###,###,###,##0.00");
		aFieldss[aa].setShowGridSummary(false);
		aa++;
		aFieldss[aa] = new ListGridField("reason","申请缘由");
		aFieldss[aa].setAlign(Alignment.CENTER);
		aFieldss[aa].setShowGridSummary(false);
		aa++;
		aFieldss[aa] = new ListGridField("createTime","领用日期");
		aFieldss[aa].setAlign(Alignment.CENTER);
		DateTimeItem  dateItems=new DateTimeItem();
		dateItems.setUseTextField(true);
		aFieldss[aa].setEditorProperties(dateItems);
		aFieldss[aa].setShowGridSummary(false);
		afterGrid.setFields(aFieldss);
		afterGrid.setCanRemoveRecords(true);
		afterGrid.setAutoFitFieldWidths(false);
		afterGrid.setShowGridSummary(true);
		afterGrid.setCanDragSelectText(true);
		afterGrid.setHeaderHeight(60);
		afterGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record selected = afterGrid.getSelectedRecord();
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
				Reimbursement.setWidth("80%");
				Reimbursement.setHeight("80%");
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.show();
			}
		});
		afterGrid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				Record selected = afterGrid.getSelectedRecord();
				totalAmout=totalAmout.subtract(BaseHelpUtils.getBigDecimalValue(selected.getAttribute("totalPrice")));
				if(totalAmout.compareTo(BigDecimal.ZERO)<=0) {
					getMainPanel().setTotalAmount(BigDecimal.ZERO);
				}else {
					getMainPanel().setTotalAmount(totalAmout);
				}
			}
		});
		afterGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"关联的物品领用", new String[] {"employeeNo","employeeId","departmentId","totalPrice","reason","createTime"}));
		bottomLetLayout.addMember(afterGrid);

		delBut=new IButton("查看详情");
		delBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!afterGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record selected = afterGrid.getSelectedRecord();
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
				Reimbursement.setWidth("80%");
				Reimbursement.setHeight("80%");
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.show();
			}
		});
		bottomRightLayout.addMember(delBut);


	}
	@Override
	public Map getValuesAsMap() {
		Map<String,Object>  valueMap=new HashMap<String, Object>();
		MapUtils.convertRecordToMap(afterGrid,afterGrid.getRecords(),valueMap,"detailBudgetProess");
		return valueMap;
	}
	@Override
	public boolean checkData() {
		boolean value=false;
		if(status) {
		   value=BaseHelpUtils.getBoolean(getMainPanel().getIsProcessItem().getValue());
		}else {
		   value=BaseHelpUtils.getBoolean(getUpdatePanel().getIsProcessItem().getValue());
		}
		if(value) {//说明关联流程
			if(afterGrid.getRecords().length==0) {
				SC.say("关联的物品领用不能为空");
				return false;
			}else {
				return true;
			}
		}else {
			return true;
		}
	}


	@Override
	public void startEdit() {
		if(status) {
			Map<String,Object> params = new HashMap<>();
			params.put("processType", 31);//物品领用

			List<Map> keyvalues = new ArrayList<>();

			Map<String, String> kv = new HashMap<>();
			kv.put("key", "spia.status =?");
			kv.put("value", "1 =? and spia.status in (2,3,4,5,6)");
			keyvalues.add(kv);

			Map<String, String> kv2 = new HashMap<>();
			kv2.put("key", "sppt.status =?");
			kv2.put("value", "1 =? and sppt.status in (2,3,4,5,6)");
			keyvalues.add(kv2);

			Map<String, String> kv1 = new HashMap<>();
			kv1.put("key", "spt.parent_process_type_id = 12");
			kv1.put("value", "spt.parent_process_type_id = 32");
			keyvalues.add(kv1);
			
			

			params.put("keyValues", keyvalues);

			if(!BaseHelpUtils.isNullOrEmpty(employeeName)&&employeeName.length()>0) {
				params.put("employeeName", employeeName);
			}

			if(!BaseHelpUtils.isNullOrEmpty(employeeNo)&&employeeNo.length()>0) {
				params.put("employeeNo", employeeNo);
			}

			params.put("employeeId", ClientUtil.getUserId());
			
			params.put("processStatus", 3);

			DBDataSource.callOperation("NQ_OnLoadFlowPersonnelBuisnessData", params, new DSCallback(){
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0) {
						beforeGrid.setData(dsResponse.getData());
					}
				}
			});
		}else {
			setDetailView();
		}
	}

	public void setEmployeeInfo(String employeeName,String employeeNo) {
		if(!BaseHelpUtils.isNullOrEmpty(employeeName)) {
			this.employeeName=employeeName;
		}
		if(!BaseHelpUtils.isNullOrEmpty(employeeNo)) {
			this.employeeNo=employeeNo;
		}
		startEdit();
	}

	public void cleanValue() {
		this.employeeName="";
		this.employeeNo="";
		employeeNameItem.clearValue();
		employeeNoItem.clearValue();
	}


	private void addSelectedEmployee() {
		ListGridRecord[] selectedRecords = beforeGrid.getSelectedRecords();
		RecordList originalList = afterGrid.getDataAsRecordList();
		int originalLength = originalList.getLength();
		RecordList newList = new RecordList();
		if (originalLength > 0) {
			newList.addList(originalList.getRange(0, originalLength));
		}
		beforeGrid.deselectAllRecords(); 
		for (ListGridRecord selectedRecord : selectedRecords) {
			Map<String,Object> searchMap = new HashMap<>();
			searchMap.put("processInstanceId", selectedRecord.getAttributeAsInt("processInstanceId"));
			if (originalLength > 0) {
				int index = originalList.findIndex(searchMap);
				if (index != -1) {
					continue;
				}
			}
			int businessId=BaseHelpUtils.getIntValue(selectedRecord.getAttributeAsInt("businessId"));
			int processType=BaseHelpUtils.getIntValue(selectedRecord.getAttributeAsInt("processType"));
			searchMap.put("employeeId", selectedRecord.getAttribute("employeeId"));
			searchMap.put("employeeNo", selectedRecord.getAttribute("employeeNo"));
			searchMap.put("departmentId", selectedRecord.getAttribute("departmentId"));
			searchMap.put("reason", selectedRecord.getAttribute("reason"));
			searchMap.put("createTime", selectedRecord.getAttributeAsDate("createTime"));
			searchMap.put("businessId", businessId);
			searchMap.put("processId", selectedRecord.getAttributeAsInt("processId"));
			searchMap.put("processType", processType);
			searchMap.put("processInstanceId", selectedRecord.getAttributeAsInt("processInstanceId"));
			BigDecimal totalPrice=getAmount(businessId,processType);
			searchMap.put("totalPrice", totalPrice);
			totalAmout=totalAmout.add(totalPrice);//预算总金额
			newList.add(new Record(searchMap));
		}
		getMainPanel().setTotalAmount(totalAmout);
		afterGrid.setData(newList);
	}

	public BigDecimal getAmount(Integer personnelBusinessId,Integer processType) {
		BigDecimal amout=BigDecimal.ZERO;
		Map<String,Object> map=new HashMap<>();
		map.put("parentId", personnelBusinessId);
		map.put("processType", processType);
		Record[] reocords=SyncDataUtil.getValueByTableNames("ST_PersonnelBusinessLinkEquipment", "find", map);
		if(!BaseHelpUtils.isNullOrEmpty(reocords)) {
		for (Record record : reocords) {
			 amout=amout.add(BaseHelpUtils.getBigDecimalValue(record.getAttribute("totalPrice")));
		 }
		}
		return amout;
	}


	public BudgetManagementWorkFlowNewForm getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(BudgetManagementWorkFlowNewForm mainPanel) {
		this.mainPanel = mainPanel;
	}



	public BudgetManagementWorkFlowUpdateForm getUpdatePanel() {
		return updatePanel;
	}

	public void setUpdatePanel(BudgetManagementWorkFlowUpdateForm updatePanel) {
		this.updatePanel = updatePanel;
	}

	public void setDetailView() {
		serchLayout.hide();
		topLayout.hide();
		afterGrid.setCanRemoveRecords(false);
		Map<String,Object> params = new HashMap<>();
		params.put("budgetManagementId",BaseHelpUtils.getIntValue(getRecord().getAttribute("budgetManagementId")));
		DBDataSource.callOperation("ST_BudgetManagementLinkProcess", "find", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					afterGrid.setData(dsResponse.getData());
				}
			}
		});
	}

}
