package com.pomplatform.client.preprojects.form;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.aboutprojectquotetemplatesparent.panel.AddProjectQuoteTemplatesParentPanel;
import com.pomplatform.client.applyprojectquotetemplate.datasource.DSApplyProjectQuoteTemplate;
import com.pomplatform.client.ja.ht.datasource.DSMainProject;
import com.pomplatform.client.preprojectrecord.datasource.DSSpreProjectRecordRrtor;
import com.pomplatform.client.preprojectrecord.panel.UpdatePrePrejectRecordPanel;
import com.pomplatform.client.preprojects.datasource.DSprojectPreInfomations;

public class projectPreInfomationsViewer extends AbstractDetailViewer
{
	private SearchForm __parentSearchForm;	
	private final DelicacyListGrid employeeGrid = new DelicacyListGrid(); 
	private final DelicacyListGrid preProjectRecordGrid = new DelicacyListGrid();
	private final DelicacyListGrid projectQuoteGrid = new DelicacyListGrid();
	private static final Logger __logger = Logger.getLogger("");	
	public projectPreInfomationsViewer() {
	}

	@Override
	public void initComponents() {
		setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
		super.initComponents();
		employeeGrid.setAutoFitFieldWidths(false);
		employeeGrid.setShowGridSummary(true);
		int index = 0;
		ListGridField[] fields = new ListGridField[5];
		fields[index] = new ListGridField("mainProjectEmployeeId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("relation","角色");
		fields[index].setValueMap(KeyValueManager.getValueMap("system_dictionary_158"));
		fields[index].setWidth("30%");
		index++;
		fields[index] = new ListGridField("employeeNo","职员编号");
		fields[index].setWidth("20%");
		index++;
		fields[index] = new ListGridField("employeeId","职员姓名");
		fields[index].setWidth("20%");
		fields[index].setValueMap(KeyValueManager.getValueMap("employees"));
		index++;
		fields[index] = new ListGridField("plateId","业务部门");
		fields[index].setWidth("30%");
		fields[index].setValueMap(KeyValueManager.getValueMap("plate_records"));		
		employeeGrid.setFields(fields);
		
		preProjectRecordGrid.setDataSource(DSSpreProjectRecordRrtor.getInstance());
		preProjectRecordGrid.setCanDragSelectText(true);
		
		int indexs = 0;
		ListGridField[] field = new ListGridField[14];
		field[indexs] = new ListGridField("projectQuoteId");
		field[indexs].setHidden(true);
		indexs++;
		field[indexs] = new ListGridField("businessType");
		KeyValueManager.loadValueMap("pre_business_type",field[indexs]);
		indexs++;
		field[indexs] = new ListGridField("basicAmount");
		indexs++;
		field[indexs] = new ListGridField("totalAmount");
		indexs++;
		field[indexs] = new ListGridField("taxAmount");
		indexs++;
		field[indexs] = new ListGridField("otherTaxAmount");
		indexs++;
		field[indexs] = new ListGridField("finalAmount");
		indexs++;
		field[indexs] = new ListGridField("taxFinalAmount");
		indexs++;
		field[indexs] = new ListGridField("quoteStatus");
		KeyValueManager.loadValueMap("system_dictionary_204",field[indexs]);
		indexs++;
		field[indexs] = new ListGridField("operateEmployeeId");
		KeyValueManager.loadValueMap("employees",field[indexs]);
		indexs++;
		field[indexs] = new ListGridField("operateTime");
		indexs++;
		field[indexs] = new ListGridField("remark");
		indexs++;
		field[indexs] = new ListGridField("projectQuoteTemplatesParentId","模板父级id");
		field[indexs].setHidden(true);
		projectQuoteGrid.setDataSource(DSApplyProjectQuoteTemplate.getInstance());
		projectQuoteGrid.setFields(field);
		projectQuoteGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				final PopupWindow popupWindow = new PopupWindow("项目报价详细");
				popupWindow.setWidth("100%");
				popupWindow.setHeight("100%");
				ProjectQuoteDetailInfo panel = new ProjectQuoteDetailInfo();
				panel.initComponents();
				panel.setRecord(projectQuoteGrid.getSelectedRecord());
				panel.lodaData();
				popupWindow.addItem(panel);
				panel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				panel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
				
			}
		});
		
		
		
		
