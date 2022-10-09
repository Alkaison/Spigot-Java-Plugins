package me.alkaison.joinleavemessage;

import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {

    JoinLeaveMessage plugin = JoinLeaveMessage.getPlugin(JoinLeaveMessage.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        // triggers when a player joins the server.
        if (player.hasPlayedBefore())
        {
            String joinMessage = plugin.getConfig().getString("join-message");
            e.setJoinMessage(ChatColor.AQUA + " " + player.getDisplayName() + " " + ChatColor.GREEN + "" + joinMessage);
        }
        // triggers when player joins first time
        else
        {
            String firstMessage = plugin.getConfig().getString("first-time-join-message");
            e.setJoinMessage(ChatColor.AQUA + " " + player.getDisplayName() + " " + ChatColor.GREEN + "" + firstMessage);
        }
    }
}
