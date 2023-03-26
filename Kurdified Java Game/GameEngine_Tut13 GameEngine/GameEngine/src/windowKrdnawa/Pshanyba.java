package windowKrdnawa;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
public class Pshanyba {
private static final int pani=1280;
private static final int barzi =720;

private static final int ZHMARAY_FPS=120;

public static void drwstkrdnyPishandanaka() {
	ContextAttribs sifataka = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);

try
{
	Display.setDisplayMode(new DisplayMode(pani, barzi));
	Display.create();
}
catch (LWJGLException e){
	e.printStackTrace();
}
GL11.glViewport(0, 0, pani, barzi);

}
public static void tazakrdnawayPeshandan() {
	Display.sync(ZHMARAY_FPS);
	Display.update();
}

public static void daxstnawayPeshandan() {
	Display.destroy();
}
}