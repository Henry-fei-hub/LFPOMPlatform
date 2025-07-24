package pomplatform.workflow.personnelbusiness.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.workflow.personnelbusiness.bean.BaseNetworkPrivileges;
import pomplatform.workflow.personnelbusiness.bean.BaseGoodsApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionCarsApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionNetworkPrivileges;
import pomplatform.workflow.personnelbusiness.query.QueryNetworkPrivileges;

public class NetworkPrivilegesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NetworkPrivilegesHandler.class);

	public static BaseCollection<BaseNetworkPrivileges> executeQueryNetworkPrivileges(ConditionNetworkPrivileges c, KeyValuePair[] replacements ) throws Exception {
		QueryNetworkPrivileges dao = new QueryNetworkPrivileges();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNetworkPrivileges> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNetworkPrivileges c = new ConditionNetworkPrivileges();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNetworkPrivileges> result = executeQueryNetworkPrivileges(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNetworkPrivileges> result;
		ConditionCarsApply c = new ConditionCarsApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNetworkPrivileges dao = new QueryNetworkPrivileges();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGoodsApply.ALL_CAPTIONS);
			for(BaseNetworkPrivileges b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


