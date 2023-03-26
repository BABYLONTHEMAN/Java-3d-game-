package packegiShader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public abstract class programyShader {
	private int IDprogramaka;
	private int IDvertexshader;
	private int IDfragmentshader;
	
	public programyShader (String failyVertex, String failyFragment) {
		IDvertexshader = ShaderLoadKa(failyVertex, GL20.GL_VERTEX_SHADER);
		IDfragmentshader = ShaderLoadKa(failyFragment,GL20.GL_FRAGMENT_SHADER);
		IDprogramaka=GL20.glCreateProgram();
		GL20.glAttachShader(IDprogramaka, IDvertexshader);
		GL20.glAttachShader(IDprogramaka, IDfragmentshader);
		baindySifatakan();
		GL20.glLinkProgram(IDprogramaka);
		GL20.glValidateProgram(IDprogramaka);
		
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
