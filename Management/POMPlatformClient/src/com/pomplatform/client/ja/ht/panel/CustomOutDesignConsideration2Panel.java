package com.pomplatform.client.ja.ht.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
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
import com.google.gwt.i18n.client.NumberFormat;
import com.pomplatform.client.ja.ht.datasource.DSOutDesignConsideration;
import com.pomplatform.client.preprojects.datasource.DSMainProjectBusinessType;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
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
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;
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

public class CustomOutDesignConsideration2Panel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid LeftGrid;
	public DelicacyListGrid RightGrid;
	private DynamicForm __infoForm;
	private TextItem totalItem;
	private TextItem quotationNameItem;
	// private TextItem finalizedMoneyItem;//最终报价
	// private static double finalizedMoney=0;

	public CustomOutDesignConsideration2Panel(final String infoCode, String projectCode, final int outQuotationId, int quotationStatus,final String newCreateQuotationName) {
		//当不成功时只准许查看
		boolean onlyShow = quotationStatus == 2 ? true : false;
		CustomOutDesignConsideration2Panel.infoCode = infoCode;
		CustomOutDesignConsideration2Panel.projectCode = projectCode;
		CustomOutDesignConsideration2Panel.outQuotationId = outQuotationId;
//		CustomOutDesignConsideration2Panel.businessType = businessType;
//		CustomOutDesignConsideration2Panel.outTempletId = outTempletId;
//		CustomOutDesignConsideration2Panel.moneySum = moneySum;
		CustomOutDesignConsideration2Panel.quotationName=newCreateQuotationName;
//		CustomOutDesignConsideration2Panel.type=type;
		
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
		fields[idx] = new ListGridField("mainDesignAreaName"); 
		fields[idx].setCanEdit(true);
//		idx++;
//		fields[idx] = new ListGridField("businessType");
//		fields[idx].setCanEdit(true);
//		fields[idx].setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
//		SelectItem selectBusinessTypeItem = new SelectItem();
//		selectBusinessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
//		fields[idx].setEditorProperties(selectBusinessTypeItem);
		idx++;
		//设计面积
		fields[idx] = new ListGridField("designArea","面积");
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null||BaseHelpUtils.getDoubleValue(value)<0) return null;  
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
                if (value == null||BaseHelpUtils.getDoubleValue(value)<0) return null;  
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
                if (value == null||BaseHelpUtils.getDoubleValue(value)<0) return null;  
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
					//先判断是否有填写金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("moneySum").getValue())){
						double designArea = BaseHelpUtils.getDoubleValue(df.getField("designArea").getValue());
						double designUnitPrice = BaseHelpUtils.getDoubleValue(df.getField("designUnitPrice").getValue());
						if(designArea>0&&designUnitPrice>0) {
							df.getField("designUnitPrice").setValue(BaseHelpUtils.get2Double(thisVal /designArea));
							df.getField("designArea").setValue(designArea);
						}else {
							df.getField("designUnitPrice").setValue(BaseHelpUtils.get2Double(thisVal /designArea));
							df.getField("designArea").setValue(designArea);
						}
					}else {
						df.getField("designUnitPrice").setValue(0);
						df.getField("designArea").setValue(0);
					}
				}
			}
		});
		
		VLayout LeftBtnVLayout=new VLayout(10);
		LeftBtnVLayout.setLayoutTopMargin(50);
		LeftBtnVLayout.setWidth("6%");
