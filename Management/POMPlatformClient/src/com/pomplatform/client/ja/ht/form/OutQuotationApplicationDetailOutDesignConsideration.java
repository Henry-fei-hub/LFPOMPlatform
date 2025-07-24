package com.pomplatform.client.ja.ht.form;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.i18n.client.NumberFormat;
import com.pomplatform.client.ja.ht.datasource.DSOutDesignConsideration;
import com.pomplatform.client.ja.ht.panel.CustomOutDesignConsideration2Panel;
import com.pomplatform.client.preprojects.datasource.DSMainProjectBusinessType;
import com.smartgwt.client.data.Criteria;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DropCompleteEvent;
import com.smartgwt.client.widgets.events.DropCompleteHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.EditorExitEvent;
import com.smartgwt.client.widgets.form.fields.events.EditorExitHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellSelectionChangedEvent;
import com.smartgwt.client.widgets.grid.events.CellSelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;

public class OutQuotationApplicationDetailOutDesignConsideration extends AbstractWizadPage
{
	
	private static final Logger __LOGGER = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);

	
	public DelicacyListGrid LeftGrid;
	public DelicacyListGrid RightGrid;
	private DynamicForm __infoForm;
	private TextItem totalItem;
	
	
	
	private String infoCode ;
	private String projectCode;
	private String outQuotationId ;
//	private String businessType ;
	private String outTempletId ;
	private String moneySum ;
	private String newCreateQuotationName;
	private String type;
	
	public OutQuotationApplicationDetailOutDesignConsideration(){
		
		//左侧
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("outDesignConsiderationId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("infoCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("projectCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("newCreateQuotationName");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("mainDesignAreaName");
		fields[idx].setHidden(false);
		idx++;
//		fields[idx] = new ListGridField("businessType");
//		fields[idx].setCanEdit(true);
//		fields[idx].setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
//		SelectItem selectBusinessTypeItem = new SelectItem();
//		selectBusinessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
//		fields[idx].setEditorProperties(selectBusinessTypeItem);
//		idx++;
		//设计面积
		fields[idx] = new ListGridField("designArea","面积");
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (BaseHelpUtils.getDoubleValue(value)<0) return null;  
                try {  
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");  
                    return "" + nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        });
		fields[idx].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				double thisVal = BaseHelpUtils.getDoubleValue(event.getValue());
				DynamicForm df = event.getForm();
				if(null != event.getValue()){
					//先判断是否有填写开票金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("designUnitPrice").getValue())){
						double designUnitPrice = BaseHelpUtils.getDoubleValue(df.getField("designUnitPrice").getValue());
						df.getField("moneySum").setValue(BaseHelpUtils.get2Double(thisVal * designUnitPrice));
					}else if(!BaseHelpUtils.isNullOrEmpty(df.getField("moneySum").getValue())){
						double moneySum = BaseHelpUtils.getDoubleValue(df.getField("moneySum").getValue());
						df.getField("designUnitPrice").setValue(BaseHelpUtils.get2Double(moneySum/thisVal));
					}
				}
				//将填写的面积默认也赋给内部的面积
				if(thisVal==0){
					df.getField("interiorArea").setValue(0);
					df.getField("moneySum").setValue(0);
				}else{
					df.getField("interiorArea").setValue(BaseHelpUtils.get2Double(thisVal));
				}
			}
		});
		idx++;
		//单价
		fields[idx] = new ListGridField("designUnitPrice","单 价");
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (BaseHelpUtils.getDoubleValue(value)<0) return null;  
                try {  
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");  
                    return "" + nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        });
		fields[idx].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					double thisVal = BaseHelpUtils.getDoubleValue(event.getValue());
					DynamicForm df = event.getForm();
					//先判断是否有填写开票金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("designArea").getValue())){
						double designArea = BaseHelpUtils.getDoubleValue(df.getField("designArea").getValue());
						df.getField("moneySum").setValue(BaseHelpUtils.get2Double(thisVal * designArea));
					}
				}
				
			}
		});
		idx++;
		//总价
		fields[idx] = new ListGridField("moneySum","总 价");
		fields[idx].setCanEdit(true);
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (BaseHelpUtils.getDoubleValue(value)<0) return null;  
                try {  
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");  
                    return "" + nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        });
		fields[idx].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					double thisVal = BaseHelpUtils.getDoubleValue(event.getValue());
					DynamicForm df = event.getForm();
					//先判断是否有填写开票金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("moneySum").getValue())){
						double designArea = BaseHelpUtils.getDoubleValue(df.getField("designArea").getValue());
						df.getField("designUnitPrice").setValue(BaseHelpUtils.get2Double(thisVal /designArea));
					}
				}
				
			}
		});
		
		VLayout LeftBtnVLayout=new VLayout(10);
		LeftBtnVLayout.setLayoutTopMargin(50);
		LeftBtnVLayout.setWidth("6%");
		IButton saveBtn=new IButton("保存");
