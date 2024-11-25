import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Response response = new Response();
        // Variavel que que guar do diretorio do arquivo csv
        String caminhoArquivo = "Inscrições.csv";
        // BufferReader que manipula o CSV com o FileReader que processa Linha por linha
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            // variavel vazia que vai guardar cada linha lida pelo loop
            String linha;
            // loop que lê cada linha do arquivo csv
            while ((linha = br.readLine()) != null) {
                // separa as partes pela virgula
                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String tipo = partes[2];
                // add aluno pelo metodo addStudent
                response.addStudent(new Student(id, nome, tipo, false));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Variavel que que guar do diretorio do arquivo csv
        String caminhoArquivoLugares = "Lugares.csv";
        // BufferReader que manipula o CSV com o FileReader que processa Linha por linha
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoLugares))) {
            // variavel vazia que vai guardar cada linha lida pelo loop
            String linha;
            // loop que lê cada linha do arquivo csv
            while ((linha = br.readLine()) != null) {
                // separa as partes pela virgula
                String[] partes = linha.split (",");
                String room = partes[0];
                int capacity = Integer.parseInt(partes[1]);
                String time = partes[2];
                // add aluno pelo metodo addStudent
                response.addClassRoom(new ClassRoom(room, capacity, time));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        response.generatingList();


    }
}
