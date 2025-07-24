package com.pomplatform.client.report.panel;

import java.util.*;

import com.pomplatform.client.ERPPermissionStatic;
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
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.report.datasource.DSCooperateStatisticsTotal;
import com.pomplatform.client.report.form.CooperateStatisticsTotalSearchForm;
import com.pomplatform.client.report.form.CooperateStatisticsTotalViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.logging.Logger;

public class CooperateStatisticsTotalPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			CooperateStatisticsTotalPanel cm = new CooperateStatisticsTotalPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CooperateStatisticsTotal";
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
		IButton exportDeCon=new IButton("导出");
		exportDeCon.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> param  = generateCriteria();
				DBDataSource.downloadFile("DW_CooperateStatisticsTotal",param);
			}
		});
		controlLayout.addMember(exportDeCon);
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
				detail.setTitle("配合统计表");
				detail.setWidth100(); 
				detail.setHeight100(); 
				CooperateStatisticsTotalViewer detailForm = new CooperateStatisticsTotalViewer();
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
		Map<String, String> kv = new HashMap<>();
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.COOPERATE_STATISTICS_QUERY_ALL)) {
		} else if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.COOPERATE_STATISTICS_QUERY_ALL)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.COOPERATE_STATISTICS_QUERY_DEPARTNENT)) {
			kv.put("key", "order by start_date");
			kv.put("value", "AND pb.type in (select pr.plate_id from plate_records pr where pr.plate_name in(SELECT d.department_name from departments  d where d.department_id in ((select dd.department_id from employee_roles dd where  dd.role_id =47  and dd.employee_id = "+ClientUtil.getUserId()+" )))) order by start_date desc");
			keyvalues.add(kv);
		} else {
			kv.put("key", "order by start_date");
			kv.put("value", "AND pb.drafter = "+ClientUtil.getUserId()+" order by start_date desc");
			keyvalues.add(kv);
		}
		criteria.put("keyValues",keyvalues);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new CooperateStatisticsTotalSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSCooperateStatisticsTotal.getInstance();
	}


}

