package graphics;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.CvType;

public class Sobel {
	   public static void main( String[] args ) {
		   
		      try {
		         int kernelSize = 9;
		         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		         
		         Mat source = Imgcodecs.imread("C:\\Users\\shubh\\Desktop\\test1.jpg",  Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
		         Mat destination = new Mat(source.rows(),source.cols(),source.type());
		         
		         Mat kernel = new Mat(kernelSize,kernelSize, CvType.CV_32F){
		            {
		               put(0,0,-1);
		               put(0,1,0);
		               put(0,2,1);

		               put(1,0-2);
		               put(1,1,0);
		               put(1,2,2);

		               put(2,0,-1);
		               put(2,1,0);
		               put(2,2,1);
		            }
		         };	      
		         
		         Imgproc.filter2D(source, destination, -1, kernel);
		         Imgcodecs.imwrite("C:\\Users\\shubh\\Desktop\\Sobel.jpg", destination);
		         
		      } catch (Exception e) {
		         System.out.println("Error: " + e.getMessage());
		      }
		      System.out.println("Done! Check your desktop!");
		   }

}
