package windowKrdnawa;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import modelakan.model;
import modelakan.modelyPekhenraw;
// Rangw sht
public class RenderKrdn {
public void amadakar() {
	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	GL11.glClearColor(1,0,0,1);
	
}

//

public void renderDrwstBka(modelyPekhenraw TarasazyPekhenraw) {
	model da3baka = TarasazyPekhenraw.getXalada3ba();
	GL30.glBindVertexArray(da3baka.IDVaoWargra());
	GL20.glEnableVertexAttribArray(0);
	GL20.glEnableVertexAttribArray(1); //ama la tutorialy 6 damanna
	GL13.glActiveTexture(GL13.GL_TEXTURE0);//ama la tutorialy 6 damanna
	GL11.glBindTexture(GL11.GL_TEXTURE_2D, TarasazyPekhenraw.getXalaPekhataka().IDwargra());//ama la tutorialy 6 damanna
	GL11.glDrawElements(GL11.GL_TRIANGLES, da3baka.VertexakanWargra(),GL11.GL_UNSIGNED_INT,0);
	GL20.glDisableVertexAttribArray(0);
	GL20.glDisableVertexAttribArray(1);// ama la tutorialy 6 damanna
	GL30.glBindVertexArray(0);

}
}
