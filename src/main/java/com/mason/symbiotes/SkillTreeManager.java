package com.mason.symbiotes;

import java.util.*;

public class SkillTreeManager {
    private Map<String, Integer> skills;
    private int transformationLevel;

    public SkillTreeManager() {
        this.skills = new HashMap<>();
        this.transformationLevel = 1;
        initializeSkills();
    }

    private void initializeSkills() {
        String[] venomSkills = { "Web Mastery", "Venom Strike", "Toxic Fangs", "Web Shield", "Shadow Clones", "Venom Aura", "Paralyzing Venom", "Web Fortress", "Dark Reflection", "Spider Sense", "Venom Burst", "Web Cocoon", "Lethal Injection", "Venom Pooling", "Shadow Merge", "Arachnid Form", "Venom Evolution", "Web Dimension", "Death From Above", "Absolute Venom" };
        for (String skill : venomSkills) {
            skills.put(skill, 0);
        }
    }

    public void levelUpSkill(String skillName) {
        if (skills.containsKey(skillName)) {
            int currentLevel = skills.get(skillName);
            if (currentLevel < 5) {
                skills.put(skillName, currentLevel + 1);
                System.out.println(skillName + " leveled up to " + (currentLevel + 1));
            } else {
                System.out.println(skillName + " is already at max level!");
            }
        } else {
            System.out.println("Skill not found: " + skillName);
        }
    }

    public void upgradeTransformation() {
        if (transformationLevel < 5) {
            transformationLevel++;
            System.out.println("Transformation upgraded to level " + transformationLevel);
        } else {
            System.out.println("Transformation is already at max level!");
        }
    }

    public int getSkillLevel(String skillName) {
        return skills.getOrDefault(skillName, 0);
    }

    public int getTransformationLevel() {
        return transformationLevel;
    }

    public Map<String, Integer> getAllSkills() {
        return new HashMap<>(skills);
    }

    public void displaySkillTree() {
        System.out.println("=== Skill Tree ===");
        System.out.println("Transformation Level: " + transformationLevel + "/5");
        System.out.println("\nSkills:");
        for (String skill : skills.keySet()) {
            int level = skills.get(skill);
            String levelBar = "";
            for (int i = 0; i < 5; i++) {
                levelBar += (i < level) ? "█" : "░";
            }
            System.out.println(skill + " " + levelBar + " (Lvl " + level + ")");
        }
    }
}