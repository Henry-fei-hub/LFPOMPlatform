package pomplatform.cwd.handler;

import org.apache.log4j.Logger;
import pomplatform.cwd.bean.BaseWorkplacePublicIPManage;
import pomplatform.cwd.bean.ConditionWorkplacePublicIPManage;
import pomplatform.cwd.query.QueryWorkplacePublicIPManage;
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

public class WorkplacePublicIPManageHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(WorkplacePublicIPManageHandler.class);

	public static BaseCollection<BaseWorkplacePublicIPManage> executeQueryWorkplacePublicIPManage(ConditionWorkplacePublicIPManage c, KeyValuePair[] replacements ) throws Exception {
		QueryWorkplacePublicIPManage dao = new QueryWorkplacePublicIPManage();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseWorkplacePublicIPManage> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionWorkplacePublicIPManage c = new ConditionWorkplacePublicIPManage();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseWorkplacePublicIPManage> result = executeQueryWorkplacePublicIPManage(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseWorkplacePublicIPManage> result;
		ConditionWorkplacePublicIPManage c = new ConditionWorkplacePublicIPManage();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryWorkplacePublicIPManage dao = new QueryWorkplacePublicIPManage();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseWorkplacePublicIPManage.ALL_CAPTIONS);
			for(BaseWorkplacePublicIPManage b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


