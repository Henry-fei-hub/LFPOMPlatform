package com.pomplatform.client.workflow.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.workflow.datasource.DSProjectNormalReimbursementDetail;
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
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectNormalReimbursementDetailProjectNormalReimbursementDetail extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private final LinkedHashMap<String,String> mainItemMap = new LinkedHashMap<>();
	private final LinkedHashMap<String,String> subItemMap = new LinkedHashMap<>();
	private AbstractWizadPage mainInfoPage;
	private int processId = 0;
	private int departmentId = 0;
	
	public ProjectNormalReimbursementDetailProjectNormalReimbursementDetail(){
		__dataGrid = grid;
		grid.setCanEdit(false);
		HLayout projectNormalReimbursementDetails = new HLayout();
		projectNormalReimbursementDetails.setWidth100();
		projectNormalReimbursementDetails.setHeight100();
		ListGridField[] fields = new ListGridField[4];
		int idx = 0;
		fields[idx] = new ListGridField("mainItemId");
		SelectItem select1 = new SelectItem();
//		select1.setValueMap(KeyValueManager.getValueMap("parent_subject_types"));
		KeyValueManager.loadValueMap("parent_subject_types",select1);
		fields[idx].setEditorProperties(select1);
		idx++;
		fields[idx] = new ListGridField("subItemId");
		SelectItem select2 = new SelectItem();
//		select2.setValueMap(KeyValueManager.getValueMap("parent_subject_types"));
		KeyValueManager.loadValueMap("parent_subject_types",select2);
		fields[idx].setEditorProperties(select2);
		idx++;
		fields[idx] = new ListGridField("amount");
		idx++;
		fields[idx] = new ListGridField("remark");
		grid.setFields(fields);
//		grid.setEditorCustomizer(new ListGridEditorCustomizer() {
//
//			@Override
//			public FormItem getEditor(ListGridEditorContext context) {
//				ListGridField f = context.getEditField();
//				ListGridRecord r = context.getEditedRecord();
//				__logger.info("第几行的数据："+grid.getRowNum(r));
//
//				if (null != f && null != r && f.getName().equals("subItemId")) {
//					SelectItem s = new SelectItem();
//					LinkedHashMap<String, String> map = KeyValueManager.getValueMap("subject_types",
//							r.getAttribute("mainItemId"));
//					int oldValue = ClientUtil.checkAndGetIntValue(r.getAttribute("subItemId"));
//					if (null != map && !map.isEmpty()) {
//						s.setValueMap(map);
//						if (oldValue != 0 && !map.containsKey(String.valueOf(oldValue))) {
//							r.setAttribute("subItemId", "");
//						}
//					}
//					return s;
//				} else {
//					return null;
//				}
//			}
//		});
		grid.setDataSource(DSProjectNormalReimbursementDetail.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				EditCompleteEvent editCompleteEvent = new EditCompleteEvent(null);
				grid.fireEvent(editCompleteEvent);
			}
		});
		projectNormalReimbursementDetails.addMember(grid);
		VLayout projectNormalReimbursementDetailsControls = new VLayout();
		projectNormalReimbursementDetailsControls.setHeight100();
		projectNormalReimbursementDetailsControls.setWidth(60);
		projectNormalReimbursementDetailsControls.setLayoutTopMargin(30);
		projectNormalReimbursementDetailsControls.setLayoutLeftMargin(5);
		projectNormalReimbursementDetailsControls.setLayoutRightMargin(5);
		projectNormalReimbursementDetailsControls.setMembersMargin(10);
		projectNormalReimbursementDetails.addMember(projectNormalReimbursementDetailsControls);
		addMember(projectNormalReimbursementDetails);
		IButton projectNormalReimbursementDetailsNewButton = new IButton("新增");
		projectNormalReimbursementDetailsNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (null != mainInfoPage && null != mainInfoPage.findNamedItem("amount")
						&& null != mainInfoPage.findNamedItem("departmentId")
						&& ClientUtil.checkAndGetIntValue(mainInfoPage.findNamedItem("departmentId").getValue()) > 0
						&& processId > 0) {
					final PopupWindow window = new PopupWindow("新增报销信息");
					window.setWidth(450);
					window.setHeight(310);
					window.centerInPage();
					int newDepartmentId = ClientUtil
							.checkAndGetIntValue(mainInfoPage.findNamedItem("departmentId").getValue());
					if (departmentId != newDepartmentId) {
						newWindowWithDBDataSource(window, newDepartmentId, new Record(), false);
					}else{
						newWindowWithoutDBDataSource(window, new Record(), false);
					}
				}
			}
		});
		IButton projectNormalReimbursementDetailsUpdateButton = new IButton("修改");
		projectNormalReimbursementDetailsUpdateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (grid.anySelected()) {
					if (null != mainInfoPage && null != mainInfoPage.findNamedItem("amount")
							&& null != mainInfoPage.findNamedItem("departmentId")
							&& ClientUtil.checkAndGetIntValue(mainInfoPage.findNamedItem("departmentId").getValue()) > 0
							&& processId > 0) {
						final PopupWindow window = new PopupWindow("修改报销信息");
						window.setWidth(450);
						window.setHeight(310);
						window.centerInPage();
						int newDepartmentId = ClientUtil
								.checkAndGetIntValue(mainInfoPage.findNamedItem("departmentId").getValue());
						Record record = grid.getSelectedRecord();
						if (departmentId != newDepartmentId) {
							newWindowWithDBDataSource(window, newDepartmentId, record, true);
						}else{
							newWindowWithoutDBDataSource(window, record, true);
						}
					}
				} else {
					SC.say("请选择一条数据");
				}
			}
		});
		IButton projectNormalReimbursementDetailsRemoveButton = new IButton("删除所有");
		projectNormalReimbursementDetailsRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
				EditCompleteEvent editCompleteEvent = new EditCompleteEvent(null);
				grid.fireEvent(editCompleteEvent);
			}
		});
		projectNormalReimbursementDetailsControls.addMember(projectNormalReimbursementDetailsNewButton);
		projectNormalReimbursementDetailsControls.addMember(projectNormalReimbursementDetailsUpdateButton);
		projectNormalReimbursementDetailsControls.addMember(projectNormalReimbursementDetailsRemoveButton);
	}

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("projectNormalReimbursementId", getRecord().getAttribute("projectNormalReimbursementId"));
		DBDataSource.callOperation("ST_ProjectNormalReimbursementDetail", "find", condition, new DSCallback(){
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
		res.add("detailProjectNormalReimbursementDetail");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailProjectNormalReimbursementDetail");
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

	public void newWindowWithDBDataSource(final PopupWindow window,final int departmentId, final Record editRecord, final boolean update) {
		this.departmentId = departmentId;
		Map<String, Object> paramsMap = new HashMap<>();
		paramsMap.put("processId", processId);
		paramsMap.put("departmentId", departmentId);
		DBDataSource.callOperation("EP_GetSubTypeByProcessAndDepartment", paramsMap, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					for (Record obj : records) {
						if (obj.getAttributeAsInt("parentId") == 0) {
							mainItemMap.put(obj.getAttribute("subjectTypeId"), obj.getAttribute("subjectName"));
						} else {
							subItemMap.put(obj.getAttribute("subjectTypeId") + "-" + obj.getAttribute("parentId"),
									obj.getAttribute("subjectName"));
						}
					}
					NormalReimbursementDetailPanel panel = new NormalReimbursementDetailPanel(mainItemMap, subItemMap);
					panel.startEdit(editRecord);
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							if(update){
								Record record = event.getData();
								RecordList list = grid.getDataAsRecordList();
								RecordList newList = new RecordList();
								int size = list.getLength();
								int rowNo = grid.getRowNum(grid.getSelectedRecord());
								for(int i=0 ; i<size; i++){
									if(i == rowNo){
										newList.add(record);
									}else{
										newList.add(list.get(i));
									}
								}
								grid.setData(newList);
							}else{
								Record record = event.getData();
								RecordList list = grid.getDataAsRecordList();
								list.add(record);
								grid.setData(list);
							}
							grid.redraw();
							FormItem item = mainInfoPage.findNamedItem("amount");
							if (null != item) {
								BigDecimal amount = BigDecimal.ZERO;
								ListGridRecord[] data = grid.getRecords();
								if (data == null || data.length == 0) {
									item.setValue(amount);
									return;
								}
								for (ListGridRecord r : data) {
									if (null != r.getAttribute("amount")) {
										amount = amount.add(new BigDecimal(r.getAttribute("amount")));
									}
								}
								item.setValue(amount);
							}
						}
					});
					panel.setParentWindow(window);
					window.addItem(panel);
					window.show();
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
	}
	
	public void newWindowWithoutDBDataSource(final PopupWindow window, final Record editRecord, final boolean update) {
		NormalReimbursementDetailPanel panel = new NormalReimbursementDetailPanel(mainItemMap, subItemMap);
		panel.startEdit(editRecord);
		panel.addDataEditedHandler(new DataEditedHandler() {
			@Override
			public void onDataEdited(DataEditEvent event) {
				if(update){
					Record record = event.getData();
					RecordList list = grid.getDataAsRecordList();
					RecordList newList = new RecordList();
					int size = list.getLength();
					int rowNo = grid.getRowNum(grid.getSelectedRecord());
					for(int i=0 ; i<size; i++){
						if(i == rowNo){
							newList.add(record);
						}else{
							newList.add(list.get(i));
						}
					}
					grid.setData(newList);
				}else{
					Record record = event.getData();
					RecordList list = grid.getDataAsRecordList();
					list.add(record);
					grid.setData(list);
				}
				grid.redraw();
				FormItem item = mainInfoPage.findNamedItem("amount");
				if (null != item) {
					BigDecimal amount = BigDecimal.ZERO;
					ListGridRecord[] data = grid.getRecords();
					if (data == null || data.length == 0) {
						item.setValue(amount);
						return;
					}
					for (ListGridRecord r : data) {
						if (null != r.getAttribute("amount")) {
							amount = amount.add(new BigDecimal(r.getAttribute("amount")));
						}
					}
					item.setValue(amount);
				}
			}
		});
		panel.setParentWindow(window);
		window.addItem(panel);
		window.show();
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

}

