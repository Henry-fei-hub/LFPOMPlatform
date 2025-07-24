package pomplatform.finance.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.finance.bean.BaseMcapitalecoosmeor;
import pomplatform.finance.bean.ConditionMcapitalecoosmeor;
import pomplatform.finance.query.AllQueryMcapitalecoosmeor;
import pomplatform.finance.query.QueryBingContractMcapitalecoosmeor;
import pomplatform.finance.query.QueryMcapitalecoosmeor;

public class McapitalecoosmeorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McapitalecoosmeorHandler.class);

	public static BaseCollection<BaseMcapitalecoosmeor> executeQueryMcapitalecoosmeor(ConditionMcapitalecoosmeor c, KeyValuePair[] replacements ) throws Exception {
//		if(BaseHelpUtils.getIntValue(c.getContractId())==2){
//			QueryBingContractMcapitalecoosmeor dao=new QueryBingContractMcapitalecoosmeor();
//			dao.setCurrentPage(c.getCurrentPage());
//			dao.setPageLines(c.getPageLines());
//			BaseCollection<BaseMcapitalecoosmeor> result = dao.executeQuery( c.getKeyValues(), c) ;
//			return result;
//		}else if(BaseHelpUtils.getIntValue(c.getContractId())==1){
//			QueryMcapitalecoosmeor dao = new QueryMcapitalecoosmeor();
//			dao.setCurrentPage(c.getCurrentPage());
//			dao.setPageLines(c.getPageLines());
//			BaseCollection<BaseMcapitalecoosmeor> result = dao.executeQuery( c.getKeyValues(), c) ;
//			return result;
//		}else{
			AllQueryMcapitalecoosmeor dao = new AllQueryMcapitalecoosmeor();
			dao.setCurrentPage(c.getCurrentPage());
			dao.setPageLines(c.getPageLines());
			BaseCollection<BaseMcapitalecoosmeor> result = dao.executeQuery( c.getKeyValues(), c) ;
			return result;
//		}
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcapitalecoosmeor c = new ConditionMcapitalecoosmeor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcapitalecoosmeor> result = executeQueryMcapitalecoosmeor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcapitalecoosmeor> result;
		ConditionMcapitalecoosmeor c = new ConditionMcapitalecoosmeor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		 
		///
//		if(BaseHelpUtils.getIntValue(c.getContractId())==2){
//			QueryBingContractMcapitalecoosmeor dao=new QueryBingContractMcapitalecoosmeor();
//			dao.setCurrentPage(0);
//			result = dao.executeQuery( c.getKeyValues(), c) ;
//		}else if(BaseHelpUtils.getIntValue(c.getContractId())==1){
//			QueryMcapitalecoosmeor dao = new QueryMcapitalecoosmeor();
//			dao.setCurrentPage(0);
//			result = dao.executeQuery( c.getKeyValues(), c) ;
//		}else{
			AllQueryMcapitalecoosmeor dao = new AllQueryMcapitalecoosmeor();
			dao.setCurrentPage(0);
			result = dao.executeQuery( c.getKeyValues(), c) ;
//		}
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcapitalecoosmeor.LOCAL_CAPTIONS);
			
			 
			
			for(BaseMcapitalecoosmeor b : result.getCollections()){
				ps.println(b.toCSVString2());
			}
		}
	}
	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