//		IButton saveBtn=new IButton("保存");
//		if(!onlyShow){
//			LeftBtnVLayout.addMember(saveBtn);
//		}
//		saveBtn.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				Map<String, Object> condition = new HashMap<>();
//				condition.put("opt_type", "saveOutDesignConsiderations");
//				condition.put("projectCode",CustomOutDesignConsideration2Panel.projectCode);
//				condition.put("infoCode",CustomOutDesignConsideration2Panel.infoCode);
//				condition.put("newCreateQuotationName", newCreateQuotationName.trim());
//				condition.put("outQuotationId", CustomOutDesignConsideration2Panel.outQuotationId);
//				condition.put("outTempletId", CustomOutDesignConsideration2Panel.outTempletId );
//				condition.put("type", CustomOutDesignConsideration2Panel.type);
//				condition.put("employeeId", ClientUtil.getEmployeeId());
//				MapUtils.convertRecordToMap(LeftGrid,LeftGrid.getRecords(),condition,"outDesignConsiderationsReocrd");
//				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if (dsResponse.getStatus() >= 0) {
//							SC.say("提示","保存成功");
//							startEdit();
//						}else{
//							ClientUtil.displayErrorMessage(dsResponse);
//						}
//					}
//				});
//			}
//		});
		
		IButton provBtn=new IButton("新增");
		if(!onlyShow){
			LeftBtnVLayout.addMember(provBtn);
		}
		provBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			 ListGridRecord record = new ListGridRecord();
			 record.setAttribute("infoCode", CustomOutDesignConsideration2Panel.infoCode);
			 record.setAttribute("employeeId", ClientUtil.getEmployeeId());
			 record.setAttribute("projectCode", CustomOutDesignConsideration2Panel.projectCode);
			 record.setAttribute("outQuotationId", CustomOutDesignConsideration2Panel.outQuotationId);
//			 record.setAttribute("outTempletId", CustomOutDesignConsideration2Panel.outTempletId);
//			 record.setAttribute("businessType", CustomOutDesignConsideration2Panel.businessType);
			 record.setAttribute("newCreateQuotationName", CustomOutDesignConsideration2Panel.quotationName);
//			 record.setAttribute("type", CustomOutDesignConsideration2Panel.type);
			 record.setAttribute("designArea", 0);
			 record.setAttribute("designUnitPrice", 0);
			 record.setAttribute("moneySum", 0);
			 LeftGrid.startEditingNew(record);
			}
		});
		
		 
		IButton btnDelOutQ=new IButton("删除");
		if(!onlyShow){
			LeftBtnVLayout.addMember(btnDelOutQ);
		}
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
//								SC.say("提示","删除成功");
								startEdit();
							}else{
								ClientUtil.displayErrorMessage(dsResponse);
							}
						}
					});
				}
			}
		});
		
		IButton upBtn=new IButton("向上");
		upBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord record = LeftGrid.getSelectedRecord();
				if(record == null){
					SC.say("请选择一条数据");
					return;
				}
				if(record.getAttributeAsInt("outDesignConsiderationId")<=0) {
					SC.say("数据未保存");
					return;
				}
			    Map params = record.toMap();
				params.put("opt_type", "moveOutDesignConsideration");
				params.put("moveType", "up");
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							int currentIndex = LeftGrid.getRowNum(record);
							LeftGrid.setData(dsResponse.getData());
							LeftGrid.selectRecord(currentIndex - 1);
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		if(!onlyShow){
//			LeftBtnVLayout.addMember(upBtn);
		}
		IButton downBtn=new IButton("向下");
		downBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord record = LeftGrid.getSelectedRecord();
				if(record == null){
					SC.say("请选择一条数据");
					return;
				}
				if(record.getAttributeAsInt("outDesignConsiderationId")<=0) {
					SC.say("数据未保存");
					return;
				}
				Map params = record.toMap();
				params.put("opt_type", "moveOutDesignConsideration");
				params.put("moveType", "down");
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							int currentIndex = LeftGrid.getRowNum(record);
							LeftGrid.setData(dsResponse.getData());
							LeftGrid.selectRecord(currentIndex + 1);
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		if(!onlyShow){
//			LeftBtnVLayout.addMember(downBtn);
		}
		IButton downLoadButton = new IButton("导出");
//		LeftBtnVLayout.addMember(downLoadButton);
		downLoadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = new HashMap<>();
//				condition.put("businessType", businessType);
				condition.put("outQuotationId", outQuotationId);
				condition.put("infoCode", infoCode);
				condition.put("exportType", "001");
