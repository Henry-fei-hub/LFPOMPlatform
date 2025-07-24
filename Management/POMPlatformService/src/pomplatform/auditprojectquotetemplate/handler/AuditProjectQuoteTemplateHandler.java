package pomplatform.auditprojectquotetemplate.handler;

import org.apache.log4j.Logger;
import pomplatform.auditprojectquotetemplate.bean.BaseAuditProjectQuoteTemplate;
import pomplatform.auditprojectquotetemplate.bean.ConditionAuditProjectQuoteTemplate;
import pomplatform.auditprojectquotetemplate.query.QueryAuditProjectQuoteTemplate;
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

public class AuditProjectQuoteTemplateHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AuditProjectQuoteTemplateHandler.class);

	public static BaseCollection<BaseAuditProjectQuoteTemplate> executeQueryAuditProjectQuoteTemplate(ConditionAuditProjectQuoteTemplate c, KeyValuePair[] replacements ) throws Exception {
		QueryAuditProjectQuoteTemplate dao = new QueryAuditProjectQuoteTemplate();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAuditProjectQuoteTemplate> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAuditProjectQuoteTemplate c = new ConditionAuditProjectQuoteTemplate();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAuditProjectQuoteTemplate> result = executeQueryAuditProjectQuoteTemplate(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAuditProjectQuoteTemplate> result;
		ConditionAuditProjectQuoteTemplate c = new ConditionAuditProjectQuoteTemplate();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAuditProjectQuoteTemplate dao = new QueryAuditProjectQuoteTemplate();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAuditProjectQuoteTemplate.ALL_CAPTIONS);
			for(BaseAuditProjectQuoteTemplate b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


