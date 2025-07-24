package com.pomplatform.client.ja.ht.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.templet.datasource.DSOutTemplet;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CustomOutTemplatePanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid SourceGrid;
	private DynamicForm __infoForm;
	private final ComboBoxItem businessTypeItem;
	private final TextItem newCreateQuotationNameItem;
//	private final SelectItem myTypeItem;
	
	public static PopupWindow popupWindow;
	public CustomOutTemplatePanel(String infoCode,String projectCode,int outQuotationId) {
		CustomOutTemplatePanel.infoCode=infoCode;
		CustomOutTemplatePanel.projectCode=projectCode;
		CustomOutTemplatePanel.outQuotationId=outQuotationId;
		SourceGrid = new DelicacyListGrid();
		SourceGrid.setCanEdit(false);
		
		HLayout bigLayout = new HLayout();
		bigLayout.setWidth100();
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setWidth("93%");
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("businessType");
		SelectItem selectBusinessTypeItem = new SelectItem();
		selectBusinessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		fields[idx].setEditorProperties(selectBusinessTypeItem);
		idx++;
		fields[idx] = new ListGridField("templetName");
		idx++;
		fields[idx] = new ListGridField("createTime");
		idx++;
		fields[idx] = new ListGridField("defaultTemplet");
		fields[idx].setHidden(true);
		idx++;
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionType(SelectionStyle.SINGLE);
		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		SourceGrid.setDataSource(DSOutTemplet.getInstance());
		SourceGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				// 验证数据是否合法
				if (checkData()) {
					final Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
					params.put("opt_type", "saveOrUpdateOutDesignConsideration");
					final int rowNumModified=event.getRowNum();
					DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", params,
					new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data,
								DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								startEdit();
								ClientUtil.displayErrorMessage(dsResponse);
							} else {
								startEdit();
							}
						}
					});
				}
			}
		});
		__infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight(140);
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		
		businessTypeItem = new ComboBoxItem("businessType","业务类别");
		businessTypeItem.setWidth(160);
		businessTypeItem.hide();
		businessTypeItem.setDefaultValue(1);//默认选中商业
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		businessTypeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				businessType=BaseHelpUtils.getIntValue(event.getValue());
				startEdit();
			}
		});
		
		newCreateQuotationNameItem=new TextItem("newCreateQuotationName","报价单标题");
		newCreateQuotationNameItem.setWidth(160);
		
//		myTypeItem=new SelectItem("type","选择建筑或设计类型");
//		myTypeItem.setWidth(160);
//		myTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_60"));
		__infoForm.setFields(businessTypeItem,newCreateQuotationNameItem);
		
		VLayout btnVLayout=new VLayout(10);
		btnVLayout.setLayoutTopMargin(100);
		IButton nextBtn=new IButton("确定");
//		nextBtn.setIcon("[SKIN]/actions/add.png");
		btnVLayout.addMember(nextBtn);
		nextBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
//				if (!SourceGrid.anySelected()) {
//					SC.say("请选择一条数据");
//					return;
//				}
				
				final String newCreateQuotationName=newCreateQuotationNameItem.getValueAsString();
				if(BaseHelpUtils.isNullOrEmpty(newCreateQuotationName)){
					SC.say("报价单标题不能为空");
					return;
				}
//				final int myType=BaseHelpUtils.getIntValue(__infoForm.getItem("type").getValue());
//				if(myType<=0){
//					SC.say("请选择建筑或设计类型");
//					return;
//				}
				
				final Map checkMap = new HashMap<>();
				checkMap.put("opt_type", "checkOutDesignConsideration");
				checkMap.put("projectCode", CustomOutTemplatePanel.projectCode);
				checkMap.put("infoCode", CustomOutTemplatePanel.infoCode);
				checkMap.put("outQuotationId", CustomOutTemplatePanel.outQuotationId);
				checkMap.put("newCreateQuotationName", newCreateQuotationName.trim());
//				checkMap.put("type", myType);
				 
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", checkMap,
				new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data,
							DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
							return;
						} else {
							final ListGridRecord selected = SourceGrid.getSelectedRecord();
							final int outTempletId=selected.getAttributeAsInt("outTempletId");
							final int businessType=selected.getAttributeAsInt("businessType");
							
							PopupWindow pw = new PopupWindow("报价单的子项");
							/**
							 * outTempletId 模板id
							 * outQuotationId 报价单id
							 * infoCode 信息编号
							 * projectCode 项目编号
							 * businessType 模板类型(业务类型)
							 */
							final CustomOutDesignConsideration2Panel panel=new CustomOutDesignConsideration2Panel(CustomOutTemplatePanel.infoCode, CustomOutTemplatePanel.projectCode, CustomOutTemplatePanel.outQuotationId,1,newCreateQuotationName);
							panel.startEdit();
							panel.setPw(pw);
							panel.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									getRefreshGrid().refreshData();
									getRefreshParentGrid().refreshData();//刷新数据
									
								}
							});
							
							pw.addCloseClickHandler(new CloseClickHandler() {
								
								@Override
								public void onCloseClick(CloseClickEvent event) {
									DataEditEvent dee = new DataEditEvent();
									fireEvent(dee);
								}
							});
//							pw.setShowCloseButton(false);
							pw.addItem(panel);
			                pw.setWidth100();
			                pw.setHeight100();
			                pw.centerInPage();
			                pw.show();
			                popupWindow.destroy();//销毁父弹出框
						}
					}
				});
			}
		});
		
		
		

		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutTopMargin(10);
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.addMember(__infoForm);
//		SearchSourceLayout.addMember(SourceGrid);
		
		bigLayout.addMember(SearchSourceLayout);
		bigLayout.addMember(btnVLayout);
		addMember(bigLayout);
	}

	@Override
	public void startEdit() {/*
		__LOGGER.info("CustomOutTemplatePanel start load");

		Map<String, Object> condition = new HashMap<>();
		condition.put("opt_type", "getTemplateDataList");
		condition.put("businessType", businessType);//默认先加载商业类型的模板
		DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", "", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				SourceGrid.setData(dsResponse.getData());
				//设置默认选中的
				ListGridRecord[] recordList=SourceGrid.getRecords();
				if(recordList!=null){
					for(int i=0;i<recordList.length;i++){
						Record record=recordList[i];
						if(BaseHelpUtils.getIntValue(record.getAttributeAsInt("defaultTemplet"))==1){
							SourceGrid.selectRecord(i);
							break;
						}
					}
				}else{
					SourceGrid.selectRecord(0);
				}
			}
		});
	*/}

	// 效验数据
	@Override
	public boolean checkData() {
		boolean isFlag = true;
		return isFlag;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("customOutTemplate");
		return res;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	public int businessType=1;
	public static String infoCode;
	public static String projectCode;
	public static int outQuotationId;
	
	private ListGrid refreshGrid;
	private ListGrid refreshParentGrid;
	public ListGrid getRefreshGrid() {
		return refreshGrid;
	}

	public void setRefreshGrid(ListGrid refreshGrid) {
		this.refreshGrid = refreshGrid;
	}

	public ListGrid getRefreshParentGrid() {
		return refreshParentGrid;
	}

	public void setRefreshParentGrid(ListGrid refreshParentGrid) {
		this.refreshParentGrid = refreshParentGrid;
	}
	
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
}
