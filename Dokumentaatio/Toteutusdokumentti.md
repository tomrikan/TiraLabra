# Toteutusdokumentti

## Yleisrakenne
Ohjelma koostuu luokista Game, Player, RpsAi ja DynamicArray. Game-luokassa on käyttöliittymä ja gamelooppi. Player-luokassa on pelaajan toiminnallisuudet ja RpsAi-luokassa on tekoälyn toiminnallisuus. DynamicArray on luokka dynaamiselle taulukolle.

## Aika- ja tilavaativuudet
Ohjelman aikavaativuutta dominoi RpsAi -luokan historyseek -metodi, jossa käydään pahimmassa tapauksessa vastustajan koko liikelista läpi. Aikavaativuus on täten O(n).

## Puutteet ja parannusehdotukset

### Lähteet