//				condition.put("outTempletId", CustomOutDesignConsideration2Panel.outTempletId);
				condition.put("newCreateQuotationName", CustomOutDesignConsideration2Panel.quotationName);
				DBDataSource.downloadFile("DW_CustomOutDesigneConsiderationHandler", condition);
			}
		});
		
		
		//右侧
		ListGridField[] aFields = new ListGridField[5];
		int a = 0;
		aFields[a] = new ListGridField("mainProjectBusinessTypeId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("businessType","业务类别");
		aFields[a].setCanEdit(true);
		KeyValueManager.loadValueMap("production_value_coefficient_type",aFields[a]);
		a++;
		aFields[a] = new ListGridField("area", "面积");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("outputValue", "产值");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("outQuotationId", "outQuotationId");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		
		VLayout RightBtnVLayout=new VLayout(10);
		RightBtnVLayout.setLayoutTopMargin(50);
		RightBtnVLayout.setWidth("6%");
//		IButton RightSaveBtn=new IButton("保存");
//		if(!onlyShow){
//			RightBtnVLayout.addMember(RightSaveBtn);
//		}
//		RightSaveBtn.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				
//				Map<String, Object> condition = new HashMap<>();
//				condition.put("opt_type", "saveMainProjectBusinessType");
//				condition.put("projectCode", CustomOutDesignConsideration2Panel.projectCode);
//				condition.put("infoCode", CustomOutDesignConsideration2Panel.infoCode);
//				condition.put("outQuotationId", CustomOutDesignConsideration2Panel.outQuotationId);
//				MapUtils.convertRecordToMap(RightGrid,RightGrid.getRecords(),condition,"businessTypeReocrd");
//				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if (dsResponse.getStatus() >= 0) {
//							SC.say("提示","保存成功");
//							startEdit();
//						}else{
//							ClientUtil.displayErrorMessage(dsResponse);
//						}
//					}
//				});
//			}
//		});
		
		IButton RightProvBtn=new IButton("新增");
		if(!onlyShow){
			RightBtnVLayout.addMember(RightProvBtn);
		}
		RightProvBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
//				SC.debugger();
//				Record r = new Record();
//				RightGrid.startEditingNew();
				
				ListGridRecord r = new ListGridRecord();
				ListGridRecord[] records = new ListGridRecord[1];
				records[0] = r;
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "newMainProjectBusinessType");
				condition.put("area", 0);
				condition.put("outputValue", 0);
				condition.put("projectCode", CustomOutDesignConsideration2Panel.projectCode);
				condition.put("infoCode", CustomOutDesignConsideration2Panel.infoCode);
				condition.put("outQuotationId", CustomOutDesignConsideration2Panel.outQuotationId);
				MapUtils.convertRecordToMap(RightGrid,records,condition,"businessTypeReocrd");
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							startEdit();
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
				
				
				
				
			}
		});
		
		 
		IButton RightBtnDelOutQ=new IButton("删除");
		if(!onlyShow){
			RightBtnVLayout.addMember(RightBtnDelOutQ);
		}
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
//				RightGrid.startEditing(RightGrid.getRecords().length-1);
				
				if(mainProjectBusinessTypeId>0) {
					Map<String, Object> condition = new HashMap<>();
					condition.put("mainProjectBusinessTypeId", mainProjectBusinessTypeId);
					DBDataSource.callOperation("ST_MainProjectBusinessType","delete", condition, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
//								SC.say("提示","删除成功");
								startEdit();
							}else{
								ClientUtil.displayErrorMessage(dsResponse);
							}
						}
					});
				}
			}
		});
		
		IButton RightUpBtn=new IButton("向上");
		RightUpBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord record = LeftGrid.getSelectedRecord();
				if(record == null){
					SC.say("请选择一条数据");
					return;
				}
			    Map params = record.toMap();
				params.put("opt_type", "moveOutDesignConsideration");
				params.put("moveType", "up");
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							int currentIndex = LeftGrid.getRowNum(record);
							LeftGrid.setData(dsResponse.getData());
							LeftGrid.selectRecord(currentIndex - 1);
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		if(!onlyShow){
//			RightBtnVLayout.addMember(RightUpBtn);
		}
		IButton RightDownBtn=new IButton("向下");
		RightDownBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord record = LeftGrid.getSelectedRecord();
				if(record == null){
					SC.say("请选择一条数据");
					return;
				}
				Map params = record.toMap();
				params.put("opt_type", "moveOutDesignConsideration");
				params.put("moveType", "down");
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							int currentIndex = LeftGrid.getRowNum(record);
							LeftGrid.setData(dsResponse.getData());
							LeftGrid.selectRecord(currentIndex + 1);
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		if(!onlyShow){
//			RightBtnVLayout.addMember(RightDownBtn);
		}
		IButton RightDownLoadButton = new IButton("导出");
