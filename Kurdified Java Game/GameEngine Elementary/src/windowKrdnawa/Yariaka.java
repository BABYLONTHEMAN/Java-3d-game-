package windowKrdnawa;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import Pekhata.PekhatayModel;
import Shtakan.Sht;
import modelakan.model;
import modelakan.modelyPekhenraw;
import packegiShader.ShaderyJegir;

public class Yariaka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pshanyba.drwstkrdnyPishandanaka();

		// 000000000000 bangi methodakan akain
		Loadkrdn loadkar = new Loadkrdn();
		
		ShaderyJegir shaderakaman = new ShaderyJegir(); // la tutorialy 4/5 zyay akain
		RenderKrdn renderbka = new RenderKrdn(shaderakaman);
		// 00000000000 openGL tasawri lwtkakan akat ba 3aksy sa3at basheway default
		// daianet
		float[] lwtkakan = { // lwtka =vertices
				-0.5f, 0.5f, 0f, -0.5f, -0.5f, 0f, 0.5f, -0.5f, 0f, // 3goshay xwarawa chap
				0.5f, 0.5f, 0f

		};
		int[] indisekan = { 0, 1, 3, 3, 1, 2
				// ,2,4,8
				// ,6,7,8

		};
		float[] pekhatayHawriz = {

				0, 0, // v0
				0, 1, // v1
				1, 1, // v2
				1, 0 // v3

		};

		model da3ba = loadkar.bikanawVAO(lwtkakan, pekhatayHawriz, indisekan);

		modelyPekhenraw da3baypekhenraw = new modelyPekhenraw(da3ba,
				new PekhatayModel(loadkar.PekhataLoadka("rasmaka")));
		Sht shtakaman = new Sht(da3baypekhenraw, new Vector3f(0, 0, -1), 0, 0, 0, 1);
	
		while (!Display.isCloseRequested()) {
			shtakaman.zyakrdnyShwen(0, 0, -0.1f);
			renderbka.amadakar();
			shaderakaman.dastpekrdn();
			renderbka.renderDrwstBka(shtakaman, shaderakaman);
			shaderakaman.wastan();
			Pshanyba.tazakrdnawayPeshandan();
		}
		shaderakaman.pakkrdnawa();
		loadkar.pakkrdnawa();
		Pshanyba.daxstnawayPeshandan();
	}
}
