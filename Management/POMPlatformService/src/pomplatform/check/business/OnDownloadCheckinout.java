package pomplatform.check.business;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.checking.bean.BaseEmployeeRealtimeChecking;
import pomplatform.checking.bean.ConditionEmployeeRealtimeChecking;
import pomplatform.checking.query.QueryEmployeeRealtimeChecking;

public class OnDownloadCheckinout implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnDownloadCheckinout.class);

	public static BaseCollection<BaseEmployeeRealtimeChecking> executeQueryInsurance(ConditionEmployeeRealtimeChecking c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeRealtimeChecking dao = new QueryEmployeeRealtimeChecking();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeRealtimeChecking> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeRealtimeChecking c = new ConditionEmployeeRealtimeChecking();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeRealtimeChecking> result = executeQueryInsurance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeRealtimeChecking> result;
		ConditionEmployeeRealtimeChecking c = new ConditionEmployeeRealtimeChecking();
		c.setDataFromJSON(creteria);
		QueryEmployeeRealtimeChecking dao = new QueryEmployeeRealtimeChecking();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeRealtimeChecking.DOWNLOAD_CAPTIONS);
			for(BaseEmployeeRealtimeChecking b : result.getCollections()){
				if(b.getEmployeeId() != 0){
					ps.println(b.toCSVString());
				}
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


