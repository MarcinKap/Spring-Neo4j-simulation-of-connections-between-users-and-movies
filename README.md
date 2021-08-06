English:

The purpose of the project was to create a system supporting the offering of films to users. 
The implemented functions include:
    1.Possibility to create users, videos and categories.  
    2.Each movie has the option of creating a relationship with a category (relationship: MOVIE_TYPE).  
    3.Each user can create a relationship with the movie (relationship: VIEWED), it is possible to delete this relationship.  
    4.Each user has the possibility to create a relationship with another user (relationship: FRIEND).  
    5.Based on the videos watched, the user searches for films of the same category that were watched by his friends.  
    6.People the user may know based on their friends are searched for.  

The project was created on database Neo4j 3.5.18 version. When enabling the project, you should use the database version 3.5 due to the Java project libraries, which allow the connection between the code and the database on this version. 
I used Java and the Spring framework to write the code. Database operations are performed using the “org.springframework.data.neo4j.annotation” library and @Query annotation which directs queries directly to the database. 

Polski:

Celem projektu było utworzenie systemu wspomagającego proponowanie filmów użytkownikom. 
Jednymi z zaimplementowanych funkcji są:
    1. Możliwość stworzenia użytkowników, filmów oraz kategorii.  
    2. Każdy film ma możliwośd stworzenia relacji z kategorią (relacja: MOVIE_TYPE).  
    3. Każdy użytkownik ma możliwośd stworzenia relacji z filmem (relacja: VIEWED), jest możliwośd usunięcia tej relacji.  
    4. Każdy użytkownik ma możliwośd stworzenia relacji z innym użytkownikiem (relacja: FRIEND).  
    5. Na podstawie oglądniętych filmów przez użytkownika wyszukiwane są filmy o tej samej kategorii, które oglądali jego znajomi.  
    6. Wyszukiwane są osoby, które może znać użytkownik na podstawie znajomych.  

Projekt został stworzony na bazie wersji Neo4j 3.5.18 i na wersji 3.5 powinien być włączany jest to związane z bibliotekami projektu Javy, które pozwalają na połączenie między kodem i bazą danych. Do napisania kodu wykorzystałem język Java oraz framework Spring. Operacje na bazie danych wykonywane są przy pomocy biblioteki “org.springframework.data.neo4j.annotation” i adnotacji @Query która zapytania kieruje prosto do bazy danych.




