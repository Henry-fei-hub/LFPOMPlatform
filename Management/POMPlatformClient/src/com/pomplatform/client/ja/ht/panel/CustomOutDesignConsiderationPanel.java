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

public class CustomOutDesignConsiderationPanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid SourceGrid;
	private DynamicForm __infoForm;
	private TextItem totalItem;
	private TextItem finalizedMoneyItem;//最终报价
	private static double finalizedMoney=0;

	public CustomOutDesignConsiderationPanel(final String infoCode, String projectCode, final int outQuotationId, double moneySum,
			int outTempletId, final int businessType, int quotationStatus,final String newCreateQuotationName,final int type) {
		//当不成功时只准许查看
		boolean onlyShow = quotationStatus == 2 ? true : false;
		CustomOutDesignConsiderationPanel.infoCode = infoCode;
		CustomOutDesignConsiderationPanel.projectCode = projectCode;
		CustomOutDesignConsiderationPanel.outQuotationId = outQuotationId;
		CustomOutDesignConsiderationPanel.businessType = businessType;
		CustomOutDesignConsiderationPanel.outTempletId = outTempletId;
		CustomOutDesignConsiderationPanel.moneySum = moneySum;
		CustomOutDesignConsiderationPanel.newCreateQuotationName=newCreateQuotationName;
		CustomOutDesignConsiderationPanel.type=type;
		SourceGrid = new DelicacyListGrid();
		SourceGrid.setCanDragSelectText(true);
		SourceGrid.setAutoFitFieldWidths(false);
		SourceGrid.setDataSource(DSOutDesignConsideration.getInstance());
		SourceGrid.setCanEdit(true);
		
		HLayout bigLayout = new HLayout();
		bigLayout.setWidth100();
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setWidth("94%");
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
		fields[idx] = new ListGridField("businessType");
		fields[idx].setCanEdit(false);
		SelectItem selectBusinessTypeItem = new SelectItem();
		selectBusinessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		fields[idx].setEditorProperties(selectBusinessTypeItem);
		idx++;
		
		//专项 子项
		fields[idx] = new ListGridField("optionType");
		SelectItem selectOptionTypeItem= new SelectItem();
		selectOptionTypeItem.setValueMap(KeyValueManager.getValueMap("sys_classifications"));
		selectOptionTypeItem.setDefaultValue("");
		fields[idx].setEditorProperties(selectOptionTypeItem);
		idx++;
		fields[idx] = new ListGridField("projectType");
		fields[idx].setHidden(true);
		SelectItem selectProjectTypeItem = new SelectItem();
		selectProjectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		fields[idx].setEditorProperties(selectProjectTypeItem);
		idx++;
		fields[idx] = new ListGridField("mainDesignAreaName");
		idx++;
		//设计面积
		if(type==1){
			fields[idx] = new ListGridField("designArea","设计面积");
		}else{
			fields[idx] = new ListGridField("designArea","建筑面积");
		}
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null||BaseHelpUtils.getDoubleValue(value)<=0) return null;  
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
                if (value == null||BaseHelpUtils.getDoubleValue(value)<=0) return null;  
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
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null||BaseHelpUtils.getDoubleValue(value)<=0) return null;  
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
		idx++;
		fields[idx] = new ListGridField("remark");
		idx++;
		//内部面积
		fields[idx] = new ListGridField("interiorArea","面 积");
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null||BaseHelpUtils.getDoubleValue(value)<=0) return null;  
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
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("interiorPrice").getValue())){
						double interiorPrice = BaseHelpUtils.getDoubleValue(df.getField("interiorPrice").getValue());
						df.getField("interiorMoneySum").setValue(BaseHelpUtils.get2Double(thisVal * interiorPrice));
					}else if(!BaseHelpUtils.isNullOrEmpty(df.getField("interiorMoneySum").getValue())){
						double interiorMoneySum = BaseHelpUtils.getDoubleValue(df.getField("interiorMoneySum").getValue());
						df.getField("interiorPrice").setValue(BaseHelpUtils.get2Double(interiorMoneySum/thisVal));
					}
				}
			}
		});
		//内部单价
		idx++;
		fields[idx] = new ListGridField("interiorPrice","单 价");
		fields[idx].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					double thisVal = BaseHelpUtils.getDoubleValue(event.getValue());
					DynamicForm df = event.getForm();
					//先判断是否有填写开票金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("interiorArea").getValue())){
						double interiorArea = BaseHelpUtils.getDoubleValue(df.getField("interiorArea").getValue());
						df.getField("interiorMoneySum").setValue(BaseHelpUtils.get2Double(thisVal * interiorArea));
					}
				}
				
			}
		});
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null||BaseHelpUtils.getDoubleValue(value)<=0) return null;  
                try {  
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");  
                    return "" + nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        });
		idx++;
		fields[idx] = new ListGridField("interiorMoneySum","总 价");
		fields[idx].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					double thisVal = BaseHelpUtils.getDoubleValue(event.getValue());
					DynamicForm df = event.getForm();
					//先判断是否有填写开票金额 有则进行后部分数据的填充
					if(!BaseHelpUtils.isNullOrEmpty(df.getField("interiorArea").getValue())){
						double interiorArea = BaseHelpUtils.getDoubleValue(df.getField("interiorArea").getValue());
						df.getField("interiorPrice").setValue(BaseHelpUtils.get2Double(thisVal / interiorArea));
					}
				}
				
			}
		});
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null||BaseHelpUtils.getDoubleValue(value)<=0) return null;  
                try {  
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");  
                    return "" + nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        });
		idx++;
		fields[idx] = new ListGridField("subContractId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("orderNo");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("disableType");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("outQuotationId");
		fields[idx].setHidden(true);
		idx++;
		SourceGrid.setFields(fields);
		//标题从新写
		SourceGrid.setHeaderHeight(60);  
		SourceGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("基本信息", new String[] {"businessType","optionType","mainDesignAreaName"}),
		   new HeaderSpan("合同报价", new String[] {"designArea","designUnitPrice","moneySum"}),
		   new HeaderSpan("内部分配", new String[] {"remark","interiorArea","interiorPrice","interiorMoneySum"}),
	    });
		
		SourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		SourceGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				// 验证数据是否合法
				if (checkData()) {
					final Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
					params.put("opt_type", "saveOrUpdateOutDesignConsideration");
					final int rowNumModified=event.getRowNum();
					__LOGGER.info(params+"");
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
		__infoForm.setHeight("16%");
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		totalItem = new TextItem("xxxx","报价单汇总  ");
		totalItem.setCanEdit(false);
		totalItem.setWidth("*");
		finalizedMoneyItem = new TextItem("finalizedMoney","最终报价");
		finalizedMoneyItem.setWidth(200);
		finalizedMoneyItem.addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				
				final Map m = new HashMap<>();
				m.put("infoCode", infoCode);
				m.put("projectCode", CustomOutDesignConsiderationPanel.projectCode);
				m.put("outQuotationId", outQuotationId);
				m.put("businessType", businessType);
				m.put("outTempletId", CustomOutDesignConsiderationPanel.outTempletId);
				m.put("newCreateQuotationName", newCreateQuotationName);
				m.put("finalizedMoney", __infoForm.getItem("finalizedMoney").getValue());
				m.put("type", type);
				m.put("opt_type", "setFinalQuotation");
				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", m, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() <= 0) {
							ClientUtil.displayErrorMessage(dsResponse);
							startEdit();
						} else {
							startEdit();
						}
					}
				});
				
			}
		});
		__infoForm.setFields(totalItem,finalizedMoneyItem);
		
		VLayout btnVLayout=new VLayout(10);
		btnVLayout.setLayoutTopMargin(50);
		btnVLayout.setWidth("6%");
		IButton saveBtn=new IButton("保存");
		if(!onlyShow){
			btnVLayout.addMember(saveBtn);
		}
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "checkPriceData");
				condition.put("businessType", businessType);
				condition.put("newCreateQuotationName", newCreateQuotationName);
				condition.put("outQuotationId", outQuotationId);
				condition.put("outTempletId", CustomOutDesignConsiderationPanel.outTempletId);
				condition.put("type", CustomOutDesignConsiderationPanel.type);
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							SC.say("提示","保存成功");
							//startEdit();
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		
		IButton closePWButton = new IButton("关闭");
