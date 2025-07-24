package com.pomplatform.client.cdcmanage.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.cdcmanage.datasource.DSMainProjectEmployee;
import com.pomplatform.client.cdcmanage.datasource.DSSmainprojectpppor;
import com.pomplatform.client.cdcmanage.form.SmainprojectppporSearchForm;
import com.pomplatform.client.cdcmanage.form.SmainprojectppporViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class SmainprojectppporPanel extends AbstractExpansionRelatedPage {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SmainprojectppporPanel cm = new SmainprojectppporPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Smainprojectpppor";
		}

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

		// resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
		// @Override
		// public void onDoubleClick(DoubleClickEvent event) {
		// showDetail();
		// }
		// });
		// IButton viewButton = new IButton("查看详细");
		// viewButton.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// showDetail();
		// }
		// });
		// controlLayout.addMember(viewButton);
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
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("项目查询");
				detail.setWidth100();
				detail.setHeight100();
				SmainprojectppporViewer detailForm = new SmainprojectppporViewer();
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
		if(criteria.containsKey("onlyCDC") && BaseHelpUtils.getBoolean(criteria.get("onlyCDC"))) {
			List<Map<String, Object>> keyvalues = new ArrayList<>();
			Map<String, Object> kv = new HashMap<>();
			kv.put("key", "ORDER BY mp.project_approval_time DESC");
			kv.put("value", " and mp.info_code in (select info_code from pre_projects where create_time >= '2019-03-12 12:30:00') ORDER BY mp.project_approval_time DESC");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SmainprojectppporSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSmainprojectpppor.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSMainProjectEmployee.getInstance();
	}

}
