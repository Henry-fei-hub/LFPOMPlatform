package pomplatform.contractchange.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.contractchange.bean.BaseContractChangeList;
import pomplatform.contractchange.bean.ConditionContractChangeList;
import pomplatform.contractchange.query.QueryContractChangeList;

public class ContractChangeListHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractChangeListHandler.class);

	public static BaseCollection<BaseContractChangeList> executeQueryContractChangeList(ConditionContractChangeList c, KeyValuePair[] replacements ) throws Exception {
		QueryContractChangeList dao = new QueryContractChangeList();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractChangeList> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractChangeList c = new ConditionContractChangeList();
		c.setDataFromJSON(creteria);
		if(null != c.getStartTime()){
			Date date = c.getStartTime();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			c.setStartTime(calendar.getTime());
		}
		if(null != c.getEndTime()){
			Date date = c.getEndTime();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)+1);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			c.setEndTime(calendar.getTime());
		}
		BaseCollection<BaseContractChangeList> result = executeQueryContractChangeList(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractChangeList> result;
		ConditionContractChangeList c = new ConditionContractChangeList();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractChangeList dao = new QueryContractChangeList();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractChangeList.ALL_CAPTIONS);
			for(BaseContractChangeList b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


