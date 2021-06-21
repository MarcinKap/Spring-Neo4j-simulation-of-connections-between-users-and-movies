Celem projektu było utworzenie systemu wspomagającego proponowanie filmów użytkownikom. 
Jednymi z zaimplementowanych funkcji są:
1. Możliwość stworzenia użytkowników, filmów oraz kategorii.
2. Każdy film ma możliwośd stworzenia relacji z kategorią (relacja: MOVIE_TYPE)
3. Każdy użytkownik ma możliwośd stworzenia relacji z filmem (relacja: VIEWED), jest możliwośd usunięcia tej relacji
4. Każdy użytkownik ma możliwośd stworzenia relacji z innym użytkownikiem (relacja: FRIEND)
5. Na podstawie oglądniętych filmów przez użytkownika wyszukiwane są filmy o tej samej kategorii, które oglądali jego znajomi.
6. Wyszukiwane są osoby, które może znać użytkownik na podstawie znajomych. 

Projekt został stworzony na bazie wersji Neo4j 3.5.18 i na wersji 3.5 powinien być włączany jest to związane z bibliotekami projektu Javy, które pozwalają na połączenie między kodem i bazą danych. Do napisania kodu wykorzystałem język Java oraz framework Spring. Operacje na bazie danych wykonywane są przy pomocy biblioteki “org.springframework.data.neo4j.annotation” i adnotacji @Query która zapytania kieruje prosto do bazy danych.
