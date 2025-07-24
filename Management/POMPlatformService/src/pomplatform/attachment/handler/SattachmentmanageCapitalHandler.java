package pomplatform.attachment.handler;

import org.apache.log4j.Logger;
import pomplatform.attachment.bean.BaseSattachmentmanageCapital;
import pomplatform.attachment.bean.ConditionSattachmentmanageCapital;
import pomplatform.attachment.query.QuerySattachmentmanageCapital;
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

public class SattachmentmanageCapitalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SattachmentmanageCapitalHandler.class);

	public static BaseCollection<BaseSattachmentmanageCapital> executeQuerySattachmentmanageCapital(ConditionSattachmentmanageCapital c, KeyValuePair[] replacements ) throws Exception {
		QuerySattachmentmanageCapital dao = new QuerySattachmentmanageCapital();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSattachmentmanageCapital> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSattachmentmanageCapital c = new ConditionSattachmentmanageCapital();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSattachmentmanageCapital> result = executeQuerySattachmentmanageCapital(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSattachmentmanageCapital> result;
		ConditionSattachmentmanageCapital c = new ConditionSattachmentmanageCapital();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySattachmentmanageCapital dao = new QuerySattachmentmanageCapital();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSattachmentmanageCapital.ALL_CAPTIONS);
			for(BaseSattachmentmanageCapital b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


