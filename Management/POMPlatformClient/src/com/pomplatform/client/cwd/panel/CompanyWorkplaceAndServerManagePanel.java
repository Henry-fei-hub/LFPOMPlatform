package com.pomplatform.client.cwd.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.cwd.datasource.DSCompanyWorkplaceAndServerManage;
import com.pomplatform.client.cwd.form.CompanyWorkplaceAndServerManageSearchForm;
import com.pomplatform.client.cwd.form.CompanyWorkplaceAndServerManageViewer;
import com.pomplatform.client.cwd.form.NewCompanyWorkplaceAndServerManageForm;
import com.pomplatform.client.cwd.form.UpdateCompanyWorkplaceAndServerManageForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.RecordList;
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

public class CompanyWorkplaceAndServerManagePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			CompanyWorkplaceAndServerManagePanel cm = new CompanyWorkplaceAndServerManagePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CompanyWorkplaceAndServerManage";
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

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton operation2Button = new IButton("新建");
		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						NewCompanyWorkplaceAndServerManageForm detailForm = new NewCompanyWorkplaceAndServerManageForm();
						detailForm.setTitle("新建");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								RecordList list = resultGrid.getDataAsRecordList();
								RecordList newList = new RecordList();
								newList.addList(list.getRange(0, list.getLength()));
								newList.add(event.getData());
								resultGrid.setData(newList);
								resultGrid.selectSingleRecord(newList.getLength()-1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		IButton operation3Button = new IButton("修改");
		controlLayout.addMember(operation3Button);
		operation3Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateCompanyWorkplaceAndServerManageForm detailForm = new UpdateCompanyWorkplaceAndServerManageForm();
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), selected1);
								resultGrid.redraw();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());
					}
				});
			}
		});
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("Please select a data to remove.");
						}
						SC.confirm("确定要删除这条工作场所吗？", new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								final ListGridRecord selected = resultGrid.getSelectedRecord();
								DBDataSource.callOperation("ST_CompanyWorkplaceWithC", "delete", selected.toMap(), new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() < 0) {
											ClientUtil.displayErrorMessage(dsResponse);
										} else {
											int indexNum = resultGrid.getRowNum(selected);
											resultGrid.removeData(selected);
											resultGrid.selectSingleRecord(indexNum);
										}
									}
								});
							}
						});
					}
				});
			}
		});
		IButton initButton = new IButton("初始化");
		controlLayout.addMember(initButton);
		initButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择需要初始化的工作场所");
							return;
						}
						ListGridRecord[] records = resultGrid.getSelectedRecords();
						StringBuilder sb = new StringBuilder();
						Integer companyNo = null;
						for(ListGridRecord record : records) {
							//	只对二级存储服务器做初始化操作
							if(ClientUtil.checkAndGetIntValue(record.getAttribute("workplaceType")) != 2) {
								SC.say("无法对工作场所：" + record.getAttribute("workplaceName") + "进行初始化");
								return;
							}
							if(!record.getAttributeAsBoolean("active")) {
								SC.say(record.getAttribute("workplaceName") + "是无效的工作场所，无法初始化");
								return;
							}
							if(record.getAttributeAsBoolean("hasInit")) {
								SC.say(record.getAttribute("workplaceName") + "已初始化完成，无需重复初始化");
								return;
							}
							if(ClientUtil.isNullOrEmpty(record.getAttribute("companyWorkplaceId"))) {
								continue;
							}
							if(null == companyNo) {
								companyNo = ClientUtil.checkAndGetIntValue(record.getAttribute("companyId"));
							}else {
								if(!Objects.equals(companyNo, ClientUtil.checkAndGetIntValue(record.getAttribute("companyId")))) {
									SC.say("只能选择同一个公司的工作场所进行初始化");
									return;
								}
							}
							if(sb.length() > 0) {
								sb.append(",");
							}
							sb.append(record.getAttribute("companyWorkplaceId"));
						}
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "initServer");
						params.put("workplaceIds", sb.toString());
						params.put("companyNo", companyNo);
						DBDataSource.callOperation("EP_CompanyWorkplaceProcessor", "find", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() < 0) {
									ClientUtil.displayErrorMessage(dsResponse);
								}else {
									SC.say("初始化成功！");
									for(ListGridRecord originalData : records) {
										originalData.setAttribute("hasInit", true);
									}
									resultGrid.redraw();
								}
							}
						});
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
				detail.setTitle("公司工作场所及其服务器配置"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				CompanyWorkplaceAndServerManageViewer detailForm = new CompanyWorkplaceAndServerManageViewer();
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
		criteria.put("addtionalCondition", "order by company_workplace_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new CompanyWorkplaceAndServerManageSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSCompanyWorkplaceAndServerManage.getInstance();
	}


}

