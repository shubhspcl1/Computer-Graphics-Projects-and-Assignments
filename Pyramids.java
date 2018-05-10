package graphics;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

class PyramidsRun {

    String window_name = "Pyramids Demo";

    public void run(String[] args) {
        System.out.println("\n" +
                " Zoom In-Out demo    \n" +
                "------------------   \n" +
                " * [i] -> Zoom [i]n  \n" +
                " * [o] -> Zoom [o]ut \n" +
                " * [ESC] -> Close program \n");

        String filename = ((args.length > 0) ? args[0] : "C:\\Users\\shubh\\Desktop\\test.jpg");
        Mat src = Imgcodecs.imread(filename);
        if( src.empty() ) {
            System.out.println("Error opening image!");
            System.out.println("Program Arguments: [image_name -- default C:\\Users\\shubh\\Desktop\\test.jpg] \n");
            System.exit(-1);
        }
        while (true){
            HighGui.imshow( window_name, src );
            char c = (char) HighGui.waitKey(0);
            c = Character.toLowerCase(c);

            if( c == 27 ){
                break;
            }else if( c == 'i'){
                Imgproc.pyrUp( src, src, new Size( src.cols()*2, src.rows()*2 ) );
                System.out.println( "** Zoom In: Image x 2" );

            }else if( c == 'o'){
                Imgproc.pyrDown( src, src, new Size( src.cols()/2, src.rows()/2 ) );
                System.out.println( "** Zoom Out: Image / 2" );
            }
        }

        System.exit(0);
    }
}

public class Pyramids {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        new PyramidsRun().run(args);
    }
}

