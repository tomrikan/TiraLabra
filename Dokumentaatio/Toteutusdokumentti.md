# Toteutusdokumentti

## Yleisrakenne
Ohjelma koostuu luokista Game, Player, RpsAi ja DynamicArray. Game-luokassa on käyttöliittymä ja gamelooppi. Player-luokassa on pelaajan toiminnallisuudet ja RpsAi-luokassa on tekoälyn toiminnallisuus. DynamicArray on luokka dynaamiselle taulukolle.

## Aika- ja tilavaativuudet
Ohjelman aikavaativuutta dominoi RpsAi -luokan historyseek -metodi, jossa käydään pahimmassa tapauksessa vastustajan koko liikelista läpi. Aikavaativuus on täten O(n). Tilavaativuus on vakio.

## Puutteet ja parannusehdotukset
HistorySeek -metodissa voisi katsoa samanaikaisesti pelaajan ja tekoälyn liikehistoriaa ja vetää johtopäätökset näistä sen sijaan, että katsotaan vain pelaajan historiaa. Olisi hyvä saada jollain tavalla yhdistettyä markovin ketjuun perustuva ja liikehistoriaan perustuva liikkeen määrittäminen sen sijaan, että käytetään molempia vuorotellen. Voitaisiin varmaan vertailla todennäköisyyksiä ja valita liike sen mukaan, kummalla tavalla saataisiin todennäköisemmin voittava liike. Tällä hetkellä tekoäly ei reagoi tarpeeksi nopeasti jos pelaaja alkaa monen erän jälkeen valitsee jatkuvasti tietyn liikkeen, koska todennäköisyydet. Tälle tulisi tehdä jokin reaktiomekanismi.

### Lähteet
Katso määrittelydokumentti.