//		LeftBtnVLayout.addMember(saveBtn);
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.debugger();
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "saveOutDesignConsiderations");
				condition.put("projectCode",projectCode);
				condition.put("infoCode",infoCode);
				condition.put("newCreateQuotationName", newCreateQuotationName.trim());
				condition.put("outQuotationId", outQuotationId);
				condition.put("outTempletId", outTempletId );
				condition.put("type", type);
				condition.put("employeeId", ClientUtil.getEmployeeId());
				MapUtils.convertRecordToMap(LeftGrid,LeftGrid.getRecords(),condition,"outDesignConsiderationsReocrd");
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							SC.say("提示","保存成功");
							startEdit();
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		IButton provBtn=new IButton("新增");
		LeftBtnVLayout.addMember(provBtn);
		provBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			 ListGridRecord record = new ListGridRecord();
			 record.setAttribute("infoCode", infoCode);
			 record.setAttribute("employeeId", ClientUtil.getEmployeeId());
			 record.setAttribute("projectCode", projectCode);
			 record.setAttribute("outQuotationId", outQuotationId);
			 record.setAttribute("outTempletId", outTempletId);
//			 record.setAttribute("businessType", businessType);
			 record.setAttribute("newCreateQuotationName", newCreateQuotationName);
			 record.setAttribute("type", type);
			 record.setAttribute("designArea", 0);
			 record.setAttribute("designUnitPrice", 0);
			 record.setAttribute("moneySum", 0);
			 LeftGrid.startEditingNew(record);
			}
		});
		
		 
		IButton btnDelOutQ=new IButton("删除");
//		LeftBtnVLayout.addMember(btnDelOutQ);
		btnDelOutQ.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord record = LeftGrid.getSelectedRecord();
				if(record == null){
					SC.say("请选择一条数据");
					return;
				}
				LeftGrid.removeData(record);
				
				if(BaseHelpUtils.getIntValue(record.getAttribute("outDesignConsiderationId"))>0) {
					Map<String, Object> condition = new HashMap<>();
					condition.put("outDesignConsiderationId", BaseHelpUtils.getIntValue(record.getAttribute("outDesignConsiderationId")));
					DBDataSource.callOperation("ST_OutDesignConsideration","delete", condition, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								SC.say("提示","删除成功");
							}else{
								ClientUtil.displayErrorMessage(dsResponse);
							}
						}
					});
				}
			}
		});
		
		
		
		
		//右侧
		ListGridField[] aFields = new ListGridField[2];
		int a = 0;
		aFields[a] = new ListGridField("mainProjectBusinessTypeId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("businessType","业务类别");
		aFields[a].setCanEdit(true);
		KeyValueManager.loadValueMap("production_value_coefficient_type",aFields[a]);
		a++;
		aFields[a] = new ListGridField("area", "面积");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("outputValue", "产值");
		aFields[a].setCanEdit(true);
		
		VLayout RightBtnVLayout=new VLayout(10);
		RightBtnVLayout.setLayoutTopMargin(50);
		RightBtnVLayout.setWidth("6%");
		IButton RightSaveBtn=new IButton("保存");
//		RightBtnVLayout.addMember(RightSaveBtn);
		RightSaveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "saveMainProjectBusinessType");
				condition.put("projectCode", projectCode);
				condition.put("infoCode", infoCode);
				MapUtils.convertRecordToMap(RightGrid,RightGrid.getRecords(),condition,"businessTypeReocrd");
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							SC.say("提示","保存成功");
							startEdit();
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		IButton RightProvBtn=new IButton("新增");
		RightBtnVLayout.addMember(RightProvBtn);
		RightProvBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Record r = new Record();
				RightGrid.startEditingNew(r);
			}
		});
		
		 
		IButton RightBtnDelOutQ=new IButton("删除");
