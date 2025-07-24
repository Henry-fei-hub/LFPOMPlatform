package pomplatform.projectItem.handler;

import org.apache.log4j.Logger;
import pomplatform.projectItem.bean.BaseSprojectItem;
import pomplatform.projectItem.bean.ConditionSprojectItem;
import pomplatform.projectItem.query.QuerySprojectItem;
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

public class SprojectItemHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectItemHandler.class);

	public static BaseCollection<BaseSprojectItem> executeQuerySprojectItem(ConditionSprojectItem c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectItem dao = new QuerySprojectItem();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectItem> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectItem c = new ConditionSprojectItem();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectItem> result = executeQuerySprojectItem(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectItem> result;
		ConditionSprojectItem c = new ConditionSprojectItem();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectItem dao = new QuerySprojectItem();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSprojectItem.ALL_CAPTIONS);
			for(BaseSprojectItem b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


