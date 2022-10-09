package me.alkaison.linecommands;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class LineCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        // Registering the commands
        Objects.requireNonNull(getCommand("god")).setExecutor(new god());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new heal());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new feed());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
