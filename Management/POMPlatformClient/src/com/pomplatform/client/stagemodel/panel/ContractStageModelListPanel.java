package com.pomplatform.client.stagemodel.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.NumberFormat;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.stagemodel.datasource.DSContractStageModelList;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.PrintPreviewCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.PrintCanvas;
import com.smartgwt.client.widgets.PrintWindow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DropCompleteEvent;
import com.smartgwt.client.widgets.events.DropCompleteHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class ContractStageModelListPanel extends AbstractSearchTree
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractStageModelListPanel cm = new ContractStageModelListPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractStageModelList";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
//		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		resultGrid.setShowOpenIcons(false);
		resultGrid.setShowDropIcons(false);
//		resultGrid.setShowSelectedStyle(false);
//		resultGrid.setShowPartialSelection(true);
//		resultGrid.setCascadeSelection(true);
        resultGrid.setCanEdit(true);
        TreeGridField[] fields = new TreeGridField[13];
        int idx = 0;
		fields[idx] = new TreeGridField("stageModelName");
		idx ++;
		fields[idx] = new TreeGridField("year");
		idx ++;
		fields[idx] = new TreeGridField("managerId");
		ComboBoxItem managerIdItem = new ComboBoxItem();
		managerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		managerIdItem.setChangeOnKeypress(false);
		managerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		fields[idx].setEditorProperties(managerIdItem);
		idx ++;
		fields[idx] = new TreeGridField("designDirectorId");
		ComboBoxItem designDirectorIdItem = new ComboBoxItem();
		designDirectorIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		designDirectorIdItem.setChangeOnKeypress(false);
		designDirectorIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		fields[idx].setEditorProperties(designDirectorIdItem);
		idx ++;
		fields[idx] = new TreeGridField("percent");
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value != null) {  
                    NumberFormat nf = NumberFormat.getFormat("##0.00");  
                    try {  
                        return nf.format(BaseHelpUtils.getDoubleValue(value)*100)+"%";  
                    } catch (Exception e) {  
                        return value.toString();  
                    }  
                } else {  
                    return null;  
                }  
            }  
        });
		idx ++;
		fields[idx] = new TreeGridField("actualPercent", "实际百分比");
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value != null) {  
                    NumberFormat nf = NumberFormat.getFormat("##0.00");  
                    try {  
                        return nf.format(BaseHelpUtils.getDoubleValue(value)*100)+"%";  
                    } catch (Exception e) {  
                        return value.toString();  
                    }  
                } else {  
                    return null;  
                }  
            }  
        });
		idx ++;
		fields[idx] = new TreeGridField("actualPercentSum", "累积百分比");
		fields[idx].setCellAlign(Alignment.RIGHT);
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                NumberFormat nf = NumberFormat.getFormat("##0.00");  
                try {  
                	if(record.getAttributeAsBoolean("leafNode")) {
                		double percent = BaseHelpUtils.getDoubleValue(record.getAttribute("actualPercent"));
                		for(int i = rowNum - 1; i > 0; i--) {
                			ListGridRecord r = resultGrid.getRecord(i);
                			if(r.getAttributeAsInt("parentId") == 0) {
                				break;
                			}
                			if(r.getAttributeAsBoolean("leafNode")) {
                				percent += BaseHelpUtils.getDoubleValue(r.getAttribute("actualPercentSum")) ;
                				break;
                			}
                		}
                		record.setAttribute("actualPercentSum", percent);
                		return nf.format(percent*100)+"%";  
                	}else {
                		return null; 
                	}
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        });
		idx ++;
		fields[idx] = new TreeGridField("confirmDate");
		idx ++;
		fields[idx] = new TreeGridField("locked");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new TreeGridField("leafNode");
		idx ++;
		fields[idx] = new TreeGridField("orderNo");
		idx ++;
		fields[idx] = new TreeGridField("needManagerAudit");
		idx ++;
		fields[idx] = new TreeGridField("needDesignDirectorAudit");
		resultGrid.setFields(fields);
        resultGrid.setShowFilterEditor(false);
        resultGrid.setFilterOnKeypress(false);
        
        resultGrid.addDropCompleteHandler(new DropCompleteHandler() {
            @Override
            public void onDropComplete(DropCompleteEvent event) {
                Record[] rs = event.getTransferredRecords();
                DBDataSource.printRecord(rs[0]);
                for (Record r : rs) {
                    DBDataSource.callOperation("ST_ContractStageModel", "update", r.toMap(), new DSCallback() {
                        @Override
                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                            if (dsResponse.getStatus() < 0) {
                                ClientUtil.displayErrorMessage(dsResponse);
                            }
                        }
                    });
                }
            }
        });

        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });
        
        IButton openAllButton = new IButton("展开");
        controlLayout.addMember(openAllButton);
        openAllButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
