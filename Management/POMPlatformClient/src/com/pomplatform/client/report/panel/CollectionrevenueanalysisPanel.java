package com.pomplatform.client.report.panel;

import java.util.Date;
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
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.report.datasource.DSCollectionrevenueanalysis;
import com.pomplatform.client.report.form.CollectionrevenueanalysisSearchForm;
import com.pomplatform.client.report.form.CollectionrevenueanalysisViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CollectionrevenueanalysisPanel extends AbstractSearchPanel
{

	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			CollectionrevenueanalysisPanel cm = new CollectionrevenueanalysisPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Collectionrevenueanalysis";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setHeaderHeight(45);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("合计", new String[] {"total","totalAmount","str"}),
				   new HeaderSpan("1月", new String[] {"januaryRevenue","januaryAmount","str1"}),
				   new HeaderSpan("2月", new String[] {"februaryRevenue","februaryAmount","str2"}),
				   new HeaderSpan("3月", new String[] {"marchRevenue","marchAmount","str3"}),
				   new HeaderSpan("4月", new String[] {"aprilRevenue","aprilAmount","str4"}),
				   new HeaderSpan("5月", new String[] {"mayRevenue","mayAmount","str5"}),
				   new HeaderSpan("6月", new String[] {"juneRevenue","juneAmount","str6"}),
				   new HeaderSpan("7月", new String[] {"julyRevenue","julyAmount","str7"}),
				   new HeaderSpan("8月", new String[] {"augustRevenue","augustAmount","str8"}),
				   new HeaderSpan("9月", new String[] {"septemberRevenue","septemberAmount","str9"}),
				   new HeaderSpan("10月", new String[] {"octoberRevenue","octoberAmount","str10"}),
				   new HeaderSpan("11月", new String[] {"novemberRevenue","novemberAmount","str11"}),
				   new HeaderSpan("12月", new String[] {"decemberRevenue","decemberAmount","str12"})
			    });	
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		/*resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
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
		controlLayout.addMember(viewButton);*/
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
				detail.setTitle("Collectionrevenueanalysis"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				CollectionrevenueanalysisViewer detailForm = new CollectionrevenueanalysisViewer();
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
		int year = BaseHelpUtils.getIntValue(criteria.get("year"));
		if(year>0) {
			criteria.put("yearStr", year+"");
		}
		SC.debugger();
		String plateIds = PomPlatformClientUtil.getRolePlateId();
		String[] plateIdArr = plateIds.split(",");
		
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.COLLECTION_REVENUE_CHECK_ALL_DATA)) {
			return true;
		} else if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.COLLECTION_REVENUE_CHECK_ALL_DATA)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.COLLECTION_REVENUE_CHECK_MYSELF_DATA)) {
			/*
			 * 只拥有查看自己部门数据的权限 ①用户是否在部门选择下拉框选择了某一个部门想进行信息查看？ ②Y:用户是否拥有该部门的数据查看权限？
			 * →有权限：返回true； 没有权限：返回false ③N:默认加载该用户所可以查看的所有部门的信息
			 */
			/*if(BaseHelpUtils.isNullOrEmpty(plateIds)||BaseHelpUtils.isNullOrEmpty(plateIdArr)||plateIdArr.length<=0) {
				SC.warn("提示", "部门数据获取失败或缺少查看部门数据的权限");
				return false;
			}*/
			String selectPlateId = BaseHelpUtils.getString(criteria.get("plateId"));
			if (BaseHelpUtils.isNullOrEmpty(selectPlateId)) {
				criteria.put("plateId", plateIdArr[0]);
				return true;
			}else {
				for (String string : plateIdArr) {
					if(string.equals(selectPlateId)) {
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
		return new CollectionrevenueanalysisSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSCollectionrevenueanalysis.getInstance();
	}

	public int getSearchFormHeight() {
		return 60;
	}

	
	
}

