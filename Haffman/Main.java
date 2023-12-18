import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) throws IOException {
    boolean exit = false;
    Scanner in = new Scanner(System.in);

    System.out.println("Type help for more information");
    while (!exit) {
      String command = in.nextLine();

      switch (command) {
        case "encode":
          encode(in);
          break;

        case "decode":
          decode(in);
          break;

        case "help":
          help();
          break;

        case "exit":
          exit = true;
          break;

        default:
          System.out.println("Command not found");
          System.out.println("Type help for more information");
          break;
      }
    }

    in.close();
  }

  static private void encode(Scanner in) throws IOException {
    System.out.print("Input filename: ");
    String input = in.nextLine();
    System.out.print("Output file prefix: ");
    String output = in.nextLine();

    Huffman huffman = new Huffman();
    huffman.encode(input, output);
    System.out.println("Done\n");
  }

  static private void decode(Scanner in) throws IOException {
    System.out.print("Input filename: ");
    String input = in.nextLine();
    System.out.print("Output file prefix: ");
    String output = in.nextLine();

    Huffman huffman = new Huffman();
    huffman.decode(input, output);
    System.out.println("Done\n");
  }

  static private void help() {
    System.out.println("\nencode");
    System.out.println("\t- To compress a file using the Huffman algorithm");
    System.out.println("decode");
    System.out.println("\t- To uncompress a file");
    System.out.println("exit");
    System.out.println("\t- To exit the program");
    System.out.println("help");
    System.out.println("\t- For command reference\n");
  }
}