import studiplayer.basic.BasicPlayer;

public abstract class SampledFile extends AudioFile {

    // durata audio in microsecunde
    protected long duration;

    // Constructor fara parametri, initializeaza durata cu 0
    public SampledFile() {
        super();
        this.duration = 0;
    }

    // Konstruktor mit Dateipfad als Parameter
    public SampledFile(String path) {
        super(path);
        this.duration = 0;
    }

    // Reda fisierul audio
    @Override
    public void play() {
        BasicPlayer.play(getPathname());
    }

    // state between playing and paused
    @Override
    public void togglePause() {
        BasicPlayer.togglePause();
    }

    // returneaza durata in microsecunde
    public long getDuration() {
        return duration;
    }

    // Gibt die formatierte Dauer im Format zurück
    public String formatDuration() {
        return timeFormatter(getDuration());
    }

    // Returneaza pozitia curenta de redare in format mm:ss
    public String formatPosition() {
        return timeFormatter(BasicPlayer.getPosition());
    }

    // Stops the audio completely
    @Override
    public void stop() {
        BasicPlayer.stop();
    }

    // Formateaza timpu, verifica limitele
    public static String timeFormatter(long timeinMicroseconds) {
        if (timeinMicroseconds < 0 || timeinMicroseconds >= 6000000000L) {
            throw new RuntimeException("Time value out of bounds");
        }

        long totalSeconds = timeinMicroseconds / 1_000_000;
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }
}