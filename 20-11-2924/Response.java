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

                    if (capacityLeft == 0) {
                        break;
                    }

                    if ("Sem Prova".equals(student.getTypeTest())) {
                        System.out.println("Aluno não atribuido por não ter prova");
                        continue;
                    }

                    // valida se a sala cabe os alunos, se o aluno é daquela sala e daquele horario
                    if (capacityLeft > 0 &&
                            getTimespan(student.getId()).equals(classroom.timeSpan) &&
                            student.isClassificado() == false) {

                        // Adiciona o aluno à sala e diminui a capacidade
                        System.out.println("Atribuindo aluno: " + student.getId() + "  Capaidade da sala "
                                + classroom.roomType + ": " + capacityLeft);
                        csvWriter.append(
                                student.getId() + "," + student.getName() + "," + student.getTypeTest() + ",");
                        csvWriter.append(classroom.roomType + "," + classroom.timeSpan + "\n");
                        capacityLeft--;
                        student.setClassificado(true);

                    } else {
                        System.out.println("Aluno " + student.getId() + " não pode ser atribuído"
                                + " Capaidade da sala " + classroom.roomType + ": " + capacityLeft);
                    }

                }

            }

            System.out.println("Arquivo CSV gerado com sucesso!");
            screeningTest();
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

    public void screeningTest() {
        
        int a = 0, b = 0, c = 0, d = 0;
        String typeTestA = "Prova A: " + a + " Alunos";
        String typeTestB = "Prova B: " + b + " Alunos";
        String typeTestC = "Prova C: " + c + " Alunos";
        String typeTestD = "Prova D: " + d + " Alunos";
        String typeTestS = "Sem Prova";
        String msg = "";

        for (ClassRoom classRoom : classRooms) {
            if (classRoom.getTimespan().equals("08H")) {
                for (Student student : students) {
                    if (student.getTypeTest().equals("Prova A")) {
                        ++a;
                    } else if (student.getTypeTest().equals("Prova B")) {
                        ++b;
                    } else if (student.getTypeTest().equals("Prova C")) {
                        ++c;
                    } else if (student.getTypeTest().equals("Prova D")) {
                        ++d;
                    }
                }
                msg += "Horário: 08H" + "\n" + typeTestA + "\n" + typeTestB + "\n" + typeTestC + "\n" + typeTestD + "\n"
                        + typeTestS;
            } else if (classRoom.getTimespan().equals("10H")) {
                for (Student student : students) {
                    if (student.getTypeTest().equals("Prova A")) {
                        ++a;
                    } else if (student.getTypeTest().equals("Prova B")) {
                        ++b;
                    } else if (student.getTypeTest().equals("Prova C")) {
                        ++c;
                    } else if (student.getTypeTest().equals("Prova D")) {
                        ++d;
                    }
                }
                msg += "Horário: 010H" + "\n" + typeTestA + "\n" + typeTestB + "\n" + typeTestC + "\n" + typeTestD
                        + "\n" + typeTestS;
            } else if (classRoom.getTimespan().equals("13H")) {
                for (Student student : students) {
                    if (student.getTypeTest().equals("Prova A")) {
                        ++a;
                    } else if (student.getTypeTest().equals("Prova B")) {
                        ++b;
                    } else if (student.getTypeTest().equals("Prova C")) {
                        ++c;
                    } else if (student.getTypeTest().equals("Prova D")) {
                        ++d;
                    }
                }
                msg += "Horário: 13H" + "\n" + typeTestA + "\n" + typeTestB + "\n" + typeTestC + "\n" + typeTestD + "\n"
                        + typeTestS;
            } else if (classRoom.getTimespan().equals("15H")) {
                for (Student student : students) {
                    if (student.getTypeTest().equals("Prova A")) {
                        ++a;
                    } else if (student.getTypeTest().equals("Prova B")) {
                        ++b;
                    } else if (student.getTypeTest().equals("Prova C")) {
                        ++c;
                    } else if (student.getTypeTest().equals("Prova D")) {
                        ++d;
                    }
                }
                msg += "Horário: 15H" + "\n" + typeTestA + "\n" + typeTestB + "\n" + typeTestC + "\n" + typeTestD + "\n"
                        + typeTestS;
            }
        }
        System.out.println(msg);
    }

}
