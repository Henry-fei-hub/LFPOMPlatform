package com.pomplatform.client.aboutprojectquotetemplatesparent.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.aboutprojectquotetemplatesparent.datasource.DSAboutProjectQuoteTemplatesParent;
import com.pomplatform.client.aboutprojectquotetemplatesparent.form.AboutProjectQuoteTemplatesParentSearchForm;
import com.pomplatform.client.project.panel.ProjectQuoteTemplatePanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class AboutProjectQuoteTemplatesParentPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AboutProjectQuoteTemplatesParentPanel cm = new AboutProjectQuoteTemplatesParentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AboutProjectQuoteTemplatesParent";
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
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton newButton = new IButton("新增报价模板");
		controlLayout.addMember(newButton);
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final PopupWindow popupWindow = new PopupWindow("新增报价模板");
				popupWindow.setWidth("60%");
				popupWindow.setHeight("60%");
				AddProjectQuoteTemplatesParentPanel addPanel = new AddProjectQuoteTemplatesParentPanel();
				addPanel.initComponents();
				popupWindow.addItem(addPanel);
				addPanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				addPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
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




		IButton delButton = new IButton("删除");
		delButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record reocrd=resultGrid.getSelectedRecord();
				Map<String,Object> map=reocrd.toMap();
				DBDataSource.callOperation("ST_ProjectQuoteTemplatesParent", "delete", map, new DSCallback(){
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							SC.say("删除成功！");
							commonQuery();
						}
					}
				});
			}
		});
		controlLayout.addMember(delButton);


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
				Record record=resultGrid.getSelectedRecord();
				String parentName=BaseHelpUtils.getString(record.getAttribute("parentName"));
				final PopupWindow popupWindow = new PopupWindow(parentName);
				popupWindow.setWidth("80%");
				popupWindow.setHeight("80%");
				ProjectQuoteTemplatePanel templatePanel = new ProjectQuoteTemplatePanel();
				templatePanel.setRecord(record);
				templatePanel.commonQuery();
				popupWindow.addItem(templatePanel);
				templatePanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				templatePanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by project_quote_templates_parent_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new AboutProjectQuoteTemplatesParentSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSAboutProjectQuoteTemplatesParent.getInstance();
	}


	public int getSearchFormHeight() {
		return 120;
	}

}

