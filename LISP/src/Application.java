import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

//pp
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chaine="";
		String fichier = "test.txt";//JOptionPane.showInputDialog("nom du fichier");

		//lecture du fichier texte
		try{
			InputStream ips=new FileInputStream(fichier);
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				chaine+=ligne+"\n";
			}
			br.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}

		System.out.println(chaine);

	}

}