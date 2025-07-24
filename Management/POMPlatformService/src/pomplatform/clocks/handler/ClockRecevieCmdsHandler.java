package pomplatform.clocks.handler;

import org.apache.log4j.Logger;
import pomplatform.clocks.bean.BaseClockRecevieCmds;
import pomplatform.clocks.bean.ConditionClockRecevieCmds;
import pomplatform.clocks.query.QueryClockRecevieCmds;
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

public class ClockRecevieCmdsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ClockRecevieCmdsHandler.class);

	public static BaseCollection<BaseClockRecevieCmds> executeQueryClockRecevieCmds(ConditionClockRecevieCmds c, KeyValuePair[] replacements ) throws Exception {
		QueryClockRecevieCmds dao = new QueryClockRecevieCmds();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseClockRecevieCmds> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionClockRecevieCmds c = new ConditionClockRecevieCmds();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseClockRecevieCmds> result = executeQueryClockRecevieCmds(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseClockRecevieCmds> result;
		ConditionClockRecevieCmds c = new ConditionClockRecevieCmds();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryClockRecevieCmds dao = new QueryClockRecevieCmds();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseClockRecevieCmds.ALL_CAPTIONS);
			for(BaseClockRecevieCmds b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


