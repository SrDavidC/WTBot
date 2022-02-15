package wtbot.wtbot.discord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import wtbot.wtbot.WTBot;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.time.LocalDate;

public class DiscordManager {
    public WTBot plugin;
    public JDA jda;
    final private String token = WTBot.getPl().getToken();
    private static DiscordManager discordManager;
    public String serverImage = "https://i.imgur.com/gT9y3FX.jpeg";


    public DiscordManager(){
        this.plugin = WTBot.getPl();
        final JDABuilder builder = JDABuilder.createDefault(token).addEventListeners(new Commands());
        try {
            (this.jda = builder.build()).awaitReady();
        } catch (InterruptedException | LoginException e) {
            e.printStackTrace();
        }
        final TextChannel channel = this.jda.getTextChannelById("925498182920700024");
        EmbedBuilder bd = buildEmbed("WITHERING SOULS", Color.GREEN, null, null, null, ":gear: Plugin encendido.");

        if(channel == null){
            System.out.println("Bot encendido ([!!] Canal de Discord no valido CANAL NO VALIDO CONTACTAR CON @SRDQRK )");
        }
        else {channel.sendMessageEmbeds(bd.build()).queue();}
    }


    public static EmbedBuilder buildEmbed(final String title, final Color color, final String footer, final String image, final String thumbnail, final String... description) {
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
    public void deathAnnounce(String nombre, String razon, String coords, boolean totem, int cantTotem){
        if (this.jda == null){ return; }
        final String serverName = "WITHERING SOULS";
        final LocalDate n = LocalDate.now();
        final String date = String.format("%02d/%02d/%02d", n.getDayOfMonth(), n.getMonthValue(), n.getYear());
        EmbedBuilder b = buildEmbed("\u00A1"+ nombre + " ha MUERTO en " + serverName + "!\n", new Color(138,43,226), null, null, "https://minotar.net/armor/bust/" + nombre + "/100.png", new String[0]);
        TextChannel channel = this.jda.getTextChannelById("928449834665513001");
        if (totem) {
            b = buildEmbed("\u00A1" + nombre + " ha usado un TOTEM! \n", new Color(138, 43, 226), null, null, "https://minotar.net/armor/bust/" + nombre + "/100.png", new String[0]);
            b.addField("\uD83C\uDFB2 N\u00FAmero de totem: #", String.valueOf(cantTotem), true);
            channel = this.jda.getTextChannelById("936028104768495657");
        }
        b.addField("\ud83d\udcc5 Fecha", date, true);
        b.addField("\ud83d\udc80 Raz\u00f3n", razon, true);
        b.addField("\ud83e\udded Coordenadas", coords, true);
        if (channel == null){System.out.println("Ha muerto" + nombre + "EL MENSAJE NO SE PUDO ENVIAR, CANAL NO VALIDO CONTACTAR CON @SRDQRK");}
        else{channel.sendMessageEmbeds(b.build()).queue();}
    }

    public static DiscordManager getInstance() {
        if (DiscordManager.discordManager == null) {
            DiscordManager.discordManager = new DiscordManager();
        }
        return DiscordManager.discordManager;
    }

    public void onBotOff(){
        TextChannel staffChannel = jda.getTextChannelById("925493490203381820");
        EmbedBuilder bd = buildEmbed("WITHERING SOULS LOGS",new Color(138,43,226),null,null,serverImage,"\uD83D\uDEA8 Servidor Apagado", "" );
        if (staffChannel != null){
            staffChannel.sendMessageEmbeds(bd.build()).queue();
        }
    }
}
