package oa.entity.sendingFiles
{
	import mx.collections.ArrayCollection;
	
	import oa.entity.BaseModel;
	
	[Bindable]
	[RemoteClass(alias="system.wlims.oa.entity.sendingFiles.SendingFileModel")]
	public class SendingFileModel 
	{
		public var  id:String;
		public var  title:String;
		public var  content:String;
		public var  authorId:String;
		public var  creationDate:Date;
		public var  auspiceDepartment:String;
		public var  subject:String;
		public var  mainSends:String;
		public var  upSends:String;
		public var  downSends:String;
		public var  dispatchWord:String;
		public var  dispatchYear:String;
		public var  dispatchNumber:String;
		public var  dispatchDate:Date;
		public var  status:int;
		public var  isCompleted:int;
		public var  fileFlows:ArrayCollection = new ArrayCollection();
		public var  attachments:ArrayCollection = new ArrayCollection();
		public function SendingFileModel()
		{
			//super();
		}
		public function getFirstDraftStepFlowId():String{
			for(var i:int=0;i<fileFlows.length;i++){
				if(fileFlows.getItemAt(i).type==0){
					return fileFlows.getItemAt(i).id;
				}
			}
			return null;
		}
	}
}