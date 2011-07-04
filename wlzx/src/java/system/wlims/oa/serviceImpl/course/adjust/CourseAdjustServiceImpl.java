package system.wlims.oa.serviceImpl.course.adjust;
import java.util.Date;
import java.util.List;
import java.util.Set;


import system.components.SecurityUserHolder;
import system.utils.UtilDateTime;
import system.wlims.oa.dao.course.adjust.CourseAdjustDAO;
import system.wlims.oa.entity.course.adjust.ApplyItemModel;
import system.wlims.oa.entity.course.adjust.ApplyModel;
import system.wlims.oa.entity.course.adjust.ApplyWorkFlowLog;
import system.wlims.oa.service.course.adjust.CourseAdjustService;

public class CourseAdjustServiceImpl implements CourseAdjustService{
	private CourseAdjustDAO courseAdjustDAO;

	public CourseAdjustDAO getCourseAdjustDAO() {
		return courseAdjustDAO;
	}

	public void setCourseAdjustDAO(CourseAdjustDAO courseAdjustDAO) {
		this.courseAdjustDAO = courseAdjustDAO;
	}

	@Override
	public boolean applyAdd(ApplyModel apply) {
		// TODO Auto-generated method stub
		Date currenDate=new Date();
		apply.setApplyNo(UtilDateTime.toDateString(currenDate, "yyyyMMddHHmmss"));
		apply.setApplyCreationDate(currenDate);
		apply.setApplyStatus(ApplyModel.ApplyStatus.WAITING.getStatus());
		ApplyWorkFlowLog log=new ApplyWorkFlowLog();
		log.setOperationName("发起申请");
		log.setOperationResult("生成编号为"+apply.getApplyNo()+"的申请记录");
		log.setOperationTime(currenDate);
		log.setOperationTeacherId(apply.getApplyTeacherId());
		apply.getLogs().add(log);
		courseAdjustDAO.saveOrUpdate(apply);
		return true;
	}

	@Override
	public List<ApplyModel> personalApplySearch() {
		// TODO Auto-generated method stub
		String accountId= SecurityUserHolder.getCurrentUser().getId();
		return courseAdjustDAO.personalApplySearch(accountId);
	}

	@Override
	public boolean cancleApplyById(String applyId) {
		// TODO Auto-generated method stub
		ApplyModel apply=courseAdjustDAO.get(applyId);
		if(apply.getApplyStatus()!=ApplyModel.ApplyStatus.WAITING.getStatus()){
			return false;
		}else {
			apply.setApplyStatus(ApplyModel.ApplyStatus.CANCLE.getStatus());
			ApplyWorkFlowLog log=new ApplyWorkFlowLog();
			log.setOperationName("取消申请");
			log.setOperationResult("取消编号为"+apply.getApplyNo()+"的申请记录");
			log.setOperationTime(new Date());
			log.setOperationTeacherId(apply.getApplyTeacherId());
			apply.getLogs().add(log);
			courseAdjustDAO.saveOrUpdate(apply);
			return true;
		}
	
	}

	@Override
	public ApplyModel getApplyById(String applyId) {
		// TODO Auto-generated method stub
		return courseAdjustDAO.get(applyId);
	}

	@Override
	public ApplyModel loadApplyInfo(String applyId) {
		// TODO Auto-generated method stub
		return courseAdjustDAO.get(applyId);
	}
	@Override
	public boolean applyUpdate(ApplyModel apply, Set<ApplyItemModel> applyItems) {
		// TODO Auto-generated method stub
//		ApplyModel preApply=courseAdjustDAO.get(apply.getId());
//		preApply.getApplyItems().removeAll(preApply.getApplyItems());
//		courseAdjustDAO.saveOrUpdate(preApply);	
//		ApplyModel newApply=courseAdjustDAO.get(apply.getId());
//		newApply.setApplyItems(applyItems);
		ApplyWorkFlowLog log=new ApplyWorkFlowLog();
		log.setOperationName("编辑申请");
		log.setOperationResult("编辑编号为"+apply.getApplyNo()+"的申请记录");
		log.setOperationTime(new Date());
		log.setOperationTeacherId(apply.getApplyTeacherId());
		apply.getLogs().add(log);
		courseAdjustDAO.saveOrUpdate(apply);
		
		return true;
	}
//	
//	public static void main(String[] args) {
//		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"system/wlims/oa/serviceImpl/course/adjust/*.xml"});	 
//		 CourseAdjustService applyService=(CourseAdjustService)applicationContext.getBean("applyServiceDest");
//		 applyService.applyUpdate(null,null);
//		 
//	}

	@Override
	public List<ApplyModel> getAppliesByCondition(String accountId,
			Integer state, Integer type, String beginDate, String endDate) {
		return courseAdjustDAO.getAppliesByCondition(accountId, state, type, beginDate, endDate);
	}

	@Override
	public boolean deleteApplyById(String applyId) {
		// TODO Auto-generated method stub
		courseAdjustDAO.remove(courseAdjustDAO.get(applyId));
		return true;
	}

	@Override
	public boolean saveApprove(ApplyModel apply) {
		// TODO Auto-generated method stub
		ApplyWorkFlowLog log=new ApplyWorkFlowLog();
		log.setOperationName("课程处审批");
		if(apply.getApplyStatus()==ApplyModel.ApplyStatus.PASS.getStatus()){
			log.setOperationResult("课程处审批编号为"+apply.getApplyNo()+"的申请通过");
		}
		else if(apply.getApplyStatus()==ApplyModel.ApplyStatus.CANCLE.getStatus()){
			log.setOperationResult("课程处审批编号为"+apply.getApplyNo()+"的申请不通过");
		}
		log.setOperationTime(new Date());
		log.setOperationTeacherId(apply.getApproveTeacherId());
		apply.getLogs().add(log);
		courseAdjustDAO.saveOrUpdate(apply);
		return true;
	}
	
}
