package pomplatform.contract.handler;

import org.apache.log4j.Logger;
import pomplatform.contract.bean.BaseContractStatusHistory;
import pomplatform.contract.bean.ConditionContractStatusHistory;
import pomplatform.contract.query.QueryContractStatusHistory;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class ContractStatusHistoryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractStatusHistoryHandler.class);

	public static BaseCollection<BaseContractStatusHistory> executeQueryContractStatusHistory(ConditionContractStatusHistory c, KeyValuePair[] replacements ) throws Exception {
		QueryContractStatusHistory dao = new QueryContractStatusHistory();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractStatusHistory> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractStatusHistory c = new ConditionContractStatusHistory();
		c.setDataFromJSON(creteria);
		if(null != c.getStartTime()){
			c.setStartTime(DateUtil.getNextDayOfDay(c.getStartTime(), 0));
		}
		if(null != c.getEndTime()){
			c.setEndTime(DateUtil.getNextDayOfDay(c.getEndTime(), 1));
		}
		BaseCollection<BaseContractStatusHistory> result = executeQueryContractStatusHistory(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractStatusHistory> result;
		ConditionContractStatusHistory c = new ConditionContractStatusHistory();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		if(null != c.getStartTime()){
			c.setStartTime(DateUtil.getNextDayOfDay(c.getStartTime(), 0));
		}
		if(null != c.getEndTime()){
			c.setEndTime(DateUtil.getNextDayOfDay(c.getEndTime(), 1));
		}
		QueryContractStatusHistory dao = new QueryContractStatusHistory();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractStatusHistory.ALL_CAPTIONS);
			for(BaseContractStatusHistory b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


