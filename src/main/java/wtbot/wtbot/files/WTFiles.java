package wtbot.wtbot.files;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import wtbot.wtbot.WTBot;
import wtbot.wtbot.utils.PlayerData;
import wtbot.wtbot.utils.PlayerUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class WTFiles {
    FileManager fm;
    public static String rutaCarpeta = "WTBotData/";
    PlayerUtils pu = WTBot.getPl().getPu();
    public File file = new File(rutaCarpeta + "jugadores.txt");
    public static File fileS = new File(rutaCarpeta + "jugadores.txt");

    public WTFiles() {
        String content = "";
        String nameFile = "jugadores.txt";
        this.fm = new FileManager();
        fm.mkDirectory(rutaCarpeta);
        fm.mkFile(nameFile, rutaCarpeta);
        for (Map.Entry me : pu.jugadores.entrySet()) {
            PlayerData pd = (PlayerData) me.getValue();
            content += me.getKey() + "," + pd.getState() + "\n";
        }
        if (!this.file.exists())
            fm.writeOnFile(rutaCarpeta, nameFile, content);
    }

    public static void chngState(String player, String state, int index) {
        if (index == -1)
            return;
        List<String> lines;
        try {
            lines = Files.readAllLines(fileS.toPath());
            lines.set(index, player.toUpperCase(Locale.ROOT) + ","+state);
            Files.write(fileS.toPath(), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void makeWhitelist(){
        List<String> lines;
        try {
            lines = Files.readAllLines(fileS.toPath());
            for(String line: lines){
                String[] split = line.split(",");
                Player p = Bukkit.getPlayer(split[0]);
                p.setWhitelisted(true);
                System.out.println(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int searchPlayer(String player) {
        String line;
        int i = -1;
        String[] split;
        boolean encontrado = false;
        if (fileS.exists()) {
            BufferedReader input = null;
            try {
                input = new BufferedReader(new FileReader(fileS));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                line = input.readLine();
                while (line != null && !encontrado){
                    split = line.split(",");
                    i++;
                    if (split[0].equalsIgnoreCase(player)){
                        encontrado = true;
                    }
                    line = input.readLine();
                }
                input.close();
                if (!encontrado)
                    return -1;
                return i;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

}
