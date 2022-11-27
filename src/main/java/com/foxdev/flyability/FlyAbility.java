package com.foxdev.flyability;

import com.foxdev.flyability.Listener.Fly;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlyAbility extends JavaPlugin {


    public static FlyAbility Instance;

    @Override
    public void onEnable() {
        Instance = this;
        getServer().getPluginManager().registerEvents(new Fly(this), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
