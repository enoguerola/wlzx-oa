package system.entity
{
	import mx.collections.ArrayCollection;
	[Bindable]
	[RemoteClass(alias="system.entity.MenuModel")] 
	public class MenuModel extends BaseModel
	{
		
		public var detail:String;
		public var menuIcon:String;
		public var children:Object=new Array();//子系统集
		public var parent:Object=new Array();//父亲系统集
		public var systems:Object=new Array();//系统集
		public var modules:Object=new Array();//模块集
		public function getUrl():String{
			if(modules!=null&&ArrayCollection(modules).length>0){
				return ModuleModel(ArrayCollection(modules).getItemAt(0)).url;
			}
			else return null;
		};
		public function getParms():String{
			if(modules!=null&&ArrayCollection(modules).length>0){
				return ModuleModel(ArrayCollection(modules).getItemAt(0)).parms;
			}
			else return null;
		};
		public function MenuModel()
		{
		}
	}
}