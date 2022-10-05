package me.alkaison.joinleavemessage;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        //triggers when a player joins the server.
        Player player = e.getPlayer();
        if (player.hasPlayedBefore())
        {
            e.setJoinMessage(ChatColor.AQUA + "" + player.getDisplayName() + "" + ChatColor.GREEN + " welcome to the server!");
        }
        else
        {
            e.setJoinMessage(ChatColor.AQUA + "" + player.getDisplayName() + "" + ChatColor.GREEN + " has joined the server for first time, give him a warm welcome.");
        }
    }
}
