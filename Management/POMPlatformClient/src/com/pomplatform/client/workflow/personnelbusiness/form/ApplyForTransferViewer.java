package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSApplyForTransfer;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCheckWorkHandover;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.PrintPreviewCallback;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.PrintCanvas;
import com.smartgwt.client.widgets.PrintWindow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.SplitPane;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class ApplyForTransferViewer extends AbstractDetailViewer {

	private SearchForm __parentSearchForm;
	
	private String processName;
	
	private final DelicacyListGrid workHandoveGrid = new DelicacyListGrid();


	public ApplyForTransferViewer() {
	}

	@Override
	public void initComponents() {
		setWidth100();
		setHeight100();
		setLayoutMargin(5);
		setMembersMargin(5);
		setBackgroundColor("azure");
		setBorder("1px solid gray");
		setCanSelectText(true);
		int horizontalPercent = getHorizontalPercent();
		// 如果没有定义字段分组，或者就一个组
		List<ListGrid> grids = getDetailListGrids();
		List<String> names = getDetailNames();
		List<GroupColumn> gcs = getGroupColumnNames();
		// 那么就是用一个DetailViewer就够了
		DetailViewer mainView = new DetailViewer();
		mainView.setCanSelectText(true);
		mainView.setHeight100();
		mainView.setWidth100();
		mainView.setWrapValues(true);

		mainView.setKeepInParentRect(true);
		// mainView.setWrapLabel(true);
		// 如果有一个分组，就需要给这个DetailViewer增加显示的字段
		if (getGroupCount() == 1) {
			GroupColumn gc = gcs.get(0);
			DetailViewerField[] dvfs = new DetailViewerField[gc.getColumnNames().size()];
			for (int i = 0; i < gc.getColumnNames().size(); i++) {
				dvfs[i] = new DetailViewerField(gc.getColumnNames().get(i));

			}
			mainView.setFields(dvfs);
		}
		mainView.setDataSource(getMainDataSource());
		detailViewers.add(mainView);
		switch (getLayoutMode()) {
		case COMPONENT_LAYOUT_NORMAL:
			SplitPane mainPane = new SplitPane();
			mainPane.setCanSelectText(true);
			mainPane.setShowListToolStrip(false);
			VLayout left = new VLayout();
			left.setCanSelectText(true);
			left.setHeight100();
			left.setPadding(5);
			left.setMembersMargin(10);
			int ii = 0;
			for (DetailViewer detailViewer : detailViewers) {
				if (getGroupCount() > 0 && getIsGroup()) {
					detailViewer.setIsGroup(true);
					detailViewer.setCanSelectText(true);
					detailViewer.setGroupTitle(gcs.get(ii++).getGroupCaption());
				}
				left.addMember(detailViewer);
			}
			if (getDetailCount() > 0) {
				// left.setShowResizeBar(true);
				if (horizontalPercent == 0) {
					left.setWidth("50%");
				} else {
					left.setWidth(String.valueOf((horizontalPercent / 10) * 10) + "%");
				}
			} else {
				// left.setShowResizeBar(false);
				left.setWidth100();
			}
			left.setOverflow(Overflow.AUTO);
			mainPane.setNavigationPane(left);

			if (getDetailCount() > 0) {
				if (getDetailCount() == 1) {
					ListGrid grid = grids.get(0);
					grid.setCanDragSelectText(true);
					grid.setHeight100();
					if (horizontalPercent == 0) {
						grid.setWidth("50%");
					} else {
						grid.setWidth(String.valueOf(((100 - horizontalPercent) / 10) * 10) + "%");
					}
					mainPane.setListPane(grid);
				} else {
					SectionStack detailStack = new SectionStack();
					detailStack.setCanSelectText(true);
					detailStack.setHeight100();
					if (horizontalPercent == 0) {
						detailStack.setWidth("50%");
					} else {
						detailStack.setWidth(String.valueOf(((100 - horizontalPercent) / 10) * 10) + "%");
					}
					detailStack.setVisibilityMode(VisibilityMode.MULTIPLE);
					for (int i = 0; i < getDetailCount(); i++) {

						SectionStackSection detailSection = new SectionStackSection(names.get(i));
						detailSection.addItem(grids.get(i));
						detailSection.setExpanded(true);
						detailStack.addSection(detailSection);
					}
					mainPane.setListPane(detailStack);
				}
			}
			VLayout v = new VLayout();
			v.setHeight100();
			v.setWidth100();
			IButton printBtn = new IButton("打印转岗单");
			HLayout hLayout = new HLayout();
			hLayout.setWidth100();
			hLayout.setHeight(30);
			hLayout.setAlign(Alignment.RIGHT);
			hLayout.addMember(printBtn);
			hLayout.setMargin(5);
			printBtn.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					if(null != getRecord()){
//						ApplyForTransferPrintView panel = new ApplyForTransferPrintView(resultGrid.getSelectedRecord());
						Map params = getRecord().toMap();
						params.put("optType", "getTranseferHtml");
						params.put("type", 2);
						params.put("operator", KeyValueManager.getValue("employees", ClientUtil.getUserId()));
						DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
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
										showPrintPreview(arr, null, "工作交接单", new PrintPreviewCallback() {
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
					
				}
			});
			v.addMember(mainPane);
			if(null != getProcessName() && getProcessName().contains("人事专员")){
				v.addMember(hLayout);
			}
			addMember(v);
		}
		workHandoveGrid.setDataSource(DSCheckWorkHandover.getInstance());
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "Spersonnelbusinesppor";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		return gcs;
	}

	@Override
	public void load() {
		if (getBusinessId() == null)
			return;
		Map params = new HashMap();
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("NQ_Spersonnelbusinesppor", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					for (DetailViewer v : detailViewers) {
						v.setData(dsResponse.getData());
						if (dsResponse.getData().length == 0)
							continue;
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
	public void viewSelectedData(ListGrid grid) {
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	public void viewDetailData() {
		Record selected = getRecord();
		Object val;
		java.util.Map condition = null;
		java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap() : __parentSearchForm.getValues();
		condition = new java.util.HashMap();
		condition.put("optType", "getWorkhandovers");
		condition.put("type", 2);
		condition.put("businessId", selected.getAttributeAsString("personnelBusinessId"));
		DBDataSource.callOperation("EP_MyPersonnelProcessor", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					workHandoveGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSApplyForTransfer.getInstance();
	}

	@Override
	public int getDetailCount() {
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(workHandoveGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("待办事项");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm(SearchForm value) {
		this.__parentSearchForm = value;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

}
