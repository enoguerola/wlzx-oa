package system.wlims.oa.serviceImpl.course.adjust;
import java.util.Date;
import java.util.List;
import java.util.Set;


import system.components.SecurityUserHolder;
import system.dao.DepartmentDAO;
import system.entity.MessageModel;
import system.service.SystemService;
import system.utils.UtilDateTime;
import system.wlims.basic.service.teacher.TeacherService;
import system.wlims.oa.dao.course.adjust.CourseAdjustDAO;
import system.wlims.oa.entity.course.adjust.ApplyItemModel;
import system.wlims.oa.entity.course.adjust.ApplyModel;
import system.wlims.oa.entity.course.adjust.ApplyWorkFlowLog;
import system.wlims.oa.entity.workFlow.takeLeave.TakeLeaveForm;
import system.wlims.oa.service.course.adjust.CourseAdjustService;

public class CourseAdjustServiceImpl implements CourseAdjustService{
	private CourseAdjustDAO courseAdjustDAO;
	private SystemService systemService;
	private TeacherService teacherService;
	private DepartmentDAO departmentDAO;
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
		
//		systemService.sendMessage(MessageModel.DefaultFromId, systemService.getWorkersIds(TaskVO.EType.CourseAdjust_Approve.getValue()), MessageModel.MessageType.SYSTEM.getValue(), "您有一项调课申请需要进行审批");
		
