package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnSalaryTotalDataSummarize;
import pomplatform.payment.bean.ConditionOnSalaryTotalDataSummarize;
import pomplatform.payment.query.QueryOnSalaryTotalDataSummarize;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class OnSalaryTotalDataSummarizeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSalaryTotalDataSummarizeHandler.class);

	public static BaseCollection<BaseOnSalaryTotalDataSummarize> executeQueryOnSalaryTotalDataSummarize(ConditionOnSalaryTotalDataSummarize c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSalaryTotalDataSummarize dao = new QueryOnSalaryTotalDataSummarize();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSalaryTotalDataSummarize> result = dao.executeQuery( c.getKeyValues(), c) ;
		List<BaseOnSalaryTotalDataSummarize> collections = result.getCollections();
		if(!BaseHelpUtils.isNullOrEmpty(collections)&&collections.size()>0) {
			Integer startyear = c.getStartyear();
//			Integer startmonth = c.getStartmonth();
//			Integer endyear = c.getEndyear();
//			Integer endmonth = c.getEndmonth();
			for (BaseOnSalaryTotalDataSummarize baseOnSalaryTotalDataSummarize : collections) {
				baseOnSalaryTotalDataSummarize.setStartyear(startyear);
//				baseOnSalaryTotalDataSummarize.setEndyear(endyear);
//				baseOnSalaryTotalDataSummarize.setStartmonth(startmonth);
//				baseOnSalaryTotalDataSummarize.setEndmonth(endmonth);
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSalaryTotalDataSummarize c = new ConditionOnSalaryTotalDataSummarize();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSalaryTotalDataSummarize> result = executeQueryOnSalaryTotalDataSummarize(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSalaryTotalDataSummarize> result;
		ConditionOnSalaryTotalDataSummarize c = new ConditionOnSalaryTotalDataSummarize();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnSalaryTotalDataSummarize dao = new QueryOnSalaryTotalDataSummarize();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnSalaryTotalDataSummarize.ALL_CAPTIONS);
			for(BaseOnSalaryTotalDataSummarize b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


