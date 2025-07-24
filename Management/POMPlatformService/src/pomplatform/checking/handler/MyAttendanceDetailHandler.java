package pomplatform.checking.handler;

import org.apache.log4j.Logger;
import pomplatform.checking.bean.BaseMyAttendanceDetail;
import pomplatform.checking.bean.ConditionMyAttendanceDetail;
import pomplatform.checking.query.QueryMyAttendanceDetail;
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

public class MyAttendanceDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MyAttendanceDetailHandler.class);

	public static BaseCollection<BaseMyAttendanceDetail> executeQueryMyAttendanceDetail(ConditionMyAttendanceDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryMyAttendanceDetail dao = new QueryMyAttendanceDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMyAttendanceDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMyAttendanceDetail c = new ConditionMyAttendanceDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMyAttendanceDetail> result = executeQueryMyAttendanceDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMyAttendanceDetail> result;
		ConditionMyAttendanceDetail c = new ConditionMyAttendanceDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMyAttendanceDetail dao = new QueryMyAttendanceDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMyAttendanceDetail.ALL_CAPTIONS);
			for(BaseMyAttendanceDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


