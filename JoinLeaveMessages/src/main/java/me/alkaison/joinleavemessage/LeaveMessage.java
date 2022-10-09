package me.alkaison.joinleavemessage;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveMessage implements Listener {

    JoinLeaveMessage plugin = JoinLeaveMessage.getPlugin(JoinLeaveMessage.class);

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        //triggers when a player leaves the server.
        Player player = e.getPlayer();
        String leaveMessage = plugin.getConfig().getString("leave-message");
        e.setQuitMessage(ChatColor.AQUA + " " + player.getDisplayName() + " " + ChatColor.GREEN + "" + leaveMessage);
    }

}
