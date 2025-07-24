package pomplatform.clocks.handler;

import org.apache.log4j.Logger;
import pomplatform.clocks.bean.BaseClockList;
import pomplatform.clocks.bean.ConditionClockList;
import pomplatform.clocks.query.QueryClockList;
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

public class ClockListHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ClockListHandler.class);

	public static BaseCollection<BaseClockList> executeQueryclockList(ConditionClockList c, KeyValuePair[] replacements ) throws Exception {
		QueryClockList dao = new QueryClockList();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseClockList> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionClockList c = new ConditionClockList();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseClockList> result = executeQueryclockList(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseClockList> result;
		ConditionClockList c = new ConditionClockList();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryClockList dao = new QueryClockList();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseClockList.ALL_CAPTIONS);
			for(BaseClockList b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


