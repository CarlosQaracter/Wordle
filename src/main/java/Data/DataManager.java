package Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class DataManager {

    private BufferedReader br;
    private int lines;
    private Random random;

    public DataManager(String filename) throws IOException {
            this.br = new BufferedReader(new FileReader(filename));
            lines = Integer.parseInt(br.readLine());
            System.out.println("DM creation" + lines);
            br.mark(lines);
            random = new Random();
    }

    public void closeDataFile() throws IOException {
        if(br != null) {
            br.close();
        }
    }

    public String getWord(int line) throws IOException {
        br.reset();
        String readLine = br.readLine();
        System.out.println("getWordinit" + readLine);
        int i = 1;
        while ((readLine != null) && (i < (lines - 1)) && (line != (i - 1))) {
            readLine = br.readLine();
            System.out.println("getWordLoop" + readLine);
            i++;
        }
        return readLine;
    }

    public String getWord() throws IOException {
        br.reset();
        String readLine = br.readLine();
        int i = 1;
        int stopLine = random.nextInt(lines - 1);

        System.out.println("Stop:" + stopLine);
        while ((readLine != null) && (i < (lines - 1)) && (stopLine != (i - 1))) {
            readLine = br.readLine();
            i++;
        }
        System.out.println("returned" + readLine);
        return readLine;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
