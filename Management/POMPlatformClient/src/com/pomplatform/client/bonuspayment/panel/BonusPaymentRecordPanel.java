package com.pomplatform.client.bonuspayment.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.bonuspayment.datasource.DSBonusPaymentRecord;
import com.pomplatform.client.bonuspayment.form.BonusPaymentRecordSearchForm;
import com.pomplatform.client.bonuspayment.form.BonusPaymentRecordViewer;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class BonusPaymentRecordPanel extends AbstractSearchPanel {

	private String plateIds;
	private String[] plateIdArr;
	private static Logger __logger = Logger.getLogger("");
	
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			BonusPaymentRecordPanel cm = new BonusPaymentRecordPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "BonusPaymentRecord";
		}

	}

	@Override
	public void initComponents() {
		
		plateIds = PomPlatformClientUtil.getRolePlateId();
		plateIdArr = plateIds.split(",");
		
		resultGrid.setShowRowNumbers(true);

		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
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
		
		IButton applyWorkProcessButton = PermissionControl.createPermissionButton("奖金发放申请",
				ERPPermissionStatic.BONUS_PAYMENT_APPLY_BUTTON);
		controlLayout.addMember(applyWorkProcessButton);
		applyWorkProcessButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				//获取process_id
				String processId = "";
				Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
		    	if(!PomPlatformClientUtil.isNullOrEmpty(str)){
		    		String[] arr = str.split(",");
		    		for(String tempStr : arr){
		    			String[] tempArr = tempStr.split(":");
		    			//获取父级ID
		    			if(tempArr[0].replaceAll("\"", "").equals("Bonus_Application")){
		    				processId = tempArr[1];
		    			}
		    		}
		    	}
				NewProcessWindow panel = new NewProcessWindow();
				panel.setTitle("奖金发放申请");
				panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
				panel.setLayoutMode(0);
				panel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				panel.initComponents();
				panel.setWidth100();
				panel.setHeight100();
				panel.centerInPage();
				panel.show();
			}
		});

		IButton applyButton = PermissionControl.createPermissionButton("一级业务奖金发放申请",
				ERPPermissionStatic.BONUS_PAYMENT_APPLY_BUTTON);
//		controlLayout.addMember(applyButton);
		applyButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final String plateIds = PomPlatformClientUtil.getRolePlateId();
				if(plateIds.length() == 0){
					return;
				}
				int plateId = ClientUtil.checkAndGetIntValue(plateIds.split(",")[0]);
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取业务部门价值积分
				final PopupWindow popupWindow = new PopupWindow(palteName + "-奖金发放申请");
				popupWindow.setWidth("70%");
				popupWindow.setHeight100();
				popupWindow.centerInPage();
				BonusPaymentApplyPanel applyPanel = new BonusPaymentApplyPanel();
				if(plateIds.indexOf(",")>0){
					applyPanel.setPlateIdArray(plateIds.split(","));
				}
				applyPanel.setPlateId(plateId);
				applyPanel.initComponents(palteName);
				popupWindow.addItem(applyPanel);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						commonQuery();
					}
				});
				applyPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});

		IButton auditButton = PermissionControl.createPermissionButton("审核处理",
				ERPPermissionStatic.BONUS_PAYMENT_AUDIT_BUTTON);
//		controlLayout.addMember(auditButton);
		auditButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecords()[0];
				Map map = record.toMap();
				if (ClientUtil.checkAndGetIntValue(record.getAttribute("bonusPaymentRecordId")) == 0) {
					SC.say("该数据无法进行审核");
					return;
				}
				if (ClientUtil.checkAndGetIntValue(record.getAttribute("state")) != 0) {
					SC.say("该申请已审核");
					return;
				}
				// 获取业务部门名称
				String palteName = KeyValueManager.getValue("system_dictionary_1", record.getAttribute("plateId"));
				// 获取业务部门价值积分
				final PopupWindow popupWindow = new PopupWindow(palteName + "-奖金发放审核");
				popupWindow.setWidth("70%");
				popupWindow.setHeight100();
				popupWindow.centerInPage();
				BonusPaymentAuditPanel auditPanel = new BonusPaymentAuditPanel();
				auditPanel.setMap(map);
				auditPanel.initComponents(palteName);
				auditPanel.load();
				popupWindow.addItem(auditPanel);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
						commonQuery();
					}
				});
				auditPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});

		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double payIntegral = 0;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						payIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("payIntegral"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("plateId", "汇总");
					record.setAttribute("payIntegral", payIntegral);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
				}
			}
		});

		
		//二级部门奖金发放申请
		IButton applyButton2 = PermissionControl.createPermissionButton("奖金发放申请",
				ERPPermissionStatic.HAVE_LEVEL_TWO_PLATE_BONUS_APPLY_BUTTON);