		return true;
	}

	@Override
	public List<ApplyModel> personalApplySearch(String userId) {
		// TODO Auto-generated method stub
//		String accountId= SecurityUserHolder.getCurrentUser().getId();
		return courseAdjustDAO.personalApplySearch(userId);
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
			String content="您于"+UtilDateTime.toDateString(apply.getApplyCreationDate(), "yyyy-MM-dd HH:mm:ss")+"调课申请记录已取消，详情请查看调课申请记录";

			systemService.sendMessage(MessageModel.DefaultFromId, apply.getApplyTeacherId(), MessageModel.MessageType.SYSTEM.getValue(), content);
			
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
		ApplyModel newApply=courseAdjustDAO.get(apply.getId());
		if(newApply.getApplyStatus()==ApplyModel.ApplyStatus.DENY.getStatus()){
			return false;
		}else{
			newApply.getApplyItems().removeAll(newApply.getApplyItems());
			courseAdjustDAO.saveOrUpdate(newApply);
			newApply.setApplyItems(applyItems);
			newApply.setApplyReason(apply.getApplyReason());
			newApply.setApplyType(apply.getApplyType());
			ApplyWorkFlowLog log=new ApplyWorkFlowLog();
			log.setOperationName("编辑申请");
			log.setOperationResult("编辑编号为"+apply.getApplyNo()+"的申请记录");
			log.setOperationTime(new Date());
			log.setOperationTeacherId(apply.getApplyTeacherId());
			newApply.getLogs().add(log);
			courseAdjustDAO.saveOrUpdate(newApply);
			return true;
		}
//		ApplyModel preApply=courseAdjustDAO.get(apply.getId());
//		preApply.getApplyItems().removeAll(preApply.getApplyItems());
//		courseAdjustDAO.saveOrUpdate(preApply);	
//		ApplyModel newApply=courseAdjustDAO.get(apply.getId());
//		newApply.setApplyItems(applyItems);
		
//		courseAdjustDAO.saveOrUpdate(apply);
		
//		return true;
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
		ApplyModel newApply=courseAdjustDAO.get(apply.getId());
		newApply.setApplyItems(apply.getApplyItems());
		newApply.setApproveDate(apply.getApproveDate());
		newApply.setApproveRemark(apply.getApproveRemark());
		newApply.setApproveTeacherId(apply.getApproveTeacherId());
		
		ApplyWorkFlowLog log=new ApplyWorkFlowLog();
		log.setOperationName("课程处审批");
		if(apply.getApplyStatus()==ApplyModel.ApplyStatus.PASS.getStatus()){
			log.setOperationResult("课程处审批编号为"+apply.getApplyNo()+"的申请通过");
			newApply.setApplyStatus(ApplyModel.ApplyStatus.PASS.getStatus());
			//系统通知
			String adjustTeachers="";
			String adjustClasses="";
			String adjustPreTimes="";
			String adjustTimes="";
			for(ApplyItemModel item:apply.getApplyItems()){
				String name=teacherService.getTeacherNameByUserId(item.getAdjustActualTeacherId());
				if(name!=null){
					adjustTeachers+=name+"/";
					adjustClasses+=item.getApplyClass()+"/";
					adjustPreTimes+=UtilDateTime.dateString(item.getApplyCourseDate())+"  "+item.getApplyCourseTime()+"/";
					adjustTimes+=UtilDateTime.dateString(item.getAdjustActualDate())+"  "+item.getAdjustActualTime()+"/";
					String content2=teacherService.getTeacherNameByUserId(apply.getApplyTeacherId())+"老师申请与您调课已经审批通过，上课班级为"+item.getApplyClass()+"，课时"+UtilDateTime.dateString(item.getApplyCourseDate())+"  "+item.getApplyCourseTime()+",调整为课时"+UtilDateTime.dateString(item.getAdjustActualDate())+"  "+item.getAdjustActualTime()+"，请准时上课";
					systemService.sendMessage(MessageModel.DefaultFromId, item.getAdjustActualTeacherId(), MessageModel.MessageType.SYSTEM.getValue(), content2);

				}
			}
			String content="您申请的调课审批已经通过，调课教师为"+adjustTeachers+"，上课班级为"+adjustClasses+"，原课时间为"+adjustPreTimes+"，调整为"+adjustTimes+"，请准时上课";
			systemService.sendMessage(MessageModel.DefaultFromId, apply.getApplyTeacherId(), MessageModel.MessageType.SYSTEM.getValue(), content);
			//通知督导科
			if(departmentDAO.getSupervisorFlagDepartment()!=null&&departmentDAO.getSupervisorFlagDepartment().getMasterUsers().size()>0){
				
				String content2=teacherService.getTeacherNameByUserId(apply.getApplyTeacherId())+"申请的调课审批已经通过，调课教师为"+adjustTeachers+"，上课班级为"+adjustClasses+"，原课时间为"+adjustPreTimes+"，调整为"+adjustTimes;
				
				systemService.sendMessage(MessageModel.DefaultFromId,departmentDAO.getSupervisorFlagDepartment().getMasterUsers().iterator().next().getId() ,MessageModel.MessageType.SYSTEM.getValue(), content2,ApplyModel.class.getSimpleName(),apply.getId());
			}
		}
		else if(apply.getApplyStatus()==ApplyModel.ApplyStatus.DENY.getStatus()){
			log.setOperationResult("课程处审批编号为"+apply.getApplyNo()+"的申请不通过");
			newApply.setApplyStatus(ApplyModel.ApplyStatus.DENY.getStatus());
			
			String content="您申请的调课审批未通过，具体情况请查看调课申请记录详细";
			systemService.sendMessage(MessageModel.DefaultFromId, apply.getApplyTeacherId(), MessageModel.MessageType.SYSTEM.getValue(), content);

		}
		log.setOperationTime(new Date());
		log.setOperationTeacherId(apply.getApproveTeacherId());
		newApply.getLogs().add(log);

		courseAdjustDAO.saveOrUpdate(newApply);
		return true;
	}

	@Override
	public boolean saveArrange(ApplyModel apply) {
		// TODO Auto-generated method stub
		ApplyModel newApply=courseAdjustDAO.get(apply.getId());
		newApply.setApplyItems(apply.getApplyItems());
		newApply.setApproveDate(apply.getApproveDate());
		newApply.setApproveRemark(apply.getApproveRemark());
		newApply.setApproveTeacherId(apply.getApproveTeacherId());
		
		ApplyWorkFlowLog log=new ApplyWorkFlowLog();
		log.setOperationName("课程员安排");
		log.setOperationResult("课程员安排编号为"+apply.getApplyNo()+"的调课申请");
//		if(apply.getApplyStatus()==ApplyModel.ApplyStatus.PASS.getStatus()){
//			log.setOperationResult("课程员安排编号为"+apply.getApplyNo()+"的申请");
//			newApply.setApplyStatus(ApplyModel.ApplyStatus.PASS.getStatus());
//			//系统通知
//			String adjustTeachers="";
//			String adjustClasses="";
//			String adjustTimes="";
//			for(ApplyItemModel item:apply.getApplyItems()){
//				String name=teacherService.getTeacherNameByUserId(item.getAdjustActualTeacherId());
//				if(name!=null){
//					adjustTeachers+=name+"/";
//					adjustClasses+=item.getApplyClass()+"/";
//					adjustTimes+=item.getAdjustActualTime()+"/";
//					String content2=teacherService.getTeacherNameByUserId(apply.getApplyTeacherId())+"老师申请与您调课已经审批通过，所带班级为"+item.getApplyClass()+"，科目是"+item.getApplyCourse()+"，上课时间为"+item.getApplyCourseTime()+"，请准时上课";
//					systemService.sendMessage(MessageModel.DefaultFromId, item.getAdjustActualTeacherId(), MessageModel.MessageType.SYSTEM.getValue(), content2);
//
//				}
//			}
//			String content="您申请的调课审批已经通过，调课教师为"+adjustTeachers+"，调课班级为"+adjustClasses+"，调课时间为"+adjustTimes+"";
//			systemService.sendMessage(MessageModel.DefaultFromId, apply.getApplyTeacherId(), MessageModel.MessageType.SYSTEM.getValue(), content);
//
//		}
//		else if(apply.getApplyStatus()==ApplyModel.ApplyStatus.DENY.getStatus()){
//			log.setOperationResult("课程处审批编号为"+apply.getApplyNo()+"的申请不通过");
//			newApply.setApplyStatus(ApplyModel.ApplyStatus.DENY.getStatus());
//			
//			String content="您申请的调课审批未通过，具体情况请查看调课申请记录详细";
//			systemService.sendMessage(MessageModel.DefaultFromId, apply.getApplyTeacherId(), MessageModel.MessageType.SYSTEM.getValue(), content);
//
//		}
		log.setOperationTime(new Date());
		log.setOperationTeacherId(SecurityUserHolder.getCurrentUser().getId());
		newApply.getLogs().add(log);

		courseAdjustDAO.saveOrUpdate(newApply);
		return true;
	}


	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	
}
