public class Utilities {
    public static void pause(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //new//
    public static int parseInt(String s, int ifInvalid){
        try{
            return Integer.parseInt(s);
        }catch (Exception e){
        return ifInvalid;
        }
    }
}
