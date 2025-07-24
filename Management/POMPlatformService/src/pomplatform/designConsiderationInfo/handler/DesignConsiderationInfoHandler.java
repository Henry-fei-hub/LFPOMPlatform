package pomplatform.designConsiderationInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.designConsiderationInfo.bean.BaseDesignConsiderationInfo;
import pomplatform.designConsiderationInfo.bean.ConditionDesignConsiderationInfo;
import pomplatform.designConsiderationInfo.query.QueryDesignConsiderationInfo;
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

public class DesignConsiderationInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(DesignConsiderationInfoHandler.class);

	public static BaseCollection<BaseDesignConsiderationInfo> executeQueryDesignConsiderationInfo(ConditionDesignConsiderationInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryDesignConsiderationInfo dao = new QueryDesignConsiderationInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseDesignConsiderationInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionDesignConsiderationInfo c = new ConditionDesignConsiderationInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseDesignConsiderationInfo> result = executeQueryDesignConsiderationInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseDesignConsiderationInfo> result;
		ConditionDesignConsiderationInfo c = new ConditionDesignConsiderationInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryDesignConsiderationInfo dao = new QueryDesignConsiderationInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseDesignConsiderationInfo.ALL_CAPTIONS);
			for(BaseDesignConsiderationInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


