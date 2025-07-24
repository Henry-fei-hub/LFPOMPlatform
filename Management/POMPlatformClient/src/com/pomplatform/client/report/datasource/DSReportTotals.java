package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportTotals extends DBDataSource
{


	public static DSReportTotals instance = null;

	public static DSReportTotals getInstance() {
		if(instance == null) {
			instance = new DSReportTotals("DSReportTotals");
		}
		return instance;
	}

	private final DataSourceIntegerField reportTotalIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField yearField;
	private final DataSourceFloatField monthRevenueField;
	private final DataSourceFloatField totalRevenueField;
	private final DataSourceFloatField monthCapitalPlateField;
	private final DataSourceFloatField totalCapitalPlateField;
	private final DataSourceFloatField monthCapitalProjectField;
	private final DataSourceFloatField totalCapitalProjectField;
	private final DataSourceFloatField monthSureIntegralPlateField;
	private final DataSourceFloatField totalSureIntegralPlateField;
	private final DataSourceFloatField monthSureIntegralProjectField;
	private final DataSourceFloatField totalSureIntegralProjectField;
	private final DataSourceFloatField monthSalaryField;
	private final DataSourceFloatField totalSalaryField;
	private final DataSourceFloatField monthCostPlateField;
	private final DataSourceFloatField totalCostPlateField;
	private final DataSourceFloatField monthCostProjectField;
	private final DataSourceFloatField totalCostProjectField;
	private final DataSourceFloatField monthCostProjectBeforeField;
	private final DataSourceFloatField totalCostProjectBeforeField;
	private final DataSourceFloatField monthNewContractField;
	private final DataSourceFloatField totalNewContractField;
	private final DataSourceFloatField contractTotalField;
	private final DataSourceFloatField averageEmpNumField;
	private final DataSourceIntegerField minEmpNumField;
	private final DataSourceFloatField yearAverageEmpRevenueField;
	private final DataSourceFloatField yearCapitalField;
	private final DataSourceFloatField benefitField;
	private final DataSourceFloatField yearRevenueField;

	public DSReportTotals(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportTotals");

		
		reportTotalIdField = new DataSourceIntegerField("reportTotalId","主键编码");
		reportTotalIdField.setLength(11);
		reportTotalIdField.setRequired(false);
		reportTotalIdField.setHidden(true);
		
		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdField.setCanEdit(false);


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);
		yearField.setCanEdit(false);

		monthRevenueField = new DataSourceFloatField("monthRevenue", "本月不含税营收");
		monthRevenueField.setLength(18);
		monthRevenueField.setDecimalPad(2);
		monthRevenueField.setFormat("#,###,###,###,###,##0.00");
		monthRevenueField.setRequired(false);
		monthRevenueField.setHidden(false);
		monthRevenueField.setCanEdit(false);


		totalRevenueField = new DataSourceFloatField("totalRevenue", "累计不含税营收");
		totalRevenueField.setLength(18);
		totalRevenueField.setDecimalPad(2);
		totalRevenueField.setFormat("#,###,###,###,###,##0.00");
		totalRevenueField.setRequired(false);
		totalRevenueField.setHidden(false);
		totalRevenueField.setCanEdit(false);


		monthCapitalPlateField = new DataSourceFloatField("monthCapitalPlate", "部门");
		monthCapitalPlateField.setLength(18);
		monthCapitalPlateField.setDecimalPad(2);
		monthCapitalPlateField.setFormat("#,###,###,###,###,##0.00");
		monthCapitalPlateField.setRequired(false);
		monthCapitalPlateField.setHidden(false);
		monthCapitalPlateField.setCanEdit(false);


		totalCapitalPlateField = new DataSourceFloatField("totalCapitalPlate", "部门");
		totalCapitalPlateField.setLength(18);
		totalCapitalPlateField.setDecimalPad(2);
		totalCapitalPlateField.setFormat("#,###,###,###,###,##0.00");
		totalCapitalPlateField.setRequired(false);
		totalCapitalPlateField.setHidden(false);
		totalCapitalPlateField.setCanEdit(false);

		monthCapitalProjectField = new DataSourceFloatField("monthCapitalProject", "项目组");
		monthCapitalProjectField.setLength(18);
		monthCapitalProjectField.setDecimalPad(2);
		monthCapitalProjectField.setFormat("#,###,###,###,###,##0.00");
		monthCapitalProjectField.setRequired(false);
		monthCapitalProjectField.setHidden(false);
		monthCapitalProjectField.setCanEdit(false);


		totalCapitalProjectField = new DataSourceFloatField("totalCapitalProject", "项目组");
		totalCapitalProjectField.setLength(18);
		totalCapitalProjectField.setDecimalPad(2);
		totalCapitalProjectField.setFormat("#,###,###,###,###,##0.00");
		totalCapitalProjectField.setRequired(false);
		totalCapitalProjectField.setHidden(false);
		totalCapitalProjectField.setCanEdit(false);


		monthSureIntegralPlateField = new DataSourceFloatField("monthSureIntegralPlate", "部门");
		monthSureIntegralPlateField.setLength(18);
		monthSureIntegralPlateField.setDecimalPad(2);
		monthSureIntegralPlateField.setFormat("#,###,###,###,###,##0.00");
		monthSureIntegralPlateField.setRequired(false);
		monthSureIntegralPlateField.setHidden(false);
		monthSureIntegralPlateField.setCanEdit(false);


		totalSureIntegralPlateField = new DataSourceFloatField("totalSureIntegralPlate", "部门");
		totalSureIntegralPlateField.setLength(18);
		totalSureIntegralPlateField.setDecimalPad(2);
		totalSureIntegralPlateField.setFormat("#,###,###,###,###,##0.00");
		totalSureIntegralPlateField.setRequired(false);
		totalSureIntegralPlateField.setHidden(false);
		totalSureIntegralPlateField.setCanEdit(false);


		monthSureIntegralProjectField = new DataSourceFloatField("monthSureIntegralProject", "项目组");
		monthSureIntegralProjectField.setLength(18);
		monthSureIntegralProjectField.setDecimalPad(2);
		monthSureIntegralProjectField.setFormat("#,###,###,###,###,##0.00");
		monthSureIntegralProjectField.setRequired(false);
		monthSureIntegralProjectField.setHidden(false);
		monthSureIntegralProjectField.setCanEdit(false);


		totalSureIntegralProjectField = new DataSourceFloatField("totalSureIntegralProject", "项目组");
		totalSureIntegralProjectField.setLength(18);
		totalSureIntegralProjectField.setDecimalPad(2);
		totalSureIntegralProjectField.setFormat("#,###,###,###,###,##0.00");
		totalSureIntegralProjectField.setRequired(false);
		totalSureIntegralProjectField.setHidden(false);
		totalSureIntegralProjectField.setCanEdit(false);


		monthSalaryField = new DataSourceFloatField("monthSalary", "本月薪酬");
		monthSalaryField.setLength(18);
		monthSalaryField.setDecimalPad(2);
		monthSalaryField.setFormat("#,###,###,###,###,##0.00");
		monthSalaryField.setRequired(false);
		monthSalaryField.setHidden(false);
		monthSalaryField.setCanEdit(false);


		totalSalaryField = new DataSourceFloatField("totalSalary", "累计薪酬");
		totalSalaryField.setLength(18);
		totalSalaryField.setDecimalPad(2);
		totalSalaryField.setFormat("#,###,###,###,###,##0.00");
		totalSalaryField.setRequired(false);
		totalSalaryField.setHidden(false);
		totalSalaryField.setCanEdit(false);


		monthCostPlateField = new DataSourceFloatField("monthCostPlate", "部门");
		monthCostPlateField.setLength(18);
		monthCostPlateField.setDecimalPad(2);
		monthCostPlateField.setFormat("#,###,###,###,###,##0.00");
		monthCostPlateField.setRequired(false);
		monthCostPlateField.setHidden(false);
		monthCostPlateField.setCanEdit(false);


		totalCostPlateField = new DataSourceFloatField("totalCostPlate", "部门");
		totalCostPlateField.setLength(18);
		totalCostPlateField.setDecimalPad(2);
		totalCostPlateField.setFormat("#,###,###,###,###,##0.00");
		totalCostPlateField.setRequired(false);
		totalCostPlateField.setHidden(false);
		totalCostPlateField.setCanEdit(false);


		monthCostProjectField = new DataSourceFloatField("monthCostProject", "项目");
		monthCostProjectField.setLength(18);
		monthCostProjectField.setDecimalPad(2);
		monthCostProjectField.setFormat("#,###,###,###,###,##0.00");
		monthCostProjectField.setRequired(false);
		monthCostProjectField.setHidden(false);
		monthCostProjectField.setCanEdit(false);


		totalCostProjectField = new DataSourceFloatField("totalCostProject", "项目");
		totalCostProjectField.setLength(18);
		totalCostProjectField.setDecimalPad(2);
		totalCostProjectField.setFormat("#,###,###,###,###,##0.00");
		totalCostProjectField.setRequired(false);
		totalCostProjectField.setHidden(false);
		totalCostProjectField.setCanEdit(false);


		monthCostProjectBeforeField = new DataSourceFloatField("monthCostProjectBefore", "前期项目");
		monthCostProjectBeforeField.setLength(18);
		monthCostProjectBeforeField.setDecimalPad(2);
		monthCostProjectBeforeField.setFormat("#,###,###,###,###,##0.00");
		monthCostProjectBeforeField.setRequired(false);
		monthCostProjectBeforeField.setHidden(false);
		monthCostProjectBeforeField.setCanEdit(false);


		totalCostProjectBeforeField = new DataSourceFloatField("totalCostProjectBefore", "前期项目");
		totalCostProjectBeforeField.setLength(18);
		totalCostProjectBeforeField.setDecimalPad(2);
		totalCostProjectBeforeField.setFormat("#,###,###,###,###,##0.00");
		totalCostProjectBeforeField.setRequired(false);
		totalCostProjectBeforeField.setHidden(false);
		totalCostProjectBeforeField.setCanEdit(false);


		monthNewContractField = new DataSourceFloatField("monthNewContract", "本月新签合同额");
		monthNewContractField.setLength(18);
		monthNewContractField.setDecimalPad(2);
		monthNewContractField.setFormat("#,###,###,###,###,##0.00");
		monthNewContractField.setRequired(false);
		monthNewContractField.setHidden(false);
		monthNewContractField.setCanEdit(false);

		totalNewContractField = new DataSourceFloatField("totalNewContract", "累计新签合同额");
		totalNewContractField.setLength(18);
		totalNewContractField.setDecimalPad(2);
		totalNewContractField.setFormat("#,###,###,###,###,##0.00");
		totalNewContractField.setRequired(false);
		totalNewContractField.setHidden(false);
		totalNewContractField.setCanEdit(false);


		contractTotalField = new DataSourceFloatField("contractTotal", "合同存量");
		contractTotalField.setLength(18);
		contractTotalField.setDecimalPad(2);
		contractTotalField.setFormat("#,###,###,###,###,##0.00");
		contractTotalField.setRequired(false);
		contractTotalField.setHidden(false);
		contractTotalField.setCanEdit(false);


		averageEmpNumField = new DataSourceFloatField("averageEmpNum", "累计平均人数");
		averageEmpNumField.setLength(18);
		averageEmpNumField.setDecimalPad(2);
		averageEmpNumField.setFormat("#,###,###,###,###,##0.00");
		averageEmpNumField.setRequired(false);
		averageEmpNumField.setHidden(false);
		averageEmpNumField.setCanEdit(false);


		minEmpNumField = new DataSourceIntegerField("minEmpNum", "最低人数");
		minEmpNumField.setLength(11);
		minEmpNumField.setRequired(false);
		minEmpNumField.setHidden(false);


		yearAverageEmpRevenueField = new DataSourceFloatField("yearAverageEmpRevenue", "年人均营收");
		yearAverageEmpRevenueField.setLength(18);
		yearAverageEmpRevenueField.setDecimalPad(2);
		yearAverageEmpRevenueField.setFormat("#,###,###,###,###,##0.00");
		yearAverageEmpRevenueField.setRequired(false);
		yearAverageEmpRevenueField.setHidden(false);


		yearCapitalField = new DataSourceFloatField("yearCapital", "年现金流");
		yearCapitalField.setLength(18);
		yearCapitalField.setDecimalPad(2);
		yearCapitalField.setFormat("#,###,###,###,###,##0.00");
		yearCapitalField.setRequired(false);
		yearCapitalField.setHidden(false);


		benefitField = new DataSourceFloatField("benefit", "效益指数");
		benefitField.setLength(18);
		benefitField.setDecimalPad(2);
		benefitField.setFormat("#,###,###,###,###,##0.00");
		benefitField.setRequired(false);
		benefitField.setHidden(false);


		yearRevenueField = new DataSourceFloatField("yearRevenue", "年不含税营收");
		yearRevenueField.setLength(18);
		yearRevenueField.setDecimalPad(2);
		yearRevenueField.setFormat("#,###,###,###,###,##0.00");
		yearRevenueField.setRequired(false);
		yearRevenueField.setHidden(false);


		setFields(reportTotalIdField,plateIdField, yearField, monthRevenueField, totalRevenueField, monthCapitalPlateField, totalCapitalPlateField, monthCapitalProjectField, totalCapitalProjectField, monthSureIntegralPlateField, totalSureIntegralPlateField, monthSureIntegralProjectField, totalSureIntegralProjectField, monthSalaryField, totalSalaryField, monthCostPlateField, totalCostPlateField, monthCostProjectField, totalCostProjectField, monthCostProjectBeforeField, totalCostProjectBeforeField, monthNewContractField, totalNewContractField, contractTotalField, averageEmpNumField, minEmpNumField, yearAverageEmpRevenueField, yearCapitalField, benefitField, yearRevenueField);
	}


}

