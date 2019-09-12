package drchicken.plug.speedsleeping;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class Sleep implements Listener {
    private SpeedSleeping plug = null;

    public Sleep(SpeedSleeping p) {
        this.plug = p;
    }

    @EventHandler
    public void onPlayerBedEnterEvent(final PlayerBedEnterEvent player) {
        this.plug.addOnePlayerBed(player.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerBedLeaveEvent(final PlayerBedLeaveEvent player) {
        this.plug.removeOnePlayerBed();
    }
}
