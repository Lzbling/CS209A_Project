/**
 * This class is used to store the data of a row.
 * It mainly involves the data for each column and their getter & setter.
 */
public class DataInfo {
    // --- start ---
    private String iso_code;        // 国家代码
    private String continent;       // 所处大洲
    private String location;        // 地理位置
    private String date;            // 日期

    private String total_cases;             // 新冠累计确诊数
    private String new_cases;               // 当日新增确诊数
    private String new_cases_smoothed;      // 新增确诊数（7日平均）
    private String total_deaths;            // 新冠累计死亡数
    private String new_deaths;              // 当日新增死亡数
    private String new_deaths_smoothed;     // 新增死亡数（7日平均）
    private String total_cases_per_million;         // 新冠累计确诊数，每百万
    private String new_cases_per_million;           // 当日新增确诊数，每百万
    private String new_cases_smoothed_per_million;  // 新增确诊数（7日平均），每百万
    private String total_deaths_per_million;        // 新冠累计死亡数，每百万
    private String new_deaths_per_million;          // 当日新增死亡数，每百万
    private String new_deaths_smoothed_per_million; // 新增死亡数（7日平均），每百万

    private String reproduction_rate;           // 实时新冠传播率（每一个病人平均能传染几个人，>1为疫情扩大，<1为疫情逐步平息）
    private String icu_patients;                // 当日ICU病人数
    private String icu_patients_per_million;    // 当日ICU病人数，每百万
    private String hosp_patients;               // 当日医院病人数
    private String hosp_patients_per_million;   // 当日医院病人数，每百万
    private String weekly_icu_admissions;               // 每周新增ICU住院数
    private String weekly_icu_admissions_per_million;   // 每周新增ICU住院数，每百万
    private String weekly_hosp_admissions;              // 每周新增医院住院数
    private String weekly_hosp_admissions_per_million;  // 每周新增医院住院数，每百万

    private String new_tests;                       // 当日新增检测数
    private String total_tests;                     // 累计检测数
    private String total_tests_per_thousand;        // 累计检测数，每千人
    private String new_tests_per_thousand;          // 新增检测数，每千人
    private String new_tests_smoothed;              // 新增检测数（7日平均）
    private String new_tests_smoothed_per_thousand; // 新增检测数（7日平均），每千人
    private String positive_rate;       // 阳性率：阳性样例占检测数的比例（7日平均）（即tests_per_case的倒数）
    private String tests_per_case;      // 检测数每确诊样例（7日平均）（即positive_rate的倒数）
    private String tests_units;         // 当地用于报告其检测数据的单位
    // 表格中已知的取值："tests performed", "people tested", "samples tested", "units unclear", (null or "")

    private String total_vaccinations;                  // 累计疫苗接种数
    private String people_vaccinated;                   // 至少接种一剂疫苗的总人数
    private String people_fully_vaccinated;             // 接受疫苗接种方案规定的所有剂量的总人数
    private String total_boosters;                      // 累计加强针（接种量超过疫苗接种方案规定的剂量）接种数
    private String new_vaccinations;                    // 当日新增疫苗接种数
    private String new_vaccinations_smoothed;           // 新增疫苗接种数（7日平均）
    // 对于没有每天报告疫苗接种数据的国家，我们假设在没有报告数据的任何时期，疫苗接种每天的变化是相同的。
    // 这将生成一系列完整的每日数据，然后在滚动的7天窗口内对其进行平均
    private String total_vaccinations_per_hundred;      // 累计疫苗接种数，每百人
    private String people_vaccinated_per_hundred;       // 至少接种一剂疫苗的总人数，每百人
    private String people_fully_vaccinated_per_hundred; // 接受疫苗接种方案规定的所有剂量的总人数，每百人
    private String total_boosters_per_hundred;          // 累计加强针接种数，每百人
    private String new_vaccinations_smoothed_per_million;   //  新增疫苗接种数（7日平均），每百人

