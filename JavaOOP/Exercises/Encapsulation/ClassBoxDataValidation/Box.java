package JavaOOP.Exercises.Encapsulation.ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight((height));
    }

    private void setLength(double length){
        if(length<=0){
            throw new IllegalStateException("Length cannot be zero or negative.");
        }

        this.length = length;
    }


    public void setHeight(double height) {
        if(height<=0){
            throw new IllegalStateException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public void setWidth(double width) {
        if(width<=0){
            throw new IllegalStateException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public double calculateSurfaceArea(){
        return 2*length*width+2*length*height+2*width*height;
    }

    public double calculateLateralSurfaceArea(){
        return 2*length*height+2*width*height;
    }

    public double calculateVolume(){
        return length*width*height;
    }
}
