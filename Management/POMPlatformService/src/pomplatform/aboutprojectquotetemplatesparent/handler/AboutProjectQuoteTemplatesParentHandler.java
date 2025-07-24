package pomplatform.aboutprojectquotetemplatesparent.handler;

import org.apache.log4j.Logger;
import pomplatform.aboutprojectquotetemplatesparent.bean.BaseAboutProjectQuoteTemplatesParent;
import pomplatform.aboutprojectquotetemplatesparent.bean.ConditionAboutProjectQuoteTemplatesParent;
import pomplatform.aboutprojectquotetemplatesparent.query.QueryAboutProjectQuoteTemplatesParent;
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

public class AboutProjectQuoteTemplatesParentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AboutProjectQuoteTemplatesParentHandler.class);

	public static BaseCollection<BaseAboutProjectQuoteTemplatesParent> executeQueryAboutProjectQuoteTemplatesParent(ConditionAboutProjectQuoteTemplatesParent c, KeyValuePair[] replacements ) throws Exception {
		QueryAboutProjectQuoteTemplatesParent dao = new QueryAboutProjectQuoteTemplatesParent();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAboutProjectQuoteTemplatesParent> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAboutProjectQuoteTemplatesParent c = new ConditionAboutProjectQuoteTemplatesParent();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAboutProjectQuoteTemplatesParent> result = executeQueryAboutProjectQuoteTemplatesParent(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAboutProjectQuoteTemplatesParent> result;
		ConditionAboutProjectQuoteTemplatesParent c = new ConditionAboutProjectQuoteTemplatesParent();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAboutProjectQuoteTemplatesParent dao = new QueryAboutProjectQuoteTemplatesParent();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAboutProjectQuoteTemplatesParent.ALL_CAPTIONS);
			for(BaseAboutProjectQuoteTemplatesParent b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


