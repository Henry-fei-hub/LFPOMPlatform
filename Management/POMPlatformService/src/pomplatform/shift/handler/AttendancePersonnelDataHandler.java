package pomplatform.shift.handler;

import org.apache.log4j.Logger;
import pomplatform.shift.bean.BaseAttendancePersonnelData;
import pomplatform.shift.bean.ConditionAttendancePersonnelData;
import pomplatform.shift.query.QueryAttendancePersonnelData;
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

public class AttendancePersonnelDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AttendancePersonnelDataHandler.class);

	public static BaseCollection<BaseAttendancePersonnelData> executeQueryAttendancePersonnelData(ConditionAttendancePersonnelData c, KeyValuePair[] replacements ) throws Exception {
		QueryAttendancePersonnelData dao = new QueryAttendancePersonnelData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAttendancePersonnelData> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAttendancePersonnelData c = new ConditionAttendancePersonnelData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAttendancePersonnelData> result = executeQueryAttendancePersonnelData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAttendancePersonnelData> result;
		ConditionAttendancePersonnelData c = new ConditionAttendancePersonnelData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAttendancePersonnelData dao = new QueryAttendancePersonnelData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAttendancePersonnelData.ALL_CAPTIONS);
			for(BaseAttendancePersonnelData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


