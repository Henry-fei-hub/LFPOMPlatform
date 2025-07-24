package com.pomplatform.client.project.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.aboutprojectquotetemplatesparent.panel.AddProjectQuoteTemplatesParentPanel;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.project.datasource.DSProjectQuoteTemplate;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DropCompleteEvent;
import com.smartgwt.client.widgets.events.DropCompleteHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.DataChangedEvent;
import com.smartgwt.client.widgets.grid.events.DataChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class ProjectQuoteTemplatePanel extends AbstractSearchTree
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ProjectQuoteTemplatePanel cm = new ProjectQuoteTemplatePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectQuoteTemplate";
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
		resultGrid.setShowFilterEditor(false);
		resultGrid.setCanEdit(true);
		TreeGridField[] fields = new TreeGridField[9];
		int idx = 0;
		fields[idx] = new TreeGridField("parentId");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("businessType");
		fields[idx].setFrozen(true);
		fields[idx].setWidth(300);
		idx ++;
		fields[idx] = new TreeGridField("projectQuoteTemplateId");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("designTypeName");
		idx ++;
		fields[idx] = new TreeGridField("designContent");        
		idx ++;
		fields[idx] = new TreeGridField("designStage");        
		idx ++;
		fields[idx] = new TreeGridField("areaType");
		idx ++;
		fields[idx] = new TreeGridField("tax");
		fields[idx].setFormat("#,###,###,###,###,##0.00");
		idx ++;
		fields[idx] = new TreeGridField("companyId");
		idx ++;
		fields[idx] = new TreeGridField("operateTime");
		idx ++;
		fields[idx] = new TreeGridField("remark");
		idx ++;
		fields[idx] = new TreeGridField("projectQuoteTemplatesParentId");
		fields[idx].setHidden(true);
		resultGrid.setFields(fields);
		//resultGrid.setShowFilterEditor(true);
		resultGrid.setFilterOnKeypress(true);
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				int rowNum=BaseHelpUtils.getIntValue(event.getRowNum());
				Record record=resultGrid.getRecord(rowNum);
				int projectQuoteTemplatesParentId=BaseHelpUtils.getIntValue(record.getAttribute("projectQuoteTemplatesParentId"));
				Map<String,Object> map=new HashMap<>();
				map.put("projectQuoteTemplatesParentId", projectQuoteTemplatesParentId);
				Record records=SyncDataUtil.getValueByTableName("ST_ProjectQuoteTemplatesParent", "find", map);
				int businessType=BaseHelpUtils.getIntValue(records.getAttribute("businessType"));
				if(businessType==45) {
					resultGrid.getField("businessType").setCanEdit(true);
				}else {
					resultGrid.getField("businessType").setCanEdit(false);
				}
			}
		});
		/*resultGrid.addDropCompleteHandler(new DropCompleteHandler() {
			@Override
			public void onDropComplete(DropCompleteEvent event) {
				Record[] rs = event.getTransferredRecords();
				DBDataSource.printRecord(rs[0]);
				for (Record r : rs) {
					DBDataSource.callOperation("ST_ProjectQuoteTemplate", "update", r.toMap(), new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								ClientUtil.displayErrorMessage(dsResponse);
							}
						}
					});
				}
			}
		});*/

		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				params.put("projectQuoteTemplatesParentId", BaseHelpUtils.getIntValue(record.getAttribute("projectQuoteTemplatesParentId")));
				Object parentId = params.get("parentId");
				if (parentId == null) {
					params.put("parentId", "0");
				}
				params.put("operateTime",new Date());
				final int rowNumModified = event.getRowNum();
				final LoadingWindow loading = new LoadingWindow();
				DBDataSource.callOperation("ST_ProjectQuoteTemplate", "saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
							DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
							loading.destroy();
							resultGrid.redraw();
						}
					}
				});
			}
		});

		IButton newButton = new IButton("新建");
		controlLayout.addMember(newButton);
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Tree tree = resultGrid.getData();
				TreeNode node = new TreeNode();
				node.setIsFolder(true);
				int businessType=BaseHelpUtils.getIntValue(record.getAttribute("businessType"));
				if(businessType==45) {//综合体
					resultGrid.getField("businessType").setCanEdit(true);
				}else {
					node.setAttribute("businessType", businessType);
					resultGrid.getField("businessType").setCanEdit(false);
				}
				tree.add(node, "/", 0);
				resultGrid.selectSingleRecord(0);
				resultGrid.startEditing();
			}
		});

		IButton newChildButton = new IButton("新建子项");
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
				DBDataSource.copyRecordNotInclude(currentNode, newNode, "projectQuoteTemplateId", "children", "isFolder");
				newNode.setAttribute("parentId", ClientUtil.checkAndGetIntValue(currentNode.getAttribute("projectQuoteTemplateId")));
				int businessType=BaseHelpUtils.getIntValue(record.getAttribute("businessType"));
				if(businessType==45) {//综合体
					resultGrid.getField("businessType").setCanEdit(true);
				}else {
					newNode.setAttribute("businessType", businessType);
					resultGrid.getField("businessType").setCanEdit(false);
				}
				DBDataSource.printRecord(newNode);
				newNode = tree.add(newNode, currentNode);
				resultGrid.openFolder(currentNode);
				resultGrid.selectSingleRecord(newNode);
				resultGrid.startEditing(resultGrid.getRowNum(newNode));
			}
		});
		
		
		IButton priceButton = new IButton("面积区间");
		controlLayout.addMember(priceButton);
		priceButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				final PopupWindow popupWindow = new PopupWindow("模板面积区间");
				popupWindow.setWidth("60%");
				popupWindow.setHeight("60%");
				ProjectQuoteAreaRangePanel pricePanel = new ProjectQuoteAreaRangePanel();
				Record record=resultGrid.getSelectedRecord();
				pricePanel.initComponents();
				pricePanel.setRecord(record);
				pricePanel.lodaData();
				popupWindow.addItem(pricePanel);
				pricePanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				pricePanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});

		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				SC.ask("提示","您确认好删除吗?",new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value) {
							final ListGridRecord selected = resultGrid.getSelectedRecord();
							DBDataSource.callOperation("ST_ProjectQuoteTemplate", "delete", selected.toMap(), new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() < 0) {
										ClientUtil.displayErrorMessage(dsResponse);
									} else {
										int indexNum = resultGrid.getRowNum(selected);
										resultGrid.removeData(selected);
										resultGrid.selectSingleRecord(indexNum);
										SC.say("删除成功！");
										commonQuery();
									}
								}
							});
						}
					}
				});
			}
		});
		

		//commonQuery();
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
		tree.setIdField("projectQuoteTemplateId");
		tree.setParentIdField("parentId");
		tree.setData(nodes);
		resultGrid.setData(tree);
		resultGrid.selectSingleRecord(0);
		TreeNode selectedNode = resultGrid.getSelectedRecord();
		if(selectedNode != null) resultGrid.openFolder(selectedNode);
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		
		criteria.put("projectQuoteTemplatesParentId",BaseHelpUtils.getIntValue(record.getAttribute("projectQuoteTemplatesParentId")));
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectQuoteTemplate.getInstance();
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

	public Window getParentWindow() {
		return parentWindow;
	}
	
	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}
	private Window parentWindow;
	
	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	

}

