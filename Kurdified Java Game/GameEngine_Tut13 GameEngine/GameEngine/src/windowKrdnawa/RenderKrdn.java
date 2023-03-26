package windowKrdnawa;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.glu.Project;
import org.lwjgl.util.vector.Matrix4f;
import org.newdawn.slick.opengl.CursorLoader;

import Pekhata.PekhatayModel;
import Shtakan.Sht;
import Sndwq.birkary;
import modelakan.model;
import modelakan.modelyPekhenraw;
import packegiShader.ShaderyJegir;

// Rangw sht
public class RenderKrdn {
	
	private static final float gosha=70;
	private static final float BininiNzik = 0.1f;
	private static final float BininiDwr =1000;
	
	private Matrix4f RunakKrdnawaySinamaie;
	
	public RenderKrdn (ShaderyJegir shader) {
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
		DrwstkrdnyRunakkrdnawaySinamaie();
		shader.dastpekrdn();
		shader.lodyRunakkrdnawaySinamaie(RunakKrdnawaySinamaie);
		shader.wastan();
		
	}
	
	public void amadakar() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		//GL11.glEnable(GL11.GL_CULL_FACE); //xom wistm trianglakan bakar benm
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
		//GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glClearColor(1, 0.3f, 0.0f, 1);

	}

	//

	public void renderDrwstBka(Sht shtek, ShaderyJegir shaderek) {
		modelyPekhenraw TarasazyPekhenraw = shtek.getDa3ba();
		model da3baka = TarasazyPekhenraw.getXalada3ba();
		GL30.glBindVertexArray(da3baka.IDVaoWargra());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1); // ama la tutorialy 6 damanna
		GL20.glEnableVertexAttribArray(2);
		Matrix4f gorinyMatrix = birkary.drwstkrdnyGorinyMatrix(shtek.getShwen(), shtek.getXulanawayX(),
				shtek.getXulanawayY(), shtek.getXulanawayZ(), shtek.getPewan());
		shaderek.LodkrdnyGorinyMatrix(gorinyMatrix);
		PekhatayModel pekhata =TarasazyPekhenraw.getXalaPekhataka();
		shaderek.lodyGorawakanyRangdanawa(pekhata.getkzbwnyRangdanawa(), pekhata.getRangDanawa());
		GL13.glActiveTexture(GL13.GL_TEXTURE0);// ama la tutorialy 6 damanna
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, TarasazyPekhenraw.getXalaPekhataka().IDwargra());// ama la tutorialy 6
																								// damanna
		GL11.glDrawElements(GL11.GL_TRIANGLES, da3baka.VertexakanWargra(), GL11.GL_UNSIGNED_INT, 0);
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);// ama la tutorialy 6 damanna
		GL20.glDisableVertexAttribArray(2);
		GL30.glBindVertexArray(0);

	}
	
	private void DrwstkrdnyRunakkrdnawaySinamaie() {
		float RezhayLaian =(float) Display.getWidth()/(float) Display.getHeight(); //aspectRatio
		float pewany_Y = (float) ((1f / Math.tan(Math.toRadians(gosha/2f))) * RezhayLaian);
		float pewany_X = pewany_Y/RezhayLaian;
		float rezhayMawa = BininiDwr-BininiNzik;
		
		RunakKrdnawaySinamaie = new Matrix4f();
		RunakKrdnawaySinamaie.m00=pewany_X;
		RunakKrdnawaySinamaie.m11=pewany_Y;
		RunakKrdnawaySinamaie.m22=-((BininiDwr+BininiNzik) / rezhayMawa);
		RunakKrdnawaySinamaie.m23=-1;
		RunakKrdnawaySinamaie.m32=-((2*BininiNzik*BininiDwr)/rezhayMawa);
		RunakKrdnawaySinamaie.m33=0;
		
	}
}