//		controlLayout.addMember(applyButton2);
		applyButton2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final String plateIds = PomPlatformClientUtil.getRolePlateId();
				if(plateIds.length() == 0){
					return;
				}
				if(plateIds.length() > 0){
					Map<String,String> plateMap = new HashMap<>();
					plateMap.put("arr", plateIds);
					plateMap.put("opt_type", "findPlateLevel");
					DBDataSource.callOperation("EP_BonusPaymentProcessor", plateMap, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record[] plateRecords = dsResponse.getData();
								int i = 0;
								String[] arrlist = new String[plateRecords.length];
								for(Record e : plateRecords){
									arrlist[i] = e.getAttribute("plateId");
									i++;
								}
								OtherBonusPaymentApplyPanel applyPanel = new OtherBonusPaymentApplyPanel();
								int plateId = ClientUtil.checkAndGetIntValue(arrlist[0]);
								// 获取业务部门名称
								String palteName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
								final PopupWindow popupWindow = new PopupWindow(palteName + "-奖金发放申请");
								popupWindow.setWidth("70%");
								popupWindow.setHeight100();
								popupWindow.centerInPage();
								applyPanel.setPlateIdArray(arrlist);  
								applyPanel.setPlateId(plateId);
								applyPanel.startEdit();
								applyPanel.initComponents(palteName);
								popupWindow.addItem(applyPanel);
								popupWindow.addCloseClickHandler(new CloseClickHandler() {
									@Override
									public void onCloseClick(CloseClickEvent event) {
										popupWindow.destroy();
										commonQuery();
									}
								});
								applyPanel.setParentWindow(popupWindow);
								popupWindow.centerInPage();
								popupWindow.show();
							}
						}
					});
				}
			}
		});
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("奖金发放申请记录");
				detail.setWidth100();
				detail.setHeight100();
				BonusPaymentRecordViewer detailForm = new BonusPaymentRecordViewer();
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
    public Canvas getViewPanel() {
        init();
        searchForm = generateSearchForm();
        VLayout layout = new VLayout();
        layout.setWidth100();
        layout.setHeight100();
        layout.setBackgroundColor("#e2e2e2");

        if (searchForm != null) {
            ClientUtil.searchFormProcessAccordingToDevice(searchForm);
            if (getSearchFormHeight() > 0) {
                searchForm.setHeight(getSearchFormHeight());
            }
            HLayout searchLayout = new HLayout(5);
            searchLayout.setMargin(10);
            layout.addMember(searchLayout);

            searchForm.setWidth100();
            searchLayout.addMember(searchForm);

            VLayout buttonLayout = new VLayout(5);
            searchButton = new IButton("搜索");
            searchButton.setIcon("[SKIN]/actions/search.png");

            IButton resetButton = new IButton("重置");
            resetButton.setIcon("[SKIN]/actions/redo.png");

            buttonLayout.addMember(searchButton);
            buttonLayout.addMember(resetButton);

            searchLayout.addMember(buttonLayout);

            searchButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    currentPage = 1;
                    commonQuery();
                }
            });

            resetButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    searchForm.editNewRecord();
                }
            });
        }
        VLayout resultLayout = new VLayout();
        resultLayout.setWidth100();
        resultLayout.setHeight100();
        if (__needControl) {
            switch (__controlPosition) {
                case LayoutConstant.TOP:
                case LayoutConstant.BOTTOM:
                    toolBar = new ToolStrip();
                    toolBar.setHeight(40);
                    break;
                case LayoutConstant.RIGHT:
                case LayoutConstant.LEFT:
                    controlLayout = new VLayout();
                    controlLayout.setHeight100();
                    controlLayout.setWidth(120);
                    controlLayout.setLayoutTopMargin(30);
                    controlLayout.setLayoutLeftMargin(5);
                    controlLayout.setLayoutRightMargin(5);
                    controlLayout.setMembersMargin(10);
                    break;
            }
        }
        if (__needControl && __controlPosition == LayoutConstant.TOP) {
            resultLayout.addMember(toolBar);
        }
        HLayout main = new HLayout();
        main.setWidth100();
        main.setHeight100();
        resultLayout.addMember(main);
        if (__needControl && __controlPosition == LayoutConstant.LEFT) {
            main.addMember(controlLayout);
        }
        Canvas mainCanvas = null;
        if (__layoutMode == LayoutConstant.LEFTRIGHT) {
            mainCanvas = generateHDataCanvas();
        } else {
            mainCanvas = generateVDataCanvas();
        }
        main.addMember(mainCanvas);
        if (__needControl && __controlPosition == LayoutConstant.RIGHT) {
            main.addMember(controlLayout);
        }
        if (__needControl && __controlPosition == LayoutConstant.BOTTOM) {
            resultLayout.addMember(toolBar);
        }
        layout.addMember(resultLayout);
        initComponents();
        if (showControlPanel()) {
            setControlLayoutWidth();
        }
        return layout;
    }
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getEmployeeId());
		// 如果拥有查看所有部门数据，则加载所有数据
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.BONUS_PAYMENT_CHECK_ALL)) {
			return true;
		} else if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.BONUS_PAYMENT_CHECK_ALL)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.BONUS_PAYMENT_CHECK_MYSELF)) {
			/*
			 * 只拥有查看自己部门数据的权限 
			 * ①用户是否在部门选择下拉框选择了某一个部门想进行信息查看？
			 * ②Y:用户是否拥有该部门的数据查看权限？ →有权限：返回true； 没有权限：返回false 
			 * ③N:默认加载该用户所可以查看的所有部门的信息
			 */
			String selectPlateId = BaseHelpUtils.getString(criteria.get("plateId"));
			if (BaseHelpUtils.isNullOrEmpty(selectPlateId)) {
				criteria.put("plateId", plateIds);
				return true;
			} else {
				for (String str : plateIdArr) {
					if (selectPlateId.equals(str)) {
						return true;
					}
				}
			}
		}
		SC.warn("提示", "您没有查看该部门数据的权限");
		return false;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new BonusPaymentRecordSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSBonusPaymentRecord.getInstance();
	}

}
