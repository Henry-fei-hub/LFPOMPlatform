package pomplatform.scapitaldistributionor.handler;

import org.apache.log4j.Logger;
import pomplatform.scapitaldistributionor.bean.BaseScapitaldistributionor;
import pomplatform.scapitaldistributionor.bean.ConditionScapitaldistributionor;
import pomplatform.scapitaldistributionor.query.QueryScapitaldistributionor;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseCapitalDistributionLinkDepartment;
import com.pomplatform.db.dao.CapitalDistributionLinkDepartment;
import com.pomplatform.db.bean.BaseCapitalDistributionLinkSubContract;
import com.pomplatform.db.dao.CapitalDistributionLinkSubContract;
import delicacy.common.BaseCollection;

public class ScapitaldistributionorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ScapitaldistributionorHandler.class);

	public static BaseCollection<BaseScapitaldistributionor> executeQueryScapitaldistributionor(ConditionScapitaldistributionor c, KeyValuePair[] replacements ) throws Exception {
		QueryScapitaldistributionor dao = new QueryScapitaldistributionor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseScapitaldistributionor> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			CapitalDistributionLinkDepartment daoCapitalDistributionLinkDepartment = new CapitalDistributionLinkDepartment();
			CapitalDistributionLinkSubContract daoCapitalDistributionLinkSubContract = new CapitalDistributionLinkSubContract();
			for(BaseScapitaldistributionor bean : result.getCollections()){
				daoCapitalDistributionLinkDepartment.setConditionCapitalDistributionId("=", bean.getCapitalDistributionId());
				bean.setDetailCapitalDistributionLinkDepartment(daoCapitalDistributionLinkDepartment.conditionalLoad(null));
				daoCapitalDistributionLinkSubContract.setConditionCapitalDistributionId("=", bean.getCapitalDistributionId());
				bean.setDetailCapitalDistributionLinkSubContract(daoCapitalDistributionLinkSubContract.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionScapitaldistributionor c = new ConditionScapitaldistributionor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseScapitaldistributionor> result = executeQueryScapitaldistributionor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseScapitaldistributionor> result;
		ConditionScapitaldistributionor c = new ConditionScapitaldistributionor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryScapitaldistributionor dao = new QueryScapitaldistributionor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseScapitaldistributionor.ALL_CAPTIONS);
			for(BaseScapitaldistributionor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


