function condition_row(){
    let bodyObj = document.getElementById("tbody");
    if (!bodyObj) {
        alert("Body of Table not Exist!");
        return;
    }
    console.log("refreshing...")
    // --- parameters ---
    // 1. continent
    let continent = document.getElementById("chosen_continent").value
    console.log("chosen continent: " + continent.toString())
    // 2. location
    let location = document.getElementById("chosen_location").value
    console.log("chosen location: " + location.toString())
    // 3. date
    let date = document.querySelector('form input[name="input_date"]').value
    console.log("chosen date: " + date.toString())

    for ( let i = 1; i < bodyObj.rows.length; i++ ){
        let row = bodyObj.rows[i]

        // 1. continent
        if ( continent.toString() !== "--" ){
            let continent_temp = row.cells[1].innerHTML
            console.log(continent_temp.toString())
            if ( continent_temp.toString() === continent.toString() ) {
                row.style.display = ""
            }
            else row.style.display = "none"
        }
        // 2. location
        if ( location.toString() !== "--" ){
            let location_temp = row.cells[2].innerHTML
            console.log(location_temp.toString())
            if ( location_temp.toString() === location.toString() ) {
                row.style.display = ""
            }
            else row.style.display = "none"
        }
        // 3. date
        if ( validateInput(date) ) {
            let date_temp = row.cells[3].innerHTML
            console.log(date_temp.toString())
            if ( date_temp.toString() === date.toString() ) {
                row.style.display = ""
            }
            else row.style.display = "none"
        }
    }
}

function validateInput(date) {
    let date_regex = new RegExp(/^[0-9]{4}-[0-9]{2}-[0-9]{2}$/);
    if ( !date_regex.test(date) ){
        console.log("Invalid date input")
        return false
    }
    return true;
}