import java.util.HashMap;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class RoleReactions extends ListenerAdapter {

    final long channelID = 0000000000000000L; // CHANNEL ID
    
    HashMap<Long, Long> reactionToRoleID = new HashMap<>();
    
    // KEY = EMOTE ID    VALUE = ROLE ID
    public RoleReactions() {
        reactionToRoleID.put(0000000000000000L, 0000000000000000L);
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L);
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L);
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L);
        reactionToRoleID.put(0000000000000000L, 0000000000000000L);  
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L);
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
        reactionToRoleID.put(0000000000000000L, 0000000000000000L); 
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {
        if (e.getTextChannel().getIdLong() == channelID) {
            Long roleID = reactionToRoleID.get(e.getReactionEmote().getIdLong());
            if (roleID == null) {
                return;
            }
            e.getGuild().addRoleToMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();
        }
    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent e) {
        if (e.getTextChannel().getIdLong() == channelID) {
            Long roleID = reactionToRoleID.get(e.getReactionEmote().getIdLong());
            if (roleID == null) {
                return;
            }
            e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();
        }
    }
}
