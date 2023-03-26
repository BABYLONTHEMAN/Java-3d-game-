package packegiShader;

public class ShaderyJegir extends programyShader{

	private static final String failaTextakay_vertexaka ="src/packegiShader/shaderyVertex.txt";
	private static final String failaTextakay_fragmentaka ="src/packegiShader/shaderyFragment.txt";
	
	
	public ShaderyJegir() {
		super(failaTextakay_vertexaka, failaTextakay_fragmentaka);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void baindySifatakan() {
super.baindySifatakan(0, "shwenakan");	
super.baindySifatakan(1, "pekhatayHawriz");
	}

}
