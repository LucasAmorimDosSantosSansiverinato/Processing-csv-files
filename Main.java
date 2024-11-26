import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Response response = new Response();
        // Variavel que que guar do diretorio do arquivo csv
        String caminhoArquivoInscricoes = "Inscrições.csv";
        String caminhoArquivoLugares = "Lugares.csv";

        // BufferReader que manipula o CSV com o FileReader que processa Linha por linha
        try (BufferedReader brInscricoes = new BufferedReader(new FileReader(caminhoArquivoInscricoes));
                BufferedReader brLugares = new BufferedReader(new FileReader(caminhoArquivoLugares))) {
            // variavel vazia que vai guardar cada linha lida pelo loop
            String linha;
            // loop que lê cada linha do arquivo csv
            while ((linha = brInscricoes.readLine()) != null) {
                // separa as partes pela virgula
                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String tipo = partes[2];
                // add aluno pelo metodo addStudent
                response.addStudent(new Student(id, nome, tipo));

                while ((linha = brLugares.readLine()) != null) {
                    // separa as partes pela virgula
                    String[] partess = linha.split(",");
                    String room = partess[0];
                    int capacity = Integer.parseInt(partess[1]);
                    String time = partess[2];
                    // add aluno pelo metodo addStudent
                    response.addClassRoom(new ClassRoom(room, capacity, time));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.generatingList();
        response.Summary();

    }
}
