package me.alkaison.linecommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class god implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(p.hasPermission("lc.god"))
            {
                if (p.isInvulnerable()) {
                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.RED + "God Mode has been disabled.");
                } else {
                    p.setInvulnerable(true);
                    p.sendMessage(ChatColor.GREEN + "God Mode has been enabled.");
                }
            }
            else
            {
                p.sendMessage(ChatColor.YELLOW + "You don't have the required permission (" + ChatColor.RED + "lc.god" + ChatColor.YELLOW + ").");
            }

        } else if (sender instanceof ConsoleCommandSender) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "The command can only be run by a player while being in-game.");
        } else if (sender instanceof BlockCommandSender) {
            Bukkit.getServer().getLogger().warning("The command can only be run by a player while being in-game.");
        }

        return true;
    }
}
