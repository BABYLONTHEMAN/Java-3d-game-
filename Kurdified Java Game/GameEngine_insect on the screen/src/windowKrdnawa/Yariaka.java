package windowKrdnawa;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import Pekhata.PekhatayModel;
import Shtakan.Kamera;
import Shtakan.OBJlodkar;
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
		///////////////////////////
		/*
		float[] lwtkakan = { 
				
				-0.5f,0.5f,-0.5f,	
				-0.5f,-0.5f,-0.5f,	
				0.5f,-0.5f,-0.5f,	
				0.5f,0.5f,-0.5f,		
				
				-0.5f,0.5f,0.5f,	
				-0.5f,-0.5f,0.5f,	
				0.5f,-0.5f,0.5f,	
				0.5f,0.5f,0.5f,
				
				0.5f,0.5f,-0.5f,	
				0.5f,-0.5f,-0.5f,	
				0.5f,-0.5f,0.5f,	
				0.5f,0.5f,0.5f,
				
				-0.5f,0.5f,-0.5f,	
				-0.5f,-0.5f,-0.5f,	
				-0.5f,-0.5f,0.5f,	
				-0.5f,0.5f,0.5f,
				
				-0.5f,0.5f,0.5f,
				-0.5f,0.5f,-0.5f,
				0.5f,0.5f,-0.5f,
				0.5f,0.5f,0.5f,
				
				-0.5f,-0.5f,0.5f,
				-0.5f,-0.5f,-0.5f,
				0.5f,-0.5f,-0.5f,
				0.5f,-0.5f,0.5f


		};
		int[] indisekan = { 
				0,1,3,	
				3,1,2,	
				4,5,7,
				7,5,6,
				8,9,11,
				11,9,10,
				12,13,15,
				15,13,14,	
				16,17,19,
				19,17,18,
				20,21,23,
				23,21,22

		};
		float[] pekhatayHawriz = {

				0,0,
				0,1,
				1,1,
				1,0,			
				0,0,
				0,1,
				1,1,
				1,0,			
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0

		};
		//////////////////////////////////////////////////////////
*/
		//model da3ba = OBJlodkar.lodyOBJmodel("ctree", loadkar);
		model da3ba = OBJlodkar.lodyOBJmodel("insan", loadkar);
		
		modelyPekhenraw da3baypekhenraw = new modelyPekhenraw(da3ba,
				new PekhatayModel(loadkar.PekhataLoadka("insan")));
		Sht shtakaman = new Sht(da3baypekhenraw, new Vector3f(0,-2,-10), 0, 0, 0, 1); // xyz 
		Kamera kamerayYari = new Kamera();
		
		while (!Display.isCloseRequested()) {
			shtakaman.zyakrdnyShwen(0, 0, 0f);
			shtakaman.zyakrdnySuranawa(0, 1, 0);
			
			kamerayYari.jwla();
			renderbka.amadakar();
			shaderakaman.dastpekrdn();
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
