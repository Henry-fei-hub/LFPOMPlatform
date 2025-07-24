package pomplatform.attentionprojectquotetemplate.handler;

import org.apache.log4j.Logger;
import pomplatform.attentionprojectquotetemplate.bean.BaseAttentionProjectQuoteTemplate;
import pomplatform.attentionprojectquotetemplate.bean.ConditionAttentionProjectQuoteTemplate;
import pomplatform.attentionprojectquotetemplate.query.QueryAttentionProjectQuoteTemplate;
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

public class AttentionProjectQuoteTemplateHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AttentionProjectQuoteTemplateHandler.class);

	public static BaseCollection<BaseAttentionProjectQuoteTemplate> executeQueryAttentionProjectQuoteTemplate(ConditionAttentionProjectQuoteTemplate c, KeyValuePair[] replacements ) throws Exception {
		QueryAttentionProjectQuoteTemplate dao = new QueryAttentionProjectQuoteTemplate();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAttentionProjectQuoteTemplate> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAttentionProjectQuoteTemplate c = new ConditionAttentionProjectQuoteTemplate();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAttentionProjectQuoteTemplate> result = executeQueryAttentionProjectQuoteTemplate(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAttentionProjectQuoteTemplate> result;
		ConditionAttentionProjectQuoteTemplate c = new ConditionAttentionProjectQuoteTemplate();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAttentionProjectQuoteTemplate dao = new QueryAttentionProjectQuoteTemplate();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAttentionProjectQuoteTemplate.ALL_CAPTIONS);
			for(BaseAttentionProjectQuoteTemplate b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


