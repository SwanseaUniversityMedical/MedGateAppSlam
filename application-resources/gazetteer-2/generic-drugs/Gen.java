import java.io.*;
import java.util.*;

public class Gen {
	public static void main(String[] args) throws Exception {
		Set<String> known = new HashSet<String>();

		for (int i = 1 ; i < args.length ; ++i) {
			File f = new File(args[i]);
			BufferedReader in = new BufferedReader(new FileReader(f));
			String line = in.readLine();
			while (line != null) {
				known.add(line.toLowerCase().trim());
				line = in.readLine();
			}
			in.close();
		}

		File f = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(f));

		String line = in.readLine();
		while (line != null) {
			if (!known.contains(line.toLowerCase().trim()))
				System.out.println(line.trim());

			line = in.readLine();
		}
	}
}
