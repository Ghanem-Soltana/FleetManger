Calendar._DN = new Array
("Dimanche",
 "Lundi",
 "Mardi",
 "Mercredi",
 "Jeudi",
 "Vendredi",
 "Samedi",
 "Dimanche");

Calendar._SDN = new Array
("Dim",
 "Lun",
 "Mar",
 "Mar",
 "Jeu",
 "Ven",
 "Sam",
 "Dim");

// First day of the week. "0" means display Sunday first, "1" means display
// Monday first, etc.
Calendar._FD = 0;

// full month names
Calendar._MN = new Array
("Janvier",
 "F&eacute;vrier",
 "Mars",
 "Avril",
 "Mai",
 "Juin",
 "Juillet",
 "Ao&ucirc;t",
 "Septembre",
 "Octobre",
 "Novembre",
 "D&eacute;cembre");

// short month names
Calendar._SMN = new Array
("Jan",
 "Fev",
 "Mar",
 "Avr",
 "Mai",
 "Juin",
 "Juil",
 "Aout",
 "Sep",
 "Oct",
 "Nov",
 "Dec");

// tooltips
Calendar._TT = {};
Calendar._TT["INFO"] = "A propos du calendrier";

Calendar._TT["ABOUT"] =
"1 Utiliser les bouttons \xab, \xbb  pour selectionner l\'annee\n" ;
Calendar._TT["ABOUT1"] =
"2 Utiliser les bouttons " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " pour selectionner les mois" ;
Calendar._TT["ABOUT2"] =
"3 Garder la souris sur n'importe quels boutons pour une selection plus rapide";
Calendar._TT["ABOUT_TIME"] = "" ;
Calendar._TT["PREV_YEAR"] = "Ann&eacute;e pr&eacute;c. (maintenir pour menu)";
Calendar._TT["PREV_MONTH"] = "Mois pr&eacute;c. (maintenir pour menu)";
Calendar._TT["GO_TODAY"] = "Atteindre la date du jour";
Calendar._TT["NEXT_MONTH"] = "Mois suiv. (maintenir pour menu)";
Calendar._TT["NEXT_YEAR"] = "Ann&eacute;e suiv. (maintenir pour menu)";
Calendar._TT["SEL_DATE"] = "S&eacute;lectionner une date";
Calendar._TT["DRAG_TO_MOVE"] = "D&eacute;placer";
Calendar._TT["PART_TODAY"] = " (Aujourd'hui)";

// the following is to inform that "%s" is to be the first day of week
// %s will be replaced with the day name.
Calendar._TT["DAY_FIRST"] = "Afficher %s en premier";

// This may be locale-dependent.  It specifies the week-end days, as an array
// of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
// means Monday, etc.
Calendar._TT["WEEKEND"] = "0,6";

Calendar._TT["CLOSE"] = "Fermer";
Calendar._TT["TODAY"] = "Aujourd'hui";
Calendar._TT["TIME_PART"] = "(Maj-)Clic ou glisser pour modifier la valeur";

// date formats
Calendar._TT["DEF_DATE_FORMAT"] = "%Y-%m-%d";
Calendar._TT["TT_DATE_FORMAT"] = "%a, %b %e";

Calendar._TT["WK"] = "Sem.";
Calendar._TT["TIME"] = "Heure :";