//                TreeNode currentNode = resultGrid.getSelectedRecord();
//                Tree tree = resultGrid.getData();
//                TreeNode parentNode = tree.getParent(currentNode);
//                __LOGGER.info("父节点信息："+parentNode.getName()+"  Title:"+parentNode.getTitle());
//                TreeNode[] arr = tree.getChildren(parentNode);
//                for(TreeNode obj : arr){
//                	__LOGGER.info(obj.getName()+"  Title:"+obj.getTitle());
//                }
                resultGrid.getTree().openAll();
            }
        });
        
        IButton closeAllButton = new IButton("收起");
        controlLayout.addMember(closeAllButton);
        closeAllButton.addClickHandler(new ClickHandler() {
        	@Override
        	public void onClick(ClickEvent event) {
        		resultGrid.getTree().closeAll();
        	}
        });
        
        IButton chooseModelButton = new IButton("添加业态节点");
        controlLayout.addMember(chooseModelButton);
        chooseModelButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						PopupWindow window = new PopupWindow("合同业态节点模板选择");
						window.setWidth("30%");
						window.setHeight("60%");
						SelectStageModelPanel panel = new SelectStageModelPanel();
						panel.commonQuery();
						panel.setContractId(contractId);
						panel.setParentWindow(window);
						panel.addDataEditedHandler(new DataEditedHandler() {
							
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						window.addItem(panel);
						window.centerInPage();
						window.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
        
        resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
            @Override
            public void onEditComplete(EditCompleteEvent event) {
                Map params = resultGrid.getRecord(event.getRowNum()).toMap();
                Object parentId = params.get("parentId");
                if (parentId == null) {
                    params.put("parentId", "0");
                }
                final int rowNumModified = event.getRowNum();
                DBDataSource.callOperation("ST_ContractStageModel", "saveOrUpdate", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        } else {
                            DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
                            resultGrid.redraw();
                        }
                    }
                });
            }
        });