//		RightBtnVLayout.addMember(RightDownLoadButton);
		RightDownLoadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = new HashMap<>();
//				condition.put("businessType", businessType);
				condition.put("outQuotationId", outQuotationId);
				condition.put("infoCode", infoCode);
				condition.put("exportType", "001");
//				condition.put("outTempletId", CustomOutDesignConsideration2Panel.outTempletId);
				condition.put("newCreateQuotationName", CustomOutDesignConsideration2Panel.quotationName);
				DBDataSource.downloadFile("DW_CustomOutDesigneConsiderationHandler", condition);
			}
		});
		
		//底部
		__infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight("16%");
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		quotationNameItem = new TextItem("quotationName","报价单标题  ");
		quotationNameItem.setCanEdit(true);
		quotationNameItem.setDefaultValue(newCreateQuotationName);
		quotationNameItem.setWidth("*");
		quotationNameItem.addEditorExitHandler(new EditorExitHandler() {

			@Override
			public void onEditorExit(EditorExitEvent event) {
				
				if(!BaseHelpUtils.isNullOrEmpty(event.getValue())) {
					SC.debugger();
					String quotationName = BaseHelpUtils.getString(event.getValue());
					CustomOutDesignConsideration2Panel.quotationName =quotationName;
					
					Map params = new HashMap<>();
					params.put("opt_type", "updateNewCreateQuotationName");
					params.put("outQuotationId", outQuotationId);
					params.put("newCreateQuotationName", quotationName);
					DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						
						}
					});
				}
			}
		});
		
		totalItem = new TextItem("xxxx","报价单汇总  ");
		totalItem.setCanEdit(false);
		totalItem.setWidth("*");
		__infoForm.setFields(quotationNameItem,totalItem);
