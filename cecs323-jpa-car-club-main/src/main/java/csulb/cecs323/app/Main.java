package csulb.cecs323.app;
import csulb.cecs323.model.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
class JPAException extends Exception
{
    public JPAException(String message)
    {
        super(message);
    }
}

public class Main {
    public static Scanner in = new Scanner(System.in);

    // private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Main");
    //private static EntityManager entityManager = emf.createEntityManager();

    public static List<Publishers> publishers = new ArrayList<Publishers>();
    public static List<Authoring_Entities> authoringEntities = new ArrayList<>();
    public static List<Books> books = new ArrayList<Books>();

    public static void main(String[] args) {

        //Create an instance of Main to call other functions
        Main JPABooks = new Main();
        //Main menu of JPABooks Program
        while (true) {

            //em.getTransaction().begin();
            System.out.println("------------------------JPA Books Menu Program------------------------");
            System.out.println("1. Add Authoring Entity");
            System.out.println("2. Add a Publisher");
            System.out.println("3. Add Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Update Book");
            System.out.println("6. List Primary Key");
            System.out.println("7. List Info of Objects");
            System.out.println("0. Quit Program");
            System.out.println("------------------------JPA Books Menu Program------------------------");
            int choice = 0;
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    JPABooks.authoring_entity();
                    break;
                case 2:
                    JPABooks.publisher_entity();
                    break;
                case 3:
                    JPABooks.addBook();
                    break;
                case 4:
                    JPABooks.deleteBook();
                    break;
                case 5:
                    JPABooks.updateBook();
                    break;
                case 6:
                    // JPABooks.listPrimaryKeys();
                    break;
                case 7:
                    JPABooks.listInfoObjects();
                    break;
                case 0:
                    System.out.println("----------------Ending JPABooks Program----------------");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice please try again...");
                    System.exit(0);
                    break;
            }
            //em.getTransaction().commit();
        /*
        //Publishers ae = new Publishers();
        //add a new publisher
        //Publishers ae =
        //ae.setPhone("9107237322");
        //ae.setEmail("2stuff@gmail.com");
        //ae.setName("Brian");

        //em.getTransaction().begin();
        //em.persist(ae);
        //em.getTransaction().commit();

        //Writing_Group wg = new Writing_Group("2test@gmail.com", "", "Mike smith", "Tim wall", 1994);
        // ia = new Individual_Author("3test@gmail.com", "", "Mike smith", "Tim wall", 1994);
        //Ad_Hoc_team aot = new Ad_Hoc_team("6test@gmail.com", "", "Mike smith", "Tim wall", 1994);

        publishers.add(new Publishers("Curtis", "9107237312", "1stuff@gmail.com"));

        Books bk = new Books("123123123", "Star wars", 1971, publishers.get(0),ia   );
        em.getTransaction().begin();
        //adding a member to a hoc team
        //aot.addIndividualAuthor(ia);
        em.persist(bk);
        em.getTransaction().commit();

        em.close();
        emf.close();
        */
        }

