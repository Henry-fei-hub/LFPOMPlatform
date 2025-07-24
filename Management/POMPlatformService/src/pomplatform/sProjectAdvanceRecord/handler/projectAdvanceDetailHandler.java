package pomplatform.sProjectAdvanceRecord.handler;

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
import pomplatform.sProjectAdvanceRecord.bean.BaseprojectAdvanceDetail;
import pomplatform.sProjectAdvanceRecord.bean.ConditionprojectAdvanceDetail;
import pomplatform.sProjectAdvanceRecord.query.QueryprojectAdvanceDetail;

public class projectAdvanceDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(projectAdvanceDetailHandler.class);

	public static BaseCollection<BaseprojectAdvanceDetail> executeQueryprojectAdvanceDetail(ConditionprojectAdvanceDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryprojectAdvanceDetail dao = new QueryprojectAdvanceDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseprojectAdvanceDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionprojectAdvanceDetail c = new ConditionprojectAdvanceDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseprojectAdvanceDetail> result = executeQueryprojectAdvanceDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseprojectAdvanceDetail> result;
		ConditionprojectAdvanceDetail c = new ConditionprojectAdvanceDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryprojectAdvanceDetail dao = new QueryprojectAdvanceDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseprojectAdvanceDetail.ALL_CAPTIONS);
			for(BaseprojectAdvanceDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