//		preProjectRecordGrid.setCanEdit(false);
//		preProjectRecordGrid.setCanRemoveRecords(false);
//		preProjectRecordGrid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
//			
//			@Override
//			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
//				int rowNum = event.getRowNum();
//				ListGridRecord record = preProjectRecordGrid.getRecord(rowNum);
//				int preProjectRecordId = BaseHelpUtils.getIntValue(record.getAttribute("preProjectRecordId"));
//				Map<String,Object> paramMap = new HashMap<>();
//				paramMap.put("preProjectRecordId", preProjectRecordId);
//				DBDataSource.callOperation("ST_PreProjectRecord", "delete",paramMap, new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if (dsResponse.getStatus() < 0) {
//							ClientUtil.displayErrorMessage(dsResponse);
//						} else {
//							preProjectRecordGrid.removeData(record);
//						}
//					}
//				});	
//			}
//		});
		
//		preProjectRecordGrid.addDoubleClickHandler(new DoubleClickHandler() {
//			
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				final ListGridRecord selected = preProjectRecordGrid.getSelectedRecord();
//				UpdatePrePrejectRecordPanel detailForm = new UpdatePrePrejectRecordPanel();
//				detailForm.setTitle("更新前期跟踪记录台账");
//				detailForm.addDataEditedHandler(new DataEditedHandler() {
//					@Override
//					public void onDataEdited(DataEditEvent event) {
//						DBDataSource.copyRecord(event.getData(), selected);
//						preProjectRecordGrid.redraw();
//					}
//				});
//				detailForm.setRecord(selected);
//				detailForm.initComponents();
//				detailForm.setWidth("40%");
//				detailForm.setHeight("60%");
//				detailForm.startEdit();
//				detailForm.centerInPage();
//				detailForm.show();
//				detailForm.centerInPage();
//				detailForm.show();				
//			}
//		});
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "前期项目信息";
	}

	@Override
	public int getGroupCount() {
		return 3;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		GroupColumn gc;
		gc = new GroupColumn();
		gc.setGroupName("baseInfo");
		gc.setGroupCaption("项目基本信息");
		gc.getColumnNames().add("projectCode");
		gc.getColumnNames().add("infoCode");
		gc.getColumnNames().add("projectName");
		//gc.getColumnNames().add("projectEnglishName");
		gc.getColumnNames().add("projectStatus");
		gc.getColumnNames().add("designStatus");
		gc.getColumnNames().add("projectOrigination");
		gc.getColumnNames().add("projectOriginationRemark");
		gc.getColumnNames().add("ownerTypeId");
		//gc.getColumnNames().add("projectType");
		gc.getColumnNames().add("region");
		gc.getColumnNames().add("province");
		gc.getColumnNames().add("city");
		gc.getColumnNames().add("detailAddress");
		gc.getColumnNames().add("infoRegisterTime");
		gc.getColumnNames().add("customerName");
		gc.getColumnNames().add("customerAddress");
		gc.getColumnNames().add("contactName");
		gc.getColumnNames().add("grade");
		gc.getColumnNames().add("contactPhone");
		gcs.add(gc);
		gc = new GroupColumn();
		gc.setGroupName("detailInfo");
		gc.setGroupCaption("项目详细信息");
		gc.getColumnNames().add("projectLevel");
		gc.getColumnNames().add("estimatePrice");
		gc.getColumnNames().add("businessType");
		gc.getColumnNames().add("specialty");
		gc.getColumnNames().add("signCompany");
		gc.getColumnNames().add("designQualification");
		gc.getColumnNames().add("comparisonForm");
		//gc.getColumnNames().add("projectModel");
		gc.getColumnNames().add("projectBaseOn");
		gc.getColumnNames().add("projectApprovalTime");
		gc.getColumnNames().add("remark");
		gc.getColumnNames().add("closeReason");
		gc.getColumnNames().add("closeRemark");
		gc.getColumnNames().add("departmentId");
		gc.getColumnNames().add("designTeam");
		gc.getColumnNames().add("competitionName");
		gc.getColumnNames().add("designCooperationName");
		gc.getColumnNames().add("architecturalDesignUnits");
		gc.getColumnNames().add("isOriginal");
		gc.getColumnNames().add("isHighRiseBuilding");
		gc.getColumnNames().add("isOperationDepartment");
		gcs.add(gc);
		gc = new GroupColumn();
		gc.setGroupName("designInfo");
		gc.setGroupCaption("项目技经指标");
		gc.getColumnNames().add("projectTotalInvestment");
		gc.getColumnNames().add("decorateMoneyControl");
		gc.getColumnNames().add("totalBuildingAreas");
		gc.getColumnNames().add("estimateTheDesignAreas");
		gc.getColumnNames().add("actualDesignAreas");
		gc.getColumnNames().add("fireResistanceRating");
		gc.getColumnNames().add("buildingHeight");
		gc.getColumnNames().add("buildingFloors");
		gcs.add(gc);
		
		gc= new GroupColumn();
		gc.setGroupName("detailInfo");
		gc.setGroupCaption("前期记录跟踪台账");
		gcs.add(gc);
		return gcs;
	}

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("preProjectId", getBusinessId());
		DBDataSource.callOperation("NQ_projectPreInfomations", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					for(DetailViewer v : detailViewers){
						v.setData(dsResponse.getData());
						if(dsResponse.getData().length == 0) continue;
						v.selectRecord(0);
						v.redraw();
					}
					setRecord(dsResponse.getData()[0]);
					viewDetailData();
				}
			}
		});
	}

	@Override
	public void viewRecord(Record r) {
		// TODO Auto-generated method stub
		super.viewRecord(r);
	}
	
	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		Record selected = grid.getSelectedRecord();
		Map<String,Object> params = new HashMap<>();
		int preProjectId = BaseHelpUtils.getIntValue(selected.getAttribute("preProjectId"));
		params.put("preProjectId", preProjectId);
		DBDataSource.callOperation("NQ_SearchMainProjectEmployeeData", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					employeeGrid.setData(dsResponse.getData());
				}
			}
		});
