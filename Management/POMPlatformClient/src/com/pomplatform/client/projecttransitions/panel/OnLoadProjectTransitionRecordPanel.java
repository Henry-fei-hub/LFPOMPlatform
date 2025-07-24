package com.pomplatform.client.projecttransitions.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.project.form.SettlementPanel;
import com.pomplatform.client.projecttransitions.datasource.DSOnLoadProjectTransitionRecord;
import com.pomplatform.client.projecttransitions.form.OnLoadProjectTransitionRecordSearchForm;
import com.pomplatform.client.projecttransitions.form.OnLoadProjectTransitionRecordViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class OnLoadProjectTransitionRecordPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadProjectTransitionRecordPanel cm = new OnLoadProjectTransitionRecordPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadProjectTransitionRecord";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
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

		IButton agreeButton = new IButton("同意");
		controlLayout.addMember(agreeButton);
		agreeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selectedRecords = resultGrid.getSelectedRecords();
				if(selectedRecords.length<=0) {
					SC.say("提示","请选择一条数据");
					return ;
				}
				
				ListGridRecord record = selectedRecords[0];
				int projectId = BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
				String projectCode = BaseHelpUtils.getString(record.getAttribute("projectCode"));
				SC.ask("确认是否通过订单编号("+projectCode+")的记录", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value) {
							Map params = record.toMap();
	                        params.put("status", 3);
	                        DBDataSource.callOperation("EP_ProjectTransitionUpdate", params, new DSCallback() {
	                            @Override
	                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
	                                if (dsResponse.getStatus() >= 0) {
	                                	SC.say("操作成功");
	                                	commonQuery();
	                                } else {
	                                    @SuppressWarnings("rawtypes")
	                					Map errors = dsResponse.getErrors();
	                                    SC.say(errors.get("errorMsg")+"");
	                                }
	                            }
	                        });
							
							
						}
					}
				});
			}
		});
		
		
		IButton notAgreeButton = new IButton("驳回");
		controlLayout.addMember(notAgreeButton);
		notAgreeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selectedRecords = resultGrid.getSelectedRecords();
				if(selectedRecords.length<=0) {
					SC.say("提示","请选择一条数据");
					return ;
				}
				
				ListGridRecord record = selectedRecords[0];
				int projectId = BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
				String projectCode = BaseHelpUtils.getString(record.getAttribute("projectCode"));
				SC.ask("确认是否驳回订单编号("+projectCode+")的记录", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value) {
							Map params = record.toMap();
	                        params.put("status", 2);
	                        DBDataSource.callOperation("EP_ProjectTransitionUpdate", params, new DSCallback() {
	                            @Override
	                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
	                                if (dsResponse.getStatus() >= 0) {
	                                	SC.say("操作成功");
	                                	commonQuery();
	                                } else {
	                                    @SuppressWarnings("rawtypes")
	                					Map errors = dsResponse.getErrors();
	                                    SC.say(errors.get("errorMsg")+"");
	                                }
	                            }
	                        });
							
							
						}
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
				detail.setTitle("OnLoadProjectTransitionRecord"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnLoadProjectTransitionRecordViewer detailForm = new OnLoadProjectTransitionRecordViewer();
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
		criteria.put("initiateDesign", ClientUtil.getUserId());
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadProjectTransitionRecordSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadProjectTransitionRecord.getInstance();
	}
	
	public int getSearchFormHeight() {
		return 60;
	}


}