//		btnVLayout.addMember(closePWButton);
		closePWButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "checkPriceData");
				condition.put("businessType", businessType);
				condition.put("newCreateQuotationName", newCreateQuotationName);
				condition.put("outQuotationId", outQuotationId);
				condition.put("type", type);
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							pw.destroy();
							DataEditEvent dee = new DataEditEvent();
							fireEvent(dee);
						}else{
							SC.ask(BaseHelpUtils.getString(dsResponse.getErrors().get("errorMsg")+" 还否还是要关闭"),new BooleanCallback() {
								
								@Override
								public void execute(Boolean value) {
									if(value){
										pw.destroy();
										DataEditEvent dee = new DataEditEvent();
										fireEvent(dee);
									}
								}
							});
							
						}
					}
				});
				
			}
		});
		
		
		
		
		IButton provBtn=new IButton("新增");
		if(!onlyShow){
			btnVLayout.addMember(provBtn);
		}
		provBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			 ListGridRecord record = new ListGridRecord();
			 record.setAttribute("infoCode", CustomOutDesignConsiderationPanel.infoCode);
			 record.setAttribute("employeeId", ClientUtil.getEmployeeId());
			 record.setAttribute("projectCode", CustomOutDesignConsiderationPanel.projectCode);
			 record.setAttribute("outQuotationId", CustomOutDesignConsiderationPanel.outQuotationId);
			 record.setAttribute("outTempletId", CustomOutDesignConsiderationPanel.outTempletId);
			 record.setAttribute("businessType", CustomOutDesignConsiderationPanel.businessType);
			 record.setAttribute("newCreateQuotationName", CustomOutDesignConsiderationPanel.newCreateQuotationName);
			 record.setAttribute("type", CustomOutDesignConsiderationPanel.type);
			 record.setAttribute("finalizedMoney", finalizedMoney);
			 SourceGrid.startEditingNew(record);
			}
		});
		
		IButton nextBtn=new IButton("向下添加");
		//btnVLayout.addMember(nextBtn);
		
		 
		IButton btnDelOutQ=new IButton("删除");
		if(!onlyShow){
			btnVLayout.addMember(btnDelOutQ);
		}
		btnDelOutQ.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = SourceGrid.getSelectedRecords();
				int count=selected.length;
				if(count<=0){
					SC.say("请选择要删除的数据");
					return;
				}
				//选中的要删除的ids
			    StringBuilder ids=new StringBuilder();
				for(int i=0;i<selected.length;i++){
					if(BaseHelpUtils.isNullOrEmpty(ids.toString())){
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("outDesignConsiderationId"));
						if(tempId>0){
							ids.append(tempId);
						}
					}else{
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("outDesignConsiderationId"));
						if(tempId>0){
							ids.append(",");
							ids.append(tempId);
						}
					}
				}
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "deleteOutDesignConsideration");
				
				__LOGGER.info(" deleteOutDesignConsideration ids="+ids);
				condition.put("ids", ""+ids);
				condition.put("outQuotationId", selected[0].getAttribute("outQuotationId"));
				condition.put("infoCode", selected[0].getAttribute("infoCode"));
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
		
		IButton upBtn=new IButton("向上");
		upBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord record = SourceGrid.getSelectedRecord();
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
							int currentIndex = SourceGrid.getRowNum(record);
							SourceGrid.setData(dsResponse.getData());
							SourceGrid.selectRecord(currentIndex - 1);
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		if(!onlyShow){
			btnVLayout.addMember(upBtn);
		}
		IButton downBtn=new IButton("向下");
		downBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord record = SourceGrid.getSelectedRecord();
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
							int currentIndex = SourceGrid.getRowNum(record);
							SourceGrid.setData(dsResponse.getData());
							SourceGrid.selectRecord(currentIndex + 1);
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		if(!onlyShow){
			btnVLayout.addMember(downBtn);
		}
		IButton downLoadButton = new IButton("导出");
		btnVLayout.addMember(downLoadButton);
		downLoadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = new HashMap<>();
				condition.put("businessType", businessType);
				condition.put("outQuotationId", outQuotationId);
				condition.put("infoCode", infoCode);
				condition.put("exportType", "001");
				condition.put("outTempletId", CustomOutDesignConsiderationPanel.outTempletId);
				condition.put("newCreateQuotationName", CustomOutDesignConsiderationPanel.newCreateQuotationName);
				DBDataSource.downloadFile("DW_CustomOutDesigneConsiderationHandler", condition);
			}
		});
		
		

		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutTopMargin(10);
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.addMember(SourceGrid);
		SearchSourceLayout.addMember(__infoForm);
		
		bigLayout.addMember(SearchSourceLayout);
		bigLayout.addMember(btnVLayout);
		addMember(bigLayout);
	}

	@Override
	public void startEdit() {
		__LOGGER.info(
				"CustomOutDesigneConsiderationHandler start load infoCode=" + infoCode + " projectCode=" + projectCode);

		if (!BaseHelpUtils.isNullOrEmpty(infoCode)&&!BaseHelpUtils.isNullOrEmpty(projectCode) && BaseHelpUtils.getIntValue(outQuotationId) > 0) {
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "getBusinessTypeQueryData");
			condition.put("infoCode", infoCode);
			condition.put("projectCode", projectCode);
			condition.put("outQuotationId", outQuotationId);
			condition.put("moneySum", CustomOutDesignConsiderationPanel.moneySum);
			condition.put("businessType", businessType);
			condition.put("outTempletId", outTempletId);
			condition.put("employeeId", ClientUtil.getEmployeeId());
			condition.put("newCreateQuotationName", newCreateQuotationName);
			condition.put("type", type);

			DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", "", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					SourceGrid.setData(dsResponse.getData());
					// 设置汇总信息
					Object o=dsResponse.getErrors().get("errorMsg");
					String[] val=BaseHelpUtils.getString(o).split("-");
				    totalItem.setValue(BaseHelpUtils.getString(val[0]).substring(1));
				    String temp=BaseHelpUtils.getString(val[2]);
				    finalizedMoney=BaseHelpUtils.get2Double(temp.substring(0,(temp.length()-1)));
				    finalizedMoneyItem.setValue(finalizedMoney);
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
	private static double moneySum;
	private static int outTempletId;
	private static int businessType;
	private static String newCreateQuotationName;
	private static int type;
	public static int getType() {
		return type;
	}

	public static void setType(int type) {
		CustomOutDesignConsiderationPanel.type = type;
	}

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
