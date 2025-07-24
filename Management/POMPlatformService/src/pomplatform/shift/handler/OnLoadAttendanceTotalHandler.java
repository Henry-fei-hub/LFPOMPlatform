package pomplatform.shift.handler;

import org.apache.log4j.Logger;
import pomplatform.shift.bean.BaseOnLoadAttendanceTotal;
import pomplatform.shift.bean.ConditionOnLoadAttendanceTotal;
import pomplatform.shift.query.QueryOnLoadAttendanceTotal;
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

public class OnLoadAttendanceTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAttendanceTotalHandler.class);

	public static BaseCollection<BaseOnLoadAttendanceTotal> executeQueryOnLoadAttendanceTotal(ConditionOnLoadAttendanceTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttendanceTotal dao = new QueryOnLoadAttendanceTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttendanceTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAttendanceTotal c = new ConditionOnLoadAttendanceTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAttendanceTotal> result = executeQueryOnLoadAttendanceTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAttendanceTotal> result;
		ConditionOnLoadAttendanceTotal c = new ConditionOnLoadAttendanceTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAttendanceTotal dao = new QueryOnLoadAttendanceTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAttendanceTotal.ALL_CAPTIONS);
			for(BaseOnLoadAttendanceTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


