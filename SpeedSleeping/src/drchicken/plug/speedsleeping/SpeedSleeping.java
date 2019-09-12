package drchicken.plug.speedsleeping;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpeedSleeping extends JavaPlugin {

    private int percent = 50;
    private int playerOnBed = 0;
    private boolean enable = true;

    @Override
    public void onEnable() {
        System.out.println("SpeedSleeping: Enable...");
        Bukkit.getPluginManager().registerEvents(new Sleep(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println("SpeedSleeping: Disable...");
    }

    public void removeOnePlayerBed() {
        if(this.playerOnBed > 0)
            this.playerOnBed -= 1;
    }

    public void addOnePlayerBed(String name) {
        playerOnBed += 1;

        for(Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(ChatColor.GOLD + name + ChatColor.YELLOW + " is sleeping");
            player.sendMessage(ChatColor.GOLD + Integer.toString(playerOnBed) + ChatColor.YELLOW + " / "
                    + ChatColor.GOLD + Bukkit.getOnlinePlayers().size() + ChatColor.YELLOW + " Players was sleeping.");
        }

        if(enable) {
            if((float)(playerOnBed)/ (float)Bukkit.getOnlinePlayers().size() >= (float)(percent/100.0)) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                    public void run() {
                        Bukkit.getServer().getWorlds().get(0).setTime(0);
                    }
                }, (50));
                playerOnBed = 0;
            }
        }
    }

}
