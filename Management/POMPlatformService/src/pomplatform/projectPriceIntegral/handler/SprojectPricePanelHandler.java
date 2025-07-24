package pomplatform.projectPriceIntegral.handler;

import org.apache.log4j.Logger;
import pomplatform.projectPriceIntegral.bean.BaseSprojectPricePanel;
import pomplatform.projectPriceIntegral.bean.ConditionSprojectPricePanel;
import pomplatform.projectPriceIntegral.query.QuerySprojectPricePanel;
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

public class SprojectPricePanelHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectPricePanelHandler.class);

	public static BaseCollection<BaseSprojectPricePanel> executeQuerySprojectPricePanel(ConditionSprojectPricePanel c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectPricePanel dao = new QuerySprojectPricePanel();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectPricePanel> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectPricePanel c = new ConditionSprojectPricePanel();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectPricePanel> result = executeQuerySprojectPricePanel(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectPricePanel> result;
		ConditionSprojectPricePanel c = new ConditionSprojectPricePanel();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectPricePanel dao = new QuerySprojectPricePanel();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSprojectPricePanel.ALL_CAPTIONS);
			for(BaseSprojectPricePanel b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


