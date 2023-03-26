package packegiShader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public abstract class programyShader {
	private int IDprogramaka;
	private int IDvertexshader;
	private int IDfragmentshader;
	
	private static FloatBuffer bafaryMatrix= BufferUtils.createFloatBuffer(16);
	
	public programyShader (String failyVertex, String failyFragment) {
		IDvertexshader = ShaderLoadKa(failyVertex, GL20.GL_VERTEX_SHADER);
		IDfragmentshader = ShaderLoadKa(failyFragment,GL20.GL_FRAGMENT_SHADER);
		IDprogramaka=GL20.glCreateProgram();
		GL20.glAttachShader(IDprogramaka, IDvertexshader);
		GL20.glAttachShader(IDprogramaka, IDfragmentshader);
		baindySifatakan();
		GL20.glLinkProgram(IDprogramaka);
		GL20.glValidateProgram(IDprogramaka);
		wargrtnyHamwShwenyUniformakan();
		}
	protected abstract void wargrtnyHamwShwenyUniformakan(); //T 7
	protected int ShwenyUniformWargra(String nawiUniformaka) { //T 7
		return GL20.glGetUniformLocation(IDprogramaka, nawiUniformaka);
		
	}
	
	public void dastpekrdn() {
		GL20.glUseProgram(IDprogramaka);
	}

	public void wastan() {
		GL20.glUseProgram(0);
	}
	
	public void pakkrdnawa() {
		wastan();
		GL20.glDetachShader(IDprogramaka, IDvertexshader);
		GL20.glDetachShader(IDprogramaka, IDfragmentshader);
		GL20.glDeleteShader(IDvertexshader);
		GL20.glDeleteShader(IDfragmentshader);
		GL20.glDeleteProgram(IDprogramaka);
	}
	
	protected abstract void baindySifatakan();
	protected void baindySifatakan(int sifat,String nawiGorawaka) {
		GL20.glBindAttribLocation(IDprogramaka, sifat, nawiGorawaka);
	}
	protected void FloatLodKa(int Shwen, float nrx) { //T 7 , wata tutorialy 7 aw T'ya 
		
		GL20.glUniform1f(Shwen, nrx);
	}
	protected void TirLodka(int Swhen,Vector3f Tir) {  //T 7,  Tir wata vector 
		GL20.glUniform3f(Swhen, Tir.x, Tir.y, Tir.z);
		
	}
	protected void BooleanLodka(int Shwen,boolean nrx) { //T 7
		float lodKa = 0;
		if(nrx) {
			lodKa=1;
		}
		GL20.glUniform1f(Shwen, lodKa);
	}

	protected void MatrixLodka(int shwen, Matrix4f matrix) {
		matrix.store(bafaryMatrix);
		bafaryMatrix.flip(); //flip 7azry akat
		GL20.glUniformMatrix4(shwen, false, bafaryMatrix);
		
	}
	private static int ShaderLoadKa (String failaka, int jor) {
		StringBuilder sarchawayShader = new StringBuilder();
		try {
			BufferedReader xwenarawa = new BufferedReader(new FileReader(failaka));
			String xat;
			while((xat=xwenarawa.readLine())!=null) {
				sarchawayShader.append(xat).append("\n");
			}
			xwenarawa.close();
		} catch (IOException e) {
			System.err.println("natwanra failaka bxwenretawa");
			e.printStackTrace();
			System.exit(-1);
		}
		
		int IDshader = GL20.glCreateShader(jor);
		GL20.glShaderSource(IDshader, sarchawayShader);
		GL20.glCompileShader(IDshader);

	
	if(GL20.glGetShaderi(IDshader, GL20.GL_COMPILE_STATUS)==GL11.GL_FALSE)
		{
		System.out.println(GL20.glGetShaderInfoLog(IDshader, 500));
		System.err.println("Natwanra shader bxwenretawa.");
		System.exit(-1);
		
		}
	return IDshader;
		}
}
