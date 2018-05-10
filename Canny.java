package graphics;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Canny {
	public static String path = "C:\\Users\\shubh\\Desktop\\test.jpg";
	public void detectEdges() {
	//read the RGB image
	Mat rgbImage = Imgcodecs.imread(path);
	//mat gray image holder
	Mat imageGray = new Mat();
	//mat canny image
	Mat imageCny = new Mat();
	//Show the RGB Image


	Imgproc.cvtColor(rgbImage, imageGray, Imgproc.COLOR_BGR2GRAY);
	Imgproc.Canny(imageGray, imageCny, 200, 300, 3, true);
	Imgcodecs.imwrite("C:\\Users\\shubh\\Desktop\\Canny.jpg", imageCny);
	}
	public static void main(String[] args) {
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	Canny edgeDetection = new Canny();
	edgeDetection.detectEdges();
	System.out.println("Done! Check your desktop!");
	}
}