//		finalizedMoneyItem = new TextItem("finalizedMoney","最终报价");
//		finalizedMoneyItem.setWidth(200);
//		finalizedMoneyItem.addEditorExitHandler(new EditorExitHandler() {
//			
//			@Override
//			public void onEditorExit(EditorExitEvent event) {
//				
//				final Map m = new HashMap<>();
//				m.put("infoCode", infoCode);
//				m.put("projectCode", CustomOutDesignConsideration2Panel.projectCode);
//				m.put("outQuotationId", outQuotationId);
//				m.put("businessType", businessType);
//				m.put("outTempletId", CustomOutDesignConsideration2Panel.outTempletId);
//				m.put("newCreateQuotationName", newCreateQuotationName);
//				m.put("finalizedMoney", __infoForm.getItem("finalizedMoney").getValue());
//				m.put("type", type);
//				m.put("opt_type", "setFinalQuotation");
//				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", m, new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if (dsResponse.getStatus() <= 0) {
//							ClientUtil.displayErrorMessage(dsResponse);
////							startEdit();
//						} else {
////							startEdit();
//						}
//					}
//				});
//				
//			}
//		});
//		__infoForm.setFields(totalItem,finalizedMoneyItem);
		
		LeftGrid = new DelicacyListGrid();
		LeftGrid.setCanDragSelectText(true);
		LeftGrid.setAutoFitFieldWidths(false);
		LeftGrid.setDataSource(DSOutDesignConsideration.getInstance());
		LeftGrid.setCanEdit(true);
		LeftGrid.setFields(fields);
		LeftGrid.setHeaderHeight(60);  
		LeftGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("合同报价", new String[] {"mainDesignAreaName","designArea","designUnitPrice","moneySum"})
			    });
				
		LeftGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		LeftGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				ListGridRecord selectedRecord = LeftGrid.getRecord(event.getRowNum());
				ListGridRecord[] records = new ListGridRecord[1];
				records[0] = selectedRecord;
				if (!BaseHelpUtils.isNullOrEmpty(selectedRecord)&&!BaseHelpUtils.isNullOrEmpty(selectedRecord.getAttribute("mainDesignAreaName"))&&!BaseHelpUtils.isNullOrEmpty(selectedRecord.getAttribute("designArea"))) {
					Map<String, Object> condition = new HashMap<>();
					condition.put("opt_type", "saveOutDesignConsiderations");
					condition.put("projectCode", CustomOutDesignConsideration2Panel.projectCode);
					condition.put("infoCode", CustomOutDesignConsideration2Panel.infoCode);
					condition.put("newCreateQuotationName", CustomOutDesignConsideration2Panel.quotationName.trim());
					condition.put("outQuotationId", CustomOutDesignConsideration2Panel.outQuotationId);
					condition.put("employeeId", ClientUtil.getEmployeeId());
					MapUtils.convertRecordToMap(LeftGrid, records, condition, "outDesignConsiderationsReocrd");
					DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								// SC.say("提示","保存成功");
								startEdit();
							} else {
								ClientUtil.displayErrorMessage(dsResponse);
							}
						}
					});
				}
			}
		});
		
		
		RightGrid = new DelicacyListGrid();
		RightGrid.setCanDragSelectText(true);
		RightGrid.setAutoFitFieldWidths(false);
		RightGrid.setDataSource(DSMainProjectBusinessType.getInstance());
		RightGrid.setCanEdit(true);
		RightGrid.setFields(aFields);
		RightGrid.setHeaderHeight(60);  
		RightGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("产值", new String[] {"businessType", "area", "outputValue","outQuotationId"})
			    });
				
		RightGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		RightGrid.addCellClickHandler(new CellClickHandler() {
			
			@Override
			public void onCellClick(CellClickEvent event) {
				SC.debugger();
				ListGridRecord r = RightGrid.getRecord(event.getRowNum());
				ListGridRecord[] records = new ListGridRecord[1];
				records[0] = r;
				Map<String, Object> condition = new HashMap<>();
				
				condition.put("businessType", r.getAttribute("businessType"));
				condition.put("projectCode", CustomOutDesignConsideration2Panel.projectCode);
				condition.put("infoCode", CustomOutDesignConsideration2Panel.infoCode);
				condition.put("outQuotationId", CustomOutDesignConsideration2Panel.outQuotationId);
				MapUtils.convertRecordToMap(RightGrid,records,condition,"businessTypeReocrd");
				
				int colNum = event.getColNum();
				if(colNum == 0) {
					
					
					
				}else if(colNum == 1) {
					
					SC.askforValue("提示", "请输入本次面积", new ValueCallback() {
						
						@Override
						public void execute(String value) {
							if (BaseHelpUtils.isNullOrEmpty(value)) {
								return;
							}
							
							condition.put("area", value);
							condition.put("opt_type", "saveMainProjectBusinessType");
							DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										startEdit();
									}else{
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
							
						}
					});
				}else if(colNum == 2) {
					SC.askforValue("提示", "请输入本次产值", new ValueCallback() {
						
						@Override
						public void execute(String value) {
							if (BaseHelpUtils.isNullOrEmpty(value)) {
								return;
							}
							condition.put("area", r.getAttribute("area"));
							condition.put("outputValue", value);
							condition.put("opt_type", "updateMainProjectBusinessType");
							DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										startEdit();
									}else{
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
							
						}
					});
				}
				
			}
		});
