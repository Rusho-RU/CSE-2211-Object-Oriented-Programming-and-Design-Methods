package batchGrayscale;

import edu.duke.*;
import java.io.File;

public class ColorToNegative {
    public void convertToNegative(ImageResource mainImage){
        ImageResource negativeImage = new ImageResource(mainImage.getWidth(), mainImage.getHeight());

        for(Pixel pixel : negativeImage.pixels()){
            Pixel mainPixel = mainImage.getPixel(pixel.getX(), pixel.getY());

            pixel.setGreen(255 - mainPixel.getGreen());
            pixel.setBlue(255 - mainPixel.getBlue());
            pixel.setRed(255 - mainPixel.getRed());
        }

        String mainFileName = mainImage.getFileName();
        String newFileName = "inverted-" + mainFileName;
        negativeImage.setFileName(newFileName);
        negativeImage.save();
        negativeImage.draw();

        return;
    }

    public void makeNegative(DirectoryResource directoryResource){
        for(File file : directoryResource.selectedFiles()){
            ImageResource mainImage = new ImageResource(file);
            convertToNegative(mainImage);
        }
        return;
    }

    public static void main(String args[]){
        DirectoryResource directoryResource = new DirectoryResource();
        ColorToNegative obj = new ColorToNegative();

        obj.makeNegative(directoryResource);
    }
}