    private String stringency_index;    // 政府响应严格性指数
    // 基于9个响应指标的综合度量，包括学校关闭、工作场所关闭和旅行禁令，取值在0~100之间。（100 = 最严格的响应）
    private String population;          // 人口总数
    private String population_density;  // 人口密度
    private String median_age;          // 年龄中位数
    private String aged_65_older;       // 65+年龄人口比例
    private String aged_70_older;       // 70+年龄人口比例
    private String gdp_per_capita;      // 人均GDP（国内生产总值）
    private String extreme_poverty;     // 极度贫困人口比例
    private String cardiovasc_death_rate;       // （2017年）心血管疾病死亡率（死亡人数，每年，每100000人）
    private String diabetes_prevalence;         // （2017年）糖尿病患病率（20-79岁人口中患者的百分比）
    private String female_smokers;              // 男性中吸烟者比例
    private String male_smokers;                // 女性中吸烟者比例
    private String handwashing_facilities;      // 拥有基本洗手设施的人口比例
    private String hospital_beds_per_thousand;  // 每千人病床数
    private String life_expectancy;             // 国民预期寿命
    private String human_development_index;     // 人类发展指数
    // 一项综合指数，衡量人类发展三个基本方面的平均成就，即长寿和健康的生活、知识和体面的生活水平。

    private String excess_mortality_cumulative_absolute;        // 超额累积死亡绝对值
    // 自2020年1月1日以来报告的死亡人数与基于前几年的同期预计死亡人数之间的累积差异
    private String excess_mortality_cumulative;                 // 超额累积死亡率
    // 自2020年1月1日以来的累计死亡人数与基于前几年的同期累计预计死亡人数之间的百分比差异。
    private String excess_mortality;                            // 超额死亡率
    // 2020至2021年间每周或每月死亡人数与前一年同期死亡人数的百分比差异
    private String excess_mortality_cumulative_per_million;     // 超额累积死亡，每百万
    // 自2020年1月1日以来报告的死亡人数与基于前几年的同期预测死亡人数之间的累积差异，单位为百万人。
    // --- end ---

    /**
     * getters & setters
     */

