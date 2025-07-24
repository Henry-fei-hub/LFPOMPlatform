package pomplatform.meeting.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.meeting.bean.BaseMeetingInfoPaymentBase;
import pomplatform.meeting.bean.ConditionMeetingInfoPaymentBase;
import pomplatform.meeting.query.QueryMeetingInfoPaymentBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class MeetingInfoPaymentBaseHandler implements GenericQuery,  GenericDownloadProcessor {


	private static final Logger __logger = Logger.getLogger(MeetingInfoPaymentBaseHandler.class);


	public static BaseCollection<BaseMeetingInfoPaymentBase> executeQueryMeetingInfoPaymentBase(ConditionMeetingInfoPaymentBase c, KeyValuePair[] replacements ) throws Exception {
		QueryMeetingInfoPaymentBase dao = new QueryMeetingInfoPaymentBase();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMeetingInfoPaymentBase> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMeetingInfoPaymentBase c = new ConditionMeetingInfoPaymentBase();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMeetingInfoPaymentBase> result = executeQueryMeetingInfoPaymentBase(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMeetingInfoPaymentBase> result;
		ConditionMeetingInfoPaymentBase c = new ConditionMeetingInfoPaymentBase();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMeetingInfoPaymentBase dao = new QueryMeetingInfoPaymentBase();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMeetingInfoPaymentBase.ALL_CAPTIONS);
			for(BaseMeetingInfoPaymentBase b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


