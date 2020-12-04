import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
public class Main {
    public static void main(String[] args) {
        JDABuilder jdaBuilder = new JDABuilder().createDefault("YOUR BOT TOKEN");
        JDA jda = null;
        
        jdaBuilder.addEventListeners(new RoleReactions());
        
        try {
            jda = jdaBuilder.build();
        } catch (LoginException ex) {
            ex.printStackTrace();
        }
        try {
            jda.awaitReady();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
  }
}
