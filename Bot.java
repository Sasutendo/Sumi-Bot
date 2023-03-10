import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import rest.*;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class Bot {
    public static void main(String[] args) throws LoginException {

        String prefix = "%";

        String status;
        status = "%help";

        int zahl = 12;
        double kommazahl = 1.45;

        String TOKEN = ""; //add your token in ""

        JDABuilder build = JDABuilder.createDefault(TOKEN);

        build.setStatus(OnlineStatus.ONLINE);
        build.setActivity(Activity.playing(status));

        build.setChunkingFilter(ChunkingFilter.ALL);
        build.setMemberCachePolicy(MemberCachePolicy.ALL);
        build.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.DIRECT_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT);

        EnumSet<CacheFlag> enumSet = EnumSet.of(CacheFlag.ONLINE_STATUS, CacheFlag.CLIENT_STATUS, CacheFlag.EMOJI, CacheFlag.VOICE_STATE);

        build.addEventListeners(new Message());
        build.addEventListeners(new welcome());
        build.addEventListeners(new view());
        build.addEventListeners(new Admin());

        JDA bot = bauplan.build();
        System.out.println("Bot is Online");
        System.out.println("The Prefix is set to: " + prefix);

    }
}
