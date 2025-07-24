package pomplatform.shift.handler;

import org.apache.log4j.Logger;
import pomplatform.shift.bean.BaseAttendanceCheckinoutData;
import pomplatform.shift.bean.ConditionAttendanceCheckinoutData;
import pomplatform.shift.query.QueryAttendanceCheckinoutData;
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

public class AttendanceCheckinoutDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AttendanceCheckinoutDataHandler.class);

	public static BaseCollection<BaseAttendanceCheckinoutData> executeQueryAttendanceCheckinoutData(ConditionAttendanceCheckinoutData c, KeyValuePair[] replacements ) throws Exception {
		QueryAttendanceCheckinoutData dao = new QueryAttendanceCheckinoutData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAttendanceCheckinoutData> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAttendanceCheckinoutData c = new ConditionAttendanceCheckinoutData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAttendanceCheckinoutData> result = executeQueryAttendanceCheckinoutData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAttendanceCheckinoutData> result;
		ConditionAttendanceCheckinoutData c = new ConditionAttendanceCheckinoutData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAttendanceCheckinoutData dao = new QueryAttendanceCheckinoutData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAttendanceCheckinoutData.ALL_CAPTIONS);
			for(BaseAttendanceCheckinoutData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