//		RightGrid.addEditCompleteHandler(new EditCompleteHandler() {
//			
//			@Override
//			public void onEditComplete(EditCompleteEvent event) {
//				// TODO Auto-generated method stub
//				ListGridRecord r = RightGrid.getRecord(event.getRowNum());
//				ListGridRecord[] records = new ListGridRecord[1];
//				records[0] = r;
//				Map<String, Object> condition = new HashMap<>();
//				condition.put("opt_type", "saveMainProjectBusinessType");
//				condition.put("businessType", r.getAttribute("businessType"));
//				condition.put("area", r.getAttribute("area"));
//				condition.put("outputValue", r.getAttribute("outputValue"));
//				condition.put("projectCode", CustomOutDesignConsideration2Panel.projectCode);
//				condition.put("infoCode", CustomOutDesignConsideration2Panel.infoCode);
//				condition.put("outQuotationId", CustomOutDesignConsideration2Panel.outQuotationId);
//				MapUtils.convertRecordToMap(RightGrid,records,condition,"businessTypeReocrd");
//				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if (dsResponse.getStatus() >= 0) {
//							startEdit();
//						}else{
//							ClientUtil.displayErrorMessage(dsResponse);
//						}
//					}
//				});
//			}
//		});
		
		HLayout secondLayout = new HLayout();
		secondLayout.setWidth100();
		secondLayout.setHeight100();
		
		HLayout leftLayout = new HLayout();
		leftLayout.setWidth("94%");
		leftLayout.setHeight("90%");
		leftLayout.setLayoutTopMargin(10);
		leftLayout.setLayoutRightMargin(5);
		leftLayout.setMembersMargin(10);
		
		HLayout rightLayout = new HLayout();
		rightLayout.setWidth("94%");
		rightLayout.setHeight("90%");
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
		mainLayout.addMember(__infoForm);
		addMember(mainLayout);
	}

	@Override
	public void startEdit() {
		__LOGGER.info(
				"CustomOutDesigneConsiderationHandler start load infoCode=" + infoCode + " projectCode=" + projectCode);

		if (!BaseHelpUtils.isNullOrEmpty(infoCode) && !BaseHelpUtils.isNullOrEmpty(projectCode)
				&& BaseHelpUtils.getIntValue(outQuotationId) > 0) {
			Map<String, Object> searchMap = new HashMap<>();
			searchMap.put("opt_type", "getMainProjectBusinessType");
			searchMap.put("projectCode", projectCode);
			searchMap.put("infoCode", infoCode);
			searchMap.put("outQuotationId", outQuotationId);
			DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", "", searchMap, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						RightGrid.setData(dsResponse.getData());
					}
				}
			});
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "getBusinessTypeQueryData");
			condition.put("infoCode", infoCode);
			condition.put("projectCode", projectCode);
			condition.put("outQuotationId", outQuotationId);
//			condition.put("moneySum", CustomOutDesignConsideration2Panel.moneySum);
//			condition.put("businessType", businessType);
//			condition.put("outTempletId", outTempletId);
			condition.put("employeeId", ClientUtil.getEmployeeId());
			condition.put("newCreateQuotationName", CustomOutDesignConsideration2Panel.quotationName);
//			condition.put("type", type);
			DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", "", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					LeftGrid.setData(dsResponse.getData());
					// 设置汇总信息
					Object o = dsResponse.getErrors().get("errorMsg");
					String[] val = BaseHelpUtils.getString(o).split("-");
					totalItem.setValue(BaseHelpUtils.getString(val[0]).substring(1));
				}
			});
		}
	}

	// 效验数据
	@Override
	public boolean checkData() {
		boolean isFlag = true;
		return isFlag;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("customOutDesignConsideration");
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

	private static String infoCode;
	private static String projectCode;
	private static int outQuotationId;
//	private static double moneySum;
//	private static int outTempletId;
//	private static int businessType;
	private static String quotationName;
//	private static int type;


	private PopupWindow pw;

	public PopupWindow getPw() {
		return pw;
	}

	public void setPw(PopupWindow pw) {
		this.pw = pw;
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
