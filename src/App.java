public class App {
    public static void main(String[] args) throws Exception {
        
        Bem bem1= new Bem("Cadeira", "Cadeira padrão UFC", "movel", "01/08/2002");
        System.out.println(bem1);

        Instituicao instituicao1 = new Instituicao("UFC", "102312031");
        System.out.println(instituicao1);
        boolean running = false;
        while (running) {
            System.out.println("---------------
            ");
        }
    }
}
