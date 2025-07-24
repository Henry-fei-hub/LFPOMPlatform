package com.pomplatform.client.financialstatements.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.financialstatements.datasource.DSScapitalipcor;
import com.pomplatform.client.financialstatements.form.ScapitalipcorViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class ScapitalipcorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ScapitalipcorPanel cm = new ScapitalipcorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Scapitalipcor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
		ListGridField [] fields = new ListGridField[3];
		int index = 0;
		fields[index] = new ListGridField("contractId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("contractCode");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("borrowMoney");
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
		// IButton refreshButton = new IButton("刷新");
		// controlLayout.addMember(refreshButton);
		// refreshButton.setIcon("[SKIN]/actions/refresh.png");
		// refreshButton.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// commonQuery();
		// }
		// });
		//
		// resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
		// @Override
		// public void onDoubleClick(DoubleClickEvent event) {
		// showDetail();
		// }
		// });
		// IButton viewButton = new IButton("查看详细");
		// viewButton.addClickHandler(new ClickHandler(){
		// @Override
		// public void onClick(ClickEvent event) {
		// showDetail();
		// }
		// });
		// controlLayout.addMember(viewButton);
		// commonQuery();
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
				detail.setTitle("Scapitalipcor");
				detail.setWidth100();
				detail.setHeight100();
				ScapitalipcorViewer detailForm = new ScapitalipcorViewer();
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
		criteria.put("selfName", getCompanyId());
		criteria.put("moneyAttribute", 1);
		criteria.put("addtionalCondition", "order by capital_id");
		criteria.put("minHappenDate", getMinHappenDate());
		criteria.put("maxHappenDate", getMaxHappenDate());
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		// return new ScapitalipcorSearchForm();
		return null;
	}
	
	@Override
	public DataSource getDataSource() {
		return DSScapitalipcor.getInstance();
	}

	private Integer companyId;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	private Date minHappenDate;
	
	private Date maxHappenDate;

	public Date getMinHappenDate() {
		return minHappenDate;
	}

	public void setMinHappenDate(Date minHappenDate) {
		this.minHappenDate = minHappenDate;
	}

	public Date getMaxHappenDate() {
		return maxHappenDate;
	}

	public void setMaxHappenDate(Date maxHappenDate) {
		this.maxHappenDate = maxHappenDate;
	}

}
