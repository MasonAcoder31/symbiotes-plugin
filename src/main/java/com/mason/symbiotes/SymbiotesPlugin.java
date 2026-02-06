package com.mason.symbiotes;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import com.mason.symbiotes.commands.SymbioteCommand;
import com.mason.symbiotes.listeners.PlayerListener;
import com.mason.symbiotes.listeners.CombatListener;
import com.mason.symbiotes.listeners.HungerListener;
import com.mason.symbiotes.listeners.MovementListener;
import com.mason.symbiotes.listeners.BlockListener;

public class SymbiotesPlugin extends JavaPlugin {
    private SymbioteManager symbioteManager;
    private SkillTreeManager skillTreeManager;
    private TransformationManager transformationManager;

    @Override
    public void onEnable() {
        getLogger().info("Symbiotes plugin enabled!");
        symbioteManager = new SymbioteManager(this);
        skillTreeManager = new SkillTreeManager(this);
        transformationManager = new TransformationManager(this);

        getCommand("symbiote").setExecutor(new SymbioteCommand(symbioteManager, skillTreeManager, transformationManager));
        getServer().getPluginManager().registerEvents(new PlayerListener(symbioteManager, skillTreeManager, transformationManager), this);
        getServer().getPluginManager().registerEvents(new CombatListener(symbioteManager, skillTreeManager, transformationManager), this);
        getServer().getPluginManager().registerEvents(new HungerListener(symbioteManager), this);
        getServer().getPluginManager().registerEvents(new MovementListener(symbioteManager, skillTreeManager), this);
        getServer().getPluginManager().registerEvents(new BlockListener(symbioteManager), this);

        new BukkitRunnable() {
            @Override
            public void run() {
                symbioteManager.tickHunger();
            }
        }.runTaskTimer(this, 0, 20);

        new BukkitRunnable() {
            @Override
            public void run() {
                symbioteManager.tickAbilities();
            }
        }.runTaskTimer(this, 0, 10);

        new BukkitRunnable() {
            @Override
            public void run() {
                symbioteManager.tickPassiveEffects();
            }
        }.runTaskTimer(this, 0, 5);

        new BukkitRunnable() {
            @Override
            public void run() {
                symbioteManager.tickRegeneration();
            }
        }.runTaskTimer(this, 0, 40);

        new BukkitRunnable() {
            @Override
            public void run() {
                skillTreeManager.tickPassiveSkills();
            }
        }.runTaskTimer(this, 0, 10);

        new BukkitRunnable() {
            @Override
            public void run() {
                transformationManager.tickTransformations();
            }
        }.runTaskTimer(this, 0, 5);

        getLogger().info("Symbiotes plugin successfully initialized!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Symbiotes plugin disabled!");
    }

    public SymbioteManager getSymbioteManager() {
        return symbioteManager;
    }

    public SkillTreeManager getSkillTreeManager() {
        return skillTreeManager;
    }

    public TransformationManager getTransformationManager() {
        return transformationManager;
    }
}