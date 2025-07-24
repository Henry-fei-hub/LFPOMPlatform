package pomplatform.shift.handler;

import org.apache.log4j.Logger;
import pomplatform.shift.bean.BaseOnLoadAttendanceStatus;
import pomplatform.shift.bean.ConditionOnLoadAttendanceStatus;
import pomplatform.shift.query.QueryOnLoadAttendanceStatus;
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

public class OnLoadAttendanceStatusHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAttendanceStatusHandler.class);

	public static BaseCollection<BaseOnLoadAttendanceStatus> executeQueryOnLoadAttendanceStatus(ConditionOnLoadAttendanceStatus c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttendanceStatus dao = new QueryOnLoadAttendanceStatus();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttendanceStatus> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAttendanceStatus c = new ConditionOnLoadAttendanceStatus();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAttendanceStatus> result = executeQueryOnLoadAttendanceStatus(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAttendanceStatus> result;
		ConditionOnLoadAttendanceStatus c = new ConditionOnLoadAttendanceStatus();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAttendanceStatus dao = new QueryOnLoadAttendanceStatus();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAttendanceStatus.ALL_CAPTIONS);
			for(BaseOnLoadAttendanceStatus b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


