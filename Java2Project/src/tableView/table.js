function initial(){
    let inputBox = document.getElementById("inputBox");
    let count = 0;
    inputBox.addEventListener("change",function(){
        let reader = new FileReader();
        reader.readAsText(inputBox.files[0],"utf-8");//发起异步请求
        reader.onloadstart = function(){
            console.log("开始加载")
        }
        reader.onprogress = function(){
            count++;
            console.log("加载中 "+count)
        }
        reader.onload = function(){
            console.log("加载成功")
        }
        reader.onloadend= function(){
            console.log("加载结束")
            let len = this.result.length;
            let fileObj = JSON.parse(this.result.toString())
            for ( let i = 0; i < len; i++ ){
                //console.log(fileObj[i])
                console.log(i)
                let rowObj = fileObj[i]
                addRow(rowObj["iso_code"], rowObj["continent"], rowObj["location"], rowObj["date"],
                    rowObj["total_cases"], rowObj["new_cases"], rowObj["new_cases_smoothed"], rowObj["total_deaths"],
                    rowObj["new_deaths"], rowObj["new_deaths_smoothed"], rowObj["total_cases_per_million"],
                    rowObj["new_cases_per_million"], rowObj["new_cases_smoothed_per_million"],
                    rowObj["total_deaths_per_million"], rowObj["new_deaths_per_million"],
                    rowObj["new_deaths_smoothed_per_million"], rowObj["reproduction_rate"], rowObj["icu_patients"],
                    rowObj["icu_patients_per_million"], rowObj["hosp_patients"], rowObj["hosp_patients_per_million"],
                    rowObj["weekly_icu_admissions"], rowObj["weekly_icu_admissions_per_million"],
                    rowObj["weekly_hosp_admissions"], rowObj["weekly_hosp_admissions_per_million"], rowObj["new_tests"],
                    rowObj["total_tests"], rowObj["total_tests_per_thousand"], rowObj["new_tests_per_thousand"],
                    rowObj["new_tests_smoothed"], rowObj["new_tests_smoothed_per_thousand"], rowObj["positive_rate"],
                    rowObj["tests_per_case"], rowObj["tests_units"], rowObj["total_vaccinations"],
                    rowObj["people_vaccinated"], rowObj["people_fully_vaccinated"], rowObj["total_boosters"],
                    rowObj["new_vaccinations"], rowObj["new_vaccinations_smoothed"],
                    rowObj["total_vaccinations_per_hundred"], rowObj["people_vaccinated_per_hundred"],
                    rowObj["people_fully_vaccinated_per_hundred"], rowObj["total_boosters_per_hundred"],
                    rowObj["new_vaccinations_smoothed_per_million"],rowObj["stringency_index"], rowObj["population"],
                    rowObj["population_density"], rowObj["median_age"], rowObj["aged_65_older"], rowObj["aged_70_older"],
                    rowObj["gdp_per_capita"], rowObj["extreme_poverty"], rowObj["cardiovasc_death_rate"],
                    rowObj["diabetes_prevalence"], rowObj["female_smokers"], rowObj["male_smokers"],
                    rowObj["handwashing_facilities"], rowObj["hospital_beds_per_thousand"], rowObj["life_expectancy"],
                    rowObj["human_development_index"], rowObj["excess_mortality_cumulative_absolute"],
                    rowObj["excess_mortality_cumulative"], rowObj["excess_mortality"],
                    rowObj["excess_mortality_cumulative_per_million"])
            }
        }
    })
}

