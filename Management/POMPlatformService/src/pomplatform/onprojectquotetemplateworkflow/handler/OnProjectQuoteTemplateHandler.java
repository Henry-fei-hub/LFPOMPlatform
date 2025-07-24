package pomplatform.onprojectquotetemplateworkflow.handler;

import org.apache.log4j.Logger;
import pomplatform.onprojectquotetemplateworkflow.bean.BaseOnProjectQuoteTemplate;
import pomplatform.onprojectquotetemplateworkflow.bean.ConditionOnProjectQuoteTemplate;
import pomplatform.onprojectquotetemplateworkflow.query.QueryOnProjectQuoteTemplate;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseProjectQuoteDetail;
import com.pomplatform.db.dao.ProjectQuoteDetail;
import delicacy.common.BaseCollection;

public class OnProjectQuoteTemplateHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnProjectQuoteTemplateHandler.class);

	public static BaseCollection<BaseOnProjectQuoteTemplate> executeQueryOnProjectQuoteTemplate(ConditionOnProjectQuoteTemplate c, KeyValuePair[] replacements ) throws Exception {
		QueryOnProjectQuoteTemplate dao = new QueryOnProjectQuoteTemplate();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnProjectQuoteTemplate> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			ProjectQuoteDetail daoProjectQuoteDetail = new ProjectQuoteDetail();
			for(BaseOnProjectQuoteTemplate bean : result.getCollections()){
				daoProjectQuoteDetail.setConditionProjectQuoteId("=", bean.getProjectQuoteId());
				bean.setDetailProjectQuoteDetail(daoProjectQuoteDetail.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnProjectQuoteTemplate c = new ConditionOnProjectQuoteTemplate();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnProjectQuoteTemplate> result = executeQueryOnProjectQuoteTemplate(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnProjectQuoteTemplate> result;
		ConditionOnProjectQuoteTemplate c = new ConditionOnProjectQuoteTemplate();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnProjectQuoteTemplate dao = new QueryOnProjectQuoteTemplate();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnProjectQuoteTemplate.ALL_CAPTIONS);
			for(BaseOnProjectQuoteTemplate b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


