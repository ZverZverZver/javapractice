package dodiKamar190517;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanMenu = new Scanner(System.in);

        // Empty club with empty Map element
        PetClub club = new PetClub();
        club.setClub(new HashMap<>());

        String menuStr = "MENU: \n" + "1: add Person to PetClub \n" + "2: add Pet to Person \n"
                + "3: remove Pet from Person \n" + "4: remove Person from PetClub \n" +
                "5: remove Pet from ALL Persons \n" + "6: show PetClup Persons and their Pets \n" + "0: EXIT";

        System.out.println(menuStr);

        while (true) {
            System.out.println(menuStr);
            switch (scanMenu.nextInt()) {
                //add member DONE
                case 1:
                    System.out.print("Enter person name: ");
                    String name = scanMenu.next();
                    System.out.print("Enter age of person: ");
                    int age = scanMenu.nextInt();

                    club.getClub().put(new Person(name, age), null);

                    break;
                // add Pet to member DONE
                case 2:
                    System.out.println("Enter Member NAME to add Pet: ");
                    String getPersonsNameToAddPet = scanMenu.next();
                    System.out.println("Enter Pet nickname:");
                    String newPetNickname = scanMenu.next();
                    System.out.println("Enter Pet age: ");
                    int newPetAge = scanMenu.nextInt();

                    Set<Map.Entry<Person, List<Pet>>> entrySetPetClubToAddPet = club.getClub().entrySet();
                    Iterator<Map.Entry<Person, List<Pet>>> entrySetPetClubIterator = entrySetPetClubToAddPet.iterator();
                    while (entrySetPetClubIterator.hasNext()) {
                        Map.Entry<Person, List<Pet>> currentPerson = entrySetPetClubIterator.next();
                        if (currentPerson.getKey().name.equals(getPersonsNameToAddPet)) {
                            if (currentPerson.getValue() == null) {
                                currentPerson.setValue(new ArrayList<>());
                                currentPerson.getValue().add(new Pet(newPetNickname, newPetAge));
                            } else {
                                currentPerson.getValue().add(new Pet(newPetNickname, newPetAge));
                            }
                        }
                    }
                    break;
                // remove Pet from member DONE
                case 3:
                    System.out.println("Enter Member NAME to remove Pet: ");
                    String getPersonsNameToRemovePet = scanMenu.next();
                    System.out.println("Enter Pet NAME to remove: ");
                    String petNicknameToRemove = scanMenu.next();

                    Set<Map.Entry<Person, List<Pet>>> entrySetPetClubForRemovePet = club.getClub().entrySet();
                    Iterator<Map.Entry<Person, List<Pet>>> petClubSetForRemoveIterator = entrySetPetClubForRemovePet.iterator();
                    while (petClubSetForRemoveIterator.hasNext()) {
                        Map.Entry<Person, List<Pet>> currentPersonForPetRemove = petClubSetForRemoveIterator.next();
                        if (currentPersonForPetRemove.getKey().name.equals(getPersonsNameToRemovePet)) {
                            Iterator<Pet> petForRemoveIterator = currentPersonForPetRemove.getValue().iterator();
                            while (petForRemoveIterator.hasNext()) {
                                Pet currentPetForRemove = petForRemoveIterator.next();
                                if (currentPetForRemove.getNickname().equals(petNicknameToRemove)) {
                                    currentPersonForPetRemove.getValue().remove(currentPetForRemove);
                                }
                            }
                        }
                    }

                    break;
                // remove member DONE
                case 4:
                    System.out.println("Enter NAME of Person to remove ");
                    String getPersonsNameToRemove = scanMenu.next();

                    Set<Person> personSetToRemove = club.getClub().keySet();
                    Iterator<Person> personToRemove = personSetToRemove.iterator();
                    while (personToRemove.hasNext()) {
                        Person previousIterator2 = personToRemove.next();
                        if (previousIterator2.name.equals(getPersonsNameToRemove)) {
                            club.getClub().remove(previousIterator2);
                            break;
                        }
                        System.out.println("There is no such Person to remove");
                    }
                    break;
                // remove pet from ALL members
                case 5:
                    System.out.println("Enter Pet NAME to remove it from ALL Persons");
                    String PetNicknameToRemoveAll = scanMenu.next();

                    Set<Map.Entry<Person, List<Pet>>> entrySetPetClubForRemovePetAll = club.getClub().entrySet();
                    Iterator<Map.Entry<Person, List<Pet>>> entrySetPetClubIterator2 = entrySetPetClubForRemovePetAll.iterator();

                    while (entrySetPetClubIterator2.hasNext()) {
                        Map.Entry<Person, List<Pet>> currentPersonForRemovePetAll = entrySetPetClubIterator2.next();
                        Iterator<Pet> PetForRemoveAllIterator = currentPersonForRemovePetAll.getValue().iterator();

                        while (PetForRemoveAllIterator.hasNext()) {
                            Pet currentPetForRemoveAll = PetForRemoveAllIterator.next();
                            if (currentPetForRemoveAll.getNickname().equals(PetNicknameToRemoveAll)) {
                                currentPersonForRemovePetAll.getValue().remove(currentPetForRemoveAll);
                            }
                        }
                    }

                    break;
                // sout PetClub DONE
                case 6:
                    System.out.println(club);
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
}