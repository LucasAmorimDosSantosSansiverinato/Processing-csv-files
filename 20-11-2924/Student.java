public class Student {
   private int id;
   private String name;
   private String typeTest;
   private boolean classificado;

   public Student(int id, String name, String typeTest, boolean classificado) {
      this.id = id;
      this.name = name;
      this.typeTest = typeTest;
   }

   public int getId() {
      return id;
   }
   
   public String getName() {
      return name;
   }
   
   public String getTypeTest() {
      return typeTest;
   }

   public void setClassificado(boolean classificado) {
      this.classificado = classificado;
   }

   // Impede que o nome do estudante seja repitido 
   public boolean isClassificado() {
      return classificado;
   }
}
