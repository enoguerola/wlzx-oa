package system.component
{
	import flash.display.Loader;
	import flash.utils.ByteArray;
	
	public class WelcomeLogo extends Loader
	{
		[Embed(source="../WebContent/resources/common/layout/preloader.png", mimeType="application/octet-stream")]
		public var WelcomeScreenGraphic:Class;
		public function WelcomeLogo()
		{
			this.loadBytes(new WelcomeScreenGraphic() as ByteArray);
		}
		
	}
}