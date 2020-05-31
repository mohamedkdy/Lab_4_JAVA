package Lab4Generics.MyExcep;

public class ExcepPassHere extends IllegalArgumentException {
    @Override
    public void printStackTrace() {
        System.out.println("\nPass already here\n");
        //super.printStackTrace();
    }
}
