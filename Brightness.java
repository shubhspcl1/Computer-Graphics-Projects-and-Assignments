package graphics;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Brightness {
	   static int width;
	   static int height;
	   static double alpha = 2;
	   static double beta = 50;
	   
	   public static void main( String[] args ) {
	   
	      try{
	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         Mat source =  Imgcodecs.imread("C:\\Users\\shubh\\Desktop\\test.jpg",Imgcodecs.CV_LOAD_IMAGE_COLOR);
	         Mat destination = new Mat(source.rows(),source.cols(),
	         
	         source.type());
	         source.convertTo(destination, -1, alpha, beta);
	         Imgcodecs.imwrite("C:\\Users\\shubh\\Desktop\\Brightness.jpg", destination);
	         
	      }catch (Exception e) {
	         System.out.println("error: " + e.getMessage());
	      }
	      System.out.println("Done! Check your desktop!");
	   }

}
