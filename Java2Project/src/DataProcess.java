import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DataProcess {
    private ArrayList<DataInfo> data = new ArrayList<>();

    public ArrayList<DataInfo> getData(){
        return data;
    }

    public void readData(String path, String sep) {
        try{
            FileInputStream fis = new FileInputStream(path);
            CSVReader csvReader = new CSVReader(fis,sep.charAt(0));
            csvReader.readNext(); // header
            List<String[]> list = csvReader.readAll();
            for ( String[] row : list ){
                DataInfo appointment = new DataInfo(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7],
                        row[8], row[9], row[10], row[11], row[12], row[13], row[14], row[15], row[16], row[17], row[18],
                        row[19], row[20], row[21], row[22], row[23], row[24], row[25], row[26], row[27], row[28],
                        row[29], row[30], row[31], row[32], row[33], row[34], row[35], row[36], row[37], row[38],
                        row[39], row[40], row[41], row[42], row[43], row[44], row[45], row[46], row[47], row[48],
                        row[49], row[50], row[51], row[52], row[53], row[54], row[55], row[56], row[57], row[58],
                        row[59], row[60], row[61], row[62], row[63], row[64]);
                data.add(appointment);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
} // end of class

class CSVReader{
    private BufferedReader br;
    private boolean hasNext = true;
    private char separator;
    private char quoteChar;
    private int skipLines;
    private boolean linesSkipped;
    public static final char DEFAULT_SEPARATOR = ',';
    public static final char DEFAULT_QUOTE_CHARACTER = '"';
    public static final int DEFAULT_SKIP_LINES = 0;
    public CSVReader(FileInputStream fis) throws IOException {
        this(fis, DEFAULT_SEPARATOR);
    }
    public CSVReader(FileInputStream fis, char separator) throws IOException {
        this(fis, separator, DEFAULT_QUOTE_CHARACTER);
    }
    public CSVReader(FileInputStream fis, char separator, char quoteChar) throws IOException {
        this(fis, separator, quoteChar, DEFAULT_SKIP_LINES);
    }
    public CSVReader(FileInputStream fis, char separator, char quoteChar, int line) throws IOException {
        this.br = new BufferedReader(new InputStreamReader(fis, StandardCharsets.ISO_8859_1));
        this.separator = separator;
        this.quoteChar = quoteChar;
        this.skipLines = line;
    }
    public List<String[]> readAll() throws IOException {
        List<String[]> allElements = new ArrayList<>();
        while (hasNext) {
            String[] nextLineAsTokens = readNext();
            if (nextLineAsTokens != null)
                allElements.add(nextLineAsTokens);
        }
        return allElements;
    }
    public String[] readNext() throws IOException {

        String nextLine = getNextLine();
        return hasNext ? parseLine(nextLine) : null;
    }
    private String getNextLine() throws IOException {
        if (!this.linesSkipped) {
            for (int i = 0; i < skipLines; i++) {
                br.readLine();
            }
            this.linesSkipped = true;
        }
        String nextLine = br.readLine();
        if (nextLine == null) {
            hasNext = false;
        }
        return hasNext ? nextLine : null;
    }
    private String[] parseLine(String nextLine) throws IOException {
        if (nextLine == null) {
            return null;
        }
        List tokensOnThisLine = new ArrayList();
        StringBuffer sb = new StringBuffer();
        boolean inQuotes = false;
        do {
            if (inQuotes) {
                // continuing a quoted section, reappend newline
                sb.append("\n");
                nextLine = getNextLine();
                if (nextLine == null)
                    break;
            }
            for (int i = 0; i < nextLine.length(); i++) {
                char c = nextLine.charAt(i);
                if (c == quoteChar) {
                    // this gets complex... the quote may end a quoted block, or escape another quote.
                    // do a 1-char lookahead:
                    if( inQuotes  // we are in quotes, therefore there can be escaped quotes in here.
                            && nextLine.length() > (i+1)  // there is indeed another character to check.
                            && nextLine.charAt(i+1) == quoteChar ){ // ..and that char. is a quote also.
                        // we have two quote chars in a row == one quote char, so consume them both and
                        // put one on the token. we do *not* exit the quoted text.
                        sb.append(nextLine.charAt(i+1));
                        i++;
                    }else{
                        inQuotes = !inQuotes;
                        // the tricky case of an embedded quote in the middle: a,bc"d"ef,g
                        if(i>2 //not on the beginning of the line
                                && nextLine.charAt(i-1) != this.separator //not at the beginning of an escape sequence
                                && nextLine.length()>(i+1) &&
                                nextLine.charAt(i+1) != this.separator //not at the	end of an escape sequence
                        ){
                            sb.append(c);
                        }
                    }
                } else if (c == separator && !inQuotes) {
                    tokensOnThisLine.add(sb.toString());
                    sb = new StringBuffer(); // start work on next token
                } else {
                    sb.append(c);
                }
            }
        } while (inQuotes);
        tokensOnThisLine.add(sb.toString());
        return (String[]) tokensOnThisLine.toArray(new String[0]);
    }
    public void close() throws IOException{
        br.close();
    }
}