package com.pomplatform.client.trainingmanagement.panel;

import java.util.ArrayList;
import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.Print;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.EditProcessWindow;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.trainingmanagement.datasource.DStrainingManagementsApplyOfWorkflow;
import com.pomplatform.client.trainingmanagement.form.trainingManagementsApplyOfWorkflowSearchForm;
import com.pomplatform.client.trainingmanagement.form.trainingManagementsApplyOfWorkflowViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Image;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class trainingManagementsApplyOfWorkflowPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private static IButton operation1Button;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			trainingManagementsApplyOfWorkflowPanel cm = new trainingManagementsApplyOfWorkflowPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "trainingManagementsApplyOfWorkflow";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
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
		

		
		IButton editButton = new IButton("撤销修改");
		controlLayout.addMember(editButton);
		editButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("please select a record to edit");
							return;
						}
						ListGridRecord selected = resultGrid.getSelectedRecord();
						int status = selected.getAttributeAsInt("processStatus");
						if (status != 0) {
							SC.say("对不起，该申请不能修改！");
							return;
						}
						EditProcessWindow Reimbursement = new EditProcessWindow();
						Reimbursement.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), resultGrid.getSelectedRecord());
								resultGrid.redraw();
							}
						});
						Reimbursement.setLayoutMode(0);
						Reimbursement.setProcessId(selected.getAttributeAsInt("processId"));
						Reimbursement.setInstanceData(selected);
						Reimbursement.initComponents();
						Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
						Reimbursement.show();
					}

					@Override
					public void onFailure(Throwable reason) {
						SC.say("请按Ctrl+F5刷新页面再操作");
					}
				});

			}
		});
		
	    operation1Button = new IButton("查看二维码");
	    operation1Button.hide();
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showQRcode();
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
				detail.setTitle("trainingManagementsApplyOfWorkflow"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				trainingManagementsApplyOfWorkflowViewer detailForm = new trainingManagementsApplyOfWorkflowViewer();
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
		List<Map> keyvalues = new ArrayList<>();
		criteria.put("employeeId",ClientUtil.getEmployeeId());
		if(!BaseHelpUtils.isNullOrEmpty(status)) {
			Map<String, String> kv2 = new HashMap<>();
			kv2.put("key", "spi.process_status IN ( 0, 1 )");
			kv2.put("value", status);
			keyvalues.add(kv2);
			
		}
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues)) {
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new trainingManagementsApplyOfWorkflowSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DStrainingManagementsApplyOfWorkflow.getInstance();
	}
	
	public int getSearchFormHeight() {
		return 60;
	}
	
	private String status;
	


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status.equals("spi.process_status IN ( 3, 5 )")) {// 如果是已审核，则隐藏审批按钮
			operation1Button.show();
		} 
		this.status = status;
	}

	private int  activityType;
	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}
	
	
	public void showQRcode(){
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据");
					return;
				}
					ListGridRecord listGridRecord = resultGrid.getSelectedRecord();
					Integer fileID = listGridRecord.getAttributeAsInt("fileManageId");
					Map<String,Integer> map = new HashMap<>();
					String subject = listGridRecord.getAttributeAsString("subject");
					String compere = listGridRecord.getAttributeAsString("compere");
					String employee = listGridRecord.getAttributeAsString("employeeId");
					Date startTime = listGridRecord.getAttributeAsDate("startTime");
					DateTimeFormat tf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");
					String times = tf.format(startTime);
					map.put("fileId", fileID);
					DBDataSource.callOperation("ST_FileManage", "find", map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							Record record = dsResponse.getData()[0];
							String fileUrl = record.getAttribute("fileUrl");
							PopupWindow pWindow = new PopupWindow();
							pWindow.setTitle("二维码");
							pWindow.setWidth(315);
							pWindow.setHeight(415);
							pWindow.centerInPage();
							VLayout vLayout = new VLayout();
							vLayout.setWidth("100%");
							vLayout.setHeight("100%");
							vLayout.setAlign(Alignment.CENTER);
							
							HLayout aLayout = new HLayout();
							aLayout.setWidth100();
							aLayout.setHeight("90%");
							Image image = new Image();
//							image.setWidth("50%");
//							image.setHeight("100%");
							image.setUrl(fileUrl);
							aLayout.addMember(image);
							vLayout.addMember(aLayout);
							
							IButton printBtn = new IButton("打印");
							HLayout bLayout = new HLayout();
							bLayout.setWidth100();
							bLayout.setHeight("10%");
							bLayout.setAlign(Alignment.CENTER);
							bLayout.addMember(printBtn);
//							printBtn.setAlign(Alignment.CENTER);
							printBtn.addClickHandler(new ClickHandler() {
								
								@Override
								public void onClick(ClickEvent event) {
									StringBuilder sb = new StringBuilder();
									sb.append("<html>");
									sb.append("<head>");
									sb.append("<meta charset='UTF-8'>");
									sb.append("<title>扫码进入培训</title>");
									sb.append("</head>");
									sb.append("<body style='position:relative;'>");
									sb.append("<table style='position:absolute;left:30%;font-size:20px;background-color:#333333'>");
									sb.append("<tr>");
									sb.append("<td>主题：</td>");
									sb.append("<td>");
									sb.append(subject);
									sb.append("<td/>");
									sb.append("<tr/>");
									sb.append("<tr>");
									sb.append("<td>主讲人：</td>");
									sb.append("<td>");
									sb.append(compere);
									sb.append("<tr/>");
									sb.append("<td>时间：</td>");
									sb.append("<td>");
									sb.append(times);
									sb.append("<td/>");
									sb.append("<tr>");
//									sb.append("<td></td>");
									sb.append("<td colspan='2'>");
									sb.append("<img src='");
									sb.append(fileUrl);
									sb.append("' width='200px' height='200px'/>");
									Print.it(sb.toString());
									
								}
							});
							vLayout.addMember(bLayout);
							pWindow.addMember(vLayout);
							pWindow.show();
						}
					});
				
			}
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
				
			}
		});
	}


}

