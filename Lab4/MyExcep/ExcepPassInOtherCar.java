package Lab4Generics.MyExcep;

public class ExcepPassInOtherCar extends IllegalArgumentException {
    @Override
    public void printStackTrace() {
        System.out.println("\nPass in other car\n");
       // super.printStackTrace();
    }
}