//		RightBtnVLayout.addMember(RightBtnDelOutQ);
		RightBtnDelOutQ.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord record = RightGrid.getSelectedRecord();
				if(record == null){
					SC.say("请选择一条数据");
					return;
				}
				
				int mainProjectBusinessTypeId = BaseHelpUtils.getIntValue(record.getAttribute("mainProjectBusinessTypeId"));
				RightGrid.removeData(record);
				RightGrid.startEditing(RightGrid.getRecords().length-1);
				
				if(mainProjectBusinessTypeId>0) {
					Map<String, Object> condition = new HashMap<>();
					condition.put("mainProjectBusinessTypeId", mainProjectBusinessTypeId);
					DBDataSource.callOperation("ST_MainProjectBusinessType","delete", condition, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								SC.say("提示","删除成功");
							}else{
								ClientUtil.displayErrorMessage(dsResponse);
							}
						}
					});
				}
			}
		});
		
		//底部
		__infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight("16%");
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		totalItem = new TextItem("xxxx","报价单汇总  ");
		totalItem.setCanEdit(false);
		totalItem.setWidth("*");
		__infoForm.setFields(totalItem);
		
		LeftGrid = new DelicacyListGrid();
		LeftGrid.setCanDragSelectText(true);
		LeftGrid.setAutoFitFieldWidths(false);
		LeftGrid.setShowGridSummary(true);
		LeftGrid.setDataSource(DSOutDesignConsideration.getInstance());
		LeftGrid.setCanEdit(true);
		LeftGrid.setCanRemoveRecords(true);
		LeftGrid.setFields(fields);
		LeftGrid.setHeaderHeight(60);  
		LeftGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("合同报价", new String[] {"mainDesignAreaName","designArea","designUnitPrice","moneySum"})
			    });
		LeftGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		
		
		
		RightGrid = new DelicacyListGrid();
		RightGrid.setCanDragSelectText(true);
		RightGrid.setAutoFitFieldWidths(false);
		RightGrid.setShowGridSummary(true);
		RightGrid.setCanEdit(true);
		RightGrid.setDataSource(DSMainProjectBusinessType.getInstance());
		RightGrid.setCanRemoveRecords(true);
		RightGrid.setFields(aFields);
		RightGrid.setHeaderHeight(60);  
		RightGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("产值", new String[] {"businessType", "area", "outputValue"})
			    });
				
		RightGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
