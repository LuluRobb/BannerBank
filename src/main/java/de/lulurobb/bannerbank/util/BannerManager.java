package de.lulurobb.bannerbank.util;

import de.lulurobb.bannerbank.Main;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;

public class BannerManager {

    public static ItemStack getBanner(DyeColor background, DyeColor font, Letter letter) {
        ItemStack banner = getEmtyBanner(background);
        BannerMeta meta = (BannerMeta) banner.getItemMeta();
        switch (letter) {
            case A:
                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_MIDDLE));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_TOP));
                break;

            case D:
                banner.setType(getEmtyBanner(font).getType());
                meta.addPattern(new Pattern(background, PatternType.TRIANGLES_BOTTOM));
                meta.addPattern(new Pattern(background, PatternType.TRIANGLES_TOP));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_CENTER));
                //meta.addPattern(new Pattern(background, PatternType.CIRCLE_MIDDLE));
                //meta.addPattern(new Pattern(background, Registry.BANNER_PATTERN.get(NamespacedKey.minecraft("circle"))));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));

                break;

            case B:
                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_BOTTOM));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_TOP));
                meta.addPattern(new Pattern(background, PatternType.CURLY_BORDER));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_MIDDLE));

                break;

            case C:
                meta.addPattern(new Pattern(font, PatternType.STRIPE_TOP));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_BOTTOM));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));
                meta.addPattern(new Pattern(background, PatternType.STRIPE_MIDDLE));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                break;

            case E:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_TOP));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_MIDDLE));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_BOTTOM));

                break;

            case F:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_MIDDLE));
                meta.addPattern(new Pattern(background, PatternType.STRIPE_RIGHT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_TOP));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));

                break;

            case G:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));
                meta.addPattern(new Pattern(background, PatternType.HALF_HORIZONTAL));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_BOTTOM));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_TOP));

                break;

            case H:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_MIDDLE));

                break;

            case I:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_CENTER));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_TOP));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_BOTTOM));

                break;

            case J:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(background, PatternType.HALF_HORIZONTAL));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_BOTTOM));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));

                break;

            case K:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_DOWNRIGHT));
                meta.addPattern(new Pattern(background, PatternType.HALF_HORIZONTAL));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_DOWNLEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));

                break;

            case L:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_BOTTOM));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));

                break;

            case M:

                meta.addPattern(new Pattern(font, PatternType.TRIANGLE_TOP));
                meta.addPattern(new Pattern(background, PatternType.TRIANGLES_TOP));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));

                break;

            case N:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(background, PatternType.TRIANGLE_TOP));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_DOWNRIGHT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));

                break;

            case O:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_TOP));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_BOTTOM));

                break;

            case P:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));
                //meta.addPattern(new Pattern(background, PatternType.HALF_HORIZONTAL_MIRROR));
                //meta.addPattern(new Pattern(background, Registry.BANNER_PATTERN.get(NamespacedKey.minecraft("half_horizontal_mirrored"))));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_MIDDLE));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_TOP));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));

                break;

            case Q:

                banner.setType(getEmtyBanner(font).getType());
                //meta.addPattern(new Pattern(background, PatternType.RHOMBUS_MIDDLE));
                //meta.addPattern(new Pattern(background, Registry.BANNER_PATTERN.get(NamespacedKey.minecraft("rhombus"))));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));
                meta.addPattern(new Pattern(font, PatternType.SQUARE_BOTTOM_RIGHT));

                break;

            case R:
                meta.addPattern(new Pattern(font, PatternType.HALF_HORIZONTAL));
                meta.addPattern(new Pattern(background, PatternType.STRIPE_CENTER));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_TOP));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_DOWNRIGHT));

                break;

            case S:

                banner.setType(getEmtyBanner(font).getType());
                //meta.addPattern(new Pattern(background, PatternType.RHOMBUS_MIDDLE));
                //meta.addPattern(new Pattern(background, Registry.BANNER_PATTERN.get(NamespacedKey.minecraft("rhombus"))));
                meta.addPattern(new Pattern(background, PatternType.STRIPE_MIDDLE));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_DOWNRIGHT));

                break;

            case T:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_TOP));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_CENTER));

                break;

            case U:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_BOTTOM));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));

                break;

            case V:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_DOWNLEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(background, PatternType.TRIANGLE_BOTTOM));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_DOWNLEFT));

                break;

            case W:

                meta.addPattern(new Pattern(font, PatternType.TRIANGLE_BOTTOM));
                meta.addPattern(new Pattern(background, PatternType.TRIANGLES_BOTTOM));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_LEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_RIGHT));

                break;

            case X:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_DOWNRIGHT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_DOWNLEFT));

                break;

            case Y:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_DOWNRIGHT));
                //meta.addPattern(new Pattern(background, PatternType.HALF_HORIZONTAL_MIRROR));
                //meta.addPattern(new Pattern(background, Registry.BANNER_PATTERN.get(NamespacedKey.minecraft("half_horizontal_mirrored"))));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_DOWNLEFT));

                break;

            case Z:

                meta.addPattern(new Pattern(font, PatternType.STRIPE_TOP));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_DOWNLEFT));
                meta.addPattern(new Pattern(font, PatternType.STRIPE_BOTTOM));

                break;

            case Underline:
                meta.addPattern(new Pattern(font, PatternType.STRIPE_BOTTOM));

                break;

        }

        meta.addPattern(new Pattern(background, PatternType.BORDER));
        banner.setItemMeta(meta);

        return banner;
    }

    public static ItemStack getEmtyBanner(DyeColor background) {
        ItemStack itemStack = new ItemStack(Material.valueOf(background.name().toUpperCase() + "_BANNER"));
        if(itemStack != null) {
            return itemStack;
        } else
            return new ItemStack(Material.WHITE_BANNER);
    }

    public static ArrayList<Letter> getAllLetters() {
        ArrayList<Letter> letters = new ArrayList<>();
        for (Letter letter : Letter.values()) {
            letters.add(letter);
        }
        return letters;
    }

    public static ArrayList<String> getAlpherbet() {
        ArrayList<String> alphabet = new ArrayList<>();
        alphabet.add("A");
        alphabet.add("B");
        alphabet.add("C");
        alphabet.add("D");
        alphabet.add("E");
        alphabet.add("F");
        alphabet.add("G");
        alphabet.add("H");
        alphabet.add("I");
        alphabet.add("J");
        alphabet.add("K");
        alphabet.add("L");
        alphabet.add("M");
        alphabet.add("N");
        alphabet.add("O");
        alphabet.add("P");
        alphabet.add("Q");
        alphabet.add("R");
        alphabet.add("S");
        alphabet.add("T");
        alphabet.add("U");
        alphabet.add("V");
        alphabet.add("W");
        alphabet.add("X");
        alphabet.add("Y");
        alphabet.add("Z");
        alphabet.add("Underline");

        return alphabet;
    }

}
