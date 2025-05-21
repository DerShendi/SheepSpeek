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
                            "Sub 8ft. Beta males really think they can take out a Sigma",
                            "Jackpot!!",
                            "Player trust me, all i need is an apple and your arm to gain the Ultimate power",
                            "The McRib is FINALLY BACK",
                            "It's been 3 DAYS dawg",
                            "Player please help me confess my feelings to the Ender Dragon.",
                            "192.48.173.62, this you? No???? Whose IP is this then????",
                            "Come, Player, friend or traitor, come. I have a question of the utmost importance. Are you familiar at all with VTubers? They are basically regular YouTubers, but they use a virtual avatar, and it's normally an anime character. There's this one called Shy Lily. She's probably the cutest human being on the planet. She does this thing where she will just say, Womp Womp, over and over again, and Player, I don't know how to say this, but I simp for Shy Lily. The Womp Womp really plays at my heartstrings. No other Sheep has ever felt this way, Player. I've donated over 80% of the Villages emeralds and 100% of my own to have her just read out my message to her. I've spent millions to have her acknowledge me, but for whatever reason, every time my donation comes up on screen, she either misses it or gets up to use the bathroom or pick up her food delivery or whatever. She hasn't read a single one of my messages. Come again, Player. What are the messages? Nothing that would dishonor the Village or the other Sheep unwarned, I can assure you. I just ask her when we are going to get married, when she is coming over to see the respawn of Ender Dragon, what her address is, and send links to photos of myself. Sometimes I ask her to describe what armor she's wearing. You know, normal stuff like that. But it's okay, Player. She is so cute. Once we are married, I will forgive her. I can see it now. The pews lined up facing the Plains right in front of the forest. It will be perfect, Player. Womp, womp, womp, womp, womp, womp, womp, womp...",
                            "Hello farm equipment",
                            "This better be sheepishly urgent",
                            "Huhuhuhu, nice place Player",
                            "Chat is this guy serious",
                            "Chat is this real",
                            "Chat what the sigma",
                            "So this is what qualifies as a base these days? Why dont we go to a Savannah and ask an Armadillo if they'd like to be the president",
                            "My tinder date is gonna be in for a hell of a catfish hehehehe",
                            "Even a devil may cry",
                            "Somethings sobeautiful of the rain. Somber. Reminds me of the old days. Back when Mojang didnt suck eggs",
                            "Look at that pile of rocks and wood, all just put together without a forethought or propper planning. Go figure this is just your base",
                            "Not right now, Im overstimulated",
                            "Say hello to the death screen for me Player",
                            "Fine. I didnt want to be sheared by you anyway, Baka",
                            "Hello there, Temu Builder",
                            "Im about to send you back to the Serverlist screen",
                            "5 Big booms for this fella",
                            "How will this affect LeBron's Legacy?",
                            "Player, when did you last bathe? Your stench is hitting me downwind",
                            "Player, do you have another bed for me so I can sleep? No! Can i be little spoon then?",
                            "An excuse me would have worked just as well",
                            "Once i gazed uppon the EnderDragon I knew that being gay was an uphill battle",
                            "Are you enjoying this world so far Player? I know I am",
                            "I just drained this opps entire EXP ammount and i couldnt even enchant at lvl 1. Yall Opps are Lame asf",
                            "Whattup my Hoonding",
                            "A quest as old as time, Sheep and Player back at it again. Boy do I love sequels",
                            "That was easier to win than a fight against an Armadillo child, take my word for it.",
                            "I cant lie Player, we need to Lock tf IN right now",
                            "Player please enchant my stuff with Armadillo EXP. I need them to know that I still hate them",
                            "You know that sleeping inst instant for me?? I have to wait here outside in the rain.",
                            "Goodbye gamer back to the lobby",
                            "Bro is saving his E Gapps for the next world.",
                            "This gamer clearly doesnt own an Air fryer",
                            "Player I think I caught Ligma, did you hear me Player? Player I said I think i caught Ligma. Player arent you gonna ask me what Ligma is? Please Player, please I need this win.",
                            "[SNEAK 100]",
                            "Gamers be like 'Whats the move for tonight?'. Brother, we are in a Savanna. THERE IS NO MOVE",
                            "What the dog doin?",
                            "This place sucks. I preffer the Pink Pony club",
                            "If you hand me anything heavy I will toss it and gaslight you about ever giving it to me",
                            "Linganguliguliguliguacha Lingangu Lingangu Linganguliguliguliguacha Lingangu Lingangu Linganguliguliguliguacha Lingangu Lingangu Linganguliguliguliguacha Lingangu Lingangu",
                            "Best things to do in a Savanna. Nr.1 Leave, Nr.2 Die"

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