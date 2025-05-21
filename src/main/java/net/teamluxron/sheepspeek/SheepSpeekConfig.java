package net.teamluxron.sheepspeek;

import net.neoforged.neoforge.common.ModConfigSpec;
import java.util.List;

public class SheepSpeekConfig {
    public static final ServerConfig SERVER;
    public static final ModConfigSpec SERVER_SPEC;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        SERVER = new ServerConfig(builder);
        SERVER_SPEC = builder.build();
    }

    public static class ServerConfig {
        public final ModConfigSpec.BooleanValue enabled;
        public final ModConfigSpec.BooleanValue secretMessages;
        public final ModConfigSpec.ConfigValue<List<? extends String>> messages;
        public final ModConfigSpec.ConfigValue<List<? extends String>> entityTypes;

        public ServerConfig(ModConfigSpec.Builder builder) {
            builder.push("General Settings");

            enabled = builder.define("enabled", true);
            secretMessages = builder.define("secretMessages", true);

            messages = builder.defineList(
                    "messages",
                    List.of(
                            "Baa!",
                            "Hello!",
                            "I hate pistons",
                            "Thanks Kaupen",
                            "I am sheep",
                            "You will live an unfulfilled life only if you let it be",
                            "I'm on the lam",
                            "Im above the law",
                            "My biggest opp is the pink one",
                            "...",
                            "Come Nerevar come",
                            "Txni Check your github",
                            "HE NEED SOME MILK",
                            "Dropkick Dungeons",
                            "The only more insufferable thing I've met besides you is that damned orange cat",
                            "Im Goobing out RN",
                            "-_-",
                            "Sub 8ft. Beta males really out here talking smack about me when theyre really the vertically challenged one",
                            "Jackpot!!",
                            "Player trust me, all i need is an apple and your arm to gain the Ultimate power",
                            "The McRib is FINALLY BACK",
                            "It's been 3 DAYS dawg",
                            "Player please help me confess my feelings to the Ender Dragon.",
                            "192.48.173.62, this you? No???? Whose IP is this then????",
                            ""

                    ),
                    obj -> obj instanceof String
            );

            entityTypes = builder.defineList(
                    "entityTypes",
                    List.of("minecraft:sheep"),
                    obj -> obj instanceof String
            );

            builder.pop();
        }
    }
}