package me.alkaison.joinleavemessage;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinLeaveMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinMessage(), this);
        getServer().getPluginManager().registerEvents(new LeaveMessage(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
