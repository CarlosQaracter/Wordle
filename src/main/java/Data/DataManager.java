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
    private int lastCode;

    public DataManager(String filename) throws IOException {
            this.br = new BufferedReader(new FileReader(filename));
            this.lines = Integer.parseInt(br.readLine());
            //System.out.println("DM creation" + lines);
            this.br.mark(lines);
            this.random = new Random();
            this.lastCode = 0;
    }

    public void closeDataFile() throws IOException {
        if(br != null) {
            br.close();
        }
    }

    public String getWord(int line) throws IOException {
        //1System.out.println("Index=" + line);
        br.reset();
        String readLine = br.readLine();
        //System.out.println("getWordinit" + readLine);
        int i = 1;
        while ((readLine != null) && (i < (lines - 1)) && (line != (i - 1))) {
            readLine = br.readLine();
            //System.out.println("getWordLoop" + readLine);
            i++;
        }
        return readLine;
    }

    public String getWord() throws IOException {
        lastCode = random.nextInt((lines - 1));
        return getWord(lastCode);
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

    public int getLastCode() {
        return lastCode;
    }

    public void setLastCode(int lastCode) {
        this.lastCode = lastCode;
    }
}
