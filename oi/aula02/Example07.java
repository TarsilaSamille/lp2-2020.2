package aula02;

import java.io.File;

public class Example07 {

	public static void main(String[] args) {
		File file = new File("/home/tarsila/Área de Trabalho");
		File destine = new File("/home/tarsila/Imagens/a");

		//explore(file);
		System.out.println("----------------------------------");
		//exploreFormated(file);
		System.out.println("----------------------------------");
		exploreFormatedWithLevel(file, destine);
	}

	public static void explore(File file) {
		System.out.println(file.getName());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				explore(f);
			}
		}
	}

	public static void exploreFormated(File file) {
		exploreFormated(file, "");
	}

	private static void exploreFormated(File file, String tab) {
		System.out.println(tab + file.getName());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				exploreFormated(f, tab + "\t");
			}
		}
	}

	public static void exploreFormatedWithLevel(File file,File destine) {
		exploreFormated(file, "", 1, destine);
	}

	private static void exploreFormated(File file, String tab, int level, File a) {
		System.out.format("%s%s (Level: %d)\n", tab, file.getName(), level);
		if(file.isFile() && file.getName().contains(".png")){
		File d = new File(a.getAbsolutePath()+"/"+file.getName() );
		file.renameTo(d);
	}
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				exploreFormated(f, tab + "\t", level + 1, a);
			}
		}
	}
}
