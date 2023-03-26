package Pekhata;

public class PekhatayModel {
	private int IDpekhataka;
	private float kzbwnyRangdanawa = 1;
	private float RangDanawa=0;

	public PekhatayModel (int ID) {
		this.IDpekhataka=ID;
		
	}
	
	public int IDwargra() {
		
		return this.IDpekhataka;
	}

	public float getkzbwnyRangdanawa() {
		return kzbwnyRangdanawa;
	}

	public void setkzbwnyRangdanawa(float kzbwnyRangdanawa) {
		this.kzbwnyRangdanawa = kzbwnyRangdanawa;
	}

	public float getRangDanawa() {
		return RangDanawa;
	}

	public void setRangDanawa(float rangDanawa) {
		RangDanawa = rangDanawa;
	}

	
}
