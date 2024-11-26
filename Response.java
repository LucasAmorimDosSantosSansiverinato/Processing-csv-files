import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Response {

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<ClassRoom> classRooms = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getAllStudent() {
        return students;
    }

    public void addClassRoom(ClassRoom classRoom) {
        classRooms.add(classRoom);
    }

    public ArrayList<ClassRoom> getAllClassRooms() {
        return classRooms;
    }

    public void generatingList() {

        // Cria arquivo csv
        try (FileWriter csvWriter = new FileWriter("distribution.csv")) {
            
            // escreve cabesalho
            csvWriter.append("Cod. Inscrição,Nome,Tipo Prova,Sala,Horário\n");

            // entra no Array sala
            for (ClassRoom classroom : classRooms) {
                // Armazena valor da capacidade da sala
                int capacityLeft = classroom.roomCapacity;

                // entra no array aluno
                for (Student student : students) {

                    // se a capacidade for igual a 0 ele para o loop e inicia o proximo
                    if (capacityLeft == 0) {
                        break;
                    }
                    if ("Sem Prova".equals(student.getTypeTest())) {
                        continue;
                    }
                    // valida se a sala cabe os alunos, se o aluno é daquela sala e daquele horario
                    if (capacityLeft > 0 &&
                            getTimespan(student.getId()).equals(classroom.timeSpan) ) {

                        // Adiciona o aluno à sala e diminui a capacidade
                        csvWriter.append(
                                student.getId() + "," + student.getName() + "," + student.getTypeTest() + ",");
                        csvWriter.append(classroom.roomType + "," + classroom.timeSpan + "\n");
                        capacityLeft--;
                       // student.setClassificado(true);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao gerar o arquivo CSV: " + e.getMessage());
        }
    }

    // metodo usado pela screeningTest para valida o horaio pelo id
    public String getTimespan(int id) {
        if (id >= 1 && id <= 250) {
            return "08h";
        } else if (id >= 251 && id <= 480) {
            return "10h";
        } else if (id >= 481 && id <= 700) {
            return "13h";
        } else if (id >= 701 && id <= 1000) {
            return "15h";
        }
        return "";
    }

    public void Summary() {

        for (ClassRoom classroom : classRooms) {

            int provaA = 0;
            int provaB = 0;
            int provaC = 0;
            int provaD = 0;
            int semProva = 0;
            int TotalLugares = classroom.getRoomCapacity();
            int lugaresOcupados = 0;

            for (Student student : students) {

                for (int i = 0; i <= classroom.getRoomCapacity(); i++) {
                    lugaresOcupados++;
                }
                if (getTimespan(student.getId()).equals(classroom.timeSpan)) {

                    if ("Prova A".equals(student.getTypeTest())) {
                        provaA++;
                    } else if ("Prova B".equals(student.getTypeTest())) {
                        provaB++;
                    } else if ("Prova C".equals(student.getTypeTest())) {
                        provaC++;
                    } else {
                        provaD++;
                    }
                }
            }

        }

    }

}
