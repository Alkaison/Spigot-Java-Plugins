package me.alkaison.linecommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

public class feed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player)
        {
            Player p = (Player) sender;
            if(p.getFoodLevel() == 20)
            {
                p.sendMessage(ChatColor.YELLOW + "Your stomach is full.");
            }
            else
            {
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.GREEN + "You are now ready to Goo!");
            }
        } else if (sender instanceof ConsoleCommandSender) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "The command can only be run by a player while being in-game.");
        } else if (sender instanceof BlockCommandSender) {
            Bukkit.getServer().getLogger().warning("The command can only be run by a player while being in-game.");
        }



        return  true;
    }
}
