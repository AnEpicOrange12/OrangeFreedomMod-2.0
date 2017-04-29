package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.EXECUTIVE, source = SourceType.BOTH)
@CommandParameters(description = "Kicks everyone and stops the server.", usage = "/<command>")
public class Command_stop extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        FUtil.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);

        for (Player player : server.getOnlinePlayers())
        {
            player.kickPlayer("OrangeFreedom is going offline. Or we are restarting this server.");
        }

        server.shutdown();

        return true;
    }
}
