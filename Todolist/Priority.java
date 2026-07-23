package Todolist;
// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public enum Priority {
   LOW,
   MEDIUM,
   HIGH;

   private Priority() {
   }

   public static Priority fromString(String var0) {

      try {
         return Priority.valueOf(var0.toUpperCase());
         
      } catch (IllegalArgumentException var2) {
         return null;
      }
   }
}
