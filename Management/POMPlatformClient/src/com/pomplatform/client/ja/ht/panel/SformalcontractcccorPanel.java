package com.pomplatform.client.ja.ht.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.ja.ht.datasource.DSSformalcontractcccor;
import com.pomplatform.client.ja.ht.form.SformalcontractcccorSearchForm;
import com.pomplatform.client.ja.ht.form.SformalcontractcccorViewer;
import com.pomplatform.client.ja.ht.form.UpdateSformalcontractcccorForm;
import com.pomplatform.client.ja.ht.window.UploadServiceFileForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;

public class SformalcontractcccorPanel extends AbstractSearchPanel
{


	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SformalcontractcccorPanel cm = new SformalcontractcccorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sformalcontractcccor";
		}

	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
//		IButton operation1Button = PermissionControl.createPermissionButton("查看详情", ERPPermissionStatic.FINALLTY_INFO_MANAGEMENT_SELECT_BUTTON);
//		controlLayout.addMember(operation1Button);
//		operation1Button.setIcon("[SKIN]/actions/view.png");
//		operation1Button.addClickHandler(new ClickHandler(){
//			@Override
//			public void onClick(ClickEvent event) {
//				showDetail();
//			}
//		});
//		IButton operation2Button = new IButton("创建正式合同");
//		controlLayout.addMember(operation2Button);
//		operation2Button.setIcon("[SKIN]/actions/add.png");
//		operation2Button.addClickHandler(new ClickHandler(){
//			@Override
//			public void onClick(ClickEvent event) {
//				GWT.runAsync(new RunAsyncCallback() {
//					@Override
//					public void onFailure(Throwable reason) {
//						SC.say("failure to download");
//					}
//					@Override
//					public void onSuccess() {
//						NewSformalcontractcccorForm detailForm = new NewSformalcontractcccorForm();
//						detailForm.setTitle("创建正式合同");
//						detailForm.addDataEditedHandler(new DataEditedHandler(){
//							@Override
//							public void onDataEdited(DataEditEvent event) {
//								RecordList list = resultGrid.getDataAsRecordList();
//								RecordList newList = new RecordList();
//								newList.addList(list.getRange(0, list.getLength()));
//								newList.add(event.getData());
//								resultGrid.setData(newList);
//								resultGrid.selectSingleRecord(newList.getLength()-1);
//							}
//						});
//						detailForm.setSearchForm(searchForm);
//						detailForm.initComponents();
//						detailForm.startEdit();
//						detailForm.setWidth100();
//						detailForm.setHeight100();
//						detailForm.centerInPage();
//						detailForm.show();
//					}
//				});
//			}
//		});
		IButton operation3Button = PermissionControl.createPermissionButton("修改合同", ERPPermissionStatic.UPDATE_CONTRACT_INFO_BTN);
		controlLayout.addMember(operation3Button);
		operation3Button.setIcon("[SKIN]/actions/edit.png");
		operation3Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateSformalcontractcccorForm detailForm = new UpdateSformalcontractcccorForm();
						detailForm.setTitle("修改合同");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), selected1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());
					}
				});
			}
		});
		
		
		IButton uploadButton = PermissionControl.createPermissionButton("服务建议书", ERPPermissionStatic.FINALLTY_INFO_UPLOAD_FILE_BUTTON);
		controlLayout.addMember(uploadButton);
		uploadButton.setIcon("[SKIN]/actions/add.png");
		uploadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
				}else{
					
					GWT.runAsync(new RunAsyncCallback() {
	                    @Override
	                    public void onFailure(Throwable reason) {
	                        SC.say("failure to download code");
	                    }

	                    @Override
	                    public void onSuccess() {
	                    	ListGridRecord[] selected = resultGrid.getSelectedRecords();
	                    	int formalContractId = selected[0].getAttributeAsInt("formalContractId");
	                    	String formalContractName=selected[0].getAttributeAsString("contractName");
	                    	UploadServiceFileForm uploadImg = new UploadServiceFileForm(formalContractId,formalContractName);
	                          uploadImg.addDataEditedHandler(new DataEditedHandler() {
	                              @Override
	                              public void onDataEdited(DataEditEvent event) {
	                                  commonQuery();
	                              }
	                          });
	                          uploadImg.show();
	                    }
	                });
				}
            }
        });
		
//		IButton removeButton = new IButton("删除");
//		controlLayout.addMember(removeButton);
//		removeButton.setIcon("[SKIN]/actions/remove.png");
//		removeButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				if (!resultGrid.anySelected()) {
//					SC.say("Please select a data to remove.");
//				}
//				final ListGridRecord selected = resultGrid.getSelectedRecord();
//				DBDataSource.callOperation("ST_Sformalcontractcccor", "delete", selected.toMap(), new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if (dsResponse.getStatus() < 0) {
//							ClientUtil.displayErrorMessage(dsResponse);
//						} else {
//							int indexNum = resultGrid.getRowNum(selected);
//							resultGrid.removeData(selected);
//							resultGrid.selectSingleRecord(indexNum);
//						}
//					}
//				});
//			}
//		});

		commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("正式合同"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SformalcontractcccorViewer detailForm = new SformalcontractcccorViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by formal_contract_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SformalcontractcccorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSformalcontractcccor.getInstance();
	}

	@Override
    public int getSearchFormHeight() {
        return 60;
    }
}

