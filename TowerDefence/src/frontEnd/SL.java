package frontEnd;

import java.io.*;
import java.util.*;

public class SL {
	public int worldWidth, worldHeight;
	
	public void loadSize(File f) {
		try {
			String [] data = null;
			BufferedReader in = new BufferedReader(new FileReader(f));
			String line;
			while((line = in.readLine()) != null) {
				data = line.split(" ");
			}
			worldWidth = Integer.parseInt(data[0]);
			worldHeight = Integer.parseInt(data[1]);
			in.close();
		}catch(IOException e) {
			
		}
		
	}
	
	public void loadGame(File f) {
		try {
			String [] data;
			BufferedReader in = new BufferedReader(new FileReader(f));
			String line;
			while((line = in.readLine()) != null) {
				data = line.split(" ");
				if(data[2].equals("material")) {
					if(data[3].equals("white")){
						Scene.room.block[Integer.parseInt(data[0])][Integer.parseInt(data[1])].grass = 0;
					}else if(data[3].equals("red")) {
						Scene.room.block[Integer.parseInt(data[0])][Integer.parseInt(data[1])].road = 1;
					}
				}
			}
		}catch(IOException e) {
			
		}
		
	}
			
	
}
