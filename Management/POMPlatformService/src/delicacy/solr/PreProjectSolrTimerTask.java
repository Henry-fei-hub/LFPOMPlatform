package delicacy.solr;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;

import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.dao.PreProject;

import delicacy.common.BaseHelpUtils;

public class PreProjectSolrTimerTask extends TimerTask {

	@Override
    public void run() {
        long time1 = System.currentTimeMillis();
        try{
            System.out.println("开始建立前期项目信息的索引....");
            // 搜索出所有前期项目的参与相似度计算的字段信息
            PreProject dao = new PreProject();
            dao.unsetSelectFlags();
            dao.setSelectPreProjectId(true);
            dao.setSelectCustomerName(true);
            dao.setSelectProjectName(true);
            dao.setSelectProvince(true);
            dao.setSelectCity(true);
            dao.setSelectProjectType(true);
            dao.setSelectContactName(true);
            dao.setSelectContactPhone(true);
            dao.setSelectInfoCode(true);
            dao.setSelectRegion(true);
            dao.setSelectDetailAddress(true);
            dao.setSelectGrade(true);
            dao.setSelectTotalBuildingAreas(true);
            dao.setSelectEstimateTheDesignAreas(true);
            dao.setSelectProjectOrigination(true);
            dao.setSelectIsOperationDepartment(true);
            dao.setSelectComparisonForm(true);
            dao.setSelectRemark(true);
            dao.setSelectApplyEmployeeId(true);
            dao.setSelectCreateTime(true);
            List<BasePreProject> list = dao.conditionalLoad();
            if(null == list || list.isEmpty())
                return;
            SolrClient client = SolrUtils.getHttpSolrClient();
            List<SolrInputDocument> docList = new ArrayList<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(BasePreProject bean : list){
                generateDocument(bean, docList, dateFormat);
            }
            client.deleteByQuery("*:*");
            client.add(docList);
            client.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("本次索引创建总耗时为：" + (System.currentTimeMillis() - time1) + "ms");
    }
    
    public void generateDocument(BasePreProject bean, List<SolrInputDocument> list, SimpleDateFormat dateFormat) throws IOException{
        if(null == bean || null == list || null == dateFormat)
            return;
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("preProjectId", bean.getPreProjectId());
        //  开发商名称	分词索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getCustomerName())){
            doc.addField("customerName", bean.getCustomerName());
        }
        //  项目名称	分词索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getProjectName())){
            doc.addField("projectName", bean.getProjectName());
        }
        //  省份	索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getProvince())){
            doc.addField("province", bean.getProvince());
        }
        //  城市	索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getCity())){
            doc.addField("city", bean.getCity());
        }
        //	详细地址	不索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getDetailAddress())){
        	doc.addField("detailAddress", bean.getDetailAddress());
        }
        //  项目类别	索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getProjectType())){
            doc.addField("projectType", bean.getProjectType());
        }
        //  联系人	分词索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getContactName())){
            doc.addField("contactName", bean.getContactName());
        }
        //  联系电话	索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getContactPhone())){
            doc.addField("contactPhone", bean.getContactPhone());
        }
        //	信息编号	索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getInfoCode())){
        	doc.addField("infoCode", bean.getInfoCode());
        }
        //	区域	不索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getRegion())){
        	doc.addField("region", bean.getRegion());
        }
        //	职位	不索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getGrade())){
        	doc.addField("grade", bean.getGrade());
        }
        //	总建筑面积(㎡)	不索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getTotalBuildingAreas())){
        	doc.addField("totalBuildingAreas", bean.getTotalBuildingAreas());
        }
        //	设计面积(㎡)	不索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getEstimateTheDesignAreas())){
        	doc.addField("estimateTheDesignAreas", bean.getEstimateTheDesignAreas());
        }
        //	比选形式 	 不索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getComparisonForm())){
        	doc.addField("comparisonForm", bean.getComparisonForm());
        }
        //	项目来源	 不索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getProjectOrigination())){
        	doc.addField("projectOrigination", bean.getProjectOrigination());
        }
        //	运营组分配项目	 不索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getIsOperationDepartment())){
        	doc.addField("isOperationDepartment", bean.getIsOperationDepartment());
        }
        //	备注	 不索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getRemark())){
        	doc.addField("remark", bean.getRemark());
        }
        //	报备人	不索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getApplyEmployeeId())) {
        	doc.addField("applyEmployeeId", bean.getApplyEmployeeId());
        }
        //	报备时间	不索引，存储
        if(!BaseHelpUtils.isNullOrEmpty(bean.getCreateTime())) {
        	doc.addField("createTime", bean.getCreateTime().getTime());
        }
        list.add(doc);
    }
    
}
