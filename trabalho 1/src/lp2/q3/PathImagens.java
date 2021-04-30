package lp2.q3;

import java.io.File;
import java.util.Arrays;

public class PathImagens {

    public static void main(String[] destinergs) {
        File file = new File(System.getProperty("user.dir") + "/src/lp2/q3/origem");
        File destine = new File(System.getProperty("user.dir") + "/src/lp2/q3/destino");
        exploradorDeArquivos(file, destine);
    }

    public static void exploradorDeArquivos(File file, File destine) {
        //cria o path se não existe
        file.mkdirs();
        destine.mkdirs();
        imprimirEMoverPNG(file, "", 1, destine);
    }

    private static void imprimirEMoverPNG(File file, String tab, int level, File destine) {
        String png = "";
        if (file.isFile() && file.getName().contains(".png")) {
            File d = new File(destine.getAbsolutePath()+ "/" + file.getName());
            if (file.renameTo(d)) png = ("--- foi mudado----");
        }
        System.out.format("%s%s (Level: %d) %s %n", tab, file.getName(), level, png);
        //imprime e move os arquivos filhos
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            Arrays.stream(files).forEach(f -> imprimirEMoverPNG(f, tab + "\t", level + 1, destine));
        }
    }
}