//        IButton newButton = new IButton("新建");
//        controlLayout.addMember(newButton);
//        newButton.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                Tree tree = resultGrid.getData();
//                TreeNode node = new TreeNode();
//                node.setIsFolder(true);
//                tree.add(node, "/", 0);
//                resultGrid.selectSingleRecord(0);
//                resultGrid.startEditing(0);
//            }
//        });

        IButton newChildButton = new IButton("增加单个节点");
        controlLayout.addMember(newChildButton);
        newChildButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TreeNode currentNode = resultGrid.getSelectedRecord();
                if (currentNode == null) {
                    SC.say("Please select a item as parent.");
                    return;
                }
                DBDataSource.printRecord(currentNode);
                Tree tree = resultGrid.getData();
                TreeNode newNode = new TreeNode();
                DBDataSource.copyRecordNotInclude(currentNode, newNode, "contractStageModelId", "children", "isFolder");
                newNode.setAttribute("parentId", ClientUtil.checkAndGetIntValue(currentNode.getAttribute("contractStageModelId")));
                DBDataSource.printRecord(newNode);
                newNode = tree.add(newNode, currentNode);
                resultGrid.openFolder(currentNode);
                resultGrid.selectSingleRecord(newNode);
                resultGrid.startEditing(resultGrid.getRowNum(newNode));
            }
        });

        IButton removeButton = new IButton("删除节点");
        controlLayout.addMember(removeButton);
        removeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!resultGrid.anySelected()) {
                    SC.say("Please select a data to remove.");
                }
                SC.confirm("确定要删除该节点以及该节点下面的所有子节点吗？", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						final ListGridRecord selected = resultGrid.getSelectedRecords()[0];
		                //获取主键ID
		                int stageModelId = BaseHelpUtils.getIntValue(selected.getAttribute("contractStageModelId"));
		                if(stageModelId > 0){
		                	DBDataSource.callOperation("ST_ContractStageModel", "delete", selected.toMap(), new DSCallback() {
		                		@Override
		                		public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                			if (dsResponse.getStatus() < 0) {
		                				ClientUtil.displayErrorMessage(dsResponse);
		                			} else {
		                				int indexNum = resultGrid.getRowNum(selected);
		                				resultGrid.removeData(selected);
		                				resultGrid.selectSingleRecord(indexNum);
		                			}
		                		}
		                	});
		                }
					}
				});
            }
        });
        
        IButton calculateButton = new IButton("计算可发布节点");
        controlLayout.addMember(calculateButton);
        calculateButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	Map<String, Object> params = new HashMap<String, Object>();
            	params.put("optType", "calculateNodes");
            	params.put("contractId", contractId);
                DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							commonQuery();
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
            }
        });
        
        /**
         * 选择可发布节点，需要满足3个条件：
         * ① 该节点没有锁定
         * ② 该节点的流程状态是新建
         * ③ 该节点的阶段百分比和累积百分比相等
         * ④ 需要审批的角色都有相对于的员工对应
         */
        IButton autoSelectButton = new IButton("选择可发布节点");
        controlLayout.addMember(autoSelectButton);
        autoSelectButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	resultGrid.deselectAllRecords();
            	ListGridRecord[] records = resultGrid.getRecords();
                Set<ListGridRecord> set = new HashSet<>();
                for(ListGridRecord record : records){
                	if(!record.getAttributeAsBoolean("locked") && BaseHelpUtils.getString(record.getAttributeAsObject("processStatus")).equals(ClientStaticUtils.CONTRACT_STAGE_PROCESS_STATUS_0)
                			&& BaseHelpUtils.getBigDecimalValue(record.getAttributeAsObject("percent")).compareTo(BaseHelpUtils.getBigDecimalValue(record.getAttributeAsObject("actualPercent"))) == 0){
                		if(record.getAttributeAsBoolean("needManagerAudit") && record.getAttributeAsBoolean("needDesignDirectorAudit")){
                			if(!BaseHelpUtils.isNullOrEmpty(record.getAttributeAsObject("managerId")) && !BaseHelpUtils.isNullOrEmpty(record.getAttributeAsObject("designDirectorId"))){
                				set.add(record);
                			}
                		}else if(record.getAttributeAsBoolean("needManagerAudit")){
                			if(!BaseHelpUtils.isNullOrEmpty(record.getAttributeAsObject("managerId"))){
                				set.add(record);
                			}
                		}else if(record.getAttributeAsBoolean("needDesignDirectorAudit")){
                			if(!BaseHelpUtils.isNullOrEmpty(record.getAttributeAsObject("designDirectorId"))){
                				set.add(record);
                			}
                		}
                	}
                }
                Record[] recordArr = new Record[set.size()];
                resultGrid.selectRecords(set.toArray(recordArr));
            }
        });
        
        IButton publishButton = new IButton("发布选定节点");
        controlLayout.addMember(publishButton);
        publishButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(resultGrid.anySelected()){
							ListGridRecord[] records = resultGrid.getSelectedRecords();
			                StringBuilder sb = new StringBuilder();
			                for(ListGridRecord record : records){
			                	if(BaseHelpUtils.getIntValue(record.getAttributeAsObject("contractStageModelId")) > 0){
				                	if(sb.length() > 0){
				                		sb.append(",");
				                	}
				                	sb.append(record.getAttributeAsObject("contractStageModelId"));
			                	}
			                }
			                if(sb.length() > 0){
			                	Map<String, Object> params = new HashMap<>();
			                	params.put("optType", "publishNodes");
			                	params.put("id", sb.toString());
			                	DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() >= 0){
											SC.say("发布成功");
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
									}
								});
			                }
						}else{
							SC.say("请选择需要发布的节点");
						}
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
            }
        });
        
        IButton lockButton = new IButton("锁定节点");
        controlLayout.addMember(lockButton);
        lockButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						changeLockStatus(true);
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
            }
        });
        
        IButton unlockButton = new IButton("解锁节点");
        controlLayout.addMember(unlockButton);
        unlockButton.addClickHandler(new ClickHandler() {
        	@Override
        	public void onClick(ClickEvent event) {
            	GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						changeLockStatus(false);
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
            }
        });
        
        IButton attachmentButton = new IButton("确认函证据");
		controlLayout.addMember(attachmentButton);
		attachmentButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请先选择一条数据");
							return;
						}
						//根据合同id获取合同相关信息
						Map<String,Object> param = new HashMap<>();
						param.put("contractId",contractId);
						DBDataSource.callOperation("ST_Contract", "find",param, new DSCallback() {
	                        @Override
	                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
	                            if (dsResponse.getStatus() >= 0) {
	                            	//获取数据集
	                            	Record[] records = dsResponse.getData();
	                            	if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
	                            		Record r = records[0];
	                            		//获取合同编号和合同名称
	                            		String contractCode = BaseHelpUtils.getString(r.getAttribute("contractCode"));
	                            		String contractName = BaseHelpUtils.getString(r.getAttribute("contractName"));
	                            		PopupWindow window = new PopupWindow("合同：" + contractName + "[" + contractCode + "]的确认函");
	                            		window.setWidth100();
	                            		window.setHeight100();
	                            		OnLoadAttachmentDataOfAttachmentPanel panel = new OnLoadAttachmentDataOfAttachmentPanel();
	                            		panel.setContractId(contractId);
	                            		panel.setIds(getContractStageModelIdFromSelectRecords());						
	                            		panel.showSureButton();
	                            		panel.commonQuery();
	                            		panel.setParentWindow(window);
	                            		panel.addDataEditedHandler(new DataEditedHandler() {
	                            			
	                            			@Override
	                            			public void onDataEdited(DataEditEvent event) {
	                            				commonQuery();
	                            			}
	                            		});
	                            		window.addItem(panel);
	                            		window.centerInPage();
	                            		window.show();
	                            	}else {
	                            		SC.say("提示","未加载到合同信息");
	                            	}
	                            }else {
	                            	ClientUtil.displayErrorMessage(dsResponse);
	                            }
	                        }
	                    });
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton invoiceButton = new IButton("发票证据");
		controlLayout.addMember(invoiceButton);
		invoiceButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请先选择一条数据");
							return;
						}
						//根据合同id获取合同相关信息
						Map<String,Object> param = new HashMap<>();
						param.put("contractId",contractId);
						DBDataSource.callOperation("ST_Contract", "find",param, new DSCallback() {
	                        @Override
	                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
	                            if (dsResponse.getStatus() >= 0) {
	                            	//获取数据集
	                            	Record[] records = dsResponse.getData();
	                            	if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
	                            		Record r = records[0];
	                            		//获取合同编号和合同名称
	                            		String contractCode = BaseHelpUtils.getString(r.getAttribute("contractCode"));
	                            		String contractName = BaseHelpUtils.getString(r.getAttribute("contractName"));
	                            		PopupWindow window = new PopupWindow("合同：" + contractName + "[" + contractCode + "]的发票");
	                            		window.setWidth100();
	                            		window.setHeight100();
	                            		SinvoiceitiorcountPanel panel = new SinvoiceitiorcountPanel();
	                            		panel.setContractId(contractId);
	                            		panel.setIds(getContractStageModelIdFromSelectRecords());						
	                            		panel.showSureButton();
	                            		panel.commonQuery();
	                            		panel.setParentWindow(window);
	                            		panel.addDataEditedHandler(new DataEditedHandler() {
	                            			@Override
	                            			public void onDataEdited(DataEditEvent event) {
	                            				commonQuery();
	                            			}
	                            		});
	                            		window.addItem(panel);
	                            		window.centerInPage();
	                            		window.show();
	                            	}else {
	                            		SC.say("提示","未加载到合同信息");
	                            	}
	                            }else {
	                            	ClientUtil.displayErrorMessage(dsResponse);
	                            }
	                        }
	                    });
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton capitalButton = new IButton("回款证据");
		controlLayout.addMember(capitalButton);
		capitalButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请先选择一条数据");
							return;
						}
						//根据合同id获取合同相关信息
						Map<String,Object> param = new HashMap<>();
						param.put("contractId",contractId);
						DBDataSource.callOperation("ST_Contract", "find",param, new DSCallback() {
	                        @Override
	                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
	                            if (dsResponse.getStatus() >= 0) {
	                            	//获取数据集
	                            	Record[] records = dsResponse.getData();
	                            	if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
	                            		Record r = records[0];
	                            		//获取合同编号和合同名称
	                            		String contractCode = BaseHelpUtils.getString(r.getAttribute("contractCode"));
	                            		String contractName = BaseHelpUtils.getString(r.getAttribute("contractName"));
	                            		PopupWindow window = new PopupWindow("合同：" + contractName + "[" + contractCode + "]的回款");
	                            		window.setWidth100();
	                            		window.setHeight100();
	                            		McapitalecoosmeorPanel panel = new McapitalecoosmeorPanel();
	                            		panel.setContractId(contractId);
	                            		panel.setIds(getContractStageModelIdFromSelectRecords());						
	                            		panel.showSureButton();
	                            		panel.commonQuery();
	                            		panel.setParentWindow(window);
	                            		panel.addDataEditedHandler(new DataEditedHandler() {
	                            			@Override
	                            			public void onDataEdited(DataEditEvent event) {
	                            				commonQuery();
	                            			}
	                            		});
	                            		window.addItem(panel);
	                            		window.centerInPage();
	                            		window.show();
	                            	}else {
	                            		SC.say("提示","未加载到合同信息");
	                            	}
	                            }else {
	                            	ClientUtil.displayErrorMessage(dsResponse);
	                            }
	                        }
	                    });
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton dateEvidenceButton = new IButton("日期证据");
		controlLayout.addMember(dateEvidenceButton);
		dateEvidenceButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请先选择一条数据");
							return;
						}
						SC.askforValue("请输入取得证据的日期", new ValueCallback() {
							
							@Override
							public void execute(String value) {
								GWT.runAsync(new RunAsyncCallback() {
									
									@Override
									public void onSuccess() {
										Date date = new Date();
										String[] arr = value.split("-");
										if(null != arr && arr.length == 3){
											date = new Date(date.UTC(BaseHelpUtils.getIntValue(arr[0]) - 1900, BaseHelpUtils.getIntValue(arr[1]) - 1, BaseHelpUtils.getIntValue(arr[2]), 0, 0, 0));
										}else{
											arr = value.split("/");
											if(null != arr && arr.length == 3){
												date = new Date(date.UTC(BaseHelpUtils.getIntValue(arr[0]) - 1900, BaseHelpUtils.getIntValue(arr[1]) - 1, BaseHelpUtils.getIntValue(arr[2]), 0, 0, 0));
											}else{
												SC.say("请输入正确的时间");
												return;
											}
										}
										String evidence = "日期证据";
										Map<String, Object> params = new HashMap<>();
										params.put("optType", "selectEvidence");
										params.put("evidence", evidence);
										params.put("confirmDate", date);
										params.put("ids", getContractStageModelIdFromSelectRecords());
										DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
											
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if(dsResponse.getStatus() >= 0){
													commonQuery();
												}else{
													ClientUtil.displayErrorMessage(dsResponse);
												}
											}
										});
									}
									
									@Override
									public void onFailure(Throwable reason) {
										SC.say(ClientStaticUtils.WARNING);
									}
								});
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton selectProjectManagerButton = new IButton("选订单项目经理");
        controlLayout.addMember(selectProjectManagerButton);
        selectProjectManagerButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择需要指定项目经理的节点");
							return;
						}
						Record[] records = resultGrid.getSelectedRecords();
						StringBuilder sb = new StringBuilder();
						for(Record record : records){
							int contractStageModelId = BaseHelpUtils.getIntValue(record.getAttributeAsObject("contractStageModelId"));
							if(contractStageModelId > 0){
								if(sb.length() > 0){
									sb.append(",");
								}
								sb.append(contractStageModelId);
							}
						}
						PopupWindow window = new PopupWindow("选订单专业负责人为项目经理");
						window.setWidth(600);
						window.setHeight(200);
						SelectProjectEmployeePanel panel = new SelectProjectEmployeePanel();
						panel.setContractId(contractId);
						panel.setIds(sb.toString());
						panel.setParentWindow(window);
						panel.initComponents();
						panel.addDataEditedHandler(new DataEditedHandler() {
							
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						window.addItem(panel);
						window.centerInPage();
						window.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
        
		IButton selectEmployeeButton = new IButton("指定项目经理");
        controlLayout.addMember(selectEmployeeButton);
        selectEmployeeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择需要指定项目经理的节点");
							return;
						}
						Record[] records = resultGrid.getSelectedRecords();
						StringBuilder sb = new StringBuilder();
						for(Record record : records){
							int contractStageModelId = BaseHelpUtils.getIntValue(record.getAttributeAsObject("contractStageModelId"));
							if(contractStageModelId > 0){
								if(sb.length() > 0){
									sb.append(",");
								}
								sb.append(contractStageModelId);
							}
						}
						PopupWindow window = new PopupWindow("指定职员作为项目经理");
						window.setWidth(370);
						window.setHeight(200);
						SelectEmployeePanel panel = new SelectEmployeePanel();
						panel.setContractId(contractId);
						panel.setIds(sb.toString());
						panel.setParentWindow(window);
						panel.initComponents();
						panel.addDataEditedHandler(new DataEditedHandler() {
							
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						window.addItem(panel);
						window.centerInPage();
						window.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
        
        IButton goToThisLineButton = new IButton("突破到此节点");
        controlLayout.addMember(goToThisLineButton);
        goToThisLineButton.addClickHandler(new ClickHandler() {
        	
        	@Override
        	public void onClick(ClickEvent event) {
        		GWT.runAsync(new RunAsyncCallback() {
        			
        			@Override
        			public void onSuccess() {
        				if(!resultGrid.anySelected()){
        					SC.say("请选择需要突破的节点");
        					return;
        				}
        				ListGridRecord record = resultGrid.getSelectedRecords()[0];
        				int contractStageModelId = BaseHelpUtils.getIntValue(record.getAttributeAsObject("contractStageModelId"));
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "goToThisLine");
						params.put("contractStageModelId", contractStageModelId);
						params.put("contractId", BaseHelpUtils.getIntValue(record.getAttributeAsObject("contractId")));
        				for(int i = resultGrid.getRowNum(record); i >= 0; i--) {
        					ListGridRecord tempRecord = resultGrid.getRecord(i);
        					if(tempRecord.getAttributeAsInt("parentId") == 0) {
        						params.put("rootId", tempRecord.getAttribute("contractStageModelId"));
        						break;
        					}
        				}
						DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									commonQuery();
								}else{
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
        			}
        			
        			@Override
        			public void onFailure(Throwable reason) {
        				SC.say(ClientStaticUtils.WARNING);
        			}
        		});
        	}
        });
        
        IButton cancelFromThisLine = new IButton("取消本行突破");
        controlLayout.addMember(cancelFromThisLine);
        cancelFromThisLine.addClickHandler(new ClickHandler() {
        	
        	@Override
        	public void onClick(ClickEvent event) {
        		GWT.runAsync(new RunAsyncCallback() {
        			
        			@Override
        			public void onSuccess() {
        				if(!resultGrid.anySelected()){
        					SC.say("请选择需要取消突破的节点");
        					return;
        				}
        				Record record = resultGrid.getSelectedRecords()[0];
        				int contractStageModelId = BaseHelpUtils.getIntValue(record.getAttributeAsObject("contractStageModelId"));
        				Map<String, Object> params = new HashMap<>();
        				params.put("optType", "cancelFromThisLine");
        				params.put("contractStageModelId", contractStageModelId);
        				DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
        					
        					@Override
        					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
        						if(dsResponse.getStatus() >= 0){
        							commonQuery();
        						}else{
        							ClientUtil.displayErrorMessage(dsResponse);
        						}
        					}
        				});
        			}
        			
        			@Override
        			public void onFailure(Throwable reason) {
        				SC.say(ClientStaticUtils.WARNING);
        			}
        		});
        	}
        });
        
        IButton viewButton = new IButton("查看/打印");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecords()[0];
						int contractStageModelId = BaseHelpUtils.getIntValue(selected1.getAttributeAsObject("contractStageModelId"));
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "getPrintHtml");
						params.put("contractStageModelId", contractStageModelId);
						DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									Record record = dsResponse.getData()[0];
									if(null != record){
										PopupWindow window = new PopupWindow();
										HTMLPane htmlPane = new HTMLPane();  
								        htmlPane.setWidth100();  
								        htmlPane.setHeight100();  
								        htmlPane.setShowEdges(true);  
								        htmlPane.setBackgroundColor("#fff");
								        htmlPane.setContents(record.getAttribute("value"));  
								        htmlPane.setSelectContentOnSelectAll(true);  
								        htmlPane.draw(); 
								        htmlPane.show();
								        window.addMember(htmlPane);
								        window.setWidth100();
								        window.setHeight100();
								        window.centerInPage();
								        window.show();
								        Object[] arr = new Object[1];
										arr[0] = htmlPane;
										showPrintPreview(arr, null, "查看/打印", new PrintPreviewCallback() {
											@Override
											public void execute(PrintCanvas printCanvas, PrintWindow printWindow) {
												printWindow.addCloseClickHandler(new CloseClickHandler() {
													@Override
													public void onCloseClick(CloseClickEvent event) {
														htmlPane.destroy();
														window.destroy();
													}
												});
											}
										});
									}
								}else{
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
				});
			}
		});
		controlLayout.addMember(viewButton);

	}

	public void changeLockStatus(boolean lock){
		if(resultGrid.anySelected()){
			ListGridRecord[] records = resultGrid.getSelectedRecords();
            StringBuilder sb = new StringBuilder();
            for(ListGridRecord record : records){
            	if(BaseHelpUtils.getIntValue(record.getAttributeAsObject("contractStageModelId")) > 0){
                	if(sb.length() > 0){
                		sb.append(",");
                	}
                	sb.append(record.getAttributeAsObject("contractStageModelId"));
            	}
            }
            if(sb.length() > 0){
            	Map<String, Object> params = new HashMap<>();
            	params.put("optType", "changeLockStatus");
            	params.put("lock", lock);
            	params.put("id", sb.toString());
            	DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							if(lock){
								SC.say("加锁成功");
							}else{
								SC.say("解锁成功");
							}
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
            }
		}else{
			if(lock){
				SC.say("请选择需要加锁的节点");
			}else{
				SC.say("请选择需要解锁的节点");
			}
		}
	}
	
	@Override
    public void fetchDataCallback(DSResponse response, Object rawData) {
        int len = response.getData().length;
        TreeNode[] nodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new TreeNode();
            DBDataSource.copyRecord(response.getData()[i], nodes[i]);
        }
        Tree tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        tree.setRootValue("0");
        tree.setIdField("contractStageModelId");
        tree.setParentIdField("parentId");
        tree.setData(nodes);
        tree.openAll();
        resultGrid.setData(tree);
        resultGrid.selectSingleRecord(0);
        TreeNode selectedNode = resultGrid.getSelectedRecord();
        if (selectedNode != null) {
            resultGrid.openFolder(selectedNode);
        }
    }

    @Override
    public boolean checkSearchCriteria(Criteria criteria) {
    	criteria.addCriteria("contractId", contractId);
    	criteria.addCriteria("addtionalCondition", "order by order_no, stage_model_id");
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return null;
    }

	@Override
	public DataSource getDataSource() {
		return DSContractStageModelList.getInstance();
	}
	
	public String getContractStageModelIdFromSelectRecords(){
		Record[] records = resultGrid.getSelectedRecords();
		StringBuilder sb = new StringBuilder();
		for(Record record : records){
			int contractStageModelId = BaseHelpUtils.getIntValue(record.getAttributeAsObject("contractStageModelId"));
			if(contractStageModelId > 0){
				if(sb.length() > 0){
					sb.append(",");
				}
				sb.append(contractStageModelId);
			}
		}
		return sb.toString();
	}
	
	private String contractId;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
}