        //Example SQL Native Query
        //@NamedNativeQuery(
        //        name="ReturnAutoBodyStyle",
        //        query = "SELECT * " +
        //                "FROM   AUTO_BODY_STYLES " +
        //                "WHERE  name = ? ",
        //        resultClass = auto_body_styles.class
        //)
    }

    public void authoring_entity() {
        //enitity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Main");
        EntityManager em = emf.createEntityManager();

        System.out.println("1. Add Writing Group 2. Add Individual Author 3. Add AD HOC Team 4. Add Author to existing Ad Hoc Team");
        int choice = in.nextInt();
        in.nextLine();
        switch (choice) {
            case 1: {
                //String email, String authoring_entity_type, String name, String head_writer, int year_formed
                System.out.println("Adding new Writing Group");
                System.out.println("Enter Email: ");
                String groupEmail = in.nextLine();

                System.out.println("Enter Name of Group: ");
                String groupName = in.nextLine();

                System.out.println("Enter Name of Head Writer: ");
                String headWriter = in.nextLine();

                System.out.println("Enter the year the Writing Group was formed: ");
                int yrFormed = in.nextInt();

                for (Authoring_Entities next : authoringEntities) {
                    if (next.getAuthoring_entity_type().equals("Writing Group")) {
                        try {
                            throw new JPAException("Cant add duplicated email");
                        } catch (JPAException e) {
                            System.out.println("Caught inside of authoring_entities case 1");
                        }
                    }

                }
                Writing_Group wg = new Writing_Group(groupEmail, "Writing Group", groupName, headWriter, yrFormed);



            }
            break;
            case 2: {
                //String email, String authoring_entity_type, String name, String head_writer, int year_formed
                System.out.println("Adding new Individual Author");

                System.out.println("Enter Email: ");
                String iaEmail = in.nextLine();

                System.out.println("Enter Name of Author: ");
                String iaName = in.nextLine();

                System.out.println("Enter the year the Writing Group was formed: ");
                int yrFormed = in.nextInt();

                for (Authoring_Entities next : authoringEntities) {
                    if (next.getAuthoring_entity_type().equals("Individual Author")) {
                        if (next.getEmail().equals(iaEmail)) {
                            try {
                                throw new JPAException("Cant add duplicated email");
                            } catch (JPAException e) {
                                System.out.println("Caught inside of authoring_entities case 2");
                            }
                        }
                        Individual_Author ia = new Individual_Author(iaEmail, "Individual Author", iaName, null, yrFormed);
                        em.getTransaction().begin();
                        authoringEntities.add(ia);
                        em.persist(ia);
                        em.getTransaction().commit();

                        em.close();
                        emf.close();
                    }
                }
            }
            break;
            case 3: {
                System.out.println("Adding new Ad Hoc Team");

                System.out.println("Enter Email: ");
                String adEmail = in.nextLine();

                System.out.println("Enter Name of Team: ");
                String adName = in.nextLine();

                System.out.println("Enter the year the Writing Group was formed: ");
                int yrFormed = in.nextInt();

                for (Authoring_Entities next : authoringEntities) {
                    if (next.getAuthoring_entity_type().equals("Ad_Hoc_team")) {
                        if (next.getEmail().equals(adEmail)) {
                            try {
                                throw new JPAException("Cant add duplicated email");
                            } catch (JPAException e) {
                                System.out.println("Caught inside of authoring_entities case 3");
                            }
                        }
                    }
                }
                Ad_Hoc_team aht = new Ad_Hoc_team(adEmail, "Ad_Hoc_team", adName, null, yrFormed);
                em.getTransaction().begin();
                authoringEntities.add(aht);
                em.persist(aht);
                em.getTransaction().commit();

                em.close();
                emf.close();

            }
            break;

            default:
                break;
        }
    }


    public void publisher_entity () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Main");
        EntityManager em = emf.createEntityManager();

        //String name, String email, String phone
        System.out.println("Enter Publisher Name: ");
        String pubName = in.nextLine();

        System.out.println("Enter Publisher Email: ");
        String pubEmail = in.nextLine();

        System.out.println("Enter Publisher Name: ");
        String pubNum = in.nextLine();

        Publishers temp = new Publishers(pubName, pubEmail, pubNum);
        publishers.add(temp);
    }

    public void addBook () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Main");
        EntityManager em = emf.createEntityManager();

        //String isbn, String title, int year_published, Publishers publishers, Authoring_Entities authoringEntity
        System.out.println("Enter ISBN, Book Title, and Year Published: ");
        System.out.println("Enter ISBN: ");
        String isbn = in.nextLine();

        System.out.println("Enter Book Title: ");
        String title = in.nextLine();

        System.out.println("Enter Year Published: ");
        int yrPub = in.nextInt();

        System.out.println("List of Publishers: ");
        for (int i = 0; i < publishers.size(); i++) {
            System.out.println((i + 1) + ". " + publishers.get(i).getName());
        }
        System.out.print("Enter your publisher choice");
        int userPub = in.nextInt();
        in.nextLine();
        userPub = userPub - 1;

        System.out.println("list of Authoring Entities:");
        for (int i = 0; i < authoringEntities.size(); i++) {
            System.out.println((i + 1) + ". " + authoringEntities.get(i).getName());
        }
        System.out.println("Choose an Authoring Entity: ");
        int userAuthoringEntity = in.nextInt();
        in.nextLine();
        userAuthoringEntity = userAuthoringEntity - 1;
        Books userBook = new Books(isbn, title, yrPub, publishers.get(userPub), authoringEntities.get(userAuthoringEntity));

        em.getTransaction().begin();
        books.add(userBook);
        em.persist(userBook);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void deleteBook () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Main");
        EntityManager em = emf.createEntityManager();

        System.out.println("Deleting Book");
        System.out.println("List of Books: ");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + 1 + ". " + books.get(i).getTitle());
        }
        System.out.println("Choose a Book: ");
        int userInput = in.nextInt();
        in.nextLine();
        userInput -= 1;
        books.remove(userInput);

        em.getTransaction().begin();
        Books temp = books.remove(userInput);
        em.persist(temp);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

    public void updateBook () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Main");
        EntityManager em = emf.createEntityManager();

        System.out.println("Updating Book's Authoring Entity");
        System.out.println("List of Books: ");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i).getTitle());
        }
        System.out.println("Choose a book");
        int bookChoice = in.nextInt();
        in.nextLine();
        bookChoice = bookChoice - 1;

        System.out.println("List of Authoring Entities: ");
        for (int i = 0; i < authoringEntities.size(); i++) {
            System.out.println((i + 1) + ". " + authoringEntities.get(i).getName());
        }
        System.out.println("Choose an Authoring Entity: ");
        int entityChoice = in.nextInt();
        in.nextLine();
        entityChoice -= 1;

        em.getTransaction().begin();
        Books tempBook = books.get(bookChoice);
        books.remove(bookChoice);
        books.add(tempBook);
        Authoring_Entities temp2 = authoringEntities.get(entityChoice);
        tempBook.setAuthoringEntity(temp2);
        em.persist(tempBook);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void listPrimaryKeys () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Main");
        EntityManager em = emf.createEntityManager();

        Query q = em.createNativeQuery(
                "SELECT PUBLISHER.NAME, BOOKS.ISBN, AUTHORING_ENTITIES.EMAIL, AUTHORING_ENTITIES.AUTHORING_ENTITY_TYPE\n" +
                "FROM PUBLISHERS \n" +
                "LEFT JOIN BOOKS  on PUBLISHER.NAME = BOOKS.PUBLISHER_NAME\n" +
                "LEFT JOIN AUTHORING_ENTITIES on AUTHORING_ENTITIES.EMAIL = BOOKS.AUTHORING_ENTITY_EMAIL\n" +
                "ORDER BY ISBN;");
        List<Object[]> primaryKeysTemp = q.getResultList();

        System.out.println("Publisher class primary keys:");
        for (Object[] next : primaryKeysTemp) {
            System.out.println("\t" + next[0]);
        }
        System.out.println("Books class primary keys:");
        for (Object[] next : primaryKeysTemp) {
            System.out.println("\t" + next[1]);
        }
        System.out.println("AuthoringEntity class primary keys:");
        for (Object[] next : primaryKeysTemp) {
            System.out.println("\t" + next[2] + "\t" + next[3]);
        }
    }


    public void listInfoObjects () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Main");
        EntityManager em = emf.createEntityManager();

        System.out.println("What would you like to view? ");
        System.out.println("1. Publisher \n2. Book\n3. Writing group");
        int input = in.nextInt();
        switch (input) {
            case 1: {
                System.out.println("List of Publishers: ");
                int i = 1;
                for (Publishers temp : publishers) {
                    System.out.println(i + ". " + temp.getName());
                    ++i;
                }
                int userInput = in.nextInt();
                in.nextLine();

                publishers.get(userInput).toString();

            }
            break;
            case 2: {
                System.out.println("List of Books: ");
                int i = 1;
                for (Books temp : books) {
                    System.out.println(i + ". " + temp.getIsbn() + " " + temp.getTitle());
                    ++i;
                }
                int userInput = in.nextInt();
                in.nextLine();

                books.get(userInput).toString();

            }
            break;
            case 3: {
                System.out.println("List of Writing Groups: ");
                int i = 1;
                for (Authoring_Entities temp : authoringEntities) {
                    if (temp.getAuthoring_entity_type().equals("Writing Group")) {
                        System.out.println(i + ". " + temp.getEmail());
                    }
                    ++i;

                    System.out.println("Choose a Writing Group");
                    int userInput = in.nextInt();
                    in.nextLine();

                    authoringEntities.get(userInput).toString();

                }
            }
            break;
            default: {
                System.out.println("Invalid choice. Try again.");
            }
            break;
        }


    }
}