    // getters
    public String getIso_code() {
        return iso_code;
    }
    public String getContinent() {
        return continent;
    }
    public String getLocation() {
        return location;
    }
    public String getDate() {
        return date;
    }
    public String getTotal_cases() {
        return total_cases;
    }
    public String getNew_cases() {
        return new_cases;
    }
    public String getNew_cases_smoothed() {
        return new_cases_smoothed;
    }
    public String getTotal_deaths() {
        return total_deaths;
    }
    public String getNew_deaths() {
        return new_deaths;
    }
    public String getNew_deaths_smoothed() {
        return new_deaths_smoothed;
    }
    public String getTotal_cases_per_million() {
        return total_cases_per_million;
    }
    public String getNew_cases_per_million() {
        return new_cases_per_million;
    }
    public String getNew_cases_smoothed_per_million() {
        return new_cases_smoothed_per_million;
    }
    public String getTotal_deaths_per_million() {
        return total_deaths_per_million;
    }
    public String getNew_deaths_per_million() {
        return new_deaths_per_million;
    }
    public String getNew_deaths_smoothed_per_million() {
        return new_deaths_smoothed_per_million;
    }
    public String getReproduction_rate() {
        return reproduction_rate;
    }
    public String getIcu_patients() {
        return icu_patients;
    }
    public String getIcu_patients_per_million() {
        return icu_patients_per_million;
    }
    public String getHosp_patients() {
        return hosp_patients;
    }
    public String getHosp_patients_per_million() {
        return hosp_patients_per_million;
    }
    public String getWeekly_icu_admissions() {
        return weekly_icu_admissions;
    }
    public String getWeekly_icu_admissions_per_million() {
        return weekly_icu_admissions_per_million;
    }
    public String getWeekly_hosp_admissions() {
        return weekly_hosp_admissions;
    }
    public String getWeekly_hosp_admissions_per_million() {
        return weekly_hosp_admissions_per_million;
    }
    public String getNew_tests() {
        return new_tests;
    }
    public String getTotal_tests() {
        return total_tests;
    }
    public String getTotal_tests_per_thousand() {
        return total_tests_per_thousand;
    }
    public String getNew_tests_per_thousand() {
        return new_tests_per_thousand;
    }
    public String getNew_tests_smoothed() {
        return new_tests_smoothed;
    }
    public String getNew_tests_smoothed_per_thousand() {
        return new_tests_smoothed_per_thousand;
    }
    public String getPositive_rate() {
        return positive_rate;
    }
    public String getTests_per_case() { return tests_per_case; }
    public String getTests_units() {
        return tests_units;
    }
    public String getTotal_vaccinations() {
        return total_vaccinations;
    }
    public String getPeople_vaccinated() {
        return people_vaccinated;
    }
    public String getPeople_fully_vaccinated() {
        return people_fully_vaccinated;
    }
    public String getTotal_boosters() {
        return total_boosters;
    }
    public String getNew_vaccinations() {
        return new_vaccinations;
    }
    public String getNew_vaccinations_smoothed() {
        return new_vaccinations_smoothed;
    }
    public String getTotal_vaccinations_per_hundred() {
        return total_vaccinations_per_hundred;
    }
    public String getPeople_vaccinated_per_hundred() {
        return people_vaccinated_per_hundred;
    }
    public String getPeople_fully_vaccinated_per_hundred() {
        return people_fully_vaccinated_per_hundred;
    }
    public String getTotal_boosters_per_hundred() {
        return total_boosters_per_hundred;
    }
    public String getNew_vaccinations_smoothed_per_million() {
        return new_vaccinations_smoothed_per_million;
    }
    public String getStringency_index() {
        return stringency_index;
    }
    public String getPopulation() {
        return population;
    }
    public String getPopulation_density() {
        return population_density;
    }
    public String getMedian_age() {
        return median_age;
    }
    public String getAged_65_older() {
        return aged_65_older;
    }
    public String getAged_70_older() {
        return aged_70_older;
    }
    public String getGdp_per_capita() {
        return gdp_per_capita;
    }
    public String getExtreme_poverty() {
        return extreme_poverty;
    }
    public String getCardiovasc_death_rate() {
        return cardiovasc_death_rate;
    }
    public String getDiabetes_prevalence() {
        return diabetes_prevalence;
    }
    public String getFemale_smokers() {
        return female_smokers;
    }
    public String getMale_smokers() {
        return male_smokers;
    }
    public String getHandwashing_facilities() {
        return handwashing_facilities;
    }
    public String getHospital_beds_per_thousand() {
        return hospital_beds_per_thousand;
    }
    public String getLife_expectancy() {
        return life_expectancy;
    }
    public String getHuman_development_index() {
        return human_development_index;
    }
    public String getExcess_mortality_cumulative_absolute() {
        return excess_mortality_cumulative_absolute;
    }
    public String getExcess_mortality_cumulative() {
        return excess_mortality_cumulative;
    }
    public String getExcess_mortality() { return excess_mortality; }
    public String getExcess_mortality_cumulative_per_million() {
        return excess_mortality_cumulative_per_million;
    }

