package pomplatform.receivables.handler;

import org.apache.log4j.Logger;
import pomplatform.receivables.bean.BaseGetTotalContractAndRentMoney;
import pomplatform.receivables.bean.ConditionGetTotalContractAndRentMoney;
import pomplatform.receivables.query.QueryGetTotalContractAndRentMoney;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class GetTotalContractAndRentMoneyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetTotalContractAndRentMoneyHandler.class);

	public static BaseCollection<BaseGetTotalContractAndRentMoney> executeQueryGetTotalContractAndRentMoney(ConditionGetTotalContractAndRentMoney c, KeyValuePair[] replacements ) throws Exception {
		QueryGetTotalContractAndRentMoney dao = new QueryGetTotalContractAndRentMoney();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetTotalContractAndRentMoney> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetTotalContractAndRentMoney c = new ConditionGetTotalContractAndRentMoney();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetTotalContractAndRentMoney> result = executeQueryGetTotalContractAndRentMoney(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetTotalContractAndRentMoney> result;
		ConditionGetTotalContractAndRentMoney c = new ConditionGetTotalContractAndRentMoney();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetTotalContractAndRentMoney dao = new QueryGetTotalContractAndRentMoney();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetTotalContractAndRentMoney.ALL_CAPTIONS);
			for(BaseGetTotalContractAndRentMoney b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


