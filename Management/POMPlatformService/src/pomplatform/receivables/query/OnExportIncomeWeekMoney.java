package pomplatform.receivables.query;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.receivables.bean.BaseIncomeMoneyForWeek;
import pomplatform.receivables.bean.ConditionIncomeMoneyForWeek;

public class OnExportIncomeWeekMoney implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnExportIncomeWeekMoney.class);

	public static BaseCollection<BaseIncomeMoneyForWeek> executeQueryInsurance(ConditionIncomeMoneyForWeek c, KeyValuePair[] replacements ) throws Exception {
		QueryIncomeMoneyForWeek dao = new QueryIncomeMoneyForWeek();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseIncomeMoneyForWeek> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionIncomeMoneyForWeek c = new ConditionIncomeMoneyForWeek();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseIncomeMoneyForWeek> result = executeQueryInsurance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseIncomeMoneyForWeek> result;
		ConditionIncomeMoneyForWeek c = new ConditionIncomeMoneyForWeek();
		c.setDataFromJSON(creteria);
		QueryIncomeMoneyForWeek dao = new QueryIncomeMoneyForWeek();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseIncomeMoneyForWeek.FOR_EXPORT);
			BigDecimal contractMoney = BigDecimal.ZERO;
			BigDecimal otherMoney = BigDecimal.ZERO;
			BigDecimal subsidyMoney = BigDecimal.ZERO;
			for(BaseIncomeMoneyForWeek b : result.getCollections()){
				int moneyAttribute = b.getMoneyAttribute();
				BigDecimal borrowMoney = b.getBorrowMoney();
				String name = "";
				if(moneyAttribute == 1 || moneyAttribute == 11 || moneyAttribute == 12 || moneyAttribute == 13){
					name = b.getContractName();
					contractMoney = contractMoney.add(borrowMoney);
				}else if(moneyAttribute == 2){
					name = b.getOtherName();
					otherMoney = otherMoney.add(borrowMoney);
				}else if(moneyAttribute == 7){
					name = b.getOtherName();
					subsidyMoney = subsidyMoney.add(borrowMoney);
				}
				b.setContractName(name);
				ps.println(b.toCSVString());
			}
			List<BaseIncomeMoneyForWeek> list = new ArrayList<>();
			BaseIncomeMoneyForWeek totalBean = new BaseIncomeMoneyForWeek();
			totalBean.setContractName("小计");
			totalBean.setBorrowMoney(contractMoney.add(otherMoney).add(subsidyMoney));
			list.add(totalBean);
			totalBean = new BaseIncomeMoneyForWeek();
			totalBean.setContractName("其中：收设计费");
			totalBean.setBorrowMoney(contractMoney);
			list.add(totalBean);
			totalBean = new BaseIncomeMoneyForWeek();
			totalBean.setContractName("收房租费用等");
			totalBean.setBorrowMoney(otherMoney);
			list.add(totalBean);
			totalBean = new BaseIncomeMoneyForWeek();
			totalBean.setContractName("政府补贴");
			totalBean.setBorrowMoney(subsidyMoney);
			list.add(totalBean);
			
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			@SuppressWarnings("unchecked")
			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
			Date endDate = GenericBase.__getDate(params.get("endDate"));
			int endDay = endDate.getDate();
			BigDecimal totalContractMoney = BaseHelpUtils.getBigDecimalValue(params.get("contractMoney"));
			BigDecimal totalRentMoney = BaseHelpUtils.getBigDecimalValue(params.get("rentMoney"));
			BigDecimal totalSubsidyMoney = BaseHelpUtils.getBigDecimalValue(params.get("subsidyMoney"));
			totalBean = new BaseIncomeMoneyForWeek();
			totalBean.setContractName("1-"+endDay+"日累计");
			totalBean.setBorrowMoney(totalContractMoney.add(totalRentMoney).add(totalSubsidyMoney));
			list.add(totalBean);
			totalBean = new BaseIncomeMoneyForWeek();
			totalBean.setContractName("其中：收设计费");
			totalBean.setBorrowMoney(totalContractMoney);
			list.add(totalBean);
			totalBean = new BaseIncomeMoneyForWeek();
			totalBean.setContractName("收房租费用等");
			totalBean.setBorrowMoney(totalRentMoney);
			list.add(totalBean);
			totalBean = new BaseIncomeMoneyForWeek();
			totalBean.setContractName("政府补贴");
			totalBean.setBorrowMoney(totalSubsidyMoney);
			list.add(totalBean);
			
			BigDecimal yearTotalContractMoney = BaseHelpUtils.getBigDecimalValue(params.get("yearContractMoney"));
			BigDecimal yearTotalRentMoney = BaseHelpUtils.getBigDecimalValue(params.get("yearRentMoney"));
			BigDecimal yearTotalSubsidyMoney = BaseHelpUtils.getBigDecimalValue(params.get("yearSubsidyMoney"));
			Date currentDate = new Date();
			int month = currentDate.getMonth()+1;
			if(month != 1){
				totalBean = new BaseIncomeMoneyForWeek();
				totalBean.setContractName("1月-"+(month-1)+"月累计");
				totalBean.setBorrowMoney(yearTotalContractMoney.add(yearTotalRentMoney).add(yearTotalSubsidyMoney));
				list.add(totalBean);
				totalBean = new BaseIncomeMoneyForWeek();
				totalBean.setContractName("其中：收设计费");
				totalBean.setBorrowMoney(yearTotalContractMoney);
				list.add(totalBean);
				totalBean = new BaseIncomeMoneyForWeek();
				totalBean.setContractName("收房租费用等");
				totalBean.setBorrowMoney(yearTotalRentMoney);
				list.add(totalBean);
				totalBean = new BaseIncomeMoneyForWeek();
				totalBean.setContractName("政府补贴");
				totalBean.setBorrowMoney(yearTotalSubsidyMoney);
				list.add(totalBean);
			}
			for(BaseIncomeMoneyForWeek e : list){
				ps.println(e.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


