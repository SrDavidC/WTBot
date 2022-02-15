package wtbot.wtbot.utils;

import java.util.HashMap;

public class PlayerUtils {
    public HashMap<String, PlayerData> jugadores;
    public static PlayerUtils playerUtils = new PlayerUtils();

    public PlayerUtils() {
        this.jugadores = new HashMap<>();
        jugadores.put("SRDQRK", new PlayerData());
        jugadores.put("ZEKTRUM", new PlayerData());
        jugadores.put("REYIRO", new PlayerData());
        jugadores.put("ZTHIAGOPRRRAHXD", new PlayerData());
        jugadores.put("HIIROF", new PlayerData());
        jugadores.put("DONGATOUNU", new PlayerData());
        jugadores.put("PREYNESS", new PlayerData());
        jugadores.put("ELEGANTO", new PlayerData());
        jugadores.put("AYEEYEL", new PlayerData());
        jugadores.put("ZURIELLARA", new PlayerData());
        jugadores.put("CAPTAINASTERB3", new PlayerData());
        jugadores.put("HIGHESTRUBY5", new PlayerData());
        jugadores.put("MYSTHUS", new PlayerData());
        jugadores.put("IGQMER", new PlayerData());
        jugadores.put("123456789JOSUE", new PlayerData());
        jugadores.put("FATTHZ_", new PlayerData());
        jugadores.put("SPOOKYFEEL", new PlayerData());
        jugadores.put("TRUTSIWO", new PlayerData());
        jugadores.put("XXDXNIXX", new PlayerData());
        jugadores.put("AISFEX", new PlayerData());
        jugadores.put("BENJATOX", new PlayerData());
        jugadores.put("DIOSHAN02", new PlayerData());
        jugadores.put("CLAVI_11CHAMP", new PlayerData());
        jugadores.put("CHARLOTTEM17", new PlayerData());
        jugadores.put("JUANELO_EX", new PlayerData());
        jugadores.put("KIKIN37", new PlayerData());
        jugadores.put("LORDKNIGHT_472", new PlayerData());
        jugadores.put("JAVIER223300", new PlayerData());
        jugadores.put("MATHIXREDIC93", new PlayerData());
        jugadores.put("RUSHERBOY", new PlayerData());
        jugadores.put("JESCHERRY", new PlayerData());
        jugadores.put("FRUTIKAREA20", new PlayerData());
        jugadores.put("BERGAMESLJ3", new PlayerData());
        jugadores.put("EDWARDS_BC", new PlayerData());
        jugadores.put("SEBSZWOLF1", new PlayerData());
        jugadores.put("STTLOCH", new PlayerData());
        jugadores.put("NEKRR", new PlayerData());
        jugadores.put("BRIVEL", new PlayerData());
        jugadores.put("DAERONNS", new PlayerData());
        jugadores.put("TRATRA2468", new PlayerData());
        jugadores.put("IPIXEL_SHADOW", new PlayerData());
        jugadores.put("BLUESPLENDOR", new PlayerData());

    }

    public static PlayerUtils getInstance() {
        return PlayerUtils.playerUtils;
    }
}