//		params.put("informationType", 1);
        DBDataSource.callOperation("ST_PreProjectRecord", "find", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    preProjectRecordGrid.setData(dsResponse.getData());
                }
            }
		});
        
        params.put("projectId", preProjectId);
        DBDataSource.callOperation("ST_ProjectQuote", "find", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    projectQuoteGrid.setData(dsResponse.getData());
                }
            }
		});
        
	}

	public void viewDetailData(){
	}

	@Override
	public DataSource getMainDataSource() {
		return DSprojectPreInfomations.getInstance();
	}

	@Override
	public Map getValues() {
		if (getRecord() == null)
			return new HashMap();
		Map res = getRecord().toMap();
		List<ListGrid> grids = getDetailListGrids();
		if (grids != null && grids.size() > 0) {
			for (ListGrid g : grids) {
				g.setCanDragSelectText(true);
				DBDataSource ds = DSprojectPreInfomations.getInstance();
				String name = "detail" + ds.getActionName();
				MapUtils.convertRecordToMap(g, g.getRecords(), res, name);
			}
		}
		return res;
	}
	
	@Override
	public int getDetailCount(){
		return 3;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(employeeGrid);
		res.add(preProjectRecordGrid);
		res.add(projectQuoteGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("项目相关人员");
		res.add("前期跟踪记录台账");
		res.add("项目报价");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}
}
