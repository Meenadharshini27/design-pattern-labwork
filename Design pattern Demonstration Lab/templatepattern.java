abstract class DocumentEditor {
    final void saveDocument() {
      prepareDocument();
      writeDocument();
      finalizeDocument();
    }
  
    abstract void writeDocument();
  
    void prepareDocument() {
      System.out.println("Preparing document");
    }
  
    void finalizeDocument() {
      System.out.println("Finalizing document");
    }
  }
  
  class PDFEditor extends DocumentEditor {
    void writeDocument() {
      System.out.println("Writing PDF document");
    }
  }
  
  class DOCXEditor extends DocumentEditor {
    void writeDocument() {
      System.out.println("Writing DOCX document");
    }
  }
  
  class TXTEditor extends DocumentEditor {
    void writeDocument() {
      System.out.println("Writing TXT document");
    }
  }
  
  public class templatepattern {
    public static void main(String[] args) {
      DocumentEditor pdfEditor = new PDFEditor();
      pdfEditor.saveDocument();
  
      DocumentEditor docxEditor = new DOCXEditor();
      docxEditor.saveDocument();
  
      DocumentEditor txtEditor = new TXTEditor();
      txtEditor.saveDocument();
    }
  }