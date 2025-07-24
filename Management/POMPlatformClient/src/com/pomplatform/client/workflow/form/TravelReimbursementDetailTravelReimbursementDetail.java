package com.pomplatform.client.workflow.form;

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
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.workflow.datasource.DSTravelReimbursementDetail;
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
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class TravelReimbursementDetailTravelReimbursementDetail extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private AbstractWizadPage mainInfoPage;

	public TravelReimbursementDetailTravelReimbursementDetail(){
		__dataGrid = grid;

		HLayout travelReimbursementDetails = new HLayout();
		travelReimbursementDetails.setWidth100();
		travelReimbursementDetails.setHeight100();
		grid.setCanEdit(false);
		grid.setDataSource(DSTravelReimbursementDetail.getInstance());
		grid.setAutoFitFieldWidths(false);
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
				PopupWindow window = new PopupWindow("新增差旅报销信息");
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
						if(null != mainInfoPage){
							FormItem item = mainInfoPage.findNamedItem("amount");
							if (null != item) {
								BigDecimal amount = BigDecimal.ZERO;
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
							if(null != mainInfoPage){
								FormItem item = mainInfoPage.findNamedItem("amount");
								if (null != item) {
									BigDecimal amount = BigDecimal.ZERO;
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
		return param;
	}

	@Override
	public String getName() {
		return "";
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

}

