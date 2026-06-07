package net.minecraft.command;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.Collections;
import java.util.List;

public class CommandHome extends CommandBase {

    @Override
    public String getCommandName() {
        return "home";  // 命令名称：/home
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;  // 0 = 所有玩家都能用（不需要 OP）
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/home - 传送到你的家";
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("h");  // 别名：/h 也能触发
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        // 确保是玩家执行的命令（不是控制台）
        EntityPlayerMP player = getCommandSenderAsPlayer(sender);
        
        // 简化版：传送到固定坐标 (0, 64, 0)
        // 进阶版：可以用 NBT 或配置文件存储每个玩家的家坐标
        double x = 0;
        double y = 64;
        double z = 0;
        
        // 传送玩家
        player.setPositionAndUpdate(x, y, z);
        
        // 发送提示消息
        player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "已传送到你的家！"));
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        // 没有参数需要补全，返回空
        return Collections.emptyList();
    }
}
