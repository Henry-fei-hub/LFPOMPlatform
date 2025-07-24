package com.pomplatform.client.projectreportrecorddetail.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.projectreportrecorddetail.datasource.DSProjectBuyCosts;
import com.pomplatform.client.projectreportrecorddetail.form.ChangeBuyIntegralPanel;
import com.pomplatform.client.projectreportrecorddetail.form.ProjectBuyCostsSearchForm;
import com.pomplatform.client.projectreportrecorddetail.form.ProjectBuyCostsViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ProjectBuyCostsPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ProjectBuyCostsPanel cm = new ProjectBuyCostsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectBuyCosts";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[7];
		int idx = 0;
		fields[idx] = new ListGridField("contractCode");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("contractName");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("projectManageId","项目经理");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("status");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("totalIntegral");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("costIntegral");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("leftIntegral");
		resultGrid.setDataSource(DSProjectBuyCosts.getInstance());
		resultGrid.setFields(fields);
		
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
		
		IButton changeButton = new IButton("额度调整");
		controlLayout.addMember(changeButton);
		changeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record record = resultGrid.getSelectedRecord();
				//项目状态为结项才可以调整额度给别的订单
				int status = ClientUtil.checkAndGetIntValue(record.getAttribute("status"));
				BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("leftIntegral"));
				if(status != 11){
					SC.say("该项目未结束，无法调整额度");
					return;
				}
				if(leftIntegral.compareTo(BigDecimal.ZERO) <= 0){
					SC.say("订单剩余额度小于等于0，无法调整额度");
					return;
				}
				Map<String,Object> map = new HashMap<>();
				String projectName = record.getAttribute("projectName");
				map.put("fromProjectId", record.getAttribute("projectId"));
				map.put("contractCode", record.getAttribute("contractCode"));
				map.put("projectName", projectName);
				map.put("leftIntegral", record.getAttribute("leftIntegral"));
				PopupWindow window = new PopupWindow();
				window.setWidth("70%");
				window.setHeight("70%");
				window.setTitle("订单 "+projectName+" 的额度调整");
				ChangeBuyIntegralPanel panel = new ChangeBuyIntegralPanel();
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				panel.initComponents(map);
				panel.load();
				window.addItem(panel);
				window.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						window.destroy();
						commonQuery();
					}
				});
				panel.setParentWindow(window);
				window.centerInPage();
				window.show();
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
				Record record = resultGrid.getSelectedRecord();
				String contractName = record.getAttribute("contractName");
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("项目("+contractName+")的相关信息"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ProjectBuyCostsViewer detailForm = new ProjectBuyCostsViewer();
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
		criteria.put("addtionalCondition", "order by project_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ProjectBuyCostsSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectBuyCosts.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

}

