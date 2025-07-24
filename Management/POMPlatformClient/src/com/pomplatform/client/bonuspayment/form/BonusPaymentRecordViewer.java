package com.pomplatform.client.bonuspayment.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.bonuspayment.datasource.DSBonusPaymentDetail;
import com.pomplatform.client.bonuspayment.datasource.DSBonusPaymentRecord;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;

public class BonusPaymentRecordViewer extends AbstractDetailViewer {

	private SearchForm __parentSearchForm;
	private final DelicacyListGrid bonusPaymentDetailGrid = new DelicacyListGrid();

	public BonusPaymentRecordViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();

		bonusPaymentDetailGrid.setDataSource(DSBonusPaymentDetail.getInstance());
		bonusPaymentDetailGrid.setShowRowNumbers(true);
		bonusPaymentDetailGrid.setCanEdit(false);
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "奖金发放申请记录";
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
	public void viewSelectedData(ListGrid grid) {
		super.viewSelectedData(grid);
		Record selected = grid.getSelectedRecord();
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "prepareAuditInfo");
		params.put("bonusPaymentRecordId", selected.getAttributeAsInt("bonusPaymentRecordId"));
		DBDataSource.callOperation("EP_BonusPaymentProcessor", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					bonusPaymentDetailGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSBonusPaymentRecord.getInstance();
	}

	@Override
	public int getDetailCount() {
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(bonusPaymentDetailGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("奖金发放申请详情");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm(SearchForm value) {
		this.__parentSearchForm = value;
	}

}