//		RightGrid.addEditorExitHandler(new com.smartgwt.client.widgets.grid.events.EditorExitHandler() {
//			
//			@Override
//			public void onEditorExit(com.smartgwt.client.widgets.grid.events.EditorExitEvent event) {
//				SC.debugger();
//				Object newValue = event.getNewValue();
//				Record re = event.getRecord();
//				Record ree = RightGrid.getRecord(event.getRowNum());
//				if(BaseHelpUtils.isNullOrEmpty(newValue)) {
//					return;
//				}
//				if(event.getColNum() != 0 && event.getColNum() != 1) {
//					return;
//				}
//				Record r = event.getRecord();
//				if(null == r) {
//					return;
//				}
//				Map<String, Object> params = new HashMap<>();
//				params.put("optType", "calculateOutputValue");
//				if(event.getColNum() == 0) {
//					//修改了业务类别
//					if(BaseHelpUtils.isNullOrZero(r.getAttribute("area"))) {
//						return;
//					}
//					params.put("businessType", newValue);
//					params.put("area", r.getAttribute("area"));
//				}else {
//					//修改了面积
//					if(BaseHelpUtils.isNullOrZero(r.getAttribute("businessType"))) {
//						return;
//					}
//					params.put("businessType", r.getAttribute("businessType"));
//					params.put("area", newValue);
//				}
//				DBDataSource.callOperation("EP_PreProjectProcess", "find", params, new DSCallback() {
//					
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if(dsResponse.getStatus() >= 0) {
//							if(null != dsResponse.getData() && dsResponse.getData().length > 0) {
//								Record result = dsResponse.getData()[0];
//								r.setAttribute("area", BaseHelpUtils.getDoubleValue(result.getAttribute("area"))   );
//								r.setAttribute("outputValue", BaseHelpUtils.getDoubleValue(result.getAttribute("outputValue")));
//								RightGrid.updateData(r);
//								RightGrid.redraw();
//							}
//						}else {
//							ClientUtil.displayErrorMessage(dsResponse);
//						}
//					}
//				});
//			}
//		})
		RightGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				int colNum = BaseHelpUtils.getIntValue(event.getColNum());
				if (colNum == 2) {
					return;
				}
				Record r = RightGrid.getRecord(event.getRowNum());
				if(BaseHelpUtils.isNullOrEmpty(r.getAttribute("businessType")) || BaseHelpUtils.isNullOrEmpty(r.getAttribute("area"))) {
					return;
				}
				Map<String, Object> params = new HashMap<>();
				params.put("optType", "calculateOutputValue");
				params.put("businessType", r.getAttribute("businessType"));
				params.put("area", r.getAttribute("area"));
				DBDataSource.callOperation("EP_PreProjectProcess",params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							if(null != dsResponse.getData() && dsResponse.getData().length > 0) {
								Record result = dsResponse.getData()[0];
								r.setAttribute("area", BaseHelpUtils.getDoubleValue(result.getAttribute("area")));
								r.setAttribute("outputValue", BaseHelpUtils.getDoubleValue(result.getAttribute("outputValue")));
								RightGrid.updateData(r);
								RightGrid.redraw();
							}
						}else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		VLayout secondLayout = new VLayout();
		secondLayout.setWidth100();
		secondLayout.setHeight100();
		
		HLayout leftLayout = new HLayout();
		leftLayout.setWidth("100%");
		leftLayout.setHeight("50%");
		leftLayout.setLayoutTopMargin(10);
		leftLayout.setLayoutRightMargin(5);
		leftLayout.setMembersMargin(10);
		
		HLayout rightLayout = new HLayout();
		rightLayout.setWidth("100%");
		rightLayout.setHeight("50%");
		rightLayout.setLayoutTopMargin(10);
		rightLayout.setLayoutRightMargin(5);
		rightLayout.setMembersMargin(10);
		
		leftLayout.addMember(LeftGrid);
		leftLayout.addMember(LeftBtnVLayout);
		
		rightLayout.addMember(RightGrid);
		rightLayout.addMember(RightBtnVLayout);
		
		secondLayout.addMember(leftLayout);
		secondLayout.addMember(rightLayout);
		
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setLayoutTopMargin(10);
		mainLayout.setLayoutRightMargin(5);
		mainLayout.setMembersMargin(10);
		mainLayout.addMember(secondLayout);
//		mainLayout.addMember(__infoForm);
		addMember(mainLayout);
	

//		HLayout outDesignConsiderations = new HLayout();
//		outDesignConsiderations.setWidth100();
//		outDesignConsiderations.setHeight100();
//		grid.setDataSource(DSOutDesignConsideration.getInstance());
//		grid.setAutoFitFieldWidths(false);
//		outDesignConsiderations.addMember(grid);
//		VLayout outDesignConsiderationsControls = new VLayout();
//		outDesignConsiderationsControls.setHeight100();
//		outDesignConsiderationsControls.setWidth(60);
//		outDesignConsiderationsControls.setLayoutTopMargin(30);
//		outDesignConsiderationsControls.setLayoutLeftMargin(5);
//		outDesignConsiderationsControls.setLayoutRightMargin(5);
//		outDesignConsiderationsControls.setMembersMargin(10);
//		outDesignConsiderations.addMember(outDesignConsiderationsControls);
//		addMember(outDesignConsiderations);
	}

	@Override
	public void startEdit() {
		SC.debugger();
		Record record = getRecord();
		if(!BaseHelpUtils.isNullOrEmpty(record)) {
			 infoCode = BaseHelpUtils.getString(record.getAttribute("infoCode"));
			 projectCode=BaseHelpUtils.getString(record.getAttribute("projectCode"));
			 outQuotationId =BaseHelpUtils.getString(record.getAttribute("outQuotationId"));
//			 businessType =BaseHelpUtils.getString(record.getAttribute("businessType"));
			 newCreateQuotationName=BaseHelpUtils.getString(record.getAttribute("newCreateQuotationName")).trim();
			 reloadDetailTableData();
		}
	}

	public void reloadDetailTableData(){
		__LOGGER.info("CustomOutDesigneConsiderationHandler start load infoCode=" + infoCode + " projectCode=" + projectCode);
		if (!BaseHelpUtils.isNullOrEmpty(infoCode)&&!BaseHelpUtils.isNullOrEmpty(projectCode) && BaseHelpUtils.getIntValue(outQuotationId) > 0) {
			Map<String,Object> searchMap = new HashMap<>();
			searchMap.put("opt_type", "getMainProjectBusinessType");
			searchMap.put("projectCode", projectCode);
			searchMap.put("infoCode", infoCode);
			searchMap.put("outQuotationId", outQuotationId);
			DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", "", searchMap, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						RightGrid.setData(dsResponse.getData());
					}
				}
			});
			
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "getBusinessTypeQueryData");
			condition.put("infoCode", infoCode);
			condition.put("projectCode", projectCode);
			condition.put("outQuotationId", outQuotationId);
			condition.put("employeeId", ClientUtil.getEmployeeId());
			condition.put("newCreateQuotationName", newCreateQuotationName);
			DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", "", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					LeftGrid.setData(dsResponse.getData());
				}
			});
		}
	}

	@Override
	public boolean checkData() {
		ListGridRecord[] row1s = LeftGrid.getRecords();
		ListGridRecord[] row2s = RightGrid.getRecords();
		if(row1s.length<=0) {
			SC.say("合同报价不能为空");
			return false;
		}
		if(row2s.length<=0) {
			SC.say("产值不能为空");
			return false;
		}
		
		for (ListGridRecord listGridRecord : row1s) {
			BigDecimal designArea = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("designArea"));
			BigDecimal designUnitPrice =BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("designUnitPrice"));
			BigDecimal moneySum =BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("moneySum"));
			String  mainDesignAreaName = BaseHelpUtils.getString(listGridRecord.getAttribute("mainDesignAreaName"));
			if(BaseHelpUtils.isNullOrEmpty(mainDesignAreaName)) {
				SC.say("合同报价业务类型不能为空");
				return false;
			}
