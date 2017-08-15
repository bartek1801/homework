package datastructures;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by bartek on 08.08.2017.
 */
public class BookCollections {

    // zwraca książki z kolekcji books które zostały napisane przez zadanego autora
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByAuthor(Collection<Book> books, Person author){
        Collection<Book> newBooks = new LinkedList<>();

        for(Book item : books){
            if(item.getAuthor().equals(author))
                newBooks.add(item);
        }
        return newBooks;
    }

    // zwraca książki z kolekcji books których tytuł zaczyna się od zadanej frazy,
    // wielkość liter nie ma znaczenia
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByTitle(Collection<Book> books, String phrase) {
        Collection<Book> newBooks =  new LinkedList<>();

        for (Book item : books) {
            String itemTitle = item.getTitle().toLowerCase();
            for (int i = 0; i < phrase.length(); i++) {
                if (phrase.toLowerCase().charAt(i) == itemTitle.charAt(i)){
                    continue;
                }
                else
                    break;
            }
            newBooks.add(item);
        }

        return newBooks;//TODO sprobuj iteratorem
    }

    // zwraca książki z kolekcji books które należą do wszystkich zadanych gatunków
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByGenres(Collection<Book> books, Set<Genre> genres) {
        Collection<Book> genresBooks = new LinkedList<>();
        for (Book item : books){
            if (genres.containsAll(item.getGenres()))
                genresBooks.add(item);
        }
        return genresBooks;
    }

