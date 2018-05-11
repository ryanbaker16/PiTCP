import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

class Commands {
  public static String execute(String str,String[] args){

  }

  private static String name(){
    return "I am the server you made";
  }

  private static String isPrime(int n){
    for (int i=2,i<=n/3,i++){
      if (n%i==0)
        return "Not Prime";
    }
    return "Is Prime";
  }

  private static String motivate(){

  }

  private static String convert(int num, int b) // The fuck is this C?
    {
        int quotient = num / b;
        int remainder = num % b;

        if (quotient == 0) // base case
            return Integer.toString(remainder);
        else
            return convert(quotient, b) + Integer.toString(remainder);

    }
    private String unix(String cmd){
      ProcessBuilder pb = new ProcessBuilder(cmd);
      return pb.start().getOutputStream();
    }

    private void africa(){
      String bip = "bip.mp3";
      Media hit = new Media(new File(bip).toURI().toString());
      MediaPlayer mediaPlayer = new MediaPlayer(hit);
      mediaPlayer.play();
    }
}
