package pomplatform.shift.handler;

import org.apache.log4j.Logger;
import pomplatform.shift.bean.BaseOnLoadEmployeeCheckTime;
import pomplatform.shift.bean.ConditionOnLoadEmployeeCheckTime;
import pomplatform.shift.query.QueryOnLoadEmployeeCheckTime;
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

public class OnLoadEmployeeCheckTimeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadEmployeeCheckTimeHandler.class);

	public static BaseCollection<BaseOnLoadEmployeeCheckTime> executeQueryOnLoadEmployeeCheckTime(ConditionOnLoadEmployeeCheckTime c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadEmployeeCheckTime dao = new QueryOnLoadEmployeeCheckTime();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadEmployeeCheckTime> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadEmployeeCheckTime c = new ConditionOnLoadEmployeeCheckTime();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadEmployeeCheckTime> result = executeQueryOnLoadEmployeeCheckTime(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadEmployeeCheckTime> result;
		ConditionOnLoadEmployeeCheckTime c = new ConditionOnLoadEmployeeCheckTime();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadEmployeeCheckTime dao = new QueryOnLoadEmployeeCheckTime();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadEmployeeCheckTime.ALL_CAPTIONS);
			for(BaseOnLoadEmployeeCheckTime b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


