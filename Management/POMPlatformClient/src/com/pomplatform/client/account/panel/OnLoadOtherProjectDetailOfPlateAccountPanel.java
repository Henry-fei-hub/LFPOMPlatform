package com.pomplatform.client.account.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.account.datasource.DSOnLoadOtherProjectDetailOfPlateAccount;
import com.pomplatform.client.account.form.OnLoadOtherProjectDetailOfPlateAccountSearchForm;
import com.pomplatform.client.account.form.OnLoadOtherProjectDetailOfPlateAccountViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class OnLoadOtherProjectDetailOfPlateAccountPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadOtherProjectDetailOfPlateAccountPanel cm = new OnLoadOtherProjectDetailOfPlateAccountPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadOtherProjectDetailOfPlateAccount";
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
		
		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					BigDecimal integral = BigDecimal.ZERO;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("sheetName"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						integral = integral.add(new BigDecimal(recordList[i].getAttribute("integral")));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("sheetName", "汇总");
					record.setAttribute("integral", integral);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}

			}
		});
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
				detail.setTitle("其它项目"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnLoadOtherProjectDetailOfPlateAccountViewer detailForm = new OnLoadOtherProjectDetailOfPlateAccountViewer();
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
		if(plateId>0)criteria.put("plateId", plateId);
		if(businessTypeId>0)criteria.put("businessTypeId", businessTypeId);
		if(year>0)criteria.put("year", year);
		if(month>0)criteria.put("month", month);
		//如果是管理项目，则改变sql语句
		if(businessTypeId == PlateAccountDesignPanel.PLATE_BT_MANAGE_PROJECT){//说明是管理项目
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "and c.project_flag = 2");
			kv.put("value", "and c.project_flag = 3");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadOtherProjectDetailOfPlateAccountSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadOtherProjectDetailOfPlateAccount.getInstance();
	}

	private int plateId;
	private int businessTypeId;
	private int year;
	private int month;
	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}

	public int getBusinessTypeId() {
		return businessTypeId;
	}

	public void setBusinessTypeId(int businessTypeId) {
		this.businessTypeId = businessTypeId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

}

