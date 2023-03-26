package windowKrdnawa;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import modelakan.model;

public class Loadkrdn {
	//00000000000000 ba dwadachony hamo VAO w VBO
	private List<Integer> vaos = new ArrayList<Integer>();
	private List<Integer> vbos = new ArrayList<Integer>();
	private List<Integer> pekhatakan = new ArrayList<Integer>(); //tutorially 6 zyay akain
	//000000000000000 kotaie badwadachon
	
	
	//public model bikanawVAO(float[] shwenakan) {  // shwen ya3ni = position ; Tutorial 2
	public model bikanawVAO(float[] shwenakan,float[] pekhatayHawriz,float[] normalakan, int[] indisekan) {  // shwen ya3ni = position ;
	int IDvao= drostkrdnyVAO();
	bindKrdnybafaryIndisekan(indisekan); //ama zya akain am mithoda la tutorial 3 
		saveKrdnyZanyaryLanawListakana(0,3,shwenakan); 
		saveKrdnyZanyaryLanawListakana(1,2,pekhatayHawriz); 
		saveKrdnyZanyaryLanawListakana(2, 3,normalakan);
		anBaindyVAO();
		//return new model(IDvao, shwenakan.length/3); ama tutorialy 2
		return new model(IDvao,indisekan.length);
		
		
	}
	public int PekhataLoadka(String nawiFailaka) { //Texture wata = pekhata
		Texture pekhata = null;
		try {
			pekhata = TextureLoader.getTexture("PNG", new FileInputStream("sarchawa/"+nawiFailaka+".png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int IDpekhataka = pekhata.getTextureID();
		pekhatakan.add(IDpekhataka);
		return IDpekhataka;
	}
	/////0000000000000
	//clean up
	//00000000000000000000000000000000000000 blocky pakrdnawa
	public void pakkrdnawa() {
		for (int vao: vaos) {
			GL30.glDeleteVertexArrays(vao);
		}
		
		
		

		for (int vbo:vbos) {
			GL15.glDeleteBuffers(vbo);
		}
		for(int pekhata:pekhatakan) {
			GL11.glDeleteTextures(pekhata);
		}
	}
	
	
	//0000000000000000000000000000000000000000
	
	private void bindKrdnybafaryIndisekan(int[] indisekan) {
		int IDvbo=GL15.glGenBuffers();
		vbos.add(IDvbo);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, IDvbo);
		IntBuffer bafar=saveKrdnyZanyaryLanawBafaryInta(indisekan);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, bafar, GL15.GL_STATIC_DRAW);
		
		
	}
	
private IntBuffer saveKrdnyZanyaryLanawBafaryInta(int[] zanyary ) {
		
		IntBuffer bafar = BufferUtils.createIntBuffer(zanyary.length);
		bafar.put(zanyary);
		bafar.flip();
		return bafar;
	} //am bafara gordrawi naw am blokaya tanha bo ama drwstkrawa away sarawa bafary xoyaty 
	
	
	
	//    drwstkrdny VAO
	private int drostkrdnyVAO() {
		int IDvao =GL30.glGenVertexArrays();
		vaos.add(IDvao);
		GL30.glBindVertexArray(IDvao);
		return IDvao;
	}
	//0000000 kotaie drwstkrdny VAO
	
	//000000000000000000
	//  save krdny zanyary la VAO
	
	private void saveKrdnyZanyaryLanawListakana(int zhmarayListaka, int qabarayHawrizakan,float[] zanyary) {
		int IDvbo =GL15.glGenBuffers();
		vbos.add(IDvbo);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, IDvbo);
		FloatBuffer bafar = savekrdnyZanyaryLanawbafaryFloata(zanyary);//drwstkrdny buffer
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, bafar, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(zhmarayListaka, qabarayHawrizakan, GL11.GL_FLOAT,false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0); //dway la axira bindy VBO akain
		
	}
	
	private void anBaindyVAO() {
		GL30.glBindVertexArray(0);
	}
	
	private FloatBuffer savekrdnyZanyaryLanawbafaryFloata(float [] zanyary) {
		FloatBuffer bafar = BufferUtils.createFloatBuffer(zanyary.length);
		bafar.put(zanyary);
		bafar.flip();
		return bafar;
	}
}
