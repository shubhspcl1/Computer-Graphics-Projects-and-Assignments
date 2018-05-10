package graphics;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Histogram {
	   static int width;
	   static int height;
	   static double alpha = 2;
	   static double beta = 50;
	   
	   public static void main( String[] args ) {
	   
	      try {
	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         Mat source = Imgcodecs.imread("C:\\Users\\shubh\\Desktop\\test1.jpg", 
	         Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
	         Mat destination = new Mat(source.rows(),source.cols(),source.type());
	         
	         Imgproc.equalizeHist(source, destination);
	         Imgcodecs.imwrite("C:\\Users\\shubh\\Desktop\\Histogram.jpg", destination);
	         
	      }catch (Exception e) {
	         System.out.println("error: " + e.getMessage());
	      }
	      System.out.println("Done! Check your desktop!");
	   }


}
