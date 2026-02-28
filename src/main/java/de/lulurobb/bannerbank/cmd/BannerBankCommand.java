package de.lulurobb.bannerbank.cmd;

import de.lulurobb.bannerbank.UIContainer;
import de.lulurobb.bannerbank.services.MessageTranslationConfiguration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BannerBankCommand implements CommandExecutor/*, TabCompleter*/ {

    private MessageTranslationConfiguration msgTranslation;
    public BannerBankCommand(MessageTranslationConfiguration msgTranslation) {
        this.msgTranslation = msgTranslation;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player p)) {
            sender.sendMessage(msgTranslation.getMessage("General.NoConsole").getAsString());
            return false;
        }

        if(!p.hasPermission("bannerbank.open")) {
            p.sendMessage(msgTranslation.getMessage("General.NoPermission").getAsComponent());
            return false;
        }

        new UIContainer(msgTranslation, p).openBannerBank();

        /*
        if(args.length == 0) {
            GUI.openBannerBank(p);
            return true;
        }

        if(args.length == 4) {
            if(args[0].equalsIgnoreCase("get")) {
                if(Main.hasPerm(p, "banner.get")) {
                    DyeColor bckcolor = ColorManager.getDyeColor(args[1]);
                    DyeColor fontcolor = ColorManager.getDyeColor(args[2]);
                    try {
                        Letter letter = Letter.valueOf(args[3].toUpperCase());
                        if(letter != null) {
                            ItemStack banner = BannerManager.getBanner(bckcolor, fontcolor, letter);
                            p.getInventory().addItem(banner);
                            p.sendMessage(Main.PREFIX + "Your get the §e" + letter + "§7 Banner");
                        } else {
                            p.sendMessage(Main.ERROR + "The Char §4" + args[3] + "§c doesnt exist!");
                        }
                    } catch (IllegalArgumentException ex) {
                        p.sendMessage(Main.ERROR + "The Char §4" + args[3] + "§c doesnt exist!");
                    }


                }

            } else sender.sendMessage(Main.USE + label + " get <Background> <Font> <Char>");
        } else sender.sendMessage(Main.USE + label + " get <Background> <Font> <Char>");*/


        return false;
    }

    /*public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> tab = new ArrayList<>();
        if(sender instanceof Player) {
            Player p = (Player) sender;
            switch(args.length) {

                case 1:
                    if(p.hasPermission("banner.get")) {
                        tab.add("get");
                    }
                        break;

                case 2:
                    if(p.hasPermission("banner.create")) {
                        for (DyeColor color : ColorManager.getAll()) {
                            tab.add(color.name());
                        }
                    }
                    break;

                case 3:
                    if(p.hasPermission("banner.create")) {
                        for (DyeColor color : ColorManager.getAll()) {
                            tab.add(color.name());
                        }
                    }
                    break;

                case 4:
                    if(p.hasPermission("banner.create")) {
                        for (Letter letter : BannerManager.getAllLetters()) {
                            tab.add(letter.name());
                        }
                    }
                    break;



            }
        }


        ArrayList<String> completerList = new ArrayList<>();
        String arg = args[args.length-1].toLowerCase();
        for (String s : tab) {
            String s1 = s.toLowerCase();
            if (s1.startsWith(arg)) {
                completerList.add(s);
            }
        }
        return completerList;

    }*/
}
