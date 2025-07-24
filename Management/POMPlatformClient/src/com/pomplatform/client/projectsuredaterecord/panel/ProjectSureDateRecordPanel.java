package com.pomplatform.client.projectsuredaterecord.panel;

import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.projectsuredaterecord.datasource.DSProjectSureDateRecord;
import com.pomplatform.client.projectsuredaterecord.form.ProjectSureDateRecordSearchForm;
import com.pomplatform.client.projectsuredaterecord.form.ProjectSureDateRecordViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class ProjectSureDateRecordPanel extends AbstractSearchPanel
{
	private String plateIds;
	private String[] plateIdArr;

	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ProjectSureDateRecordPanel cm = new ProjectSureDateRecordPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectSureDateRecord";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		plateIds = PomPlatformClientUtil.getRolePlateId();
		plateIdArr = plateIds.split(",");
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("项目进度表"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ProjectSureDateRecordViewer detailForm = new ProjectSureDateRecordViewer();
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
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		// 如果拥有查看所有部门数据，则加载所有数据
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REVENUE_PROJECT_PROGRESS_CHECK_ALL_DATA)) {
			return true;
		} else if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.REVENUE_PROJECT_PROGRESS_CHECK_ALL_DATA)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.REVENUE_PROJECT_PROGRESS_CHECK_MYSELF_DATA)) {
			/*
			 * 只拥有查看自己部门数据的权限 ①用户是否在部门选择下拉框选择了某一个部门想进行信息查看？ ②Y:用户是否拥有该部门的数据查看权限？
			 * →有权限：返回true； 没有权限：返回false ③N:默认加载该用户所可以查看的所有部门的信息
			 */
			String selectPlateId = BaseHelpUtils.getString(criteria.get("plateId"));
			if (BaseHelpUtils.isNullOrEmpty(selectPlateId)) {
				criteria.put("plateId", plateIds);
				return true;
			} else {
				for (String str : plateIdArr) {
					if (selectPlateId.equals(str)) {
						return true;
					}
				}
			}
		}
		SC.warn("提示", "您没有查看该部门数据的权限");
		return false;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ProjectSureDateRecordSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectSureDateRecord.getInstance();
	}


}

