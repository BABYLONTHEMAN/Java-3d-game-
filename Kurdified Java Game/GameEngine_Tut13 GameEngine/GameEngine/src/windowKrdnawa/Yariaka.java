package windowKrdnawa;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import Pekhata.PekhatayModel;
import Shtakan.Kamera;
import Shtakan.OBJlodkar;
import Shtakan.Rwnaky;
import Shtakan.Sht;
import modelakan.model;
import modelakan.modelyPekhenraw;
import packegiShader.ShaderyJegir;

public class Yariaka {

	public static void main(String[] args) {

		Pshanyba.drwstkrdnyPishandanaka();

		// 000000000000 bangi methodakan akain
		Loadkrdn loadkar = new Loadkrdn();

		ShaderyJegir shaderakaman = new ShaderyJegir(); // la tutorialy 4/5 zyay akain
		RenderKrdn renderbka = new RenderKrdn(shaderakaman);
		// 00000000000 openGL tasawri lwtkakan akat ba 3aksy sa3at basheway default
		// daianet
		///////////////////////////

		// model da3ba = OBJlodkar.lodyOBJmodel("ctree", loadkar);
		model da3ba = OBJlodkar.lodyOBJmodel("dT", loadkar);

		modelyPekhenraw da3baypekhenraw = new modelyPekhenraw(da3ba, new PekhatayModel(loadkar.PekhataLoadka("dT")));
		PekhatayModel pekhata = da3baypekhenraw.getXalaPekhataka(); /* da3baypekhenraw = staticModel la ThinMatrix */
		pekhata.setkzbwnyRangdanawa(10); //kzbwn akain ba 10
		pekhata.setRangDanawa(1);
		Sht shtakaman = new Sht(da3baypekhenraw, new Vector3f(0, -2, -20), 0, 0, 0, 1); // xyz
		Rwnaky rwnaky = new Rwnaky(new Vector3f(0, 0, 1), new Vector3f(1, 1, 1));
		Kamera kamerayYari = new Kamera();

		while (!Display.isCloseRequested()) {
			shtakaman.zyakrdnyShwen(0, 0, -0.001f);
			shtakaman.zyakrdnySuranawa(0, 1, 0);
			kamerayYari.jwla();
			renderbka.amadakar();
			shaderakaman.dastpekrdn();
			shaderakaman.RwnakyLodka(rwnaky);
			shaderakaman.bininiMatrixLodka(kamerayYari);
			renderbka.renderDrwstBka(shtakaman, shaderakaman);
			shaderakaman.wastan();
			Pshanyba.tazakrdnawayPeshandan();
		}
		shaderakaman.pakkrdnawa();
		loadkar.pakkrdnawa();
		Pshanyba.daxstnawayPeshandan();
	}
}
