package pomplatform.cwd.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.dao.CompanyWorkplaceServer;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.cwd.bean.BaseCompanyWorkplaceAndServerManage;
import pomplatform.cwd.bean.ConditionCompanyWorkplaceAndServerManage;
import pomplatform.cwd.query.QueryCompanyWorkplaceAndServerManage;

public class CompanyWorkplaceAndServerManageHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CompanyWorkplaceAndServerManageHandler.class);

	public static BaseCollection<BaseCompanyWorkplaceAndServerManage> executeQueryCompanyWorkplaceAndServerManage(ConditionCompanyWorkplaceAndServerManage c, KeyValuePair[] replacements ) throws Exception {
		QueryCompanyWorkplaceAndServerManage dao = new QueryCompanyWorkplaceAndServerManage();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCompanyWorkplaceAndServerManage> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			CompanyWorkplaceServer daoCompanyWorkplaceServer = new CompanyWorkplaceServer();
			for(BaseCompanyWorkplaceAndServerManage bean : result.getCollections()){
				daoCompanyWorkplaceServer.setConditionWorkplaceId("=", bean.getCompanyWorkplaceId());
				bean.setDetailCompanyWorkplaceServer(daoCompanyWorkplaceServer.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCompanyWorkplaceAndServerManage c = new ConditionCompanyWorkplaceAndServerManage();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCompanyWorkplaceAndServerManage> result = executeQueryCompanyWorkplaceAndServerManage(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCompanyWorkplaceAndServerManage> result;
		ConditionCompanyWorkplaceAndServerManage c = new ConditionCompanyWorkplaceAndServerManage();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCompanyWorkplaceAndServerManage dao = new QueryCompanyWorkplaceAndServerManage();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCompanyWorkplaceAndServerManage.ALL_CAPTIONS);
			for(BaseCompanyWorkplaceAndServerManage b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