function addRow(iso_code, continent, location, date, total_cases, new_cases, new_cases_smoothed, total_deaths,
                new_deaths, new_deaths_smoothed, total_cases_per_million, new_cases_per_million,
                new_cases_smoothed_per_million, total_deaths_per_million, new_deaths_per_million,
                new_deaths_smoothed_per_million, reproduction_rate, icu_patients, icu_patients_per_million,
                hosp_patients, hosp_patients_per_million, weekly_icu_admissions, weekly_icu_admissions_per_million,
                weekly_hosp_admissions, weekly_hosp_admissions_per_million, new_tests, total_tests,
                total_tests_per_thousand, new_tests_per_thousand, new_tests_smoothed, new_tests_smoothed_per_thousand,
                positive_rate, tests_per_case, tests_units, total_vaccinations, people_vaccinated,
                people_fully_vaccinated, total_boosters, new_vaccinations, new_vaccinations_smoothed,
                total_vaccinations_per_hundred, people_vaccinated_per_hundred, people_fully_vaccinated_per_hundred,
                total_boosters_per_hundred, new_vaccinations_smoothed_per_million, stringency_index, population,
                population_density, median_age, aged_65_older, aged_70_older, gdp_per_capita, extreme_poverty,
                cardiovasc_death_rate, diabetes_prevalence, female_smokers, male_smokers, handwashing_facilities,
                hospital_beds_per_thousand, life_expectancy, human_development_index,
                excess_mortality_cumulative_absolute, excess_mortality_cumulative, excess_mortality,
                excess_mortality_cumulative_per_million){
    let bodyObj = document.getElementById("tbody");
    if (!bodyObj) {
        alert("Body of Table not Exist!");
        return;
    }
    let rowCount = bodyObj.rows.length;
    bodyObj.style.display = ""; // display the tbody
    let newRow = bodyObj.insertRow(rowCount++);
    newRow.insertCell(0).innerHTML = iso_code;
    newRow.insertCell(1).innerHTML = continent;
    newRow.insertCell(2).innerHTML = location;
    newRow.insertCell(3).innerHTML = date;

    newRow.insertCell(4).innerHTML = total_cases;
    newRow.insertCell(5).innerHTML = new_cases;
    newRow.insertCell(6).innerHTML = new_cases_smoothed;
    newRow.insertCell(7).innerHTML = total_deaths;
    newRow.insertCell(8).innerHTML = new_deaths;
    newRow.insertCell(9).innerHTML = new_deaths_smoothed;
    newRow.insertCell(10).innerHTML = total_cases_per_million;
    newRow.insertCell(11).innerHTML = new_cases_per_million;
    newRow.insertCell(12).innerHTML = new_cases_smoothed_per_million;
    newRow.insertCell(13).innerHTML = total_deaths_per_million;
    newRow.insertCell(14).innerHTML = new_deaths_per_million;
    newRow.insertCell(15).innerHTML = new_deaths_smoothed_per_million;

    newRow.insertCell(16).innerHTML = reproduction_rate;
    newRow.insertCell(17).innerHTML = icu_patients;
    newRow.insertCell(18).innerHTML = icu_patients_per_million;
    newRow.insertCell(19).innerHTML = hosp_patients;
    newRow.insertCell(20).innerHTML = hosp_patients_per_million;
    newRow.insertCell(21).innerHTML = weekly_icu_admissions;
    newRow.insertCell(22).innerHTML = weekly_icu_admissions_per_million;
    newRow.insertCell(23).innerHTML = weekly_hosp_admissions;
    newRow.insertCell(24).innerHTML = weekly_hosp_admissions_per_million;

    newRow.insertCell(25).innerHTML = new_tests;
    newRow.insertCell(26).innerHTML = total_tests;
    newRow.insertCell(27).innerHTML = total_tests_per_thousand;
    newRow.insertCell(28).innerHTML = new_tests_per_thousand;
    newRow.insertCell(29).innerHTML = new_tests_smoothed;
    newRow.insertCell(30).innerHTML = new_tests_smoothed_per_thousand;
    newRow.insertCell(31).innerHTML = positive_rate;
    newRow.insertCell(32).innerHTML = tests_per_case;
    newRow.insertCell(33).innerHTML = tests_units;

    newRow.insertCell(34).innerHTML = total_vaccinations;
    newRow.insertCell(35).innerHTML = people_vaccinated;
    newRow.insertCell(36).innerHTML = people_fully_vaccinated;
    newRow.insertCell(37).innerHTML = total_boosters;
    newRow.insertCell(38).innerHTML = new_vaccinations;
    newRow.insertCell(39).innerHTML = new_vaccinations_smoothed;
    newRow.insertCell(40).innerHTML = total_vaccinations_per_hundred;
    newRow.insertCell(41).innerHTML = people_vaccinated_per_hundred;
    newRow.insertCell(42).innerHTML = people_fully_vaccinated_per_hundred;
    newRow.insertCell(43).innerHTML = total_boosters_per_hundred;
    newRow.insertCell(44).innerHTML = new_vaccinations_smoothed_per_million;

    newRow.insertCell(45).innerHTML = stringency_index;
    newRow.insertCell(46).innerHTML = population;
    newRow.insertCell(47).innerHTML = population_density;
    newRow.insertCell(48).innerHTML = median_age;
    newRow.insertCell(49).innerHTML = aged_65_older;
    newRow.insertCell(50).innerHTML = aged_70_older;
    newRow.insertCell(51).innerHTML = gdp_per_capita;
    newRow.insertCell(52).innerHTML = extreme_poverty;
    newRow.insertCell(53).innerHTML = cardiovasc_death_rate;
    newRow.insertCell(54).innerHTML = diabetes_prevalence;
    newRow.insertCell(55).innerHTML = female_smokers;
    newRow.insertCell(56).innerHTML = male_smokers;
    newRow.insertCell(57).innerHTML = handwashing_facilities;
    newRow.insertCell(58).innerHTML = hospital_beds_per_thousand;
    newRow.insertCell(59).innerHTML = life_expectancy;
    newRow.insertCell(60).innerHTML = human_development_index;

    newRow.insertCell(61).innerHTML = excess_mortality_cumulative_absolute;
    newRow.insertCell(62).innerHTML = excess_mortality_cumulative;
    newRow.insertCell(63).innerHTML = excess_mortality;
    newRow.insertCell(64).innerHTML = excess_mortality_cumulative_per_million;
}


