package com.pomplatform.client.shift.form;

import java.util.*;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.shift.datasource.DSSEmployeeDayCheck;
import com.pomplatform.client.shift.datasource.DSSEmployeeMonthCheck;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class EmployeeMonthCheckViewer extends AbstractDetailViewer {

	private SearchForm __parentSearchForm;
	private final DelicacyListGrid detail = new DelicacyListGrid();
	private VLayout buttonLayout;
	private IButton lockButton;
	private static final Logger __logger = Logger.getLogger("");

	public EmployeeMonthCheckViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		
		detail.setCanEdit(true);
		detail.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map<String,Object> params = detail.getRecord(event.getRowNum()).toMap();
				DBDataSource.callOperation("ST_EmployeeDayCheck", "saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
						}
					}
				});
			}
		});
		
		buttonLayout = new VLayout();
		buttonLayout.setWidth("5%");
		buttonLayout.setHeight100();
		buttonLayout.setLayoutTopMargin(30);
		buttonLayout.setMembersMargin(10);
		
		lockButton = new IButton("加锁");
		buttonLayout.addMember(lockButton);
		
		lockButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> map = new HashMap<>();
				map.put("employeeId", employeeId);
				map.put("year", year);
				map.put("month", month);
				map.put("optType", "onLockCheckData");
				DBDataSource.callOperation("EP_OnShiftManageProcess", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.say("加锁成功");
							loadDetailGridData();
						}
					}
				});
			}
		});
		
		IButton deleteButton = new IButton("删除");
		buttonLayout.addMember(deleteButton);
		deleteButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!detail.anySelected()){
					SC.say("请选择一条数据");
					return;
				}
				SC.ask("确认删除该条数据吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							Map<String,Object> param = detail.getSelectedRecord().toMap();
							DBDataSource.callOperation("ST_EmployeeDayCheck", "delete", param, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										SC.say("删除成功");
										loadDetailGridData();
									}
								}
							});
						}
					}
				});
				
			}
		});
		
		
		IButton sumMonthButton = new IButton("月统计");
		buttonLayout.addMember(sumMonthButton);
		sumMonthButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> map = new HashMap<>();
				map.put("employeeId", employeeId);
				map.put("year", year);
				map.put("month", month);
				map.put("optType", "onCheckMonthData");
				DBDataSource.callOperation("EP_OnShiftManageProcess", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.say("统计成功");
							viewSelectedData(new ListGrid());
						}
					}
				});
			}
		});
		
		addMember(buttonLayout);
		
	}

	//加载grid数据,把已加锁数据设为不可编辑
	public void loadDetailGridData(){
		Map<String,Object> params = new HashMap<>();
		params.put("employeeId", employeeId);
		params.put("year", year);
		params.put("month", month);
		params.put("optType", "onEmployeeDayChecks");
		DBDataSource.callOperation("EP_OnShiftManageProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				Record[] record = dsResponse.getData();
				if(!BaseHelpUtils.isNullOrEmpty(record)){
					for(Record e : record){
						if(e.getAttributeAsBoolean("isLocked") == Boolean.TRUE){
							e.setAttribute("enabled", false);
						}
					}


					detail.setData(record);
				}
			}
		});
	}
	
	
	@Override
	public int getHorizontalPercent() {
		return 37;
	}

	@Override
	public String getName() {
		return "本月考勤汇总";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<>();
		return gcs;
	}

	@Override
	public void viewSelectedData(ListGrid grid) {
		for (DetailViewer view : detailViewers) {
			Map<String,Object> map = new HashMap<>();
			List<Map> keyvalues = new ArrayList<>();
	    	Map<String, String> kv = new HashMap<>();
	    	kv.put("key", "employee_day_checks");
	    	kv.put("value", "employee_month_checks");
	    	keyvalues.add(kv);
	    	map.put("keyValues", keyvalues);
			map.put("employeeId", employeeId);
			map.put("year", year);
			map.put("month", month);
			DBDataSource.callOperation("NQ_OnLoadEmployeeMonthCheck", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						view.setData(dsResponse.getData());
					}
				}
			});
		}
	}

	@Override
	public DataSource getMainDataSource() {
		return DSSEmployeeMonthCheck.getInstance();
	}

	@Override
	public int getDetailCount() {
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<>();
		detail.setDataSource(DSSEmployeeDayCheck.getInstance());
		res.add(detail);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<>();
		res.add("考勤明细");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm(SearchForm value) {
		this.__parentSearchForm = value;
	}
	
	private int employeeId;
	private int year;
	private int month;

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

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
}
