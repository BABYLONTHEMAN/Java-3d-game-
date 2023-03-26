package Sndwq;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class birkary {

	public static Matrix4f drwstkrdnyGorinyMatrix(Vector3f Tarjwma, float suranawayX, float suranawayY,
			float suranawayZ, float pewan) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.translate(Tarjwma, matrix, matrix);
		Matrix4f.rotate((float)Math.toRadians(suranawayX), new Vector3f(1, 0, 0), matrix, matrix);
		Matrix4f.rotate((float)Math.toRadians(suranawayY), new Vector3f(0, 1, 0), matrix, matrix);
		Matrix4f.rotate((float)Math.toRadians(suranawayZ), new Vector3f(0, 0, 1), matrix, matrix);
		Matrix4f.scale(new Vector3f(pewan,pewan,pewan),matrix,matrix);
		return matrix;
	}
}
