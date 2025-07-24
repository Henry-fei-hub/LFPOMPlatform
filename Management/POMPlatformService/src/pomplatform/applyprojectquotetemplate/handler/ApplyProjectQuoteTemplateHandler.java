package pomplatform.applyprojectquotetemplate.handler;

import org.apache.log4j.Logger;
import pomplatform.applyprojectquotetemplate.bean.BaseApplyProjectQuoteTemplate;
import pomplatform.applyprojectquotetemplate.bean.ConditionApplyProjectQuoteTemplate;
import pomplatform.applyprojectquotetemplate.query.QueryApplyProjectQuoteTemplate;
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

public class ApplyProjectQuoteTemplateHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ApplyProjectQuoteTemplateHandler.class);

	public static BaseCollection<BaseApplyProjectQuoteTemplate> executeQueryApplyProjectQuoteTemplate(ConditionApplyProjectQuoteTemplate c, KeyValuePair[] replacements ) throws Exception {
		QueryApplyProjectQuoteTemplate dao = new QueryApplyProjectQuoteTemplate();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseApplyProjectQuoteTemplate> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionApplyProjectQuoteTemplate c = new ConditionApplyProjectQuoteTemplate();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseApplyProjectQuoteTemplate> result = executeQueryApplyProjectQuoteTemplate(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseApplyProjectQuoteTemplate> result;
		ConditionApplyProjectQuoteTemplate c = new ConditionApplyProjectQuoteTemplate();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryApplyProjectQuoteTemplate dao = new QueryApplyProjectQuoteTemplate();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseApplyProjectQuoteTemplate.ALL_CAPTIONS);
			for(BaseApplyProjectQuoteTemplate b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


