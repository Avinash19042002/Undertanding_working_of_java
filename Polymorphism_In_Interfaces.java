interface MyCamera{
    void takeSnap();
    void recordVideo();
    default void recordVideoIn4K(){
        System.out.println("Recording video in 4k Quality...");
    }

}
interface Wifi{
    String[] getNetworks();
    void connectToNetwork(String networks);
}

class CellPhone{
    public void call(String contact_no){
        System.out.println("Calling on..."+contact_no);
    }
    public void takeCall(){
        System.out.println("Receiving Call...");
    }
}
class MySmartPhone extends CellPhone implements MyCamera,Wifi {
    public void takeSnap(){
        System.out.println("Taking SnapShot...");
    }
    public void recordVideo(){
        System.out.println("Recording videos...");
    }
    public String[] getNetworks(){
        System.out.println("getting list of Networks Available : ");
       String [] networks={"\tbeta tumse n ho paayega","\tAvinash","\tNahi degi"};
       return networks;
    }
    public void connectToNetwork(String network){
        System.out.println("Connecting to \""+network+"\" ...");
    }

    public void useInternet(String url){
        System.out.println("Browsing "+url+" ...");
    }
}
public class Polymorphism_In_Interfaces {
    public static void main(String[] args) {
        System.out.println("We can only Access the methods of Camera as we are asking for a Camera");
     MyCamera camera = new MySmartPhone();
     camera.recordVideo();
     camera.recordVideoIn4K();
//     camera.call(); --> Not Allowed


        System.out.print("\n\n");
        System.out.println("Now we can Access all the methods either it is of Camera or Wifi or Smartphone");
     MySmartPhone phone = new MySmartPhone();
     phone.call("9939381075");
     phone.takeSnap();
     String[] list= phone.getNetworks();

     for (String it:list) System.out.println(it);

     phone.connectToNetwork("beta tumse n ho paayega");
     phone.takeCall();
     phone.recordVideoIn4K();
     phone.recordVideo();
     phone.useInternet("Google.com");
    }
}
