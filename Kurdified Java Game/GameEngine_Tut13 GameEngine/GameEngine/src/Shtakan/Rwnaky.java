package Shtakan;

import org.lwjgl.util.vector.Vector3f;

public class Rwnaky {

	private Vector3f shwen;
	private Vector3f rang;
	public Rwnaky(Vector3f shwen, Vector3f rang) {
		this.shwen = shwen;
		this.rang = rang;
	}
	public Vector3f getShwen() {
		return shwen;
	}
	public void setShwen(Vector3f shwen) {
		this.shwen = shwen;
	}
	public Vector3f getRang() {
		return rang;
	}
	public void setRang(Vector3f rang) {
		this.rang = rang;
	}
	
}
