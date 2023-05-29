package com.example.kolo_fortuny.password;

import java.util.List;

public class WordList {
//    wywalić polskie znaki
    private static List<String> WORDS = List.of(
            "Co nagle to po diable.",
            "Czego Jas sie nie nauczy tego Jan nie bedzie umial",
            "Gdzie kucharek szesc tam nie ma co jesc",
            "Gdzie raki zimuja tam woda nie zamarza",
            "Kto mieczem wojuje od miecza ginie",
            "Lepszy wróbel w garsci niz golab na dachu",
            "Nie chwal dnia przed zachodem slonca",
            "Nie wszystko zloto co sie swieci",
            "Od zawsze ciernie maja kolce",
            "Pieniadz szczescia nie daje",
            "Prawdziwych przyjaciól poznaje sie w biedzie",
            "Slowo sie rzeklo konca niema",
            "Szukajcie a znajdziecie",
            "Wszystko jest dla ludzi",
            "Zawsze chodzi o to samo",
            "Zmienic cos na lepsze",
            "Bez pracy nie ma kolaczy",
            "Darowanemu koniowi w zeby sie nie zaglada",
            "Kto nie ryzykuje ten nie ma nic"
    );

    public static List<String> getWORDS() {
        return WORDS;
    }
}
