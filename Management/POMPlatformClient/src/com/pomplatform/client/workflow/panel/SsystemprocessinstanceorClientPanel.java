package com.pomplatform.client.workflow.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.PaginationPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.management.panel.SsystemprocessinstanceorPanel;
import com.delicacy.client.ui.EditProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class SsystemprocessinstanceorClientPanel extends SsystemprocessinstanceorPanel {
	private static final Logger logger = Logger.getLogger("");
	private Integer projectNormalProcess = 0;
	private Integer commonNormalProcess = 0;
	private Integer projectTravelProcess = 0;
	private Integer commonTravelProcess = 0;
	private Integer borrowMoneyProcess = 0;
	private Integer paymentProcess = 0;
	private static final String PROCESSID = "processId";

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			SsystemprocessinstanceorClientPanel cm = new SsystemprocessinstanceorClientPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SsystemprocessinstanceorClient";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;

	}
	
	@Override
	public void initComponents() {
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
				ListGridRecord selected = resultGrid.getSelectedRecord();
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.show();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("please select a record to edit");
					return;
				}
				ListGridRecord selected = resultGrid.getSelectedRecord();
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.show();
			}
		});
		controlLayout.addMember(viewButton);

		IButton editButton = new IButton("撤销修改");
		controlLayout.addMember(editButton);
		editButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("please select a record to edit");
					return;
				}
				ListGridRecord selected = resultGrid.getSelectedRecord();
				int status = selected.getAttributeAsInt("processStatus");
				if (status != 0) {
					SC.say("对不起，该申请不能修改！");
					return;
				}
				EditProcessWindow Reimbursement = new EditProcessWindow();
				Reimbursement.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						DBDataSource.copyRecord(event.getData(), resultGrid.getSelectedRecord());
						resultGrid.redraw();
					}
				});
				Integer processType = selected.getAttributeAsInt("processType");
				if (null != processType && (processType.equals(4) || processType.equals(5))) {
					Reimbursement.setLayoutMode(1);
				} else {
					Reimbursement.setLayoutMode(0);
				}
				Reimbursement.setProcessId(selected.getAttributeAsInt("processId"));
				Reimbursement.setInstanceData(selected);
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.show();
			}
		});

		commonQuery();
	}

	@Override
	public Canvas getViewPanel() {
		Map<String,String> processIdMap = PomPlatformClientUtil.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_1);
		logger.info(MapUtils.toJSON(processIdMap));
		projectNormalProcess = ClientUtil.checkAndGetIntValue(processIdMap.get("Project_normal_reimbursement"));
		commonNormalProcess = ClientUtil.checkAndGetIntValue(processIdMap.get("Common_normal_reimbursement"));
		projectTravelProcess = ClientUtil.checkAndGetIntValue(processIdMap.get("Project_travel_reimbursement"));
		commonTravelProcess = ClientUtil.checkAndGetIntValue(processIdMap.get("Common_travel_reimbursement"));
		borrowMoneyProcess = ClientUtil.checkAndGetIntValue(processIdMap.get("Borrow_money_manage"));
		paymentProcess = ClientUtil.checkAndGetIntValue(processIdMap.get("Pay_money_manage"));
		init();
		searchForm = generateSearchForm();
		VLayout layout = new VLayout();
		layout.setWidth100();
		layout.setHeight100();
		layout.setBackgroundColor("#e2e2e2");

		HLayout bLayout = new HLayout();
		bLayout.setWidth100();
		bLayout.setHeight("8%");
		if (null != commonNormalProcess && commonNormalProcess > 0) {
			final ImgButton button1 = new ImgButton();
			button1.setWidth(160);
			button1.setHeight(80);
			button1.setSrc("process/1.jpg");
			button1.setCursor(Cursor.POINTER);
			button1.setMargin(10);
			button1.setID(PROCESSID + "_" + commonNormalProcess);
			button1.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					newPanel(button1.getID().split("_")[1], 0);
				}
			});
			bLayout.addMember(button1);
		}
		if (null != projectNormalProcess && projectNormalProcess > 0) {
			final ImgButton button2 = new ImgButton();
			button2.setSrc("process/2.jpg");
			button2.setWidth(160);
			button2.setHeight(80);
			button2.setCursor(Cursor.POINTER);
			button2.setMargin(10);
			button2.setID(PROCESSID + "_" + projectNormalProcess);
			button2.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					newPanel(button2.getID().split("_")[1], 0);
				}
			});
			bLayout.addMember(button2);
		}
		if (null != commonTravelProcess && commonTravelProcess > 0) {
			final ImgButton button3 = new ImgButton();
			button3.setSrc("process/3.jpg");
			button3.setWidth(160);
			button3.setHeight(80);
			button3.setCursor(Cursor.POINTER);
			button3.setMargin(10);
			button3.setID(PROCESSID + "_" + commonTravelProcess);
			button3.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					newPanel(button3.getID().split("_")[1], 1);
				}
			});
			bLayout.addMember(button3);
		}
		if (null != projectTravelProcess && projectTravelProcess > 0) {
			final ImgButton button4 = new ImgButton();
			button4.setSrc("process/4.jpg");
			button4.setWidth(160);
			button4.setHeight(80);
			button4.setCursor(Cursor.POINTER);
			button4.setMargin(10);
			button4.setID(PROCESSID + "_" + projectTravelProcess);
			button4.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					newPanel(button4.getID().split("_")[1], 1);
				}
			});
			bLayout.addMember(button4);
		}
		if (null != borrowMoneyProcess && borrowMoneyProcess > 0) {
			final ImgButton button5 = new ImgButton();
			button5.setSrc("process/5.jpg");
			button5.setWidth(160);
			button5.setHeight(80);
			button5.setCursor(Cursor.POINTER);
			button5.setMargin(10);
			button5.setID(PROCESSID + "_" + borrowMoneyProcess);
			button5.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					newPanel(button5.getID().split("_")[1], 0);
				}
			});
			bLayout.addMember(button5);
		}
		if (null != paymentProcess || paymentProcess > 0) {
			final ImgButton button6 = new ImgButton();
			button6.setSrc("process/6.jpg");
			button6.setWidth(160);
			button6.setHeight(80);
			button6.setCursor(Cursor.POINTER);
			button6.setMargin(10);
			button6.setID(PROCESSID + "_" + paymentProcess);
			button6.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					newPanel(button6.getID().split("_")[1], 0);
				}
			});
			bLayout.addMember(button6);
		}
		layout.addMember(bLayout);
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
		resultGrid.setCanDragSelectText(true);
		main.addMember(mainCanvas);
		if (__needControl && __controlPosition == LayoutConstant.RIGHT) {
			main.addMember(controlLayout);
		}
		if (__needControl && __controlPosition == LayoutConstant.BOTTOM) {
			resultLayout.addMember(toolBar);
		}
		layout.addMember(resultLayout);

		if (Browser.getIsDesktop() && showPagination()) {
			pager = new PaginationPanel();
			resultLayout.addMember(pager);

			pager.getGotoButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					TextItem item = pager.getGotoPage();
					String strPageNo = item.getValueAsString();
					if (strPageNo == null || strPageNo.equals("")) {
						return;
					}
					currentPage = Integer.parseInt(strPageNo);
					commonQuery();
				}
			});
			pager.getFirstButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					currentPage = 1;
					commonQuery();
				}
			});
			pager.getPreviousButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (currentPage > 1) {
						currentPage--;
						commonQuery();
					}
				}
			});
			pager.addKeyPressHandler(new KeyPressHandler() {

				@Override
				public void onKeyPress(KeyPressEvent event) {
					if (event.getKeyName() != null) {
						switch (event.getKeyName()) {
						case "Arrow_Right":
							if (currentPage < totalPages) {
								currentPage++;
								commonQuery();
							}
							break;
						case "Arrow_Left":
							if (currentPage > 1) {
								currentPage--;
								commonQuery();
							}
							break;
						}
					}
				}
			});
			pager.getNextButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (currentPage < totalPages) {
						currentPage++;
						commonQuery();
					}
				}
			});
			pager.getLastButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (totalPages > 0) {
						currentPage = totalPages;
						commonQuery();
					}
				}
			});
			pager.getRefreshButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					commonQuery();
				}
			});
		}
		initComponents();
		if (showControlPanel()) {
			setControlLayoutWidth();
		}
		return layout;
	}
	
	private void newPanel(String processId,int layoutMode){
		NewProcessWindow Reimbursement = new NewProcessWindow();
		Reimbursement.addDataEditedHandler(new DataEditedHandler() {
			@Override
			public void onDataEdited(DataEditEvent event) {
				commonQuery();
			}
		});
		Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(processId));
		Reimbursement.setLayoutMode(layoutMode);
		Reimbursement.initComponents();
		Reimbursement.setTitle(KeyValueManager.getValue("employee_processes", processId));
		Reimbursement.show();
	}
	
}
