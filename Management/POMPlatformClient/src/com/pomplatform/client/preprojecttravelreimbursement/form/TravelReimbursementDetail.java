package com.pomplatform.client.preprojecttravelreimbursement.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.workflow.commonTravelReimbursement.form.TravelReimbursementLinkDepartmentDetail;
import com.pomplatform.client.workflow.form.TravelReimbursementDetailPanel;
import com.pomplatform.client.workflow.projectTravelReimbursement.datasource.DSTravelReimbursementDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;

public class TravelReimbursementDetail extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private AbstractWizadPage mainInfoPage;
	private TravelReimbursementLinkDepartmentDetail departmentPanel;
	
	public TravelReimbursementDetail(){

		__dataGrid = grid;
		HLayout travelReimbursementDetails = new HLayout();
		travelReimbursementDetails.setWidth100();
		travelReimbursementDetails.setHeight100();
		ListGridField[] fields = new ListGridField[14];
		int idx = 0;
		fields[idx] = new ListGridField("startDate");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("endDate");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("startAddress");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("arrivingAddress");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("travelDays");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("airfare");
		idx++;
		fields[idx] = new ListGridField("carBoatFee");
		idx++;
		fields[idx] = new ListGridField("cityTransportation");
		idx++;
		fields[idx] = new ListGridField("shippingFee");
		idx++;
		fields[idx] = new ListGridField("accommodationFee");
		idx++;
		fields[idx] = new ListGridField("drivingFee");
		idx++;
		fields[idx] = new ListGridField("travelAllowance");
		idx++;
		fields[idx] = new ListGridField("sum");
		idx++;
		fields[idx] = new ListGridField("remark");
		fields[idx].setShowGridSummary(false);
		grid.setHeaderHeight(60); 
		grid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("前期项目差旅报销费用清单", new String[] {"startDate","endDate","startAddress","arrivingAddress","travelDays","airfare","carBoatFee","cityTransportation","shippingFee","accommodationFee","drivingFee","travelAllowance","sum","remark"})
	    });
		grid.setFields(fields);
		grid.setShowGridSummary(true);
		grid.setCanEdit(false);
		grid.setDataSource(DSTravelReimbursementDetail.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				if(null != departmentPanel){
					int rowNum = event.getRowNum();
					BigDecimal amount = BigDecimal.ZERO;
					ListGridRecord[] data = grid.getRecords();
					int i = 0;
					for (ListGridRecord r : data) {
						if (i != rowNum && null != r.getAttribute("sum")) {
							amount = amount.add(new BigDecimal(r.getAttribute("sum")));
						}
						i++;
					}
					departmentPanelInfoChange(amount);
				}
				EditCompleteEvent editCompleteEvent = new EditCompleteEvent(null);
				grid.fireEvent(editCompleteEvent);
			}
		});
		travelReimbursementDetails.addMember(grid);
		VLayout travelReimbursementDetailsControls = new VLayout();
		travelReimbursementDetailsControls.setHeight100();
		travelReimbursementDetailsControls.setWidth(60);
		travelReimbursementDetailsControls.setLayoutTopMargin(30);
		travelReimbursementDetailsControls.setLayoutLeftMargin(5);
		travelReimbursementDetailsControls.setLayoutRightMargin(5);
		travelReimbursementDetailsControls.setMembersMargin(10);
		travelReimbursementDetails.addMember(travelReimbursementDetailsControls);
		addMember(travelReimbursementDetails);
		IButton travelReimbursementDetailsNewButton = new IButton("新增");
		travelReimbursementDetailsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow("新增前期项目差旅报销信息");
				window.setWidth("40%");
				window.setHeight("50%");
				window.centerInPage();
				Object startDate = mainInfoPage.findNamedItem("startDate").getValue();
				Object endDate = mainInfoPage.findNamedItem("endDate").getValue();
				TravelReimbursementDetailPanel panel = new TravelReimbursementDetailPanel(startDate, endDate);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						Record record = event.getData();
						RecordList list = grid.getDataAsRecordList();
						list.add(record);
						grid.setData(list);
						grid.redraw();
						BigDecimal amount = BigDecimal.ZERO;
						if(null != mainInfoPage){
							FormItem item = mainInfoPage.findNamedItem("amount");
							if (null != item) {
								ListGridRecord[] data = grid.getRecords();
								if (data == null || data.length == 0) {
									item.setValue(amount);
									return;
								}
								for (ListGridRecord r : data) {
									if (null != r.getAttribute("sum")) {
										amount = amount.add(new BigDecimal(r.getAttribute("sum")));
									}
								}
								item.setValue(amount);
							}
						}
						departmentPanelInfoChange(amount);
					}
				});
				panel.setParentWindow(window);
				window.addItem(panel);
				window.show();
			}
		});
		IButton travelReimbursementDetailsUpdateButton = new IButton("修改");
		travelReimbursementDetailsUpdateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (grid.anySelected()) {
					PopupWindow window = new PopupWindow("修改差旅报销信息");
					window.setWidth("40%");
					window.setHeight("50%");
					window.centerInPage();
					TravelReimbursementDetailPanel panel = new TravelReimbursementDetailPanel(null, null);
					final int rowNo = grid.getRowNum(grid.getSelectedRecord());
					Record record = grid.getSelectedRecord();
					panel.startEdit(record);
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							Record record = event.getData();
							RecordList list = grid.getDataAsRecordList();
							RecordList newList = new RecordList();
							int size = list.getLength();
							for(int i=0 ; i<size; i++){
								if(i == rowNo){
									newList.add(record);
								}else{
									newList.add(list.get(i));
								}
							}
							grid.setData(newList);
							grid.redraw();
							BigDecimal amount = BigDecimal.ZERO;
							if(null != mainInfoPage){
								FormItem item = mainInfoPage.findNamedItem("amount");
								if (null != item) {
									ListGridRecord[] data = grid.getRecords();
									if (data == null || data.length == 0) {
										item.setValue(amount);
										return;
									}
									for (ListGridRecord r : data) {
										if (null != r.getAttribute("sum")) {
											amount = amount.add(new BigDecimal(r.getAttribute("sum")));
										}
									}
									item.setValue(amount);
								}
							}
							departmentPanelInfoChange(amount);
						}
					});
					panel.setParentWindow(window);
					window.addItem(panel);
					window.show();
				} else {
					SC.say("请选择一条数据");
				}
			}
		});
		IButton travelReimbursementDetailsRemoveButton = new IButton("删除所有");
		travelReimbursementDetailsRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
				departmentPanelInfoChange(BigDecimal.ZERO);
				EditCompleteEvent editCompleteEvent = new EditCompleteEvent(null);
				grid.fireEvent(editCompleteEvent);
			}
		});
		travelReimbursementDetailsControls.addMember(travelReimbursementDetailsNewButton);
		travelReimbursementDetailsControls.addMember(travelReimbursementDetailsUpdateButton);
		travelReimbursementDetailsControls.addMember(travelReimbursementDetailsRemoveButton);
	}

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("travelReimbursementId", getRecord().getAttribute("travelReimbursementId"));
		DBDataSource.callOperation("ST_TravelReimbursementDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					if(__startLoadedDetail != null) __startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(dsResponse.getData());
					if(__endLoadedDetail != null) __endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		for(ListGridRecord r : grid.getRecords()) {
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailTravelReimbursementDetail");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		Map param = new HashMap();
		ListGridRecord[] rows = grid.getRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailTravelReimbursementDetail");
		__logger.info(param.toString());
		return param;
	}

	@Override
	public String getName() {
		return "";
	}

	public void departmentPanelInfoChange(BigDecimal amount){
		if(null != departmentPanel){
			DelicacyListGrid departmentRecords = departmentPanel.getGrid();
			if(departmentRecords.getRecords().length <= 1){
				//只有部门费用分拆的数据量<=1条的时候，才需要在金额变动的时候，跟着变动部门分担的费用，多于1条数据的，由用户自行调整部门分担费用
				ListGridRecord departmentRecord = departmentRecords.getRecord(0);
				if(null == departmentRecord){
					departmentRecord = new ListGridRecord();
					FormItem departmentItem = mainInfoPage.findNamedItem("departmentId");
					if(null != departmentItem && null != departmentItem.getValue()){
						String departmentId = departmentItem.getValue().toString();
						Tree departmentTree = KeyValueManager.getTree("departments");
						TreeNode[] nodes = departmentTree.getAllNodes();
						for(TreeNode node : nodes){
							if(node.getName().equals(departmentId)){
								String path = departmentTree.getPath(node);
								String[] paths = path.split("/");
								if(paths.length>=4){
									departmentRecord.setAttribute("departmentId", paths[3]);
								}else{
									departmentRecord.setAttribute("departmentId", paths[paths.length-1]);
								}
							}
						}
						
					}
				}
				departmentRecord.setAttribute("amount", amount);
				ListGridRecord[] recordArr = new ListGridRecord[1];
				recordArr[0] = departmentRecord;
				departmentRecords.setRecords(recordArr);
				departmentPanel.setGrid(departmentRecords);
				departmentPanel.reDrawGrid();
			}
		}
	}
	
	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail( DSCallback value ) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail( DSCallback value ) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}

	public AbstractWizadPage getMainInfoPage() {
		return mainInfoPage;
	}

	public void setMainInfoPage(AbstractWizadPage mainInfoPage) {
		this.mainInfoPage = mainInfoPage;
	}

	public TravelReimbursementLinkDepartmentDetail getDepartmentPanel() {
		return departmentPanel;
	}

	public void setDepartmentPanel(TravelReimbursementLinkDepartmentDetail departmentPanel) {
		this.departmentPanel = departmentPanel;
	}

}