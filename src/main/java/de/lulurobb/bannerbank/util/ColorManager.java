package de.lulurobb.bannerbank.util;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorManager {

    public static DyeColor getDyeColor(String input) {
        switch (input.toLowerCase()) {
            case "black":
                return DyeColor.BLACK;
            case "blue":
                return DyeColor.BLUE;
            case "brown":
                return DyeColor.BROWN;
            case "cyan":
                return DyeColor.CYAN;
            case "gray":
                return DyeColor.GRAY;
            case "green":
                return DyeColor.GREEN;
            case "light_blue":
                return DyeColor.LIGHT_BLUE;
            case "lime":
                return DyeColor.LIME;
            case "magenta":
                return DyeColor.MAGENTA;
            case "orange":
                return DyeColor.ORANGE;
            case "pink":
                return DyeColor.PINK;
            case "purple":
                return DyeColor.PURPLE;
            case "red":
                return DyeColor.RED;
            case "silver":
                return DyeColor.LIGHT_GRAY;
            case "yellow":
                return DyeColor.YELLOW;
            default:
                return DyeColor.WHITE;

        }
    }

    public static String getByDyeColor(DyeColor color) {
        switch (color) {
            case BLACK:
                return "<black>";
            case BLUE:
                return "<dark_blue>";
            case BROWN:
                return "<gold>";
            case CYAN:
                return "<dark_aqua>";
            case GRAY:
                return "<dark_gray>";
            case GREEN:
                return "<dark_green>";
            case LIGHT_BLUE:
                return "<aqua>";
            case LIME:
                return "<green>";
            case MAGENTA:
                return "<light_purple>";
            case ORANGE:
                return "<gold>";
            case PINK:
                return "<light_purple>";
            case PURPLE:
                return "<dark_purple>";
            case RED:
                return "<red>";
            case LIGHT_GRAY:
                return "<gray>";
            case YELLOW:
                return "<yellow>";
            default:
                return "<white>";

        }
    }

    public static Material getDyeByDye(DyeColor color) {
        return Material.valueOf(color.toString().toUpperCase() + "_DYE");
    }

    public static ArrayList<DyeColor> getAll() {
        ArrayList<DyeColor> colors = new ArrayList<>();
        for (DyeColor color : DyeColor.values()) {
            colors.add(color);
        }
        return colors;
    }

}
