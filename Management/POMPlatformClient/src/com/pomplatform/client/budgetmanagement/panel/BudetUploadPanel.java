package com.pomplatform.client.budgetmanagement.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.payseqaddinfo.panel.PaySeqAddInfoPanel;
import com.pomplatform.client.workflow.panel.AddReceiveUnitPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class BudetUploadPanel extends HLayout implements HasHandlers {
	private Window parentWindow;
	private DelicacyListGrid bdDetailGrid;
	//private int   budgetManagementId;
	private HLayout  mainLayout;
	private VLayout  rightLayout;
	private  IButton uploadbut;
	private  IButton updatebut;
	private  IButton deletebut;
	private  IButton applybut;
	private  IButton payseqInfobut;
	private  IButton addUnitButton;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	public void initComponents() {
		mainLayout=new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		addMember(mainLayout);

		bdDetailGrid = new DelicacyListGrid();
		bdDetailGrid.setWidth("90%");
		bdDetailGrid.setAlign(Alignment.CENTER);
		int a = 0;
		ListGridField[] aFields = new ListGridField[9];
		aFields[a] = new ListGridField("budgetAttachmentId","附件id");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("budgetManagementId","预算管理Id");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("attachmentName","附件名称");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("fileUrl","路径");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		aFields[a].setLinkText("预算文件下载/预览");
		a++;
		aFields[a] = new ListGridField("budgetContractAmount","合同预算金额");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("budgetContractAmountUse","合同已付金额");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("budgetContractAmountRest","合同剩余金额");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("payPercent","付款比例");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("receiveUnitManageId","供应商");
		aFields[a].setAlign(Alignment.CENTER);
		Map<String,Object> map=new HashMap<>();
		map.put("receiveUnitManageId", null);
		Record[] reRecord=SyncDataUtil.getValueByTableNames("ST_ReceiveUnitManage", "find",map);
		LinkedHashMap<Integer,String> linkMap=new LinkedHashMap<>();
		for (Record record : reRecord) {
			int receiveUnitManageId=BaseHelpUtils.getIntValue(record.getAttribute("receiveUnitManageId"));
			String receiveUnit=BaseHelpUtils.getString(record.getAttribute("receiveUnit"));
			linkMap.put(receiveUnitManageId, receiveUnit);
		}
		aFields[a].setValueMap(linkMap);
		aFields[a].setShowGridSummary(false);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("bddType","预算类别");
		aFields[a].setAlign(Alignment.CENTER);
		/*ComboBoxItem bddTpyeBoxItem = new ComboBoxItem();
		bddTpyeBoxItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		aFields[a].setEditorProperties(bddTpyeBoxItem);*/
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadEmployeeId","上传人员");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setValueMap(KeyValueManager.getValueMap("employees"));
		aFields[a].setShowGridSummary(false);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadTime","上传时间");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("isApproval","审批状态");
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_192"));
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadRemark","备注");
		aFields[a].setAutoFitWidth(true);
		aFields[a].setType(ListGridFieldType.TEXT);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("projectId","项目Id");
		aFields[a].setHidden(true);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("isLock","是否加锁");
		aFields[a].setHidden(true);
		aFields[a].setCanEdit(false);
		bdDetailGrid.setFields(aFields);
		bdDetailGrid.setAutoFitFieldWidths(false);
		bdDetailGrid.setDataSource(DSBudgetAttachmentDetail.getInstance());
		bdDetailGrid.setCanRemoveRecords(false);
		bdDetailGrid.setShowGridSummary(true);
		bdDetailGrid.setHeaderHeight(60);
		//bdDetailGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);//勾选菜单
		//bdDetailGrid.setSelectionType(SelectionStyle.SIMPLE);//设置多选属性
		bdDetailGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"预算附件详情", new String[] {"budgetAttachmentId","budgetManagementId","attachmentName","fileUrl","budgetContractAmount","budgetContractAmountUse","budgetContractAmountRest","payPercent","receiveUnitManageId","bddType","uploadEmployeeId","uploadTime","isApproval","uploadRemark"}));
		bdDetailGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				final PopupWindow popupWindow = new PopupWindow("查看付款序列");
				popupWindow.setWidth("80%");
				popupWindow.setHeight("80%");
				Record record=bdDetailGrid.getSelectedRecord();
				PaySeqDetailPanel paySeqPanel = new PaySeqDetailPanel();
				paySeqPanel.setRecord(record);
				paySeqPanel.initComponents();
				paySeqPanel.loadData();
				popupWindow.addItem(paySeqPanel);
				paySeqPanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						lodaDate();
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				paySeqPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();			
			}
		});
		mainLayout.addMember(bdDetailGrid);
		

		rightLayout=new VLayout(20);
		rightLayout.setMargin(20);
		rightLayout.setPadding(20);
		rightLayout.setWidth("10%");
		rightLayout.setHeight100();
		mainLayout.addMember(rightLayout);


		IButton refreshButton = new IButton("刷新");
		rightLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				lodaDate();
			}
		});

		uploadbut=new IButton("上传预算附件");
		rightLayout.addMember(uploadbut);
		uploadbut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] ListGridRecords=bdDetailGrid.getGridSummaryData();
				//获取附件合同预算总金额
				BigDecimal  totalBudgetContractAmount=BigDecimal.ZERO;
				//获取预算管理ID
				int budgetManagementId=0;
				for (Record record : ListGridRecords) {
					totalBudgetContractAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("budgetContractAmount"));
				}
				budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
				if(budgetManagementId<=0) {
					SC.say("失败！预算管理id小于或者等于0");
					return;
				}
				Map<String,Object> map=new HashMap<>();
				map.put("budgetManagementId", budgetManagementId);
                Record bmRecord=SyncDataUtil.getValueByTableName("ST_BudgetManagement", "find", map);
                if(BaseHelpUtils.isNullOrEmpty(bmRecord)) {
                	SC.say("查询数据失败,record为空");
                	return;
                }
                //获取预算总金额
                BigDecimal bdTotalAmount=BaseHelpUtils.getBigDecimalValue(bmRecord.getAttribute("bdTotalAmount"));
                if(totalBudgetContractAmount.compareTo(bdTotalAmount)>0) {
                	SC.say("当前附件总金额["+totalBudgetContractAmount+"]大于预算总金额["+bdTotalAmount+"]"+"，请重新分配金额");
                	return;
                }
				final PopupWindow popupWindow = new PopupWindow("上传预算相关附件");
				popupWindow.setWidth("70%");
				popupWindow.setHeight("70%");
				BudetAboutUploadPanel uploadPanel = new BudetAboutUploadPanel();
				record.setAttribute("totalBudgetContractAmount", totalBudgetContractAmount);
				uploadPanel.setRecord(record);
				uploadPanel.lodaData();
				uploadPanel.initComponents();
				popupWindow.addItem(uploadPanel);
				uploadPanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						lodaDate();
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				uploadPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();

			}
		});

		updatebut=new IButton("更新附件");
		rightLayout.addMember(updatebut);
		updatebut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!bdDetailGrid.anySelected()){SC.say("请选择一条数据"); return;};
				ListGridRecord[] ListGridRecords=bdDetailGrid.getGridSummaryData();
				//获取附件合同预算总金额
				BigDecimal  totalBudgetContractAmount=BigDecimal.ZERO;
				//获取预算管理ID
				for (Record records : ListGridRecords) {
					totalBudgetContractAmount=BaseHelpUtils.getBigDecimalValue(records.getAttribute("budgetContractAmount"));
				}
				Record record=bdDetailGrid.getSelectedRecord();
				/*boolean isLock=BaseHelpUtils.getBoolean(record.getAttribute("isLock"));
				if(isLock==true) {
					SC.say("该附件存在正在付款或者已完成付款的序列,不能更新！");
					return;
				}*/
				int isApproval=BaseHelpUtils.getIntValue(record.getAttribute("isApproval"));
				if(isApproval>0) {
					SC.say("该附件存在审批流程中或者审批完成,不能更新！");
					return;
				}
				final PopupWindow popupWindow = new PopupWindow("更新预算相关附件");
				popupWindow.setWidth("70%");
				popupWindow.setHeight("70%");
				BudetUpdateUploadPanel updatePanel = new BudetUpdateUploadPanel();
				record.setAttribute("totalBudgetContractAmount", totalBudgetContractAmount);
				updatePanel.setRecord(record);
				updatePanel.loadDate();
				updatePanel.initComponents();
				popupWindow.addItem(updatePanel);
				updatePanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						lodaDate();
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				updatePanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});

		deletebut=new IButton("删除附件");
		rightLayout.addMember(deletebut);
		deletebut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!bdDetailGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record record=bdDetailGrid.getSelectedRecord();
				boolean isLock=BaseHelpUtils.getBoolean(record.getAttribute("isLock"));
				if(isLock==true) {
					SC.say("该附件存在正在付款或者已完成付款的序列,不能删除！");
					return;
				}
				int isApproval=BaseHelpUtils.getIntValue(record.getAttribute("isApproval"));
				if(isApproval>0) {
					SC.say("该附件存在审批流程中或者审批完成,不能删除！");
					return;
				}
				SC.ask("删除附件","确定要删除附件吗？",new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value) {
							Map<String, Object> params = new HashMap<>();
							int budgetAttachmentId=bdDetailGrid.getSelectedRecord().getAttributeAsInt("budgetAttachmentId");
							params.put("optType", "deleteBudgetAttachment");
							params.put("budgetAttachmentId", budgetAttachmentId);
							DBDataSource.callOperation("EP_BudgetProcessor", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										SC.say("删除附件成功!");
										lodaDate();
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

		applybut=new IButton("附件审批");
		rightLayout.addMember(applybut);
		applybut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!bdDetailGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				NewProcessWindow panel=new NewProcessWindow();
				Record rcord=bdDetailGrid.getSelectedRecord();
				panel.setTitle("预算附件审批");
				panel.setProcessId(ClientUtil.checkAndGetIntValue(gerProcessId("Attachment_Approval")));
				panel.setData(rcord);
				panel.setLayoutMode(0);
				panel.initComponents();
				panel.setWidth("80%");
				panel.setHeight("40%");
				panel.centerInPage();
				panel.show();
			}
		});


		IButton PaySeqAddInfos=new IButton("维护付款序列");
		rightLayout.addMember(PaySeqAddInfos);
		PaySeqAddInfos.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!bdDetailGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow details = new GenericViewWindow();
				details.setTitle("维护付款序列"); 
				details.setWidth("90%"); 
				details.setHeight("90%"); 
				PaySeqAddInfoPanel paySeqPanel =new PaySeqAddInfoPanel();
				Record records=bdDetailGrid.getSelectedRecord();
				paySeqPanel.setRecord(records);
				paySeqPanel.setMainRecord(record);
				paySeqPanel.commonQuery();
				details.setContent(paySeqPanel);
				details.centerInPage();
				details.show();


			}
		});

		payseqInfobut=new IButton("查看付款序列");
		rightLayout.addMember(payseqInfobut);
		payseqInfobut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!bdDetailGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				final PopupWindow popupWindow = new PopupWindow("查看付款序列");
				popupWindow.setWidth("80%");
				popupWindow.setHeight("80%");
				Record record=bdDetailGrid.getSelectedRecord();
				PaySeqDetailPanel paySeqPanel = new PaySeqDetailPanel();
				paySeqPanel.setRecord(record);
				paySeqPanel.initComponents();
				paySeqPanel.loadData();
				popupWindow.addItem(paySeqPanel);
				paySeqPanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						lodaDate();
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				paySeqPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});

		addUnitButton = new IButton("添加供应商", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow();
				window.setWidth("30%");
				window.setHeight("95%");
				window.centerInPage();
				window.setTitle("添加供应商");
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
								if(dsResponse.getStatus()>=0) {
									SC.say("添加成功");
									panel.destroy();
								}
							}
						});
					}
				});
				window.addItem(panel);
				window.show();
			}
		});
		rightLayout.addMember(addUnitButton);
		
		IButton downloadButton = new IButton("导出", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> map=new HashMap<>();
				//获取预算管理ID
				int budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
				map.put("budgetManagementId",budgetManagementId);
				DBDataSource.downloadFile("DW_BudgetAttachmentDetail", map);
			}
		});
		rightLayout.addMember(downloadButton);


	}

	public void lodaDate() {
		final LoadingWindow loading = new LoadingWindow();
		Map<String,Object> map=new HashMap<>();
		//获取预算管理ID
		int budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
		map.put("budgetManagementId",budgetManagementId);
		DBDataSource.callOperation("NQ_BudgetAttachmentDetail","find",map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if (dsResponse.getStatus() >= 0) {
					bdDetailGrid.setData(dsResponse.getData());
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

	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
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
