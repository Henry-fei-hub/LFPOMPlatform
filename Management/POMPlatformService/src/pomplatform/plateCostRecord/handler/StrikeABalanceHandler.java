package pomplatform.plateCostRecord.handler;

import org.apache.log4j.Logger;
import pomplatform.plateCostRecord.bean.BaseStrikeABalance;
import pomplatform.plateCostRecord.bean.ConditionStrikeABalance;
import pomplatform.plateCostRecord.query.QueryStrikeABalance;
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

public class StrikeABalanceHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(StrikeABalanceHandler.class);

	public static BaseCollection<BaseStrikeABalance> executeQueryStrikeABalance(ConditionStrikeABalance c, KeyValuePair[] replacements ) throws Exception {
		QueryStrikeABalance dao = new QueryStrikeABalance();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseStrikeABalance> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionStrikeABalance c = new ConditionStrikeABalance();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseStrikeABalance> result = executeQueryStrikeABalance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseStrikeABalance> result;
		ConditionStrikeABalance c = new ConditionStrikeABalance();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryStrikeABalance dao = new QueryStrikeABalance();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseStrikeABalance.ALL_CAPTIONS);
			for(BaseStrikeABalance b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


