package com.pomplatform.client.operation.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.PaginationPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.CommonFormat;
import com.pomplatform.client.common.SetProjectAppendIntegral;
import com.pomplatform.client.operation.datasource.DSProjectManager;
import com.pomplatform.client.operation.form.NewProjectManagerForm;
import com.pomplatform.client.operation.form.ProjectManagerSearchForm;
import com.pomplatform.client.operation.form.ProjectManagerViewer;
import com.pomplatform.client.operation.form.UpdateProjectManagerForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectManagerPanel1 extends AbstractSearchPanel {
	private static final Logger __logger = Logger.getLogger("");
	private DynamicForm __infoForm;
	private TextItem totalItem;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ProjectManagerPanel1 cm = new ProjectManagerPanel1();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectManager";
		}
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton operation2Button = PermissionControl.createPermissionButton("项目立项",
				ERPPermissionStatic.OPERATE_MANAGE_PROJECT_PROJECT_BUTTON);
		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						// 获取当前项目的部门经理板块id
						int plateId = ClientUtil
								.checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATOR_PLATEID_COOKIE));
						if (plateId == 0) {// 当前立项的运行管理员没有设置板块，不可进行立项操作
							SC.say("提示", "当前立项的运行管理员没有设置板块，不可进行立项操作,请先设置板块");
							return;
						}
						NewProjectManagerForm detailForm = new NewProjectManagerForm();
						detailForm.setTitle("项目立项");
						detailForm.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								RecordList list = resultGrid.getDataAsRecordList();
								RecordList newList = new RecordList();
								newList.addList(list.getRange(0, list.getLength()));
								newList.add(event.getData());
								resultGrid.setData(newList);
								resultGrid.selectSingleRecord(newList.getLength() - 1);
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
		IButton operation3Button = PermissionControl.createPermissionButton("修改项目",
				ERPPermissionStatic.OPERATE_MANAGE_PROJECT_UPDATE_BUTTON);
		controlLayout.addMember(operation3Button);
		operation3Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据修改");
							return;
						}
						ListGridRecord[] selected = resultGrid.getSelectedRecords();
						UpdateProjectManagerForm detailForm = new UpdateProjectManagerForm();
						detailForm.setTitle("修改项目");
						detailForm.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								RecordList list = resultGrid.getDataAsRecordList();
								Map params = new HashMap();
								params.put("projectId", event.getData().getAttribute("projectId"));
								int index = list.findIndex(params);
								if (index != -1) {
									RecordList newList = new RecordList();
									if (index > 0) {
										newList.addList(list.getRange(0, index));
									}
									newList.add(event.getData());
									if (index < list.getLength() - 1) {
										newList.addList(list.getRange(index + 1, list.getLength()));
									}
									resultGrid.setData(newList);
									resultGrid.selectSingleRecord(index);
								}
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected[0]);
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

		final IButton operation4Button = PermissionControl.createPermissionButton("项目移除",
				ERPPermissionStatic.OPERATE_MANAGE_PROJECT_DELETE_BUTTON);
		controlLayout.addMember(operation4Button);
		operation4Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("提示", "请选择一条数据修改");
							return;
						}
						SC.confirm("提示", "您确定要删除该项目吗？", new BooleanCallback() {
							@Override
							public void execute(Boolean value) {
								if (value) {
									ListGridRecord[] selected = resultGrid.getSelectedRecords();
									String projectId = selected[0].getAttribute("projectId");
									Map param = new LinkedHashMap();
									param.put("projectId", projectId);
									String message = MapUtils.toJSON(param);
									// 删除方法
									DBDataSource.callOperation("EP_ProjectDelete", "delete", message, new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() >= 0) {
												// SC.say("操作成功");
												// 执行成功后重新执行查询，刷新表格数据
												commonQuery();
											} else {
												Map errors = dsResponse.getErrors();
												SC.say("删除失败" + errors);
											}
										}
									});
								}
							}
						});
					}
				});
			}
		});

		IButton operation6Button = PermissionControl.createPermissionButton("追加积分",
				ERPPermissionStatic.OPERATE_MANAGE_PROJECT_ADDITIONAL_INTEGRATION_BUTTON);
		controlLayout.addMember(operation6Button);
		operation6Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据修改");
							return;
						}
						ListGridRecord[] selected = resultGrid.getSelectedRecords();
						int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
						double totalIntegral = ClientUtil
								.checkAndGetDoubleValue(selected[0].getAttribute("totalIntegral"));// 项目总积分
						double projectIntegral = ClientUtil
								.checkAndGetDoubleValue(selected[0].getAttribute("projectIntegral"));// 项目积分
						double reserveIntegral = ClientUtil
								.checkAndGetDoubleValue(selected[0].getAttribute("reserveIntegral"));// 预留积分
						double appendTotalIntegral = ClientUtil
								.checkAndGetDoubleValue(selected[0].getAttribute("appendTotalIntegral"));// 追加总积分
						int appendIntegral = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("appendIntegral"));// 追加积分
						if (appendIntegral <= 0) {
							SC.say("该项目没有追加的积分，不可继续追加");
							return;
						}
						String remark = selected[0].getAttribute("remark");// 备注
						String projectName = selected[0].getAttribute("projectName");// 备注
						PopupWindow popupWindow = new PopupWindow("项目审核");
						popupWindow.setWidth("50%");
						popupWindow.setHeight("60%");
						popupWindow.centerInPage();
						SetProjectAppendIntegral audit = new SetProjectAppendIntegral();
						audit.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						audit.initComponents(Boolean.TRUE, projectName, projectId, totalIntegral, projectIntegral,
								reserveIntegral, appendTotalIntegral, appendIntegral, remark);
						popupWindow.addItem(audit);
						audit.setParentWindow(popupWindow);
						popupWindow.centerInPage();
						popupWindow.show();
					}
				});
			}
		});
		commonQuery();
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		int plateId = ClientUtil.getPlateId();
		if (plateId == 1) {// 如果是商业板块的板块运营负责人，则可以看杰加商业板块的数据
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "order by p.project_id desc");
			kv.put("value", " and (p.plate_id =1 or p.plate_id =8) order by p.project_id desc");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		} else {
			criteria.put("plateId", plateId);
		}
		return true;
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
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("项目管理");
				detail.setWidth100();
				detail.setHeight100();
				ProjectManagerViewer detailForm = new ProjectManagerViewer();
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
	public Canvas getViewPanel() {
		searchForm = generateSearchForm();
		VLayout layout = new VLayout();
		layout.setWidth100();
		layout.setHeight100();
		layout.setBackgroundColor("#e2e2e2");

		if (searchForm != null) {
			ClientUtil.searchFormProcessAccordingToDevice(searchForm);
			if (getSearchFormHeight() > 0) {
				searchForm.setHeight(getSearchFormHeight());
			}
			HLayout searchLayout = new HLayout(5);
			searchLayout.setMargin(10);
			layout.addMember(searchLayout);

			searchForm.setWidth100();
			searchLayout.addMember(searchForm);

			VLayout buttonLayout = new VLayout(5);
			searchButton = new IButton("搜索");
			searchButton.setIcon("[SKIN]/actions/search.png");

			IButton resetButton = new IButton("重置");
			resetButton.setIcon("[SKIN]/actions/redo.png");

			buttonLayout.addMember(searchButton);
			buttonLayout.addMember(resetButton);

			searchLayout.addMember(buttonLayout);

			searchButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					currentPage = 1;
					commonQuery();
				}
			});

			resetButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					searchForm.editNewRecord();
				}
			});
		}
		VLayout resultLayout = new VLayout();
		resultLayout.setWidth100();
		resultLayout.setHeight100();

		HLayout dataLayout = new HLayout();
		dataLayout.setHeight100();
		dataLayout.setWidth100();
		resultLayout.addMember(dataLayout);

		resultGrid = new DelicacyListGrid();
		resultGrid.setDataSource(getDataSource());

		__infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight("8%");
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		totalItem = new TextItem("汇总");
		totalItem.setCanEdit(false);
		totalItem.setWidth("*");

		__infoForm.setFields(totalItem);

		VLayout newLayout = new VLayout();
		newLayout.addMember(resultGrid);
		newLayout.addMember(__infoForm);

		dataLayout.addMember(newLayout);
		if (showControlPanel()) {
			controlLayout = new VLayout();
			controlLayout.setHeight100();
			controlLayout.setLayoutTopMargin(30);
			controlLayout.setLayoutLeftMargin(5);
			controlLayout.setLayoutRightMargin(5);
			controlLayout.setMembersMargin(10);

			dataLayout.addMember(controlLayout);
		}

		layout.addMember(resultLayout);

		if (Browser.getIsDesktop() && showPagination()) {
			pager = new PaginationPanel();
			resultLayout.addMember(pager);

			pager.getGotoButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					TextItem item = pager.getGotoPage();
					String strPageNo = item.getValueAsString();
					if (strPageNo == null || strPageNo.equals("")) {
						return;
					}
					currentPage = Integer.parseInt(strPageNo);
					commonQuery();
				}
			});
			pager.getFirstButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					currentPage = 1;
					commonQuery();
				}
			});
			pager.getPreviousButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (currentPage > 1) {
						currentPage--;
						commonQuery();
					}
				}
			});
			pager.addKeyPressHandler(new KeyPressHandler() {

				@Override
				public void onKeyPress(KeyPressEvent event) {
					if (event.getKeyName() != null) {
						switch (event.getKeyName()) {
						case "Arrow_Right":
							if (currentPage < totalPages) {
								currentPage++;
								commonQuery();
							}
							break;
						case "Arrow_Left":
							if (currentPage > 1) {
								currentPage--;
								commonQuery();
							}
							break;
						}
					}
				}
			});
			pager.getNextButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (currentPage < totalPages) {
						currentPage++;
						commonQuery();
					}
				}
			});
			pager.getLastButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (totalPages > 0) {
						currentPage = totalPages;
						commonQuery();
					}
				}
			});
			pager.getRefreshButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					commonQuery();
				}
			});
		}
		initComponents();
		if (showControlPanel()) {
			setControlLayoutWidth();
		}
		return layout;
	}

	@Override
	public void commonQuery() {
		Map condition = generateCriteria();
		if (condition == null) {
			return;
		}
		if (searchForm != null) {
			searchButton.setIcon("loading38.gif");
		}
		DBDataSource ds = (DBDataSource) getDataSource();
		String operationName = ds.getActionMode() + ds.getActionName();
		DBDataSource.callOperation(operationName, condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (searchForm != null) {
					searchButton.setIcon("[SKIN]/actions/search.png");
				}
				double totalIntegral = 0;// 项目总积分汇总
				double projectIntegral = 0;// 项目积分
				double reserveIntegral = 0;// 预留积分
				if (dsResponse.getStatus() >= 0) {
					Record[] record = dsResponse.getData();
					for (Record e : record) {
						totalIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("totalIntegral"));
						projectIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("projectIntegral"));
						reserveIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("reserveIntegral"));
					}
					totalItem.setValue("项目总积分:" + CommonFormat.doubleFormat(totalIntegral) + "   项目积分:"
							+ CommonFormat.doubleFormat(projectIntegral) + "   预留积分:"
							+ CommonFormat.doubleFormat(reserveIntegral));
					resultGrid.setData(record);
					afterDataReceived(dsResponse.getData());
					if (showPagination()) {
						if (currentPage == 1) {
							totalPages = dsResponse.getAttributeAsInt("totalPages");
							pager.getTotalPages().setContents(String.valueOf(totalPages));
						}
					}
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
				if (showPagination()) {
					pager.getCurrentPage().setContents(String.valueOf(currentPage));
				}
			}
		});
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ProjectManagerSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectManager.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 126;
	}

}