    // zwraca posortowaną rosnąco po tytule listę książek stworzoną z kolekcji books
    // NIE modyfikuje kolekcji books!
    public static List<Book> sortByTitle(Collection<Book> books) {
        List<Book> newList = new ArrayList<>(books);

        newList.sort(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });
        return newList;
    }

    // zwraca posortowaną rosnąco listę książek z kolekcji books po nazwisku, imieniu autora i
    // po tytule
    // NIE modyfikuje kolekcji books!
    public static List<Book> sortByAuthorAndTitle(Collection<Book> books) {
        List<Book> newList = new ArrayList<>(books);

        newList.sort(new Comparator<Book>() {
            private static final int LAST_NAME_PRIORITY = 100;
            private static final int FIRST_NAME_PRIORITY = 10;
            private static final int TITLE_PRIORITY = 1;

            @Override
            public int compare(Book b1, Book b2) {
                int lastNameComparator = b1.getAuthor().getLastName().compareTo(b2.getAuthor().getLastName());
                int firstNameComparator = b1.getAuthor().getFirstName().compareTo(b2.getAuthor().getFirstName());
                int titleComparator = b1.getTitle().compareTo(b2.getTitle());
                return lastNameComparator * LAST_NAME_PRIORITY + firstNameComparator * FIRST_NAME_PRIORITY
                        + titleComparator * TITLE_PRIORITY;
            }
        });

        return newList;
    }

    //tworzy mapę książek należących do poszczególnych gatunków, jeśli ksiżąka należy
    //do wielu gatunków, powinna wiele razy występować na mapie
    public static Map<Genre, Collection<Book>> genresMap(Collection<Book> books) {
        return null; //TODO
    }

    //tworzy mapę książek należących napisanych przez poszczególnych autorów
    public static Map<Person, Collection<Book>> authorsMap(Collection<Book> books) {
        Collection<Book> booksOfAuthor = new ArrayList<>();
        Map<Person, Collection<Book>> mapOfBooks = new HashMap<>();

        /*for (Book item : books){
             Collection<Book> current =  mapOfBooks.get(item.getAuthor());

            if (current.equals(null))
                mapOfBooks.put(item.getAuthor(), Arrays.asList(new Book(item.getTitle(), item.getAuthor(),item.getGenres())));
            else
                mapOfBooks.put(item.getAuthor(), Arrays.asList(item));
        }*/
        return mapOfBooks; //TODO
    }

    //tworzy mapę z ilością książek napisanych przez zadanego autora
    public static Map<Person, Integer> authorsBookCountMap(Collection<Book> books) {
        Map<Person, Integer> booksCount = new HashMap<>();

        for (Book item : books){
            Integer currentCount = booksCount.get(item.getAuthor());
            if (currentCount == null)
                booksCount.put(item.getAuthor(), 1);
            else
                booksCount.put(item.getAuthor(), currentCount + 1);
        }
        return booksCount;
    }

    // zwraca liczbę książek których autorem jest auhtor
    public static int booksCount(Collection<Book> books, Person author) {
        int booksCounter = 0;
        for (Book item : books){
            if (item.getAuthor().equals(author))
                booksCounter++;
        }
        return booksCounter;
    }

    // zwraca liczbę książek z danego gatunku
    public static int booksCount(Collection<Book> books, Genre genre) {
        int counter = 0;
        for (Book item : books){
            if (item.hasGenre(genre))
                counter++;
        }
        return counter;
    }


    // zwraca autora który napisał najwięcej książek
    public Person bestAuthor(Collection<Book> books) {

        for (Book item : books){

        }

        return null;
    }

    // zwraca gatunek który ma najwięcej książek
    public Genre mostPopularGenre(Collection<Book> books) {
        return null;
    }


    public static void main(String[] args) {
        Set<Genre> otherGenres = new HashSet<>();

        Person martin = new Person("George R.R.", "Martin", 68);
        Person puzo = new Person("Mario", "Puzo", 70);
        Person sienkiewicz = new Person("Henryk", "Sienkiewicz", 80);

        otherGenres.add(Genre.FANTASY);
        Book b1 = new Book("A Game of throne", martin ,  otherGenres);
        otherGenres.remove(Genre.FANTASY);
        otherGenres.add(Genre.DRAMA);
        Book b2 = new Book("A Family Corleone", puzo , otherGenres );
        otherGenres.remove(Genre.DRAMA);
        otherGenres.add(Genre.FANTASY);
        Book b3 = new Book("A Clash of Kings", martin, otherGenres);
        otherGenres.remove(Genre.FANTASY);
        otherGenres.add(Genre.DRAMA);
        Book b4 = new Book("God father", puzo , otherGenres);
        otherGenres.remove(Genre.DRAMA);
        otherGenres.add(Genre.FANTASY);
        Book b5 = new Book("A Storm of Swords", martin , otherGenres);
        otherGenres.remove(Genre.FANTASY);
        otherGenres.add(Genre.HISTORICAL);
        otherGenres.add(Genre.REALISTIC);
        Book b6 = new Book("Potop", sienkiewicz , otherGenres);


        Collection<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);

        System.out.println("=================findByAuthor================");

        Collection<Book> authorsBooks = findByAuthor(books, martin);
        for (Book item : authorsBooks){
            System.out.println(item.toString());
        }

        System.out.println("=================findByTitle================");

        Collection<Book> booksFindByTitle = findByTitle(books, "A Game");
        for (Book item : booksFindByTitle){
            System.out.println(item.toString());
        }

        System.out.println("=================findByGenre================");

        Set<Genre> genresToFind = new HashSet<>();
        genresToFind.add(Genre.HISTORICAL);
        genresToFind.add(Genre.REALISTIC);
        Collection<Book> booksFindByGenres = findByGenres(books, genresToFind);
        for (Book item : booksFindByGenres){
            System.out.println(item.toString());
        }


        System.out.println("================sortByTitle=================");
        List<Book> booksSortedByTitle = sortByTitle(books);

        for (Book item : booksSortedByTitle){
            System.out.println(item.toString());
        }

        System.out.println("=============sortByAuthorAndTitle====================");
        List<Book> sortedBooks = sortByAuthorAndTitle(books);

        for (Book item : sortedBooks){
            System.out.println(item.toString());
        }

       /* System.out.println("===============authorsMap==================");
        Map<Person, Collection<Book>> mapOfAuthors = authorsMap(books);

        for (Map.Entry<Person, Collection<Book>> item : mapOfAuthors.entrySet()){
            System.out.println("Author: " + item.getKey().toString() + "Books" + item.getValue().toString());
        }*/

        System.out.println("================authorsBookCountMap=================");
        Map<Person, Integer> booksMap = authorsBookCountMap(books);

        for (Map.Entry<Person, Integer> item : booksMap.entrySet()){
            System.out.println( "Author: "  + item.getKey().getFirstName() + " " + item.getKey().getLastName() +
                    " - count of books: " + item.getValue());
        }

        System.out.println("===============booksCount==================");
        System.out.println(martin.getFirstName() + " " + martin.getLastName() + " - count of books: " + booksCount(books, martin));
        System.out.println(puzo.getFirstName() + " " + puzo.getLastName() + " - count of books: " + booksCount(books, puzo));
        System.out.println(sienkiewicz.getFirstName() + " " + sienkiewicz.getLastName() + " - count of books: " + booksCount(books, sienkiewicz));


        System.out.println("===============booksCount-genre==================");
        System.out.println("Count of FANTASY books is: " + booksCount(books, Genre.FANTASY));
    }

}