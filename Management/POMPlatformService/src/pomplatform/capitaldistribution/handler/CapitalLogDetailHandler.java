package pomplatform.capitaldistribution.handler;

import org.apache.log4j.Logger;
import pomplatform.capitaldistribution.bean.BaseCapitalLogDetail;
import pomplatform.capitaldistribution.bean.ConditionCapitalLogDetail;
import pomplatform.capitaldistribution.query.QueryCapitalLogDetail;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class CapitalLogDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CapitalLogDetailHandler.class);

	public static BaseCollection<BaseCapitalLogDetail> executeQueryCapitalLogDetail(ConditionCapitalLogDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryCapitalLogDetail dao = new QueryCapitalLogDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCapitalLogDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCapitalLogDetail c = new ConditionCapitalLogDetail();
		c.setDataFromJSON(creteria);
		if(null != c.getStartTime()){
			c.setStartTime(DateUtil.getNextDayOfDay(c.getStartTime(), 0));
		}
		if(null != c.getEndTime()){
			c.setEndTime(DateUtil.getNextDayOfDay(c.getEndTime(), 1));
		}
		BaseCollection<BaseCapitalLogDetail> result = executeQueryCapitalLogDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCapitalLogDetail> result;
		ConditionCapitalLogDetail c = new ConditionCapitalLogDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCapitalLogDetail dao = new QueryCapitalLogDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCapitalLogDetail.ALL_CAPTIONS);
			for(BaseCapitalLogDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


