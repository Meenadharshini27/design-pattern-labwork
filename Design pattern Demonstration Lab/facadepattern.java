class DVDPlayer {
    void play() {
      System.out.println("DVD player playing");
    }
  
    void stop() {
      System.out.println("DVD player stopped");
    }
  }
  
  class Projector {
    void on() {
      System.out.println("Projector on");
    }
  
    void off() {
      System.out.println("Projector off");
    }
  }
  
  class SoundSystem {
    void setVolume(int volume) {
      System.out.println("Sound system volume: " + volume);
    }
  }
  
  
  class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;
  
    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, SoundSystem soundSystem) {
      this.dvdPlayer = dvdPlayer;
      this.projector = projector;
      this.soundSystem = soundSystem;
    }
  
    public void watchMovie() {
      dvdPlayer.play();
      projector.on();
      soundSystem.setVolume(50);
    }
  
    public void endMovie() {
      dvdPlayer.stop();
      projector.off();
      soundSystem.setVolume(0);
    }
  }
  
  
  public class facadepattern {
    public static void main(String[] args) {
      DVDPlayer dvdPlayer = new DVDPlayer();
      Projector projector = new Projector();
      SoundSystem soundSystem = new SoundSystem();
  
      HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, soundSystem);
  
      homeTheater.watchMovie();
      homeTheater.endMovie();
    }
  }