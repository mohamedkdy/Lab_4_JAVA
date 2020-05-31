package Lab4Generics.MyExcep;

public class ExcepNoPass extends IllegalArgumentException {
    @Override
    public void printStackTrace() {
        System.out.println("\nThis vehicle has not this passenger\n");
        //super.printStackTrace();
    }
}
