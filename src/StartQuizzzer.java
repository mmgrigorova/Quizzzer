import game.ClosedQuestion;
import game.GameLauncher;
import users.Player;

import java.util.*;
import java.io.*;
import game.*;

public class StartQuizzzer {
    public static void main(String[] args) throws IOException {
        //initializer();
        GameLauncher launcher = new GameLauncher();
        launcher.start();
    

    }

    private static void initializer() throws IOException {
        QuestionCategory st = QuestionCategory.HIST;
        System.out.println(st.toString());

        Player p = new Player("Johny");

        for (QuestionCategory q : p.getAnsweredQuestions().keySet()) {
            System.out.println(q + " " + p.getAnsweredQuestions().get(q));
        }

        ArrayList<Question> list = new ArrayList<>();


        FileOutputStream f = null;
        ObjectOutputStream o = null;
        f = new FileOutputStream("Players.txt");
        o = new ObjectOutputStream(f);

        Player p1 = new Player("Yasen");
        Player p2 = new Player("Masha");

        o.writeObject(p1);
        o.writeObject(p2);
        f.close();
        o.close();

        f = new FileOutputStream("Questions.txt");
        o = new ObjectOutputStream(f);

        //sports questions
        Question q = new ClosedQuestion("Which country won the 2014 FIFA World Cup?", QuestionCategory.SPORTS,
                "Brazil", "Germany", "Italy", "Spain", 2);
        Question q1 = new ClosedQuestion("Which country won the first ever soccer World Cup in 1930?", QuestionCategory.SPORTS,
                "Uruguay", "Brazil", "Germany", "Russia", 1);
        Question q2 = new ClosedQuestion("Name the European club David Beckham ended his career with?", QuestionCategory.SPORTS,
                "Paris Saint-Germain", "Manchester United", "Barcelona", "Levski Sofia", 1);
        Question q3 = new ClosedQuestion("The American basketball team ‘The Bulls’, represent which city?", QuestionCategory.SPORTS,
                "Boston", "Chicago", "Detroit", "New York", 2);
        Question q4 = new ClosedQuestion("Jan-Ove Waldner, Zhang Jike and Deng Yaping have been noteable players in which sport?", QuestionCategory.SPORTS,
                "Volleyball", "Gymnastics", "Swimming", "Table tennis", 4);
        Question q5 = new ClosedQuestion("Of what nationality is tennis player Novak Djokovic? ", QuestionCategory.SPORTS,
                "Croatian", "Bosnian", "Serbian", "American", 3);
        Question q6 = new ClosedQuestion("Wladimir Klitschko is a champion boxer from which country?", QuestionCategory.SPORTS,
                "Russia", "Ukraine", "Germany", "Poland", 2);
        Question q7 = new ClosedQuestion("Which male tennis player has won the most Grand Slams", QuestionCategory.SPORTS,
                "Rafael Nadal", "Andy Murray", "Roger Federer", "Grigor Dimitrov", 3);
        Question q8 = new ClosedQuestion("Who won the men’s single at Wimbledon in 1985 at the age of just 17?", QuestionCategory.SPORTS,
                "Andre Agassi", "Roger Federer", "Boris Becker", "Pete Sampras", 3);
        Question q9 = new ClosedQuestion("How is soccer player Edson Arantes do Nascimento better known?", QuestionCategory.SPORTS,
                "Ronaldo", "Pele", "Ronaldinho", "Rafinha", 2);

        Question q10 = new OpenQuestion("In which year was the first ever FIFA World Cup played?", 1930, QuestionCategory.SPORTS);
        Question q11 = new OpenQuestion("In which year did Lionel Messi won his first Ballon d'Or?", 2009, QuestionCategory.SPORTS);
        Question q12 = new OpenQuestion("How many NBA championships did Michael Jordan win with the Chicago Bulls?", 6, QuestionCategory.SPORTS);
        Question q13 = new OpenQuestion("In 1997, Tiger Woods became the youngest golfer at the time to win the Masters, how old was he?", 21, QuestionCategory.SPORTS);
        Question q14 = new OpenQuestion("In what year were women first allowed to participate in the modern Olympic games?", 1900, QuestionCategory.SPORTS);
        Question q15 = new OpenQuestion("What is the maximum number of clubs a golfer is allowed in his or her bag in a round of golf?", 14, QuestionCategory.SPORTS);
        Question q16 = new OpenQuestion("How many minutes long is a hockey match?", 70, QuestionCategory.SPORTS);
        Question q17 = new OpenQuestion("What was David Beckham's squad number in his first World Cup?", 7, QuestionCategory.SPORTS);
        Question q18 = new OpenQuestion("What is a perfect score in bowling?", 300, QuestionCategory.SPORTS);
        Question q19 = new OpenQuestion("How many times has Brazil won the FIFA World Cup?", 5, QuestionCategory.SPORTS);


        // history questions

        Question q20 = new ClosedQuestion("Who was president of the United States when the nuclear bombs were droped over Hyroshima and Nagasaki?", QuestionCategory.HIST,
                "Franklin D Roosewelt", "Gerald Ford", "Richard Nixon", "Harry S Truman", 4);
        Question q21 = new ClosedQuestion("Which nation is a direct descendant of the Roman Empire?", QuestionCategory.HIST,
                "Italy", "Germany", "Greece", "Zimbabwe", 1);
        Question q22 = new ClosedQuestion("What is the main reason as to why upon the Holy Lands there was no and the is no peace to this day?", QuestionCategory.HIST,
                "Politics", "Religion", "Natural resources", "Corruption", 1);
        Question q23 = new ClosedQuestion("Whose side was Bulgaria on during most of the WW2?", QuestionCategory.HIST,
                "Russia", "Germany", "USA", "Uganda", 2);
        Question q24 = new ClosedQuestion("Liberty, equality, fraternity\" was the moto of the:", QuestionCategory.HIST,
                "American revolution", "French Revolution", "Iranian Revolution", "Russian revolution", 2);
        Question q25 = new ClosedQuestion("Whose words were these : \"History is a bunch of lies, agreed upon\"?", QuestionCategory.HIST,
                "Emperor Neron", "Stalin", "JFK", "Napoleon", 4);
        Question q26 = new ClosedQuestion("What language is the Bible written in?", QuestionCategory.HIST,
                "Arameic(Antient arabic) and Greek", "Greek and Latin", "Chinese", "Latin and Greek", 1);
        Question q27 = new ClosedQuestion("What ethnicity was Aleksander The Great(Makedonski)?", QuestionCategory.HIST,
                "Greek", "Bulgarian", "Turk", "Viking", 1);
        Question q28 = new ClosedQuestion("Who invented the concrete?", QuestionCategory.HIST,
                "The Vikings", "The Romans", "The Arabs", "Japanese", 2);
        Question q29 = new ClosedQuestion("Which was the only country in the world to save its citizen of jewish descend from Hitler's gas chambers?", QuestionCategory.HIST,
                "Hungary", "Poland", "France", "Bulgaria", 4);

        Question q30 = new OpenQuestion("Krum was a bulgarian leader known to have Byzantine Emperor Nikephoros skull made to a glass from which he drank.\n" +
                "What was the year at which his reign over Bulgaria started?", 803, QuestionCategory.HIST);
        Question q31 = new OpenQuestion("What was the year when Nazi Germany invaded Poland - the WW2 brake out?", 1939, QuestionCategory.HIST);
        Question q32 = new OpenQuestion("What was the year of the Bulgarian Declaration of Independence?", 1908, QuestionCategory.HIST);
        Question q33 = new OpenQuestion("Which century was Bulgaria founded?", 7, QuestionCategory.HIST);
        Question q34 = new OpenQuestion("What was the year when USA landed its spaceship with astronauts on the moon?", 1969, QuestionCategory.HIST);
        Question q35 = new OpenQuestion("When was the first time a human - the russian Juri Gagarin flew in outer space?", 1961, QuestionCategory.HIST);
        Question q36 = new OpenQuestion("The Cuban Missile Crisis was a period of two weeks when the world was at its closest to a global nuclear war?\n" +
                "What was the year of it?", 1962, QuestionCategory.HIST);
        Question q37 = new OpenQuestion("United States of America had a fresh start without holding a centuries old grudges like old european states. When was it founded?", 1776, QuestionCategory.HIST);
        Question q38 = new OpenQuestion("Pythagoras ws an ancient greek philosopher and mathematician. What century BC was he born?", 6, QuestionCategory.HIST);
        Question q39 = new OpenQuestion("How many times was the pope a woman?", 1, QuestionCategory.HIST);

        list.add(q);
        list.add(q1);
        list.add(q2);
        list.add(q3);
        list.add(q4);
        list.add(q5);
        list.add(q6);
        list.add(q7);
        list.add(q8);
        list.add(q9);
        list.add(q10);
        list.add(q11);
        list.add(q12);
        list.add(q13);
        list.add(q14);
        list.add(q15);
        list.add(q16);
        list.add(q17);
        list.add(q18);
        list.add(q19);

        list.add(q20);
        list.add(q21);
        list.add(q22);
        list.add(q23);
        list.add(q24);
        list.add(q25);
        list.add(q26);
        list.add(q27);
        list.add(q28);
        list.add(q29);
        list.add(q30);
        list.add(q31);
        list.add(q32);
        list.add(q33);
        list.add(q34);
        list.add(q35);
        list.add(q36);
        list.add(q37);
        list.add(q38);
        list.add(q39);

        Question q40 = new ClosedQuestion("Which is the capital of Australia?", QuestionCategory.GEO,
                "Sofia", "Sidney", "Canberra", "Ottawa", 3);
        Question q41 = new ClosedQuestion("Where do polar bears reside?", QuestionCategory.GEO,
                "Arctic region plus some northern countries ", "South Pole along with the penguins", "Siberia", "South Africa", 1);
        Question q42 = new ClosedQuestion("Which is the highest waterfall in the world?", QuestionCategory.GEO,
                "Niagara Falls(USA/Canad)", "Angel Falls(Venezuela)", "Victoria Falls(Zambia/Zimbabwe)", "Raisko praskalo(Bulgaria)", 2);
        Question q43 = new ClosedQuestion("Which is/are the first countrie/s to celebrate the New Year?", QuestionCategory.GEO,
                "Samoa, Tonga, Kiribati", "Japan", "Chile, Easter Islands", "New Zealand", 1);
        Question q44 = new ClosedQuestion("Which continent has the most countries?", QuestionCategory.GEO,
                "Asia", "Africa", "Europe", "South America", 2);
        Question q45 = new ClosedQuestion("Which is the biggest country in the world?", QuestionCategory.GEO,
                "Canada", "China", "USA", "Russia", 4);
        Question q46 = new ClosedQuestion("Which is the largest freshwater lake in the world?", QuestionCategory.GEO,
                "Caspian sea", "Pancharevo", "Lake Baikal", "Lake Victoria", 3);
        Question q47 = new ClosedQuestion("Where is Dead Sea?", QuestionCategory.GEO,
                "Between Jordan, Israel and Palestine", "Between Uganda and Tanzania", "Between Saudi Arabia and Yemen", "Namibia", 1);
        Question q48 = new ClosedQuestion("Which is the largest ocean in the world?", QuestionCategory.GEO,
                "Indian ocean", "Pacific ocean", "Atlantic ocean", "Arctic ocean", 2);
        Question q49 = new ClosedQuestion("Which is the capital of Brazil?", QuestionCategory.GEO,
                "Sao Paulo", "Rio de Janeiro", "Brasilia", "Bucharest", 3);

        Question q50 = new OpenQuestion("How many countries are there in the European Union?", 28, QuestionCategory.GEO);
        Question q51 = new OpenQuestion("What is the highest temperature ever measured(in celsius)?", 58, QuestionCategory.GEO);
        Question q52 = new OpenQuestion("What is the absolute zero(0 Kelvin scale) at which no thermal energy is present and you can't go lower/colder than that?", 273, QuestionCategory.GEO);
        Question q53 = new OpenQuestion("What is the altitude of peak Everest in the Himalayas in meters?", 8848, QuestionCategory.GEO);
        Question q54 = new OpenQuestion("What is the altitude of Bulgaria's highest peak Musala in  meters?", 2925, QuestionCategory.GEO);
        Question q55 = new OpenQuestion("How many years ago(in millions) did the dinosaurs perish?", 66, QuestionCategory.GEO);
        Question q56 = new OpenQuestion("How many Great Lakes are there(North America)?", 5, QuestionCategory.GEO);
        Question q57 = new OpenQuestion("The United Kingdom is comprised of how many countries", 4, QuestionCategory.GEO);
        Question q58 = new OpenQuestion("What is the approximate size(in thousands) of Earth's equator?", 40, QuestionCategory.GEO);
        Question q59 = new OpenQuestion("What is the approximate population of Germany(in millions)?", 82, QuestionCategory.GEO);

        list.add(q40);
        list.add(q41);
        list.add(q42);
        list.add(q43);
        list.add(q44);
        list.add(q45);
        list.add(q46);
        list.add(q47);
        list.add(q48);
        list.add(q49);
        list.add(q50);
        list.add(q51);
        list.add(q52);
        list.add(q53);
        list.add(q54);
        list.add(q55);
        list.add(q56);
        list.add(q57);
        list.add(q58);
        list.add(q59);

        Question q60 = new ClosedQuestion("What would you say a compiler is?", QuestionCategory.TECH,
                "A tester",
                "A developer",
                "A program",
                "An operator", 3);
                Question q61 = new ClosedQuestion("The imitation of one device or system by another is called: ", QuestionCategory.TECH,
                "Simulation",
                "Emulation",
                "Resilience", "Compactions", 2);
        Question q62 = new ClosedQuestion("What animal is drawn on the logo of the Firefox browser?", QuestionCategory.TECH,
                "A cat",
                "A fox",
                "A red panda",
                "A bear", 3);
        Question q63 = new ClosedQuestion("Which person has been featured on the first Apple logo?", QuestionCategory.TECH,
                "Sir Isaac Newton",
                "Steve Jobs",
                "Steve Wozniak",
                "There was never a person on the logo", 1);
        Question q64 = new ClosedQuestion("Which person has been featured on the first Apple logo?", QuestionCategory.TECH,
                "Sir Isaac Newton",
                "Steve Jobs",
                "Steve Wozniak",
                "There was never a person on the logo", 1);
        Question q65 = new ClosedQuestion("Which American state can be typed using only one row of the QWERTY keyboard?", QuestionCategory.TECH,
                "Miami",
                "Texas",
                "New York",
                "Alaska", 4);
        Question q66 = new ClosedQuestion("How was Amazon.com previously known?", QuestionCategory.TECH,
                "Alibaba.com",
                "Cadabra.com",
                "Magic.com",
                "Esell.com", 2);
        Question q67 = new ClosedQuestion("What's the name of Apple's virtual assistant?", QuestionCategory.TECH,
                "Alexa",
                "Cortana",
                "Braina",
                "Siri", 4);
        Question q68 = new ClosedQuestion("Which country in the world has maximum number of robots working?", QuestionCategory.TECH,
                "USA",
                "China",
                "Japan",
                "India", 3);
        Question q69 = new ClosedQuestion("Which of the following is NOT an operating system?", QuestionCategory.TECH,
                "Windows 10",
                "iMac",
                "Free BSD",
                "Ubuntu", 2);



        Question q70 = new OpenQuestion("When has the first VCR been created?", 1956, QuestionCategory.TECH);
        Question q71 = new OpenQuestion("How many year took for the radio to reach a market audience of 50 million?", 38, QuestionCategory.TECH);
        Question q72 = new OpenQuestion("In what yeas has the first computer mouse been invented?", 1964, QuestionCategory.TECH);
        Question q73 = new OpenQuestion("When was the very first domain name (www.symbolitics.com) registered?", 1985, QuestionCategory.TECH);
        Question q74 = new OpenQuestion("In what year did the first banner advertising appear?", 1994, QuestionCategory.TECH);

        list.add(q60);
        list.add(q61);
        list.add(q62);
        list.add(q63);
        list.add(q64);
        list.add(q65);
        list.add(q66);
        list.add(q67);
        list.add(q68);
        list.add(q69);
        list.add(q70);
        list.add(q71);
        list.add(q72);
        list.add(q73);
        list.add(q74);


        for (Question quest : list) {
            o.writeObject(quest);
        }

        f.close();
        o.close();



    }
}