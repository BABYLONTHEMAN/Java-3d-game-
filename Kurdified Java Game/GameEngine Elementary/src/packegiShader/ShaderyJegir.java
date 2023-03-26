package packegiShader;

import org.lwjgl.util.vector.Matrix4f;

public class ShaderyJegir extends programyShader{

	private static final String failaTextakay_vertexaka ="src/packegiShader/shaderyVertex.txt";
	private static final String failaTextakay_fragmentaka ="src/packegiShader/shaderyFragment.txt";
	
	private int shwenyGorinyMatrix;
	private int shwenyRunakkrdnawaySinamaie;
	public ShaderyJegir() {
		super(failaTextakay_vertexaka, failaTextakay_fragmentaka);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void baindySifatakan() {
super.baindySifatakan(0, "shwenakan");	
super.baindySifatakan(1, "pekhatayHawriz");
	}

	@Override
	protected void wargrtnyHamwShwenyUniformakan() {
		shwenyGorinyMatrix=super.ShwenyUniformWargra("gorinyMatrix");
		shwenyRunakkrdnawaySinamaie = super.ShwenyUniformWargra("RunakkrdnawaySinamaie");
	}

	public void LodkrdnyGorinyMatrix(Matrix4f matrix) {
		super.MatrixLodka(shwenyGorinyMatrix, matrix);
	}
	
	public void lodyRunakkrdnawaySinamaie(Matrix4f Runakkrdnawa) {
		super.MatrixLodka(shwenyRunakkrdnawaySinamaie, Runakkrdnawa);
		
	}
}
