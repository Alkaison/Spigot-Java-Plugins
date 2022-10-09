package me.alkaison.joinleavemessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinLeaveMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        // getting config.yml files inside
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // registering player join & leave messages
        getServer().getPluginManager().registerEvents(new JoinMessage(), this);
        getServer().getPluginManager().registerEvents(new LeaveMessage(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // command for checking the messages from config.yml
        if(command.getName().equalsIgnoreCase("debug"))
        {
            if(sender instanceof Player)
            {
                Player p = (Player) sender;
                if(p.hasPermission("jlm.debug"))
                {
                    p.sendMessage(ChatColor.GREEN + "<<------------------------------------------------->>");
                    p.sendMessage(ChatColor.GOLD + "Join Message: " + ChatColor.AQUA + "" + p.getDisplayName() + " " + ChatColor.GREEN + "" + getConfig().getString("join-message"));
                    p.sendMessage(ChatColor.GOLD + "Leave Message: " + ChatColor.AQUA + "" + p.getDisplayName() + " " + ChatColor.GREEN + "" + getConfig().getString("leave-message"));
                    p.sendMessage(ChatColor.GOLD + "First Time Join Message: " + ChatColor.AQUA + "" + p.getDisplayName() + " " + ChatColor.GREEN + "" + getConfig().getString("first-time-join-message"));
                    p.sendMessage(ChatColor.GREEN + "<<------------------------------------------------->>");
                }
                else
                {
                    p.sendMessage(ChatColor.YELLOW + "You don't have the required permission (" + ChatColor.RED + "jlm.debug" + ChatColor.YELLOW + ").");
                }
            } else if (sender instanceof ConsoleCommandSender)
            {
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "The command can only be run by a player while being in-game.");
            }
            else if (sender instanceof BlockCommandSender)
            {
                Bukkit.getServer().getLogger().warning("The command can only be run by a player while being in-game.");
            }
        }


        return true;
    }
}
