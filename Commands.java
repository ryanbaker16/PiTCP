import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

class Commands {
    static File msgs = new File("msgs");
    public static void main(String args[]){
        //FOR TESTING PURPOSE ONLY
        displayBoardOptions();
        writeBoard(0,"Hello world");
        String[] posts = readBoard(0);
        for (String p:posts){
            System.out.println(p);
        }
    }
  public static String execute(String str,String[] args){
    String out="";
    try {
      for (String s:args){
        str+=" "+args;
      }
      out=unix(str);
    }catch (Exception e){
      System.out.println("Error executing command: "+str+" erroring out");
      return "Err";
    }
    return out;
  }

  private static String name(){
    return "I am the server you made";
  }

  private static String isPrime(int n){
    for (int i=2;i<=n/3;i++){
      if (n%i==0)
        return "Not Prime";
    }
    return "Is Prime";
  }
/*
  private static String motivate(){

  }
*/
  private static String convert(int num, int b) // The fuck is this C?
    {
        int quotient = num / b;
        int remainder = num % b;

        if (quotient == 0) // base case
            return Integer.toString(remainder);
        else
            return convert(quotient, b) + Integer.toString(remainder);

    }
    private static String unix(String cmd) throws Exception{
      ProcessBuilder pb = new ProcessBuilder(cmd);
      return pb.start().getOutputStream().toString();
    }

    private void africa(){

      Process p = Runtime.getRuntime().exec("python Africa.py");

    }

    public static void displayBoardOptions(){
      String[] boards = displayIt(msgs);
      System.out.println("boards available to connect to :");
      for (int i=0;i<boards.length;i++){
          System.out.println("("+i+"):"+boards[i]);
      }
    }

    public static String[] readBoard(int select){
      String[] boards = displayIt(msgs);
      List<String> output = new ArrayList<>();
      try {
          BufferedReader file = new BufferedReader(new FileReader(new File("msgs/"+boards[select])));
          String line;
          do {
              line=file.readLine();
              if (line!=null)
                  output.add(line);
          } while (line!=null);
          file.close();
      }catch(Exception e){
          System.err.println("board like doesn't exist");
          output.clear();
          output.add("err");
      }
      String[] realO = new String[output.size()];
      for (int i=0;i<output.size();i++){
          realO[i] = output.get(i);
      }
      return realO;
    }

    public static boolean writeBoard(int select,String msg){
      String[] boards = displayIt(msgs);
      try {
          FileWriter write = new FileWriter("msgs/"+boards[select],true);
          write.append(msg+"\n");
          write.close();
      }catch(Exception e){
          System.err.println("Selection not found");
          return false;
      }
      return true;
    }

    public static String[] displayIt(File node){
      if(node.isDirectory()){
        return node.list();
        }else{
          return new String[]{node.getAbsoluteFile().toString()};
      }
  }

}
