package views;

public class Util {
    public static void ClearConsole(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
