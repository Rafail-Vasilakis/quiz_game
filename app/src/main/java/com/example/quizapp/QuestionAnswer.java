package com.example.quizapp;

public class QuestionAnswer {

    public static String movies_questions[] ={
            "Which actor played the character of Tony Stark in the Marvel Cinematic Universe?",
            "Which movie won the Academy Award for Best Picture in 2020?",
            "Who directed the 2019 film 'Joker'?",
            "Which actor portrayed the character of Neo in the movie 'The Matrix'?"
    };
    public static String movies_questionsgr[] = {
            "Ποιος ηθοποιός υποδύθηκε τον χαρακτήρα του Tony Stark στο Marvel Cinematic Universe;",
            "Ποια ταινία κέρδισε το Βραβείο Καλύτερης Ταινίας στα Όσκαρ του 2020;",
            "Ποιος σκηνοθέτης σκηνοθέτησε την ταινία 'Joker' του 2019;",
            "Ποιος ηθοποιός υποδύθηκε τον χαρακτήρα του Neo στην ταινία 'The Matrix';"
    };

    public static String movies_choices[][] = {
            {"Robert Downey Jr"," Chris Hemsworth"," Chris Evans","Mark Ruffalo"},
            {"Parasite","1917","Joker","The Irishman"},
            {" Christopher Nolan","Martin Scorsese","Todd Phillips"," Quentin Tarantino"},
            {"Keanu Reeves","Tom Cruise"," Leonardo DiCaprio","Brad Pitt"}
    };

    public static String movies_correctAnswers[] = {
            "Robert Downey Jr",
            "Parasite",
            "Todd Phillips",
            "Keanu Reeves"
    };

    public static String game_questions[] ={
            "Which video game franchise features a character named Mario?",
            "Which video game series is developed by Rockstar Games?",
            "In the game 'Fortnite', which of the following is NOT a playable character?",
            "Which video game console is produced by Sony?"
    };

    public static String game_questionsgr[] ={
            "Σε ποια σειρά βιντεοπαιχνιδιών εμφανίζεται ο χαρακτήρας με το όνομα Μάριο;",
            "Ποια σειρά βιντεοπαιχνιδιών αναπτύσσεται από την Rockstar Games;",
            "Στο παιχνίδι 'Fortnite', ποια από τις παρακάτω επιλογές ΔΕΝ είναι διαθέσιμος χαρακτήρας;",
            "Ποια κονσόλα βιντεοπαιχνιδιών παράγεται από την Sony;"
    };


    public static String game_choices[][] = {
            {"The Legend of Zelda","Super Mario","Halo","Grand Theft Auto"},
            {"Assassin's Creed","Call of Duty","Grand Theft Auto","Minecraft"},
            {"John Wick","Spider-Man","Iron Man","Thanos"},
            {"Xbox Series X","Nintendo Switch","PlayStation 5","PC (Personal Computer)"}
    };

    public static String game_correctAnswers[] = {
            "Super Mario",
            "Grand Theft Auto",
            "Spider-Man",
            "PlayStation 5"
    };

    public static String sport_questions[] ={
            "Which player has the most goals in the history of the FIFA World Cup?",
            "Which team has won the most Super Bowl championships in NFL history?",
            "Who holds the record for the most home runs in a single Major League Baseball (MLB) season?",
            "Which tennis player has won the most Grand Slam singles titles?"
    };

    public static String sport_questionsgr[] ={
            "Ποιος παίκτης έχει τα περισσότερα γκολ στην ιστορία του Παγκοσμίου Κυπέλλου της FIFA;",
            "Ποια ομάδα έχει κερδίσει τα περισσότερα πρωταθλήματα Super Bowl στην ιστορία του NFL;",
            "Ποιος κατέχει το ρεκόρ για τα περισσότερα home runs σε μία μόνο σεζόν του Major League Baseball (MLB);",
            "Ποιος τενίστας έχει κερδίσει τα περισσότερα Grand Slam τίτλους στο απλό;"
    };

    public static String sport_choices[][] = {
            {"Cristiano Ronaldo","Lionel Messi","Pele","Diego Maradona"},
            {"New England Patriots","Pittsburgh Steelers","Dallas Cowboys","San Francisco 49ers"},
            {"Babe Ruth","Barry Bonds","Hank Aaron","Sammy Sosa"},
            {"Rafael Nadal","Roger Federer","Serena Williams","Novak Djokovic"}
    };

    public static String sport_correctAnswers[] = {
            "Pele",
            "New England Patriots",
            "Barry Bonds",
            "Roger Federer"
    };

    public static String history_questions[] ={
            "Who was the first President of the United States?",
            "Which famous scientist developed the theory of relativity?",
            "Which ancient civilization built the Great Pyramids of Giza?",
            "What year did World War II end?"
    };

    public static String history_questionsgr[] ={
            "Ποιος ήταν ο πρώτος Πρόεδρος των Ηνωμένων Πολιτειών;",
            "Ποιος διάσημος επιστήμονας ανέπτυξε τη θεωρία της σχετικότητας;",
            "Ποια αρχαία πολιτισμική πολιτεία κατασκεύασε τις Μεγάλες Πυραμίδες της Γκίζας;",
            "Το ποιο έτος τελείωσε ο Β' Παγκόσμιος Πόλεμος;"
    };

    public static String history_choices[][] = {
            {"George Washington","Thomas Jefferson","Abraham Lincoln","John Adams"},
            {"Isaac Newton","Albert Einstein","Galileo Galilei","Nikola Tesla"},
            {"Ancient Greece","Ancient Rome","Ancient Egypt","Ancient China"},
            {"1943","1945","1947","1950"}
    };

    public static String history_correctAnswers[] = {
            "George Washington",
            "Albert Einstein",
            "Ancient Egypt",
            "1945"
    };
}
