import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataProcess {
    private ArrayList<DataInfo> data = new ArrayList<>();
    private static final String missing = "missing";

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

    private static final String JSON_FilePath = "file.json";
    public void saveAsFile(){
        BufferedWriter writer = null;
        File file = new File(JSON_FilePath);
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file,false), StandardCharsets.UTF_8));
            writer.write("[");

            StringBuilder sb;
            boolean isFirst = true;
            int cnt = 0;
            for ( DataInfo row : data ){
                sb = new StringBuilder();
                if (isFirst) isFirst = false;
                else sb.append(", ");
                sb.append("{ ");

                sb.append("\"iso_code\":\""); sb.append(row.getIso_code()); sb.append("\", ");
                sb.append("\"continent\":\""); sb.append(row.getContinent()); sb.append("\", ");
                sb.append("\"location\":\""); sb.append(row.getLocation()); sb.append("\", ");
                sb.append("\"date\":\""); sb.append(row.getDate()); sb.append("\", ");

                sb.append("\"total_cases\":\""); sb.append(row.getTotal_cases()); sb.append("\", ");
                sb.append("\"new_cases\":\""); sb.append(row.getNew_cases()); sb.append("\", ");
                sb.append("\"new_cases_smoothed\":\""); sb.append(row.getNew_cases_smoothed()); sb.append("\", ");
                sb.append("\"total_deaths\":\""); sb.append(row.getTotal_deaths()); sb.append("\", ");
                sb.append("\"new_deaths\":\""); sb.append(row.getNew_deaths()); sb.append("\", ");
                sb.append("\"new_deaths_smoothed\":\""); sb.append(row.getNew_deaths_smoothed()); sb.append("\", ");
                sb.append("\"total_cases_per_million\":\""); sb.append(row.getTotal_cases_per_million()); sb.append("\", ");
                sb.append("\"new_cases_per_million\":\""); sb.append(row.getNew_cases_per_million()); sb.append("\", ");
                sb.append("\"new_cases_smoothed_per_million\":\"");
                sb.append(row.getNew_cases_smoothed_per_million()); sb.append("\", ");
                sb.append("\"total_deaths_per_million\":\"");
                sb.append(row.getTotal_deaths_per_million()); sb.append("\", ");
                sb.append("\"new_deaths_per_million\":\""); sb.append(row.getNew_deaths_per_million()); sb.append("\", ");
                sb.append("\"new_deaths_smoothed_per_million\":\"");
                sb.append(row.getNew_deaths_smoothed_per_million()); sb.append("\", ");

                sb.append("\"reproduction_rate\":\""); sb.append(row.getReproduction_rate()); sb.append("\", ");
                sb.append("\"icu_patients\":\""); sb.append(row.getIcu_patients()); sb.append("\", ");
                sb.append("\"icu_patients_per_million\":\"");
                sb.append(row.getIcu_patients_per_million()); sb.append("\", ");
                sb.append("\"hosp_patients\":\""); sb.append(row.getHosp_patients()); sb.append("\", ");
                sb.append("\"hosp_patients_per_million\":\"");
                sb.append(row.getHosp_patients_per_million()); sb.append("\", ");
                sb.append("\"weekly_icu_admissions\":\""); sb.append(row.getWeekly_icu_admissions()); sb.append("\", ");
                sb.append("\"weekly_icu_admissions_per_million\":\"");
                sb.append(row.getWeekly_icu_admissions_per_million()); sb.append("\", ");
                sb.append("\"weekly_hosp_admissions\":\""); sb.append(row.getWeekly_hosp_admissions()); sb.append("\", ");
                sb.append("\"weekly_hosp_admissions_per_million\":\"");
                sb.append(row.getWeekly_hosp_admissions_per_million()); sb.append("\", ");

                sb.append("\"new_tests\":\""); sb.append(row.getNew_tests()); sb.append("\", ");
                sb.append("\"total_tests\":\""); sb.append(row.getTotal_tests()); sb.append("\", ");
                sb.append("\"total_tests_per_thousand\":\"");
                sb.append(row.getTotal_tests_per_thousand()); sb.append("\", ");
                sb.append("\"new_tests_per_thousand\":\""); sb.append(row.getNew_tests_per_thousand()); sb.append("\", ");
                sb.append("\"new_tests_smoothed\":\""); sb.append(row.getNew_tests_smoothed()); sb.append("\", ");
                sb.append("\"new_tests_smoothed_per_thousand\":\"");
                sb.append(row.getNew_tests_smoothed_per_thousand()); sb.append("\", ");
                sb.append("\"positive_rate\":\""); sb.append(row.getPositive_rate()); sb.append("\", ");
                sb.append("\"tests_per_case\":\""); sb.append(row.getTests_per_case()); sb.append("\", ");
                sb.append("\"tests_units\":\""); sb.append(row.getTests_units()); sb.append("\", ");

                sb.append("\"total_vaccinations\":\""); sb.append(row.getTotal_vaccinations()); sb.append("\", ");
                sb.append("\"people_vaccinated\":\""); sb.append(row.getPeople_vaccinated()); sb.append("\", ");
                sb.append("\"people_fully_vaccinated\":\""); sb.append(row.getPeople_fully_vaccinated()); sb.append("\", ");
                sb.append("\"total_boosters\":\""); sb.append(row.getTotal_boosters()); sb.append("\", ");
                sb.append("\"new_vaccinations\":\""); sb.append(row.getNew_vaccinations()); sb.append("\", ");
                sb.append("\"new_vaccinations_smoothed\":\"");
                sb.append(row.getNew_vaccinations_smoothed()); sb.append("\", ");
                sb.append("\"total_vaccinations_per_hundred\":\"");
                sb.append(row.getTotal_vaccinations_per_hundred()); sb.append("\", ");
                sb.append("\"people_vaccinated_per_hundred\":\"");
                sb.append(row.getPeople_vaccinated_per_hundred()); sb.append("\", ");
                sb.append("\"people_fully_vaccinated_per_hundred\":\"");
                sb.append(row.getPeople_fully_vaccinated_per_hundred()); sb.append("\", ");
                sb.append("\"total_boosters_per_hundred\":\"");
                sb.append(row.getTotal_boosters_per_hundred()); sb.append("\", ");
                sb.append("\"new_vaccinations_smoothed_per_million\":\"");
                sb.append(row.getNew_vaccinations_smoothed_per_million()); sb.append("\", ");

                sb.append("\"stringency_index\":\""); sb.append(row.getStringency_index()); sb.append("\", ");
                sb.append("\"population\":\""); sb.append(row.getPopulation()); sb.append("\", ");
                sb.append("\"population_density\":\""); sb.append(row.getPopulation_density()); sb.append("\", ");
                sb.append("\"median_age\":\""); sb.append(row.getMedian_age()); sb.append("\", ");
                sb.append("\"aged_65_older\":\""); sb.append(row.getAged_65_older()); sb.append("\", ");
                sb.append("\"aged_70_older\":\""); sb.append(row.getAged_70_older()); sb.append("\", ");
                sb.append("\"gdp_per_capita\":\""); sb.append(row.getGdp_per_capita()); sb.append("\", ");
                sb.append("\"extreme_poverty\":\""); sb.append(row.getExtreme_poverty()); sb.append("\", ");
                sb.append("\"cardiovasc_death_rate\":\""); sb.append(row.getCardiovasc_death_rate()); sb.append("\", ");
                sb.append("\"diabetes_prevalence\":\""); sb.append(row.getDiabetes_prevalence()); sb.append("\", ");
                sb.append("\"female_smokers\":\""); sb.append(row.getFemale_smokers()); sb.append("\", ");
                sb.append("\"male_smokers\":\""); sb.append(row.getMale_smokers()); sb.append("\", ");
                sb.append("\"handwashing_facilities\":\""); sb.append(row.getHandwashing_facilities()); sb.append("\", ");
                sb.append("\"hospital_beds_per_thousand\":\"");
                sb.append(row.getHospital_beds_per_thousand()); sb.append("\", ");
                sb.append("\"life_expectancy\":\""); sb.append(row.getLife_expectancy()); sb.append("\", ");
                sb.append("\"human_development_index\":\""); sb.append(row.getHuman_development_index()); sb.append("\", ");

                sb.append("\"excess_mortality_cumulative_absolute\":\"");
                sb.append(row.getExcess_mortality_cumulative_absolute()); sb.append("\", ");
                sb.append("\"excess_mortality_cumulative\":\"");
                sb.append(row.getExcess_mortality_cumulative()); sb.append("\", ");
                sb.append("\"excess_mortality\":\""); sb.append(row.getExcess_mortality()); sb.append("\", ");
                sb.append("\"excess_mortality_cumulative_per_million\":\"");
                sb.append(row.getExcess_mortality_cumulative_per_million()); sb.append("\"");

                sb.append(" }");
                writer.write(sb.toString());
                cnt++;
                System.out.printf("finish writing %d rows\n", cnt);
            }
            writer.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("JSON文件写入成功！");
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