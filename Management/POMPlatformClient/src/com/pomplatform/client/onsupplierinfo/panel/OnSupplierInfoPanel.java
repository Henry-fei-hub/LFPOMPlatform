package com.pomplatform.client.onsupplierinfo.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DownloadFileByUrl;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.common.UploadSalaryOfBonus;
import com.pomplatform.client.onsupplierinfo.datasource.DSOnSupplierInfo;
import com.pomplatform.client.onsupplierinfo.form.OnSupplierInfoSearchForm;
import com.pomplatform.client.onsupplierinfo.form.OnSupplierInfoViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class OnSupplierInfoPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnSupplierInfoPanel cm = new OnSupplierInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSupplierInfo";
		}

	}

	@Override
	public void init(){
		super.init();
		int index = 0;
		ListGridField[] fields = new ListGridField[14];
		fields[index] = new ListGridField("supplierId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("supplierType");
		index++;
		fields[index] = new ListGridField("supplierName");
		index++;
		fields[index] = new ListGridField("supplierContact");
		index++;
		fields[index] = new ListGridField("supplierPhone");
		index++;
		fields[index] = new ListGridField("supplierEmail");
		index++;
		fields[index] = new ListGridField("teamSize");
		index++;
		fields[index] = new ListGridField("areasExpertise");
		KeyValueManager.loadValueMap("system_dictionary_213", fields[index]);
		index++;
		fields[index] = new ListGridField("fileUrl","附件");
		fields[index].setCanEdit(false);
		fields[index].setLinkText("相关文件下载/预览");
		index++;
		fields[index] = new ListGridField("operateEmployeeId");
		KeyValueManager.loadValueMap("employees",fields[index]);
		index++;
		fields[index] = new ListGridField("operateTime");
		index++;
		fields[index] = new ListGridField("isUse");
		fields[index].setAlign(Alignment.CENTER);
		LinkedHashMap<Integer, String> linkMap=new LinkedHashMap<>();
		linkMap.put(0, "无效");
		linkMap.put(1, "有效");
		fields[index].setValueMap(linkMap);
		index++;
		fields[index] = new ListGridField("processStatus");
		KeyValueManager.loadValueMap("process_status", fields[index]);
		resultGrid.setFields(fields);
		resultGrid.setDataSource(getDataSource());
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);

		IButton recordButton = new IButton("供应商入库申请");
		controlLayout.addMember(recordButton);
		recordButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				//获取流程process_id
				String processId = "";
				Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
				if(!PomPlatformClientUtil.isNullOrEmpty(str)){
					String[] arr = str.split(",");
					for(String tempStr : arr){
						String[] tempArr = tempStr.split(":");
						//获取父级ID
						if(tempArr[0].replaceAll("\"", "").equals("Supplier_Come_In")){
							processId = tempArr[1];
						}
					}
				}
				NewProcessWindow panel=new NewProcessWindow();
				panel.setTitle("供应商入库申请");
				panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
				panel.setLayoutMode(0);
				panel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				panel.initComponents();
				panel.setWidth("100%");
				panel.setHeight("100%");
				panel.centerInPage();
				panel.show();

			}
		});

		IButton AddReceiveBut=new IButton("增加收款方");
		controlLayout.addMember(AddReceiveBut);
		AddReceiveBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				PopupWindow window = new PopupWindow();
				window.setWidth("30%");
				window.setHeight("95%");
				window.centerInPage();
				window.setTitle("供应商添加收款单位");
				SupplierAddReceiveUnitPanel panel = new SupplierAddReceiveUnitPanel();
				Record record=resultGrid.getSelectedRecord();
				int supplierId=BaseHelpUtils.getIntValue(record.getAttribute("supplierId"));
				if(supplierId<=0){
					SC.say("获取供应商主键失败！");
					return;
				}
				panel.setRecord(record);
				panel.loadData();
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


		IButton progressButton=new IButton("流程进度");
		controlLayout.addMember(progressButton);
		progressButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record record = resultGrid.getSelectedRecord();
				String sprocessInstanceId = record.getAttribute("processInstanceId");
				if(BaseHelpUtils.isNullOrEmpty(sprocessInstanceId)) {
					SC.say("该数据没有发起流程");
					return;
				}
				Map params = new HashMap();
				params.put("processInstanceId", sprocessInstanceId);
				DBDataSource.callOperation("EP_GetProcessInstance", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record[] records = dsResponse.getData();
							if (records.length == 0) {
								return;
							}
							Record record = records[0];
							Record processInstance = record.getAttributeAsRecord("processInstance");
							ClientUtil.showWorkFlow(processInstance);
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		IButton downloadTemplate = new IButton("下载模板");
		controlLayout.addMember(downloadTemplate);
		downloadTemplate.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	DownloadFileByUrl.download("/files/supplierInfo.xlsx");
            }
        });
		
		IButton importData = new IButton("导入");
		controlLayout.addMember(importData);
		importData.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						Map<String,Object> map = new HashMap<>();
						map.put("operateEmployeeId", ClientUtil.getEmployeeId());
						map.put("operateTime", new Date());
						UploadSalaryOfBonus uploadXls = new UploadSalaryOfBonus(map, DBDataSource.getServerURL("UP_OnUploadSupplierInfo"));
						uploadXls.addDataEditedHandler(new DataEditedHandler() {
							
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						uploadXls.show();
					}
				});
			}
		});


		commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("供应商详情"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnSupplierInfoViewer detailForm = new OnSupplierInfoViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnSupplierInfoSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSupplierInfo.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

}

