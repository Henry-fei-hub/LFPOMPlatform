package com.pomplatform.client.payment.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
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
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.payment.datasource.DSOnSalaryTotalData;
import com.pomplatform.client.payment.form.OnSalaryTotalDataSearchForm;
import com.pomplatform.client.payment.form.OnSalaryTotalDataViewer;
import com.pomplatform.client.project.form.SettlementPanel;
import com.pomplatform.client.project.panel.StageOfPlanningPanel;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class OnSalaryTotalDataPanel2 extends AbstractSearchPanel
{

	private Window parentWindow;
	private static final Logger __LOGGER = Logger.getLogger("");
	private static boolean canCheck = true;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnSalaryTotalDataPanel2 cm = new OnSalaryTotalDataPanel2();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryTotalData";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowRowNumbers(true);
		resultGrid.setCanEdit(true);
		resultGrid.setShowGridSummary(true);
		canCheck = true;
		__needControl = false;
	}

	@Override
	public void initComponents() {
		
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
				detail.setTitle("工资总表"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnSalaryTotalDataViewer detailForm = new OnSalaryTotalDataViewer();
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
	public void commonQuery() {
		if(!canCheck){
			SC.askforValue("提示","您需输入正确的解锁密码方可查看数据",new ValueCallback() {
				@Override
				public void execute(String value) {
					if(BaseHelpUtils.isNullOrEmpty(value)){
						SC.say("提示","请输入正确的解锁密码");
					}else{
						Map<String,Object> params = new HashMap<>();
						params.put("password",BaseHelpUtils.getString(value));
						params.put("optType","onComparePassword");
						DBDataSource.callOperation("EP_OnPaymentManageProcess","find", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									SC.say("提示","密码匹配错误");
								}else {
									canCheck = true;
									query();
								}
							}
						});
					}
				}
			});
			return;
		}else{
			query();
		}
	}
	
	public void query(){
		Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        if (searchForm != null) {
            searchButton.setIcon("loading38.gif");
        }
        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        final LoadingWindow loading = new LoadingWindow();
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	loading.destroy();
                if (searchForm != null) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                if (dsResponse.getStatus() >= 0) {
                    resultGrid.setData(dsResponse.getData());
                    afterDataReceived(dsResponse.getData());
                    if (isNeedPagenation() && pager != null) {
                        if (currentPage == 1) {
                            totalPages = dsResponse.getAttributeAsInt("totalPages");
                            pager.getTotalPages().setContents(String.valueOf(totalPages));
                        }
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                if (showPagination() && pager != null) {
                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
                }
            }
        });
	}
	
	@Override
	public void afterDataReceived(Record[] data) {
		if(!BaseHelpUtils.isNullOrEmpty(data) && data.length > 0){
			for(Record e : data){
				//获取是否发放
				boolean isSended = e.getAttributeAsBoolean("isSended");
				if(isSended){//如果已发放，则设置为不可用，即不可以进行修改
					e.setAttribute("enabled", false);
				}
			}
		}
	}
	
	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				//获取实付工资
				BigDecimal factSalary = BaseHelpUtils.getBigDecimalValue(record.getAttribute("factSalary"));
				if (factSalary.compareTo(BigDecimal.ZERO) < 0) {
					return "color: red;";
				} else {
					return super.getCellCSSText(record, rowNum, colNum);
				}
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		resultGrid.setShowRowNumbers(true);
		resultGrid.setCanEdit(true);
		resultGrid.setShowGridSummary(true);
		return resultGrid;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("year", year);
		criteria.put("employeeId", employeeId);
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryTotalData.getInstance();
	}
	
	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	private int employeeId;
	private int year;
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	

}

