package com.pomplatform.client.reimbursementpackage.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.reimbursementpackage.datasource.DSNewReimbursementPackage;
import com.pomplatform.client.reimbursementpackage.form.NewReimbursementPackageSearchForm;
import com.pomplatform.client.sreimbursementpackagemmror.panel.UpdatePaymentInfoPanel;
import com.pomplatform.client.workflow.panel.AddUpdateProcessBillListPanel;
import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class NewReimbursementPackagePanel extends AbstractSearchPanel implements HasHandlers {

	private static final Logger __LOGGER = Logger.getLogger("");

	private PopupWindow parentWindow;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			NewReimbursementPackagePanel cm = new NewReimbursementPackagePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "NewReimbursementPackage";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needViewPage = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		resultGrid.setSelectionType(SelectionStyle.SIMPLE);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton rightMoveData = new IButton("> >");
		controlLayout.addMember(rightMoveData);
		rightMoveData.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DataEditEvent dee = new DataEditEvent();
                fireEvent(dee);
				
			}
		});
		
		IButton packageButton = new IButton("打包");
//		controlLayout.addMember(packageButton);
		packageButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				SC.confirm("确认打包", new BooleanCallback() {

					@Override
					public void execute(Boolean value) {
						if (value) {
							final ListGridRecord[] list = resultGrid.getSelectedRecords();
							String companyId = list[0].getAttribute("companyId");
							for (ListGridRecord obj : list) {
								if (!obj.getAttribute("companyId").equals(companyId)) {
									SC.say("您选择的记录涉及到多个归属公司，目前系统只支持打包同一个归属公司的信息！");
									return;
								}
							}
							//弹出选择可操作角色和添加备注的面板
							PopupWindow window = new PopupWindow();
							window.setWidth("30%");
							window.setHeight("60%");
							window.centerInPage();
							window.setTitle("选定审批角色");
							NewReimbursementSelectRolePackagePanel panel = new NewReimbursementSelectRolePackagePanel(BaseHelpUtils.getIntValue(companyId));
							panel.setParentWindow(window);
							panel.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									Record record = event.getData();
									Map params = record.toMap();
									params.put("operatorId", ClientUtil.getEmployeeId());
									params.put("records", list);
									params.put("opt_type", "addPackage");
									DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() >= 0) {
												SC.say("打包成功!");
												getParentWindow().destroy();
												DataEditEvent dee = new DataEditEvent();
					                            fireEvent(dee);
											} else {
												ClientUtil.displayErrorMessage(dsResponse);
											}
										}
									});
								}
							});
							window.addItem(panel);
							window.show();
							
						}
					}
				});
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				PopupWindow window = new PopupWindow();
				window.setHeight("80%");
				window.setWidth("80%");
				window.centerInPage();
				window.setTitle("收款信息");
				ProcessBillListDetailPanel panel = new ProcessBillListDetailPanel();
				panel.setTitle("账单流水");
//				panel.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
				panel.setRecord(record);
				
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
					}
				});
				panel.startEdit();
				window.addItem(panel);
				window.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
//		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("backViewName", "出纳");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new NewReimbursementPackageSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSNewReimbursementPackage.getInstance();
	}

	public void removeData(Record record){
		AdvancedCriteria adCriteria = new AdvancedCriteria();
		adCriteria.addCriteria("code", record.getAttribute("code"));
		Record findRecord = resultGrid.find(adCriteria);
		if(null != findRecord){
			resultGrid.removeData(findRecord);
		}
	}
	
	
	public PopupWindow getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(PopupWindow parentWindow) {
		this.parentWindow = parentWindow;
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
    
    public DelicacyListGrid getGrid(){
    	return resultGrid;
    }
}
