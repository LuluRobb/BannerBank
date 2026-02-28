package de.lulurobb.bannerbank.util;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;

public class Util {

    public static Boolean hasInvSpace(Player p) {
        Boolean hasFree = false;
        for (Integer i = 0; i < p.getInventory().getSize(); i++) {
            if(p.getInventory().getItem(i) != null) {
                hasFree = true;
            }
        }
        return hasFree;
    }

    public static Inventory setOutline(Inventory gui, ItemStack item) {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, item);
        }
        switch (gui.getSize()/9) {
            case 6:
                gui.setItem(36, item);
                gui.setItem(44, item);

            case 5:
                gui.setItem(27, item);
                gui.setItem(35, item);

            case 4:
                gui.setItem(18, item);
                gui.setItem(26, item);

            case 3:
                gui.setItem(9, item);
                gui.setItem(17, item);
        }

        switch (gui.getSize()/9) {
            case 3:
                for (int i = 18; i < 27; i++) {
                    gui.setItem(i, item);
                }
                break;

            case 4:
                for (int i = 27; i < 36; i++) {
                    gui.setItem(i, item);
                }
                break;

            case 5:
                for (int i = 36; i < 45; i++) {
                    gui.setItem(i, item);
                }
                break;

            case 6:
                for (int i = 45; i < 54; i++) {
                    gui.setItem(i, item);
                }
                break;
        }

        return gui;
    }

    public static Player getPlayer(String string) {
        Player p = null;
        for (Player all : Bukkit.getOnlinePlayers()) {
            if(string.contains(all.getName())) {
                p = all;
            }
        }
        return p;
    }

    public static boolean isBanner(Material material) {
        return material == Material.WHITE_BANNER ||
                material == Material.ORANGE_BANNER ||
                material == Material.MAGENTA_BANNER ||
                material == Material.LIGHT_BLUE_BANNER ||
                material == Material.YELLOW_BANNER ||
                material == Material.LIME_BANNER ||
                material == Material.PINK_BANNER ||
                material == Material.GRAY_BANNER ||
                material == Material.LIGHT_GRAY_BANNER ||
                material == Material.CYAN_BANNER ||
                material == Material.PURPLE_BANNER ||
                material == Material.BLUE_BANNER ||
                material == Material.BROWN_BANNER ||
                material == Material.GREEN_BANNER ||
                material == Material.RED_BANNER ||
                material == Material.BLACK_BANNER;
    }

    public static boolean isDye(Material material) {
        return material == Material.WHITE_DYE ||
                material == Material.ORANGE_DYE ||
                material == Material.MAGENTA_DYE ||
                material == Material.LIGHT_BLUE_DYE ||
                material == Material.YELLOW_DYE ||
                material == Material.LIME_DYE ||
                material == Material.PINK_DYE ||
                material == Material.GRAY_DYE ||
                material == Material.LIGHT_GRAY_DYE ||
                material == Material.CYAN_DYE ||
                material == Material.PURPLE_DYE ||
                material == Material.BLUE_DYE ||
                material == Material.BROWN_DYE ||
                material == Material.GREEN_DYE ||
                material == Material.RED_DYE ||
                material == Material.BLACK_DYE;
    }

    public static DyeColor getDyeColorFromBanner(Material banner) {
        if (banner == Material.WHITE_DYE) {
            return DyeColor.WHITE;
        } else if (banner == Material.ORANGE_DYE) {
            return DyeColor.ORANGE;
        } else if (banner == Material.MAGENTA_DYE) {
            return DyeColor.MAGENTA;
        } else if (banner == Material.LIGHT_BLUE_DYE) {
            return DyeColor.LIGHT_BLUE;
        } else if (banner == Material.YELLOW_DYE) {
            return DyeColor.YELLOW;
        } else if (banner == Material.LIME_DYE) {
            return DyeColor.LIME;
        } else if (banner == Material.PINK_DYE) {
            return DyeColor.PINK;
        } else if (banner == Material.GRAY_DYE) {
            return DyeColor.GRAY;
        } else if (banner == Material.LIGHT_GRAY_DYE) {
            return DyeColor.LIGHT_GRAY;
        } else if (banner == Material.CYAN_DYE) {
            return DyeColor.CYAN;
        } else if (banner == Material.PURPLE_DYE) {
            return DyeColor.PURPLE;
        } else if (banner == Material.BLUE_DYE) {
            return DyeColor.BLUE;
        } else if (banner == Material.BROWN_DYE) {
            return DyeColor.BROWN;
        } else if (banner == Material.GREEN_DYE) {
            return DyeColor.GREEN;
        } else if (banner == Material.RED_DYE) {
            return DyeColor.RED;
        } else if (banner == Material.BLACK_DYE) {
            return DyeColor.BLACK;
        }

        return null;
    }

    public static Integer getLowestFreeInt(ArrayList<Integer> numbers) {
        Collections.sort(numbers);

        int smallestMissingInt = 1;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == smallestMissingInt) {
                smallestMissingInt++;
            } else if (numbers.get(i) > smallestMissingInt) {
                break;
            }
        }

        return smallestMissingInt;
    }



}
