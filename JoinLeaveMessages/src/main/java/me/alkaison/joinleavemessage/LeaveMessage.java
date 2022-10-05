package me.alkaison.joinleavemessage;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveMessage implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        //triggers when a player leaves the server.
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.AQUA + "" + player.getDisplayName() + "" + ChatColor.GREEN + " come back again please");
    }

}
