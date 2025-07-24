package com.pomplatform.client.sealkeepers.panel;

import java.math.BigDecimal;
import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.pomplatform.client.sealkeepers.form.AddRankForm;
import com.smartgwt.client.bean.types.DateValueType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
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
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.sealkeepers.datasource.DSRankMaintenance;
import com.pomplatform.client.sealkeepers.form.RankMaintenanceSearchForm;
import com.pomplatform.client.sealkeepers.form.RankMaintenanceViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RankMaintenancePanel extends AbstractSearchPanel
{

	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			RankMaintenancePanel cm = new RankMaintenancePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "RankMaintenance";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		//设置多选属性
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
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

		IButton rankButton = new IButton("系数维护");
		controlLayout.addMember(rankButton);
		rankButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				if (!resultGrid.anySelected()) {
					SC.say("提示", "请至少选择一条数据进行系数维护");
					return;
				}
				SC.askforValue("请输入维护比例", new ValueCallback() {
					@Override
					public void execute(String s) {
						if (!BaseHelpUtils.isNullOrEmpty(s)) {
							BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(s);
							if (bigDecimalValue.compareTo(BigDecimal.ZERO) <= 0) {
								SC.say("请输入大于的0的数据格式");
								return;
							}
							ListGridRecord[] selectedRecords = resultGrid.getSelectedRecords();
							Map<String, Object> params = new HashMap<>();
							params.put("opt_type", "rankMaintenance");
							params.put("rate", s);
							params.put("lists", selectedRecords);
							DBDataSource.callOperation("EP_ProjectCommonProcess", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										SC.say("提示", "保存成功");
										commonQuery();
									} else {
										SC.say("提示", dsResponse.getErrors().get("errorMsg").toString());
									}
								}
							});
						}
					}
				});
			}
		});

		//新增职级并且维护系数
		IButton addRank = new IButton("新增职级");
		controlLayout.addMember(addRank);
		addRank.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				PopupWindow popupWindow = new PopupWindow();
				popupWindow.setTitle("新增职级");
				popupWindow.setWidth("25%");
				popupWindow.setHeight("30%");
				popupWindow.centerInPage();
				AddRankForm addRankForm = new AddRankForm();
				addRankForm.onModuleLoad();
				addRankForm.setParentWindow(popupWindow);
				addRankForm.setParentPanel(new RankMaintenancePanel());
				popupWindow.addMember(addRankForm);
				popupWindow.show();

			}
		});

		IButton deleteButton = new IButton("删除职级");
		controlLayout.addMember(deleteButton);
		deleteButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择需要删除的数据");
					return;
				}
				SC.ask("是否删除数据", new BooleanCallback() {
					@Override
					public void execute(Boolean aBoolean) {
						if (aBoolean) {
							Map<String, Object> params = new HashMap<>();
							ListGridRecord[] selectedRecords = resultGrid.getSelectedRecords();
							params.put("list", selectedRecords);
							params.put("opt_type", "deleteRank");
							DBDataSource.callOperation("EP_ProjectCommonProcess", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										SC.say("删除成功");
										commonQuery();
									} else {
										SC.say(dsResponse.getErrors().get("errorMsg").toString());
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

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new RankMaintenanceSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSRankMaintenance.getInstance();
	}


}

