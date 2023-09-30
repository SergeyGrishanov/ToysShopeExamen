package workExam;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Raffle {

    private static List<Toys> toys = new ArrayList<>();
    private static PriorityQueue<Toys> prizes = new PriorityQueue<>();
    

    private static int count = 0;
    

    public void addToys() {
        Scanner scan = new Scanner(System.in);
        String name;
        int periodicl;
        while (true) {
            System.out.print("Введите наименование игрушки: ");
            name = scan.nextLine();
            if (name.isEmpty()) {
                System.out.println("Некорректный ввод! Попробуйте еще раз, пожалуйста.");
                break;
            }
            System.out.print("Введите частоту выпадения игрушки: ");
            String value = scan.nextLine();
            if (isDigit(value)) {
                periodicl = Integer.parseInt(value);
                if (periodicl <= 0) {
                    System.out.println("Некорректный ввод! Попробуйте еще раз, пожалуйста.");
                } else {
                    Toys toy = new Toys(count, name, periodicl);
                    if (!toys.contains(toy) || toys.size() == 0) {
                        count++;
                        toys.add(toy);
                        System.out.println("Добавлена новая игрушка!");
                    } else {
                        System.out.println("Эта игрушка уже в призовом фонде!");
                    }
                }
            } else {
                System.out.println("Некорректный ввод! Попробуйте еще раз, пожалуйста.");
            }
            break;
        }
    }

    public void setFrequency() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите ID игрушки: ");
        String value = scan.nextLine();
        if (isDigit(value)) {
            int numId = Integer.parseInt(value);
            if (numId >= 0 && numId < toys.size()) {
                System.out.println("Игрушка " + toys.get(numId).getToyName() +
                        " имеет частоту выпадений " + toys.get(numId).getDrawnToys());
                System.out.print("Введите новую частоту выпадений игрушки: ");
                value = scan.nextLine();
                if (isDigit(value)) {
                    int newDrawn = Integer.parseInt(value);
                    toys.get(numId).setDrawnToys(newDrawn);//(newDrawn);
                    System.out.println("Частота выпадений изменена.");
                } else {
                    System.out.println("Некорректный ввод! Попробуйте еще раз, пожалуйста.");
                }
            } else {
                System.out.println("В призовом фонде нет игрушки с таким ID.");
            }
        } else {
            System.out.println("Некорректный ввод! Попробуйте еще раз, пожалуйста.");
        }
    }


    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

        public Toys getPrize() {
            
        if (prizes.size() == 0) {
            
            Random rnd = new Random();
            for (Toys toy : toys) {
                for (int i = 0; i < toy.getToyId(); i++) {
                    Toys temp = new Toys(toy.getToyId(), toy.getToyName(), rnd.nextInt(1, 10));  
                    prizes.add(temp);
                    
                }   
                }
            }
        
        return prizes.poll();
    }

    

    public void raffle() {
        if (toys.size() >= 2) {
            Toys prize = getPrize(); 
            System.out.println("Приз: " + prize.getToyName());
            result(prize.getInfo());       
        } else {
            System.out.println("В призовом фонде должно быть не мение двух игрушек!");
        }
    }

    private void result(String text) {
        File file = new File("RaffleToyRes.txt");
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter("RaffleToyRes.txt", true)) {
            fw.write(text + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
