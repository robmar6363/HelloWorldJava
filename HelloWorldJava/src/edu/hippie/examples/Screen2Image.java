package edu.hippie.examples;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;


/** Do screenshots every 10 seconds and save them to "c://temp" folder.
 * To terminate program click red square button (terminate) or Ctrl+C if launched from command line.  
 * @author Robert Marciniak
 * 
 *
 */
public class Screen2Image
{
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_hh_mm_ss_a");

    public void robo() throws Exception
    {
        Calendar now = Calendar.getInstance();
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                
        ImageIO.write(screenShot, "JPG", new File("c://temp/screenshot_"+formatter.format(now.getTime())+".jpg"));
        System.out.println(formatter.format(now.getTime()));
    }

    public static void main(String[] args) throws Exception
    {
        Screen2Image s2i = new Screen2Image();
        while(true)
        {
            s2i.robo();
            Thread.sleep(10000); // do screenshots every 10 seconds
        }
    }
}
