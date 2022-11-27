package com.foxdev.flyability.Listener;

import com.foxdev.flyability.FlyAbility;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;



public class Fly implements Listener {


    int count = 10;
    private FlyAbility main;

    public Fly(FlyAbility main) {
        this.main = main;
    }





    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        ItemStack item = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);


        if (p.getInventory().getItemInMainHand().getType().equals(item)) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR) {
                p.sendMessage("Fly is aangezet voor minder dan 10 seconden");
                p.getInventory().getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount()-1);
                p.setAllowFlight(true);

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(FlyAbility.Instance, new Runnable() {
                    @Override
                    public void run() {
                        if (count == 10) {
                        }
                        p.sendMessage("Fly is gestopt!");
                        p.setAllowFlight(false);
                        count--;
                    }

                }, 100);

            }
        }
    }
}
