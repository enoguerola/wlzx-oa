package system.component
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.ProgressEvent;
	import flash.events.TimerEvent;
	import flash.text.TextField;
	import flash.utils.Timer;
	import mx.events.FlexEvent;
	import mx.preloaders.DownloadProgressBar;
	
	public class Preloader extends DownloadProgressBar
	{
		//显示进度的文字
		private var progressText:TextField;
		//进度条
		public var img:WelcomeScreen;
		//logo页面
		public var logo:WelcomeLogo;
		private var _timer:Timer;
		
		public function Preloader()
		{
			super();
			//加入logo
			logo = new WelcomeLogo();
			this.addChild(logo);
			//加入进度条
			img = new WelcomeScreen();
			this.addChild(img);
			//加入进度文字
			progressText = new TextField();
			progressText.x = 120;
			progressText.y = 90;
			
			this.addChild(progressText);
			
			//进度条计时器初始化，我们实现进度条的原理就是不停的刷新进图条图片
			//因为每次进度条的长度不同，所以就有进度条在走的效果
			_timer = new Timer(1);
			_timer.addEventListener(TimerEvent.TIMER, drawTimerHandler);
			_timer.start();
		}
		/**
		 * override这个函数，来实现自己Preloader的设置，而不是用其默认的设置
		 */
		override public function set preloader(value:Sprite):void
		{
			value.addEventListener(ProgressEvent.PROGRESS, progHandler);
			value.addEventListener(FlexEvent.INIT_COMPLETE, initCompleteHandler1);
			//在这里设置预载界面居中
			//如果在初始化函数中设置，会有stageWidth和最终界面大小不一致的错误，而导致不能居中
			x = (stageWidth/2) - (300/2);
			y = (stageHeight/2) - (180/2);
		}
		
		private function progHandler(e:ProgressEvent):void
		{
			//计算进度，并且设置文字进度和进度条的进度。
			var prog:Number = e.bytesLoaded/e.bytesTotal*100;
			progressText.text = "已下载 " + String(int(prog)) + "%";
			if(img)
			{
				img.progress = prog;
			}
		}
		
		private function compHandler(e:Event):void
		{
			
		}
		
		protected function initCompleteHandler1(event:Event):void
		{
			//如果载入完毕，则停止刷新
			img.ready = true;
			_timer.stop();
			//测试专用。下载完毕后，不马上跳到程序的默认界面。而是停顿1秒后再跳入。
//			var timer:Timer = new Timer(1000, 1);
//			timer.addEventListener(TimerEvent.TIMER, dispatchComplete);
//			timer.start();
			this.dispatchEvent(new Event(Event.COMPLETE));
		}
		
		private function initProgHandler(e:FlexEvent):void
		{
			
		}
		/**
		 * 一定要分发这个事件，来通知程序已经完全下载，可以进入程序的默认界面了
		 */
		private function dispatchComplete(event:TimerEvent):void
		{
			this.dispatchEvent(new Event(Event.COMPLETE));
		}
		/**
		 * 每个时钟周期都刷新进度条图片
		 */
		private function drawTimerHandler(event:TimerEvent):void
		{
			img.refresh();
		}
		
	}
}