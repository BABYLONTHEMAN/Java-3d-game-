package objGorar;

import org.lwjgl.util.vector.Vector3f;

public class Lwtka {

	private static final int Be_Nawarok = -1;
	
	private Vector3f shwen;
	private int NawarokyPekhata = Be_Nawarok;
	private int NawarokyNormal = Be_Nawarok;
	private Lwtka LwtkaDabllKa = null;
	private int nawarok;
	private float drezhy;
	
	public Lwtka(int nawarok, Vector3f shwen) {
		this.nawarok=nawarok;
		this.shwen=shwen;
		this.drezhy=shwen.length();
	}
	
	public int nawarokWargra() {
		return nawarok;
	}
	public float drezhyWargra() {
		return drezhy;
	}
	public boolean danRawa() {
		return NawarokyPekhata!=Be_Nawarok && NawarokyNormal!=Be_Nawarok;
	}
	public boolean HamanpekhatawNormalyHaya(int NawarokypekhatakayTr, int NawarokyNormalakayTr) {
		return NawarokypekhatakayTr == NawarokyPekhata && NawarokyNormalakayTr==NawarokyNormal;
	}
	public void nawarokyPekhataDane(int NawarokyPekhata) {  //dane wata Set
		this.NawarokyPekhata=NawarokyPekhata;
	}
	public void NawarokyNormalDane(int NawarokyNormal) {
		this.NawarokyNormal=NawarokyNormal;
	}
	public Vector3f shwenWargra() {
		return shwen;
	}
	public int nawarokyPekhataWargra() {
		return NawarokyPekhata;
	}
	public int nawarokyNormalWargra() {
		return NawarokyNormal;
	}
	public Lwtka LwtkaDablkaWargra() {
		return LwtkaDabllKa;
	}
	public void lwtkaDablkaDane(Lwtka LwtkaDabllKa) {
		this.LwtkaDabllKa=LwtkaDabllKa;
	}
}
