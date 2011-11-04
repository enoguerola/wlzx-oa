package basic.utils
{
	import flash.display.DisplayObject;

	public  class LockWinTool
	{
		import mx.managers.PopUpManager;
		
		public static var win:LockWin=null;
		/**
		 * 锁定当前窗口
		 */
		public static function lockCurrentWin(parentWin:DisplayObject,tip:String=null):void{
			if(win==null){
				win=LockWin(PopUpManager.createPopUp(parentWin,LockWin,true)); 
				win.tip.text=tip;
				PopUpManager.centerPopUp(win);
				win.percentHeight=100;
				win.percentWidth=100;
			}				
		}
		/**
		 * 解锁当前窗口
		 */
		public static function unLockCurrentWin():void{
			if(win!=null){
				PopUpManager.removePopUp(win);
				win=null;
			}
				
		}
	}
}