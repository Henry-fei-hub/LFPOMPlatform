package pomplatform.ht.handler;

import org.apache.log4j.Logger;

import com.pomplatform.db.dao.MainProject;

import pomplatform.ht.bean.BaseMainProject;
import pomplatform.ht.bean.ConditionMainProject;
import pomplatform.ht.query.QueryMainProject;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class MainProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MainProjectHandler.class);

	public static BaseCollection<BaseMainProject> executeQueryMainProject(ConditionMainProject c, KeyValuePair[] replacements ) throws Exception {
		QueryMainProject dao = new QueryMainProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMainProject> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	/**
	 * 检查传进来的项目是否有
	 * 报价单
	 * @param mianProjectIds
	 * @return
	 * @throws SQLException
	 */
	public static Map<Integer,com.pomplatform.db.bean.BaseMainProject> getNewMainProject(String mianProjectIds) throws SQLException{
		Map<Integer,com.pomplatform.db.bean.BaseMainProject> map=new HashMap<>();
		//有报价单项目
		MainProject mp=new MainProject();
		StringBuilder sql=new StringBuilder();
		sql.append(" left join out_quotations o on info_code=o.info_code");
		sql.append(" left join out_design_considerations d on o.out_quotation_id=d.out_quotation_id");
		sql.append(" where mp.main_project_id in ("+mianProjectIds+")");
		List<com.pomplatform.db.bean.BaseMainProject> l=mp.conditionalLoad(BaseHelpUtils.getString(sql));
		for(com.pomplatform.db.bean.BaseMainProject b :l){
			map.put(b.getMainProjectId(), b);
		}
		return map;
	}
	@Override
	public String find(String creteria) throws Exception {
		ConditionMainProject c = new ConditionMainProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMainProject> result = executeQueryMainProject(c, c.getKeyValues());

		/**
		 * 当逆向项目没有 项目编号 进行该项目信息处理
		 */

		//数据处理前的list
		List<BaseMainProject> bList=result.getCollections();
		//定义处理后的list
		List<BaseMainProject> newList=new ArrayList<>();
		StringBuilder mianProjectIds=new StringBuilder();
		for(BaseMainProject b:bList){
			if(!BaseHelpUtils.isNullOrEmpty(b.getInfoCode())){
				if(BaseHelpUtils.isNullOrEmpty(mianProjectIds)){
					mianProjectIds.append(b.getMainProjectId());
				}else{
					mianProjectIds.append(",");
					mianProjectIds.append(b.getMainProjectId());
				}

			}
		}
		Map<Integer,com.pomplatform.db.bean.BaseMainProject> quotationsMap = null;
		if(!BaseHelpUtils.isNullOrEmpty(mianProjectIds)){
			quotationsMap=getNewMainProject(BaseHelpUtils.getString(mianProjectIds));
		}
		for(BaseMainProject b:bList){
			//判断是否有报价单
			Iterator<Map.Entry<Integer, com.pomplatform.db.bean.BaseMainProject>> entries = quotationsMap.entrySet().iterator();
			while (entries.hasNext()) {
			    Map.Entry<Integer, com.pomplatform.db.bean.BaseMainProject> entry = entries.next();
			    if(BaseHelpUtils.getIntValue(entry.getKey())==b.getMainProjectId()){
			    	b.setHasOutQuotations(true);
			    	break;
			    }
			}
			newList.add(b);
		}


		result.setCollections(newList);

		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMainProject> result;
		ConditionMainProject c = new ConditionMainProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMainProject dao = new QueryMainProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMainProject.ALL_CAPTIONS);
			for(BaseMainProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


