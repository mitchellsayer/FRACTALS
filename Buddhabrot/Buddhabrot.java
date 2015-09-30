import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Buddhabrot  {
	
	public static BufferedImage drawBuddha() {
        double cr, ci, zr, zi, zrAux, ziAux;
        float increm = 1/10000f;
        
        int i, j, n, maxN =25;
        double[][] trajectories = new double[maxN][2];
        int coX, coY, dimen = 1000, color;
        double[][] pixelsCol = new double[dimen][dimen];
        
        int[] pixels = new int[dimen*dimen];
        BufferedImage img;
        
        for (cr = -2; cr < 2; cr += increm) {
        	for (ci = -2; ci < 2; ci += increm) {
        		zrAux = 0;
        		ziAux = 0;
        		for (n = 0; n < maxN; n++) {
	        		zr = calculateReal(zrAux, ziAux, cr);
	        		zi = calculateImaginary(zrAux, ziAux, ci);
	        		trajectories[n][0] = zrAux = zr;
	        		trajectories[n][1] = ziAux = zi;
	        		if (zr*zr + zi*zi > 4)
	        			break;
        		}
        		if (n < maxN)
        			for (i = 0; i< n; i++) {
        				coX = (int)(((trajectories[i][0]+2) / 4)*dimen);
        				coY = (int)(((trajectories[i][1]+2) / 4)*dimen);
        				if (coX < 0 || coX >= dimen || coY < 0 || coY >= dimen)
        					continue;
        				pixelsCol[coX][coY]++;
        			}
        	}
        	
        }
        double maxColor = findMax(pixelsCol);
        double factorColor = 255 / maxColor;
        for (i = 0; i < dimen; i++) {
        	for (j = 0; j < dimen; j++) {
        		color = (int)(pixelsCol[i][j] * factorColor);
        		pixels[ i * dimen + j] = color << 16 | color << 8 | color;
        	}
        }
    	img = new BufferedImage(dimen,dimen, BufferedImage.TYPE_INT_RGB);
    	img.setRGB(0, 0, dimen, dimen, pixels, 0, dimen);
    	return img;
    	
	}
	
	private static double findMax(double[][] arr) {
		double max = 0;
		for (int j, i = 0; i < arr.length; i++) for (j = 0; j < arr[i].length; j++)
	        if (arr[i][j] > max) max = arr[i][j];
	    return max;
	}
	
    private static double calculateImaginary(double zr, double zi, double ci) {
		return 2 * zr * zi + ci;
	}

	private static double calculateReal(double zr, double zi, double cr) {
		return zr * zr - zi * zi + cr;
	}

	public static void main(String args[]) throws Exception {
		try {
            BufferedImage imagen = drawBuddha();
            ImageIO.write(imagen, "PNG", new File("BuddhaBrot65c.png"));
        } catch (Exception excepcion) { excepcion.printStackTrace(); }
    }
}