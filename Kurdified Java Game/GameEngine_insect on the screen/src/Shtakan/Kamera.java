package Shtakan;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Kamera {
	
private Vector3f shwenyKamera  = new Vector3f(0,0,0);
private float barzwnzmy;  // pitch
private float amlawawla; //yaw
private float xulan; // roll


public void jwla() {
	if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
		shwenyKamera.z-=0.02f;
	}
	if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
		shwenyKamera.x+=0.02f;
		
	}
	if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
		
		shwenyKamera.x-=0.02f;
	}
	
}

public Vector3f getShwenyKamera() {
	return shwenyKamera;
}
public void setShwenyKamera(Vector3f shwenyKamera) {
	this.shwenyKamera = shwenyKamera;
}
public float getBarzwnzmy() {
	return barzwnzmy;
}
public void setBarzwnzmy(float barzwnzmy) {
	this.barzwnzmy = barzwnzmy;
}
public float getAmlawawla() {
	return amlawawla;
}
public void setAmlawawla(float amlawawla) {
	this.amlawawla = amlawawla;
}
public float getXulan() {
	return xulan;
}
public void setXulan(float xulan) {
	this.xulan = xulan;
}



}
