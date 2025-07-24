package pomplatform.company.handler;

import org.apache.log4j.Logger;
import pomplatform.company.bean.BaseSprojectcorDetail;
import pomplatform.company.bean.ConditionSprojectcorDetail;
import pomplatform.company.query.QuerySprojectcorDetail;
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

public class SprojectcorDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectcorDetailHandler.class);

	public static BaseCollection<BaseSprojectcorDetail> executeQuerySprojectcorDetail(ConditionSprojectcorDetail c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectcorDetail dao = new QuerySprojectcorDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectcorDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectcorDetail c = new ConditionSprojectcorDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectcorDetail> result = executeQuerySprojectcorDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectcorDetail> result;
		ConditionSprojectcorDetail c = new ConditionSprojectcorDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectcorDetail dao = new QuerySprojectcorDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSprojectcorDetail.ALL_CAPTIONS);
			for(BaseSprojectcorDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


