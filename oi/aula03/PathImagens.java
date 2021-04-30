package aula03;

import java.io.File;

public class PathImagens {

	public static void main(String[] args) {

		File file = new File(System.getProperty("user.dir"));
		File destine = new File(System.getProperty("user.dir"));
		System.out.println(" ----------------------------------");
		exploreFormatedWithLevel(file, destine);
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