//			if( designArea.compareTo(BigDecimal.ZERO)<=0 || designUnitPrice.compareTo(BigDecimal.ZERO)<=0 ||moneySum.compareTo(BigDecimal.ZERO)<=0 ) {
//				SC.say("合同报价数据不能小于等于0 或者为空");
//				return false;
//			}
		}
		
		for (ListGridRecord listGridRecord : row2s) {
			BigDecimal area =BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("area"));
			BigDecimal outputValue =BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("outputValue"));
			int businessType = BaseHelpUtils.getIntValue(listGridRecord.getAttribute("businessType"));
			if(businessType<=0) {
				SC.say("产值业务类型不能为空");
				return false;
			}
			/*if(area.compareTo(BigDecimal.ZERO)<=0 || outputValue.compareTo(BigDecimal.ZERO)<=0 ) {
				SC.say("产值数据不能小于等于0 或者为空");
				return false;
			}*/
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
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
		ListGridRecord[] row1s = LeftGrid.getRecords();
		ListGridRecord[] row2s = RightGrid.getRecords();
		MapUtils.convertRecordToMap(LeftGrid.getDataSource(), row1s, param, "detailOutDesignConsideration");
		MapUtils.convertRecordToMap(RightGrid.getDataSource(), row2s, param, "detailMainProjectBusinessType");
		return param;
	}

	@Override
	public String getName() {
		return "报价单子项表";
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

	public DelicacyListGrid getLeftGrid() {
		return LeftGrid;
	}

	public void setLeftGrid(DelicacyListGrid leftGrid) {
		LeftGrid = leftGrid;
	}

	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getOutQuotationId() {
		return outQuotationId;
	}

	public void setOutQuotationId(String outQuotationId) {
		this.outQuotationId = outQuotationId;
	}

	public String getOutTempletId() {
		return outTempletId;
	}

	public void setOutTempletId(String outTempletId) {
		this.outTempletId = outTempletId;
	}

	public String getMoneySum() {
		return moneySum;
	}

	public void setMoneySum(String moneySum) {
		this.moneySum = moneySum;
	}

	public String getNewCreateQuotationName() {
		return newCreateQuotationName;
	}

	public void setNewCreateQuotationName(String newCreateQuotationName) {
		this.newCreateQuotationName = newCreateQuotationName;
	}
	
	


}

