abstract class Shape {
    protected RenderingEngine renderingEngine;
  
    public Shape(RenderingEngine renderingEngine) {
      this.renderingEngine = renderingEngine;
    }
  
    abstract void draw();
  }
  
  class Circle extends Shape {
    public Circle(RenderingEngine renderingEngine) {
      super(renderingEngine);
    }
  
    void draw() {
      renderingEngine.renderCircle();
    }
  }
  
  class Square extends Shape {
    public Square(RenderingEngine renderingEngine) {
      super(renderingEngine);
    }
  
    void draw() {
      renderingEngine.renderSquare();
    }
  }
  
  interface RenderingEngine {
    void renderCircle();
    void renderSquare();
  }
  
  
  class RasterRenderingEngine implements RenderingEngine {
    public void renderCircle() {
      System.out.println("Rendering circle using raster engine");
    }
  
    public void renderSquare() {
      System.out.println("Rendering square using raster engine");
    }
  }
  
  
  class VectorRenderingEngine implements RenderingEngine {
    public void renderCircle() {
      System.out.println("Rendering circle using vector engine");
    }
  
    public void renderSquare() {
      System.out.println("Rendering square using vector engine");
    }
  }
  
  
  public class bridgepattern {
    public static void main(String[] args) {
      RenderingEngine rasterEngine = new RasterRenderingEngine();
      Shape circle = new Circle(rasterEngine);
      circle.draw();
  
      RenderingEngine vectorEngine = new VectorRenderingEngine();
      Shape square = new Square(vectorEngine);
      square.draw();
    }
  }