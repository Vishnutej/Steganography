import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		ImagePanel source=new ImagePanel();
		ImagePanel hidden=new ImagePanel();
		ImagePanel result=new ImagePanel();
		String cover ="C:\\Users\\Vishnutej\\Steganography\\stegano-java-master\\images\\cover.jpg";
		String secret ="C:\\Users\\Vishnutej\\Steganography\\stegano-java-master\\images\\cover1.png";
		while (true) {
			System.out.println(
					"Choose Action:\n 1. Cover Image\n 2. Secret Image\n 3. Hide Image\n 4. Reveal Image\n 5. Save Image\n 6. Exit");
			Scanner sc = new Scanner(System.in);
			int ip = sc.nextInt();
			if (ip == 1) {
				// Choose Source Image and call the function
				File file = new File(cover);
				BufferedImage buf=ImageFileManager.loadImage(file);
				source.setImage(buf);
				 // BufferedReader br = new BufferedReader(new FileReader(file));
			} else if (ip == 2) {
				//Choose Image to Hide
				File file = new File(secret);
				BufferedImage buf2 = ImageFileManager.loadImage(file);
				hidden.setImage(buf2);
			} else if (ip == 3) {
				//Hide Image - Stegano call
				Stegano s = new Stegano(source.getImage(), hidden.getImage());
				s.hide();
				result.setImage(s.getResultImage());
			} else if (ip == 4) {
				//Reveal Image - Stegano call
				Stegano s = new Stegano(source.getImage());
		        s.reveal();
				result.setImage(s.getResultImage());
			} else if (ip == 5) {
				//Save Image call
				File f=new File("C:\\Users\\Vishnutej\\Desktop\\r.png");
				ImageFileManager.saveImage(result.getImage(), f);
			} else {
				System.out.println("Exiting...");
				break;
			}
		}

	}

}
