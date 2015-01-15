import hwconklin.contextFreeGrammar.WeightedContextFreeGrammar;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.jfugue.Player;



public class ContextFreeMusic {

	public static void main(String[] args) {
		System.out.println("Loading grammar");
		WeightedContextFreeGrammar gram;
		try {
			gram = WeightedContextFreeGrammar.loadFromFile("music.gram");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		
		System.out.println("Generating");
		List<String> music = new ArrayList<>();
		music.add("MUSIC");
		music = gram.generate(music);
		
		String m = "";
		
		for (int i = 0; i < music.size(); i++){
			String c = music.get(i);
			switch (c){
			case "I": m+="Cmaj"; break;
			case "ii": m+="Dmin"; break;
			case "iii": m+="Emin"; break;
			case "IV": m+="Fmaj"; break;
			case "V": m+="Gmaj"; break;
			case "vi": m+="Amin"; break;
			case "vii_dim": m+="Bdim"; break;
			}
			if (i+1 < music.size() && music.get(i+1).equals("END_PHRASE")){
				m+="h ";
				i++;
			}
			else m+= "q ";
			
		}
		System.out.println(m);
		
		new Player().play(m);
		
	}
}
