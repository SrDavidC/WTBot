package wtbot.wtbot;

import fr.mrmicky.fastinv.FastInvManager;
import org.bukkit.plugin.java.JavaPlugin;
import wtbot.wtbot.discord.DiscordManager;
import wtbot.wtbot.files.FileManager;
import wtbot.wtbot.files.WTFiles;
import wtbot.wtbot.listeners.DeathListener;
import wtbot.wtbot.listeners.Listeners;
import wtbot.wtbot.managers.CommandManager;
import wtbot.wtbot.utils.PlayerUtils;

public final class WTBot extends JavaPlugin {
    private static WTBot pl;
    private final String token = "OTI4MzQzMjIyODEwNDY4NDYy.YdXZAA.KHBbw-NzQyo3Kghdg98zZfEiees";
    private PlayerUtils pu;
    private FileManager fm;
    private CommandManager commandManager;
    private boolean detectDeath;
    DiscordManager dm;

    @Override
    public void onEnable() {
        FastInvManager.register(this);
        pl = this;
        this.commandManager = new CommandManager();
        this.getServer().getPluginManager().registerEvents(new DeathListener(), this);
        this.getServer().getPluginManager().registerEvents(new Listeners(),this);
        this.pu = PlayerUtils.getInstance();
        fm = new FileManager();
        WTFiles wt = new WTFiles();
        this.dm =  DiscordManager.getInstance();
        System.out.println("[WitheringSoulsBot] BOT DISCORD ON");
        this.detectDeath = true;
        //CraftingManager cm = new CraftingManager(pl);
    }
    @Override
    public void onDisable() {
        DiscordManager.getInstance().onBotOff();
        System.out.println("[WT BOT] BOT OFF");
    }

    public PlayerUtils getPu() {
        return pu;
    }

    public static WTBot getPl() {
        return pl;
    }

    public String getToken() {
        return token;
    }

    public boolean isDetectDeath() {
        return detectDeath;
    }

    public void setDetectDeath(boolean detectDeath) {
        this.detectDeath = detectDeath;
    }

    public DiscordManager getDm() {
        return dm;
    }

    public void setDm(DiscordManager dm) {
        this.dm = dm;
    }
}