    // setters
    public void setIso_code(String iso_code) {
        this.iso_code = iso_code;
    }
    public void setContinent(String continent) {
        this.continent = continent;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setHosp_patients(String hosp_patients) {
        this.hosp_patients = hosp_patients;
    }
    public void setHosp_patients_per_million(String hosp_patients_per_million) {
        this.hosp_patients_per_million = hosp_patients_per_million;
    }
    public void setIcu_patients(String icu_patients) {
        this.icu_patients = icu_patients;
    }
    public void setIcu_patients_per_million(String icu_patients_per_million) {
        this.icu_patients_per_million = icu_patients_per_million;
    }
    public void setNew_cases(String new_cases) {
        this.new_cases = new_cases;
    }
    public void setNew_cases_per_million(String new_cases_per_million) {
        this.new_cases_per_million = new_cases_per_million;
    }
    public void setNew_cases_smoothed(String new_cases_smoothed) {
        this.new_cases_smoothed = new_cases_smoothed;
    }
    public void setNew_deaths(String new_deaths) {
        this.new_deaths = new_deaths;
    }
    public void setNew_cases_smoothed_per_million(String new_cases_smoothed_per_million) {
        this.new_cases_smoothed_per_million = new_cases_smoothed_per_million;
    }
    public void setNew_deaths_per_million(String new_deaths_per_million) {
        this.new_deaths_per_million = new_deaths_per_million;
    }
    public void setNew_deaths_smoothed(String new_deaths_smoothed) {
        this.new_deaths_smoothed = new_deaths_smoothed;
    }
    public void setNew_deaths_smoothed_per_million(String new_deaths_smoothed_per_million) {
        this.new_deaths_smoothed_per_million = new_deaths_smoothed_per_million;
    }
    public void setNew_tests(String new_tests) {
        this.new_tests = new_tests;
    }
    public void setNew_tests_per_thousand(String new_tests_per_thousand) {
        this.new_tests_per_thousand = new_tests_per_thousand;
    }
    public void setNew_tests_smoothed(String new_tests_smoothed) {
        this.new_tests_smoothed = new_tests_smoothed;
    }
    public void setReproduction_rate(String reproduction_rate) {
        this.reproduction_rate = reproduction_rate;
    }
    public void setNew_tests_smoothed_per_thousand(String new_tests_smoothed_per_thousand) {
        this.new_tests_smoothed_per_thousand = new_tests_smoothed_per_thousand;
    }
    public void setTotal_cases(String total_cases) {
        this.total_cases = total_cases;
    }
    public void setTotal_cases_per_million(String total_cases_per_million) {
        this.total_cases_per_million = total_cases_per_million;
    }
    public void setTotal_deaths(String total_deaths) {
        this.total_deaths = total_deaths;
    }
    public void setTotal_deaths_per_million(String total_deaths_per_million) {
        this.total_deaths_per_million = total_deaths_per_million;
    }
    public void setTotal_tests(String total_tests) {
        this.total_tests = total_tests;
    }
    public void setTotal_tests_per_thousand(String total_tests_per_thousand) {
        this.total_tests_per_thousand = total_tests_per_thousand;
    }
    public void setWeekly_hosp_admissions(String weekly_hosp_admissions) {
        this.weekly_hosp_admissions = weekly_hosp_admissions;
    }
    public void setWeekly_hosp_admissions_per_million(String weekly_hosp_admissions_per_million) {
        this.weekly_hosp_admissions_per_million = weekly_hosp_admissions_per_million;
    }
    public void setWeekly_icu_admissions(String weekly_icu_admissions) {
        this.weekly_icu_admissions = weekly_icu_admissions;
    }
    public void setPositive_rate(String positive_rate) {
        this.positive_rate = positive_rate;
    }
    public void setWeekly_icu_admissions_per_million(String weekly_icu_admissions_per_million) {
        this.weekly_icu_admissions_per_million = weekly_icu_admissions_per_million;
    }
    public void setAged_65_older(String aged_65_older) {
        this.aged_65_older = aged_65_older;
    }
    public void setAged_70_older(String aged_70_older) {
        this.aged_70_older = aged_70_older;
    }
    public void setCardiovasc_death_rate(String cardiovasc_death_rate) {
        this.cardiovasc_death_rate = cardiovasc_death_rate;
    }
    public void setDiabetes_prevalence(String diabetes_prevalence) {
        this.diabetes_prevalence = diabetes_prevalence;
    }
    public void setExcess_mortality(String excess_mortality) {
        this.excess_mortality = excess_mortality;
    }
    public void setTests_per_case(String tests_per_case) {
        this.tests_per_case = tests_per_case;
    }
    public void setExcess_mortality_cumulative(String excess_mortality_cumulative) {
        this.excess_mortality_cumulative = excess_mortality_cumulative;
    }
    public void setExcess_mortality_cumulative_absolute(String excess_mortality_cumulative_absolute) {
        this.excess_mortality_cumulative_absolute = excess_mortality_cumulative_absolute;
    }
    public void setExcess_mortality_cumulative_per_million(String excess_mortality_cumulative_per_million) {
        this.excess_mortality_cumulative_per_million = excess_mortality_cumulative_per_million;
    }
    public void setExtreme_poverty(String extreme_poverty) {
        this.extreme_poverty = extreme_poverty;
    }
    public void setFemale_smokers(String female_smokers) {
        this.female_smokers = female_smokers;
    }
    public void setGdp_per_capita(String gdp_per_capita) {
        this.gdp_per_capita = gdp_per_capita;
    }
    public void setHandwashing_facilities(String handwashing_facilities) {
        this.handwashing_facilities = handwashing_facilities;
    }
    public void setHospital_beds_per_thousand(String hospital_beds_per_thousand) {
        this.hospital_beds_per_thousand = hospital_beds_per_thousand;
    }
    public void setHuman_development_index(String human_development_index) {
        this.human_development_index = human_development_index;
    }
    public void setLife_expectancy(String life_expectancy) {
        this.life_expectancy = life_expectancy;
    }
    public void setMale_smokers(String male_smokers) {
        this.male_smokers = male_smokers;
    }
    public void setMedian_age(String median_age) {
        this.median_age = median_age;
    }
    public void setNew_vaccinations(String new_vaccinations) {
        this.new_vaccinations = new_vaccinations;
    }
    public void setNew_vaccinations_smoothed(String new_vaccinations_smoothed) {
        this.new_vaccinations_smoothed = new_vaccinations_smoothed;
    }
    public void setNew_vaccinations_smoothed_per_million(String new_vaccinations_smoothed_per_million) {
        this.new_vaccinations_smoothed_per_million = new_vaccinations_smoothed_per_million;
    }
    public void setPeople_fully_vaccinated(String people_fully_vaccinated) {
        this.people_fully_vaccinated = people_fully_vaccinated;
    }
    public void setPeople_fully_vaccinated_per_hundred(String people_fully_vaccinated_per_hundred) {
        this.people_fully_vaccinated_per_hundred = people_fully_vaccinated_per_hundred;
    }
    public void setPeople_vaccinated(String people_vaccinated) {
        this.people_vaccinated = people_vaccinated;
    }
    public void setPeople_vaccinated_per_hundred(String people_vaccinated_per_hundred) {
        this.people_vaccinated_per_hundred = people_vaccinated_per_hundred;
    }
    public void setPopulation(String population) {
        this.population = population;
    }
    public void setPopulation_density(String population_density) {
        this.population_density = population_density;
    }
    public void setStringency_index(String stringency_index) {
        this.stringency_index = stringency_index;
    }
    public void setTests_units(String tests_units) {
        this.tests_units = tests_units;
    }
    public void setTotal_boosters(String total_boosters) {
        this.total_boosters = total_boosters;
    }
    public void setTotal_boosters_per_hundred(String total_boosters_per_hundred) {
        this.total_boosters_per_hundred = total_boosters_per_hundred;
    }
    public void setTotal_vaccinations(String total_vaccinations) {
        this.total_vaccinations = total_vaccinations;
    }
    public void setTotal_vaccinations_per_hundred(String total_vaccinations_per_hundred) {
        this.total_vaccinations_per_hundred = total_vaccinations_per_hundred;
    }

    /**
     * constructor of this class, initialize the following members with the data read from dataSet
     */
    public DataInfo(String iso_code, String continent, String location, String date,
                    String total_cases, String new_cases, String new_cases_smoothed,
                    String total_deaths, String new_deaths, String new_deaths_smoothed,
                    String total_cases_per_million, String new_cases_per_million,
                    String new_cases_smoothed_per_million,
                    String total_deaths_per_million, String new_deaths_per_million,
                    String new_deaths_smoothed_per_million,
                    String reproduction_rate, String icu_patients, String icu_patients_per_million,
                    String hosp_patients, String hosp_patients_per_million, String weekly_icu_admissions,
                    String weekly_icu_admissions_per_million, String weekly_hosp_admissions,
                    String weekly_hosp_admissions_per_million, String new_tests, String total_tests,
                    String total_tests_per_thousand, String new_tests_per_thousand,
                    String new_tests_smoothed, String new_tests_smoothed_per_thousand,
                    String positive_rate, String tests_per_case, String tests_units,
                    String total_vaccinations, String people_vaccinated, String people_fully_vaccinated,
                    String total_boosters, String new_vaccinations, String new_vaccinations_smoothed,
                    String total_vaccinations_per_hundred, String people_vaccinated_per_hundred,
                    String people_fully_vaccinated_per_hundred, String total_boosters_per_hundred,
                    String new_vaccinations_smoothed_per_million, String stringency_index,
                    String population, String population_density, String median_age,
                    String aged_65_older, String aged_70_older, String gdp_per_capita,
                    String extreme_poverty, String cardiovasc_death_rate, String diabetes_prevalence,
                    String female_smokers, String male_smokers, String handwashing_facilities,
                    String hospital_beds_per_thousand, String life_expectancy, String human_development_index,
                    String excess_mortality_cumulative_absolute, String excess_mortality_cumulative,
                    String excess_mortality, String excess_mortality_cumulative_per_million){
        setIso_code(iso_code); setContinent(continent); setLocation(location); setDate(date);
        setTotal_cases(total_cases); setNew_cases(new_cases); setNew_cases_smoothed(new_cases_smoothed);
        setTotal_deaths(total_deaths); setNew_deaths(new_deaths); setNew_deaths_smoothed(new_deaths_smoothed);
        setTotal_cases_per_million(total_cases_per_million); setNew_cases_per_million(new_cases_per_million);
        setNew_cases_smoothed_per_million(new_cases_smoothed_per_million);
        setTotal_deaths_per_million(total_deaths_per_million); setNew_deaths_per_million(new_deaths_per_million);
        setNew_deaths_smoothed_per_million(new_deaths_smoothed_per_million);
        setReproduction_rate(reproduction_rate); setIcu_patients(icu_patients);
        setIcu_patients_per_million(icu_patients_per_million); setHosp_patients(hosp_patients);
        setHosp_patients_per_million(hosp_patients_per_million); setWeekly_icu_admissions(weekly_icu_admissions);
        setWeekly_icu_admissions_per_million(weekly_icu_admissions_per_million);
        setWeekly_hosp_admissions(weekly_hosp_admissions);
        setWeekly_hosp_admissions_per_million(weekly_hosp_admissions_per_million);
        setNew_tests(new_tests); setTotal_tests(total_tests); setTotal_tests_per_thousand(total_tests_per_thousand);
        setNew_tests_per_thousand(new_tests_per_thousand); setNew_tests_smoothed(new_tests_smoothed);
        setNew_tests_smoothed_per_thousand(new_tests_smoothed_per_thousand); setPositive_rate(positive_rate);
        setTests_per_case(tests_per_case); setTests_units(tests_units); setTotal_vaccinations(total_vaccinations);
        setPeople_vaccinated(people_vaccinated); setPeople_fully_vaccinated(people_fully_vaccinated);
        setTotal_boosters(total_boosters); setNew_vaccinations(new_vaccinations);
        setNew_vaccinations_smoothed(new_vaccinations_smoothed);
        setTotal_vaccinations_per_hundred(total_vaccinations_per_hundred);
        setPeople_vaccinated_per_hundred(people_vaccinated_per_hundred);
        setPeople_fully_vaccinated_per_hundred(people_fully_vaccinated_per_hundred);
        setTotal_boosters_per_hundred(total_boosters_per_hundred);
        setNew_vaccinations_smoothed_per_million(new_vaccinations_smoothed_per_million);
        setStringency_index(stringency_index); setPopulation(population); setPopulation_density(population_density);
        setMedian_age(median_age); setAged_65_older(aged_65_older); setAged_70_older(aged_70_older);
        setGdp_per_capita(gdp_per_capita); setExtreme_poverty(extreme_poverty);
        setCardiovasc_death_rate(cardiovasc_death_rate); setDiabetes_prevalence(diabetes_prevalence);
        setFemale_smokers(female_smokers); setMale_smokers(male_smokers); setHandwashing_facilities(handwashing_facilities);
        setHospital_beds_per_thousand(hospital_beds_per_thousand); setLife_expectancy(life_expectancy);
        setHuman_development_index(human_development_index);
        setExcess_mortality_cumulative_absolute(excess_mortality_cumulative_absolute);
        setExcess_mortality_cumulative(excess_mortality_cumulative);
        setExcess_mortality(excess_mortality);
        setExcess_mortality_cumulative_per_million(excess_mortality_cumulative_per_million);
    }
} // end of class
