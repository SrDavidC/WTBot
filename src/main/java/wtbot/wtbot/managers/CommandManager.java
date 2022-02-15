package wtbot.wtbot.managers;

import co.aikar.commands.PaperCommandManager;
import wtbot.wtbot.WTBot;
import wtbot.wtbot.commands.DetectDeaths;
import wtbot.wtbot.commands.Respawn;
import wtbot.wtbot.commands.Revivir;
import wtbot.wtbot.commands.Test;

public class CommandManager {
    PaperCommandManager commandManager;
    public CommandManager() {
        this.commandManager = new PaperCommandManager(WTBot.getPl());
        commandManager.registerCommand(new Respawn());
        commandManager.registerCommand(new DetectDeaths());
        commandManager.registerCommand(new Revivir());
        commandManager.registerCommand(new Test());

    }

}
