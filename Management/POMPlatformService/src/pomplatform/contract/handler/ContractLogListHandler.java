package pomplatform.contract.handler;

import org.apache.log4j.Logger;
import pomplatform.contract.bean.BaseContractLogList;
import pomplatform.contract.bean.ConditionContractLogList;
import pomplatform.contract.query.QueryContractLogList;
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

public class ContractLogListHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractLogListHandler.class);

	public static BaseCollection<BaseContractLogList> executeQueryContractLogList(ConditionContractLogList c, KeyValuePair[] replacements ) throws Exception {
		QueryContractLogList dao = new QueryContractLogList();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractLogList> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractLogList c = new ConditionContractLogList();
		c.setDataFromJSON(creteria);
		if(null != c.getStartDate())
		{
			c.setStartDate(DateUtil.getNextDayOfDay(c.getStartDate(), 0));
		}
		if(null != c.getEndDate())
		{
			c.setEndDate(DateUtil.getNextDayOfDay(c.getEndDate(), 1));
		}
		BaseCollection<BaseContractLogList> result = executeQueryContractLogList(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractLogList> result;
		ConditionContractLogList c = new ConditionContractLogList();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		if(null != c.getStartDate())
		{
			c.setStartDate(DateUtil.getNextDayOfDay(c.getStartDate(), 0));
		}
		if(null != c.getEndDate())
		{
			c.setEndDate(DateUtil.getNextDayOfDay(c.getEndDate(), 1));
		}
		QueryContractLogList dao = new QueryContractLogList();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractLogList.ALL_CAPTIONS);
			for(BaseContractLogList b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


