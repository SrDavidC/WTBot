package wtbot.wtbot.discord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import wtbot.wtbot.files.WTFiles;
import wtbot.wtbot.utils.Utils;

import java.awt.*;
import java.io.*;

public class Commands extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getAuthor().isBot())
            return;
        Message msg = e.getMessage();
        String[] args = msg.getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase("!vivos")){
            String m = getPlayersType("jugadores.txt", WTFiles.rutaCarpeta, "ALIVE");
            System.out.println("Command detected");

           EmbedBuilder bd =  this.buildEmbedd("\u2728 VIVOS \u2728",new Color(242,240,121),"\ud83c\udf1f Por favor no mueran",null, Utils.serverImage,m, "" );
            e.getTextChannel().sendMessageEmbeds(bd.build()).queue();
        }
        else if(args[0].equalsIgnoreCase("!muertos")){
            String m =getPlayersType("jugadores.txt", WTFiles.rutaCarpeta, "DEAD");
            System.out.println("Command detected");
            EmbedBuilder bd =  this.buildEmbedd("\ud83d\udc80 Muertos \ud83d\udc80",new Color(147,40,166),"\ud83d\udc80 Por favor no mueran \ud83d\udc80",null, Utils.serverImage,m, "" );
            e.getTextChannel().sendMessageEmbeds(bd.build()).queue();
        }
    }

    public String getPlayersType(String name,String path, String state){
        File file = new File(path+name);
        StringBuilder message = new StringBuilder();
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String line = input.readLine();
            int i = 1;
            while(line != null){
                String[] split = line.split(",");
                if (split.length > 1){
                    if (split[1].equalsIgnoreCase(state)){
                        message.append("**").append(i++).append(".-** ").append(split[0]).append("\n");
                    }
                }
                line = input.readLine();
            }
            input.close();
            if (message.toString().equalsIgnoreCase(""))
                return "Todos han muerto.";
            else
                return message.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "null ";
    }
    public static EmbedBuilder buildEmbedd(final String title, final Color color, final String footer, final String image, final String thumbnail, final String... description) {
        final EmbedBuilder eb = new EmbedBuilder();
        if (title != null) {
            eb.setTitle(title);
        }
        if (color != null) {
            eb.setColor(color);
        }
        if (footer != null) {
            eb.setFooter(footer);
        }
        if (image != null) {
            eb.setImage(image);
        }
        if (thumbnail != null) {
            eb.setThumbnail(thumbnail);
        }
        for (final String s : description) {
            eb.addField("", s, false);
        }
        return eb;
    }

}
