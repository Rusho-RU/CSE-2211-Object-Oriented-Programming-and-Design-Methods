package batchGrayscale;

import edu.duke.*;
import java.io.File;

public class ColorToGray {
    public void convertToGray(ImageResource mainImage){
        ImageResource grayedImage = new ImageResource(mainImage.getWidth(), mainImage.getHeight());

        for(Pixel pixel : grayedImage.pixels()){
            Pixel mainPixel = mainImage.getPixel(pixel.getX(), pixel.getY());

            int average = (mainPixel.getRed() + mainPixel.getBlue() + mainPixel.getGreen()) / 3;

            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);
        }

        String mainFileName = mainImage.getFileName();
        String newFilename = "gray-" + mainFileName;
        grayedImage.setFileName(newFilename);
        grayedImage.draw();
        grayedImage.save();
    }

    public void makeGray(DirectoryResource directoryResource){
        for(File file : directoryResource.selectedFiles()){
            ImageResource mainImage = new ImageResource(file);
            convertToGray(mainImage);
        }
    }

    public static void main(String args[]){
        ColorToGray obj = new ColorToGray();
        DirectoryResource directoryResource = new DirectoryResource();

        obj.makeGray(directoryResource);
    }
}
