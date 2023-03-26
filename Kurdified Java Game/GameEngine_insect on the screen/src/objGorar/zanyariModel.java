package objGorar;

public class zanyariModel {

	private float[] lwtkakan;
	private float[] pekhatayHawriz;
	private float[] normalakan;
	private int [] indisekan;
	private float dwrtrinNwqta;
	public zanyariModel(float[] lwtkakan, float[] pekhatayHawriz, float[] normalakan, int[] indisekan,
			float dwrtrinNwqta) {
		
		this.lwtkakan = lwtkakan;
		this.pekhatayHawriz = pekhatayHawriz;
		this.normalakan = normalakan;
		this.indisekan = indisekan;
		this.dwrtrinNwqta = dwrtrinNwqta;
	}
	public float[] getLwtkakan() {
		return lwtkakan;
	}
	
	public float[] getPekhatayHawriz() {
		return pekhatayHawriz;
	}
	
	public float[] getNormalakan() {
		return normalakan;
	}
	
	public int[] getIndisekan() {
		return indisekan;
	}
	
	public float getDwrtrinNwqta() {
		return dwrtrinNwqta;
	}
	
	
}
